package com.google.firebase.analytics;

import com.google.android.gms.internal.measurement.zzm;
import com.google.android.gms.internal.measurement.zzn;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zzb
  extends ThreadPoolExecutor
{
  zzb(FirebaseAnalytics paramFirebaseAnalytics, int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue paramBlockingQueue)
  {
    super(0, 1, 30L, paramTimeUnit, paramBlockingQueue);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    super.execute(zzm.zza().zza(paramRunnable));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\analytics\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */