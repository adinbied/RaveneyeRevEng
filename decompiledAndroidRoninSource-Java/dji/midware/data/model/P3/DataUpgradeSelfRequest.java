package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataAsync2Listener;

public class DataUpgradeSelfRequest
  extends DataBase
  implements DJIDataAsync2Listener
{
  private static DataUpgradeSelfRequest instance;
  private ControlCmd controlCmd;
  
  public static DataUpgradeSelfRequest getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataUpgradeSelfRequest();
      }
      DataUpgradeSelfRequest localDataUpgradeSelfRequest = instance;
      return localDataUpgradeSelfRequest;
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
  
  public int getSenderDeviceId()
  {
    return 0;
  }
  
  public DeviceType getSenderDeviceType()
  {
    return null;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public DataUpgradeSelfRequest setControlCmd(ControlCmd paramControlCmd)
  {
    this.controlCmd = paramControlCmd;
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
  
  public static enum ControlCmd
  {
    private int data;
    
    static
    {
      DO = new ControlCmd("DO", 1, 1);
      ControlCmd localControlCmd = new ControlCmd("OTHER", 2, 7);
      OTHER = localControlCmd;
      $VALUES = new ControlCmd[] { UNDO, DO, localControlCmd };
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataUpgradeSelfRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */