package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcGetFDRcCalibrationState
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcGetFDRcCalibrationState instance;
  
  public static DataRcGetFDRcCalibrationState getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetFDRcCalibrationState();
      }
      DataRcGetFDRcCalibrationState localDataRcGetFDRcCalibrationState = instance;
      return localDataRcGetFDRcCalibrationState;
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
  
  public int getASegmentFilledUpState()
  {
    return 0;
  }
  
  public int getBSegmentFilledUpState()
  {
    return 0;
  }
  
  public int getCSegmentFilledUpState()
  {
    return 0;
  }
  
  public int getDSegmentFilledUpState()
  {
    return 0;
  }
  
  public int getESegmentFilledUpState()
  {
    return 0;
  }
  
  public int getFSegmentFilledUpState()
  {
    return 0;
  }
  
  public int getGSegmentFilledUpState()
  {
    return 0;
  }
  
  public int getHSegmentFilledUpState()
  {
    return 0;
  }
  
  public int getSegmentNumber()
  {
    return 0;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetFDRcCalibrationState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */