package com.xiaomi.push;

public class ds
{
  private static volatile ds jdField_a_of_type_ComXiaomiPushDs;
  private dr jdField_a_of_type_ComXiaomiPushDr;
  
  public static ds a()
  {
    if (jdField_a_of_type_ComXiaomiPushDs == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiPushDs == null) {
          jdField_a_of_type_ComXiaomiPushDs = new ds();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiPushDs;
  }
  
  public dr a()
  {
    return this.jdField_a_of_type_ComXiaomiPushDr;
  }
  
  public void a(dr paramdr)
  {
    this.jdField_a_of_type_ComXiaomiPushDr = paramdr;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */