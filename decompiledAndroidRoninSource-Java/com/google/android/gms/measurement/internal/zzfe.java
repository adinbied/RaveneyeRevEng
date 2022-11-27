package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzfe
{
  private final String zza;
  private final Bundle zzb;
  private boolean zzc;
  private Bundle zzd;
  
  public zzfe(zzfd paramzzfd, String paramString, Bundle paramBundle)
  {
    Preconditions.checkNotEmpty(paramString);
    this.zza = paramString;
    this.zzb = new Bundle();
  }
  
  private final String zzb(Bundle paramBundle)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if (localObject != null) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("n", str);
          localJSONObject.put("v", String.valueOf(localObject));
          boolean bool = localObject instanceof String;
          if (bool)
          {
            localJSONObject.put("t", "s");
          }
          else if ((localObject instanceof Long))
          {
            localJSONObject.put("t", "l");
          }
          else
          {
            if (!(localObject instanceof Double)) {
              break label158;
            }
            localJSONObject.put("t", "d");
          }
          localJSONArray.put(localJSONObject);
          continue;
          label158:
          this.zze.zzq().zze().zza("Cannot serialize bundle value to SharedPreferences. Type", localObject.getClass());
        }
        catch (JSONException localJSONException)
        {
          this.zze.zzq().zze().zza("Cannot serialize bundle value to SharedPreferences", localJSONException);
        }
      }
    }
    return localJSONArray.toString();
  }
  
  public final Bundle zza()
  {
    Object localObject;
    if (!this.zzc)
    {
      this.zzc = true;
      localObject = this.zze.zzf().getString(this.zza, null);
      if (localObject == null) {}
    }
    try
    {
      localBundle = new Bundle();
      localObject = new JSONArray((String)localObject);
      j = 0;
    }
    catch (JSONException localJSONException1)
    {
      int j;
      for (;;)
      {
        Bundle localBundle;
        int i;
      }
    }
    i = ((JSONArray)localObject).length();
    if (j < i) {}
    try
    {
      JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
      String str1 = localJSONObject.getString("n");
      String str2 = localJSONObject.getString("t");
      i = -1;
      int k = str2.hashCode();
      if (k != 100)
      {
        if (k != 108)
        {
          if ((k == 115) && (str2.equals("s"))) {
            i = 0;
          }
        }
        else if (str2.equals("l")) {
          i = 2;
        }
      }
      else
      {
        boolean bool = str2.equals("d");
        if (bool) {
          i = 1;
        }
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            this.zze.zzq().zze().zza("Unrecognized persisted bundle type. Type", str2);
          } else {
            localBundle.putLong(str1, Long.parseLong(localJSONObject.getString("v")));
          }
        }
        else {
          localBundle.putDouble(str1, Double.parseDouble(localJSONObject.getString("v")));
        }
      }
      else {
        localBundle.putString(str1, localJSONObject.getString("v"));
      }
    }
    catch (JSONException|NumberFormatException localJSONException2)
    {
      for (;;) {}
      j += 1;
    }
    this.zze.zzq().zze().zza("Error reading value from SharedPreferences. Value dropped");
    break label333;
    this.zzd = localBundle;
    break label303;
    this.zze.zzq().zze().zza("Error loading bundle from SharedPreferences. Values will be lost");
    label303:
    if (this.zzd == null) {
      this.zzd = this.zzb;
    }
    return this.zzd;
  }
  
  public final void zza(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = this.zze.zzf().edit();
    if (localBundle.size() == 0) {
      paramBundle.remove(this.zza);
    } else {
      paramBundle.putString(this.zza, zzb(localBundle));
    }
    paramBundle.apply();
    this.zzd = localBundle;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */