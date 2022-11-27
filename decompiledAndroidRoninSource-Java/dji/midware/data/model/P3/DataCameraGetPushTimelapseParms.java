package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;
import java.util.ArrayList;

public class DataCameraGetPushTimelapseParms
  extends DJICameraDataBase
{
  private static DataCameraGetPushTimelapseParms instance;
  
  public static DataCameraGetPushTimelapseParms getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushTimelapseParms();
      }
      DataCameraGetPushTimelapseParms localDataCameraGetPushTimelapseParms = instance;
      return localDataCameraGetPushTimelapseParms;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getControlMode()
  {
    return 0;
  }
  
  public int getDuration(int paramInt)
  {
    return 0;
  }
  
  public ArrayList<TimelapsePushPointInfo> getGimbalInfoPoints()
  {
    return null;
  }
  
  public int getGimbalPointCount()
  {
    return 0;
  }
  
  public int getInterval(int paramInt)
  {
    return 0;
  }
  
  public int getPitch(int paramInt)
  {
    return 0;
  }
  
  public int getRoll(int paramInt)
  {
    return 0;
  }
  
  public int getTotalDuration()
  {
    return 0;
  }
  
  public int getYaw(int paramInt)
  {
    return 0;
  }
  
  public class TimelapsePushPointInfo
  {
    public int duration = 0;
    public int interval = 0;
    public int pitch = 0;
    public int roll = 0;
    public int yaw = 0;
    
    public TimelapsePushPointInfo() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushTimelapseParms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */