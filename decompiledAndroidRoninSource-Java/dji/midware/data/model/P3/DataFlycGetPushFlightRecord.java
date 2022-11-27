package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushFlightRecord
  extends DataBase
{
  private static DataFlycGetPushFlightRecord instance;
  public int result = 0;
  public int rpcAtti = 0;
  public int rpcId = 0;
  
  public static DataFlycGetPushFlightRecord getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushFlightRecord();
      }
      DataFlycGetPushFlightRecord localDataFlycGetPushFlightRecord = instance;
      return localDataFlycGetPushFlightRecord;
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
  
  public byte[] getCompressPackage()
  {
    return null;
  }
  
  public String getFileName()
  {
    return null;
  }
  
  public byte[] getFirstCompressPackage()
  {
    return null;
  }
  
  public int getRPCCommandId()
  {
    return 0;
  }
  
  public int getRPCSet()
  {
    return 0;
  }
  
  public boolean isWritingConfigFile()
  {
    return false;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushFlightRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */