package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushSensorException
  extends DataBase
{
  private static DataEyeGetPushSensorException instance;
  
  public static DataEyeGetPushSensorException getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushSensorException();
      }
      DataEyeGetPushSensorException localDataEyeGetPushSensorException = instance;
      return localDataEyeGetPushSensorException;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getCntIndex()
  {
    return 0;
  }
  
  public boolean isBackImageDiff()
  {
    return false;
  }
  
  public boolean isBackImageException()
  {
    return false;
  }
  
  public boolean isBackImageExposureTooLong()
  {
    return false;
  }
  
  public boolean isBackOverExposure()
  {
    return false;
  }
  
  public boolean isBackUnderExposure()
  {
    return false;
  }
  
  public boolean isBottomImageDiff()
  {
    return false;
  }
  
  public boolean isBottomImageException()
  {
    return false;
  }
  
  public boolean isBottomImageExposureTooLong()
  {
    return false;
  }
  
  public boolean isBottomOverExposure()
  {
    return false;
  }
  
  public boolean isBottomUnderExposure()
  {
    return false;
  }
  
  public boolean isFrontImageDiff()
  {
    return false;
  }
  
  public boolean isFrontImageException()
  {
    return false;
  }
  
  public boolean isFrontImageExposureTooLong()
  {
    return false;
  }
  
  public boolean isFrontOverExposure()
  {
    return false;
  }
  
  public boolean isFrontUnderExposure()
  {
    return false;
  }
  
  public boolean isLeft3DTOFAbnormal()
  {
    return false;
  }
  
  public boolean isLeftImageDiff()
  {
    return false;
  }
  
  public boolean isLeftImageException()
  {
    return false;
  }
  
  public boolean isLeftImageExposureTooLong()
  {
    return false;
  }
  
  public boolean isLeftOverExposure()
  {
    return false;
  }
  
  public boolean isLeftUnderExposure()
  {
    return false;
  }
  
  public boolean isRight3DTOFAbnormal()
  {
    return false;
  }
  
  public boolean isRightImageDiff()
  {
    return false;
  }
  
  public boolean isRightImageException()
  {
    return false;
  }
  
  public boolean isRightImageExposureTooLong()
  {
    return false;
  }
  
  public boolean isRightOverExposure()
  {
    return false;
  }
  
  public boolean isRightUnderExposure()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushSensorException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */