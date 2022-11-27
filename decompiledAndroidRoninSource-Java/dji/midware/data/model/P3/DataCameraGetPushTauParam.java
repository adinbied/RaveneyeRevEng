package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;

public class DataCameraGetPushTauParam
  extends DJICameraDataBase
{
  private static DataCameraGetPushTauParam instance;
  
  public static DataCameraGetPushTauParam getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushTauParam();
      }
      DataCameraGetPushTauParam localDataCameraGetPushTauParam = instance;
      return localDataCameraGetPushTauParam;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getACE(int... paramVarArgs)
  {
    return 0;
  }
  
  public DataCameraTauParamAGC.AGCType getAGC(int... paramVarArgs)
  {
    return null;
  }
  
  public float getAreaThermometricAverage()
  {
    return 0.0F;
  }
  
  public int getAreaThermometricBottom()
  {
    return 0;
  }
  
  public int getAreaThermometricLeft()
  {
    return 0;
  }
  
  public float getAreaThermometricMax()
  {
    return 0.0F;
  }
  
  public int getAreaThermometricMaxX()
  {
    return 0;
  }
  
  public int getAreaThermometricMaxY()
  {
    return 0;
  }
  
  public float getAreaThermometricMin()
  {
    return 0.0F;
  }
  
  public int getAreaThermometricMinX()
  {
    return 0;
  }
  
  public int getAreaThermometricMinY()
  {
    return 0;
  }
  
  public int getAreaThermometricRight()
  {
    return 0;
  }
  
  public int getAreaThermometricTop()
  {
    return 0;
  }
  
  public short getAtmosphereTemperature()
  {
    return 0;
  }
  
  public short getAtmosphereTransmission()
  {
    return 0;
  }
  
  public short getBackgroundTemperature()
  {
    return 0;
  }
  
  public int getBrightness(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getContrast(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getDDE()
  {
    return 0;
  }
  
  public int getDigitalFilter()
  {
    return 0;
  }
  
  public DataCameraTauExterParamType.ExterParamType getExterParamType()
  {
    return null;
  }
  
  public DataCameraTauFFCMode.FFCMode getFFCMode()
  {
    return null;
  }
  
  public DataCameraTauParamGainMode.GainMode getGainMode()
  {
    return null;
  }
  
  public int getImageFormat()
  {
    return 0;
  }
  
  public short getIsothermLower(int... paramVarArgs)
  {
    return 0;
  }
  
  public short getIsothermMiddle(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getIsothermUnit(int... paramVarArgs)
  {
    return 0;
  }
  
  public short getIsothermUpper(int... paramVarArgs)
  {
    return 0;
  }
  
  public LenFocusLength getLenFocusLength()
  {
    return null;
  }
  
  public LenFps getLenFps()
  {
    return null;
  }
  
  public int getObjectControl()
  {
    return 0;
  }
  
  public int getPhotoInterval(int... paramVarArgs)
  {
    return 0;
  }
  
  public DataCameraTauParamROI.ROIType getROIType()
  {
    return null;
  }
  
  public int getSSO(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getShotCountDown()
  {
    return 0;
  }
  
  public short getTargetEmissivity()
  {
    return 0;
  }
  
  public float getThermometricTemp()
  {
    return 0.0F;
  }
  
  public DataCameraTauParamThermometricEnable.ThermometricType getThermometricType(int... paramVarArgs)
  {
    return null;
  }
  
  public float getThermometricXAxis()
  {
    return 0.0F;
  }
  
  public float getThermometricYAxis()
  {
    return 0.0F;
  }
  
  public int getVideoFormat()
  {
    return 0;
  }
  
  public int getVideoFps()
  {
    return 0;
  }
  
  public VideoResolution getVideoResolution()
  {
    return null;
  }
  
  public short getWindowReflectedTemperature()
  {
    return 0;
  }
  
  public short getWindowReflection(int... paramVarArgs)
  {
    return 0;
  }
  
  public short getWindowTemperature()
  {
    return 0;
  }
  
  public short getWindowTransmission(int... paramVarArgs)
  {
    return 0;
  }
  
  public DataCameraSetFocusParam.ZoomMode getZoomMode()
  {
    return null;
  }
  
  public int getZoomScale()
  {
    return 0;
  }
  
  public boolean isIsothermEnable()
  {
    return false;
  }
  
  public boolean isThermometricEnable()
  {
    return false;
  }
  
  public boolean isThermometricValid(int... paramVarArgs)
  {
    return false;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    super.setPushRecData(paramArrayOfByte);
  }
  
  public boolean supportSpotThermometric(int... paramVarArgs)
  {
    return false;
  }
  
  public static enum LenFocusLength
  {
    private int data;
    
    static
    {
      LFL_130 = new LenFocusLength("LFL_130", 3, 3);
      LFL_190 = new LenFocusLength("LFL_190", 4, 4);
      LenFocusLength localLenFocusLength = new LenFocusLength("UNKNOWN", 5, 255);
      UNKNOWN = localLenFocusLength;
      $VALUES = new LenFocusLength[] { LFL_68, LFL_75, LFL_90, LFL_130, LFL_190, localLenFocusLength };
    }
    
    private LenFocusLength(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static LenFocusLength find(int paramInt)
    {
      LenFocusLength localLenFocusLength = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localLenFocusLength;
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
  
  public static enum LenFps
  {
    private int data;
    
    static
    {
      FPS_30 = new LenFps("FPS_30", 1, 4);
      LenFps localLenFps = new LenFps("UNKNOWN", 2, 255);
      UNKNOWN = localLenFps;
      $VALUES = new LenFps[] { FPS_LESS_9, FPS_30, localLenFps };
    }
    
    private LenFps(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static LenFps find(int paramInt)
    {
      LenFps localLenFps = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localLenFps;
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
  
  public static enum VideoResolution
  {
    private int data;
    
    static
    {
      VR_336 = new VideoResolution("VR_336", 1, 1);
      VideoResolution localVideoResolution = new VideoResolution("UNKNOWN", 2, 255);
      UNKNOWN = localVideoResolution;
      $VALUES = new VideoResolution[] { VR_640, VR_336, localVideoResolution };
    }
    
    private VideoResolution(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static VideoResolution find(int paramInt)
    {
      VideoResolution localVideoResolution = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localVideoResolution;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushTauParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */