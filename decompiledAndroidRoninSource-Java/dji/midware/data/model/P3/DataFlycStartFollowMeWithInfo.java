package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycStartFollowMeWithInfo
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycStartFollowMeWithInfo instance;
  private FOLLOWMODE followMode = FOLLOWMODE.Relative_mode;
  private short mAltitude = 0;
  private int mAppSource = 1;
  private short mHeading = 0;
  private int mSensitivity = 0;
  private double mUserLatitude;
  private double mUserLongitude;
  private YAWMODE yawMode = YAWMODE.Use_Remote_Controll;
  
  public static DataFlycStartFollowMeWithInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycStartFollowMeWithInfo();
      }
      DataFlycStartFollowMeWithInfo localDataFlycStartFollowMeWithInfo = instance;
      return localDataFlycStartFollowMeWithInfo;
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
  
  public int getResult()
  {
    return 0;
  }
  
  public DataFlycStartFollowMeWithInfo setAltitude(short paramShort)
  {
    this.mAltitude = paramShort;
    return this;
  }
  
  public DataFlycStartFollowMeWithInfo setFollowMode(FOLLOWMODE paramFOLLOWMODE)
  {
    this.followMode = paramFOLLOWMODE;
    return this;
  }
  
  public DataFlycStartFollowMeWithInfo setHeading(short paramShort)
  {
    this.mHeading = paramShort;
    return this;
  }
  
  public DataFlycStartFollowMeWithInfo setSensitivity(int paramInt)
  {
    this.mSensitivity = paramInt;
    return this;
  }
  
  public DataFlycStartFollowMeWithInfo setUserLatitude(double paramDouble)
  {
    this.mUserLatitude = paramDouble;
    return this;
  }
  
  public DataFlycStartFollowMeWithInfo setUserLongitude(double paramDouble)
  {
    this.mUserLongitude = paramDouble;
    return this;
  }
  
  public DataFlycStartFollowMeWithInfo setYawMode(YAWMODE paramYAWMODE)
  {
    this.yawMode = paramYAWMODE;
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
  
  public static enum FOLLOWMODE
  {
    private int data;
    
    static
    {
      FOLLOWMODE localFOLLOWMODE = new FOLLOWMODE("Smart_mode", 2, 2);
      Smart_mode = localFOLLOWMODE;
      $VALUES = new FOLLOWMODE[] { Relative_mode, Route_mode, localFOLLOWMODE };
    }
    
    private FOLLOWMODE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FOLLOWMODE find(int paramInt)
    {
      FOLLOWMODE localFOLLOWMODE = Relative_mode;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFOLLOWMODE;
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
  
  public static enum YAWMODE
  {
    private int data;
    
    static
    {
      YAWMODE localYAWMODE = new YAWMODE("Use_Remote_Controll", 1, 1);
      Use_Remote_Controll = localYAWMODE;
      $VALUES = new YAWMODE[] { Point_To_Target, localYAWMODE };
    }
    
    private YAWMODE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static YAWMODE find(int paramInt)
    {
      YAWMODE localYAWMODE = Point_To_Target;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localYAWMODE;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycStartFollowMeWithInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */