package com.google.android.gms.common.providers;

import java.util.concurrent.ScheduledExecutorService;

public class PooledExecutorsProvider
{
  private static PooledExecutorFactory zzey;
  
  public static PooledExecutorFactory getInstance()
  {
    try
    {
      if (zzey == null) {
        zzey = new zza();
      }
      PooledExecutorFactory localPooledExecutorFactory = zzey;
      return localPooledExecutorFactory;
    }
    finally {}
  }
  
  public static abstract interface PooledExecutorFactory
  {
    public abstract ScheduledExecutorService newSingleThreadScheduledExecutor();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\providers\PooledExecutorsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */