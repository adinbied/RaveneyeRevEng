package dji.midware.ble2.base;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class BleBackgroundHandler
{
  private static BleBackgroundHandler looper;
  public Handler handler;
  public HandlerThread handlerThread;
  
  private BleBackgroundHandler()
  {
    HandlerThread localHandlerThread = new HandlerThread("dji_ble_background_thread");
    this.handlerThread = localHandlerThread;
    localHandlerThread.start();
    this.handler = new Handler(this.handlerThread.getLooper());
  }
  
  public static BleBackgroundHandler get()
  {
    if (looper == null) {
      looper = new BleBackgroundHandler();
    }
    return looper;
  }
  
  public static Looper getLooper()
  {
    return get().handlerThread.getLooper();
  }
  
  public static void post(Runnable paramRunnable)
  {
    get().handler.post(paramRunnable);
  }
  
  public static void postDelayed(Runnable paramRunnable, long paramLong)
  {
    get().handler.postDelayed(paramRunnable, paramLong);
  }
  
  public static void remove(Runnable paramRunnable)
  {
    get().handler.removeCallbacks(paramRunnable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\base\BleBackgroundHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */