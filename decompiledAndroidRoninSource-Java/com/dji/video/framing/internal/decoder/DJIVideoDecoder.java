package com.dji.video.framing.internal.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.dji.video.framing.VideoLog;
import com.dji.video.framing.internal.VideoFrame;
import com.dji.video.framing.internal.decoder.decoderinterface.IDJIVideoDecoder;
import com.dji.video.framing.internal.decoder.decoderinterface.IDecoderOutputCallback;
import com.dji.video.framing.internal.decoder.decoderinterface.IDecoderStateListener;
import com.dji.video.framing.internal.decoder.decoderinterface.IReceiveDataCallback;
import com.dji.video.framing.internal.decoder.decoderinterface.IVideoRecordDataListener;
import com.dji.video.framing.internal.decoder.decoderinterface.IYuvDataCallback;
import com.dji.video.framing.internal.opengl.surface.SurfaceInterface;
import com.dji.video.framing.internal.opengl.surface.SurfaceInterface.BitmapCallback;
import com.dji.video.framing.utils.BackgroundLooper;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class DJIVideoDecoder
  implements IDJIVideoDecoder
{
  private static final boolean DEBUG_SYNC = false;
  public static final float FOCUS_PEAKING_HIGH = 4.0F;
  public static final float FOCUS_PEAKING_LOW = 1.5F;
  public static final float FOCUS_PEAKING_NORMAL = 2.7F;
  private static final String KEY_EXTRA_IMAGE_READER_SURFACE = "ExtraImageReaderSurface";
  public static final String KEY_PEAKING_FOCUS_THRESHOLD = "key_peaking_focus_threshold";
  public static final String KEY_PEAKING_FOCUS_THRESHOLD_FPV = "key_peaking_focus_threshold_fpv";
  private static final long LOG_FREQ_LIMIT = 5000L;
  private static final int SAVE_LOG_INTERVAL = 3000;
  private static final String TAG = "DJIVideoDecoder";
  private static final String TAG_Input = "Decoder_Input";
  private static final String TAG_Server = "Decoder_Server";
  private static long lastLogTime;
  protected boolean DEBUG_CLIENT = false;
  protected boolean DEBUG_SERVER = false;
  protected boolean DEBUG_SERVER_VERBOSE = false;
  private CountDownLatch cl;
  private VideoDecoderState decoderState;
  public int height = 9;
  private IReceiveDataCallback mCallback;
  private ReentrantReadWriteLock mCallbackLock;
  private ReentrantReadWriteLock.ReadLock mCallbackReadLock;
  private ReentrantReadWriteLock.WriteLock mCallbackWriteLock;
  private Context mContext;
  private IDecoderOutputCallback mDecoderOutputCallback;
  private List<IDecoderStateListener> mDecoderStateListenerList;
  private DJIDecodeClient mDjiDecodeClient;
  private HandlerThread mExtraImageReaderHandlerThread;
  private ExtraImageReaderManager mExtraImageReaderManager;
  private int mFps = 30;
  private InvokeOutputCallbackTask mInvokeOutputCallbackTask;
  private boolean mIsHevcMode;
  private boolean mIsStop = false;
  private Handler mJpegRenderHandler;
  private GdrKeyFrameGenerator.KeyFrameResCallback mKeyFrameResCallback;
  public long mLatestFrameTimestamp = -1L;
  public long mLatestPTS;
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  private boolean mNeedLowFreqForSmoothing;
  private boolean mNeedResetWhenResolutionChange;
  public int mOutPutWidth = 0;
  public int mOutputColorFormat = -1;
  public int mOutputHeight = 0;
  private Object mOutputSurfaceObject = null;
  private int mPlaybackFrameRate;
  public byte[] mPpsHeader = null;
  private List<IVideoRecordDataListener> mRecordDataListenerList;
  private SurfaceInterface mRenderManager = null;
  private ReentrantReadWriteLock mRenderManagerLock;
  private ReentrantReadWriteLock.ReadLock mRenderManagerReadLock;
  private ReentrantReadWriteLock.WriteLock mRenderManagerWriteLock;
  public byte[] mSpsHeader = null;
  private Surface mSurfaceDrawTo;
  private VideoDecoderEventListener mVideoDecoderEventListener;
  private IYuvDataCallback mYuvDataCallback;
  private Bitmap screenBitmap;
  StateMonitor stateMonitor = new StateMonitor();
  public int width = 16;
  
  public DJIVideoDecoder(Context paramContext, IYuvDataCallback paramIYuvDataCallback)
  {
    ReentrantReadWriteLock localReentrantReadWriteLock = new ReentrantReadWriteLock(false);
    this.mRenderManagerLock = localReentrantReadWriteLock;
    this.mRenderManagerReadLock = localReentrantReadWriteLock.readLock();
    this.mRenderManagerWriteLock = this.mRenderManagerLock.writeLock();
    this.mDecoderOutputCallback = null;
    localReentrantReadWriteLock = new ReentrantReadWriteLock();
    this.mCallbackLock = localReentrantReadWriteLock;
    this.mCallbackReadLock = localReentrantReadWriteLock.readLock();
    this.mCallbackWriteLock = this.mCallbackLock.writeLock();
    this.mDecoderStateListenerList = new LinkedList();
    this.mRecordDataListenerList = new LinkedList();
    this.mPlaybackFrameRate = -1;
    this.mNeedResetWhenResolutionChange = false;
    this.mNeedLowFreqForSmoothing = false;
    this.mIsHevcMode = false;
    this.decoderState = VideoDecoderState.Initialized;
    this.cl = null;
    this.screenBitmap = null;
    if (paramIYuvDataCallback != null)
    {
      this.mYuvDataCallback = paramIYuvDataCallback;
      init(paramContext);
      return;
    }
    throw null;
  }
  
  public DJIVideoDecoder(Context paramContext, SurfaceInterface paramSurfaceInterface, GdrKeyFrameGenerator.KeyFrameResCallback paramKeyFrameResCallback, ErrorStatusManager.FrameCheckerCallback paramFrameCheckerCallback, boolean paramBoolean)
  {
    ReentrantReadWriteLock localReentrantReadWriteLock = new ReentrantReadWriteLock(false);
    this.mRenderManagerLock = localReentrantReadWriteLock;
    this.mRenderManagerReadLock = localReentrantReadWriteLock.readLock();
    this.mRenderManagerWriteLock = this.mRenderManagerLock.writeLock();
    this.mDecoderOutputCallback = null;
    localReentrantReadWriteLock = new ReentrantReadWriteLock();
    this.mCallbackLock = localReentrantReadWriteLock;
    this.mCallbackReadLock = localReentrantReadWriteLock.readLock();
    this.mCallbackWriteLock = this.mCallbackLock.writeLock();
    this.mDecoderStateListenerList = new LinkedList();
    this.mRecordDataListenerList = new LinkedList();
    this.mPlaybackFrameRate = -1;
    this.mNeedResetWhenResolutionChange = false;
    this.mNeedLowFreqForSmoothing = false;
    this.mIsHevcMode = false;
    this.decoderState = VideoDecoderState.Initialized;
    this.cl = null;
    this.screenBitmap = null;
    this.mIsHevcMode = paramBoolean;
    if (paramSurfaceInterface != null)
    {
      paramSurfaceInterface.setVideoDecoder(this);
      this.mRenderManager = paramSurfaceInterface;
      this.mKeyFrameResCallback = paramKeyFrameResCallback;
      ErrorStatusManager.getInstance().setFrameCheckerCallback(paramFrameCheckerCallback);
      init(paramContext);
      return;
    }
    throw null;
  }
  
  public DJIVideoDecoder(Context paramContext, SurfaceInterface paramSurfaceInterface, IYuvDataCallback paramIYuvDataCallback)
  {
    ReentrantReadWriteLock localReentrantReadWriteLock = new ReentrantReadWriteLock(false);
    this.mRenderManagerLock = localReentrantReadWriteLock;
    this.mRenderManagerReadLock = localReentrantReadWriteLock.readLock();
    this.mRenderManagerWriteLock = this.mRenderManagerLock.writeLock();
    this.mDecoderOutputCallback = null;
    localReentrantReadWriteLock = new ReentrantReadWriteLock();
    this.mCallbackLock = localReentrantReadWriteLock;
    this.mCallbackReadLock = localReentrantReadWriteLock.readLock();
    this.mCallbackWriteLock = this.mCallbackLock.writeLock();
    this.mDecoderStateListenerList = new LinkedList();
    this.mRecordDataListenerList = new LinkedList();
    this.mPlaybackFrameRate = -1;
    this.mNeedResetWhenResolutionChange = false;
    this.mNeedLowFreqForSmoothing = false;
    this.mIsHevcMode = false;
    this.decoderState = VideoDecoderState.Initialized;
    this.cl = null;
    this.screenBitmap = null;
    if (paramSurfaceInterface != null)
    {
      paramSurfaceInterface.setVideoDecoder(this);
      this.mRenderManager = paramSurfaceInterface;
      this.mYuvDataCallback = paramIYuvDataCallback;
      init(paramContext);
      return;
    }
    throw null;
  }
  
  public DJIVideoDecoder(Context paramContext, Object paramObject)
  {
    ReentrantReadWriteLock localReentrantReadWriteLock = new ReentrantReadWriteLock(false);
    this.mRenderManagerLock = localReentrantReadWriteLock;
    this.mRenderManagerReadLock = localReentrantReadWriteLock.readLock();
    this.mRenderManagerWriteLock = this.mRenderManagerLock.writeLock();
    this.mDecoderOutputCallback = null;
    localReentrantReadWriteLock = new ReentrantReadWriteLock();
    this.mCallbackLock = localReentrantReadWriteLock;
    this.mCallbackReadLock = localReentrantReadWriteLock.readLock();
    this.mCallbackWriteLock = this.mCallbackLock.writeLock();
    this.mDecoderStateListenerList = new LinkedList();
    this.mRecordDataListenerList = new LinkedList();
    this.mPlaybackFrameRate = -1;
    this.mNeedResetWhenResolutionChange = false;
    this.mNeedLowFreqForSmoothing = false;
    this.mIsHevcMode = false;
    this.decoderState = VideoDecoderState.Initialized;
    this.cl = null;
    this.screenBitmap = null;
    if (paramObject != null)
    {
      this.mOutputSurfaceObject = paramObject;
      init(paramContext);
      return;
    }
    throw null;
  }
  
  /* Error */
  private void init(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static void log2File(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("log2File: ");
    localStringBuilder.append(paramString);
    VideoLog.w("DJIVideoDecoder", localStringBuilder.toString(), new Object[0]);
  }
  
  public static void log2FileWithFreqLimit(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - lastLogTime > 5000L)
    {
      log2File(paramString);
      lastLogTime = l;
    }
  }
  
  /* Error */
  public void addDecoderStateListener(IDecoderStateListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addRecordDataListener(IVideoRecordDataListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void checkAndRestartImageReader()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  boolean checkAsyncRenderSurfaceExist(String paramString)
  {
    return false;
  }
  
  /* Error */
  public void clearDecoderStateListeners()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Bitmap getBitmap(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public Bitmap getBitmap(boolean paramBoolean)
  {
    return null;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public VideoDecoderState getDecoderState()
  {
    return this.decoderState;
  }
  
  public int getFps()
  {
    return this.mFps;
  }
  
  public double getFrameQueueinIntervalAvgValue()
  {
    return 1.043694996E-315D;
  }
  
  public GdrKeyFrameGenerator.KeyFrameResCallback getKeyFrameResCallback()
  {
    return this.mKeyFrameResCallback;
  }
  
  public long getLastFrameOutTime()
  {
    return 211246230L;
  }
  
  public long getLastInitCodecOutputTime()
  {
    return 211246236L;
  }
  
  Object getOutputSurfaceObject()
  {
    return this.mOutputSurfaceObject;
  }
  
  public boolean getPeakFocusEnable()
  {
    return false;
  }
  
  public float getPeakFocusThreshold()
  {
    return 0.0F;
  }
  
  Lock getRenderManagerReadLock()
  {
    return this.mRenderManagerReadLock;
  }
  
  public byte[] getRgbaData(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public int getVideoHeight()
  {
    return this.height;
  }
  
  public int getVideoWidth()
  {
    return this.width;
  }
  
  public byte[] getYuvData(int paramInt1, int paramInt2)
  {
    return getYuvData(paramInt1, paramInt2, 21);
  }
  
  public byte[] getYuvData(int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  public IYuvDataCallback getYuvDataCallBack()
  {
    return this.mYuvDataCallback;
  }
  
  public SurfaceInterface getmRenderManager()
  {
    return this.mRenderManager;
  }
  
  /* Error */
  public void initDecoder()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  void invokeCallbackOneFrameComeIn()
  {
    IReceiveDataCallback localIReceiveDataCallback = this.mCallback;
    if (localIReceiveDataCallback != null) {
      localIReceiveDataCallback.oneFrameComeIn();
    }
  }
  
  /* Error */
  void invokeCallbackResetVideoSurface()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void invokeOnVideoFrameInput(VideoFrame arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void invokeOutputCallback(VideoFrame arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isDecoderOK()
  {
    return false;
  }
  
  public boolean isHevcMode()
  {
    return this.mIsHevcMode;
  }
  
  public boolean isNeedResetCodecWhenResolutionChanged()
  {
    return this.mNeedResetWhenResolutionChange;
  }
  
  public boolean isSurfaceAvailable()
  {
    return this.mRenderManager != null;
  }
  
  public boolean needLowFrequencyForSmoothing()
  {
    return this.mNeedLowFreqForSmoothing;
  }
  
  /* Error */
  void onCodecInit()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void onFrameDropped()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void queueInputBuffer(VideoFrame arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void recvTimeout()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void removeDecoderStateListener(IDecoderStateListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void removeRecordDataListener(IVideoRecordDataListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void resetCodec()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void resetKeyFrame()
  {
    this.mDjiDecodeClient.resetKeyFrame();
  }
  
  public boolean setAsyncRenderSurface(String paramString, Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public void setFps(int paramInt)
  {
    this.mFps = paramInt;
  }
  
  public void setHevcMode(boolean paramBoolean)
  {
    this.mIsHevcMode = paramBoolean;
  }
  
  public void setNeedLowFrequencyForSmoothing(boolean paramBoolean)
  {
    this.mNeedLowFreqForSmoothing = paramBoolean;
  }
  
  public void setNeedResetCodecWhenResolutionChanged(boolean paramBoolean)
  {
    this.mNeedResetWhenResolutionChange = paramBoolean;
  }
  
  /* Error */
  public void setPause(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setPeakFocusEnable(boolean paramBoolean)
  {
    setPeakFocusEnable(paramBoolean, false);
  }
  
  public void setPeakFocusEnable(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mRenderManager == null) {
      return;
    }
    this.mRenderManagerReadLock.lock();
    try
    {
      if (isSurfaceAvailable()) {
        this.mRenderManager.setPeakFocusEnable(paramBoolean1);
      }
      return;
    }
    finally
    {
      this.mRenderManagerReadLock.unlock();
    }
  }
  
  /* Error */
  public void setPeakFocusThreshold(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  public void setRecvDataCallBack(IReceiveDataCallback paramIReceiveDataCallback)
  {
    this.mCallback = paramIReceiveDataCallback;
  }
  
  public void setSurface(SurfaceInterface paramSurfaceInterface)
  {
    setSurface(paramSurfaceInterface, false);
  }
  
  /* Error */
  public void setSurface(SurfaceInterface arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void setYuvDataCallBack(IYuvDataCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setmDecoderOutputCallback(IDecoderOutputCallback paramIDecoderOutputCallback)
  {
    this.mDecoderOutputCallback = paramIDecoderOutputCallback;
  }
  
  /* Error */
  public void setmVideoDecoderEventListener(VideoDecoderEventListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean startGetAsyncRgbaData(ExtraImageReaderManager.ExtraImageReaderCallback paramExtraImageReaderCallback)
  {
    return false;
  }
  
  /* Error */
  public void stopGetAsyncRgbaData(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateYuvDataCallback(ByteBuffer arg1, int arg2, int arg3, int arg4, int arg5, int arg6, long arg7)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class InvokeOutputCallbackTask
    implements Runnable
  {
    private IDecoderOutputCallback callback;
    private int frameNum;
    private boolean isKeyFrame;
    
    private InvokeOutputCallbackTask() {}
    
    public void invoke(VideoFrame paramVideoFrame, IDecoderOutputCallback paramIDecoderOutputCallback)
    {
      if (paramIDecoderOutputCallback == null) {
        return;
      }
      this.callback = paramIDecoderOutputCallback;
      this.frameNum = paramVideoFrame.frameNum;
      this.isKeyFrame = paramVideoFrame.isKeyFrame;
      DJIVideoDecoder.this.mMainHandler.post(this);
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  class StateMonitor
  {
    private static final int CHECK_INPUT_TIME_INTERVAL = 1000;
    private static final int INPUT_BREAK_TIME_LIMIT = 3000;
    private static final int MSG_INPUT_BROKEN = 0;
    private static final int MSG_INVOKE_STATE_LISTENERS = 2;
    private static final int MSG_OUTPUT_BROKEN = 1;
    private static final int OUTPUT_BREAK_TIME_LIMIT = 3000;
    private Handler stateUpdateHandler = new Handler(BackgroundLooper.getLooper())
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
    
    StateMonitor() {}
    
    /* Error */
    private void onInputBroken()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void onOutputBroken()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void setDecoderState(DJIVideoDecoder.VideoDecoderState arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void onFrameInput()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void onFrameOutput()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void release()
    {
      this.stateUpdateHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public static abstract interface VideoDecoderEventListener
  {
    public abstract void onCodecInit();
    
    public abstract void onFrameDropped();
  }
  
  public static enum VideoDecoderState
  {
    static
    {
      Decoding = new VideoDecoderState("Decoding", 2);
      VideoDecoderState localVideoDecoderState = new VideoDecoderState("Paused", 3);
      Paused = localVideoDecoderState;
      $VALUES = new VideoDecoderState[] { Initialized, VideoFrameInput, Decoding, localVideoDecoderState };
    }
    
    private VideoDecoderState() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\decoder\DJIVideoDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */