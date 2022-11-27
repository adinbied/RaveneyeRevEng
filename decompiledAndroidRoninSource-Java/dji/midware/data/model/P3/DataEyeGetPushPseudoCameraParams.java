package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICommonDataBase;

public class DataEyeGetPushPseudoCameraParams
  extends DJICommonDataBase
{
  private static DataEyeGetPushPseudoCameraParams instance;
  
  public static DataEyeGetPushPseudoCameraParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushPseudoCameraParams();
      }
      DataEyeGetPushPseudoCameraParams localDataEyeGetPushPseudoCameraParams = instance;
      return localDataEyeGetPushPseudoCameraParams;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public PseudoCameraMode getCameraMode()
  {
    return null;
  }
  
  public int getMissionId()
  {
    return 0;
  }
  
  public PseudoCameraMissionState getMissionState()
  {
    return null;
  }
  
  public int getVersion()
  {
    return 0;
  }
  
  public static enum PseudoCameraMissionState
  {
    private final int data;
    
    static
    {
      PseudoCameraMissionState localPseudoCameraMissionState = new PseudoCameraMissionState("OTHER", 3, 255);
      OTHER = localPseudoCameraMissionState;
      $VALUES = new PseudoCameraMissionState[] { PSEUDO_CAMERA_MISSION_STATE_IDLE, PSEUDO_CAMERA_MISSION_STATE_PREPARE, PSEUDO_CAMERA_MISSION_STATE_RUNNING, localPseudoCameraMissionState };
    }
    
    private PseudoCameraMissionState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static PseudoCameraMissionState find(int paramInt)
    {
      PseudoCameraMissionState localPseudoCameraMissionState1 = OTHER;
      PseudoCameraMissionState[] arrayOfPseudoCameraMissionState = values();
      int j = arrayOfPseudoCameraMissionState.length;
      int i = 0;
      while (i < j)
      {
        PseudoCameraMissionState localPseudoCameraMissionState2 = arrayOfPseudoCameraMissionState[i];
        if (localPseudoCameraMissionState2._equals(paramInt)) {
          return localPseudoCameraMissionState2;
        }
        i += 1;
      }
      return localPseudoCameraMissionState1;
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
  
  public static enum PseudoCameraMode
  {
    private final int data;
    
    static
    {
      PSEUDO_CAMERA_MODE_BOKEH = new PseudoCameraMode("PSEUDO_CAMERA_MODE_BOKEH", 2, 4);
      PSEUDO_CAMERA_MODE_GESTURE = new PseudoCameraMode("PSEUDO_CAMERA_MODE_GESTURE", 3, 5);
      PSEUDO_CAMERA_MODE_PANO_3x1 = new PseudoCameraMode("PSEUDO_CAMERA_MODE_PANO_3x1", 4, 6);
      PSEUDO_CAMERA_MODE_PANO_3x3 = new PseudoCameraMode("PSEUDO_CAMERA_MODE_PANO_3x3", 5, 7);
      PseudoCameraMode localPseudoCameraMode = new PseudoCameraMode("OTHER", 6, 255);
      OTHER = localPseudoCameraMode;
      $VALUES = new PseudoCameraMode[] { PSEUDO_CAMERA_MODE_NONE, PSEUDO_CAMERA_MODE_PANO_1x3, PSEUDO_CAMERA_MODE_BOKEH, PSEUDO_CAMERA_MODE_GESTURE, PSEUDO_CAMERA_MODE_PANO_3x1, PSEUDO_CAMERA_MODE_PANO_3x3, localPseudoCameraMode };
    }
    
    private PseudoCameraMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static PseudoCameraMode find(int paramInt)
    {
      PseudoCameraMode localPseudoCameraMode1 = OTHER;
      PseudoCameraMode[] arrayOfPseudoCameraMode = values();
      int j = arrayOfPseudoCameraMode.length;
      int i = 0;
      while (i < j)
      {
        PseudoCameraMode localPseudoCameraMode2 = arrayOfPseudoCameraMode[i];
        if (localPseudoCameraMode2._equals(paramInt)) {
          return localPseudoCameraMode2;
        }
        i += 1;
      }
      return localPseudoCameraMode1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushPseudoCameraParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */