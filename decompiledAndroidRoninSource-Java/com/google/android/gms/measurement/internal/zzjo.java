package com.google.android.gms.measurement.internal;

import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzmj;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

public final class zzjo
  extends zzkj
{
  private String zzb;
  private boolean zzc;
  private long zzd;
  
  zzjo(zzki paramzzki)
  {
    super(paramzzki);
  }
  
  @Deprecated
  private final Pair<String, Boolean> zzb(String paramString)
  {
    zzc();
    long l = zzl().elapsedRealtime();
    if ((this.zzb != null) && (l < this.zzd)) {
      return new Pair(this.zzb, Boolean.valueOf(this.zzc));
    }
    this.zzd = (l + zzs().zze(paramString));
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
    try
    {
      paramString = AdvertisingIdClient.getAdvertisingIdInfo(zzm());
      if (paramString != null)
      {
        this.zzb = paramString.getId();
        this.zzc = paramString.isLimitAdTrackingEnabled();
      }
      if (this.zzb == null) {
        this.zzb = "";
      }
    }
    catch (Exception paramString)
    {
      zzq().zzv().zza("Unable to get advertising id", paramString);
      this.zzb = "";
    }
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
    return new Pair(this.zzb, Boolean.valueOf(this.zzc));
  }
  
  final Pair<String, Boolean> zza(String paramString, zzad paramzzad)
  {
    if ((zzmj.zzb()) && (zzs().zza(zzat.zzci)) && (!paramzzad.zzc())) {
      return new Pair("", Boolean.valueOf(false));
    }
    return zzb(paramString);
  }
  
  @Deprecated
  final String zza(String paramString)
  {
    zzc();
    paramString = (String)zzb(paramString).first;
    MessageDigest localMessageDigest = zzkw.zzh();
    if (localMessageDigest == null) {
      return null;
    }
    return String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, localMessageDigest.digest(paramString.getBytes())) });
  }
  
  protected final boolean zzd()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzjo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */