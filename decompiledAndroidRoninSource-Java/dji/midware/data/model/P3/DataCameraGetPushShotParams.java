package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;

public class DataCameraGetPushShotParams
  extends DJICameraDataBase
{
  private static DataCameraGetPushShotParams instance;
  
  public static DataCameraGetPushShotParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushShotParams();
      }
      DataCameraGetPushShotParams localDataCameraGetPushShotParams = instance;
      return localDataCameraGetPushShotParams;
    }
    finally {}
  }
  
  public boolean autoAEUnlock()
  {
    return false;
  }
  
  public boolean autoTurnOffForeLed()
  {
    return false;
  }
  
  protected void doPack() {}
  
  public int getAEBNumber()
  {
    return 0;
  }
  
  public int getAntiFlicker()
  {
    return 0;
  }
  
  public int getApertureSize()
  {
    return 0;
  }
  
  public int getCapMaxAperture()
  {
    return 0;
  }
  
  public int getCapMaxShutter()
  {
    return 0;
  }
  
  public int getCapMaxShutterDecimal()
  {
    return 0;
  }
  
  public String getCapMaxShutterStr()
  {
    return null;
  }
  
  public int getCapMinAperture()
  {
    return 0;
  }
  
  public int getCapMinShutter()
  {
    return 0;
  }
  
  public int getCapMinShutterDecimal()
  {
    return 0;
  }
  
  public String getCapMinShutterStr()
  {
    return null;
  }
  
  public int getColorTemp()
  {
    return 0;
  }
  
  public int getConstrastEhance()
  {
    return 0;
  }
  
  public int getContinuous()
  {
    return 0;
  }
  
  public int getContrast()
  {
    return 0;
  }
  
  public int getCtrObjectForOne()
  {
    return 0;
  }
  
  public int getCtrObjectForTwo()
  {
    return 0;
  }
  
  public int getDigitalFilter()
  {
    return 0;
  }
  
  public int getDigitalZoomScale(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getExposureCompensation(int... paramVarArgs)
  {
    return 0;
  }
  
  public DataCameraSetExposureMode.ExposureMode getExposureMode(int... paramVarArgs)
  {
    return null;
  }
  
  public int getExposureStatus()
  {
    return 0;
  }
  
  public int getISO()
  {
    return 0;
  }
  
  public int getImageFormat(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getImageQuality()
  {
    return 0;
  }
  
  public DataCameraGetImageSize.RatioType getImageRatio()
  {
    return null;
  }
  
  public DataCameraGetImageSize.SizeType getImageSize()
  {
    return null;
  }
  
  public int getMCTFStrength()
  {
    return 0;
  }
  
  public int getMetering()
  {
    return 0;
  }
  
  public int getOpticsScale()
  {
    return 0;
  }
  
  public PanoMode getPanoMode()
  {
    return null;
  }
  
  public DataCameraSetPhoto.TYPE getPhotoType(int... paramVarArgs)
  {
    return null;
  }
  
  public DataCameraSetVideoEncode.VideoEncodeType getPrimaryVideoEncodeType()
  {
    return null;
  }
  
  public int getRawBurstCount()
  {
    return 0;
  }
  
  public int getRawBurstNumber()
  {
    return 0;
  }
  
  public int getRawCapMaxShutter()
  {
    return 0;
  }
  
  public int getRawCapMinShutter()
  {
    return 0;
  }
  
  public int getRealApertureSize()
  {
    return 0;
  }
  
  public int getRealRawShutter()
  {
    return 0;
  }
  
  public int getRelExposureCompensation()
  {
    return 0;
  }
  
  public int getRelISO()
  {
    return 0;
  }
  
  public int getRelShutter()
  {
    return 0;
  }
  
  public int getRelShutterSpeedDecimal()
  {
    return 0;
  }
  
  public String getRelShutterString()
  {
    return null;
  }
  
  public DataCameraSetCameraRotationMode.RotationAngleType getRotationAngleType()
  {
    return null;
  }
  
  public int getSaturation()
  {
    return 0;
  }
  
  public int getSceneMode()
  {
    return 0;
  }
  
  public DataCameraSetVideoEncode.VideoEncodeType getSecondaryVideoEncodeType()
  {
    return null;
  }
  
  public int getSharpe()
  {
    return 0;
  }
  
  public int getShutter()
  {
    return 0;
  }
  
  public int getShutterSpeedDecimal()
  {
    return 0;
  }
  
  public String getShutterString()
  {
    return null;
  }
  
  public int getSpotAreaBottomRightPos()
  {
    return 0;
  }
  
  public int getTimeCountdown()
  {
    return 0;
  }
  
  public int getTimeParamsNum(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getTimeParamsPeriod(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getTimeParamsType(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getTimelapseDuration(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getTimelapseRecordedFrame()
  {
    return 0;
  }
  
  public int getTimelapseSaveType(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getTimelapseTimeCountDown()
  {
    return 0;
  }
  
  public int getTonal()
  {
    return 0;
  }
  
  public int getUserRawShutter()
  {
    return 0;
  }
  
  public int getVideoContastEnhance()
  {
    return 0;
  }
  
  public int getVideoFormat(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getVideoFov()
  {
    return 0;
  }
  
  public int getVideoFps(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getVideoQuality()
  {
    return 0;
  }
  
  public int getVideoRecordIntervalTime(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getVideoRecordMode(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getVideoSecondOpen()
  {
    return 0;
  }
  
  public int getVideoSecondRatio()
  {
    return 0;
  }
  
  public int getVideoStandard(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getVideoStoreFormat()
  {
    return 0;
  }
  
  public int getWhiteBalance()
  {
    return 0;
  }
  
  public boolean isAELock(int... paramVarArgs)
  {
    return false;
  }
  
  public boolean isCapMaxShutterReciprocal()
  {
    return false;
  }
  
  public boolean isCapMinShutterReciprocal()
  {
    return false;
  }
  
  public boolean isLockedGimbalWhenShot()
  {
    return false;
  }
  
  public boolean isMCTFEnable()
  {
    return false;
  }
  
  public boolean isMechanicShutterEnable()
  {
    return false;
  }
  
  public boolean isReciprocal()
  {
    return false;
  }
  
  public boolean isRelReciprocal()
  {
    return false;
  }
  
  public boolean isVideoCaptionEnable()
  {
    return false;
  }
  
  public static enum PanoMode
  {
    private int data;
    
    static
    {
      Manual = new PanoMode("Manual", 3, 4);
      Auto180 = new PanoMode("Auto180", 4, 5);
      VERTICAL = new PanoMode("VERTICAL", 5, 6);
      SECTORIAL = new PanoMode("SECTORIAL", 6, 7);
      PanoMode localPanoMode = new PanoMode("OTHER", 7, 0);
      OTHER = localPanoMode;
      $VALUES = new PanoMode[] { Auto360, Ball, Self, Manual, Auto180, VERTICAL, SECTORIAL, localPanoMode };
    }
    
    private PanoMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static PanoMode find(int paramInt)
    {
      PanoMode localPanoMode = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPanoMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushShotParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */