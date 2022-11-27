package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyePushFovCalibrate
  extends DataBase
{
  private static final String TAG = "DataEyePushFovCalibrate";
  private static volatile DataEyePushFovCalibrate mInstance;
  
  public static DataEyePushFovCalibrate getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new DataEyePushFovCalibrate();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  protected void doPack() {}
  
  public int getFovCalibProgress()
  {
    return 0;
  }
  
  public int getFovCalibState()
  {
    return 0;
  }
  
  /* Error */
  public void setRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyePushFovCalibrate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */