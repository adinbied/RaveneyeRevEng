package org.bouncycastle.pqc.crypto.xmss;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.encoders.Hex;

public class XMSSUtil
{
  public static long bytesToXBigEndian(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      long l = 0L;
      int i = paramInt1;
      while (i < paramInt1 + paramInt2)
      {
        l = l << 8 | paramArrayOfByte[i] & 0xFF;
        i += 1;
      }
      return l;
    }
    throw new NullPointerException("in == null");
  }
  
  public static int calculateTau(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      if ((paramInt1 >> i & 0x1) == 0) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  public static byte[] cloneArray(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        arrayOfByte[i] = paramArrayOfByte[i];
        i += 1;
      }
      return arrayOfByte;
    }
    throw new NullPointerException("in == null");
  }
  
  public static byte[][] cloneArray(byte[][] paramArrayOfByte)
  {
    if (!hasNullPointer(paramArrayOfByte))
    {
      byte[][] arrayOfByte = new byte[paramArrayOfByte.length][];
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        arrayOfByte[i] = new byte[paramArrayOfByte[i].length];
        int j = 0;
        while (j < paramArrayOfByte[i].length)
        {
          arrayOfByte[i][j] = paramArrayOfByte[i][j];
          j += 1;
        }
        i += 1;
      }
      return arrayOfByte;
    }
    throw new NullPointerException("in has null pointers");
  }
  
  public static boolean compareByteArray(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      if (paramArrayOfByte1.length == paramArrayOfByte2.length)
      {
        int i = 0;
        while (i < paramArrayOfByte1.length)
        {
          if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
            return false;
          }
          i += 1;
        }
        return true;
      }
      throw new IllegalArgumentException("size of a and b must be equal");
    }
    throw new NullPointerException("a or b == null");
  }
  
  public static boolean compareByteArray(byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2)
  {
    if ((!hasNullPointer(paramArrayOfByte1)) && (!hasNullPointer(paramArrayOfByte2)))
    {
      int i = 0;
      while (i < paramArrayOfByte1.length)
      {
        if (!compareByteArray(paramArrayOfByte1[i], paramArrayOfByte2[i])) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    throw new NullPointerException("a or b == null");
  }
  
  public static byte[] concat(byte[]... paramVarArgs)
  {
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    byte[] arrayOfByte = new byte[j];
    i = 0;
    j = 0;
    while (i < paramVarArgs.length)
    {
      System.arraycopy(paramVarArgs[i], 0, arrayOfByte, j, paramVarArgs[i].length);
      j += paramVarArgs[i].length;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static void copyBytesAtOffset(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 != null)
      {
        if (paramInt >= 0)
        {
          if (paramArrayOfByte2.length + paramInt <= paramArrayOfByte1.length)
          {
            int i = 0;
            while (i < paramArrayOfByte2.length)
            {
              paramArrayOfByte1[(paramInt + i)] = paramArrayOfByte2[i];
              i += 1;
            }
            return;
          }
          throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
        }
        throw new IllegalArgumentException("offset hast to be >= 0");
      }
      throw new NullPointerException("src == null");
    }
    throw new NullPointerException("dst == null");
  }
  
  public static Object deserialize(byte[] paramArrayOfByte)
    throws IOException, ClassNotFoundException
  {
    return new ObjectInputStream(new ByteArrayInputStream(paramArrayOfByte)).readObject();
  }
  
  public static void dumpByteArray(byte[][] paramArrayOfByte)
  {
    if (!hasNullPointer(paramArrayOfByte))
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        System.out.println(Hex.toHexString(paramArrayOfByte[i]));
        i += 1;
      }
      return;
    }
    throw new NullPointerException("x has null pointers");
  }
  
  public static byte[] extractBytesAtOffset(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 >= 0)
        {
          if (paramInt1 + paramInt2 <= paramArrayOfByte.length)
          {
            byte[] arrayOfByte = new byte[paramInt2];
            int i = 0;
            while (i < paramInt2)
            {
              arrayOfByte[i] = paramArrayOfByte[(paramInt1 + i)];
              i += 1;
            }
            return arrayOfByte;
          }
          throw new IllegalArgumentException("offset + length must not be greater then size of source array");
        }
        throw new IllegalArgumentException("length hast to be >= 0");
      }
      throw new IllegalArgumentException("offset hast to be >= 0");
    }
    throw new NullPointerException("src == null");
  }
  
  public static int getDigestSize(Digest paramDigest)
  {
    if (paramDigest != null)
    {
      String str = paramDigest.getAlgorithmName();
      if (str.equals("SHAKE128")) {
        return 32;
      }
      if (str.equals("SHAKE256")) {
        return 64;
      }
      return paramDigest.getDigestSize();
    }
    throw new NullPointerException("digest == null");
  }
  
  public static int getLeafIndex(long paramLong, int paramInt)
  {
    return (int)(paramLong & (1L << paramInt) - 1L);
  }
  
  public static long getTreeIndex(long paramLong, int paramInt)
  {
    return paramLong >> paramInt;
  }
  
  public static boolean hasNullPointer(byte[][] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return true;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if (paramArrayOfByte[i] == null) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static void intToBytesBigEndianOffset(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length - paramInt2 >= 4)
      {
        paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 24 & 0xFF));
        paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16 & 0xFF));
        paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 8 & 0xFF));
        paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 & 0xFF));
        return;
      }
      throw new IllegalArgumentException("not enough space in array");
    }
    throw new NullPointerException("in == null");
  }
  
  public static boolean isIndexValid(int paramInt, long paramLong)
  {
    if (paramLong >= 0L) {
      return paramLong < 1L << paramInt;
    }
    throw new IllegalStateException("index must not be negative");
  }
  
  public static boolean isNewAuthenticationPathNeeded(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramLong == 0L) {
      return false;
    }
    if ((paramLong + 1L) % Math.pow(1 << paramInt1, paramInt2) == 0L) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isNewBDSInitNeeded(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramLong == 0L) {
      return false;
    }
    if (paramLong % Math.pow(1 << paramInt1, paramInt2 + 1) == 0L) {
      bool = true;
    }
    return bool;
  }
  
  public static int log2(int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    for (;;)
    {
      i >>= 1;
      if (i == 0) {
        break;
      }
      paramInt += 1;
    }
    return paramInt;
  }
  
  public static void longToBytesBigEndianOffset(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length - paramInt >= 8)
      {
        paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 56 & 0xFF));
        paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 48 & 0xFF));
        paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 40 & 0xFF));
        paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >> 32 & 0xFF));
        paramArrayOfByte[(paramInt + 4)] = ((byte)(int)(paramLong >> 24 & 0xFF));
        paramArrayOfByte[(paramInt + 5)] = ((byte)(int)(paramLong >> 16 & 0xFF));
        paramArrayOfByte[(paramInt + 6)] = ((byte)(int)(paramLong >> 8 & 0xFF));
        paramArrayOfByte[(paramInt + 7)] = ((byte)(int)(paramLong & 0xFF));
        return;
      }
      throw new IllegalArgumentException("not enough space in array");
    }
    throw new NullPointerException("in == null");
  }
  
  public static byte[] serialize(Object paramObject)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
    localObjectOutputStream.writeObject(paramObject);
    localObjectOutputStream.flush();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] toBytesBigEndian(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramInt -= 1;
    while (paramInt >= 0)
    {
      arrayOfByte[paramInt] = ((byte)(int)paramLong);
      paramLong >>>= 8;
      paramInt -= 1;
    }
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\XMSSUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */