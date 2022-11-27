package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycStartHotPointMissionWithInfo
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycStartHotPointMissionWithInfo instance;
  private double altitude;
  private float angleSpeed;
  private CAMERA_DIR cameraDir;
  private double latitude;
  private double longitude;
  private double radious;
  private ROTATION_DIR rotationDir;
  private TO_START_POINT_MODE toStartPointMode;
  private byte version = 0;
  
  public static DataFlycStartHotPointMissionWithInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycStartHotPointMissionWithInfo();
      }
      DataFlycStartHotPointMissionWithInfo localDataFlycStartHotPointMissionWithInfo = instance;
      return localDataFlycStartHotPointMissionWithInfo;
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
  
  public float getMaxRadius()
  {
    return 0.0F;
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public void printResult() {}
  
  public DataFlycStartHotPointMissionWithInfo setAltitude(double paramDouble)
  {
    this.altitude = paramDouble;
    return this;
  }
  
  public DataFlycStartHotPointMissionWithInfo setCameraDir(CAMERA_DIR paramCAMERA_DIR)
  {
    this.cameraDir = paramCAMERA_DIR;
    return this;
  }
  
  public DataFlycStartHotPointMissionWithInfo setLatitude(double paramDouble)
  {
    this.latitude = paramDouble;
    return this;
  }
  
  public DataFlycStartHotPointMissionWithInfo setLongitude(double paramDouble)
  {
    this.longitude = paramDouble;
    return this;
  }
  
  public DataFlycStartHotPointMissionWithInfo setRadious(double paramDouble)
  {
    this.radious = paramDouble;
    return this;
  }
  
  public DataFlycStartHotPointMissionWithInfo setRotationDir(ROTATION_DIR paramROTATION_DIR)
  {
    this.rotationDir = paramROTATION_DIR;
    return this;
  }
  
  public DataFlycStartHotPointMissionWithInfo setToStartPointMode(TO_START_POINT_MODE paramTO_START_POINT_MODE)
  {
    this.toStartPointMode = paramTO_START_POINT_MODE;
    return this;
  }
  
  public DataFlycStartHotPointMissionWithInfo setVelocity(float paramFloat)
  {
    this.angleSpeed = paramFloat;
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
  
  public static enum CAMERA_DIR
  {
    private int data;
    
    static
    {
      Forwards_Hot_Point = new CAMERA_DIR("Forwards_Hot_Point", 1, 1);
      Backforwards_Hot_Point = new CAMERA_DIR("Backforwards_Hot_Point", 2, 2);
      Remote_Control = new CAMERA_DIR("Remote_Control", 3, 3);
      CAMERA_DIR localCAMERA_DIR = new CAMERA_DIR("INVERSE_DIR_AS_SPEED", 4, 5);
      INVERSE_DIR_AS_SPEED = localCAMERA_DIR;
      $VALUES = new CAMERA_DIR[] { SAME_DIR_AS_SPEED, Forwards_Hot_Point, Backforwards_Hot_Point, Remote_Control, localCAMERA_DIR };
    }
    
    private CAMERA_DIR(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CAMERA_DIR find(int paramInt)
    {
      CAMERA_DIR localCAMERA_DIR = SAME_DIR_AS_SPEED;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localCAMERA_DIR;
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
  
  public static enum ROTATION_DIR
  {
    private int data;
    
    static
    {
      ROTATION_DIR localROTATION_DIR = new ROTATION_DIR("Clockwise", 1, 1);
      Clockwise = localROTATION_DIR;
      $VALUES = new ROTATION_DIR[] { Anti_Clockwise, localROTATION_DIR };
    }
    
    private ROTATION_DIR(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ROTATION_DIR find(int paramInt)
    {
      ROTATION_DIR localROTATION_DIR = Anti_Clockwise;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localROTATION_DIR;
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
  
  public static enum TO_START_POINT_MODE
  {
    private int data;
    
    static
    {
      Ease = new TO_START_POINT_MODE("Ease", 3, 3);
      TO_START_POINT_MODE localTO_START_POINT_MODE = new TO_START_POINT_MODE("Initi", 4, 4);
      Initi = localTO_START_POINT_MODE;
      $VALUES = new TO_START_POINT_MODE[] { North, South, West, Ease, localTO_START_POINT_MODE };
    }
    
    private TO_START_POINT_MODE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TO_START_POINT_MODE find(int paramInt)
    {
      TO_START_POINT_MODE localTO_START_POINT_MODE = Initi;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localTO_START_POINT_MODE;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycStartHotPointMissionWithInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */