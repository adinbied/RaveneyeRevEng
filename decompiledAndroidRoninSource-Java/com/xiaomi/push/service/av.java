package com.xiaomi.push.service;

import com.xiaomi.push.bc;

public class av
{
  private static int jdField_a_of_type_Int = 8;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b = 0;
  private int c = 0;
  private int d = 64870;
  
  public av()
  {
    this.a = new byte['Ā'];
  }
  
  public static int a(byte paramByte)
  {
    if (paramByte >= 0) {
      return paramByte;
    }
    return paramByte + 256;
  }
  
  private void a()
  {
    this.c = 0;
    this.b = 0;
  }
  
  /* Error */
  private void a(int arg1, byte[] arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    a(256, paramArrayOfByte, false);
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[paramInt1];
    paramArrayOfByte[paramInt1] = paramArrayOfByte[paramInt2];
    paramArrayOfByte[paramInt2] = i;
  }
  
  public static byte[] a(String paramString1, String paramString2)
  {
    paramString1 = bc.a(paramString1);
    paramString2 = paramString2.getBytes();
    byte[] arrayOfByte = new byte[paramString1.length + 1 + paramString2.length];
    int j = 0;
    int i = 0;
    while (i < paramString1.length)
    {
      arrayOfByte[i] = paramString1[i];
      i += 1;
    }
    arrayOfByte[paramString1.length] = 95;
    i = j;
    while (i < paramString2.length)
    {
      arrayOfByte[(paramString1.length + 1 + i)] = paramString2[i];
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    return a(paramArrayOfByte, bc.a(paramString));
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte2.length];
    av localav = new av();
    localav.a(paramArrayOfByte1);
    localav.a();
    int i = 0;
    while (i < paramArrayOfByte2.length)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte2[i] ^ localav.a()));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= paramArrayOfByte2.length) && (paramInt1 + paramInt2 <= paramArrayOfByte2.length))
    {
      int j = 0;
      byte[] arrayOfByte;
      int i;
      if (!paramBoolean)
      {
        arrayOfByte = new byte[paramInt2];
        i = 0;
      }
      else
      {
        arrayOfByte = paramArrayOfByte2;
        i = paramInt1;
      }
      av localav = new av();
      localav.a(paramArrayOfByte1);
      localav.a();
      while (j < paramInt2)
      {
        arrayOfByte[(i + j)] = ((byte)(paramArrayOfByte2[(paramInt1 + j)] ^ localav.a()));
        j += 1;
      }
      return arrayOfByte;
    }
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("start = ");
    paramArrayOfByte1.append(paramInt1);
    paramArrayOfByte1.append(" len = ");
    paramArrayOfByte1.append(paramInt2);
    throw new IllegalArgumentException(paramArrayOfByte1.toString());
  }
  
  byte a()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */