package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzen
  extends zzcr
{
  private final BaseImplementation.ResultHolder<Status> zzev;
  
  public zzen(BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    this.zzev = paramResultHolder;
  }
  
  public static zzen zza(TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    return new zzen(new zzeo(paramTaskCompletionSource));
  }
  
  public static zzen zzb(TaskCompletionSource<Boolean> paramTaskCompletionSource)
  {
    return new zzen(new zzep(paramTaskCompletionSource));
  }
  
  public final void onResult(Status paramStatus)
  {
    this.zzev.setResult(paramStatus);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */