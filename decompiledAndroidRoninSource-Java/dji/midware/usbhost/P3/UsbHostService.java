package dji.midware.usbhost.P3;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.os.Environment;
import dji.midware.data.manager.P3.DJIPackManager;
import dji.midware.data.manager.P3.DJIServiceInterface;
import dji.midware.natives.FPVController;
import dji.midware.parser.plugins.DJIPluginLBChanneParser;
import dji.midware.parser.plugins.DJIPluginLBChanneParser.DJILBChannelListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class UsbHostService
  implements DJIServiceInterface
{
  private static UsbHostService instance;
  private static final String saveVideoPath;
  private final boolean IS_PRINT_RATE = true;
  private final String TAG = getClass().getSimpleName();
  private byte[] boxbuffer = new byte['䀀'];
  private UsbDeviceConnection connection;
  private int count = 0;
  private boolean dataMode;
  private DJIPluginLBChanneParser djiPluginLBChanneParser;
  private FileOutputStream fileOutputStream = null;
  private int getVideoIndex = 0;
  private boolean isPauseRecvThread = false;
  private boolean isPauseService = false;
  private final boolean isSaveVideoToFile = false;
  private boolean isStartStream;
  private long lastT = 0L;
  private boolean mOsdRun;
  private boolean mParseRun;
  private boolean mParseVideoRun;
  private boolean mVodRun;
  private UsbEndpoint osdEndpoint;
  private byte[] osdbuffer = new byte['က'];
  private UsbEndpoint outEndpoint;
  private DJIPackManager packManager;
  private Thread parseOsdThread;
  private Thread parseVideoThread;
  private Thread recvOsdThread;
  private Thread recvVodThread;
  private int setVideoIndex = 0;
  private DJIUsbReceiver usbReceiver;
  private ArrayList<byte[]> videoList = new ArrayList(50);
  private ArrayList<Integer> videoSizeList = new ArrayList(50);
  private UsbEndpoint vodEndpoint;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("usbhost.264");
    saveVideoPath = localStringBuilder.toString();
  }
  
  public UsbHostService()
  {
    System.out.println("xxxxxxxxxxxxxx UsbHostService construct");
    this.djiPluginLBChanneParser = new DJIPluginLBChanneParser(new DJIPluginLBChanneParser.DJILBChannelListener()
    {
      public void onRecv(int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        FPVController.native_transferVideoData(paramAnonymousArrayOfByte, paramAnonymousInt3);
      }
    });
    startStream();
    this.packManager = DJIPackManager.getInstance();
  }
  
  public static void Destroy()
  {
    UsbHostService localUsbHostService = instance;
    if (localUsbHostService != null) {
      localUsbHostService.destroy();
    }
  }
  
  public static UsbHostService getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new UsbHostService();
      }
      UsbHostService localUsbHostService = instance;
      return localUsbHostService;
    }
    finally {}
  }
  
  private long getTickCount()
  {
    return System.currentTimeMillis();
  }
  
  /* Error */
  private void handleOldMethod(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
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
  private void printUI(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void putVideoBuffer(byte[] arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void startRecvVodThread()
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
  
  public void handleNewMethod(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    DJIPluginLBChanneParser localDJIPluginLBChanneParser = this.djiPluginLBChanneParser;
    if (localDJIPluginLBChanneParser != null) {
      localDJIPluginLBChanneParser.parse(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public boolean isConnected()
  {
    return this.usbReceiver.isGetedConnection();
  }
  
  public boolean isOK()
  {
    return isConnected();
  }
  
  public boolean isRemoteOK()
  {
    return true;
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
  
  public void pauseParseThread() {}
  
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
  
  public void resumeParseThread() {}
  
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
  
  public void setDataMode(boolean paramBoolean) {}
  
  /* Error */
  public void start(android.content.Context arg1)
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
  protected void startThreads()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stop(android.content.Context arg1)
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
  
  private class ParseVideoRunnable
    implements Runnable
  {
    public static final String TAG = "VideoStream_Parse_Thread";
    private int aoa_log_update = 0;
    private long last_frame_num_packet = 0L;
    private long last_frame_size = 0L;
    private long last_frame_start_time = -1L;
    
    private ParseVideoRunnable() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  private class RecvVodRunnable
    implements Runnable
  {
    private RecvVodRunnable() {}
    
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\usbhost\P3\UsbHostService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */