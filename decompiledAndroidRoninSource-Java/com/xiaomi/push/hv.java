package com.xiaomi.push;

public enum hv
{
  private final int jdField_a_of_type_Int;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushHv = new hv("INT", 0, 1);
    b = new hv("LONG", 1, 2);
    c = new hv("STRING", 2, 3);
    hv localhv = new hv("BOOLEAN", 3, 4);
    d = localhv;
    jdField_a_of_type_ArrayOfComXiaomiPushHv = new hv[] { jdField_a_of_type_ComXiaomiPushHv, b, c, localhv };
  }
  
  private hv(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static hv a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return null;
          }
          return d;
        }
        return c;
      }
      return b;
    }
    return jdField_a_of_type_ComXiaomiPushHv;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\hv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */