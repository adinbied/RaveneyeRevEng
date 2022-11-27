package com.xiaomi.push;

import android.content.Context;

public class bo
{
  private static volatile bo jdField_a_of_type_ComXiaomiPushBo;
  private Context jdField_a_of_type_AndroidContentContext;
  
  private bo(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static bo a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiPushBo == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiPushBo == null) {
          jdField_a_of_type_ComXiaomiPushBo = new bo(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiPushBo;
  }
  
  public long a(String paramString1, String paramString2, long paramLong)
  {
    return 1006647180L;
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    return null;
  }
  
  /* Error */
  public void a(String arg1, String arg2, long arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(String arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */