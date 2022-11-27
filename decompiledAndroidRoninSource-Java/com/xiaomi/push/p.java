package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;

public class p
{
  private static volatile p jdField_a_of_type_ComXiaomiPushP;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Map<String, Map<String, String>> jdField_a_of_type_JavaUtilMap;
  
  private p(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static p a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiPushP == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiPushP == null) {
          jdField_a_of_type_ComXiaomiPushP = new p(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiPushP;
  }
  
  private String a(String paramString1, String paramString2)
  {
    return null;
  }
  
  /* Error */
  private void b(String arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    return null;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */