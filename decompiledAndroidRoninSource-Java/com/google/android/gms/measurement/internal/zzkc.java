package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzmu;

final class zzkc
{
  zzkc(zzju paramzzju) {}
  
  private final void zzb(long paramLong, boolean paramBoolean)
  {
    this.zza.zzc();
    if (!this.zza.zzy.zzaa()) {
      return;
    }
    this.zza.zzr().zzp.zza(paramLong);
    long l = this.zza.zzl().elapsedRealtime();
    this.zza.zzq().zzw().zza("Session started, time", Long.valueOf(l));
    Object localObject = Long.valueOf(paramLong / 1000L);
    this.zza.zze().zza("auto", "_sid", localObject, paramLong);
    this.zza.zzr().zzm.zza(false);
    Bundle localBundle = new Bundle();
    localBundle.putLong("_sid", ((Long)localObject).longValue());
    if ((this.zza.zzs().zza(zzat.zzbj)) && (paramBoolean)) {
      localBundle.putLong("_aib", 1L);
    }
    this.zza.zze().zza("auto", "_s", paramLong, localBundle);
    if ((zzmu.zzb()) && (this.zza.zzs().zza(zzat.zzbo)))
    {
      localObject = this.zza.zzr().zzu.zza();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localBundle = new Bundle();
        localBundle.putString("_ffr", (String)localObject);
        this.zza.zze().zza("auto", "_ssr", paramLong, localBundle);
      }
    }
  }
  
  final void zza()
  {
    this.zza.zzc();
    if (this.zza.zzr().zza(this.zza.zzl().currentTimeMillis()))
    {
      this.zza.zzr().zzm.zza(true);
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      if (localRunningAppProcessInfo.importance == 100)
      {
        this.zza.zzq().zzw().zza("Detected application was in foreground");
        zzb(this.zza.zzl().currentTimeMillis(), false);
      }
    }
  }
  
  final void zza(long paramLong, boolean paramBoolean)
  {
    this.zza.zzc();
    zzju.zza(this.zza);
    if (this.zza.zzr().zza(paramLong)) {
      this.zza.zzr().zzm.zza(true);
    }
    this.zza.zzr().zzp.zza(paramLong);
    if (this.zza.zzr().zzm.zza()) {
      zzb(paramLong, paramBoolean);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzkc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */