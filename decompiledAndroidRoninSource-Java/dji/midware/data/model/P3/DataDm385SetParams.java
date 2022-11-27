package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataDm385SetParams
  extends DataBase
  implements DJIDataSyncListener
{
  private DM385CmdId cmdId;
  private int value;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataDm385SetParams set(DM385CmdId paramDM385CmdId, int paramInt)
  {
    this.cmdId = paramDM385CmdId;
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
  
  public static enum DM385CmdId
  {
    private int data;
    
    static
    {
      DM385CmdId localDM385CmdId = new DM385CmdId("OTHER", 1, 100);
      OTHER = localDM385CmdId;
      $VALUES = new DM385CmdId[] { SetTransmissionMode, localDM385CmdId };
    }
    
    private DM385CmdId(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DM385CmdId find(int paramInt)
    {
      DM385CmdId localDM385CmdId = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDM385CmdId;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataDm385SetParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */