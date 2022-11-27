package dji.midware.media.demuxer;

import android.media.MediaFormat;

public abstract class DemuxerBase
{
  protected int audioTrack = -1;
  protected int videoTrack = -1;
  
  public int getAudioTrack()
  {
    return 0;
  }
  
  public abstract int getTrackCount();
  
  public abstract MediaFormat getTrackFormat(int paramInt);
  
  public int getTrackIndex(String paramString)
  {
    return 0;
  }
  
  public int getVideoTrack()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\demuxer\DemuxerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */