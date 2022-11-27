package com.xiaomi.push.service;

import android.content.Context;

public class a
{
  private static volatile a jdField_a_of_type_ComXiaomiPushServiceA;
  private Context jdField_a_of_type_AndroidContentContext;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = "mipush_region";
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private final String jdField_b_of_type_JavaLangString = "mipush_country_code";
  private final String c = "mipush_region.lock";
  private final String d = "mipush_country_code.lock";
  private volatile String e;
  private volatile String f;
  
  public a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static a a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiPushServiceA == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiPushServiceA == null) {
          jdField_a_of_type_ComXiaomiPushServiceA = new a(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiPushServiceA;
  }
  
  private String a(Context paramContext, String paramString1, String paramString2, Object paramObject)
  {
    return null;
  }
  
  /* Error */
  private void a(Context arg1, String arg2, String arg3, String arg4, Object arg5)
  {
    // Byte code:
    //   0: goto +6 -> 6
    //   3: return
    //   4: astore_1
    //   5: return
    //   6: goto -3 -> 3
  }
  
  public String a()
  {
    return null;
  }
  
  /* Error */
  public void a(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String b()
  {
    return null;
  }
  
  /* Error */
  public void b(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */