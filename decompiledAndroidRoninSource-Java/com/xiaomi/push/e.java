package com.xiaomi.push;

import java.io.IOException;

public abstract class e
{
  public abstract int a();
  
  public abstract e a(b paramb);
  
  public e a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public e a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = b.a(paramArrayOfByte, paramInt1, paramInt2);
      a(paramArrayOfByte);
      paramArrayOfByte.a(0);
      return this;
    }
    catch (d paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;) {}
    }
    throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
  }
  
  public abstract void a(c paramc);
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = c.a(paramArrayOfByte, paramInt1, paramInt2);
      a(paramArrayOfByte);
      paramArrayOfByte.b();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;) {}
    }
    throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
  }
  
  protected boolean a(b paramb, int paramInt)
  {
    return paramb.a(paramInt);
  }
  
  public byte[] a()
  {
    return null;
  }
  
  public abstract int b();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */