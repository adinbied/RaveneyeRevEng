package com.xiaomi.push;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.xiaomi.channel.commonutils.logger.b;

public class ah
{
  public static boolean a(Context paramContext)
  {
    try
    {
      boolean bool = ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      return bool;
    }
    catch (Exception paramContext)
    {
      b.a(paramContext);
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    localObject = null;
    try
    {
      paramContext = paramContext.registerReceiver(null, localIntentFilter);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        boolean bool;
        int i;
        paramContext = (Context)localObject;
      }
    }
    bool = false;
    if (paramContext == null) {
      return false;
    }
    i = paramContext.getIntExtra("status", -1);
    if ((i == 2) || (i == 5)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */