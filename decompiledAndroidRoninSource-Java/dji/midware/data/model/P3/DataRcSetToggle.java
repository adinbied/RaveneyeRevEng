package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcSetToggle
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcSetToggle instance;
  private boolean isOpen;
  
  public static DataRcSetToggle getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSetToggle();
      }
      DataRcSetToggle localDataRcSetToggle = instance;
      return localDataRcSetToggle;
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
  
  public DataRcSetToggle setIsOpen(boolean paramBoolean)
  {
    this.isOpen = paramBoolean;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetToggle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */