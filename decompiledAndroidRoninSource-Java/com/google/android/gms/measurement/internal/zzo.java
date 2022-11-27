package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbv.zzb;
import com.google.android.gms.internal.measurement.zzbv.zze;
import com.google.android.gms.internal.measurement.zzcd.zza;
import com.google.android.gms.internal.measurement.zzcd.zzb;
import com.google.android.gms.internal.measurement.zzcd.zzc;
import com.google.android.gms.internal.measurement.zzcd.zzi;
import com.google.android.gms.internal.measurement.zzcd.zzi.zza;
import com.google.android.gms.internal.measurement.zzcd.zzj;
import com.google.android.gms.internal.measurement.zzcd.zzk;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzhz.zza;
import com.google.android.gms.internal.measurement.zzmv;
import com.google.android.gms.internal.measurement.zznb;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzo
  extends zzkj
{
  private String zzb;
  private Set<Integer> zzc;
  private Map<Integer, zzq> zzd;
  private Long zze;
  private Long zzf;
  
  zzo(zzki paramzzki)
  {
    super(paramzzki);
  }
  
  private final zzq zza(int paramInt)
  {
    if (this.zzd.containsKey(Integer.valueOf(paramInt))) {
      return (zzq)this.zzd.get(Integer.valueOf(paramInt));
    }
    zzq localzzq = new zzq(this, this.zzb, null);
    this.zzd.put(Integer.valueOf(paramInt), localzzq);
    return localzzq;
  }
  
  private final boolean zza(int paramInt1, int paramInt2)
  {
    if (this.zzd.get(Integer.valueOf(paramInt1)) == null) {
      return false;
    }
    return zzq.zza((zzq)this.zzd.get(Integer.valueOf(paramInt1))).get(paramInt2);
  }
  
  final List<zzcd.zza> zza(String paramString, List<zzcd.zzc> paramList, List<zzcd.zzk> paramList1, Long paramLong1, Long paramLong2)
  {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramList);
    Preconditions.checkNotNull(paramList1);
    this.zzb = paramString;
    this.zzc = new HashSet();
    this.zzd = new ArrayMap();
    this.zze = paramLong1;
    this.zzf = paramLong2;
    paramString = paramList.iterator();
    while (paramString.hasNext()) {
      if ("_s".equals(((zzcd.zzc)paramString.next()).zzc()))
      {
        k = 1;
        break label99;
      }
    }
    int k = 0;
    label99:
    int i;
    if ((zzmv.zzb()) && (zzs().zzd(this.zzb, zzat.zzbb))) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((zzmv.zzb()) && (zzs().zzd(this.zzb, zzat.zzba))) {
      j = 1;
    } else {
      j = 0;
    }
    if (k != 0)
    {
      paramString = zzi();
      paramLong1 = this.zzb;
      paramString.zzaj();
      paramString.zzc();
      Preconditions.checkNotEmpty(paramLong1);
      paramLong2 = new ContentValues();
      paramLong2.put("current_session_count", Integer.valueOf(0));
      try
      {
        paramString.c_().update("events", paramLong2, "app_id = ?", new String[] { paramLong1 });
      }
      catch (SQLiteException paramLong2)
      {
        paramString.zzq().zze().zza("Error resetting session-scoped event counts. appId", zzer.zza(paramLong1), paramLong2);
      }
    }
    paramString = Collections.emptyMap();
    paramLong1 = paramString;
    if (j != 0)
    {
      paramLong1 = paramString;
      if (i != 0) {
        paramLong1 = zzi().zze(this.zzb);
      }
    }
    Object localObject1 = zzi().zzg(this.zzb);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    label1121:
    long l;
    if (((zznb.zzb()) && (zzs().zzd(this.zzb, zzat.zzce))) || ((localObject1 != null) && (!((Map)localObject1).isEmpty())))
    {
      paramLong2 = new HashSet(((Map)localObject1).keySet());
      int m;
      if (k != 0)
      {
        localObject2 = this.zzb;
        Preconditions.checkNotEmpty((String)localObject2);
        Preconditions.checkNotNull(localObject1);
        paramString = new ArrayMap();
        if (!((Map)localObject1).isEmpty())
        {
          localObject2 = zzi().zzf((String)localObject2);
          localObject3 = ((Map)localObject1).keySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            m = ((Integer)((Iterator)localObject3).next()).intValue();
            localObject4 = (zzcd.zzi)((Map)localObject1).get(Integer.valueOf(m));
            localObject5 = (List)((Map)localObject2).get(Integer.valueOf(m));
            if ((localObject5 != null) && (!((List)localObject5).isEmpty()))
            {
              localObject6 = f_().zza(((zzcd.zzi)localObject4).zzc(), (List)localObject5);
              if (!((List)localObject6).isEmpty())
              {
                localObject6 = ((zzcd.zzi.zza)((zzhz)localObject4).zzbn()).zzb().zzb((Iterable)localObject6);
                localObject7 = f_().zza(((zzcd.zzi)localObject4).zza(), (List)localObject5);
                ((zzcd.zzi.zza)localObject6).zza().zza((Iterable)localObject7);
                k = 0;
                while (k < ((zzcd.zzi)localObject4).zzf())
                {
                  if (((List)localObject5).contains(Integer.valueOf(((zzcd.zzi)localObject4).zza(k).zzb()))) {
                    ((zzcd.zzi.zza)localObject6).zza(k);
                  }
                  k += 1;
                }
                k = 0;
                while (k < ((zzcd.zzi)localObject4).zzh())
                {
                  if (((List)localObject5).contains(Integer.valueOf(((zzcd.zzi)localObject4).zzb(k).zzb()))) {
                    ((zzcd.zzi.zza)localObject6).zzb(k);
                  }
                  k += 1;
                }
                paramString.put(Integer.valueOf(m), (zzcd.zzi)((zzhz.zza)localObject6).zzz());
              }
            }
            else
            {
              paramString.put(Integer.valueOf(m), localObject4);
            }
          }
        }
      }
      else
      {
        paramString = (String)localObject1;
      }
      localObject2 = paramLong2.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        int n = ((Integer)((Iterator)localObject2).next()).intValue();
        localObject6 = (zzcd.zzi)paramString.get(Integer.valueOf(n));
        localObject3 = new BitSet();
        localObject4 = new BitSet();
        localObject5 = new ArrayMap();
        if ((localObject6 != null) && (((zzcd.zzi)localObject6).zzf() != 0))
        {
          localObject7 = ((zzcd.zzi)localObject6).zze().iterator();
          while (((Iterator)localObject7).hasNext())
          {
            paramLong2 = (zzcd.zzb)((Iterator)localObject7).next();
            if (paramLong2.zza())
            {
              k = paramLong2.zzb();
              if (paramLong2.zzc()) {
                paramLong2 = Long.valueOf(paramLong2.zzd());
              } else {
                paramLong2 = null;
              }
              ((Map)localObject5).put(Integer.valueOf(k), paramLong2);
            }
          }
        }
        paramLong2 = new ArrayMap();
        if ((localObject6 != null) && (((zzcd.zzi)localObject6).zzh() != 0))
        {
          localObject7 = ((zzcd.zzi)localObject6).zzg().iterator();
          while (((Iterator)localObject7).hasNext())
          {
            localObject8 = (zzcd.zzj)((Iterator)localObject7).next();
            if ((((zzcd.zzj)localObject8).zza()) && (((zzcd.zzj)localObject8).zzd() > 0)) {
              paramLong2.put(Integer.valueOf(((zzcd.zzj)localObject8).zzb()), Long.valueOf(((zzcd.zzj)localObject8).zza(((zzcd.zzj)localObject8).zzd() - 1)));
            }
          }
        }
        if (localObject6 != null)
        {
          k = 0;
          while (k < ((zzcd.zzi)localObject6).zzb() << 6)
          {
            if (zzks.zza(((zzcd.zzi)localObject6).zza(), k))
            {
              zzq().zzw().zza("Filter already evaluated. audience ID, filter ID", Integer.valueOf(n), Integer.valueOf(k));
              ((BitSet)localObject4).set(k);
              if (zzks.zza(((zzcd.zzi)localObject6).zzc(), k))
              {
                ((BitSet)localObject3).set(k);
                m = 1;
                break label1121;
              }
            }
            m = 0;
            if (m == 0) {
              ((Map)localObject5).remove(Integer.valueOf(k));
            }
            k += 1;
          }
        }
        localObject6 = (zzcd.zzi)((Map)localObject1).get(Integer.valueOf(n));
        if ((j != 0) && (i != 0))
        {
          localObject7 = (List)paramLong1.get(Integer.valueOf(n));
          if ((localObject7 != null) && (this.zzf != null) && (this.zze != null))
          {
            localObject7 = ((List)localObject7).iterator();
            while (((Iterator)localObject7).hasNext())
            {
              localObject8 = (zzbv.zzb)((Iterator)localObject7).next();
              k = ((zzbv.zzb)localObject8).zzb();
              l = this.zzf.longValue() / 1000L;
              if (((zzbv.zzb)localObject8).zzi()) {
                l = this.zze.longValue() / 1000L;
              }
              if (((Map)localObject5).containsKey(Integer.valueOf(k))) {
                ((Map)localObject5).put(Integer.valueOf(k), Long.valueOf(l));
              }
              if (paramLong2.containsKey(Integer.valueOf(k))) {
                paramLong2.put(Integer.valueOf(k), Long.valueOf(l));
              }
            }
          }
        }
        paramLong2 = new zzq(this, this.zzb, (zzcd.zzi)localObject6, (BitSet)localObject3, (BitSet)localObject4, (Map)localObject5, paramLong2, null);
        this.zzd.put(Integer.valueOf(n), paramLong2);
      }
    }
    boolean bool;
    if (!paramList.isEmpty())
    {
      paramLong1 = new zzt(this, null);
      localObject1 = new ArrayMap();
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramString = (zzcd.zzc)((Iterator)localObject2).next();
        localObject3 = paramLong1.zza(this.zzb, paramString);
        if (localObject3 != null)
        {
          paramList = zzi();
          paramLong2 = this.zzb;
          localObject4 = ((zzcd.zzc)localObject3).zzc();
          localObject5 = paramList.zza(paramLong2, paramString.zzc());
          if (localObject5 == null)
          {
            paramList.zzq().zzh().zza("Event aggregate wasn't created during raw event logging. appId, event", zzer.zza(paramLong2), paramList.zzn().zza((String)localObject4));
            paramList = new zzan(paramLong2, paramString.zzc(), 1L, 1L, 1L, paramString.zze(), 0L, null, null, null, null);
          }
          else
          {
            paramList = new zzan(((zzan)localObject5).zza, ((zzan)localObject5).zzb, ((zzan)localObject5).zzc + 1L, ((zzan)localObject5).zzd + 1L, ((zzan)localObject5).zze + 1L, ((zzan)localObject5).zzf, ((zzan)localObject5).zzg, ((zzan)localObject5).zzh, ((zzan)localObject5).zzi, ((zzan)localObject5).zzj, ((zzan)localObject5).zzk);
          }
          zzi().zza(paramList);
          l = paramList.zzc;
          localObject4 = ((zzcd.zzc)localObject3).zzc();
          paramString = (Map)((Map)localObject1).get(localObject4);
          paramLong2 = paramString;
          if (paramString == null)
          {
            paramLong2 = zzi().zzf(this.zzb, (String)localObject4);
            if (zznb.zzb())
            {
              paramString = paramLong2;
              if (zzs().zzd(this.zzb, zzat.zzce)) {}
            }
            else
            {
              paramString = paramLong2;
              if (paramLong2 == null) {
                paramString = new ArrayMap();
              }
            }
            ((Map)localObject1).put(localObject4, paramString);
            paramLong2 = paramString;
          }
          localObject4 = paramLong2.keySet().iterator();
          paramString = paramLong1;
          for (;;)
          {
            paramLong1 = paramString;
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            i = ((Integer)((Iterator)localObject4).next()).intValue();
            if (this.zzc.contains(Integer.valueOf(i)))
            {
              zzq().zzw().zza("Skipping failed audience ID", Integer.valueOf(i));
            }
            else
            {
              paramLong1 = ((List)paramLong2.get(Integer.valueOf(i))).iterator();
              bool = true;
              while (paramLong1.hasNext())
              {
                localObject5 = (zzbv.zzb)paramLong1.next();
                localObject6 = new zzs(this, this.zzb, i, (zzbv.zzb)localObject5);
                localObject7 = this.zze;
                localObject8 = this.zzf;
                bool = zza(i, ((zzbv.zzb)localObject5).zzb());
                j = i;
                bool = ((zzs)localObject6).zza((Long)localObject7, (Long)localObject8, (zzcd.zzc)localObject3, l, paramList, bool);
                if (bool)
                {
                  zza(j).zza((zzv)localObject6);
                  i = j;
                }
                else
                {
                  this.zzc.add(Integer.valueOf(j));
                }
              }
              if (!bool) {
                this.zzc.add(Integer.valueOf(i));
              }
            }
          }
        }
      }
    }
    if (!paramList1.isEmpty())
    {
      paramLong1 = new ArrayMap();
      paramList1 = paramList1.iterator();
      label2533:
      while (paramList1.hasNext())
      {
        paramLong2 = (zzcd.zzk)paramList1.next();
        localObject1 = paramLong2.zzc();
        paramList = (Map)paramLong1.get(localObject1);
        paramString = paramList;
        if (paramList == null)
        {
          paramList = zzi().zzg(this.zzb, (String)localObject1);
          if (zznb.zzb())
          {
            paramString = paramList;
            if (zzs().zzd(this.zzb, zzat.zzce)) {}
          }
          else
          {
            paramString = paramList;
            if (paramList == null) {
              paramString = new ArrayMap();
            }
          }
          paramLong1.put(localObject1, paramString);
        }
        localObject1 = paramString.keySet().iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label2533;
          }
          i = ((Integer)((Iterator)localObject1).next()).intValue();
          if (this.zzc.contains(Integer.valueOf(i)))
          {
            zzq().zzw().zza("Skipping failed audience ID", Integer.valueOf(i));
            break;
          }
          localObject3 = ((List)paramString.get(Integer.valueOf(i))).iterator();
          bool = true;
          while (((Iterator)localObject3).hasNext())
          {
            localObject2 = (zzbv.zze)((Iterator)localObject3).next();
            if (zzq().zza(2))
            {
              localObject4 = zzq().zzw();
              if (((zzbv.zze)localObject2).zza()) {
                paramList = Integer.valueOf(((zzbv.zze)localObject2).zzb());
              } else {
                paramList = null;
              }
              ((zzet)localObject4).zza("Evaluating filter. audience, filter, property", Integer.valueOf(i), paramList, zzn().zzc(((zzbv.zze)localObject2).zzc()));
              zzq().zzw().zza("Filter definition", f_().zza((zzbv.zze)localObject2));
            }
            if ((((zzbv.zze)localObject2).zza()) && (((zzbv.zze)localObject2).zzb() <= 256))
            {
              paramList = new zzu(this, this.zzb, i, (zzbv.zze)localObject2);
              bool = paramList.zza(this.zze, this.zzf, paramLong2, zza(i, ((zzbv.zze)localObject2).zzb()));
              if (bool) {
                zza(i).zza(paramList);
              } else {
                this.zzc.add(Integer.valueOf(i));
              }
            }
            else
            {
              localObject3 = zzq().zzh();
              localObject4 = zzer.zza(this.zzb);
              if (((zzbv.zze)localObject2).zza()) {
                paramList = Integer.valueOf(((zzbv.zze)localObject2).zzb());
              } else {
                paramList = null;
              }
              ((zzet)localObject3).zza("Invalid property filter ID. appId, id", localObject4, String.valueOf(paramList));
              bool = false;
            }
          }
          if (!bool) {
            this.zzc.add(Integer.valueOf(i));
          }
        }
      }
    }
    paramList = new ArrayList();
    paramString = this.zzd.keySet();
    paramString.removeAll(this.zzc);
    paramList1 = paramString.iterator();
    while (paramList1.hasNext())
    {
      i = ((Integer)paramList1.next()).intValue();
      paramString = ((zzq)this.zzd.get(Integer.valueOf(i))).zza(i);
      paramList.add(paramString);
      paramLong1 = zzi();
      paramLong2 = this.zzb;
      paramString = paramString.zzc();
      paramLong1.zzaj();
      paramLong1.zzc();
      Preconditions.checkNotEmpty(paramLong2);
      Preconditions.checkNotNull(paramString);
      localObject1 = paramString.zzbk();
      paramString = new ContentValues();
      paramString.put("app_id", paramLong2);
      paramString.put("audience_id", Integer.valueOf(i));
      paramString.put("current_results", (byte[])localObject1);
      try
      {
        localObject1 = paramLong1.c_();
        try
        {
          if (((SQLiteDatabase)localObject1).insertWithOnConflict("audience_filter_values", null, paramString, 5) != -1L) {
            continue;
          }
          paramLong1.zzq().zze().zza("Failed to insert filter results (got -1). appId", zzer.zza(paramLong2));
        }
        catch (SQLiteException paramString) {}
        paramLong1.zzq().zze().zza("Error storing filter results. appId", zzer.zza(paramLong2), paramString);
      }
      catch (SQLiteException paramString) {}
    }
    return paramList;
  }
  
  protected final boolean zzd()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */