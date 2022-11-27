package com.facebook.imageformat;

import com.facebook.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;

public class ImageFormatCheckerUtils
{
  public static byte[] asciiBytes(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    try
    {
      paramString = paramString.getBytes("ASCII");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("ASCII not found!", paramString);
    }
  }
  
  public static boolean hasPatternAt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    Preconditions.checkNotNull(paramArrayOfByte1);
    Preconditions.checkNotNull(paramArrayOfByte2);
    if (paramArrayOfByte2.length + paramInt > paramArrayOfByte1.length) {
      return false;
    }
    int i = 0;
    while (i < paramArrayOfByte2.length)
    {
      if (paramArrayOfByte1[(paramInt + i)] != paramArrayOfByte2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static int indexOfPattern(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    Preconditions.checkNotNull(paramArrayOfByte1);
    Preconditions.checkNotNull(paramArrayOfByte2);
    if (paramInt2 > paramInt1) {
      return -1;
    }
    int i = 0;
    int m = paramArrayOfByte2[0];
    int n = paramInt1 - paramInt2;
    for (paramInt1 = i; paramInt1 <= n; paramInt1 = i + 1)
    {
      int k = paramArrayOfByte1[paramInt1];
      int j = 1;
      i = paramInt1;
      if (k != m) {
        do
        {
          paramInt1 += 1;
          i = paramInt1;
          if (paramInt1 > n) {
            break;
          }
          i = paramInt1;
        } while (paramArrayOfByte1[paramInt1] != m);
      }
      if (i <= n)
      {
        k = i + 1;
        int i1 = k + paramInt2 - 1;
        paramInt1 = j;
        j = k;
        while ((j < i1) && (paramArrayOfByte1[j] == paramArrayOfByte2[paramInt1]))
        {
          j += 1;
          paramInt1 += 1;
        }
        if (j == i1) {
          return i;
        }
      }
    }
    return -1;
  }
  
  public static boolean startsWithPattern(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return hasPatternAt(paramArrayOfByte1, paramArrayOfByte2, 0);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imageformat\ImageFormatCheckerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */