package dji.midware.media.muxer;

import android.media.MediaFormat;
import dji.midware.media.datacontainer.DynamicByteBuffer;

public class FFMpegMuxer
  implements DJIMuxerInterface
{
  private static boolean DEBUG = true;
  private static String TAG = "FFMpegMuxer";
  AudioTrackFormat aTrack = null;
  private int curTrackNum = 0;
  private String filePath;
  private DynamicByteBuffer jniBuffer = new DynamicByteBuffer(138240, true);
  private Status status = Status.StandBy;
  VideoTrackFormat vTrack = null;
  
  public int addTrack(MediaFormat paramMediaFormat)
  {
    return 0;
  }
  
  public int getNumTrack()
  {
    return this.curTrackNum;
  }
  
  /* Error */
  public void init(String arg1)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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
  
  /* Error */
  public void writeSampleData(int arg1, java.nio.ByteBuffer arg2, android.media.MediaCodec.BufferInfo arg3, long arg4)
  {
    // Byte code:
    //   0: goto +6 -> 6
    //   3: return
    //   4: astore_2
    //   5: return
    //   6: goto -3 -> 3
  }
  
  static class AudioTrackFormat
  {
    int bitRate;
    int channels;
    byte[] csd;
    int csdSize;
    long durationUs;
    int sampleRate;
    int trackIndex;
  }
  
  private static enum Status
  {
    static
    {
      Initialized = new Status("Initialized", 1);
      TrackAdded = new Status("TrackAdded", 2);
      Muxing = new Status("Muxing", 3);
      Status localStatus = new Status("Stopped", 4);
      Stopped = localStatus;
      $VALUES = new Status[] { StandBy, Initialized, TrackAdded, Muxing, localStatus };
    }
    
    private Status() {}
  }
  
  static class VideoTrackFormat
  {
    long durationUs;
    int height;
    int sizeSpspps;
    byte[] spspps;
    int trackIndex;
    int width;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\muxer\FFMpegMuxer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */