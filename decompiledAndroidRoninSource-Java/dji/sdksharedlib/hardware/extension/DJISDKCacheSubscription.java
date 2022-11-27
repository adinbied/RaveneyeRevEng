package dji.sdksharedlib.hardware.extension;

import android.os.Handler;
import android.os.HandlerThread;
import dji.log.DJILog;
import dji.midware.data.config.P3.Ccode;
import dji.midware.interfaces.DJIDataCallBack;

public abstract class DJISDKCacheSubscription
{
  private static final int SECOND = 1000;
  private static final String TAG = "DJISDKCacheSubscription";
  private static Handler handler;
  private static HandlerThread subscriptionTimeOutHandlerThread;
  protected DJIDataCallBack callback = new DJIDataCallBack()
  {
    public void onFailure(Ccode paramAnonymousCcode) {}
    
    public void onSuccess(Object paramAnonymousObject)
    {
      DJISDKCacheSubscription.this.startCountingTimer();
    }
  };
  protected boolean hasAlreadySubscribed;
  protected Runnable turnOffRunnable = new Runnable()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  };
  protected Runnable turnOnRunnable = new Runnable()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  };
  
  public DJISDKCacheSubscription()
  {
    HandlerThread localHandlerThread = new HandlerThread("DJISDKCacheSubscription");
    subscriptionTimeOutHandlerThread = localHandlerThread;
    localHandlerThread.start();
    handler = new Handler(subscriptionTimeOutHandlerThread.getLooper());
    DJILog.d("SDR", "ss", new Object[0]);
  }
  
  /* Error */
  private void refreshTimer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void startCountingTimer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean hasAlreadySubscribed()
  {
    try
    {
      boolean bool = this.hasAlreadySubscribed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void turnOffSubscription();
  
  protected abstract void turnOnSubscription();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\extension\DJISDKCacheSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */