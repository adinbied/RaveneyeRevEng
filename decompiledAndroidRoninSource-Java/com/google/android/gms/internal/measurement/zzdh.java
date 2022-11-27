package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.util.Log;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public abstract class zzdh<T>
{
  private static final Object zza = new Object();
  @Nullable
  private static volatile zzdp zzb = null;
  private static volatile boolean zzc = false;
  private static final AtomicReference<Collection<zzdh<?>>> zzd = new AtomicReference();
  private static zzdq zze = new zzdq(zzdj.zza);
  private static final AtomicInteger zzi = new AtomicInteger();
  private final zzdm zzf;
  private final String zzg;
  private final T zzh;
  private volatile int zzj = -1;
  private volatile T zzk;
  private final boolean zzl;
  
  private zzdh(zzdm paramzzdm, String paramString, T paramT, boolean paramBoolean)
  {
    if (paramzzdm.zza != null)
    {
      this.zzf = paramzzdm;
      this.zzg = paramString;
      this.zzh = paramT;
      this.zzl = paramBoolean;
      return;
    }
    throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
  }
  
  private final String zza(String paramString)
  {
    if ((paramString != null) && (paramString.isEmpty())) {
      return this.zzg;
    }
    paramString = String.valueOf(paramString);
    String str = String.valueOf(this.zzg);
    if (str.length() != 0) {
      return paramString.concat(str);
    }
    return new String(paramString);
  }
  
  static void zza()
  {
    zzi.incrementAndGet();
  }
  
  @Deprecated
  public static void zza(Context paramContext)
  {
    for (;;)
    {
      Context localContext;
      synchronized (zza)
      {
        zzdp localzzdp = zzb;
        localContext = paramContext.getApplicationContext();
        if (localContext == null)
        {
          if ((localzzdp == null) || (localzzdp.zza() != paramContext))
          {
            zzct.zzc();
            zzdo.zza();
            zzcy.zza();
            zzb = new zzcq(paramContext, zzef.zza(new zzdg(paramContext)));
            zzi.incrementAndGet();
          }
          return;
        }
      }
      paramContext = localContext;
    }
  }
  
  private static zzdh<Double> zzb(zzdm paramzzdm, String paramString, double paramDouble, boolean paramBoolean)
  {
    return new zzdk(paramzzdm, paramString, Double.valueOf(-3.0D), true);
  }
  
  private static zzdh<Long> zzb(zzdm paramzzdm, String paramString, long paramLong, boolean paramBoolean)
  {
    return new zzdi(paramzzdm, paramString, Long.valueOf(paramLong), true);
  }
  
  private static zzdh<String> zzb(zzdm paramzzdm, String paramString1, String paramString2, boolean paramBoolean)
  {
    return new zzdn(paramzzdm, paramString1, paramString2, true);
  }
  
  private static zzdh<Boolean> zzb(zzdm paramzzdm, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new zzdl(paramzzdm, paramString, Boolean.valueOf(paramBoolean1), true);
  }
  
  abstract T zza(Object paramObject);
  
  public final String zzb()
  {
    return zza(this.zzf.zzc);
  }
  
  public final T zzc()
  {
    if (!this.zzl) {
      zzeb.zzb(zze.zza(this.zzg), "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error.");
    }
    int j = zzi.get();
    if (this.zzj < j) {}
    for (;;)
    {
      try
      {
        if (this.zzj < j)
        {
          Object localObject4 = zzb;
          i = 1;
          if (localObject4 == null) {
            break label427;
          }
          bool = true;
          zzeb.zzb(bool, "Must call PhenotypeFlag.init() first");
          Object localObject1 = (String)zzcy.zza(((zzdp)localObject4).zza()).zza("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
          if ((localObject1 == null) || (!zzcp.zzb.matcher((CharSequence)localObject1).matches())) {
            break label432;
          }
          if (i == 0)
          {
            if (this.zzf.zza != null)
            {
              if (!zzdf.zza(((zzdp)localObject4).zza(), this.zzf.zza)) {
                break label437;
              }
              localObject1 = zzct.zza(((zzdp)localObject4).zza().getContentResolver(), this.zzf.zza);
            }
            else
            {
              localObject1 = zzdo.zza(((zzdp)localObject4).zza(), null);
            }
            if (localObject1 == null) {
              break label443;
            }
            localObject1 = ((zzcx)localObject1).zza(zzb());
            if (localObject1 == null) {
              break label443;
            }
            localObject1 = zza(localObject1);
            break label446;
          }
          if (!Log.isLoggable("PhenotypeFlag", 3)) {
            break label443;
          }
          localObject1 = String.valueOf(zzb());
          if (((String)localObject1).length() != 0) {
            localObject1 = "Bypass reading Phenotype values for flag: ".concat((String)localObject1);
          } else {
            localObject1 = new String("Bypass reading Phenotype values for flag: ");
          }
          Log.d("PhenotypeFlag", (String)localObject1);
          break label443;
          localObject1 = zzcy.zza(((zzdp)localObject4).zza()).zza(zza(this.zzf.zzb));
          if (localObject1 == null) {
            break label454;
          }
          localObject1 = zza(localObject1);
          break label457;
          localObject1 = this.zzh;
          localObject4 = (zzdy)((zzdp)localObject4).zzb().zza();
          if (((zzdy)localObject4).zza())
          {
            localObject1 = ((zzdd)((zzdy)localObject4).zzb()).zza(this.zzf.zza, null, this.zzf.zzc, this.zzg);
            if (localObject1 == null) {
              localObject1 = this.zzh;
            } else {
              localObject1 = zza(localObject1);
            }
          }
          this.zzk = localObject1;
          this.zzj = j;
        }
      }
      finally {}
      return (T)this.zzk;
      label427:
      boolean bool = false;
      continue;
      label432:
      int i = 0;
      continue;
      label437:
      Object localObject3 = null;
      continue;
      label443:
      localObject3 = null;
      label446:
      if (localObject3 != null)
      {
        continue;
        label454:
        localObject3 = null;
        label457:
        if (localObject3 == null) {}
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */