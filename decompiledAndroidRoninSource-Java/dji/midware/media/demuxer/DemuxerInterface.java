package dji.midware.media.demuxer;

import android.media.MediaFormat;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract interface DemuxerInterface
{
  public abstract boolean advance();
  
  public abstract int getAudioTrack();
  
  public abstract int getSampleFlags();
  
  public abstract long getSampleTime();
  
  public abstract int getSampleTrackIndex();
  
  public abstract int getTrackCount();
  
  public abstract MediaFormat getTrackFormat(int paramInt);
  
  public abstract int getVideoTrack();
  
  public abstract int readSampleData(ByteBuffer paramByteBuffer, int paramInt);
  
  public abstract void release();
  
  public abstract void seekTo(long paramLong, int paramInt);
  
  public abstract void selectTrack(int paramInt);
  
  public abstract void setDataSource(String paramString)
    throws IOException;
  
  public abstract void unselectTrack(int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\demuxer\DemuxerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */