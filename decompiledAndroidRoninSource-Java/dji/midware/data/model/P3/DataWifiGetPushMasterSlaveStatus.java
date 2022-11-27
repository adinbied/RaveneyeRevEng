package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataWifiGetPushMasterSlaveStatus
  extends DataBase
{
  private static DataWifiGetPushMasterSlaveStatus mInstance;
  private String mAuthCode;
  private String mConnectState;
  private String mFreqPoint;
  private String mMasterId;
  private String mRecStatus;
  private String mRecvFreq;
  private String mRssi;
  private String mSendFreq;
  private String mSlaveId;
  private String mStatusMode;
  
  /* Error */
  private void extractInfo()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static DataWifiGetPushMasterSlaveStatus getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiGetPushMasterSlaveStatus();
      }
      DataWifiGetPushMasterSlaveStatus localDataWifiGetPushMasterSlaveStatus = mInstance;
      return localDataWifiGetPushMasterSlaveStatus;
    }
    finally {}
  }
  
  private String getStatusString()
  {
    return null;
  }
  
  protected void doPack() {}
  
  public String getAuthCode()
  {
    return this.mAuthCode;
  }
  
  public String getConnectState()
  {
    return this.mConnectState;
  }
  
  public String getFreqPoint()
  {
    return this.mFreqPoint;
  }
  
  public String getMasterId()
  {
    return this.mMasterId;
  }
  
  public String getRecvFreq()
  {
    return this.mRecvFreq;
  }
  
  public String getRssi()
  {
    return this.mRssi;
  }
  
  public String getSendFreq()
  {
    return this.mSendFreq;
  }
  
  public String getSlaveId()
  {
    return this.mSlaveId;
  }
  
  public DataRcSetMaster.MODE getStatusMode()
  {
    return null;
  }
  
  protected void post()
  {
    extractInfo();
    super.post();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiGetPushMasterSlaveStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */