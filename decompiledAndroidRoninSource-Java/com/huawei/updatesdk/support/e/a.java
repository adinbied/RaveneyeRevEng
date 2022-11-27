package com.huawei.updatesdk.support.e;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;

public abstract class a
{
  public static void a(Context paramContext, BroadcastReceiver paramBroadcastReceiver)
  {
    if (paramBroadcastReceiver != null)
    {
      if (paramContext == null) {
        return;
      }
      try
      {
        paramContext.unregisterReceiver(paramBroadcastReceiver);
        return;
      }
      catch (IllegalArgumentException paramContext)
      {
        paramBroadcastReceiver = new StringBuilder();
        paramBroadcastReceiver.append("unregisterReceiver error:");
        paramBroadcastReceiver.append(paramContext.toString());
        com.huawei.updatesdk.sdk.a.c.a.a.a.d("ActivityUtil", paramBroadcastReceiver.toString());
      }
    }
  }
  
  public static void a(Context paramContext, IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
  {
    if (paramIntentFilter != null)
    {
      if (paramBroadcastReceiver == null) {
        return;
      }
      if (a(paramContext)) {
        return;
      }
      try
      {
        paramContext.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
        return;
      }
      catch (IllegalArgumentException paramContext)
      {
        paramIntentFilter = new StringBuilder();
        paramIntentFilter.append("registerReceiver error:");
        paramIntentFilter.append(paramContext.toString());
        com.huawei.updatesdk.sdk.a.c.a.a.a.d("ActivityUtil", paramIntentFilter.toString());
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return true;
    }
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      if ((paramContext.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramContext.isDestroyed())))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("activity has bean finished, cannot instance:");
        localStringBuilder.append(paramContext);
        com.huawei.updatesdk.sdk.a.c.a.a.a.d("ActivityUtil", localStringBuilder.toString());
        return true;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\support\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */