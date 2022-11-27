package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L>
{
  private final ListenerHolder.ListenerKey<L> zajl;
  
  protected UnregisterListenerMethod(ListenerHolder.ListenerKey<L> paramListenerKey)
  {
    this.zajl = paramListenerKey;
  }
  
  public ListenerHolder.ListenerKey<L> getListenerKey()
  {
    return this.zajl;
  }
  
  protected abstract void unregisterListener(A paramA, TaskCompletionSource<Boolean> paramTaskCompletionSource)
    throws RemoteException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\UnregisterListenerMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */