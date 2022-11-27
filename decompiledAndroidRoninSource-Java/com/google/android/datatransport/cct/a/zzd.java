package com.google.android.datatransport.cct.a;

final class zzd
  extends zza
{
  private final Integer zza;
  private final String zzb;
  private final String zzc;
  private final String zzd;
  private final String zze;
  private final String zzf;
  private final String zzg;
  private final String zzh;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof zza))
    {
      Object localObject = this.zza;
      if (localObject == null ? ((zzd)paramObject).zza == null : ((Integer)localObject).equals(((zzd)paramObject).zza))
      {
        localObject = this.zzb;
        if (localObject == null ? ((zzd)paramObject).zzb == null : ((String)localObject).equals(((zzd)paramObject).zzb))
        {
          localObject = this.zzc;
          if (localObject == null ? ((zzd)paramObject).zzc == null : ((String)localObject).equals(((zzd)paramObject).zzc))
          {
            localObject = this.zzd;
            if (localObject == null ? ((zzd)paramObject).zzd == null : ((String)localObject).equals(((zzd)paramObject).zzd))
            {
              localObject = this.zze;
              if (localObject == null ? ((zzd)paramObject).zze == null : ((String)localObject).equals(((zzd)paramObject).zze))
              {
                localObject = this.zzf;
                if (localObject == null ? ((zzd)paramObject).zzf == null : ((String)localObject).equals(((zzd)paramObject).zzf))
                {
                  localObject = this.zzg;
                  if (localObject == null ? ((zzd)paramObject).zzg == null : ((String)localObject).equals(((zzd)paramObject).zzg))
                  {
                    localObject = this.zzh;
                    if (localObject == null)
                    {
                      if (((zzd)paramObject).zzh == null) {
                        return true;
                      }
                    }
                    else if (((String)localObject).equals(((zzd)paramObject).zzh)) {
                      return true;
                    }
                  }
                }
              }
            }
          }
        }
      }
      return false;
    }
    return false;
  }
  
  public int hashCode()
  {
    Object localObject = this.zza;
    int i3 = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Integer)localObject).hashCode();
    }
    localObject = this.zzb;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    localObject = this.zzc;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((String)localObject).hashCode();
    }
    localObject = this.zzd;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((String)localObject).hashCode();
    }
    localObject = this.zze;
    int n;
    if (localObject == null) {
      n = 0;
    } else {
      n = ((String)localObject).hashCode();
    }
    localObject = this.zzf;
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((String)localObject).hashCode();
    }
    localObject = this.zzg;
    int i2;
    if (localObject == null) {
      i2 = 0;
    } else {
      i2 = ((String)localObject).hashCode();
    }
    localObject = this.zzh;
    if (localObject != null) {
      i3 = ((String)localObject).hashCode();
    }
    return (((((((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ n) * 1000003 ^ i1) * 1000003 ^ i2) * 1000003 ^ i3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AndroidClientInfo{sdkVersion=");
    localStringBuilder.append(this.zza);
    localStringBuilder.append(", model=");
    localStringBuilder.append(this.zzb);
    localStringBuilder.append(", hardware=");
    localStringBuilder.append(this.zzc);
    localStringBuilder.append(", device=");
    localStringBuilder.append(this.zzd);
    localStringBuilder.append(", product=");
    localStringBuilder.append(this.zze);
    localStringBuilder.append(", osBuild=");
    localStringBuilder.append(this.zzf);
    localStringBuilder.append(", manufacturer=");
    localStringBuilder.append(this.zzg);
    localStringBuilder.append(", fingerprint=");
    localStringBuilder.append(this.zzh);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public String zzb()
  {
    return this.zzd;
  }
  
  public String zzc()
  {
    return this.zzh;
  }
  
  public String zzd()
  {
    return this.zzc;
  }
  
  public String zze()
  {
    return this.zzg;
  }
  
  public String zzf()
  {
    return this.zzb;
  }
  
  public String zzg()
  {
    return this.zzf;
  }
  
  public String zzh()
  {
    return this.zze;
  }
  
  public Integer zzi()
  {
    return this.zza;
  }
  
  static final class zza
    extends zza.zza
  {
    private Integer zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private String zzh;
    
    public zza.zza zza(Integer paramInteger)
    {
      this.zza = paramInteger;
      return this;
    }
    
    public zza.zza zza(String paramString)
    {
      this.zzd = paramString;
      return this;
    }
    
    public zza zza()
    {
      return new zzd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, null);
    }
    
    public zza.zza zzb(String paramString)
    {
      this.zzh = paramString;
      return this;
    }
    
    public zza.zza zzc(String paramString)
    {
      this.zzc = paramString;
      return this;
    }
    
    public zza.zza zzd(String paramString)
    {
      this.zzg = paramString;
      return this;
    }
    
    public zza.zza zze(String paramString)
    {
      this.zzb = paramString;
      return this;
    }
    
    public zza.zza zzf(String paramString)
    {
      this.zzf = paramString;
      return this;
    }
    
    public zza.zza zzg(String paramString)
    {
      this.zze = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\cct\a\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */