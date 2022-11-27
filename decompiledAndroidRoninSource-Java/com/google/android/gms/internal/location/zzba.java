package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.location.LocationStatusCodes;

final class zzba
  extends zzan
{
  private BaseImplementation.ResultHolder<Status> zzdf;
  
  public zzba(BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    this.zzdf = paramResultHolder;
  }
  
  public final void zza(int paramInt, PendingIntent paramPendingIntent)
  {
    Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
  }
  
  public final void zza(int paramInt, String[] paramArrayOfString)
  {
    if (this.zzdf == null)
    {
      Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
      return;
    }
    paramArrayOfString = LocationStatusCodes.zzd(LocationStatusCodes.zzc(paramInt));
    this.zzdf.setResult(paramArrayOfString);
    this.zzdf = null;
  }
  
  public final void zzb(int paramInt, String[] paramArrayOfString)
  {
    Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */