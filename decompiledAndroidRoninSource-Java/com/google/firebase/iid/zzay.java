package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class zzay
{
  private static final long zzb = TimeUnit.DAYS.toMillis(7L);
  final String zza;
  private final String zzc;
  private final long zzd;
  
  private zzay(String paramString1, String paramString2, long paramLong)
  {
    this.zza = paramString1;
    this.zzc = paramString2;
    this.zzd = paramLong;
  }
  
  static zzay zza(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.startsWith("{")) {
      try
      {
        paramString = new JSONObject(paramString);
        paramString = new zzay(paramString.getString("token"), paramString.getString("appVersion"), paramString.getLong("timestamp"));
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString = String.valueOf(paramString);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 23);
        localStringBuilder.append("Failed to parse token: ");
        localStringBuilder.append(paramString);
        Log.w("FirebaseInstanceId", localStringBuilder.toString());
        return null;
      }
    }
    return new zzay(paramString, null, 0L);
  }
  
  static String zza(zzay paramzzay)
  {
    if (paramzzay == null) {
      return null;
    }
    return paramzzay.zza;
  }
  
  static String zza(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("token", paramString1);
      localJSONObject.put("appVersion", paramString2);
      localJSONObject.put("timestamp", paramLong);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1 = String.valueOf(paramString1);
      paramString2 = new StringBuilder(String.valueOf(paramString1).length() + 24);
      paramString2.append("Failed to encode token: ");
      paramString2.append(paramString1);
      Log.w("FirebaseInstanceId", paramString2.toString());
    }
    return null;
  }
  
  final boolean zzb(String paramString)
  {
    return (System.currentTimeMillis() > this.zzd + zzb) || (!paramString.equals(this.zzc));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */