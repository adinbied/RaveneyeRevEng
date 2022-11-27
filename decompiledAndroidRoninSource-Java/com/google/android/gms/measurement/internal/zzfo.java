package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfo
  extends zzgr
{
  private static final AtomicLong zzj = new AtomicLong(Long.MIN_VALUE);
  private zzfs zza;
  private zzfs zzb;
  private final PriorityBlockingQueue<zzft<?>> zzc = new PriorityBlockingQueue();
  private final BlockingQueue<zzft<?>> zzd = new LinkedBlockingQueue();
  private final Thread.UncaughtExceptionHandler zze = new zzfq(this, "Thread death: Uncaught exception on worker thread");
  private final Thread.UncaughtExceptionHandler zzf = new zzfq(this, "Thread death: Uncaught exception on network thread");
  private final Object zzg = new Object();
  private final Semaphore zzh = new Semaphore(2);
  private volatile boolean zzi;
  
  zzfo(zzfv paramzzfv)
  {
    super(paramzzfv);
  }
  
  private final void zza(zzft<?> paramzzft)
  {
    synchronized (this.zzg)
    {
      this.zzc.add(paramzzft);
      if (this.zza == null)
      {
        paramzzft = new zzfs(this, "Measurement Worker", this.zzc);
        this.zza = paramzzft;
        paramzzft.setUncaughtExceptionHandler(this.zze);
        this.zza.start();
      }
      else
      {
        this.zza.zza();
      }
      return;
    }
  }
  
  final <T> T zza(AtomicReference<T> paramAtomicReference, long paramLong, String paramString, Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        zzp().zza(paramRunnable);
      }
      finally {}
      try
      {
        paramAtomicReference.wait(paramLong);
        paramRunnable = paramAtomicReference.get();
        if (paramRunnable == null)
        {
          zzet localzzet = zzq().zzh();
          paramAtomicReference = String.valueOf(paramString);
          if (paramAtomicReference.length() != 0) {
            paramAtomicReference = "Timed out waiting for ".concat(paramAtomicReference);
          } else {
            paramAtomicReference = new String("Timed out waiting for ");
          }
          localzzet.zza(paramAtomicReference);
        }
        return paramRunnable;
      }
      catch (InterruptedException paramRunnable) {}
    }
    paramRunnable = zzq().zzh();
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Interrupted waiting for ".concat(paramString);
    } else {
      paramString = new String("Interrupted waiting for ");
    }
    paramRunnable.zza(paramString);
    return null;
  }
  
  public final <V> Future<V> zza(Callable<V> paramCallable)
    throws IllegalStateException
  {
    zzaa();
    Preconditions.checkNotNull(paramCallable);
    paramCallable = new zzft(this, paramCallable, false, "Task exception on worker thread");
    if (Thread.currentThread() == this.zza)
    {
      if (!this.zzc.isEmpty()) {
        zzq().zzh().zza("Callable skipped the worker queue.");
      }
      paramCallable.run();
      return paramCallable;
    }
    zza(paramCallable);
    return paramCallable;
  }
  
  public final void zza(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzaa();
    Preconditions.checkNotNull(paramRunnable);
    zza(new zzft(this, paramRunnable, false, "Task exception on worker thread"));
  }
  
  public final <V> Future<V> zzb(Callable<V> paramCallable)
    throws IllegalStateException
  {
    zzaa();
    Preconditions.checkNotNull(paramCallable);
    paramCallable = new zzft(this, paramCallable, true, "Task exception on worker thread");
    if (Thread.currentThread() == this.zza)
    {
      paramCallable.run();
      return paramCallable;
    }
    zza(paramCallable);
    return paramCallable;
  }
  
  public final void zzb()
  {
    if (Thread.currentThread() == this.zzb) {
      return;
    }
    throw new IllegalStateException("Call expected from network thread");
  }
  
  public final void zzb(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzaa();
    Preconditions.checkNotNull(paramRunnable);
    zza(new zzft(this, paramRunnable, true, "Task exception on worker thread"));
  }
  
  public final void zzc()
  {
    if (Thread.currentThread() == this.zza) {
      return;
    }
    throw new IllegalStateException("Call expected from worker thread");
  }
  
  public final void zzc(Runnable arg1)
    throws IllegalStateException
  {
    zzaa();
    Preconditions.checkNotNull(???);
    Object localObject1 = new zzft(this, ???, false, "Task exception on network thread");
    synchronized (this.zzg)
    {
      this.zzd.add(localObject1);
      if (this.zzb == null)
      {
        localObject1 = new zzfs(this, "Measurement Network", this.zzd);
        this.zzb = ((zzfs)localObject1);
        ((zzfs)localObject1).setUncaughtExceptionHandler(this.zzf);
        this.zzb.start();
      }
      else
      {
        this.zzb.zza();
      }
      return;
    }
  }
  
  protected final boolean zzd()
  {
    return false;
  }
  
  public final boolean zzf()
  {
    return Thread.currentThread() == this.zza;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */