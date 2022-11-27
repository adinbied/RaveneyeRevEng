package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.internal.location.zzad;
import com.google.android.gms.internal.location.zzak;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzp
  extends zzak
{
  zzp(FusedLocationProviderClient paramFusedLocationProviderClient, TaskCompletionSource paramTaskCompletionSource) {}
  
  public final void zza(zzad paramzzad)
    throws RemoteException
  {
    paramzzad = paramzzad.getStatus();
    if (paramzzad == null)
    {
      this.zzab.trySetException(new ApiException(new Status(8, "Got null status from location service")));
      return;
    }
    if (paramzzad.getStatusCode() == 0)
    {
      this.zzab.setResult(Boolean.valueOf(true));
      return;
    }
    this.zzab.trySetException(ApiExceptionUtil.fromStatus(paramzzad));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */