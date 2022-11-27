package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSmartBatteryGetStaticData
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSmartBatteryGetStaticData mInstance;
  private int index = 0;
  
  public static DataSmartBatteryGetStaticData getInstance()
  {
    if (mInstance == null) {
      mInstance = new DataSmartBatteryGetStaticData();
    }
    return mInstance;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public long getAppVer()
  {
    return 277694806L;
  }
  
  public String getBoardProvider()
  {
    return null;
  }
  
  public String getCellProvider()
  {
    return null;
  }
  
  public int getCycleTimes()
  {
    return 0;
  }
  
  public long getDesignCapacity()
  {
    return 277694822L;
  }
  
  public int getDesignVoltage()
  {
    return 0;
  }
  
  public String getDeviceName()
  {
    return null;
  }
  
  public int getIndex()
  {
    return 0;
  }
  
  public long getLifePercent()
  {
    return 277694838L;
  }
  
  public long getLoaderVer()
  {
    return 277694842L;
  }
  
  public int getProductionDate()
  {
    return 0;
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public int getSerialNumber()
  {
    return 0;
  }
  
  public long getType()
  {
    return 277694858L;
  }
  
  public DataSmartBatteryGetStaticData setIndex(int paramInt)
  {
    this.index = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSmartBatteryGetStaticData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */