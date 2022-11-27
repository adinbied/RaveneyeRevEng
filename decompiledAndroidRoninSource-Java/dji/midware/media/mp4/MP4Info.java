package dji.midware.media.mp4;

public class MP4Info
{
  private static final String TAG = MP4Info.class.getName();
  private final int SAMPLE_DELTA = 1000;
  public int[] chunk_offset;
  public int create_time;
  public int duration;
  public int duration_time;
  public int fps;
  public int height;
  public int media_length;
  public int modification_time;
  public int[] pos_iframe;
  public byte[] pps;
  public int[] sample_size;
  public byte[] sps;
  public int time_scale;
  public int width;
  
  public MP4Info(MP4MovieBox paramMP4MovieBox)
  {
    this.height = paramMP4MovieBox.trak.tkhd.height;
    this.width = paramMP4MovieBox.trak.tkhd.width;
    this.time_scale = paramMP4MovieBox.mvhd.time_scale;
    this.duration = paramMP4MovieBox.mvhd.duration;
    this.create_time = paramMP4MovieBox.mvhd.create_time;
    this.modification_time = paramMP4MovieBox.mvhd.modification_time;
    this.sample_size = paramMP4MovieBox.trak.mdia.minf.stbl.stsz.sample_size_list;
    this.chunk_offset = paramMP4MovieBox.trak.mdia.minf.stbl.stco.chunk_offset_list;
    this.pps = paramMP4MovieBox.trak.mdia.minf.stbl.stsd.avc1.avcC.pps;
    this.sps = paramMP4MovieBox.trak.mdia.minf.stbl.stsd.avc1.avcC.sps;
    this.pos_iframe = paramMP4MovieBox.trak.mdia.minf.stbl.stss.iframe_sample_number;
    int i = this.duration;
    int j = this.time_scale;
    this.duration_time = (i / j);
    this.fps = (j / 1000);
    this.media_length = this.sample_size.length;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\mp4\MP4Info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */