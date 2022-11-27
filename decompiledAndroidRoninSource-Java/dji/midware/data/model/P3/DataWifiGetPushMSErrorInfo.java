package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataWifiGetPushMSErrorInfo
  extends DataBase
{
  private static DataWifiGetPushMSErrorInfo mInstance;
  
  public static DataWifiGetPushMSErrorInfo getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiGetPushMSErrorInfo();
      }
      DataWifiGetPushMSErrorInfo localDataWifiGetPushMSErrorInfo = mInstance;
      return localDataWifiGetPushMSErrorInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public DataRcSetMaster.MODE getRcType()
  {
    return null;
  }
  
  public boolean hasError()
  {
    return false;
  }
  
  public boolean isCountryCodeSetted()
  {
    return false;
  }
  
  public boolean isSlaveRelatedMaster()
  {
    return false;
  }
  
  public boolean isSupportedMSCurCountry()
  {
    return false;
  }
  
  public boolean isWifiAuthSuccess()
  {
    return false;
  }
  
  public boolean isWifiFreqChannelSetted()
  {
    return false;
  }
  
  public boolean isWifiMacSetted()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiGetPushMSErrorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */