package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zaca
  extends RegisterListenerMethod<A, L>
{
  zaca(RegistrationMethods.Builder paramBuilder, ListenerHolder paramListenerHolder, Feature[] paramArrayOfFeature, boolean paramBoolean)
  {
    super(paramListenerHolder, paramArrayOfFeature, paramBoolean);
  }
  
  protected final void registerListener(A paramA, TaskCompletionSource<Void> paramTaskCompletionSource)
    throws RemoteException
  {
    RegistrationMethods.Builder.zaa(this.zakh).accept(paramA, paramTaskCompletionSource);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */