package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.DataPoint;
import java.util.List;

public abstract interface SensorEventDispatcher
{
  public abstract void publish(DataPoint paramDataPoint)
    throws RemoteException;
  
  public abstract void publish(List<DataPoint> paramList)
    throws RemoteException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\service\SensorEventDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */