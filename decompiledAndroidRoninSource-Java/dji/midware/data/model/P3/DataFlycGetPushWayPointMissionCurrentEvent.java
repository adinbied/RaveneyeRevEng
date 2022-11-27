package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataFlycGetPushWayPointMissionCurrentEvent
  extends DataBase
{
  private static DataFlycGetPushWayPointMissionCurrentEvent instance;
  
  public static DataFlycGetPushWayPointMissionCurrentEvent getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushWayPointMissionCurrentEvent();
      }
      DataFlycGetPushWayPointMissionCurrentEvent localDataFlycGetPushWayPointMissionCurrentEvent = instance;
      return localDataFlycGetPushWayPointMissionCurrentEvent;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getEventType()
  {
    return 0;
  }
  
  public int getFinishIncidentIsRepeat()
  {
    return 0;
  }
  
  public int getFinishIncidentResrved()
  {
    return 0;
  }
  
  public int getReachIncidentCurrentStatus()
  {
    return 0;
  }
  
  public int getReachIncidentReserved()
  {
    return 0;
  }
  
  public int getReachIncidentWayPointIndex()
  {
    return 0;
  }
  
  public int getUploadIncidentEstimatedTime()
  {
    return 0;
  }
  
  public int getUploadIncidentIsValid()
  {
    return 0;
  }
  
  public int getUploadIncidentReserved()
  {
    return 0;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushWayPointMissionCurrentEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */