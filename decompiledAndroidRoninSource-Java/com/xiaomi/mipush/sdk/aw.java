package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.xiaomi.push.ho;
import com.xiaomi.push.iz;
import java.util.ArrayList;
import java.util.List;

public class aw
{
  private static aw jdField_a_of_type_ComXiaomiMipushSdkAw;
  private static final ArrayList<a> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean b;
  private Context jdField_a_of_type_AndroidContentContext;
  private Intent jdField_a_of_type_AndroidContentIntent = null;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private Messenger jdField_a_of_type_AndroidOsMessenger;
  private Integer jdField_a_of_type_JavaLangInteger = null;
  private String jdField_a_of_type_JavaLangString;
  private List<Message> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean c = false;
  
  private aw(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = c();
    b = d();
    this.jdField_a_of_type_AndroidOsHandler = new ax(this, Looper.getMainLooper());
    paramContext = b();
    if (paramContext != null) {
      b(paramContext);
    }
  }
  
  private int a()
  {
    return 0;
  }
  
  private Intent a()
  {
    return null;
  }
  
  private Message a(Intent paramIntent)
  {
    return null;
  }
  
  public static aw a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_ComXiaomiMipushSdkAw == null) {
        jdField_a_of_type_ComXiaomiMipushSdkAw = new aw(paramContext);
      }
      paramContext = jdField_a_of_type_ComXiaomiMipushSdkAw;
      return paramContext;
    }
    finally {}
  }
  
  private String a()
  {
    return null;
  }
  
  /* Error */
  private void a(String arg1, bb arg2, boolean arg3, java.util.HashMap<String, String> arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private Intent b()
  {
    return null;
  }
  
  /* Error */
  private void b(Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private Intent c()
  {
    return null;
  }
  
  /* Error */
  private void c(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  private void c(Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean c()
  {
    return false;
  }
  
  private Intent d()
  {
    return null;
  }
  
  /* Error */
  private void d(Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private boolean d()
  {
    return false;
  }
  
  private Intent e()
  {
    return null;
  }
  
  private boolean e()
  {
    return false;
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void a()
  {
    b(a());
  }
  
  /* Error */
  public void a(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void a(int arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void a(Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void a(com.xiaomi.push.hs arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void a(com.xiaomi.push.io arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void a(com.xiaomi.push.iu arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final <T extends iz<T, ?>> void a(T arg1, ho arg2, com.xiaomi.push.ib arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public <T extends iz<T, ?>> void a(T arg1, ho arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public final <T extends iz<T, ?>> void a(T arg1, ho arg2, boolean arg3, com.xiaomi.push.ib arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final <T extends iz<T, ?>> void a(T arg1, ho arg2, boolean arg3, com.xiaomi.push.ib arg4, boolean arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final <T extends iz<T, ?>> void a(T arg1, ho arg2, boolean arg3, boolean arg4, com.xiaomi.push.ib arg5, boolean arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final <T extends iz<T, ?>> void a(T arg1, ho arg2, boolean arg3, boolean arg4, com.xiaomi.push.ib arg5, boolean arg6, String arg7, String arg8)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void a(String arg1, bb arg2, d arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final void a(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  /* Error */
  public final void a(boolean arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void b(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public boolean b()
  {
    return false;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static class a<T extends iz<T, ?>>
  {
    ho jdField_a_of_type_ComXiaomiPushHo;
    T jdField_a_of_type_ComXiaomiPushIz;
    boolean jdField_a_of_type_Boolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */