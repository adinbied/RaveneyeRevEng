package com.dji.video.framing.internal.muxer;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;

public class AndroidMuxer
  implements DJIMuxerInterface
{
  private static final String TAG = "AndroidMuxer";
  private MediaMuxer muxer;
  private int numTrack = 0;
  
  public int addTrack(MediaFormat paramMediaFormat)
  {
    return 0;
  }
  
  public int getNumTrack()
  {
    return this.numTrack;
  }
  
  /* Error */
  public void init(String arg1)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void release()
  {
    this.muxer.release();
  }
  
  public void setOrientationHint(int paramInt)
  {
    this.muxer.setOrientationHint(paramInt);
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    try
    {
      this.muxer.writeSampleData(paramInt, paramByteBuffer, paramBufferInfo);
      return;
    }
    catch (IllegalStateException paramByteBuffer)
    {
      Log.e("AndroidMuxer", "writeSampleData: ", paramByteBuffer);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\muxer\AndroidMuxer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */