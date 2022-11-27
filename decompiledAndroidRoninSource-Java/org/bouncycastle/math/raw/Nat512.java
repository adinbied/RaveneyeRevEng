package org.bouncycastle.math.raw;

public abstract class Nat512
{
  public static void mul(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    Nat256.mul(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    Nat256.mul(paramArrayOfInt1, 8, paramArrayOfInt2, 8, paramArrayOfInt3, 16);
    int j = Nat256.addToEachOther(paramArrayOfInt3, 8, paramArrayOfInt3, 16);
    int k = Nat256.addTo(paramArrayOfInt3, 24, paramArrayOfInt3, 16, Nat256.addTo(paramArrayOfInt3, 0, paramArrayOfInt3, 8, 0) + j);
    int[] arrayOfInt1 = Nat256.create();
    int[] arrayOfInt2 = Nat256.create();
    int i;
    if (Nat256.diff(paramArrayOfInt1, 8, paramArrayOfInt1, 0, arrayOfInt1, 0) != Nat256.diff(paramArrayOfInt2, 8, paramArrayOfInt2, 0, arrayOfInt2, 0)) {
      i = 1;
    } else {
      i = 0;
    }
    paramArrayOfInt1 = Nat256.createExt();
    Nat256.mul(arrayOfInt1, arrayOfInt2, paramArrayOfInt1);
    if (i != 0) {
      i = Nat.addTo(16, paramArrayOfInt1, 0, paramArrayOfInt3, 8);
    } else {
      i = Nat.subFrom(16, paramArrayOfInt1, 0, paramArrayOfInt3, 8);
    }
    Nat.addWordAt(32, j + k + i, paramArrayOfInt3, 24);
  }
  
  public static void square(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Nat256.square(paramArrayOfInt1, paramArrayOfInt2);
    Nat256.square(paramArrayOfInt1, 8, paramArrayOfInt2, 16);
    int i = Nat256.addToEachOther(paramArrayOfInt2, 8, paramArrayOfInt2, 16);
    int j = Nat256.addTo(paramArrayOfInt2, 24, paramArrayOfInt2, 16, Nat256.addTo(paramArrayOfInt2, 0, paramArrayOfInt2, 8, 0) + i);
    int[] arrayOfInt = Nat256.create();
    Nat256.diff(paramArrayOfInt1, 8, paramArrayOfInt1, 0, arrayOfInt, 0);
    paramArrayOfInt1 = Nat256.createExt();
    Nat256.square(arrayOfInt, paramArrayOfInt1);
    Nat.addWordAt(32, i + j + Nat.subFrom(16, paramArrayOfInt1, 0, paramArrayOfInt2, 8), paramArrayOfInt2, 24);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\raw\Nat512.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */