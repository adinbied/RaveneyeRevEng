package com.google.android.gms.internal.measurement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zzk
  implements zzj
{
  private static ExecutorService zza(int paramInt1, ThreadFactory paramThreadFactory, int paramInt2)
  {
    paramThreadFactory = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), paramThreadFactory);
    paramThreadFactory.allowCoreThreadTimeOut(true);
    return Executors.unconfigurableExecutorService(paramThreadFactory);
  }
  
  public final ExecutorService zza(int paramInt)
  {
    return zza(1, Executors.defaultThreadFactory(), paramInt);
  }
  
  public final ExecutorService zza(ThreadFactory paramThreadFactory, int paramInt)
  {
    return zza(1, paramThreadFactory, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */