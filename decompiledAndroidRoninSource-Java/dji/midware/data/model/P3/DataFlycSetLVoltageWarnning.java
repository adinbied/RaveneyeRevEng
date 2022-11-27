package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSetLVoltageWarnning
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycSetLVoltageWarnning instance;
  private boolean isNeedGoHome;
  private DataFlycGetVoltageWarnning.WarnningLevel level;
  private int value;
  
  public static DataFlycSetLVoltageWarnning getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycSetLVoltageWarnning();
      }
      DataFlycSetLVoltageWarnning localDataFlycSetLVoltageWarnning = instance;
      return localDataFlycSetLVoltageWarnning;
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
  
  public void setIsNeedGoHome(boolean paramBoolean)
  {
    this.isNeedGoHome = paramBoolean;
  }
  
  public void setIsNeedLanding(boolean paramBoolean)
  {
    this.isNeedGoHome = paramBoolean;
  }
  
  public void setValue(int paramInt)
  {
    this.value = paramInt;
  }
  
  public void setWarnningLevel(DataFlycGetVoltageWarnning.WarnningLevel paramWarnningLevel)
  {
    this.level = paramWarnningLevel;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSetLVoltageWarnning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */