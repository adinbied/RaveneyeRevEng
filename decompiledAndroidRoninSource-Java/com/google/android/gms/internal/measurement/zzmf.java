package com.google.android.gms.internal.measurement;

public final class zzmf
  implements zzmg
{
  private static final zzdh<Long> zza;
  private static final zzdh<Long> zzaa;
  private static final zzdh<Long> zzab;
  private static final zzdh<Long> zzac;
  private static final zzdh<Long> zzad;
  private static final zzdh<Long> zzae;
  private static final zzdh<Long> zzaf;
  private static final zzdh<Long> zzag;
  private static final zzdh<Long> zzah;
  private static final zzdh<String> zzai;
  private static final zzdh<Long> zzaj;
  private static final zzdh<Long> zzb;
  private static final zzdh<String> zzc;
  private static final zzdh<String> zzd;
  private static final zzdh<String> zze;
  private static final zzdh<Long> zzf;
  private static final zzdh<Long> zzg;
  private static final zzdh<Long> zzh;
  private static final zzdh<Long> zzi;
  private static final zzdh<Long> zzj;
  private static final zzdh<Long> zzk;
  private static final zzdh<Long> zzl;
  private static final zzdh<Long> zzm;
  private static final zzdh<Long> zzn;
  private static final zzdh<Long> zzo;
  private static final zzdh<Long> zzp;
  private static final zzdh<Long> zzq;
  private static final zzdh<String> zzr;
  private static final zzdh<Long> zzs;
  private static final zzdh<Long> zzt;
  private static final zzdh<Long> zzu;
  private static final zzdh<Long> zzv;
  private static final zzdh<Long> zzw;
  private static final zzdh<Long> zzx;
  private static final zzdh<Long> zzy;
  private static final zzdh<Long> zzz;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.ad_id_cache_time", 10000L);
    zzb = localzzdm.zza("measurement.config.cache_time", 86400000L);
    zzc = localzzdm.zza("measurement.log_tag", "FA");
    zzd = localzzdm.zza("measurement.config.url_authority", "app-measurement.com");
    zze = localzzdm.zza("measurement.config.url_scheme", "https");
    zzf = localzzdm.zza("measurement.upload.debug_upload_interval", 1000L);
    zzg = localzzdm.zza("measurement.lifetimevalue.max_currency_tracked", 4L);
    zzh = localzzdm.zza("measurement.store.max_stored_events_per_app", 100000L);
    zzi = localzzdm.zza("measurement.experiment.max_ids", 50L);
    zzj = localzzdm.zza("measurement.audience.filter_result_max_count", 200L);
    zzk = localzzdm.zza("measurement.alarm_manager.minimum_interval", 60000L);
    zzl = localzzdm.zza("measurement.upload.minimum_delay", 500L);
    zzm = localzzdm.zza("measurement.monitoring.sample_period_millis", 86400000L);
    zzn = localzzdm.zza("measurement.upload.realtime_upload_interval", 10000L);
    zzo = localzzdm.zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
    zzp = localzzdm.zza("measurement.config.cache_time.service", 3600000L);
    zzq = localzzdm.zza("measurement.service_client.idle_disconnect_millis", 5000L);
    zzr = localzzdm.zza("measurement.log_tag.service", "FA-SVC");
    zzs = localzzdm.zza("measurement.upload.stale_data_deletion_interval", 86400000L);
    zzt = localzzdm.zza("measurement.upload.backoff_period", 43200000L);
    zzu = localzzdm.zza("measurement.upload.initial_upload_delay_time", 15000L);
    zzv = localzzdm.zza("measurement.upload.interval", 3600000L);
    zzw = localzzdm.zza("measurement.upload.max_bundle_size", 65536L);
    zzx = localzzdm.zza("measurement.upload.max_bundles", 100L);
    zzy = localzzdm.zza("measurement.upload.max_conversions_per_day", 500L);
    zzz = localzzdm.zza("measurement.upload.max_error_events_per_day", 1000L);
    zzaa = localzzdm.zza("measurement.upload.max_events_per_bundle", 1000L);
    zzab = localzzdm.zza("measurement.upload.max_events_per_day", 100000L);
    zzac = localzzdm.zza("measurement.upload.max_public_events_per_day", 50000L);
    zzad = localzzdm.zza("measurement.upload.max_queue_time", 2419200000L);
    zzae = localzzdm.zza("measurement.upload.max_realtime_events_per_day", 10L);
    zzaf = localzzdm.zza("measurement.upload.max_batch_size", 65536L);
    zzag = localzzdm.zza("measurement.upload.retry_count", 6L);
    zzah = localzzdm.zza("measurement.upload.retry_time", 1800000L);
    zzai = localzzdm.zza("measurement.upload.url", "https://app-measurement.com/a");
    zzaj = localzzdm.zza("measurement.upload.window_interval", 3600000L);
  }
  
  public final long zza()
  {
    return ((Long)zza.zzc()).longValue();
  }
  
  public final long zzaa()
  {
    return ((Long)zzad.zzc()).longValue();
  }
  
  public final long zzab()
  {
    return ((Long)zzae.zzc()).longValue();
  }
  
  public final long zzac()
  {
    return ((Long)zzaf.zzc()).longValue();
  }
  
  public final long zzad()
  {
    return ((Long)zzag.zzc()).longValue();
  }
  
  public final long zzae()
  {
    return ((Long)zzah.zzc()).longValue();
  }
  
  public final String zzaf()
  {
    return (String)zzai.zzc();
  }
  
  public final long zzag()
  {
    return ((Long)zzaj.zzc()).longValue();
  }
  
  public final long zzb()
  {
    return ((Long)zzb.zzc()).longValue();
  }
  
  public final String zzc()
  {
    return (String)zzd.zzc();
  }
  
  public final String zzd()
  {
    return (String)zze.zzc();
  }
  
  public final long zze()
  {
    return ((Long)zzf.zzc()).longValue();
  }
  
  public final long zzf()
  {
    return ((Long)zzg.zzc()).longValue();
  }
  
  public final long zzg()
  {
    return ((Long)zzh.zzc()).longValue();
  }
  
  public final long zzh()
  {
    return ((Long)zzi.zzc()).longValue();
  }
  
  public final long zzi()
  {
    return ((Long)zzj.zzc()).longValue();
  }
  
  public final long zzj()
  {
    return ((Long)zzk.zzc()).longValue();
  }
  
  public final long zzk()
  {
    return ((Long)zzl.zzc()).longValue();
  }
  
  public final long zzl()
  {
    return ((Long)zzm.zzc()).longValue();
  }
  
  public final long zzm()
  {
    return ((Long)zzn.zzc()).longValue();
  }
  
  public final long zzn()
  {
    return ((Long)zzo.zzc()).longValue();
  }
  
  public final long zzo()
  {
    return ((Long)zzq.zzc()).longValue();
  }
  
  public final long zzp()
  {
    return ((Long)zzs.zzc()).longValue();
  }
  
  public final long zzq()
  {
    return ((Long)zzt.zzc()).longValue();
  }
  
  public final long zzr()
  {
    return ((Long)zzu.zzc()).longValue();
  }
  
  public final long zzs()
  {
    return ((Long)zzv.zzc()).longValue();
  }
  
  public final long zzt()
  {
    return ((Long)zzw.zzc()).longValue();
  }
  
  public final long zzu()
  {
    return ((Long)zzx.zzc()).longValue();
  }
  
  public final long zzv()
  {
    return ((Long)zzy.zzc()).longValue();
  }
  
  public final long zzw()
  {
    return ((Long)zzz.zzc()).longValue();
  }
  
  public final long zzx()
  {
    return ((Long)zzaa.zzc()).longValue();
  }
  
  public final long zzy()
  {
    return ((Long)zzab.zzc()).longValue();
  }
  
  public final long zzz()
  {
    return ((Long)zzac.zzc()).longValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzmf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */