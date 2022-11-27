package dji.midware.media.record;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import dji.log.RoninLog;
import dji.midware.data.manager.P3.ServiceManager;
import dji.midware.media.MediaLogger;
import dji.midware.media.muxer.DJIMuxerInterface;
import dji.midware.media.transcode.online.OnlineTranscoder.OnlineTranscoderListener;
import org.greenrobot.eventbus.EventBus;

public class RecorderMp4
  extends RecorderBase
  implements RecorderInterface, OnlineTranscoder.OnlineTranscoderListener
{
  private static final boolean DEBUG = false;
  public static String TAG = "RecorderMp4";
  private static RecorderMp4 instance;
  private static MediaRecorder recorder;
  private long initial_original_pts = -1L;
  private DJIMuxerInterface muxer = null;
  private boolean muxerInitialized = false;
  private ServiceManager serviceMangaer;
  
  private RecorderMp4()
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
      MediaLogger.show("RecorderMp4 will be destroyed asynchronously");
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
  
  public static RecorderMp4 getInstance()
  {
    try
    {
      if (instance == null)
      {
        instance = new RecorderMp4();
        EventBus.getDefault().register(instance);
      }
      RecorderMp4 localRecorderMp4 = instance;
      return localRecorderMp4;
    }
    finally {}
  }
  
  /* Error */
  private void startRecordAudio()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void stopRecordAudio()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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
  public void onFrameInput(java.nio.ByteBuffer arg1, android.media.MediaCodec.BufferInfo arg2, int arg3, int arg4, int arg5)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\record\RecorderMp4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */