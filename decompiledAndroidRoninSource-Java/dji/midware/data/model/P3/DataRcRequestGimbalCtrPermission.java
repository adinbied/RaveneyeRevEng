package dji.midware.data.model.P3;

import dji.midware.data.config.P3.Ccode;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcRequestGimbalCtrPermission
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcRequestGimbalCtrPermission instance;
  
  public static DataRcRequestGimbalCtrPermission getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcRequestGimbalCtrPermission();
      }
      DataRcRequestGimbalCtrPermission localDataRcRequestGimbalCtrPermission = instance;
      return localDataRcRequestGimbalCtrPermission;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public RcGimbalError getError(Ccode paramCcode)
  {
    return RcGimbalError.find(paramCcode.relValue());
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum RcGimbalError
  {
    private int data;
    
    static
    {
      Getted = new RcGimbalError("Getted", 2, 3);
      RcGimbalError localRcGimbalError = new RcGimbalError("OTHER", 3, 100);
      OTHER = localRcGimbalError;
      $VALUES = new RcGimbalError[] { Refused, TimeOut, Getted, localRcGimbalError };
    }
    
    private RcGimbalError(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static RcGimbalError find(int paramInt)
    {
      RcGimbalError localRcGimbalError = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localRcGimbalError;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcRequestGimbalCtrPermission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */