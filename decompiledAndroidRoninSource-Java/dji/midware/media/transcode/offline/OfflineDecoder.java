package dji.midware.media.transcode.offline;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import dji.midware.media.record.H264FrameListener;
import java.nio.ByteBuffer;

public class OfflineDecoder
  implements H264FrameListener
{
  private static String TAG = "OfflineDecoder";
  private int colorFormat;
  public MediaCodec decoder;
  private ByteBuffer decoderOutputBuffer;
  private MediaCodec.BufferInfo decoderOutputBufferInfo = new MediaCodec.BufferInfo();
  private EncoderMuxer encoderMuxer;
  boolean hasConfigEncoder = false;
  int height;
  private boolean isContinue = true;
  MediaFormat mediaFormatDe;
  DecoderOutputMonitor outputMonitor = null;
  int sample_flag;
  int sample_index;
  int sample_time;
  int width;
  
  /* Error */
  private void initDecoder()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void onDecoderInput(byte[] arg1, int arg2)
  {
    // Byte code:
    //   0: goto +6 -> 6
    //   3: return
    //   4: astore_1
    //   5: return
    //   6: goto -3 -> 3
  }
  
  /* Error */
  private void onDecoderOutput()
    throws java.lang.Exception
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void onH264FrameInput(byte[] paramArrayOfByte, int paramInt, long paramLong, boolean paramBoolean)
  {
    onDecoderInput(paramArrayOfByte, paramInt);
  }
  
  public void setVideoDataListener(EncoderMuxer paramEncoderMuxer)
  {
    this.encoderMuxer = paramEncoderMuxer;
  }
  
  /* Error */
  public void start(MediaCodec arg1, int arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stopAndReleaseDecoder()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean stopOutputMonitor()
  {
    return false;
  }
  
  protected class DecoderOutputMonitor
    extends Thread
  {
    protected DecoderOutputMonitor() {}
    
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\transcode\offline\OfflineDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */