package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BlockingServiceConnection
  implements ServiceConnection
{
  private boolean zze = false;
  private final BlockingQueue<IBinder> zzf = new LinkedBlockingQueue();
  
  public IBinder getService()
    throws InterruptedException
  {
    Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
    if (!this.zze)
    {
      this.zze = true;
      return (IBinder)this.zzf.take();
    }
    throw new IllegalStateException("Cannot call get on this connection more than once");
  }
  
  public IBinder getServiceWithTimeout(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, TimeoutException
  {
    Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
    if (!this.zze)
    {
      this.zze = true;
      paramTimeUnit = (IBinder)this.zzf.poll(paramLong, paramTimeUnit);
      if (paramTimeUnit != null) {
        return paramTimeUnit;
      }
      throw new TimeoutException("Timed out waiting for the service connection");
    }
    throw new IllegalStateException("Cannot call get on this connection more than once");
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.zzf.add(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\BlockingServiceConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */