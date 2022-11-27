package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AnalyticsConnectorImpl
  implements AnalyticsConnector
{
  private static volatile AnalyticsConnector zzb;
  final Map<String, com.google.firebase.analytics.connector.internal.zza> zza;
  private final AppMeasurementSdk zzc;
  
  private AnalyticsConnectorImpl(AppMeasurementSdk paramAppMeasurementSdk)
  {
    Preconditions.checkNotNull(paramAppMeasurementSdk);
    this.zzc = paramAppMeasurementSdk;
    this.zza = new ConcurrentHashMap();
  }
  
  public static AnalyticsConnector getInstance()
  {
    return getInstance(FirebaseApp.getInstance());
  }
  
  public static AnalyticsConnector getInstance(FirebaseApp paramFirebaseApp)
  {
    return (AnalyticsConnector)paramFirebaseApp.get(AnalyticsConnector.class);
  }
  
  public static AnalyticsConnector getInstance(FirebaseApp paramFirebaseApp, Context paramContext, Subscriber paramSubscriber)
  {
    Preconditions.checkNotNull(paramFirebaseApp);
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramSubscriber);
    Preconditions.checkNotNull(paramContext.getApplicationContext());
    if (zzb == null) {
      try
      {
        if (zzb == null)
        {
          Bundle localBundle = new Bundle(1);
          if (paramFirebaseApp.isDefaultApp())
          {
            paramSubscriber.subscribe(DataCollectionDefaultChange.class, zza.zza, zzb.zza);
            localBundle.putBoolean("dataCollectionDefaultEnabled", paramFirebaseApp.isDataCollectionDefaultEnabled());
          }
          zzb = new AnalyticsConnectorImpl(zzag.zza(paramContext, null, null, null, localBundle).zza());
        }
      }
      finally {}
    }
    return zzb;
  }
  
  private final boolean zza(String paramString)
  {
    return (!paramString.isEmpty()) && (this.zza.containsKey(paramString)) && (this.zza.get(paramString) != null);
  }
  
  public void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
  {
    if ((paramString2 != null) && (!com.google.firebase.analytics.connector.internal.zzb.zza(paramString2, paramBundle))) {
      return;
    }
    this.zzc.clearConditionalUserProperty(paramString1, paramString2, paramBundle);
  }
  
  public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = this.zzc.getConditionalUserProperties(paramString1, paramString2).iterator();
    while (paramString1.hasNext()) {
      localArrayList.add(com.google.firebase.analytics.connector.internal.zzb.zza((Bundle)paramString1.next()));
    }
    return localArrayList;
  }
  
  public int getMaxUserProperties(String paramString)
  {
    return this.zzc.getMaxUserProperties(paramString);
  }
  
  public Map<String, Object> getUserProperties(boolean paramBoolean)
  {
    return this.zzc.getUserProperties(null, null, paramBoolean);
  }
  
  public void logEvent(String paramString1, String paramString2, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (!com.google.firebase.analytics.connector.internal.zzb.zza(paramString1)) {
      return;
    }
    if (!com.google.firebase.analytics.connector.internal.zzb.zza(paramString2, localBundle)) {
      return;
    }
    if (!com.google.firebase.analytics.connector.internal.zzb.zza(paramString1, paramString2, localBundle)) {
      return;
    }
    com.google.firebase.analytics.connector.internal.zzb.zzb(paramString1, paramString2, localBundle);
    this.zzc.logEvent(paramString1, paramString2, localBundle);
  }
  
  public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(final String paramString, AnalyticsConnector.AnalyticsConnectorListener paramAnalyticsConnectorListener)
  {
    Preconditions.checkNotNull(paramAnalyticsConnectorListener);
    if (!com.google.firebase.analytics.connector.internal.zzb.zza(paramString)) {
      return null;
    }
    if (zza(paramString)) {
      return null;
    }
    AppMeasurementSdk localAppMeasurementSdk = this.zzc;
    if ("fiam".equals(paramString)) {
      paramAnalyticsConnectorListener = new zze(localAppMeasurementSdk, paramAnalyticsConnectorListener);
    } else if ((!"crash".equals(paramString)) && (!"clx".equals(paramString))) {
      paramAnalyticsConnectorListener = null;
    } else {
      paramAnalyticsConnectorListener = new zzg(localAppMeasurementSdk, paramAnalyticsConnectorListener);
    }
    if (paramAnalyticsConnectorListener != null)
    {
      this.zza.put(paramString, paramAnalyticsConnectorListener);
      new AnalyticsConnector.AnalyticsConnectorHandle()
      {
        public void registerEventNames(Set<String> paramAnonymousSet)
        {
          if ((AnalyticsConnectorImpl.zza(AnalyticsConnectorImpl.this, paramString)) && (paramString.equals("fiam")) && (paramAnonymousSet != null))
          {
            if (paramAnonymousSet.isEmpty()) {
              return;
            }
            ((com.google.firebase.analytics.connector.internal.zza)AnalyticsConnectorImpl.this.zza.get(paramString)).zza(paramAnonymousSet);
          }
        }
        
        public void unregister()
        {
          if (!AnalyticsConnectorImpl.zza(AnalyticsConnectorImpl.this, paramString)) {
            return;
          }
          AnalyticsConnector.AnalyticsConnectorListener localAnalyticsConnectorListener = ((com.google.firebase.analytics.connector.internal.zza)AnalyticsConnectorImpl.this.zza.get(paramString)).zza();
          if (localAnalyticsConnectorListener != null) {
            localAnalyticsConnectorListener.onMessageTriggered(0, null);
          }
          AnalyticsConnectorImpl.this.zza.remove(paramString);
        }
        
        public void unregisterEventNames()
        {
          if (AnalyticsConnectorImpl.zza(AnalyticsConnectorImpl.this, paramString))
          {
            if (!paramString.equals("fiam")) {
              return;
            }
            ((com.google.firebase.analytics.connector.internal.zza)AnalyticsConnectorImpl.this.zza.get(paramString)).zzb();
          }
        }
      };
    }
    return null;
  }
  
  public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty paramConditionalUserProperty)
  {
    if (!com.google.firebase.analytics.connector.internal.zzb.zza(paramConditionalUserProperty)) {
      return;
    }
    this.zzc.setConditionalUserProperty(com.google.firebase.analytics.connector.internal.zzb.zzb(paramConditionalUserProperty));
  }
  
  public void setUserProperty(String paramString1, String paramString2, Object paramObject)
  {
    if (!com.google.firebase.analytics.connector.internal.zzb.zza(paramString1)) {
      return;
    }
    if (!com.google.firebase.analytics.connector.internal.zzb.zza(paramString1, paramString2)) {
      return;
    }
    this.zzc.setUserProperty(paramString1, paramString2, paramObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\analytics\connector\AnalyticsConnectorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */