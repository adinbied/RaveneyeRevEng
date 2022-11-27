package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public abstract class BaseAlgorithmParameters
  extends AlgorithmParametersSpi
{
  protected AlgorithmParameterSpec engineGetParameterSpec(Class paramClass)
    throws InvalidParameterSpecException
  {
    if (paramClass != null) {
      return localEngineGetParameterSpec(paramClass);
    }
    throw new NullPointerException("argument to getParameterSpec must not be null");
  }
  
  protected boolean isASN1FormatString(String paramString)
  {
    return (paramString == null) || (paramString.equals("ASN.1"));
  }
  
  protected abstract AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
    throws InvalidParameterSpecException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetri\\util\BaseAlgorithmParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */