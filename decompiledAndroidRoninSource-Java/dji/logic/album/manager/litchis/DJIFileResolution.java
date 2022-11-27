package dji.logic.album.manager.litchis;

public enum DJIFileResolution
{
  private int data;
  private int height;
  private int relValue;
  private int width;
  
  static
  {
    Size_1280_640p = new DJIFileResolution("Size_1280_640p", 1, 2, 1280, 640);
    Size_1280_720p = new DJIFileResolution("Size_1280_720p", 2, 4, 1280, 720);
    Size_1280_960p = new DJIFileResolution("Size_1280_960p", 3, 6, 1280, 960);
    Size_1920_960p = new DJIFileResolution("Size_1920_960p", 4, 8, 1920, 960);
    Size_1920_1080p = new DJIFileResolution("Size_1920_1080p", 5, 10, 1920, 1080);
    Size_1920_1440p = new DJIFileResolution("Size_1920_1440p", 6, 12, 1920, 1440);
    Size_3840_1920p = new DJIFileResolution("Size_3840_1920p", 7, 14, 3840, 1920);
    Size_3840_2160p = new DJIFileResolution("Size_3840_2160p", 8, 16, 3840, 2160);
    Size_3840_2880p = new DJIFileResolution("Size_3840_2880p", 9, 18, 3840, 2880);
    Size_4096_2048p = new DJIFileResolution("Size_4096_2048p", 10, 20, 4096, 2048);
    Size_4096_2160p = new DJIFileResolution("Size_4096_2160p", 11, 22, 4096, 2160);
    Size_2704_1520p = new DJIFileResolution("Size_2704_1520p", 12, 24, 2704, 1520);
    Size_640_512p = new DJIFileResolution("Size_640_512p", 13, 26, 640, 512);
    Size_4608_2160p = new DJIFileResolution("Size_4608_2160p", 14, 27, 4608, 2160);
    Size_4608_2592p = new DJIFileResolution("Size_4608_2592p", 15, 28, 4608, 2592);
    Size_848_480p = new DJIFileResolution("Size_848_480p", 16, 29, 848, 480);
    Size_2720_1530p = new DJIFileResolution("Size_2720_1530p", 17, 31, 2720, 1530);
    Size_5280_2160p = new DJIFileResolution("Size_5280_2160p", 18, 32, 5280, 2160);
    Size_5280_2970p = new DJIFileResolution("Size_5280_2970p", 19, 33, 5280, 2970);
    Size_640_480i = new DJIFileResolution("Size_640_480i", 20, 1, 640, 480);
    Size_1280_640i = new DJIFileResolution("Size_1280_640i", 21, 3, 1280, 640);
    Size_1280_720i = new DJIFileResolution("Size_1280_720i", 22, 5, 1280, 720);
    Size_1280_960i = new DJIFileResolution("Size_1280_960i", 23, 7, 1280, 960);
    Size_1920_960i = new DJIFileResolution("Size_1920_960i", 24, 9, 1920, 960);
    Size_1920_1080i = new DJIFileResolution("Size_1920_1080i", 25, 11, 1920, 1080);
    Size_1920_1440i = new DJIFileResolution("Size_1920_1440i", 26, 13, 1920, 1440);
    Size_3840_1920i = new DJIFileResolution("Size_3840_1920i", 27, 15, 3840, 1920);
    Size_3840_2160i = new DJIFileResolution("Size_3840_2160i", 28, 17, 3840, 2160);
    Size_3840_2880i = new DJIFileResolution("Size_3840_2880i", 29, 19, 3840, 2880);
    Size_4096_2048i = new DJIFileResolution("Size_4096_2048i", 30, 21, 4096, 2048);
    Size_4096_2160i = new DJIFileResolution("Size_4096_2160i", 31, 23, 4096, 2160);
    Size_2704_1520i = new DJIFileResolution("Size_2704_1520i", 32, 25, 2704, 1520);
    Size_848_480i = new DJIFileResolution("Size_848_480i", 33, 30, 848, 480);
    R_2720x1530p = new DJIFileResolution("R_2720x1530p", 34, 31, 2720, 1530);
    R_5280x2160p = new DJIFileResolution("R_5280x2160p", 35, 32, 5280, 2160);
    R_5280x2970p = new DJIFileResolution("R_5280x2970p", 36, 33, 5280, 2972);
    R_3840x1572p = new DJIFileResolution("R_3840x1572p", 37, 34, 3840, 1572);
    R_MAX = new DJIFileResolution("R_MAX", 38, 253, 5280, 2972);
    UNDEFINED = new DJIFileResolution("UNDEFINED", 39, 100);
    UNSET = new DJIFileResolution("UNSET", 40, 254);
    DJIFileResolution localDJIFileResolution = new DJIFileResolution("UNKNOWN", 41, 255);
    UNKNOWN = localDJIFileResolution;
    $VALUES = new DJIFileResolution[] { Size_640_480p, Size_1280_640p, Size_1280_720p, Size_1280_960p, Size_1920_960p, Size_1920_1080p, Size_1920_1440p, Size_3840_1920p, Size_3840_2160p, Size_3840_2880p, Size_4096_2048p, Size_4096_2160p, Size_2704_1520p, Size_640_512p, Size_4608_2160p, Size_4608_2592p, Size_848_480p, Size_2720_1530p, Size_5280_2160p, Size_5280_2970p, Size_640_480i, Size_1280_640i, Size_1280_720i, Size_1280_960i, Size_1920_960i, Size_1920_1080i, Size_1920_1440i, Size_3840_1920i, Size_3840_2160i, Size_3840_2880i, Size_4096_2048i, Size_4096_2160i, Size_2704_1520i, Size_848_480i, R_2720x1530p, R_5280x2160p, R_5280x2970p, R_3840x1572p, R_MAX, UNDEFINED, UNSET, localDJIFileResolution };
  }
  
  private DJIFileResolution(int paramInt)
  {
    this.data = paramInt;
  }
  
  private DJIFileResolution(int paramInt1, int paramInt2, int paramInt3)
  {
    this.data = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
  }
  
  public static DJIFileResolution find(int paramInt)
  {
    DJIFileResolution localDJIFileResolution2 = UNDEFINED;
    int i = 0;
    DJIFileResolution localDJIFileResolution1;
    for (;;)
    {
      localDJIFileResolution1 = localDJIFileResolution2;
      if (i >= values().length) {
        break;
      }
      if (values()[i]._equals(paramInt))
      {
        localDJIFileResolution1 = values()[i];
        break;
      }
      i += 1;
    }
    localDJIFileResolution1.setRelValue(paramInt);
    return localDJIFileResolution1;
  }
  
  public static DJIFileResolution find(String paramString)
  {
    DJIFileResolution localDJIFileResolution = UNDEFINED;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i].toString().equals(paramString)) {
        return values()[i];
      }
      i += 1;
    }
    return localDJIFileResolution;
  }
  
  private void setRelValue(int paramInt)
  {
    this.relValue = paramInt;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public boolean is4K()
  {
    return this.data > 13;
  }
  
  public int relValue()
  {
    return this.relValue;
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\litchis\DJIFileResolution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */