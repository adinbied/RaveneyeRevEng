package dji.midware.data.model.P3;

import dji.logic.mc.DJIMcHelper;
import dji.midware.data.model.base.DJIOsdDataBase;

public class DataOsdGetPushCommon
  extends DJIOsdDataBase
{
  private static DataOsdGetPushCommon instance;
  
  public DataOsdGetPushCommon() {}
  
  public DataOsdGetPushCommon(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public static DataOsdGetPushCommon getInstance()
  {
    try
    {
      if (instance == null)
      {
        localDataOsdGetPushCommon = new DataOsdGetPushCommon();
        instance = localDataOsdGetPushCommon;
        localDataOsdGetPushCommon.isNeedPushLosed = true;
        instance.isRemoteModel = true;
      }
      DataOsdGetPushCommon localDataOsdGetPushCommon = instance;
      return localDataOsdGetPushCommon;
    }
    finally {}
  }
  
  public boolean canIOCWork()
  {
    return false;
  }
  
  public void clear()
  {
    super.clear();
  }
  
  protected void doPack() {}
  
  public DataFlycFunctionControl.FLYC_COMMAND getAppCommand()
  {
    return null;
  }
  
  public int getBattery()
  {
    return 0;
  }
  
  public BatteryType getBatteryType()
  {
    return null;
  }
  
  public boolean getCompassError()
  {
    return false;
  }
  
  public DroneType getDroneType()
  {
    return null;
  }
  
  public FLIGHT_ACTION getFlightAction()
  {
    return null;
  }
  
  public int getFlyTime()
  {
    return 0;
  }
  
  public FLYC_STATE getFlycState()
  {
    return null;
  }
  
  public int getFlycVersion()
  {
    return 0;
  }
  
  public GOHOME_STATUS getGohomeStatus()
  {
    return null;
  }
  
  public int getGpsLevel()
  {
    return 0;
  }
  
  public int getGpsNum()
  {
    return 0;
  }
  
  public int getHeight()
  {
    return 0;
  }
  
  public IMU_INITFAIL_REASON getIMUinitFailReason()
  {
    return null;
  }
  
  public double getLatitude()
  {
    return 1.37267456E-315D;
  }
  
  public double getLongitude()
  {
    return 1.37267458E-315D;
  }
  
  public RcModeChannel getModeChannel()
  {
    return null;
  }
  
  public RcModeChannel getModeChannelByFR()
  {
    return null;
  }
  
  public MotorFailReason getMotorFailReason()
  {
    return null;
  }
  
  public MotorStartFailedCause getMotorFailedCause()
  {
    return null;
  }
  
  public int getMotorRevolution()
  {
    return 0;
  }
  
  public MotorStartFailedCause getMotorStartCauseNoStartAction()
  {
    return null;
  }
  
  public NON_GPS_CAUSE getNonGpsCause()
  {
    return null;
  }
  
  public int getPitch()
  {
    return 0;
  }
  
  public boolean getRcState()
  {
    return false;
  }
  
  public int getRoll()
  {
    return 0;
  }
  
  public SDKCtrlDevice getSDKCtrlDevice()
  {
    return null;
  }
  
  public int getSwaveHeight()
  {
    return 0;
  }
  
  public int getVoltageWarning()
  {
    return 0;
  }
  
  public boolean getWaveError()
  {
    return false;
  }
  
  public boolean getWaypointLimitMode()
  {
    return false;
  }
  
  public int getXSpeed()
  {
    return 0;
  }
  
  public int getYSpeed()
  {
    return 0;
  }
  
  public int getYaw()
  {
    return 0;
  }
  
  public int getZSpeed()
  {
    return 0;
  }
  
  public int groundOrSky()
  {
    return 0;
  }
  
  public boolean isAcceletorOverRange()
  {
    return false;
  }
  
  public boolean isAllowImuInitfailReason()
  {
    return false;
  }
  
  public boolean isBarometerDeadInAir()
  {
    return false;
  }
  
  public boolean isGoHomeHeightModified()
  {
    return false;
  }
  
  public boolean isGpsUsed()
  {
    return false;
  }
  
  public boolean isImuInitError()
  {
    return false;
  }
  
  public boolean isImuPreheatd()
  {
    return false;
  }
  
  public boolean isMotorBlock()
  {
    return false;
  }
  
  public boolean isMotorUp()
  {
    return false;
  }
  
  public boolean isNotEnoughForce()
  {
    return false;
  }
  
  public boolean isOutOfLimit()
  {
    return false;
  }
  
  public boolean isPropellerCatapult()
  {
    return false;
  }
  
  public boolean isQuickSpin()
  {
    return false;
  }
  
  public boolean isShowNearGroundProtectTips()
  {
    return false;
  }
  
  public boolean isSwaveWork()
  {
    return false;
  }
  
  public boolean isVibrating()
  {
    return false;
  }
  
  public boolean isVisionUsed()
  {
    return false;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    super.setPushRecData(paramArrayOfByte);
  }
  
  public static enum BatteryType
  {
    private static volatile BatteryType[] sValues = null;
    private int _value = 0;
    
    static
    {
      NonSmart = new BatteryType("NonSmart", 1, 1);
      BatteryType localBatteryType = new BatteryType("Smart", 2, 2);
      Smart = localBatteryType;
      $VALUES = new BatteryType[] { Unknown, NonSmart, localBatteryType };
    }
    
    private BatteryType(int paramInt)
    {
      this._value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this._value == paramInt;
    }
    
    public static BatteryType find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      BatteryType[] arrayOfBatteryType = sValues;
      int j = arrayOfBatteryType.length;
      int i = 0;
      while (i < j)
      {
        BatteryType localBatteryType = arrayOfBatteryType[i];
        if (localBatteryType._equals(paramInt)) {
          return localBatteryType;
        }
        i += 1;
      }
      return Unknown;
    }
    
    public int value()
    {
      return this._value;
    }
  }
  
  public static enum DroneType
  {
    private static volatile DroneType[] sValues = null;
    private int _value = 0;
    
    static
    {
      Inspire = new DroneType("Inspire", 1, 1);
      P3S = new DroneType("P3S", 2, 2);
      P3X = new DroneType("P3X", 3, 3);
      P3C = new DroneType("P3C", 4, 4);
      OpenFrame = new DroneType("OpenFrame", 5, 5);
      ACEONE = new DroneType("ACEONE", 6, 6);
      WKM = new DroneType("WKM", 7, 7);
      NAZA = new DroneType("NAZA", 8, 8);
      A2 = new DroneType("A2", 9, 9);
      A3 = new DroneType("A3", 10, 10);
      P4 = new DroneType("P4", 11, 11);
      PM820 = new DroneType("PM820", 12, 14);
      P34K = new DroneType("P34K", 13, 15);
      wm220 = new DroneType("wm220", 14, 16);
      Orange2 = new DroneType("Orange2", 15, 17);
      Pomato = new DroneType("Pomato", 16, 18);
      N3 = new DroneType("N3", 17, 20);
      Mammoth = new DroneType("Mammoth", 18, 21);
      PM820PRO = new DroneType("PM820PRO", 19, 23);
      M200 = new DroneType("M200", 20, 25);
      M210 = new DroneType("M210", 21, 28);
      M210RTK = new DroneType("M210RTK", 22, 30);
      Potato = new DroneType("Potato", 23, 27);
      NoFlyc = new DroneType("NoFlyc", 24, 255);
      DroneType localDroneType = new DroneType("None", 25, 100);
      None = localDroneType;
      $VALUES = new DroneType[] { Unknown, Inspire, P3S, P3X, P3C, OpenFrame, ACEONE, WKM, NAZA, A2, A3, P4, PM820, P34K, wm220, Orange2, Pomato, N3, Mammoth, PM820PRO, M200, M210, M210RTK, Potato, NoFlyc, localDroneType };
    }
    
    private DroneType(int paramInt)
    {
      this._value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this._value == paramInt;
    }
    
    public static DroneType find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      DroneType[] arrayOfDroneType = sValues;
      int j = arrayOfDroneType.length;
      int i = 0;
      while (i < j)
      {
        DroneType localDroneType = arrayOfDroneType[i];
        if (localDroneType._equals(paramInt)) {
          return localDroneType;
        }
        i += 1;
      }
      return None;
    }
    
    public int value()
    {
      return this._value;
    }
  }
  
  public static enum FLIGHT_ACTION
  {
    private static volatile FLIGHT_ACTION[] sValues = null;
    private int _value = 0;
    
    static
    {
      SMART_POWER_GOHOME = new FLIGHT_ACTION("SMART_POWER_GOHOME", 3, 3);
      SMART_POWER_LANDING = new FLIGHT_ACTION("SMART_POWER_LANDING", 4, 4);
      LOW_VOLTAGE_LANDING = new FLIGHT_ACTION("LOW_VOLTAGE_LANDING", 5, 5);
      LOW_VOLTAGE_GOHOME = new FLIGHT_ACTION("LOW_VOLTAGE_GOHOME", 6, 6);
      SERIOUS_LOW_VOLTAGE_LANDING = new FLIGHT_ACTION("SERIOUS_LOW_VOLTAGE_LANDING", 7, 7);
      RC_ONEKEY_GOHOME = new FLIGHT_ACTION("RC_ONEKEY_GOHOME", 8, 8);
      RC_ASSISTANT_TAKEOFF = new FLIGHT_ACTION("RC_ASSISTANT_TAKEOFF", 9, 9);
      RC_AUTO_TAKEOFF = new FLIGHT_ACTION("RC_AUTO_TAKEOFF", 10, 10);
      RC_AUTO_LANDING = new FLIGHT_ACTION("RC_AUTO_LANDING", 11, 11);
      APP_AUTO_GOHOME = new FLIGHT_ACTION("APP_AUTO_GOHOME", 12, 12);
      APP_AUTO_LANDING = new FLIGHT_ACTION("APP_AUTO_LANDING", 13, 13);
      APP_AUTO_TAKEOFF = new FLIGHT_ACTION("APP_AUTO_TAKEOFF", 14, 14);
      OUTOF_CONTROL_GOHOME = new FLIGHT_ACTION("OUTOF_CONTROL_GOHOME", 15, 15);
      API_AUTO_TAKEOFF = new FLIGHT_ACTION("API_AUTO_TAKEOFF", 16, 16);
      API_AUTO_LANDING = new FLIGHT_ACTION("API_AUTO_LANDING", 17, 17);
      API_AUTO_GOHOME = new FLIGHT_ACTION("API_AUTO_GOHOME", 18, 18);
      AVOID_GROUND_LANDING = new FLIGHT_ACTION("AVOID_GROUND_LANDING", 19, 19);
      AIRPORT_AVOID_LANDING = new FLIGHT_ACTION("AIRPORT_AVOID_LANDING", 20, 20);
      TOO_CLOSE_GOHOME_LANDING = new FLIGHT_ACTION("TOO_CLOSE_GOHOME_LANDING", 21, 21);
      TOO_FAR_GOHOME_LANDING = new FLIGHT_ACTION("TOO_FAR_GOHOME_LANDING", 22, 22);
      APP_WP_MISSION = new FLIGHT_ACTION("APP_WP_MISSION", 23, 23);
      WP_AUTO_TAKEOFF = new FLIGHT_ACTION("WP_AUTO_TAKEOFF", 24, 24);
      GOHOME_AVOID = new FLIGHT_ACTION("GOHOME_AVOID", 25, 25);
      GOHOME_FINISH = new FLIGHT_ACTION("GOHOME_FINISH", 26, 26);
      VERT_LOW_LIMIT_LANDING = new FLIGHT_ACTION("VERT_LOW_LIMIT_LANDING", 27, 27);
      BATTERY_FORCE_LANDING = new FLIGHT_ACTION("BATTERY_FORCE_LANDING", 28, 28);
      MC_PROTECT_GOHOME = new FLIGHT_ACTION("MC_PROTECT_GOHOME", 29, 29);
      MOTORBLOCK_LANDING = new FLIGHT_ACTION("MOTORBLOCK_LANDING", 30, 30);
      APP_REQUEST_FORCE_LANDING = new FLIGHT_ACTION("APP_REQUEST_FORCE_LANDING", 31, 31);
      FAKEBATTERY_LANDING = new FLIGHT_ACTION("FAKEBATTERY_LANDING", 32, 32);
      RTH_COMING_OBSTACLE_LANDING = new FLIGHT_ACTION("RTH_COMING_OBSTACLE_LANDING", 33, 33);
      FLIGHT_ACTION localFLIGHT_ACTION = new FLIGHT_ACTION("IMUERROR_RTH", 34, 34);
      IMUERROR_RTH = localFLIGHT_ACTION;
      $VALUES = new FLIGHT_ACTION[] { NONE, WARNING_POWER_GOHOME, WARNING_POWER_LANDING, SMART_POWER_GOHOME, SMART_POWER_LANDING, LOW_VOLTAGE_LANDING, LOW_VOLTAGE_GOHOME, SERIOUS_LOW_VOLTAGE_LANDING, RC_ONEKEY_GOHOME, RC_ASSISTANT_TAKEOFF, RC_AUTO_TAKEOFF, RC_AUTO_LANDING, APP_AUTO_GOHOME, APP_AUTO_LANDING, APP_AUTO_TAKEOFF, OUTOF_CONTROL_GOHOME, API_AUTO_TAKEOFF, API_AUTO_LANDING, API_AUTO_GOHOME, AVOID_GROUND_LANDING, AIRPORT_AVOID_LANDING, TOO_CLOSE_GOHOME_LANDING, TOO_FAR_GOHOME_LANDING, APP_WP_MISSION, WP_AUTO_TAKEOFF, GOHOME_AVOID, GOHOME_FINISH, VERT_LOW_LIMIT_LANDING, BATTERY_FORCE_LANDING, MC_PROTECT_GOHOME, MOTORBLOCK_LANDING, APP_REQUEST_FORCE_LANDING, FAKEBATTERY_LANDING, RTH_COMING_OBSTACLE_LANDING, localFLIGHT_ACTION };
    }
    
    private FLIGHT_ACTION(int paramInt)
    {
      this._value = paramInt;
    }
    
    public static FLIGHT_ACTION find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      FLIGHT_ACTION localFLIGHT_ACTION1 = NONE;
      FLIGHT_ACTION[] arrayOfFLIGHT_ACTION = sValues;
      int j = arrayOfFLIGHT_ACTION.length;
      int i = 0;
      while (i < j)
      {
        FLIGHT_ACTION localFLIGHT_ACTION2 = arrayOfFLIGHT_ACTION[i];
        if (localFLIGHT_ACTION2.belongsTo(paramInt)) {
          return localFLIGHT_ACTION2;
        }
        i += 1;
      }
      return localFLIGHT_ACTION1;
    }
    
    public boolean belongsTo(int paramInt)
    {
      return this._value == paramInt;
    }
    
    public int value()
    {
      return this._value;
    }
  }
  
  public static enum FLYC_STATE
  {
    private static volatile FLYC_STATE[] sValues = null;
    private int data;
    
    static
    {
      Atti = new FLYC_STATE("Atti", 1, 1);
      Atti_CL = new FLYC_STATE("Atti_CL", 2, 2);
      Atti_Hover = new FLYC_STATE("Atti_Hover", 3, 3);
      Hover = new FLYC_STATE("Hover", 4, 4);
      GPS_Blake = new FLYC_STATE("GPS_Blake", 5, 5);
      GPS_Atti = new FLYC_STATE("GPS_Atti", 6, 6);
      GPS_CL = new FLYC_STATE("GPS_CL", 7, 7);
      GPS_HomeLock = new FLYC_STATE("GPS_HomeLock", 8, 8);
      GPS_HotPoint = new FLYC_STATE("GPS_HotPoint", 9, 9);
      AssitedTakeoff = new FLYC_STATE("AssitedTakeoff", 10, 10);
      AutoTakeoff = new FLYC_STATE("AutoTakeoff", 11, 11);
      AutoLanding = new FLYC_STATE("AutoLanding", 12, 12);
      AttiLangding = new FLYC_STATE("AttiLangding", 13, 13);
      NaviGo = new FLYC_STATE("NaviGo", 14, 14);
      GoHome = new FLYC_STATE("GoHome", 15, 15);
      ClickGo = new FLYC_STATE("ClickGo", 16, 16);
      Joystick = new FLYC_STATE("Joystick", 17, 17);
      Cinematic = new FLYC_STATE("Cinematic", 18, 19);
      Atti_Limited = new FLYC_STATE("Atti_Limited", 19, 23);
      NaviSubMode_Draw = new FLYC_STATE("NaviSubMode_Draw", 20, 24);
      NaviMissionFollow = new FLYC_STATE("NaviMissionFollow", 21, 25);
      NaviSubMode_Tracking = new FLYC_STATE("NaviSubMode_Tracking", 22, 26);
      NaviSubMode_Pointing = new FLYC_STATE("NaviSubMode_Pointing", 23, 27);
      PANO = new FLYC_STATE("PANO", 24, 28);
      Farming = new FLYC_STATE("Farming", 25, 29);
      FPV = new FLYC_STATE("FPV", 26, 30);
      SPORT = new FLYC_STATE("SPORT", 27, 31);
      NOVICE = new FLYC_STATE("NOVICE", 28, 32);
      FORCE_LANDING = new FLYC_STATE("FORCE_LANDING", 29, 33);
      TERRAIN_TRACKING = new FLYC_STATE("TERRAIN_TRACKING", 30, 35);
      PALM_CONTROL = new FLYC_STATE("PALM_CONTROL", 31, 36);
      QUICK_SHOT = new FLYC_STATE("QUICK_SHOT", 32, 37);
      TRIPOD_GPS = new FLYC_STATE("TRIPOD_GPS", 33, 38);
      TRACK_HEADLOCK = new FLYC_STATE("TRACK_HEADLOCK", 34, 39);
      ENGINE_START = new FLYC_STATE("ENGINE_START", 35, 41);
      GENTLE_GPS = new FLYC_STATE("GENTLE_GPS", 36, 43);
      FLYC_STATE localFLYC_STATE = new FLYC_STATE("OTHER", 37, 100);
      OTHER = localFLYC_STATE;
      $VALUES = new FLYC_STATE[] { Manula, Atti, Atti_CL, Atti_Hover, Hover, GPS_Blake, GPS_Atti, GPS_CL, GPS_HomeLock, GPS_HotPoint, AssitedTakeoff, AutoTakeoff, AutoLanding, AttiLangding, NaviGo, GoHome, ClickGo, Joystick, Cinematic, Atti_Limited, NaviSubMode_Draw, NaviMissionFollow, NaviSubMode_Tracking, NaviSubMode_Pointing, PANO, Farming, FPV, SPORT, NOVICE, FORCE_LANDING, TERRAIN_TRACKING, PALM_CONTROL, QUICK_SHOT, TRIPOD_GPS, TRACK_HEADLOCK, ENGINE_START, GENTLE_GPS, localFLYC_STATE };
    }
    
    private FLYC_STATE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FLYC_STATE find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      FLYC_STATE localFLYC_STATE = OTHER;
      int i = 0;
      while (i < sValues.length)
      {
        if (sValues[i]._equals(paramInt)) {
          return sValues[i];
        }
        i += 1;
      }
      return localFLYC_STATE;
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
  
  public static enum GOHOME_STATUS
  {
    private static volatile GOHOME_STATUS[] sValues = null;
    private int data = 0;
    
    static
    {
      PREASCENDING = new GOHOME_STATUS("PREASCENDING", 1, 1);
      ALIGN = new GOHOME_STATUS("ALIGN", 2, 2);
      ASCENDING = new GOHOME_STATUS("ASCENDING", 3, 3);
      CRUISE = new GOHOME_STATUS("CRUISE", 4, 4);
      BRAKING = new GOHOME_STATUS("BRAKING", 5, 5);
      BYPASSING = new GOHOME_STATUS("BYPASSING", 6, 6);
      GOHOME_STATUS localGOHOME_STATUS = new GOHOME_STATUS("OTHER", 7, 7);
      OTHER = localGOHOME_STATUS;
      $VALUES = new GOHOME_STATUS[] { STANDBY, PREASCENDING, ALIGN, ASCENDING, CRUISE, BRAKING, BYPASSING, localGOHOME_STATUS };
    }
    
    private GOHOME_STATUS(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static GOHOME_STATUS find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      GOHOME_STATUS localGOHOME_STATUS = OTHER;
      int i = 0;
      while (i < sValues.length)
      {
        if (sValues[i]._equals(paramInt)) {
          return sValues[i];
        }
        i += 1;
      }
      return localGOHOME_STATUS;
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
  
  public static enum IMU_INITFAIL_REASON
  {
    private static volatile IMU_INITFAIL_REASON[] sValues = null;
    private int _value = 0;
    
    static
    {
      ColletingData = new IMU_INITFAIL_REASON("ColletingData", 1, 1);
      GyroDead = new IMU_INITFAIL_REASON("GyroDead", 2, 2);
      AcceDead = new IMU_INITFAIL_REASON("AcceDead", 3, 3);
      CompassDead = new IMU_INITFAIL_REASON("CompassDead", 4, 4);
      BarometerDead = new IMU_INITFAIL_REASON("BarometerDead", 5, 5);
      BarometerNegative = new IMU_INITFAIL_REASON("BarometerNegative", 6, 6);
      CompassModTooLarge = new IMU_INITFAIL_REASON("CompassModTooLarge", 7, 7);
      GyroBiasTooLarge = new IMU_INITFAIL_REASON("GyroBiasTooLarge", 8, 8);
      AcceBiasTooLarge = new IMU_INITFAIL_REASON("AcceBiasTooLarge", 9, 9);
      CompassNoiseTooLarge = new IMU_INITFAIL_REASON("CompassNoiseTooLarge", 10, 10);
      BarometerNoiseTooLarge = new IMU_INITFAIL_REASON("BarometerNoiseTooLarge", 11, 11);
      WaitingMcStationary = new IMU_INITFAIL_REASON("WaitingMcStationary", 12, 12);
      AcceMoveTooLarge = new IMU_INITFAIL_REASON("AcceMoveTooLarge", 13, 13);
      McHeaderMoved = new IMU_INITFAIL_REASON("McHeaderMoved", 14, 14);
      McVirbrated = new IMU_INITFAIL_REASON("McVirbrated", 15, 15);
      IMU_INITFAIL_REASON localIMU_INITFAIL_REASON = new IMU_INITFAIL_REASON("None", 16, 100);
      None = localIMU_INITFAIL_REASON;
      $VALUES = new IMU_INITFAIL_REASON[] { MonitorError, ColletingData, GyroDead, AcceDead, CompassDead, BarometerDead, BarometerNegative, CompassModTooLarge, GyroBiasTooLarge, AcceBiasTooLarge, CompassNoiseTooLarge, BarometerNoiseTooLarge, WaitingMcStationary, AcceMoveTooLarge, McHeaderMoved, McVirbrated, localIMU_INITFAIL_REASON };
    }
    
    private IMU_INITFAIL_REASON(int paramInt)
    {
      this._value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this._value == paramInt;
    }
    
    public static IMU_INITFAIL_REASON find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      IMU_INITFAIL_REASON[] arrayOfIMU_INITFAIL_REASON = sValues;
      int j = arrayOfIMU_INITFAIL_REASON.length;
      int i = 0;
      while (i < j)
      {
        IMU_INITFAIL_REASON localIMU_INITFAIL_REASON = arrayOfIMU_INITFAIL_REASON[i];
        if (localIMU_INITFAIL_REASON._equals(paramInt)) {
          return localIMU_INITFAIL_REASON;
        }
        i += 1;
      }
      return None;
    }
    
    public int value()
    {
      return this._value;
    }
  }
  
  public static enum MotorFailReason
  {
    private static volatile MotorFailReason[] sValues = null;
    private int _value = 0;
    
    static
    {
      ESC_STALL_NEAR_GROUND = new MotorFailReason("ESC_STALL_NEAR_GROUND", 1, 95);
      ESC_UNBALANCE_ON_GRD = new MotorFailReason("ESC_UNBALANCE_ON_GRD", 2, 96);
      ESC_PART_EMPTY_ON_GRD = new MotorFailReason("ESC_PART_EMPTY_ON_GRD", 3, 97);
      ENGINE_START_FAILED = new MotorFailReason("ENGINE_START_FAILED", 4, 98);
      AUTO_TAKEOFF_LANCH_FAILED = new MotorFailReason("AUTO_TAKEOFF_LANCH_FAILED", 5, 99);
      ROLL_OVER_ON_GRD = new MotorFailReason("ROLL_OVER_ON_GRD", 6, 100);
      MotorFailReason localMotorFailReason = new MotorFailReason("OTHER", 7, 128);
      OTHER = localMotorFailReason;
      $VALUES = new MotorFailReason[] { TAKEOFF_EXCEPTION, ESC_STALL_NEAR_GROUND, ESC_UNBALANCE_ON_GRD, ESC_PART_EMPTY_ON_GRD, ENGINE_START_FAILED, AUTO_TAKEOFF_LANCH_FAILED, ROLL_OVER_ON_GRD, localMotorFailReason };
    }
    
    private MotorFailReason(int paramInt)
    {
      this._value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this._value == paramInt;
    }
    
    public static MotorFailReason find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      MotorFailReason[] arrayOfMotorFailReason = sValues;
      int j = arrayOfMotorFailReason.length;
      int i = 0;
      while (i < j)
      {
        MotorFailReason localMotorFailReason = arrayOfMotorFailReason[i];
        if (localMotorFailReason._equals(paramInt)) {
          return localMotorFailReason;
        }
        i += 1;
      }
      return OTHER;
    }
    
    public int value()
    {
      return this._value;
    }
  }
  
  public static enum MotorStartFailedCause
  {
    private static volatile MotorStartFailedCause[] sValues = null;
    private final int maxValue;
    private final int minValue;
    private int relValue = 0;
    
    static
    {
      CompassError = new MotorStartFailedCause("CompassError", 1, 1);
      AssistantProtected = new MotorStartFailedCause("AssistantProtected", 2, 2);
      DeviceLocked = new MotorStartFailedCause("DeviceLocked", 3, 3);
      DistanceLimit = new MotorStartFailedCause("DistanceLimit", 4, 4);
      IMUNeedCalibration = new MotorStartFailedCause("IMUNeedCalibration", 5, 5);
      IMUSNError = new MotorStartFailedCause("IMUSNError", 6, 6);
      IMUWarning = new MotorStartFailedCause("IMUWarning", 7, 7);
      CompassCalibrating = new MotorStartFailedCause("CompassCalibrating", 8, 8);
      AttiError = new MotorStartFailedCause("AttiError", 9, 9);
      NoviceProtected = new MotorStartFailedCause("NoviceProtected", 10, 10);
      BatteryCellError = new MotorStartFailedCause("BatteryCellError", 11, 11);
      BatteryCommuniteError = new MotorStartFailedCause("BatteryCommuniteError", 12, 12);
      SeriouLowVoltage = new MotorStartFailedCause("SeriouLowVoltage", 13, 13);
      SeriouLowPower = new MotorStartFailedCause("SeriouLowPower", 14, 14);
      LowVoltage = new MotorStartFailedCause("LowVoltage", 15, 15);
      TempureVolLow = new MotorStartFailedCause("TempureVolLow", 16, 16);
      SmartLowToLand = new MotorStartFailedCause("SmartLowToLand", 17, 17);
      BatteryNotReady = new MotorStartFailedCause("BatteryNotReady", 18, 18);
      SimulatorMode = new MotorStartFailedCause("SimulatorMode", 19, 19);
      PackMode = new MotorStartFailedCause("PackMode", 20, 20);
      AttitudeAbNormal = new MotorStartFailedCause("AttitudeAbNormal", 21, 21);
      UnActive = new MotorStartFailedCause("UnActive", 22, 22);
      FlyForbiddenError = new MotorStartFailedCause("FlyForbiddenError", 23, 23);
      BiasError = new MotorStartFailedCause("BiasError", 24, 24);
      EscError = new MotorStartFailedCause("EscError", 25, 25);
      ImuInitError = new MotorStartFailedCause("ImuInitError", 26, 26);
      SystemUpgrade = new MotorStartFailedCause("SystemUpgrade", 27, 27);
      SimulatorStarted = new MotorStartFailedCause("SimulatorStarted", 28, 28);
      ImuingError = new MotorStartFailedCause("ImuingError", 29, 29);
      AttiAngleOver = new MotorStartFailedCause("AttiAngleOver", 30, 30);
      GyroscopeError = new MotorStartFailedCause("GyroscopeError", 31, 31);
      AcceletorError = new MotorStartFailedCause("AcceletorError", 32, 32);
      CompassFailed = new MotorStartFailedCause("CompassFailed", 33, 33);
      BarometerError = new MotorStartFailedCause("BarometerError", 34, 34);
      BarometerNegative = new MotorStartFailedCause("BarometerNegative", 35, 35);
      CompassBig = new MotorStartFailedCause("CompassBig", 36, 36);
      GyroscopeBiasBig = new MotorStartFailedCause("GyroscopeBiasBig", 37, 37);
      AcceletorBiasBig = new MotorStartFailedCause("AcceletorBiasBig", 38, 38);
      CompassNoiseBig = new MotorStartFailedCause("CompassNoiseBig", 39, 39);
      BarometerNoiseBig = new MotorStartFailedCause("BarometerNoiseBig", 40, 40);
      InvalidSn = new MotorStartFailedCause("InvalidSn", 41, 41);
      FLASH_OPERATING = new MotorStartFailedCause("FLASH_OPERATING", 42, 44);
      GPS_DISCONNECT = new MotorStartFailedCause("GPS_DISCONNECT", 43, 45);
      SDCardException = new MotorStartFailedCause("SDCardException", 44, 47);
      IMUNoconnection = new MotorStartFailedCause("IMUNoconnection", 45, 61);
      RCCalibration = new MotorStartFailedCause("RCCalibration", 46, 62);
      RCCalibrationException = new MotorStartFailedCause("RCCalibrationException", 47, 63);
      RCCalibrationUnfinished = new MotorStartFailedCause("RCCalibrationUnfinished", 48, 64);
      RCCalibrationException2 = new MotorStartFailedCause("RCCalibrationException2", 49, 65);
      RCCalibrationException3 = new MotorStartFailedCause("RCCalibrationException3", 50, 66);
      AircraftTypeMismatch = new MotorStartFailedCause("AircraftTypeMismatch", 51, 67);
      FoundUnfinishedModule = new MotorStartFailedCause("FoundUnfinishedModule", 52, 68);
      CYRO_ABNORMAL = new MotorStartFailedCause("CYRO_ABNORMAL", 53, 70);
      BARO_ABNORMAL = new MotorStartFailedCause("BARO_ABNORMAL", 54, 71);
      COMPASS_ABNORMAL = new MotorStartFailedCause("COMPASS_ABNORMAL", 55, 72);
      GPS_ABNORMAL = new MotorStartFailedCause("GPS_ABNORMAL", 56, 73);
      NS_ABNORMAL = new MotorStartFailedCause("NS_ABNORMAL", 57, 74);
      TOPOLOGY_ABNORMAL = new MotorStartFailedCause("TOPOLOGY_ABNORMAL", 58, 75);
      RC_NEED_CALI = new MotorStartFailedCause("RC_NEED_CALI", 59, 76);
      INVALID_FLOAT = new MotorStartFailedCause("INVALID_FLOAT", 60, 77);
      M600_BAT_TOO_LITTLE = new MotorStartFailedCause("M600_BAT_TOO_LITTLE", 61, 78);
      M600_BAT_AUTH_ERR = new MotorStartFailedCause("M600_BAT_AUTH_ERR", 62, 79);
      M600_BAT_COMM_ERR = new MotorStartFailedCause("M600_BAT_COMM_ERR", 63, 80);
      M600_BAT_DIF_VOLT_LARGE_1 = new MotorStartFailedCause("M600_BAT_DIF_VOLT_LARGE_1", 64, 81);
      M600_BAT_DIF_VOLT_LARGE_2 = new MotorStartFailedCause("M600_BAT_DIF_VOLT_LARGE_2", 65, 82);
      INVALID_VERSION = new MotorStartFailedCause("INVALID_VERSION", 66, 83);
      GIMBAL_GYRO_ABNORMAL = new MotorStartFailedCause("GIMBAL_GYRO_ABNORMAL", 67, 84);
      GIMBAL_ESC_PITCH_NON_DATA = new MotorStartFailedCause("GIMBAL_ESC_PITCH_NON_DATA", 68, 85);
      GIMBAL_ESC_ROLL_NON_DATA = new MotorStartFailedCause("GIMBAL_ESC_ROLL_NON_DATA", 69, 86);
      GIMBAL_ESC_YAW_NON_DATA = new MotorStartFailedCause("GIMBAL_ESC_YAW_NON_DATA", 70, 87);
      GIMBAL_FIRM_IS_UPDATING = new MotorStartFailedCause("GIMBAL_FIRM_IS_UPDATING", 71, 88);
      GIMBAL_DISORDER = new MotorStartFailedCause("GIMBAL_DISORDER", 72, 89);
      GIMBAL_PITCH_SHOCK = new MotorStartFailedCause("GIMBAL_PITCH_SHOCK", 73, 90);
      GIMBAL_ROLL_SHOCK = new MotorStartFailedCause("GIMBAL_ROLL_SHOCK", 74, 91);
      GIMBAL_YAW_SHOCK = new MotorStartFailedCause("GIMBAL_YAW_SHOCK", 75, 92);
      IMUcCalibrationFinished = new MotorStartFailedCause("IMUcCalibrationFinished", 76, 93);
      BatVersionError = new MotorStartFailedCause("BatVersionError", 77, 101);
      RTK_BAD_SIGNAL = new MotorStartFailedCause("RTK_BAD_SIGNAL", 78, 102);
      RTK_DEVIATION_ERROR = new MotorStartFailedCause("RTK_DEVIATION_ERROR", 79, 103);
      ESC_CALIBRATING = new MotorStartFailedCause("ESC_CALIBRATING", 80, 112);
      GPS_SIGN_INVALID = new MotorStartFailedCause("GPS_SIGN_INVALID", 81, 113);
      GIMBAL_IS_CALIBRATING = new MotorStartFailedCause("GIMBAL_IS_CALIBRATING", 82, 114);
      LOCK_BY_APP = new MotorStartFailedCause("LOCK_BY_APP", 83, 115);
      START_FLY_HEIGHT_ERROR = new MotorStartFailedCause("START_FLY_HEIGHT_ERROR", 84, 116);
      ESC_VERSION_NOT_MATCH = new MotorStartFailedCause("ESC_VERSION_NOT_MATCH", 85, 117);
      IMU_ORI_NOT_MATCH = new MotorStartFailedCause("IMU_ORI_NOT_MATCH", 86, 118);
      STOP_BY_APP = new MotorStartFailedCause("STOP_BY_APP", 87, 119);
      COMPASS_IMU_ORI_NOT_MATCH = new MotorStartFailedCause("COMPASS_IMU_ORI_NOT_MATCH", 88, 120);
      ESC_ECHOING = new MotorStartFailedCause("ESC_ECHOING", 89, 122);
      REMOTE_USB_CONNECTED = new MotorStartFailedCause("REMOTE_USB_CONNECTED", 90, 200, 255);
      MotorStartFailedCause localMotorStartFailedCause = new MotorStartFailedCause("OTHER", 91, Integer.MAX_VALUE);
      OTHER = localMotorStartFailedCause;
      $VALUES = new MotorStartFailedCause[] { None, CompassError, AssistantProtected, DeviceLocked, DistanceLimit, IMUNeedCalibration, IMUSNError, IMUWarning, CompassCalibrating, AttiError, NoviceProtected, BatteryCellError, BatteryCommuniteError, SeriouLowVoltage, SeriouLowPower, LowVoltage, TempureVolLow, SmartLowToLand, BatteryNotReady, SimulatorMode, PackMode, AttitudeAbNormal, UnActive, FlyForbiddenError, BiasError, EscError, ImuInitError, SystemUpgrade, SimulatorStarted, ImuingError, AttiAngleOver, GyroscopeError, AcceletorError, CompassFailed, BarometerError, BarometerNegative, CompassBig, GyroscopeBiasBig, AcceletorBiasBig, CompassNoiseBig, BarometerNoiseBig, InvalidSn, FLASH_OPERATING, GPS_DISCONNECT, SDCardException, IMUNoconnection, RCCalibration, RCCalibrationException, RCCalibrationUnfinished, RCCalibrationException2, RCCalibrationException3, AircraftTypeMismatch, FoundUnfinishedModule, CYRO_ABNORMAL, BARO_ABNORMAL, COMPASS_ABNORMAL, GPS_ABNORMAL, NS_ABNORMAL, TOPOLOGY_ABNORMAL, RC_NEED_CALI, INVALID_FLOAT, M600_BAT_TOO_LITTLE, M600_BAT_AUTH_ERR, M600_BAT_COMM_ERR, M600_BAT_DIF_VOLT_LARGE_1, M600_BAT_DIF_VOLT_LARGE_2, INVALID_VERSION, GIMBAL_GYRO_ABNORMAL, GIMBAL_ESC_PITCH_NON_DATA, GIMBAL_ESC_ROLL_NON_DATA, GIMBAL_ESC_YAW_NON_DATA, GIMBAL_FIRM_IS_UPDATING, GIMBAL_DISORDER, GIMBAL_PITCH_SHOCK, GIMBAL_ROLL_SHOCK, GIMBAL_YAW_SHOCK, IMUcCalibrationFinished, BatVersionError, RTK_BAD_SIGNAL, RTK_DEVIATION_ERROR, ESC_CALIBRATING, GPS_SIGN_INVALID, GIMBAL_IS_CALIBRATING, LOCK_BY_APP, START_FLY_HEIGHT_ERROR, ESC_VERSION_NOT_MATCH, IMU_ORI_NOT_MATCH, STOP_BY_APP, COMPASS_IMU_ORI_NOT_MATCH, ESC_ECHOING, REMOTE_USB_CONNECTED, localMotorStartFailedCause };
    }
    
    private MotorStartFailedCause(int paramInt)
    {
      this(paramInt, paramInt);
    }
    
    private MotorStartFailedCause(int paramInt1, int paramInt2)
    {
      this.minValue = paramInt1;
      this.maxValue = paramInt2;
    }
    
    public static MotorStartFailedCause find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      MotorStartFailedCause localMotorStartFailedCause2 = OTHER;
      MotorStartFailedCause[] arrayOfMotorStartFailedCause = sValues;
      int i = 0;
      int j = arrayOfMotorStartFailedCause.length;
      MotorStartFailedCause localMotorStartFailedCause1;
      for (;;)
      {
        localMotorStartFailedCause1 = localMotorStartFailedCause2;
        if (i >= j) {
          break;
        }
        if (arrayOfMotorStartFailedCause[i]._equals(paramInt))
        {
          localMotorStartFailedCause1 = arrayOfMotorStartFailedCause[i];
          break;
        }
        i += 1;
      }
      localMotorStartFailedCause1.relValue = paramInt;
      return localMotorStartFailedCause1;
    }
    
    public boolean _equals(int paramInt)
    {
      return (this.minValue <= paramInt) && (paramInt <= this.maxValue);
    }
    
    public int relValue()
    {
      return this.relValue;
    }
  }
  
  public static enum MotorStateEvent
  {
    static
    {
      MotorStateEvent localMotorStateEvent = new MotorStateEvent("MOTOR_DOWN", 1);
      MOTOR_DOWN = localMotorStateEvent;
      $VALUES = new MotorStateEvent[] { MOTOR_UP, localMotorStateEvent };
    }
    
    private MotorStateEvent() {}
  }
  
  public static enum NON_GPS_CAUSE
  {
    private static volatile NON_GPS_CAUSE[] sValues = null;
    private int data = 0;
    
    static
    {
      COMPASS_ERROR_LARGE = new NON_GPS_CAUSE("COMPASS_ERROR_LARGE", 7, 7);
      NON_GPS_CAUSE localNON_GPS_CAUSE = new NON_GPS_CAUSE("UNKNOWN", 8, 8);
      UNKNOWN = localNON_GPS_CAUSE;
      $VALUES = new NON_GPS_CAUSE[] { ALREADY, FORBIN, GPSNUM_NONENOUGH, GPS_HDOP_LARGE, GPS_POSITION_NONMATCH, SPEED_ERROR_LARGE, YAW_ERROR_LARGE, COMPASS_ERROR_LARGE, localNON_GPS_CAUSE };
    }
    
    private NON_GPS_CAUSE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static NON_GPS_CAUSE find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      NON_GPS_CAUSE localNON_GPS_CAUSE = UNKNOWN;
      int i = 0;
      while (i < sValues.length)
      {
        if (sValues[i]._equals(paramInt)) {
          return sValues[i];
        }
        i += 1;
      }
      return localNON_GPS_CAUSE;
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
  
  public static enum RcModeChannel
  {
    private int _value = 0;
    
    static
    {
      CHANNEL_A = new RcModeChannel("CHANNEL_A", 1, 1);
      CHANNEL_P = new RcModeChannel("CHANNEL_P", 2, 2);
      CHANNEL_NAV = new RcModeChannel("CHANNEL_NAV", 3, 3);
      CHANNEL_FPV = new RcModeChannel("CHANNEL_FPV", 4, 4);
      CHANNEL_FARM = new RcModeChannel("CHANNEL_FARM", 5, 5);
      CHANNEL_S = new RcModeChannel("CHANNEL_S", 6, 6);
      CHANNEL_F = new RcModeChannel("CHANNEL_F", 7, 7);
      CHANNEL_M = new RcModeChannel("CHANNEL_M", 8, 8);
      CHANNEL_G = new RcModeChannel("CHANNEL_G", 9, 9);
      RcModeChannel localRcModeChannel = new RcModeChannel("CHANNEL_UNKNOWN", 10, 255);
      CHANNEL_UNKNOWN = localRcModeChannel;
      $VALUES = new RcModeChannel[] { CHANNEL_MANUAL, CHANNEL_A, CHANNEL_P, CHANNEL_NAV, CHANNEL_FPV, CHANNEL_FARM, CHANNEL_S, CHANNEL_F, CHANNEL_M, CHANNEL_G, localRcModeChannel };
    }
    
    private RcModeChannel(int paramInt)
    {
      this._value = paramInt;
    }
    
    public static RcModeChannel find(int paramInt1, int paramInt2, DataOsdGetPushCommon.DroneType paramDroneType)
    {
      return find(paramInt1, paramInt2, paramDroneType, true);
    }
    
    public static RcModeChannel find(int paramInt1, int paramInt2, DataOsdGetPushCommon.DroneType paramDroneType, boolean paramBoolean)
    {
      if ((paramInt2 >= 14) && (paramBoolean)) {
        return DJIMcHelper.getInstance().getRcModeChannel(paramInt1);
      }
      if ((DataOsdGetPushCommon.DroneType.P4 != paramDroneType) && (DataOsdGetPushCommon.DroneType.wm220 != paramDroneType))
      {
        if (paramInt1 == 0) {
          return CHANNEL_F;
        }
        if (paramInt1 == 1) {
          return CHANNEL_A;
        }
        return CHANNEL_P;
      }
      if (paramInt1 == 0) {
        return CHANNEL_A;
      }
      if (paramInt1 == 1) {
        return CHANNEL_S;
      }
      return CHANNEL_P;
    }
    
    private static boolean isValueMatchChannelAMode(int paramInt)
    {
      return (paramInt == DataOsdGetPushCommon.RcModeChannelAfter16.ATTI.value()) || (paramInt == DataOsdGetPushCommon.RcModeChannelAfter16.ATTI_MANUAL.value());
    }
    
    private static boolean isValueMatchChannelGMode(int paramInt)
    {
      return (paramInt == DataOsdGetPushCommon.RcModeChannelAfter16.ATTI_GENTLE.value()) || (paramInt == DataOsdGetPushCommon.RcModeChannelAfter16.GPS_GENTLE.value());
    }
    
    private static boolean isValueMatchChannelMMode(int paramInt)
    {
      return paramInt == DataOsdGetPushCommon.RcModeChannelAfter16.MANUAL.value();
    }
    
    private static boolean isValueMatchChannelPMode(int paramInt)
    {
      return (paramInt == DataOsdGetPushCommon.RcModeChannelAfter16.GPS_ATTI.value()) || (paramInt == DataOsdGetPushCommon.RcModeChannelAfter16.GPS_NORMAL.value());
    }
    
    private static boolean isValueMatchChannelSMode(int paramInt)
    {
      return (paramInt == DataOsdGetPushCommon.RcModeChannelAfter16.GPS_SPORT.value()) || (paramInt == DataOsdGetPushCommon.RcModeChannelAfter16.ATTI_SPORT.value());
    }
    
    public static RcModeChannel realFind(int paramInt)
    {
      if (DataOsdGetPushCommon.getInstance().getFlycVersion() < 16)
      {
        RcModeChannel[] arrayOfRcModeChannel = values();
        int j = arrayOfRcModeChannel.length;
        int i = 0;
        while (i < j)
        {
          RcModeChannel localRcModeChannel = arrayOfRcModeChannel[i];
          if (localRcModeChannel.belongsTo(paramInt)) {
            return localRcModeChannel;
          }
          i += 1;
        }
        return CHANNEL_P;
      }
      if (isValueMatchChannelAMode(paramInt)) {
        return CHANNEL_A;
      }
      if (isValueMatchChannelPMode(paramInt)) {
        return CHANNEL_P;
      }
      if (isValueMatchChannelSMode(paramInt)) {
        return CHANNEL_S;
      }
      if (isValueMatchChannelGMode(paramInt)) {
        return CHANNEL_G;
      }
      if (isValueMatchChannelMMode(paramInt)) {
        return CHANNEL_M;
      }
      return CHANNEL_P;
    }
    
    public boolean belongsTo(int paramInt)
    {
      return this._value == paramInt;
    }
    
    public int value()
    {
      return this._value;
    }
  }
  
  static enum RcModeChannelAfter16
  {
    private static volatile RcModeChannelAfter16[] sValues = null;
    private int _value = 0;
    
    static
    {
      ATTI = new RcModeChannelAfter16("ATTI", 1, 1);
      ATTI_GENTLE = new RcModeChannelAfter16("ATTI_GENTLE", 2, 2);
      ATTI_MANUAL = new RcModeChannelAfter16("ATTI_MANUAL", 3, 3);
      ATTI_SPORT = new RcModeChannelAfter16("ATTI_SPORT", 4, 4);
      GPS_ATTI = new RcModeChannelAfter16("GPS_ATTI", 5, 5);
      GPS_GENTLE = new RcModeChannelAfter16("GPS_GENTLE", 6, 6);
      GPS_NORMAL = new RcModeChannelAfter16("GPS_NORMAL", 7, 7);
      GPS_SPORT = new RcModeChannelAfter16("GPS_SPORT", 8, 8);
      NAVIGATION = new RcModeChannelAfter16("NAVIGATION", 9, 9);
      FPV = new RcModeChannelAfter16("FPV", 10, 10);
      FARM = new RcModeChannelAfter16("FARM", 11, 11);
      RcModeChannelAfter16 localRcModeChannelAfter16 = new RcModeChannelAfter16("OTHER", 12, 255);
      OTHER = localRcModeChannelAfter16;
      $VALUES = new RcModeChannelAfter16[] { MANUAL, ATTI, ATTI_GENTLE, ATTI_MANUAL, ATTI_SPORT, GPS_ATTI, GPS_GENTLE, GPS_NORMAL, GPS_SPORT, NAVIGATION, FPV, FARM, localRcModeChannelAfter16 };
    }
    
    private RcModeChannelAfter16(int paramInt)
    {
      this._value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this._value == paramInt;
    }
    
    public static RcModeChannelAfter16 find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      RcModeChannelAfter16[] arrayOfRcModeChannelAfter16 = sValues;
      int j = arrayOfRcModeChannelAfter16.length;
      int i = 0;
      while (i < j)
      {
        RcModeChannelAfter16 localRcModeChannelAfter16 = arrayOfRcModeChannelAfter16[i];
        if (localRcModeChannelAfter16._equals(paramInt)) {
          return localRcModeChannelAfter16;
        }
        i += 1;
      }
      return OTHER;
    }
    
    public int value()
    {
      return this._value;
    }
  }
  
  public static enum SDKCtrlDevice
  {
    private int _value = 0;
    
    static
    {
      APP = new SDKCtrlDevice("APP", 1, 1);
      ONBOARD_DEVICE = new SDKCtrlDevice("ONBOARD_DEVICE", 2, 2);
      CAMERA = new SDKCtrlDevice("CAMERA", 3, 3);
      SDKCtrlDevice localSDKCtrlDevice = new SDKCtrlDevice("OTHER", 4, 128);
      OTHER = localSDKCtrlDevice;
      $VALUES = new SDKCtrlDevice[] { RC, APP, ONBOARD_DEVICE, CAMERA, localSDKCtrlDevice };
    }
    
    private SDKCtrlDevice(int paramInt)
    {
      this._value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this._value == paramInt;
    }
    
    public static SDKCtrlDevice find(int paramInt)
    {
      SDKCtrlDevice[] arrayOfSDKCtrlDevice = values();
      int j = arrayOfSDKCtrlDevice.length;
      int i = 0;
      while (i < j)
      {
        SDKCtrlDevice localSDKCtrlDevice = arrayOfSDKCtrlDevice[i];
        if (localSDKCtrlDevice._equals(paramInt)) {
          return localSDKCtrlDevice;
        }
        i += 1;
      }
      return OTHER;
    }
    
    public int value()
    {
      return this._value;
    }
  }
  
  public static enum TRIPOD_STATUS
  {
    private static volatile TRIPOD_STATUS[] sValues = null;
    private byte _value = 0;
    
    static
    {
      FOLD_COMPELTE = new TRIPOD_STATUS("FOLD_COMPELTE", 1, (byte)1);
      FOLOING = new TRIPOD_STATUS("FOLOING", 2, (byte)2);
      STRETCH_COMPLETE = new TRIPOD_STATUS("STRETCH_COMPLETE", 3, (byte)3);
      STRETCHING = new TRIPOD_STATUS("STRETCHING", 4, (byte)4);
      TRIPOD_STATUS localTRIPOD_STATUS = new TRIPOD_STATUS("STOP_DEFORMATION", 5, (byte)5);
      STOP_DEFORMATION = localTRIPOD_STATUS;
      $VALUES = new TRIPOD_STATUS[] { UNKNOWN, FOLD_COMPELTE, FOLOING, STRETCH_COMPLETE, STRETCHING, localTRIPOD_STATUS };
    }
    
    private TRIPOD_STATUS(byte paramByte)
    {
      this._value = paramByte;
    }
    
    private boolean belongsTo(byte paramByte)
    {
      return this._value == paramByte;
    }
    
    public static TRIPOD_STATUS ofValue(byte paramByte)
    {
      if (sValues == null) {
        sValues = values();
      }
      TRIPOD_STATUS[] arrayOfTRIPOD_STATUS = sValues;
      int j = arrayOfTRIPOD_STATUS.length;
      int i = 0;
      while (i < j)
      {
        TRIPOD_STATUS localTRIPOD_STATUS = arrayOfTRIPOD_STATUS[i];
        if (localTRIPOD_STATUS.belongsTo(paramByte)) {
          return localTRIPOD_STATUS;
        }
        i += 1;
      }
      return UNKNOWN;
    }
    
    public byte value()
    {
      return this._value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */