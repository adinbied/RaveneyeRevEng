package org.bouncycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;

public class ElGamalGenParameterSpec
  implements AlgorithmParameterSpec
{
  private int primeSize;
  
  public ElGamalGenParameterSpec(int paramInt)
  {
    this.primeSize = paramInt;
  }
  
  public int getPrimeSize()
  {
    return this.primeSize;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\spec\ElGamalGenParameterSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */