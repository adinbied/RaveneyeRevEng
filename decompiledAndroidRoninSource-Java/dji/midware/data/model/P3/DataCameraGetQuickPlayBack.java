package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraGetQuickPlayBack
  extends DataBase
  implements DJIDataSyncListener
{
  private static final byte FLAG_ENABLE = -128;
  private static DataCameraGetQuickPlayBack instance;
  
  public static DataCameraGetQuickPlayBack getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetQuickPlayBack();
      }
      DataCameraGetQuickPlayBack localDataCameraGetQuickPlayBack = instance;
      return localDataCameraGetQuickPlayBack;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public byte getTime()
  {
    return 0;
  }
  
  public boolean isEnable()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetQuickPlayBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */