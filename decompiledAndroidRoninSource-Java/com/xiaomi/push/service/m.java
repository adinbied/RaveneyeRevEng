package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class m
{
  private static m jdField_a_of_type_ComXiaomiPushServiceM;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final List<String> b = new ArrayList();
  private final List<String> c = new ArrayList();
  
  private m(Context paramContext)
  {
    Object localObject = paramContext.getApplicationContext();
    this.jdField_a_of_type_AndroidContentContext = ((Context)localObject);
    if (localObject == null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
    }
    paramContext = this.jdField_a_of_type_AndroidContentContext;
    int j = 0;
    paramContext = paramContext.getSharedPreferences("mipush_app_info", 0);
    localObject = paramContext.getString("unregistered_pkg_names", "").split(",");
    int k = localObject.length;
    int i = 0;
    CharSequence localCharSequence;
    while (i < k)
    {
      localCharSequence = localObject[i];
      if (TextUtils.isEmpty(localCharSequence)) {
        this.jdField_a_of_type_JavaUtilList.add(localCharSequence);
      }
      i += 1;
    }
    localObject = paramContext.getString("disable_push_pkg_names", "").split(",");
    k = localObject.length;
    i = 0;
    while (i < k)
    {
      localCharSequence = localObject[i];
      if (!TextUtils.isEmpty(localCharSequence)) {
        this.b.add(localCharSequence);
      }
      i += 1;
    }
    paramContext = paramContext.getString("disable_push_pkg_names_cache", "").split(",");
    k = paramContext.length;
    i = j;
    while (i < k)
    {
      localObject = paramContext[i];
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.c.add(localObject);
      }
      i += 1;
    }
  }
  
  public static m a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiPushServiceM == null) {
      jdField_a_of_type_ComXiaomiPushServiceM = new m(paramContext);
    }
    return jdField_a_of_type_ComXiaomiPushServiceM;
  }
  
  /* Error */
  public void a(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  /* Error */
  public void b(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean b(String paramString)
  {
    return false;
  }
  
  /* Error */
  public void c(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean c(String paramString)
  {
    return false;
  }
  
  /* Error */
  public void d(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void e(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void f(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */