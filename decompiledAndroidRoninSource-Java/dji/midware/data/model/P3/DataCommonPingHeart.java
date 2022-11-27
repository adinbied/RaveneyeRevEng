package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCommonPingHeart
  extends DataBase
  implements DJIDataSyncListener
{
  private static final String TAG = DataCommonPingHeart.class.getSimpleName();
  private int mReceiverId = 0;
  private DeviceType mReceiverType = DeviceType.CAMERA;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataCommonPingHeart setReceiverId(int paramInt)
  {
    this.mReceiverId = paramInt;
    return this;
  }
  
  public DataCommonPingHeart setReceiverType(DeviceType paramDeviceType)
  {
    this.mReceiverType = paramDeviceType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonPingHeart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */