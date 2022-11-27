package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataGimbalControl
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataGimbalControl instance;
  private boolean isReset;
  private MODE mode;
  private int pitch;
  private int roll;
  private SOURCE source = SOURCE.APP_JOYSTICK;
  private int yaw;
  
  public static DataGimbalControl getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalControl();
      }
      DataGimbalControl localDataGimbalControl = instance;
      return localDataGimbalControl;
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
  
  public DataGimbalControl reset(boolean paramBoolean)
  {
    this.isReset = paramBoolean;
    return this;
  }
  
  public DataGimbalControl setMode(MODE paramMODE)
  {
    this.mode = paramMODE;
    return this;
  }
  
  public DataGimbalControl setPitch(int paramInt)
  {
    this.pitch = paramInt;
    return this;
  }
  
  public DataGimbalControl setRoll(int paramInt)
  {
    this.roll = paramInt;
    return this;
  }
  
  public DataGimbalControl setSource(SOURCE paramSOURCE)
  {
    this.source = paramSOURCE;
    return this;
  }
  
  public DataGimbalControl setYaw(int paramInt)
  {
    this.yaw = paramInt;
    return this;
  }
  
  /* Error */
  public void start()
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
  
  public static enum MODE
  {
    private int data;
    
    static
    {
      FPV = new MODE("FPV", 1, 1);
      YawFollow = new MODE("YawFollow", 2, 2);
      MODE localMODE = new MODE("OTHER", 3, 254);
      OTHER = localMODE;
      $VALUES = new MODE[] { YawNoFollow, FPV, YawFollow, localMODE };
    }
    
    private MODE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static MODE find(int paramInt)
    {
      MODE localMODE = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localMODE;
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
  
  public static enum SOURCE
  {
    private int data;
    
    static
    {
      REAL_JOYSTICK = new SOURCE("REAL_JOYSTICK", 1, 1);
      APP_JOYSTICK = new SOURCE("APP_JOYSTICK", 2, 2);
      MOTION = new SOURCE("MOTION", 3, 3);
      SOURCE localSOURCE = new SOURCE("GAMEPAD", 4, 4);
      GAMEPAD = localSOURCE;
      $VALUES = new SOURCE[] { RESERVED, REAL_JOYSTICK, APP_JOYSTICK, MOTION, localSOURCE };
    }
    
    private SOURCE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static SOURCE find(int paramInt)
    {
      SOURCE localSOURCE = RESERVED;
      SOURCE[] arrayOfSOURCE = values();
      int i = 0;
      while (i < arrayOfSOURCE.length)
      {
        if (arrayOfSOURCE[i]._equals(paramInt)) {
          return arrayOfSOURCE[i];
        }
        i += 1;
      }
      return localSOURCE;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */