package org.bouncycastle.util.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class Streams
{
  private static int BUFFER_SIZE = 4096;
  
  public static void drain(InputStream paramInputStream)
    throws IOException
  {
    int i = BUFFER_SIZE;
    byte[] arrayOfByte = new byte[i];
    while (paramInputStream.read(arrayOfByte, 0, i) >= 0) {}
  }
  
  public static void pipeAll(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    int i = BUFFER_SIZE;
    byte[] arrayOfByte = new byte[i];
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte, 0, i);
      if (j < 0) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, j);
    }
  }
  
  public static long pipeAllLimited(InputStream paramInputStream, long paramLong, OutputStream paramOutputStream)
    throws IOException
  {
    int i = BUFFER_SIZE;
    byte[] arrayOfByte = new byte[i];
    long l1 = 0L;
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte, 0, i);
      if (j < 0) {
        break label74;
      }
      long l2 = j;
      if (paramLong - l1 < l2) {
        break;
      }
      l1 += l2;
      paramOutputStream.write(arrayOfByte, 0, j);
    }
    throw new StreamOverflowException("Data Overflow");
    label74:
    return l1;
  }
  
  public static byte[] readAll(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    pipeAll(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] readAllLimited(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    pipeAllLimited(paramInputStream, paramInt, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static int readFully(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    return readFully(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int readFully(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j < 0) {
        return i;
      }
      i += j;
    }
    return i;
  }
  
  public static void writeBufTo(ByteArrayOutputStream paramByteArrayOutputStream, OutputStream paramOutputStream)
    throws IOException
  {
    paramByteArrayOutputStream.writeTo(paramOutputStream);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\io\Streams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */