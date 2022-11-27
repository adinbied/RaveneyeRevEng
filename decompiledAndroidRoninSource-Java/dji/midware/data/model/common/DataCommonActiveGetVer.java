package dji.midware.data.model.common;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCommonActiveGetVer
  extends DataBase
  implements DJIDataSyncListener
{
  private DeviceType deviceType;
  private DataAbstractGetPushActiveStatus.DJIActiveVersion version;
  
  protected void LogPack(String paramString) {}
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataAbstractGetPushActiveStatus.DJIActiveVersion getVer()
  {
    return this.version;
  }
  
  public DataCommonActiveGetVer setDevice(DeviceType paramDeviceType)
  {
    this.deviceType = paramDeviceType;
    return this;
  }
  
  /* Error */
  public void setRecData(byte[] arg1)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\common\DataCommonActiveGetVer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */