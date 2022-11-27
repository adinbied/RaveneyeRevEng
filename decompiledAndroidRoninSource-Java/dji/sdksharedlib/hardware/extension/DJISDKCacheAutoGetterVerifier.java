package dji.sdksharedlib.hardware.extension;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import dji.sdksharedlib.hardware.DJISDKCacheHWAbstractionLayer;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJISDKCacheListenerLayer;
import dji.sdksharedlib.listener.DJISDKCacheListenerLayer.OnChangeListener;
import java.util.concurrent.ConcurrentHashMap;

public class DJISDKCacheAutoGetterVerifier
{
  private static final int MSG_ADD = 1;
  private static final int MSG_COMPONENT_CHANGED = 3;
  private static final int MSG_REMOVE = 2;
  private static final int ONE_SECOND = 1000;
  private static final int PUSH_DATA_AUTOGET_INTERVAL = 0;
  private static final String TAG = "DJISDKCacheAutoGetterVerifier";
  private AutoGetterHandler autoGetterHandler;
  private DJISDKCacheHWAbstractionLayer hal;
  private HandlerThread handlerThread;
  private ConcurrentHashMap<DJISDKCacheKey, Signal> keyPathSignalMap;
  private DJISDKCacheListenerLayer listenerLayer;
  private DJISDKCacheListenerLayer.OnChangeListener onChangeListener;
  private DJISDKCacheCenterTimer timer;
  
  /* Error */
  private void addSignal(DJISDKCacheKey arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void refreshSignal()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void removeSignal(DJISDKCacheKey arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getCenterTimerIntervalListSize(int paramInt)
  {
    return this.timer.getCenterTimerIntervalSize(paramInt);
  }
  
  public int getCenterTimerMapSize()
  {
    return this.timer.getCenterTimerMapSize();
  }
  
  public int getSignalMapSize()
  {
    return this.keyPathSignalMap.size();
  }
  
  /* Error */
  public void init(DJISDKCacheHWAbstractionLayer arg1, DJISDKCacheListenerLayer arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.sdksharedlib.hardware.DJISDKCacheHWAbstractionLayer.AbstractionChangeEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class AutoGetterHandler
    extends Handler
  {
    public AutoGetterHandler(Looper paramLooper)
    {
      super();
    }
    
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public class Signal
    implements Runnable
  {
    private int interval = 0;
    private DJISDKCacheKey keyPath;
    
    public Signal(DJISDKCacheKey paramDJISDKCacheKey)
    {
      this.keyPath = paramDJISDKCacheKey;
    }
    
    public boolean equals(Object paramObject)
    {
      return false;
    }
    
    public int getInterval()
    {
      return this.interval;
    }
    
    public int hashCode()
    {
      return 0;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void setInterval(int paramInt)
    {
      this.interval = paramInt;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\extension\DJISDKCacheAutoGetterVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */