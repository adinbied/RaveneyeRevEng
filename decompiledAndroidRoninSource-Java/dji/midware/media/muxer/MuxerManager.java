package dji.midware.media.muxer;

import android.os.Build.VERSION;
import dji.midware.media.MediaLogger;

public class MuxerManager
{
  public static DJIMuxerInterface createMuxer()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return createMuxer(MuxerType.NATIVE);
    }
    return createMuxer(MuxerType.FFMPEG);
  }
  
  public static DJIMuxerInterface createMuxer(MuxerType paramMuxerType)
  {
    if (1.$SwitchMap$dji$midware$media$muxer$MuxerManager$MuxerType[paramMuxerType.ordinal()] != 1)
    {
      paramMuxerType = new FFMpegMuxer();
      MediaLogger.show("Using FFMpeg-based Mp4 muxer");
      return paramMuxerType;
    }
    paramMuxerType = new AndroidMuxer();
    MediaLogger.show("Using Android native Mp4 muxer");
    return paramMuxerType;
  }
  
  public static enum MuxerType
  {
    static
    {
      MuxerType localMuxerType = new MuxerType("FFMPEG", 1);
      FFMPEG = localMuxerType;
      $VALUES = new MuxerType[] { NATIVE, localMuxerType };
    }
    
    private MuxerType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\muxer\MuxerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */