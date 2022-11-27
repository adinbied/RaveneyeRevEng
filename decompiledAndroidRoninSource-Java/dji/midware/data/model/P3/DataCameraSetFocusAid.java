package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetFocusAid
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetFocusAid instance;
  private boolean mDigitalFocusA = true;
  private boolean mDigitalFocusM = true;
  
  public static DataCameraSetFocusAid getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetFocusAid();
      }
      DataCameraSetFocusAid localDataCameraSetFocusAid = instance;
      return localDataCameraSetFocusAid;
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
  
  public DataCameraSetFocusAid setDigitalFocus(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mDigitalFocusA = paramBoolean1;
    this.mDigitalFocusM = paramBoolean2;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetFocusAid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */