package com.huawei.updatesdk.service.deamon.download;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
{
  private static final c a = new c();
  private final AtomicInteger b = new AtomicInteger();
  private a c = null;
  private DownloadService d = null;
  private final List<Message> e = new ArrayList();
  
  public static void a()
  {
    com.huawei.updatesdk.sdk.a.c.a.a.a.a("ServiceProxy", "start DownloadService");
    Context localContext = com.huawei.updatesdk.sdk.service.a.a.a().b();
    localContext.startService(new Intent(localContext, DownloadService.class));
  }
  
  public static c b()
  {
    return a;
  }
  
  private boolean g()
  {
    return false;
  }
  
  protected DownloadService c()
  {
    return null;
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public DownloadService e()
  {
    return a.d;
  }
  
  public DownloadService f()
  {
    return null;
  }
  
  private final class a
    implements ServiceConnection
  {
    private a() {}
    
    /* Error */
    public void onServiceConnected(android.content.ComponentName arg1, android.os.IBinder arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onServiceDisconnected(android.content.ComponentName arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\deamon\download\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */