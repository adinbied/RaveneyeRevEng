package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.HashMap;

public class DataDm368GetGParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataDm368GetGParams instance;
  private DataDm368SetGParams.CmdId cmdId;
  private boolean isGetPhoneCharge = false;
  private boolean isLb2 = false;
  private HashMap<DataDm368SetGParams.CmdId, Integer> mDm368GHm = new HashMap();
  
  public static DataDm368GetGParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataDm368GetGParams();
      }
      DataDm368GetGParams localDataDm368GetGParams = instance;
      return localDataDm368GetGParams;
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
  
  public int get720PFps()
  {
    return 0;
  }
  
  public int getChargingMode()
  {
    return 0;
  }
  
  public int getHDMIFormat()
  {
    return 0;
  }
  
  public boolean getIsDisableUpgradeVoice()
  {
    return false;
  }
  
  public boolean getIsDouble()
  {
    return false;
  }
  
  public boolean getIsShowOsd()
  {
    return false;
  }
  
  public int getOsdMarginBottom()
  {
    return 0;
  }
  
  public int getOsdMarginLeft()
  {
    return 0;
  }
  
  public int getOsdMarginRight()
  {
    return 0;
  }
  
  public int getOsdMarginTop()
  {
    return 0;
  }
  
  public int getOutputDevice()
  {
    return 0;
  }
  
  public boolean getOutputEnable()
  {
    return false;
  }
  
  public int getOutputLocation()
  {
    return 0;
  }
  
  public int getOutputMode()
  {
    return 0;
  }
  
  public DataDm368SetGParams.PhoneChargeConfig getPhoneChargeConfig()
  {
    return null;
  }
  
  public int getSDIFormat()
  {
    return 0;
  }
  
  public boolean getUnit()
  {
    return false;
  }
  
  public DataDm368GetGParams setGetPhoneCharge(boolean paramBoolean)
  {
    this.isGetPhoneCharge = paramBoolean;
    return this;
  }
  
  /* Error */
  public void setRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataDm368GetGParams setType(boolean paramBoolean)
  {
    this.isLb2 = paramBoolean;
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
  
  public int toInt(Object paramObject)
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataDm368GetGParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */