package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalNewResetAndSetMode
  extends DataBase
  implements DJIDataSyncListener
{
  private DataGimbalControl.MODE gimbalMode = DataGimbalControl.MODE.OTHER;
  private boolean resetGimbal = false;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataGimbalNewResetAndSetMode setGimbalMode(DataGimbalControl.MODE paramMODE)
  {
    this.gimbalMode = paramMODE;
    return this;
  }
  
  public DataGimbalNewResetAndSetMode setReset(boolean paramBoolean)
  {
    this.resetGimbal = paramBoolean;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalNewResetAndSetMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */