package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class zzu<TResult>
  extends Task<TResult>
{
  private final Object mLock = new Object();
  private TResult zzaa;
  private Exception zzab;
  private final zzr<TResult> zzx = new zzr();
  private boolean zzy;
  private volatile boolean zzz;
  
  private final void zzb()
  {
    Preconditions.checkState(this.zzy, "Task is not yet complete");
  }
  
  private final void zzc()
  {
    Preconditions.checkState(this.zzy ^ true, "Task is already complete");
  }
  
  private final void zzd()
  {
    if (!this.zzz) {
      return;
    }
    throw new CancellationException("Task is already canceled.");
  }
  
  private final void zze()
  {
    synchronized (this.mLock)
    {
      if (!this.zzy) {
        return;
      }
      this.zzx.zza(this);
      return;
    }
  }
  
  public final Task<TResult> addOnCanceledListener(Activity paramActivity, OnCanceledListener paramOnCanceledListener)
  {
    paramOnCanceledListener = new zzg(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
    this.zzx.zza(paramOnCanceledListener);
    zza.zza(paramActivity).zzb(paramOnCanceledListener);
    zze();
    return this;
  }
  
  public final Task<TResult> addOnCanceledListener(OnCanceledListener paramOnCanceledListener)
  {
    return addOnCanceledListener(TaskExecutors.MAIN_THREAD, paramOnCanceledListener);
  }
  
  public final Task<TResult> addOnCanceledListener(Executor paramExecutor, OnCanceledListener paramOnCanceledListener)
  {
    this.zzx.zza(new zzg(paramExecutor, paramOnCanceledListener));
    zze();
    return this;
  }
  
  public final Task<TResult> addOnCompleteListener(Activity paramActivity, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    paramOnCompleteListener = new zzi(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
    this.zzx.zza(paramOnCompleteListener);
    zza.zza(paramActivity).zzb(paramOnCompleteListener);
    zze();
    return this;
  }
  
  public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> paramOnCompleteListener)
  {
    return addOnCompleteListener(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
  }
  
  public final Task<TResult> addOnCompleteListener(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    this.zzx.zza(new zzi(paramExecutor, paramOnCompleteListener));
    zze();
    return this;
  }
  
  public final Task<TResult> addOnFailureListener(Activity paramActivity, OnFailureListener paramOnFailureListener)
  {
    paramOnFailureListener = new zzk(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    this.zzx.zza(paramOnFailureListener);
    zza.zza(paramActivity).zzb(paramOnFailureListener);
    zze();
    return this;
  }
  
  public final Task<TResult> addOnFailureListener(OnFailureListener paramOnFailureListener)
  {
    return addOnFailureListener(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
  }
  
  public final Task<TResult> addOnFailureListener(Executor paramExecutor, OnFailureListener paramOnFailureListener)
  {
    this.zzx.zza(new zzk(paramExecutor, paramOnFailureListener));
    zze();
    return this;
  }
  
  public final Task<TResult> addOnSuccessListener(Activity paramActivity, OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    paramOnSuccessListener = new zzm(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    this.zzx.zza(paramOnSuccessListener);
    zza.zza(paramActivity).zzb(paramOnSuccessListener);
    zze();
    return this;
  }
  
  public final Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    return addOnSuccessListener(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
  }
  
  public final Task<TResult> addOnSuccessListener(Executor paramExecutor, OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    this.zzx.zza(new zzm(paramExecutor, paramOnSuccessListener));
    zze();
    return this;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> paramContinuation)
  {
    return continueWith(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor paramExecutor, Continuation<TResult, TContinuationResult> paramContinuation)
  {
    zzu localzzu = new zzu();
    this.zzx.zza(new zzc(paramExecutor, paramContinuation, localzzu));
    zze();
    return localzzu;
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    return continueWithTask(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor paramExecutor, Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    zzu localzzu = new zzu();
    this.zzx.zza(new zze(paramExecutor, paramContinuation, localzzu));
    zze();
    return localzzu;
  }
  
  public final Exception getException()
  {
    synchronized (this.mLock)
    {
      Exception localException = this.zzab;
      return localException;
    }
  }
  
  public final TResult getResult()
  {
    synchronized (this.mLock)
    {
      zzb();
      zzd();
      if (this.zzab == null)
      {
        Object localObject2 = this.zzaa;
        return (TResult)localObject2;
      }
      throw new RuntimeExecutionException(this.zzab);
    }
  }
  
  public final <X extends Throwable> TResult getResult(Class<X> paramClass)
    throws Throwable
  {
    synchronized (this.mLock)
    {
      zzb();
      zzd();
      if (!paramClass.isInstance(this.zzab))
      {
        if (this.zzab == null)
        {
          paramClass = this.zzaa;
          return paramClass;
        }
        throw new RuntimeExecutionException(this.zzab);
      }
      throw ((Throwable)paramClass.cast(this.zzab));
    }
  }
  
  public final boolean isCanceled()
  {
    return this.zzz;
  }
  
  public final boolean isComplete()
  {
    synchronized (this.mLock)
    {
      boolean bool = this.zzy;
      return bool;
    }
  }
  
  public final boolean isSuccessful()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if ((this.zzy) && (!this.zzz) && (this.zzab == null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation)
  {
    return onSuccessTask(TaskExecutors.MAIN_THREAD, paramSuccessContinuation);
  }
  
  public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor paramExecutor, SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation)
  {
    zzu localzzu = new zzu();
    this.zzx.zza(new zzo(paramExecutor, paramSuccessContinuation, localzzu));
    zze();
    return localzzu;
  }
  
  public final void setException(Exception paramException)
  {
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.mLock)
    {
      zzc();
      this.zzy = true;
      this.zzab = paramException;
      this.zzx.zza(this);
      return;
    }
  }
  
  public final void setResult(TResult paramTResult)
  {
    synchronized (this.mLock)
    {
      zzc();
      this.zzy = true;
      this.zzaa = paramTResult;
      this.zzx.zza(this);
      return;
    }
  }
  
  public final boolean trySetException(Exception paramException)
  {
    Preconditions.checkNotNull(paramException, "Exception must not be null");
    synchronized (this.mLock)
    {
      if (this.zzy) {
        return false;
      }
      this.zzy = true;
      this.zzab = paramException;
      this.zzx.zza(this);
      return true;
    }
  }
  
  public final boolean trySetResult(TResult paramTResult)
  {
    synchronized (this.mLock)
    {
      if (this.zzy) {
        return false;
      }
      this.zzy = true;
      this.zzaa = paramTResult;
      this.zzx.zza(this);
      return true;
    }
  }
  
  public final boolean zza()
  {
    synchronized (this.mLock)
    {
      if (this.zzy) {
        return false;
      }
      this.zzy = true;
      this.zzz = true;
      this.zzx.zza(this);
      return true;
    }
  }
  
  private static class zza
    extends LifecycleCallback
  {
    private final List<WeakReference<zzq<?>>> zzac = new ArrayList();
    
    private zza(LifecycleFragment paramLifecycleFragment)
    {
      super();
      this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
    }
    
    public static zza zza(Activity paramActivity)
    {
      LifecycleFragment localLifecycleFragment = getFragment(paramActivity);
      zza localzza = (zza)localLifecycleFragment.getCallbackOrNull("TaskOnStopCallback", zza.class);
      paramActivity = localzza;
      if (localzza == null) {
        paramActivity = new zza(localLifecycleFragment);
      }
      return paramActivity;
    }
    
    public void onStop()
    {
      synchronized (this.zzac)
      {
        Iterator localIterator = this.zzac.iterator();
        while (localIterator.hasNext())
        {
          zzq localzzq = (zzq)((WeakReference)localIterator.next()).get();
          if (localzzq != null) {
            localzzq.cancel();
          }
        }
        this.zzac.clear();
        return;
      }
    }
    
    public final <T> void zzb(zzq<T> paramzzq)
    {
      synchronized (this.zzac)
      {
        this.zzac.add(new WeakReference(paramzzq));
        return;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */