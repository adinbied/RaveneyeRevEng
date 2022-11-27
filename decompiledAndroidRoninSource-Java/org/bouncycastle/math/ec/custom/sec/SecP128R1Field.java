package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat128;
import org.bouncycastle.math.raw.Nat256;

public class SecP128R1Field
{
  private static final long M = 4294967295L;
  static final int[] P = { -1, -1, -1, -3 };
  private static final int P3 = -3;
  static final int[] PExt = { 1, 0, 0, 4, -2, -1, 3, -4 };
  private static final int PExt7 = -4;
  private static final int[] PExtInv = { -1, -1, -1, -5, 1, 0, -4, 3 };
  
  public static void add(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat128.add(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[3] == -3) && (Nat128.gte(paramArrayOfInt3, P)))) {
      addPInvTo(paramArrayOfInt3);
    }
  }
  
  public static void addExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat256.add(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[7] == -4) && (Nat256.gte(paramArrayOfInt3, PExt))))
    {
      paramArrayOfInt1 = PExtInv;
      Nat.addTo(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3);
    }
  }
  
  public static void addOne(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.inc(4, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[3] == -3) && (Nat128.gte(paramArrayOfInt2, P)))) {
      addPInvTo(paramArrayOfInt2);
    }
  }
  
  private static void addPInvTo(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) + 1L;
    paramArrayOfInt[0] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L)
    {
      l1 = l2 + (paramArrayOfInt[1] & 0xFFFFFFFF);
      paramArrayOfInt[1] = ((int)l1);
      l1 = (l1 >> 32) + (paramArrayOfInt[2] & 0xFFFFFFFF);
      paramArrayOfInt[2] = ((int)l1);
      l1 >>= 32;
    }
    paramArrayOfInt[3] = ((int)(l1 + ((0xFFFFFFFF & paramArrayOfInt[3]) + 2L)));
  }
  
  public static int[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat128.fromBigInteger(paramBigInteger);
    if ((paramBigInteger[3] == -3) && (Nat128.gte(paramBigInteger, P))) {
      Nat128.subFrom(P, paramBigInteger);
    }
    return paramBigInteger;
  }
  
  public static void half(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1[0] & 0x1) == 0)
    {
      Nat.shiftDownBit(4, paramArrayOfInt1, 0, paramArrayOfInt2);
      return;
    }
    Nat.shiftDownBit(4, paramArrayOfInt2, Nat128.add(paramArrayOfInt1, P, paramArrayOfInt2));
  }
  
  public static void multiply(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = Nat128.createExt();
    Nat128.mul(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void multiplyAddToExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat128.mulAddTo(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[7] == -4) && (Nat256.gte(paramArrayOfInt3, PExt))))
    {
      paramArrayOfInt1 = PExtInv;
      Nat.addTo(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3);
    }
  }
  
  public static void negate(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (Nat128.isZero(paramArrayOfInt1))
    {
      Nat128.zero(paramArrayOfInt2);
      return;
    }
    Nat128.sub(P, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static void reduce(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l6 = paramArrayOfInt1[0];
    long l4 = paramArrayOfInt1[1];
    long l3 = paramArrayOfInt1[2];
    long l1 = paramArrayOfInt1[3];
    long l7 = paramArrayOfInt1[4];
    long l8 = paramArrayOfInt1[5];
    long l5 = paramArrayOfInt1[6];
    long l2 = paramArrayOfInt1[7] & 0xFFFFFFFF;
    l5 = (l5 & 0xFFFFFFFF) + (l2 << 1);
    l8 = (l8 & 0xFFFFFFFF) + (l5 << 1);
    l7 = (l7 & 0xFFFFFFFF) + (l8 << 1);
    l6 = (l6 & 0xFFFFFFFF) + l7;
    paramArrayOfInt2[0] = ((int)l6);
    l4 = (l4 & 0xFFFFFFFF) + l8 + (l6 >>> 32);
    paramArrayOfInt2[1] = ((int)l4);
    l3 = (l3 & 0xFFFFFFFF) + l5 + (l4 >>> 32);
    paramArrayOfInt2[2] = ((int)l3);
    l1 = (l1 & 0xFFFFFFFF) + l2 + (l7 << 1) + (l3 >>> 32);
    paramArrayOfInt2[3] = ((int)l1);
    reduce32((int)(l1 >>> 32), paramArrayOfInt2);
  }
  
  public static void reduce32(int paramInt, int[] paramArrayOfInt)
  {
    while (paramInt != 0)
    {
      long l3 = paramInt & 0xFFFFFFFF;
      long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) + l3;
      paramArrayOfInt[0] = ((int)l1);
      long l2 = l1 >> 32;
      l1 = l2;
      if (l2 != 0L)
      {
        l1 = l2 + (paramArrayOfInt[1] & 0xFFFFFFFF);
        paramArrayOfInt[1] = ((int)l1);
        l1 = (l1 >> 32) + (paramArrayOfInt[2] & 0xFFFFFFFF);
        paramArrayOfInt[2] = ((int)l1);
        l1 >>= 32;
      }
      l1 += (0xFFFFFFFF & paramArrayOfInt[3]) + (l3 << 1);
      paramArrayOfInt[3] = ((int)l1);
      paramInt = (int)(l1 >> 32);
    }
  }
  
  public static void square(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat128.createExt();
    Nat128.square(paramArrayOfInt1, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void squareN(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat128.createExt();
    Nat128.square(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      reduce(arrayOfInt, paramArrayOfInt2);
      paramInt -= 1;
      if (paramInt <= 0) {
        break;
      }
      Nat128.square(paramArrayOfInt2, arrayOfInt);
    }
  }
  
  private static void subPInvFrom(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) - 1L;
    paramArrayOfInt[0] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L)
    {
      l1 = l2 + (paramArrayOfInt[1] & 0xFFFFFFFF);
      paramArrayOfInt[1] = ((int)l1);
      l1 = (l1 >> 32) + (paramArrayOfInt[2] & 0xFFFFFFFF);
      paramArrayOfInt[2] = ((int)l1);
      l1 >>= 32;
    }
    paramArrayOfInt[3] = ((int)(l1 + ((0xFFFFFFFF & paramArrayOfInt[3]) - 2L)));
  }
  
  public static void subtract(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat128.sub(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      subPInvFrom(paramArrayOfInt3);
    }
  }
  
  public static void subtractExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat.sub(10, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0)
    {
      paramArrayOfInt1 = PExtInv;
      Nat.subFrom(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3);
    }
  }
  
  public static void twice(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.shiftUpBit(4, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[3] == -3) && (Nat128.gte(paramArrayOfInt2, P)))) {
      addPInvTo(paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP128R1Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */