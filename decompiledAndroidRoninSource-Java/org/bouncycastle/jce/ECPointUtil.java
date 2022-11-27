package org.bouncycastle.jce;

import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.EllipticCurve;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.F2m;
import org.bouncycastle.math.ec.ECCurve.Fp;
import org.bouncycastle.math.ec.ECFieldElement;

public class ECPointUtil
{
  public static java.security.spec.ECPoint decodePoint(EllipticCurve paramEllipticCurve, byte[] paramArrayOfByte)
  {
    if ((paramEllipticCurve.getField() instanceof ECFieldFp))
    {
      paramEllipticCurve = new ECCurve.Fp(((ECFieldFp)paramEllipticCurve.getField()).getP(), paramEllipticCurve.getA(), paramEllipticCurve.getB());
    }
    else
    {
      int[] arrayOfInt = ((ECFieldF2m)paramEllipticCurve.getField()).getMidTermsOfReductionPolynomial();
      if (arrayOfInt.length == 3) {
        paramEllipticCurve = new ECCurve.F2m(((ECFieldF2m)paramEllipticCurve.getField()).getM(), arrayOfInt[2], arrayOfInt[1], arrayOfInt[0], paramEllipticCurve.getA(), paramEllipticCurve.getB());
      } else {
        paramEllipticCurve = new ECCurve.F2m(((ECFieldF2m)paramEllipticCurve.getField()).getM(), arrayOfInt[0], paramEllipticCurve.getA(), paramEllipticCurve.getB());
      }
    }
    paramEllipticCurve = paramEllipticCurve.decodePoint(paramArrayOfByte);
    return new java.security.spec.ECPoint(paramEllipticCurve.getAffineXCoord().toBigInteger(), paramEllipticCurve.getAffineYCoord().toBigInteger());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\ECPointUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */