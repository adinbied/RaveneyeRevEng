package dji.midware.media.record;

import dji.log.RoninLog;
import dji.midware.data.manager.P3.ServiceManager;
import dji.midware.media.DJIVideoHardwareEncoder;
import dji.midware.media.MediaLogger;
import dji.midware.media.muxer.DJIMuxerInterface;
import dji.midware.media.transcode.fullframe.FullFrameHardwareTranscoder.FullFrameTranscoderListener;
import org.greenrobot.eventbus.EventBus;

public class RecorderFullFrame
  extends RecorderBase
  implements RecorderInterface, FullFrameHardwareTranscoder.FullFrameTranscoderListener
{
  private static final boolean DEBUG = false;
  public static String TAG = "RecorderFullFrame";
  private static RecorderFullFrame instance;
  private DJIVideoHardwareEncoder encoder;
  private long initial_original_pts = -1L;
  private long last_original_pts = -1L;
  private long last_written_pts = -1L;
  private DJIMuxerInterface muxer = null;
  private boolean muxerInitialized = false;
  private ServiceManager serviceMangaer;
  
  private RecorderFullFrame()
  {
    RoninLog.i(TAG, "An instance is created", new Object[0]);
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
      MediaLogger.show("RecorderFullFrame will be destroyed asynchronously");
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
  
  public static RecorderFullFrame getInstance()
  {
    try
    {
      if (instance == null)
      {
        instance = new RecorderFullFrame();
        EventBus.getDefault().register(instance);
      }
      RecorderFullFrame localRecorderFullFrame = instance;
      return localRecorderFullFrame;
    }
    finally {}
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
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onFrameInput(java.nio.ByteBuffer arg1, android.media.MediaCodec.BufferInfo arg2, int arg3, int arg4, boolean arg5)
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
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\record\RecorderFullFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */