package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushFixedWingState
  extends DataBase
{
  private static DataEyeGetPushFixedWingState instance;
  
  public static DataEyeGetPushFixedWingState getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushFixedWingState();
      }
      DataEyeGetPushFixedWingState localDataEyeGetPushFixedWingState = instance;
      return localDataEyeGetPushFixedWingState;
    }
    finally {}
  }
  
  public boolean cantDetour()
  {
    return false;
  }
  
  protected void doPack() {}
  
  public boolean exitByPortrait()
  {
    return false;
  }
  
  public boolean forceHoriFly()
  {
    return false;
  }
  
  public FixedWingState getFixedWingState()
  {
    return null;
  }
  
  public boolean hasDelay()
  {
    return false;
  }
  
  public boolean isBraking()
  {
    return false;
  }
  
  public boolean isDecelerating()
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
  
  public boolean isFixWingGimbalCtrled()
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
  
  public boolean isSpinning()
  {
    return false;
  }
  
  public boolean isTripodFolded()
  {
    return false;
  }
  
  public boolean rcModeError()
  {
    return false;
  }
  
  public boolean stopByUser()
  {
    return false;
  }
  
  public static enum FixedWingState
  {
    private static volatile FixedWingState[] sValues = null;
    private final int data;
    
    static
    {
      MATCH_CONDITION = new FixedWingState("MATCH_CONDITION", 1, 1);
      ALREADY = new FixedWingState("ALREADY", 2, 2);
      FixedWingState localFixedWingState = new FixedWingState("OTHER", 3, 100);
      OTHER = localFixedWingState;
      $VALUES = new FixedWingState[] { NON_MATCH, MATCH_CONDITION, ALREADY, localFixedWingState };
    }
    
    private FixedWingState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FixedWingState find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      FixedWingState localFixedWingState1 = NON_MATCH;
      FixedWingState[] arrayOfFixedWingState = sValues;
      int j = arrayOfFixedWingState.length;
      int i = 0;
      while (i < j)
      {
        FixedWingState localFixedWingState2 = arrayOfFixedWingState[i];
        if (localFixedWingState2._equals(paramInt)) {
          return localFixedWingState2;
        }
        i += 1;
      }
      return localFixedWingState1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushFixedWingState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */