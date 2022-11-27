package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;

class bm
  implements ServiceConnection
{
  bm(XMPushService paramXMPushService) {}
  
  /* Error */
  public void onServiceConnected(ComponentName arg1, android.os.IBinder arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */