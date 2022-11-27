package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat512;

public class SecP521R1Field
{
  static final int[] P = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 511 };
  private static final int P16 = 511;
  
  public static void add(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int j = Nat.add(16, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) + paramArrayOfInt1[16] + paramArrayOfInt2[16];
    int i;
    if (j <= 511)
    {
      i = j;
      if (j == 511)
      {
        i = j;
        if (!Nat.eq(16, paramArrayOfInt3, P)) {}
      }
    }
    else
    {
      i = j + Nat.inc(16, paramArrayOfInt3) & 0x1FF;
    }
    paramArrayOfInt3[16] = i;
  }
  
  public static void addOne(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int j = Nat.inc(16, paramArrayOfInt1, paramArrayOfInt2) + paramArrayOfInt1[16];
    int i;
    if (j <= 511)
    {
      i = j;
      if (j == 511)
      {
        i = j;
        if (!Nat.eq(16, paramArrayOfInt2, P)) {}
      }
    }
    else
    {
      i = j + Nat.inc(16, paramArrayOfInt2) & 0x1FF;
    }
    paramArrayOfInt2[16] = i;
  }
  
  public static int[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat.fromBigInteger(521, paramBigInteger);
    if (Nat.eq(17, paramBigInteger, P)) {
      Nat.zero(17, paramBigInteger);
    }
    return paramBigInteger;
  }
  
  public static void half(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = paramArrayOfInt1[16];
    paramArrayOfInt2[16] = (Nat.shiftDownBit(16, paramArrayOfInt1, i, paramArrayOfInt2) >>> 23 | i >>> 1);
  }
  
  protected static void implMultiply(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    Nat512.mul(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    int i = paramArrayOfInt1[16];
    int j = paramArrayOfInt2[16];
    paramArrayOfInt3[32] = (Nat.mul31BothAdd(16, i, paramArrayOfInt2, j, paramArrayOfInt1, paramArrayOfInt3, 16) + i * j);
  }
  
  protected static void implSquare(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Nat512.square(paramArrayOfInt1, paramArrayOfInt2);
    int i = paramArrayOfInt1[16];
    paramArrayOfInt2[32] = (Nat.mulWordAddTo(16, i << 1, paramArrayOfInt1, 0, paramArrayOfInt2, 16) + i * i);
  }
  
  public static void multiply(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = Nat.create(33);
    implMultiply(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void negate(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (Nat.isZero(17, paramArrayOfInt1))
    {
      Nat.zero(17, paramArrayOfInt2);
      return;
    }
    Nat.sub(17, P, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static void reduce(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = paramArrayOfInt1[32];
    int j = (Nat.shiftDownBits(16, paramArrayOfInt1, 16, 9, i, paramArrayOfInt2, 0) >>> 23) + (i >>> 9) + Nat.addTo(16, paramArrayOfInt1, paramArrayOfInt2);
    if (j <= 511)
    {
      i = j;
      if (j == 511)
      {
        i = j;
        if (!Nat.eq(16, paramArrayOfInt2, P)) {}
      }
    }
    else
    {
      i = j + Nat.inc(16, paramArrayOfInt2) & 0x1FF;
    }
    paramArrayOfInt2[16] = i;
  }
  
  public static void reduce23(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[16];
    int j = Nat.addWordTo(16, i >>> 9, paramArrayOfInt) + (i & 0x1FF);
    if (j <= 511)
    {
      i = j;
      if (j == 511)
      {
        i = j;
        if (!Nat.eq(16, paramArrayOfInt, P)) {}
      }
    }
    else
    {
      i = j + Nat.inc(16, paramArrayOfInt) & 0x1FF;
    }
    paramArrayOfInt[16] = i;
  }
  
  public static void square(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat.create(33);
    implSquare(paramArrayOfInt1, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void squareN(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat.create(33);
    implSquare(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      reduce(arrayOfInt, paramArrayOfInt2);
      paramInt -= 1;
      if (paramInt <= 0) {
        break;
      }
      implSquare(paramArrayOfInt2, arrayOfInt);
    }
  }
  
  public static void subtract(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int j = Nat.sub(16, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) + paramArrayOfInt1[16] - paramArrayOfInt2[16];
    int i = j;
    if (j < 0) {
      i = j + Nat.dec(16, paramArrayOfInt3) & 0x1FF;
    }
    paramArrayOfInt3[16] = i;
  }
  
  public static void twice(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = paramArrayOfInt1[16];
    paramArrayOfInt2[16] = ((Nat.shiftUpBit(16, paramArrayOfInt1, i << 23, paramArrayOfInt2) | i << 1) & 0x1FF);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP521R1Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */