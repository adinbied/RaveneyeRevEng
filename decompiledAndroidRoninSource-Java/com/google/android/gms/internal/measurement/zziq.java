package com.google.android.gms.internal.measurement;

public class zziq
{
  private static final zzhm zza = ;
  private zzgr zzb;
  private volatile zzjh zzc;
  private volatile zzgr zzd;
  
  private final zzjh zzb(zzjh paramzzjh)
  {
    if (this.zzc == null) {}
    for (;;)
    {
      try
      {
        if (this.zzc == null) {}
      }
      finally {}
      try
      {
        this.zzc = paramzzjh;
        this.zzd = zzgr.zza;
      }
      catch (zzih localzzih) {}
    }
    this.zzc = paramzzjh;
    this.zzd = zzgr.zza;
    return this.zzc;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zziq)) {
      return false;
    }
    paramObject = (zziq)paramObject;
    zzjh localzzjh1 = this.zzc;
    zzjh localzzjh2 = ((zziq)paramObject).zzc;
    if ((localzzjh1 == null) && (localzzjh2 == null)) {
      return zzc().equals(((zziq)paramObject).zzc());
    }
    if ((localzzjh1 != null) && (localzzjh2 != null)) {
      return localzzjh1.equals(localzzjh2);
    }
    if (localzzjh1 != null) {
      return localzzjh1.equals(((zziq)paramObject).zzb(localzzjh1.zzaa()));
    }
    return zzb(localzzjh2.zzaa()).equals(localzzjh2);
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public final zzjh zza(zzjh paramzzjh)
  {
    zzjh localzzjh = this.zzc;
    this.zzb = null;
    this.zzd = null;
    this.zzc = paramzzjh;
    return localzzjh;
  }
  
  public final int zzb()
  {
    if (this.zzd != null) {
      return this.zzd.zza();
    }
    if (this.zzc != null) {
      return this.zzc.zzbo();
    }
    return 0;
  }
  
  public final zzgr zzc()
  {
    if (this.zzd != null) {
      return this.zzd;
    }
    try
    {
      if (this.zzd != null)
      {
        localzzgr = this.zzd;
        return localzzgr;
      }
      if (this.zzc == null) {
        this.zzd = zzgr.zza;
      } else {
        this.zzd = this.zzc.zzbj();
      }
      zzgr localzzgr = this.zzd;
      return localzzgr;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zziq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */