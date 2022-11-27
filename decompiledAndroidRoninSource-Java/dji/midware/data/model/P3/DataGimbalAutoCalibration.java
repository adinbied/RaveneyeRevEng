package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalAutoCalibration
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataGimbalAutoCalibration instance;
  private CalibrationPart mCalType = CalibrationPart.AUTO;
  
  public static DataGimbalAutoCalibration getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalAutoCalibration();
      }
      DataGimbalAutoCalibration localDataGimbalAutoCalibration = instance;
      return localDataGimbalAutoCalibration;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public CalibrationStatus getStatus()
  {
    return null;
  }
  
  public CalibrationPart getType()
  {
    return null;
  }
  
  public DataGimbalAutoCalibration setCalType(CalibrationPart paramCalibrationPart)
  {
    this.mCalType = paramCalibrationPart;
    return this;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum CalibrationPart
  {
    int value;
    
    static
    {
      HALL_LINEAR = new CalibrationPart("HALL_LINEAR", 2, 2);
      JOINT_ANGLE_CAMERA = new CalibrationPart("JOINT_ANGLE_CAMERA", 3, 3);
      JOINT_ANGLE_FIXTURE = new CalibrationPart("JOINT_ANGLE_FIXTURE", 4, 4);
      GYRO = new CalibrationPart("GYRO", 5, 5);
      ACCELERATION = new CalibrationPart("ACCELERATION", 6, 6);
      COMPASS = new CalibrationPart("COMPASS", 7, 7);
      IMU_AND_SENSOR = new CalibrationPart("IMU_AND_SENSOR", 8, 8);
      CalibrationPart localCalibrationPart = new CalibrationPart("SHOCK_PLATE", 9, 9);
      SHOCK_PLATE = localCalibrationPart;
      $VALUES = new CalibrationPart[] { AUTO, JOINT_ANGLE, HALL_LINEAR, JOINT_ANGLE_CAMERA, JOINT_ANGLE_FIXTURE, GYRO, ACCELERATION, COMPASS, IMU_AND_SENSOR, localCalibrationPart };
    }
    
    private CalibrationPart(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum CalibrationStatus
  {
    int value;
    
    static
    {
      CalibrationStatus localCalibrationStatus = new CalibrationStatus("PROCESSING", 2, 2);
      PROCESSING = localCalibrationStatus;
      $VALUES = new CalibrationStatus[] { FAIL, SUCCESS, localCalibrationStatus };
    }
    
    private CalibrationStatus(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalAutoCalibration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */