package org.bouncycastle.pqc.jcajce.provider.rainbow;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.rainbow.RainbowSigner;

public class SignatureSpi
  extends java.security.SignatureSpi
{
  private Digest digest;
  private SecureRandom random;
  private RainbowSigner signer;
  
  protected SignatureSpi(Digest paramDigest, RainbowSigner paramRainbowSigner)
  {
    this.digest = paramDigest;
    this.signer = paramRainbowSigner;
  }
  
  protected Object engineGetParameter(String paramString)
  {
    throw new UnsupportedOperationException("engineSetParameter unsupported");
  }
  
  protected void engineInitSign(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    AsymmetricKeyParameter localAsymmetricKeyParameter = RainbowKeysToParams.generatePrivateKeyParameter(paramPrivateKey);
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
    paramPublicKey = RainbowKeysToParams.generatePublicKeyParameter(paramPublicKey);
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
    byte[] arrayOfByte = new byte[this.digest.getDigestSize()];
    this.digest.doFinal(arrayOfByte, 0);
    try
    {
      arrayOfByte = this.signer.generateSignature(arrayOfByte);
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
    return this.signer.verifySignature(arrayOfByte, paramArrayOfByte);
  }
  
  public static class withSha224
    extends SignatureSpi
  {
    public withSha224()
    {
      super(new RainbowSigner());
    }
  }
  
  public static class withSha256
    extends SignatureSpi
  {
    public withSha256()
    {
      super(new RainbowSigner());
    }
  }
  
  public static class withSha384
    extends SignatureSpi
  {
    public withSha384()
    {
      super(new RainbowSigner());
    }
  }
  
  public static class withSha512
    extends SignatureSpi
  {
    public withSha512()
    {
      super(new RainbowSigner());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\rainbow\SignatureSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */