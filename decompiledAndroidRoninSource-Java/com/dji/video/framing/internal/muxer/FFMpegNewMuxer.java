package com.dji.video.framing.internal.muxer;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.Map;

public class FFMpegNewMuxer
  implements DJIMuxerInterface
{
  private static final int MUXER_STATE_INITIALIZED = 0;
  private static final int MUXER_STATE_STARTED = 1;
  private static final int MUXER_STATE_STOPPED = 2;
  private static final int MUXER_STATE_UNINITIALIZED = -1;
  private static final String TAG = "FFMpegNewMuxer";
  private Object addTrackLock = new Object();
  private Object directBufLock = new Object();
  private String[] mKeyArray = { "width", "height", "csd-0", "csd-1", "bitrate", "sample-rate", "channel-count", "mime" };
  private int mLastTrackIndex = -1;
  private long mNativeObject;
  private int mState = -1;
  private int orientationDegree = 0;
  private ByteBuffer temporaryDirectBuf;
  
  static
  {
    System.loadLibrary("video-framing");
  }
  
  private Map<String, Object> getFormatMap(MediaFormat paramMediaFormat)
  {
    return null;
  }
  
  private ByteBuffer getTemporaryDirectBuf(int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  public int addTrack(MediaFormat paramMediaFormat)
  {
    return 0;
  }
  
  public int getNumTrack()
  {
    return 0;
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
  
  public native int native_add_track(long paramLong, String[] paramArrayOfString, Object[] paramArrayOfObject);
  
  public native long native_init(String paramString);
  
  public native int native_release(long paramLong);
  
  public native int native_set_location(long paramLong, int paramInt1, int paramInt2);
  
  public native int native_set_orientation_hint(long paramLong, int paramInt);
  
  public native int native_start(long paramLong);
  
  public native int native_stop(long paramLong);
  
  public native int native_write_sample_data(long paramLong1, int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3, long paramLong2, int paramInt4);
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setOrientationHint(int paramInt)
  {
    this.orientationDegree = paramInt;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void writeSampleData(int arg1, ByteBuffer arg2, android.media.MediaCodec.BufferInfo arg3, long arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\muxer\FFMpegNewMuxer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */