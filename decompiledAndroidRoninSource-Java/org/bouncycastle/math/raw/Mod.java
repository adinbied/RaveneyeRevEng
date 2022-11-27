package org.bouncycastle.math.raw;

import java.util.Random;

public abstract class Mod
{
  public static void add(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    int i = paramArrayOfInt1.length;
    if (Nat.add(i, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4) != 0) {
      Nat.subFrom(i, paramArrayOfInt1, paramArrayOfInt4);
    }
  }
  
  private static int getTrailingZeroes(int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while ((i & 0x1) == 0)
    {
      i >>>= 1;
      paramInt += 1;
    }
    return paramInt;
  }
  
  public static int inverse32(int paramInt)
  {
    int i = (2 - paramInt * paramInt) * paramInt;
    i *= (2 - paramInt * i);
    i *= (2 - paramInt * i);
    return i * (2 - paramInt * i);
  }
  
  private static void inversionResult(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (paramInt < 0)
    {
      Nat.add(paramArrayOfInt1.length, paramArrayOfInt2, paramArrayOfInt1, paramArrayOfInt3);
      return;
    }
    System.arraycopy(paramArrayOfInt2, 0, paramArrayOfInt3, 0, paramArrayOfInt1.length);
  }
  
  private static int inversionStep(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int[] paramArrayOfInt3, int paramInt2)
  {
    int k = paramArrayOfInt1.length;
    int i = 0;
    while (paramArrayOfInt2[0] == 0)
    {
      Nat.shiftDownWord(paramInt1, paramArrayOfInt2, 0);
      i += 32;
    }
    int m = getTrailingZeroes(paramArrayOfInt2[0]);
    int j = i;
    if (m > 0)
    {
      Nat.shiftDownBits(paramInt1, paramArrayOfInt2, m, 0);
      j = i + m;
    }
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      i = paramInt2;
      if ((paramArrayOfInt3[0] & 0x1) != 0)
      {
        if (paramInt2 < 0) {
          i = Nat.addTo(k, paramArrayOfInt1, paramArrayOfInt3);
        } else {
          i = Nat.subFrom(k, paramArrayOfInt1, paramArrayOfInt3);
        }
        i = paramInt2 + i;
      }
      Nat.shiftDownBit(k, paramArrayOfInt3, i);
      paramInt1 += 1;
      paramInt2 = i;
    }
    return paramInt2;
  }
  
  public static void invert(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int m = paramArrayOfInt1.length;
    if (!Nat.isZero(m, paramArrayOfInt2))
    {
      boolean bool = Nat.isOne(m, paramArrayOfInt2);
      int k = 0;
      if (bool)
      {
        System.arraycopy(paramArrayOfInt2, 0, paramArrayOfInt3, 0, m);
        return;
      }
      paramArrayOfInt2 = Nat.copy(m, paramArrayOfInt2);
      int[] arrayOfInt1 = Nat.create(m);
      arrayOfInt1[0] = 1;
      int i;
      if ((0x1 & paramArrayOfInt2[0]) == 0) {
        i = inversionStep(paramArrayOfInt1, paramArrayOfInt2, m, arrayOfInt1, 0);
      } else {
        i = 0;
      }
      if (Nat.isOne(m, paramArrayOfInt2))
      {
        inversionResult(paramArrayOfInt1, i, arrayOfInt1, paramArrayOfInt3);
        return;
      }
      int[] arrayOfInt2 = Nat.copy(m, paramArrayOfInt1);
      int[] arrayOfInt3 = Nat.create(m);
      int j = m;
      int n;
      do
      {
        do
        {
          for (;;)
          {
            n = j - 1;
            if ((paramArrayOfInt2[n] != 0) || (arrayOfInt2[n] != 0)) {
              break;
            }
            j -= 1;
          }
          if (!Nat.gte(j, paramArrayOfInt2, arrayOfInt2)) {
            break;
          }
          Nat.subFrom(j, arrayOfInt2, paramArrayOfInt2);
          n = inversionStep(paramArrayOfInt1, paramArrayOfInt2, j, arrayOfInt1, i + (Nat.subFrom(m, arrayOfInt3, arrayOfInt1) - k));
          i = n;
        } while (!Nat.isOne(j, paramArrayOfInt2));
        inversionResult(paramArrayOfInt1, n, arrayOfInt1, paramArrayOfInt3);
        return;
        Nat.subFrom(j, paramArrayOfInt2, arrayOfInt2);
        n = inversionStep(paramArrayOfInt1, arrayOfInt2, j, arrayOfInt3, k + (Nat.subFrom(m, arrayOfInt1, arrayOfInt3) - i));
        k = n;
      } while (!Nat.isOne(j, arrayOfInt2));
      inversionResult(paramArrayOfInt1, n, arrayOfInt3, paramArrayOfInt3);
      return;
    }
    throw new IllegalArgumentException("'x' cannot be 0");
  }
  
  public static int[] random(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    Random localRandom = new Random();
    int[] arrayOfInt = Nat.create(j);
    int k = j - 1;
    int i = paramArrayOfInt[k];
    i |= i >>> 1;
    i |= i >>> 2;
    i |= i >>> 4;
    int m = i | i >>> 8;
    do
    {
      i = 0;
      while (i != j)
      {
        arrayOfInt[i] = localRandom.nextInt();
        i += 1;
      }
      arrayOfInt[k] &= (m | m >>> 16);
    } while (Nat.gte(j, arrayOfInt, paramArrayOfInt));
    return arrayOfInt;
  }
  
  public static void subtract(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    int i = paramArrayOfInt1.length;
    if (Nat.sub(i, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4) != 0) {
      Nat.addTo(i, paramArrayOfInt1, paramArrayOfInt4);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\raw\Mod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */