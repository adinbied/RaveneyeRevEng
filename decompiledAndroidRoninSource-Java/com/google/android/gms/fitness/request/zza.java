package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.BleDevice;

public final class zza
  extends zzaf
{
  private final ListenerHolder<BleScanCallback> zzge;
  
  private zza(ListenerHolder<BleScanCallback> paramListenerHolder)
  {
    this.zzge = ((ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
  }
  
  public final void onDeviceFound(BleDevice paramBleDevice)
    throws RemoteException
  {
    this.zzge.notifyListener(new zzb(this, paramBleDevice));
  }
  
  public final void onScanStopped()
    throws RemoteException
  {
    this.zzge.notifyListener(new zzc(this));
  }
  
  public final void release()
  {
    this.zzge.clear();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */