package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzdk
  extends zzdh<Double>
{
  zzdk(zzdm paramzzdm, String paramString, Double paramDouble, boolean paramBoolean)
  {
    super(paramzzdm, paramString, paramDouble, true, null);
  }
  
  private final Double zzb(Object paramObject)
  {
    if ((paramObject instanceof Double)) {
      return (Double)paramObject;
    }
    if ((paramObject instanceof Float)) {
      return Double.valueOf(((Float)paramObject).doubleValue());
    }
    if ((paramObject instanceof String)) {}
    try
    {
      double d = Double.parseDouble((String)paramObject);
      return Double.valueOf(d);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      String str;
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    str = super.zzb();
    paramObject = String.valueOf(paramObject);
    localStringBuilder = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(paramObject).length());
    localStringBuilder.append("Invalid double value for ");
    localStringBuilder.append(str);
    localStringBuilder.append(": ");
    localStringBuilder.append((String)paramObject);
    Log.e("PhenotypeFlag", localStringBuilder.toString());
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */