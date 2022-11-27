package com.google.android.datatransport.cct.a;

import com.google.firebase.encoders.annotations.Encodable.Field;
import java.util.List;

public abstract class zzr
{
  public static zza zza()
  {
    return new zzk.zza();
  }
  
  public abstract zzp zzb();
  
  @Encodable.Field(name="logEvent")
  public abstract List<zzq> zzc();
  
  public abstract Integer zzd();
  
  public abstract String zze();
  
  public abstract zzu zzf();
  
  public abstract long zzg();
  
  public abstract long zzh();
  
  public static abstract class zza
  {
    public zza zza(int paramInt)
    {
      return zza(Integer.valueOf(paramInt));
    }
    
    public abstract zza zza(long paramLong);
    
    public abstract zza zza(zzp paramzzp);
    
    public abstract zza zza(zzu paramzzu);
    
    abstract zza zza(Integer paramInteger);
    
    abstract zza zza(String paramString);
    
    public abstract zza zza(List<zzq> paramList);
    
    public abstract zzr zza();
    
    public abstract zza zzb(long paramLong);
    
    public zza zzb(String paramString)
    {
      return zza(paramString);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\cct\a\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */