package dji.midware.media.record;

import dji.log.RoninLog;
import dji.midware.media.MediaLogger;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import org.greenrobot.eventbus.EventBus;

public class RecorderH264
  extends RecorderBase
  implements RecorderInterface, H264FrameListener
{
  private static String TAG = "H264Recorder";
  private static RecorderH264 instance;
  private BufferedOutputStream h264BufferedOutputStream = null;
  private BufferedOutputStream h264IndexBos = null;
  private OutputStream h264IndexFos = null;
  private OutputStream h264OutputStream = null;
  
  private RecorderH264()
  {
    RoninLog.i(TAG, "An instance is created", new Object[0]);
  }
  
  /* Error */
  private void addIFrame()
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
      MediaLogger.show("RecorderH264 is destroyed");
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
  
  public static RecorderH264 getInstance()
  {
    try
    {
      if (instance == null)
      {
        instance = new RecorderH264();
        EventBus.getDefault().register(instance);
      }
      RecorderH264 localRecorderH264 = instance;
      return localRecorderH264;
    }
    finally {}
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
  
  protected void onEndRecord()
  {
    detachListenerToUpstream();
    endRecordVideoInfo();
    closeOrDeleteFile();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\record\RecorderH264.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */