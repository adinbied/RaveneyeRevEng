package com.xiaomi.push;

public final class jt
  extends ju
{
  private int jdField_a_of_type_Int;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int += paramInt;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException("No writing allowed!");
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public int b()
  {
    return this.b - this.jdField_a_of_type_Int;
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = (paramInt1 + paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\jt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */