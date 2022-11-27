package com.google.android.gms.internal.common;

import android.content.Context;
import android.os.Build.VERSION;

public final class zzg
{
  private static volatile boolean zziy = zzam() ^ true;
  
  public static Context getDeviceProtectedStorageContext(Context paramContext)
  {
    if (paramContext.isDeviceProtectedStorage()) {
      return paramContext;
    }
    return paramContext.createDeviceProtectedStorageContext();
  }
  
  public static boolean zzam()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\common\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */