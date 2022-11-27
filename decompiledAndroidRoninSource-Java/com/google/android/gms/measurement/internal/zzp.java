package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.util.Clock;
import java.util.Iterator;
import java.util.Set;

public final class zzp
{
  private final zzfv zza;
  
  public zzp(zzfv paramzzfv)
  {
    this.zza = paramzzfv;
  }
  
  private final boolean zzc()
  {
    if (!zzd()) {
      return false;
    }
    return this.zza.zzl().currentTimeMillis() - this.zza.zzb().zzw.zza() > this.zza.zza().zza(null, zzat.zzcd);
  }
  
  private final boolean zzd()
  {
    return this.zza.zzb().zzw.zza() > 0L;
  }
  
  final void zza()
  {
    this.zza.zzp().zzc();
    if (!zzd()) {
      return;
    }
    Object localObject;
    if (zzc())
    {
      this.zza.zzb().zzv.zza(null);
      localObject = new Bundle();
      ((Bundle)localObject).putString("source", "(not set)");
      ((Bundle)localObject).putString("medium", "(not set)");
      ((Bundle)localObject).putString("_cis", "intent");
      ((Bundle)localObject).putLong("_cc", 1L);
      this.zza.zzg().zza("auto", "_cmpx", (Bundle)localObject);
    }
    else
    {
      localObject = this.zza.zzb().zzv.zza();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.zza.zzq().zzf().zza("Cache still valid but referrer not found");
      }
      else
      {
        long l = this.zza.zzb().zzw.zza() / 3600000L;
        localObject = Uri.parse((String)localObject);
        Bundle localBundle = new Bundle();
        Pair localPair = new Pair(((Uri)localObject).getPath(), localBundle);
        Iterator localIterator = ((Uri)localObject).getQueryParameterNames().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localBundle.putString(str, ((Uri)localObject).getQueryParameter(str));
        }
        ((Bundle)localPair.second).putLong("_cc", (l - 1L) * 3600000L);
        this.zza.zzg().zza((String)localPair.first, "_cmp", (Bundle)localPair.second);
      }
      this.zza.zzb().zzv.zza(null);
    }
    this.zza.zzb().zzw.zza(0L);
  }
  
  final void zza(String paramString, Bundle paramBundle)
  {
    this.zza.zzp().zzc();
    if (!this.zza.zzaa())
    {
      if ((paramBundle != null) && (!paramBundle.isEmpty()))
      {
        if (paramString != null)
        {
          localObject = paramString;
          if (!paramString.isEmpty()) {}
        }
        else
        {
          localObject = "auto";
        }
        paramString = new Uri.Builder();
        paramString.path((String)localObject);
        Object localObject = paramBundle.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          paramString.appendQueryParameter(str, paramBundle.getString(str));
        }
        paramString = paramString.build().toString();
      }
      else
      {
        paramString = null;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        this.zza.zzb().zzv.zza(paramString);
        this.zza.zzb().zzw.zza(this.zza.zzl().currentTimeMillis());
      }
    }
  }
  
  final void zzb()
  {
    if ((zzd()) && (zzc())) {
      this.zza.zzb().zzv.zza(null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */