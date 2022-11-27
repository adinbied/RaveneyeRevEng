package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.MissingFormatArgumentException;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public final class zzt
{
  private final Bundle zza;
  
  public zzt(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.zza = new Bundle(paramBundle);
      return;
    }
    throw new NullPointerException("data");
  }
  
  public static boolean zza(Bundle paramBundle)
  {
    return ("1".equals(paramBundle.getString("gcm.n.e"))) || ("1".equals(paramBundle.getString(zzi("gcm.n.e"))));
  }
  
  private final String zzb(Resources paramResources, String paramString1, String paramString2)
  {
    Object localObject = zze(paramString2);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    int i = paramResources.getIdentifier((String)localObject, "string", paramString1);
    if (i == 0)
    {
      paramResources = String.valueOf(paramString2);
      if ("_loc_key".length() != 0) {
        paramResources = paramResources.concat("_loc_key");
      } else {
        paramResources = new String(paramResources);
      }
      paramResources = zzh(paramResources);
      paramString1 = new StringBuilder(String.valueOf(paramResources).length() + 49 + String.valueOf(paramString2).length());
      paramString1.append(paramResources);
      paramString1.append(" resource not found: ");
      paramString1.append(paramString2);
      paramString1.append(" Default value will be used.");
      Log.w("NotificationParams", paramString1.toString());
      return null;
    }
    paramString1 = zzf(paramString2);
    if (paramString1 == null) {
      return paramResources.getString(i);
    }
    try
    {
      paramResources = paramResources.getString(i, paramString1);
      return paramResources;
    }
    catch (MissingFormatArgumentException paramResources)
    {
      paramString2 = zzh(paramString2);
      paramString1 = Arrays.toString(paramString1);
      localObject = new StringBuilder(String.valueOf(paramString2).length() + 58 + String.valueOf(paramString1).length());
      ((StringBuilder)localObject).append("Missing format argument for ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(": ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" Default value will be used.");
      Log.w("NotificationParams", ((StringBuilder)localObject).toString(), paramResources);
    }
    return null;
  }
  
  private final JSONArray zzg(String paramString)
  {
    String str = zza(paramString);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      localObject = new JSONArray(str);
      return (JSONArray)localObject;
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      for (;;) {}
    }
    paramString = zzh(paramString);
    localObject = new StringBuilder(String.valueOf(paramString).length() + 50 + String.valueOf(str).length());
    ((StringBuilder)localObject).append("Malformed JSON for key ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(", falling back to default");
    Log.w("NotificationParams", ((StringBuilder)localObject).toString());
    return null;
  }
  
  private static String zzh(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("gcm.n.")) {
      str = paramString.substring(6);
    }
    return str;
  }
  
  private static String zzi(String paramString)
  {
    if (!paramString.startsWith("gcm.n.")) {
      return paramString;
    }
    return paramString.replace("gcm.n.", "gcm.notification.");
  }
  
  public final Uri zza()
  {
    String str2 = zza("gcm.n.link_android");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = zza("gcm.n.link");
    }
    if (!TextUtils.isEmpty(str1)) {
      return Uri.parse(str1);
    }
    return null;
  }
  
  public final String zza(Resources paramResources, String paramString1, String paramString2)
  {
    String str = zza(paramString2);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return zzb(paramResources, paramString1, paramString2);
  }
  
  public final String zza(String paramString)
  {
    Bundle localBundle = this.zza;
    Object localObject = paramString;
    if (!localBundle.containsKey(paramString))
    {
      localObject = paramString;
      if (paramString.startsWith("gcm.n."))
      {
        String str = zzi(paramString);
        localObject = paramString;
        if (this.zza.containsKey(str)) {
          localObject = str;
        }
      }
    }
    return localBundle.getString((String)localObject);
  }
  
  public final String zzb()
  {
    String str2 = zza("gcm.n.sound2");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = zza("gcm.n.sound");
    }
    return str1;
  }
  
  public final boolean zzb(String paramString)
  {
    paramString = zza(paramString);
    return ("1".equals(paramString)) || (Boolean.parseBoolean(paramString));
  }
  
  public final Integer zzc(String paramString)
  {
    String str = zza(paramString);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      int i = Integer.parseInt(str);
      return Integer.valueOf(i);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    paramString = zzh(paramString);
    localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 38 + String.valueOf(str).length());
    localStringBuilder.append("Couldn't parse value of ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("(");
    localStringBuilder.append(str);
    localStringBuilder.append(") into an int");
    Log.w("NotificationParams", localStringBuilder.toString());
    return null;
  }
  
  public final long[] zzc()
  {
    Object localObject1 = zzg("gcm.n.vibrate_timings");
    if (localObject1 == null) {
      return null;
    }
    try
    {
      if (((JSONArray)localObject1).length() > 1)
      {
        int j = ((JSONArray)localObject1).length();
        localObject2 = new long[j];
        int i = 0;
        while (i < j)
        {
          localObject2[i] = ((JSONArray)localObject1).optLong(i);
          i += 1;
        }
      }
      throw new JSONException("vibrateTimings have invalid length");
    }
    catch (JSONException|NumberFormatException localJSONException)
    {
      Object localObject2;
      for (;;) {}
      return localJSONException;
    }
    localObject1 = String.valueOf(localObject1);
    localObject2 = new StringBuilder(String.valueOf(localObject1).length() + 74);
    ((StringBuilder)localObject2).append("User defined vibrateTimings is invalid: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(". Skipping setting vibrateTimings.");
    Log.w("NotificationParams", ((StringBuilder)localObject2).toString());
    return null;
  }
  
  public final Long zzd(String paramString)
  {
    String str = zza(paramString);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      long l = Long.parseLong(str);
      return Long.valueOf(l);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    paramString = zzh(paramString);
    localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 38 + String.valueOf(str).length());
    localStringBuilder.append("Couldn't parse value of ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("(");
    localStringBuilder.append(str);
    localStringBuilder.append(") into a long");
    Log.w("NotificationParams", localStringBuilder.toString());
    return null;
  }
  
  final int[] zzd()
  {
    Object localObject1 = zzg("gcm.n.light_settings");
    if (localObject1 == null) {
      return null;
    }
    try
    {
      if (((JSONArray)localObject1).length() == 3)
      {
        int i = Color.parseColor(((JSONArray)localObject1).optString(0));
        if (i != -16777216) {
          return new int[] { i, ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(2) };
        }
        throw new IllegalArgumentException("Transparent color is invalid");
      }
      throw new JSONException("lightSettings don't have all three fields");
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localObject1 = String.valueOf(localObject1);
      Object localObject2 = localIllegalArgumentException.getMessage();
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject1).length() + 60 + String.valueOf(localObject2).length());
      localStringBuilder.append("LightSettings is invalid: ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(". ");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(". Skipping setting LightSettings");
      Log.w("NotificationParams", localStringBuilder.toString());
      return null;
      localObject1 = String.valueOf(localObject1);
      localObject2 = new StringBuilder(String.valueOf(localObject1).length() + 58);
      ((StringBuilder)localObject2).append("LightSettings is invalid: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(". Skipping setting LightSettings");
      Log.w("NotificationParams", ((StringBuilder)localObject2).toString());
      return null;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  public final Bundle zze()
  {
    Bundle localBundle = new Bundle(this.zza);
    Iterator localIterator = this.zza.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i;
      if ((!str.startsWith("google.c.")) && (!str.startsWith("gcm.n.")) && (!str.startsWith("gcm.notification."))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        localBundle.remove(str);
      }
    }
    return localBundle;
  }
  
  public final String zze(String paramString)
  {
    paramString = String.valueOf(paramString);
    if ("_loc_key".length() != 0) {
      paramString = paramString.concat("_loc_key");
    } else {
      paramString = new String(paramString);
    }
    return zza(paramString);
  }
  
  public final Bundle zzf()
  {
    Bundle localBundle = new Bundle(this.zza);
    Iterator localIterator = this.zza.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i;
      if ((!str.startsWith("google.c.a.")) && (!str.equals("from"))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        localBundle.remove(str);
      }
    }
    return localBundle;
  }
  
  public final Object[] zzf(String paramString)
  {
    paramString = String.valueOf(paramString);
    if ("_loc_args".length() != 0) {
      paramString = paramString.concat("_loc_args");
    } else {
      paramString = new String(paramString);
    }
    paramString = zzg(paramString);
    if (paramString == null) {
      return null;
    }
    int j = paramString.length();
    String[] arrayOfString = new String[j];
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = paramString.optString(i);
      i += 1;
    }
    return arrayOfString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */