package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.util.Arrays;

public class ECNamedCurveSpec
  extends ECParameterSpec
{
  private String name;
  
  public ECNamedCurveSpec(String paramString, EllipticCurve paramEllipticCurve, java.security.spec.ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    super(paramEllipticCurve, paramECPoint, paramBigInteger, 1);
    this.name = paramString;
  }
  
  public ECNamedCurveSpec(String paramString, EllipticCurve paramEllipticCurve, java.security.spec.ECPoint paramECPoint, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    super(paramEllipticCurve, paramECPoint, paramBigInteger1, paramBigInteger2.intValue());
    this.name = paramString;
  }
  
  public ECNamedCurveSpec(String paramString, ECCurve paramECCurve, org.bouncycastle.math.ec.ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    super(convertCurve(paramECCurve, null), convertPoint(paramECPoint), paramBigInteger, 1);
    this.name = paramString;
  }
  
  public ECNamedCurveSpec(String paramString, ECCurve paramECCurve, org.bouncycastle.math.ec.ECPoint paramECPoint, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    super(convertCurve(paramECCurve, null), convertPoint(paramECPoint), paramBigInteger1, paramBigInteger2.intValue());
    this.name = paramString;
  }
  
  public ECNamedCurveSpec(String paramString, ECCurve paramECCurve, org.bouncycastle.math.ec.ECPoint paramECPoint, BigInteger paramBigInteger1, BigInteger paramBigInteger2, byte[] paramArrayOfByte)
  {
    super(convertCurve(paramECCurve, paramArrayOfByte), convertPoint(paramECPoint), paramBigInteger1, paramBigInteger2.intValue());
    this.name = paramString;
  }
  
  private static EllipticCurve convertCurve(ECCurve paramECCurve, byte[] paramArrayOfByte)
  {
    return new EllipticCurve(convertField(paramECCurve.getField()), paramECCurve.getA().toBigInteger(), paramECCurve.getB().toBigInteger(), paramArrayOfByte);
  }
  
  private static ECField convertField(FiniteField paramFiniteField)
  {
    if (ECAlgorithms.isFpField(paramFiniteField)) {
      return new ECFieldFp(paramFiniteField.getCharacteristic());
    }
    paramFiniteField = ((PolynomialExtensionField)paramFiniteField).getMinimalPolynomial();
    int[] arrayOfInt = paramFiniteField.getExponentsPresent();
    arrayOfInt = Arrays.reverse(Arrays.copyOfRange(arrayOfInt, 1, arrayOfInt.length - 1));
    return new ECFieldF2m(paramFiniteField.getDegree(), arrayOfInt);
  }
  
  private static java.security.spec.ECPoint convertPoint(org.bouncycastle.math.ec.ECPoint paramECPoint)
  {
    paramECPoint = paramECPoint.normalize();
    return new java.security.spec.ECPoint(paramECPoint.getAffineXCoord().toBigInteger(), paramECPoint.getAffineYCoord().toBigInteger());
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\spec\ECNamedCurveSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */