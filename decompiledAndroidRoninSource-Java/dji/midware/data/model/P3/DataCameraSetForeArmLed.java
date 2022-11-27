package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetForeArmLed
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetForeArmLed instance;
  private byte mEnableMask = -1;
  
  public static DataCameraSetForeArmLed getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetForeArmLed();
      }
      DataCameraSetForeArmLed localDataCameraSetForeArmLed = instance;
      return localDataCameraSetForeArmLed;
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
  
  public DataCameraSetForeArmLed setEnable(byte paramByte)
  {
    this.mEnableMask = paramByte;
    return this;
  }
  
  public DataCameraSetForeArmLed setEnable(boolean paramBoolean)
  {
    this.mEnableMask = ((byte)paramBoolean);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetForeArmLed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */