package com.huawei.updatesdk.sdk.service.download;

import android.os.Handler;
import com.huawei.updatesdk.sdk.a.c.a.a.a;
import com.huawei.updatesdk.sdk.service.download.bean.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class d
{
  private static volatile d e;
  private static final Object f = new Object();
  protected List<DownloadTask> a = new ArrayList();
  protected b b;
  private ExecutorService c;
  private ExecutorService d;
  private Handler g;
  private boolean h = false;
  
  protected d()
  {
    a.a("HiAppDownload", "create executor with thread pool number:1");
    this.c = Executors.newFixedThreadPool(1);
    this.d = Executors.newFixedThreadPool(2);
    this.h = false;
  }
  
  public static d a()
  {
    synchronized (f)
    {
      if (e == null) {
        e = new d();
      }
      d locald = e;
      return locald;
    }
  }
  
  /* Error */
  private void e(DownloadTask arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public DownloadTask a(String paramString)
  {
    return null;
  }
  
  public void a(Handler paramHandler)
  {
    this.g = paramHandler;
  }
  
  public void a(b paramb)
  {
    this.b = paramb;
  }
  
  /* Error */
  public void a(DownloadTask arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(DownloadTask arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(String arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void b(String paramString)
  {
    a(paramString, true);
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public boolean b(DownloadTask paramDownloadTask)
  {
    return false;
  }
  
  public ExecutorService c()
  {
    return this.d;
  }
  
  /* Error */
  public void c(DownloadTask arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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
  public void d(DownloadTask arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean e()
  {
    return false;
  }
  
  public int f()
  {
    return 0;
  }
  
  public List<DownloadTask> g()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\download\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */