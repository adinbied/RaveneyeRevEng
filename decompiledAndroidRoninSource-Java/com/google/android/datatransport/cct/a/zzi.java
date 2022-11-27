package com.google.android.datatransport.cct.a;

import java.util.Arrays;

final class zzi
  extends zzq
{
  private final long zza;
  private final Integer zzb;
  private final long zzc;
  private final byte[] zzd;
  private final String zze;
  private final long zzf;
  private final zzt zzg;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof zzq))
    {
      zzq localzzq = (zzq)paramObject;
      if (this.zza == localzzq.zzb())
      {
        paramObject = this.zzb;
        if ((paramObject == null ? ((zzi)localzzq).zzb == null : ((Integer)paramObject).equals(((zzi)localzzq).zzb)) && (this.zzc == localzzq.zzc()))
        {
          byte[] arrayOfByte = this.zzd;
          if ((localzzq instanceof zzi)) {
            paramObject = ((zzi)localzzq).zzd;
          } else {
            paramObject = localzzq.zze();
          }
          if (Arrays.equals(arrayOfByte, (byte[])paramObject))
          {
            paramObject = this.zze;
            if ((paramObject == null ? ((zzi)localzzq).zze == null : ((String)paramObject).equals(((zzi)localzzq).zze)) && (this.zzf == localzzq.zzg()))
            {
              paramObject = this.zzg;
              if (paramObject == null)
              {
                if (((zzi)localzzq).zzg == null) {
                  return true;
                }
              }
              else if (paramObject.equals(((zzi)localzzq).zzg)) {
                return true;
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
    int m = (int)(l ^ l >>> 32);
    Object localObject = this.zzb;
    int k = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Integer)localObject).hashCode();
    }
    l = this.zzc;
    int n = (int)(l ^ l >>> 32);
    int i1 = Arrays.hashCode(this.zzd);
    localObject = this.zze;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    l = this.zzf;
    int i2 = (int)(l >>> 32 ^ l);
    localObject = this.zzg;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return ((((((m ^ 0xF4243) * 1000003 ^ i) * 1000003 ^ n) * 1000003 ^ i1) * 1000003 ^ j) * 1000003 ^ i2) * 1000003 ^ k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LogEvent{eventTimeMs=");
    localStringBuilder.append(this.zza);
    localStringBuilder.append(", eventCode=");
    localStringBuilder.append(this.zzb);
    localStringBuilder.append(", eventUptimeMs=");
    localStringBuilder.append(this.zzc);
    localStringBuilder.append(", sourceExtension=");
    localStringBuilder.append(Arrays.toString(this.zzd));
    localStringBuilder.append(", sourceExtensionJsonProto3=");
    localStringBuilder.append(this.zze);
    localStringBuilder.append(", timezoneOffsetSeconds=");
    localStringBuilder.append(this.zzf);
    localStringBuilder.append(", networkConnectionInfo=");
    localStringBuilder.append(this.zzg);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public Integer zza()
  {
    return this.zzb;
  }
  
  public long zzb()
  {
    return this.zza;
  }
  
  public long zzc()
  {
    return this.zzc;
  }
  
  public zzt zzd()
  {
    return this.zzg;
  }
  
  public byte[] zze()
  {
    return this.zzd;
  }
  
  public String zzf()
  {
    return this.zze;
  }
  
  public long zzg()
  {
    return this.zzf;
  }
  
  static final class zza
    extends zzq.zza
  {
    private Long zza;
    private Integer zzb;
    private Long zzc;
    private byte[] zzd;
    private String zze;
    private Long zzf;
    private zzt zzg;
    
    public zzq.zza zza(long paramLong)
    {
      this.zza = Long.valueOf(paramLong);
      return this;
    }
    
    public zzq.zza zza(zzt paramzzt)
    {
      this.zzg = paramzzt;
      return this;
    }
    
    public zzq.zza zza(Integer paramInteger)
    {
      this.zzb = paramInteger;
      return this;
    }
    
    zzq.zza zza(String paramString)
    {
      this.zze = paramString;
      return this;
    }
    
    zzq.zza zza(byte[] paramArrayOfByte)
    {
      this.zzd = paramArrayOfByte;
      return this;
    }
    
    public zzq zza()
    {
      Object localObject2 = this.zza;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" eventTimeMs");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.zzc == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" eventUptimeMs");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.zzf == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" timezoneOffsetSeconds");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new zzi(this.zza.longValue(), this.zzb, this.zzc.longValue(), this.zzd, this.zze, this.zzf.longValue(), this.zzg, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public zzq.zza zzb(long paramLong)
    {
      this.zzc = Long.valueOf(paramLong);
      return this;
    }
    
    public zzq.zza zzc(long paramLong)
    {
      this.zzf = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\cct\a\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */