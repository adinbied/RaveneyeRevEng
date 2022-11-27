package org.bouncycastle.math.ec.custom.djb;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;

public class Curve25519Field
{
  private static final long M = 4294967295L;
  static final int[] P = { -19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE };
  private static final int P7 = Integer.MAX_VALUE;
  private static final int[] PExt = { 361, 0, 0, 0, 0, 0, 0, 0, -19, -1, -1, -1, -1, -1, -1, 1073741823 };
  private static final int PInv = 19;
  
  public static void add(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    Nat256.add(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    if (Nat256.gte(paramArrayOfInt3, P)) {
      subPFrom(paramArrayOfInt3);
    }
  }
  
  public static void addExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    Nat.add(16, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    if (Nat.gte(16, paramArrayOfInt3, PExt)) {
      subPExtFrom(paramArrayOfInt3);
    }
  }
  
  public static void addOne(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Nat.inc(8, paramArrayOfInt1, paramArrayOfInt2);
    if (Nat256.gte(paramArrayOfInt2, P)) {
      subPFrom(paramArrayOfInt2);
    }
  }
  
  private static int addPExtTo(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) + (PExt[0] & 0xFFFFFFFF);
    paramArrayOfInt[0] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L) {
      l1 = Nat.incAt(8, paramArrayOfInt, 1);
    }
    l1 += (paramArrayOfInt[8] & 0xFFFFFFFF) - 19L;
    paramArrayOfInt[8] = ((int)l1);
    l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L) {
      l1 = Nat.decAt(15, paramArrayOfInt, 9);
    }
    l1 += (paramArrayOfInt[15] & 0xFFFFFFFF) + (0xFFFFFFFF & PExt[15] + 1);
    paramArrayOfInt[15] = ((int)l1);
    return (int)(l1 >> 32);
  }
  
  private static int addPTo(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) - 19L;
    paramArrayOfInt[0] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L) {
      l1 = Nat.decAt(7, paramArrayOfInt, 1);
    }
    l1 += (0xFFFFFFFF & paramArrayOfInt[7]) + 2147483648L;
    paramArrayOfInt[7] = ((int)l1);
    return (int)(l1 >> 32);
  }
  
  public static int[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat256.fromBigInteger(paramBigInteger);
    while (Nat256.gte(paramBigInteger, P)) {
      Nat256.subFrom(P, paramBigInteger);
    }
    return paramBigInteger;
  }
  
  public static void half(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1[0] & 0x1) == 0)
    {
      Nat.shiftDownBit(8, paramArrayOfInt1, 0, paramArrayOfInt2);
      return;
    }
    Nat256.add(paramArrayOfInt1, P, paramArrayOfInt2);
    Nat.shiftDownBit(8, paramArrayOfInt2, 0);
  }
  
  public static void multiply(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = Nat256.createExt();
    Nat256.mul(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void multiplyAddToExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    Nat256.mulAddTo(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    if (Nat.gte(16, paramArrayOfInt3, PExt)) {
      subPExtFrom(paramArrayOfInt3);
    }
  }
  
  public static void negate(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (Nat256.isZero(paramArrayOfInt1))
    {
      Nat256.zero(paramArrayOfInt2);
      return;
    }
    Nat256.sub(P, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static void reduce(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = paramArrayOfInt1[7];
    Nat.shiftUpBit(8, paramArrayOfInt1, 8, i, paramArrayOfInt2, 0);
    int j = Nat256.mulByWordAddTo(19, paramArrayOfInt1, paramArrayOfInt2);
    int k = paramArrayOfInt2[7];
    paramArrayOfInt2[7] = ((k & 0x7FFFFFFF) + Nat.addWordTo(7, ((j << 1) + ((k >>> 31) - (i >>> 31))) * 19, paramArrayOfInt2));
    if (Nat256.gte(paramArrayOfInt2, P)) {
      subPFrom(paramArrayOfInt2);
    }
  }
  
  public static void reduce27(int paramInt, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[7];
    paramArrayOfInt[7] = ((i & 0x7FFFFFFF) + Nat.addWordTo(7, (paramInt << 1 | i >>> 31) * 19, paramArrayOfInt));
    if (Nat256.gte(paramArrayOfInt, P)) {
      subPFrom(paramArrayOfInt);
    }
  }
  
  public static void square(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat256.createExt();
    Nat256.square(paramArrayOfInt1, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void squareN(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat256.createExt();
    Nat256.square(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      reduce(arrayOfInt, paramArrayOfInt2);
      paramInt -= 1;
      if (paramInt <= 0) {
        break;
      }
      Nat256.square(paramArrayOfInt2, arrayOfInt);
    }
  }
  
  private static int subPExtFrom(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) - (PExt[0] & 0xFFFFFFFF);
    paramArrayOfInt[0] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L) {
      l1 = Nat.decAt(8, paramArrayOfInt, 1);
    }
    l1 += (paramArrayOfInt[8] & 0xFFFFFFFF) + 19L;
    paramArrayOfInt[8] = ((int)l1);
    l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L) {
      l1 = Nat.incAt(15, paramArrayOfInt, 9);
    }
    l1 += (paramArrayOfInt[15] & 0xFFFFFFFF) - (0xFFFFFFFF & PExt[15] + 1);
    paramArrayOfInt[15] = ((int)l1);
    return (int)(l1 >> 32);
  }
  
  private static int subPFrom(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) + 19L;
    paramArrayOfInt[0] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L) {
      l1 = Nat.incAt(7, paramArrayOfInt, 1);
    }
    l1 += (0xFFFFFFFF & paramArrayOfInt[7]) - 2147483648L;
    paramArrayOfInt[7] = ((int)l1);
    return (int)(l1 >> 32);
  }
  
  public static void subtract(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat256.sub(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      addPTo(paramArrayOfInt3);
    }
  }
  
  public static void subtractExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat.sub(16, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      addPExtTo(paramArrayOfInt3);
    }
  }
  
  public static void twice(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Nat.shiftUpBit(8, paramArrayOfInt1, 0, paramArrayOfInt2);
    if (Nat256.gte(paramArrayOfInt2, P)) {
      subPFrom(paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\djb\Curve25519Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */