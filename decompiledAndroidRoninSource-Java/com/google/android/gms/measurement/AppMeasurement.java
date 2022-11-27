package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.measurement.internal.zza;
import com.google.android.gms.measurement.internal.zzfv;
import com.google.android.gms.measurement.internal.zzgs;
import com.google.android.gms.measurement.internal.zzgt;
import com.google.android.gms.measurement.internal.zzgu;
import com.google.android.gms.measurement.internal.zzgv;
import com.google.android.gms.measurement.internal.zzgw;
import com.google.android.gms.measurement.internal.zzgx;
import com.google.android.gms.measurement.internal.zzgy;
import com.google.android.gms.measurement.internal.zzib;
import com.google.android.gms.measurement.internal.zzih;
import com.google.android.gms.measurement.internal.zzkr;
import com.google.android.gms.measurement.internal.zzkw;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Deprecated
public class AppMeasurement
{
  public static final String CRASH_ORIGIN = "crash";
  public static final String FCM_ORIGIN = "fcm";
  public static final String FIAM_ORIGIN = "fiam";
  private static volatile AppMeasurement zza;
  private final zzfv zzb;
  private final zzib zzc;
  private final boolean zzd;
  
  private AppMeasurement(zzfv paramzzfv)
  {
    Preconditions.checkNotNull(paramzzfv);
    this.zzb = paramzzfv;
    this.zzc = null;
    this.zzd = false;
  }
  
  private AppMeasurement(zzib paramzzib)
  {
    Preconditions.checkNotNull(paramzzib);
    this.zzc = paramzzib;
    this.zzb = null;
    this.zzd = true;
  }
  
  @Deprecated
  public static AppMeasurement getInstance(Context paramContext)
  {
    return zza(paramContext, null, null);
  }
  
  private static AppMeasurement zza(Context paramContext, String paramString1, String paramString2)
  {
    if (zza == null) {
      try
      {
        if (zza == null)
        {
          paramString1 = zza(paramContext, null);
          if (paramString1 != null) {
            zza = new AppMeasurement(paramString1);
          } else {
            zza = new AppMeasurement(zzfv.zza(paramContext, new zzae(0L, 0L, true, null, null, null, null), null));
          }
        }
      }
      finally {}
    }
    return zza;
  }
  
  private static zzib zza(Context paramContext, Bundle paramBundle)
  {
    try
    {
      paramBundle = Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
      paramContext = (zzib)paramBundle.getDeclaredMethod("getScionFrontendApiImplementation", new Class[] { Context.class, Bundle.class }).invoke(null, new Object[] { paramContext, null });
      return paramContext;
    }
    catch (ClassNotFoundException|Exception paramContext) {}
    return null;
  }
  
  public void beginAdUnitExposure(String paramString)
  {
    if (this.zzd)
    {
      this.zzc.zza(paramString);
      return;
    }
    this.zzb.zzy().zza(paramString, this.zzb.zzl().elapsedRealtime());
  }
  
  public void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.zzd)
    {
      this.zzc.zzb(paramString1, paramString2, paramBundle);
      return;
    }
    this.zzb.zzg().zzc(paramString1, paramString2, paramBundle);
  }
  
  protected void clearConditionalUserPropertyAs(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (!this.zzd)
    {
      this.zzb.zzg().zza(paramString1, paramString2, paramString3, paramBundle);
      return;
    }
    throw new IllegalStateException("Unexpected call on client side");
  }
  
  public void endAdUnitExposure(String paramString)
  {
    if (this.zzd)
    {
      this.zzc.zzb(paramString);
      return;
    }
    this.zzb.zzy().zzb(paramString, this.zzb.zzl().elapsedRealtime());
  }
  
  public long generateEventId()
  {
    if (this.zzd) {
      return this.zzc.zze();
    }
    return this.zzb.zzh().zzf();
  }
  
  public String getAppInstanceId()
  {
    if (this.zzd) {
      return this.zzc.zzc();
    }
    return this.zzb.zzg().zzag();
  }
  
  public Boolean getBoolean()
  {
    if (this.zzd) {
      return (Boolean)this.zzc.zza(4);
    }
    return this.zzb.zzg().zzab();
  }
  
  public List<ConditionalUserProperty> getConditionalUserProperties(String paramString1, String paramString2)
  {
    if (this.zzd) {
      paramString1 = this.zzc.zza(paramString1, paramString2);
    } else {
      paramString1 = this.zzb.zzg().zza(paramString1, paramString2);
    }
    int i;
    if (paramString1 == null) {
      i = 0;
    } else {
      i = paramString1.size();
    }
    paramString2 = new ArrayList(i);
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext()) {
      paramString2.add(new ConditionalUserProperty((Bundle)paramString1.next()));
    }
    return paramString2;
  }
  
  protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(String paramString1, String paramString2, String paramString3)
  {
    if (!this.zzd)
    {
      paramString2 = this.zzb.zzg().zza(paramString1, paramString2, paramString3);
      int j = 0;
      if (paramString2 == null) {
        i = 0;
      } else {
        i = paramString2.size();
      }
      paramString1 = new ArrayList(i);
      paramString2 = (ArrayList)paramString2;
      int k = paramString2.size();
      int i = j;
      while (i < k)
      {
        paramString3 = paramString2.get(i);
        i += 1;
        paramString1.add(new ConditionalUserProperty((Bundle)paramString3));
      }
      return paramString1;
    }
    throw new IllegalStateException("Unexpected call on client side");
  }
  
  public String getCurrentScreenClass()
  {
    if (this.zzd) {
      return this.zzc.zzb();
    }
    return this.zzb.zzg().zzaj();
  }
  
  public String getCurrentScreenName()
  {
    if (this.zzd) {
      return this.zzc.zza();
    }
    return this.zzb.zzg().zzai();
  }
  
  public Double getDouble()
  {
    if (this.zzd) {
      return (Double)this.zzc.zza(2);
    }
    return this.zzb.zzg().zzaf();
  }
  
  public String getGmpAppId()
  {
    if (this.zzd) {
      return this.zzc.zzd();
    }
    return this.zzb.zzg().zzak();
  }
  
  public Integer getInteger()
  {
    if (this.zzd) {
      return (Integer)this.zzc.zza(3);
    }
    return this.zzb.zzg().zzae();
  }
  
  public Long getLong()
  {
    if (this.zzd) {
      return (Long)this.zzc.zza(1);
    }
    return this.zzb.zzg().zzad();
  }
  
  public int getMaxUserProperties(String paramString)
  {
    if (this.zzd) {
      return this.zzc.zzc(paramString);
    }
    this.zzb.zzg();
    Preconditions.checkNotEmpty(paramString);
    return 25;
  }
  
  public String getString()
  {
    if (this.zzd) {
      return (String)this.zzc.zza(0);
    }
    return this.zzb.zzg().zzac();
  }
  
  protected Map<String, Object> getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.zzd) {
      return this.zzc.zza(paramString1, paramString2, paramBoolean);
    }
    return this.zzb.zzg().zza(paramString1, paramString2, paramBoolean);
  }
  
  public Map<String, Object> getUserProperties(boolean paramBoolean)
  {
    if (this.zzd) {
      return this.zzc.zza(null, null, paramBoolean);
    }
    Object localObject = this.zzb.zzg().zza(paramBoolean);
    ArrayMap localArrayMap = new ArrayMap(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      zzkr localzzkr = (zzkr)((Iterator)localObject).next();
      localArrayMap.put(localzzkr.zza, localzzkr.zza());
    }
    return localArrayMap;
  }
  
  protected Map<String, Object> getUserPropertiesAs(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (!this.zzd) {
      return this.zzb.zzg().zza(paramString1, paramString2, paramString3, paramBoolean);
    }
    throw new IllegalStateException("Unexpected call on client side");
  }
  
  public void logEventInternal(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.zzd)
    {
      this.zzc.zza(paramString1, paramString2, paramBundle);
      return;
    }
    this.zzb.zzg().zza(paramString1, paramString2, paramBundle);
  }
  
  public void logEventInternalNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    if (this.zzd)
    {
      this.zzc.zza(paramString1, paramString2, paramBundle, paramLong);
      return;
    }
    this.zzb.zzg().zza(paramString1, paramString2, paramBundle, true, false, paramLong);
  }
  
  public void registerOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    if (this.zzd)
    {
      this.zzc.zza(paramOnEventListener);
      return;
    }
    this.zzb.zzg().zza(paramOnEventListener);
  }
  
  public void setConditionalUserProperty(ConditionalUserProperty paramConditionalUserProperty)
  {
    Preconditions.checkNotNull(paramConditionalUserProperty);
    if (this.zzd)
    {
      this.zzc.zza(paramConditionalUserProperty.zza());
      return;
    }
    this.zzb.zzg().zza(paramConditionalUserProperty.zza());
  }
  
  protected void setConditionalUserPropertyAs(ConditionalUserProperty paramConditionalUserProperty)
  {
    Preconditions.checkNotNull(paramConditionalUserProperty);
    if (!this.zzd)
    {
      this.zzb.zzg().zzb(paramConditionalUserProperty.zza());
      return;
    }
    throw new IllegalStateException("Unexpected call on client side");
  }
  
  public void setEventInterceptor(EventInterceptor paramEventInterceptor)
  {
    if (this.zzd)
    {
      this.zzc.zza(paramEventInterceptor);
      return;
    }
    this.zzb.zzg().zza(paramEventInterceptor);
  }
  
  @Deprecated
  public void setMeasurementEnabled(boolean paramBoolean)
  {
    if (this.zzd)
    {
      this.zzc.zza(Boolean.valueOf(paramBoolean));
      return;
    }
    this.zzb.zzg().zza(Boolean.valueOf(paramBoolean));
  }
  
  public void setUserPropertyInternal(String paramString1, String paramString2, Object paramObject)
  {
    Preconditions.checkNotEmpty(paramString1);
    if (this.zzd)
    {
      this.zzc.zza(paramString1, paramString2, paramObject);
      return;
    }
    this.zzb.zzg().zza(paramString1, paramString2, paramObject, true);
  }
  
  public void unregisterOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    if (this.zzd)
    {
      this.zzc.zzb(paramOnEventListener);
      return;
    }
    this.zzb.zzg().zzb(paramOnEventListener);
  }
  
  public static class ConditionalUserProperty
  {
    public boolean mActive;
    public String mAppId;
    public long mCreationTimestamp;
    public String mExpiredEventName;
    public Bundle mExpiredEventParams;
    public String mName;
    public String mOrigin;
    public long mTimeToLive;
    public String mTimedOutEventName;
    public Bundle mTimedOutEventParams;
    public String mTriggerEventName;
    public long mTriggerTimeout;
    public String mTriggeredEventName;
    public Bundle mTriggeredEventParams;
    public long mTriggeredTimestamp;
    public Object mValue;
    
    public ConditionalUserProperty() {}
    
    ConditionalUserProperty(Bundle paramBundle)
    {
      Preconditions.checkNotNull(paramBundle);
      this.mAppId = ((String)zzgt.zza(paramBundle, "app_id", String.class, null));
      this.mOrigin = ((String)zzgt.zza(paramBundle, "origin", String.class, null));
      this.mName = ((String)zzgt.zza(paramBundle, "name", String.class, null));
      this.mValue = zzgt.zza(paramBundle, "value", Object.class, null);
      this.mTriggerEventName = ((String)zzgt.zza(paramBundle, "trigger_event_name", String.class, null));
      Long localLong = Long.valueOf(0L);
      this.mTriggerTimeout = ((Long)zzgt.zza(paramBundle, "trigger_timeout", Long.class, localLong)).longValue();
      this.mTimedOutEventName = ((String)zzgt.zza(paramBundle, "timed_out_event_name", String.class, null));
      this.mTimedOutEventParams = ((Bundle)zzgt.zza(paramBundle, "timed_out_event_params", Bundle.class, null));
      this.mTriggeredEventName = ((String)zzgt.zza(paramBundle, "triggered_event_name", String.class, null));
      this.mTriggeredEventParams = ((Bundle)zzgt.zza(paramBundle, "triggered_event_params", Bundle.class, null));
      this.mTimeToLive = ((Long)zzgt.zza(paramBundle, "time_to_live", Long.class, localLong)).longValue();
      this.mExpiredEventName = ((String)zzgt.zza(paramBundle, "expired_event_name", String.class, null));
      this.mExpiredEventParams = ((Bundle)zzgt.zza(paramBundle, "expired_event_params", Bundle.class, null));
      this.mActive = ((Boolean)zzgt.zza(paramBundle, "active", Boolean.class, Boolean.valueOf(false))).booleanValue();
      this.mCreationTimestamp = ((Long)zzgt.zza(paramBundle, "creation_timestamp", Long.class, localLong)).longValue();
      this.mTriggeredTimestamp = ((Long)zzgt.zza(paramBundle, "triggered_timestamp", Long.class, localLong)).longValue();
    }
    
    public ConditionalUserProperty(ConditionalUserProperty paramConditionalUserProperty)
    {
      Preconditions.checkNotNull(paramConditionalUserProperty);
      this.mAppId = paramConditionalUserProperty.mAppId;
      this.mOrigin = paramConditionalUserProperty.mOrigin;
      this.mCreationTimestamp = paramConditionalUserProperty.mCreationTimestamp;
      this.mName = paramConditionalUserProperty.mName;
      Object localObject = paramConditionalUserProperty.mValue;
      if (localObject != null)
      {
        localObject = zzih.zza(localObject);
        this.mValue = localObject;
        if (localObject == null) {
          this.mValue = paramConditionalUserProperty.mValue;
        }
      }
      this.mActive = paramConditionalUserProperty.mActive;
      this.mTriggerEventName = paramConditionalUserProperty.mTriggerEventName;
      this.mTriggerTimeout = paramConditionalUserProperty.mTriggerTimeout;
      this.mTimedOutEventName = paramConditionalUserProperty.mTimedOutEventName;
      if (paramConditionalUserProperty.mTimedOutEventParams != null) {
        this.mTimedOutEventParams = new Bundle(paramConditionalUserProperty.mTimedOutEventParams);
      }
      this.mTriggeredEventName = paramConditionalUserProperty.mTriggeredEventName;
      if (paramConditionalUserProperty.mTriggeredEventParams != null) {
        this.mTriggeredEventParams = new Bundle(paramConditionalUserProperty.mTriggeredEventParams);
      }
      this.mTriggeredTimestamp = paramConditionalUserProperty.mTriggeredTimestamp;
      this.mTimeToLive = paramConditionalUserProperty.mTimeToLive;
      this.mExpiredEventName = paramConditionalUserProperty.mExpiredEventName;
      if (paramConditionalUserProperty.mExpiredEventParams != null) {
        this.mExpiredEventParams = new Bundle(paramConditionalUserProperty.mExpiredEventParams);
      }
    }
    
    final Bundle zza()
    {
      Bundle localBundle = new Bundle();
      Object localObject = this.mAppId;
      if (localObject != null) {
        localBundle.putString("app_id", (String)localObject);
      }
      localObject = this.mOrigin;
      if (localObject != null) {
        localBundle.putString("origin", (String)localObject);
      }
      localObject = this.mName;
      if (localObject != null) {
        localBundle.putString("name", (String)localObject);
      }
      localObject = this.mValue;
      if (localObject != null) {
        zzgt.zza(localBundle, localObject);
      }
      localObject = this.mTriggerEventName;
      if (localObject != null) {
        localBundle.putString("trigger_event_name", (String)localObject);
      }
      localBundle.putLong("trigger_timeout", this.mTriggerTimeout);
      localObject = this.mTimedOutEventName;
      if (localObject != null) {
        localBundle.putString("timed_out_event_name", (String)localObject);
      }
      localObject = this.mTimedOutEventParams;
      if (localObject != null) {
        localBundle.putBundle("timed_out_event_params", (Bundle)localObject);
      }
      localObject = this.mTriggeredEventName;
      if (localObject != null) {
        localBundle.putString("triggered_event_name", (String)localObject);
      }
      localObject = this.mTriggeredEventParams;
      if (localObject != null) {
        localBundle.putBundle("triggered_event_params", (Bundle)localObject);
      }
      localBundle.putLong("time_to_live", this.mTimeToLive);
      localObject = this.mExpiredEventName;
      if (localObject != null) {
        localBundle.putString("expired_event_name", (String)localObject);
      }
      localObject = this.mExpiredEventParams;
      if (localObject != null) {
        localBundle.putBundle("expired_event_params", (Bundle)localObject);
      }
      localBundle.putLong("creation_timestamp", this.mCreationTimestamp);
      localBundle.putBoolean("active", this.mActive);
      localBundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
      return localBundle;
    }
  }
  
  public static final class Event
    extends zzgs
  {
    public static final String AD_REWARD = "_ar";
    public static final String APP_EXCEPTION = "_ae";
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
  
  public static final class Param
    extends zzgv
  {
    public static final String FATAL = "fatal";
    public static final String TIMESTAMP = "timestamp";
    public static final String TYPE = "type";
  }
  
  public static final class UserProperty
    extends zzgu
  {
    public static final String FIREBASE_LAST_NOTIFICATION = "_ln";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\AppMeasurement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */