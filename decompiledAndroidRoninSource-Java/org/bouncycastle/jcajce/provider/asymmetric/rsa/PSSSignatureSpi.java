package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.jcajce.provider.util.DigestFactory;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;

public class PSSSignatureSpi
  extends SignatureSpi
{
  private Digest contentDigest;
  private AlgorithmParameters engineParams;
  private final JcaJceHelper helper = new BCJcaJceHelper();
  private boolean isRaw;
  private Digest mgfDigest;
  private PSSParameterSpec originalSpec;
  private PSSParameterSpec paramSpec;
  private PSSSigner pss;
  private int saltLength;
  private AsymmetricBlockCipher signer;
  private byte trailer;
  
  protected PSSSignatureSpi(AsymmetricBlockCipher paramAsymmetricBlockCipher, PSSParameterSpec paramPSSParameterSpec)
  {
    this(paramAsymmetricBlockCipher, paramPSSParameterSpec, false);
  }
  
  protected PSSSignatureSpi(AsymmetricBlockCipher paramAsymmetricBlockCipher, PSSParameterSpec paramPSSParameterSpec, boolean paramBoolean)
  {
    this.signer = paramAsymmetricBlockCipher;
    this.originalSpec = paramPSSParameterSpec;
    if (paramPSSParameterSpec == null) {
      this.paramSpec = PSSParameterSpec.DEFAULT;
    } else {
      this.paramSpec = paramPSSParameterSpec;
    }
    this.mgfDigest = DigestFactory.getDigest(this.paramSpec.getDigestAlgorithm());
    this.saltLength = this.paramSpec.getSaltLength();
    this.trailer = getTrailer(this.paramSpec.getTrailerField());
    this.isRaw = paramBoolean;
    setupContentDigest();
  }
  
  private byte getTrailer(int paramInt)
  {
    if (paramInt == 1) {
      return -68;
    }
    throw new IllegalArgumentException("unknown trailer field");
  }
  
  private void setupContentDigest()
  {
    Object localObject;
    if (this.isRaw) {
      localObject = new NullPssDigest(this.mgfDigest);
    } else {
      localObject = this.mgfDigest;
    }
    this.contentDigest = ((Digest)localObject);
  }
  
  protected Object engineGetParameter(String paramString)
  {
    throw new UnsupportedOperationException("engineGetParameter unsupported");
  }
  
  protected AlgorithmParameters engineGetParameters()
  {
    if ((this.engineParams == null) && (this.paramSpec != null)) {
      try
      {
        AlgorithmParameters localAlgorithmParameters = this.helper.createAlgorithmParameters("PSS");
        this.engineParams = localAlgorithmParameters;
        localAlgorithmParameters.init(this.paramSpec);
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException.toString());
      }
    }
    return this.engineParams;
  }
  
  protected void engineInitSign(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    if ((paramPrivateKey instanceof RSAPrivateKey))
    {
      PSSSigner localPSSSigner = new PSSSigner(this.signer, this.contentDigest, this.mgfDigest, this.saltLength, this.trailer);
      this.pss = localPSSSigner;
      localPSSSigner.init(true, RSAUtil.generatePrivateKeyParameter((RSAPrivateKey)paramPrivateKey));
      return;
    }
    throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
  }
  
  protected void engineInitSign(PrivateKey paramPrivateKey, SecureRandom paramSecureRandom)
    throws InvalidKeyException
  {
    if ((paramPrivateKey instanceof RSAPrivateKey))
    {
      PSSSigner localPSSSigner = new PSSSigner(this.signer, this.contentDigest, this.mgfDigest, this.saltLength, this.trailer);
      this.pss = localPSSSigner;
      localPSSSigner.init(true, new ParametersWithRandom(RSAUtil.generatePrivateKeyParameter((RSAPrivateKey)paramPrivateKey), paramSecureRandom));
      return;
    }
    throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
  }
  
  protected void engineInitVerify(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    if ((paramPublicKey instanceof RSAPublicKey))
    {
      PSSSigner localPSSSigner = new PSSSigner(this.signer, this.contentDigest, this.mgfDigest, this.saltLength, this.trailer);
      this.pss = localPSSSigner;
      localPSSSigner.init(false, RSAUtil.generatePublicKeyParameter((RSAPublicKey)paramPublicKey));
      return;
    }
    throw new InvalidKeyException("Supplied key is not a RSAPublicKey instance");
  }
  
  protected void engineSetParameter(String paramString, Object paramObject)
  {
    throw new UnsupportedOperationException("engineSetParameter unsupported");
  }
  
  protected void engineSetParameter(AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidAlgorithmParameterException
  {
    if ((paramAlgorithmParameterSpec instanceof PSSParameterSpec))
    {
      paramAlgorithmParameterSpec = (PSSParameterSpec)paramAlgorithmParameterSpec;
      Object localObject = this.originalSpec;
      if ((localObject != null) && (!DigestFactory.isSameDigest(((PSSParameterSpec)localObject).getDigestAlgorithm(), paramAlgorithmParameterSpec.getDigestAlgorithm())))
      {
        paramAlgorithmParameterSpec = new StringBuilder();
        paramAlgorithmParameterSpec.append("parameter must be using ");
        paramAlgorithmParameterSpec.append(this.originalSpec.getDigestAlgorithm());
        throw new InvalidAlgorithmParameterException(paramAlgorithmParameterSpec.toString());
      }
      if ((!paramAlgorithmParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1")) && (!paramAlgorithmParameterSpec.getMGFAlgorithm().equals(PKCSObjectIdentifiers.id_mgf1.getId()))) {
        throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
      }
      if ((paramAlgorithmParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec))
      {
        localObject = (MGF1ParameterSpec)paramAlgorithmParameterSpec.getMGFParameters();
        if (DigestFactory.isSameDigest(((MGF1ParameterSpec)localObject).getDigestAlgorithm(), paramAlgorithmParameterSpec.getDigestAlgorithm()))
        {
          Digest localDigest = DigestFactory.getDigest(((MGF1ParameterSpec)localObject).getDigestAlgorithm());
          if (localDigest != null)
          {
            this.engineParams = null;
            this.paramSpec = paramAlgorithmParameterSpec;
            this.mgfDigest = localDigest;
            this.saltLength = paramAlgorithmParameterSpec.getSaltLength();
            this.trailer = getTrailer(this.paramSpec.getTrailerField());
            setupContentDigest();
            return;
          }
          paramAlgorithmParameterSpec = new StringBuilder();
          paramAlgorithmParameterSpec.append("no match on MGF digest algorithm: ");
          paramAlgorithmParameterSpec.append(((MGF1ParameterSpec)localObject).getDigestAlgorithm());
          throw new InvalidAlgorithmParameterException(paramAlgorithmParameterSpec.toString());
        }
        throw new InvalidAlgorithmParameterException("digest algorithm for MGF should be the same as for PSS parameters.");
      }
      throw new InvalidAlgorithmParameterException("unknown MGF parameters");
    }
    throw new InvalidAlgorithmParameterException("Only PSSParameterSpec supported");
  }
  
  protected byte[] engineSign()
    throws SignatureException
  {
    try
    {
      byte[] arrayOfByte = this.pss.generateSignature();
      return arrayOfByte;
    }
    catch (CryptoException localCryptoException)
    {
      throw new SignatureException(localCryptoException.getMessage());
    }
  }
  
  protected void engineUpdate(byte paramByte)
    throws SignatureException
  {
    this.pss.update(paramByte);
  }
  
  protected void engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws SignatureException
  {
    this.pss.update(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  protected boolean engineVerify(byte[] paramArrayOfByte)
    throws SignatureException
  {
    return this.pss.verifySignature(paramArrayOfByte);
  }
  
  private class NullPssDigest
    implements Digest
  {
    private ByteArrayOutputStream bOut = new ByteArrayOutputStream();
    private Digest baseDigest;
    private boolean oddTime = true;
    
    public NullPssDigest(Digest paramDigest)
    {
      this.baseDigest = paramDigest;
    }
    
    public int doFinal(byte[] paramArrayOfByte, int paramInt)
    {
      byte[] arrayOfByte = this.bOut.toByteArray();
      if (this.oddTime)
      {
        System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt, arrayOfByte.length);
      }
      else
      {
        this.baseDigest.update(arrayOfByte, 0, arrayOfByte.length);
        this.baseDigest.doFinal(paramArrayOfByte, paramInt);
      }
      reset();
      this.oddTime ^= true;
      return arrayOfByte.length;
    }
    
    public String getAlgorithmName()
    {
      return "NULL";
    }
    
    public int getByteLength()
    {
      return 0;
    }
    
    public int getDigestSize()
    {
      return this.baseDigest.getDigestSize();
    }
    
    public void reset()
    {
      this.bOut.reset();
      this.baseDigest.reset();
    }
    
    public void update(byte paramByte)
    {
      this.bOut.write(paramByte);
    }
    
    public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.bOut.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public static class PSSwithRSA
    extends PSSSignatureSpi
  {
    public PSSwithRSA()
    {
      super(null);
    }
  }
  
  public static class SHA1withRSA
    extends PSSSignatureSpi
  {
    public SHA1withRSA()
    {
      super(PSSParameterSpec.DEFAULT);
    }
  }
  
  public static class SHA224withRSA
    extends PSSSignatureSpi
  {
    public SHA224withRSA()
    {
      super(new PSSParameterSpec("SHA-224", "MGF1", new MGF1ParameterSpec("SHA-224"), 28, 1));
    }
  }
  
  public static class SHA256withRSA
    extends PSSSignatureSpi
  {
    public SHA256withRSA()
    {
      super(new PSSParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-256"), 32, 1));
    }
  }
  
  public static class SHA384withRSA
    extends PSSSignatureSpi
  {
    public SHA384withRSA()
    {
      super(new PSSParameterSpec("SHA-384", "MGF1", new MGF1ParameterSpec("SHA-384"), 48, 1));
    }
  }
  
  public static class SHA3_224withRSA
    extends PSSSignatureSpi
  {
    public SHA3_224withRSA()
    {
      super(new PSSParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), 28, 1));
    }
  }
  
  public static class SHA3_256withRSA
    extends PSSSignatureSpi
  {
    public SHA3_256withRSA()
    {
      super(new PSSParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), 32, 1));
    }
  }
  
  public static class SHA3_384withRSA
    extends PSSSignatureSpi
  {
    public SHA3_384withRSA()
    {
      super(new PSSParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), 48, 1));
    }
  }
  
  public static class SHA3_512withRSA
    extends PSSSignatureSpi
  {
    public SHA3_512withRSA()
    {
      super(new PSSParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), 64, 1));
    }
  }
  
  public static class SHA512_224withRSA
    extends PSSSignatureSpi
  {
    public SHA512_224withRSA()
    {
      super(new PSSParameterSpec("SHA-512(224)", "MGF1", new MGF1ParameterSpec("SHA-512(224)"), 28, 1));
    }
  }
  
  public static class SHA512_256withRSA
    extends PSSSignatureSpi
  {
    public SHA512_256withRSA()
    {
      super(new PSSParameterSpec("SHA-512(256)", "MGF1", new MGF1ParameterSpec("SHA-512(256)"), 32, 1));
    }
  }
  
  public static class SHA512withRSA
    extends PSSSignatureSpi
  {
    public SHA512withRSA()
    {
      super(new PSSParameterSpec("SHA-512", "MGF1", new MGF1ParameterSpec("SHA-512"), 64, 1));
    }
  }
  
  public static class nonePSS
    extends PSSSignatureSpi
  {
    public nonePSS()
    {
      super(null, true);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\rsa\PSSSignatureSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */