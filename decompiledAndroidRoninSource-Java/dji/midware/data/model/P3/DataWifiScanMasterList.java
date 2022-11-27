package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;
import java.util.List;

public class DataWifiScanMasterList
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataWifiScanMasterList mInstance;
  private List<ScannedMasterInfo> mMasterInfo = new ArrayList();
  
  public static DataWifiScanMasterList getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiScanMasterList();
      }
      DataWifiScanMasterList localDataWifiScanMasterList = mInstance;
      return localDataWifiScanMasterList;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public List<ScannedMasterInfo> getMasterInfo()
  {
    return this.mMasterInfo;
  }
  
  /* Error */
  public void interrupt()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class ScannedMasterInfo
  {
    private String mFreeOrBusy;
    private String mFreqPoint;
    private String mMasterId;
    private String mRssi;
    
    public String getFreqPoint()
    {
      return this.mFreqPoint;
    }
    
    public String getMasterId()
    {
      return this.mMasterId;
    }
    
    public String getRssi()
    {
      return this.mRssi;
    }
    
    public boolean isFree()
    {
      return false;
    }
    
    void setFreeOrBusy(String paramString)
    {
      this.mFreeOrBusy = paramString;
    }
    
    void setFreqPoint(String paramString)
    {
      this.mFreqPoint = paramString;
    }
    
    void setMasterId(String paramString)
    {
      this.mMasterId = paramString;
    }
    
    void setRssi(String paramString)
    {
      this.mRssi = paramString;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiScanMasterList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */