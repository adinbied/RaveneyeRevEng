package com.dji.video.framing.internal.recorder;

import android.media.MediaRecorder;
import com.dji.video.framing.internal.decoder.DJIVideoDecoder;
import com.dji.video.framing.internal.decoder.decoderinterface.IVideoRecordDataListener;

public class RecorderMp4
  extends RecorderBase
  implements IVideoRecordDataListener
{
  private static final boolean DEBUG = false;
  public static String TAG = "RecorderMp4";
  private static MediaRecorder recorder;
  private long initial_original_pts = -1L;
  private long lastVideoPts = -1L;
  private boolean muxerInitialized = false;
  
  public RecorderMp4(RecorderManager paramRecorderManager, DJIVideoDecoder paramDJIVideoDecoder, String paramString)
  {
    super(paramRecorderManager, paramDJIVideoDecoder, paramString);
    paramRecorderManager = new StringBuilder();
    paramRecorderManager.append("create instance: ");
    paramRecorderManager.append(this);
    logToFile(paramRecorderManager.toString());
  }
  
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
  
  /* Error */
  protected void onEndRecord()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onStartRecord()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onVideoFrameInput(com.dji.video.framing.internal.VideoFrame arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\recorder\RecorderMp4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */