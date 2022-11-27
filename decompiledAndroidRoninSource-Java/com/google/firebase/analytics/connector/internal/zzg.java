package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import java.util.Set;

public final class zzg
  implements zza
{
  private AnalyticsConnector.AnalyticsConnectorListener zza;
  private AppMeasurementSdk zzb;
  private zzf zzc;
  
  public zzg(AppMeasurementSdk paramAppMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener paramAnalyticsConnectorListener)
  {
    this.zza = paramAnalyticsConnectorListener;
    this.zzb = paramAppMeasurementSdk;
    paramAppMeasurementSdk = new zzf(this);
    this.zzc = paramAppMeasurementSdk;
    this.zzb.registerOnMeasurementEventListener(paramAppMeasurementSdk);
  }
  
  public final AnalyticsConnector.AnalyticsConnectorListener zza()
  {
    return this.zza;
  }
  
  public final void zza(Set<String> paramSet) {}
  
  public final void zzb() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\analytics\connector\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */