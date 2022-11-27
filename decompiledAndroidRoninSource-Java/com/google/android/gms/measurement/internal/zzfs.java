package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

final class zzfs
  extends Thread
{
  private final Object zza;
  private final BlockingQueue<zzft<?>> zzb;
  private boolean zzc = false;
  
  public zzfs(String paramString, BlockingQueue<zzft<?>> paramBlockingQueue)
  {
    Preconditions.checkNotNull(paramBlockingQueue);
    Object localObject;
    Preconditions.checkNotNull(localObject);
    this.zza = new Object();
    this.zzb = ((BlockingQueue)localObject);
    setName(paramBlockingQueue);
  }
  
  private final void zza(InterruptedException paramInterruptedException)
  {
    this.zzd.zzq().zzh().zza(String.valueOf(getName()).concat(" was interrupted"), paramInterruptedException);
  }
  
  private final void zzb()
  {
    synchronized (zzfo.zzc(this.zzd))
    {
      if (!this.zzc)
      {
        zzfo.zza(this.zzd).release();
        zzfo.zzc(this.zzd).notifyAll();
        if (this == zzfo.zzd(this.zzd)) {
          zzfo.zza(this.zzd, null);
        } else if (this == zzfo.zze(this.zzd)) {
          zzfo.zzb(this.zzd, null);
        } else {
          this.zzd.zzq().zze().zza("Current scheduler thread is neither worker nor network");
        }
        this.zzc = true;
      }
      return;
    }
  }
  
  public final void run()
  {
    int i = 0;
    while (i == 0) {
      try
      {
        zzfo.zza(this.zzd).acquire();
        i = 1;
      }
      catch (InterruptedException localInterruptedException1)
      {
        zza(localInterruptedException1);
      }
    }
    for (;;)
    {
      try
      {
        int j = Process.getThreadPriority(Process.myTid());
        ??? = (zzft)this.zzb.poll();
        if (??? != null)
        {
          if (((zzft)???).zza)
          {
            i = j;
            Process.setThreadPriority(i);
            ((zzft)???).run();
          }
        }
        else {
          synchronized (this.zza)
          {
            if (this.zzb.peek() == null)
            {
              boolean bool = zzfo.zzb(this.zzd);
              if (!bool) {
                try
                {
                  this.zza.wait(30000L);
                }
                catch (InterruptedException localInterruptedException2)
                {
                  zza(localInterruptedException2);
                }
              }
            }
            synchronized (zzfo.zzc(this.zzd))
            {
              if (this.zzb.peek() == null)
              {
                if (this.zzd.zzs().zza(zzat.zzbq)) {
                  zzb();
                }
                return;
              }
            }
          }
        }
        i = 10;
      }
      finally
      {
        zzb();
      }
    }
  }
  
  public final void zza()
  {
    synchronized (this.zza)
    {
      this.zza.notifyAll();
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */