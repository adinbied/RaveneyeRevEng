package org.bouncycastle.math.ec;

public class FixedPointPreCompInfo
  implements PreCompInfo
{
  protected ECPoint offset = null;
  protected ECPoint[] preComp = null;
  protected int width = -1;
  
  public ECPoint getOffset()
  {
    return this.offset;
  }
  
  public ECPoint[] getPreComp()
  {
    return this.preComp;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void setOffset(ECPoint paramECPoint)
  {
    this.offset = paramECPoint;
  }
  
  public void setPreComp(ECPoint[] paramArrayOfECPoint)
  {
    this.preComp = paramArrayOfECPoint;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\FixedPointPreCompInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */