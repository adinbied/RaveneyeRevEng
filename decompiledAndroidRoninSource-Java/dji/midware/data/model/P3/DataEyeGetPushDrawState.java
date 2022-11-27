package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICommonDataBase;

public class DataEyeGetPushDrawState
  extends DJICommonDataBase
{
  private static DataEyeGetPushDrawState instance;
  
  public static DataEyeGetPushDrawState getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushDrawState();
      }
      DataEyeGetPushDrawState localDataEyeGetPushDrawState = instance;
      return localDataEyeGetPushDrawState;
    }
    finally {}
  }
  
  public boolean beInvalidHeight()
  {
    return false;
  }
  
  public boolean beInvalidPoints()
  {
    return false;
  }
  
  public boolean canDetour()
  {
    return false;
  }
  
  protected void doPack() {}
  
  public DataSingleVisualParam.DrawMode getDrawMode()
  {
    return null;
  }
  
  public int getSequence()
  {
    return 0;
  }
  
  public DrawState getState()
  {
    return null;
  }
  
  public int getTime()
  {
    return 0;
  }
  
  public int getVelocity()
  {
    return 0;
  }
  
  public boolean isBraking()
  {
    return false;
  }
  
  public boolean isComplexPoints()
  {
    return false;
  }
  
  public boolean isDecelerating()
  {
    return false;
  }
  
  public boolean isDetourLeft()
  {
    return false;
  }
  
  public boolean isDetourRight()
  {
    return false;
  }
  
  public boolean isDetourUp()
  {
    return false;
  }
  
  public boolean isDroneTooLow()
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
  
  public boolean isNearNonFlyZone()
  {
    return false;
  }
  
  public boolean isNonFlying()
  {
    return false;
  }
  
  public boolean isPaused()
  {
    return false;
  }
  
  public boolean isPullPitchStick()
  {
    return false;
  }
  
  public boolean isTripodFolded()
  {
    return false;
  }
  
  public boolean reachEndPoint()
  {
    return false;
  }
  
  public static enum DrawState
  {
    private final int data;
    
    static
    {
      PAUSE = new DrawState("PAUSE", 5, 5);
      DrawState localDrawState = new DrawState("OTHER", 6, 100);
      OTHER = localDrawState;
      $VALUES = new DrawState[] { INIT, PREPARE, READY_TO_GO, START_AUTO, START_MANUAL, PAUSE, localDrawState };
    }
    
    private DrawState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DrawState find(int paramInt)
    {
      DrawState localDrawState1 = INIT;
      DrawState[] arrayOfDrawState = values();
      int j = arrayOfDrawState.length;
      int i = 0;
      while (i < j)
      {
        DrawState localDrawState2 = arrayOfDrawState[i];
        if (localDrawState2._equals(paramInt)) {
          return localDrawState2;
        }
        i += 1;
      }
      return localDrawState1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushDrawState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */