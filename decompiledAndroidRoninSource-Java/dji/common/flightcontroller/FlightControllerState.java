package dji.common.flightcontroller;

import dji.common.model.LocationCoordinate2D;

public class FlightControllerState
{
  private int aircraftHeadDirection;
  private LocationCoordinate3D aircraftLocation;
  private Attitude attitude;
  private BatteryThresholdBehavior batteryThresholdBehavior;
  private boolean doesUltrasonicHaveError;
  private FlightMode flightMode;
  private String flightModeString;
  private int flightTimeInSeconds;
  private GoHomeAssessment goHomeAssessment;
  private GoHomeExecutionState goHomeExecutionState;
  private int goHomeHeight;
  private GPSSignalLevel gpsSignalLevel;
  private boolean hasReachedMaxFlightHeight;
  private boolean hasReachedMaxFlightRadius;
  private LocationCoordinate2D homeLocation;
  private float homePointAltitude;
  private boolean isFailsafeEnabled;
  private boolean isFlying;
  private boolean isGoingHome;
  private boolean isHomeLocationSet;
  private boolean isIMUPreheating;
  private boolean isMultipModeOpen;
  private boolean isUltrasonicBeingUsed;
  private boolean isVisionPositioningSensorBeingUsed;
  private boolean motorsOn;
  private FlightOrientationMode orientationMode;
  private int satelliteCount;
  private float ultrasonicHeightInMeters;
  private float velocityX;
  private float velocityY;
  private float velocityZ;
  
  public boolean areMotorsOn()
  {
    return this.motorsOn;
  }
  
  public boolean doesUltrasonicHaveError()
  {
    return this.doesUltrasonicHaveError;
  }
  
  public int getAircraftHeadDirection()
  {
    return this.aircraftHeadDirection;
  }
  
  public LocationCoordinate3D getAircraftLocation()
  {
    return this.aircraftLocation;
  }
  
  public Attitude getAttitude()
  {
    return this.attitude;
  }
  
  public BatteryThresholdBehavior getBatteryThresholdBehavior()
  {
    return this.batteryThresholdBehavior;
  }
  
  public FlightMode getFlightMode()
  {
    return this.flightMode;
  }
  
  public String getFlightModeString()
  {
    return this.flightModeString;
  }
  
  public int getFlightTimeInSeconds()
  {
    return this.flightTimeInSeconds;
  }
  
  public GPSSignalLevel getGPSSignalLevel()
  {
    return this.gpsSignalLevel;
  }
  
  public GoHomeAssessment getGoHomeAssessment()
  {
    return null;
  }
  
  public GoHomeExecutionState getGoHomeExecutionState()
  {
    return this.goHomeExecutionState;
  }
  
  public int getGoHomeHeight()
  {
    return this.goHomeHeight;
  }
  
  public LocationCoordinate2D getHomeLocation()
  {
    return this.homeLocation;
  }
  
  public float getHomePointAltitude()
  {
    return this.homePointAltitude;
  }
  
  public FlightOrientationMode getOrientationMode()
  {
    return this.orientationMode;
  }
  
  public int getSatelliteCount()
  {
    return this.satelliteCount;
  }
  
  public float getUltrasonicHeightInMeters()
  {
    return this.ultrasonicHeightInMeters;
  }
  
  public float getVelocityX()
  {
    return this.velocityX;
  }
  
  public float getVelocityY()
  {
    return this.velocityY;
  }
  
  public float getVelocityZ()
  {
    return this.velocityZ;
  }
  
  public boolean hasReachedMaxFlightHeight()
  {
    return this.hasReachedMaxFlightHeight;
  }
  
  public boolean hasReachedMaxFlightRadius()
  {
    return this.hasReachedMaxFlightRadius;
  }
  
  public boolean isFailsafeEnabled()
  {
    return this.isFailsafeEnabled;
  }
  
  public boolean isFlying()
  {
    return this.isFlying;
  }
  
  public boolean isGoingHome()
  {
    return this.isGoingHome;
  }
  
  public boolean isHomeLocationSet()
  {
    return this.isHomeLocationSet;
  }
  
  public boolean isIMUPreheating()
  {
    return this.isIMUPreheating;
  }
  
  public boolean isLandingConfirmationNeeded()
  {
    return false;
  }
  
  public boolean isMultipleModeOpen()
  {
    return this.isMultipModeOpen;
  }
  
  public boolean isUltrasonicBeingUsed()
  {
    return this.isUltrasonicBeingUsed;
  }
  
  public boolean isVisionPositioningSensorBeingUsed()
  {
    return this.isVisionPositioningSensorBeingUsed;
  }
  
  public void setAircraftHeadDirection(int paramInt)
  {
    this.aircraftHeadDirection = paramInt;
  }
  
  public void setAircraftLocation(LocationCoordinate3D paramLocationCoordinate3D)
  {
    this.aircraftLocation = paramLocationCoordinate3D;
  }
  
  public void setAttitude(Attitude paramAttitude)
  {
    this.attitude = paramAttitude;
  }
  
  public void setBatteryThresholdBehavior(BatteryThresholdBehavior paramBatteryThresholdBehavior)
  {
    this.batteryThresholdBehavior = paramBatteryThresholdBehavior;
  }
  
  public void setDoesUltrasonicHaveError(boolean paramBoolean)
  {
    this.doesUltrasonicHaveError = paramBoolean;
  }
  
  public void setFailsafeEnabled(boolean paramBoolean)
  {
    this.isFailsafeEnabled = paramBoolean;
  }
  
  public void setFlightMode(FlightMode paramFlightMode)
  {
    this.flightMode = paramFlightMode;
  }
  
  public void setFlightModeString(String paramString)
  {
    this.flightModeString = paramString;
  }
  
  public void setFlightTimeInSeconds(int paramInt)
  {
    this.flightTimeInSeconds = paramInt;
  }
  
  public void setFlying(boolean paramBoolean)
  {
    this.isFlying = paramBoolean;
  }
  
  public void setGPSSignalLevel(GPSSignalLevel paramGPSSignalLevel)
  {
    this.gpsSignalLevel = paramGPSSignalLevel;
  }
  
  public void setGoHomeAssessment(GoHomeAssessment paramGoHomeAssessment)
  {
    this.goHomeAssessment = paramGoHomeAssessment;
  }
  
  public void setGoHomeExecutionState(GoHomeExecutionState paramGoHomeExecutionState)
  {
    this.goHomeExecutionState = paramGoHomeExecutionState;
  }
  
  public void setGoHomeHeight(int paramInt)
  {
    this.goHomeHeight = paramInt;
  }
  
  public void setGoingHome(boolean paramBoolean)
  {
    this.isGoingHome = paramBoolean;
  }
  
  public void setHasReachedMaxFlightHeight(boolean paramBoolean)
  {
    this.hasReachedMaxFlightHeight = paramBoolean;
  }
  
  public void setHasReachedMaxFlightRadius(boolean paramBoolean)
  {
    this.hasReachedMaxFlightRadius = paramBoolean;
  }
  
  public void setHomeLocation(LocationCoordinate2D paramLocationCoordinate2D)
  {
    this.homeLocation = paramLocationCoordinate2D;
  }
  
  public void setHomeLocationSet(boolean paramBoolean)
  {
    this.isHomeLocationSet = paramBoolean;
  }
  
  public void setHomePointAltitude(float paramFloat)
  {
    this.homePointAltitude = paramFloat;
  }
  
  public void setIMUPreheating(boolean paramBoolean)
  {
    this.isIMUPreheating = paramBoolean;
  }
  
  public void setMotorsOn(boolean paramBoolean)
  {
    this.motorsOn = paramBoolean;
  }
  
  public void setMultipModeOpen(boolean paramBoolean)
  {
    this.isMultipModeOpen = paramBoolean;
  }
  
  public void setOrientationMode(FlightOrientationMode paramFlightOrientationMode)
  {
    this.orientationMode = paramFlightOrientationMode;
  }
  
  public void setSatelliteCount(int paramInt)
  {
    this.satelliteCount = paramInt;
  }
  
  public void setUltrasonicBeingUsed(boolean paramBoolean)
  {
    this.isUltrasonicBeingUsed = paramBoolean;
  }
  
  public void setUltrasonicHeightInMeters(float paramFloat)
  {
    this.ultrasonicHeightInMeters = paramFloat;
  }
  
  public void setVelocityX(float paramFloat)
  {
    this.velocityX = paramFloat;
  }
  
  public void setVelocityY(float paramFloat)
  {
    this.velocityY = paramFloat;
  }
  
  public void setVelocityZ(float paramFloat)
  {
    this.velocityZ = paramFloat;
  }
  
  public void setVisionPositioningSensorBeingUsed(boolean paramBoolean)
  {
    this.isVisionPositioningSensorBeingUsed = paramBoolean;
  }
  
  public String toString()
  {
    return null;
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(FlightControllerState paramFlightControllerState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\FlightControllerState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */