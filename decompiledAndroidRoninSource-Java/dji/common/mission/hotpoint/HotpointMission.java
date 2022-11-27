package dji.common.mission.hotpoint;

import dji.common.error.DJIError;
import dji.common.model.LocationCoordinate2D;

public class HotpointMission
{
  public static final double MAX_ALTITUDE = 500.0D;
  public static final double MAX_RADIUS = 500.0D;
  public static final double MIN_ALTITUDE = 5.0D;
  public static final double MIN_RADIUS = 5.0D;
  private double altitude;
  private float angularVelocity;
  private HotpointHeading heading;
  private LocationCoordinate2D hotpoint;
  private boolean isClockwise = false;
  private double radius;
  private HotpointStartPoint startPoint;
  
  public HotpointMission() {}
  
  public HotpointMission(LocationCoordinate2D paramLocationCoordinate2D, double paramDouble1, double paramDouble2, float paramFloat, boolean paramBoolean, HotpointStartPoint paramHotpointStartPoint, HotpointHeading paramHotpointHeading)
  {
    this.hotpoint = paramLocationCoordinate2D;
    this.altitude = paramDouble1;
    this.radius = paramDouble2;
    this.angularVelocity = paramFloat;
    this.isClockwise = paramBoolean;
    this.startPoint = paramHotpointStartPoint;
    this.heading = paramHotpointHeading;
  }
  
  public DJIError checkParameters()
  {
    return null;
  }
  
  public double getAltitude()
  {
    return this.altitude;
  }
  
  public float getAngularVelocity()
  {
    return this.angularVelocity;
  }
  
  public HotpointHeading getHeading()
  {
    return this.heading;
  }
  
  public LocationCoordinate2D getHotpoint()
  {
    return this.hotpoint;
  }
  
  public double getRadius()
  {
    return this.radius;
  }
  
  public HotpointStartPoint getStartPoint()
  {
    return this.startPoint;
  }
  
  public boolean isClockwise()
  {
    return this.isClockwise;
  }
  
  /* Error */
  public void resetMissionWithData(HotpointMission arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setAltitude(double paramDouble)
  {
    this.altitude = paramDouble;
  }
  
  public void setAngularVelocity(float paramFloat)
  {
    this.angularVelocity = paramFloat;
  }
  
  public void setClockwise(boolean paramBoolean)
  {
    this.isClockwise = paramBoolean;
  }
  
  public void setHeading(HotpointHeading paramHotpointHeading)
  {
    this.heading = paramHotpointHeading;
  }
  
  public void setHotpoint(LocationCoordinate2D paramLocationCoordinate2D)
  {
    this.hotpoint = paramLocationCoordinate2D;
  }
  
  public void setRadius(double paramDouble)
  {
    this.radius = paramDouble;
  }
  
  public void setStartPoint(HotpointStartPoint paramHotpointStartPoint)
  {
    this.startPoint = paramHotpointStartPoint;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\hotpoint\HotpointMission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */