package org.bouncycastle.jce.spec;

import java.security.spec.KeySpec;

public class ECKeySpec
  implements KeySpec
{
  private ECParameterSpec spec;
  
  protected ECKeySpec(ECParameterSpec paramECParameterSpec)
  {
    this.spec = paramECParameterSpec;
  }
  
  public ECParameterSpec getParams()
  {
    return this.spec;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\spec\ECKeySpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */