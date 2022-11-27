package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.service.aa;
import java.util.HashMap;

public final class es
{
  private static volatile es jdField_a_of_type_ComXiaomiPushEs;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ew jdField_a_of_type_ComXiaomiPushEw;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<eu, ev> jdField_a_of_type_JavaUtilHashMap;
  private String b;
  
  private es(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap = localHashMap;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    localHashMap.put(eu.b, new ey());
    this.jdField_a_of_type_JavaUtilHashMap.put(eu.c, new ez());
    this.jdField_a_of_type_JavaUtilHashMap.put(eu.a, new eq());
    this.jdField_a_of_type_JavaUtilHashMap.put(eu.d, new ex());
  }
  
  public static es a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiPushEs == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiPushEs == null) {
          jdField_a_of_type_ComXiaomiPushEs = new es(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiPushEs;
  }
  
  /* Error */
  private void a(eu arg1, Context arg2, er arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static boolean a(Context paramContext)
  {
    return aa.a(paramContext, paramContext.getPackageName());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ew a()
  {
    return this.jdField_a_of_type_ComXiaomiPushEw;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  /* Error */
  public void a(Context arg1, String arg2, int arg3, String arg4, String arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(eu arg1, Context arg2, android.content.Intent arg3, String arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(ew paramew)
  {
    this.jdField_a_of_type_ComXiaomiPushEw = paramew;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, int paramInt, ew paramew)
  {
    a(paramString1);
    b(paramString2);
    a(paramInt);
    a(paramew);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\es.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */