package dji.common.mission.waypoint;

import dji.common.error.DJIError;
import dji.common.mission.MissionUtils;
import dji.common.model.LocationCoordinate2D;
import dji.midware.data.model.P3.DataFlycDownloadWayPointMissionMsg;
import dji.midware.data.model.P3.DataFlycUploadWayPointMissionMsg.ACTION_ON_RC_LOST;
import dji.midware.data.model.P3.DataFlycUploadWayPointMissionMsg.FINISH_ACTION;
import dji.midware.data.model.P3.DataFlycUploadWayPointMissionMsg.GIMBAL_PITCH_MODE;
import dji.midware.data.model.P3.DataFlycUploadWayPointMissionMsg.TRACE_MODE;
import dji.midware.data.model.P3.DataFlycUploadWayPointMissionMsg.YAW_MODE;
import java.util.ArrayList;
import java.util.List;

public final class WaypointMission
{
  public static final float MAX_AUTO_FLIGHT_SPEED = 15.0F;
  public static final float MAX_FLIGHT_SPEED = 15.0F;
  public static final int MAX_WAYPOINT_COUNT = 99;
  public static final float MIN_AUTO_FLIGHT_SPEED = -15.0F;
  public static final float MIN_FLIGHT_SPEED = 2.0F;
  public static final int MIN_REPEAT_TIME = 0;
  public static final int MIN_WAYPOINT_COUNT = 2;
  private final float autoFlightSpeed;
  private final WaypointMissionFinishedAction finishedAction;
  private final WaypointMissionFlightPathMode flightPathMode;
  private final WaypointMissionGotoWaypointMode gotoFirstWaypointMode;
  private final WaypointMissionHeadingMode headingMode;
  private final boolean isExitMissionOnRCSignalLostEnabled;
  private final boolean isGimbalPitchRotationEnabled;
  private final float maxFlightSpeed;
  private final LocationCoordinate2D pointOfInterest;
  private final int repeatTimes;
  private int waypointCount;
  private final List<Waypoint> waypointList;
  
  private WaypointMission(Builder paramBuilder)
  {
    this.waypointCount = paramBuilder.waypointCount;
    this.maxFlightSpeed = paramBuilder.maxFlightSpeed;
    this.autoFlightSpeed = paramBuilder.autoFlightSpeed;
    this.finishedAction = paramBuilder.finishedAction;
    this.headingMode = paramBuilder.headingMode;
    this.flightPathMode = paramBuilder.flightPathMode;
    this.gotoFirstWaypointMode = paramBuilder.gotoFirstWaypointMode;
    this.isExitMissionOnRCSignalLostEnabled = paramBuilder.isExitMissionOnRCSignalLostEnabled;
    this.pointOfInterest = paramBuilder.pointOfInterest;
    this.isGimbalPitchRotationEnabled = paramBuilder.isGimbalPitchRotationEnabled;
    this.repeatTimes = paramBuilder.repeatTimes;
    this.waypointList = new ArrayList(paramBuilder.waypointList);
  }
  
  public DJIError checkParameters()
  {
    return null;
  }
  
  public float getAutoFlightSpeed()
  {
    return this.autoFlightSpeed;
  }
  
  public WaypointMissionFinishedAction getFinishedAction()
  {
    return this.finishedAction;
  }
  
  public WaypointMissionFlightPathMode getFlightPathMode()
  {
    return this.flightPathMode;
  }
  
  public WaypointMissionGotoWaypointMode getGotoFirstWaypointMode()
  {
    return this.gotoFirstWaypointMode;
  }
  
  public WaypointMissionHeadingMode getHeadingMode()
  {
    return this.headingMode;
  }
  
  public float getMaxFlightSpeed()
  {
    return this.maxFlightSpeed;
  }
  
  public LocationCoordinate2D getPointOfInterest()
  {
    return this.pointOfInterest;
  }
  
  public int getRepeatTimes()
  {
    return this.repeatTimes;
  }
  
  public int getWaypointCount()
  {
    return this.waypointCount;
  }
  
  public List<Waypoint> getWaypointList()
  {
    return this.waypointList;
  }
  
  public boolean isExitMissionOnRCSignalLostEnabled()
  {
    return this.isExitMissionOnRCSignalLostEnabled;
  }
  
  public boolean isGimbalPitchRotationEnabled()
  {
    return this.isGimbalPitchRotationEnabled;
  }
  
  public static final class Builder
  {
    private float autoFlightSpeed;
    private WaypointMissionFinishedAction finishedAction;
    private WaypointMissionFlightPathMode flightPathMode;
    private WaypointMissionGotoWaypointMode gotoFirstWaypointMode;
    private WaypointMissionHeadingMode headingMode;
    private boolean isExitMissionOnRCSignalLostEnabled;
    private boolean isGimbalPitchRotationEnabled;
    private float maxFlightSpeed;
    private LocationCoordinate2D pointOfInterest;
    private int repeatTimes;
    private int waypointCount;
    private List<Waypoint> waypointList;
    
    public Builder()
    {
      this.headingMode = WaypointMissionHeadingMode.AUTO;
      this.gotoFirstWaypointMode = WaypointMissionGotoWaypointMode.SAFELY;
      this.isExitMissionOnRCSignalLostEnabled = false;
      this.isGimbalPitchRotationEnabled = false;
      this.repeatTimes = 1;
      this.waypointList = new ArrayList();
      this.waypointCount = 0;
    }
    
    public Builder(WaypointMission paramWaypointMission)
    {
      this.waypointCount = paramWaypointMission.waypointCount;
      this.maxFlightSpeed = paramWaypointMission.maxFlightSpeed;
      this.autoFlightSpeed = paramWaypointMission.autoFlightSpeed;
      this.finishedAction = paramWaypointMission.finishedAction;
      this.headingMode = paramWaypointMission.headingMode;
      this.flightPathMode = paramWaypointMission.flightPathMode;
      this.gotoFirstWaypointMode = paramWaypointMission.gotoFirstWaypointMode;
      this.isExitMissionOnRCSignalLostEnabled = paramWaypointMission.isExitMissionOnRCSignalLostEnabled;
      this.pointOfInterest = paramWaypointMission.pointOfInterest;
      this.isGimbalPitchRotationEnabled = paramWaypointMission.isGimbalPitchRotationEnabled;
      this.repeatTimes = paramWaypointMission.repeatTimes;
      this.waypointList = new ArrayList(paramWaypointMission.waypointList);
    }
    
    Builder(DataFlycDownloadWayPointMissionMsg paramDataFlycDownloadWayPointMissionMsg)
    {
      this.waypointCount = paramDataFlycDownloadWayPointMissionMsg.getWayPointCount();
      this.maxFlightSpeed = paramDataFlycDownloadWayPointMissionMsg.getCmdSpeed();
      this.autoFlightSpeed = paramDataFlycDownloadWayPointMissionMsg.getIdleSpeed();
      this.finishedAction = WaypointMissionFinishedAction.find(paramDataFlycDownloadWayPointMissionMsg.getFinishAction().value());
      this.repeatTimes = paramDataFlycDownloadWayPointMissionMsg.getRepeatNum();
      this.headingMode = WaypointMissionHeadingMode.find(paramDataFlycDownloadWayPointMissionMsg.getYawMode().value());
      this.flightPathMode = WaypointMissionFlightPathMode.find(paramDataFlycDownloadWayPointMissionMsg.getTraceMode().value());
      this.gotoFirstWaypointMode = WaypointMissionGotoWaypointMode.find(paramDataFlycDownloadWayPointMissionMsg.getGotoFirstFlag());
      DataFlycUploadWayPointMissionMsg.ACTION_ON_RC_LOST localACTION_ON_RC_LOST1 = paramDataFlycDownloadWayPointMissionMsg.getActionOnRCLost();
      DataFlycUploadWayPointMissionMsg.ACTION_ON_RC_LOST localACTION_ON_RC_LOST2 = DataFlycUploadWayPointMissionMsg.ACTION_ON_RC_LOST.EXIT_WP;
      boolean bool2 = true;
      boolean bool1;
      if (localACTION_ON_RC_LOST1 == localACTION_ON_RC_LOST2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.isExitMissionOnRCSignalLostEnabled = bool1;
      if (paramDataFlycDownloadWayPointMissionMsg.getGimbalPitchMode() == DataFlycUploadWayPointMissionMsg.GIMBAL_PITCH_MODE.PITCH_SMOOTH) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.isGimbalPitchRotationEnabled = bool1;
      this.pointOfInterest = new LocationCoordinate2D(MissionUtils.Degree(paramDataFlycDownloadWayPointMissionMsg.getHPLat()), MissionUtils.Degree(paramDataFlycDownloadWayPointMissionMsg.getHPLng()));
      this.waypointList = new ArrayList();
    }
    
    public Builder addWaypoint(Waypoint paramWaypoint)
    {
      return null;
    }
    
    public Builder autoFlightSpeed(float paramFloat)
    {
      this.autoFlightSpeed = paramFloat;
      return this;
    }
    
    public WaypointMission build()
    {
      return new WaypointMission(this, null);
    }
    
    public DJIError checkParameters()
    {
      return null;
    }
    
    public Builder finishedAction(WaypointMissionFinishedAction paramWaypointMissionFinishedAction)
    {
      this.finishedAction = paramWaypointMissionFinishedAction;
      return this;
    }
    
    public Builder flightPathMode(WaypointMissionFlightPathMode paramWaypointMissionFlightPathMode)
    {
      this.flightPathMode = paramWaypointMissionFlightPathMode;
      return this;
    }
    
    public float getAutoFlightSpeed()
    {
      return this.autoFlightSpeed;
    }
    
    public WaypointMissionFinishedAction getFinishedAction()
    {
      return this.finishedAction;
    }
    
    public WaypointMissionFlightPathMode getFlightPathMode()
    {
      return this.flightPathMode;
    }
    
    public WaypointMissionGotoWaypointMode getGotoFirstWaypointMode()
    {
      return this.gotoFirstWaypointMode;
    }
    
    public WaypointMissionHeadingMode getHeadingMode()
    {
      return this.headingMode;
    }
    
    public float getMaxFlightSpeed()
    {
      return this.maxFlightSpeed;
    }
    
    public LocationCoordinate2D getPointOfInterest()
    {
      return this.pointOfInterest;
    }
    
    public int getRepeatTimes()
    {
      return this.repeatTimes;
    }
    
    public int getWaypointCount()
    {
      return this.waypointCount;
    }
    
    public List<Waypoint> getWaypointList()
    {
      return this.waypointList;
    }
    
    public Builder gotoFirstWaypointMode(WaypointMissionGotoWaypointMode paramWaypointMissionGotoWaypointMode)
    {
      this.gotoFirstWaypointMode = paramWaypointMissionGotoWaypointMode;
      return this;
    }
    
    public Builder headingMode(WaypointMissionHeadingMode paramWaypointMissionHeadingMode)
    {
      this.headingMode = paramWaypointMissionHeadingMode;
      return this;
    }
    
    public boolean isExitMissionOnRCSignalLostEnabled()
    {
      return this.isGimbalPitchRotationEnabled;
    }
    
    public boolean isGimbalPitchRotationEnabled()
    {
      return this.isGimbalPitchRotationEnabled;
    }
    
    public boolean isMissionComplete()
    {
      return false;
    }
    
    public Builder maxFlightSpeed(float paramFloat)
    {
      this.maxFlightSpeed = paramFloat;
      return this;
    }
    
    public Builder repeatTimes(int paramInt)
    {
      this.repeatTimes = paramInt;
      return this;
    }
    
    public Builder setExitMissionOnRCSignalLostEnabled(boolean paramBoolean)
    {
      this.isExitMissionOnRCSignalLostEnabled = paramBoolean;
      return this;
    }
    
    public Builder setGimbalPitchRotationEnabled(boolean paramBoolean)
    {
      this.isGimbalPitchRotationEnabled = paramBoolean;
      return this;
    }
    
    public Builder setPointOfInterest(LocationCoordinate2D paramLocationCoordinate2D)
    {
      this.pointOfInterest = paramLocationCoordinate2D;
      return this;
    }
    
    public Builder waypointCount(int paramInt)
    {
      this.waypointCount = paramInt;
      return this;
    }
    
    public Builder waypointList(List<Waypoint> paramList)
    {
      this.waypointList = paramList;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointMission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */