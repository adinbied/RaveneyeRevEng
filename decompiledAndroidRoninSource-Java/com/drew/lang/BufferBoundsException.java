package com.drew.lang;

import java.io.IOException;

public final class BufferBoundsException
  extends IOException
{
  private static final long serialVersionUID = 2911102837808946396L;
  
  public BufferBoundsException(int paramInt1, int paramInt2, long paramLong)
  {
    super(getMessage(paramInt1, paramInt2, paramLong));
  }
  
  public BufferBoundsException(String paramString)
  {
    super(paramString);
  }
  
  private static String getMessage(int paramInt1, int paramInt2, long paramLong)
  {
    if (paramInt1 < 0) {
      return String.format("Attempt to read from buffer using a negative index (%d)", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 < 0) {
      return String.format("Number of requested bytes cannot be negative (%d)", new Object[] { Integer.valueOf(paramInt2) });
    }
    if (paramInt1 + paramInt2 - 1L > 2147483647L) {
      return String.format("Number of requested bytes summed with starting index exceed maximum range of signed 32 bit integers (requested index: %d, requested count: %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    return String.format("Attempt to read from beyond end of underlying data source (requested index: %d, requested count: %d, max index: %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong - 1L) });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\BufferBoundsException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */