package dji.midware.data.model.P3;

import dji.midware.data.model.common.DataAbstractGetPushActiveStatus;
import dji.midware.data.packages.P3.Pack;

public class DataRonin_batteryActiveStatus
  extends DataAbstractGetPushActiveStatus
{
  private static DataRonin_batteryActiveStatus instance;
  private int mIndexMultiBattery = 0;
  
  public static DataRonin_batteryActiveStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRonin_batteryActiveStatus();
      }
      DataRonin_batteryActiveStatus localDataRonin_batteryActiveStatus = instance;
      return localDataRonin_batteryActiveStatus;
    }
    finally {}
  }
  
  public int getSenderIndex()
  {
    return this.pack.senderId;
  }
  
  public DataRonin_batteryActiveStatus setIndexMultiBattery(int paramInt)
  {
    this.mIndexMultiBattery = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRonin_batteryActiveStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */