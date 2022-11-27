package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSetGetVerPhone
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycSetGetVerPhone mInstance;
  private VerPhoneCmdType mCmdType = VerPhoneCmdType.GET;
  private String phone = "";
  private int phoneFlag = 0;
  private int time = 0;
  
  private boolean checkCrc()
  {
    return false;
  }
  
  public static DataFlycSetGetVerPhone getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataFlycSetGetVerPhone();
      }
      DataFlycSetGetVerPhone localDataFlycSetGetVerPhone = mInstance;
      return localDataFlycSetGetVerPhone;
    }
    finally {}
  }
  
  private byte[] getPhoneByte()
  {
    return null;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getFlagTime()
  {
    return 0;
  }
  
  public String getPhone()
  {
    return null;
  }
  
  public FlycPhoneStatus getPhoneFlag()
  {
    return null;
  }
  
  public void setCmdType(VerPhoneCmdType paramVerPhoneCmdType)
  {
    this.mCmdType = paramVerPhoneCmdType;
  }
  
  public void setFlagTime(int paramInt)
  {
    this.time = paramInt;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setPhoneFlag(FlycPhoneStatus paramFlycPhoneStatus)
  {
    this.phoneFlag = paramFlycPhoneStatus.data;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum FlycPhoneStatus
  {
    int data = 0;
    
    static
    {
      NeedBind = new FlycPhoneStatus("NeedBind", 2, 172);
      FlycPhoneStatus localFlycPhoneStatus = new FlycPhoneStatus("Unknown", 3, 170);
      Unknown = localFlycPhoneStatus;
      $VALUES = new FlycPhoneStatus[] { BindOk, NotBind, NeedBind, localFlycPhoneStatus };
    }
    
    private FlycPhoneStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FlycPhoneStatus find(int paramInt)
    {
      FlycPhoneStatus localFlycPhoneStatus = Unknown;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i].data == paramInt) {
          return values()[i];
        }
        i += 1;
      }
      return localFlycPhoneStatus;
    }
  }
  
  public static enum VerPhoneCmdType
  {
    public int data = 0;
    
    static
    {
      VerPhoneCmdType localVerPhoneCmdType = new VerPhoneCmdType("SET", 1, 1);
      SET = localVerPhoneCmdType;
      $VALUES = new VerPhoneCmdType[] { GET, localVerPhoneCmdType };
    }
    
    private VerPhoneCmdType(int paramInt)
    {
      this.data = paramInt;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSetGetVerPhone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */