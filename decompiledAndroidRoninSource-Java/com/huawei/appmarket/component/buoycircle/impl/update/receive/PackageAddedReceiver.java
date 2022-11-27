package com.huawei.appmarket.component.buoycircle.impl.update.receive;

import android.content.BroadcastReceiver;
import android.os.Handler;

public class PackageAddedReceiver
  extends BroadcastReceiver
{
  private static final int INSTALL_SUCCESS = 2;
  private static final int PREFIX_LENGTH = 8;
  private static final String TAG = "PackageAddedReceiver";
  private Handler handler;
  
  public PackageAddedReceiver(Handler paramHandler)
  {
    this.handler = paramHandler;
  }
  
  /* Error */
  public void onReceive(android.content.Context arg1, android.content.Intent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\receive\PackageAddedReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */