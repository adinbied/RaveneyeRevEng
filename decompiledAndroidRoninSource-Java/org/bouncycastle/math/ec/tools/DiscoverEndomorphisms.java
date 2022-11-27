package org.bouncycastle.math.ec.tools;

import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECFieldElement.Fp;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.util.BigIntegers;

public class DiscoverEndomorphisms
{
  private static final int radix = 16;
  
  private static boolean areRelativelyPrime(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    return paramBigInteger1.gcd(paramBigInteger2).equals(ECConstants.ONE);
  }
  
  private static BigInteger[] calculateRange(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    return order(paramBigInteger1.subtract(paramBigInteger2).divide(paramBigInteger3), paramBigInteger1.add(paramBigInteger2).divide(paramBigInteger3));
  }
  
  private static BigInteger[] chooseShortest(BigInteger[] paramArrayOfBigInteger1, BigInteger[] paramArrayOfBigInteger2)
  {
    if (isShorter(paramArrayOfBigInteger1, paramArrayOfBigInteger2)) {
      return paramArrayOfBigInteger1;
    }
    return paramArrayOfBigInteger2;
  }
  
  private static void discoverEndomorphisms(String paramString)
  {
    Object localObject1 = ECNamedCurveTable.getByName(paramString);
    if (localObject1 == null)
    {
      localObject1 = System.err;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Unknown curve: ");
      ((StringBuilder)localObject2).append(paramString);
      ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject2 = ((X9ECParameters)localObject1).getCurve();
    if (ECAlgorithms.isFpCurve((ECCurve)localObject2))
    {
      Object localObject3 = ((ECCurve)localObject2).getField().getCharacteristic();
      if ((((ECCurve)localObject2).getA().isZero()) && (((BigInteger)localObject3).mod(ECConstants.THREE).equals(ECConstants.ONE)))
      {
        localObject2 = System.out;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Curve '");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append("' has a 'GLV Type B' endomorphism with these parameters:");
        ((PrintStream)localObject2).println(((StringBuilder)localObject3).toString());
        printGLVTypeBParameters((X9ECParameters)localObject1);
      }
    }
  }
  
  public static void discoverEndomorphisms(X9ECParameters paramX9ECParameters)
  {
    if (paramX9ECParameters != null)
    {
      ECCurve localECCurve = paramX9ECParameters.getCurve();
      if (ECAlgorithms.isFpCurve(localECCurve))
      {
        BigInteger localBigInteger = localECCurve.getField().getCharacteristic();
        if ((localECCurve.getA().isZero()) && (localBigInteger.mod(ECConstants.THREE).equals(ECConstants.ONE)))
        {
          System.out.println("Curve has a 'GLV Type B' endomorphism with these parameters:");
          printGLVTypeBParameters(paramX9ECParameters);
        }
      }
      return;
    }
    throw new NullPointerException("x9");
  }
  
  private static BigInteger[] extEuclidBezout(BigInteger[] paramArrayOfBigInteger)
  {
    int i;
    if (paramArrayOfBigInteger[0].compareTo(paramArrayOfBigInteger[1]) < 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      swap(paramArrayOfBigInteger);
    }
    Object localObject5 = paramArrayOfBigInteger[0];
    paramArrayOfBigInteger = paramArrayOfBigInteger[1];
    Object localObject4 = ECConstants.ONE;
    Object localObject1 = ECConstants.ZERO;
    Object localObject3 = ECConstants.ZERO;
    BigInteger localBigInteger2;
    for (Object localObject2 = ECConstants.ONE; paramArrayOfBigInteger.compareTo(ECConstants.ONE) > 0; localObject2 = localBigInteger2)
    {
      localObject5 = ((BigInteger)localObject5).divideAndRemainder(paramArrayOfBigInteger);
      localBigInteger2 = localObject5[0];
      localObject5 = localObject5[1];
      BigInteger localBigInteger1 = ((BigInteger)localObject4).subtract(localBigInteger2.multiply((BigInteger)localObject1));
      localBigInteger2 = ((BigInteger)localObject3).subtract(localBigInteger2.multiply((BigInteger)localObject2));
      localObject3 = localObject5;
      localObject5 = paramArrayOfBigInteger;
      paramArrayOfBigInteger = (BigInteger[])localObject3;
      localObject4 = localObject1;
      localObject1 = localBigInteger1;
      localObject3 = localObject2;
    }
    if (paramArrayOfBigInteger.signum() <= 0) {
      return null;
    }
    paramArrayOfBigInteger = new BigInteger[2];
    paramArrayOfBigInteger[0] = localObject1;
    paramArrayOfBigInteger[1] = localObject2;
    if (i != 0) {
      swap(paramArrayOfBigInteger);
    }
    return paramArrayOfBigInteger;
  }
  
  private static BigInteger[] extEuclidGLV(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    BigInteger localBigInteger1 = ECConstants.ZERO;
    Object localObject3 = ECConstants.ONE;
    Object localObject2 = paramBigInteger1;
    Object localObject1 = paramBigInteger2;
    paramBigInteger2 = (BigInteger)localObject3;
    for (;;)
    {
      localObject3 = ((BigInteger)localObject2).divideAndRemainder((BigInteger)localObject1);
      BigInteger localBigInteger2 = localObject3[0];
      localObject3 = localObject3[1];
      localBigInteger2 = localBigInteger1.subtract(localBigInteger2.multiply(paramBigInteger2));
      if (isLessThanSqrt((BigInteger)localObject1, paramBigInteger1)) {
        return new BigInteger[] { localObject2, localBigInteger1, localObject1, paramBigInteger2, localObject3, localBigInteger2 };
      }
      localObject2 = localBigInteger2;
      localBigInteger1 = paramBigInteger2;
      paramBigInteger2 = (BigInteger)localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  private static ECFieldElement[] findBetaValues(ECCurve paramECCurve)
  {
    BigInteger localBigInteger1 = paramECCurve.getField().getCharacteristic();
    BigInteger localBigInteger2 = localBigInteger1.divide(ECConstants.THREE);
    SecureRandom localSecureRandom = new SecureRandom();
    BigInteger localBigInteger3;
    do
    {
      localBigInteger3 = BigIntegers.createRandomInRange(ECConstants.TWO, localBigInteger1.subtract(ECConstants.TWO), localSecureRandom).modPow(localBigInteger2, localBigInteger1);
    } while (localBigInteger3.equals(ECConstants.ONE));
    paramECCurve = paramECCurve.fromBigInteger(localBigInteger3);
    return new ECFieldElement[] { paramECCurve, paramECCurve.square() };
  }
  
  private static BigInteger[] intersect(BigInteger[] paramArrayOfBigInteger1, BigInteger[] paramArrayOfBigInteger2)
  {
    BigInteger localBigInteger = paramArrayOfBigInteger1[0].max(paramArrayOfBigInteger2[0]);
    paramArrayOfBigInteger1 = paramArrayOfBigInteger1[1].min(paramArrayOfBigInteger2[1]);
    if (localBigInteger.compareTo(paramArrayOfBigInteger1) > 0) {
      return null;
    }
    return new BigInteger[] { localBigInteger, paramArrayOfBigInteger1 };
  }
  
  private static boolean isLessThanSqrt(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    paramBigInteger1 = paramBigInteger1.abs();
    paramBigInteger2 = paramBigInteger2.abs();
    int i = paramBigInteger2.bitLength();
    int j = paramBigInteger1.bitLength() * 2;
    return (j - 1 <= i) && ((j < i) || (paramBigInteger1.multiply(paramBigInteger1).compareTo(paramBigInteger2) < 0));
  }
  
  private static boolean isShorter(BigInteger[] paramArrayOfBigInteger1, BigInteger[] paramArrayOfBigInteger2)
  {
    boolean bool3 = false;
    BigInteger localBigInteger1 = paramArrayOfBigInteger1[0].abs();
    paramArrayOfBigInteger1 = paramArrayOfBigInteger1[1].abs();
    BigInteger localBigInteger2 = paramArrayOfBigInteger2[0].abs();
    paramArrayOfBigInteger2 = paramArrayOfBigInteger2[1].abs();
    if (localBigInteger1.compareTo(localBigInteger2) < 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (paramArrayOfBigInteger1.compareTo(paramArrayOfBigInteger2) < 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (bool1 == bool2) {
      return bool1;
    }
    boolean bool1 = bool3;
    if (localBigInteger1.multiply(localBigInteger1).add(paramArrayOfBigInteger1.multiply(paramArrayOfBigInteger1)).compareTo(localBigInteger2.multiply(localBigInteger2).add(paramArrayOfBigInteger2.multiply(paramArrayOfBigInteger2))) < 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  private static boolean isVectorBoundedBySqrt(BigInteger[] paramArrayOfBigInteger, BigInteger paramBigInteger)
  {
    return isLessThanSqrt(paramArrayOfBigInteger[0].abs().max(paramArrayOfBigInteger[1].abs()), paramBigInteger);
  }
  
  private static BigInteger isqrt(BigInteger paramBigInteger)
  {
    BigInteger localBigInteger;
    for (Object localObject = paramBigInteger.shiftRight(paramBigInteger.bitLength() / 2);; localObject = localBigInteger)
    {
      localBigInteger = ((BigInteger)localObject).add(paramBigInteger.divide((BigInteger)localObject)).shiftRight(1);
      if (localBigInteger.equals(localObject)) {
        return localBigInteger;
      }
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 1)
    {
      System.err.println("Expected a list of curve names as arguments");
      return;
    }
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      discoverEndomorphisms(paramArrayOfString[i]);
      i += 1;
    }
  }
  
  private static BigInteger[] order(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    if (paramBigInteger1.compareTo(paramBigInteger2) <= 0) {
      return new BigInteger[] { paramBigInteger1, paramBigInteger2 };
    }
    return new BigInteger[] { paramBigInteger2, paramBigInteger1 };
  }
  
  private static void printGLVTypeBParameters(X9ECParameters paramX9ECParameters)
  {
    BigInteger[] arrayOfBigInteger = solveQuadraticEquation(paramX9ECParameters.getN(), ECConstants.ONE, ECConstants.ONE);
    ECFieldElement[] arrayOfECFieldElement = findBetaValues(paramX9ECParameters.getCurve());
    printGLVTypeBParameters(paramX9ECParameters, arrayOfBigInteger[0], arrayOfECFieldElement);
    System.out.println("OR");
    printGLVTypeBParameters(paramX9ECParameters, arrayOfBigInteger[1], arrayOfECFieldElement);
  }
  
  private static void printGLVTypeBParameters(X9ECParameters paramX9ECParameters, BigInteger paramBigInteger, ECFieldElement[] paramArrayOfECFieldElement)
  {
    Object localObject3 = paramX9ECParameters.getG().normalize();
    Object localObject4 = ((ECPoint)localObject3).multiply(paramBigInteger).normalize();
    if (((ECPoint)localObject3).getYCoord().equals(((ECPoint)localObject4).getYCoord()))
    {
      Object localObject2 = paramArrayOfECFieldElement[0];
      Object localObject1 = localObject2;
      if (!((ECPoint)localObject3).getXCoord().multiply((ECFieldElement)localObject2).equals(((ECPoint)localObject4).getXCoord()))
      {
        localObject1 = paramArrayOfECFieldElement[1];
        if (!((ECPoint)localObject3).getXCoord().multiply((ECFieldElement)localObject1).equals(((ECPoint)localObject4).getXCoord())) {
          throw new IllegalStateException("Derivation of GLV Type B parameters failed unexpectedly");
        }
      }
      BigInteger localBigInteger1 = paramX9ECParameters.getN();
      localObject3 = extEuclidGLV(localBigInteger1, paramBigInteger);
      BigInteger[] arrayOfBigInteger1 = new BigInteger[2];
      arrayOfBigInteger1[0] = localObject3[2];
      arrayOfBigInteger1[1] = localObject3[3].negate();
      paramX9ECParameters = localObject3[0];
      paramArrayOfECFieldElement = localObject3[1].negate();
      localObject2 = localObject3[4];
      localObject3 = localObject3[5].negate();
      paramX9ECParameters = chooseShortest(new BigInteger[] { paramX9ECParameters, paramArrayOfECFieldElement }, new BigInteger[] { localObject2, localObject3 });
      localObject2 = paramX9ECParameters;
      if (!isVectorBoundedBySqrt(paramX9ECParameters, localBigInteger1))
      {
        localObject2 = paramX9ECParameters;
        if (areRelativelyPrime(arrayOfBigInteger1[0], arrayOfBigInteger1[1]))
        {
          BigInteger localBigInteger2 = arrayOfBigInteger1[0];
          BigInteger localBigInteger3 = arrayOfBigInteger1[1];
          localObject4 = localBigInteger2.add(localBigInteger3.multiply(paramBigInteger)).divide(localBigInteger1);
          paramArrayOfECFieldElement = extEuclidBezout(new BigInteger[] { ((BigInteger)localObject4).abs(), localBigInteger3.abs() });
          localObject2 = paramX9ECParameters;
          if (paramArrayOfECFieldElement != null)
          {
            localObject2 = paramArrayOfECFieldElement[0];
            localObject3 = paramArrayOfECFieldElement[1];
            paramArrayOfECFieldElement = (ECFieldElement[])localObject2;
            if (((BigInteger)localObject4).signum() < 0) {
              paramArrayOfECFieldElement = ((BigInteger)localObject2).negate();
            }
            localObject2 = localObject3;
            if (localBigInteger3.signum() > 0) {
              localObject2 = ((BigInteger)localObject3).negate();
            }
            if (((BigInteger)localObject4).multiply(paramArrayOfECFieldElement).subtract(localBigInteger3.multiply((BigInteger)localObject2)).equals(ECConstants.ONE))
            {
              BigInteger localBigInteger4 = ((BigInteger)localObject2).multiply(localBigInteger1).subtract(paramArrayOfECFieldElement.multiply(paramBigInteger));
              localObject2 = paramArrayOfECFieldElement.negate();
              localObject3 = localBigInteger4.negate();
              localObject4 = isqrt(localBigInteger1.subtract(ECConstants.ONE)).add(ECConstants.ONE);
              BigInteger[] arrayOfBigInteger2 = intersect(calculateRange((BigInteger)localObject2, (BigInteger)localObject4, localBigInteger3), calculateRange((BigInteger)localObject3, (BigInteger)localObject4, localBigInteger2));
              localObject2 = paramX9ECParameters;
              if (arrayOfBigInteger2 != null)
              {
                localObject3 = arrayOfBigInteger2[0];
                for (;;)
                {
                  localObject2 = paramX9ECParameters;
                  if (((BigInteger)localObject3).compareTo(arrayOfBigInteger2[1]) > 0) {
                    break;
                  }
                  localObject4 = new BigInteger[2];
                  localObject4[0] = localBigInteger4.add(((BigInteger)localObject3).multiply(localBigInteger2));
                  localObject4[1] = paramArrayOfECFieldElement.add(((BigInteger)localObject3).multiply(localBigInteger3));
                  localObject2 = paramX9ECParameters;
                  if (isShorter((BigInteger[])localObject4, paramX9ECParameters)) {
                    localObject2 = localObject4;
                  }
                  localObject3 = ((BigInteger)localObject3).add(ECConstants.ONE);
                  paramX9ECParameters = (X9ECParameters)localObject2;
                }
              }
            }
            else
            {
              throw new IllegalStateException();
            }
          }
        }
      }
      paramX9ECParameters = arrayOfBigInteger1[0].multiply(localObject2[1]).subtract(arrayOfBigInteger1[1].multiply(localObject2[0]));
      int i = localBigInteger1.bitLength() + 16 - (localBigInteger1.bitLength() & 0x7);
      paramArrayOfECFieldElement = roundQuotient(localObject2[1].shiftLeft(i), paramX9ECParameters);
      localObject3 = roundQuotient(arrayOfBigInteger1[1].shiftLeft(i), paramX9ECParameters).negate();
      printProperty("Beta", ((ECFieldElement)localObject1).toBigInteger().toString(16));
      printProperty("Lambda", paramBigInteger.toString(16));
      paramBigInteger = new StringBuilder();
      paramBigInteger.append("{ ");
      paramBigInteger.append(arrayOfBigInteger1[0].toString(16));
      paramBigInteger.append(", ");
      paramBigInteger.append(arrayOfBigInteger1[1].toString(16));
      paramBigInteger.append(" }");
      printProperty("v1", paramBigInteger.toString());
      paramBigInteger = new StringBuilder();
      paramBigInteger.append("{ ");
      paramBigInteger.append(localObject2[0].toString(16));
      paramBigInteger.append(", ");
      paramBigInteger.append(localObject2[1].toString(16));
      paramBigInteger.append(" }");
      printProperty("v2", paramBigInteger.toString());
      printProperty("d", paramX9ECParameters.toString(16));
      printProperty("(OPT) g1", paramArrayOfECFieldElement.toString(16));
      printProperty("(OPT) g2", ((BigInteger)localObject3).toString(16));
      printProperty("(OPT) bits", Integer.toString(i));
      return;
    }
    throw new IllegalStateException("Derivation of GLV Type B parameters failed unexpectedly");
  }
  
  private static void printProperty(String paramString, Object paramObject)
  {
    StringBuffer localStringBuffer = new StringBuffer("  ");
    localStringBuffer.append(paramString);
    while (localStringBuffer.length() < 20) {
      localStringBuffer.append(' ');
    }
    localStringBuffer.append("= ");
    localStringBuffer.append(paramObject.toString());
    System.out.println(localStringBuffer.toString());
  }
  
  private static BigInteger roundQuotient(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    int i;
    if (paramBigInteger1.signum() != paramBigInteger2.signum()) {
      i = 1;
    } else {
      i = 0;
    }
    paramBigInteger1 = paramBigInteger1.abs();
    paramBigInteger2 = paramBigInteger2.abs();
    paramBigInteger2 = paramBigInteger1.add(paramBigInteger2.shiftRight(1)).divide(paramBigInteger2);
    paramBigInteger1 = paramBigInteger2;
    if (i != 0) {
      paramBigInteger1 = paramBigInteger2.negate();
    }
    return paramBigInteger1;
  }
  
  private static BigInteger[] solveQuadraticEquation(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    paramBigInteger2 = new ECFieldElement.Fp(paramBigInteger1, paramBigInteger2.multiply(paramBigInteger2).subtract(paramBigInteger3.shiftLeft(2)).mod(paramBigInteger1)).sqrt().toBigInteger();
    paramBigInteger3 = paramBigInteger1.subtract(paramBigInteger2);
    if (paramBigInteger2.testBit(0))
    {
      paramBigInteger3 = paramBigInteger3.add(paramBigInteger1);
      paramBigInteger1 = paramBigInteger2;
      paramBigInteger2 = paramBigInteger3;
    }
    else
    {
      paramBigInteger1 = paramBigInteger2.add(paramBigInteger1);
      paramBigInteger2 = paramBigInteger3;
    }
    return new BigInteger[] { paramBigInteger1.shiftRight(1), paramBigInteger2.shiftRight(1) };
  }
  
  private static void swap(BigInteger[] paramArrayOfBigInteger)
  {
    BigInteger localBigInteger = paramArrayOfBigInteger[0];
    paramArrayOfBigInteger[0] = paramArrayOfBigInteger[1];
    paramArrayOfBigInteger[1] = localBigInteger;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\tools\DiscoverEndomorphisms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */