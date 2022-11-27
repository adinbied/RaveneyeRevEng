package com.google.android.gms.fitness.request;

import android.os.Looper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolders;
import java.util.HashMap;
import java.util.Map;

public final class zzd
{
  private static final zzd zzgg = new zzd();
  private final Map<ListenerHolder.ListenerKey<BleScanCallback>, zza> zzgh = new HashMap();
  
  private static ListenerHolder<BleScanCallback> zzc(BleScanCallback paramBleScanCallback, Looper paramLooper)
  {
    return ListenerHolders.createListenerHolder(paramBleScanCallback, paramLooper, BleScanCallback.class.getSimpleName());
  }
  
  public static zzd zzt()
  {
    return zzgg;
  }
  
  public final zza zza(ListenerHolder<BleScanCallback> paramListenerHolder)
  {
    synchronized (this.zzgh)
    {
      zza localzza2 = (zza)this.zzgh.get(paramListenerHolder.getListenerKey());
      zza localzza1 = localzza2;
      if (localzza2 == null)
      {
        localzza1 = new zza(paramListenerHolder, null);
        this.zzgh.put(paramListenerHolder.getListenerKey(), localzza1);
      }
      return localzza1;
    }
  }
  
  public final zza zza(BleScanCallback paramBleScanCallback, Looper paramLooper)
  {
    return zza(zzc(paramBleScanCallback, paramLooper));
  }
  
  public final zza zzb(ListenerHolder<BleScanCallback> paramListenerHolder)
  {
    synchronized (this.zzgh)
    {
      paramListenerHolder = (zza)this.zzgh.get(paramListenerHolder.getListenerKey());
      if (paramListenerHolder != null) {
        paramListenerHolder.release();
      }
      return paramListenerHolder;
    }
  }
  
  public final zza zzb(BleScanCallback paramBleScanCallback, Looper paramLooper)
  {
    return zzb(zzc(paramBleScanCallback, paramLooper));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */