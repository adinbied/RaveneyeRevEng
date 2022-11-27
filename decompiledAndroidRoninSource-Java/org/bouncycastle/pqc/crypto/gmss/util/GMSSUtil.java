package org.bouncycastle.pqc.crypto.gmss.util;

import java.io.PrintStream;

public class GMSSUtil
{
  public int bytesToIntLittleEndian(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    int j = paramArrayOfByte[1];
    int k = paramArrayOfByte[2];
    return (paramArrayOfByte[3] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public int bytesToIntLittleEndian(byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int i = j + 1;
    j = paramArrayOfByte[j];
    int k = paramArrayOfByte[i];
    return (paramArrayOfByte[(i + 1)] & 0xFF) << 24 | paramInt & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public byte[] concatenateArray(byte[][] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length * paramArrayOfByte[0].length];
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      System.arraycopy(paramArrayOfByte[i], 0, arrayOfByte, j, paramArrayOfByte[i].length);
      j += paramArrayOfByte[i].length;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public int getLog(int paramInt)
  {
    int i = 1;
    int j = 2;
    while (j < paramInt)
    {
      j <<= 1;
      i += 1;
    }
    return i;
  }
  
  public byte[] intToBytesLittleEndian(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 24 & 0xFF) };
  }
  
  public void printArray(String paramString, byte[] paramArrayOfByte)
  {
    System.out.println(paramString);
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      paramString = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(j);
      localStringBuilder.append("; ");
      localStringBuilder.append(paramArrayOfByte[i]);
      paramString.println(localStringBuilder.toString());
      j += 1;
      i += 1;
    }
  }
  
  public void printArray(String paramString, byte[][] paramArrayOfByte)
  {
    System.out.println(paramString);
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = 0;
      while (k < paramArrayOfByte[0].length)
      {
        paramString = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(j);
        localStringBuilder.append("; ");
        localStringBuilder.append(paramArrayOfByte[i][k]);
        paramString.println(localStringBuilder.toString());
        j += 1;
        k += 1;
      }
      i += 1;
    }
  }
  
  public boolean testPowerOfTwo(int paramInt)
  {
    int i = 1;
    while (i < paramInt) {
      i <<= 1;
    }
    return paramInt == i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gms\\util\GMSSUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */