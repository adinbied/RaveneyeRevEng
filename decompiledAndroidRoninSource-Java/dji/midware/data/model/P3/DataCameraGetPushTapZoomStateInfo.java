package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;

public class DataCameraGetPushTapZoomStateInfo
  extends DJICameraDataBase
{
  private static DataCameraGetPushTapZoomStateInfo instance;
  
  public static DataCameraGetPushTapZoomStateInfo getInstance()
  {
    try
    {
      if (instance == null)
      {
        localDataCameraGetPushTapZoomStateInfo = new DataCameraGetPushTapZoomStateInfo();
        instance = localDataCameraGetPushTapZoomStateInfo;
        localDataCameraGetPushTapZoomStateInfo.isNeedPushLosed = true;
      }
      DataCameraGetPushTapZoomStateInfo localDataCameraGetPushTapZoomStateInfo = instance;
      return localDataCameraGetPushTapZoomStateInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getGimbalState()
  {
    return 0;
  }
  
  public int getMultiplier()
  {
    return 0;
  }
  
  public WorkingState getWorkingState()
  {
    return null;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    super.setPushRecData(paramArrayOfByte);
  }
  
  public static enum WorkingState
  {
    private int value;
    
    static
    {
      WorkingState localWorkingState = new WorkingState("Unknown", 3, 255);
      Unknown = localWorkingState;
      $VALUES = new WorkingState[] { IDLE, ZOOM_IN, ZOOM_OUT, localWorkingState };
    }
    
    private WorkingState(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static WorkingState find(int paramInt)
    {
      WorkingState localWorkingState = Unknown;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localWorkingState;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushTapZoomStateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */