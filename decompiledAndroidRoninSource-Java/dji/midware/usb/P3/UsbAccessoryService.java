package dji.midware.usb.P3;

import android.content.Context;
import android.content.IntentFilter;
import dji.log.RoninLog;
import dji.midware.data.manager.P3.DJIPackManager;
import dji.midware.data.manager.P3.DJIServiceInterface;
import dji.midware.parser.plugins.DJIPluginLBChanneParser;
import dji.midware.parser.plugins.DJIPluginLBChanneParser.DJILBChannelListener;
import dji.midware.parser.plugins.DJIPluginRingBufferParser;
import dji.midware.parser.plugins.DJIPluginRingBufferParser.DJIRingBufferParserListener;
import dji.midware.parser.plugins.DJIRingBufferModel;
import dji.midware.util.BytesUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class UsbAccessoryService
  implements DJIServiceInterface
{
  private static boolean IS_BUFFER_VIDEODATA = true;
  public static boolean STREAM_DEBUG;
  private static UsbAccessoryService instance;
  private static DJIUsbAccessoryReceiver usbReceiver;
  private final boolean IS_PRINT_RATE = true;
  private final boolean IS_SaveData = false;
  private final boolean IS_SaveDownData = false;
  private final String TAG = getClass().getSimpleName();
  private int aoa_log_update = 0;
  private long count = 0L;
  private File dataFile = new File("/sdcard/aoa_recv.bin");
  private boolean dataMode;
  private FileOutputStream dataoFileOutputStream;
  private DJIPluginLBChanneParser djiPluginLBChanneParser;
  private File downFile = new File("/sdcard/aoa_dowon.bin");
  private FileOutputStream downFileOutputStream;
  int ecount = 0;
  private InputStream inputStream;
  private int ioerrorcount = 0;
  private boolean isParse = true;
  private boolean isPauseRarseThread = false;
  private boolean isPauseRecvThread = false;
  private boolean isPauseService = false;
  private boolean isStartStream;
  private long lastT = 0L;
  private long last_frame_num_packet = 0L;
  private long last_frame_size = 0L;
  private long last_frame_start_time = -1L;
  private volatile boolean mParseVideoRun;
  private volatile boolean mRecvBufferRun;
  private OutputStream outputStream;
  private DJIPackManager packManager;
  private Thread parseVideoFromCamThread;
  private Thread parseVideoFromFpvThread;
  private Thread recvBufferThread;
  private DJIPluginRingBufferParser ringBufferParser;
  private VideoBufferQueue videoBufferQueueForCamera = new VideoBufferQueue();
  private VideoBufferQueue videoBufferQueueForFpv = new VideoBufferQueue();
  
  public UsbAccessoryService()
  {
    startStream();
    this.packManager = DJIPackManager.getInstance();
    DJIRingBufferModel localDJIRingBufferModel = new DJIRingBufferModel();
    localDJIRingBufferModel.header = new byte[] { 85, -52 };
    localDJIRingBufferModel.secondHeaderLen = 6;
    this.ringBufferParser = new DJIPluginRingBufferParser(102400, localDJIRingBufferModel, new DJIPluginRingBufferParser.DJIRingBufferParserListener()
    {
      private int dataLen = 0;
      private short dataType = 0;
      
      /* Error */
      public void onGetBody(byte[] arg1, int arg2, int arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public int parseSecondHeader(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        this.dataType = BytesUtil.getShort(paramAnonymousArrayOfByte, paramAnonymousInt1);
        paramAnonymousInt1 = BytesUtil.getInt(paramAnonymousArrayOfByte, paramAnonymousInt1 + 2);
        this.dataLen = paramAnonymousInt1;
        paramAnonymousInt2 = this.dataType;
        if ((paramAnonymousInt2 <= 22349) && (paramAnonymousInt2 >= 22345)) {
          return paramAnonymousInt1;
        }
        paramAnonymousArrayOfByte = UsbAccessoryService.this;
        paramAnonymousArrayOfByte.ecount += 1;
        paramAnonymousArrayOfByte = UsbAccessoryService.this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("错包数量=");
        localStringBuilder.append(UsbAccessoryService.this.ecount);
        RoninLog.d(paramAnonymousArrayOfByte, localStringBuilder.toString(), new Object[0]);
        return -1;
      }
    });
    this.djiPluginLBChanneParser = new DJIPluginLBChanneParser(new DJIPluginLBChanneParser.DJILBChannelListener()
    {
      /* Error */
      public void onRecv(int arg1, byte[] arg2, int arg3, int arg4)
      {
        // Byte code:
        //   0: return
        //   1: astore_2
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static void Destroy()
  {
    UsbAccessoryService localUsbAccessoryService = instance;
    if (localUsbAccessoryService != null) {
      localUsbAccessoryService.destroy();
    }
  }
  
  public static void DestroyFinal()
  {
    if (instance != null)
    {
      DJIUsbAccessoryReceiver localDJIUsbAccessoryReceiver = usbReceiver;
      if (localDJIUsbAccessoryReceiver != null) {
        localDJIUsbAccessoryReceiver.clearTimer();
      }
      instance.destroy();
    }
  }
  
  public static UsbAccessoryService getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new UsbAccessoryService();
      }
      UsbAccessoryService localUsbAccessoryService = instance;
      return localUsbAccessoryService;
    }
    finally {}
  }
  
  private long getTickCount()
  {
    return System.currentTimeMillis();
  }
  
  /* Error */
  private void handleOldMethod(byte[] arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isAllwaysLiveViewWhenDownload()
  {
    return false;
  }
  
  /* Error */
  private void print(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void printRate(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void putVideoBuffer(byte[] arg1, int arg2, int arg3, VideoStreamSource arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static void registerAoaReceiver(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    Object localObject = new DJIUsbAccessoryReceiver();
    usbReceiver = (DJIUsbAccessoryReceiver)localObject;
    ((DJIUsbAccessoryReceiver)localObject).start(paramContext);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.dji.v4.accessory.USB");
    ((IntentFilter)localObject).addAction("android.hardware.usb.action.USB_ACCESSORY_ATTACHED");
    ((IntentFilter)localObject).addAction("android.hardware.usb.action.USB_ACCESSORY_DETACHED");
    ((IntentFilter)localObject).addAction("com.dji.v4.accessory.USB_ACCESSORY_ATTACHED");
    paramContext.registerReceiver(usbReceiver, (IntentFilter)localObject);
  }
  
  /* Error */
  private void startRecvBufferThread()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void toTransVideoData(byte[] arg1, int arg2, VideoStreamSource arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void handleNewMethod(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    DJIPluginLBChanneParser localDJIPluginLBChanneParser = this.djiPluginLBChanneParser;
    if (localDJIPluginLBChanneParser != null) {
      localDJIPluginLBChanneParser.parse(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public boolean isConnected()
  {
    return false;
  }
  
  public boolean isOK()
  {
    return isConnected();
  }
  
  public boolean isRemoteOK()
  {
    return this.packManager.isRemoteConnected();
  }
  
  /* Error */
  public void onConnect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDisconnect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void pauseParseThread()
  {
    this.isPauseRarseThread = true;
  }
  
  public void pauseRecvThread()
  {
    this.isPauseRecvThread = true;
  }
  
  /* Error */
  public void pauseService(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void resumeParseThread()
  {
    this.isPauseRarseThread = false;
  }
  
  public void resumeRecvThread()
  {
    this.isPauseRecvThread = false;
  }
  
  /* Error */
  public void sendmessage(dji.midware.data.packages.P3.SendPack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void sendmessage(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setDataMode(boolean paramBoolean)
  {
    this.dataMode = paramBoolean;
  }
  
  /* Error */
  public void startParseVideoThread()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startStream()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startThreads()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stopStream()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void testToAddBuffer(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void testToRecv()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class ParseVideoRunnable
    implements Runnable
  {
    public static final String TAG = "VideoStream_Parse_Thread";
    private UsbAccessoryService.VideoStreamSource videoStreamSource;
    
    public ParseVideoRunnable(UsbAccessoryService.VideoStreamSource paramVideoStreamSource)
    {
      this.videoStreamSource = paramVideoStreamSource;
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
  
  private class RecvBufferRunnable
    implements Runnable
  {
    public static final String TAG = "Hybrid_Recieve_Thread";
    int frame_count = 0;
    
    private RecvBufferRunnable() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  private static class VideoBufferInfo
  {
    public byte[] buffer;
    public int length = -1;
  }
  
  private static class VideoBufferQueue
  {
    private static String TAG = "VideoBufferQueue";
    private static final int VIDEO_LIST_SIZE = 300;
    private int getVideoIndex = 0;
    private volatile boolean mbHasInited = false;
    private int oneBufferSize = 30720;
    private int setVideoIndex = 0;
    private ArrayList<UsbAccessoryService.VideoBufferInfo> videoBufferInfoList = new ArrayList(300);
    private ArrayList<byte[]> videoList = new ArrayList(300);
    private ArrayList<Integer> videoSizeList = new ArrayList(300);
    
    public UsbAccessoryService.VideoBufferInfo dequeueData()
    {
      return null;
    }
    
    /* Error */
    public void finalizeSelf()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
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
    
    /* Error */
    public void queueInData(byte[] arg1, int arg2, int arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static enum VideoStreamSource
  {
    private int index;
    
    static
    {
      VideoStreamSource localVideoStreamSource = new VideoStreamSource("Unknown", 3, 255);
      Unknown = localVideoStreamSource;
      $VALUES = new VideoStreamSource[] { Camera, Fpv, SecondaryCamera, localVideoStreamSource };
    }
    
    private VideoStreamSource(int paramInt)
    {
      this.index = paramInt;
    }
    
    public static VideoStreamSource find(int paramInt)
    {
      VideoStreamSource[] arrayOfVideoStreamSource = values();
      int j = arrayOfVideoStreamSource.length;
      int i = 0;
      while (i < j)
      {
        VideoStreamSource localVideoStreamSource = arrayOfVideoStreamSource[i];
        if (localVideoStreamSource.getIndex() == paramInt) {
          return localVideoStreamSource;
        }
        i += 1;
      }
      return Unknown;
    }
    
    public int getIndex()
    {
      return this.index;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\usb\P3\UsbAccessoryService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */