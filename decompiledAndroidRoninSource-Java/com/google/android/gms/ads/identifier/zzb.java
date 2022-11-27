package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

public final class zzb
{
  private SharedPreferences zzs;
  
  public zzb(Context paramContext)
  {
    try
    {
      paramContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if (paramContext == null) {
        paramContext = null;
      } else {
        paramContext = paramContext.getSharedPreferences("google_ads_flags", 0);
      }
      this.zzs = paramContext;
      return;
    }
    finally
    {
      Log.w("GmscoreFlag", "Error while getting SharedPreferences ", paramContext);
      this.zzs = null;
    }
  }
  
  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    try
    {
      if (this.zzs == null) {
        return false;
      }
      paramBoolean = this.zzs.getBoolean(paramString, false);
      return paramBoolean;
    }
    finally
    {
      Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", paramString);
    }
    return false;
  }
  
  final float getFloat(String paramString, float paramFloat)
  {
    try
    {
      if (this.zzs == null) {
        return 0.0F;
      }
      paramFloat = this.zzs.getFloat(paramString, 0.0F);
      return paramFloat;
    }
    finally
    {
      Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", paramString);
    }
    return 0.0F;
  }
  
  final String getString(String paramString1, String paramString2)
  {
    try
    {
      if (this.zzs == null) {
        return paramString2;
      }
      paramString1 = this.zzs.getString(paramString1, paramString2);
      return paramString1;
    }
    finally
    {
      Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", paramString1);
    }
    return paramString2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\ads\identifier\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */