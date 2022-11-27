package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCommonGetDeviceInfo
  extends DataBase
  implements DJIDataSyncListener
{
  private int mReceiveId = 0;
  private DeviceType mReceiveType = DeviceType.DM368;
  
  protected void doPack() {}
  
  public String getInfo()
  {
    return null;
  }
  
  public boolean isHaveCcode()
  {
    return false;
  }
  
  public DataCommonGetDeviceInfo setReceiveId(int paramInt)
  {
    this.mReceiveId = paramInt;
    return this;
  }
  
  public DataCommonGetDeviceInfo setReceiveType(DeviceType paramDeviceType)
  {
    this.mReceiveType = paramDeviceType;
    return this;
  }
  
  public void start(DJIDataCallBack paramDJIDataCallBack)
  {
    start(paramDJIDataCallBack, 1000, 2);
  }
  
  /* Error */
  public void start(DJIDataCallBack arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonGetDeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */