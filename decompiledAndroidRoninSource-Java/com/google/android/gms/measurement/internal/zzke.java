package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzh;

public final class zzke
  extends zzkj
{
  private final AlarmManager zzb = (AlarmManager)zzm().getSystemService("alarm");
  private final zzaj zzc;
  private Integer zzd;
  
  protected zzke(zzki paramzzki)
  {
    super(paramzzki);
    this.zzc = new zzkh(this, paramzzki.zzu(), paramzzki);
  }
  
  private final void zzu()
  {
    ((JobScheduler)zzm().getSystemService("jobscheduler")).cancel(zzv());
  }
  
  private final int zzv()
  {
    if (this.zzd == null)
    {
      String str = String.valueOf(zzm().getPackageName());
      if (str.length() != 0) {
        str = "measurement".concat(str);
      } else {
        str = new String("measurement");
      }
      this.zzd = Integer.valueOf(str.hashCode());
    }
    return this.zzd.intValue();
  }
  
  private final PendingIntent zzw()
  {
    Context localContext = zzm();
    return PendingIntent.getBroadcast(localContext, 0, new Intent().setClassName(localContext, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
  }
  
  public final void zza(long paramLong)
  {
    zzaj();
    Context localContext = zzm();
    if (!zzfn.zza(localContext)) {
      zzq().zzv().zza("Receiver not registered/enabled");
    }
    if (!zzkw.zza(localContext, false)) {
      zzq().zzv().zza("Service not registered/enabled");
    }
    zze();
    zzq().zzw().zza("Scheduling upload, millis", Long.valueOf(paramLong));
    long l = zzl().elapsedRealtime();
    if ((paramLong < Math.max(0L, ((Long)zzat.zzw.zza(null)).longValue())) && (!this.zzc.zzb())) {
      this.zzc.zza(paramLong);
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      localContext = zzm();
      ComponentName localComponentName = new ComponentName(localContext, "com.google.android.gms.measurement.AppMeasurementJobService");
      int i = zzv();
      PersistableBundle localPersistableBundle = new PersistableBundle();
      localPersistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
      zzh.zza(localContext, new JobInfo.Builder(i, localComponentName).setMinimumLatency(paramLong).setOverrideDeadline(paramLong << 1).setExtras(localPersistableBundle).build(), "com.google.android.gms", "UploadAlarm");
      return;
    }
    this.zzb.setInexactRepeating(2, l + paramLong, Math.max(((Long)zzat.zzr.zza(null)).longValue(), paramLong), zzw());
  }
  
  protected final boolean zzd()
  {
    this.zzb.cancel(zzw());
    if (Build.VERSION.SDK_INT >= 24) {
      zzu();
    }
    return false;
  }
  
  public final void zze()
  {
    zzaj();
    zzq().zzw().zza("Unscheduling upload");
    this.zzb.cancel(zzw());
    this.zzc.zzc();
    if (Build.VERSION.SDK_INT >= 24) {
      zzu();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */