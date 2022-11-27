package com.xiaomi.push.service;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.database.ContentObserver;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Process;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.db;
import com.xiaomi.push.fn;
import com.xiaomi.push.fs;
import com.xiaomi.push.fu;
import com.xiaomi.push.fv;
import com.xiaomi.push.fx;
import com.xiaomi.push.fz;
import com.xiaomi.push.gl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class XMPushService
  extends Service
  implements fx
{
  public static int a;
  private static final int d = ;
  private long jdField_a_of_type_Long = 0L;
  private ContentObserver jdField_a_of_type_AndroidDatabaseContentObserver;
  Messenger jdField_a_of_type_AndroidOsMessenger = null;
  private fs jdField_a_of_type_ComXiaomiPushFs;
  private fu jdField_a_of_type_ComXiaomiPushFu;
  private fv jdField_a_of_type_ComXiaomiPushFv;
  private fz jdField_a_of_type_ComXiaomiPushFz = new bi(this);
  private e jdField_a_of_type_ComXiaomiPushServiceXMPushService$e;
  private p jdField_a_of_type_ComXiaomiPushServiceXMPushService$p;
  private al jdField_a_of_type_ComXiaomiPushServiceAl = null;
  private aw jdField_a_of_type_ComXiaomiPushServiceAw;
  private d jdField_a_of_type_ComXiaomiPushServiceD;
  private g jdField_a_of_type_ComXiaomiPushServiceG = null;
  protected Class a;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<l> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Collection<af> jdField_a_of_type_JavaUtilCollection = Collections.synchronizedCollection(new ArrayList());
  private int jdField_b_of_type_Int;
  private ContentObserver jdField_b_of_type_AndroidDatabaseContentObserver;
  private int c = 0;
  
  static
  {
    db.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
    jdField_a_of_type_Int = 1;
  }
  
  public XMPushService()
  {
    this.b = 0;
    this.jdField_a_of_type_JavaLangClass = XMJobService.class;
  }
  
  public static Notification a(Context paramContext)
  {
    Object localObject2 = new Intent(paramContext, XMPushService.class);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject1 = new Notification.Builder(paramContext);
      ((Notification.Builder)localObject1).setSmallIcon(paramContext.getApplicationInfo().icon);
      ((Notification.Builder)localObject1).setContentTitle("Push Service");
      ((Notification.Builder)localObject1).setContentText("Push Service");
      ((Notification.Builder)localObject1).setContentIntent(PendingIntent.getActivity(paramContext, 0, (Intent)localObject2, 0));
      return ((Notification.Builder)localObject1).getNotification();
    }
    Object localObject1 = new Notification();
    localObject2 = PendingIntent.getService(paramContext, 0, (Intent)localObject2, 0);
    try
    {
      localObject1.getClass().getMethod("setLatestEventInfo", new Class[] { Context.class, CharSequence.class, CharSequence.class, PendingIntent.class }).invoke(localObject1, new Object[] { paramContext, "Push Service", "Push Service", localObject2 });
      return (Notification)localObject1;
    }
    catch (Exception paramContext)
    {
      b.a(paramContext);
    }
    return (Notification)localObject1;
  }
  
  private gl a(gl paramgl, String paramString1, String paramString2)
  {
    return null;
  }
  
  private am.b a(String paramString, Intent paramIntent)
  {
    return null;
  }
  
  private String a()
  {
    return null;
  }
  
  private void a(BroadcastReceiver paramBroadcastReceiver)
  {
    if (paramBroadcastReceiver != null) {
      try
      {
        unregisterReceiver(paramBroadcastReceiver);
        return;
      }
      catch (IllegalArgumentException paramBroadcastReceiver)
      {
        b.a(paramBroadcastReceiver);
      }
    }
  }
  
  /* Error */
  private void a(Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void a(Intent arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void a(String arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean a(Context paramContext)
  {
    return false;
  }
  
  private boolean a(String paramString, Intent paramIntent)
  {
    return false;
  }
  
  private int[] a()
  {
    return null;
  }
  
  /* Error */
  private void b(Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void b(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void c(Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private void c(i parami)
  {
    this.jdField_a_of_type_ComXiaomiPushServiceG.a(parami);
  }
  
  /* Error */
  private void c(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
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
  private void d(Intent arg1)
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
    //   2: goto -2 -> 0
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
    //   2: goto -2 -> 0
  }
  
  private boolean f()
  {
    return false;
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private boolean g()
  {
    return false;
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean h()
  {
    return false;
  }
  
  /* Error */
  private void i()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private boolean i()
  {
    return false;
  }
  
  private boolean j()
  {
    return false;
  }
  
  private boolean k()
  {
    return false;
  }
  
  private boolean l()
  {
    return false;
  }
  
  public fu a()
  {
    return this.jdField_a_of_type_ComXiaomiPushFu;
  }
  
  public d a()
  {
    return new d();
  }
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComXiaomiPushServiceG.a(paramInt);
  }
  
  /* Error */
  public void a(int arg1, Exception arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(fn arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(fu arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(fu arg1, int arg2, Exception arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(fu arg1, Exception arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(i parami)
  {
    a(parami, 0L);
  }
  
  /* Error */
  public void a(i arg1, long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(l arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(am.b arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1, String arg2, int arg3, String arg4, String arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void a(String arg1, byte[] arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComXiaomiPushServiceAw.a(paramBoolean);
  }
  
  /* Error */
  public void a(byte[] arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(fn[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ComXiaomiPushServiceG.a(paramInt);
  }
  
  public d b()
  {
    return this.jdField_a_of_type_ComXiaomiPushServiceD;
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void b(fu arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void b(i parami)
  {
    this.jdField_a_of_type_ComXiaomiPushServiceG.a(parami.jdField_a_of_type_Int, parami);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.jdField_a_of_type_AndroidOsMessenger.getBinder();
  }
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onStart(Intent arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    onStart(paramIntent, paramInt2);
    return jdField_a_of_type_Int;
  }
  
  class a
    extends XMPushService.i
  {
    am.b jdField_a_of_type_ComXiaomiPushServiceAm$b = null;
    
    public a(am.b paramb)
    {
      super();
      this.jdField_a_of_type_ComXiaomiPushServiceAm$b = paramb;
    }
    
    public String a()
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
  }
  
  static class b
    extends XMPushService.i
  {
    private final am.b a;
    
    public b(am.b paramb)
    {
      super();
      this.a = paramb;
    }
    
    public String a()
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
    
    public boolean equals(Object paramObject)
    {
      return false;
    }
    
    public int hashCode()
    {
      return 0;
    }
  }
  
  class c
    extends XMPushService.i
  {
    private fn jdField_a_of_type_ComXiaomiPushFn = null;
    
    public c(fn paramfn)
    {
      super();
      this.jdField_a_of_type_ComXiaomiPushFn = paramfn;
    }
    
    public String a()
    {
      return "receive a message.";
    }
    
    /* Error */
    public void a()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public class d
    extends XMPushService.i
  {
    d()
    {
      super();
    }
    
    public String a()
    {
      return "do reconnect..";
    }
    
    /* Error */
    public void a()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  class e
    extends BroadcastReceiver
  {
    e() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      XMPushService.this.onStart(paramIntent, XMPushService.a);
    }
  }
  
  public class f
    extends XMPushService.i
  {
    public Exception a;
    public int b;
    
    f(int paramInt, Exception paramException)
    {
      super();
      this.b = paramInt;
      this.jdField_a_of_type_JavaLangException = paramException;
    }
    
    public String a()
    {
      return "disconnect the connection.";
    }
    
    /* Error */
    public void a()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  class g
    extends XMPushService.i
  {
    g()
    {
      super();
    }
    
    public String a()
    {
      return "Init Job";
    }
    
    public void a()
    {
      XMPushService.b(XMPushService.this);
    }
  }
  
  class h
    extends XMPushService.i
  {
    private Intent jdField_a_of_type_AndroidContentIntent = null;
    
    public h(Intent paramIntent)
    {
      super();
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
    
    public String a()
    {
      return null;
    }
    
    public void a()
    {
      XMPushService.a(XMPushService.this, this.jdField_a_of_type_AndroidContentIntent);
    }
  }
  
  public static abstract class i
    extends g.b
  {
    public i(int paramInt)
    {
      super();
    }
    
    public abstract String a();
    
    public abstract void a();
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  class j
    extends XMPushService.i
  {
    public j()
    {
      super();
    }
    
    public String a()
    {
      return "ask the job queue to quit";
    }
    
    /* Error */
    public void a()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  class k
    extends XMPushService.i
  {
    private gl jdField_a_of_type_ComXiaomiPushGl = null;
    
    public k(gl paramgl)
    {
      super();
      this.jdField_a_of_type_ComXiaomiPushGl = paramgl;
    }
    
    public String a()
    {
      return "receive a message.";
    }
    
    /* Error */
    public void a()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static abstract interface l
  {
    public abstract void a();
  }
  
  class m
    extends XMPushService.i
  {
    boolean jdField_a_of_type_Boolean;
    
    public m(boolean paramBoolean)
    {
      super();
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
    
    public String a()
    {
      return "send ping..";
    }
    
    /* Error */
    public void a()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  class n
    extends XMPushService.i
  {
    am.b jdField_a_of_type_ComXiaomiPushServiceAm$b = null;
    
    public n(am.b paramb)
    {
      super();
      this.jdField_a_of_type_ComXiaomiPushServiceAm$b = paramb;
    }
    
    public String a()
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
  }
  
  class o
    extends XMPushService.i
  {
    o()
    {
      super();
    }
    
    public String a()
    {
      return "reset the connection.";
    }
    
    /* Error */
    public void a()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  class p
    extends BroadcastReceiver
  {
    p() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      XMPushService.this.onStart(paramIntent, 1);
    }
  }
  
  class q
    extends XMPushService.i
  {
    am.b jdField_a_of_type_ComXiaomiPushServiceAm$b = null;
    String jdField_a_of_type_JavaLangString;
    int jdField_b_of_type_Int;
    String jdField_b_of_type_JavaLangString;
    
    public q(am.b paramb, int paramInt, String paramString1, String paramString2)
    {
      super();
      this.jdField_a_of_type_ComXiaomiPushServiceAm$b = paramb;
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
    }
    
    public String a()
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\XMPushService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */