package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;

public abstract class PushMessageReceiver
  extends BroadcastReceiver
{
  public void onCommandResult(Context paramContext, MiPushCommandMessage paramMiPushCommandMessage) {}
  
  public void onNotificationMessageArrived(Context paramContext, MiPushMessage paramMiPushMessage) {}
  
  public void onNotificationMessageClicked(Context paramContext, MiPushMessage paramMiPushMessage) {}
  
  /* Error */
  public final void onReceive(Context arg1, android.content.Intent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  @Deprecated
  public void onReceiveMessage(Context paramContext, MiPushMessage paramMiPushMessage) {}
  
  public void onReceivePassThroughMessage(Context paramContext, MiPushMessage paramMiPushMessage) {}
  
  public void onReceiveRegisterResult(Context paramContext, MiPushCommandMessage paramMiPushCommandMessage) {}
  
  public void onRequirePermissions(Context paramContext, String[] paramArrayOfString) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\PushMessageReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */