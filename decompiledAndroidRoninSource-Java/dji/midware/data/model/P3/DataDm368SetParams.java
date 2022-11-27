package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataDm368SetParams
  extends DataBase
  implements DJIDataSyncListener
{
  private DM368CmdId cmdId;
  private int value;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataDm368SetParams set(DM368CmdId paramDM368CmdId, int paramInt)
  {
    this.cmdId = paramDM368CmdId;
    this.value = paramInt;
    return this;
  }
  
  /* Error */
  protected void setPushRecPack(dji.midware.data.packages.P3.Pack arg1)
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
  
  public static enum DM368CmdId
  {
    private int data;
    
    static
    {
      EncodeMode = new DM368CmdId("EncodeMode", 3, 6);
      BandwidthPercentage = new DM368CmdId("BandwidthPercentage", 4, 7);
      RevertImage = new DM368CmdId("RevertImage", 5, 9);
      DM368CmdId localDM368CmdId = new DM368CmdId("OTHER", 6, 100);
      OTHER = localDM368CmdId;
      $VALUES = new DM368CmdId[] { DisableLiveStream, SetEncodeFormat, SetTransmissionMode, EncodeMode, BandwidthPercentage, RevertImage, localDM368CmdId };
    }
    
    private DM368CmdId(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DM368CmdId find(int paramInt)
    {
      DM368CmdId localDM368CmdId = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDM368CmdId;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataDm368SetParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */