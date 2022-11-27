package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzm;
import com.google.android.gms.internal.measurement.zzn;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

final class zzft<V>
  extends FutureTask<V>
  implements Comparable<zzft<V>>
{
  final boolean zza;
  private final long zzb;
  private final String zzc;
  
  zzft(zzfo paramzzfo, Runnable paramRunnable, boolean paramBoolean, String paramString)
  {
    super(zzm.zza().zza(paramRunnable), null);
    Preconditions.checkNotNull(paramString);
    long l = zzfo.zzg().getAndIncrement();
    this.zzb = l;
    this.zzc = paramString;
    this.zza = paramBoolean;
    if (l == Long.MAX_VALUE) {
      paramzzfo.zzq().zze().zza("Tasks index overflow");
    }
  }
  
  zzft(Callable<V> paramCallable, boolean paramBoolean, String paramString)
  {
    super(zzm.zza().zza(paramBoolean));
    Object localObject;
    Preconditions.checkNotNull(localObject);
    long l = zzfo.zzg().getAndIncrement();
    this.zzb = l;
    this.zzc = ((String)localObject);
    this.zza = paramString;
    if (l == Long.MAX_VALUE) {
      paramCallable.zzq().zze().zza("Tasks index overflow");
    }
  }
  
  protected final void setException(Throwable paramThrowable)
  {
    this.zzd.zzq().zze().zza(this.zzc, paramThrowable);
    if ((paramThrowable instanceof zzfr)) {
      Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), paramThrowable);
    }
    super.setException(paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */