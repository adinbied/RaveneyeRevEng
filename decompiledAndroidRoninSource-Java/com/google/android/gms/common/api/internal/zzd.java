package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zzd
  implements Runnable
{
  zzd(zzc paramzzc, LifecycleCallback paramLifecycleCallback, String paramString) {}
  
  public final void run()
  {
    if (zzc.zza(this.zzbl) > 0)
    {
      LifecycleCallback localLifecycleCallback = this.zzbi;
      Bundle localBundle;
      if (zzc.zzb(this.zzbl) != null) {
        localBundle = zzc.zzb(this.zzbl).getBundle(this.zzbj);
      } else {
        localBundle = null;
      }
      localLifecycleCallback.onCreate(localBundle);
    }
    if (zzc.zza(this.zzbl) >= 2) {
      this.zzbi.onStart();
    }
    if (zzc.zza(this.zzbl) >= 3) {
      this.zzbi.onResume();
    }
    if (zzc.zza(this.zzbl) >= 4) {
      this.zzbi.onStop();
    }
    if (zzc.zza(this.zzbl) >= 5) {
      this.zzbi.onDestroy();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */