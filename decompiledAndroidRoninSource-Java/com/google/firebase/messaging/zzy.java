package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

final class zzy
{
  private static WeakReference<zzy> zza;
  private final SharedPreferences zzb;
  private zzx zzc;
  private final Executor zzd;
  
  private zzy(SharedPreferences paramSharedPreferences, Executor paramExecutor)
  {
    this.zzd = paramExecutor;
    this.zzb = paramSharedPreferences;
  }
  
  public static zzy zza(Context paramContext, Executor paramExecutor)
  {
    zzy localzzy1 = null;
    try
    {
      if (zza != null) {
        localzzy1 = (zzy)zza.get();
      }
      zzy localzzy2 = localzzy1;
      if (localzzy1 == null)
      {
        localzzy2 = new zzy(paramContext.getSharedPreferences("com.google.android.gms.appid", 0), paramExecutor);
        localzzy2.zzb();
        zza = new WeakReference(localzzy2);
      }
      return localzzy2;
    }
    finally {}
  }
  
  private final void zzb()
  {
    try
    {
      this.zzc = zzx.zza(this.zzb, "topic_operation_queue", ",", this.zzd);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final zzz zza()
  {
    try
    {
      zzz localzzz = zzz.zzc(this.zzc.zza());
      return localzzz;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final boolean zza(zzz paramzzz)
  {
    try
    {
      boolean bool = this.zzc.zza(paramzzz.zzc());
      return bool;
    }
    finally
    {
      paramzzz = finally;
      throw paramzzz;
    }
  }
  
  final boolean zzb(zzz paramzzz)
  {
    try
    {
      boolean bool = this.zzc.zza(paramzzz.zzc());
      return bool;
    }
    finally
    {
      paramzzz = finally;
      throw paramzzz;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */