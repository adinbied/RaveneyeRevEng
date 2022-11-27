package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

public class RegistrationMethods<A extends Api.AnyClient, L>
{
  public final RegisterListenerMethod<A, L> zajz;
  public final UnregisterListenerMethod<A, L> zaka;
  
  private RegistrationMethods(RegisterListenerMethod<A, L> paramRegisterListenerMethod, UnregisterListenerMethod<A, L> paramUnregisterListenerMethod)
  {
    this.zajz = paramRegisterListenerMethod;
    this.zaka = paramUnregisterListenerMethod;
  }
  
  public static <A extends Api.AnyClient, L> Builder<A, L> builder()
  {
    return new Builder(null);
  }
  
  public static class Builder<A extends Api.AnyClient, L>
  {
    private boolean zajw = true;
    private RemoteCall<A, TaskCompletionSource<Void>> zakb;
    private RemoteCall<A, TaskCompletionSource<Boolean>> zakc;
    private ListenerHolder<L> zakd;
    private Feature[] zake;
    
    public RegistrationMethods<A, L> build()
    {
      RemoteCall localRemoteCall = this.zakb;
      boolean bool2 = true;
      boolean bool1;
      if (localRemoteCall != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Must set register function");
      if (this.zakc != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Must set unregister function");
      if (this.zakd != null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Must set holder");
      return new RegistrationMethods(new zaca(this, this.zakd, this.zake, this.zajw), new zacb(this, this.zakd.getListenerKey()), null);
    }
    
    public Builder<A, L> register(RemoteCall<A, TaskCompletionSource<Void>> paramRemoteCall)
    {
      this.zakb = paramRemoteCall;
      return this;
    }
    
    @Deprecated
    public Builder<A, L> register(BiConsumer<A, TaskCompletionSource<Void>> paramBiConsumer)
    {
      this.zakb = new zaby(paramBiConsumer);
      return this;
    }
    
    public Builder<A, L> setAutoResolveMissingFeatures(boolean paramBoolean)
    {
      this.zajw = paramBoolean;
      return this;
    }
    
    public Builder<A, L> setFeatures(Feature[] paramArrayOfFeature)
    {
      this.zake = paramArrayOfFeature;
      return this;
    }
    
    public Builder<A, L> unregister(RemoteCall<A, TaskCompletionSource<Boolean>> paramRemoteCall)
    {
      this.zakc = paramRemoteCall;
      return this;
    }
    
    @Deprecated
    public Builder<A, L> unregister(BiConsumer<A, TaskCompletionSource<Boolean>> paramBiConsumer)
    {
      this.zakb = new zabz(this);
      return this;
    }
    
    public Builder<A, L> withHolder(ListenerHolder<L> paramListenerHolder)
    {
      this.zakd = paramListenerHolder;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\RegistrationMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */