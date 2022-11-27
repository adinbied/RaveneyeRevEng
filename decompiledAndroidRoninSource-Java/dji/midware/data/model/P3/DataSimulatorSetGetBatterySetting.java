package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSimulatorSetGetBatterySetting
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSimulatorSetGetBatterySetting instance;
  private int mCellNum;
  private int mCellVoltage;
  private int mCycleCnt;
  private int mDesignCapacity;
  private int mErrorCnt;
  private int mFlag;
  private int mInitialCapPer;
  private float mInitialTemperature;
  private float mInternalResistance;
  private int mManufactureDate;
  private int mSequenceNum;
  private float mStandbyCurrent;
  
  public static DataSimulatorSetGetBatterySetting getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataSimulatorSetGetBatterySetting();
      }
      DataSimulatorSetGetBatterySetting localDataSimulatorSetGetBatterySetting = instance;
      return localDataSimulatorSetGetBatterySetting;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataSimulatorSetGetBatterySetting setAckFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFlag |= 0x1;
      return this;
    }
    this.mFlag |= 0x0;
    return this;
  }
  
  public void setmCellNum(int paramInt)
  {
    this.mCellNum = paramInt;
  }
  
  public void setmCellVoltage(int paramInt)
  {
    this.mCellVoltage = paramInt;
  }
  
  public void setmCycleCnt(int paramInt)
  {
    this.mCycleCnt = paramInt;
  }
  
  public void setmDesignCapacity(int paramInt)
  {
    this.mDesignCapacity = paramInt;
  }
  
  public void setmErrorCnt(int paramInt)
  {
    this.mErrorCnt = paramInt;
  }
  
  public void setmInitialCapPer(int paramInt)
  {
    this.mInitialCapPer = paramInt;
  }
  
  public void setmInitialTemperature(float paramFloat)
  {
    this.mInitialTemperature = paramFloat;
  }
  
  public void setmInternalResistance(float paramFloat)
  {
    this.mInternalResistance = paramFloat;
  }
  
  public void setmManufactureDate(int paramInt)
  {
    this.mManufactureDate = paramInt;
  }
  
  public void setmSequenceNum(int paramInt)
  {
    this.mSequenceNum = paramInt;
  }
  
  public void setmStandbyCurrent(float paramFloat)
  {
    this.mStandbyCurrent = paramFloat;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSimulatorSetGetBatterySetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */