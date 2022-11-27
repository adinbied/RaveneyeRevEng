package dji.midware.media.record;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaMuxer;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.media.MediaLogger;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import org.greenrobot.eventbus.EventBus;

public class RecorderGop
  extends RecorderBase
  implements RecorderInterface, H264FrameListener
{
  private static String TAG = "RecorderGop";
  private static RecorderGop instance;
  private long cmdOpDelay;
  private long cmdStartTime;
  private boolean cmdSuccess;
  private Object cmdSync = new Object();
  private BufferedOutputStream h264BufferedOutputStream = null;
  private OutputStream h264OutputStream = null;
  private MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
  private MediaMuxer muxer = null;
  private int numFrameJumped;
  boolean start = true;
  private boolean writeH264File = false;
  
  /* Error */
  private void activeGOP()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void closeOrDeleteFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void createFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static void destroy()
  {
    try
    {
      MediaLogger.show("RecorderGop is destroyed");
      if (instance != null)
      {
        instance.onDestroy();
        instance = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static RecorderGop getInstance()
  {
    try
    {
      if (instance == null)
      {
        instance = new RecorderGop();
        EventBus.getDefault().register(instance);
      }
      RecorderGop localRecorderGop = instance;
      return localRecorderGop;
    }
    finally {}
  }
  
  private boolean isIFrame(byte[] paramArrayOfByte)
  {
    return false;
  }
  
  /* Error */
  public void attachListenerToUpstream()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void detachListenerToUpstream()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected String getTAG()
  {
    return TAG;
  }
  
  /* Error */
  protected void onEndRecord()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onH264FrameInput(byte[] arg1, int arg2, long arg3, boolean arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void onStartRecord()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\record\RecorderGop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */