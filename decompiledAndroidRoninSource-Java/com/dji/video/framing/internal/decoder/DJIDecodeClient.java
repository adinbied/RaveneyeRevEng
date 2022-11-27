package com.dji.video.framing.internal.decoder;

import android.os.HandlerThread;
import com.dji.video.framing.internal.VideoFrame;

public class DJIDecodeClient
{
  private static final int FILE_LOG_ERROR_STATUS_INTERVAL = 5000;
  private static final int FILE_LOG_INTERVAL = 2000;
  private static final int MAX_PARSE_SEI_LENGTH = 64;
  private static final String TAG = "DJIDecodeClient";
  private long checkSum;
  private int frameHead;
  private int frameLen;
  private HandlerThread inoutThread;
  private int lastCheckIndex = -1;
  private long lastLogErrorStatusTime = 0L;
  private DJIVideoDecoder mDjiVideoDecoder;
  AbsDjiDecodeServer server;
  
  public DJIDecodeClient(DJIVideoDecoder paramDJIVideoDecoder)
  {
    this.mDjiVideoDecoder = paramDJIVideoDecoder;
  }
  
  private boolean checkFrame(VideoFrame paramVideoFrame, int paramInt)
  {
    return false;
  }
  
  /* Error */
  private void onSeiGet(VideoFrame arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private int parseHevcSei(VideoFrame paramVideoFrame, boolean paramBoolean, int paramInt)
  {
    return 0;
  }
  
  private int parseSei(VideoFrame paramVideoFrame, boolean paramBoolean, int paramInt)
  {
    return 0;
  }
  
  /* Error */
  void queueInFrame(VideoFrame arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void resetKeyFrame()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void startServer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void stopServer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\decoder\DJIDecodeClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */