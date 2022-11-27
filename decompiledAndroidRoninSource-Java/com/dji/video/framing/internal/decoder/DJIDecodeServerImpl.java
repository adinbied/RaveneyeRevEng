package com.dji.video.framing.internal.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.Callback;
import android.media.MediaFormat;
import android.os.Looper;
import java.util.LinkedList;
import java.util.Queue;

public class DJIDecodeServerImpl
  extends AbsDjiDecodeServer
{
  private static final int DECODING_CHECK_INTERVAL = 500;
  private static final int MSG_CHECK_DECODING_RST = 1002;
  private static final int MSG_FRAME_IN = 1000;
  private static final int MSG_FRAME_OUTPUT = 1003;
  private static final int MSG_INPUT_BUFFER_AVAILABLE = 1001;
  private static final String TAG = "DJIDecodeServerImpl";
  private MediaCodec.Callback codecCallback = new MediaCodec.Callback()
  {
    /* Error */
    public void onError(MediaCodec arg1, android.media.MediaCodec.CodecException arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onInputBufferAvailable(MediaCodec arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onOutputBufferAvailable(MediaCodec arg1, int arg2, android.media.MediaCodec.BufferInfo arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onOutputFormatChanged(MediaCodec paramAnonymousMediaCodec, MediaFormat paramAnonymousMediaFormat)
    {
      DJIDecodeServerImpl.this.post(new Runnable()
      {
        public void run()
        {
          DJIDecodeServerImpl.this.onOutputFormatChanged();
        }
      });
    }
  };
  private Queue<Integer> inputIndexQueue = new LinkedList();
  
  public DJIDecodeServerImpl(Looper paramLooper, DJIVideoDecoder paramDJIVideoDecoder)
  {
    super(paramLooper, paramDJIVideoDecoder);
    sendEmptyMessageDelayed(1002, 2000L);
  }
  
  protected void handleInOutMsg() {}
  
  /* Error */
  public void handleMessage(android.os.Message arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected void initVideoDecoder()
  {
    initVideoDecoder(false, true);
  }
  
  protected void onCodecConfigured()
  {
    this.codec.setCallback(this.codecCallback);
  }
  
  protected void onCodecStarted() {}
  
  /* Error */
  protected void queueInframe(com.dji.video.framing.internal.VideoFrame arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void releaseDecoder()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\decoder\DJIDecodeServerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */