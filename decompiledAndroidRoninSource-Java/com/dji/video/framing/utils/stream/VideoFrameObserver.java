package com.dji.video.framing.utils.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class VideoFrameObserver
{
  private static final boolean ENABLE = false;
  private static final int H264_PARSE_KEY_OFFSET = 5;
  private static final int INFO_MAP_MAX_SIZE = 300;
  private static final String TAG = "VideoFrameObserver";
  private static VideoFrameObserver instance;
  private HashMap<Long, VideoFrameInfo> frameInfoMap;
  private ReentrantReadWriteLock frameInfoMapKeyLock;
  private ReentrantReadWriteLock.ReadLock frameInfoMapKeyRLock;
  private ReentrantReadWriteLock.WriteLock frameInfoMapKeyWLock;
  private Queue<Long> keyQueue;
  
  private VideoFrameObserver()
  {
    ReentrantReadWriteLock localReentrantReadWriteLock = new ReentrantReadWriteLock();
    this.frameInfoMapKeyLock = localReentrantReadWriteLock;
    this.frameInfoMapKeyRLock = localReentrantReadWriteLock.readLock();
    this.frameInfoMapKeyWLock = this.frameInfoMapKeyLock.writeLock();
    this.frameInfoMap = new HashMap();
    this.keyQueue = new LinkedList();
  }
  
  /* Error */
  private void addFrameInfoToMap(long arg1, VideoFrameInfo arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  public static void destroy()
  {
    VideoFrameObserver localVideoFrameObserver = instance;
    if (localVideoFrameObserver != null) {
      localVideoFrameObserver.clean();
    }
    instance = null;
  }
  
  private int getAudLength(byte[] paramArrayOfByte, int paramInt)
  {
    return 0;
  }
  
  private String getByteString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public static VideoFrameObserver getInstance()
  {
    if (instance == null) {
      instance = new VideoFrameObserver();
    }
    return instance;
  }
  
  private long getKey(byte[] paramArrayOfByte, int paramInt)
  {
    return 211068758L;
  }
  
  private static boolean isContainSubArr(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length + paramInt < paramArrayOfByte1.length)) {
      return Arrays.equals(Arrays.copyOfRange(paramArrayOfByte1, paramInt, paramArrayOfByte2.length + paramInt), paramArrayOfByte2);
    }
    return false;
  }
  
  private VideoFrameInfo pollFrameInfo(long paramLong)
  {
    return null;
  }
  
  /* Error */
  public void clean()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public VideoFrameInfo saveTimeStamp(TimeSavingPoint paramTimeSavingPoint, long paramLong, boolean paramBoolean)
  {
    return null;
  }
  
  public VideoFrameInfo saveTimeStamp(TimeSavingPoint paramTimeSavingPoint, byte[] paramArrayOfByte, int paramInt, long paramLong, boolean paramBoolean)
  {
    return null;
  }
  
  public VideoFrameInfo saveTimeStamp(TimeSavingPoint paramTimeSavingPoint, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    return null;
  }
  
  public static enum TimeSavingPoint
  {
    static
    {
      BeforeQueueToCodec = new TimeSavingPoint("BeforeQueueToCodec", 2);
      TimeSavingPoint localTimeSavingPoint = new TimeSavingPoint("OutputFrame", 3);
      OutputFrame = localTimeSavingPoint;
      $VALUES = new TimeSavingPoint[] { UsbGetBody, VideoDataRecv, BeforeQueueToCodec, localTimeSavingPoint };
    }
    
    private TimeSavingPoint() {}
  }
  
  public static class VideoFrameInfo
  {
    public long comPts = -1L;
    public long key;
    public long[] timeStampArr = new long[VideoFrameObserver.TimeSavingPoint.values().length];
    
    public VideoFrameInfo(long paramLong)
    {
      this.key = paramLong;
    }
    
    public long getTimeStamp(VideoFrameObserver.TimeSavingPoint paramTimeSavingPoint)
    {
      return 211068679L;
    }
    
    public void setTimeStamp(VideoFrameObserver.TimeSavingPoint paramTimeSavingPoint)
    {
      setTimeStamp(paramTimeSavingPoint, System.currentTimeMillis());
    }
    
    /* Error */
    public void setTimeStamp(VideoFrameObserver.TimeSavingPoint arg1, long arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static abstract interface VideoFrameObservingListener
  {
    public abstract void onProcessComplete(VideoFrameObserver.VideoFrameInfo paramVideoFrameInfo);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\stream\VideoFrameObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */