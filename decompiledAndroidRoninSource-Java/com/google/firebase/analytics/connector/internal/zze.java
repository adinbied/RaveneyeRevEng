package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class zze
  implements zza
{
  Set<String> zza;
  private AnalyticsConnector.AnalyticsConnectorListener zzb;
  private AppMeasurementSdk zzc;
  private zzd zzd;
  
  public zze(AppMeasurementSdk paramAppMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener paramAnalyticsConnectorListener)
  {
    this.zzb = paramAnalyticsConnectorListener;
    this.zzc = paramAppMeasurementSdk;
    paramAppMeasurementSdk = new zzd(this);
    this.zzd = paramAppMeasurementSdk;
    this.zzc.registerOnMeasurementEventListener(paramAppMeasurementSdk);
    this.zza = new HashSet();
  }
  
  public final AnalyticsConnector.AnalyticsConnectorListener zza()
  {
    return this.zzb;
  }
  
  public final void zza(Set<String> paramSet)
  {
    this.zza.clear();
    Set localSet = this.zza;
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (localHashSet.size() >= 50) {
        break;
      }
      if ((zzb.zzd(str)) && (zzb.zzc(str))) {
        localHashSet.add(zzb.zzf(str));
      }
    }
    localSet.addAll(localHashSet);
  }
  
  public final void zzb()
  {
    this.zza.clear();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\analytics\connector\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */