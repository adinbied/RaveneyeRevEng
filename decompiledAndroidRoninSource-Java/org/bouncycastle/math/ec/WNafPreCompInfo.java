package org.bouncycastle.math.ec;

public class WNafPreCompInfo
  implements PreCompInfo
{
  protected ECPoint[] preComp = null;
  protected ECPoint[] preCompNeg = null;
  protected ECPoint twice = null;
  
  public ECPoint[] getPreComp()
  {
    return this.preComp;
  }
  
  public ECPoint[] getPreCompNeg()
  {
    return this.preCompNeg;
  }
  
  public ECPoint getTwice()
  {
    return this.twice;
  }
  
  public void setPreComp(ECPoint[] paramArrayOfECPoint)
  {
    this.preComp = paramArrayOfECPoint;
  }
  
  public void setPreCompNeg(ECPoint[] paramArrayOfECPoint)
  {
    this.preCompNeg = paramArrayOfECPoint;
  }
  
  public void setTwice(ECPoint paramECPoint)
  {
    this.twice = paramECPoint;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\WNafPreCompInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */