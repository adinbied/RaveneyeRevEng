package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushWayPointMissionInfo
  extends DataBase
{
  private static DataFlycGetPushWayPointMissionInfo instance;
  
  public static DataFlycGetPushWayPointMissionInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushWayPointMissionInfo();
      }
      DataFlycGetPushWayPointMissionInfo localDataFlycGetPushWayPointMissionInfo = instance;
      return localDataFlycGetPushWayPointMissionInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getCurrentHeight()
  {
    return 0;
  }
  
  public int getCurrentStatus()
  {
    return 0;
  }
  
  public int getErrorNotification()
  {
    return 0;
  }
  
  public int getFollowMeDistance()
  {
    return 0;
  }
  
  public int getFollowMeGpsLevel()
  {
    return 0;
  }
  
  public int getFollowMeReason()
  {
    return 0;
  }
  
  public int getFollowMeStatus()
  {
    return 0;
  }
  
  public int getHotPointMissionStatus()
  {
    return 0;
  }
  
  public int getHotPointRadius()
  {
    return 0;
  }
  
  public int getHotPointReason()
  {
    return 0;
  }
  
  public int getHotPointSpeed()
  {
    return 0;
  }
  
  public int getLastMissionType()
  {
    return 0;
  }
  
  public int getLimitedHeight()
  {
    return 0;
  }
  
  public int getMissionStatus()
  {
    return 0;
  }
  
  public int getMissionType()
  {
    return 0;
  }
  
  public int getReserved()
  {
    return 0;
  }
  
  public RunningStatus getRunningStatus()
  {
    return null;
  }
  
  public int getTargetWayPoint()
  {
    return 0;
  }
  
  public int getWayPointStatus()
  {
    return 0;
  }
  
  public int getWaypointMissionVelocity()
  {
    return 0;
  }
  
  public boolean isBroken()
  {
    return false;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public boolean isClockwise()
  {
    return false;
  }
  
  public boolean isPositionValid()
  {
    return false;
  }
  
  public int isTrackingEnabled()
  {
    return 0;
  }
  
  public boolean isVelocityControl()
  {
    return false;
  }
  
  public static enum RunningStatus
  {
    private int data;
    
    static
    {
      RunningStatus localRunningStatus = new RunningStatus("Paused", 2, 2);
      Paused = localRunningStatus;
      $VALUES = new RunningStatus[] { NotRunning, Running, localRunningStatus };
    }
    
    private RunningStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static RunningStatus find(int paramInt)
    {
      RunningStatus localRunningStatus = NotRunning;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localRunningStatus;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushWayPointMissionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */