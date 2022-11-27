package com.dji.video.framing.utils.stream;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StreamDataObserver
{
  private static final int MSG_OBSERVING = 0;
  public static final String PARAM_BYTE_RATE = "byte_rate";
  public static final String PARAM_DELAY_TIME = "phase_delay_time";
  public static final String PARAM_FRAME_RATE = "frame_rate";
  public static final String PARAM_HEIGHT = "height";
  public static final String PARAM_KEYFRAME_NUM = "key_frame_num";
  public static final String PARAM_SPSPPS_NUM = "sps_pps_num";
  public static final String PARAM_TOTAL_BYTE_COUNT = "total_byte_count";
  public static final String PARAM_TOTAL_FRAME_COUNT = "total_frame_count";
  public static final String PARAM_WIDTH = "width";
  private static boolean isRunning;
  private static List<IStreamDataObserverGlobalListener> listenerList = new LinkedList();
  private static final Object listenerLock = new Object();
  private static Object mapLock = new Object();
  private static StreamDataObserver[] observerArray = new StreamDataObserver[ObservingPoint.values().length];
  private static Map<String, Map<String, Long>> sGlobalRst;
  private static Handler sObservingHandler;
  private static HandlerThread sObservingThread;
  private ObservingPoint observingPoint;
  private long[] paramArr;
  
  private StreamDataObserver(ObservingPoint paramObservingPoint)
  {
    this.observingPoint = paramObservingPoint;
    paramObservingPoint = new long[ObservingContext.values().length];
    this.paramArr = paramObservingPoint;
    Arrays.fill(paramObservingPoint, -1L);
  }
  
  public static void addListener(IStreamDataObserverGlobalListener paramIStreamDataObserverGlobalListener)
  {
    Object localObject = listenerLock;
    if (paramIStreamDataObserverGlobalListener != null) {}
    try
    {
      if (!listenerList.contains(paramIStreamDataObserverGlobalListener))
      {
        listenerList.add(paramIStreamDataObserverGlobalListener);
        if (!isObserving()) {
          startObserving();
        }
      }
      return;
    }
    finally {}
  }
  
  public static Set<String> getDescSet()
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    StreamDataObserver[] arrayOfStreamDataObserver = observerArray;
    int j = arrayOfStreamDataObserver.length;
    int i = 0;
    while (i < j)
    {
      StreamDataObserver localStreamDataObserver = arrayOfStreamDataObserver[i];
      if (localStreamDataObserver != null) {
        localLinkedHashSet.add(localStreamDataObserver.observingPoint.getDesc());
      }
      i += 1;
    }
    return localLinkedHashSet;
  }
  
  public static StreamDataObserver getInstance(ObservingPoint paramObservingPoint)
  {
    StreamDataObserver localStreamDataObserver2 = observerArray[paramObservingPoint.ordinal()];
    StreamDataObserver localStreamDataObserver1 = localStreamDataObserver2;
    if (localStreamDataObserver2 == null)
    {
      localStreamDataObserver1 = new StreamDataObserver(paramObservingPoint);
      observerArray[paramObservingPoint.ordinal()] = localStreamDataObserver1;
    }
    return localStreamDataObserver1;
  }
  
  public static Set<String> getKeys()
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    StreamDataObserver[] arrayOfStreamDataObserver = observerArray;
    int j = arrayOfStreamDataObserver.length;
    int i = 0;
    while (i < j)
    {
      StreamDataObserver localStreamDataObserver = arrayOfStreamDataObserver[i];
      if (localStreamDataObserver != null) {
        localLinkedHashSet.add(localStreamDataObserver.observingPoint.getPos());
      }
      i += 1;
    }
    return localLinkedHashSet;
  }
  
  private static void invokeGlobalListener(Map<String, Map<String, Long>> paramMap)
  {
    synchronized (listenerLock)
    {
      Iterator localIterator = listenerList.iterator();
      while (localIterator.hasNext()) {
        ((IStreamDataObserverGlobalListener)localIterator.next()).onByteRatesUpdate(paramMap);
      }
      return;
    }
  }
  
  public static boolean isObserving()
  {
    return isRunning;
  }
  
  private Map<String, Long> onObservingData()
  {
    return null;
  }
  
  public static void removeListener(IStreamDataObserverGlobalListener paramIStreamDataObserverGlobalListener)
  {
    synchronized (listenerLock)
    {
      if (listenerList.contains(paramIStreamDataObserverGlobalListener))
      {
        listenerList.remove(paramIStreamDataObserverGlobalListener);
        if ((isObserving()) && (listenerList.isEmpty())) {
          stopObserving();
        }
      }
      return;
    }
  }
  
  /* Error */
  private void resetParamMap()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static void startObserving()
  {
    if ((sObservingThread != null) || (sObservingHandler != null)) {
      stopObserving();
    }
    Object localObject = new HandlerThread("stream data observing thread");
    sObservingThread = (HandlerThread)localObject;
    ((HandlerThread)localObject).start();
    localObject = new Handler(sObservingThread.getLooper())
    {
      /* Error */
      public void handleMessage(android.os.Message arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    };
    sObservingHandler = (Handler)localObject;
    ((Handler)localObject).sendEmptyMessage(0);
    isRunning = true;
  }
  
  private static void stopObserving()
  {
    Object localObject = sObservingHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      sObservingHandler = null;
    }
    isRunning = false;
    localObject = sObservingThread;
    if (localObject != null)
    {
      if (((HandlerThread)localObject).isAlive()) {
        if (Build.VERSION.SDK_INT >= 18) {
          sObservingThread.quitSafely();
        } else {
          sObservingThread.quit();
        }
      }
      sObservingThread = null;
    }
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public StreamDataObserver onDataRecv(ObservingContext paramObservingContext, long paramLong)
  {
    return null;
  }
  
  public static abstract interface IStreamDataObserverGlobalListener
  {
    public abstract void onByteRatesUpdate(Map<String, Map<String, Long>> paramMap);
  }
  
  public static enum ObservingContext
  {
    private String desc;
    
    static
    {
      FrameRate = new ObservingContext("FrameRate", 2, "frame_rate");
      TotalFrameCount = new ObservingContext("TotalFrameCount", 3, "total_frame_count");
      Width = new ObservingContext("Width", 4, "width");
      Height = new ObservingContext("Height", 5, "height");
      KeyframeNum = new ObservingContext("KeyframeNum", 6, "key_frame_num");
      SpsppsNum = new ObservingContext("SpsppsNum", 7, "sps_pps_num");
      ObservingContext localObservingContext = new ObservingContext("DelayTime", 8, "phase_delay_time");
      DelayTime = localObservingContext;
      $VALUES = new ObservingContext[] { ByteRate, TotalByteCount, FrameRate, TotalFrameCount, Width, Height, KeyframeNum, SpsppsNum, localObservingContext };
    }
    
    private ObservingContext(String paramString)
    {
      this.desc = paramString;
    }
    
    public String toString()
    {
      return this.desc;
    }
  }
  
  public static enum ObservingPoint
  {
    private String desc;
    private String pos;
    
    static
    {
      DecoderQueueIn = new ObservingPoint("DecoderQueueIn", 2, "DJIVideoDecoder.onServerQueuein", "解码输入线程DecodeServer接收视频流");
      DecoderQueueToCodec = new ObservingPoint("DecoderQueueToCodec", 3, "DJIVideoDecoder.queueToCodec", "进入系统硬解码器前视频流");
      DecoderOutputFrame = new ObservingPoint("DecoderOutputFrame", 4, "AbsDjiDecodeServer.onOutputFrame", "硬解码器出来的数据");
      ObservingPoint localObservingPoint = new ObservingPoint("GlyuvSurfaceDisplay", 5, "GLYUVSurface.display", "解码后渲染");
      GlyuvSurfaceDisplay = localObservingPoint;
      $VALUES = new ObservingPoint[] { SwUdpServiceParse, VideoDataFramed, DecoderQueueIn, DecoderQueueToCodec, DecoderOutputFrame, localObservingPoint };
    }
    
    private ObservingPoint(String paramString1, String paramString2)
    {
      this.pos = paramString1;
      this.desc = paramString2;
    }
    
    public String getDesc()
    {
      return this.desc;
    }
    
    public String getDescId()
    {
      return this.desc;
    }
    
    public String getPos()
    {
      return this.pos;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\stream\StreamDataObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */