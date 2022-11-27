package com.huawei.updatesdk.service.deamon.download;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.huawei.updatesdk.sdk.a.d.b.a;
import com.huawei.updatesdk.sdk.service.download.bean.DownloadTask;
import com.huawei.updatesdk.sdk.service.download.d;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadService
  extends Service
{
  private static boolean b;
  protected d a;
  private final AtomicInteger c = new AtomicInteger();
  private final IBinder d = new a();
  
  private static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean a()
  {
    return b;
  }
  
  private boolean b()
  {
    return a.e();
  }
  
  public void a(String paramString)
  {
    this.a.b(paramString);
  }
  
  public boolean a(DownloadTask paramDownloadTask)
  {
    return false;
  }
  
  public DownloadTask b(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public boolean b(DownloadTask paramDownloadTask)
  {
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    this.c.incrementAndGet();
    return this.d;
  }
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  public void onRebind(Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    return false;
  }
  
  public class a
    extends Binder
  {
    public a() {}
    
    public DownloadService a()
    {
      return DownloadService.this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\deamon\download\DownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */