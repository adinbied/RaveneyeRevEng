package org.bouncycastle.math.ec;

public class WTauNafPreCompInfo
  implements PreCompInfo
{
  protected ECPoint.AbstractF2m[] preComp = null;
  
  public ECPoint.AbstractF2m[] getPreComp()
  {
    return this.preComp;
  }
  
  public void setPreComp(ECPoint.AbstractF2m[] paramArrayOfAbstractF2m)
  {
    this.preComp = paramArrayOfAbstractF2m;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\WTauNafPreCompInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */