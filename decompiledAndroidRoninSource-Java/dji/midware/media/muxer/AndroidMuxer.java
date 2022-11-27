package dji.midware.media.muxer;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
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
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void stop()
  {
    this.muxer.stop();
  }
  
  public void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    this.muxer.writeSampleData(paramInt, paramByteBuffer, paramBufferInfo);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\muxer\AndroidMuxer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */