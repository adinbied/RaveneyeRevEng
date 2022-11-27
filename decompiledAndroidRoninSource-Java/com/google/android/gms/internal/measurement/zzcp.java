package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzcp
{
  public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
  public static final Pattern zzb = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
  public static final Pattern zzc = Pattern.compile("^(0|false|f|off|no|n)$", 2);
  private static final Uri zzd = Uri.parse("content://com.google.android.gsf.gservices/prefix");
  private static final AtomicBoolean zze = new AtomicBoolean();
  private static HashMap<String, String> zzf;
  private static final HashMap<String, Boolean> zzg = new HashMap();
  private static final HashMap<String, Integer> zzh = new HashMap();
  private static final HashMap<String, Long> zzi = new HashMap();
  private static final HashMap<String, Float> zzj = new HashMap();
  private static Object zzk;
  private static boolean zzl;
  private static String[] zzm = new String[0];
  
  public static String zza(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = zzf;
        String str = null;
        paramString2 = null;
        Object localObject1 = null;
        if (localObject2 == null)
        {
          zze.set(false);
          zzf = new HashMap();
          zzk = new Object();
          zzl = false;
          paramContentResolver.registerContentObserver(zza, true, new zzco(null));
        }
        else if (zze.getAndSet(false))
        {
          zzf.clear();
          zzg.clear();
          zzh.clear();
          zzi.clear();
          zzj.clear();
          zzk = new Object();
          zzl = false;
        }
        localObject2 = zzk;
        if (zzf.containsKey(paramString1))
        {
          paramString1 = (String)zzf.get(paramString1);
          paramContentResolver = (ContentResolver)localObject1;
          if (paramString1 != null) {
            paramContentResolver = paramString1;
          }
          return paramContentResolver;
        }
        localObject1 = zzm;
        int j = localObject1.length;
        int i = 0;
        if (i < j)
        {
          if (paramString1.startsWith(localObject1[i]))
          {
            if ((!zzl) || (zzf.isEmpty()))
            {
              paramString2 = zzm;
              zzf.putAll(zza(paramContentResolver, paramString2));
              zzl = true;
              if (zzf.containsKey(paramString1))
              {
                paramString1 = (String)zzf.get(paramString1);
                paramContentResolver = str;
                if (paramString1 != null) {
                  paramContentResolver = paramString1;
                }
                return paramContentResolver;
              }
            }
            return null;
          }
        }
        else
        {
          localObject1 = paramContentResolver.query(zza, null, null, new String[] { paramString1 }, null);
          if (localObject1 == null)
          {
            if (localObject1 != null) {
              ((Cursor)localObject1).close();
            }
            return null;
          }
          try
          {
            if (!((Cursor)localObject1).moveToFirst())
            {
              zza(localObject2, paramString1, null);
              return null;
            }
            str = ((Cursor)localObject1).getString(1);
            paramContentResolver = str;
            if (str != null)
            {
              paramContentResolver = str;
              if (str.equals(null)) {
                paramContentResolver = null;
              }
            }
            zza(localObject2, paramString1, paramContentResolver);
            paramString1 = paramString2;
            if (paramContentResolver != null) {
              paramString1 = paramContentResolver;
            }
            return paramString1;
          }
          finally
          {
            if (localObject1 != null) {
              ((Cursor)localObject1).close();
            }
          }
        }
        i += 1;
      }
      finally {}
    }
  }
  
  private static Map<String, String> zza(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    paramContentResolver = paramContentResolver.query(zzd, null, null, paramVarArgs, null);
    paramVarArgs = new TreeMap();
    if (paramContentResolver == null) {
      return paramVarArgs;
    }
    try
    {
      while (paramContentResolver.moveToNext()) {
        paramVarArgs.put(paramContentResolver.getString(0), paramContentResolver.getString(1));
      }
      return paramVarArgs;
    }
    finally
    {
      paramContentResolver.close();
    }
  }
  
  private static void zza(Object paramObject, String paramString1, String paramString2)
  {
    try
    {
      if (paramObject == zzk) {
        zzf.put(paramString1, paramString2);
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzcp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */