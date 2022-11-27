package com.google.android.gms.internal.measurement;

public enum zzce
  implements zzib
{
  private static final zzie<zzce> zzg = new zzch();
  private final int zzh;
  
  static
  {
    zzce localzzce = new zzce("AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_CONFIGURED", 5, 5);
    zzf = localzzce;
    zzi = new zzce[] { zza, zzb, zzc, zzd, zze, localzzce };
  }
  
  private zzce(int paramInt)
  {
    this.zzh = paramInt;
  }
  
  public static zzce zza(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return null;
              }
              return zzf;
            }
            return zze;
          }
          return zzd;
        }
        return zzc;
      }
      return zzb;
    }
    return zza;
  }
  
  public static zzid zzb()
  {
    return zzcg.zza;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" number=");
    localStringBuilder.append(this.zzh);
    localStringBuilder.append(" name=");
    localStringBuilder.append(name());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
  
  public final int zza()
  {
    return this.zzh;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */