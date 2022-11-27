package dji.common.airlink;

public enum ChannelSelectionMode
{
  private int value;
  
  static
  {
    ChannelSelectionMode localChannelSelectionMode = new ChannelSelectionMode("UNKNOWN", 2, 255);
    UNKNOWN = localChannelSelectionMode;
    $VALUES = new ChannelSelectionMode[] { AUTO, MANUAL, localChannelSelectionMode };
  }
  
  private ChannelSelectionMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static ChannelSelectionMode find(int paramInt)
  {
    ChannelSelectionMode localChannelSelectionMode = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localChannelSelectionMode;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\ChannelSelectionMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */