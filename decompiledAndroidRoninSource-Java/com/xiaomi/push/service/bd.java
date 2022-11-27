package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.ConcurrentHashMap;

public final class bd
  implements af
{
  private static volatile bd jdField_a_of_type_ComXiaomiPushServiceBd;
  private long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private ConcurrentHashMap<String, a> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  private bd(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("sync", 0);
  }
  
  public static bd a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiPushServiceBd == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiPushServiceBd == null) {
          jdField_a_of_type_ComXiaomiPushServiceBd = new bd(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiPushServiceBd;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(a arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract class a
    implements Runnable
  {
    long jdField_a_of_type_Long;
    String jdField_a_of_type_JavaLangString;
    
    a(String paramString, long paramLong)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Long = paramLong;
    }
    
    abstract void a(bd parambd);
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */