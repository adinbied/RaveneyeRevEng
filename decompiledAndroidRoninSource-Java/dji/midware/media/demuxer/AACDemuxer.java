package dji.midware.media.demuxer;

import android.media.MediaFormat;
import java.io.BufferedInputStream;
import java.nio.ByteBuffer;

public class AACDemuxer
  implements DemuxerInterface
{
  private static boolean DEBUG = false;
  private static final String TAG = "AACDemuxer";
  private byte[] buffer = new byte[102400];
  private boolean eos = false;
  private BufferedInputStream file = null;
  private int frameIndex = 0;
  private int frameSize = 0;
  
  public boolean advance()
  {
    return false;
  }
  
  public int getAudioTrack()
  {
    return 0;
  }
  
  public int getSampleFlags()
  {
    return 0;
  }
  
  public long getSampleTime()
  {
    return 0L;
  }
  
  public int getSampleTrackIndex()
  {
    return 0;
  }
  
  public int getTrackCount()
  {
    return 0;
  }
  
  public MediaFormat getTrackFormat(int paramInt)
  {
    return null;
  }
  
  public int getVideoTrack()
  {
    return 0;
  }
  
  public int readSampleData(ByteBuffer paramByteBuffer, int paramInt)
  {
    return 0;
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void seekTo(long paramLong, int paramInt) {}
  
  public void selectTrack(int paramInt) {}
  
  /* Error */
  public void setDataSource(String arg1)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void unselectTrack(int paramInt) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\demuxer\AACDemuxer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */