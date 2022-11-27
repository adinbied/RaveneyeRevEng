package com.xiaomi.push;

public class dw
{
  private static void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 2)
    {
      paramArrayOfByte[0] = 99;
      paramArrayOfByte[1] = 100;
    }
  }
  
  public static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    paramString = bc.a(paramString);
    try
    {
      a(paramString);
      paramString = h.a(paramString, paramArrayOfByte);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static byte[] b(String paramString, byte[] paramArrayOfByte)
  {
    paramString = bc.a(paramString);
    try
    {
      a(paramString);
      paramString = h.b(paramString, paramArrayOfByte);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */