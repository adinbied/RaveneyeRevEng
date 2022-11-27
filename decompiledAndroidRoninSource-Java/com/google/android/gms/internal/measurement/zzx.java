package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public final class zzx
  extends zza
  implements zzv
{
  zzx(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
  }
  
  public final void beginAdUnitExposure(String paramString, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeString(paramString);
    localParcel.writeLong(paramLong);
    zzb(23, localParcel);
  }
  
  public final void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzb.zza(localParcel, paramBundle);
    zzb(9, localParcel);
  }
  
  public final void clearMeasurementEnabled(long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeLong(paramLong);
    zzb(43, localParcel);
  }
  
  public final void endAdUnitExposure(String paramString, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeString(paramString);
    localParcel.writeLong(paramLong);
    zzb(24, localParcel);
  }
  
  public final void generateEventId(zzw paramzzw)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzw);
    zzb(22, localParcel);
  }
  
  public final void getAppInstanceId(zzw paramzzw)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzw);
    zzb(20, localParcel);
  }
  
  public final void getCachedAppInstanceId(zzw paramzzw)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzw);
    zzb(19, localParcel);
  }
  
  public final void getConditionalUserProperties(String paramString1, String paramString2, zzw paramzzw)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzb.zza(localParcel, paramzzw);
    zzb(10, localParcel);
  }
  
  public final void getCurrentScreenClass(zzw paramzzw)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzw);
    zzb(17, localParcel);
  }
  
  public final void getCurrentScreenName(zzw paramzzw)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzw);
    zzb(16, localParcel);
  }
  
  public final void getGmpAppId(zzw paramzzw)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzw);
    zzb(21, localParcel);
  }
  
  public final void getMaxUserProperties(String paramString, zzw paramzzw)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeString(paramString);
    zzb.zza(localParcel, paramzzw);
    zzb(6, localParcel);
  }
  
  public final void getTestFlag(zzw paramzzw, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzw);
    localParcel.writeInt(paramInt);
    zzb(38, localParcel);
  }
  
  public final void getUserProperties(String paramString1, String paramString2, boolean paramBoolean, zzw paramzzw)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzb.zza(localParcel, paramBoolean);
    zzb.zza(localParcel, paramzzw);
    zzb(5, localParcel);
  }
  
  public final void initForTests(Map paramMap)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeMap(paramMap);
    zzb(37, localParcel);
  }
  
  public final void initialize(IObjectWrapper paramIObjectWrapper, zzae paramzzae, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramIObjectWrapper);
    zzb.zza(localParcel, paramzzae);
    localParcel.writeLong(paramLong);
    zzb(1, localParcel);
  }
  
  public final void isDataCollectionEnabled(zzw paramzzw)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzw);
    zzb(40, localParcel);
  }
  
  public final void logEvent(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzb.zza(localParcel, paramBundle);
    zzb.zza(localParcel, paramBoolean1);
    zzb.zza(localParcel, paramBoolean2);
    localParcel.writeLong(paramLong);
    zzb(2, localParcel);
  }
  
  public final void logEventAndBundle(String paramString1, String paramString2, Bundle paramBundle, zzw paramzzw, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzb.zza(localParcel, paramBundle);
    zzb.zza(localParcel, paramzzw);
    localParcel.writeLong(paramLong);
    zzb(3, localParcel);
  }
  
  public final void logHealthData(int paramInt, String paramString, IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeInt(paramInt);
    localParcel.writeString(paramString);
    zzb.zza(localParcel, paramIObjectWrapper1);
    zzb.zza(localParcel, paramIObjectWrapper2);
    zzb.zza(localParcel, paramIObjectWrapper3);
    zzb(33, localParcel);
  }
  
  public final void onActivityCreated(IObjectWrapper paramIObjectWrapper, Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramIObjectWrapper);
    zzb.zza(localParcel, paramBundle);
    localParcel.writeLong(paramLong);
    zzb(27, localParcel);
  }
  
  public final void onActivityDestroyed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramIObjectWrapper);
    localParcel.writeLong(paramLong);
    zzb(28, localParcel);
  }
  
  public final void onActivityPaused(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramIObjectWrapper);
    localParcel.writeLong(paramLong);
    zzb(29, localParcel);
  }
  
  public final void onActivityResumed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramIObjectWrapper);
    localParcel.writeLong(paramLong);
    zzb(30, localParcel);
  }
  
  public final void onActivitySaveInstanceState(IObjectWrapper paramIObjectWrapper, zzw paramzzw, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramIObjectWrapper);
    zzb.zza(localParcel, paramzzw);
    localParcel.writeLong(paramLong);
    zzb(31, localParcel);
  }
  
  public final void onActivityStarted(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramIObjectWrapper);
    localParcel.writeLong(paramLong);
    zzb(25, localParcel);
  }
  
  public final void onActivityStopped(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramIObjectWrapper);
    localParcel.writeLong(paramLong);
    zzb(26, localParcel);
  }
  
  public final void performAction(Bundle paramBundle, zzw paramzzw, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramBundle);
    zzb.zza(localParcel, paramzzw);
    localParcel.writeLong(paramLong);
    zzb(32, localParcel);
  }
  
  public final void registerOnMeasurementEventListener(zzab paramzzab)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzab);
    zzb(35, localParcel);
  }
  
  public final void resetAnalyticsData(long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeLong(paramLong);
    zzb(12, localParcel);
  }
  
  public final void setConditionalUserProperty(Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramBundle);
    localParcel.writeLong(paramLong);
    zzb(8, localParcel);
  }
  
  public final void setConsent(Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramBundle);
    localParcel.writeLong(paramLong);
    zzb(44, localParcel);
  }
  
  public final void setConsentThirdParty(Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramBundle);
    localParcel.writeLong(paramLong);
    zzb(45, localParcel);
  }
  
  public final void setCurrentScreen(IObjectWrapper paramIObjectWrapper, String paramString1, String paramString2, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeLong(paramLong);
    zzb(15, localParcel);
  }
  
  public final void setDataCollectionEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramBoolean);
    zzb(39, localParcel);
  }
  
  public final void setDefaultEventParameters(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramBundle);
    zzb(42, localParcel);
  }
  
  public final void setEventInterceptor(zzab paramzzab)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzab);
    zzb(34, localParcel);
  }
  
  public final void setInstanceIdProvider(zzac paramzzac)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzac);
    zzb(18, localParcel);
  }
  
  public final void setMeasurementEnabled(boolean paramBoolean, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramBoolean);
    localParcel.writeLong(paramLong);
    zzb(11, localParcel);
  }
  
  public final void setMinimumSessionDuration(long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeLong(paramLong);
    zzb(13, localParcel);
  }
  
  public final void setSessionTimeoutDuration(long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeLong(paramLong);
    zzb(14, localParcel);
  }
  
  public final void setUserId(String paramString, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeString(paramString);
    localParcel.writeLong(paramLong);
    zzb(7, localParcel);
  }
  
  public final void setUserProperty(String paramString1, String paramString2, IObjectWrapper paramIObjectWrapper, boolean paramBoolean, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzb.zza(localParcel, paramIObjectWrapper);
    zzb.zza(localParcel, paramBoolean);
    localParcel.writeLong(paramLong);
    zzb(4, localParcel);
  }
  
  public final void unregisterOnMeasurementEventListener(zzab paramzzab)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramzzab);
    zzb(36, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */