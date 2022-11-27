package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.packages.P3.Pack;

public class DataOsdGetHdvtPushException
  extends DataBase
{
  private static DataOsdGetHdvtPushException instance;
  private boolean isChannelEncryptException = false;
  private boolean isGndRfException = false;
  private boolean isUavRfException = false;
  
  public static DataOsdGetHdvtPushException getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetHdvtPushException();
      }
      DataOsdGetHdvtPushException localDataOsdGetHdvtPushException = instance;
      return localDataOsdGetHdvtPushException;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean getChannelEncryptStatus()
  {
    return this.isChannelEncryptException;
  }
  
  public boolean getGndRfStatus()
  {
    return this.isGndRfException;
  }
  
  public int getSenderType()
  {
    return this.pack.senderType;
  }
  
  public boolean getUavRfStatus()
  {
    return this.isUavRfException;
  }
  
  /* Error */
  protected void post()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetHdvtPushException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */