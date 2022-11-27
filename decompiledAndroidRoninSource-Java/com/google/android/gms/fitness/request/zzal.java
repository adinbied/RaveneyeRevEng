package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.zzu;

public final class zzal
  extends zzu
{
  private final ListenerHolder<OnDataPointListener> zzhn;
  
  private zzal(ListenerHolder<OnDataPointListener> paramListenerHolder)
  {
    this.zzhn = ((ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
  }
  
  public final void release()
  {
    this.zzhn.clear();
  }
  
  public final void zzc(DataPoint paramDataPoint)
    throws RemoteException
  {
    this.zzhn.notifyListener(new zzam(this, paramDataPoint));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */