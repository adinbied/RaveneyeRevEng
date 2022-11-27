package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;

public abstract class BaseAlgorithmParameterGenerator
  extends AlgorithmParameterGeneratorSpi
{
  private final JcaJceHelper helper = new BCJcaJceHelper();
  protected SecureRandom random;
  protected int strength = 1024;
  
  protected final AlgorithmParameters createParametersInstance(String paramString)
    throws NoSuchAlgorithmException, NoSuchProviderException
  {
    return this.helper.createAlgorithmParameters(paramString);
  }
  
  protected void engineInit(int paramInt, SecureRandom paramSecureRandom)
  {
    this.strength = paramInt;
    this.random = paramSecureRandom;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetri\\util\BaseAlgorithmParameterGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */