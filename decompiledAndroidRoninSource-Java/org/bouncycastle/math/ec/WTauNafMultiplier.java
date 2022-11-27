package org.bouncycastle.math.ec;

import java.math.BigInteger;

public class WTauNafMultiplier
  extends AbstractECMultiplier
{
  static final String PRECOMP_NAME = "bc_wtnaf";
  
  private static ECPoint.AbstractF2m multiplyFromWTnaf(ECPoint.AbstractF2m paramAbstractF2m, byte[] paramArrayOfByte, PreCompInfo paramPreCompInfo)
  {
    Object localObject1 = (ECCurve.AbstractF2m)paramAbstractF2m.getCurve();
    byte b = ((ECCurve.AbstractF2m)localObject1).getA().toBigInteger().byteValue();
    if ((paramPreCompInfo != null) && ((paramPreCompInfo instanceof WTauNafPreCompInfo)))
    {
      paramPreCompInfo = ((WTauNafPreCompInfo)paramPreCompInfo).getPreComp();
    }
    else
    {
      paramPreCompInfo = Tnaf.getPreComp(paramAbstractF2m, b);
      localObject2 = new WTauNafPreCompInfo();
      ((WTauNafPreCompInfo)localObject2).setPreComp(paramPreCompInfo);
      ((ECCurve.AbstractF2m)localObject1).setPreCompInfo(paramAbstractF2m, "bc_wtnaf", (PreCompInfo)localObject2);
    }
    Object localObject2 = new ECPoint.AbstractF2m[paramPreCompInfo.length];
    int i = 0;
    while (i < paramPreCompInfo.length)
    {
      localObject2[i] = ((ECPoint.AbstractF2m)paramPreCompInfo[i].negate());
      i += 1;
    }
    paramAbstractF2m = (ECPoint.AbstractF2m)paramAbstractF2m.getCurve().getInfinity();
    int j = paramArrayOfByte.length - 1;
    i = 0;
    while (j >= 0)
    {
      int k = i + 1;
      int m = paramArrayOfByte[j];
      i = k;
      localObject1 = paramAbstractF2m;
      if (m != 0)
      {
        localObject1 = paramAbstractF2m.tauPow(k);
        if (m > 0) {
          paramAbstractF2m = paramPreCompInfo[(m >>> 1)];
        } else {
          paramAbstractF2m = localObject2[(-m >>> 1)];
        }
        localObject1 = (ECPoint.AbstractF2m)((ECPoint.AbstractF2m)localObject1).add(paramAbstractF2m);
        i = 0;
      }
      j -= 1;
      paramAbstractF2m = (ECPoint.AbstractF2m)localObject1;
    }
    paramArrayOfByte = paramAbstractF2m;
    if (i > 0) {
      paramArrayOfByte = paramAbstractF2m.tauPow(i);
    }
    return paramArrayOfByte;
  }
  
  private ECPoint.AbstractF2m multiplyWTnaf(ECPoint.AbstractF2m paramAbstractF2m, ZTauElement paramZTauElement, PreCompInfo paramPreCompInfo, byte paramByte1, byte paramByte2)
  {
    ZTauElement[] arrayOfZTauElement;
    if (paramByte1 == 0) {
      arrayOfZTauElement = Tnaf.alpha0;
    } else {
      arrayOfZTauElement = Tnaf.alpha1;
    }
    BigInteger localBigInteger = Tnaf.getTw(paramByte2, 4);
    return multiplyFromWTnaf(paramAbstractF2m, Tnaf.tauAdicWNaf(paramByte2, paramZTauElement, (byte)4, BigInteger.valueOf(16L), localBigInteger, arrayOfZTauElement), paramPreCompInfo);
  }
  
  protected ECPoint multiplyPositive(ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    if ((paramECPoint instanceof ECPoint.AbstractF2m))
    {
      paramECPoint = (ECPoint.AbstractF2m)paramECPoint;
      ECCurve.AbstractF2m localAbstractF2m = (ECCurve.AbstractF2m)paramECPoint.getCurve();
      int i = localAbstractF2m.getFieldSize();
      byte b1 = localAbstractF2m.getA().toBigInteger().byteValue();
      byte b2 = Tnaf.getMu(b1);
      return multiplyWTnaf(paramECPoint, Tnaf.partModReduction(paramBigInteger, i, b1, localAbstractF2m.getSi(), b2, (byte)10), localAbstractF2m.getPreCompInfo(paramECPoint, "bc_wtnaf"), b1, b2);
    }
    throw new IllegalArgumentException("Only ECPoint.AbstractF2m can be used in WTauNafMultiplier");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\WTauNafMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */