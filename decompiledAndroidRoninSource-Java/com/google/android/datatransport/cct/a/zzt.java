package com.google.android.datatransport.cct.a;

import android.util.SparseArray;

public abstract class zzt
{
  public static zza zza()
  {
    return new zzn.zza();
  }
  
  public abstract zzb zzb();
  
  public abstract zzc zzc();
  
  public static abstract class zza
  {
    public abstract zza zza(zzt.zzb paramzzb);
    
    public abstract zza zza(zzt.zzc paramzzc);
    
    public abstract zzt zza();
  }
  
  public static enum zzb
  {
    private static final SparseArray<zzb> zzv;
    private final int zzw;
    
    static
    {
      SparseArray localSparseArray = new SparseArray();
      zzv = localSparseArray;
      localSparseArray.put(0, zza);
      zzv.put(1, zzb);
      zzv.put(2, zzc);
      zzv.put(3, zzd);
      zzv.put(4, zze);
      zzv.put(5, zzf);
      zzv.put(6, zzg);
      zzv.put(7, zzh);
      zzv.put(8, zzi);
      zzv.put(9, zzj);
      zzv.put(10, zzk);
      zzv.put(11, zzl);
      zzv.put(12, zzm);
      zzv.put(13, zzn);
      zzv.put(14, zzo);
      zzv.put(15, zzp);
      zzv.put(16, zzq);
      zzv.put(17, zzr);
      zzv.put(18, zzs);
      zzv.put(19, zzt);
    }
    
    private zzb(int paramInt)
    {
      this.zzw = paramInt;
    }
    
    public static zzb zza(int paramInt)
    {
      return (zzb)zzv.get(paramInt);
    }
    
    public int zza()
    {
      return this.zzw;
    }
  }
  
  public static enum zzc
  {
    private static final SparseArray<zzc> zzt;
    private final int zzu;
    
    static
    {
      SparseArray localSparseArray = new SparseArray();
      zzt = localSparseArray;
      localSparseArray.put(0, zza);
      zzt.put(1, zzb);
      zzt.put(2, zzc);
      zzt.put(3, zzd);
      zzt.put(4, zze);
      zzt.put(5, zzf);
      zzt.put(6, zzg);
      zzt.put(7, zzh);
      zzt.put(8, zzi);
      zzt.put(9, zzj);
      zzt.put(10, zzk);
      zzt.put(11, zzl);
      zzt.put(12, zzm);
      zzt.put(13, zzn);
      zzt.put(14, zzo);
      zzt.put(15, zzp);
      zzt.put(16, zzq);
      zzt.put(17, zzr);
      zzt.put(-1, zzs);
    }
    
    private zzc(int paramInt)
    {
      this.zzu = paramInt;
    }
    
    public static zzc zza(int paramInt)
    {
      return (zzc)zzt.get(paramInt);
    }
    
    public int zza()
    {
      return this.zzu;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\cct\a\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */