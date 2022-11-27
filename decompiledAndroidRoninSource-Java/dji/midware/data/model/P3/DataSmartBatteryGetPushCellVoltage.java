package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSmartBatteryGetPushCellVoltage
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSmartBatteryGetPushCellVoltage mInstance;
  private int dataOffset = 0;
  private int index = 0;
  private boolean isRequestPush = false;
  private boolean isStopPush = true;
  private int pushFreq = 1;
  
  public static DataSmartBatteryGetPushCellVoltage getInstance()
  {
    if (mInstance == null) {
      mInstance = new DataSmartBatteryGetPushCellVoltage();
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
  
  public int getCells()
  {
    return 0;
  }
  
  public int getIndex()
  {
    return 0;
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public int[] getVoltages()
  {
    return null;
  }
  
  public DataSmartBatteryGetPushCellVoltage setContinuePush(boolean paramBoolean)
  {
    this.isStopPush = paramBoolean;
    return this;
  }
  
  public DataSmartBatteryGetPushCellVoltage setIndex(int paramInt)
  {
    this.index = paramInt;
    return this;
  }
  
  public DataSmartBatteryGetPushCellVoltage setPushFreq(int paramInt)
  {
    this.pushFreq = paramInt;
    return this;
  }
  
  /* Error */
  protected void setPushRecPack(dji.midware.data.packages.P3.Pack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataSmartBatteryGetPushCellVoltage setRequestPush(boolean paramBoolean)
  {
    this.isRequestPush = paramBoolean;
    this.dataOffset = (paramBoolean ^ true);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSmartBatteryGetPushCellVoltage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */