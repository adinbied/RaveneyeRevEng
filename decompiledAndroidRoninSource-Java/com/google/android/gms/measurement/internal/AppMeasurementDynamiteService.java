package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzab;
import com.google.android.gms.internal.measurement.zzac;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzmj;
import com.google.android.gms.internal.measurement.zzu;
import com.google.android.gms.internal.measurement.zzw;
import java.util.Map;

public class AppMeasurementDynamiteService
  extends zzu
{
  zzfv zza = null;
  private Map<Integer, zzgw> zzb = new ArrayMap();
  
  private final void zza()
  {
    if (this.zza != null) {
      return;
    }
    throw new IllegalStateException("Attempting to perform action before initialize.");
  }
  
  private final void zza(zzw paramzzw, String paramString)
  {
    this.zza.zzh().zza(paramzzw, paramString);
  }
  
  public void beginAdUnitExposure(String paramString, long paramLong)
    throws RemoteException
  {
    zza();
    this.zza.zzy().zza(paramString, paramLong);
  }
  
  public void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    zza();
    this.zza.zzg().zzc(paramString1, paramString2, paramBundle);
  }
  
  public void clearMeasurementEnabled(long paramLong)
    throws RemoteException
  {
    zza();
    this.zza.zzg().zza(null);
  }
  
  public void endAdUnitExposure(String paramString, long paramLong)
    throws RemoteException
  {
    zza();
    this.zza.zzy().zzb(paramString, paramLong);
  }
  
  public void generateEventId(zzw paramzzw)
    throws RemoteException
  {
    zza();
    long l = this.zza.zzh().zzf();
    this.zza.zzh().zza(paramzzw, l);
  }
  
  public void getAppInstanceId(zzw paramzzw)
    throws RemoteException
  {
    zza();
    this.zza.zzp().zza(new zzh(this, paramzzw));
  }
  
  public void getCachedAppInstanceId(zzw paramzzw)
    throws RemoteException
  {
    zza();
    zza(paramzzw, this.zza.zzg().zzag());
  }
  
  public void getConditionalUserProperties(String paramString1, String paramString2, zzw paramzzw)
    throws RemoteException
  {
    zza();
    this.zza.zzp().zza(new zzl(this, paramzzw, paramString1, paramString2));
  }
  
  public void getCurrentScreenClass(zzw paramzzw)
    throws RemoteException
  {
    zza();
    zza(paramzzw, this.zza.zzg().zzaj());
  }
  
  public void getCurrentScreenName(zzw paramzzw)
    throws RemoteException
  {
    zza();
    zza(paramzzw, this.zza.zzg().zzai());
  }
  
  public void getGmpAppId(zzw paramzzw)
    throws RemoteException
  {
    zza();
    zza(paramzzw, this.zza.zzg().zzak());
  }
  
  public void getMaxUserProperties(String paramString, zzw paramzzw)
    throws RemoteException
  {
    zza();
    this.zza.zzg();
    Preconditions.checkNotEmpty(paramString);
    this.zza.zzh().zza(paramzzw, 25);
  }
  
  public void getTestFlag(zzw paramzzw, int paramInt)
    throws RemoteException
  {
    zza();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            this.zza.zzh().zza(paramzzw, this.zza.zzg().zzab().booleanValue());
            return;
          }
          this.zza.zzh().zza(paramzzw, this.zza.zzg().zzae().intValue());
          return;
        }
        zzkw localzzkw = this.zza.zzh();
        double d = this.zza.zzg().zzaf().doubleValue();
        Bundle localBundle = new Bundle();
        localBundle.putDouble("r", d);
        try
        {
          paramzzw.zza(localBundle);
          return;
        }
        catch (RemoteException paramzzw)
        {
          localzzkw.zzy.zzq().zzh().zza("Error returning double value to wrapper", paramzzw);
          return;
        }
      }
      this.zza.zzh().zza(paramzzw, this.zza.zzg().zzad().longValue());
      return;
    }
    this.zza.zzh().zza(paramzzw, this.zza.zzg().zzac());
  }
  
  public void getUserProperties(String paramString1, String paramString2, boolean paramBoolean, zzw paramzzw)
    throws RemoteException
  {
    zza();
    this.zza.zzp().zza(new zzi(this, paramzzw, paramString1, paramString2, paramBoolean));
  }
  
  public void initForTests(Map paramMap)
    throws RemoteException
  {
    zza();
  }
  
  public void initialize(IObjectWrapper paramIObjectWrapper, zzae paramzzae, long paramLong)
    throws RemoteException
  {
    paramIObjectWrapper = (Context)ObjectWrapper.unwrap(paramIObjectWrapper);
    zzfv localzzfv = this.zza;
    if (localzzfv == null)
    {
      this.zza = zzfv.zza(paramIObjectWrapper, paramzzae, Long.valueOf(paramLong));
      return;
    }
    localzzfv.zzq().zzh().zza("Attempting to initialize multiple times");
  }
  
  public void isDataCollectionEnabled(zzw paramzzw)
    throws RemoteException
  {
    zza();
    this.zza.zzp().zza(new zzk(this, paramzzw));
  }
  
  public void logEvent(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    throws RemoteException
  {
    zza();
    this.zza.zzg().zza(paramString1, paramString2, paramBundle, paramBoolean1, paramBoolean2, paramLong);
  }
  
  public void logEventAndBundle(String paramString1, String paramString2, Bundle paramBundle, zzw paramzzw, long paramLong)
    throws RemoteException
  {
    zza();
    Preconditions.checkNotEmpty(paramString2);
    Bundle localBundle;
    if (paramBundle != null) {
      localBundle = new Bundle(paramBundle);
    } else {
      localBundle = new Bundle();
    }
    localBundle.putString("_o", "app");
    paramString2 = new zzar(paramString2, new zzam(paramBundle), "app", paramLong);
    this.zza.zzp().zza(new zzj(this, paramzzw, paramString2, paramString1));
  }
  
  public void logHealthData(int paramInt, String paramString, IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3)
    throws RemoteException
  {
    zza();
    Object localObject = null;
    if (paramIObjectWrapper1 == null) {
      paramIObjectWrapper1 = null;
    } else {
      paramIObjectWrapper1 = ObjectWrapper.unwrap(paramIObjectWrapper1);
    }
    if (paramIObjectWrapper2 == null) {
      paramIObjectWrapper2 = null;
    } else {
      paramIObjectWrapper2 = ObjectWrapper.unwrap(paramIObjectWrapper2);
    }
    if (paramIObjectWrapper3 == null) {
      paramIObjectWrapper3 = (IObjectWrapper)localObject;
    } else {
      paramIObjectWrapper3 = ObjectWrapper.unwrap(paramIObjectWrapper3);
    }
    this.zza.zzq().zza(paramInt, true, false, paramString, paramIObjectWrapper1, paramIObjectWrapper2, paramIObjectWrapper3);
  }
  
  public void onActivityCreated(IObjectWrapper paramIObjectWrapper, Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    zza();
    zzhz localzzhz = this.zza.zzg().zza;
    if (localzzhz != null)
    {
      this.zza.zzg().zzaa();
      localzzhz.onActivityCreated((Activity)ObjectWrapper.unwrap(paramIObjectWrapper), paramBundle);
    }
  }
  
  public void onActivityDestroyed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    zza();
    zzhz localzzhz = this.zza.zzg().zza;
    if (localzzhz != null)
    {
      this.zza.zzg().zzaa();
      localzzhz.onActivityDestroyed((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    }
  }
  
  public void onActivityPaused(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    zza();
    zzhz localzzhz = this.zza.zzg().zza;
    if (localzzhz != null)
    {
      this.zza.zzg().zzaa();
      localzzhz.onActivityPaused((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    }
  }
  
  public void onActivityResumed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    zza();
    zzhz localzzhz = this.zza.zzg().zza;
    if (localzzhz != null)
    {
      this.zza.zzg().zzaa();
      localzzhz.onActivityResumed((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    }
  }
  
  public void onActivitySaveInstanceState(IObjectWrapper paramIObjectWrapper, zzw paramzzw, long paramLong)
    throws RemoteException
  {
    zza();
    zzhz localzzhz = this.zza.zzg().zza;
    Bundle localBundle = new Bundle();
    if (localzzhz != null)
    {
      this.zza.zzg().zzaa();
      localzzhz.onActivitySaveInstanceState((Activity)ObjectWrapper.unwrap(paramIObjectWrapper), localBundle);
    }
    try
    {
      paramzzw.zza(localBundle);
      return;
    }
    catch (RemoteException paramIObjectWrapper)
    {
      this.zza.zzq().zzh().zza("Error returning bundle value to wrapper", paramIObjectWrapper);
    }
  }
  
  public void onActivityStarted(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    zza();
    zzhz localzzhz = this.zza.zzg().zza;
    if (localzzhz != null)
    {
      this.zza.zzg().zzaa();
      localzzhz.onActivityStarted((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    }
  }
  
  public void onActivityStopped(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    zza();
    zzhz localzzhz = this.zza.zzg().zza;
    if (localzzhz != null)
    {
      this.zza.zzg().zzaa();
      localzzhz.onActivityStopped((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    }
  }
  
  public void performAction(Bundle paramBundle, zzw paramzzw, long paramLong)
    throws RemoteException
  {
    zza();
    paramzzw.zza(null);
  }
  
  public void registerOnMeasurementEventListener(zzab paramzzab)
    throws RemoteException
  {
    zza();
    zzgw localzzgw = (zzgw)this.zzb.get(Integer.valueOf(paramzzab.zza()));
    Object localObject = localzzgw;
    if (localzzgw == null)
    {
      localObject = new zza(paramzzab);
      this.zzb.put(Integer.valueOf(paramzzab.zza()), localObject);
    }
    this.zza.zzg().zza((zzgw)localObject);
  }
  
  public void resetAnalyticsData(long paramLong)
    throws RemoteException
  {
    zza();
    zzgy localzzgy = this.zza.zzg();
    localzzgy.zza(null);
    localzzgy.zzp().zza(new zzhi(localzzgy, paramLong));
  }
  
  public void setConditionalUserProperty(Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    zza();
    if (paramBundle == null)
    {
      this.zza.zzq().zze().zza("Conditional user property must not be null");
      return;
    }
    this.zza.zzg().zza(paramBundle, paramLong);
  }
  
  public void setConsent(Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    zza();
    zzgy localzzgy = this.zza.zzg();
    if ((zzmj.zzb()) && (localzzgy.zzs().zzd(null, zzat.zzcg))) {
      localzzgy.zza(paramBundle, 30, paramLong);
    }
  }
  
  public void setConsentThirdParty(Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    zza();
    zzgy localzzgy = this.zza.zzg();
    if ((zzmj.zzb()) && (localzzgy.zzs().zzd(null, zzat.zzch))) {
      localzzgy.zza(paramBundle, 10, paramLong);
    }
  }
  
  public void setCurrentScreen(IObjectWrapper paramIObjectWrapper, String paramString1, String paramString2, long paramLong)
    throws RemoteException
  {
    zza();
    this.zza.zzu().zza((Activity)ObjectWrapper.unwrap(paramIObjectWrapper), paramString1, paramString2);
  }
  
  public void setDataCollectionEnabled(boolean paramBoolean)
    throws RemoteException
  {
    zza();
    zzgy localzzgy = this.zza.zzg();
    localzzgy.zzv();
    localzzgy.zzp().zza(new zzhw(localzzgy, paramBoolean));
  }
  
  public void setDefaultEventParameters(Bundle paramBundle)
  {
    zza();
    zzgy localzzgy = this.zza.zzg();
    if (paramBundle == null) {
      paramBundle = null;
    } else {
      paramBundle = new Bundle(paramBundle);
    }
    localzzgy.zzp().zza(new zzhb(localzzgy, paramBundle));
  }
  
  public void setEventInterceptor(zzab paramzzab)
    throws RemoteException
  {
    zza();
    zzgy localzzgy = this.zza.zzg();
    paramzzab = new zzb(paramzzab);
    localzzgy.zzv();
    localzzgy.zzp().zza(new zzhl(localzzgy, paramzzab));
  }
  
  public void setInstanceIdProvider(zzac paramzzac)
    throws RemoteException
  {
    zza();
  }
  
  public void setMeasurementEnabled(boolean paramBoolean, long paramLong)
    throws RemoteException
  {
    zza();
    this.zza.zzg().zza(Boolean.valueOf(paramBoolean));
  }
  
  public void setMinimumSessionDuration(long paramLong)
    throws RemoteException
  {
    zza();
    zzgy localzzgy = this.zza.zzg();
    localzzgy.zzp().zza(new zzhf(localzzgy, paramLong));
  }
  
  public void setSessionTimeoutDuration(long paramLong)
    throws RemoteException
  {
    zza();
    zzgy localzzgy = this.zza.zzg();
    localzzgy.zzp().zza(new zzhe(localzzgy, paramLong));
  }
  
  public void setUserId(String paramString, long paramLong)
    throws RemoteException
  {
    zza();
    this.zza.zzg().zza(null, "_id", paramString, true, paramLong);
  }
  
  public void setUserProperty(String paramString1, String paramString2, IObjectWrapper paramIObjectWrapper, boolean paramBoolean, long paramLong)
    throws RemoteException
  {
    zza();
    paramIObjectWrapper = ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zza.zzg().zza(paramString1, paramString2, paramIObjectWrapper, paramBoolean, paramLong);
  }
  
  public void unregisterOnMeasurementEventListener(zzab paramzzab)
    throws RemoteException
  {
    zza();
    zzgw localzzgw = (zzgw)this.zzb.remove(Integer.valueOf(paramzzab.zza()));
    Object localObject = localzzgw;
    if (localzzgw == null) {
      localObject = new zza(paramzzab);
    }
    this.zza.zzg().zzb((zzgw)localObject);
  }
  
  final class zza
    implements zzgw
  {
    private zzab zza;
    
    zza(zzab paramzzab)
    {
      this.zza = paramzzab;
    }
    
    public final void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
    {
      try
      {
        this.zza.zza(paramString1, paramString2, paramBundle, paramLong);
        return;
      }
      catch (RemoteException paramString1)
      {
        AppMeasurementDynamiteService.this.zza.zzq().zzh().zza("Event listener threw exception", paramString1);
      }
    }
  }
  
  final class zzb
    implements zzgx
  {
    private zzab zza;
    
    zzb(zzab paramzzab)
    {
      this.zza = paramzzab;
    }
    
    public final void interceptEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
    {
      try
      {
        this.zza.zza(paramString1, paramString2, paramBundle, paramLong);
        return;
      }
      catch (RemoteException paramString1)
      {
        AppMeasurementDynamiteService.this.zza.zzq().zzh().zza("Event interceptor threw exception", paramString1);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\AppMeasurementDynamiteService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */