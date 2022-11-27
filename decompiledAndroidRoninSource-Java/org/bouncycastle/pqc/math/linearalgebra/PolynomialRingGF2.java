package org.bouncycastle.pqc.math.linearalgebra;

import java.io.PrintStream;

public final class PolynomialRingGF2
{
  public static int add(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  public static int degree(int paramInt)
  {
    int i = -1;
    while (paramInt != 0)
    {
      i += 1;
      paramInt >>>= 1;
    }
    return i;
  }
  
  public static int degree(long paramLong)
  {
    int i = 0;
    while (paramLong != 0L)
    {
      i += 1;
      paramLong >>>= 1;
    }
    return i - 1;
  }
  
  public static int gcd(int paramInt1, int paramInt2)
  {
    int i;
    for (;;)
    {
      i = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt1 == 0) {
        break;
      }
      paramInt2 = remainder(i, paramInt1);
    }
    return i;
  }
  
  public static int getIrreduciblePolynomial(int paramInt)
  {
    PrintStream localPrintStream;
    if (paramInt < 0) {
      localPrintStream = System.err;
    }
    for (String str = "The Degree is negative";; str = "The Degree is more then 31")
    {
      localPrintStream.println(str);
      return 0;
      if (paramInt <= 31) {
        break;
      }
      localPrintStream = System.err;
    }
    if (paramInt == 0) {
      return 1;
    }
    int i = (1 << paramInt) + 1;
    while (i < 1 << paramInt + 1)
    {
      if (isIrreducible(i)) {
        return i;
      }
      i += 2;
    }
    return 0;
  }
  
  public static boolean isIrreducible(int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    int k = degree(paramInt);
    int j = 2;
    int i = 0;
    while (i < k >>> 1)
    {
      j = modMultiply(j, j, paramInt);
      if (gcd(j ^ 0x2, paramInt) != 1) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static int modMultiply(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = remainder(paramInt1, paramInt3);
    paramInt1 = remainder(paramInt2, paramInt3);
    int j = 0;
    paramInt2 = 0;
    if (paramInt1 != 0)
    {
      int n = degree(paramInt3);
      for (;;)
      {
        j = paramInt2;
        if (i == 0) {
          break;
        }
        j = paramInt2;
        if ((byte)(i & 0x1) == 1) {
          j = paramInt2 ^ paramInt1;
        }
        int k = i >>> 1;
        int m = paramInt1 << 1;
        paramInt2 = j;
        i = k;
        paramInt1 = m;
        if (m >= 1 << n)
        {
          paramInt1 = m ^ paramInt3;
          paramInt2 = j;
          i = k;
        }
      }
    }
    return j;
  }
  
  public static long multiply(int paramInt1, int paramInt2)
  {
    long l1 = 0L;
    long l3 = l1;
    if (paramInt2 != 0)
    {
      long l2 = paramInt2 & 0xFFFFFFFF;
      for (;;)
      {
        l3 = l1;
        if (paramInt1 == 0) {
          break;
        }
        l3 = l1;
        if ((byte)(paramInt1 & 0x1) == 1) {
          l3 = l1 ^ l2;
        }
        paramInt1 >>>= 1;
        l2 <<= 1;
        l1 = l3;
      }
    }
    return l3;
  }
  
  public static int remainder(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      System.err.println("Error: to be divided by 0");
      return 0;
    }
    while (degree(paramInt1) >= degree(paramInt2)) {
      paramInt1 ^= paramInt2 << degree(paramInt1) - degree(paramInt2);
    }
    return paramInt1;
  }
  
  public static int rest(long paramLong, int paramInt)
  {
    if (paramInt == 0)
    {
      System.err.println("Error: to be divided by 0");
      return 0;
    }
    long l = paramInt & 0xFFFFFFFF;
    while (paramLong >>> 32 != 0L) {
      paramLong ^= l << degree(paramLong) - degree(l);
    }
    int i = (int)(paramLong & 0xFFFFFFFFFFFFFFFF);
    while (degree(i) >= degree(paramInt)) {
      i ^= paramInt << degree(i) - degree(paramInt);
    }
    return i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\PolynomialRingGF2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */