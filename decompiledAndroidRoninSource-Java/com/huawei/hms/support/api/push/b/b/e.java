package com.huawei.hms.support.api.push.b.b;

import com.huawei.hms.support.api.push.b.a.a.a;

public abstract class e
{
  public static byte[] a()
  {
    byte[] arrayOfByte1 = a.b(com.huawei.hms.support.api.push.b.a.a.b.a());
    byte[] arrayOfByte2 = a.b(b.a());
    byte[] arrayOfByte3 = a.b(b());
    return a(a(a(arrayOfByte1, arrayOfByte2), arrayOfByte3));
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      while (i < paramArrayOfByte.length)
      {
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] >> 2));
        i += 1;
      }
      return paramArrayOfByte;
    }
    return new byte[0];
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte1.length != 0) && (paramArrayOfByte2.length != 0))
    {
      int j = paramArrayOfByte1.length;
      if (j != paramArrayOfByte2.length) {
        return new byte[0];
      }
      byte[] arrayOfByte = new byte[j];
      while (i < j)
      {
        arrayOfByte[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
        i += 1;
      }
      return arrayOfByte;
    }
    return new byte[0];
  }
  
  private static String b()
  {
    return "2A57086C86EF54970C1E6EB37BFC72B1";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\b\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */