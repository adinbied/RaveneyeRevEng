package com.xiaomi.push;

public enum ic
{
  private final int jdField_a_of_type_Int;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushIc = new ic("RegIdExpired", 0, 0);
    b = new ic("PackageUnregistered", 1, 1);
    ic localic = new ic("Init", 2, 2);
    c = localic;
    jdField_a_of_type_ArrayOfComXiaomiPushIc = new ic[] { jdField_a_of_type_ComXiaomiPushIc, b, localic };
  }
  
  private ic(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static ic a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return null;
        }
        return c;
      }
      return b;
    }
    return jdField_a_of_type_ComXiaomiPushIc;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */