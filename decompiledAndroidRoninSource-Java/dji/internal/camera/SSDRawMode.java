package dji.internal.camera;

public enum SSDRawMode
{
  private int data;
  
  static
  {
    DRAW = new SSDRawMode("DRAW", 1, 1);
    PRORES_HQ422 = new SSDRawMode("PRORES_HQ422", 2, 16);
    PRORES_HQ444 = new SSDRawMode("PRORES_HQ444", 3, 17);
    PRORSE_OFF = new SSDRawMode("PRORSE_OFF", 4, 32);
    SSDRawMode localSSDRawMode = new SSDRawMode("UNKNOW", 5, 255);
    UNKNOW = localSSDRawMode;
    $VALUES = new SSDRawMode[] { JPEG_LOSSLESS, DRAW, PRORES_HQ422, PRORES_HQ444, PRORSE_OFF, localSSDRawMode };
  }
  
  private SSDRawMode(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static SSDRawMode find(int paramInt)
  {
    SSDRawMode localSSDRawMode = PRORSE_OFF;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localSSDRawMode;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\camera\SSDRawMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */