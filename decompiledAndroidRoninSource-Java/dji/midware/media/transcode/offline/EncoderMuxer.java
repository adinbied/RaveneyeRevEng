package dji.midware.media.transcode.offline;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import dji.log.RoninLog;
import dji.midware.media.colors.ColorFormatConv;
import dji.midware.media.muxer.DJIMuxerInterface;

public class EncoderMuxer
{
  private String TAG = "EncoderMuxer";
  private int colorFormat;
  private ColorFormatConv conv = null;
  private MediaCodec encoder = null;
  MediaCodec.BufferInfo encoderOutputBufferInfo = new MediaCodec.BufferInfo();
  EncoderOutputMonitor encoderOutputMonitor = null;
  private int height;
  private boolean isContinue = true;
  private DJIMuxerInterface muxer = null;
  int numFrameJumped = 0;
  int numFrameMuxerReceived = 0;
  int num_track_in_muxer = 0;
  private String outputFullFileName;
  int sample_flag;
  int sample_index;
  int sample_time;
  private int width;
  byte[] yuv_source;
  byte[] yuv_target;
  
  /* Error */
  private void initVideoMuxer()
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void onEncoderOutput()
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void initVideoEncoder(android.media.MediaFormat arg1)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onEncoderInput(java.nio.ByteBuffer arg1, MediaCodec.BufferInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setColorFormatConv(ColorFormatConv paramColorFormatConv)
  {
    this.conv = paramColorFormatConv;
  }
  
  public void setFrameJumped(int paramInt)
  {
    this.numFrameJumped = paramInt;
  }
  
  public void setOutputFileName(String paramString)
  {
    this.outputFullFileName = paramString;
  }
  
  public void start(MediaCodec paramMediaCodec, int paramInt1, int paramInt2, int paramInt3)
  {
    this.encoder = paramMediaCodec;
    this.colorFormat = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.sample_index = 0;
    RoninLog.i(this.TAG, "complete execution of start()", new Object[0]);
  }
  
  /* Error */
  public void stopAndReleaseEncoderMuxer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean stopOutputMonitor()
  {
    return false;
  }
  
  protected class EncoderOutputMonitor
    extends Thread
  {
    protected EncoderOutputMonitor() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\transcode\offline\EncoderMuxer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */