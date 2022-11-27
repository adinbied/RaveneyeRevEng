package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzca.zza.zza;
import com.google.android.gms.internal.measurement.zzca.zzb;
import com.google.android.gms.internal.measurement.zzca.zzb.zza;
import com.google.android.gms.internal.measurement.zzca.zzc;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzhz.zza;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzlq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzfp
  extends zzkj
  implements zzaa
{
  private static int zzb = 65535;
  private static int zzc = 2;
  private final Map<String, Map<String, String>> zzd = new ArrayMap();
  private final Map<String, Map<String, Boolean>> zze = new ArrayMap();
  private final Map<String, Map<String, Boolean>> zzf = new ArrayMap();
  private final Map<String, zzca.zzb> zzg = new ArrayMap();
  private final Map<String, Map<String, Integer>> zzh = new ArrayMap();
  private final Map<String, String> zzi = new ArrayMap();
  
  zzfp(zzki paramzzki)
  {
    super(paramzzki);
  }
  
  private final zzca.zzb zza(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return zzca.zzb.zzj();
    }
    for (;;)
    {
      try
      {
        zzca.zzb localzzb = (zzca.zzb)((zzca.zzb.zza)zzks.zza(zzca.zzb.zzi(), paramArrayOfByte)).zzz();
        zzet localzzet = zzq().zzw();
        boolean bool = localzzb.zza();
        String str = null;
        if (bool)
        {
          paramArrayOfByte = Long.valueOf(localzzb.zzb());
          if (localzzb.zzc()) {
            str = localzzb.zzd();
          }
          localzzet.zza("Parsed config. version, gmp_app_id", paramArrayOfByte, str);
          return localzzb;
        }
      }
      catch (RuntimeException paramArrayOfByte)
      {
        zzq().zzh().zza("Unable to merge remote config. appId", zzer.zza(paramString), paramArrayOfByte);
        return zzca.zzb.zzj();
      }
      catch (zzih paramArrayOfByte)
      {
        zzq().zzh().zza("Unable to merge remote config. appId", zzer.zza(paramString), paramArrayOfByte);
        return zzca.zzb.zzj();
      }
      paramArrayOfByte = null;
    }
  }
  
  private static Map<String, String> zza(zzca.zzb paramzzb)
  {
    ArrayMap localArrayMap = new ArrayMap();
    if (paramzzb != null)
    {
      paramzzb = paramzzb.zze().iterator();
      while (paramzzb.hasNext())
      {
        zzca.zzc localzzc = (zzca.zzc)paramzzb.next();
        localArrayMap.put(localzzc.zza(), localzzc.zzb());
      }
    }
    return localArrayMap;
  }
  
  private final void zza(String paramString, zzca.zzb.zza paramzza)
  {
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    ArrayMap localArrayMap3 = new ArrayMap();
    if (paramzza != null)
    {
      int i = 0;
      while (i < paramzza.zza())
      {
        zzca.zza.zza localzza2 = (zzca.zza.zza)paramzza.zza(i).zzbn();
        if (TextUtils.isEmpty(localzza2.zza()))
        {
          zzq().zzh().zza("EventConfig contained null event name");
        }
        else
        {
          String str1 = localzza2.zza();
          String str2 = zzgs.zzb(localzza2.zza());
          zzca.zza.zza localzza1 = localzza2;
          if (!TextUtils.isEmpty(str2))
          {
            localzza1 = localzza2.zza(str2);
            paramzza.zza(i, localzza1);
          }
          if ((zzlq.zzb()) && (zzs().zza(zzat.zzcm))) {
            localArrayMap1.put(str1, Boolean.valueOf(localzza1.zzb()));
          } else {
            localArrayMap1.put(localzza1.zza(), Boolean.valueOf(localzza1.zzb()));
          }
          localArrayMap2.put(localzza1.zza(), Boolean.valueOf(localzza1.zzc()));
          if (localzza1.zzd()) {
            if ((localzza1.zze() >= zzc) && (localzza1.zze() <= zzb)) {
              localArrayMap3.put(localzza1.zza(), Integer.valueOf(localzza1.zze()));
            } else {
              zzq().zzh().zza("Invalid sampling rate. Event name, sample rate", localzza1.zza(), Integer.valueOf(localzza1.zze()));
            }
          }
        }
        i += 1;
      }
    }
    this.zze.put(paramString, localArrayMap1);
    this.zzf.put(paramString, localArrayMap2);
    this.zzh.put(paramString, localArrayMap3);
  }
  
  private final void zzi(String paramString)
  {
    zzaj();
    zzc();
    Preconditions.checkNotEmpty(paramString);
    if (this.zzg.get(paramString) == null)
    {
      Object localObject = zzi().zzd(paramString);
      if (localObject == null)
      {
        this.zzd.put(paramString, null);
        this.zze.put(paramString, null);
        this.zzf.put(paramString, null);
        this.zzg.put(paramString, null);
        this.zzi.put(paramString, null);
        this.zzh.put(paramString, null);
        return;
      }
      localObject = (zzca.zzb.zza)zza(paramString, (byte[])localObject).zzbn();
      zza(paramString, (zzca.zzb.zza)localObject);
      this.zzd.put(paramString, zza((zzca.zzb)((zzhz.zza)localObject).zzz()));
      this.zzg.put(paramString, (zzca.zzb)((zzhz.zza)localObject).zzz());
      this.zzi.put(paramString, null);
    }
  }
  
  protected final zzca.zzb zza(String paramString)
  {
    zzaj();
    zzc();
    Preconditions.checkNotEmpty(paramString);
    zzi(paramString);
    return (zzca.zzb)this.zzg.get(paramString);
  }
  
  public final String zza(String paramString1, String paramString2)
  {
    zzc();
    zzi(paramString1);
    paramString1 = (Map)this.zzd.get(paramString1);
    if (paramString1 != null) {
      return (String)paramString1.get(paramString2);
    }
    return null;
  }
  
  protected final boolean zza(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    zzaj();
    zzc();
    Preconditions.checkNotEmpty(paramString1);
    zzca.zzb.zza localzza = (zzca.zzb.zza)zza(paramString1, paramArrayOfByte).zzbn();
    if (localzza == null) {
      return false;
    }
    zza(paramString1, localzza);
    this.zzg.put(paramString1, (zzca.zzb)localzza.zzz());
    this.zzi.put(paramString1, paramString2);
    this.zzd.put(paramString1, zza((zzca.zzb)localzza.zzz()));
    zzi().zza(paramString1, new ArrayList(localzza.zzb()));
    try
    {
      localzza.zzc();
      paramString2 = ((zzca.zzb)localzza.zzz()).zzbk();
      paramArrayOfByte = paramString2;
    }
    catch (RuntimeException paramString2)
    {
      zzq().zzh().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzer.zza(paramString1), paramString2);
    }
    paramString2 = zzi();
    Preconditions.checkNotEmpty(paramString1);
    paramString2.zzc();
    paramString2.zzaj();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("remote_config", paramArrayOfByte);
    try
    {
      if (paramString2.c_().update("apps", localContentValues, "app_id = ?", new String[] { paramString1 }) == 0L) {
        paramString2.zzq().zze().zza("Failed to update remote config (got 0). appId", zzer.zza(paramString1));
      }
    }
    catch (SQLiteException paramArrayOfByte)
    {
      paramString2.zzq().zze().zza("Error storing remote config. appId", zzer.zza(paramString1), paramArrayOfByte);
    }
    this.zzg.put(paramString1, (zzca.zzb)localzza.zzz());
    return true;
  }
  
  protected final String zzb(String paramString)
  {
    zzc();
    return (String)this.zzi.get(paramString);
  }
  
  final boolean zzb(String paramString1, String paramString2)
  {
    zzc();
    zzi(paramString1);
    if ((zzg(paramString1)) && (zzkw.zzd(paramString2))) {
      return true;
    }
    if ((zzh(paramString1)) && (zzkw.zza(paramString2))) {
      return true;
    }
    paramString1 = (Map)this.zze.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Boolean)paramString1.get(paramString2);
      if (paramString1 == null) {
        return false;
      }
      return paramString1.booleanValue();
    }
    return false;
  }
  
  protected final void zzc(String paramString)
  {
    zzc();
    this.zzi.put(paramString, null);
  }
  
  final boolean zzc(String paramString1, String paramString2)
  {
    zzc();
    zzi(paramString1);
    if ("ecommerce_purchase".equals(paramString2)) {
      return true;
    }
    if (!"purchase".equals(paramString2))
    {
      if ("refund".equals(paramString2)) {
        return true;
      }
      paramString1 = (Map)this.zzf.get(paramString1);
      if (paramString1 != null)
      {
        paramString1 = (Boolean)paramString1.get(paramString2);
        if (paramString1 == null) {
          return false;
        }
        return paramString1.booleanValue();
      }
      return false;
    }
    return true;
  }
  
  final int zzd(String paramString1, String paramString2)
  {
    zzc();
    zzi(paramString1);
    paramString1 = (Map)this.zzh.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Integer)paramString1.get(paramString2);
      if (paramString1 == null) {
        return 1;
      }
      return paramString1.intValue();
    }
    return 1;
  }
  
  final void zzd(String paramString)
  {
    zzc();
    this.zzg.remove(paramString);
  }
  
  protected final boolean zzd()
  {
    return false;
  }
  
  final boolean zze(String paramString)
  {
    zzc();
    paramString = zza(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.zzh();
  }
  
  final long zzf(String paramString)
  {
    String str = zza(paramString, "measurement.account.time_zone_offset_minutes");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        long l = Long.parseLong(str);
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        zzq().zzh().zza("Unable to parse timezone offset. appId", zzer.zza(paramString), localNumberFormatException);
      }
    }
    return 0L;
  }
  
  final boolean zzg(String paramString)
  {
    return "1".equals(zza(paramString, "measurement.upload.blacklist_internal"));
  }
  
  final boolean zzh(String paramString)
  {
    return "1".equals(zza(paramString, "measurement.upload.blacklist_public"));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */