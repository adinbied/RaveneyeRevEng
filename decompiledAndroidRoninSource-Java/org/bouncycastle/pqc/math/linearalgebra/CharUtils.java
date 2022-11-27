package org.bouncycastle.pqc.math.linearalgebra;

public final class CharUtils
{
  public static char[] clone(char[] paramArrayOfChar)
  {
    char[] arrayOfChar = new char[paramArrayOfChar.length];
    System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramArrayOfChar.length);
    return arrayOfChar;
  }
  
  public static boolean equals(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    if (paramArrayOfChar1.length != paramArrayOfChar2.length) {
      return false;
    }
    int i = paramArrayOfChar1.length - 1;
    boolean bool2 = true;
    while (i >= 0)
    {
      boolean bool1;
      if (paramArrayOfChar1[i] == paramArrayOfChar2[i]) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 &= bool1;
      i -= 1;
    }
    return bool2;
  }
  
  public static byte[] toByteArray(char[] paramArrayOfChar)
  {
    byte[] arrayOfByte = new byte[paramArrayOfChar.length];
    int i = paramArrayOfChar.length - 1;
    while (i >= 0)
    {
      arrayOfByte[i] = ((byte)paramArrayOfChar[i]);
      i -= 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] toByteArrayForPBE(char[] paramArrayOfChar)
  {
    int j = paramArrayOfChar.length;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      arrayOfByte[i] = ((byte)paramArrayOfChar[i]);
      i += 1;
    }
    int k = j * 2;
    paramArrayOfChar = new byte[k + 2];
    i = 0;
    while (i < j)
    {
      int m = i * 2;
      paramArrayOfChar[m] = '\000';
      paramArrayOfChar[(m + 1)] = arrayOfByte[i];
      i += 1;
    }
    paramArrayOfChar[k] = '\000';
    paramArrayOfChar[(k + 1)] = '\000';
    return paramArrayOfChar;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\CharUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */