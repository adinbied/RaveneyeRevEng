package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class c
{
  private final int jdField_a_of_type_Int;
  private final OutputStream jdField_a_of_type_JavaIoOutputStream;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  
  private c(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_JavaIoOutputStream = paramOutputStream;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.b = 0;
    this.jdField_a_of_type_Int = paramArrayOfByte.length;
  }
  
  private c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaIoOutputStream = null;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.b = paramInt1;
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt >= 0) {
      return d(paramInt);
    }
    return 10;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return c(paramInt1) + a(paramInt2);
  }
  
  public static int a(int paramInt, long paramLong)
  {
    return c(paramInt) + a(paramLong);
  }
  
  public static int a(int paramInt, a parama)
  {
    return c(paramInt) + a(parama);
  }
  
  public static int a(int paramInt, e parame)
  {
    return c(paramInt) + a(parame);
  }
  
  public static int a(int paramInt, String paramString)
  {
    return c(paramInt) + a(paramString);
  }
  
  public static int a(int paramInt, boolean paramBoolean)
  {
    return c(paramInt) + a(paramBoolean);
  }
  
  public static int a(long paramLong)
  {
    return c(paramLong);
  }
  
  public static int a(a parama)
  {
    return d(parama.a()) + parama.a();
  }
  
  public static int a(e parame)
  {
    int i = parame.b();
    return d(i) + i;
  }
  
  public static int a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = d(paramString.length);
      int j = paramString.length;
      return i + j;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
    throw new RuntimeException("UTF-8 not supported.");
  }
  
  public static int a(boolean paramBoolean)
  {
    return 1;
  }
  
  public static c a(OutputStream paramOutputStream)
  {
    return a(paramOutputStream, 4096);
  }
  
  public static c a(OutputStream paramOutputStream, int paramInt)
  {
    return new c(paramOutputStream, new byte[paramInt]);
  }
  
  public static c a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new c(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int b(int paramInt)
  {
    return d(paramInt);
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    return c(paramInt1) + b(paramInt2);
  }
  
  public static int b(int paramInt, long paramLong)
  {
    return c(paramInt) + b(paramLong);
  }
  
  public static int b(long paramLong)
  {
    return c(paramLong);
  }
  
  public static int c(int paramInt)
  {
    return d(f.a(paramInt, 0));
  }
  
  public static int c(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0xFFFFFFF800000000 & paramLong) == 0L) {
      return 5;
    }
    if ((0xFFFFFC0000000000 & paramLong) == 0L) {
      return 6;
    }
    if ((0xFFFE000000000000 & paramLong) == 0L) {
      return 7;
    }
    if ((0xFF00000000000000 & paramLong) == 0L) {
      return 8;
    }
    if ((paramLong & 0x8000000000000000) == 0L) {
      return 9;
    }
    return 10;
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static int d(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((paramInt & 0xF0000000) == 0) {
      return 4;
    }
    return 5;
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaIoOutputStream != null) {
      c();
    }
  }
  
  /* Error */
  public void a(byte arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, 0);
    a(paramInt2);
  }
  
  public void a(int paramInt, long paramLong)
  {
    c(paramInt, 0);
    a(paramLong);
  }
  
  public void a(int paramInt, a parama)
  {
    c(paramInt, 2);
    a(parama);
  }
  
  public void a(int paramInt, e parame)
  {
    c(paramInt, 2);
    a(parame);
  }
  
  public void a(int paramInt, String paramString)
  {
    c(paramInt, 2);
    a(paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    c(paramInt, 0);
    a(paramBoolean);
  }
  
  public void a(long paramLong)
  {
    c(paramLong);
  }
  
  /* Error */
  public void a(a arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(e arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  /* Error */
  public void a(byte[] arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void b(int paramInt)
  {
    d(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, 0);
    b(paramInt2);
  }
  
  public void b(int paramInt, long paramLong)
  {
    c(paramInt, 0);
    b(paramLong);
  }
  
  public void b(long paramLong)
  {
    c(paramLong);
  }
  
  public void c(int paramInt)
  {
    a((byte)paramInt);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    d(f.a(paramInt1, paramInt2));
  }
  
  /* Error */
  public void c(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void d(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public static class a
    extends IOException
  {
    a()
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */