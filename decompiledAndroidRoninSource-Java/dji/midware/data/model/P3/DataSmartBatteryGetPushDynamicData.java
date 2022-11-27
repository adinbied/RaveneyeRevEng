package dji.midware.data.model.P3;

import android.util.SparseIntArray;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSmartBatteryGetPushDynamicData
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSmartBatteryGetPushDynamicData mInstance;
  private int dataOffset = 0;
  private int index = 0;
  private SparseIntArray isPushLostList = new SparseIntArray(3);
  private boolean isRequestPush = false;
  private boolean isStopPush = true;
  private int pushFreq = 1;
  
  public DataSmartBatteryGetPushDynamicData()
  {
    this.isNeedPushLosed = true;
    this.delayPushLoseTime = 3000;
  }
  
  public static DataSmartBatteryGetPushDynamicData getInstance()
  {
    if (mInstance == null) {
      mInstance = new DataSmartBatteryGetPushDynamicData();
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
  
  public int getBatteryHeatState()
  {
    return 0;
  }
  
  public int getCellSize()
  {
    return 0;
  }
  
  public int getCellSize(int paramInt)
  {
    return 0;
  }
  
  public int getCurrent()
  {
    return 0;
  }
  
  public int getCurrent(int paramInt)
  {
    return 0;
  }
  
  public int getFullCapacity()
  {
    return 0;
  }
  
  public int getFullCapacity(int paramInt)
  {
    return 0;
  }
  
  public int getIndex()
  {
    return 0;
  }
  
  public int getRelativeCapacityPercentage()
  {
    return 0;
  }
  
  public int getRelativeCapacityPercentage(int paramInt)
  {
    return 0;
  }
  
  public int getRemainCapacity()
  {
    return 0;
  }
  
  public int getRemainCapacity(int paramInt)
  {
    return 0;
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public int getSenderId()
  {
    return 0;
  }
  
  public int getSenderType()
  {
    return 0;
  }
  
  public long getStatus()
  {
    return 277694576L;
  }
  
  public int getTemperature()
  {
    return 0;
  }
  
  public int getTemperature(int paramInt)
  {
    return 0;
  }
  
  public long getVersion()
  {
    return 277694592L;
  }
  
  public int getVoltage()
  {
    return 0;
  }
  
  public int getVoltage(int paramInt)
  {
    return 0;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return super.isChanged(paramArrayOfByte);
  }
  
  public boolean isPushLosed(int paramInt)
  {
    return false;
  }
  
  public DataSmartBatteryGetPushDynamicData setContinuePush(boolean paramBoolean)
  {
    this.isStopPush = paramBoolean;
    return this;
  }
  
  public DataSmartBatteryGetPushDynamicData setIndex(int paramInt)
  {
    this.index = paramInt;
    return this;
  }
  
  public DataSmartBatteryGetPushDynamicData setPushFreq(int paramInt)
  {
    this.pushFreq = paramInt;
    return this;
  }
  
  /* Error */
  protected void setPushLose(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void setPushRecPack(dji.midware.data.packages.P3.Pack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataSmartBatteryGetPushDynamicData setRequestPush(boolean paramBoolean)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSmartBatteryGetPushDynamicData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */