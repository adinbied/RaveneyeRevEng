package org.bouncycastle.jce.spec;

import org.bouncycastle.math.ec.ECPoint;

public class ECPublicKeySpec
  extends ECKeySpec
{
  private ECPoint q;
  
  public ECPublicKeySpec(ECPoint paramECPoint, ECParameterSpec paramECParameterSpec)
  {
    super(paramECParameterSpec);
    paramECParameterSpec = paramECPoint;
    if (paramECPoint.getCurve() != null) {
      paramECParameterSpec = paramECPoint.normalize();
    }
    this.q = paramECParameterSpec;
  }
  
  public ECPoint getQ()
  {
    return this.q;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\spec\ECPublicKeySpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */