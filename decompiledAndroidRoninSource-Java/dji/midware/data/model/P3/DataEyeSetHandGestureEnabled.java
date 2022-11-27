package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataEyeSetHandGestureEnabled
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataEyeSetHandGestureEnabled instance;
  private boolean enabled;
  
  public static DataEyeSetHandGestureEnabled getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeSetHandGestureEnabled();
      }
      DataEyeSetHandGestureEnabled localDataEyeSetHandGestureEnabled = instance;
      return localDataEyeSetHandGestureEnabled;
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
  
  public DataEyeSetHandGestureEnabled setEnabled(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeSetHandGestureEnabled.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */