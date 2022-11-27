package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.fitness.result.BleDevicesResult;

final class zzda
  extends zzes
{
  private final BaseImplementation.ResultHolder<BleDevicesResult> zzev;
  
  private zzda(BaseImplementation.ResultHolder<BleDevicesResult> paramResultHolder)
  {
    this.zzev = paramResultHolder;
  }
  
  public final void zza(BleDevicesResult paramBleDevicesResult)
  {
    this.zzev.setResult(paramBleDevicesResult);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzda.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */