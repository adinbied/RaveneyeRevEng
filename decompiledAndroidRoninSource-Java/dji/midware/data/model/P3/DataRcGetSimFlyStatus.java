package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcGetSimFlyStatus
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcGetSimFlyStatus instance;
  
  public static DataRcGetSimFlyStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetSimFlyStatus();
      }
      DataRcGetSimFlyStatus localDataRcGetSimFlyStatus = instance;
      return localDataRcGetSimFlyStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public FlySimStatus getFlySimStatus()
  {
    return null;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum FlySimStatus
  {
    private int mData = 0;
    
    static
    {
      FlySimStatus localFlySimStatus = new FlySimStatus("FLY_SIM", 1, 1);
      FLY_SIM = localFlySimStatus;
      $VALUES = new FlySimStatus[] { NORMAL, localFlySimStatus };
    }
    
    private FlySimStatus(int paramInt)
    {
      this.mData = paramInt;
    }
    
    private boolean belongsTo(int paramInt)
    {
      return this.mData == paramInt;
    }
    
    public static FlySimStatus ofData(int paramInt)
    {
      FlySimStatus[] arrayOfFlySimStatus = values();
      int j = arrayOfFlySimStatus.length;
      int i = 0;
      while (i < j)
      {
        FlySimStatus localFlySimStatus = arrayOfFlySimStatus[i];
        if (localFlySimStatus.belongsTo(paramInt)) {
          return localFlySimStatus;
        }
        i += 1;
      }
      return NORMAL;
    }
    
    public int value()
    {
      return this.mData;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetSimFlyStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */