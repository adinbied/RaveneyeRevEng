package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzdh;
import com.google.android.gms.internal.measurement.zzmj;
import com.google.android.gms.internal.measurement.zzmu;
import com.google.android.gms.internal.measurement.zzny;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class zzfv
  implements zzgq
{
  private static volatile zzfv zzb;
  final long zza;
  private Boolean zzaa;
  private long zzab;
  private volatile Boolean zzac;
  private Boolean zzad;
  private Boolean zzae;
  private volatile boolean zzaf;
  private int zzag;
  private AtomicInteger zzah;
  private final Context zzc;
  private final String zzd;
  private final String zze;
  private final String zzf;
  private final boolean zzg;
  private final zzx zzh;
  private final zzy zzi;
  private final zzfd zzj;
  private final zzer zzk;
  private final zzfo zzl;
  private final zzju zzm;
  private final zzkw zzn;
  private final zzep zzo;
  private final Clock zzp;
  private final zzij zzq;
  private final zzgy zzr;
  private final zza zzs;
  private final zzia zzt;
  private zzen zzu;
  private zzio zzv;
  private zzal zzw;
  private zzek zzx;
  private zzfi zzy;
  private boolean zzz;
  
  private zzfv(zzgz paramzzgz)
  {
    int j = 0;
    this.zzz = false;
    this.zzah = new AtomicInteger(0);
    Preconditions.checkNotNull(paramzzgz);
    Object localObject1 = new zzx(paramzzgz.zza);
    this.zzh = ((zzx)localObject1);
    zzeh.zza = (zzx)localObject1;
    this.zzc = paramzzgz.zza;
    this.zzd = paramzzgz.zzb;
    this.zze = paramzzgz.zzc;
    this.zzf = paramzzgz.zzd;
    this.zzg = paramzzgz.zzh;
    this.zzac = paramzzgz.zze;
    this.zzaf = true;
    localObject1 = paramzzgz.zzg;
    Object localObject2;
    if ((localObject1 != null) && (((zzae)localObject1).zzg != null))
    {
      localObject2 = ((zzae)localObject1).zzg.get("measurementEnabled");
      if ((localObject2 instanceof Boolean)) {
        this.zzad = ((Boolean)localObject2);
      }
      localObject1 = ((zzae)localObject1).zzg.get("measurementDeactivated");
      if ((localObject1 instanceof Boolean)) {
        this.zzae = ((Boolean)localObject1);
      }
    }
    zzdh.zza(this.zzc);
    this.zzp = DefaultClock.getInstance();
    long l;
    if (paramzzgz.zzi != null) {
      l = paramzzgz.zzi.longValue();
    } else {
      l = this.zzp.currentTimeMillis();
    }
    this.zza = l;
    this.zzi = new zzy(this);
    localObject1 = new zzfd(this);
    ((zzgr)localObject1).zzab();
    this.zzj = ((zzfd)localObject1);
    localObject1 = new zzer(this);
    ((zzgr)localObject1).zzab();
    this.zzk = ((zzer)localObject1);
    localObject1 = new zzkw(this);
    ((zzgr)localObject1).zzab();
    this.zzn = ((zzkw)localObject1);
    localObject1 = new zzep(this);
    ((zzgr)localObject1).zzab();
    this.zzo = ((zzep)localObject1);
    this.zzs = new zza(this);
    localObject1 = new zzij(this);
    ((zzg)localObject1).zzw();
    this.zzq = ((zzij)localObject1);
    localObject1 = new zzgy(this);
    ((zzg)localObject1).zzw();
    this.zzr = ((zzgy)localObject1);
    localObject1 = new zzju(this);
    ((zzg)localObject1).zzw();
    this.zzm = ((zzju)localObject1);
    localObject1 = new zzia(this);
    ((zzgr)localObject1).zzab();
    this.zzt = ((zzia)localObject1);
    localObject1 = new zzfo(this);
    ((zzgr)localObject1).zzab();
    this.zzl = ((zzfo)localObject1);
    int i = j;
    if (paramzzgz.zzg != null)
    {
      i = j;
      if (paramzzgz.zzg.zzb != 0L) {
        i = 1;
      }
    }
    if ((this.zzc.getApplicationContext() instanceof Application))
    {
      localObject1 = zzg();
      if ((((zzgo)localObject1).zzm().getApplicationContext() instanceof Application))
      {
        localObject2 = (Application)((zzgo)localObject1).zzm().getApplicationContext();
        if (((zzgy)localObject1).zza == null) {
          ((zzgy)localObject1).zza = new zzhz((zzgy)localObject1, null);
        }
        if ((i ^ 0x1) != 0)
        {
          ((Application)localObject2).unregisterActivityLifecycleCallbacks(((zzgy)localObject1).zza);
          ((Application)localObject2).registerActivityLifecycleCallbacks(((zzgy)localObject1).zza);
          ((zzgo)localObject1).zzq().zzw().zza("Registered activity lifecycle callback");
        }
      }
    }
    else
    {
      zzq().zzh().zza("Application context is not an Application");
    }
    this.zzl.zza(new zzfx(this, paramzzgz));
  }
  
  public static zzfv zza(Context paramContext, zzae paramzzae, Long paramLong)
  {
    zzae localzzae = paramzzae;
    if (paramzzae != null) {
      if (paramzzae.zze != null)
      {
        localzzae = paramzzae;
        if (paramzzae.zzf != null) {}
      }
      else
      {
        localzzae = new zzae(paramzzae.zza, paramzzae.zzb, paramzzae.zzc, paramzzae.zzd, null, null, paramzzae.zzg);
      }
    }
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramContext.getApplicationContext());
    if (zzb == null) {
      try
      {
        if (zzb == null) {
          zzb = new zzfv(new zzgz(paramContext, localzzae, paramLong));
        }
      }
      finally {}
    } else if ((localzzae != null) && (localzzae.zzg != null) && (localzzae.zzg.containsKey("dataCollectionDefaultEnabled"))) {
      zzb.zza(localzzae.zzg.getBoolean("dataCollectionDefaultEnabled"));
    }
    return zzb;
  }
  
  private static void zza(zzgo paramzzgo)
  {
    if (paramzzgo != null) {
      return;
    }
    throw new IllegalStateException("Component not created");
  }
  
  private final void zza(zzgz paramzzgz)
  {
    zzp().zzc();
    Object localObject = new zzal(this);
    ((zzgr)localObject).zzab();
    this.zzw = ((zzal)localObject);
    paramzzgz = new zzek(this, paramzzgz.zzf);
    paramzzgz.zzw();
    this.zzx = paramzzgz;
    localObject = new zzen(this);
    ((zzg)localObject).zzw();
    this.zzu = ((zzen)localObject);
    localObject = new zzio(this);
    ((zzg)localObject).zzw();
    this.zzv = ((zzio)localObject);
    this.zzn.zzac();
    this.zzj.zzac();
    this.zzy = new zzfi(this);
    this.zzx.zzx();
    zzq().zzu().zza("App measurement initialized, version", Long.valueOf(32053L));
    zzq().zzu().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
    paramzzgz = paramzzgz.zzaa();
    if (TextUtils.isEmpty(this.zzd))
    {
      if (zzh().zze(paramzzgz))
      {
        localObject = zzq().zzu();
        paramzzgz = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
      }
      else
      {
        localObject = zzq().zzu();
        paramzzgz = String.valueOf(paramzzgz);
        if (paramzzgz.length() != 0) {
          paramzzgz = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(paramzzgz);
        } else {
          paramzzgz = new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
        }
      }
      ((zzet)localObject).zza(paramzzgz);
    }
    zzq().zzv().zza("Debug-level message logging enabled");
    if (this.zzag != this.zzah.get()) {
      zzq().zze().zza("Not all components initialized", Integer.valueOf(this.zzag), Integer.valueOf(this.zzah.get()));
    }
    this.zzz = true;
  }
  
  private final zzia zzah()
  {
    zzb(this.zzt);
    return this.zzt;
  }
  
  private static void zzb(zzg paramzzg)
  {
    if (paramzzg != null)
    {
      if (paramzzg.zzu()) {
        return;
      }
      paramzzg = String.valueOf(paramzzg.getClass());
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramzzg).length() + 27);
      localStringBuilder.append("Component not initialized: ");
      localStringBuilder.append(paramzzg);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("Component not created");
  }
  
  private static void zzb(zzgr paramzzgr)
  {
    if (paramzzgr != null)
    {
      if (paramzzgr.zzz()) {
        return;
      }
      paramzzgr = String.valueOf(paramzzgr.getClass());
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramzzgr).length() + 27);
      localStringBuilder.append("Component not initialized: ");
      localStringBuilder.append(paramzzgr);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("Component not created");
  }
  
  public final zzy zza()
  {
    return this.zzi;
  }
  
  protected final void zza(zzae paramzzae)
  {
    zzp().zzc();
    if ((zzmj.zzb()) && (this.zzi.zza(zzat.zzcg)))
    {
      zzad localzzad = zzb().zzw();
      Object localObject = localzzad;
      if (paramzzae != null)
      {
        localObject = localzzad;
        if (paramzzae.zzg != null)
        {
          localObject = localzzad;
          if (zzb().zza(40))
          {
            paramzzae = zzad.zzb(paramzzae.zzg);
            localObject = localzzad;
            if (!paramzzae.equals(zzad.zza))
            {
              zzg().zza(paramzzae, 40, this.zza);
              localObject = paramzzae;
            }
          }
        }
      }
      zzg().zza((zzad)localObject);
    }
    if (zzb().zzc.zza() == 0L) {
      zzb().zzc.zza(this.zzp.currentTimeMillis());
    }
    if (Long.valueOf(zzb().zzh.zza()).longValue() == 0L)
    {
      zzq().zzw().zza("Persisting first open", Long.valueOf(this.zza));
      zzb().zzh.zza(this.zza);
    }
    if (this.zzi.zza(zzat.zzcc)) {
      zzg().zzb.zzb();
    }
    if (!zzaf())
    {
      if (zzaa())
      {
        if (!zzh().zzc("android.permission.INTERNET")) {
          zzq().zze().zza("App is missing INTERNET permission");
        }
        if (!zzh().zzc("android.permission.ACCESS_NETWORK_STATE")) {
          zzq().zze().zza("App is missing ACCESS_NETWORK_STATE permission");
        }
        if ((!Wrappers.packageManager(this.zzc).isCallerInstantApp()) && (!this.zzi.zzw()))
        {
          if (!zzfn.zza(this.zzc)) {
            zzq().zze().zza("AppMeasurementReceiver not registered/enabled");
          }
          if (!zzkw.zza(this.zzc, false)) {
            zzq().zze().zza("AppMeasurementService not registered/enabled");
          }
        }
        zzq().zze().zza("Uploading is not possible. App measurement disabled");
      }
    }
    else
    {
      if ((!TextUtils.isEmpty(zzx().zzab())) || (!TextUtils.isEmpty(zzx().zzac())))
      {
        zzh();
        if (zzkw.zza(zzx().zzab(), zzb().zzg(), zzx().zzac(), zzb().zzh()))
        {
          zzq().zzu().zza("Rechecking which service to use due to a GMP App Id change");
          zzb().zzj();
          zzj().zzaa();
          this.zzv.zzag();
          this.zzv.zzae();
          zzb().zzh.zza(this.zza);
          zzb().zzj.zza(null);
        }
        zzb().zzb(zzx().zzab());
        zzb().zzc(zzx().zzac());
      }
      if ((zzmj.zzb()) && (this.zzi.zza(zzat.zzcg)) && (!zzb().zzw().zze())) {
        zzb().zzj.zza(null);
      }
      zzg().zza(zzb().zzj.zza());
      if ((zzmu.zzb()) && (this.zzi.zza(zzat.zzbo)) && (!zzh().zzj()) && (!TextUtils.isEmpty(zzb().zzu.zza())))
      {
        zzq().zzh().zza("Remote config removed with active feature rollouts");
        zzb().zzu.zza(null);
      }
      if ((!TextUtils.isEmpty(zzx().zzab())) || (!TextUtils.isEmpty(zzx().zzac())))
      {
        boolean bool = zzaa();
        if ((!zzb().zzy()) && (!this.zzi.zzf())) {
          zzb().zzb(bool ^ true);
        }
        if (bool) {
          zzg().zzah();
        }
        zzd().zza.zza();
        zzv().zza(new AtomicReference());
        if ((zzny.zzb()) && (this.zzi.zza(zzat.zzby))) {
          zzv().zza(zzb().zzx.zza());
        }
      }
    }
    zzb().zzo.zza(this.zzi.zza(zzat.zzax));
  }
  
  final void zza(zzg paramzzg)
  {
    this.zzag += 1;
  }
  
  final void zza(zzgr paramzzgr)
  {
    this.zzag += 1;
  }
  
  final void zza(boolean paramBoolean)
  {
    this.zzac = Boolean.valueOf(paramBoolean);
  }
  
  public final boolean zzaa()
  {
    return zzab() == 0;
  }
  
  public final int zzab()
  {
    zzp().zzc();
    if (this.zzi.zzf()) {
      return 1;
    }
    Boolean localBoolean = this.zzae;
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return 2;
    }
    if ((zzmj.zzb()) && (this.zzi.zza(zzat.zzcg)) && (!zzac())) {
      return 8;
    }
    localBoolean = zzb().zzu();
    if (localBoolean != null)
    {
      if (localBoolean.booleanValue()) {
        return 0;
      }
      return 3;
    }
    localBoolean = this.zzi.zzf("firebase_analytics_collection_enabled");
    if (localBoolean != null)
    {
      if (localBoolean.booleanValue()) {
        return 0;
      }
      return 4;
    }
    localBoolean = this.zzad;
    if (localBoolean != null)
    {
      if (localBoolean.booleanValue()) {
        return 0;
      }
      return 5;
    }
    if (GoogleServices.isMeasurementExplicitlyDisabled()) {
      return 6;
    }
    if ((this.zzi.zza(zzat.zzar)) && (this.zzac != null))
    {
      if (this.zzac.booleanValue()) {
        return 0;
      }
      return 7;
    }
    return 0;
  }
  
  public final boolean zzac()
  {
    zzp().zzc();
    return this.zzaf;
  }
  
  final void zzad()
  {
    throw new IllegalStateException("Unexpected call on client side");
  }
  
  final void zzae()
  {
    this.zzah.incrementAndGet();
  }
  
  protected final boolean zzaf()
  {
    if (this.zzz)
    {
      zzp().zzc();
      Boolean localBoolean = this.zzaa;
      if ((localBoolean == null) || (this.zzab == 0L) || ((localBoolean != null) && (!localBoolean.booleanValue()) && (Math.abs(this.zzp.elapsedRealtime() - this.zzab) > 1000L)))
      {
        this.zzab = this.zzp.elapsedRealtime();
        boolean bool1 = zzh().zzc("android.permission.INTERNET");
        boolean bool2 = true;
        if ((bool1) && (zzh().zzc("android.permission.ACCESS_NETWORK_STATE")) && ((Wrappers.packageManager(this.zzc).isCallerInstantApp()) || (this.zzi.zzw()) || ((zzfn.zza(this.zzc)) && (zzkw.zza(this.zzc, false))))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localBoolean = Boolean.valueOf(bool1);
        this.zzaa = localBoolean;
        if (localBoolean.booleanValue())
        {
          bool1 = bool2;
          if (!zzh().zza(zzx().zzab(), zzx().zzac(), zzx().zzad())) {
            if (!TextUtils.isEmpty(zzx().zzac())) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
          this.zzaa = Boolean.valueOf(bool1);
        }
      }
      return this.zzaa.booleanValue();
    }
    throw new IllegalStateException("AppMeasurement is not initialized");
  }
  
  public final void zzag()
  {
    zzp().zzc();
    zzb(zzah());
    String str = zzx().zzaa();
    Object localObject1 = zzb().zza(str);
    if ((this.zzi.zzg().booleanValue()) && (!((Boolean)((Pair)localObject1).second).booleanValue()) && (!TextUtils.isEmpty((CharSequence)((Pair)localObject1).first)))
    {
      if (!zzah().zzf())
      {
        zzq().zzh().zza("Network is not available for Deferred Deep Link request. Skipping");
        return;
      }
      Object localObject2 = zzh();
      zzx();
      localObject1 = ((zzkw)localObject2).zza(32053L, str, (String)((Pair)localObject1).first, zzb().zzt.zza() - 1L);
      localObject2 = zzah();
      zzfu localzzfu = new zzfu(this);
      ((zzgo)localObject2).zzc();
      ((zzgr)localObject2).zzaa();
      Preconditions.checkNotNull(localObject1);
      Preconditions.checkNotNull(localzzfu);
      ((zzgo)localObject2).zzp().zzc(new zzic((zzia)localObject2, str, (URL)localObject1, null, null, localzzfu));
      return;
    }
    zzq().zzv().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
  }
  
  public final zzfd zzb()
  {
    zza(this.zzj);
    return this.zzj;
  }
  
  public final void zzb(boolean paramBoolean)
  {
    zzp().zzc();
    this.zzaf = paramBoolean;
  }
  
  public final zzer zzc()
  {
    zzer localzzer = this.zzk;
    if ((localzzer != null) && (localzzer.zzz())) {
      return this.zzk;
    }
    return null;
  }
  
  public final zzju zzd()
  {
    zzb(this.zzm);
    return this.zzm;
  }
  
  public final zzfi zze()
  {
    return this.zzy;
  }
  
  final zzfo zzf()
  {
    return this.zzl;
  }
  
  public final zzgy zzg()
  {
    zzb(this.zzr);
    return this.zzr;
  }
  
  public final zzkw zzh()
  {
    zza(this.zzn);
    return this.zzn;
  }
  
  public final zzep zzi()
  {
    zza(this.zzo);
    return this.zzo;
  }
  
  public final zzen zzj()
  {
    zzb(this.zzu);
    return this.zzu;
  }
  
  public final boolean zzk()
  {
    return TextUtils.isEmpty(this.zzd);
  }
  
  public final Clock zzl()
  {
    return this.zzp;
  }
  
  public final Context zzm()
  {
    return this.zzc;
  }
  
  public final String zzn()
  {
    return this.zzd;
  }
  
  public final String zzo()
  {
    return this.zze;
  }
  
  public final zzfo zzp()
  {
    zzb(this.zzl);
    return this.zzl;
  }
  
  public final zzer zzq()
  {
    zzb(this.zzk);
    return this.zzk;
  }
  
  public final String zzr()
  {
    return this.zzf;
  }
  
  public final boolean zzs()
  {
    return this.zzg;
  }
  
  public final zzx zzt()
  {
    return this.zzh;
  }
  
  public final zzij zzu()
  {
    zzb(this.zzq);
    return this.zzq;
  }
  
  public final zzio zzv()
  {
    zzb(this.zzv);
    return this.zzv;
  }
  
  public final zzal zzw()
  {
    zzb(this.zzw);
    return this.zzw;
  }
  
  public final zzek zzx()
  {
    zzb(this.zzx);
    return this.zzx;
  }
  
  public final zza zzy()
  {
    zza localzza = this.zzs;
    if (localzza != null) {
      return localzza;
    }
    throw new IllegalStateException("Component not created");
  }
  
  public final boolean zzz()
  {
    return (this.zzac != null) && (this.zzac.booleanValue());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */