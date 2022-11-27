package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.zzt;
import java.util.Iterator;
import java.util.List;

final class zzc
  implements SensorEventDispatcher
{
  private final zzt zzhr;
  
  zzc(zzt paramzzt)
  {
    this.zzhr = ((zzt)Preconditions.checkNotNull(paramzzt));
  }
  
  public final void publish(DataPoint paramDataPoint)
    throws RemoteException
  {
    paramDataPoint.zzg();
    this.zzhr.zzc(paramDataPoint);
  }
  
  public final void publish(List<DataPoint> paramList)
    throws RemoteException
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      publish((DataPoint)paramList.next());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\service\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */