package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzcd.zza;
import com.google.android.gms.internal.measurement.zzcd.zza.zza;
import com.google.android.gms.internal.measurement.zzcd.zzb;
import com.google.android.gms.internal.measurement.zzcd.zzb.zza;
import com.google.android.gms.internal.measurement.zzcd.zzi;
import com.google.android.gms.internal.measurement.zzcd.zzi.zza;
import com.google.android.gms.internal.measurement.zzcd.zzj;
import com.google.android.gms.internal.measurement.zzcd.zzj.zza;
import com.google.android.gms.internal.measurement.zzhz.zza;
import com.google.android.gms.internal.measurement.zzmv;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzq
{
  private String zza;
  private boolean zzb;
  private zzcd.zzi zzc;
  private BitSet zzd;
  private BitSet zze;
  private Map<Integer, Long> zzf;
  private Map<Integer, List<Long>> zzg;
  
  private zzq(zzo paramzzo, String paramString)
  {
    this.zza = paramString;
    this.zzb = true;
    this.zzd = new BitSet();
    this.zze = new BitSet();
    this.zzf = new ArrayMap();
    this.zzg = new ArrayMap();
  }
  
  private zzq(String paramString, zzcd.zzi paramzzi, BitSet paramBitSet1, BitSet paramBitSet2, Map<Integer, Long> paramMap1, Map<Integer, Long> paramMap2)
  {
    this.zza = paramzzi;
    this.zzd = paramBitSet2;
    this.zze = paramMap1;
    this.zzf = paramMap2;
    this.zzg = new ArrayMap();
    Object localObject;
    if (localObject != null)
    {
      paramString = ((Map)localObject).keySet().iterator();
      while (paramString.hasNext())
      {
        paramzzi = (Integer)paramString.next();
        paramBitSet2 = new ArrayList();
        paramBitSet2.add((Long)((Map)localObject).get(paramzzi));
        this.zzg.put(paramzzi, paramBitSet2);
      }
    }
    this.zzb = false;
    this.zzc = paramBitSet1;
  }
  
  final zzcd.zza zza(int paramInt)
  {
    zzcd.zza.zza localzza = zzcd.zza.zzh();
    localzza.zza(paramInt);
    localzza.zza(this.zzb);
    Object localObject1 = this.zzc;
    if (localObject1 != null) {
      localzza.zza((zzcd.zzi)localObject1);
    }
    zzcd.zzi.zza localzza1 = zzcd.zzi.zzi().zzb(zzks.zza(this.zzd)).zza(zzks.zza(this.zze));
    ArrayList localArrayList;
    Iterator localIterator;
    if (this.zzf == null)
    {
      localObject1 = null;
    }
    else
    {
      localArrayList = new ArrayList(this.zzf.size());
      localIterator = this.zzf.keySet().iterator();
      for (;;)
      {
        localObject1 = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramInt = ((Integer)localIterator.next()).intValue();
        localArrayList.add((zzcd.zzb)zzcd.zzb.zze().zza(paramInt).zza(((Long)this.zzf.get(Integer.valueOf(paramInt))).longValue()).zzz());
      }
    }
    localzza1.zzc((Iterable)localObject1);
    if (this.zzg == null)
    {
      localObject1 = Collections.emptyList();
    }
    else
    {
      localArrayList = new ArrayList(this.zzg.size());
      localIterator = this.zzg.keySet().iterator();
      for (;;)
      {
        localObject1 = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = (Integer)localIterator.next();
        localObject1 = zzcd.zzj.zze().zza(((Integer)localObject2).intValue());
        localObject2 = (List)this.zzg.get(localObject2);
        if (localObject2 != null)
        {
          Collections.sort((List)localObject2);
          ((zzcd.zzj.zza)localObject1).zza((Iterable)localObject2);
        }
        localArrayList.add((zzcd.zzj)((zzhz.zza)localObject1).zzz());
      }
    }
    localzza1.zzd((Iterable)localObject1);
    localzza.zza(localzza1);
    return (zzcd.zza)localzza.zzz();
  }
  
  final void zza(zzv paramzzv)
  {
    int i = paramzzv.zza();
    if (paramzzv.zzc != null) {
      this.zze.set(i, paramzzv.zzc.booleanValue());
    }
    if (paramzzv.zzd != null) {
      this.zzd.set(i, paramzzv.zzd.booleanValue());
    }
    Object localObject;
    long l;
    if (paramzzv.zze != null)
    {
      localObject = (Long)this.zzf.get(Integer.valueOf(i));
      l = paramzzv.zze.longValue() / 1000L;
      if ((localObject == null) || (l > ((Long)localObject).longValue())) {
        this.zzf.put(Integer.valueOf(i), Long.valueOf(l));
      }
    }
    if (paramzzv.zzf != null)
    {
      List localList = (List)this.zzg.get(Integer.valueOf(i));
      localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzg.put(Integer.valueOf(i), localObject);
      }
      if (paramzzv.zzb()) {
        ((List)localObject).clear();
      }
      if ((zzmv.zzb()) && (this.zzh.zzs().zzd(this.zza, zzat.zzbb)) && (paramzzv.zzc())) {
        ((List)localObject).clear();
      }
      if ((zzmv.zzb()) && (this.zzh.zzs().zzd(this.zza, zzat.zzbb)))
      {
        l = paramzzv.zzf.longValue() / 1000L;
        if (!((List)localObject).contains(Long.valueOf(l))) {
          ((List)localObject).add(Long.valueOf(l));
        }
        return;
      }
      ((List)localObject).add(Long.valueOf(paramzzv.zzf.longValue() / 1000L));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */