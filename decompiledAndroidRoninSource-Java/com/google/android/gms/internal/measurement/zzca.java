package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzca
{
  public static final class zza
    extends zzhz<zza, zza>
    implements zzjj
  {
    private static final zza zzh;
    private static volatile zzju<zza> zzi;
    private int zzc;
    private String zzd = "";
    private boolean zze;
    private boolean zzf;
    private int zzg;
    
    static
    {
      zza localzza = new zza();
      zzh = localzza;
      zzhz.zza(zza.class, localzza);
    }
    
    private final void zza(String paramString)
    {
      paramString.getClass();
      this.zzc |= 0x1;
      this.zzd = paramString;
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzcc.zza[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject1 = zzi;
        if (paramObject1 == null) {
          try
          {
            paramObject2 = zzi;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new zzhz.zzc(zzh);
              zzi = (zzju)paramObject1;
            }
            return paramObject1;
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzh;
      case 3: 
        return zza(zzh, "\001\004\000\001\001\004\004\000\000\000\001ဈ\000\002ဇ\001\003ဇ\002\004င\003", new Object[] { "zzc", "zzd", "zze", "zzf", "zzg" });
      case 2: 
        return new zza(null);
      }
      return new zza();
    }
    
    public final String zza()
    {
      return this.zzd;
    }
    
    public final boolean zzb()
    {
      return this.zze;
    }
    
    public final boolean zzc()
    {
      return this.zzf;
    }
    
    public final boolean zzd()
    {
      return (this.zzc & 0x8) != 0;
    }
    
    public final int zze()
    {
      return this.zzg;
    }
    
    public static final class zza
      extends zzhz.zza<zzca.zza, zza>
      implements zzjj
    {
      private zza()
      {
        super();
      }
      
      public final zza zza(String paramString)
      {
        if (this.zzb)
        {
          zzu();
          this.zzb = false;
        }
        zzca.zza.zza((zzca.zza)this.zza, paramString);
        return this;
      }
      
      public final String zza()
      {
        return ((zzca.zza)this.zza).zza();
      }
      
      public final boolean zzb()
      {
        return ((zzca.zza)this.zza).zzb();
      }
      
      public final boolean zzc()
      {
        return ((zzca.zza)this.zza).zzc();
      }
      
      public final boolean zzd()
      {
        return ((zzca.zza)this.zza).zzd();
      }
      
      public final int zze()
      {
        return ((zzca.zza)this.zza).zze();
      }
    }
  }
  
  public static final class zzb
    extends zzhz<zzb, zza>
    implements zzjj
  {
    private static final zzb zzm;
    private static volatile zzju<zzb> zzn;
    private int zzc;
    private long zzd;
    private String zze = "";
    private int zzf;
    private zzii<zzca.zzc> zzg = zzbr();
    private zzii<zzca.zza> zzh = zzbr();
    private zzii<zzbv.zza> zzi = zzbr();
    private String zzj = "";
    private boolean zzk;
    private zzii<zzck.zza> zzl = zzbr();
    
    static
    {
      zzb localzzb = new zzb();
      zzm = localzzb;
      zzhz.zza(zzb.class, localzzb);
    }
    
    private final void zza(int paramInt, zzca.zza paramzza)
    {
      paramzza.getClass();
      zzii localzzii = this.zzh;
      if (!localzzii.zza()) {
        this.zzh = zzhz.zza(localzzii);
      }
      this.zzh.set(paramInt, paramzza);
    }
    
    public static zza zzi()
    {
      return (zza)zzm.zzbm();
    }
    
    public static zzb zzj()
    {
      return zzm;
    }
    
    private final void zzl()
    {
      this.zzi = zzbr();
    }
    
    public final zzca.zza zza(int paramInt)
    {
      return (zzca.zza)this.zzh.get(paramInt);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzcc.zza[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject1 = zzn;
        if (paramObject1 == null) {
          try
          {
            paramObject2 = zzn;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new zzhz.zzc(zzm);
              zzn = (zzju)paramObject1;
            }
            return paramObject1;
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzm;
      case 3: 
        return zza(zzm, "\001\t\000\001\001\t\t\000\004\000\001ဂ\000\002ဈ\001\003င\002\004\033\005\033\006\033\007ဈ\003\bဇ\004\t\033", new Object[] { "zzc", "zzd", "zze", "zzf", "zzg", zzca.zzc.class, "zzh", zzca.zza.class, "zzi", zzbv.zza.class, "zzj", "zzk", "zzl", zzck.zza.class });
      case 2: 
        return new zza(null);
      }
      return new zzb();
    }
    
    public final boolean zza()
    {
      return (this.zzc & 0x1) != 0;
    }
    
    public final long zzb()
    {
      return this.zzd;
    }
    
    public final boolean zzc()
    {
      return (this.zzc & 0x2) != 0;
    }
    
    public final String zzd()
    {
      return this.zze;
    }
    
    public final List<zzca.zzc> zze()
    {
      return this.zzg;
    }
    
    public final int zzf()
    {
      return this.zzh.size();
    }
    
    public final List<zzbv.zza> zzg()
    {
      return this.zzi;
    }
    
    public final boolean zzh()
    {
      return this.zzk;
    }
    
    public static final class zza
      extends zzhz.zza<zzca.zzb, zza>
      implements zzjj
    {
      private zza()
      {
        super();
      }
      
      public final int zza()
      {
        return ((zzca.zzb)this.zza).zzf();
      }
      
      public final zzca.zza zza(int paramInt)
      {
        return ((zzca.zzb)this.zza).zza(paramInt);
      }
      
      public final zza zza(int paramInt, zzca.zza.zza paramzza)
      {
        if (this.zzb)
        {
          zzu();
          this.zzb = false;
        }
        zzca.zzb.zza((zzca.zzb)this.zza, paramInt, (zzca.zza)paramzza.zzz());
        return this;
      }
      
      public final List<zzbv.zza> zzb()
      {
        return Collections.unmodifiableList(((zzca.zzb)this.zza).zzg());
      }
      
      public final zza zzc()
      {
        if (this.zzb)
        {
          zzu();
          this.zzb = false;
        }
        zzca.zzb.zza((zzca.zzb)this.zza);
        return this;
      }
    }
  }
  
  public static final class zzc
    extends zzhz<zzc, zza>
    implements zzjj
  {
    private static final zzc zzf;
    private static volatile zzju<zzc> zzg;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    
    static
    {
      zzc localzzc = new zzc();
      zzf = localzzc;
      zzhz.zza(zzc.class, localzzc);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzcc.zza[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject1 = zzg;
        if (paramObject1 == null) {
          try
          {
            paramObject2 = zzg;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new zzhz.zzc(zzf);
              zzg = (zzju)paramObject1;
            }
            return paramObject1;
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzf;
      case 3: 
        return zza(zzf, "\001\002\000\001\001\002\002\000\000\000\001ဈ\000\002ဈ\001", new Object[] { "zzc", "zzd", "zze" });
      case 2: 
        return new zza(null);
      }
      return new zzc();
    }
    
    public final String zza()
    {
      return this.zzd;
    }
    
    public final String zzb()
    {
      return this.zze;
    }
    
    public static final class zza
      extends zzhz.zza<zzca.zzc, zza>
      implements zzjj
    {
      private zza()
      {
        super();
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */