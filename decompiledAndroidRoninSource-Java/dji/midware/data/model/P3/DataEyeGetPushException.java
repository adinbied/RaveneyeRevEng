package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICommonDataBase;

public class DataEyeGetPushException
  extends DJICommonDataBase
{
  private static DataEyeGetPushException instance;
  
  public static DataEyeGetPushException getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushException();
      }
      DataEyeGetPushException localDataEyeGetPushException = instance;
      return localDataEyeGetPushException;
    }
    finally {}
  }
  
  public boolean brakedByCollision()
  {
    return false;
  }
  
  public boolean brakedByCollisionInTracking()
  {
    return false;
  }
  
  public boolean cantDetour()
  {
    return false;
  }
  
  public boolean cantDetourInTracking()
  {
    return false;
  }
  
  public boolean detourDownInTracking()
  {
    return false;
  }
  
  public boolean detourLeft()
  {
    return false;
  }
  
  public boolean detourLeftInTracking()
  {
    return false;
  }
  
  public boolean detourRight()
  {
    return false;
  }
  
  public boolean detourRightInTracking()
  {
    return false;
  }
  
  public boolean detourUp()
  {
    return false;
  }
  
  public boolean detourUpInTracking()
  {
    return false;
  }
  
  protected void doPack() {}
  
  public AdvanceGoHomeState getAdvanceGoHomeState()
  {
    return null;
  }
  
  public AdvanceGoHomeStrategy getAdvanceGoHomeStrategy()
  {
    return null;
  }
  
  public PreciseLandingState getPreciseLandingState()
  {
    return null;
  }
  
  public TrackExceptionStatus getTrackStatus()
  {
    return null;
  }
  
  public AircraftVisionStatus getVisionStatus()
  {
    return null;
  }
  
  public long getVisionVersion()
  {
    return 277666647L;
  }
  
  public boolean isAPPDisconnect()
  {
    return false;
  }
  
  public boolean isAdjustingPreciseLanding()
  {
    return false;
  }
  
  public boolean isAircraftGpsAbnormal()
  {
    return false;
  }
  
  public boolean isAvoidOkInTracking()
  {
    return false;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public boolean isDeceleratingInTracking()
  {
    return false;
  }
  
  public boolean isDisparityPackLost()
  {
    return false;
  }
  
  public boolean isEffectedByObstacle()
  {
    return false;
  }
  
  public boolean isExecutingPreciseLanding()
  {
    return false;
  }
  
  public boolean isFaceDetectEnable()
  {
    return false;
  }
  
  public boolean isFronImageOverExposure()
  {
    return false;
  }
  
  public boolean isFronImageUnderExposure()
  {
    return false;
  }
  
  public boolean isFrontImageDiff()
  {
    return false;
  }
  
  public boolean isFrontSensorDemarkAbnormal()
  {
    return false;
  }
  
  public boolean isFrontVisoinError()
  {
    return false;
  }
  
  public boolean isFusionDataAbnormal()
  {
    return false;
  }
  
  public boolean isGPSError()
  {
    return false;
  }
  
  public boolean isGimbalPackLost()
  {
    return false;
  }
  
  public boolean isGpsTrackingEnable()
  {
    return false;
  }
  
  public boolean isGpsTrackingFlusionAbnormal()
  {
    return false;
  }
  
  public boolean isIMUPackLost()
  {
    return false;
  }
  
  public boolean isInAdvanceHoming()
  {
    return false;
  }
  
  public boolean isInDraw()
  {
    return false;
  }
  
  public boolean isInFrobidFlyZone()
  {
    return false;
  }
  
  public boolean isInLowFlying()
  {
    return false;
  }
  
  public boolean isInNonFlyZone()
  {
    return false;
  }
  
  public boolean isInPointing()
  {
    return false;
  }
  
  public boolean isInPreciseLanding()
  {
    return false;
  }
  
  public boolean isInTapFly()
  {
    return false;
  }
  
  public boolean isInTracking()
  {
    return false;
  }
  
  public boolean isMovingObjectDetectEnable()
  {
    return false;
  }
  
  public boolean isNearNonFlyZone()
  {
    return false;
  }
  
  public boolean isNonFlying()
  {
    return false;
  }
  
  public boolean isOutOfControl()
  {
    return false;
  }
  
  public boolean isOutOfRange()
  {
    return false;
  }
  
  public boolean isPhoneGpsAbnormal()
  {
    return false;
  }
  
  public boolean isPointSystemAbnormal()
  {
    return false;
  }
  
  public boolean isQuickMovieExecuting()
  {
    return false;
  }
  
  public boolean isRCDisconnect()
  {
    return false;
  }
  
  public boolean isRCPackLost()
  {
    return false;
  }
  
  public boolean isReachDistanceLimit()
  {
    return false;
  }
  
  public boolean isReachHeightLimit()
  {
    return false;
  }
  
  public boolean isRunningDelay()
  {
    return false;
  }
  
  public boolean isStickAdd()
  {
    return false;
  }
  
  public boolean isTrackSystemAbnormal()
  {
    return false;
  }
  
  public boolean isTripodFolded()
  {
    return false;
  }
  
  public boolean isUserQuickPullPitch()
  {
    return false;
  }
  
  public boolean isUserTapStop()
  {
    return false;
  }
  
  public boolean isVisualDataAbnormal()
  {
    return false;
  }
  
  public boolean rcNotInFMode()
  {
    return false;
  }
  
  public boolean supportHomingSenseGH()
  {
    return false;
  }
  
  public static enum AdvanceGoHomeState
  {
    private static volatile AdvanceGoHomeState[] sValues = null;
    private int data;
    
    static
    {
      EXECUTING_GO_HOME = new AdvanceGoHomeState("EXECUTING_GO_HOME", 2, 2);
      HOVERING_AT_SAFE_POINT = new AdvanceGoHomeState("HOVERING_AT_SAFE_POINT", 3, 3);
      PLANING = new AdvanceGoHomeState("PLANING", 4, 4);
      AdvanceGoHomeState localAdvanceGoHomeState = new AdvanceGoHomeState("OTHER", 5, 100);
      OTHER = localAdvanceGoHomeState;
      $VALUES = new AdvanceGoHomeState[] { NO_ACTION, TURNING_YAW, EXECUTING_GO_HOME, HOVERING_AT_SAFE_POINT, PLANING, localAdvanceGoHomeState };
    }
    
    private AdvanceGoHomeState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static AdvanceGoHomeState find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      AdvanceGoHomeState localAdvanceGoHomeState = OTHER;
      int i = 0;
      while (i < sValues.length)
      {
        if (sValues[i]._equals(paramInt)) {
          return sValues[i];
        }
        i += 1;
      }
      return localAdvanceGoHomeState;
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
  
  public static enum AdvanceGoHomeStrategy
  {
    private static volatile AdvanceGoHomeStrategy[] sValues = null;
    private int data;
    
    static
    {
      EXPLORE_STRATEGY = new AdvanceGoHomeStrategy("EXPLORE_STRATEGY", 2, 2);
      AdvanceGoHomeStrategy localAdvanceGoHomeStrategy = new AdvanceGoHomeStrategy("OTHER", 3, 100);
      OTHER = localAdvanceGoHomeStrategy;
      $VALUES = new AdvanceGoHomeStrategy[] { NO_STRATEGY, SAFE_STRATEGY, EXPLORE_STRATEGY, localAdvanceGoHomeStrategy };
    }
    
    private AdvanceGoHomeStrategy(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static AdvanceGoHomeStrategy find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      AdvanceGoHomeStrategy localAdvanceGoHomeStrategy = OTHER;
      int i = 0;
      while (i < sValues.length)
      {
        if (sValues[i]._equals(paramInt)) {
          return sValues[i];
        }
        i += 1;
      }
      return localAdvanceGoHomeStrategy;
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
  
  public static enum AircraftVisionStatus
  {
    private static volatile AircraftVisionStatus[] sValues = null;
    private int data;
    
    static
    {
      POINTING_CONTROL = new AircraftVisionStatus("POINTING_CONTROL", 2, 2);
      ADVANCE_HOMING = new AircraftVisionStatus("ADVANCE_HOMING", 3, 4);
      PRECISE_LANDING = new AircraftVisionStatus("PRECISE_LANDING", 4, 8);
      AircraftVisionStatus localAircraftVisionStatus = new AircraftVisionStatus("OTHER", 5, 100);
      OTHER = localAircraftVisionStatus;
      $VALUES = new AircraftVisionStatus[] { NONE, TRACKING_CONTROL, POINTING_CONTROL, ADVANCE_HOMING, PRECISE_LANDING, localAircraftVisionStatus };
    }
    
    private AircraftVisionStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static AircraftVisionStatus find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      AircraftVisionStatus localAircraftVisionStatus = NONE;
      int i = 0;
      while (i < sValues.length)
      {
        if (sValues[i]._equals(paramInt)) {
          return sValues[i];
        }
        i += 1;
      }
      return localAircraftVisionStatus;
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
  
  public static enum PreciseLandingState
  {
    private static volatile PreciseLandingState[] sValues = null;
    private int data;
    
    static
    {
      LANDING = new PreciseLandingState("LANDING", 2, 2);
      PreciseLandingState localPreciseLandingState = new PreciseLandingState("OTHER", 3, 100);
      OTHER = localPreciseLandingState;
      $VALUES = new PreciseLandingState[] { NO_ACTION, TURNING_YAW, LANDING, localPreciseLandingState };
    }
    
    private PreciseLandingState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static PreciseLandingState find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      PreciseLandingState localPreciseLandingState = OTHER;
      int i = 0;
      while (i < sValues.length)
      {
        if (sValues[i]._equals(paramInt)) {
          return sValues[i];
        }
        i += 1;
      }
      return localPreciseLandingState;
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
  
  public static enum TrackExceptionStatus
  {
    private static volatile TrackExceptionStatus[] sValues = null;
    private int data;
    
    static
    {
      LOST_TIMEOUT = new TrackExceptionStatus("LOST_TIMEOUT", 1, 1);
      INVALID_SPEED = new TrackExceptionStatus("INVALID_SPEED", 2, 2);
      NONE_IMAGE = new TrackExceptionStatus("NONE_IMAGE", 3, 3);
      LOW_FRAME = new TrackExceptionStatus("LOW_FRAME", 4, 4);
      NFZ = new TrackExceptionStatus("NFZ", 5, 5);
      RCCONN_TIMEOUT = new TrackExceptionStatus("RCCONN_TIMEOUT", 6, 6);
      APPCONN_TIMEOUT = new TrackExceptionStatus("APPCONN_TIMEOUT", 7, 7);
      LOST_CONTROL = new TrackExceptionStatus("LOST_CONTROL", 8, 9);
      APP_STOP = new TrackExceptionStatus("APP_STOP", 9, 10);
      EXIT_BYSELF = new TrackExceptionStatus("EXIT_BYSELF", 10, 11);
      TOO_SMALL = new TrackExceptionStatus("TOO_SMALL", 11, -21);
      TOO_LARGE = new TrackExceptionStatus("TOO_LARGE", 12, -22);
      NO_DETECT = new TrackExceptionStatus("NO_DETECT", 13, -23);
      PITCH_LOW = new TrackExceptionStatus("PITCH_LOW", 14, -24);
      TrackExceptionStatus localTrackExceptionStatus = new TrackExceptionStatus("OTHER", 15, 100);
      OTHER = localTrackExceptionStatus;
      $VALUES = new TrackExceptionStatus[] { NORMAL, LOST_TIMEOUT, INVALID_SPEED, NONE_IMAGE, LOW_FRAME, NFZ, RCCONN_TIMEOUT, APPCONN_TIMEOUT, LOST_CONTROL, APP_STOP, EXIT_BYSELF, TOO_SMALL, TOO_LARGE, NO_DETECT, PITCH_LOW, localTrackExceptionStatus };
    }
    
    private TrackExceptionStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TrackExceptionStatus find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      TrackExceptionStatus localTrackExceptionStatus = NORMAL;
      int i = 0;
      while (i < sValues.length)
      {
        if (sValues[i]._equals(paramInt)) {
          return sValues[i];
        }
        i += 1;
      }
      return localTrackExceptionStatus;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */