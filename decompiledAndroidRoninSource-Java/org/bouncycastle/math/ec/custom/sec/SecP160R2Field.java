package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat160;

public class SecP160R2Field
{
  static final int[] P = { 44147, -2, -1, -1, -1 };
  private static final int P4 = -1;
  static final int[] PExt = { 457489321, 42778, 1, 0, 0, -42778, -3, -1, -1, -1 };
  private static final int PExt9 = -1;
  private static final int[] PExtInv = { -457489321, -42779, -2, -1, -1, 42777, 2 };
  private static final int PInv33 = 21389;
  
  public static void add(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat160.add(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[4] == -1) && (Nat160.gte(paramArrayOfInt3, P)))) {
      Nat.add33To(5, 21389, paramArrayOfInt3);
    }
  }
  
  public static void addExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat.add(10, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[9] == -1) && (Nat.gte(10, paramArrayOfInt3, PExt))))
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.addTo(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.incAt(10, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void addOne(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.inc(5, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[4] == -1) && (Nat160.gte(paramArrayOfInt2, P)))) {
      Nat.add33To(5, 21389, paramArrayOfInt2);
    }
  }
  
  public static int[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat160.fromBigInteger(paramBigInteger);
    if ((paramBigInteger[4] == -1) && (Nat160.gte(paramBigInteger, P))) {
      Nat160.subFrom(P, paramBigInteger);
    }
    return paramBigInteger;
  }
  
  public static void half(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1[0] & 0x1) == 0)
    {
      Nat.shiftDownBit(5, paramArrayOfInt1, 0, paramArrayOfInt2);
      return;
    }
    Nat.shiftDownBit(5, paramArrayOfInt2, Nat160.add(paramArrayOfInt1, P, paramArrayOfInt2));
  }
  
  public static void multiply(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = Nat160.createExt();
    Nat160.mul(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void multiplyAddToExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat160.mulAddTo(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[9] == -1) && (Nat.gte(10, paramArrayOfInt3, PExt))))
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.addTo(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.incAt(10, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void negate(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (Nat160.isZero(paramArrayOfInt1))
    {
      Nat160.zero(paramArrayOfInt2);
      return;
    }
    Nat160.sub(P, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static void reduce(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat160.mul33DWordAdd(21389, Nat160.mul33Add(21389, paramArrayOfInt1, 5, paramArrayOfInt1, 0, paramArrayOfInt2, 0), paramArrayOfInt2, 0) != 0) || ((paramArrayOfInt2[4] == -1) && (Nat160.gte(paramArrayOfInt2, P)))) {
      Nat.add33To(5, 21389, paramArrayOfInt2);
    }
  }
  
  public static void reduce32(int paramInt, int[] paramArrayOfInt)
  {
    if (((paramInt != 0) && (Nat160.mul33WordAdd(21389, paramInt, paramArrayOfInt, 0) != 0)) || ((paramArrayOfInt[4] == -1) && (Nat160.gte(paramArrayOfInt, P)))) {
      Nat.add33To(5, 21389, paramArrayOfInt);
    }
  }
  
  public static void square(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat160.createExt();
    Nat160.square(paramArrayOfInt1, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void squareN(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat160.createExt();
    Nat160.square(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      reduce(arrayOfInt, paramArrayOfInt2);
      paramInt -= 1;
      if (paramInt <= 0) {
        break;
      }
      Nat160.square(paramArrayOfInt2, arrayOfInt);
    }
  }
  
  public static void subtract(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat160.sub(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      Nat.sub33From(5, 21389, paramArrayOfInt3);
    }
  }
  
  public static void subtractExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat.sub(10, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0)
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.subFrom(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.decAt(10, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void twice(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.shiftUpBit(5, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[4] == -1) && (Nat160.gte(paramArrayOfInt2, P)))) {
      Nat.add33To(5, 21389, paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP160R2Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */