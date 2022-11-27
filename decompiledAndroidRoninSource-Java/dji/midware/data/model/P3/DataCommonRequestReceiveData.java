package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCommonRequestReceiveData
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCommonRequestReceiveData instance;
  private DataCommonRequestUpgrade.DJIUpgradeFileMethod fileMethod;
  private long mDataLength = 0L;
  private int mEncrypt = 0;
  private int mReceiveId = 0;
  private DeviceType mReceiveType = DeviceType.RC;
  private int mType;
  private DataCommonRequestUpgrade.DJIUpgradeTranMethod tranMethod;
  
  public static DataCommonRequestReceiveData getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCommonRequestReceiveData();
      }
      DataCommonRequestReceiveData localDataCommonRequestReceiveData = instance;
      return localDataCommonRequestReceiveData;
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
  
  public void clear() {}
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String getDir()
  {
    return null;
  }
  
  public String getFtpIP()
  {
    return null;
  }
  
  public int getFtpPort()
  {
    return 0;
  }
  
  public int getReceiveDataLength()
  {
    return 0;
  }
  
  public DataCommonRequestReceiveData setDataLength(long paramLong)
  {
    this.mDataLength = paramLong;
    return this;
  }
  
  public DataCommonRequestReceiveData setFileMethod(DataCommonRequestUpgrade.DJIUpgradeFileMethod paramDJIUpgradeFileMethod)
  {
    this.fileMethod = paramDJIUpgradeFileMethod;
    return this;
  }
  
  public DataCommonRequestReceiveData setReceiveId(int paramInt)
  {
    this.mReceiveId = paramInt;
    return this;
  }
  
  public DataCommonRequestReceiveData setReceiveType(DeviceType paramDeviceType)
  {
    this.mReceiveType = paramDeviceType;
    return this;
  }
  
  public DataCommonRequestReceiveData setTranMethod(DataCommonRequestUpgrade.DJIUpgradeTranMethod paramDJIUpgradeTranMethod)
  {
    this.tranMethod = paramDJIUpgradeTranMethod;
    return this;
  }
  
  public DataCommonRequestReceiveData setType(int paramInt)
  {
    this.mType = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonRequestReceiveData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */