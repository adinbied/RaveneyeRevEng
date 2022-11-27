package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.internal.zzgw;
import com.google.android.gms.measurement.internal.zzgx;
import java.util.List;
import java.util.Map;

public class AppMeasurementSdk
{
  private final zzag zza;
  
  public AppMeasurementSdk(zzag paramzzag)
  {
    this.zza = paramzzag;
  }
  
  public static AppMeasurementSdk getInstance(Context paramContext)
  {
    return zzag.zza(paramContext).zza();
  }
  
  public static AppMeasurementSdk getInstance(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    return zzag.zza(paramContext, paramString1, paramString2, paramString3, paramBundle).zza();
  }
  
  public void beginAdUnitExposure(String paramString)
  {
    this.zza.zzb(paramString);
  }
  
  public void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.zza.zzb(paramString1, paramString2, paramBundle);
  }
  
  public void endAdUnitExposure(String paramString)
  {
    this.zza.zzc(paramString);
  }
  
  public long generateEventId()
  {
    return this.zza.zze();
  }
  
  public String getAppIdOrigin()
  {
    return this.zza.zzi();
  }
  
  public String getAppInstanceId()
  {
    return this.zza.zzd();
  }
  
  public List<Bundle> getConditionalUserProperties(String paramString1, String paramString2)
  {
    return this.zza.zzb(paramString1, paramString2);
  }
  
  public String getCurrentScreenClass()
  {
    return this.zza.zzg();
  }
  
  public String getCurrentScreenName()
  {
    return this.zza.zzf();
  }
  
  public String getGmpAppId()
  {
    return this.zza.zzc();
  }
  
  public int getMaxUserProperties(String paramString)
  {
    return this.zza.zzd(paramString);
  }
  
  public Map<String, Object> getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
  {
    return this.zza.zza(paramString1, paramString2, paramBoolean);
  }
  
  public void logEvent(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.zza.zza(paramString1, paramString2, paramBundle);
  }
  
  public void logEventNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    this.zza.zza(paramString1, paramString2, paramBundle, paramLong);
  }
  
  public void performAction(Bundle paramBundle)
  {
    this.zza.zza(paramBundle, false);
  }
  
  public Bundle performActionWithResponse(Bundle paramBundle)
  {
    return this.zza.zza(paramBundle, true);
  }
  
  public void registerOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    this.zza.zza(paramOnEventListener);
  }
  
  public void setConditionalUserProperty(Bundle paramBundle)
  {
    this.zza.zza(paramBundle);
  }
  
  public void setConsent(Bundle paramBundle)
  {
    this.zza.zzb(paramBundle);
  }
  
  public void setCurrentScreen(Activity paramActivity, String paramString1, String paramString2)
  {
    this.zza.zza(paramActivity, paramString1, paramString2);
  }
  
  public void setEventInterceptor(EventInterceptor paramEventInterceptor)
  {
    this.zza.zza(paramEventInterceptor);
  }
  
  public void setMeasurementEnabled(Boolean paramBoolean)
  {
    this.zza.zza(paramBoolean);
  }
  
  public void setMeasurementEnabled(boolean paramBoolean)
  {
    this.zza.zza(Boolean.valueOf(paramBoolean));
  }
  
  public void setUserProperty(String paramString1, String paramString2, Object paramObject)
  {
    this.zza.zza(paramString1, paramString2, paramObject);
  }
  
  public void unregisterOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    this.zza.zzb(paramOnEventListener);
  }
  
  public final void zza(boolean paramBoolean)
  {
    this.zza.zza(paramBoolean);
  }
  
  public static final class ConditionalUserProperty
  {
    public static final String ACTIVE = "active";
    public static final String CREATION_TIMESTAMP = "creation_timestamp";
    public static final String EXPIRED_EVENT_NAME = "expired_event_name";
    public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";
    public static final String NAME = "name";
    public static final String ORIGIN = "origin";
    public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";
    public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";
    public static final String TIME_TO_LIVE = "time_to_live";
    public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";
    public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";
    public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";
    public static final String TRIGGER_EVENT_NAME = "trigger_event_name";
    public static final String TRIGGER_TIMEOUT = "trigger_timeout";
    public static final String VALUE = "value";
  }
  
  public static abstract interface EventInterceptor
    extends zzgx
  {
    public abstract void interceptEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }
  
  public static abstract interface OnEventListener
    extends zzgw
  {
    public abstract void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\api\AppMeasurementSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */