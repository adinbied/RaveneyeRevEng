package com.dji.video.framing.internal.recorder;

import android.media.MediaFormat;
import com.dji.video.framing.internal.audio.DJIAudioEncoder;
import com.dji.video.framing.internal.audio.DJIAudioEncoder.DJIAudioEncoderListener;
import com.dji.video.framing.internal.audio.DJIAudioRecordWrapper;
import com.dji.video.framing.internal.audio.DJIAudioRecordWrapper.DJIAudioRecordListenter;
import com.dji.video.framing.internal.decoder.DJIVideoDecoder;
import com.dji.video.framing.internal.decoder.decoderinterface.IVideoRecordDataListener;

public class RecorderAudioMp4
  extends RecorderBase
  implements DJIAudioEncoder.DJIAudioEncoderListener, DJIAudioRecordWrapper.DJIAudioRecordListenter, IVideoRecordDataListener
{
  private static final boolean DEBUG = false;
  private static final int MAX_VIDEO_PTS_INTERVAL = 47619;
  public static String TAG = "RecorderAudioMp4";
  private static final int VIDEO_AUDIO_PTS_DIFF_THRESHOLD = 1000;
  private static RecorderAudioMp4 instance;
  private DJIAudioEncoder audioEncoder;
  private long audioPtsBase = -1L;
  private DJIAudioRecordWrapper audioRecordWrapper;
  private int audioTrackIndex = -1;
  private long initial_original_pts = -1L;
  private boolean isMuxerStarted;
  private boolean isStarted = false;
  private long lastAudioPts = -1L;
  private long lastRecvAudioPts = -1L;
  private long lastVideoPts = -1L;
  private boolean muxerInitialized = false;
  private boolean needRecordAudio = true;
  private String recordDir;
  private volatile RecorderAudioState recorderAudioState = RecorderAudioState.NotInitiated;
  private Object recorderLock = new Object();
  private long videoPtsBase = -1L;
  private int videoTrackIndex = -1;
  
  public RecorderAudioMp4(RecorderManager paramRecorderManager, DJIVideoDecoder paramDJIVideoDecoder, String paramString)
  {
    super(paramRecorderManager, paramDJIVideoDecoder, paramString);
    paramRecorderManager = new StringBuilder();
    paramRecorderManager.append("create instance: ");
    paramRecorderManager.append(this);
    logToFile(paramRecorderManager.toString());
  }
  
  /* Error */
  private void initMuxer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void log(String paramString) {}
  
  /* Error */
  private void logToFile(String arg1)
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
  
  public boolean needRecordAudio()
  {
    return this.needRecordAudio;
  }
  
  /* Error */
  public void onAudioDataRead(java.nio.ByteBuffer arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDataEncoded(java.nio.ByteBuffer arg1, android.media.MediaCodec.BufferInfo arg2, long arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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
  protected void onStartRecord()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onVideoFrameInput(com.dji.video.framing.internal.VideoFrame arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void onVolumeRefresh(double paramDouble) {}
  
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\recorder\RecorderAudioMp4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */