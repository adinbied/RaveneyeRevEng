package com.huawei.updatesdk.service.deamon.download;

import android.os.Handler;
import com.huawei.updatesdk.sdk.service.download.bean.DownloadTask;
import com.huawei.updatesdk.sdk.service.download.d;
import java.lang.ref.WeakReference;

public final class DownloadHandler
  extends Handler
{
  private WeakReference<DownloadService> a;
  
  public DownloadHandler(DownloadService paramDownloadService)
  {
    this.a = new WeakReference(paramDownloadService);
  }
  
  /* Error */
  private void a(DownloadTask arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(DownloadService paramDownloadService, DownloadTask paramDownloadTask)
  {
    paramDownloadService.a.c(paramDownloadTask);
  }
  
  /* Error */
  public void handleMessage(android.os.Message arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\deamon\download\DownloadHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */