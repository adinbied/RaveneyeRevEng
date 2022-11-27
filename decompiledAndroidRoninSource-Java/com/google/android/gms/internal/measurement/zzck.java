package com.google.android.gms.internal.measurement;

public final class zzck
{
  public static final class zza
    extends zzhz<zza, zza>
    implements zzjj
  {
    private static final zza zzd;
    private static volatile zzju<zza> zze;
    private zzii<zzck.zzb> zzc = zzbr();
    
    static
    {
      zza localzza = new zza();
      zzd = localzza;
      zzhz.zza(zza.class, localzza);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzcl.zza[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject1 = zze;
        if (paramObject1 == null) {
          try
          {
            paramObject2 = zze;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new zzhz.zzc(zzd);
              zze = (zzju)paramObject1;
            }
            return paramObject1;
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzd;
      case 3: 
        return zza(zzd, "\001\001\000\000\001\001\001\000\001\000\001\033", new Object[] { "zzc", zzck.zzb.class });
      case 2: 
        return new zza(null);
      }
      return new zza();
    }
    
    public static final class zza
      extends zzhz.zza<zzck.zza, zza>
      implements zzjj
    {
      private zza()
      {
        super();
      }
    }
  }
  
  public static final class zzb
    extends zzhz<zzb, zzb>
    implements zzjj
  {
    private static final zzb zzk;
    private static volatile zzju<zzb> zzl;
    private int zzc;
    private int zzd;
    private String zze = "";
    private boolean zzf;
    private long zzg;
    private double zzh;
    private zzii<zzb> zzi = zzbr();
    private String zzj = "";
    
    static
    {
      zzb localzzb = new zzb();
      zzk = localzzb;
      zzhz.zza(zzb.class, localzzb);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzcl.zza[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject1 = zzl;
        if (paramObject1 == null) {
          try
          {
            paramObject2 = zzl;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new zzhz.zzc(zzk);
              zzl = (zzju)paramObject1;
            }
            return paramObject1;
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzk;
      case 3: 
        paramObject1 = zza.zzb();
        return zza(zzk, "\001\007\000\001\001\007\007\000\001\000\001ဌ\000\002ဈ\001\003ဇ\002\004ဂ\003\005က\004\006\033\007ဈ\005", new Object[] { "zzc", "zzd", paramObject1, "zze", "zzf", "zzg", "zzh", "zzi", zzb.class, "zzj" });
      case 2: 
        return new zzb(null);
      }
      return new zzb();
    }
    
    public static enum zza
      implements zzib
    {
      private static final zzie<zza> zzi = new zzcn();
      private final int zzj;
      
      static
      {
        zza localzza = new zza("STATEMENT", 7, 7);
        zzh = localzza;
        zzk = new zza[] { zza, zzb, zzc, zzd, zze, zzf, zzg, localzza };
      }
      
      private zza(int paramInt)
      {
        this.zzj = paramInt;
      }
      
      public static zza zza(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 7: 
          return zzh;
        case 6: 
          return zzg;
        case 5: 
          return zzf;
        case 4: 
          return zze;
        case 3: 
          return zzd;
        case 2: 
          return zzc;
        case 1: 
          return zzb;
        }
        return zza;
      }
      
      public static zzid zzb()
      {
        return zzcm.zza;
      }
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder("<");
        localStringBuilder.append(getClass().getName());
        localStringBuilder.append('@');
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        localStringBuilder.append(" number=");
        localStringBuilder.append(this.zzj);
        localStringBuilder.append(" name=");
        localStringBuilder.append(name());
        localStringBuilder.append('>');
        return localStringBuilder.toString();
      }
      
      public final int zza()
      {
        return this.zzj;
      }
    }
    
    public static final class zzb
      extends zzhz.zza<zzck.zzb, zzb>
      implements zzjj
    {
      private zzb()
      {
        super();
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */