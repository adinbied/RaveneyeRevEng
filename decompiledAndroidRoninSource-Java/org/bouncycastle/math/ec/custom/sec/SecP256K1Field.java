package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;

public class SecP256K1Field
{
  static final int[] P = { 64559, -2, -1, -1, -1, -1, -1, -1 };
  private static final int P7 = -1;
  static final int[] PExt = { 954529, 1954, 1, 0, 0, 0, 0, 0, 63582, -3, -1, -1, -1, -1, -1, -1 };
  private static final int PExt15 = -1;
  private static final int[] PExtInv = { -954529, 63581, -2, -1, -1, -1, -1, -1, 1953, 2 };
  private static final int PInv33 = 977;
  
  public static void add(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat256.add(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[7] == -1) && (Nat256.gte(paramArrayOfInt3, P)))) {
      Nat.add33To(8, 977, paramArrayOfInt3);
    }
  }
  
  public static void addExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat.add(16, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[15] == -1) && (Nat.gte(16, paramArrayOfInt3, PExt))))
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.addTo(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.incAt(16, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void addOne(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.inc(8, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[7] == -1) && (Nat256.gte(paramArrayOfInt2, P)))) {
      Nat.add33To(8, 977, paramArrayOfInt2);
    }
  }
  
  public static int[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat256.fromBigInteger(paramBigInteger);
    if ((paramBigInteger[7] == -1) && (Nat256.gte(paramBigInteger, P))) {
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
    Nat.shiftDownBit(8, paramArrayOfInt2, Nat256.add(paramArrayOfInt1, P, paramArrayOfInt2));
  }
  
  public static void multiply(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = Nat256.createExt();
    Nat256.mul(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void multiplyAddToExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat256.mulAddTo(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[15] == -1) && (Nat.gte(16, paramArrayOfInt3, PExt))))
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.addTo(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.incAt(16, paramArrayOfInt3, PExtInv.length);
      }
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
    if ((Nat256.mul33DWordAdd(977, Nat256.mul33Add(977, paramArrayOfInt1, 8, paramArrayOfInt1, 0, paramArrayOfInt2, 0), paramArrayOfInt2, 0) != 0) || ((paramArrayOfInt2[7] == -1) && (Nat256.gte(paramArrayOfInt2, P)))) {
      Nat.add33To(8, 977, paramArrayOfInt2);
    }
  }
  
  public static void reduce32(int paramInt, int[] paramArrayOfInt)
  {
    if (((paramInt != 0) && (Nat256.mul33WordAdd(977, paramInt, paramArrayOfInt, 0) != 0)) || ((paramArrayOfInt[7] == -1) && (Nat256.gte(paramArrayOfInt, P)))) {
      Nat.add33To(8, 977, paramArrayOfInt);
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
  
  public static void subtract(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat256.sub(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      Nat.sub33From(8, 977, paramArrayOfInt3);
    }
  }
  
  public static void subtractExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat.sub(16, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0)
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.subFrom(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.decAt(16, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void twice(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.shiftUpBit(8, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[7] == -1) && (Nat256.gte(paramArrayOfInt2, P)))) {
      Nat.add33To(8, 977, paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP256K1Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */