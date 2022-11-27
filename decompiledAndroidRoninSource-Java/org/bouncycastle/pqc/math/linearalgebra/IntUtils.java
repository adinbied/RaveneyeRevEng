package org.bouncycastle.pqc.math.linearalgebra;

public final class IntUtils
{
  public static int[] clone(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramArrayOfInt.length);
    return arrayOfInt;
  }
  
  public static boolean equals(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1.length != paramArrayOfInt2.length) {
      return false;
    }
    int i = paramArrayOfInt1.length - 1;
    boolean bool2 = true;
    while (i >= 0)
    {
      boolean bool1;
      if (paramArrayOfInt1[i] == paramArrayOfInt2[i]) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 &= bool1;
      i -= 1;
    }
    return bool2;
  }
  
  public static void fill(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt.length - 1;
    while (i >= 0)
    {
      paramArrayOfInt[i] = paramInt;
      i -= 1;
    }
  }
  
  private static int partition(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramArrayOfInt[paramInt3];
    paramArrayOfInt[paramInt3] = paramArrayOfInt[paramInt2];
    paramArrayOfInt[paramInt2] = j;
    int i;
    for (paramInt3 = paramInt1; paramInt1 < paramInt2; paramInt3 = i)
    {
      i = paramInt3;
      if (paramArrayOfInt[paramInt1] <= j)
      {
        i = paramArrayOfInt[paramInt3];
        paramArrayOfInt[paramInt3] = paramArrayOfInt[paramInt1];
        paramArrayOfInt[paramInt1] = i;
        i = paramInt3 + 1;
      }
      paramInt1 += 1;
    }
    paramInt1 = paramArrayOfInt[paramInt3];
    paramArrayOfInt[paramInt3] = paramArrayOfInt[paramInt2];
    paramArrayOfInt[paramInt2] = paramInt1;
    return paramInt3;
  }
  
  public static void quicksort(int[] paramArrayOfInt)
  {
    quicksort(paramArrayOfInt, 0, paramArrayOfInt.length - 1);
  }
  
  public static void quicksort(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1)
    {
      int i = partition(paramArrayOfInt, paramInt1, paramInt2, paramInt2);
      quicksort(paramArrayOfInt, paramInt1, i - 1);
      quicksort(paramArrayOfInt, i + 1, paramInt2);
    }
  }
  
  public static int[] subArray(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    paramInt2 -= paramInt1;
    int[] arrayOfInt = new int[paramInt2];
    System.arraycopy(paramArrayOfInt, paramInt1, arrayOfInt, 0, paramInt2);
    return arrayOfInt;
  }
  
  public static String toHexString(int[] paramArrayOfInt)
  {
    return ByteUtils.toHexString(BigEndianConversions.toByteArray(paramArrayOfInt));
  }
  
  public static String toString(int[] paramArrayOfInt)
  {
    String str = "";
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramArrayOfInt[i]);
      localStringBuilder.append(" ");
      str = localStringBuilder.toString();
      i += 1;
    }
    return str;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\IntUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */