package dji.common.mission;

import dji.common.mission.waypoint.WaypointMission;
import dji.common.model.LocationCoordinate2D;
import java.util.List;

public class MissionUtils
{
  public static double Degree(double paramDouble)
  {
    return paramDouble * 180.0D / 3.141592653589793D;
  }
  
  public static double Radian(double paramDouble)
  {
    return paramDouble * 3.141592653589793D / 180.0D;
  }
  
  public static boolean checkValidGPSCoordinate(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 > -90.0D) && (paramDouble1 < 90.0D) && (paramDouble2 > -180.0D) && (paramDouble2 < 180.0D);
  }
  
  public static boolean isGPSCoordinateValid(LocationCoordinate2D paramLocationCoordinate2D)
  {
    return (paramLocationCoordinate2D != null) && (paramLocationCoordinate2D.getLatitude() > -90.0D) && (paramLocationCoordinate2D.getLatitude() < 90.0D) && (paramLocationCoordinate2D.getLongitude() > -180.0D) && (paramLocationCoordinate2D.getLongitude() < 180.0D);
  }
  
  public static boolean isWaypointMissionComplete(WaypointMission paramWaypointMission)
  {
    return (paramWaypointMission.getWaypointCount() != 0) && (paramWaypointMission.getWaypointList() != null) && (paramWaypointMission.getWaypointCount() == paramWaypointMission.getWaypointList().size());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\MissionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */