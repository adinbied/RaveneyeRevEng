package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;

public class DataRcGetControlMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcGetControlMode instance;
  private ArrayList<DataRcSetControlMode.ChannelCustomModel> arrayList;
  private DataRcSetControlMode.ControlMode controlMode;
  
  public static DataRcGetControlMode getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetControlMode();
      }
      DataRcGetControlMode localDataRcGetControlMode = instance;
      return localDataRcGetControlMode;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public ArrayList<DataRcSetControlMode.ChannelCustomModel> getChannels()
  {
    return null;
  }
  
  public DataRcSetControlMode.ControlMode getControlType()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetControlMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */