package dji.midware.media.metadata;

import java.util.HashMap;

public class DJIFFmpegMediaRetriever
{
  private static final String KEY_DURATION = "duration";
  private static final String KEY_FRAMERATE = "framerate";
  private static final String KEY_HEIGHT = "height";
  private static final String KEY_ROTATION = "rotate";
  private static final String KEY_WIDTH = "width";
  private static final String TAG = "DJIFFmpegMediaRetriver";
  private HashMap<String, String> metaData = null;
  private String path;
  
  public int getDurationMs()
  {
    return 0;
  }
  
  public float getFrameRate()
  {
    return 0.0F;
  }
  
  /* Error */
  public void getMetaData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public float getRotation()
  {
    return 0.0F;
  }
  
  public int getVideoHeight()
  {
    return 0;
  }
  
  public int getVideoWidth()
  {
    return 0;
  }
  
  /* Error */
  public void setDataSource(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\metadata\DJIFFmpegMediaRetriever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */