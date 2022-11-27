package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzbv
{
  public static final class zza
    extends zzhz<zza, zza>
    implements zzjj
  {
    private static final zza zzi;
    private static volatile zzju<zza> zzj;
    private int zzc;
    private int zzd;
    private zzii<zzbv.zze> zze = zzbr();
    private zzii<zzbv.zzb> zzf = zzbr();
    private boolean zzg;
    private boolean zzh;
    
    static
    {
      zza localzza = new zza();
      zzi = localzza;
      zzhz.zza(zza.class, localzza);
    }
    
    private final void zza(int paramInt, zzbv.zzb paramzzb)
    {
      paramzzb.getClass();
      zzii localzzii = this.zzf;
      if (!localzzii.zza()) {
        this.zzf = zzhz.zza(localzzii);
      }
      this.zzf.set(paramInt, paramzzb);
    }
    
    private final void zza(int paramInt, zzbv.zze paramzze)
    {
      paramzze.getClass();
      zzii localzzii = this.zze;
      if (!localzzii.zza()) {
        this.zze = zzhz.zza(localzzii);
      }
      this.zze.set(paramInt, paramzze);
    }
    
    public final zzbv.zze zza(int paramInt)
    {
      return (zzbv.zze)this.zze.get(paramInt);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzbw.zza[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject1 = zzj;
        if (paramObject1 == null) {
          try
          {
            paramObject2 = zzj;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new zzhz.zzc(zzi);
              zzj = (zzju)paramObject1;
            }
            return paramObject1;
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzi;
      case 3: 
        return zza(zzi, "\001\005\000\001\001\005\005\000\002\000\001င\000\002\033\003\033\004ဇ\001\005ဇ\002", new Object[] { "zzc", "zzd", "zze", zzbv.zze.class, "zzf", zzbv.zzb.class, "zzg", "zzh" });
      case 2: 
        return new zza(null);
      }
      return new zza();
    }
    
    public final boolean zza()
    {
      return (this.zzc & 0x1) != 0;
    }
    
    public final int zzb()
    {
      return this.zzd;
    }
    
    public final zzbv.zzb zzb(int paramInt)
    {
      return (zzbv.zzb)this.zzf.get(paramInt);
    }
    
    public final List<zzbv.zze> zzc()
    {
      return this.zze;
    }
    
    public final int zzd()
    {
      return this.zze.size();
    }
    
    public final List<zzbv.zzb> zze()
    {
      return this.zzf;
    }
    
    public final int zzf()
    {
      return this.zzf.size();
    }
    
    public static final class zza
      extends zzhz.zza<zzbv.zza, zza>
      implements zzjj
    {
      private zza()
      {
        super();
      }
      
      public final int zza()
      {
        return ((zzbv.zza)this.zza).zzd();
      }
      
      public final zza zza(int paramInt, zzbv.zzb.zza paramzza)
      {
        if (this.zzb)
        {
          zzu();
          this.zzb = false;
        }
        zzbv.zza.zza((zzbv.zza)this.zza, paramInt, (zzbv.zzb)paramzza.zzz());
        return this;
      }
      
      public final zza zza(int paramInt, zzbv.zze.zza paramzza)
      {
        if (this.zzb)
        {
          zzu();
          this.zzb = false;
        }
        zzbv.zza.zza((zzbv.zza)this.zza, paramInt, (zzbv.zze)paramzza.zzz());
        return this;
      }
      
      public final zzbv.zze zza(int paramInt)
      {
        return ((zzbv.zza)this.zza).zza(paramInt);
      }
      
      public final int zzb()
      {
        return ((zzbv.zza)this.zza).zzf();
      }
      
      public final zzbv.zzb zzb(int paramInt)
      {
        return ((zzbv.zza)this.zza).zzb(paramInt);
      }
    }
  }
  
  public static final class zzb
    extends zzhz<zzb, zza>
    implements zzjj
  {
    private static final zzb zzl;
    private static volatile zzju<zzb> zzm;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zzii<zzbv.zzc> zzf = zzbr();
    private boolean zzg;
    private zzbv.zzd zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    
    static
    {
      zzb localzzb = new zzb();
      zzl = localzzb;
      zzhz.zza(zzb.class, localzzb);
    }
    
    private final void zza(int paramInt, zzbv.zzc paramzzc)
    {
      paramzzc.getClass();
      zzii localzzii = this.zzf;
      if (!localzzii.zza()) {
        this.zzf = zzhz.zza(localzzii);
      }
      this.zzf.set(paramInt, paramzzc);
    }
    
    private final void zza(String paramString)
    {
      paramString.getClass();
      this.zzc |= 0x2;
      this.zze = paramString;
    }
    
    public static zza zzl()
    {
      return (zza)zzl.zzbm();
    }
    
    public final zzbv.zzc zza(int paramInt)
    {
      return (zzbv.zzc)this.zzf.get(paramInt);
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzbw.zza[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject1 = zzm;
        if (paramObject1 == null) {
          try
          {
            paramObject2 = zzm;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new zzhz.zzc(zzl);
              zzm = (zzju)paramObject1;
            }
            return paramObject1;
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzl;
      case 3: 
        return zza(zzl, "\001\b\000\001\001\b\b\000\001\000\001င\000\002ဈ\001\003\033\004ဇ\002\005ဉ\003\006ဇ\004\007ဇ\005\bဇ\006", new Object[] { "zzc", "zzd", "zze", "zzf", zzbv.zzc.class, "zzg", "zzh", "zzi", "zzj", "zzk" });
      case 2: 
        return new zza(null);
      }
      return new zzb();
    }
    
    public final boolean zza()
    {
      return (this.zzc & 0x1) != 0;
    }
    
    public final int zzb()
    {
      return this.zzd;
    }
    
    public final String zzc()
    {
      return this.zze;
    }
    
    public final List<zzbv.zzc> zzd()
    {
      return this.zzf;
    }
    
    public final int zze()
    {
      return this.zzf.size();
    }
    
    public final boolean zzf()
    {
      return (this.zzc & 0x8) != 0;
    }
    
    public final zzbv.zzd zzg()
    {
      zzbv.zzd localzzd2 = this.zzh;
      zzbv.zzd localzzd1 = localzzd2;
      if (localzzd2 == null) {
        localzzd1 = zzbv.zzd.zzk();
      }
      return localzzd1;
    }
    
    public final boolean zzh()
    {
      return this.zzi;
    }
    
    public final boolean zzi()
    {
      return this.zzj;
    }
    
    public final boolean zzj()
    {
      return (this.zzc & 0x40) != 0;
    }
    
    public final boolean zzk()
    {
      return this.zzk;
    }
    
    public static final class zza
      extends zzhz.zza<zzbv.zzb, zza>
      implements zzjj
    {
      private zza()
      {
        super();
      }
      
      public final zza zza(int paramInt, zzbv.zzc paramzzc)
      {
        if (this.zzb)
        {
          zzu();
          this.zzb = false;
        }
        zzbv.zzb.zza((zzbv.zzb)this.zza, paramInt, paramzzc);
        return this;
      }
      
      public final zza zza(String paramString)
      {
        if (this.zzb)
        {
          zzu();
          this.zzb = false;
        }
        zzbv.zzb.zza((zzbv.zzb)this.zza, paramString);
        return this;
      }
      
      public final zzbv.zzc zza(int paramInt)
      {
        return ((zzbv.zzb)this.zza).zza(paramInt);
      }
      
      public final String zza()
      {
        return ((zzbv.zzb)this.zza).zzc();
      }
      
      public final int zzb()
      {
        return ((zzbv.zzb)this.zza).zze();
      }
    }
  }
  
  public static final class zzc
    extends zzhz<zzc, zza>
    implements zzjj
  {
    private static final zzc zzh;
    private static volatile zzju<zzc> zzi;
    private int zzc;
    private zzbv.zzf zzd;
    private zzbv.zzd zze;
    private boolean zzf;
    private String zzg = "";
    
    static
    {
      zzc localzzc = new zzc();
      zzh = localzzc;
      zzhz.zza(zzc.class, localzzc);
    }
    
    private final void zza(String paramString)
    {
      paramString.getClass();
      this.zzc |= 0x8;
      this.zzg = paramString;
    }
    
    public static zzc zzi()
    {
      return zzh;
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzbw.zza[(paramInt - 1)])
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
        return zza(zzh, "\001\004\000\001\001\004\004\000\000\000\001ဉ\000\002ဉ\001\003ဇ\002\004ဈ\003", new Object[] { "zzc", "zzd", "zze", "zzf", "zzg" });
      case 2: 
        return new zza(null);
      }
      return new zzc();
    }
    
    public final boolean zza()
    {
      return (this.zzc & 0x1) != 0;
    }
    
    public final zzbv.zzf zzb()
    {
      zzbv.zzf localzzf2 = this.zzd;
      zzbv.zzf localzzf1 = localzzf2;
      if (localzzf2 == null) {
        localzzf1 = zzbv.zzf.zzi();
      }
      return localzzf1;
    }
    
    public final boolean zzc()
    {
      return (this.zzc & 0x2) != 0;
    }
    
    public final zzbv.zzd zzd()
    {
      zzbv.zzd localzzd2 = this.zze;
      zzbv.zzd localzzd1 = localzzd2;
      if (localzzd2 == null) {
        localzzd1 = zzbv.zzd.zzk();
      }
      return localzzd1;
    }
    
    public final boolean zze()
    {
      return (this.zzc & 0x4) != 0;
    }
    
    public final boolean zzf()
    {
      return this.zzf;
    }
    
    public final boolean zzg()
    {
      return (this.zzc & 0x8) != 0;
    }
    
    public final String zzh()
    {
      return this.zzg;
    }
    
    public static final class zza
      extends zzhz.zza<zzbv.zzc, zza>
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
        zzbv.zzc.zza((zzbv.zzc)this.zza, paramString);
        return this;
      }
    }
  }
  
  public static final class zzd
    extends zzhz<zzd, zzb>
    implements zzjj
  {
    private static final zzd zzi;
    private static volatile zzju<zzd> zzj;
    private int zzc;
    private int zzd;
    private boolean zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    
    static
    {
      zzd localzzd = new zzd();
      zzi = localzzd;
      zzhz.zza(zzd.class, localzzd);
    }
    
    public static zzd zzk()
    {
      return zzi;
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzbw.zza[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject1 = zzj;
        if (paramObject1 == null) {
          try
          {
            paramObject2 = zzj;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new zzhz.zzc(zzi);
              zzj = (zzju)paramObject1;
            }
            return paramObject1;
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzi;
      case 3: 
        paramObject1 = zza.zzb();
        return zza(zzi, "\001\005\000\001\001\005\005\000\000\000\001ဌ\000\002ဇ\001\003ဈ\002\004ဈ\003\005ဈ\004", new Object[] { "zzc", "zzd", paramObject1, "zze", "zzf", "zzg", "zzh" });
      case 2: 
        return new zzb(null);
      }
      return new zzd();
    }
    
    public final boolean zza()
    {
      return (this.zzc & 0x1) != 0;
    }
    
    public final zza zzb()
    {
      zza localzza2 = zza.zza(this.zzd);
      zza localzza1 = localzza2;
      if (localzza2 == null) {
        localzza1 = zza.zza;
      }
      return localzza1;
    }
    
    public final boolean zzc()
    {
      return (this.zzc & 0x2) != 0;
    }
    
    public final boolean zzd()
    {
      return this.zze;
    }
    
    public final boolean zze()
    {
      return (this.zzc & 0x4) != 0;
    }
    
    public final String zzf()
    {
      return this.zzf;
    }
    
    public final boolean zzg()
    {
      return (this.zzc & 0x8) != 0;
    }
    
    public final String zzh()
    {
      return this.zzg;
    }
    
    public final boolean zzi()
    {
      return (this.zzc & 0x10) != 0;
    }
    
    public final String zzj()
    {
      return this.zzh;
    }
    
    public static enum zza
      implements zzib
    {
      private static final zzie<zza> zzf = new zzby();
      private final int zzg;
      
      static
      {
        zza localzza = new zza("BETWEEN", 4, 4);
        zze = localzza;
        zzh = new zza[] { zza, zzb, zzc, zzd, localzza };
      }
      
      private zza(int paramInt)
      {
        this.zzg = paramInt;
      }
      
      public static zza zza(int paramInt)
      {
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt != 3)
              {
                if (paramInt != 4) {
                  return null;
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
        return zzbx.zza;
      }
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder("<");
        localStringBuilder.append(getClass().getName());
        localStringBuilder.append('@');
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        localStringBuilder.append(" number=");
        localStringBuilder.append(this.zzg);
        localStringBuilder.append(" name=");
        localStringBuilder.append(name());
        localStringBuilder.append('>');
        return localStringBuilder.toString();
      }
      
      public final int zza()
      {
        return this.zzg;
      }
    }
    
    public static final class zzb
      extends zzhz.zza<zzbv.zzd, zzb>
      implements zzjj
    {
      private zzb()
      {
        super();
      }
    }
  }
  
  public static final class zze
    extends zzhz<zze, zza>
    implements zzjj
  {
    private static final zze zzj;
    private static volatile zzju<zze> zzk;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zzbv.zzc zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    
    static
    {
      zze localzze = new zze();
      zzj = localzze;
      zzhz.zza(zze.class, localzze);
    }
    
    private final void zza(String paramString)
    {
      paramString.getClass();
      this.zzc |= 0x2;
      this.zze = paramString;
    }
    
    public static zza zzi()
    {
      return (zza)zzj.zzbm();
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzbw.zza[(paramInt - 1)])
      {
      default: 
        throw new UnsupportedOperationException();
      case 7: 
        return null;
      case 6: 
        return Byte.valueOf((byte)1);
      case 5: 
        paramObject1 = zzk;
        if (paramObject1 == null) {
          try
          {
            paramObject2 = zzk;
            paramObject1 = paramObject2;
            if (paramObject2 == null)
            {
              paramObject1 = new zzhz.zzc(zzj);
              zzk = (zzju)paramObject1;
            }
            return paramObject1;
          }
          finally {}
        }
        return paramObject1;
      case 4: 
        return zzj;
      case 3: 
        return zza(zzj, "\001\006\000\001\001\006\006\000\000\000\001င\000\002ဈ\001\003ဉ\002\004ဇ\003\005ဇ\004\006ဇ\005", new Object[] { "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi" });
      case 2: 
        return new zza(null);
      }
      return new zze();
    }
    
    public final boolean zza()
    {
      return (this.zzc & 0x1) != 0;
    }
    
    public final int zzb()
    {
      return this.zzd;
    }
    
    public final String zzc()
    {
      return this.zze;
    }
    
    public final zzbv.zzc zzd()
    {
      zzbv.zzc localzzc2 = this.zzf;
      zzbv.zzc localzzc1 = localzzc2;
      if (localzzc2 == null) {
        localzzc1 = zzbv.zzc.zzi();
      }
      return localzzc1;
    }
    
    public final boolean zze()
    {
      return this.zzg;
    }
    
    public final boolean zzf()
    {
      return this.zzh;
    }
    
    public final boolean zzg()
    {
      return (this.zzc & 0x20) != 0;
    }
    
    public final boolean zzh()
    {
      return this.zzi;
    }
    
    public static final class zza
      extends zzhz.zza<zzbv.zze, zza>
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
        zzbv.zze.zza((zzbv.zze)this.zza, paramString);
        return this;
      }
    }
  }
  
  public static final class zzf
    extends zzhz<zzf, zza>
    implements zzjj
  {
    private static final zzf zzh;
    private static volatile zzju<zzf> zzi;
    private int zzc;
    private int zzd;
    private String zze = "";
    private boolean zzf;
    private zzii<String> zzg = zzhz.zzbr();
    
    static
    {
      zzf localzzf = new zzf();
      zzh = localzzf;
      zzhz.zza(zzf.class, localzzf);
    }
    
    public static zzf zzi()
    {
      return zzh;
    }
    
    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      switch (zzbw.zza[(paramInt - 1)])
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
        paramObject1 = zzb.zzb();
        return zza(zzh, "\001\004\000\001\001\004\004\000\001\000\001ဌ\000\002ဈ\001\003ဇ\002\004\032", new Object[] { "zzc", "zzd", paramObject1, "zze", "zzf", "zzg" });
      case 2: 
        return new zza(null);
      }
      return new zzf();
    }
    
    public final boolean zza()
    {
      return (this.zzc & 0x1) != 0;
    }
    
    public final zzb zzb()
    {
      zzb localzzb2 = zzb.zza(this.zzd);
      zzb localzzb1 = localzzb2;
      if (localzzb2 == null) {
        localzzb1 = zzb.zza;
      }
      return localzzb1;
    }
    
    public final boolean zzc()
    {
      return (this.zzc & 0x2) != 0;
    }
    
    public final String zzd()
    {
      return this.zze;
    }
    
    public final boolean zze()
    {
      return (this.zzc & 0x4) != 0;
    }
    
    public final boolean zzf()
    {
      return this.zzf;
    }
    
    public final List<String> zzg()
    {
      return this.zzg;
    }
    
    public final int zzh()
    {
      return this.zzg.size();
    }
    
    public static final class zza
      extends zzhz.zza<zzbv.zzf, zza>
      implements zzjj
    {
      private zza()
      {
        super();
      }
    }
    
    public static enum zzb
      implements zzib
    {
      private static final zzie<zzb> zzh = new zzbz();
      private final int zzi;
      
      static
      {
        zzb localzzb = new zzb("IN_LIST", 6, 6);
        zzg = localzzb;
        zzj = new zzb[] { zza, zzb, zzc, zzd, zze, zzf, localzzb };
      }
      
      private zzb(int paramInt)
      {
        this.zzi = paramInt;
      }
      
      public static zzb zza(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
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
        return zzcb.zza;
      }
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder("<");
        localStringBuilder.append(getClass().getName());
        localStringBuilder.append('@');
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        localStringBuilder.append(" number=");
        localStringBuilder.append(this.zzi);
        localStringBuilder.append(" name=");
        localStringBuilder.append(name());
        localStringBuilder.append('>');
        return localStringBuilder.toString();
      }
      
      public final int zza()
      {
        return this.zzi;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */