package com.huawei.updatesdk.sdk.service.secure;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class SecureBroadcastReceiver
  extends BroadcastReceiver
{
  public abstract void a(Context paramContext, a parama);
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    a(paramContext, a.a(paramIntent));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\secure\SecureBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */