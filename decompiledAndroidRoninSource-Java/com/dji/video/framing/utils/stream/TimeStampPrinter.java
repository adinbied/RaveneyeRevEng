package com.dji.video.framing.utils.stream;

import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Pools.SynchronizedPool;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class TimeStampPrinter
{
  private static final int FRAME_INFO_QUEUE_MAX_SIZE = 50;
  private static final int GEN_ID_DEFAULT_OFFSET = 6;
  private static final int MSG_ADD_LISTENER = 1;
  private static final int MSG_CLEAR_LISTENER = 3;
  private static final int MSG_OUTPUT = 0;
  private static final int MSG_REMOVE_LISTENER = 2;
  private static final String TAG = "TimeStampPrinter";
  private static TimeStampPrinter instance;
  private boolean enable = false;
  private FrameInfoQueue frameInfoQueue = new FrameInfoQueue(null);
  private Handler handler = new Handler(Looper.getMainLooper())
  {
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private LinkedList<VideoProcessTimeListener> listenerList = new LinkedList();
  
  public static TimeStampPrinter getInstance()
  {
    if (instance == null) {
      instance = new TimeStampPrinter();
    }
    return instance;
  }
  
  private long getTimeStampId(byte[] paramArrayOfByte)
  {
    return 211068351L;
  }
  
  /* Error */
  private void outputRst(FrameInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void start()
  {
    this.enable = true;
  }
  
  /* Error */
  private void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addListener(VideoProcessTimeListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void clearListeners()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onVideoDataProcessing(VideoProcessPoint paramVideoProcessPoint, byte[] paramArrayOfByte) {}
  
  /* Error */
  public void onVideoDataProcessing(VideoProcessPoint arg1, byte[] arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void removeListener(VideoProcessTimeListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class FrameInfo
  {
    private static Pools.SynchronizedPool<FrameInfo> sPool = new Pools.SynchronizedPool(100);
    private static final long[] zeroArr = new long[TimeStampPrinter.VideoProcessPoint.values().length];
    public long id;
    public long pts;
    public long[] timeStamps = new long[TimeStampPrinter.VideoProcessPoint.values().length];
    
    /* Error */
    private void clear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void clearTimeStamps()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public static FrameInfo obtain()
    {
      FrameInfo localFrameInfo = (FrameInfo)sPool.acquire();
      if (localFrameInfo != null)
      {
        localFrameInfo.clear();
        return localFrameInfo;
      }
      return new FrameInfo();
    }
    
    public long getTimeStamp(TimeStampPrinter.VideoProcessPoint paramVideoProcessPoint)
    {
      return 211068182L;
    }
    
    /* Error */
    public void recycle()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void setTimeStamp(TimeStampPrinter.VideoProcessPoint arg1, long arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public String toString()
    {
      return null;
    }
  }
  
  private class FrameInfoQueue
  {
    private List<TimeStampPrinter.FrameInfo> frameInfoList;
    private ReentrantReadWriteLock lock;
    private ReentrantReadWriteLock.ReadLock rLock;
    private ReentrantReadWriteLock.WriteLock wLock;
    
    private FrameInfoQueue()
    {
      this$1 = new ReentrantReadWriteLock();
      this.lock = TimeStampPrinter.this;
      this.rLock = TimeStampPrinter.this.readLock();
      this.wLock = this.lock.writeLock();
      this.frameInfoList = new ArrayList(50);
    }
    
    /* Error */
    public void clear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public TimeStampPrinter.FrameInfo findById(long paramLong)
    {
      return null;
    }
    
    public boolean queueIn(TimeStampPrinter.FrameInfo paramFrameInfo)
    {
      return false;
    }
    
    /* Error */
    public void remove(TimeStampPrinter.FrameInfo arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public int size()
    {
      return this.frameInfoList.size();
    }
  }
  
  public static enum VideoProcessPoint
  {
    static
    {
      BeforeParse = new VideoProcessPoint("BeforeParse", 1);
      VideoRecv = new VideoProcessPoint("VideoRecv", 2);
      DecoderServerIn = new VideoProcessPoint("DecoderServerIn", 3);
      DecoderCodecIn = new VideoProcessPoint("DecoderCodecIn", 4);
      VideoProcessPoint localVideoProcessPoint = new VideoProcessPoint("DecoderCodecOut", 5);
      DecoderCodecOut = localVideoProcessPoint;
      $VALUES = new VideoProcessPoint[] { DataRead, BeforeParse, VideoRecv, DecoderServerIn, DecoderCodecIn, localVideoProcessPoint };
    }
    
    private VideoProcessPoint() {}
  }
  
  public static abstract interface VideoProcessTimeListener
  {
    public abstract void onResultOutput(TimeStampPrinter.FrameInfo paramFrameInfo);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\stream\TimeStampPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */