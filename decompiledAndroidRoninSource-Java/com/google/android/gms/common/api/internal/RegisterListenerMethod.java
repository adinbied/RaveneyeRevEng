package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class RegisterListenerMethod<A extends Api.AnyClient, L>
{
  private final ListenerHolder<L> zaju;
  private final Feature[] zajv;
  private final boolean zajw;
  
  protected RegisterListenerMethod(ListenerHolder<L> paramListenerHolder)
  {
    this.zaju = paramListenerHolder;
    this.zajv = null;
    this.zajw = false;
  }
  
  protected RegisterListenerMethod(ListenerHolder<L> paramListenerHolder, Feature[] paramArrayOfFeature, boolean paramBoolean)
  {
    this.zaju = paramListenerHolder;
    this.zajv = paramArrayOfFeature;
    this.zajw = paramBoolean;
  }
  
  public void clearListener()
  {
    this.zaju.clear();
  }
  
  public ListenerHolder.ListenerKey<L> getListenerKey()
  {
    return this.zaju.getListenerKey();
  }
  
  public Feature[] getRequiredFeatures()
  {
    return this.zajv;
  }
  
  protected abstract void registerListener(A paramA, TaskCompletionSource<Void> paramTaskCompletionSource)
    throws RemoteException;
  
  public final boolean shouldAutoResolveMissingFeatures()
  {
    return this.zajw;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\RegisterListenerMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */