package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

public class BaseImplementation
{
  public static abstract class ApiMethodImpl<R extends Result, A extends Api.AnyClient>
    extends BasePendingResult<R>
    implements BaseImplementation.ResultHolder<R>
  {
    private final Api<?> mApi;
    private final Api.AnyClientKey<A> mClientKey;
    
    @Deprecated
    protected ApiMethodImpl(Api.AnyClientKey<A> paramAnyClientKey, GoogleApiClient paramGoogleApiClient)
    {
      super();
      this.mClientKey = ((Api.AnyClientKey)Preconditions.checkNotNull(paramAnyClientKey));
      this.mApi = null;
    }
    
    protected ApiMethodImpl(Api<?> paramApi, GoogleApiClient paramGoogleApiClient)
    {
      super();
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      this.mClientKey = paramApi.getClientKey();
      this.mApi = paramApi;
    }
    
    protected ApiMethodImpl(BasePendingResult.CallbackHandler<R> paramCallbackHandler)
    {
      super();
      this.mClientKey = null;
      this.mApi = null;
    }
    
    private void setFailedResult(RemoteException paramRemoteException)
    {
      setFailedResult(new Status(8, paramRemoteException.getLocalizedMessage(), null));
    }
    
    protected abstract void doExecute(A paramA)
      throws RemoteException;
    
    public final Api<?> getApi()
    {
      return this.mApi;
    }
    
    public final Api.AnyClientKey<A> getClientKey()
    {
      return this.mClientKey;
    }
    
    protected void onSetFailedResult(R paramR) {}
    
    public final void run(A paramA)
      throws DeadObjectException
    {
      Object localObject = paramA;
      if ((paramA instanceof SimpleClientAdapter)) {
        localObject = ((SimpleClientAdapter)paramA).getClient();
      }
      try
      {
        doExecute((Api.AnyClient)localObject);
        return;
      }
      catch (RemoteException paramA)
      {
        setFailedResult(paramA);
        return;
      }
      catch (DeadObjectException paramA)
      {
        setFailedResult(paramA);
        throw paramA;
      }
    }
    
    public final void setFailedResult(Status paramStatus)
    {
      Preconditions.checkArgument(paramStatus.isSuccess() ^ true, "Failed result must not be success");
      paramStatus = createFailedResult(paramStatus);
      setResult(paramStatus);
      onSetFailedResult(paramStatus);
    }
  }
  
  public static abstract interface ResultHolder<R>
  {
    public abstract void setFailedResult(Status paramStatus);
    
    public abstract void setResult(R paramR);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\BaseImplementation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */