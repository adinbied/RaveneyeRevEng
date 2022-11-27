package com.huawei.updatesdk.sdk.service.download;

import android.os.Handler;
import com.huawei.updatesdk.sdk.service.download.bean.DownloadTask;
import com.huawei.updatesdk.sdk.service.download.bean.a;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class e
  implements j, Runnable
{
  private b a = new com.huawei.updatesdk.service.deamon.download.b();
  private Handler b;
  private volatile boolean c = true;
  private boolean d = false;
  private int e = 0;
  private int f = 0;
  private long g = 0L;
  private long h = 0L;
  private c i = null;
  private DownloadTask j;
  private Object k = new byte[0];
  private List<f> l = new ArrayList();
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private a q = new a();
  private int r = 0;
  
  public e(DownloadTask paramDownloadTask, Handler paramHandler)
  {
    this.j = paramDownloadTask;
    paramDownloadTask.c(null);
    this.b = paramHandler;
  }
  
  /* Error */
  private void A()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void a(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(java.io.File arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(boolean arg1)
    throws c
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  private void a(boolean arg1, List<String> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private boolean a(HttpURLConnection paramHttpURLConnection)
  {
    return false;
  }
  
  /* Error */
  private void b(c arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void b(boolean arg1)
    throws c
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  static boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.toLowerCase(Locale.getDefault()).startsWith("https");
  }
  
  private HttpURLConnection c(String paramString)
    throws c
  {
    return null;
  }
  
  /* Error */
  private void c(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private boolean c(c paramc)
  {
    return false;
  }
  
  private boolean d()
    throws c
  {
    return false;
  }
  
  private boolean d(String paramString)
  {
    return false;
  }
  
  /* Error */
  private void e()
    throws c
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private boolean f()
  {
    return false;
  }
  
  /* Error */
  private void g()
    throws c
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void h()
    throws c
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void i()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean j()
    throws c
  {
    return false;
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void l()
    throws c
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void m()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void n()
    throws c
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean o()
  {
    return false;
  }
  
  private boolean p()
  {
    return false;
  }
  
  private boolean q()
  {
    return false;
  }
  
  /* Error */
  private void r()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void s()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void t()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void u()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void v()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void w()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void x()
    throws c
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void y()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void z()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String a(String paramString)
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
  
  public void a(b paramb)
  {
    this.a = paramb;
  }
  
  /* Error */
  public void a(c arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void c()
    throws c
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\download\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */