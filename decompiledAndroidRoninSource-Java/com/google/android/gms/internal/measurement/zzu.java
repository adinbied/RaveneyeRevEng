package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzu
  extends zzc
  implements zzv
{
  public zzu()
  {
    super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
  }
  
  public static zzv asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    if ((localIInterface instanceof zzv)) {
      return (zzv)localIInterface;
    }
    return new zzx(paramIBinder);
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject3 = null;
    Bundle localBundle = null;
    Object localObject9 = null;
    Object localObject10 = null;
    Object localObject11 = null;
    Object localObject12 = null;
    Object localObject13 = null;
    Object localObject14 = null;
    Object localObject15 = null;
    Object localObject1 = null;
    IInterface localIInterface = null;
    Object localObject2 = null;
    Object localObject4 = null;
    switch (paramInt1)
    {
    case 41: 
    default: 
      return false;
    case 45: 
      setConsentThirdParty((Bundle)zzb.zza(paramParcel1, Bundle.CREATOR), paramParcel1.readLong());
      break;
    case 44: 
      setConsent((Bundle)zzb.zza(paramParcel1, Bundle.CREATOR), paramParcel1.readLong());
      break;
    case 43: 
      clearMeasurementEnabled(paramParcel1.readLong());
      break;
    case 42: 
      setDefaultEventParameters((Bundle)zzb.zza(paramParcel1, Bundle.CREATOR));
      break;
    case 40: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject4;
      }
      else
      {
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject1 instanceof zzw)) {
          paramParcel1 = (zzw)localObject1;
        } else {
          paramParcel1 = new zzy(paramParcel1);
        }
      }
      isDataCollectionEnabled(paramParcel1);
      break;
    case 39: 
      setDataCollectionEnabled(zzb.zza(paramParcel1));
      break;
    case 38: 
      localObject1 = paramParcel1.readStrongBinder();
      if (localObject1 == null)
      {
        localObject1 = localObject5;
      }
      else
      {
        localObject2 = ((IBinder)localObject1).queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject2 instanceof zzw)) {
          localObject1 = (zzw)localObject2;
        } else {
          localObject1 = new zzy((IBinder)localObject1);
        }
      }
      getTestFlag((zzw)localObject1, paramParcel1.readInt());
      break;
    case 37: 
      initForTests(zzb.zzb(paramParcel1));
      break;
    case 36: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject6;
      }
      else
      {
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
        if ((localObject1 instanceof zzab)) {
          paramParcel1 = (zzab)localObject1;
        } else {
          paramParcel1 = new zzad(paramParcel1);
        }
      }
      unregisterOnMeasurementEventListener(paramParcel1);
      break;
    case 35: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject7;
      }
      else
      {
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
        if ((localObject1 instanceof zzab)) {
          paramParcel1 = (zzab)localObject1;
        } else {
          paramParcel1 = new zzad(paramParcel1);
        }
      }
      registerOnMeasurementEventListener(paramParcel1);
      break;
    case 34: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject8;
      }
      else
      {
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
        if ((localObject1 instanceof zzab)) {
          paramParcel1 = (zzab)localObject1;
        } else {
          paramParcel1 = new zzad(paramParcel1);
        }
      }
      setEventInterceptor(paramParcel1);
      break;
    case 33: 
      logHealthData(paramParcel1.readInt(), paramParcel1.readString(), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      break;
    case 32: 
      localObject2 = (Bundle)zzb.zza(paramParcel1, Bundle.CREATOR);
      localObject1 = paramParcel1.readStrongBinder();
      if (localObject1 == null)
      {
        localObject1 = localObject3;
      }
      else
      {
        localObject3 = ((IBinder)localObject1).queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject3 instanceof zzw)) {
          localObject1 = (zzw)localObject3;
        } else {
          localObject1 = new zzy((IBinder)localObject1);
        }
      }
      performAction((Bundle)localObject2, (zzw)localObject1, paramParcel1.readLong());
      break;
    case 31: 
      localObject2 = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
      localObject1 = paramParcel1.readStrongBinder();
      if (localObject1 == null)
      {
        localObject1 = localBundle;
      }
      else
      {
        localObject3 = ((IBinder)localObject1).queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject3 instanceof zzw)) {
          localObject1 = (zzw)localObject3;
        } else {
          localObject1 = new zzy((IBinder)localObject1);
        }
      }
      onActivitySaveInstanceState((IObjectWrapper)localObject2, (zzw)localObject1, paramParcel1.readLong());
      break;
    case 30: 
      onActivityResumed(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readLong());
      break;
    case 29: 
      onActivityPaused(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readLong());
      break;
    case 28: 
      onActivityDestroyed(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readLong());
      break;
    case 27: 
      onActivityCreated(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), (Bundle)zzb.zza(paramParcel1, Bundle.CREATOR), paramParcel1.readLong());
      break;
    case 26: 
      onActivityStopped(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readLong());
      break;
    case 25: 
      onActivityStarted(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readLong());
      break;
    case 24: 
      endAdUnitExposure(paramParcel1.readString(), paramParcel1.readLong());
      break;
    case 23: 
      beginAdUnitExposure(paramParcel1.readString(), paramParcel1.readLong());
      break;
    case 22: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject9;
      }
      else
      {
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject1 instanceof zzw)) {
          paramParcel1 = (zzw)localObject1;
        } else {
          paramParcel1 = new zzy(paramParcel1);
        }
      }
      generateEventId(paramParcel1);
      break;
    case 21: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject10;
      }
      else
      {
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject1 instanceof zzw)) {
          paramParcel1 = (zzw)localObject1;
        } else {
          paramParcel1 = new zzy(paramParcel1);
        }
      }
      getGmpAppId(paramParcel1);
      break;
    case 20: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject11;
      }
      else
      {
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject1 instanceof zzw)) {
          paramParcel1 = (zzw)localObject1;
        } else {
          paramParcel1 = new zzy(paramParcel1);
        }
      }
      getAppInstanceId(paramParcel1);
      break;
    case 19: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject12;
      }
      else
      {
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject1 instanceof zzw)) {
          paramParcel1 = (zzw)localObject1;
        } else {
          paramParcel1 = new zzy(paramParcel1);
        }
      }
      getCachedAppInstanceId(paramParcel1);
      break;
    case 18: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject13;
      }
      else
      {
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
        if ((localObject1 instanceof zzac)) {
          paramParcel1 = (zzac)localObject1;
        } else {
          paramParcel1 = new zzaf(paramParcel1);
        }
      }
      setInstanceIdProvider(paramParcel1);
      break;
    case 17: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject14;
      }
      else
      {
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject1 instanceof zzw)) {
          paramParcel1 = (zzw)localObject1;
        } else {
          paramParcel1 = new zzy(paramParcel1);
        }
      }
      getCurrentScreenClass(paramParcel1);
      break;
    case 16: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject15;
      }
      else
      {
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject1 instanceof zzw)) {
          paramParcel1 = (zzw)localObject1;
        } else {
          paramParcel1 = new zzy(paramParcel1);
        }
      }
      getCurrentScreenName(paramParcel1);
      break;
    case 15: 
      setCurrentScreen(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong());
      break;
    case 14: 
      setSessionTimeoutDuration(paramParcel1.readLong());
      break;
    case 13: 
      setMinimumSessionDuration(paramParcel1.readLong());
      break;
    case 12: 
      resetAnalyticsData(paramParcel1.readLong());
      break;
    case 11: 
      setMeasurementEnabled(zzb.zza(paramParcel1), paramParcel1.readLong());
      break;
    case 10: 
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject1;
      }
      else
      {
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject1 instanceof zzw)) {
          paramParcel1 = (zzw)localObject1;
        } else {
          paramParcel1 = new zzy(paramParcel1);
        }
      }
      getConditionalUserProperties((String)localObject2, (String)localObject3, paramParcel1);
      break;
    case 9: 
      clearConditionalUserProperty(paramParcel1.readString(), paramParcel1.readString(), (Bundle)zzb.zza(paramParcel1, Bundle.CREATOR));
      break;
    case 8: 
      setConditionalUserProperty((Bundle)zzb.zza(paramParcel1, Bundle.CREATOR), paramParcel1.readLong());
      break;
    case 7: 
      setUserId(paramParcel1.readString(), paramParcel1.readLong());
      break;
    case 6: 
      localObject1 = paramParcel1.readString();
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = localIInterface;
      }
      else
      {
        localObject2 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject2 instanceof zzw)) {
          paramParcel1 = (zzw)localObject2;
        } else {
          paramParcel1 = new zzy(paramParcel1);
        }
      }
      getMaxUserProperties((String)localObject1, paramParcel1);
      break;
    case 5: 
      localObject1 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      boolean bool = zzb.zza(paramParcel1);
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject2;
      }
      else
      {
        localObject2 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject2 instanceof zzw)) {
          paramParcel1 = (zzw)localObject2;
        } else {
          paramParcel1 = new zzy(paramParcel1);
        }
      }
      getUserProperties((String)localObject1, (String)localObject3, bool, paramParcel1);
      break;
    case 4: 
      setUserProperty(paramParcel1.readString(), paramParcel1.readString(), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), zzb.zza(paramParcel1), paramParcel1.readLong());
      break;
    case 3: 
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localBundle = (Bundle)zzb.zza(paramParcel1, Bundle.CREATOR);
      localObject1 = paramParcel1.readStrongBinder();
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localIInterface = ((IBinder)localObject1).queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localIInterface instanceof zzw)) {
          localObject1 = (zzw)localIInterface;
        } else {
          localObject1 = new zzy((IBinder)localObject1);
        }
      }
      logEventAndBundle((String)localObject2, (String)localObject3, localBundle, (zzw)localObject1, paramParcel1.readLong());
      break;
    case 2: 
      logEvent(paramParcel1.readString(), paramParcel1.readString(), (Bundle)zzb.zza(paramParcel1, Bundle.CREATOR), zzb.zza(paramParcel1), zzb.zza(paramParcel1), paramParcel1.readLong());
      break;
    case 1: 
      initialize(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), (zzae)zzb.zza(paramParcel1, zzae.CREATOR), paramParcel1.readLong());
    }
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */