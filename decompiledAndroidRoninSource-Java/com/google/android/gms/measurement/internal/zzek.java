package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.measurement.zzmj;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.internal.measurement.zzpi;
import java.lang.reflect.Method;
import java.util.List;

public final class zzek
  extends zzg
{
  private String zza;
  private String zzb;
  private int zzc;
  private String zzd;
  private String zze;
  private long zzf;
  private long zzg;
  private List<String> zzh;
  private int zzi;
  private String zzj;
  private String zzk;
  private String zzl;
  
  zzek(zzfv paramzzfv, long paramLong)
  {
    super(paramzzfv);
    this.zzg = paramLong;
  }
  
  private final String zzah()
  {
    if ((zzpi.zzb()) && (zzs().zza(zzat.zzbk)))
    {
      zzq().zzw().zza("Disabled IID for tests.");
      return null;
    }
    for (;;)
    {
      try
      {
        localObject1 = zzm().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
        if (localObject1 == null) {
          return null;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Object localObject1;
        Object localObject2;
        label113:
        return null;
      }
      try
      {
        localObject2 = ((Class)localObject1).getDeclaredMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { zzm() });
        if (localObject2 == null) {
          return null;
        }
      }
      catch (Exception localException1) {}
    }
    try
    {
      localObject1 = (String)((Class)localObject1).getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(localObject2, new Object[0]);
      return (String)localObject1;
    }
    catch (Exception localException2)
    {
      break label113;
    }
    zzq().zzj().zza("Failed to retrieve Firebase Instance Id");
    return null;
    zzq().zzi().zza("Failed to obtain Firebase Analytics instance");
    return null;
  }
  
  final zzn zza(String paramString)
  {
    zzc();
    String str3 = zzaa();
    String str4 = zzab();
    zzv();
    String str5 = this.zzb;
    long l2 = zzae();
    zzv();
    String str6 = this.zzd;
    zzv();
    zzc();
    if (this.zzf == 0L) {
      this.zzf = this.zzy.zzh().zza(zzm(), zzm().getPackageName());
    }
    long l3 = this.zzf;
    boolean bool2 = this.zzy.zzaa();
    boolean bool3 = zzr().zzq;
    zzc();
    String str1;
    if (!this.zzy.zzaa()) {
      str1 = null;
    } else {
      str1 = zzah();
    }
    Object localObject1 = this.zzy;
    Object localObject2 = Long.valueOf(((zzfv)localObject1).zzb().zzh.zza());
    long l1;
    if (((Long)localObject2).longValue() == 0L) {
      l1 = ((zzfv)localObject1).zza;
    } else {
      l1 = Math.min(((zzfv)localObject1).zza, ((Long)localObject2).longValue());
    }
    int i = zzaf();
    boolean bool4 = zzs().zzg().booleanValue();
    localObject1 = zzs().zzf("google_analytics_ssaid_collection_enabled");
    if ((localObject1 != null) && (!((Boolean)localObject1).booleanValue())) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool1 = Boolean.valueOf(bool1).booleanValue();
    localObject1 = zzr();
    ((zzgo)localObject1).zzc();
    boolean bool5 = ((zzfd)localObject1).zzf().getBoolean("deferred_analytics_collection", false);
    String str7 = zzac();
    localObject1 = zzs().zzf("google_analytics_default_allow_ad_personalization_signals");
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = Boolean.valueOf(true ^ ((Boolean)localObject1).booleanValue());
    }
    long l4 = this.zzg;
    List localList = this.zzh;
    if ((zznt.zzb()) && (zzs().zza(zzat.zzbi))) {
      localObject2 = zzad();
    } else {
      localObject2 = null;
    }
    String str2;
    if ((zzmj.zzb()) && (zzs().zza(zzat.zzcg))) {
      str2 = zzr().zzw().zza();
    } else {
      str2 = "";
    }
    return new zzn(str3, str4, str5, l2, str6, 32053L, l3, paramString, bool2, bool3 ^ true, str1, 0L, l1, i, bool4, bool1, bool5, str7, (Boolean)localObject1, l4, localList, (String)localObject2, str2);
  }
  
  final String zzaa()
  {
    zzv();
    return this.zza;
  }
  
  final String zzab()
  {
    zzv();
    return this.zzj;
  }
  
  final String zzac()
  {
    zzv();
    return this.zzk;
  }
  
  final String zzad()
  {
    zzv();
    return this.zzl;
  }
  
  final int zzae()
  {
    zzv();
    return this.zzc;
  }
  
  final int zzaf()
  {
    zzv();
    return this.zzi;
  }
  
  final List<String> zzag()
  {
    return this.zzh;
  }
  
  protected final boolean zzy()
  {
    return true;
  }
  
  protected final void zzz()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */