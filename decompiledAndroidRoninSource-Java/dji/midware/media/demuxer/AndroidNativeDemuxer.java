package dji.midware.media.demuxer;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import dji.midware.media.MediaLogger;
import java.io.IOException;
import java.nio.ByteBuffer;

public class AndroidNativeDemuxer
  extends DemuxerBase
  implements DemuxerInterface
{
  private static String TAG = "AndroidNativeDemuxer";
  MediaExtractor etx = new MediaExtractor();
  
  public AndroidNativeDemuxer()
  {
    MediaLogger.i(TAG, "create a AndroidNativeDemuxer");
  }
  
  public boolean advance()
  {
    return this.etx.advance();
  }
  
  public int getSampleFlags()
  {
    return this.etx.getSampleFlags();
  }
  
  public long getSampleTime()
  {
    return this.etx.getSampleTime();
  }
  
  public int getSampleTrackIndex()
  {
    return this.etx.getSampleTrackIndex();
  }
  
  public int getTrackCount()
  {
    return this.etx.getTrackCount();
  }
  
  public MediaFormat getTrackFormat(int paramInt)
  {
    return this.etx.getTrackFormat(paramInt);
  }
  
  public int readSampleData(ByteBuffer paramByteBuffer, int paramInt)
  {
    return this.etx.readSampleData(paramByteBuffer, paramInt);
  }
  
  public void release()
  {
    this.etx.release();
  }
  
  public void seekTo(long paramLong, int paramInt)
  {
    this.etx.seekTo(paramLong, paramInt);
  }
  
  public void selectTrack(int paramInt)
  {
    this.etx.selectTrack(paramInt);
  }
  
  public void setDataSource(String paramString)
    throws IOException
  {
    this.etx.setDataSource(paramString);
  }
  
  public void unselectTrack(int paramInt)
  {
    this.etx.unselectTrack(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\demuxer\AndroidNativeDemuxer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */