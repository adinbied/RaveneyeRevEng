package com.google.android.gms.fitness;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.internal.fitness.zzas;

final class zzn
  extends RegisterListenerMethod<zzas, OnDataPointListener>
{
  zzn(SensorsClient paramSensorsClient, ListenerHolder paramListenerHolder1, ListenerHolder paramListenerHolder2, SensorRequest paramSensorRequest)
  {
    super(paramListenerHolder1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */