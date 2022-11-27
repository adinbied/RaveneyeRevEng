package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataEyeGetHandGestureEnabled
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataEyeGetHandGestureEnabled instance;
  
  public static DataEyeGetHandGestureEnabled getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetHandGestureEnabled();
      }
      DataEyeGetHandGestureEnabled localDataEyeGetHandGestureEnabled = instance;
      return localDataEyeGetHandGestureEnabled;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean getEnabled()
  {
    return false;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetHandGestureEnabled.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */