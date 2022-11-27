package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zack
  extends TaskApiCall<A, ResultT>
{
  zack(TaskApiCall.Builder paramBuilder, Feature[] paramArrayOfFeature, boolean paramBoolean)
  {
    super(paramArrayOfFeature, paramBoolean, null);
  }
  
  protected final void doExecute(A paramA, TaskCompletionSource<ResultT> paramTaskCompletionSource)
    throws RemoteException
  {
    TaskApiCall.Builder.zaa(this.zakn).accept(paramA, paramTaskCompletionSource);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */