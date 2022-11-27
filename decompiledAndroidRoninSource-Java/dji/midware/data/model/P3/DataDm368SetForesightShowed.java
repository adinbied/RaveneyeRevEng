package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataDm368SetForesightShowed
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataDm368SetForesightShowed instance;
  private int mIsOpen = 0;
  
  public static DataDm368SetForesightShowed getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataDm368SetForesightShowed();
      }
      DataDm368SetForesightShowed localDataDm368SetForesightShowed = instance;
      return localDataDm368SetForesightShowed;
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
  
  public DataDm368SetForesightShowed setIsOpen(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mIsOpen = 1;
      return this;
    }
    this.mIsOpen = 0;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataDm368SetForesightShowed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */