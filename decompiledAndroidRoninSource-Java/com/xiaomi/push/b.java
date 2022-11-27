package com.xiaomi.push;

import java.io.InputStream;

public final class b
{
  private int jdField_a_of_type_Int;
  private final InputStream jdField_a_of_type_JavaIoInputStream;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f = Integer.MAX_VALUE;
  private int g;
  private int h = 64;
  private int i = 67108864;
  
  private b(InputStream paramInputStream)
  {
    this.jdField_a_of_type_ArrayOfByte = new byte['က'];
    this.jdField_a_of_type_Int = 0;
    this.c = 0;
    this.jdField_a_of_type_JavaIoInputStream = paramInputStream;
  }
  
  private b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Int = (paramInt2 + paramInt1);
    this.c = paramInt1;
    this.jdField_a_of_type_JavaIoInputStream = null;
  }
  
  public static b a(InputStream paramInputStream)
  {
    return new b(paramInputStream);
  }
  
  public static b a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public byte a()
  {
    return 0;
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public long a()
  {
    return c();
  }
  
  public a a()
  {
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
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
  
  /* Error */
  public void a(e arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public byte[] a(int paramInt)
  {
    return null;
  }
  
  public int b()
  {
    return d();
  }
  
  public long b()
  {
    return c();
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
    b();
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return d();
  }
  
  public long c()
  {
    return 1006647168L;
  }
  
  /* Error */
  public void c(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public int d()
  {
    return 0;
  }
  
  public long d()
  {
    return 1006647171L;
  }
  
  public int e()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */