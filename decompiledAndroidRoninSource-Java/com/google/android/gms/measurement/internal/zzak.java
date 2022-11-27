package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;

public final class zzak
{
  final String zza;
  final String zzb;
  final long zzc;
  final long zzd;
  final zzam zze;
  private final String zzf;
  
  zzak(zzfv paramzzfv, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotEmpty(paramString3);
    this.zza = paramString2;
    this.zzb = paramString3;
    paramString3 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString3 = null;
    }
    this.zzf = paramString3;
    this.zzc = paramLong1;
    this.zzd = paramLong2;
    if ((paramLong2 != 0L) && (paramLong2 > paramLong1)) {
      paramzzfv.zzq().zzh().zza("Event created with reverse previous/current timestamps. appId", zzer.zza(paramString2));
    }
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      paramString1 = new Bundle(paramBundle);
      paramString2 = paramString1.keySet().iterator();
      while (paramString2.hasNext())
      {
        paramString3 = (String)paramString2.next();
        if (paramString3 == null)
        {
          paramzzfv.zzq().zze().zza("Param name can't be null");
          paramString2.remove();
        }
        else
        {
          paramBundle = paramzzfv.zzh().zza(paramString3, paramString1.get(paramString3));
          if (paramBundle == null)
          {
            paramzzfv.zzq().zzh().zza("Param value can't be null", paramzzfv.zzi().zzb(paramString3));
            paramString2.remove();
          }
          else
          {
            paramzzfv.zzh().zza(paramString1, paramString3, paramBundle);
          }
        }
      }
      paramzzfv = new zzam(paramString1);
    }
    else
    {
      paramzzfv = new zzam(new Bundle());
    }
    this.zze = paramzzfv;
  }
  
  private zzak(zzfv paramzzfv, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, zzam paramzzam)
  {
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotEmpty(paramString3);
    Preconditions.checkNotNull(paramzzam);
    this.zza = paramString2;
    this.zzb = paramString3;
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = null;
    }
    this.zzf = str;
    this.zzc = paramLong1;
    this.zzd = paramLong2;
    if ((paramLong2 != 0L) && (paramLong2 > paramLong1)) {
      paramzzfv.zzq().zzh().zza("Event created with reverse previous/current timestamps. appId, name", zzer.zza(paramString2), zzer.zza(paramString3));
    }
    this.zze = paramzzam;
  }
  
  public final String toString()
  {
    String str1 = this.zza;
    String str2 = this.zzb;
    String str3 = String.valueOf(this.zze);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 33 + String.valueOf(str2).length() + String.valueOf(str3).length());
    localStringBuilder.append("Event{appId='");
    localStringBuilder.append(str1);
    localStringBuilder.append("', name='");
    localStringBuilder.append(str2);
    localStringBuilder.append("', params=");
    localStringBuilder.append(str3);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  final zzak zza(zzfv paramzzfv, long paramLong)
  {
    return new zzak(paramzzfv, this.zzf, this.zza, this.zzb, this.zzc, paramLong, this.zze);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */