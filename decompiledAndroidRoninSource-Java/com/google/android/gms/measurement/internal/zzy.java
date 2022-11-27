package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzmi;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.internal.measurement.zzof;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public final class zzy
  extends zzgo
{
  private Boolean zza;
  private zzaa zzb = zzab.zza;
  private Boolean zzc;
  
  zzy(zzfv paramzzfv)
  {
    super(paramzzfv);
  }
  
  private final int zza(String paramString, zzeg<Integer> paramzzeg, int paramInt1, int paramInt2)
  {
    return Math.max(Math.min(zzb(paramString, paramzzeg), paramInt2), paramInt1);
  }
  
  private final String zza(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (InvocationTargetException paramString1)
    {
      zzq().zze().zza("SystemProperties.get() threw an exception", paramString1);
      return paramString2;
    }
    catch (IllegalAccessException paramString1)
    {
      zzq().zze().zza("Could not access SystemProperties.get()", paramString1);
      return paramString2;
    }
    catch (NoSuchMethodException paramString1)
    {
      zzq().zze().zza("Could not find SystemProperties.get() method", paramString1);
      return paramString2;
    }
    catch (ClassNotFoundException paramString1)
    {
      zzq().zze().zza("Could not find SystemProperties class", paramString1);
    }
    return paramString2;
  }
  
  public static long zzi()
  {
    return ((Long)zzat.zzac.zza(null)).longValue();
  }
  
  public static long zzj()
  {
    return ((Long)zzat.zzc.zza(null)).longValue();
  }
  
  private final Bundle zzx()
  {
    try
    {
      if (zzm().getPackageManager() == null)
      {
        zzq().zze().zza("Failed to load metadata: PackageManager is null");
        return null;
      }
      Object localObject = Wrappers.packageManager(zzm()).getApplicationInfo(zzm().getPackageName(), 128);
      if (localObject == null)
      {
        zzq().zze().zza("Failed to load metadata: ApplicationInfo is null");
        return null;
      }
      localObject = ((ApplicationInfo)localObject).metaData;
      return (Bundle)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      zzq().zze().zza("Failed to load metadata: Package name not found", localNameNotFoundException);
    }
    return null;
  }
  
  public final int zza(String paramString)
  {
    return zza(paramString, zzat.zzah, 25, 100);
  }
  
  public final long zza(String paramString, zzeg<Long> paramzzeg)
  {
    if (paramString == null) {
      return ((Long)paramzzeg.zza(null)).longValue();
    }
    paramString = this.zzb.zza(paramString, paramzzeg.zza());
    if (TextUtils.isEmpty(paramString)) {
      return ((Long)paramzzeg.zza(null)).longValue();
    }
    try
    {
      long l = ((Long)paramzzeg.zza(Long.valueOf(Long.parseLong(paramString)))).longValue();
      return l;
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return ((Long)paramzzeg.zza(null)).longValue();
  }
  
  public final String zza(zzf paramzzf)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    Object localObject2 = paramzzf.zze();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      if ((zznt.zzb()) && (zzs().zzd(paramzzf.zzc(), zzat.zzbi)))
      {
        localObject2 = paramzzf.zzg();
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
      }
      else
      {
        localObject1 = paramzzf.zzf();
      }
    }
    localObject2 = localBuilder.scheme((String)zzat.zzd.zza(null)).encodedAuthority((String)zzat.zze.zza(null));
    localObject1 = String.valueOf(localObject1);
    if (((String)localObject1).length() != 0) {
      localObject1 = "config/app/".concat((String)localObject1);
    } else {
      localObject1 = new String("config/app/");
    }
    ((Uri.Builder)localObject2).path((String)localObject1).appendQueryParameter("app_instance_id", paramzzf.zzd()).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "32053");
    return localBuilder.build().toString();
  }
  
  final void zza(zzaa paramzzaa)
  {
    this.zzb = paramzzaa;
  }
  
  public final boolean zza(zzeg<Boolean> paramzzeg)
  {
    return zzd(null, paramzzeg);
  }
  
  final int zzb(String paramString)
  {
    if ((zzmi.zzb()) && (zzd(null, zzat.zzbv))) {
      return zza(paramString, zzat.zzag, 500, 2000);
    }
    return 500;
  }
  
  public final int zzb(String paramString, zzeg<Integer> paramzzeg)
  {
    if (paramString == null) {
      return ((Integer)paramzzeg.zza(null)).intValue();
    }
    paramString = this.zzb.zza(paramString, paramzzeg.zza());
    if (TextUtils.isEmpty(paramString)) {
      return ((Integer)paramzzeg.zza(null)).intValue();
    }
    try
    {
      int i = ((Integer)paramzzeg.zza(Integer.valueOf(Integer.parseInt(paramString)))).intValue();
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return ((Integer)paramzzeg.zza(null)).intValue();
  }
  
  public final double zzc(String paramString, zzeg<Double> paramzzeg)
  {
    if (paramString == null) {
      return ((Double)paramzzeg.zza(null)).doubleValue();
    }
    paramString = this.zzb.zza(paramString, paramzzeg.zza());
    if (TextUtils.isEmpty(paramString)) {
      return ((Double)paramzzeg.zza(null)).doubleValue();
    }
    try
    {
      double d = ((Double)paramzzeg.zza(Double.valueOf(Double.parseDouble(paramString)))).doubleValue();
      return d;
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return ((Double)paramzzeg.zza(null)).doubleValue();
  }
  
  public final int zzc(String paramString)
  {
    return zzb(paramString, zzat.zzn);
  }
  
  public final int zzd()
  {
    if ((zzmi.zzb()) && (zzs().zzd(null, zzat.zzbw)))
    {
      zzkw localzzkw = zzo();
      Boolean localBoolean = localzzkw.zzy.zzv().zzaf();
      int i;
      if ((localzzkw.zzi() < 201500) && ((localBoolean == null) || (localBoolean.booleanValue()))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        return 100;
      }
    }
    return 25;
  }
  
  final int zzd(String paramString)
  {
    if ((zzmi.zzb()) && (zzd(null, zzat.zzbv))) {
      return zza(paramString, zzat.zzaf, 25, 100);
    }
    return 25;
  }
  
  public final boolean zzd(String paramString, zzeg<Boolean> paramzzeg)
  {
    if (paramString == null) {
      return ((Boolean)paramzzeg.zza(null)).booleanValue();
    }
    paramString = this.zzb.zza(paramString, paramzzeg.zza());
    if (TextUtils.isEmpty(paramString)) {
      return ((Boolean)paramzzeg.zza(null)).booleanValue();
    }
    return ((Boolean)paramzzeg.zza(Boolean.valueOf(Boolean.parseBoolean(paramString)))).booleanValue();
  }
  
  final long zze(String paramString)
  {
    return zza(paramString, zzat.zza);
  }
  
  public final boolean zze()
  {
    if (this.zzc == null) {}
    for (;;)
    {
      try
      {
        if (this.zzc == null)
        {
          Object localObject2 = zzm().getApplicationInfo();
          String str = ProcessUtils.getMyProcessName();
          if (localObject2 != null)
          {
            localObject2 = ((ApplicationInfo)localObject2).processName;
            if ((localObject2 == null) || (!((String)localObject2).equals(str))) {
              break label107;
            }
            bool = true;
            this.zzc = Boolean.valueOf(bool);
          }
          if (this.zzc == null)
          {
            this.zzc = Boolean.TRUE;
            zzq().zze().zza("My process not in the list of running processes");
          }
        }
      }
      finally {}
      return this.zzc.booleanValue();
      label107:
      boolean bool = false;
    }
  }
  
  public final boolean zze(String paramString, zzeg<Boolean> paramzzeg)
  {
    return zzd(paramString, paramzzeg);
  }
  
  final Boolean zzf(String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    Bundle localBundle = zzx();
    if (localBundle == null)
    {
      zzq().zze().zza("Failed to load metadata: Metadata bundle is null");
      return null;
    }
    if (!localBundle.containsKey(paramString)) {
      return null;
    }
    return Boolean.valueOf(localBundle.getBoolean(paramString));
  }
  
  public final boolean zzf()
  {
    Boolean localBoolean = zzf("firebase_analytics_collection_deactivated");
    return (localBoolean != null) && (localBoolean.booleanValue());
  }
  
  public final Boolean zzg()
  {
    Boolean localBoolean = zzf("google_analytics_adid_collection_enabled");
    boolean bool;
    if ((localBoolean != null) && (!localBoolean.booleanValue())) {
      bool = false;
    } else {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
  
  final List<String> zzg(String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    Bundle localBundle = zzx();
    if (localBundle == null) {
      zzq().zze().zza("Failed to load metadata: Metadata bundle is null");
    }
    while (!localBundle.containsKey(paramString))
    {
      paramString = null;
      break;
    }
    paramString = Integer.valueOf(localBundle.getInt(paramString));
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = zzm().getResources().getStringArray(paramString.intValue());
      if (paramString == null) {
        return null;
      }
      paramString = Arrays.asList(paramString);
      return paramString;
    }
    catch (Resources.NotFoundException paramString)
    {
      zzq().zze().zza("Failed to load string array from metadata: resource not found", paramString);
    }
    return null;
  }
  
  public final Boolean zzh()
  {
    boolean bool1 = zzof.zzb();
    boolean bool2 = true;
    if ((bool1) && (zza(zzat.zzbt)))
    {
      Boolean localBoolean = zzf("google_analytics_automatic_screen_reporting_enabled");
      bool1 = bool2;
      if (localBoolean != null) {
        if (localBoolean.booleanValue()) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      return Boolean.valueOf(bool1);
    }
    return Boolean.valueOf(true);
  }
  
  public final boolean zzh(String paramString)
  {
    return "1".equals(this.zzb.zza(paramString, "gaia_collection_enabled"));
  }
  
  public final boolean zzi(String paramString)
  {
    return "1".equals(this.zzb.zza(paramString, "measurement.event_sampling_enabled"));
  }
  
  final boolean zzj(String paramString)
  {
    return zzd(paramString, zzat.zzaj);
  }
  
  final String zzk(String paramString)
  {
    zzeg localzzeg = zzat.zzak;
    if (paramString == null) {
      return (String)localzzeg.zza(null);
    }
    return (String)localzzeg.zza(this.zzb.zza(paramString, localzzeg.zza()));
  }
  
  public final String zzu()
  {
    return zza("debug.firebase.analytics.app", "");
  }
  
  public final String zzv()
  {
    return zza("debug.deferred.deeplink", "");
  }
  
  final boolean zzw()
  {
    if (this.zza == null)
    {
      Boolean localBoolean = zzf("app_measurement_lite");
      this.zza = localBoolean;
      if (localBoolean == null) {
        this.zza = Boolean.valueOf(false);
      }
    }
    return (this.zza.booleanValue()) || (!this.zzy.zzs());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */