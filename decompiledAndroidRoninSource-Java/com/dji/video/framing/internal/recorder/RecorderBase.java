package com.dji.video.framing.internal.recorder;

import android.os.Handler;
import android.os.Looper;
import androidx.documentfile.provider.DocumentFile;
import com.dji.video.framing.VideoLog;
import com.dji.video.framing.internal.decoder.DJIVideoDecoder;
import com.dji.video.framing.internal.muxer.DJIMuxerInterface;
import com.dji.video.framing.internal.recorder.externalsd.ExternalSdRecordingHelper;
import com.dji.video.framing.utils.BackgroundLooper;

public abstract class RecorderBase
{
  protected static final float BUFFER_EXPAND_MULTIPLIER = 1.15F;
  private static final int CHECK_DECODER_INTERVAL = 500;
  private static final int CHECK_DECODER_RETRY_NUM = 20;
  protected static final int MAX_FRAME_DURATION = 41667;
  private static final int MIN_INTERVAL_TO_DECODER_INIT = 2000;
  private static final int MSG_CHECK_SPACE = 2;
  private static final int MSG_DESTROY = 3;
  private static final int MSG_START_RECORD = 0;
  private static final int MSG_STOP_RECORD = 1;
  private static final String TAG = "RecorderBase";
  protected long audioSampleWriteCount = 0L;
  private int checkDecoderNum = 0;
  DJIVideoDecoder currentDecoder;
  protected RecorderStatus currentStatus = RecorderStatus.Standby;
  protected ExternalSdRecordingHelper externalSdRecordingHelper;
  private long[] lastLogDataTimeArr = new long[LogDataMode.values().length];
  protected String mainFileName = "";
  RecorderManager manager;
  protected DJIMuxerInterface muxer = null;
  public int numFrameWritten;
  protected DocumentFile recordDirDf;
  protected Object recordStatusSwitchSync = new Object();
  private Handler stateHandler = new Handler(BackgroundLooper.getLooper())
  {
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  };
  
  RecorderBase(RecorderManager paramRecorderManager, DJIVideoDecoder paramDJIVideoDecoder, String paramString)
  {
    this.mainFileName = paramString;
    this.manager = paramRecorderManager;
    this.currentDecoder = paramDJIVideoDecoder;
  }
  
  /* Error */
  private void _startRecord()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void _stopRecord()
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
  
  private double getTotalDuration()
  {
    return 1.04279634E-315D;
  }
  
  public static void log2File(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("log2File: ");
    localStringBuilder.append(paramString);
    VideoLog.d("Recorder", localStringBuilder.toString(), new Object[0]);
  }
  
  protected boolean checkIsCurrentRecorder()
  {
    return this.manager.isCurrentRecorder(this);
  }
  
  public void destroy()
  {
    this.stateHandler.sendEmptyMessage(3);
  }
  
  public DJIVideoDecoder getCurrentDecoder()
  {
    return this.currentDecoder;
  }
  
  public RecorderStatus getCurrentStatus()
  {
    return this.currentStatus;
  }
  
  public String getFileName()
  {
    return this.mainFileName;
  }
  
  public int getNumFrameWritten()
  {
    return this.numFrameWritten;
  }
  
  protected int[] getRecordWidthHeight()
  {
    return null;
  }
  
  public String getRecordingFileName()
  {
    return null;
  }
  
  protected String getRecordingFilePath()
  {
    return null;
  }
  
  protected abstract String getTAG();
  
  /* Error */
  protected void initExternalSdRecordingHelper()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isRecordingToExternalSd()
  {
    return this.externalSdRecordingHelper != null;
  }
  
  /* Error */
  protected void logDataInput(String arg1, int arg2, LogDataMode arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void onEndRecord();
  
  protected abstract void onStartRecord();
  
  public void setFileName(String paramString)
  {
    this.mainFileName = paramString;
  }
  
  protected void setNewStatus(RecorderStatus paramRecorderStatus)
  {
    if (this.currentStatus != paramRecorderStatus) {
      this.currentStatus = paramRecorderStatus;
    }
  }
  
  void startRecord()
  {
    this.stateHandler.sendEmptyMessage(0);
  }
  
  /* Error */
  protected void stopExternalSdRecordingHelper()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  void stopRecord()
  {
    this.stateHandler.sendEmptyMessage(1);
  }
  
  public static class EventVideoCacheCompletion
  {
    private final String filePath;
    
    public EventVideoCacheCompletion(String paramString)
    {
      this.filePath = paramString;
    }
    
    public String getFilePath()
    {
      return this.filePath;
    }
  }
  
  public static enum LogDataMode
  {
    static
    {
      LogDataMode localLogDataMode = new LogDataMode("Audio", 1);
      Audio = localLogDataMode;
      $VALUES = new LogDataMode[] { Video, localLogDataMode };
    }
    
    private LogDataMode() {}
  }
  
  public static enum RecorderStatus
  {
    static
    {
      RecorderStatus localRecorderStatus = new RecorderStatus("Recording", 1);
      Recording = localRecorderStatus;
      $VALUES = new RecorderStatus[] { Standby, localRecorderStatus };
    }
    
    private RecorderStatus() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\recorder\RecorderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */