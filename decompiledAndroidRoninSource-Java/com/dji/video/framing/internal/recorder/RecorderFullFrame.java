package com.dji.video.framing.internal.recorder;

import android.media.MediaCodec.BufferInfo;
import com.dji.video.framing.internal.decoder.DJIVideoDecoder;
import com.dji.video.framing.internal.encoder.FullFrameHardwareTranscoder.FullFrameTranscoderListener;

public class RecorderFullFrame
  extends RecorderBase
  implements FullFrameHardwareTranscoder.FullFrameTranscoderListener
{
  private static final boolean DEBUG = false;
  public static String TAG = "RecorderFullFrame";
  private static RecorderFullFrame instance;
  private long initialOriginalTime = -1L;
  private long initial_original_pts = -1L;
  private long lastInputTime = -1L;
  private long last_original_pts = -1L;
  private long last_written_pts = -1L;
  private boolean muxerInitialized = false;
  
  public RecorderFullFrame(RecorderManager paramRecorderManager, DJIVideoDecoder paramDJIVideoDecoder, String paramString)
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
  
  protected int[] getRecordWidthHeight()
  {
    return null;
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
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\recorder\RecorderFullFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */