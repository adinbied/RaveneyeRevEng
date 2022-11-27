package com.dji.video.framing.internal.decoder;

import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.core.util.Pools.SynchronizedPool;
import com.dji.video.framing.VideoLog;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ExtraImageReaderManager
{
  private static final int MAX_IMAGE_READER_CACHE_SIZE = 2;
  private static final int MAX_POOL_SIZE = 256;
  private static final String TAG = "ExtraImageReaderManager";
  private ExtraImageReaderCallback mExtraImageReaderCallback;
  private Handler mHandler;
  private int mHeight;
  private ImageReader mImageReader;
  private ConcurrentLinkedDeque<ImageFromVideoFrame> mLinkedQueue;
  private ImageReader.OnImageAvailableListener mOnImageAvailableListener = new ImageReader.OnImageAvailableListener()
  {
    /* Error */
    public void onImageAvailable(ImageReader arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  };
  private TimestampPredictor mTimestampPredictor;
  private int mWidth;
  
  public ExtraImageReaderManager(Looper paramLooper)
  {
    VideoLog.d("ExtraImageReaderManager", "ExtraImageReaderManager()", new Object[0]);
    this.mHandler = new Handler(paramLooper);
    this.mLinkedQueue = new ConcurrentLinkedDeque();
    this.mTimestampPredictor = new SimpleTimestampPredictor(null);
  }
  
  /* Error */
  private void stopGetExtraARGBImage(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public Surface getSurface()
  {
    return this.mImageReader.getSurface();
  }
  
  public boolean hasImageReaderCallback()
  {
    return this.mExtraImageReaderCallback != null;
  }
  
  /* Error */
  public void offer(com.dji.video.framing.internal.VideoFrame arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void resetVideo(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void setExtraImageReaderCallback(ExtraImageReaderCallback paramExtraImageReaderCallback)
  {
    this.mExtraImageReaderCallback = paramExtraImageReaderCallback;
  }
  
  /* Error */
  public void startGetExtraARGBImage(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void stopGetExtraARGBImage()
  {
    stopGetExtraARGBImage(true);
  }
  
  public static abstract interface ExtraImageReaderCallback
  {
    public abstract void onImageOutput(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong);
  }
  
  static final class ImageFromVideoFrame
  {
    private static final Pools.SynchronizedPool<ImageFromVideoFrame> sPool = new Pools.SynchronizedPool(256);
    int frameNum;
    long timestampFromFrame;
    long timestampQueueIn;
    long timestampQueueOut;
    
    public static ImageFromVideoFrame obtain()
    {
      ImageFromVideoFrame localImageFromVideoFrame = (ImageFromVideoFrame)sPool.acquire();
      if (localImageFromVideoFrame != null) {
        return localImageFromVideoFrame;
      }
      return new ImageFromVideoFrame();
    }
    
    public void recycle()
    {
      sPool.release(this);
    }
  }
  
  private static class SimpleTimestampPredictor
    implements ExtraImageReaderManager.TimestampPredictor
  {
    private long offset;
    
    public void destroy() {}
    
    public int getPredictValue()
    {
      return 0;
    }
    
    public void inputValue(long paramLong)
    {
      this.offset = (System.currentTimeMillis() - paramLong);
    }
  }
  
  static abstract interface TimestampPredictor
  {
    public abstract void destroy();
    
    public abstract int getPredictValue();
    
    public abstract void inputValue(long paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\decoder\ExtraImageReaderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */