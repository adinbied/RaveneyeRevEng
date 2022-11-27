package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzv;

final class zzat
  extends zzv
{
  private final ListenerHolder<LocationCallback> zzda;
  
  zzat(ListenerHolder<LocationCallback> paramListenerHolder)
  {
    this.zzda = paramListenerHolder;
  }
  
  public final void onLocationAvailability(LocationAvailability paramLocationAvailability)
  {
    this.zzda.notifyListener(new zzav(this, paramLocationAvailability));
  }
  
  public final void onLocationResult(LocationResult paramLocationResult)
  {
    this.zzda.notifyListener(new zzau(this, paramLocationResult));
  }
  
  public final void release()
  {
    try
    {
      this.zzda.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */