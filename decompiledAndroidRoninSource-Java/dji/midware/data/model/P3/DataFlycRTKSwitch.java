package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycRTKSwitch
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycRTKSwitch instance;
  private boolean isRtkEnabled;
  
  public static DataFlycRTKSwitch getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycRTKSwitch();
      }
      DataFlycRTKSwitch localDataFlycRTKSwitch = instance;
      return localDataFlycRTKSwitch;
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
  
  public DataFlycRTKSwitch setRtkEnabled(boolean paramBoolean)
  {
    this.isRtkEnabled = paramBoolean;
    return this;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycRTKSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */