package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;

public final class zzji
  implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener
{
  private volatile boolean zzb;
  private volatile zzeo zzc;
  
  protected zzji(zzio paramzzio) {}
  
  public final void onConnected(Bundle paramBundle)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
    try
    {
      try
      {
        paramBundle = (zzej)this.zzc.getService();
        this.zza.zzp().zza(new zzjn(this, paramBundle));
      }
      finally
      {
        break label57;
      }
    }
    catch (DeadObjectException|IllegalStateException paramBundle)
    {
      for (;;) {}
    }
    this.zzc = null;
    this.zzb = false;
    return;
    label57:
    throw paramBundle;
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
    zzer localzzer = this.zza.zzy.zzc();
    if (localzzer != null) {
      localzzer.zzh().zza("Service connection failed", paramConnectionResult);
    }
    try
    {
      this.zzb = false;
      this.zzc = null;
      this.zza.zzp().zza(new zzjp(this));
      return;
    }
    finally {}
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
    this.zza.zzq().zzv().zza("Service connection suspended");
    this.zza.zzp().zza(new zzjm(this));
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
    if (paramIBinder == null) {
      try
      {
        this.zzb = false;
        this.zza.zzq().zze().zza("Service connected with null binder");
        return;
      }
      finally
      {
        break label241;
      }
    }
    Object localObject = null;
    paramComponentName = null;
    IInterface localIInterface = null;
    ComponentName localComponentName = paramComponentName;
    try
    {
      str = paramIBinder.getInterfaceDescriptor();
      localComponentName = paramComponentName;
      if (!"com.google.android.gms.measurement.internal.IMeasurementService".equals(str)) {
        break label145;
      }
      if (paramIBinder == null)
      {
        paramComponentName = localIInterface;
      }
      else
      {
        localComponentName = paramComponentName;
        localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        localComponentName = paramComponentName;
        if ((localIInterface instanceof zzej))
        {
          localComponentName = paramComponentName;
          paramComponentName = (zzej)localIInterface;
        }
        else
        {
          localComponentName = paramComponentName;
          paramComponentName = new zzel(paramIBinder);
        }
      }
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        String str;
      }
    }
    localComponentName = paramComponentName;
    this.zza.zzq().zzw().zza("Bound to IMeasurementService interface");
    break label187;
    label145:
    localComponentName = paramComponentName;
    this.zza.zzq().zze().zza("Got binder with a wrong descriptor", str);
    paramComponentName = (ComponentName)localObject;
    break label187;
    this.zza.zzq().zze().zza("Service connect failed to get IMeasurementService");
    paramComponentName = localComponentName;
    label187:
    if (paramComponentName == null) {
      this.zzb = false;
    }
    try
    {
      ConnectionTracker.getInstance().unbindService(this.zza.zzm(), zzio.zza(this.zza));
    }
    catch (IllegalArgumentException paramComponentName)
    {
      for (;;) {}
    }
    this.zza.zzp().zza(new zzjl(this, paramComponentName));
    return;
    label241:
    throw paramComponentName;
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
    this.zza.zzq().zzv().zza("Service disconnected");
    this.zza.zzp().zza(new zzjk(this, paramComponentName));
  }
  
  public final void zza()
  {
    if ((this.zzc != null) && ((this.zzc.isConnected()) || (this.zzc.isConnecting()))) {
      this.zzc.disconnect();
    }
    this.zzc = null;
  }
  
  public final void zza(Intent paramIntent)
  {
    this.zza.zzc();
    Context localContext = this.zza.zzm();
    ConnectionTracker localConnectionTracker = ConnectionTracker.getInstance();
    try
    {
      if (this.zzb)
      {
        this.zza.zzq().zzw().zza("Connection attempt already in progress");
        return;
      }
      this.zza.zzq().zzw().zza("Using local app measurement service");
      this.zzb = true;
      localConnectionTracker.bindService(localContext, paramIntent, zzio.zza(this.zza), 129);
      return;
    }
    finally {}
  }
  
  public final void zzb()
  {
    this.zza.zzc();
    Context localContext = this.zza.zzm();
    try
    {
      if (this.zzb)
      {
        this.zza.zzq().zzw().zza("Connection attempt already in progress");
        return;
      }
      if ((this.zzc != null) && ((this.zzc.isConnecting()) || (this.zzc.isConnected())))
      {
        this.zza.zzq().zzw().zza("Already awaiting connection attempt");
        return;
      }
      this.zzc = new zzeo(localContext, Looper.getMainLooper(), this, this);
      this.zza.zzq().zzw().zza("Connecting to remote service");
      this.zzb = true;
      this.zzc.checkAvailabilityAndConnect();
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */