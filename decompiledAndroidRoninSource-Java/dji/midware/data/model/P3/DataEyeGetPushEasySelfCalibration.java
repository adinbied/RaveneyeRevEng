package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushEasySelfCalibration
  extends DataBase
{
  private static DataEyeGetPushEasySelfCalibration instance;
  
  public static DataEyeGetPushEasySelfCalibration getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushEasySelfCalibration();
      }
      DataEyeGetPushEasySelfCalibration localDataEyeGetPushEasySelfCalibration = instance;
      return localDataEyeGetPushEasySelfCalibration;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public CaliStatusCode getCaliStatusCode()
  {
    return null;
  }
  
  public int getProgress()
  {
    return 0;
  }
  
  public VisionSensorType getSensorType()
  {
    return null;
  }
  
  public int getTinkCount()
  {
    return 0;
  }
  
  public static enum CaliStatusCode
  {
    private final int data;
    
    static
    {
      CollectImage = new CaliStatusCode("CollectImage", 2, 2);
      Caculating = new CaliStatusCode("Caculating", 3, 3);
      WaitingNext = new CaliStatusCode("WaitingNext", 4, 99);
      Success = new CaliStatusCode("Success", 5, 100);
      MoveWrong = new CaliStatusCode("MoveWrong", 6, -1);
      MoveTooFast = new CaliStatusCode("MoveTooFast", 7, -2);
      GroundDetailTooLess = new CaliStatusCode("GroundDetailTooLess", 8, -3);
      LightEnviromentInvalid = new CaliStatusCode("LightEnviromentInvalid", 9, -4);
      FeatureLess = new CaliStatusCode("FeatureLess", 10, -5);
      DiffLarge = new CaliStatusCode("DiffLarge", 11, -6);
      AlreadyCali = new CaliStatusCode("AlreadyCali", 12, -10);
      CalulateTimeOut = new CaliStatusCode("CalulateTimeOut", 13, -100);
      ParamDiffSerious = new CaliStatusCode("ParamDiffSerious", 14, -101);
      CaliStatusCode localCaliStatusCode = new CaliStatusCode("OTHER", 15, 100);
      OTHER = localCaliStatusCode;
      $VALUES = new CaliStatusCode[] { NotCalibrating, WaitingMove, CollectImage, Caculating, WaitingNext, Success, MoveWrong, MoveTooFast, GroundDetailTooLess, LightEnviromentInvalid, FeatureLess, DiffLarge, AlreadyCali, CalulateTimeOut, ParamDiffSerious, localCaliStatusCode };
    }
    
    private CaliStatusCode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CaliStatusCode find(int paramInt)
    {
      CaliStatusCode localCaliStatusCode1 = NotCalibrating;
      CaliStatusCode[] arrayOfCaliStatusCode = values();
      int j = arrayOfCaliStatusCode.length;
      int i = 0;
      while (i < j)
      {
        CaliStatusCode localCaliStatusCode2 = arrayOfCaliStatusCode[i];
        if (localCaliStatusCode2._equals(paramInt)) {
          return localCaliStatusCode2;
        }
        i += 1;
      }
      return localCaliStatusCode1;
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
  
  public static enum VisionSensorType
  {
    private final int data;
    
    static
    {
      Bottom = new VisionSensorType("Bottom", 1, 1);
      Forward = new VisionSensorType("Forward", 2, 2);
      Right = new VisionSensorType("Right", 3, 3);
      Backward = new VisionSensorType("Backward", 4, 4);
      Left = new VisionSensorType("Left", 5, 5);
      Top = new VisionSensorType("Top", 6, 6);
      VisionSensorType localVisionSensorType = new VisionSensorType("OTHER", 7, 100);
      OTHER = localVisionSensorType;
      $VALUES = new VisionSensorType[] { None, Bottom, Forward, Right, Backward, Left, Top, localVisionSensorType };
    }
    
    private VisionSensorType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static VisionSensorType find(int paramInt)
    {
      VisionSensorType localVisionSensorType1 = None;
      VisionSensorType[] arrayOfVisionSensorType = values();
      int j = arrayOfVisionSensorType.length;
      int i = 0;
      while (i < j)
      {
        VisionSensorType localVisionSensorType2 = arrayOfVisionSensorType[i];
        if (localVisionSensorType2._equals(paramInt)) {
          return localVisionSensorType2;
        }
        i += 1;
      }
      return localVisionSensorType1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushEasySelfCalibration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */