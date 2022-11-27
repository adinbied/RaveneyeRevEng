package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetAudio
  extends DataBase
  implements DJIDataSyncListener
{
  DJIDataCallBack callBack;
  DataCameraGetAudio getter;
  byte isEnable = -1;
  int src = -1;
  byte toFirstDataRate = -1;
  byte toSecondDataRate = -1;
  int type = -1;
  
  /* Error */
  private void sendPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataCameraSetAudio setEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.isEnable = 1;
      return this;
    }
    this.isEnable = 0;
    return this;
  }
  
  /* Error */
  public void start(DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetAudio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */