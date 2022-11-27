package com.dji.video.framing.internal.recorder;

import android.location.Location;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.dji.video.framing.internal.audio.DJIAudioEncoder;
import com.dji.video.framing.internal.audio.DJIAudioEncoder.DJIAudioEncoderListener;
import com.dji.video.framing.internal.audio.DJIAudioRecordWrapper;
import com.dji.video.framing.internal.audio.DJIAudioRecordWrapper.DJIAudioRecordListenter;
import com.dji.video.framing.internal.decoder.DJIVideoDecoder;
import com.dji.video.framing.internal.encoder.FullFrameHardwareTranscoder.FullFrameTranscoderListener;
import java.io.File;

public class RecorderAudioFullFrame
  extends RecorderBase
  implements DJIAudioEncoder.DJIAudioEncoderListener, FullFrameHardwareTranscoder.FullFrameTranscoderListener, DJIAudioRecordWrapper.DJIAudioRecordListenter
{
  private static final boolean DEBUG = false;
  public static String TAG = "RecorderAudioFullFrame";
  private static RecorderAudioFullFrame instance;
  private DJIAudioEncoder audioEncoder;
  private long audioPtsBase = -1L;
  private DJIAudioRecordWrapper audioRecordWrapper;
  private int audioTrackIndex = -1;
  public String fileName;
  private long initial_original_pts = -1L;
  private boolean isMuxerStarted;
  private boolean isStarted = false;
  private long lastAudioPts = -1L;
  private long lastRecvAudioPts = -1L;
  private long lastVideoPts = -1L;
  public Location loc;
  private boolean muxerInitialized = false;
  private boolean needRecordAudio = true;
  public int orientation;
  public byte[] pps;
  private String recordDir;
  private volatile RecorderAudioState recorderAudioState = RecorderAudioState.NotInitiated;
  private Object recorderLock = new Object();
  public byte[] sps;
  private File testingFile;
  private long videoPtsBase = -1L;
  private int videoTrackIndex = -1;
  
  public RecorderAudioFullFrame(RecorderManager paramRecorderManager, DJIVideoDecoder paramDJIVideoDecoder, String paramString)
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
  
  protected int[] getRecordWidthHeight()
  {
    return null;
  }
  
  protected String getTAG()
  {
    return TAG;
  }
  
  public RecorderAudioFullFrame initVideoInfo(String paramString, Location paramLocation, int paramInt)
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
  public void onAudioDataRead(java.nio.ByteBuffer arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDataEncoded(java.nio.ByteBuffer arg1, MediaCodec.BufferInfo arg2, long arg3)
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
  public void onFrameInput(java.nio.ByteBuffer arg1, MediaCodec.BufferInfo arg2, int arg3, int arg4, boolean arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void onFrameInput(byte[] paramArrayOfByte, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  /* Error */
  protected void onStartRecord()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\recorder\RecorderAudioFullFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */