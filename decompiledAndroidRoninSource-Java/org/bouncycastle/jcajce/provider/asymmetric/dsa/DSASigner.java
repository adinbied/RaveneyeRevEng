package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.NullDigest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.signers.HMacDSAKCalculator;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;

public class DSASigner
  extends SignatureSpi
  implements PKCSObjectIdentifiers, X509ObjectIdentifiers
{
  private Digest digest;
  private SecureRandom random;
  private DSA signer;
  
  protected DSASigner(Digest paramDigest, DSA paramDSA)
  {
    this.digest = paramDigest;
    this.signer = paramDSA;
  }
  
  private BigInteger[] derDecode(byte[] paramArrayOfByte)
    throws IOException
  {
    ASN1Sequence localASN1Sequence = (ASN1Sequence)ASN1Primitive.fromByteArray(paramArrayOfByte);
    if (localASN1Sequence.size() == 2)
    {
      if (Arrays.areEqual(paramArrayOfByte, localASN1Sequence.getEncoded("DER"))) {
        return new BigInteger[] { ((ASN1Integer)localASN1Sequence.getObjectAt(0)).getValue(), ((ASN1Integer)localASN1Sequence.getObjectAt(1)).getValue() };
      }
      throw new IOException("malformed signature");
    }
    throw new IOException("malformed signature");
  }
  
  private byte[] derEncode(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    throws IOException
  {
    return new DERSequence(new ASN1Integer[] { new ASN1Integer(paramBigInteger1), new ASN1Integer(paramBigInteger2) }).getEncoded("DER");
  }
  
  protected Object engineGetParameter(String paramString)
  {
    throw new UnsupportedOperationException("engineSetParameter unsupported");
  }
  
  protected void engineInitSign(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    AsymmetricKeyParameter localAsymmetricKeyParameter = DSAUtil.generatePrivateKeyParameter(paramPrivateKey);
    SecureRandom localSecureRandom = this.random;
    paramPrivateKey = localAsymmetricKeyParameter;
    if (localSecureRandom != null) {
      paramPrivateKey = new ParametersWithRandom(localAsymmetricKeyParameter, localSecureRandom);
    }
    this.digest.reset();
    this.signer.init(true, paramPrivateKey);
  }
  
  protected void engineInitSign(PrivateKey paramPrivateKey, SecureRandom paramSecureRandom)
    throws InvalidKeyException
  {
    this.random = paramSecureRandom;
    engineInitSign(paramPrivateKey);
  }
  
  protected void engineInitVerify(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    paramPublicKey = DSAUtil.generatePublicKeyParameter(paramPublicKey);
    this.digest.reset();
    this.signer.init(false, paramPublicKey);
  }
  
  protected void engineSetParameter(String paramString, Object paramObject)
  {
    throw new UnsupportedOperationException("engineSetParameter unsupported");
  }
  
  protected void engineSetParameter(AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    throw new UnsupportedOperationException("engineSetParameter unsupported");
  }
  
  protected byte[] engineSign()
    throws SignatureException
  {
    Object localObject = new byte[this.digest.getDigestSize()];
    this.digest.doFinal((byte[])localObject, 0);
    try
    {
      localObject = this.signer.generateSignature((byte[])localObject);
      localObject = derEncode(localObject[0], localObject[1]);
      return (byte[])localObject;
    }
    catch (Exception localException)
    {
      throw new SignatureException(localException.toString());
    }
  }
  
  protected void engineUpdate(byte paramByte)
    throws SignatureException
  {
    this.digest.update(paramByte);
  }
  
  protected void engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws SignatureException
  {
    this.digest.update(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  protected boolean engineVerify(byte[] paramArrayOfByte)
    throws SignatureException
  {
    byte[] arrayOfByte = new byte[this.digest.getDigestSize()];
    this.digest.doFinal(arrayOfByte, 0);
    try
    {
      paramArrayOfByte = derDecode(paramArrayOfByte);
      return this.signer.verifySignature(arrayOfByte, paramArrayOfByte[0], paramArrayOfByte[1]);
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;) {}
    }
    throw new SignatureException("error decoding signature bytes.");
  }
  
  public static class detDSA
    extends DSASigner
  {
    public detDSA()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA1())));
    }
  }
  
  public static class detDSA224
    extends DSASigner
  {
    public detDSA224()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA224())));
    }
  }
  
  public static class detDSA256
    extends DSASigner
  {
    public detDSA256()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA256())));
    }
  }
  
  public static class detDSA384
    extends DSASigner
  {
    public detDSA384()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA384())));
    }
  }
  
  public static class detDSA512
    extends DSASigner
  {
    public detDSA512()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA512())));
    }
  }
  
  public static class detDSASha3_224
    extends DSASigner
  {
    public detDSASha3_224()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_224())));
    }
  }
  
  public static class detDSASha3_256
    extends DSASigner
  {
    public detDSASha3_256()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_256())));
    }
  }
  
  public static class detDSASha3_384
    extends DSASigner
  {
    public detDSASha3_384()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_384())));
    }
  }
  
  public static class detDSASha3_512
    extends DSASigner
  {
    public detDSASha3_512()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_512())));
    }
  }
  
  public static class dsa224
    extends DSASigner
  {
    public dsa224()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner());
    }
  }
  
  public static class dsa256
    extends DSASigner
  {
    public dsa256()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner());
    }
  }
  
  public static class dsa384
    extends DSASigner
  {
    public dsa384()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner());
    }
  }
  
  public static class dsa512
    extends DSASigner
  {
    public dsa512()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner());
    }
  }
  
  public static class dsaSha3_224
    extends DSASigner
  {
    public dsaSha3_224()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner());
    }
  }
  
  public static class dsaSha3_256
    extends DSASigner
  {
    public dsaSha3_256()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner());
    }
  }
  
  public static class dsaSha3_384
    extends DSASigner
  {
    public dsaSha3_384()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner());
    }
  }
  
  public static class dsaSha3_512
    extends DSASigner
  {
    public dsaSha3_512()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner());
    }
  }
  
  public static class noneDSA
    extends DSASigner
  {
    public noneDSA()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner());
    }
  }
  
  public static class stdDSA
    extends DSASigner
  {
    public stdDSA()
    {
      super(new org.bouncycastle.crypto.signers.DSASigner());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dsa\DSASigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */