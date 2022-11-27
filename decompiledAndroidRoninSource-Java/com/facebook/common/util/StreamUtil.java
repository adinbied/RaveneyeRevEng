package com.facebook.common.util;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil
{
  public static byte[] getBytesFromStream(InputStream paramInputStream)
    throws IOException
  {
    return getBytesFromStream(paramInputStream, paramInputStream.available());
  }
  
  public static byte[] getBytesFromStream(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    ByteArrayOutputStream local1 = new ByteArrayOutputStream(paramInt)
    {
      public byte[] toByteArray()
      {
        if (this.count == this.buf.length) {
          return this.buf;
        }
        return super.toByteArray();
      }
    };
    ByteStreams.copy(paramInputStream, local1);
    return local1.toByteArray();
  }
  
  public static long skip(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    boolean bool;
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    long l1 = paramLong;
    long l2 = paramLong;
    if (l1 > 0L)
    {
      l2 = paramInputStream.skip(l1);
      if (l2 > 0L) {}
      for (;;)
      {
        l1 -= l2;
        break;
        if (paramInputStream.read() == -1) {
          break label72;
        }
        l2 = 1L;
      }
      label72:
      l2 = paramLong - l1;
    }
    return l2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\commo\\util\StreamUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */