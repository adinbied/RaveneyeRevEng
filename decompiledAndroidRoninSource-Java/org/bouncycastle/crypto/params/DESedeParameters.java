package org.bouncycastle.crypto.params;

public class DESedeParameters
  extends DESParameters
{
  public static final int DES_EDE_KEY_LENGTH = 24;
  
  public DESedeParameters(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
    if (!isWeakKey(paramArrayOfByte, 0, paramArrayOfByte.length)) {
      return;
    }
    throw new IllegalArgumentException("attempt to create weak DESede key");
  }
  
  public static boolean isReal2Key(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = false;
    int i = paramInt;
    while (i != paramInt + 8)
    {
      if (paramArrayOfByte[i] != paramArrayOfByte[(i + 8)]) {
        bool = true;
      }
      i += 1;
    }
    return bool;
  }
  
  public static boolean isReal3Key(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = false;
    int j = paramInt;
    int m = 0;
    int k = 0;
    int i = 0;
    for (;;)
    {
      int i1 = 1;
      if (j == paramInt + 8) {
        break;
      }
      int n = paramArrayOfByte[j];
      int i3 = j + 8;
      if (n != paramArrayOfByte[i3]) {
        n = 1;
      } else {
        n = 0;
      }
      n = m | n;
      m = paramArrayOfByte[j];
      int i4 = j + 16;
      if (m != paramArrayOfByte[i4]) {
        m = 1;
      } else {
        m = 0;
      }
      int i2 = k | m;
      if (paramArrayOfByte[i3] != paramArrayOfByte[i4]) {
        k = i1;
      } else {
        k = 0;
      }
      i |= k;
      j += 1;
      m = n;
      k = i2;
    }
    boolean bool1 = bool2;
    if (m != 0)
    {
      bool1 = bool2;
      if (k != 0)
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isRealEDEKey(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte.length == 16) {
      return isReal2Key(paramArrayOfByte, paramInt);
    }
    return isReal3Key(paramArrayOfByte, paramInt);
  }
  
  public static boolean isWeakKey(byte[] paramArrayOfByte, int paramInt)
  {
    return isWeakKey(paramArrayOfByte, paramInt, paramArrayOfByte.length - paramInt);
  }
  
  public static boolean isWeakKey(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (DESParameters.isWeakKey(paramArrayOfByte, paramInt1)) {
        return true;
      }
      paramInt1 += 8;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\DESedeParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */