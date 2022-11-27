package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetPushHome
  extends DataBase
{
  public static final int COUNT_MOTOR_ESCM = 8;
  private static DataOsdGetPushHome instance;
  private final MotorEscmState[] mMotorEscmStates = new MotorEscmState[8];
  
  public DataOsdGetPushHome() {}
  
  public DataOsdGetPushHome(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public static DataOsdGetPushHome getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushHome();
      }
      DataOsdGetPushHome localDataOsdGetPushHome = instance;
      return localDataOsdGetPushHome;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getAircraftHeadDirection()
  {
    return 0;
  }
  
  public int getCompassCeleStatus()
  {
    return 0;
  }
  
  public short getCourseLockAngle()
  {
    return 0;
  }
  
  public int getCurDataRecorderFileIndex()
  {
    return 0;
  }
  
  public int getDataRecorderRemainCapacity()
  {
    return 0;
  }
  
  public int getDataRecorderRemainTime()
  {
    return 0;
  }
  
  public int getDataRecorderStatus()
  {
    return 0;
  }
  
  public int getFlycLogIndex()
  {
    return 0;
  }
  
  public int getForceLandingHeight()
  {
    return 0;
  }
  
  public int getGoHomeHeight()
  {
    return 0;
  }
  
  public int getGoHomeMode()
  {
    return 0;
  }
  
  public int getGoHomeStatus()
  {
    return 0;
  }
  
  public float getHeight()
  {
    return 0.0F;
  }
  
  public HeightLimitStatus getHeightLimitStatus()
  {
    return null;
  }
  
  public float getHeightLimitValue()
  {
    return 0.0F;
  }
  
  public DataFlycGetIoc.MODE getIOCMode()
  {
    return null;
  }
  
  public double getLatitude()
  {
    return 1.37194504E-315D;
  }
  
  public double getLongitude()
  {
    return 1.37194506E-315D;
  }
  
  public MotorEscmState[] getMotorEscmState()
  {
    return null;
  }
  
  public PaddleState getPaddleState()
  {
    return null;
  }
  
  public boolean hasGoHome()
  {
    return false;
  }
  
  public boolean isBeginnerMode()
  {
    return false;
  }
  
  public boolean isBigGale()
  {
    return false;
  }
  
  public boolean isBigGaleWarning()
  {
    return false;
  }
  
  public boolean isCompassCeleing()
  {
    return false;
  }
  
  public boolean isCompassInstallErr()
  {
    return false;
  }
  
  public boolean isDynamicHomePiontEnable()
  {
    return false;
  }
  
  public boolean isFanCurrentInAbnormalState()
  {
    return false;
  }
  
  public boolean isFlycInNavigationMode()
  {
    return false;
  }
  
  public boolean isFlycInSimulationMode()
  {
    return false;
  }
  
  public boolean isHomeRecord()
  {
    return false;
  }
  
  public boolean isIOCEnabled()
  {
    return false;
  }
  
  public boolean isMultipleModeOpen()
  {
    return false;
  }
  
  public boolean isReatchLimitDistance()
  {
    return false;
  }
  
  public boolean isReatchLimitHeight()
  {
    return false;
  }
  
  public boolean isWingBroken()
  {
    return false;
  }
  
  public boolean useAbsoluteHeight()
  {
    return false;
  }
  
  public static enum HeightLimitStatus
  {
    private static volatile HeightLimitStatus[] sValues = null;
    private int _value = 0;
    
    static
    {
      NON_GPS = new HeightLimitStatus("NON_GPS", 1, 1);
      ORIENTATION_NEED_CALI = new HeightLimitStatus("ORIENTATION_NEED_CALI", 2, 2);
      ORIENTATION_GO = new HeightLimitStatus("ORIENTATION_GO", 3, 3);
      AVOID_GROUND = new HeightLimitStatus("AVOID_GROUND", 4, 4);
      HeightLimitStatus localHeightLimitStatus = new HeightLimitStatus("NORMAL_LIMIT", 5, 5);
      NORMAL_LIMIT = localHeightLimitStatus;
      $VALUES = new HeightLimitStatus[] { NON_LIMIT, NON_GPS, ORIENTATION_NEED_CALI, ORIENTATION_GO, AVOID_GROUND, localHeightLimitStatus };
    }
    
    private HeightLimitStatus(int paramInt)
    {
      this._value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this._value == paramInt;
    }
    
    public static HeightLimitStatus find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      HeightLimitStatus[] arrayOfHeightLimitStatus = sValues;
      int j = arrayOfHeightLimitStatus.length;
      int i = 0;
      while (i < j)
      {
        HeightLimitStatus localHeightLimitStatus = arrayOfHeightLimitStatus[i];
        if (localHeightLimitStatus._equals(paramInt)) {
          return localHeightLimitStatus;
        }
        i += 1;
      }
      return NON_LIMIT;
    }
    
    public int value()
    {
      return this._value;
    }
  }
  
  public static enum MotorEscmState
  {
    private static volatile MotorEscmState[] sValues = null;
    private int _value = 0;
    
    static
    {
      DISCONNECT = new MotorEscmState("DISCONNECT", 1, 1);
      SIGNAL_ERROR = new MotorEscmState("SIGNAL_ERROR", 2, 2);
      RESISTANCE_ERROR = new MotorEscmState("RESISTANCE_ERROR", 3, 3);
      BLOCK = new MotorEscmState("BLOCK", 4, 4);
      NON_BALANCE = new MotorEscmState("NON_BALANCE", 5, 5);
      ESCM_ERROR = new MotorEscmState("ESCM_ERROR", 6, 6);
      PROPELLER_OFF = new MotorEscmState("PROPELLER_OFF", 7, 7);
      MOTOR_IDLE = new MotorEscmState("MOTOR_IDLE", 8, 8);
      MOTOR_UP = new MotorEscmState("MOTOR_UP", 9, 9);
      MOTOR_OFF = new MotorEscmState("MOTOR_OFF", 10, 10);
      NON_CONNECT = new MotorEscmState("NON_CONNECT", 11, 11);
      MotorEscmState localMotorEscmState = new MotorEscmState("OTHER", 12, 100);
      OTHER = localMotorEscmState;
      $VALUES = new MotorEscmState[] { NON_SMART, DISCONNECT, SIGNAL_ERROR, RESISTANCE_ERROR, BLOCK, NON_BALANCE, ESCM_ERROR, PROPELLER_OFF, MOTOR_IDLE, MOTOR_UP, MOTOR_OFF, NON_CONNECT, localMotorEscmState };
    }
    
    private MotorEscmState(int paramInt)
    {
      this._value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this._value == paramInt;
    }
    
    public static MotorEscmState find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      MotorEscmState[] arrayOfMotorEscmState = sValues;
      int j = arrayOfMotorEscmState.length;
      int i = 0;
      while (i < j)
      {
        MotorEscmState localMotorEscmState = arrayOfMotorEscmState[i];
        if (localMotorEscmState._equals(paramInt)) {
          return localMotorEscmState;
        }
        i += 1;
      }
      return NON_CONNECT;
    }
    
    public int value()
    {
      return this._value;
    }
  }
  
  public static enum PaddleState
  {
    private static volatile PaddleState[] sValues = null;
    private int _value = 0;
    
    static
    {
      FLATLAND_ON_HIGHLAND = new PaddleState("FLATLAND_ON_HIGHLAND", 1, 1);
      HIGHLAND_ON_FLATLAND = new PaddleState("HIGHLAND_ON_FLATLAND", 2, 2);
      PaddleState localPaddleState = new PaddleState("OTHER", 3, 3);
      OTHER = localPaddleState;
      $VALUES = new PaddleState[] { NORMAL, FLATLAND_ON_HIGHLAND, HIGHLAND_ON_FLATLAND, localPaddleState };
    }
    
    private PaddleState(int paramInt)
    {
      this._value = paramInt;
    }
    
    private boolean _equal(int paramInt)
    {
      return this._value == paramInt;
    }
    
    public static PaddleState find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      PaddleState[] arrayOfPaddleState = sValues;
      int j = arrayOfPaddleState.length;
      int i = 0;
      while (i < j)
      {
        PaddleState localPaddleState = arrayOfPaddleState[i];
        if (localPaddleState._equal(paramInt)) {
          return localPaddleState;
        }
        i += 1;
      }
      return NORMAL;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushHome.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */