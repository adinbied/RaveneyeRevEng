package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetPushDevicesState
  extends DataBase
{
  private static DataOsdGetPushDevicesState instance;
  
  public static DataOsdGetPushDevicesState getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushDevicesState();
      }
      DataOsdGetPushDevicesState localDataOsdGetPushDevicesState = instance;
      return localDataOsdGetPushDevicesState;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean getSignalQuality(DeviceType paramDeviceType)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushDevicesState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */