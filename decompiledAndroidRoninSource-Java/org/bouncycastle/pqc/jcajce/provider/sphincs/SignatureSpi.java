package org.bouncycastle.pqc.jcajce.provider.sphincs;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHA512tDigest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCS256Signer;

public class SignatureSpi
  extends java.security.SignatureSpi
{
  private Digest digest;
  private SecureRandom random;
  private SPHINCS256Signer signer;
  
  protected SignatureSpi(Digest paramDigest, SPHINCS256Signer paramSPHINCS256Signer)
  {
    this.digest = paramDigest;
    this.signer = paramSPHINCS256Signer;
  }
  
  protected Object engineGetParameter(String paramString)
  {
    throw new UnsupportedOperationException("engineSetParameter unsupported");
  }
  
  protected void engineInitSign(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    if ((paramPrivateKey instanceof BCSphincs256PrivateKey))
    {
      CipherParameters localCipherParameters = ((BCSphincs256PrivateKey)paramPrivateKey).getKeyParams();
      SecureRandom localSecureRandom = this.random;
      paramPrivateKey = localCipherParameters;
      if (localSecureRandom != null) {
        paramPrivateKey = new ParametersWithRandom(localCipherParameters, localSecureRandom);
      }
      this.digest.reset();
      this.signer.init(true, paramPrivateKey);
      return;
    }
    throw new InvalidKeyException("unknown private key passed to SPHINCS-256");
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
    if ((paramPublicKey instanceof BCSphincs256PublicKey))
    {
      paramPublicKey = ((BCSphincs256PublicKey)paramPublicKey).getKeyParams();
      this.digest.reset();
      this.signer.init(false, paramPublicKey);
      return;
    }
    throw new InvalidKeyException("unknown public key passed to SPHINCS-256");
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
  
  public static class withSha3_512
    extends SignatureSpi
  {
    public withSha3_512()
    {
      super(new SPHINCS256Signer(new SHA3Digest(256), new SHA3Digest(512)));
    }
  }
  
  public static class withSha512
    extends SignatureSpi
  {
    public withSha512()
    {
      super(new SPHINCS256Signer(new SHA512tDigest(256), new SHA512Digest()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\sphincs\SignatureSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */