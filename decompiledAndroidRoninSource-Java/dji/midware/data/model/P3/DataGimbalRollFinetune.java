package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalRollFinetune
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataGimbalRollFinetune instance;
  private int mAxis = FineTuneAxis.ROLL.cmdValue;
  private byte mData = 0;
  private int mRepeatTimes = -1;
  private int mTimeOut = -1;
  
  public static DataGimbalRollFinetune getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalRollFinetune();
      }
      DataGimbalRollFinetune localDataGimbalRollFinetune = instance;
      return localDataGimbalRollFinetune;
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
  
  public DataGimbalRollFinetune setFineTuneAxis(FineTuneAxis paramFineTuneAxis)
  {
    this.mAxis = paramFineTuneAxis.cmdValue;
    return this;
  }
  
  public DataGimbalRollFinetune setFineTuneValue(byte paramByte)
  {
    this.mData = paramByte;
    return this;
  }
  
  public void setRepeatTimes(int paramInt)
  {
    this.mRepeatTimes = paramInt;
  }
  
  public void setTimeOut(int paramInt)
  {
    this.mTimeOut = paramInt;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum FineTuneAxis
  {
    private final int cmdValue;
    
    static
    {
      PITCH = new FineTuneAxis("PITCH", 1, 2);
      FineTuneAxis localFineTuneAxis = new FineTuneAxis("YAW", 2, 4);
      YAW = localFineTuneAxis;
      $VALUES = new FineTuneAxis[] { ROLL, PITCH, localFineTuneAxis };
    }
    
    private FineTuneAxis(int paramInt)
    {
      this.cmdValue = paramInt;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalRollFinetune.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */