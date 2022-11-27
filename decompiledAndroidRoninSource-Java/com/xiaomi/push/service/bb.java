package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xiaomi.push.al.b;
import com.xiaomi.push.el.a;
import com.xiaomi.push.em.b;
import com.xiaomi.push.i;
import com.xiaomi.push.t;
import java.util.ArrayList;
import java.util.List;

public class bb
{
  private static bb jdField_a_of_type_ComXiaomiPushServiceBb = new bb();
  private static String jdField_a_of_type_JavaLangString;
  private al.b jdField_a_of_type_ComXiaomiPushAl$b;
  private el.a jdField_a_of_type_ComXiaomiPushEl$a;
  private List<a> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static bb a()
  {
    return jdField_a_of_type_ComXiaomiPushServiceBb;
  }
  
  public static String a()
  {
    try
    {
      if (jdField_a_of_type_JavaLangString == null)
      {
        localObject1 = t.a().getSharedPreferences("XMPushServiceConfig", 0);
        String str = ((SharedPreferences)localObject1).getString("DeviceUUID", null);
        jdField_a_of_type_JavaLangString = str;
        if (str == null)
        {
          str = i.a(t.a(), false);
          jdField_a_of_type_JavaLangString = str;
          if (str != null) {
            ((SharedPreferences)localObject1).edit().putString("DeviceUUID", jdField_a_of_type_JavaLangString).commit();
          }
        }
      }
      Object localObject1 = jdField_a_of_type_JavaLangString;
      return (String)localObject1;
    }
    finally {}
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComXiaomiPushEl$a == null) {
      d();
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  int a()
  {
    return 0;
  }
  
  public el.a a()
  {
    b();
    return this.jdField_a_of_type_ComXiaomiPushEl$a;
  }
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void a(em.b arg1)
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
  
  public static abstract class a
  {
    public void a(el.a parama) {}
    
    public void a(em.b paramb) {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */