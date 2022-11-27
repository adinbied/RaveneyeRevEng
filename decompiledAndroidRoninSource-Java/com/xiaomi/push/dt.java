package com.xiaomi.push;

import android.content.Context;
import android.content.IntentFilter;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.mpcd.receivers.BroadcastActionsReceiver;

public class dt
{
  private static IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addDataScheme("package");
    return localIntentFilter;
  }
  
  private static dy a()
  {
    return new du();
  }
  
  public static void a(Context paramContext)
  {
    dz.a(paramContext).a();
    try
    {
      paramContext.registerReceiver(new BroadcastActionsReceiver(a()), a());
      return;
    }
    finally
    {
      b.a(paramContext);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */