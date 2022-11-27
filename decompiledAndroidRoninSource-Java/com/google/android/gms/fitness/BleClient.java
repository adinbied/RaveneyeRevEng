package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.internal.fitness.zzct;
import com.google.android.gms.internal.fitness.zzeq;
import com.google.android.gms.internal.fitness.zzp;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.List;

public class BleClient
  extends GoogleApi<FitnessOptions>
{
  private static final BleApi zze;
  
  static
  {
    Object localObject;
    if (PlatformVersion.isAtLeastJellyBeanMR2()) {
      localObject = new zzct();
    } else {
      localObject = new zzeq();
    }
    zze = (BleApi)localObject;
  }
  
  BleClient(Activity paramActivity, FitnessOptions paramFitnessOptions)
  {
    super(paramActivity, zzp.zzew, paramFitnessOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  BleClient(Context paramContext, FitnessOptions paramFitnessOptions)
  {
    super(paramContext, zzp.zzew, paramFitnessOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task<Void> claimBleDevice(BleDevice paramBleDevice)
  {
    return PendingResultUtil.toVoidTask(zze.claimBleDevice(asGoogleApiClient(), paramBleDevice));
  }
  
  public Task<Void> claimBleDevice(String paramString)
  {
    return PendingResultUtil.toVoidTask(zze.claimBleDevice(asGoogleApiClient(), paramString));
  }
  
  public Task<List<BleDevice>> listClaimedBleDevices()
  {
    return PendingResultUtil.toTask(zze.listClaimedBleDevices(asGoogleApiClient()), zza.zzf);
  }
  
  public Task<Void> startBleScan(List<DataType> paramList, int paramInt, BleScanCallback paramBleScanCallback)
  {
    if (!PlatformVersion.isAtLeastJellyBeanMR2()) {
      return Tasks.forException(new ApiException(zzeq.zzgd));
    }
    paramBleScanCallback = registerListener(paramBleScanCallback, BleScanCallback.class.getSimpleName());
    return doRegisterEventListener(new zzb(this, paramBleScanCallback, paramBleScanCallback, paramList, paramInt), new zzc(this, paramBleScanCallback.getListenerKey(), paramBleScanCallback));
  }
  
  public Task<Boolean> stopBleScan(BleScanCallback paramBleScanCallback)
  {
    if (!PlatformVersion.isAtLeastJellyBeanMR2()) {
      return Tasks.forException(new ApiException(zzeq.zzgd));
    }
    return doUnregisterEventListener(ListenerHolders.createListenerKey(paramBleScanCallback, BleScanCallback.class.getSimpleName()));
  }
  
  public Task<Void> unclaimBleDevice(BleDevice paramBleDevice)
  {
    return PendingResultUtil.toVoidTask(zze.unclaimBleDevice(asGoogleApiClient(), paramBleDevice));
  }
  
  public Task<Void> unclaimBleDevice(String paramString)
  {
    return PendingResultUtil.toVoidTask(zze.unclaimBleDevice(asGoogleApiClient(), paramString));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\BleClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */