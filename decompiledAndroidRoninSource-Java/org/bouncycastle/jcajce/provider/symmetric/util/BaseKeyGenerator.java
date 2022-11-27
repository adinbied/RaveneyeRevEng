package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class BaseKeyGenerator
  extends KeyGeneratorSpi
{
  protected String algName;
  protected int defaultKeySize;
  protected CipherKeyGenerator engine;
  protected int keySize;
  protected boolean uninitialised = true;
  
  protected BaseKeyGenerator(String paramString, int paramInt, CipherKeyGenerator paramCipherKeyGenerator)
  {
    this.algName = paramString;
    this.defaultKeySize = paramInt;
    this.keySize = paramInt;
    this.engine = paramCipherKeyGenerator;
  }
  
  protected SecretKey engineGenerateKey()
  {
    if (this.uninitialised)
    {
      this.engine.init(new KeyGenerationParameters(new SecureRandom(), this.defaultKeySize));
      this.uninitialised = false;
    }
    return new SecretKeySpec(this.engine.generateKey(), this.algName);
  }
  
  protected void engineInit(int paramInt, SecureRandom paramSecureRandom)
  {
    SecureRandom localSecureRandom = paramSecureRandom;
    if (paramSecureRandom == null) {}
    try
    {
      localSecureRandom = new SecureRandom();
      this.engine.init(new KeyGenerationParameters(localSecureRandom, paramInt));
      this.uninitialised = false;
      return;
    }
    catch (IllegalArgumentException paramSecureRandom)
    {
      throw new InvalidParameterException(paramSecureRandom.getMessage());
    }
  }
  
  protected void engineInit(SecureRandom paramSecureRandom)
  {
    if (paramSecureRandom != null)
    {
      this.engine.init(new KeyGenerationParameters(paramSecureRandom, this.defaultKeySize));
      this.uninitialised = false;
    }
  }
  
  protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidAlgorithmParameterException
  {
    throw new InvalidAlgorithmParameterException("Not Implemented");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetri\\util\BaseKeyGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */