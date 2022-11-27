package dji.midware.usbhost.P3;

import android.content.Context;
import android.os.Environment;
import dji.midware.data.manager.P3.DJIPackManager;
import dji.midware.data.manager.P3.DJIServiceInterface;
import dji.midware.data.manager.P3.DJIVideoPackManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class UsbHostServiceRC
  implements DJIServiceInterface
{
  static boolean firstRecv = true;
  private static UsbHostServiceRC instance;
  private static final String saveVideoPath;
  private final boolean IS_PRINT_RATE = true;
  private final String TAG = getClass().getSimpleName();
  private byte[] boxbuffer = new byte['䀀'];
  private int count = 0;
  private boolean dataMode;
  private FileOutputStream fileOutputStream = null;
  private int getVideoIndex = 0;
  private boolean isPauseRecvThread = false;
  private boolean isPauseService = false;
  private boolean isPaused = false;
  private final boolean isSaveVideoToFile = false;
  private boolean isStartStream;
  private long lastT = 0L;
  private boolean mOsdRun;
  private boolean mParseRun;
  private boolean mParseVideoRun;
  private boolean mVodRun;
  private boolean m_cmd_serial = true;
  private byte[] osdbuffer = new byte['က'];
  private DJIPackManager packManager;
  private Thread parseVideoThread;
  private int setVideoIndex = 0;
  private ArrayList<byte[]> videoList = new ArrayList(50);
  private DJIVideoPackManager videoPackManager;
  private ArrayList<Integer> videoSizeList = new ArrayList(50);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("usbhost.264");
    saveVideoPath = localStringBuilder.toString();
  }
  
  public UsbHostServiceRC()
  {
    System.out.println("xxxxxxxxxxxxxx UsbHostServiceRC construct");
    startStream();
    this.packManager = DJIPackManager.getInstance();
    this.videoPackManager = DJIVideoPackManager.getInstance();
    NativeRcController.rc_init();
    NativeRcController.rc_set_cb_obj(this);
  }
  
  public static void Destroy()
  {
    UsbHostServiceRC localUsbHostServiceRC = instance;
    if (localUsbHostServiceRC != null) {
      localUsbHostServiceRC.destroy();
    }
  }
  
  public static void Pause()
  {
    UsbHostServiceRC localUsbHostServiceRC = instance;
    if (localUsbHostServiceRC != null) {
      localUsbHostServiceRC.pause();
    }
  }
  
  public static UsbHostServiceRC getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new UsbHostServiceRC();
      }
      UsbHostServiceRC localUsbHostServiceRC = instance;
      return localUsbHostServiceRC;
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
  
  private void pause()
  {
    this.isPaused = true;
    firstRecv = true;
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
  
  private void startRecvVodThread() {}
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void handleNewMethod(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public boolean isConnected()
  {
    return true;
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
  
  /* Error */
  public void onSerialRecv(byte[] arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Deprecated
  public void onVideoRecv(byte[] paramArrayOfByte, int paramInt) {}
  
  @Deprecated
  public void onVideoRecv(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9) {}
  
  /* Error */
  public void onVideoRecv(byte[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11)
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
  
  public void resume()
  {
    this.isPaused = false;
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
  
  public void start(Context paramContext)
  {
    paramContext.getApplicationContext();
    NativeRcController.rc_init();
  }
  
  /* Error */
  public void startStream()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void startThreads() {}
  
  public void stop(Context paramContext) {}
  
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
    
    public void run()
    {
      UsbHostServiceRC.this.print("ParseVideoRunnable.end");
    }
  }
  
  private class RecvVodRunnable
    implements Runnable
  {
    private RecvVodRunnable() {}
    
    public void run() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\usbhost\P3\UsbHostServiceRC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */