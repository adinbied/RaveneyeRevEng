package dji.midware.media.record;

import android.location.Location;
import android.media.MediaFormat;
import dji.log.RoninLog;
import dji.midware.data.manager.P3.ServiceManager;
import dji.midware.media.DJIAudioEncoder.DJIAudioEncoderListener;
import dji.midware.media.DJIAudioRecordWrapper;
import dji.midware.media.MediaLogger;
import dji.midware.media.muxer.DJIMuxerInterface;
import dji.midware.media.transcode.online.OnlineTranscoder.OnlineTranscoderListener;
import java.io.File;
import org.greenrobot.eventbus.EventBus;

public class RecorderAudioMp4
  extends RecorderBase
  implements RecorderInterface, OnlineTranscoder.OnlineTranscoderListener, DJIAudioEncoder.DJIAudioEncoderListener
{
  private static final boolean DEBUG = false;
  public static String TAG = "RecorderAudioMp4";
  private static RecorderAudioMp4 instance;
  private DJIAudioRecordWrapper audioRecordWrapper;
  private int audioTrackIndex = -1;
  public String fileName;
  private long initAudioPts;
  private long initial_original_pts = -1L;
  private boolean isMuxerStarted;
  private boolean isStarted = false;
  private long lastAudioPts;
  private long lastVideoPts;
  public Location loc;
  private DJIMuxerInterface muxer = null;
  private boolean muxerInitialized = false;
  private boolean needRecordAudio = true;
  public int orientation;
  public byte[] pps;
  private String recordDir;
  private volatile RecorderAudioState recorderAudioState = RecorderAudioState.NotInitiated;
  private ServiceManager serviceMangaer;
  public byte[] sps;
  private File testingFile;
  private int videoTrackIndex = -1;
  
  private RecorderAudioMp4()
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
      MediaLogger.show("RecorderAudioMp4 will be destroyed asynchronously");
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
  
  public static RecorderAudioMp4 getInstance()
  {
    try
    {
      if (instance == null)
      {
        instance = new RecorderAudioMp4();
        EventBus.getDefault().register(instance);
      }
      RecorderAudioMp4 localRecorderAudioMp4 = instance;
      return localRecorderAudioMp4;
    }
    finally {}
  }
  
  /* Error */
  private void initMuxer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private void log(String paramString) {}
  
  private void startRecordAudio() {}
  
  private void stopRecordAudio() {}
  
  protected String getTAG()
  {
    return TAG;
  }
  
  public RecorderAudioMp4 initVideoInfo(String paramString, Location paramLocation, int paramInt)
  {
    this.fileName = paramString;
    this.loc = paramLocation;
    this.orientation = paramInt;
    return this;
  }
  
  public boolean needRecordAudio()
  {
    return this.needRecordAudio;
  }
  
  /* Error */
  public void onDataEncoded(java.nio.ByteBuffer arg1, android.media.MediaCodec.BufferInfo arg2, long arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onEncoderInit(MediaFormat arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onEndRecord()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onFormatChanged(MediaFormat paramMediaFormat) {}
  
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
  
  public void setFileDir(String paramString)
  {
    this.recordDir = paramString;
  }
  
  public void setNeedRecordAudio(boolean paramBoolean)
  {
    this.needRecordAudio = paramBoolean;
  }
  
  /* Error */
  public void setRecorderAudioState(RecorderAudioState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum RecorderAudioState
  {
    static
    {
      AudioTrackAdded = new RecorderAudioState("AudioTrackAdded", 3);
      AllTracksAdded = new RecorderAudioState("AllTracksAdded", 4);
      RecorderAudioState localRecorderAudioState = new RecorderAudioState("Recording", 5);
      Recording = localRecorderAudioState;
      $VALUES = new RecorderAudioState[] { NotInitiated, Standby, VideoTrackAdded, AudioTrackAdded, AllTracksAdded, localRecorderAudioState };
    }
    
    private RecorderAudioState() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\record\RecorderAudioMp4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */