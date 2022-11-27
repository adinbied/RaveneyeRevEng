package com.dji.video.framing.internal.parser;

import android.os.Handler;
import android.os.Looper;
import com.dji.video.framing.internal.VideoFrame;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoStreamParseController
{
  private static final int MSG_INVOKE_CALLBACK = 0;
  private static final String TAG = "VideoStreamParseControl";
  private int fps = -1;
  private long frameIndex = 0L;
  private int frameQueueSizeLimit = 60;
  private Queue<VideoFrame> framesCacheQueue = new LinkedList();
  private AtomicBoolean isNotifyOutput = new AtomicBoolean(false);
  private long mLastFramedTime;
  private IFrameParser.OnFrameParserListener mNormalFrameParserListener = new -..Lambda.VideoStreamParseController.TFjBT0a3_xnE7Cec_XKcGxwekSM(this);
  private IFrameParser mNormalParser;
  private IFrameParser.OnFrameParserListener mSecondFrameParserListener = new -..Lambda.VideoStreamParseController.5LHKBO6Z4U5ZOdhkNuUr3feg1Kw(this);
  private IFrameParser mSecondParser;
  private FrameDataOutputCallback outputCallback;
  private Handler outputHandler;
  private OutputMode outputMode = OutputMode.Directly;
  private ScheduledExecutorService scheduledExecutorService;
  
  public VideoStreamParseController(OutputMode paramOutputMode, int paramInt)
  {
    this.outputMode = paramOutputMode;
    this.frameQueueSizeLimit = paramInt;
    init();
  }
  
  public VideoStreamParseController(OutputMode paramOutputMode, int paramInt, Looper paramLooper)
  {
    this(paramOutputMode, paramInt);
    this.outputHandler = new Handler(paramLooper)
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
  }
  
  /* Error */
  private void _setFps(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void invokeOutputCallback(VideoFrame arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void offerFrameIntoQueue(VideoFrame arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void onRecFrameData(byte[] arg1, int arg2, boolean arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, boolean arg12)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void pollAllFrames()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void restartTimer()
  {
    stopTimer();
    startTimer();
  }
  
  /* Error */
  private void startTimer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void stopTimer()
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
  
  /* Error */
  public void feedData(byte[] arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getCachedFrameNum()
  {
    return this.framesCacheQueue.size();
  }
  
  public int getFps()
  {
    return this.fps;
  }
  
  public int getFrameQueueSizeLimit()
  {
    return this.frameQueueSizeLimit;
  }
  
  public OutputMode getOutputMode()
  {
    return this.outputMode;
  }
  
  /* Error */
  public void notifyOutputFrame()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void resetCheckStatus()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setFps(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setFrameQueueSizeLimit(int paramInt)
  {
    this.frameQueueSizeLimit = paramInt;
  }
  
  public void setOutputCallback(FrameDataOutputCallback paramFrameDataOutputCallback)
  {
    this.outputCallback = paramFrameDataOutputCallback;
  }
  
  /* Error */
  public void setOutputMode(OutputMode arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface FrameDataOutputCallback
  {
    public abstract boolean onFrameOutput(VideoFrame paramVideoFrame);
  }
  
  public static enum OutputMode
  {
    static
    {
      OutputMode localOutputMode = new OutputMode("Notify", 3);
      Notify = localOutputMode;
      $VALUES = new OutputMode[] { Directly, FpsFromSps, FpsFromUserSetting, localOutputMode };
    }
    
    private OutputMode() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\parser\VideoStreamParseController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */