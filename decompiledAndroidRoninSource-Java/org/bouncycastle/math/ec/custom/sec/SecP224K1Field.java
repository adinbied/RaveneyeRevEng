package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat224;

public class SecP224K1Field
{
  static final int[] P = { 58733, -2, -1, -1, -1, -1, -1 };
  private static final int P6 = -1;
  static final int[] PExt = { 46280809, 13606, 1, 0, 0, 0, 0, 51930, -3, -1, -1, -1, -1, -1 };
  private static final int PExt13 = -1;
  private static final int[] PExtInv = { -46280809, 51929, -2, -1, -1, -1, -1, 13605, 2 };
  private static final int PInv33 = 6803;
  
  public static void add(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat224.add(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[6] == -1) && (Nat224.gte(paramArrayOfInt3, P)))) {
      Nat.add33To(7, 6803, paramArrayOfInt3);
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
      Nat.add33To(7, 6803, paramArrayOfInt2);
    }
  }
  
  public static int[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat224.fromBigInteger(paramBigInteger);
    if ((paramBigInteger[6] == -1) && (Nat224.gte(paramBigInteger, P))) {
      Nat.add33To(7, 6803, paramBigInteger);
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
    if ((Nat224.mul33DWordAdd(6803, Nat224.mul33Add(6803, paramArrayOfInt1, 7, paramArrayOfInt1, 0, paramArrayOfInt2, 0), paramArrayOfInt2, 0) != 0) || ((paramArrayOfInt2[6] == -1) && (Nat224.gte(paramArrayOfInt2, P)))) {
      Nat.add33To(7, 6803, paramArrayOfInt2);
    }
  }
  
  public static void reduce32(int paramInt, int[] paramArrayOfInt)
  {
    if (((paramInt != 0) && (Nat224.mul33WordAdd(6803, paramInt, paramArrayOfInt, 0) != 0)) || ((paramArrayOfInt[6] == -1) && (Nat224.gte(paramArrayOfInt, P)))) {
      Nat.add33To(7, 6803, paramArrayOfInt);
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
  
  public static void subtract(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat224.sub(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      Nat.sub33From(7, 6803, paramArrayOfInt3);
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
      Nat.add33To(7, 6803, paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP224K1Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */