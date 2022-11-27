package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;

public class au
  implements ar
{
  private static volatile au jdField_a_of_type_ComXiaomiPushAu;
  private ar jdField_a_of_type_ComXiaomiPushAr;
  
  private au(Context paramContext)
  {
    this.jdField_a_of_type_ComXiaomiPushAr = at.a(paramContext);
    paramContext = new StringBuilder();
    paramContext.append("create id manager is: ");
    paramContext.append(this.jdField_a_of_type_ComXiaomiPushAr);
    b.a(paramContext.toString());
  }
  
  public static au a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiPushAu == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiPushAu == null) {
          jdField_a_of_type_ComXiaomiPushAu = new au(paramContext.getApplicationContext());
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiPushAu;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public String a()
  {
    return null;
  }
  
  /* Error */
  public void a(java.util.Map<String, String> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComXiaomiPushAr.a();
  }
  
  public String b()
  {
    return null;
  }
  
  public String c()
  {
    return null;
  }
  
  public String d()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */