package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

public final class UnsupportedApiCallException
  extends UnsupportedOperationException
{
  private final Feature zzas;
  
  public UnsupportedApiCallException(Feature paramFeature)
  {
    this.zzas = paramFeature;
  }
  
  public final String getMessage()
  {
    String str = String.valueOf(this.zzas);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 8);
    localStringBuilder.append("Missing ");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\UnsupportedApiCallException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */