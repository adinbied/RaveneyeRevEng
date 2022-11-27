package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.HashMap;
import java.util.Map;

public class hm
{
  private static hm jdField_a_of_type_ComXiaomiPushHm;
  private final Context jdField_a_of_type_AndroidContentContext;
  private Map<String, hn> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private hm(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static hm a(Context paramContext)
  {
    if (paramContext == null)
    {
      b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
      return null;
    }
    if (jdField_a_of_type_ComXiaomiPushHm == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiPushHm == null) {
          jdField_a_of_type_ComXiaomiPushHm = new hm(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiPushHm;
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    return false;
  }
  
  hn a()
  {
    return null;
  }
  
  Map<String, hn> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  /* Error */
  public void a(hn arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean a(hs paramhs, String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\hm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */