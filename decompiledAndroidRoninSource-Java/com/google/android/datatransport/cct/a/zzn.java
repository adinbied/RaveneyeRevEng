package com.google.android.datatransport.cct.a;

final class zzn
  extends zzt
{
  private final zzt.zzc zza;
  private final zzt.zzb zzb;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof zzt))
    {
      Object localObject = this.zza;
      if (localObject == null ? ((zzn)paramObject).zza == null : ((Enum)localObject).equals(((zzn)paramObject).zza))
      {
        localObject = this.zzb;
        if (localObject == null)
        {
          if (((zzn)paramObject).zzb == null) {
            return true;
          }
        }
        else if (((Enum)localObject).equals(((zzn)paramObject).zzb)) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  public int hashCode()
  {
    Object localObject = this.zza;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Enum)localObject).hashCode();
    }
    localObject = this.zzb;
    if (localObject != null) {
      j = ((Enum)localObject).hashCode();
    }
    return (i ^ 0xF4243) * 1000003 ^ j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetworkConnectionInfo{networkType=");
    localStringBuilder.append(this.zza);
    localStringBuilder.append(", mobileSubtype=");
    localStringBuilder.append(this.zzb);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public zzt.zzb zzb()
  {
    return this.zzb;
  }
  
  public zzt.zzc zzc()
  {
    return this.zza;
  }
  
  static final class zza
    extends zzt.zza
  {
    private zzt.zzc zza;
    private zzt.zzb zzb;
    
    public zzt.zza zza(zzt.zzb paramzzb)
    {
      this.zzb = paramzzb;
      return this;
    }
    
    public zzt.zza zza(zzt.zzc paramzzc)
    {
      this.zza = paramzzc;
      return this;
    }
    
    public zzt zza()
    {
      return new zzn(this.zza, this.zzb, null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\cct\a\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */