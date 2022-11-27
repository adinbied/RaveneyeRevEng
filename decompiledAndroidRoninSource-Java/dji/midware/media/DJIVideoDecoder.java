package dji.midware.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import dji.log.FpsLog;
import dji.log.RoninLog;
import dji.logic.manager.DJIUSBWifiSwitchManager;
import dji.midware.R.raw;
import dji.midware.component.DJIComponentManager.CameraComponentType;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DJIVideoDataEvent;
import dji.midware.data.manager.P3.DJIVideoEvent;
import dji.midware.data.manager.P3.ServiceManager;
import dji.midware.data.model.P3.DataCameraGetMode.MODE;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo.CameraType;
import dji.midware.interfaces.RecvDataCallback;
import dji.midware.media.opengl.surface.GLYUVSurface.BitmapCallback;
import dji.midware.media.opengl.surface.SurfaceInterface;
import dji.midware.media.transcode.online.DecoderListener;
import dji.midware.usb.P3.UsbAccessoryService.VideoStreamSource;
import dji.midware.util.DoubleCameraSupportUtil;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class DJIVideoDecoder
{
  private static final boolean DEBUG_SYNC = false;
  private static final int IN_OUT_DIFF_THRESHOLD = 2000;
  public static final int InputQueueCapacity = 15;
  public static final String KEY_PEAKING_FOCUS_THRESHOLD = "key_peaking_focus_threshold";
  private static final int REFRESH_IFRAME_RETRY_INTERVAL = 500;
  private static final int REFRESH_IFRAME_RETRY_NUM = 6;
  private static final String TAG = "DJIVideoDecoder";
  private static final String TAG_Input = "Decoder_Input";
  private static final String TAG_Server = "Decoder_Server";
  private static boolean TEST_RESTART_MECHANISM = false;
  public static final int connectLosedelay = 2000;
  static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private static DataCameraGetPushStateInfo stateInfo;
  private static DJIUSBWifiSwitchManager switchManager;
  public static boolean testDisconnect;
  private static final boolean testToogle = false;
  protected boolean DEBUG_CLIENT = false;
  protected boolean DEBUG_SERVER = false;
  protected boolean DEBUG_SERVER_VERBOSE = false;
  private CountDownLatch cl = null;
  private DJIDecodeClient client = new DJIDecodeClient(null);
  private Context context;
  public int height = 9;
  private long inLastTime = -1L;
  private boolean isLiveStream = true;
  private boolean isStop = false;
  Handler jpegRenderHandler;
  private int last_input_frame_num = -1;
  public long latestPTS;
  public DecoderListener listener = null;
  public Object listenerSync = new Object();
  private FileOutputStream liveStreamOutputStream;
  private RecvDataCallback mCallback;
  private boolean needRefreshIframe = false;
  private long outLastTime = -1L;
  public int outputColorFormat = -1;
  public int outputHeight = 0;
  public int outputWidth = 0;
  private int playbackFrameRate = -1;
  public byte[] pps_header = null;
  private int refreshIframeRetryCount = 0;
  private SurfaceInterface renderManager = null;
  private boolean saveLiveStream = false;
  private Bitmap screenBitmap = null;
  private DJIDecodeServer server;
  private SmoothFilter smoothFilter;
  private UsbAccessoryService.VideoStreamSource source;
  public byte[] sps_header = null;
  private StatusMonitor statusMonitor = new StatusMonitor(null);
  public UsbAccessoryService.VideoStreamSource streamSource;
  private Surface surfaceDrawTo;
  private long tLastFrameIn = -1L;
  private long tLastFrameOut = -1L;
  private AtomicInteger time_initialized = new AtomicInteger(0);
  public int width = 16;
  
  public DJIVideoDecoder(Context paramContext, SurfaceInterface paramSurfaceInterface)
  {
    this(paramContext, true, paramSurfaceInterface);
  }
  
  public DJIVideoDecoder(Context paramContext, boolean paramBoolean, SurfaceInterface paramSurfaceInterface)
  {
    this(paramContext, paramBoolean, paramSurfaceInterface, UsbAccessoryService.VideoStreamSource.Camera);
  }
  
  public DJIVideoDecoder(Context paramContext, boolean paramBoolean, SurfaceInterface paramSurfaceInterface, UsbAccessoryService.VideoStreamSource paramVideoStreamSource)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("new a DJIVideoDecoder = ");
    localStringBuilder.append(toString());
    MediaLogger.show("DJIVideoDecoder", localStringBuilder.toString());
    this.context = paramContext;
    this.isLiveStream = paramBoolean;
    this.source = paramVideoStreamSource;
    paramSurfaceInterface.setVideoDecoder(this);
    if (paramVideoStreamSource == UsbAccessoryService.VideoStreamSource.Camera)
    {
      this.streamSource = UsbAccessoryService.VideoStreamSource.Camera;
      ServiceManager.getInstance().setVideoDecoder(this);
    }
    else if (paramVideoStreamSource == UsbAccessoryService.VideoStreamSource.Fpv)
    {
      this.streamSource = UsbAccessoryService.VideoStreamSource.Fpv;
      ServiceManager.getInstance().setSecondaryVideoDecoder(this);
    }
    this.statusMonitor.freshDecodeStatus(5000);
    this.statusMonitor.freshDataStatus(5000);
    setSurface(paramSurfaceInterface);
    if (paramVideoStreamSource == UsbAccessoryService.VideoStreamSource.Camera) {
      if (DataCameraGetPushStateInfo.getInstance().getMode(new int[] { 0 }) != DataCameraGetMode.MODE.TAKEPHOTO)
      {
        if (DataCameraGetPushStateInfo.getInstance().getMode(new int[] { 0 }) != DataCameraGetMode.MODE.RECORD) {}
      }
      else
      {
        initPeakingFocusState(new int[] { 0 });
        break label451;
      }
    }
    if ((paramVideoStreamSource == UsbAccessoryService.VideoStreamSource.Fpv) && (DoubleCameraSupportUtil.getMainCameraBandwidthPercent() != 0) && (DoubleCameraSupportUtil.getMainCameraBandwidthPercent() != 10)) {
      if (DataCameraGetPushStateInfo.getInstance().getMode(new int[] { 2 }) != DataCameraGetMode.MODE.TAKEPHOTO)
      {
        if (DataCameraGetPushStateInfo.getInstance().getMode(new int[] { 2 }) != DataCameraGetMode.MODE.RECORD) {}
      }
      else {
        initPeakingFocusState(new int[] { 2 });
      }
    }
    label451:
    paramContext = new SmoothFilter();
    this.smoothFilter = paramContext;
    paramContext.init();
    this.smoothFilter.setCallback(new SmoothFilter.Callback()
    {
      /* Error */
      public void outputData(Object arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  private void fpsLog(String paramString)
  {
    FpsLog.getInstance().d(paramString);
  }
  
  public static int getIframeRawId(ProductType paramProductType, int paramInt1, int paramInt2)
  {
    return getIframeRawId(paramProductType, paramInt1, paramInt2, UsbAccessoryService.VideoStreamSource.Camera);
  }
  
  public static int getIframeRawId(ProductType paramProductType, int paramInt1, int paramInt2, UsbAccessoryService.VideoStreamSource paramVideoStreamSource)
  {
    if (stateInfo == null) {
      stateInfo = DataCameraGetPushStateInfo.getInstance();
    }
    if (switchManager == null) {
      switchManager = DJIUSBWifiSwitchManager.getInstance();
    }
    int j = R.raw.iframe_1280x720_ins;
    switch (4.$SwitchMap$dji$midware$data$config$P3$ProductType[paramProductType.ordinal()])
    {
    default: 
      RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1280x720_ins", new Object[0]);
      return R.raw.iframe_1280x720_ins;
    case 20: 
    case 21: 
      paramProductType = DataCameraGetPushStateInfo.getInstance().getCameraType(new int[0]);
      if ((!paramVideoStreamSource.equals(UsbAccessoryService.VideoStreamSource.Fpv)) && (paramProductType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeGD600)) {
        return R.raw.iframe_1080x720_gd600;
      }
      if ((paramInt1 == 640) && (paramInt2 == 368))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_640x368_wm620", new Object[0]);
        return R.raw.iframe_640x368_wm620;
      }
      if ((paramInt1 == 608) && (paramInt2 == 448))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_608x448_wm620", new Object[0]);
        return R.raw.iframe_608x448_wm620;
      }
      if ((paramInt1 == 720) && (paramInt2 == 480))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_720x480_wm620", new Object[0]);
        return R.raw.iframe_720x480_wm620;
      }
      if ((paramInt1 == 1280) && (paramInt2 == 720))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1280x720_wm620", new Object[0]);
        return R.raw.iframe_1280x720_wm620;
      }
      if ((paramInt1 == 1080) && (paramInt2 == 720))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1080x720_wm620", new Object[0]);
        return R.raw.iframe_1080x720_wm620;
      }
      if ((paramInt1 == 1088) && (paramInt2 == 720))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1088x720_wm620", new Object[0]);
        return R.raw.iframe_1088x720_wm620;
      }
      if ((paramInt1 == 960) && (paramInt2 == 720))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_960x720_wm620", new Object[0]);
        return R.raw.iframe_960x720_wm620;
      }
      if ((paramInt1 == 1360) && (paramInt2 == 720))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1360x720_wm620", new Object[0]);
        return R.raw.iframe_1360x720_wm620;
      }
      if ((paramInt1 == 1344) && (paramInt2 == 720))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1344x720_wm620", new Object[0]);
        return R.raw.iframe_1344x720_wm620;
      }
      if ((paramInt1 == 1440) && (paramInt2 == 1088))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1440x1088_wm620", new Object[0]);
        return R.raw.iframe_1440x1088_wm620;
      }
      if ((paramInt1 == 1632) && (paramInt2 == 1080))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1632x1080_wm620", new Object[0]);
        return R.raw.iframe_1632x1080_wm620;
      }
      if ((paramInt1 == 1760) && (paramInt2 == 720))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1760x720_wm620", new Object[0]);
        return R.raw.iframe_1760x720_wm620;
      }
      if ((paramInt1 == 1920) && (paramInt2 == 800))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1920x800_wm620", new Object[0]);
        return R.raw.iframe_1920x800_wm620;
      }
      if ((paramInt1 == 1920) && (paramInt2 == 1024))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1920x1024_wm620", new Object[0]);
        return R.raw.iframe_1920x1024_wm620;
      }
      if ((paramInt1 == 1920) && (paramInt2 == 1088))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1920x1080_wm620", new Object[0]);
        return R.raw.iframe_1920x1088_wm620;
      }
      i = j;
      if (paramInt1 != 1920) {
        break label1657;
      }
      i = j;
      if (paramInt2 != 1440) {
        break label1657;
      }
      RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1920x1440_wm620", new Object[0]);
      return R.raw.iframe_1920x1440_wm620;
    case 18: 
    case 19: 
      if ((DoubleCameraSupportUtil.getMainCameraBandwidthPercent() != 0) && (DoubleCameraSupportUtil.getMainCameraBandwidthPercent() != 10)) {
        i = 0;
      } else {
        i = -1;
      }
      if (paramVideoStreamSource.equals(UsbAccessoryService.VideoStreamSource.Camera))
      {
        if (!DoubleCameraSupportUtil.getMainCameraType().equals(DJIComponentManager.CameraComponentType.None)) {
          paramProductType = DoubleCameraSupportUtil.getMainCameraType();
        } else {
          paramProductType = DoubleCameraSupportUtil.getSecondaryCameraType();
        }
      }
      else if ((paramVideoStreamSource.equals(UsbAccessoryService.VideoStreamSource.Fpv)) && (i != -1)) {
        paramProductType = DoubleCameraSupportUtil.getSecondaryCameraType();
      } else {
        paramProductType = null;
      }
      if ((paramProductType != null) && (paramProductType.equals(DJIComponentManager.CameraComponentType.GD600))) {
        return R.raw.iframe_1080x720_gd600;
      }
      if ((paramInt1 == 640) && (paramInt2 == 368))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_640x368_wm620", new Object[0]);
        return R.raw.iframe_640x368_wm620;
      }
      if ((paramInt1 == 608) && (paramInt2 == 448))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_608x448_wm620", new Object[0]);
        return R.raw.iframe_608x448_wm620;
      }
      if ((paramInt1 == 720) && (paramInt2 == 480))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_720x480_wm620", new Object[0]);
        return R.raw.iframe_720x480_wm620;
      }
      if ((paramInt1 == 1280) && (paramInt2 == 720))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1280x720_wm620", new Object[0]);
        return R.raw.iframe_1280x720_wm620;
      }
      if ((paramInt1 == 1080) && (paramInt2 == 720))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1080x720_wm620", new Object[0]);
        return R.raw.iframe_1080x720_wm620;
      }
      if ((paramInt1 == 1088) && (paramInt2 == 720))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1088x720_wm620", new Object[0]);
        return R.raw.iframe_1088x720_wm620;
      }
      if ((paramInt1 == 960) && (paramInt2 == 720))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_960x720_wm620", new Object[0]);
        return R.raw.iframe_960x720_wm620;
      }
      if ((paramInt1 == 1360) && (paramInt2 == 720))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1360x720_wm620", new Object[0]);
        return R.raw.iframe_1360x720_wm620;
      }
      if ((paramInt1 == 1344) && (paramInt2 == 720))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1344x720_wm620", new Object[0]);
        return R.raw.iframe_1344x720_wm620;
      }
      if ((paramInt1 == 1440) && (paramInt2 == 1088))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1440x1088_wm620", new Object[0]);
        return R.raw.iframe_1440x1088_wm620;
      }
      if ((paramInt1 == 1632) && (paramInt2 == 1080))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1632x1080_wm620", new Object[0]);
        return R.raw.iframe_1632x1080_wm620;
      }
      if ((paramInt1 == 1760) && (paramInt2 == 720))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1760x720_wm620", new Object[0]);
        return R.raw.iframe_1760x720_wm620;
      }
      if ((paramInt1 == 1920) && (paramInt2 == 800))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1920x800_wm620", new Object[0]);
        return R.raw.iframe_1920x800_wm620;
      }
      if ((paramInt1 == 1920) && (paramInt2 == 1024))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1920x1024_wm620", new Object[0]);
        return R.raw.iframe_1920x1024_wm620;
      }
      if ((paramInt1 == 1920) && (paramInt2 == 1088))
      {
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1920x1080_wm620", new Object[0]);
        return R.raw.iframe_1920x1088_wm620;
      }
      i = j;
      if (paramInt1 != 1920) {
        break label1657;
      }
      i = j;
      if (paramInt2 != 1440) {
        break label1657;
      }
      RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1920x1440_wm620", new Object[0]);
      return R.raw.iframe_1920x1440_wm620;
    case 15: 
    case 16: 
    case 17: 
      if (DataCameraGetPushStateInfo.getInstance().getCameraType(new int[0]) == DataCameraGetPushStateInfo.CameraType.DJICameraTypeGD600) {
        return R.raw.iframe_1080x720_gd600;
      }
      return R.raw.iframe_1280x720_ins;
    case 13: 
    case 14: 
      if (paramInt1 != 960)
      {
        if (paramInt1 != 1088)
        {
          if (paramInt1 != 1280)
          {
            if (paramInt1 != 1344)
            {
              if (paramInt1 != 1440)
              {
                if (paramInt1 != 1632)
                {
                  if (paramInt1 != 1920) {
                    return R.raw.iframe_p4p_720_16x9;
                  }
                  if (paramInt2 != 800)
                  {
                    if (paramInt2 != 1024) {
                      return R.raw.iframe_1920x1088_wm620;
                    }
                    return R.raw.iframe_1920x1024_wm620;
                  }
                  return R.raw.iframe_1920x800_wm620;
                }
                return R.raw.iframe_1632x1080_wm620;
              }
              return R.raw.iframe_1440x1088_wm620;
            }
            return R.raw.iframe_p4p_1344x720;
          }
          return R.raw.iframe_p4p_720_16x9;
        }
        return R.raw.iframe_p4p_720_3x2;
      }
      return R.raw.iframe_p4p_720_4x3;
    case 12: 
      RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1280x720_p4", new Object[0]);
      return R.raw.iframe_1280x720_p4;
    case 11: 
      if (paramInt1 != 1024)
      {
        if (paramInt1 != 1280) {
          return R.raw.iframe_1280x720_p4;
        }
        return R.raw.iframe_1280x720_p4;
      }
      return R.raw.iframe_1024x768_wm100;
    case 9: 
    case 10: 
      if (DJIUSBWifiSwitchManager.getInstance().isWifiConnected()) {
        return R.raw.iframe_1280x720_wm220;
      }
      RoninLog.i("DJIVideoDecoder", "Selected Iframe=-1", new Object[0]);
      break;
    case 7: 
    case 8: 
      return R.raw.iframe_1280x720_ins;
    case 6: 
      if (paramInt1 == 960) {
        paramInt2 = R.raw.iframe_960x720_3s;
      }
      for (;;)
      {
        break;
        if (paramInt1 == 640) {
          paramInt2 = R.raw.iframe_640x480;
        } else {
          paramInt2 = R.raw.iframe_1280x720_3s;
        }
      }
      paramProductType = new StringBuilder();
      paramProductType.append("longan zoom width:");
      paramProductType.append(paramInt1);
      RoninLog.d("DJIVideoDecoder", paramProductType.toString(), new Object[0]);
      return paramInt2;
    case 5: 
      if (stateInfo.getVerstion(new int[0]) >= 4) {
        return -1;
      }
      return R.raw.iframe_1280x720_ins;
    case 4: 
      if (paramInt1 != 640)
      {
        if (paramInt1 != 848)
        {
          RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1280x720_3s", new Object[0]);
          return R.raw.iframe_1280x720_3s;
        }
        RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_848x480", new Object[0]);
        return R.raw.iframe_848x480;
      }
      RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_640x480", new Object[0]);
      return R.raw.iframe_640x480;
    }
    if (paramInt1 == 960)
    {
      RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_960x720_3s", new Object[0]);
      return R.raw.iframe_960x720_3s;
    }
    RoninLog.i("DJIVideoDecoder", "Selected Iframe=iframe_1280x720_3s", new Object[0]);
    int i = R.raw.iframe_1280x720_3s;
    label1657:
    return i;
  }
  
  public static String getStringDate()
  {
    Date localDate = new Date();
    return formatter.format(localDate);
  }
  
  /* Error */
  private void initPeakingFocusState(int... arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isNeedResetCodecWhenResolutionChanged()
  {
    return false;
  }
  
  public static Bitmap zoomImg(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
  
  /* Error */
  public void ConnectStatus(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void debugLOG(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void displayJpegFrame(byte[] arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void freshDecodeStatus(int paramInt)
  {
    this.statusMonitor.freshDataStatus(paramInt);
  }
  
  public Bitmap getBitmap(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public Bitmap getBitmap(boolean paramBoolean)
  {
    return null;
  }
  
  public long getLastExtraDrawTime(String paramString)
  {
    return 277702619L;
  }
  
  public long getLastFrameOutTime()
  {
    return this.tLastFrameOut;
  }
  
  public boolean getPeakFocusEnable()
  {
    return false;
  }
  
  public float getPeakFocusThreshold()
  {
    return 0.0F;
  }
  
  public int getPlaybackFrameRate()
  {
    return this.playbackFrameRate;
  }
  
  public int getSecondaryOutputInterval(String paramString)
  {
    return 0;
  }
  
  public UsbAccessoryService.VideoStreamSource getStreamSource()
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
  
  /* Error */
  public void initDecoder()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isDecoderOK()
  {
    return this.statusMonitor.isDecoderOK();
  }
  
  public boolean isHasVideoData()
  {
    return this.statusMonitor.isHasVideoData();
  }
  
  public boolean isSurfaceAvailable()
  {
    return this.renderManager != null;
  }
  
  public boolean needLowFrequencyForSmoothing()
  {
    return false;
  }
  
  public void pauseStatusCheck()
  {
    this.statusMonitor.pauseStatusCheck();
  }
  
  /* Error */
  public void queueInputBuffer(byte[] arg1, int arg2, long arg3, int arg5, boolean arg6, long arg7, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14)
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
  
  public void resetCodec()
  {
    this.server.resetCodec();
  }
  
  public void resetKeyFrame()
  {
    this.client.resetKeyFrame();
  }
  
  public void resetToManager()
  {
    ServiceManager.getInstance().setVideoDecoder(this);
  }
  
  public void resumeStatusCheck()
  {
    this.statusMonitor.resumeStatusCheck();
  }
  
  public void setConnectLosedelay(int paramInt)
  {
    this.statusMonitor.setConnectLosedelay(paramInt);
  }
  
  /* Error */
  public void setPeakFocusEnable(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setPeakFocusThreshold(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setPlaybackFrameRate(int paramInt)
  {
    this.playbackFrameRate = paramInt;
  }
  
  public void setRecvDataCallBack(RecvDataCallback paramRecvDataCallback)
  {
    this.mCallback = paramRecvDataCallback;
  }
  
  public void setSecondaryOutputInterval(String paramString, int paramInt)
  {
    SurfaceInterface localSurfaceInterface = this.renderManager;
    if (localSurfaceInterface != null) {
      localSurfaceInterface.setSecondaryOutputInterval(paramString, paramInt);
    }
  }
  
  /* Error */
  public void setSecondaryOutputSurface(String arg1, Object arg2, int arg3, int arg4, int arg5, int arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setSurface(SurfaceInterface arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setVideoDataListener(DecoderListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private class DJIDecodeClient
  {
    private HandlerThread inoutThread;
    
    private DJIDecodeClient() {}
    
    /* Error */
    private void queueInFrame(byte[] arg1, int arg2, int arg3, boolean arg4, long arg5, long arg7, int arg9, int arg10)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void resetKeyFrame()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void startServer()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void stopServer()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  private class DJIDecodeServer
    extends Handler
  {
    private static final int DEQUEUE_INPUT_BUFFER = 10000;
    private static final int MSG_INIT = 0;
    private static final int MSG_IN_OUT = 2;
    private static final int MSG_QUEUEIN = 1;
    private static final int MSG_REINIT_KEY_FRAME = 10;
    LinkedList<Long> bufferChangedQueue = new LinkedList();
    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    private MediaCodec codec = null;
    private int codecDequeueFailCount = 0;
    private int codecFailResetThreshold = 20;
    private int count = 0;
    private boolean decoderConfigure = false;
    private boolean iframeIntoCodec = false;
    private boolean iframeIntoQueue = false;
    private boolean initCodecing = false;
    private ByteBuffer[] inputBuffers;
    private BlockingQueue<DJIVideoDecoder.InputFrame> inputQueue = new LinkedBlockingQueue(15);
    private long lastT = 0L;
    int outputBufferIndex;
    private ByteBuffer[] outputBuffers;
    private long start_time = System.currentTimeMillis();
    long timeOutput;
    
    public DJIDecodeServer(Looper paramLooper)
    {
      super();
    }
    
    /* Error */
    private void initVideoDecoder()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    private void onDecoderInput()
      throws java.lang.Exception
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    private void onOutputBufferChanged()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void onOutputFormatChanged()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void onOutputFrame()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void onServerQueuein(Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void printRate()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void queueToCodec(MediaCodec arg1, byte[] arg2, int arg3, int arg4, int arg5, long arg6, int arg8)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void releaseDecoder()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public byte[] getDefaultKeyFrame(int paramInt1, int paramInt2)
    {
      return null;
    }
    
    /* Error */
    public void handleMessage(Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isInitingCodec()
    {
      return this.initCodecing;
    }
    
    /* Error */
    public void onDecoderOutput()
      throws java.lang.Exception
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
  }
  
  private static class InputFrame
  {
    public long codecOutputTime;
    public long comPts;
    public long fedIntoCodecTime;
    public long frameIndex;
    public int frameNum;
    public int height;
    public long incomingTimeMs;
    public boolean isKeyFrame;
    public int size;
    public byte[] videoBuffer;
    public int width;
    
    public InputFrame(byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt2, long paramLong3, int paramInt3, int paramInt4)
    {
      this.videoBuffer = paramArrayOfByte;
      this.size = paramInt1;
      this.comPts = paramLong1;
      this.incomingTimeMs = paramLong2;
      this.isKeyFrame = paramBoolean;
      this.frameNum = paramInt2;
      this.frameIndex = paramLong3;
      this.width = paramInt3;
      this.height = paramInt4;
    }
    
    public long getDecodingDelay()
    {
      return this.codecOutputTime - this.fedIntoCodecTime;
    }
    
    public long getQueueDelay()
    {
      return this.fedIntoCodecTime - this.incomingTimeMs;
    }
    
    public long getTotalDelay()
    {
      return this.codecOutputTime - this.fedIntoCodecTime;
    }
  }
  
  private class StatusMonitor
  {
    private static final int MSG_ID_CONNECT_LOSE = 1;
    private static final int MSG_ID_NO_VIDEO_DATA = 3;
    private int connectLosedelayMillis = 2000;
    protected DJIVideoDecoder.VideoDecodeStatus curDecodeHealthStatus = DJIVideoDecoder.VideoDecodeStatus.Healthy;
    protected DJIVideoEvent curEvent = DJIVideoEvent.ConnectLose;
    protected DJIVideoDataEvent curVideoEvent = DJIVideoDataEvent.NoVideo;
    private Handler handler = new Handler(new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        return false;
      }
    });
    
    private StatusMonitor() {}
    
    /* Error */
    private void checkVideoDecodeStatus()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void freshDataStatus(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void freshDataStatusWithOK(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void freshDecodeStatus(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void freshDecodeStatusWithOK(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    private boolean isDecoderOK()
    {
      return false;
    }
    
    private boolean isHasVideoData()
    {
      return false;
    }
    
    /* Error */
    private void pauseStatusCheck()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void release()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void resumeStatusCheck()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private void setConnectLosedelay(int paramInt)
    {
      this.connectLosedelayMillis = paramInt;
      freshDecodeStatus(paramInt);
      freshDataStatus(this.connectLosedelayMillis);
    }
    
    private void setVideoDataEvent(DJIVideoDataEvent paramDJIVideoDataEvent)
    {
      this.curVideoEvent = paramDJIVideoDataEvent;
      checkVideoDecodeStatus();
    }
    
    private void setVideoEvent(DJIVideoEvent paramDJIVideoEvent)
    {
      this.curEvent = paramDJIVideoEvent;
      checkVideoDecodeStatus();
    }
  }
  
  public static enum VideoDecodeStatus
  {
    static
    {
      VideoDecodeStatus localVideoDecodeStatus = new VideoDecodeStatus("Healthy", 1);
      Healthy = localVideoDecodeStatus;
      $VALUES = new VideoDecodeStatus[] { Unhealthy, localVideoDecodeStatus };
    }
    
    private VideoDecodeStatus() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\DJIVideoDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */