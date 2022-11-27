package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;

public class DataRcGetSlaveMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcGetSlaveMode instance;
  private ArrayList<DataRcSetSlaveMode.SlaveCustomModel> arrayList;
  private DataRcSetSlaveMode.ControlMode controlMode;
  
  public static DataRcGetSlaveMode getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetSlaveMode();
      }
      DataRcGetSlaveMode localDataRcGetSlaveMode = instance;
      return localDataRcGetSlaveMode;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public ArrayList<DataRcSetSlaveMode.SlaveCustomModel> getChannels()
  {
    return null;
  }
  
  public DataRcSetSlaveMode.ControlMode getControlType()
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetSlaveMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */