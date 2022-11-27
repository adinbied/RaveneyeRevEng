package dji.midware.media.muxer;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract interface DJIMuxerInterface
{
  public abstract int addTrack(MediaFormat paramMediaFormat);
  
  public abstract int getNumTrack();
  
  public abstract void init(String paramString)
    throws IOException;
  
  public abstract void release();
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, long paramLong);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\muxer\DJIMuxerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */