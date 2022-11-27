package org.bouncycastle.pqc.math.linearalgebra;

public final class ByteUtils
{
  private static final char[] HEX_CHARS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static byte[] clone(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public static byte[] concatenate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public static byte[] concatenate(byte[][] paramArrayOfByte)
  {
    int k = paramArrayOfByte[0].length;
    byte[] arrayOfByte = new byte[paramArrayOfByte.length * k];
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      System.arraycopy(paramArrayOfByte[i], 0, arrayOfByte, j, k);
      j += k;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static int deepHashCode(byte[] paramArrayOfByte)
  {
    int j = 1;
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      j = j * 31 + paramArrayOfByte[i];
      i += 1;
    }
    return j;
  }
  
  public static int deepHashCode(byte[][] paramArrayOfByte)
  {
    int j = 1;
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      j = j * 31 + deepHashCode(paramArrayOfByte[i]);
      i += 1;
    }
    return j;
  }
  
  public static int deepHashCode(byte[][][] paramArrayOfByte)
  {
    int j = 1;
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      j = j * 31 + deepHashCode(paramArrayOfByte[i]);
      i += 1;
    }
    return j;
  }
  
  public static boolean equals(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {
      return paramArrayOfByte2 == null;
    }
    if (paramArrayOfByte2 == null) {
      return false;
    }
    if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
      return false;
    }
    int i = paramArrayOfByte1.length - 1;
    boolean bool2 = true;
    while (i >= 0)
    {
      boolean bool1;
      if (paramArrayOfByte1[i] == paramArrayOfByte2[i]) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 &= bool1;
      i -= 1;
    }
    return bool2;
  }
  
  public static boolean equals(byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
      return false;
    }
    int i = paramArrayOfByte1.length;
    boolean bool = true;
    i -= 1;
    while (i >= 0)
    {
      bool &= equals(paramArrayOfByte1[i], paramArrayOfByte2[i]);
      i -= 1;
    }
    return bool;
  }
  
  public static boolean equals(byte[][][] paramArrayOfByte1, byte[][][] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
      return false;
    }
    int i = paramArrayOfByte1.length - 1;
    boolean bool = true;
    while (i >= 0)
    {
      if (paramArrayOfByte1[i].length != paramArrayOfByte2[i].length) {
        return false;
      }
      int j = paramArrayOfByte1[i].length - 1;
      while (j >= 0)
      {
        bool &= equals(paramArrayOfByte1[i][j], paramArrayOfByte2[i][j]);
        j -= 1;
      }
      i -= 1;
    }
    return bool;
  }
  
  public static byte[] fromHexString(String paramString)
  {
    paramString = paramString.toUpperCase().toCharArray();
    int m = 0;
    int i = 0;
    int k;
    for (int j = 0; i < paramString.length; j = k)
    {
      if ((paramString[i] < '0') || (paramString[i] > '9'))
      {
        k = j;
        if (paramString[i] >= 'A')
        {
          k = j;
          if (paramString[i] > 'F') {}
        }
      }
      else
      {
        k = j + 1;
      }
      i += 1;
    }
    byte[] arrayOfByte = new byte[j + 1 >> 1];
    j &= 0x1;
    i = m;
    while (i < paramString.length)
    {
      if ((paramString[i] >= '0') && (paramString[i] <= '9'))
      {
        k = j >> 1;
        arrayOfByte[k] = ((byte)(arrayOfByte[k] << 4));
        arrayOfByte[k] = ((byte)(arrayOfByte[k] | paramString[i] - '0'));
      }
      else
      {
        k = j;
        if (paramString[i] < 'A') {
          break label200;
        }
        k = j;
        if (paramString[i] > 'F') {
          break label200;
        }
        k = j >> 1;
        arrayOfByte[k] = ((byte)(arrayOfByte[k] << 4));
        arrayOfByte[k] = ((byte)(arrayOfByte[k] | paramString[i] - 'A' + 10));
      }
      k = j + 1;
      label200:
      i += 1;
      j = k;
    }
    return arrayOfByte;
  }
  
  public static byte[][] split(byte[] paramArrayOfByte, int paramInt)
    throws ArrayIndexOutOfBoundsException
  {
    if (paramInt <= paramArrayOfByte.length)
    {
      byte[][] arrayOfByte = new byte[2][];
      arrayOfByte[0] = new byte[paramInt];
      arrayOfByte[1] = new byte[paramArrayOfByte.length - paramInt];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte[0], 0, paramInt);
      System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte[1], 0, paramArrayOfByte.length - paramInt);
      return arrayOfByte;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public static byte[] subArray(byte[] paramArrayOfByte, int paramInt)
  {
    return subArray(paramArrayOfByte, paramInt, paramArrayOfByte.length);
  }
  
  public static byte[] subArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 -= paramInt1;
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public static String toBinaryString(byte[] paramArrayOfByte)
  {
    Object localObject1 = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[i];
      int j = 0;
      while (j < 8)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(k >>> j & 0x1);
        localObject1 = ((StringBuilder)localObject2).toString();
        j += 1;
      }
      Object localObject2 = localObject1;
      if (i != paramArrayOfByte.length - 1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" ");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      i += 1;
      localObject1 = localObject2;
    }
    return (String)localObject1;
  }
  
  public static char[] toCharArray(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfChar[i] = ((char)paramArrayOfByte[i]);
      i += 1;
    }
    return arrayOfChar;
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    String str = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(HEX_CHARS[(paramArrayOfByte[i] >>> 4 & 0xF)]);
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(HEX_CHARS[(paramArrayOfByte[i] & 0xF)]);
      str = localStringBuilder.toString();
      i += 1;
    }
    return str;
  }
  
  public static String toHexString(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    paramString1 = new String(paramString1);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(HEX_CHARS[(paramArrayOfByte[i] >>> 4 & 0xF)]);
      paramString1 = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(HEX_CHARS[(paramArrayOfByte[i] & 0xF)]);
      localObject = ((StringBuilder)localObject).toString();
      paramString1 = (String)localObject;
      if (i < paramArrayOfByte.length - 1)
      {
        paramString1 = new StringBuilder();
        paramString1.append((String)localObject);
        paramString1.append(paramString2);
        paramString1 = paramString1.toString();
      }
      i += 1;
    }
    return paramString1;
  }
  
  public static byte[] xor(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
    int i = paramArrayOfByte1.length - 1;
    while (i >= 0)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i -= 1;
    }
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\ByteUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */