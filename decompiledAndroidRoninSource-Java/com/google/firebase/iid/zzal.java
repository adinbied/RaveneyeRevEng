package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

final class zzal
{
  private final Messenger zza;
  private final zzj zzb;
  
  zzal(IBinder paramIBinder)
    throws RemoteException
  {
    String str = paramIBinder.getInterfaceDescriptor();
    if ("android.os.IMessenger".equals(str))
    {
      this.zza = new Messenger(paramIBinder);
      this.zzb = null;
      return;
    }
    if ("com.google.android.gms.iid.IMessengerCompat".equals(str))
    {
      this.zzb = new zzj(paramIBinder);
      this.zza = null;
      return;
    }
    paramIBinder = String.valueOf(str);
    if (paramIBinder.length() != 0) {
      paramIBinder = "Invalid interface descriptor: ".concat(paramIBinder);
    } else {
      paramIBinder = new String("Invalid interface descriptor: ");
    }
    Log.w("MessengerIpcClient", paramIBinder);
    throw new RemoteException();
  }
  
  final void zza(Message paramMessage)
    throws RemoteException
  {
    Object localObject = this.zza;
    if (localObject != null)
    {
      ((Messenger)localObject).send(paramMessage);
      return;
    }
    localObject = this.zzb;
    if (localObject != null)
    {
      ((zzj)localObject).zza(paramMessage);
      return;
    }
    throw new IllegalStateException("Both messengers are null");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */