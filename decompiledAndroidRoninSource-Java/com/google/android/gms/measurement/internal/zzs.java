package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzbv.zzb;
import com.google.android.gms.internal.measurement.zzbv.zzc;
import com.google.android.gms.internal.measurement.zzcd.zzc;
import com.google.android.gms.internal.measurement.zzcd.zze;
import com.google.android.gms.internal.measurement.zzmv;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzs
  extends zzv
{
  private zzbv.zzb zzg;
  
  zzs(zzo paramzzo, String paramString, int paramInt, zzbv.zzb paramzzb)
  {
    super(paramString, paramInt);
    this.zzg = paramzzb;
  }
  
  final int zza()
  {
    return this.zzg.zzb();
  }
  
  final boolean zza(Long paramLong1, Long paramLong2, zzcd.zzc paramzzc, long paramLong, zzan paramzzan, boolean paramBoolean)
  {
    boolean bool1 = zzmv.zzb();
    Boolean localBoolean = Boolean.valueOf(true);
    Object localObject1 = Boolean.valueOf(false);
    int i;
    if ((bool1) && (this.zzh.zzs().zzd(this.zza, zzat.zzbb))) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.zzg.zzk()) {
      paramLong = paramzzan.zze;
    }
    bool1 = this.zzh.zzq().zza(2);
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4;
    int j;
    if (bool1)
    {
      localObject4 = this.zzh.zzq().zzw();
      j = this.zzb;
      if (this.zzg.zza()) {
        paramzzan = Integer.valueOf(this.zzg.zzb());
      } else {
        paramzzan = null;
      }
      ((zzet)localObject4).zza("Evaluating filter. audience, filter, event", Integer.valueOf(j), paramzzan, this.zzh.zzn().zza(this.zzg.zzc()));
      this.zzh.zzq().zzw().zza("Filter definition", this.zzh.f_().zza(this.zzg));
    }
    if ((this.zzg.zza()) && (this.zzg.zzb() <= 256))
    {
      bool1 = this.zzg.zzh();
      boolean bool2 = this.zzg.zzi();
      boolean bool3 = this.zzg.zzk();
      if ((!bool1) && (!bool2) && (!bool3)) {
        j = 0;
      } else {
        j = 1;
      }
      if ((paramBoolean) && (j == 0))
      {
        paramLong2 = this.zzh.zzq().zzw();
        i = this.zzb;
        paramLong1 = (Long)localObject3;
        if (this.zzg.zza()) {
          paramLong1 = Integer.valueOf(this.zzg.zzb());
        }
        paramLong2.zza("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(i), paramLong1);
        return true;
      }
      localObject4 = this.zzg;
      localObject2 = paramzzc.zzc();
      if (((zzbv.zzb)localObject4).zzf())
      {
        paramzzan = zza(paramLong, ((zzbv.zzb)localObject4).zzg());
        if (paramzzan != null) {}
      }
      for (;;)
      {
        paramzzan = null;
        break label1347;
        if (!paramzzan.booleanValue())
        {
          paramzzan = (zzan)localObject1;
          break label1347;
        }
        Object localObject5 = new HashSet();
        paramzzan = ((zzbv.zzb)localObject4).zzd().iterator();
        for (;;)
        {
          if (!paramzzan.hasNext()) {
            break label504;
          }
          localObject3 = (zzbv.zzc)paramzzan.next();
          if (((zzbv.zzc)localObject3).zzh().isEmpty())
          {
            this.zzh.zzq().zzh().zza("null or empty param name in filter. event", this.zzh.zzn().zza((String)localObject2));
            break;
          }
          ((Set)localObject5).add(((zzbv.zzc)localObject3).zzh());
        }
        label504:
        localObject3 = new ArrayMap();
        Object localObject6 = paramzzc.zza().iterator();
        for (;;)
        {
          if (((Iterator)localObject6).hasNext())
          {
            paramzzan = (zzcd.zze)((Iterator)localObject6).next();
            if (((Set)localObject5).contains(paramzzan.zzb()))
            {
              String str;
              if (paramzzan.zze())
              {
                str = paramzzan.zzb();
                if (paramzzan.zze()) {
                  paramzzan = Long.valueOf(paramzzan.zzf());
                } else {
                  paramzzan = null;
                }
                ((Map)localObject3).put(str, paramzzan);
              }
              else if (paramzzan.zzi())
              {
                str = paramzzan.zzb();
                if (paramzzan.zzi()) {
                  paramzzan = Double.valueOf(paramzzan.zzj());
                } else {
                  paramzzan = null;
                }
                ((Map)localObject3).put(str, paramzzan);
              }
              else if (paramzzan.zzc())
              {
                ((Map)localObject3).put(paramzzan.zzb(), paramzzan.zzd());
              }
              else
              {
                this.zzh.zzq().zzh().zza("Unknown value for param. event, param", this.zzh.zzn().zza((String)localObject2), this.zzh.zzn().zzb(paramzzan.zzb()));
                break;
              }
            }
          }
        }
        localObject4 = ((zzbv.zzb)localObject4).zzd().iterator();
        label959:
        label1061:
        do
        {
          do
          {
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break label1343;
              }
              paramzzan = (zzbv.zzc)((Iterator)localObject4).next();
              if ((paramzzan.zze()) && (paramzzan.zzf())) {
                paramBoolean = true;
              } else {
                paramBoolean = false;
              }
              localObject5 = paramzzan.zzh();
              if (((String)localObject5).isEmpty())
              {
                this.zzh.zzq().zzh().zza("Event has empty param name. event", this.zzh.zzn().zza((String)localObject2));
                break;
              }
              localObject6 = ((Map)localObject3).get(localObject5);
              if (!(localObject6 instanceof Long)) {
                break label959;
              }
              if (!paramzzan.zzc())
              {
                this.zzh.zzq().zzh().zza("No number filter for long param. event, param", this.zzh.zzn().zza((String)localObject2), this.zzh.zzn().zzb((String)localObject5));
                break;
              }
              paramzzan = zza(((Long)localObject6).longValue(), paramzzan.zzd());
              if (paramzzan == null) {
                break;
              }
            } while (paramzzan.booleanValue() != paramBoolean);
            paramzzan = (zzan)localObject1;
            break label1347;
            if (!(localObject6 instanceof Double)) {
              break label1061;
            }
            if (!paramzzan.zzc())
            {
              this.zzh.zzq().zzh().zza("No number filter for double param. event, param", this.zzh.zzn().zza((String)localObject2), this.zzh.zzn().zzb((String)localObject5));
              break;
            }
            paramzzan = zza(((Double)localObject6).doubleValue(), paramzzan.zzd());
            if (paramzzan == null) {
              break;
            }
          } while (paramzzan.booleanValue() != paramBoolean);
          paramzzan = (zzan)localObject1;
          break label1347;
          if (!(localObject6 instanceof String)) {
            break label1248;
          }
          if (paramzzan.zza())
          {
            paramzzan = zza((String)localObject6, paramzzan.zzb(), this.zzh.zzq());
          }
          else
          {
            if (!paramzzan.zzc()) {
              break label1205;
            }
            localObject6 = (String)localObject6;
            if (!zzks.zza((String)localObject6)) {
              break label1162;
            }
            paramzzan = zza((String)localObject6, paramzzan.zzd());
          }
          if (paramzzan == null) {
            break;
          }
        } while (paramzzan.booleanValue() != paramBoolean);
        paramzzan = (zzan)localObject1;
        break label1347;
        label1162:
        this.zzh.zzq().zzh().zza("Invalid param value for number filter. event, param", this.zzh.zzn().zza((String)localObject2), this.zzh.zzn().zzb((String)localObject5));
        continue;
        label1205:
        this.zzh.zzq().zzh().zza("No filter for String param. event, param", this.zzh.zzn().zza((String)localObject2), this.zzh.zzn().zzb((String)localObject5));
        continue;
        label1248:
        if (localObject6 == null)
        {
          this.zzh.zzq().zzw().zza("Missing param for filter. event, param", this.zzh.zzn().zza((String)localObject2), this.zzh.zzn().zzb((String)localObject5));
          paramzzan = (zzan)localObject1;
          break label1347;
        }
        this.zzh.zzq().zzh().zza("Unknown param type. event, param", this.zzh.zzn().zza((String)localObject2), this.zzh.zzn().zzb((String)localObject5));
      }
      label1343:
      paramzzan = localBoolean;
      label1347:
      localObject2 = this.zzh.zzq().zzw();
      if (paramzzan == null) {
        localObject1 = "null";
      } else {
        localObject1 = paramzzan;
      }
      ((zzet)localObject2).zza("Event filter result", localObject1);
      if (paramzzan == null) {
        return false;
      }
      this.zzc = localBoolean;
      if (!paramzzan.booleanValue()) {
        return true;
      }
      this.zzd = localBoolean;
      if ((j != 0) && (paramzzc.zzd()))
      {
        paramzzc = Long.valueOf(paramzzc.zze());
        if (this.zzg.zzi())
        {
          paramLong2 = paramzzc;
          if (i != 0)
          {
            paramLong2 = paramzzc;
            if (this.zzg.zzf()) {
              paramLong2 = paramLong1;
            }
          }
          this.zzf = paramLong2;
          return true;
        }
        paramLong1 = paramzzc;
        if (i != 0)
        {
          paramLong1 = paramzzc;
          if (this.zzg.zzf()) {
            paramLong1 = paramLong2;
          }
        }
        this.zze = paramLong1;
      }
      return true;
    }
    paramLong2 = this.zzh.zzq().zzh();
    paramzzc = zzer.zza(this.zza);
    paramLong1 = (Long)localObject2;
    if (this.zzg.zza()) {
      paramLong1 = Integer.valueOf(this.zzg.zzb());
    }
    paramLong2.zza("Invalid event filter ID. appId, id", paramzzc, String.valueOf(paramLong1));
    return false;
  }
  
  final boolean zzb()
  {
    return false;
  }
  
  final boolean zzc()
  {
    return this.zzg.zzf();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */