package com.google.android.datatransport.cct.a;

import com.google.firebase.encoders.annotations.Encodable.Field;
import java.util.List;

final class zzk
  extends zzr
{
  private final long zza;
  private final long zzb;
  private final zzp zzc;
  private final Integer zzd;
  private final String zze;
  private final List<zzq> zzf;
  private final zzu zzg;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof zzr))
    {
      paramObject = (zzr)paramObject;
      if ((this.zza == ((zzr)paramObject).zzg()) && (this.zzb == ((zzr)paramObject).zzh()))
      {
        Object localObject = this.zzc;
        if (localObject == null ? ((zzk)paramObject).zzc == null : localObject.equals(((zzk)paramObject).zzc))
        {
          localObject = this.zzd;
          if (localObject == null ? ((zzk)paramObject).zzd == null : ((Integer)localObject).equals(((zzk)paramObject).zzd))
          {
            localObject = this.zze;
            if (localObject == null ? ((zzk)paramObject).zze == null : ((String)localObject).equals(((zzk)paramObject).zze))
            {
              localObject = this.zzf;
              if (localObject == null ? ((zzk)paramObject).zzf == null : ((List)localObject).equals(((zzk)paramObject).zzf))
              {
                localObject = this.zzg;
                if (localObject == null)
                {
                  if (((zzk)paramObject).zzg == null) {
                    return true;
                  }
                }
                else if (((Enum)localObject).equals(((zzk)paramObject).zzg)) {
                  return true;
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
    long l = this.zza;
    int i1 = (int)(l ^ l >>> 32);
    l = this.zzb;
    int i2 = (int)(l >>> 32 ^ l);
    Object localObject = this.zzc;
    int n = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = this.zzd;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((Integer)localObject).hashCode();
    }
    localObject = this.zze;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((String)localObject).hashCode();
    }
    localObject = this.zzf;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((List)localObject).hashCode();
    }
    localObject = this.zzg;
    if (localObject != null) {
      n = ((Enum)localObject).hashCode();
    }
    return ((((((i1 ^ 0xF4243) * 1000003 ^ i2) * 1000003 ^ i) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ n;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LogRequest{requestTimeMs=");
    localStringBuilder.append(this.zza);
    localStringBuilder.append(", requestUptimeMs=");
    localStringBuilder.append(this.zzb);
    localStringBuilder.append(", clientInfo=");
    localStringBuilder.append(this.zzc);
    localStringBuilder.append(", logSource=");
    localStringBuilder.append(this.zzd);
    localStringBuilder.append(", logSourceName=");
    localStringBuilder.append(this.zze);
    localStringBuilder.append(", logEvents=");
    localStringBuilder.append(this.zzf);
    localStringBuilder.append(", qosTier=");
    localStringBuilder.append(this.zzg);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public zzp zzb()
  {
    return this.zzc;
  }
  
  @Encodable.Field(name="logEvent")
  public List<zzq> zzc()
  {
    return this.zzf;
  }
  
  public Integer zzd()
  {
    return this.zzd;
  }
  
  public String zze()
  {
    return this.zze;
  }
  
  public zzu zzf()
  {
    return this.zzg;
  }
  
  public long zzg()
  {
    return this.zza;
  }
  
  public long zzh()
  {
    return this.zzb;
  }
  
  static final class zza
    extends zzr.zza
  {
    private Long zza;
    private Long zzb;
    private zzp zzc;
    private Integer zzd;
    private String zze;
    private List<zzq> zzf;
    private zzu zzg;
    
    public zzr.zza zza(long paramLong)
    {
      this.zza = Long.valueOf(paramLong);
      return this;
    }
    
    public zzr.zza zza(zzp paramzzp)
    {
      this.zzc = paramzzp;
      return this;
    }
    
    public zzr.zza zza(zzu paramzzu)
    {
      this.zzg = paramzzu;
      return this;
    }
    
    zzr.zza zza(Integer paramInteger)
    {
      this.zzd = paramInteger;
      return this;
    }
    
    zzr.zza zza(String paramString)
    {
      this.zze = paramString;
      return this;
    }
    
    public zzr.zza zza(List<zzq> paramList)
    {
      this.zzf = paramList;
      return this;
    }
    
    public zzr zza()
    {
      Object localObject2 = this.zza;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" requestTimeMs");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.zzb == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" requestUptimeMs");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new zzk(this.zza.longValue(), this.zzb.longValue(), this.zzc, this.zzd, this.zze, this.zzf, this.zzg, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public zzr.zza zzb(long paramLong)
    {
      this.zzb = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\cct\a\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */