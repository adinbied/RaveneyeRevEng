package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetQuickPlayBack
  extends DataBase
  implements DJIDataSyncListener
{
  private static final byte FLAG_ENABLE = -128;
  private static DataCameraSetQuickPlayBack instance;
  private boolean enbale = false;
  private byte mTime = 0;
  
  public static DataCameraSetQuickPlayBack getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetQuickPlayBack();
      }
      DataCameraSetQuickPlayBack localDataCameraSetQuickPlayBack = instance;
      return localDataCameraSetQuickPlayBack;
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
  
  public void setEnable(boolean paramBoolean)
  {
    this.enbale = paramBoolean;
  }
  
  public void setTime(byte paramByte)
  {
    this.mTime = paramByte;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetQuickPlayBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */