package dji.common.mission.waypoint;

import dji.common.error.DJIError;
import dji.common.model.LocationCoordinate2D;
import java.util.LinkedList;
import java.util.List;

public class Waypoint
{
  public static final int MAX_ACTION_COUNT = 15;
  public static final int MAX_ACTION_REPEAT_TIMES = 15;
  public static final int MAX_ACTION_TIMEOUT = 999;
  public static final float MAX_ALTITUDE = 500.0F;
  public static final float MAX_CORNER_RADIUS = 1000.0F;
  public static final float MAX_GIMBAL_PITCH = 0.0F;
  public static final int MAX_HEADING = 180;
  public static final float MAX_SPEED = 15.0F;
  public static final int MIN_ACTION_REPEAT_TIMES = 1;
  public static final int MIN_ACTION_TIMEOUT = 0;
  public static final float MIN_ALTITUDE = -200.0F;
  public static final float MIN_CORNER_RADIUS = 0.2F;
  public static final float MIN_GIMBAL_PITCH = -90.0F;
  public static final int MIN_HEADING = -180;
  public static final float MIN_SPEED = 0.0F;
  public int actionRepeatTimes = 1;
  public int actionTimeoutInSeconds = 999;
  public float altitude;
  public LocationCoordinate2D coordinate;
  public float cornerRadiusInMeters = 0.2F;
  public float gimbalPitch;
  public boolean hasAction;
  public int heading;
  public float shootPhotoDistanceInterval;
  public float shootPhotoTimeInterval;
  public float speed;
  public WaypointTurnMode turnMode;
  public List<WaypointAction> waypointActions;
  
  public Waypoint(double paramDouble1, double paramDouble2, float paramFloat)
  {
    this.coordinate = new LocationCoordinate2D(paramDouble1, paramDouble2);
    this.altitude = paramFloat;
    this.waypointActions = new LinkedList();
  }
  
  public boolean addAction(WaypointAction paramWaypointAction)
  {
    return false;
  }
  
  public boolean adjustActionAtIndex(int paramInt, WaypointAction paramWaypointAction)
  {
    return false;
  }
  
  public DJIError checkParameters()
  {
    return null;
  }
  
  public WaypointAction getActionAtIndex(int paramInt)
  {
    return null;
  }
  
  public boolean insertAction(WaypointAction paramWaypointAction, int paramInt)
  {
    return false;
  }
  
  public boolean isEqualPosition(Waypoint paramWaypoint)
  {
    return false;
  }
  
  public boolean removeAction(WaypointAction paramWaypointAction)
  {
    return this.waypointActions.remove(paramWaypointAction);
  }
  
  public boolean removeActionAtIndex(int paramInt)
  {
    return false;
  }
  
  /* Error */
  public void removeAllAction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\Waypoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */