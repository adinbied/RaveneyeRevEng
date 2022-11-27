package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzd;
import com.google.android.gms.fitness.result.BleDevicesResult;

public final class zzct
  implements BleApi
{
  public final PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return paramGoogleApiClient.execute(new zzcx(this, paramGoogleApiClient, paramBleDevice));
  }
  
  public final PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.execute(new zzcw(this, paramGoogleApiClient, paramString));
  }
  
  public final PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.enqueue(new zzcz(this, paramGoogleApiClient));
  }
  
  public final PendingResult<Status> startBleScan(GoogleApiClient paramGoogleApiClient, StartBleScanRequest paramStartBleScanRequest)
  {
    return paramGoogleApiClient.enqueue(new zzcu(this, paramGoogleApiClient, paramStartBleScanRequest, zzd.zzt().zza(paramStartBleScanRequest.zzz(), paramGoogleApiClient.getLooper())));
  }
  
  public final PendingResult<Status> stopBleScan(GoogleApiClient paramGoogleApiClient, BleScanCallback paramBleScanCallback)
  {
    paramBleScanCallback = zzd.zzt().zzb(paramBleScanCallback, paramGoogleApiClient.getLooper());
    if (paramBleScanCallback == null) {
      return PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, paramGoogleApiClient);
    }
    return paramGoogleApiClient.enqueue(new zzcv(this, paramGoogleApiClient, paramBleScanCallback));
  }
  
  public final PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return unclaimBleDevice(paramGoogleApiClient, paramBleDevice.getAddress());
  }
  
  public final PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.execute(new zzcy(this, paramGoogleApiClient, paramString));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */