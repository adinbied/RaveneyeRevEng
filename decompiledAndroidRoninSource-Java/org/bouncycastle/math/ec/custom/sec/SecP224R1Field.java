package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat224;

public class SecP224R1Field
{
  private static final long M = 4294967295L;
  static final int[] P = { 1, 0, 0, -1, -1, -1, -1 };
  private static final int P6 = -1;
  static final int[] PExt = { 1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1 };
  private static final int PExt13 = -1;
  private static final int[] PExtInv = { -1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1 };
  
  public static void add(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat224.add(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[6] == -1) && (Nat224.gte(paramArrayOfInt3, P)))) {
      addPInvTo(paramArrayOfInt3);
    }
  }
  
  public static void addExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat.add(14, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[13] == -1) && (Nat.gte(14, paramArrayOfInt3, PExt))))
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.addTo(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.incAt(14, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void addOne(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.inc(7, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[6] == -1) && (Nat224.gte(paramArrayOfInt2, P)))) {
      addPInvTo(paramArrayOfInt2);
    }
  }
  
  private static void addPInvTo(int[] paramArrayOfInt)
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
    l1 += (0xFFFFFFFF & paramArrayOfInt[3]) + 1L;
    paramArrayOfInt[3] = ((int)l1);
    if (l1 >> 32 != 0L) {
      Nat.incAt(7, paramArrayOfInt, 4);
    }
  }
  
  public static int[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat224.fromBigInteger(paramBigInteger);
    if ((paramBigInteger[6] == -1) && (Nat224.gte(paramBigInteger, P))) {
      Nat224.subFrom(P, paramBigInteger);
    }
    return paramBigInteger;
  }
  
  public static void half(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1[0] & 0x1) == 0)
    {
      Nat.shiftDownBit(7, paramArrayOfInt1, 0, paramArrayOfInt2);
      return;
    }
    Nat.shiftDownBit(7, paramArrayOfInt2, Nat224.add(paramArrayOfInt1, P, paramArrayOfInt2));
  }
  
  public static void multiply(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = Nat224.createExt();
    Nat224.mul(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void multiplyAddToExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat224.mulAddTo(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[13] == -1) && (Nat.gte(14, paramArrayOfInt3, PExt))))
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.addTo(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.incAt(14, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void negate(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (Nat224.isZero(paramArrayOfInt1))
    {
      Nat224.zero(paramArrayOfInt2);
      return;
    }
    Nat224.sub(P, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static void reduce(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l2 = paramArrayOfInt1[10] & 0xFFFFFFFF;
    long l7 = paramArrayOfInt1[11] & 0xFFFFFFFF;
    long l4 = paramArrayOfInt1[12] & 0xFFFFFFFF;
    long l3 = paramArrayOfInt1[13] & 0xFFFFFFFF;
    long l6 = (paramArrayOfInt1[7] & 0xFFFFFFFF) + l7 - 1L;
    long l8 = (paramArrayOfInt1[8] & 0xFFFFFFFF) + l4;
    long l5 = (paramArrayOfInt1[9] & 0xFFFFFFFF) + l3;
    long l1 = (paramArrayOfInt1[0] & 0xFFFFFFFF) - l6 + 0L;
    long l9 = (l1 >> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) - l8);
    paramArrayOfInt2[1] = ((int)l9);
    l9 = (l9 >> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) - l5);
    paramArrayOfInt2[2] = ((int)l9);
    l6 = (l9 >> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) + l6 - l2);
    l7 = (l6 >> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + l8 - l7);
    paramArrayOfInt2[4] = ((int)l7);
    l4 = (l7 >> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) + l5 - l4);
    paramArrayOfInt2[5] = ((int)l4);
    l2 = (l4 >> 32) + ((paramArrayOfInt1[6] & 0xFFFFFFFF) + l2 - l3);
    paramArrayOfInt2[6] = ((int)l2);
    l3 = (l2 >> 32) + 1L;
    l2 = (l6 & 0xFFFFFFFF) + l3;
    l1 = (l1 & 0xFFFFFFFF) - l3;
    paramArrayOfInt2[0] = ((int)l1);
    l3 = l1 >> 32;
    l1 = l2;
    if (l3 != 0L)
    {
      l1 = l3 + (paramArrayOfInt2[1] & 0xFFFFFFFF);
      paramArrayOfInt2[1] = ((int)l1);
      l1 = (l1 >> 32) + (0xFFFFFFFF & paramArrayOfInt2[2]);
      paramArrayOfInt2[2] = ((int)l1);
      l1 = l2 + (l1 >> 32);
    }
    paramArrayOfInt2[3] = ((int)l1);
    if (((l1 >> 32 != 0L) && (Nat.incAt(7, paramArrayOfInt2, 4) != 0)) || ((paramArrayOfInt2[6] == -1) && (Nat224.gte(paramArrayOfInt2, P)))) {
      addPInvTo(paramArrayOfInt2);
    }
  }
  
  public static void reduce32(int paramInt, int[] paramArrayOfInt)
  {
    long l1;
    if (paramInt != 0)
    {
      long l3 = paramInt & 0xFFFFFFFF;
      l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) - l3 + 0L;
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
      l1 += (0xFFFFFFFF & paramArrayOfInt[3]) + l3;
      paramArrayOfInt[3] = ((int)l1);
      l1 >>= 32;
    }
    else
    {
      l1 = 0L;
    }
    if (((l1 != 0L) && (Nat.incAt(7, paramArrayOfInt, 4) != 0)) || ((paramArrayOfInt[6] == -1) && (Nat224.gte(paramArrayOfInt, P)))) {
      addPInvTo(paramArrayOfInt);
    }
  }
  
  public static void square(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat224.createExt();
    Nat224.square(paramArrayOfInt1, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void squareN(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat224.createExt();
    Nat224.square(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      reduce(arrayOfInt, paramArrayOfInt2);
      paramInt -= 1;
      if (paramInt <= 0) {
        break;
      }
      Nat224.square(paramArrayOfInt2, arrayOfInt);
    }
  }
  
  private static void subPInvFrom(int[] paramArrayOfInt)
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
    l1 += (0xFFFFFFFF & paramArrayOfInt[3]) - 1L;
    paramArrayOfInt[3] = ((int)l1);
    if (l1 >> 32 != 0L) {
      Nat.decAt(7, paramArrayOfInt, 4);
    }
  }
  
  public static void subtract(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat224.sub(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      subPInvFrom(paramArrayOfInt3);
    }
  }
  
  public static void subtractExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat.sub(14, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0)
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.subFrom(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.decAt(14, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void twice(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.shiftUpBit(7, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[6] == -1) && (Nat224.gte(paramArrayOfInt2, P)))) {
      addPInvTo(paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP224R1Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */