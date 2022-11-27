package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushTrackStatus
  extends DataBase
{
  private static DataEyeGetPushTrackStatus instance;
  
  public static DataEyeGetPushTrackStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushTrackStatus();
      }
      DataEyeGetPushTrackStatus localDataEyeGetPushTrackStatus = instance;
      return localDataEyeGetPushTrackStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public float getCenterX()
  {
    return 0.0F;
  }
  
  public float getCenterY()
  {
    return 0.0F;
  }
  
  public int getCurrentTrackingMaximumSpeed()
  {
    return 0;
  }
  
  public TrackException getException()
  {
    return null;
  }
  
  public float getHeight()
  {
    return 0.0F;
  }
  
  public TrackMode getRectMode()
  {
    return null;
  }
  
  public short getSessionId()
  {
    return 0;
  }
  
  public TargetAction getTargetAction()
  {
    return null;
  }
  
  public TargetObjType getTargetType()
  {
    return null;
  }
  
  public DataSingleVisualParam.TrackingMode getTrackingMode()
  {
    return null;
  }
  
  public int getTrackingSpeedThreshold()
  {
    return 0;
  }
  
  public float getWidth()
  {
    return 0.0F;
  }
  
  public boolean isGpsUsed()
  {
    return false;
  }
  
  public boolean isHeadLock()
  {
    return false;
  }
  
  public boolean isHumanTarget()
  {
    return false;
  }
  
  public boolean isSpotLight()
  {
    return false;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    setRecData(paramArrayOfByte);
    if (isWantPush()) {
      post();
    }
  }
  
  public static enum TargetAction
  {
    private final int data;
    
    static
    {
      JUMP = new TargetAction("JUMP", 1, 1);
      TargetAction localTargetAction = new TargetAction("OTHER", 2, 100);
      OTHER = localTargetAction;
      $VALUES = new TargetAction[] { Non, JUMP, localTargetAction };
    }
    
    private TargetAction(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TargetAction find(int paramInt)
    {
      TargetAction localTargetAction1 = Non;
      TargetAction[] arrayOfTargetAction = values();
      int j = arrayOfTargetAction.length;
      int i = 0;
      while (i < j)
      {
        TargetAction localTargetAction2 = arrayOfTargetAction[i];
        if (localTargetAction2._equals(paramInt)) {
          return localTargetAction2;
        }
        i += 1;
      }
      return localTargetAction1;
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
  
  public static enum TargetObjType
  {
    private final int data;
    
    static
    {
      PERSON = new TargetObjType("PERSON", 1, 1);
      CAR = new TargetObjType("CAR", 2, 2);
      VAN = new TargetObjType("VAN", 3, 3);
      BIKE = new TargetObjType("BIKE", 4, 4);
      ANIMAL = new TargetObjType("ANIMAL", 5, 5);
      BOAT = new TargetObjType("BOAT", 6, 6);
      TargetObjType localTargetObjType = new TargetObjType("OTHER", 7, 100);
      OTHER = localTargetObjType;
      $VALUES = new TargetObjType[] { UNKNOWN, PERSON, CAR, VAN, BIKE, ANIMAL, BOAT, localTargetObjType };
    }
    
    private TargetObjType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TargetObjType find(int paramInt)
    {
      TargetObjType localTargetObjType1 = UNKNOWN;
      TargetObjType[] arrayOfTargetObjType = values();
      int j = arrayOfTargetObjType.length;
      int i = 0;
      while (i < j)
      {
        TargetObjType localTargetObjType2 = arrayOfTargetObjType[i];
        if (localTargetObjType2._equals(paramInt)) {
          return localTargetObjType2;
        }
        i += 1;
      }
      return localTargetObjType1;
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
  
  public static enum TrackException
  {
    private int data;
    
    static
    {
      NO_VELOCITY = new TrackException("NO_VELOCITY", 2, 2);
      NO_IMAGE_INPUT = new TrackException("NO_IMAGE_INPUT", 3, 3);
      LOW_FPS = new TrackException("LOW_FPS", 4, 4);
      LIMIT = new TrackException("LIMIT", 5, 5);
      LOST_RC = new TrackException("LOST_RC", 6, 6);
      LOST_APP = new TrackException("LOST_APP", 7, 7);
      LOST_CONTROL = new TrackException("LOST_CONTROL", 8, 9);
      APP_STOP = new TrackException("APP_STOP", 9, 10);
      EXIT_BYSELF = new TrackException("EXIT_BYSELF", 10, 11);
      QUICK_MOVIE_FINISH_NORMALLY = new TrackException("QUICK_MOVIE_FINISH_NORMALLY", 11, 12);
      QUICK_MOVIE_STOP_BY_USER = new TrackException("QUICK_MOVIE_STOP_BY_USER", 12, 13);
      SHAKE = new TrackException("SHAKE", 13, -1);
      LOW_DETECT = new TrackException("LOW_DETECT", 14, -2);
      RC_HALT = new TrackException("RC_HALT", 15, -3);
      APP_HALT = new TrackException("APP_HALT", 16, -4);
      TOO_HIGH = new TrackException("TOO_HIGH", 17, -11);
      OBSTACLE = new TrackException("OBSTACLE", 18, -12);
      PITCH_LOW = new TrackException("PITCH_LOW", 19, -13);
      TOO_FAR = new TrackException("TOO_FAR", 20, -14);
      TOO_CLOSE = new TrackException("TOO_CLOSE", 21, -15);
      DRONE_TOO_HIGH = new TrackException("DRONE_TOO_HIGH", 22, -16);
      DRONE_TOO_LOW = new TrackException("DRONE_TOO_LOW", 23, -17);
      RADAR_FAILED = new TrackException("RADAR_FAILED", 24, -18);
      TOO_SMALL = new TrackException("TOO_SMALL", 25, -21);
      TOO_LARGE = new TrackException("TOO_LARGE", 26, -22);
      NO_FEATURE = new TrackException("NO_FEATURE", 27, -23);
      TrackException localTrackException = new TrackException("OTHER", 28, 100);
      OTHER = localTrackException;
      $VALUES = new TrackException[] { NONE, TIMEOUT, NO_VELOCITY, NO_IMAGE_INPUT, LOW_FPS, LIMIT, LOST_RC, LOST_APP, LOST_CONTROL, APP_STOP, EXIT_BYSELF, QUICK_MOVIE_FINISH_NORMALLY, QUICK_MOVIE_STOP_BY_USER, SHAKE, LOW_DETECT, RC_HALT, APP_HALT, TOO_HIGH, OBSTACLE, PITCH_LOW, TOO_FAR, TOO_CLOSE, DRONE_TOO_HIGH, DRONE_TOO_LOW, RADAR_FAILED, TOO_SMALL, TOO_LARGE, NO_FEATURE, localTrackException };
    }
    
    private TrackException(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TrackException find(int paramInt)
    {
      TrackException localTrackException = NONE;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localTrackException;
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
  
  public static enum TrackMode
  {
    private int data;
    
    static
    {
      DETECT_AFTER_LOST = new TrackMode("DETECT_AFTER_LOST", 3, 3);
      TRACKING = new TrackMode("TRACKING", 4, 4);
      CONFIRM = new TrackMode("CONFIRM", 5, 5);
      PERSON = new TrackMode("PERSON", 6, 6);
      TrackMode localTrackMode = new TrackMode("OTHER", 7, 100);
      OTHER = localTrackMode;
      $VALUES = new TrackMode[] { LOST, NORMAL, WEAK, DETECT_AFTER_LOST, TRACKING, CONFIRM, PERSON, localTrackMode };
    }
    
    private TrackMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TrackMode find(int paramInt)
    {
      TrackMode localTrackMode = LOST;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localTrackMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushTrackStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */