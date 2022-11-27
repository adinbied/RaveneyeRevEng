package com.dji.video.framing.internal.decoder;

import android.os.Looper;
import com.dji.video.framing.internal.VideoFrame;
import java.nio.ByteBuffer;

public class DJIDecodeServerImplApi24
  extends AbsDjiDecodeServer
{
  private static final String TAG = "DJIDecodeServerImplApi24";
  private ByteBuffer[] inputBuffers;
  private String outIndexPrefix = "Decoder output outputBufferIndex = ";
  private StringBuffer outIndexSb = new StringBuffer("Decoder output outputBufferIndex = ");
  private ByteBuffer[] outputBuffers;
  
  public DJIDecodeServerImplApi24(Looper paramLooper, DJIVideoDecoder paramDJIVideoDecoder)
  {
    super(paramLooper, paramDJIVideoDecoder);
  }
  
  /* Error */
  private void onOutputBufferChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void handleInOutMsg()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected void onCodecConfigured() {}
  
  /* Error */
  protected void onCodecStarted()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onDecoderInput()
    throws java.lang.Exception
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void onDecoderOutput()
    throws java.lang.Exception
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void onDecoderOutput(int arg1, android.media.MediaCodec.BufferInfo arg2)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  protected void queueInframe(VideoFrame paramVideoFrame)
  {
    offerFrameToInputQueue(paramVideoFrame);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\decoder\DJIDecodeServerImplApi24.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */