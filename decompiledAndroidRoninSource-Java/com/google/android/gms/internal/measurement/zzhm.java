package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzhm
{
  private static volatile boolean zza = false;
  private static boolean zzb = true;
  private static volatile zzhm zzc;
  private static volatile zzhm zzd;
  private static final zzhm zze = new zzhm(true);
  private final Map<zza, zzhz.zzd<?, ?>> zzf;
  
  zzhm()
  {
    this.zzf = new HashMap();
  }
  
  private zzhm(boolean paramBoolean)
  {
    this.zzf = Collections.emptyMap();
  }
  
  public static zzhm zza()
  {
    Object localObject = zzc;
    if (localObject == null) {
      try
      {
        zzhm localzzhm2 = zzc;
        localObject = localzzhm2;
        if (localzzhm2 == null)
        {
          localObject = zze;
          zzc = (zzhm)localObject;
        }
        return (zzhm)localObject;
      }
      finally {}
    }
    return localzzhm1;
  }
  
  public static zzhm zzb()
  {
    zzhm localzzhm = zzd;
    if (localzzhm != null) {
      return localzzhm;
    }
    try
    {
      localzzhm = zzd;
      if (localzzhm != null) {
        return localzzhm;
      }
      localzzhm = zzhy.zza(zzhm.class);
      zzd = localzzhm;
      return localzzhm;
    }
    finally {}
  }
  
  public final <ContainingType extends zzjh> zzhz.zzd<ContainingType, ?> zza(ContainingType paramContainingType, int paramInt)
  {
    return (zzhz.zzd)this.zzf.get(new zza(paramContainingType, paramInt));
  }
  
  private static final class zza
  {
    private final Object zza;
    private final int zzb;
    
    zza(Object paramObject, int paramInt)
    {
      this.zza = paramObject;
      this.zzb = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza)) {
        return false;
      }
      paramObject = (zza)paramObject;
      return (this.zza == ((zza)paramObject).zza) && (this.zzb == ((zza)paramObject).zzb);
    }
    
    public final int hashCode()
    {
      return System.identityHashCode(this.zza) * 65535 + this.zzb;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */