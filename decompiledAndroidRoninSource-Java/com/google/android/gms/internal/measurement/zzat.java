package com.google.android.gms.internal.measurement;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class zzat
  implements ThreadFactory
{
  private ThreadFactory zza = Executors.defaultThreadFactory();
  
  zzat(zzag paramzzag) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = this.zza.newThread(paramRunnable);
    paramRunnable.setName("ScionFrontendApi");
    return paramRunnable;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */