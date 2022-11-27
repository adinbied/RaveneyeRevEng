package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;

final class zze
  extends GmsClientSupervisor
  implements Handler.Callback
{
  private final Handler mHandler;
  private final HashMap<GmsClientSupervisor.zza, zzf> zzdu = new HashMap();
  private final Context zzdv;
  private final ConnectionTracker zzdw;
  private final long zzdx;
  private final long zzdy;
  
  zze(Context paramContext)
  {
    this.zzdv = paramContext.getApplicationContext();
    this.mHandler = new com.google.android.gms.internal.common.zze(paramContext.getMainLooper(), this);
    this.zzdw = ConnectionTracker.getInstance();
    this.zzdx = 5000L;
    this.zzdy = 300000L;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      synchronized (this.zzdu)
      {
        GmsClientSupervisor.zza localzza = (GmsClientSupervisor.zza)paramMessage.obj;
        zzf localzzf = (zzf)this.zzdu.get(localzza);
        if ((localzzf != null) && (localzzf.getState() == 3))
        {
          paramMessage = String.valueOf(localzza);
          ??? = new StringBuilder(String.valueOf(paramMessage).length() + 47);
          ((StringBuilder)???).append("Timeout waiting for ServiceConnection callback ");
          ((StringBuilder)???).append(paramMessage);
          Log.e("GmsClientSupervisor", ((StringBuilder)???).toString(), new Exception());
          ??? = localzzf.getComponentName();
          paramMessage = (Message)???;
          if (??? == null) {
            paramMessage = localzza.getComponentName();
          }
          ??? = paramMessage;
          if (paramMessage == null) {
            ??? = new ComponentName(localzza.getPackage(), "unknown");
          }
          localzzf.onServiceDisconnected((ComponentName)???);
        }
        return true;
      }
    }
    synchronized (this.zzdu)
    {
      paramMessage = (GmsClientSupervisor.zza)paramMessage.obj;
      ??? = (zzf)this.zzdu.get(paramMessage);
      if ((??? != null) && (((zzf)???).zzr()))
      {
        if (((zzf)???).isBound()) {
          ((zzf)???).zzf("GmsClientSupervisor");
        }
        this.zzdu.remove(paramMessage);
      }
      return true;
    }
  }
  
  protected final boolean zza(GmsClientSupervisor.zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    synchronized (this.zzdu)
    {
      zzf localzzf = (zzf)this.zzdu.get(paramzza);
      if (localzzf == null)
      {
        localzzf = new zzf(this, paramzza);
        localzzf.zza(paramServiceConnection, paramString);
        localzzf.zze(paramString);
        this.zzdu.put(paramzza, localzzf);
        paramzza = localzzf;
      }
      else
      {
        this.mHandler.removeMessages(0, paramzza);
        if (localzzf.zza(paramServiceConnection)) {
          break label168;
        }
        localzzf.zza(paramServiceConnection, paramString);
        int i = localzzf.getState();
        if (i != 1)
        {
          if (i != 2)
          {
            paramzza = localzzf;
          }
          else
          {
            localzzf.zze(paramString);
            paramzza = localzzf;
          }
        }
        else
        {
          paramServiceConnection.onServiceConnected(localzzf.getComponentName(), localzzf.getBinder());
          paramzza = localzzf;
        }
      }
      boolean bool = paramzza.isBound();
      return bool;
      label168:
      paramzza = String.valueOf(paramzza);
      paramServiceConnection = new StringBuilder(String.valueOf(paramzza).length() + 81);
      paramServiceConnection.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
      paramServiceConnection.append(paramzza);
      throw new IllegalStateException(paramServiceConnection.toString());
    }
  }
  
  protected final void zzb(GmsClientSupervisor.zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    synchronized (this.zzdu)
    {
      zzf localzzf = (zzf)this.zzdu.get(paramzza);
      if (localzzf != null)
      {
        if (localzzf.zza(paramServiceConnection))
        {
          localzzf.zzb(paramServiceConnection, paramString);
          if (localzzf.zzr())
          {
            paramzza = this.mHandler.obtainMessage(0, paramzza);
            this.mHandler.sendMessageDelayed(paramzza, this.zzdx);
          }
          return;
        }
        paramzza = String.valueOf(paramzza);
        paramServiceConnection = new StringBuilder(String.valueOf(paramzza).length() + 76);
        paramServiceConnection.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
        paramServiceConnection.append(paramzza);
        throw new IllegalStateException(paramServiceConnection.toString());
      }
      paramzza = String.valueOf(paramzza);
      paramServiceConnection = new StringBuilder(String.valueOf(paramzza).length() + 50);
      paramServiceConnection.append("Nonexistent connection status for service config: ");
      paramServiceConnection.append(paramzza);
      throw new IllegalStateException(paramServiceConnection.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */