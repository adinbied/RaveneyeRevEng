package com.xiaomi.push;

public enum hu
{
  private final int jdField_a_of_type_Int;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushHu = new hu("MISC_CONFIG", 0, 1);
    hu localhu = new hu("PLUGIN_CONFIG", 1, 2);
    b = localhu;
    jdField_a_of_type_ArrayOfComXiaomiPushHu = new hu[] { jdField_a_of_type_ComXiaomiPushHu, localhu };
  }
  
  private hu(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static hu a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
      return b;
    }
    return jdField_a_of_type_ComXiaomiPushHu;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\hu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */