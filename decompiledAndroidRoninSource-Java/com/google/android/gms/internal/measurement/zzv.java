package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public abstract interface zzv
  extends IInterface
{
  public abstract void beginAdUnitExposure(String paramString, long paramLong)
    throws RemoteException;
  
  public abstract void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void clearMeasurementEnabled(long paramLong)
    throws RemoteException;
  
  public abstract void endAdUnitExposure(String paramString, long paramLong)
    throws RemoteException;
  
  public abstract void generateEventId(zzw paramzzw)
    throws RemoteException;
  
  public abstract void getAppInstanceId(zzw paramzzw)
    throws RemoteException;
  
  public abstract void getCachedAppInstanceId(zzw paramzzw)
    throws RemoteException;
  
  public abstract void getConditionalUserProperties(String paramString1, String paramString2, zzw paramzzw)
    throws RemoteException;
  
  public abstract void getCurrentScreenClass(zzw paramzzw)
    throws RemoteException;
  
  public abstract void getCurrentScreenName(zzw paramzzw)
    throws RemoteException;
  
  public abstract void getGmpAppId(zzw paramzzw)
    throws RemoteException;
  
  public abstract void getMaxUserProperties(String paramString, zzw paramzzw)
    throws RemoteException;
  
  public abstract void getTestFlag(zzw paramzzw, int paramInt)
    throws RemoteException;
  
  public abstract void getUserProperties(String paramString1, String paramString2, boolean paramBoolean, zzw paramzzw)
    throws RemoteException;
  
  public abstract void initForTests(Map paramMap)
    throws RemoteException;
  
  public abstract void initialize(IObjectWrapper paramIObjectWrapper, zzae paramzzae, long paramLong)
    throws RemoteException;
  
  public abstract void isDataCollectionEnabled(zzw paramzzw)
    throws RemoteException;
  
  public abstract void logEvent(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    throws RemoteException;
  
  public abstract void logEventAndBundle(String paramString1, String paramString2, Bundle paramBundle, zzw paramzzw, long paramLong)
    throws RemoteException;
  
  public abstract void logHealthData(int paramInt, String paramString, IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3)
    throws RemoteException;
  
  public abstract void onActivityCreated(IObjectWrapper paramIObjectWrapper, Bundle paramBundle, long paramLong)
    throws RemoteException;
  
  public abstract void onActivityDestroyed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException;
  
  public abstract void onActivityPaused(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException;
  
  public abstract void onActivityResumed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException;
  
  public abstract void onActivitySaveInstanceState(IObjectWrapper paramIObjectWrapper, zzw paramzzw, long paramLong)
    throws RemoteException;
  
  public abstract void onActivityStarted(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException;
  
  public abstract void onActivityStopped(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException;
  
  public abstract void performAction(Bundle paramBundle, zzw paramzzw, long paramLong)
    throws RemoteException;
  
  public abstract void registerOnMeasurementEventListener(zzab paramzzab)
    throws RemoteException;
  
  public abstract void resetAnalyticsData(long paramLong)
    throws RemoteException;
  
  public abstract void setConditionalUserProperty(Bundle paramBundle, long paramLong)
    throws RemoteException;
  
  public abstract void setConsent(Bundle paramBundle, long paramLong)
    throws RemoteException;
  
  public abstract void setConsentThirdParty(Bundle paramBundle, long paramLong)
    throws RemoteException;
  
  public abstract void setCurrentScreen(IObjectWrapper paramIObjectWrapper, String paramString1, String paramString2, long paramLong)
    throws RemoteException;
  
  public abstract void setDataCollectionEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setDefaultEventParameters(Bundle paramBundle)
    throws RemoteException;
  
  public abstract void setEventInterceptor(zzab paramzzab)
    throws RemoteException;
  
  public abstract void setInstanceIdProvider(zzac paramzzac)
    throws RemoteException;
  
  public abstract void setMeasurementEnabled(boolean paramBoolean, long paramLong)
    throws RemoteException;
  
  public abstract void setMinimumSessionDuration(long paramLong)
    throws RemoteException;
  
  public abstract void setSessionTimeoutDuration(long paramLong)
    throws RemoteException;
  
  public abstract void setUserId(String paramString, long paramLong)
    throws RemoteException;
  
  public abstract void setUserProperty(String paramString1, String paramString2, IObjectWrapper paramIObjectWrapper, boolean paramBoolean, long paramLong)
    throws RemoteException;
  
  public abstract void unregisterOnMeasurementEventListener(zzab paramzzab)
    throws RemoteException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */