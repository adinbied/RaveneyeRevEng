package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalGetPushSensorCalibrateStatus
  extends DataBase
  implements DJIDataSyncListener
{
  private static final String TAG = "SensorCalibrateStatus";
  private static DataGimbalGetPushSensorCalibrateStatus instance;
  
  public static DataGimbalGetPushSensorCalibrateStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalGetPushSensorCalibrateStatus();
      }
      DataGimbalGetPushSensorCalibrateStatus localDataGimbalGetPushSensorCalibrateStatus = instance;
      return localDataGimbalGetPushSensorCalibrateStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getProgress()
  {
    return 0;
  }
  
  public CalibrationStatus getStatus()
  {
    return null;
  }
  
  public void start(DJIDataCallBack paramDJIDataCallBack) {}
  
  public static enum CalibrationStatus
  {
    int value;
    
    static
    {
      FAIL = new CalibrationStatus("FAIL", 2, 3);
      CalibrationStatus localCalibrationStatus = new CalibrationStatus("OTHER", 3, 9);
      OTHER = localCalibrationStatus;
      $VALUES = new CalibrationStatus[] { COMPLETE, PROCESSING, FAIL, localCalibrationStatus };
    }
    
    private CalibrationStatus(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static CalibrationStatus find(int paramInt)
    {
      CalibrationStatus localCalibrationStatus = OTHER;
      CalibrationStatus[] arrayOfCalibrationStatus = values();
      int i = 0;
      while (i < arrayOfCalibrationStatus.length)
      {
        if (arrayOfCalibrationStatus[i]._equals(paramInt)) {
          return arrayOfCalibrationStatus[i];
        }
        i += 1;
      }
      return localCalibrationStatus;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetPushSensorCalibrateStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */