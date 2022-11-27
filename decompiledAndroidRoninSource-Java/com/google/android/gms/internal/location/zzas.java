package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzr;
import com.google.android.gms.location.zzu;
import com.google.android.gms.location.zzx;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzas
{
  private final zzbj<zzao> zzcb;
  private final Context zzcu;
  private ContentProviderClient zzcv = null;
  private boolean zzcw = false;
  private final Map<ListenerHolder.ListenerKey<LocationListener>, zzax> zzcx = new HashMap();
  private final Map<ListenerHolder.ListenerKey<Object>, zzaw> zzcy = new HashMap();
  private final Map<ListenerHolder.ListenerKey<LocationCallback>, zzat> zzcz = new HashMap();
  
  public zzas(Context paramContext, zzbj<zzao> paramzzbj)
  {
    this.zzcu = paramContext;
    this.zzcb = paramzzbj;
  }
  
  private final zzax zza(ListenerHolder<LocationListener> paramListenerHolder)
  {
    synchronized (this.zzcx)
    {
      zzax localzzax2 = (zzax)this.zzcx.get(paramListenerHolder.getListenerKey());
      zzax localzzax1 = localzzax2;
      if (localzzax2 == null) {
        localzzax1 = new zzax(paramListenerHolder);
      }
      this.zzcx.put(paramListenerHolder.getListenerKey(), localzzax1);
      return localzzax1;
    }
  }
  
  private final zzat zzb(ListenerHolder<LocationCallback> paramListenerHolder)
  {
    synchronized (this.zzcz)
    {
      zzat localzzat2 = (zzat)this.zzcz.get(paramListenerHolder.getListenerKey());
      zzat localzzat1 = localzzat2;
      if (localzzat2 == null) {
        localzzat1 = new zzat(paramListenerHolder);
      }
      this.zzcz.put(paramListenerHolder.getListenerKey(), localzzat1);
      return localzzat1;
    }
  }
  
  public final Location getLastLocation()
    throws RemoteException
  {
    this.zzcb.checkConnected();
    return ((zzao)this.zzcb.getService()).zza(this.zzcu.getPackageName());
  }
  
  public final void removeAllListeners()
    throws RemoteException
  {
    synchronized (this.zzcx)
    {
      Iterator localIterator = this.zzcx.values().iterator();
      Object localObject4;
      while (localIterator.hasNext())
      {
        localObject4 = (zzax)localIterator.next();
        if (localObject4 != null) {
          ((zzao)this.zzcb.getService()).zza(zzbf.zza((zzx)localObject4, null));
        }
      }
      this.zzcx.clear();
      synchronized (this.zzcz)
      {
        localIterator = this.zzcz.values().iterator();
        while (localIterator.hasNext())
        {
          localObject4 = (zzat)localIterator.next();
          if (localObject4 != null) {
            ((zzao)this.zzcb.getService()).zza(zzbf.zza((zzu)localObject4, null));
          }
        }
        this.zzcz.clear();
        synchronized (this.zzcy)
        {
          localIterator = this.zzcy.values().iterator();
          while (localIterator.hasNext())
          {
            localObject4 = (zzaw)localIterator.next();
            if (localObject4 != null) {
              ((zzao)this.zzcb.getService()).zza(new zzo(2, null, ((zzr)localObject4).asBinder(), null));
            }
          }
          this.zzcy.clear();
          return;
        }
      }
    }
  }
  
  public final LocationAvailability zza()
    throws RemoteException
  {
    this.zzcb.checkConnected();
    return ((zzao)this.zzcb.getService()).zzb(this.zzcu.getPackageName());
  }
  
  public final void zza(PendingIntent paramPendingIntent, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    zzao localzzao = (zzao)this.zzcb.getService();
    if (paramzzaj != null) {
      paramzzaj = paramzzaj.asBinder();
    } else {
      paramzzaj = null;
    }
    localzzao.zza(new zzbf(2, null, null, paramPendingIntent, null, paramzzaj));
  }
  
  public final void zza(Location paramLocation)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    ((zzao)this.zzcb.getService()).zza(paramLocation);
  }
  
  public final void zza(ListenerHolder.ListenerKey<LocationListener> paramListenerKey, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    Preconditions.checkNotNull(paramListenerKey, "Invalid null listener key");
    synchronized (this.zzcx)
    {
      paramListenerKey = (zzax)this.zzcx.remove(paramListenerKey);
      if (paramListenerKey != null)
      {
        paramListenerKey.release();
        ((zzao)this.zzcb.getService()).zza(zzbf.zza(paramListenerKey, paramzzaj));
      }
      return;
    }
  }
  
  public final void zza(zzaj paramzzaj)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    ((zzao)this.zzcb.getService()).zza(paramzzaj);
  }
  
  public final void zza(zzbd paramzzbd, ListenerHolder<LocationCallback> paramListenerHolder, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    paramListenerHolder = zzb(paramListenerHolder);
    zzao localzzao = (zzao)this.zzcb.getService();
    IBinder localIBinder = paramListenerHolder.asBinder();
    if (paramzzaj != null) {
      paramListenerHolder = paramzzaj.asBinder();
    } else {
      paramListenerHolder = null;
    }
    localzzao.zza(new zzbf(1, paramzzbd, null, null, localIBinder, paramListenerHolder));
  }
  
  public final void zza(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    zzao localzzao = (zzao)this.zzcb.getService();
    zzbd localzzbd = zzbd.zza(paramLocationRequest);
    if (paramzzaj != null) {
      paramLocationRequest = paramzzaj.asBinder();
    } else {
      paramLocationRequest = null;
    }
    localzzao.zza(new zzbf(1, localzzbd, null, paramPendingIntent, null, paramLocationRequest));
  }
  
  public final void zza(LocationRequest paramLocationRequest, ListenerHolder<LocationListener> paramListenerHolder, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    Object localObject = zza(paramListenerHolder);
    paramListenerHolder = (zzao)this.zzcb.getService();
    zzbd localzzbd = zzbd.zza(paramLocationRequest);
    localObject = ((zzx)localObject).asBinder();
    if (paramzzaj != null) {
      paramLocationRequest = paramzzaj.asBinder();
    } else {
      paramLocationRequest = null;
    }
    paramListenerHolder.zza(new zzbf(1, localzzbd, (IBinder)localObject, null, null, paramLocationRequest));
  }
  
  public final void zza(boolean paramBoolean)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    ((zzao)this.zzcb.getService()).zza(paramBoolean);
    this.zzcw = paramBoolean;
  }
  
  public final void zzb()
    throws RemoteException
  {
    if (this.zzcw) {
      zza(false);
    }
  }
  
  public final void zzb(ListenerHolder.ListenerKey<LocationCallback> paramListenerKey, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    Preconditions.checkNotNull(paramListenerKey, "Invalid null listener key");
    synchronized (this.zzcz)
    {
      paramListenerKey = (zzat)this.zzcz.remove(paramListenerKey);
      if (paramListenerKey != null)
      {
        paramListenerKey.release();
        ((zzao)this.zzcb.getService()).zza(zzbf.zza(paramListenerKey, paramzzaj));
      }
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */