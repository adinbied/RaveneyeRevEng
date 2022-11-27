package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public final class zah
  extends zad<Boolean>
{
  private final ListenerHolder.ListenerKey<?> zact;
  
  public zah(ListenerHolder.ListenerKey<?> paramListenerKey, TaskCompletionSource<Boolean> paramTaskCompletionSource)
  {
    super(4, paramTaskCompletionSource);
    this.zact = paramListenerKey;
  }
  
  public final Feature[] zab(GoogleApiManager.zaa<?> paramzaa)
  {
    paramzaa = (zabw)paramzaa.zabk().get(this.zact);
    if (paramzaa == null) {
      return null;
    }
    return paramzaa.zajx.getRequiredFeatures();
  }
  
  public final boolean zac(GoogleApiManager.zaa<?> paramzaa)
  {
    paramzaa = (zabw)paramzaa.zabk().get(this.zact);
    return (paramzaa != null) && (paramzaa.zajx.shouldAutoResolveMissingFeatures());
  }
  
  public final void zad(GoogleApiManager.zaa<?> paramzaa)
    throws RemoteException
  {
    zabw localzabw = (zabw)paramzaa.zabk().remove(this.zact);
    if (localzabw != null)
    {
      localzabw.zajy.unregisterListener(paramzaa.zaab(), this.zacn);
      localzabw.zajx.clearListener();
      return;
    }
    this.zacn.trySetResult(Boolean.valueOf(false));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */