package dji.midware.media.newframing;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.dji.video.framing.internal.decoder.decoderinterface.IDJIVideoDecoder;
import com.dji.video.framing.internal.opengl.GLContextMgr;
import com.dji.video.framing.internal.opengl.extra.ExtraRenderThread;
import com.dji.video.framing.internal.opengl.extra.FrameBufferTexturePair;
import com.dji.video.framing.internal.opengl.renderer.GLFellowRender;
import com.dji.video.framing.internal.opengl.renderer.GLGrayRender;
import com.dji.video.framing.internal.opengl.renderer.GLIdentityRender;
import com.dji.video.framing.internal.opengl.renderer.GLLutRender;
import com.dji.video.framing.internal.opengl.renderer.GLMonoChromeRender;
import com.dji.video.framing.internal.opengl.renderer.GLMonoChromeRender.Filter;
import com.dji.video.framing.internal.opengl.renderer.GLPseudoRender;
import com.dji.video.framing.internal.opengl.renderer.GLRGB2YUVRender;
import com.dji.video.framing.internal.opengl.renderer.GLRenderBase;
import com.dji.video.framing.internal.opengl.renderer.OverExposureWarner;
import com.dji.video.framing.internal.opengl.renderer.PeakingFocusPresenter;
import com.dji.video.framing.internal.opengl.surface.CacheContainer;
import com.dji.video.framing.internal.opengl.surface.SurfaceInterface;
import com.dji.video.framing.internal.opengl.surface.SurfaceInterface.BitmapCallback;
import dji.midware.R.raw;
import dji.midware.media.MediaLogger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

public class GLYUVSurface
  implements SurfaceInterface
{
  private static final int CHECK_TIME = 2000;
  public static final boolean DEBUG = false;
  private static final boolean DEBUG_SYNC = false;
  private static int DEFAULT_INTERVAL_TIMES = 0;
  public static int DEFAULT_SLICE_NUM = 4;
  public static final String TAG = "GLYUVSurface";
  public static final boolean VERBOSE = false;
  private GLFellowRender asyncRender = null;
  private final Object asyncRenderLock = new Object();
  private ExtraRenderThread asyncRenderThread;
  private CacheContainer cacheContainer;
  private FrameBufferTexturePair[] cacheFbos;
  private int cacheNum = 4;
  private GLIdentityRender cameraRenderer = null;
  private GLIdentityRender cameraRendererWithoutCorrection = null;
  private GLContextMgr ctxCur;
  private GLContextMgr ctxPre;
  private int curBufferHeight = -1;
  private int curBufferWidth = -1;
  private int curHeight = -1;
  private int curWidth = -1;
  private int dataCount = 0;
  private Runnable displayRunnable = new Runnable()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private byte[] dst;
  private boolean enableSmooth = false;
  private List<GLRenderBase> extraRenderList = new ArrayList(3);
  private int extraTime = 3;
  private FrameBufferTexturePair fbo1 = null;
  private FrameBufferTexturePair fbo2 = null;
  private BlockingQueue<Runnable> frameAvailableTaskQueue = new LinkedBlockingQueue();
  private GetDataTask getRgbaDataTask = new GetDataTask();
  private GetDataTask getYuvDataTask = new GetDataTask();
  private GLGrayRender grayRender = null;
  private boolean hasInit = false;
  private boolean hasOutputSurface = false;
  private Surface inputSurface;
  private SurfaceTexture inputSurfaceTexture;
  private int inputTextureID = -1;
  private OverExposureWarner internalOewRenderer = null;
  private int interval = -1;
  private boolean isDistortion = false;
  private long lastCheckTime = -1L;
  private long lastValidTime = -1L;
  private Object listenerSync = new Object();
  private boolean mIsLutEnable = false;
  private Bitmap mLutBmp;
  private GLLutRender mLutRender;
  private boolean mMonoChromeEnable = false;
  private GLMonoChromeRender mMonoChromeRender;
  private GLMonoChromeRender.Filter mMonoChromeRenderFilter;
  private GLPseudoRender mPseudoRender;
  private boolean mPseudoRenderEnable;
  private float[] mSTMatrix = new float[16];
  private int maxSize = (4 + 1) / 2;
  private boolean needInputTexture;
  private boolean needResetExtraRenderList = true;
  private OverExposureWarner oewRenderer = null;
  private Bitmap outputBitmap;
  private boolean overExposureWarner = false;
  private int overExposureWarnerTextureResID = R.raw.overexposure;
  private boolean peakFocusEnable = false;
  private float peakFocusThreshold = 2.7F;
  private PeakingFocusPresenter peakingFocusPresenter = null;
  private int preheight = 0;
  private int prewidth = 0;
  private ByteBuffer readByteBuffer = null;
  private FrameBufferTexturePair readCacheFbo = null;
  private ReadPixelSeperatlyTask readPixelSeperatlyTask;
  private Handler renderHandler;
  private HandlerThread renderThread = null;
  private GLRGB2YUVRender rgb2yuvRenderer = null;
  boolean running = true;
  private boolean saveFirstReadData = false;
  private long secondaryDrawCount = 0L;
  private byte[] src;
  private Object syncCreateST = new Object();
  private GLIdentityRender tempRender = null;
  private GLIdentityRender texture2DRenderer = null;
  private IDJIVideoDecoder videoDecoder;
  private int viewRotateDegree;
  private Surface viewSurface;
  private int viewX;
  private int viewportHeight;
  private int viewportWidth;
  private GLRenderBase vrRenderer = null;
  
  /* Error */
  private void _destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void asyncDisplay(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  private void cacheInit()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void cacheUnit()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void destroyReadFrameBuffer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void display()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawDisplay(FrameBufferTexturePair arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private FrameBufferTexturePair getFbo1()
  {
    return null;
  }
  
  private FrameBufferTexturePair getFbo2()
  {
    return null;
  }
  
  private SurfaceTexture getInputSurfaceTexture()
  {
    return this.inputSurfaceTexture;
  }
  
  private FrameBufferTexturePair getReadCacheFbo()
  {
    return null;
  }
  
  /* Error */
  private void initExtraRenderList()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initReadFrameBuffer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private FrameBufferTexturePair obtainCache()
  {
    return null;
  }
  
  private void onReadPixel()
  {
    ReadPixelSeperatlyTask localReadPixelSeperatlyTask = this.readPixelSeperatlyTask;
    if (localReadPixelSeperatlyTask != null) {
      localReadPixelSeperatlyTask.run();
    }
  }
  
  private void postFrameAvailebleTask(Runnable paramRunnable)
  {
    Handler localHandler = this.renderHandler;
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
  }
  
  /* Error */
  private void readPixelSeperate(ByteBuffer arg1, int arg2, int arg3, ReadPixelResultListener arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean sendDataToListener(long paramLong, int paramInt1, int paramInt2)
  {
    synchronized (this.listenerSync)
    {
      return false;
    }
  }
  
  /* Error */
  private void setAntiDistortionEnabled(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateInterval()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateTexImage()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void checkVideoSizeChange(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void createInputSurfaceTexture()
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
    //   2: return
  }
  
  /* Error */
  public void enableLutRender(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void enableMonoChromeRender(boolean paramBoolean)
  {
    this.mMonoChromeEnable = paramBoolean;
    this.needResetExtraRenderList = true;
  }
  
  public void enableOverExposureWarning(boolean paramBoolean, int paramInt)
  {
    this.overExposureWarner = paramBoolean;
    this.overExposureWarnerTextureResID = paramInt;
    this.needResetExtraRenderList = true;
  }
  
  public void enablePseudoRender(boolean paramBoolean)
  {
    this.mPseudoRenderEnable = paramBoolean;
    this.needResetExtraRenderList = true;
  }
  
  /* Error */
  public void getBitmap(int arg1, int arg2, SurfaceInterface.BitmapCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void getBitmap(SurfaceInterface.BitmapCallback paramBitmapCallback)
  {
    getBitmap(this.curWidth, this.curHeight, paramBitmapCallback);
  }
  
  public int getExtraAsyncRenderInterval(String paramString)
  {
    return 0;
  }
  
  public Surface getInputSurface()
  {
    return null;
  }
  
  public long getLastExtraDrawTime(String paramString)
  {
    return 277709506L;
  }
  
  public boolean getPeakFocusEnable()
  {
    return this.peakFocusEnable;
  }
  
  public float getPeakFocusThreshold()
  {
    return 0.0F;
  }
  
  public byte[] getRgbaData(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public int getSecondaryOutputInterval(String paramString)
  {
    return 0;
  }
  
  public byte[] getYuvData(int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  /* Error */
  public void init(Object arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void init(Object arg1, int arg2, int arg3, int arg4, int arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void init(Object arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, boolean arg7)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean isSupportSmooth()
  {
    return false;
  }
  
  /* Error */
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void reSizeSurface(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      this.viewportWidth = paramInt1;
      this.viewportHeight = paramInt2;
      this.viewRotateDegree = paramInt4;
      this.viewX = paramInt3;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GLYUVSresizeSurface: width=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" height=");
      localStringBuilder.append(paramInt2);
      MediaLogger.show(localStringBuilder.toString());
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void resetSurface(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void resizeSurface(int paramInt1, int paramInt2)
  {
    reSizeSurface(paramInt1, paramInt2, 0, 0);
  }
  
  public void setDistortion(boolean paramBoolean)
  {
    this.isDistortion = paramBoolean;
  }
  
  /* Error */
  public void setExtraAsyncRenderInterval(String arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean setExtraAsyncRenderSurface(String paramString, Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  /* Error */
  public void setLutBmp(Bitmap arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setMonoChromeRender(GLMonoChromeRender.Filter paramFilter)
  {
    this.mMonoChromeRenderFilter = paramFilter;
    this.needResetExtraRenderList = true;
  }
  
  public void setPeakFocusEnable(boolean paramBoolean)
  {
    this.peakFocusEnable = paramBoolean;
    this.needResetExtraRenderList = true;
  }
  
  /* Error */
  public void setPeakFocusThreshold(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setSecondaryOutputInterval(String arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setSecondaryOutputSurface(String arg1, Object arg2, int arg3, int arg4, int arg5, int arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setVideoDecoder(IDJIVideoDecoder paramIDJIVideoDecoder)
  {
    this.videoDecoder = paramIDJIVideoDecoder;
  }
  
  public void setYUVScale(float paramFloat)
  {
    GLIdentityRender localGLIdentityRender = this.cameraRenderer;
    if (localGLIdentityRender != null) {
      localGLIdentityRender.setYUVScale(paramFloat);
    }
  }
  
  /* Error */
  public void toBlack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void toGray()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateFrameInfo(int arg1, int arg2, int arg3, com.dji.video.framing.internal.decoder.common.FrameFovType arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  class GetDataTask
    implements Runnable
  {
    private ByteBuffer byteBufferRst;
    private CountDownLatch cdl;
    private Object cdlLock = new Object();
    private int height;
    private boolean isYuvData;
    private int width;
    
    GetDataTask() {}
    
    /* Error */
    public void await(int arg1, java.util.concurrent.TimeUnit arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    /* Error */
    public ByteBuffer execute(int paramInt1, int paramInt2, int paramInt3, java.util.concurrent.TimeUnit paramTimeUnit, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iload_1
      //   4: putfield 38	dji/midware/media/newframing/GLYUVSurface$GetDataTask:width	I
      //   7: aload_0
      //   8: iload_2
      //   9: putfield 40	dji/midware/media/newframing/GLYUVSurface$GetDataTask:height	I
      //   12: aload_0
      //   13: iload 5
      //   15: putfield 42	dji/midware/media/newframing/GLYUVSurface$GetDataTask:isYuvData	Z
      //   18: aload_0
      //   19: getfield 31	dji/midware/media/newframing/GLYUVSurface$GetDataTask:cdlLock	Ljava/lang/Object;
      //   22: astore 6
      //   24: aload 6
      //   26: monitorenter
      //   27: aload_0
      //   28: getfield 44	dji/midware/media/newframing/GLYUVSurface$GetDataTask:cdl	Ljava/util/concurrent/CountDownLatch;
      //   31: ifnonnull +23 -> 54
      //   34: aload_0
      //   35: new 46	java/util/concurrent/CountDownLatch
      //   38: dup
      //   39: iconst_1
      //   40: invokespecial 49	java/util/concurrent/CountDownLatch:<init>	(I)V
      //   43: putfield 44	dji/midware/media/newframing/GLYUVSurface$GetDataTask:cdl	Ljava/util/concurrent/CountDownLatch;
      //   46: aload_0
      //   47: getfield 26	dji/midware/media/newframing/GLYUVSurface$GetDataTask:this$0	Ldji/midware/media/newframing/GLYUVSurface;
      //   50: aload_0
      //   51: invokestatic 53	dji/midware/media/newframing/GLYUVSurface:access$1100	(Ldji/midware/media/newframing/GLYUVSurface;Ljava/lang/Runnable;)V
      //   54: aload 6
      //   56: monitorexit
      //   57: aload_0
      //   58: iload_3
      //   59: aload 4
      //   61: invokevirtual 55	dji/midware/media/newframing/GLYUVSurface$GetDataTask:await	(ILjava/util/concurrent/TimeUnit;)V
      //   64: aload_0
      //   65: getfield 57	dji/midware/media/newframing/GLYUVSurface$GetDataTask:byteBufferRst	Ljava/nio/ByteBuffer;
      //   68: astore 4
      //   70: aload_0
      //   71: monitorexit
      //   72: aload 4
      //   74: areturn
      //   75: astore 4
      //   77: aload 6
      //   79: monitorexit
      //   80: aload 4
      //   82: athrow
      //   83: astore 4
      //   85: aload_0
      //   86: monitorexit
      //   87: aload 4
      //   89: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	90	0	this	GetDataTask
      //   0	90	1	paramInt1	int
      //   0	90	2	paramInt2	int
      //   0	90	3	paramInt3	int
      //   0	90	4	paramTimeUnit	java.util.concurrent.TimeUnit
      //   0	90	5	paramBoolean	boolean
      // Exception table:
      //   from	to	target	type
      //   27	54	75	finally
      //   54	57	75	finally
      //   77	80	75	finally
      //   2	27	83	finally
      //   57	70	83	finally
      //   80	83	83	finally
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  class GetYuvDataTask
    implements Runnable
  {
    public ByteBuffer byteBufferRst;
    public CountDownLatch cdl;
    public int height;
    public int width;
    
    GetYuvDataTask() {}
    
    /* Error */
    public void await(int arg1, java.util.concurrent.TimeUnit arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    /* Error */
    public void execute(int arg1, java.util.concurrent.TimeUnit arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  static abstract interface ReadPixelResultListener
  {
    public abstract void onComplete(ByteBuffer paramByteBuffer);
    
    public abstract void onFailure();
  }
  
  private class ReadPixelSeperatlyTask
    implements Runnable
  {
    private ByteBuffer container;
    private int height;
    private int intervalTimes = 0;
    private boolean isFboCopyDone = false;
    private GLYUVSurface.ReadPixelResultListener listener;
    private int originFrameBuffer;
    private int readSliceNum;
    private int width;
    
    public ReadPixelSeperatlyTask(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, GLYUVSurface.ReadPixelResultListener paramReadPixelResultListener)
    {
      this.container = paramByteBuffer;
      this.width = paramInt1;
      this.height = paramInt2;
      this.listener = paramReadPixelResultListener;
      this.isFboCopyDone = false;
    }
    
    /* Error */
    public void execute()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\newframing\GLYUVSurface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */