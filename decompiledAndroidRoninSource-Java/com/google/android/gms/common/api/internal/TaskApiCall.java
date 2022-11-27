package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class TaskApiCall<A extends Api.AnyClient, ResultT>
{
  private final Feature[] zake;
  private final boolean zakl;
  
  @Deprecated
  public TaskApiCall()
  {
    this.zake = null;
    this.zakl = false;
  }
  
  private TaskApiCall(Feature[] paramArrayOfFeature, boolean paramBoolean)
  {
    this.zake = paramArrayOfFeature;
    this.zakl = paramBoolean;
  }
  
  public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder()
  {
    return new Builder(null);
  }
  
  protected abstract void doExecute(A paramA, TaskCompletionSource<ResultT> paramTaskCompletionSource)
    throws RemoteException;
  
  public boolean shouldAutoResolveMissingFeatures()
  {
    return this.zakl;
  }
  
  public final Feature[] zabt()
  {
    return this.zake;
  }
  
  public static class Builder<A extends Api.AnyClient, ResultT>
  {
    private Feature[] zake;
    private boolean zakl = true;
    private RemoteCall<A, TaskCompletionSource<ResultT>> zakm;
    
    public TaskApiCall<A, ResultT> build()
    {
      boolean bool;
      if (this.zakm != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "execute parameter required");
      return new zack(this, this.zake, this.zakl);
    }
    
    @Deprecated
    public Builder<A, ResultT> execute(BiConsumer<A, TaskCompletionSource<ResultT>> paramBiConsumer)
    {
      this.zakm = new zacj(paramBiConsumer);
      return this;
    }
    
    public Builder<A, ResultT> run(RemoteCall<A, TaskCompletionSource<ResultT>> paramRemoteCall)
    {
      this.zakm = paramRemoteCall;
      return this;
    }
    
    public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean paramBoolean)
    {
      this.zakl = paramBoolean;
      return this;
    }
    
    public Builder<A, ResultT> setFeatures(Feature... paramVarArgs)
    {
      this.zake = paramVarArgs;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\TaskApiCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */