package org.bouncycastle.crypto.ec;

import org.bouncycastle.math.ec.ECPoint;

public class ECPair
{
  private final ECPoint x;
  private final ECPoint y;
  
  public ECPair(ECPoint paramECPoint1, ECPoint paramECPoint2)
  {
    this.x = paramECPoint1;
    this.y = paramECPoint2;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ECPair)) {
      return equals((ECPair)paramObject);
    }
    return false;
  }
  
  public boolean equals(ECPair paramECPair)
  {
    return (paramECPair.getX().equals(getX())) && (paramECPair.getY().equals(getY()));
  }
  
  public ECPoint getX()
  {
    return this.x;
  }
  
  public ECPoint getY()
  {
    return this.y;
  }
  
  public int hashCode()
  {
    return this.x.hashCode() + this.y.hashCode() * 37;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\ec\ECPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */