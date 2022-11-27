package org.bouncycastle.math.raw;

public abstract class Nat384
{
  public static void mul(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    Nat192.mul(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    Nat192.mul(paramArrayOfInt1, 6, paramArrayOfInt2, 6, paramArrayOfInt3, 12);
    int j = Nat192.addToEachOther(paramArrayOfInt3, 6, paramArrayOfInt3, 12);
    int k = Nat192.addTo(paramArrayOfInt3, 18, paramArrayOfInt3, 12, Nat192.addTo(paramArrayOfInt3, 0, paramArrayOfInt3, 6, 0) + j);
    int[] arrayOfInt1 = Nat192.create();
    int[] arrayOfInt2 = Nat192.create();
    int i;
    if (Nat192.diff(paramArrayOfInt1, 6, paramArrayOfInt1, 0, arrayOfInt1, 0) != Nat192.diff(paramArrayOfInt2, 6, paramArrayOfInt2, 0, arrayOfInt2, 0)) {
      i = 1;
    } else {
      i = 0;
    }
    paramArrayOfInt1 = Nat192.createExt();
    Nat192.mul(arrayOfInt1, arrayOfInt2, paramArrayOfInt1);
    if (i != 0) {
      i = Nat.addTo(12, paramArrayOfInt1, 0, paramArrayOfInt3, 6);
    } else {
      i = Nat.subFrom(12, paramArrayOfInt1, 0, paramArrayOfInt3, 6);
    }
    Nat.addWordAt(24, j + k + i, paramArrayOfInt3, 18);
  }
  
  public static void square(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Nat192.square(paramArrayOfInt1, paramArrayOfInt2);
    Nat192.square(paramArrayOfInt1, 6, paramArrayOfInt2, 12);
    int i = Nat192.addToEachOther(paramArrayOfInt2, 6, paramArrayOfInt2, 12);
    int j = Nat192.addTo(paramArrayOfInt2, 18, paramArrayOfInt2, 12, Nat192.addTo(paramArrayOfInt2, 0, paramArrayOfInt2, 6, 0) + i);
    int[] arrayOfInt = Nat192.create();
    Nat192.diff(paramArrayOfInt1, 6, paramArrayOfInt1, 0, arrayOfInt, 0);
    paramArrayOfInt1 = Nat192.createExt();
    Nat192.square(arrayOfInt, paramArrayOfInt1);
    Nat.addWordAt(24, i + j + Nat.subFrom(12, paramArrayOfInt1, 0, paramArrayOfInt2, 6), paramArrayOfInt2, 18);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\raw\Nat384.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */