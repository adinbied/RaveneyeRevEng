package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

class StreamUtil
{
  private static final long MAX_MEMORY = Runtime.getRuntime().maxMemory();
  
  static int calculateBodyLength(int paramInt)
  {
    int j = 1;
    int k = 1;
    if (paramInt > 127)
    {
      j = 1;
      int i = paramInt;
      paramInt = j;
      for (;;)
      {
        i >>>= 8;
        if (i == 0) {
          break;
        }
        paramInt += 1;
      }
      i = (paramInt - 1) * 8;
      paramInt = k;
      for (;;)
      {
        j = paramInt;
        if (i < 0) {
          break;
        }
        paramInt += 1;
        i -= 8;
      }
    }
    return j;
  }
  
  static int calculateTagLength(int paramInt)
    throws IOException
  {
    int i = 1;
    if (paramInt >= 31)
    {
      if (paramInt < 128) {
        return 2;
      }
      byte[] arrayOfByte = new byte[5];
      i = 4;
      int j;
      int k;
      do
      {
        j = paramInt >> 7;
        k = i - 1;
        arrayOfByte[k] = ((byte)(j & 0x7F | 0x80));
        i = k;
        paramInt = j;
      } while (j > 127);
      i = 1 + (5 - k);
    }
    return i;
  }
  
  static int findLimit(InputStream paramInputStream)
  {
    if ((paramInputStream instanceof LimitedInputStream)) {
      return ((LimitedInputStream)paramInputStream).getRemaining();
    }
    if ((paramInputStream instanceof ASN1InputStream)) {
      return ((ASN1InputStream)paramInputStream).getLimit();
    }
    if ((paramInputStream instanceof ByteArrayInputStream)) {
      return ((ByteArrayInputStream)paramInputStream).available();
    }
    if ((paramInputStream instanceof FileInputStream)) {}
    try
    {
      paramInputStream = ((FileInputStream)paramInputStream).getChannel();
      if (paramInputStream != null) {
        l = paramInputStream.size();
      } else {
        l = 2147483647L;
      }
      if (l < 2147483647L) {
        return (int)l;
      }
    }
    catch (IOException paramInputStream)
    {
      long l;
      for (;;) {}
    }
    l = MAX_MEMORY;
    if (l > 2147483647L) {
      return Integer.MAX_VALUE;
    }
    return (int)l;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\StreamUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */