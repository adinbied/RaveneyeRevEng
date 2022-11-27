package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zzb
  implements Runnable
{
  zzb(zza paramzza, LifecycleCallback paramLifecycleCallback, String paramString) {}
  
  public final void run()
  {
    if (zza.zza(this.zzbk) > 0)
    {
      LifecycleCallback localLifecycleCallback = this.zzbi;
      Bundle localBundle;
      if (zza.zzb(this.zzbk) != null) {
        localBundle = zza.zzb(this.zzbk).getBundle(this.zzbj);
      } else {
        localBundle = null;
      }
      localLifecycleCallback.onCreate(localBundle);
    }
    if (zza.zza(this.zzbk) >= 2) {
      this.zzbi.onStart();
    }
    if (zza.zza(this.zzbk) >= 3) {
      this.zzbi.onResume();
    }
    if (zza.zza(this.zzbk) >= 4) {
      this.zzbi.onStop();
    }
    if (zza.zza(this.zzbk) >= 5) {
      this.zzbi.onDestroy();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */