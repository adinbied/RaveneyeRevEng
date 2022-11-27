package com.xiaomi.push;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class gs
{
  private static gs jdField_a_of_type_ComXiaomiPushGs;
  private Map<String, Object> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Map<String, Object> b = new ConcurrentHashMap();
  
  private gs()
  {
    a();
  }
  
  public static gs a()
  {
    try
    {
      if (jdField_a_of_type_ComXiaomiPushGs == null) {
        jdField_a_of_type_ComXiaomiPushGs = new gs();
      }
      gs localgs = jdField_a_of_type_ComXiaomiPushGs;
      return localgs;
    }
    finally {}
  }
  
  private String a(String paramString1, String paramString2)
  {
    return null;
  }
  
  private ClassLoader[] a()
  {
    return null;
  }
  
  public Object a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramString2);
    return this.jdField_a_of_type_JavaUtilMap.get(paramString1);
  }
  
  /* Error */
  protected void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(String arg1, String arg2, Object arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\gs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */