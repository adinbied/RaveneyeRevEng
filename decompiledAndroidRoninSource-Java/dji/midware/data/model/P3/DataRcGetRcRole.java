package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcGetRcRole
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcGetRcRole instance;
  
  public static DataRcGetRcRole getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetRcRole();
      }
      DataRcGetRcRole localDataRcGetRcRole = instance;
      return localDataRcGetRcRole;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public RcRole getRole()
  {
    return null;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum RcRole
  {
    private int data;
    
    static
    {
      MAIN_CONTROL_SUB = new RcRole("MAIN_CONTROL_SUB", 2, 2);
      SLAVE_CONTROL_SUB = new RcRole("SLAVE_CONTROL_SUB", 3, 3);
      RcRole localRcRole = new RcRole("OTHER", 4, 10);
      OTHER = localRcRole;
      $VALUES = new RcRole[] { MAIN_CONTROL, SLAVE_CONTROL, MAIN_CONTROL_SUB, SLAVE_CONTROL_SUB, localRcRole };
    }
    
    private RcRole(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static RcRole find(int paramInt)
    {
      RcRole localRcRole = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localRcRole;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetRcRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */