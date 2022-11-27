package dji.common;

public enum VideoDataChannel
{
  private int value;
  
  static
  {
    HDMI = new VideoDataChannel("HDMI", 2, 2);
    AV = new VideoDataChannel("AV", 3, 3);
    VideoDataChannel localVideoDataChannel = new VideoDataChannel("UNKNOWN", 4, 255);
    UNKNOWN = localVideoDataChannel;
    $VALUES = new VideoDataChannel[] { FPV_CAMERA, HD_GIMBAL, HDMI, AV, localVideoDataChannel };
  }
  
  private VideoDataChannel(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static VideoDataChannel find(int paramInt)
  {
    VideoDataChannel localVideoDataChannel = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localVideoDataChannel;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\VideoDataChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */