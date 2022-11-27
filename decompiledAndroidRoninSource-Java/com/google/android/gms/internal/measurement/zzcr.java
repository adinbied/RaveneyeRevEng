package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

public class zzcr
{
  private static UserManager zza;
  private static volatile boolean zzb = zza() ^ true;
  private static boolean zzc = false;
  
  public static boolean zza()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  public static boolean zza(Context paramContext)
  {
    return (!zza()) || (zzc(paramContext));
  }
  
  private static boolean zzb(Context paramContext)
  {
    boolean bool2 = true;
    int i = 1;
    boolean bool1;
    for (;;)
    {
      bool1 = false;
      if (i > 2) {
        break;
      }
      if (zza == null) {
        zza = (UserManager)paramContext.getSystemService(UserManager.class);
      }
      UserManager localUserManager = zza;
      if (localUserManager == null) {
        return true;
      }
      bool1 = bool2;
      try
      {
        if (!localUserManager.isUserUnlocked())
        {
          bool1 = localUserManager.isUserRunning(Process.myUserHandle());
          if (!bool1) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        Log.w("DirectBootUtils", "Failed to check if user is unlocked.", localNullPointerException);
        zza = null;
        i += 1;
      }
    }
    if (bool1) {
      zza = null;
    }
    return bool1;
  }
  
  private static boolean zzc(Context paramContext)
  {
    if (zzb) {
      return true;
    }
    try
    {
      if (zzb) {
        return true;
      }
      boolean bool = zzb(paramContext);
      if (bool) {
        zzb = bool;
      }
      return bool;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzcr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */