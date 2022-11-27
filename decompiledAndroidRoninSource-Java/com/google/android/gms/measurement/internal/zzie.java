package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzcd.zzc;
import com.google.android.gms.internal.measurement.zzcd.zzc.zza;
import com.google.android.gms.internal.measurement.zzcd.zzd;
import com.google.android.gms.internal.measurement.zzcd.zzd.zza;
import com.google.android.gms.internal.measurement.zzcd.zze;
import com.google.android.gms.internal.measurement.zzcd.zze.zza;
import com.google.android.gms.internal.measurement.zzcd.zzf;
import com.google.android.gms.internal.measurement.zzcd.zzf.zza;
import com.google.android.gms.internal.measurement.zzcd.zzg;
import com.google.android.gms.internal.measurement.zzcd.zzg.zza;
import com.google.android.gms.internal.measurement.zzcd.zzh;
import com.google.android.gms.internal.measurement.zzcd.zzh.zza;
import com.google.android.gms.internal.measurement.zzcd.zzk;
import com.google.android.gms.internal.measurement.zzcd.zzk.zza;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzhz.zza;
import com.google.android.gms.internal.measurement.zzmj;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.internal.measurement.zzny;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzie
  extends zzkj
{
  public zzie(zzki paramzzki)
  {
    super(paramzzki);
  }
  
  private static String zza(String paramString1, String paramString2)
  {
    throw new SecurityException("This implementation should not be used.");
  }
  
  public final byte[] zza(zzar paramzzar, String paramString)
  {
    zzc();
    this.zzy.zzad();
    Preconditions.checkNotNull(paramzzar);
    Preconditions.checkNotEmpty(paramString);
    boolean bool2 = zzs().zze(paramString, zzat.zzav);
    int i = 0;
    if (!bool2)
    {
      zzq().zzv().zza("Generating ScionPayload disabled. packageName", paramString);
      return new byte[0];
    }
    if ((!"_iap".equals(paramzzar.zza)) && (!"_iapx".equals(paramzzar.zza)))
    {
      zzq().zzv().zza("Generating a payload for this event is not available. package_name, event_name", paramString, paramzzar.zza);
      return null;
    }
    zzcd.zzf.zza localzza1 = zzcd.zzf.zzb();
    zzi().zze();
    label2026:
    for (;;)
    {
      try
      {
        zzf localzzf = zzi().zzb(paramString);
        if (localzzf == null)
        {
          zzq().zzv().zza("Log and bundle not available. package_name", paramString);
          return new byte[0];
        }
        if (!localzzf.zzr())
        {
          zzq().zzv().zza("Log and bundle disabled. package_name", paramString);
          return new byte[0];
        }
        zzcd.zzg.zza localzza = zzcd.zzg.zzbh().zza(1).zza("android");
        if (!TextUtils.isEmpty(localzzf.zzc())) {
          localzza.zzf(localzzf.zzc());
        }
        if (!TextUtils.isEmpty(localzzf.zzn())) {
          localzza.zze(localzzf.zzn());
        }
        if (!TextUtils.isEmpty(localzzf.zzl())) {
          localzza.zzg(localzzf.zzl());
        }
        if (localzzf.zzm() != -2147483648L) {
          localzza.zzh((int)localzzf.zzm());
        }
        localzza.zzf(localzzf.zzo()).zzk(localzzf.zzq());
        if ((zznt.zzb()) && (zzs().zze(localzzf.zzc(), zzat.zzbi)))
        {
          if (!TextUtils.isEmpty(localzzf.zze())) {
            localzza.zzk(localzzf.zze());
          } else if (!TextUtils.isEmpty(localzzf.zzg())) {
            localzza.zzp(localzzf.zzg());
          } else if (!TextUtils.isEmpty(localzzf.zzf())) {
            localzza.zzo(localzzf.zzf());
          }
        }
        else if (!TextUtils.isEmpty(localzzf.zze())) {
          localzza.zzk(localzzf.zze());
        } else if (!TextUtils.isEmpty(localzzf.zzf())) {
          localzza.zzo(localzzf.zzf());
        }
        Object localObject1 = this.zza.zza(paramString);
        localzza.zzh(localzzf.zzp());
        if ((this.zzy.zzaa()) && (zzs().zzh(localzza.zzj()))) {
          if ((zzmj.zzb()) && (zzs().zza(zzat.zzci)))
          {
            if ((((zzad)localObject1).zzc()) && (!TextUtils.isEmpty(null))) {
              localzza.zzn(null);
            }
          }
          else
          {
            localzza.zzj();
            if (!TextUtils.isEmpty(null)) {
              localzza.zzn(null);
            }
          }
        }
        if ((zzmj.zzb()) && (zzs().zza(zzat.zzci))) {
          localzza.zzq(((zzad)localObject1).zza());
        }
        if ((!zzmj.zzb()) || (!zzs().zza(zzat.zzci)) || (((zzad)localObject1).zzc()))
        {
          localObject2 = zzf().zza(localzzf.zzc(), (zzad)localObject1);
          if ((localzzf.zzaf()) && (localObject2 != null))
          {
            bool2 = TextUtils.isEmpty((CharSequence)((Pair)localObject2).first);
            if (!bool2) {
              try
              {
                localzza.zzh(zza((String)((Pair)localObject2).first, Long.toString(paramzzar.zzd)));
                if (((Pair)localObject2).second != null) {
                  localzza.zza(((Boolean)((Pair)localObject2).second).booleanValue());
                }
              }
              catch (SecurityException paramzzar)
              {
                zzq().zzv().zza("Resettable device id encryption failed", paramzzar.getMessage());
                return new byte[0];
              }
            }
          }
        }
        zzk().zzaa();
        Object localObject2 = localzza.zzc(Build.MODEL);
        zzk().zzaa();
        ((zzcd.zzg.zza)localObject2).zzb(Build.VERSION.RELEASE).zzf((int)zzk().zze()).zzd(zzk().zzf());
        try
        {
          if ((!zzmj.zzb()) || (!zzs().zza(zzat.zzci)) || (((zzad)localObject1).zze())) {
            localzza.zzi(zza(localzzf.zzd(), Long.toString(paramzzar.zzd)));
          }
          if (!TextUtils.isEmpty(localzzf.zzi())) {
            localzza.zzl(localzzf.zzi());
          }
          Object localObject3 = localzzf.zzc();
          localObject2 = zzi().zza((String)localObject3);
          Iterator localIterator = ((List)localObject2).iterator();
          if (localIterator.hasNext())
          {
            localObject1 = (zzkt)localIterator.next();
            if (!"_lte".equals(((zzkt)localObject1).zzc)) {
              continue;
            }
            if ((localObject1 == null) || (((zzkt)localObject1).zze == null))
            {
              localObject1 = new zzkt((String)localObject3, "auto", "_lte", zzl().currentTimeMillis(), Long.valueOf(0L));
              ((List)localObject2).add(localObject1);
              zzi().zza((zzkt)localObject1);
            }
            localObject1 = f_();
            ((zzgo)localObject1).zzq().zzw().zza("Checking account type status for ad personalization signals");
            if (((zzgo)localObject1).zzk().zzi())
            {
              localObject3 = localzzf.zzc();
              if ((localzzf.zzaf()) && (((zzkg)localObject1).zzj().zze((String)localObject3)))
              {
                ((zzgo)localObject1).zzq().zzv().zza("Turning off ad personalization due to account type");
                localIterator = ((List)localObject2).iterator();
                if (localIterator.hasNext())
                {
                  if (!"_npa".equals(((zzkt)localIterator.next()).zzc)) {
                    break label2026;
                  }
                  localIterator.remove();
                }
                ((List)localObject2).add(new zzkt((String)localObject3, "auto", "_npa", ((zzgo)localObject1).zzl().currentTimeMillis(), Long.valueOf(1L)));
              }
            }
            localObject1 = new zzcd.zzk[((List)localObject2).size()];
            if (i < ((List)localObject2).size())
            {
              localObject3 = zzcd.zzk.zzj().zza(((zzkt)((List)localObject2).get(i)).zzc).zza(((zzkt)((List)localObject2).get(i)).zzd);
              f_().zza((zzcd.zzk.zza)localObject3, ((zzkt)((List)localObject2).get(i)).zze);
              localObject1[i] = ((zzcd.zzk)(zzhz)((zzhz.zza)localObject3).zzz());
              i += 1;
              continue;
            }
            localzza.zzb(Arrays.asList((Object[])localObject1));
            if ((zzny.zzb()) && (zzs().zza(zzat.zzbz)) && (zzs().zza(zzat.zzca)))
            {
              localObject1 = zzev.zza(paramzzar);
              zzo().zza(((zzev)localObject1).zzb, zzi().zzi(paramString));
              zzo().zza((zzev)localObject1, zzs().zza(paramString));
              localObject2 = ((zzev)localObject1).zzb;
            }
            else
            {
              localObject2 = paramzzar.zzb.zzb();
            }
            ((Bundle)localObject2).putLong("_c", 1L);
            zzq().zzv().zza("Marking in-app purchase as real-time");
            ((Bundle)localObject2).putLong("_r", 1L);
            ((Bundle)localObject2).putString("_o", paramzzar.zzc);
            if (zzo().zze(localzza.zzj()))
            {
              zzo().zza((Bundle)localObject2, "_dbg", Long.valueOf(1L));
              zzo().zza((Bundle)localObject2, "_r", Long.valueOf(1L));
            }
            localObject1 = zzi().zza(paramString, paramzzar.zza);
            if (localObject1 == null)
            {
              localObject1 = new zzan(paramString, paramzzar.zza, 0L, 0L, paramzzar.zzd, 0L, null, null, null, null);
              l1 = 0L;
            }
            else
            {
              l1 = ((zzan)localObject1).zzf;
              localObject1 = ((zzan)localObject1).zza(paramzzar.zzd);
            }
            zzi().zza((zzan)localObject1);
            localObject2 = new zzak(this.zzy, paramzzar.zzc, paramString, paramzzar.zza, paramzzar.zzd, l1, (Bundle)localObject2);
            localObject3 = zzcd.zzc.zzj().zza(((zzak)localObject2).zzc).zza(((zzak)localObject2).zzb).zzb(((zzak)localObject2).zzd);
            localIterator = ((zzak)localObject2).zze.iterator();
            if (localIterator.hasNext())
            {
              Object localObject4 = (String)localIterator.next();
              zzcd.zze.zza localzza2 = zzcd.zze.zzm().zza((String)localObject4);
              localObject4 = ((zzak)localObject2).zze.zza((String)localObject4);
              f_().zza(localzza2, localObject4);
              ((zzcd.zzc.zza)localObject3).zza(localzza2);
              continue;
            }
            localzza.zza((zzcd.zzc.zza)localObject3).zza(zzcd.zzh.zza().zza(zzcd.zzd.zza().zza(((zzan)localObject1).zzc).zza(paramzzar.zza)));
            localzza.zzc(zzh().zza(localzzf.zzc(), Collections.emptyList(), localzza.zzd(), Long.valueOf(((zzcd.zzc.zza)localObject3).zzf()), Long.valueOf(((zzcd.zzc.zza)localObject3).zzf())));
            if (((zzcd.zzc.zza)localObject3).zze()) {
              localzza.zzb(((zzcd.zzc.zza)localObject3).zzf()).zzc(((zzcd.zzc.zza)localObject3).zzf());
            }
            long l1 = localzzf.zzk();
            boolean bool1 = l1 < 0L;
            if (bool1) {
              localzza.zze(l1);
            }
            long l2 = localzzf.zzj();
            if (l2 != 0L) {
              localzza.zzd(l2);
            } else if (bool1) {
              localzza.zzd(l1);
            }
            localzzf.zzv();
            localzza.zzg((int)localzzf.zzs()).zzg(32053L).zza(zzl().currentTimeMillis()).zzb(Boolean.TRUE.booleanValue());
            localzza1.zza(localzza);
            localzzf.zza(localzza.zzf());
            localzzf.zzb(localzza.zzg());
            zzi().zza(localzzf);
            zzi().b_();
            zzi().zzg();
            try
            {
              paramzzar = f_().zzc(((zzcd.zzf)localzza1.zzz()).zzbk());
              return paramzzar;
            }
            catch (IOException paramzzar)
            {
              zzq().zze().zza("Data loss. Failed to bundle and serialize. appId", zzer.zza(paramString), paramzzar);
              return null;
            }
            paramzzar = finally;
          }
        }
        catch (SecurityException paramzzar)
        {
          zzq().zzv().zza("app instance id encryption failed", paramzzar.getMessage());
          return new byte[0];
        }
        localObject1 = null;
      }
      finally
      {
        zzi().zzg();
      }
    }
  }
  
  protected final boolean zzd()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */