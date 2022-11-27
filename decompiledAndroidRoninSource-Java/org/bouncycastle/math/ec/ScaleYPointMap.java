package org.bouncycastle.math.ec;

public class ScaleYPointMap
  implements ECPointMap
{
  protected final ECFieldElement scale;
  
  public ScaleYPointMap(ECFieldElement paramECFieldElement)
  {
    this.scale = paramECFieldElement;
  }
  
  public ECPoint map(ECPoint paramECPoint)
  {
    return paramECPoint.scaleY(this.scale);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\ScaleYPointMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */