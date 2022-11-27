package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcSetAppSpecialControl
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcSetAppSpecialControl instance;
  private CmdType mCmdType = CmdType.SHIELD_CUSTOMKEY;
  private byte mValue = 0;
  
  public static DataRcSetAppSpecialControl getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSetAppSpecialControl();
      }
      DataRcSetAppSpecialControl localDataRcSetAppSpecialControl = instance;
      return localDataRcSetAppSpecialControl;
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
  
  public CmdType getCmdType()
  {
    return null;
  }
  
  public int getValue()
  {
    return 0;
  }
  
  public boolean isCrack()
  {
    return false;
  }
  
  public DataRcSetAppSpecialControl setCmdType(CmdType paramCmdType)
  {
    this.mCmdType = paramCmdType;
    return this;
  }
  
  public DataRcSetAppSpecialControl setValue(byte paramByte)
  {
    this.mValue = paramByte;
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
  
  public static enum CmdType
  {
    private final int data;
    
    static
    {
      RC_VIBRATE = new CmdType("RC_VIBRATE", 1, 2);
      SET_RC_CRACK = new CmdType("SET_RC_CRACK", 2, 5);
      GET_RC_CRACK = new CmdType("GET_RC_CRACK", 3, 6);
      SET_GIMBAL_CONTROL = new CmdType("SET_GIMBAL_CONTROL", 4, 9);
      SET_AIRCRAFT_TYPE = new CmdType("SET_AIRCRAFT_TYPE", 5, 14);
      GET_AIRCRAFT_TYPE = new CmdType("GET_AIRCRAFT_TYPE", 6, 15);
      CmdType localCmdType = new CmdType("OTHER", 7, 100);
      OTHER = localCmdType;
      $VALUES = new CmdType[] { SHIELD_CUSTOMKEY, RC_VIBRATE, SET_RC_CRACK, GET_RC_CRACK, SET_GIMBAL_CONTROL, SET_AIRCRAFT_TYPE, GET_AIRCRAFT_TYPE, localCmdType };
    }
    
    private CmdType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CmdType find(int paramInt)
    {
      CmdType localCmdType1 = SHIELD_CUSTOMKEY;
      CmdType[] arrayOfCmdType = values();
      int j = arrayOfCmdType.length;
      int i = 0;
      while (i < j)
      {
        CmdType localCmdType2 = arrayOfCmdType[i];
        if (localCmdType2._equals(paramInt)) {
          return localCmdType2;
        }
        i += 1;
      }
      return localCmdType1;
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
  
  public static enum RcAircraftType
  {
    private final int data;
    
    static
    {
      IN2 = new RcAircraftType("IN2", 5, 6);
      RcAircraftType localRcAircraftType = new RcAircraftType("OTHER", 6, 100);
      OTHER = localRcAircraftType;
      $VALUES = new RcAircraftType[] { P3_ADVANCED, P3_PROFESSIONAL, P4, P4_ADVANCED, P4_PROFESSIONAL, IN2, localRcAircraftType };
    }
    
    private RcAircraftType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static RcAircraftType find(int paramInt)
    {
      RcAircraftType localRcAircraftType1 = P3_ADVANCED;
      RcAircraftType[] arrayOfRcAircraftType = values();
      int j = arrayOfRcAircraftType.length;
      int i = 0;
      while (i < j)
      {
        RcAircraftType localRcAircraftType2 = arrayOfRcAircraftType[i];
        if (localRcAircraftType2._equals(paramInt)) {
          return localRcAircraftType2;
        }
        i += 1;
      }
      return localRcAircraftType1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetAppSpecialControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */