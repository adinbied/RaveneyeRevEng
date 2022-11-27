package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;

public final class zzbd
{
  private static final long zza = TimeUnit.MINUTES.toMillis(1L);
  private static final Object zzb = new Object();
  private static WakeLock zzc;
  
  public static ComponentName zza(Context paramContext, Intent paramIntent)
  {
    synchronized (zzb)
    {
      if (zzc == null)
      {
        WakeLock localWakeLock = new WakeLock(paramContext, 1, "wake:com.google.firebase.iid.WakeLockHolder");
        zzc = localWakeLock;
        localWakeLock.setReferenceCounted(true);
      }
      boolean bool = paramIntent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
      zza(paramIntent, true);
      paramContext = paramContext.startService(paramIntent);
      if (paramContext == null) {
        return null;
      }
      if (!bool) {
        zzc.acquire(zza);
      }
      return paramContext;
    }
  }
  
  public static void zza(Intent paramIntent)
  {
    synchronized (zzb)
    {
      if ((zzc != null) && (paramIntent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)))
      {
        zza(paramIntent, false);
        zzc.release();
      }
      return;
    }
  }
  
  private static void zza(Intent paramIntent, boolean paramBoolean)
  {
    paramIntent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzbd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */