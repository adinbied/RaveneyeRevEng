package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;

public class ah
{
  private static volatile ah jdField_a_of_type_ComXiaomiPushServiceAh;
  protected SharedPreferences a;
  private HashSet<a> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  
  private ah(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("mipush_oc", 0);
  }
  
  public static ah a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiPushServiceAh == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiPushServiceAh == null) {
          jdField_a_of_type_ComXiaomiPushServiceAh = new ah(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiPushServiceAh;
  }
  
  private String a(int paramInt)
  {
    return null;
  }
  
  /* Error */
  private void a(android.content.SharedPreferences.Editor arg1, android.util.Pair<Integer, Object> arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private String b(int paramInt)
  {
    return null;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public String a(int paramInt, String paramString)
  {
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(a arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(java.util.List<android.util.Pair<Integer, Object>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    return false;
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void b(java.util.List<android.util.Pair<Integer, Object>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract class a
    implements Runnable
  {
    private int jdField_a_of_type_Int;
    private String jdField_a_of_type_JavaLangString;
    
    public a(int paramInt, String paramString)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    
    protected abstract void a();
    
    public boolean equals(Object paramObject)
    {
      return false;
    }
    
    public int hashCode()
    {
      return this.jdField_a_of_type_Int;
    }
    
    public final void run()
    {
      a();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */