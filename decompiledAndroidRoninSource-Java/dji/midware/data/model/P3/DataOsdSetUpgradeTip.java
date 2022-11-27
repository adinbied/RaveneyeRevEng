package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataOsdSetUpgradeTip
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataOsdSetUpgradeTip instance;
  private UPGRADETIP mUpgradeTip = UPGRADETIP.START;
  
  public static DataOsdSetUpgradeTip getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdSetUpgradeTip();
      }
      DataOsdSetUpgradeTip localDataOsdSetUpgradeTip = instance;
      return localDataOsdSetUpgradeTip;
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
  
  public DataOsdSetUpgradeTip setUpgradeTip(UPGRADETIP paramUPGRADETIP)
  {
    this.mUpgradeTip = paramUPGRADETIP;
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
  
  public static enum UPGRADETIP
  {
    private int data;
    
    static
    {
      UPGRADETIP localUPGRADETIP = new UPGRADETIP("FAIL", 2, 3);
      FAIL = localUPGRADETIP;
      $VALUES = new UPGRADETIP[] { START, SUCCESS, localUPGRADETIP };
    }
    
    private UPGRADETIP(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static UPGRADETIP find(int paramInt)
    {
      UPGRADETIP localUPGRADETIP = START;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localUPGRADETIP;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdSetUpgradeTip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */