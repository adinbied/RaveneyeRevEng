package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;

public class DataRcGetWifiFreqInfo
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcGetWifiFreqInfo mCcInstance;
  private static DataRcGetWifiFreqInfo mSkyCcInstance;
  private CommonType mCommonType = CommonType.Support;
  public DeviceType mDeviceType;
  
  public static DataRcGetWifiFreqInfo getCcInstance()
  {
    try
    {
      if (mCcInstance == null)
      {
        localDataRcGetWifiFreqInfo = new DataRcGetWifiFreqInfo();
        mCcInstance = localDataRcGetWifiFreqInfo;
        localDataRcGetWifiFreqInfo.mCommonType = CommonType.COUNTRY_CODE;
      }
      DataRcGetWifiFreqInfo localDataRcGetWifiFreqInfo = mCcInstance;
      return localDataRcGetWifiFreqInfo;
    }
    finally {}
  }
  
  public static DataRcGetWifiFreqInfo getSkyCcInstance()
  {
    try
    {
      if (mSkyCcInstance == null)
      {
        localDataRcGetWifiFreqInfo = new DataRcGetWifiFreqInfo();
        mSkyCcInstance = localDataRcGetWifiFreqInfo;
        localDataRcGetWifiFreqInfo.mCommonType = CommonType.COUNTRY_CODE;
        if (DJIProductManager.getInstance().getType().equals(ProductType.Mammoth)) {
          mSkyCcInstance.mDeviceType = DeviceType.WIFI;
        }
      }
      DataRcGetWifiFreqInfo localDataRcGetWifiFreqInfo = mSkyCcInstance;
      return localDataRcGetWifiFreqInfo;
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
  
  public CommonType getCommonType()
  {
    return this.mCommonType;
  }
  
  public String getCountryCode()
  {
    return null;
  }
  
  public int[] getFreqModeRange()
  {
    return null;
  }
  
  public ArrayList<Integer> getFreqModeSupport()
  {
    return null;
  }
  
  public boolean isGetted()
  {
    return this._recData != null;
  }
  
  public DataRcGetWifiFreqInfo setCommonType(CommonType paramCommonType)
  {
    this.mCommonType = paramCommonType;
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
  
  public static enum CommonType
  {
    static
    {
      FM_24_RANGE = new CommonType("FM_24_RANGE", 2);
      FM_57_RANGE = new CommonType("FM_57_RANGE", 3);
      CommonType localCommonType = new CommonType("FM_58_RANGE", 4);
      FM_58_RANGE = localCommonType;
      $VALUES = new CommonType[] { COUNTRY_CODE, Support, FM_24_RANGE, FM_57_RANGE, localCommonType };
    }
    
    private CommonType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetWifiFreqInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */