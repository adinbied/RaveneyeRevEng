package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsResult;

final class zzbc
  extends zzar
{
  private BaseImplementation.ResultHolder<LocationSettingsResult> zzdf;
  
  public zzbc(BaseImplementation.ResultHolder<LocationSettingsResult> paramResultHolder)
  {
    boolean bool;
    if (paramResultHolder != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "listener can't be null.");
    this.zzdf = paramResultHolder;
  }
  
  public final void zza(LocationSettingsResult paramLocationSettingsResult)
    throws RemoteException
  {
    this.zzdf.setResult(paramLocationSettingsResult);
    this.zzdf = null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */