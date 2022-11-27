package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataOnBoardSdkGetIOState
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataOnBoardSdkGetIOState instance;
  private int iOIndex = 0;
  
  public static DataOnBoardSdkGetIOState getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOnBoardSdkGetIOState();
      }
      DataOnBoardSdkGetIOState localDataOnBoardSdkGetIOState = instance;
      return localDataOnBoardSdkGetIOState;
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
  
  public int getDutyRatio()
  {
    return 0;
  }
  
  public int getFrequency()
  {
    return 0;
  }
  
  public DataOnBoardSdkSetIOState.GPIOMode getGPIOMode()
  {
    return null;
  }
  
  public DataOnBoardSdkSetIOState.IOProperty getProperty()
  {
    return null;
  }
  
  public boolean hasInitialized()
  {
    return false;
  }
  
  public boolean isHighElectricLevel()
  {
    return false;
  }
  
  public DataOnBoardSdkGetIOState setIOIndex(int paramInt)
  {
    this.iOIndex = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOnBoardSdkGetIOState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */