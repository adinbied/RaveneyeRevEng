package com.google.android.gms.stats;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.stats.WakeLockTracker;

public abstract class GCoreWakefulBroadcastReceiver
  extends WakefulBroadcastReceiver
{
  private static String TAG = "GCoreWakefulBroadcastReceiver";
  
  public static boolean completeWakefulIntent(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    if (paramContext != null)
    {
      WakeLockTracker.getInstance().registerReleaseEvent(paramContext, paramIntent);
    }
    else
    {
      String str = TAG;
      paramContext = String.valueOf(paramIntent.toUri(0));
      if (paramContext.length() != 0) {
        paramContext = "context shouldn't be null. intent: ".concat(paramContext);
      } else {
        paramContext = new String("context shouldn't be null. intent: ");
      }
      Log.w(str, paramContext);
    }
    return WakefulBroadcastReceiver.completeWakefulIntent(paramIntent);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\stats\GCoreWakefulBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */