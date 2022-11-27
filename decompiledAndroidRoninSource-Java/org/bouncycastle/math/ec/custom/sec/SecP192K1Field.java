package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;

public class SecP192K1Field
{
  static final int[] P = { 60983, -2, -1, -1, -1, -1 };
  private static final int P5 = -1;
  static final int[] PExt = { 20729809, 9106, 1, 0, 0, 0, 56430, -3, -1, -1, -1, -1 };
  private static final int PExt11 = -1;
  private static final int[] PExtInv = { -20729809, 56429, -2, -1, -1, -1, 9105, 2 };
  private static final int PInv33 = 4553;
  
  public static void add(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat192.add(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[5] == -1) && (Nat192.gte(paramArrayOfInt3, P)))) {
      Nat.add33To(6, 4553, paramArrayOfInt3);
    }
  }
  
  public static void addExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat.add(12, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[11] == -1) && (Nat.gte(12, paramArrayOfInt3, PExt))))
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.addTo(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.incAt(12, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void addOne(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.inc(6, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[5] == -1) && (Nat192.gte(paramArrayOfInt2, P)))) {
      Nat.add33To(6, 4553, paramArrayOfInt2);
    }
  }
  
  public static int[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat192.fromBigInteger(paramBigInteger);
    if ((paramBigInteger[5] == -1) && (Nat192.gte(paramBigInteger, P))) {
      Nat192.subFrom(P, paramBigInteger);
    }
    return paramBigInteger;
  }
  
  public static void half(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1[0] & 0x1) == 0)
    {
      Nat.shiftDownBit(6, paramArrayOfInt1, 0, paramArrayOfInt2);
      return;
    }
    Nat.shiftDownBit(6, paramArrayOfInt2, Nat192.add(paramArrayOfInt1, P, paramArrayOfInt2));
  }
  
  public static void multiply(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = Nat192.createExt();
    Nat192.mul(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void multiplyAddToExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat192.mulAddTo(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[11] == -1) && (Nat.gte(12, paramArrayOfInt3, PExt))))
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.addTo(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.incAt(12, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void negate(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (Nat192.isZero(paramArrayOfInt1))
    {
      Nat192.zero(paramArrayOfInt2);
      return;
    }
    Nat192.sub(P, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static void reduce(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat192.mul33DWordAdd(4553, Nat192.mul33Add(4553, paramArrayOfInt1, 6, paramArrayOfInt1, 0, paramArrayOfInt2, 0), paramArrayOfInt2, 0) != 0) || ((paramArrayOfInt2[5] == -1) && (Nat192.gte(paramArrayOfInt2, P)))) {
      Nat.add33To(6, 4553, paramArrayOfInt2);
    }
  }
  
  public static void reduce32(int paramInt, int[] paramArrayOfInt)
  {
    if (((paramInt != 0) && (Nat192.mul33WordAdd(4553, paramInt, paramArrayOfInt, 0) != 0)) || ((paramArrayOfInt[5] == -1) && (Nat192.gte(paramArrayOfInt, P)))) {
      Nat.add33To(6, 4553, paramArrayOfInt);
    }
  }
  
  public static void square(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat192.createExt();
    Nat192.square(paramArrayOfInt1, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void squareN(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat192.createExt();
    Nat192.square(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      reduce(arrayOfInt, paramArrayOfInt2);
      paramInt -= 1;
      if (paramInt <= 0) {
        break;
      }
      Nat192.square(paramArrayOfInt2, arrayOfInt);
    }
  }
  
  public static void subtract(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat192.sub(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      Nat.sub33From(6, 4553, paramArrayOfInt3);
    }
  }
  
  public static void subtractExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat.sub(12, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0)
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.subFrom(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.decAt(12, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void twice(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.shiftUpBit(6, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[5] == -1) && (Nat192.gte(paramArrayOfInt2, P)))) {
      Nat.add33To(6, 4553, paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP192K1Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */