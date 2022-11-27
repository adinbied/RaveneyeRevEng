package org.bouncycastle.crypto.prng.drbg;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class DualECPoints
{
  private final int cofactor;
  private final ECPoint p;
  private final ECPoint q;
  private final int securityStrength;
  
  public DualECPoints(int paramInt1, ECPoint paramECPoint1, ECPoint paramECPoint2, int paramInt2)
  {
    if (paramECPoint1.getCurve().equals(paramECPoint2.getCurve()))
    {
      this.securityStrength = paramInt1;
      this.p = paramECPoint1;
      this.q = paramECPoint2;
      this.cofactor = paramInt2;
      return;
    }
    throw new IllegalArgumentException("points need to be on the same curve");
  }
  
  private static int log2(int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    for (;;)
    {
      i >>= 1;
      if (i == 0) {
        break;
      }
      paramInt += 1;
    }
    return paramInt;
  }
  
  public int getCofactor()
  {
    return this.cofactor;
  }
  
  public int getMaxOutlen()
  {
    return (this.p.getCurve().getFieldSize() - (log2(this.cofactor) + 13)) / 8 * 8;
  }
  
  public ECPoint getP()
  {
    return this.p;
  }
  
  public ECPoint getQ()
  {
    return this.q;
  }
  
  public int getSecurityStrength()
  {
    return this.securityStrength;
  }
  
  public int getSeedLen()
  {
    return this.p.getCurve().getFieldSize();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\drbg\DualECPoints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */