package com.google.android.datatransport.cct.a;

final class zzl
  extends zzs
{
  private final long zza;
  
  zzl(long paramLong)
  {
    this.zza = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof zzs))
    {
      paramObject = (zzs)paramObject;
      return this.zza == ((zzs)paramObject).zza();
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = this.zza;
    return 0xF4243 ^ (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LogResponse{nextRequestWaitMillis=");
    localStringBuilder.append(this.zza);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public long zza()
  {
    return this.zza;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\cct\a\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */