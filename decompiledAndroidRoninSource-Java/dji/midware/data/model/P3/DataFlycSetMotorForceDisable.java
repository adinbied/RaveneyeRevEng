package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSetMotorForceDisable
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycSetMotorForceDisable instance;
  private boolean isDisable = false;
  
  public static DataFlycSetMotorForceDisable getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycSetMotorForceDisable();
      }
      DataFlycSetMotorForceDisable localDataFlycSetMotorForceDisable = instance;
      return localDataFlycSetMotorForceDisable;
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
  
  public DataFlycSetMotorForceDisable setDisable(boolean paramBoolean)
  {
    this.isDisable = paramBoolean;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSetMotorForceDisable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */