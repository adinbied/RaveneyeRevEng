package com.google.android.datatransport.cct.a;

import com.google.firebase.encoders.annotations.Encodable.Field;
import java.util.List;

final class zze
  extends zzo
{
  private final List<zzr> zza;
  
  zze(List<zzr> paramList)
  {
    if (paramList != null)
    {
      this.zza = paramList;
      return;
    }
    throw new NullPointerException("Null logRequests");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof zzo))
    {
      paramObject = (zzo)paramObject;
      return this.zza.equals(((zzo)paramObject).zza());
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.zza.hashCode() ^ 0xF4243;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BatchedLogRequest{logRequests=");
    localStringBuilder.append(this.zza);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  @Encodable.Field(name="logRequest")
  public List<zzr> zza()
  {
    return this.zza;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\cct\a\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */