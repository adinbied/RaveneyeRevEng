package com.xiaomi.push;

public enum hp
{
  private final int jdField_a_of_type_Int;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushHp = new hp("START", 0, 0);
    hp localhp = new hp("BIND", 1, 1);
    b = localhp;
    jdField_a_of_type_ArrayOfComXiaomiPushHp = new hp[] { jdField_a_of_type_ComXiaomiPushHp, localhp };
  }
  
  private hp(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\hp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */