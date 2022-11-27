package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzf
  implements ServiceConnection
{
  private ComponentName mComponentName;
  private int mState;
  private IBinder zzcz;
  private final Set<ServiceConnection> zzdz;
  private boolean zzea;
  private final GmsClientSupervisor.zza zzeb;
  
  public zzf(zze paramzze, GmsClientSupervisor.zza paramzza)
  {
    this.zzeb = paramzza;
    this.zzdz = new HashSet();
    this.mState = 2;
  }
  
  public final IBinder getBinder()
  {
    return this.zzcz;
  }
  
  public final ComponentName getComponentName()
  {
    return this.mComponentName;
  }
  
  public final int getState()
  {
    return this.mState;
  }
  
  public final boolean isBound()
  {
    return this.zzea;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (zze.zza(this.zzec))
    {
      zze.zzb(this.zzec).removeMessages(1, this.zzeb);
      this.zzcz = paramIBinder;
      this.mComponentName = paramComponentName;
      Iterator localIterator = this.zzdz.iterator();
      while (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
      }
      this.mState = 1;
      return;
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    synchronized (zze.zza(this.zzec))
    {
      zze.zzb(this.zzec).removeMessages(1, this.zzeb);
      this.zzcz = null;
      this.mComponentName = paramComponentName;
      Iterator localIterator = this.zzdz.iterator();
      while (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
      }
      this.mState = 2;
      return;
    }
  }
  
  public final void zza(ServiceConnection paramServiceConnection, String paramString)
  {
    zze.zzd(this.zzec);
    zze.zzc(this.zzec);
    this.zzeb.zzb(zze.zzc(this.zzec));
    this.zzdz.add(paramServiceConnection);
  }
  
  public final boolean zza(ServiceConnection paramServiceConnection)
  {
    return this.zzdz.contains(paramServiceConnection);
  }
  
  public final void zzb(ServiceConnection paramServiceConnection, String paramString)
  {
    zze.zzd(this.zzec);
    zze.zzc(this.zzec);
    this.zzdz.remove(paramServiceConnection);
  }
  
  public final void zze(String paramString)
  {
    this.mState = 3;
    boolean bool = zze.zzd(this.zzec).zza(zze.zzc(this.zzec), paramString, this.zzeb.zzb(zze.zzc(this.zzec)), this, this.zzeb.zzq());
    this.zzea = bool;
    if (bool)
    {
      paramString = zze.zzb(this.zzec).obtainMessage(1, this.zzeb);
      zze.zzb(this.zzec).sendMessageDelayed(paramString, zze.zze(this.zzec));
      return;
    }
    this.mState = 2;
    try
    {
      zze.zzd(this.zzec).unbindService(zze.zzc(this.zzec), this);
      return;
    }
    catch (IllegalArgumentException paramString) {}
  }
  
  public final void zzf(String paramString)
  {
    zze.zzb(this.zzec).removeMessages(1, this.zzeb);
    zze.zzd(this.zzec).unbindService(zze.zzc(this.zzec), this);
    this.zzea = false;
    this.mState = 2;
  }
  
  public final boolean zzr()
  {
    return this.zzdz.isEmpty();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */