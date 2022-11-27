package dji.midware.data.model.P3;

import dji.midware.data.config.P3.Ccode;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCommonGetPushAppGpsConfig
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCommonGetPushAppGpsConfig instance;
  private Ccode ResponseCode = Ccode.UNDEFINED;
  private boolean isStart = false;
  private int pushInterval = 0;
  
  public static DataCommonGetPushAppGpsConfig getInstance()
  {
    if (instance == null) {
      instance = new DataCommonGetPushAppGpsConfig();
    }
    return instance;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getPushInterval()
  {
    return 0;
  }
  
  public boolean isStart()
  {
    return false;
  }
  
  /* Error */
  public void setResponseCode(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonGetPushAppGpsConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */