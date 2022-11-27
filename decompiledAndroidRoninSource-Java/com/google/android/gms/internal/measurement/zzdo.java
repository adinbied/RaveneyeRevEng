package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzdo
  implements zzcx
{
  private static final Map<String, zzdo> zza = new ArrayMap();
  private final SharedPreferences zzb;
  private final SharedPreferences.OnSharedPreferenceChangeListener zzc = new zzdr(this);
  private final Object zzd = new Object();
  private volatile Map<String, ?> zze;
  private final List<zzcu> zzf = new ArrayList();
  
  private zzdo(SharedPreferences paramSharedPreferences)
  {
    this.zzb = paramSharedPreferences;
    paramSharedPreferences.registerOnSharedPreferenceChangeListener(this.zzc);
  }
  
  static zzdo zza(Context paramContext, String paramString)
  {
    if (zzcr.zza()) {
      throw new NullPointerException();
    }
    if (1 == 0) {
      return null;
    }
    try
    {
      zzdo localzzdo = (zzdo)zza.get(null);
      paramString = localzzdo;
      if (localzzdo == null)
      {
        paramString = new zzdo(zzb(paramContext, null));
        zza.put(null, paramString);
      }
      return paramString;
    }
    finally {}
  }
  
  static void zza()
  {
    try
    {
      Iterator localIterator = zza.values().iterator();
      while (localIterator.hasNext())
      {
        zzdo localzzdo = (zzdo)localIterator.next();
        localzzdo.zzb.unregisterOnSharedPreferenceChangeListener(localzzdo.zzc);
      }
      zza.clear();
      return;
    }
    finally {}
  }
  
  private static SharedPreferences zzb(Context paramContext, String paramString)
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskReads();
    try
    {
      if (paramString.startsWith("direct_boot:"))
      {
        Context localContext = paramContext;
        if (zzcr.zza()) {
          localContext = paramContext.createDeviceProtectedStorageContext();
        }
        paramContext = localContext.getSharedPreferences(paramString.substring(12), 0);
        return paramContext;
      }
      paramContext = paramContext.getSharedPreferences(paramString, 0);
      return paramContext;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }
  
  public final Object zza(String paramString)
  {
    Object localObject2 = this.zze;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      synchronized (this.zzd)
      {
        localObject2 = this.zze;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject2 = StrictMode.allowThreadDiskReads();
        }
        try
        {
          localObject1 = this.zzb.getAll();
          this.zze = ((Map)localObject1);
          StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)localObject2);
        }
        finally
        {
          StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)localObject2);
        }
      }
    }
    if (localObject1 != null) {
      return ((Map)localObject1).get(paramString);
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */