package dji.midware.media.demuxer;

import android.media.MediaFormat;
import dji.midware.media.MediaLogger;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class FFMpegDemuxer
  extends DemuxerBase
  implements DemuxerInterface
{
  private static final boolean DEBUG = false;
  public static final String TAG = "FFMpegDemuxer";
  private int filter_in_size;
  private int filter_out_size;
  private Vector<MediaFormat> formats = new Vector();
  private ByteBuffer frameData;
  private int frameDataOffset;
  private long handle = 0L;
  private boolean hasAdvance = false;
  private boolean isEOS;
  int max_video_height = 0;
  int max_video_width = 0;
  private ByteBuffer sBuffer = ByteBuffer.allocateDirect(2048);
  private int sampleFlags;
  private int sampleOffset;
  private int sampleSize;
  private long sampleTime;
  private int sampleTrackIndex;
  private int sei_start;
  private Set<Integer> selectedTracks = new HashSet();
  private int trackCount = -1;
  
  public FFMpegDemuxer()
  {
    MediaLogger.i("FFMpegDemuxer", "create a FFMpegDemuxer");
  }
  
  /* Error */
  private void checkError()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean advance()
  {
    return false;
  }
  
  public int getSampleFlags()
  {
    return 0;
  }
  
  public long getSampleTime()
  {
    return 277834606L;
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
  
  public boolean isEOSorError()
  {
    return this.isEOS;
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
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void seekTo(long arg1, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void selectTrack(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setDataSource(String arg1)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void unselectTrack(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\demuxer\FFMpegDemuxer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */