package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.agreement.kdf.DHKEKGenerator;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.bouncycastle.jcajce.spec.UserKeyingMaterialSpec;

public class KeyAgreementSpi
  extends BaseAgreementSpi
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private static final BigInteger TWO = BigInteger.valueOf(2L);
  private BigInteger g;
  private BigInteger p;
  private BigInteger result;
  private BigInteger x;
  
  public KeyAgreementSpi()
  {
    super("Diffie-Hellman", null);
  }
  
  public KeyAgreementSpi(String paramString, DerivationFunction paramDerivationFunction)
  {
    super(paramString, paramDerivationFunction);
  }
  
  protected byte[] bigIntToBytes(BigInteger paramBigInteger)
  {
    int i = (this.p.bitLength() + 7) / 8;
    paramBigInteger = paramBigInteger.toByteArray();
    if (paramBigInteger.length == i) {
      return paramBigInteger;
    }
    if ((paramBigInteger[0] == 0) && (paramBigInteger.length == i + 1))
    {
      i = paramBigInteger.length - 1;
      arrayOfByte = new byte[i];
      System.arraycopy(paramBigInteger, 1, arrayOfByte, 0, i);
      return arrayOfByte;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramBigInteger, 0, arrayOfByte, i - paramBigInteger.length, paramBigInteger.length);
    return arrayOfByte;
  }
  
  protected byte[] calcSecret()
  {
    return bigIntToBytes(this.result);
  }
  
  protected Key engineDoPhase(Key paramKey, boolean paramBoolean)
    throws InvalidKeyException, IllegalStateException
  {
    if (this.x != null)
    {
      if ((paramKey instanceof DHPublicKey))
      {
        paramKey = (DHPublicKey)paramKey;
        if ((paramKey.getParams().getG().equals(this.g)) && (paramKey.getParams().getP().equals(this.p)))
        {
          BigInteger localBigInteger = paramKey.getY();
          if ((localBigInteger != null) && (localBigInteger.compareTo(TWO) >= 0) && (localBigInteger.compareTo(this.p.subtract(ONE)) < 0))
          {
            localBigInteger = localBigInteger.modPow(this.x, this.p);
            this.result = localBigInteger;
            if (localBigInteger.compareTo(ONE) != 0)
            {
              if (paramBoolean) {
                return null;
              }
              return new BCDHPublicKey(this.result, paramKey.getParams());
            }
            throw new InvalidKeyException("Shared key can't be 1");
          }
          throw new InvalidKeyException("Invalid DH PublicKey");
        }
        throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
      }
      throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
    }
    throw new IllegalStateException("Diffie-Hellman not initialised.");
  }
  
  protected int engineGenerateSecret(byte[] paramArrayOfByte, int paramInt)
    throws IllegalStateException, ShortBufferException
  {
    if (this.x != null) {
      return super.engineGenerateSecret(paramArrayOfByte, paramInt);
    }
    throw new IllegalStateException("Diffie-Hellman not initialised.");
  }
  
  protected SecretKey engineGenerateSecret(String paramString)
    throws NoSuchAlgorithmException
  {
    if (this.x != null)
    {
      byte[] arrayOfByte = bigIntToBytes(this.result);
      if (paramString.equals("TlsPremasterSecret")) {
        return new SecretKeySpec(trimZeroes(arrayOfByte), paramString);
      }
      return super.engineGenerateSecret(paramString);
    }
    throw new IllegalStateException("Diffie-Hellman not initialised.");
  }
  
  protected byte[] engineGenerateSecret()
    throws IllegalStateException
  {
    if (this.x != null) {
      return super.engineGenerateSecret();
    }
    throw new IllegalStateException("Diffie-Hellman not initialised.");
  }
  
  protected void engineInit(Key paramKey, SecureRandom paramSecureRandom)
    throws InvalidKeyException
  {
    if ((paramKey instanceof DHPrivateKey))
    {
      paramKey = (DHPrivateKey)paramKey;
      this.p = paramKey.getParams().getP();
      this.g = paramKey.getParams().getG();
      paramKey = paramKey.getX();
      this.result = paramKey;
      this.x = paramKey;
      return;
    }
    throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
  }
  
  protected void engineInit(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    if ((paramKey instanceof DHPrivateKey))
    {
      paramSecureRandom = (DHPrivateKey)paramKey;
      if (paramAlgorithmParameterSpec != null)
      {
        if ((paramAlgorithmParameterSpec instanceof DHParameterSpec))
        {
          paramKey = (DHParameterSpec)paramAlgorithmParameterSpec;
          this.p = paramKey.getP();
        }
        else
        {
          if ((paramAlgorithmParameterSpec instanceof UserKeyingMaterialSpec))
          {
            this.p = paramSecureRandom.getParams().getP();
            this.g = paramSecureRandom.getParams().getG();
            this.ukmParameters = ((UserKeyingMaterialSpec)paramAlgorithmParameterSpec).getUserKeyingMaterial();
            break label124;
          }
          throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
        }
      }
      else
      {
        this.p = paramSecureRandom.getParams().getP();
        paramKey = paramSecureRandom.getParams();
      }
      this.g = paramKey.getG();
      label124:
      paramKey = paramSecureRandom.getX();
      this.result = paramKey;
      this.x = paramKey;
      return;
    }
    throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
  }
  
  public static class DHwithRFC2631KDF
    extends KeyAgreementSpi
  {
    public DHwithRFC2631KDF()
    {
      super(new DHKEKGenerator(DigestFactory.createSHA1()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dh\KeyAgreementSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */