package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.model.common.CameraShutterSpeed;

public class DataThirdPartyCameraGetPushLensInfo
  extends DataBase
{
  private static DataThirdPartyCameraGetPushLensInfo instance;
  
  public static DataThirdPartyCameraGetPushLensInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataThirdPartyCameraGetPushLensInfo();
      }
      DataThirdPartyCameraGetPushLensInfo localDataThirdPartyCameraGetPushLensInfo = instance;
      return localDataThirdPartyCameraGetPushLensInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getCurFofus()
  {
    return 0;
  }
  
  public int getMaxAperture()
  {
    return 0;
  }
  
  public int getMaxFocusRange()
  {
    return 0;
  }
  
  public CameraShutterSpeed getMaxShutterSpeed()
  {
    return null;
  }
  
  public int getMinAperture()
  {
    return 0;
  }
  
  public int getMinFocusRange()
  {
    return 0;
  }
  
  public CameraShutterSpeed getMinShutterSpeed()
  {
    return null;
  }
  
  public ThirdPartyCameraLensType getType()
  {
    return null;
  }
  
  public static enum ThirdPartyCameraLensType
  {
    private int data;
    private boolean isNewLens;
    
    static
    {
      HASSEL_28MM_F4 = new ThirdPartyCameraLensType("HASSEL_28MM_F4", 1, 257, false);
      HASSEL_35MM_F3p5 = new ThirdPartyCameraLensType("HASSEL_35MM_F3p5", 2, 258, false);
      HASSEL_50MM_F3p5 = new ThirdPartyCameraLensType("HASSEL_50MM_F3p5", 3, 259, false);
      HASSEL_28MM_F4_new = new ThirdPartyCameraLensType("HASSEL_28MM_F4_new", 4, 260, true);
      HASSEL_35MM_F3p5_new = new ThirdPartyCameraLensType("HASSEL_35MM_F3p5_new", 5, 261, true);
      ThirdPartyCameraLensType localThirdPartyCameraLensType = new ThirdPartyCameraLensType("HASSEL_50MM_F3p5_new", 6, 262, true);
      HASSEL_50MM_F3p5_new = localThirdPartyCameraLensType;
      $VALUES = new ThirdPartyCameraLensType[] { UNKNOWN, HASSEL_28MM_F4, HASSEL_35MM_F3p5, HASSEL_50MM_F3p5, HASSEL_28MM_F4_new, HASSEL_35MM_F3p5_new, localThirdPartyCameraLensType };
    }
    
    private ThirdPartyCameraLensType(int paramInt, boolean paramBoolean)
    {
      this.data = paramInt;
      this.isNewLens = paramBoolean;
    }
    
    public static ThirdPartyCameraLensType find(int paramInt)
    {
      ThirdPartyCameraLensType localThirdPartyCameraLensType = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localThirdPartyCameraLensType;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public boolean is28mm()
    {
      int i = DataThirdPartyCameraGetPushLensInfo.1.$SwitchMap$dji$midware$data$model$P3$DataThirdPartyCameraGetPushLensInfo$ThirdPartyCameraLensType[ordinal()];
      return (i == 1) || (i == 2);
    }
    
    public boolean isNewLens()
    {
      return this.isNewLens;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataThirdPartyCameraGetPushLensInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */