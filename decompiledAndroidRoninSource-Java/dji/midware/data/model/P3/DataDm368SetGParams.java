package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataDm368SetGParams
  extends DataBase
  implements DJIDataSyncListener
{
  private CmdId cmdId;
  private int value;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataDm368SetGParams set(CmdId paramCmdId, int paramInt)
  {
    this.cmdId = paramCmdId;
    this.value = paramInt;
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
  
  public static enum CmdId
  {
    private int data;
    
    static
    {
      Set720PFps = new CmdId("Set720PFps", 1, 3);
      SetOsdLeft = new CmdId("SetOsdLeft", 2, 4);
      SetOsdRight = new CmdId("SetOsdRight", 3, 5);
      SetOsdTop = new CmdId("SetOsdTop", 4, 6);
      SetOsdBottom = new CmdId("SetOsdBottom", 5, 7);
      ShowUnit = new CmdId("ShowUnit", 6, 9);
      ShowDouble = new CmdId("ShowDouble", 7, 10);
      SetOutputDevice = new CmdId("SetOutputDevice", 8, 12);
      SetHDMIFormat = new CmdId("SetHDMIFormat", 9, 13);
      SetSDIFormat = new CmdId("SetSDIFormat", 10, 15);
      SetOutputMode = new CmdId("SetOutputMode", 11, 16);
      SetOutputLoc = new CmdId("SetOutputLoc", 12, 17);
      SetOutputEnable = new CmdId("SetOutputEnable", 13, 18);
      AndroidPhoneCharge = new CmdId("AndroidPhoneCharge", 14, 23);
      DisableUpgradeSound = new CmdId("DisableUpgradeSound", 15, 26);
      CmdId localCmdId = new CmdId("OTHER", 16, 100);
      OTHER = localCmdId;
      $VALUES = new CmdId[] { ShowOsd, Set720PFps, SetOsdLeft, SetOsdRight, SetOsdTop, SetOsdBottom, ShowUnit, ShowDouble, SetOutputDevice, SetHDMIFormat, SetSDIFormat, SetOutputMode, SetOutputLoc, SetOutputEnable, AndroidPhoneCharge, DisableUpgradeSound, localCmdId };
    }
    
    private CmdId(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CmdId find(int paramInt)
    {
      CmdId localCmdId = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localCmdId;
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
  
  public static enum PhoneChargeConfig
  {
    private int data;
    
    static
    {
      HIGH_CURRENT = new PhoneChargeConfig("HIGH_CURRENT", 1, 1);
      PhoneChargeConfig localPhoneChargeConfig = new PhoneChargeConfig("OTHER", 2, 100);
      OTHER = localPhoneChargeConfig;
      $VALUES = new PhoneChargeConfig[] { SMALL_CURRENT, HIGH_CURRENT, localPhoneChargeConfig };
    }
    
    private PhoneChargeConfig(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static PhoneChargeConfig find(int paramInt)
    {
      PhoneChargeConfig localPhoneChargeConfig = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPhoneChargeConfig;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataDm368SetGParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */