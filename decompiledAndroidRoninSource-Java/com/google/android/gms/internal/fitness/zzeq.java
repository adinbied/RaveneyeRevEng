package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public final class zzeq
  implements BleApi
{
  public static final Status zzgd = new Status(5007);
  
  public final PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return PendingResults.immediatePendingResult(zzgd, paramGoogleApiClient);
  }
  
  public final PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return PendingResults.immediatePendingResult(zzgd, paramGoogleApiClient);
  }
  
  public final PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient paramGoogleApiClient)
  {
    return PendingResults.immediateFailedResult(BleDevicesResult.zzb(zzgd), paramGoogleApiClient);
  }
  
  public final PendingResult<Status> startBleScan(GoogleApiClient paramGoogleApiClient, StartBleScanRequest paramStartBleScanRequest)
  {
    return PendingResults.immediatePendingResult(zzgd, paramGoogleApiClient);
  }
  
  public final PendingResult<Status> stopBleScan(GoogleApiClient paramGoogleApiClient, BleScanCallback paramBleScanCallback)
  {
    return PendingResults.immediatePendingResult(zzgd, paramGoogleApiClient);
  }
  
  public final PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return PendingResults.immediatePendingResult(zzgd, paramGoogleApiClient);
  }
  
  public final PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return PendingResults.immediatePendingResult(zzgd, paramGoogleApiClient);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */