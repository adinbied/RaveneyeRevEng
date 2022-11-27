package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zza
  extends zzd
{
  private final Map<String, Long> zza = new ArrayMap();
  private final Map<String, Integer> zzb = new ArrayMap();
  private long zzc;
  
  public zza(zzfv paramzzfv)
  {
    super(paramzzfv);
  }
  
  private final void zza(long paramLong, zzig paramzzig)
  {
    if (paramzzig == null)
    {
      zzq().zzw().zza("Not logging ad exposure. No active activity");
      return;
    }
    if (paramLong < 1000L)
    {
      zzq().zzw().zza("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(paramLong));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("_xt", paramLong);
    zzij.zza(paramzzig, localBundle, true);
    zze().zza("am", "_xa", localBundle);
  }
  
  private final void zza(String paramString, long paramLong, zzig paramzzig)
  {
    if (paramzzig == null)
    {
      zzq().zzw().zza("Not logging ad unit exposure. No active activity");
      return;
    }
    if (paramLong < 1000L)
    {
      zzq().zzw().zza("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(paramLong));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_ai", paramString);
    localBundle.putLong("_xt", paramLong);
    zzij.zza(paramzzig, localBundle, true);
    zze().zza("am", "_xu", localBundle);
  }
  
  private final void zzb(long paramLong)
  {
    Iterator localIterator = this.zza.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.zza.put(str, Long.valueOf(paramLong));
    }
    if (!this.zza.isEmpty()) {
      this.zzc = paramLong;
    }
  }
  
  private final void zzc(String paramString, long paramLong)
  {
    zzc();
    Preconditions.checkNotEmpty(paramString);
    if (this.zzb.isEmpty()) {
      this.zzc = paramLong;
    }
    Integer localInteger = (Integer)this.zzb.get(paramString);
    if (localInteger != null)
    {
      this.zzb.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
      return;
    }
    if (this.zzb.size() >= 100)
    {
      zzq().zzh().zza("Too many ads visible");
      return;
    }
    this.zzb.put(paramString, Integer.valueOf(1));
    this.zza.put(paramString, Long.valueOf(paramLong));
  }
  
  private final void zzd(String paramString, long paramLong)
  {
    zzc();
    Preconditions.checkNotEmpty(paramString);
    Object localObject = (Integer)this.zzb.get(paramString);
    if (localObject != null)
    {
      zzig localzzig = zzh().zza(false);
      int i = ((Integer)localObject).intValue() - 1;
      if (i == 0)
      {
        this.zzb.remove(paramString);
        localObject = (Long)this.zza.get(paramString);
        long l;
        if (localObject == null)
        {
          zzq().zze().zza("First ad unit exposure time was never set");
        }
        else
        {
          l = ((Long)localObject).longValue();
          this.zza.remove(paramString);
          zza(paramString, paramLong - l, localzzig);
        }
        if (this.zzb.isEmpty())
        {
          l = this.zzc;
          if (l == 0L)
          {
            zzq().zze().zza("First ad exposure time was never set");
            return;
          }
          zza(paramLong - l, localzzig);
          this.zzc = 0L;
        }
        return;
      }
      this.zzb.put(paramString, Integer.valueOf(i));
      return;
    }
    zzq().zze().zza("Call to endAdUnitExposure for unknown ad unit id", paramString);
  }
  
  public final void zza(long paramLong)
  {
    zzig localzzig = zzh().zza(false);
    Iterator localIterator = this.zza.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zza(str, paramLong - ((Long)this.zza.get(str)).longValue(), localzzig);
    }
    if (!this.zza.isEmpty()) {
      zza(paramLong - this.zzc, localzzig);
    }
    zzb(paramLong);
  }
  
  public final void zza(String paramString, long paramLong)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      zzp().zza(new zzc(this, paramString, paramLong));
      return;
    }
    zzq().zze().zza("Ad unit id must be a non-empty string");
  }
  
  public final void zzb(String paramString, long paramLong)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      zzp().zza(new zzb(this, paramString, paramLong));
      return;
    }
    zzq().zze().zza("Ad unit id must be a non-empty string");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */