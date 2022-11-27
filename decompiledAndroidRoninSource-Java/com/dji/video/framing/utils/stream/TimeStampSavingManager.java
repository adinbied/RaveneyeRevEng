package com.dji.video.framing.utils.stream;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.LinkedList;
import java.util.List;

public class TimeStampSavingManager
{
  private static final int LISTENERS_INVOKING_INTERVAL = 1000;
  private static final int MSG_INVOKE_LISTENERS = 0;
  private static TimeStampSavingManager instance;
  private boolean isRunning = false;
  private Handler listenerHandler;
  private List<TimeStampSavingListener> listenerList = new LinkedList();
  private Object listenerLock = new Object();
  private HandlerThread listenerThread;
  private TimeStampSaver[] saverList = new TimeStampSaver[TimeStampSavePoint.values().length];
  
  public static TimeStampSavingManager getInstance()
  {
    if (instance == null) {
      instance = new TimeStampSavingManager();
    }
    return instance;
  }
  
  private TimeStampSaver getSaverInstance(TimeStampSavePoint paramTimeStampSavePoint)
  {
    return null;
  }
  
  /* Error */
  private void invokeListeners(List<TimeStampSaver.TimeStampSaverData> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void startListenerThread()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void stopListenerThread()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addListener(TimeStampSavingListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void clearListeners()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean isRunning()
  {
    return this.isRunning;
  }
  
  /* Error */
  public void removeListener(TimeStampSavingListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void saveTimeStamp(TimeStampSavePoint arg1, long arg2, long arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void saveTimeStamp(TimeStampSavePoint arg1, byte[] arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void start()
  {
    startListenerThread();
    this.isRunning = true;
  }
  
  public void stop()
  {
    this.isRunning = false;
    stopListenerThread();
  }
  
  public static enum TimeStampSavePoint
  {
    static
    {
      DecoderQueueIn = new TimeStampSavePoint("DecoderQueueIn", 4);
      DecoderInput = new TimeStampSavePoint("DecoderInput", 5);
      GlYuvSurfaceDisplay = new TimeStampSavePoint("GlYuvSurfaceDisplay", 6);
      TimeStampSavePoint localTimeStampSavePoint = new TimeStampSavePoint("Unknown", 7);
      Unknown = localTimeStampSavePoint;
      $VALUES = new TimeStampSavePoint[] { UsbOnGetBodyStream, UsbPutVideoBuffer, UsbToTrans, VideoRecv, DecoderQueueIn, DecoderInput, GlYuvSurfaceDisplay, localTimeStampSavePoint };
    }
    
    private TimeStampSavePoint() {}
  }
  
  public static abstract interface TimeStampSavingListener
  {
    public abstract void onDataUpdated(List<TimeStampSaver.TimeStampSaverData> paramList);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\stream\TimeStampSavingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */