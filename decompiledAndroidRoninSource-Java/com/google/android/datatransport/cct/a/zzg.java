package com.google.android.datatransport.cct.a;

final class zzg
  extends zzp
{
  private final zzp.zzb zza;
  private final zza zzb;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof zzp))
    {
      Object localObject = this.zza;
      if (localObject == null ? ((zzg)paramObject).zza == null : ((Enum)localObject).equals(((zzg)paramObject).zza))
      {
        localObject = this.zzb;
        if (localObject == null)
        {
          if (((zzg)paramObject).zzb == null) {
            return true;
          }
        }
        else if (localObject.equals(((zzg)paramObject).zzb)) {
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
      j = localObject.hashCode();
    }
    return (i ^ 0xF4243) * 1000003 ^ j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ClientInfo{clientType=");
    localStringBuilder.append(this.zza);
    localStringBuilder.append(", androidClientInfo=");
    localStringBuilder.append(this.zzb);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public zza zzb()
  {
    return this.zzb;
  }
  
  public zzp.zzb zzc()
  {
    return this.zza;
  }
  
  static final class zza
    extends zzp.zza
  {
    private zzp.zzb zza;
    private zza zzb;
    
    public zzp.zza zza(zza paramzza)
    {
      this.zzb = paramzza;
      return this;
    }
    
    public zzp.zza zza(zzp.zzb paramzzb)
    {
      this.zza = paramzzb;
      return this;
    }
    
    public zzp zza()
    {
      return new zzg(this.zza, this.zzb, null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\cct\a\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */