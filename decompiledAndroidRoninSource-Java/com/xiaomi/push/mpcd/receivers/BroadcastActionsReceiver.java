package com.xiaomi.push.mpcd.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.dy;

public class BroadcastActionsReceiver
  extends BroadcastReceiver
{
  private dy a;
  
  public BroadcastActionsReceiver(dy paramdy)
  {
    this.a = paramdy;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    dy localdy = this.a;
    if (localdy != null) {
      localdy.a(paramContext, paramIntent);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\mpcd\receivers\BroadcastActionsReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */