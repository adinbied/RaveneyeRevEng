package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraGetVideoParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraGetVideoParams instance;
  
  public static DataCameraGetVideoParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetVideoParams();
      }
      DataCameraGetVideoParams localDataCameraGetVideoParams = instance;
      return localDataCameraGetVideoParams;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getFileId()
  {
    return 0;
  }
  
  public int getFolderId()
  {
    return 0;
  }
  
  public int getFps()
  {
    return 0;
  }
  
  public int getRatio()
  {
    return 0;
  }
  
  public long getUuid()
  {
    return 277657468L;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum FPS_Drone
  {
    private int fps;
    private int type;
    
    static
    {
      FPS_Drone localFPS_Drone = new FPS_Drone("OTHER", 10, -1, 0);
      OTHER = localFPS_Drone;
      $VALUES = new FPS_Drone[] { FPS0, FPS1, FPS2, FPS3, FPS4, FPS5, FPS6, FPS7, FPS8, FPS9, localFPS_Drone };
    }
    
    private FPS_Drone(int paramInt1, int paramInt2)
    {
      this.type = paramInt1;
      this.fps = paramInt2;
    }
    
    public static FPS_Drone find(int paramInt)
    {
      FPS_Drone localFPS_Drone = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFPS_Drone;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.type == paramInt;
    }
    
    public int fps()
    {
      return this.fps;
    }
    
    public int type()
    {
      return this.type;
    }
  }
  
  public static enum Resolution_Drone
  {
    private int height;
    private String suffix;
    private int type;
    private int width;
    
    static
    {
      R10 = new Resolution_Drone("R10", 10, 10, 1920, 1080, "p");
      R11 = new Resolution_Drone("R11", 11, 11, 1920, 1080, "i");
      R12 = new Resolution_Drone("R12", 12, 12, 1920, 1440, "p");
      R13 = new Resolution_Drone("R13", 13, 13, 1920, 1440, "i");
      R14 = new Resolution_Drone("R14", 14, 14, 3840, 1920, "p");
      R15 = new Resolution_Drone("R15", 15, 15, 3840, 1920, "i");
      R16 = new Resolution_Drone("R16", 16, 16, 3840, 2160, "p");
      R17 = new Resolution_Drone("R17", 17, 17, 3840, 2160, "i");
      R18 = new Resolution_Drone("R18", 18, 18, 3840, 2880, "p");
      R19 = new Resolution_Drone("R19", 19, 19, 3840, 2880, "i");
      R20 = new Resolution_Drone("R20", 20, 20, 4096, 2048, "p");
      R21 = new Resolution_Drone("R21", 21, 21, 4096, 2048, "i");
      R22 = new Resolution_Drone("R22", 22, 22, 4096, 2160, "p");
      R23 = new Resolution_Drone("R23", 23, 23, 4096, 2160, "i");
      Resolution_Drone localResolution_Drone = new Resolution_Drone("OTHER", 24, -1, 0, 0, "-");
      OTHER = localResolution_Drone;
      $VALUES = new Resolution_Drone[] { R0, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22, R23, localResolution_Drone };
    }
    
    private Resolution_Drone(int paramInt1, int paramInt2, int paramInt3, String paramString)
    {
      this.type = paramInt1;
      this.width = paramInt2;
      this.height = paramInt3;
      this.suffix = paramString;
    }
    
    public static Resolution_Drone find(int paramInt)
    {
      Resolution_Drone localResolution_Drone = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localResolution_Drone;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.type == paramInt;
    }
    
    public int height()
    {
      return this.height;
    }
    
    public String suffix()
    {
      return this.suffix;
    }
    
    public int type()
    {
      return this.type;
    }
    
    public int width()
    {
      return this.width;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetVideoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */