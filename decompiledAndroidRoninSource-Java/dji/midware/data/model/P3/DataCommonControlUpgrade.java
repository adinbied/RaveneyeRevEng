package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCommonControlUpgrade
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCommonControlUpgrade instance;
  private ControlCmd controlCmd;
  private int mReceiveId = 0;
  private DeviceType mReceiveType = DeviceType.DM368;
  
  public static DataCommonControlUpgrade getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCommonControlUpgrade();
      }
      DataCommonControlUpgrade localDataCommonControlUpgrade = instance;
      return localDataCommonControlUpgrade;
    }
    finally {}
  }
  
  /* Error */
  protected void LogPack(String arg1)
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
  
  public DataCommonControlUpgrade setControlCmd(ControlCmd paramControlCmd)
  {
    this.controlCmd = paramControlCmd;
    return this;
  }
  
  public DataCommonControlUpgrade setReceiveId(int paramInt)
  {
    this.mReceiveId = paramInt;
    return this;
  }
  
  public DataCommonControlUpgrade setReceiveType(DeviceType paramDeviceType)
  {
    this.mReceiveType = paramDeviceType;
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
  
  public static enum ControlCmd
  {
    private int data;
    
    static
    {
      Pause = new ControlCmd("Pause", 2, 2);
      Stop = new ControlCmd("Stop", 3, 3);
      StopPush = new ControlCmd("StopPush", 4, 4);
      Restart = new ControlCmd("Restart", 5, 5);
      ControlCmd localControlCmd = new ControlCmd("OTHER", 6, 7);
      OTHER = localControlCmd;
      $VALUES = new ControlCmd[] { Cancel, Start, Pause, Stop, StopPush, Restart, localControlCmd };
    }
    
    private ControlCmd(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ControlCmd find(int paramInt)
    {
      ControlCmd localControlCmd = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localControlCmd;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonControlUpgrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */