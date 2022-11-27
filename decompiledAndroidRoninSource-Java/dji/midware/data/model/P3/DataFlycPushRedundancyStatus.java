package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycPushRedundancyStatus
  extends DataBase
{
  private static DataFlycPushRedundancyStatus mInstance;
  
  public static DataFlycPushRedundancyStatus getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataFlycPushRedundancyStatus();
      }
      DataFlycPushRedundancyStatus localDataFlycPushRedundancyStatus = mInstance;
      return localDataFlycPushRedundancyStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public DataFlycRedundancyStatus.RS_CMD_TYPE getCmdType()
  {
    return null;
  }
  
  public DataFlycRedundancyStatus.IMUStatus getIMUStatus()
  {
    return null;
  }
  
  public RedundancySwitchInfo getSwitchInfo()
  {
    return null;
  }
  
  public static class RedundancySwitchInfo
  {
    public long dstErrCode;
    public int dstImuIndex;
    public int id;
    public int reqID;
    public int resultCode;
    public long srcErrCode;
    public int srcImuIndex;
    public long time;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycPushRedundancyStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */