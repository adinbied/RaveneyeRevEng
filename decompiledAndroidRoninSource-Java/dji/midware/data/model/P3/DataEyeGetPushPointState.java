package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushPointState
  extends DataBase
{
  private static DataEyeGetPushPointState instance;
  
  public static DataEyeGetPushPointState getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushPointState();
      }
      DataEyeGetPushPointState localDataEyeGetPushPointState = instance;
      return localDataEyeGetPushPointState;
    }
    finally {}
  }
  
  public boolean brakedByCollision()
  {
    return false;
  }
  
  public boolean cantDetour()
  {
    return false;
  }
  
  public boolean detourLeft()
  {
    return false;
  }
  
  public boolean detourRight()
  {
    return false;
  }
  
  public boolean detourUp()
  {
    return false;
  }
  
  protected void doPack() {}
  
  public float getAxisX()
  {
    return 0.0F;
  }
  
  public float getAxisY()
  {
    return 0.0F;
  }
  
  public float getAxisZ()
  {
    return 0.0F;
  }
  
  public float getMaxSpeed()
  {
    return 0.0F;
  }
  
  public int getSessionId()
  {
    return 0;
  }
  
  public DataSingleSetPointPos.TapMode getTapMode()
  {
    return null;
  }
  
  public PointMode getTragetMode()
  {
    return null;
  }
  
  public boolean isFrontDemarkError()
  {
    return false;
  }
  
  public boolean isFrontImageDiff()
  {
    return false;
  }
  
  public boolean isFrontImageOverExposure()
  {
    return false;
  }
  
  public boolean isFrontImageUnderExposure()
  {
    return false;
  }
  
  public boolean isHadTapStop()
  {
    return false;
  }
  
  public boolean isInLowFlying()
  {
    return false;
  }
  
  public boolean isInPointing()
  {
    return false;
  }
  
  public boolean isNonInFlying()
  {
    return false;
  }
  
  public boolean isOutOfRange()
  {
    return false;
  }
  
  public boolean isPaused()
  {
    return false;
  }
  
  public boolean isQuickSpinTapGo()
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
  
  public boolean isTerrianFollow()
  {
    return false;
  }
  
  public boolean isUserQuickPullPitch()
  {
    return false;
  }
  
  public boolean rcNotInFMode()
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
  
  public static enum PointMode
  {
    private int data;
    
    static
    {
      CANT_FLY = new PointMode("CANT_FLY", 1, 1);
      FLYING = new PointMode("FLYING", 2, 2);
      END_FLY = new PointMode("END_FLY", 3, 3);
      PointMode localPointMode = new PointMode("OTHER", 4, 100);
      OTHER = localPointMode;
      $VALUES = new PointMode[] { HIDE, CANT_FLY, FLYING, END_FLY, localPointMode };
    }
    
    private PointMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static PointMode find(int paramInt)
    {
      PointMode localPointMode = HIDE;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPointMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushPointState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */