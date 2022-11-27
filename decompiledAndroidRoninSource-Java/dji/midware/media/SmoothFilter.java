package dji.midware.media;

import dji.midware.data.model.P3.DataCameraGetMode.MODE;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SmoothFilter
{
  private static final int CHECK_TIME = 2000;
  private static final int DELAY_TIME = 80;
  public static boolean enableSmoothFilter = true;
  static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  public final String TAG = "SmoothFilter";
  private int cacheNum = -1;
  private Callback callback;
  private DataCameraGetMode.MODE cameraMode = null;
  private int dataCount = 0;
  private BlockingQueue<Object> dataQueue = new ArrayBlockingQueue(1000);
  private int interval = -1;
  private boolean isStop = true;
  private long lastCheckTime = -1L;
  private long lastInputTime;
  private long lastOutputDataTime = 0L;
  private long lastTime = 0L;
  private Runnable runnable = new Runnable()
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
  private Thread thread;
  
  public static String getStringDate()
  {
    Date localDate = new Date();
    return formatter.format(localDate);
  }
  
  /* Error */
  private void invokeCallback(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void log(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void outputData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void updateInterval(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isSupportProduct()
  {
    return false;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3MainThread(dji.midware.data.model.P3.DataCameraGetPushStateInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void putData(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setCallback(Callback paramCallback)
  {
    this.callback = paramCallback;
  }
  
  /* Error */
  public void uninit()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface Callback
  {
    public abstract void outputData(Object paramObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\SmoothFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */