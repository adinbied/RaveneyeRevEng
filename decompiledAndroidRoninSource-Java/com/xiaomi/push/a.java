package com.xiaomi.push;

public final class a
{
  public static final a a;
  private volatile int jdField_a_of_type_Int = 0;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushA = new a(new byte[0]);
  }
  
  private a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public static a a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static a a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new a(arrayOfByte);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ArrayOfByte.length;
  }
  
  public byte[] a()
  {
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */