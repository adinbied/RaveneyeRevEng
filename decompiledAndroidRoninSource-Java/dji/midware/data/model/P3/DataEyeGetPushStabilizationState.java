package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushStabilizationState
  extends DataBase
{
  private static DataEyeGetPushStabilizationState instance;
  
  public static DataEyeGetPushStabilizationState getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushStabilizationState();
      }
      DataEyeGetPushStabilizationState localDataEyeGetPushStabilizationState = instance;
      return localDataEyeGetPushStabilizationState;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public PauseReason getPauseReason()
  {
    return null;
  }
  
  public boolean getStateIsPaused()
  {
    return false;
  }
  
  public boolean getStateIsTurnOn()
  {
    return false;
  }
  
  public static enum PauseReason
  {
    private final int data;
    
    static
    {
      CameraChanging = new PauseReason("CameraChanging", 1, 1);
      GimbalMoving = new PauseReason("GimbalMoving", 2, 2);
      DroneMoving = new PauseReason("DroneMoving", 3, 3);
      Tracking = new PauseReason("Tracking", 4, 4);
      PauseReason localPauseReason = new PauseReason("OTHER", 5, 255);
      OTHER = localPauseReason;
      $VALUES = new PauseReason[] { UnCharacteristic, CameraChanging, GimbalMoving, DroneMoving, Tracking, localPauseReason };
    }
    
    private PauseReason(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static PauseReason find(int paramInt)
    {
      PauseReason localPauseReason1 = OTHER;
      PauseReason[] arrayOfPauseReason = values();
      int j = arrayOfPauseReason.length;
      int i = 0;
      while (i < j)
      {
        PauseReason localPauseReason2 = arrayOfPauseReason[i];
        if (localPauseReason2._equals(paramInt)) {
          return localPauseReason2;
        }
        i += 1;
      }
      return localPauseReason1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushStabilizationState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */