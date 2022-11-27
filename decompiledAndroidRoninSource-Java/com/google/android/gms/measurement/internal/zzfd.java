package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzmj;

final class zzfd
  extends zzgr
{
  static final Pair<String, Long> zza = new Pair("", Long.valueOf(0L));
  private String zzaa;
  private boolean zzab;
  private long zzac;
  public zzfg zzb;
  public final zzfh zzc = new zzfh(this, "last_upload", 0L);
  public final zzfh zzd = new zzfh(this, "last_upload_attempt", 0L);
  public final zzfh zze = new zzfh(this, "backoff", 0L);
  public final zzfh zzf = new zzfh(this, "last_delete_stale", 0L);
  public final zzfh zzg = new zzfh(this, "midnight_offset", 0L);
  public final zzfh zzh = new zzfh(this, "first_open_time", 0L);
  public final zzfh zzi = new zzfh(this, "app_install_time", 0L);
  public final zzfj zzj = new zzfj(this, "app_instance_id", null);
  public final zzfh zzk = new zzfh(this, "time_before_start", 10000L);
  public final zzfh zzl = new zzfh(this, "session_timeout", 1800000L);
  public final zzff zzm = new zzff(this, "start_new_session", true);
  public final zzfj zzn = new zzfj(this, "non_personalized_ads", null);
  public final zzff zzo = new zzff(this, "allow_remote_dynamite", false);
  public final zzfh zzp = new zzfh(this, "last_pause_time", 0L);
  public boolean zzq;
  public zzff zzr = new zzff(this, "app_backgrounded", false);
  public zzff zzs = new zzff(this, "deep_link_retrieval_complete", false);
  public zzfh zzt = new zzfh(this, "deep_link_retrieval_attempts", 0L);
  public final zzfj zzu = new zzfj(this, "firebase_feature_rollouts", null);
  public final zzfj zzv = new zzfj(this, "deferred_attribution_cache", null);
  public final zzfh zzw = new zzfh(this, "deferred_attribution_cache_timestamp", 0L);
  public final zzfe zzx = new zzfe(this, "default_event_parameters", null);
  private SharedPreferences zzz;
  
  zzfd(zzfv paramzzfv)
  {
    super(paramzzfv);
  }
  
  protected final void g_()
  {
    Object localObject = zzm().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
    this.zzz = ((SharedPreferences)localObject);
    boolean bool = ((SharedPreferences)localObject).getBoolean("has_been_opened", false);
    this.zzq = bool;
    if (!bool)
    {
      localObject = this.zzz.edit();
      ((SharedPreferences.Editor)localObject).putBoolean("has_been_opened", true);
      ((SharedPreferences.Editor)localObject).apply();
    }
    this.zzb = new zzfg(this, "health_monitor", Math.max(0L, ((Long)zzat.zzb.zza(null)).longValue()), null);
  }
  
  final Pair<String, Boolean> zza(String paramString)
  {
    zzc();
    long l = zzl().elapsedRealtime();
    if ((this.zzaa != null) && (l < this.zzac)) {
      return new Pair(this.zzaa, Boolean.valueOf(this.zzab));
    }
    this.zzac = (l + zzs().zze(paramString));
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
    try
    {
      paramString = AdvertisingIdClient.getAdvertisingIdInfo(zzm());
      if (paramString != null)
      {
        this.zzaa = paramString.getId();
        this.zzab = paramString.isLimitAdTrackingEnabled();
      }
      if (this.zzaa == null) {
        this.zzaa = "";
      }
    }
    catch (Exception paramString)
    {
      zzq().zzv().zza("Unable to get advertising id", paramString);
      this.zzaa = "";
    }
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
    return new Pair(this.zzaa, Boolean.valueOf(this.zzab));
  }
  
  final void zza(Boolean paramBoolean)
  {
    zzc();
    SharedPreferences.Editor localEditor = zzf().edit();
    if (paramBoolean != null) {
      localEditor.putBoolean("measurement_enabled", paramBoolean.booleanValue());
    } else {
      localEditor.remove("measurement_enabled");
    }
    localEditor.apply();
  }
  
  final void zza(boolean paramBoolean)
  {
    zzc();
    SharedPreferences.Editor localEditor = zzf().edit();
    localEditor.putBoolean("use_service", paramBoolean);
    localEditor.apply();
  }
  
  final boolean zza(int paramInt)
  {
    return zzad.zza(paramInt, zzf().getInt("consent_source", 100));
  }
  
  final boolean zza(long paramLong)
  {
    return paramLong - this.zzl.zza() > this.zzp.zza();
  }
  
  final boolean zza(zzad paramzzad, int paramInt)
  {
    if ((zzmj.zzb()) && (zzs().zza(zzat.zzcg)))
    {
      zzc();
      if (zza(paramInt))
      {
        SharedPreferences.Editor localEditor = zzf().edit();
        localEditor.putString("consent_settings", paramzzad.zza());
        localEditor.putInt("consent_source", paramInt);
        localEditor.apply();
        return true;
      }
    }
    return false;
  }
  
  final void zzb(Boolean paramBoolean)
  {
    if ((zzmj.zzb()) && (zzs().zza(zzat.zzcg)))
    {
      zzc();
      SharedPreferences.Editor localEditor = zzf().edit();
      if (paramBoolean != null) {
        localEditor.putBoolean("measurement_enabled_from_api", paramBoolean.booleanValue());
      } else {
        localEditor.remove("measurement_enabled_from_api");
      }
      localEditor.apply();
    }
  }
  
  final void zzb(String paramString)
  {
    zzc();
    SharedPreferences.Editor localEditor = zzf().edit();
    localEditor.putString("gmp_app_id", paramString);
    localEditor.apply();
  }
  
  final void zzb(boolean paramBoolean)
  {
    zzc();
    zzq().zzw().zza("App measurement setting deferred collection", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = zzf().edit();
    localEditor.putBoolean("deferred_analytics_collection", paramBoolean);
    localEditor.apply();
  }
  
  final void zzc(String paramString)
  {
    zzc();
    SharedPreferences.Editor localEditor = zzf().edit();
    localEditor.putString("admob_app_id", paramString);
    localEditor.apply();
  }
  
  protected final boolean zzd()
  {
    return true;
  }
  
  protected final SharedPreferences zzf()
  {
    zzc();
    zzaa();
    return this.zzz;
  }
  
  final String zzg()
  {
    zzc();
    return zzf().getString("gmp_app_id", null);
  }
  
  final String zzh()
  {
    zzc();
    return zzf().getString("admob_app_id", null);
  }
  
  final Boolean zzi()
  {
    zzc();
    if (!zzf().contains("use_service")) {
      return null;
    }
    return Boolean.valueOf(zzf().getBoolean("use_service", false));
  }
  
  final void zzj()
  {
    zzc();
    Boolean localBoolean = zzu();
    SharedPreferences.Editor localEditor = zzf().edit();
    localEditor.clear();
    localEditor.apply();
    if (localBoolean != null) {
      zza(localBoolean);
    }
  }
  
  final Boolean zzu()
  {
    zzc();
    if (zzf().contains("measurement_enabled")) {
      return Boolean.valueOf(zzf().getBoolean("measurement_enabled", true));
    }
    return null;
  }
  
  final Boolean zzv()
  {
    if ((zzmj.zzb()) && (zzs().zza(zzat.zzcg)))
    {
      zzc();
      if (zzf().contains("measurement_enabled_from_api")) {
        return Boolean.valueOf(zzf().getBoolean("measurement_enabled_from_api", true));
      }
    }
    return null;
  }
  
  final zzad zzw()
  {
    zzc();
    return zzad.zza(zzf().getString("consent_settings", "G1"));
  }
  
  protected final String zzx()
  {
    zzc();
    String str1 = zzf().getString("previous_os_version", null);
    zzk().zzaa();
    String str2 = Build.VERSION.RELEASE;
    if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str1)))
    {
      SharedPreferences.Editor localEditor = zzf().edit();
      localEditor.putString("previous_os_version", str2);
      localEditor.apply();
    }
    return str1;
  }
  
  final boolean zzy()
  {
    return this.zzz.contains("deferred_analytics_collection");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */