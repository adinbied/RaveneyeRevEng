package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class zzaz
{
  private final SharedPreferences zza;
  private final Context zzb;
  private final Map<String, Long> zzc = new ArrayMap();
  
  public zzaz(Context paramContext)
  {
    this.zzb = paramContext;
    this.zza = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    paramContext = new File(ContextCompat.getNoBackupFilesDir(this.zzb), "com.google.android.gms.appid-no-backup");
    if (!paramContext.exists()) {
      try
      {
        if ((paramContext.createNewFile()) && (!zzb()))
        {
          Log.i("FirebaseInstanceId", "App restored, clearing state");
          zza();
          FirebaseInstanceId.getInstance().zze();
        }
        return;
      }
      catch (IOException paramContext)
      {
        if (Log.isLoggable("FirebaseInstanceId", 3))
        {
          paramContext = String.valueOf(paramContext.getMessage());
          if (paramContext.length() != 0) {
            paramContext = "Error creating file in no backup dir: ".concat(paramContext);
          } else {
            paramContext = new String("Error creating file in no backup dir: ");
          }
          Log.d("FirebaseInstanceId", paramContext);
        }
      }
    }
  }
  
  private static String zza(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString1).length() + 3 + String.valueOf(paramString2).length());
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|S|");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private final boolean zzb()
  {
    try
    {
      boolean bool = this.zza.getAll().isEmpty();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static String zzc(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString1).length() + 4 + String.valueOf(paramString2).length() + String.valueOf(paramString3).length());
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|T|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  private final long zzd(String paramString)
  {
    paramString = this.zza.getString(zza(paramString, "cre"), null);
    if (paramString != null) {}
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return 0L;
  }
  
  public final long zza(String paramString)
  {
    try
    {
      Long localLong = (Long)this.zzc.get(paramString);
      if (localLong != null)
      {
        l = localLong.longValue();
        return l;
      }
      long l = zzd(paramString);
      return l;
    }
    finally {}
  }
  
  public final zzay zza(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = zzay.zza(this.zza.getString(zzc(paramString1, paramString2, paramString3), null));
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void zza()
  {
    try
    {
      this.zzc.clear();
      this.zza.edit().clear().commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void zza(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramString4 = zzay.zza(paramString4, paramString5, System.currentTimeMillis());
      if (paramString4 == null) {
        return;
      }
      paramString5 = this.zza.edit();
      paramString5.putString(zzc(paramString1, paramString2, paramString3), paramString4);
      paramString5.commit();
      return;
    }
    finally {}
  }
  
  public final long zzb(String paramString)
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = zza(paramString, "cre");
      if (!this.zza.contains((String)localObject))
      {
        localObject = this.zza.edit();
        ((SharedPreferences.Editor)localObject).putString(zza(paramString, "cre"), String.valueOf(l));
        ((SharedPreferences.Editor)localObject).commit();
      }
      else
      {
        l = zzd(paramString);
      }
      this.zzc.put(paramString, Long.valueOf(l));
      return l;
    }
    finally {}
  }
  
  public final void zzb(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = zzc(paramString1, paramString2, paramString3);
      paramString2 = this.zza.edit();
      paramString2.remove(paramString1);
      paramString2.commit();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void zzc(String paramString)
  {
    try
    {
      paramString = String.valueOf(paramString).concat("|T|");
      SharedPreferences.Editor localEditor = this.zza.edit();
      Iterator localIterator = this.zza.getAll().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(paramString)) {
          localEditor.remove(str);
        }
      }
      localEditor.commit();
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */