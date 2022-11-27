package org.bouncycastle.math.field;

import java.math.BigInteger;

public abstract class FiniteFields
{
  static final FiniteField GF_2 = new PrimeField(BigInteger.valueOf(2L));
  static final FiniteField GF_3 = new PrimeField(BigInteger.valueOf(3L));
  
  public static PolynomialExtensionField getBinaryExtensionField(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt[0] == 0)
    {
      int i = 1;
      while (i < paramArrayOfInt.length) {
        if (paramArrayOfInt[i] > paramArrayOfInt[(i - 1)]) {
          i += 1;
        } else {
          throw new IllegalArgumentException("Polynomial exponents must be montonically increasing");
        }
      }
      return new GenericPolynomialExtensionField(GF_2, new GF2Polynomial(paramArrayOfInt));
    }
    throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
  }
  
  public static FiniteField getPrimeField(BigInteger paramBigInteger)
  {
    int i = paramBigInteger.bitLength();
    if ((paramBigInteger.signum() > 0) && (i >= 2))
    {
      if (i < 3)
      {
        i = paramBigInteger.intValue();
        if (i != 2)
        {
          if (i == 3) {
            return GF_3;
          }
        }
        else {
          return GF_2;
        }
      }
      return new PrimeField(paramBigInteger);
    }
    throw new IllegalArgumentException("'characteristic' must be >= 2");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\field\FiniteFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */