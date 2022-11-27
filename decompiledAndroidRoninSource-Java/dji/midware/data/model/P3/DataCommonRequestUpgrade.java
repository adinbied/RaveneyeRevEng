package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCommonRequestUpgrade
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCommonRequestUpgrade instance;
  private int mEncrypt = 0;
  private int mReceiveId = 0;
  private DeviceType mReceiveType = DeviceType.RC;
  private DJIUpgradeFileMethod upgradeFileMethod = new DJIUpgradeFileMethod();
  private DJIUpgradeTranMethod upgradeTranMethod = new DJIUpgradeTranMethod();
  
  public static DataCommonRequestUpgrade getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCommonRequestUpgrade();
      }
      DataCommonRequestUpgrade localDataCommonRequestUpgrade = instance;
      return localDataCommonRequestUpgrade;
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
  
  public DJIUpgradeFileMethod getTranFileEntry()
  {
    return null;
  }
  
  public DJIUpgradeTranMethod getTranMethodEntry()
  {
    return null;
  }
  
  public DeviceType getmReceiveType()
  {
    return this.mReceiveType;
  }
  
  public DataCommonRequestUpgrade setReceiveId(int paramInt)
  {
    this.mReceiveId = paramInt;
    return this;
  }
  
  public DataCommonRequestUpgrade setReceiveType(DeviceType paramDeviceType)
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
  
  public static class DJIUpgradeFileMethod
    implements Cloneable
  {
    public boolean isSupportBigPackage = false;
    public boolean isSupportCopyData = false;
    public boolean isSupportMultiFile = false;
    public boolean isSupportSingalFileSerial = false;
    
    public Object clone()
    {
      return null;
    }
    
    public byte getBuffer()
    {
      return 0;
    }
    
    /* Error */
    public void parse(byte arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void reset()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static class DJIUpgradeTranMethod
    implements Cloneable
  {
    public boolean isSupportFTP = false;
    public boolean isSupportV1 = false;
    
    public Object clone()
    {
      return null;
    }
    
    public byte getBuffer()
    {
      return 0;
    }
    
    /* Error */
    public void parse(byte arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    public void reset()
    {
      this.isSupportV1 = false;
      this.isSupportFTP = false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonRequestUpgrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */