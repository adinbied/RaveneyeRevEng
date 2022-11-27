package com.google.android.gms.fitness.request;

import android.os.Looper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolders;
import java.util.HashMap;
import java.util.Map;

public final class zzan
{
  private static final zzan zzhp = new zzan();
  private final Map<ListenerHolder.ListenerKey<OnDataPointListener>, zzal> zzhq = new HashMap();
  
  private static ListenerHolder<OnDataPointListener> zzc(OnDataPointListener paramOnDataPointListener, Looper paramLooper)
  {
    return ListenerHolders.createListenerHolder(paramOnDataPointListener, paramLooper, OnDataPointListener.class.getSimpleName());
  }
  
  public static zzan zzw()
  {
    return zzhp;
  }
  
  public final zzal zza(OnDataPointListener paramOnDataPointListener, Looper paramLooper)
  {
    return zzc(zzc(paramOnDataPointListener, paramLooper));
  }
  
  public final zzal zzb(OnDataPointListener paramOnDataPointListener, Looper paramLooper)
  {
    return zzd(zzc(paramOnDataPointListener, paramLooper));
  }
  
  public final zzal zzc(ListenerHolder<OnDataPointListener> paramListenerHolder)
  {
    synchronized (this.zzhq)
    {
      zzal localzzal2 = (zzal)this.zzhq.get(paramListenerHolder.getListenerKey());
      zzal localzzal1 = localzzal2;
      if (localzzal2 == null)
      {
        localzzal1 = new zzal(paramListenerHolder, null);
        this.zzhq.put(paramListenerHolder.getListenerKey(), localzzal1);
      }
      return localzzal1;
    }
  }
  
  public final zzal zzd(ListenerHolder<OnDataPointListener> paramListenerHolder)
  {
    synchronized (this.zzhq)
    {
      paramListenerHolder = (zzal)this.zzhq.remove(paramListenerHolder.getListenerKey());
      if (paramListenerHolder != null) {
        paramListenerHolder.release();
      }
      return paramListenerHolder;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */