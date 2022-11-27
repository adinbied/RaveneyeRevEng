package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.firebase_messaging.zze;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

final class zzac
  implements ServiceConnection
{
  int zza = 0;
  final Messenger zzb = new Messenger(new zze(Looper.getMainLooper(), new zzaf(this)));
  zzal zzc;
  final Queue<zzan<?>> zzd = new ArrayDeque();
  final SparseArray<zzan<?>> zze = new SparseArray();
  
  private zzac(zzab paramzzab) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (Log.isLoggable("MessengerIpcClient", 2)) {
      Log.v("MessengerIpcClient", "Service connected");
    }
    zzab.zzb(this.zzf).execute(new zzah(this, paramIBinder));
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (Log.isLoggable("MessengerIpcClient", 2)) {
      Log.v("MessengerIpcClient", "Service disconnected");
    }
    zzab.zzb(this.zzf).execute(new zzaj(this));
  }
  
  final void zza()
  {
    zzab.zzb(this.zzf).execute(new zzag(this));
  }
  
  final void zza(int paramInt)
  {
    try
    {
      zzan localzzan = (zzan)this.zze.get(paramInt);
      if (localzzan != null)
      {
        StringBuilder localStringBuilder = new StringBuilder(31);
        localStringBuilder.append("Timing out request: ");
        localStringBuilder.append(paramInt);
        Log.w("MessengerIpcClient", localStringBuilder.toString());
        this.zze.remove(paramInt);
        localzzan.zza(new zzam(3, "Timed out waiting for response"));
        zzb();
      }
      return;
    }
    finally {}
  }
  
  final void zza(int paramInt, String paramString)
  {
    try
    {
      Object localObject;
      if (Log.isLoggable("MessengerIpcClient", 3))
      {
        localObject = String.valueOf(paramString);
        if (((String)localObject).length() != 0) {
          localObject = "Disconnected: ".concat((String)localObject);
        } else {
          localObject = new String("Disconnected: ");
        }
        Log.d("MessengerIpcClient", (String)localObject);
      }
      int i = this.zza;
      if (i != 0)
      {
        if ((i != 1) && (i != 2))
        {
          if (i != 3)
          {
            if (i == 4) {
              return;
            }
            paramInt = this.zza;
            paramString = new StringBuilder(26);
            paramString.append("Unknown state: ");
            paramString.append(paramInt);
            throw new IllegalStateException(paramString.toString());
          }
          this.zza = 4;
          return;
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
          Log.v("MessengerIpcClient", "Unbinding service");
        }
        this.zza = 4;
        ConnectionTracker.getInstance().unbindService(zzab.zza(this.zzf), this);
        paramString = new zzam(paramInt, paramString);
        localObject = this.zzd.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((zzan)((Iterator)localObject).next()).zza(paramString);
        }
        this.zzd.clear();
        paramInt = 0;
        while (paramInt < this.zze.size())
        {
          ((zzan)this.zze.valueAt(paramInt)).zza(paramString);
          paramInt += 1;
        }
        this.zze.clear();
        return;
      }
      throw new IllegalStateException();
    }
    finally {}
  }
  
  final boolean zza(Message paramMessage)
  {
    int i = paramMessage.arg1;
    Object localObject;
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      localObject = new StringBuilder(41);
      ((StringBuilder)localObject).append("Received response to request: ");
      ((StringBuilder)localObject).append(i);
      Log.d("MessengerIpcClient", ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = (zzan)this.zze.get(i);
      if (localObject == null)
      {
        paramMessage = new StringBuilder(50);
        paramMessage.append("Received response for unknown request: ");
        paramMessage.append(i);
        Log.w("MessengerIpcClient", paramMessage.toString());
        return true;
      }
      this.zze.remove(i);
      zzb();
      paramMessage = paramMessage.getData();
      if (paramMessage.getBoolean("unsupported", false))
      {
        ((zzan)localObject).zza(new zzam(4, "Not supported by GmsCore"));
        return true;
      }
      ((zzan)localObject).zza(paramMessage);
      return true;
    }
    finally {}
  }
  
  final boolean zza(zzan<?> paramzzan)
  {
    for (;;)
    {
      try
      {
        int i = this.zza;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if ((i != 3) && (i != 4))
              {
                i = this.zza;
                paramzzan = new StringBuilder(26);
                paramzzan.append("Unknown state: ");
                paramzzan.append(i);
                throw new IllegalStateException(paramzzan.toString());
              }
              return false;
            }
            this.zzd.add(paramzzan);
            zza();
            return true;
          }
          this.zzd.add(paramzzan);
          return true;
        }
        this.zzd.add(paramzzan);
        if (this.zza == 0)
        {
          bool = true;
          Preconditions.checkState(bool);
          if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
          }
          this.zza = 1;
          paramzzan = new Intent("com.google.android.c2dm.intent.REGISTER");
          paramzzan.setPackage("com.google.android.gms");
          if (!ConnectionTracker.getInstance().bindService(zzab.zza(this.zzf), paramzzan, this, 1)) {
            zza(0, "Unable to bind to service");
          } else {
            zzab.zzb(this.zzf).schedule(new zzae(this), 30L, TimeUnit.SECONDS);
          }
          return true;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  final void zzb()
  {
    try
    {
      if ((this.zza == 2) && (this.zzd.isEmpty()) && (this.zze.size() == 0))
      {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
          Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
        }
        this.zza = 3;
        ConnectionTracker.getInstance().unbindService(zzab.zza(this.zzf), this);
      }
      return;
    }
    finally {}
  }
  
  final void zzc()
  {
    try
    {
      if (this.zza == 1) {
        zza(1, "Timed out while binding");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */