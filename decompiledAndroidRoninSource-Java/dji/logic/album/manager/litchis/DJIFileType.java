package dji.logic.album.manager.litchis;

public enum DJIFileType
{
  private int data;
  
  static
  {
    DNG = new DJIFileType("DNG", 1, 1);
    MOV = new DJIFileType("MOV", 2, 2);
    MP4 = new DJIFileType("MP4", 3, 3);
    PANO = new DJIFileType("PANO", 4, 4);
    TIF = new DJIFileType("TIF", 5, 5);
    BOKEH = new DJIFileType("BOKEH", 6, 6);
    PANORAMA = new DJIFileType("PANORAMA", 7, 7);
    DJIFileType localDJIFileType = new DJIFileType("UNDEFINED", 8, 100);
    UNDEFINED = localDJIFileType;
    $VALUES = new DJIFileType[] { JPG, DNG, MOV, MP4, PANO, TIF, BOKEH, PANORAMA, localDJIFileType };
  }
  
  private DJIFileType(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static DJIFileType find(int paramInt)
  {
    DJIFileType localDJIFileType = UNDEFINED;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localDJIFileType;
  }
  
  public static DJIFileType find(String paramString)
  {
    DJIFileType localDJIFileType = UNDEFINED;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i].toString().equals(paramString)) {
        return values()[i];
      }
      i += 1;
    }
    return localDJIFileType;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public boolean canDownload()
  {
    return (this != DNG) && (this != BOKEH) && (this != PANO);
  }
  
  public boolean isVideo()
  {
    return (this == MOV) || (this == MP4);
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\litchis\DJIFileType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */