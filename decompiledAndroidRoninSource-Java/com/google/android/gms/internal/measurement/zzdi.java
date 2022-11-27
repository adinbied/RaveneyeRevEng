package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzdi
  extends zzdh<Long>
{
  zzdi(zzdm paramzzdm, String paramString, Long paramLong, boolean paramBoolean)
  {
    super(paramzzdm, paramString, paramLong, true, null);
  }
  
  private final Long zzb(Object paramObject)
  {
    if ((paramObject instanceof Long)) {
      return (Long)paramObject;
    }
    if ((paramObject instanceof String)) {}
    try
    {
      long l = Long.parseLong((String)paramObject);
      return Long.valueOf(l);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      String str;
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    str = super.zzb();
    paramObject = String.valueOf(paramObject);
    localStringBuilder = new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(paramObject).length());
    localStringBuilder.append("Invalid long value for ");
    localStringBuilder.append(str);
    localStringBuilder.append(": ");
    localStringBuilder.append((String)paramObject);
    Log.e("PhenotypeFlag", localStringBuilder.toString());
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */