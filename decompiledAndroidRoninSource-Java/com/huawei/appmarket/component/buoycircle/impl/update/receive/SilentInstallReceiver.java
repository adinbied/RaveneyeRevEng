package com.huawei.appmarket.component.buoycircle.impl.update.receive;

import android.content.BroadcastReceiver;
import android.os.Handler;

public class SilentInstallReceiver
  extends BroadcastReceiver
{
  private static final String DOWNLOAD_PROGRESS_ACTION = "com.huawei.appmarket.service.downloadservice.progress.Receiver";
  private static final String DOWNLOAD_STATUS_ACTION = "com.huawei.appmarket.service.downloadservice.Receiver";
  private static final String INSTALL_ACTION = "com.huawei.appmarket.service.installerservice.Receiver";
  private static final String TAG = "SilentInstallReceiver";
  private Handler handler;
  
  public SilentInstallReceiver(Handler paramHandler)
  {
    this.handler = paramHandler;
  }
  
  /* Error */
  public void onReceive(android.content.Context arg1, android.content.Intent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\receive\SilentInstallReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */