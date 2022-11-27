package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;

class StreamProcessor
{
  public static int readPackedInt(InputStream paramInputStream, int paramInt, boolean paramBoolean)
    throws IOException
  {
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      int k = paramInputStream.read();
      if (k != -1)
      {
        if (paramBoolean)
        {
          k = (k & 0xFF) << j * 8;
        }
        else
        {
          i <<= 8;
          k &= 0xFF;
        }
        i |= k;
        j += 1;
      }
      else
      {
        throw new IOException("no more bytes");
      }
    }
    return i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imageutils\StreamProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */