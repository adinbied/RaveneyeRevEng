package dji.midware.media.muxer;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import dji.midware.media.MediaLogger;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class EmptyMuxer
  implements DJIMuxerInterface
{
  private static final int FlushDuration = 15;
  private static final String TAG = "EmptyMuxer";
  private BufferedOutputStream h264BufferedOutputStream = null;
  private OutputStream h264OutputStream = null;
  private int numFrameWritten;
  
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
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void release() {}
  
  public void start() {}
  
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
      this.h264BufferedOutputStream.write(paramByteBuffer.array(), paramBufferInfo.offset, paramBufferInfo.size);
      paramInt = this.numFrameWritten + 1;
      this.numFrameWritten = paramInt;
      if (paramInt % 15 == 0)
      {
        this.h264BufferedOutputStream.flush();
        return;
      }
    }
    catch (IOException paramByteBuffer)
    {
      MediaLogger.e("EmptyMuxer", paramByteBuffer);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\muxer\EmptyMuxer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */