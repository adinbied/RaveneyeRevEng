package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.WhirlpoolDigest;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.signers.ISO9796d2Signer;
import org.bouncycastle.crypto.util.DigestFactory;

public class ISOSignatureSpi
  extends SignatureSpi
{
  private ISO9796d2Signer signer;
  
  protected ISOSignatureSpi(Digest paramDigest, AsymmetricBlockCipher paramAsymmetricBlockCipher)
  {
    this.signer = new ISO9796d2Signer(paramAsymmetricBlockCipher, paramDigest, true);
  }
  
  protected Object engineGetParameter(String paramString)
  {
    throw new UnsupportedOperationException("engineSetParameter unsupported");
  }
  
  protected void engineInitSign(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    paramPrivateKey = RSAUtil.generatePrivateKeyParameter((RSAPrivateKey)paramPrivateKey);
    this.signer.init(true, paramPrivateKey);
  }
  
  protected void engineInitVerify(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    paramPublicKey = RSAUtil.generatePublicKeyParameter((RSAPublicKey)paramPublicKey);
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
    try
    {
      byte[] arrayOfByte = this.signer.generateSignature();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw new SignatureException(localException.toString());
    }
  }
  
  protected void engineUpdate(byte paramByte)
    throws SignatureException
  {
    this.signer.update(paramByte);
  }
  
  protected void engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws SignatureException
  {
    this.signer.update(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  protected boolean engineVerify(byte[] paramArrayOfByte)
    throws SignatureException
  {
    return this.signer.verifySignature(paramArrayOfByte);
  }
  
  public static class MD5WithRSAEncryption
    extends ISOSignatureSpi
  {
    public MD5WithRSAEncryption()
    {
      super(new RSABlindedEngine());
    }
  }
  
  public static class RIPEMD160WithRSAEncryption
    extends ISOSignatureSpi
  {
    public RIPEMD160WithRSAEncryption()
    {
      super(new RSABlindedEngine());
    }
  }
  
  public static class SHA1WithRSAEncryption
    extends ISOSignatureSpi
  {
    public SHA1WithRSAEncryption()
    {
      super(new RSABlindedEngine());
    }
  }
  
  public static class SHA224WithRSAEncryption
    extends ISOSignatureSpi
  {
    public SHA224WithRSAEncryption()
    {
      super(new RSABlindedEngine());
    }
  }
  
  public static class SHA256WithRSAEncryption
    extends ISOSignatureSpi
  {
    public SHA256WithRSAEncryption()
    {
      super(new RSABlindedEngine());
    }
  }
  
  public static class SHA384WithRSAEncryption
    extends ISOSignatureSpi
  {
    public SHA384WithRSAEncryption()
    {
      super(new RSABlindedEngine());
    }
  }
  
  public static class SHA512WithRSAEncryption
    extends ISOSignatureSpi
  {
    public SHA512WithRSAEncryption()
    {
      super(new RSABlindedEngine());
    }
  }
  
  public static class SHA512_224WithRSAEncryption
    extends ISOSignatureSpi
  {
    public SHA512_224WithRSAEncryption()
    {
      super(new RSABlindedEngine());
    }
  }
  
  public static class SHA512_256WithRSAEncryption
    extends ISOSignatureSpi
  {
    public SHA512_256WithRSAEncryption()
    {
      super(new RSABlindedEngine());
    }
  }
  
  public static class WhirlpoolWithRSAEncryption
    extends ISOSignatureSpi
  {
    public WhirlpoolWithRSAEncryption()
    {
      super(new RSABlindedEngine());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\rsa\ISOSignatureSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */