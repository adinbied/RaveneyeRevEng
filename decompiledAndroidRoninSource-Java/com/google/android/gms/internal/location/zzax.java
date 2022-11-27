package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzy;

final class zzax
  extends zzy
{
  private final ListenerHolder<LocationListener> zzda;
  
  zzax(ListenerHolder<LocationListener> paramListenerHolder)
  {
    this.zzda = paramListenerHolder;
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    try
    {
      this.zzda.notifyListener(new zzay(this, paramLocation));
      return;
    }
    finally
    {
      paramLocation = finally;
      throw paramLocation;
    }
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */