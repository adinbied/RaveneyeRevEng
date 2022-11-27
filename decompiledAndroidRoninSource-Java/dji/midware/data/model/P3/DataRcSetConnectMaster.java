package dji.midware.data.model.P3;

import dji.midware.data.config.P3.Ccode;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcSetConnectMaster
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcSetConnectMaster instance;
  private DataRcGetSlaveList.RcModel master;
  
  public static DataRcSetConnectMaster getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSetConnectMaster();
      }
      DataRcSetConnectMaster localDataRcSetConnectMaster = instance;
      return localDataRcSetConnectMaster;
    }
    finally {}
  }
  
  /* Error */
  protected void LogPack(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public RcConnectError getError(Ccode paramCcode)
  {
    return RcConnectError.find(paramCcode.relValue());
  }
  
  public DataRcSetConnectMaster setMaster(DataRcGetSlaveList.RcModel paramRcModel)
  {
    this.master = paramRcModel;
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
  
  public static enum RcConnectError
  {
    private int data;
    
    static
    {
      Refused = new RcConnectError("Refused", 1, 2);
      Exceed = new RcConnectError("Exceed", 2, 3);
      TimeOut = new RcConnectError("TimeOut", 3, 4);
      RcConnectError localRcConnectError = new RcConnectError("OTHER", 4, 100);
      OTHER = localRcConnectError;
      $VALUES = new RcConnectError[] { WrongPwd, Refused, Exceed, TimeOut, localRcConnectError };
    }
    
    private RcConnectError(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static RcConnectError find(int paramInt)
    {
      RcConnectError localRcConnectError = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localRcConnectError;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetConnectMaster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */