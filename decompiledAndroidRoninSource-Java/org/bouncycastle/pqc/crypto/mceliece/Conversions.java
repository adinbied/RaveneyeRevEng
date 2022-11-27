package org.bouncycastle.pqc.crypto.mceliece;

import java.math.BigInteger;
import org.bouncycastle.pqc.math.linearalgebra.BigIntUtils;
import org.bouncycastle.pqc.math.linearalgebra.GF2Vector;
import org.bouncycastle.pqc.math.linearalgebra.IntegerFunctions;

final class Conversions
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private static final BigInteger ZERO = BigInteger.valueOf(0L);
  
  public static byte[] decode(int paramInt1, int paramInt2, GF2Vector paramGF2Vector)
  {
    if ((paramGF2Vector.getLength() == paramInt1) && (paramGF2Vector.getHammingWeight() == paramInt2))
    {
      int[] arrayOfInt = paramGF2Vector.getVecArray();
      paramGF2Vector = IntegerFunctions.binomial(paramInt1, paramInt2);
      Object localObject1 = ZERO;
      int i = 0;
      int k = paramInt1;
      while (i < paramInt1)
      {
        BigInteger localBigInteger = paramGF2Vector.multiply(BigInteger.valueOf(k - paramInt2)).divide(BigInteger.valueOf(k));
        k -= 1;
        paramGF2Vector = localBigInteger;
        Object localObject2 = localObject1;
        int j = paramInt2;
        if ((arrayOfInt[(i >> 5)] & 1 << (i & 0x1F)) != 0)
        {
          localObject2 = ((BigInteger)localObject1).add(localBigInteger);
          j = paramInt2 - 1;
          if (k == j) {
            paramGF2Vector = ONE;
          } else {
            paramGF2Vector = localBigInteger.multiply(BigInteger.valueOf(j + 1)).divide(BigInteger.valueOf(k - j));
          }
        }
        i += 1;
        localObject1 = localObject2;
        paramInt2 = j;
      }
      return BigIntUtils.toMinimalByteArray((BigInteger)localObject1);
    }
    throw new IllegalArgumentException("vector has wrong length or hamming weight");
  }
  
  public static GF2Vector encode(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramInt1 >= paramInt2)
    {
      Object localObject2 = IntegerFunctions.binomial(paramInt1, paramInt2);
      Object localObject1 = new BigInteger(1, paramArrayOfByte);
      if (((BigInteger)localObject1).compareTo((BigInteger)localObject2) < 0)
      {
        GF2Vector localGF2Vector = new GF2Vector(paramInt1);
        int i = 0;
        int k = paramInt1;
        paramArrayOfByte = (byte[])localObject2;
        while (i < paramInt1)
        {
          BigInteger localBigInteger = paramArrayOfByte.multiply(BigInteger.valueOf(k - paramInt2)).divide(BigInteger.valueOf(k));
          k -= 1;
          paramArrayOfByte = localBigInteger;
          localObject2 = localObject1;
          int j = paramInt2;
          if (localBigInteger.compareTo((BigInteger)localObject1) <= 0)
          {
            localGF2Vector.setBit(i);
            localObject2 = ((BigInteger)localObject1).subtract(localBigInteger);
            j = paramInt2 - 1;
            if (k == j) {
              paramArrayOfByte = ONE;
            } else {
              paramArrayOfByte = localBigInteger.multiply(BigInteger.valueOf(j + 1)).divide(BigInteger.valueOf(k - j));
            }
          }
          i += 1;
          localObject1 = localObject2;
          paramInt2 = j;
        }
        return localGF2Vector;
      }
      throw new IllegalArgumentException("Encoded number too large.");
    }
    throw new IllegalArgumentException("n < t");
  }
  
  public static byte[] signConversion(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramInt1 >= paramInt2)
    {
      Object localObject2 = IntegerFunctions.binomial(paramInt1, paramInt2);
      int i = ((BigInteger)localObject2).bitLength() - 1;
      int m = i >> 3;
      int n = i & 0x7;
      int k = 8;
      int j = n;
      i = m;
      if (n == 0)
      {
        i = m - 1;
        j = 8;
      }
      m = paramInt1 >> 3;
      n = paramInt1 & 0x7;
      if (n == 0) {
        m -= 1;
      } else {
        k = n;
      }
      n = m + 1;
      byte[] arrayOfByte = new byte[n];
      if (paramArrayOfByte.length < n)
      {
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
        k = paramArrayOfByte.length;
        while (k < n)
        {
          arrayOfByte[k] = 0;
          k += 1;
        }
      }
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, m);
      arrayOfByte[m] = ((byte)(paramArrayOfByte[m] & (1 << k) - 1));
      Object localObject1 = ZERO;
      n = paramInt1;
      k = 0;
      paramArrayOfByte = (byte[])localObject2;
      while (k < paramInt1)
      {
        BigInteger localBigInteger = paramArrayOfByte.multiply(new BigInteger(Integer.toString(n - paramInt2))).divide(new BigInteger(Integer.toString(n)));
        n -= 1;
        paramArrayOfByte = localBigInteger;
        m = paramInt2;
        localObject2 = localObject1;
        if ((byte)(arrayOfByte[(k >>> 3)] & 1 << (k & 0x7)) != 0)
        {
          localObject2 = ((BigInteger)localObject1).add(localBigInteger);
          m = paramInt2 - 1;
          if (n == m) {
            paramArrayOfByte = ONE;
          } else {
            paramArrayOfByte = localBigInteger.multiply(new BigInteger(Integer.toString(m + 1))).divide(new BigInteger(Integer.toString(n - m)));
          }
        }
        k += 1;
        paramInt2 = m;
        localObject1 = localObject2;
      }
      paramInt2 = i + 1;
      paramArrayOfByte = new byte[paramInt2];
      localObject1 = ((BigInteger)localObject1).toByteArray();
      if (localObject1.length < paramInt2)
      {
        System.arraycopy(localObject1, 0, paramArrayOfByte, 0, localObject1.length);
        paramInt1 = localObject1.length;
        while (paramInt1 < paramInt2)
        {
          paramArrayOfByte[paramInt1] = 0;
          paramInt1 += 1;
        }
      }
      System.arraycopy(localObject1, 0, paramArrayOfByte, 0, i);
      paramArrayOfByte[i] = ((byte)((1 << j) - 1 & localObject1[i]));
      return paramArrayOfByte;
    }
    throw new IllegalArgumentException("n < t");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\Conversions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */