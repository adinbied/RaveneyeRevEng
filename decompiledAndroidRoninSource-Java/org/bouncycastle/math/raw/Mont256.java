package org.bouncycastle.math.raw;

public abstract class Mont256
{
  private static final long M = 4294967295L;
  
  public static int inverse32(int paramInt)
  {
    int i = (2 - paramInt * paramInt) * paramInt;
    i *= (2 - paramInt * i);
    i *= (2 - paramInt * i);
    return i * (2 - paramInt * i);
  }
  
  public static void multAdd(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int paramInt)
  {
    long l1 = paramArrayOfInt2[0] & 0xFFFFFFFF;
    int i = 0;
    int j = 0;
    while (i < 8)
    {
      long l2 = paramArrayOfInt3[0];
      long l4 = paramArrayOfInt1[i] & 0xFFFFFFFF;
      long l3 = l4 * l1;
      long l5 = (l3 & 0xFFFFFFFF) + (l2 & 0xFFFFFFFF);
      l2 = (int)l5 * paramInt & 0xFFFFFFFF;
      long l6 = (paramArrayOfInt4[0] & 0xFFFFFFFF) * l2;
      l3 = (l5 + (l6 & 0xFFFFFFFF) >>> 32) + (l3 >>> 32) + (l6 >>> 32);
      int k = 1;
      while (k < 8)
      {
        l5 = (paramArrayOfInt2[k] & 0xFFFFFFFF) * l4;
        l6 = (paramArrayOfInt4[k] & 0xFFFFFFFF) * l2;
        l3 += (l5 & 0xFFFFFFFF) + (l6 & 0xFFFFFFFF) + (paramArrayOfInt3[k] & 0xFFFFFFFF);
        paramArrayOfInt3[(k - 1)] = ((int)l3);
        l3 = (l3 >>> 32) + (l5 >>> 32) + (l6 >>> 32);
        k += 1;
      }
      l2 = l3 + (j & 0xFFFFFFFF);
      paramArrayOfInt3[7] = ((int)l2);
      j = (int)(l2 >>> 32);
      i += 1;
    }
    if ((j != 0) || (Nat256.gte(paramArrayOfInt3, paramArrayOfInt4))) {
      Nat256.sub(paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt3);
    }
  }
  
  public static void multAddXF(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    long l1 = paramArrayOfInt2[0] & 0xFFFFFFFF;
    int i = 0;
    int j = 0;
    while (i < 8)
    {
      long l3 = paramArrayOfInt1[i] & 0xFFFFFFFF;
      long l4 = l3 * l1 + (paramArrayOfInt3[0] & 0xFFFFFFFF);
      long l2 = l4 & 0xFFFFFFFF;
      l4 = (l4 >>> 32) + l2;
      int k = 1;
      while (k < 8)
      {
        long l5 = (paramArrayOfInt2[k] & 0xFFFFFFFF) * l3;
        long l6 = (paramArrayOfInt4[k] & 0xFFFFFFFF) * l2;
        l4 += (l5 & 0xFFFFFFFF) + (l6 & 0xFFFFFFFF) + (paramArrayOfInt3[k] & 0xFFFFFFFF);
        paramArrayOfInt3[(k - 1)] = ((int)l4);
        l4 = (l4 >>> 32) + (l5 >>> 32) + (l6 >>> 32);
        k += 1;
      }
      l2 = l4 + (j & 0xFFFFFFFF);
      paramArrayOfInt3[7] = ((int)l2);
      j = (int)(l2 >>> 32);
      i += 1;
    }
    if ((j != 0) || (Nat256.gte(paramArrayOfInt3, paramArrayOfInt4))) {
      Nat256.sub(paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt3);
    }
  }
  
  public static void reduce(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    while (i < 8)
    {
      int j = paramArrayOfInt1[0];
      long l2 = j * paramInt & 0xFFFFFFFF;
      long l1 = (paramArrayOfInt2[0] & 0xFFFFFFFF) * l2 + (j & 0xFFFFFFFF) >>> 32;
      j = 1;
      while (j < 8)
      {
        l1 += (paramArrayOfInt2[j] & 0xFFFFFFFF) * l2 + (paramArrayOfInt1[j] & 0xFFFFFFFF);
        paramArrayOfInt1[(j - 1)] = ((int)l1);
        l1 >>>= 32;
        j += 1;
      }
      paramArrayOfInt1[7] = ((int)l1);
      i += 1;
    }
    if (Nat256.gte(paramArrayOfInt1, paramArrayOfInt2)) {
      Nat256.sub(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt1);
    }
  }
  
  public static void reduceXF(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = 0;
    while (i < 8)
    {
      long l2 = paramArrayOfInt1[0] & 0xFFFFFFFF;
      int j = 1;
      long l1 = l2;
      while (j < 8)
      {
        l1 += (paramArrayOfInt2[j] & 0xFFFFFFFF) * l2 + (paramArrayOfInt1[j] & 0xFFFFFFFF);
        paramArrayOfInt1[(j - 1)] = ((int)l1);
        l1 >>>= 32;
        j += 1;
      }
      paramArrayOfInt1[7] = ((int)l1);
      i += 1;
    }
    if (Nat256.gte(paramArrayOfInt1, paramArrayOfInt2)) {
      Nat256.sub(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt1);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\raw\Mont256.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */