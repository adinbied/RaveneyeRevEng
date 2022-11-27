package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalGetPushCalibrationStatus
  extends DataBase
  implements DJIDataSyncListener
{
  private static final String TAG = DataGimbalGetPushCalibrationStatus.class.getSimpleName();
  private int mCalibratePercent;
  private int mCalibrateStatus;
  
  public static DataGimbalGetPushCalibrationStatus getInstance()
  {
    return InstanceHolder.sINSTANCE;
  }
  
  protected void doPack() {}
  
  public int getCalibratePercent()
  {
    return this.mCalibratePercent;
  }
  
  public CalibrationStatus getCalibrateStatus()
  {
    return CalibrationStatus.find(this.mCalibrateStatus);
  }
  
  /* Error */
  protected void setPushRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum CalibrationStatus
  {
    private int data;
    
    static
    {
      Processing = new CalibrationStatus("Processing", 1, 1);
      Complete = new CalibrationStatus("Complete", 2, 2);
      Failure = new CalibrationStatus("Failure", 3, 3);
      CalibrationStatus localCalibrationStatus = new CalibrationStatus("UnKnown", 4, 255);
      UnKnown = localCalibrationStatus;
      $VALUES = new CalibrationStatus[] { UnStart, Processing, Complete, Failure, localCalibrationStatus };
    }
    
    private CalibrationStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    static CalibrationStatus find(int paramInt)
    {
      CalibrationStatus localCalibrationStatus = UnKnown;
      CalibrationStatus[] arrayOfCalibrationStatus = values();
      int i = 0;
      while (i < arrayOfCalibrationStatus.length)
      {
        if (arrayOfCalibrationStatus[i].data == paramInt) {
          return arrayOfCalibrationStatus[i];
        }
        i += 1;
      }
      return localCalibrationStatus;
    }
  }
  
  private static class InstanceHolder
  {
    private static final DataGimbalGetPushCalibrationStatus sINSTANCE = new DataGimbalGetPushCalibrationStatus(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetPushCalibrationStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */