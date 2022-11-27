package dji.common.flightcontroller;

import dji.common.error.DJIError;
import dji.common.model.LocationCoordinate2D;

public final class RTKState
{
  private final float bsAltitude;
  private final LocationCoordinate2D bsLocation;
  private final ReceiverInfo bsReceiverBeiDouInfo;
  private final ReceiverInfo bsReceiverGLONASSInfo;
  private final ReceiverInfo bsReceiverGPSInfo;
  private final DJIError error;
  private final float heading;
  private final boolean isHeadingValid;
  private final boolean isRTKEnabled;
  private final float msAntenna1Altitude;
  private final LocationCoordinate2D msAntenna1Location;
  private final ReceiverInfo msReceiver1BeiDouInfo;
  private final ReceiverInfo msReceiver1GLONASSInfo;
  private final ReceiverInfo msReceiver1GPSInfo;
  private final ReceiverInfo msReceiver2BeiDouInfo;
  private final ReceiverInfo msReceiver2GLONASSInfo;
  private final ReceiverInfo msReceiver2GPSInfo;
  private final PositioningSolution positioningSolution;
  
  public RTKState(Builder paramBuilder)
  {
    this.error = paramBuilder.error;
    this.positioningSolution = paramBuilder.positioningSolution;
    this.msReceiver1GPSInfo = paramBuilder.msReceiver1GPSInfo;
    this.msReceiver2GPSInfo = paramBuilder.msReceiver2GPSInfo;
    this.bsReceiverGPSInfo = paramBuilder.bsReceiverGPSInfo;
    this.msReceiver1BeiDouInfo = paramBuilder.msReceiver1BeiDouInfo;
    this.msReceiver2BeiDouInfo = paramBuilder.msReceiver2BeiDouInfo;
    this.bsReceiverBeiDouInfo = paramBuilder.bsReceiverBeiDouInfo;
    this.msReceiver1GLONASSInfo = paramBuilder.msReceiver1GLONASSInfo;
    this.msReceiver2GLONASSInfo = paramBuilder.msReceiver2GLONASSInfo;
    this.bsReceiverGLONASSInfo = paramBuilder.bsReceiverGLONASSInfo;
    this.msAntenna1Location = paramBuilder.msAntenna1Location;
    this.msAntenna1Altitude = paramBuilder.msAntenna1Altitude;
    this.bsLocation = paramBuilder.bsLocation;
    this.bsAltitude = paramBuilder.bsAltitude;
    this.heading = paramBuilder.heading;
    this.isHeadingValid = paramBuilder.isHeadingValid;
    this.isRTKEnabled = paramBuilder.isRTKEnabled;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public float getBaseStationAltitude()
  {
    return this.bsAltitude;
  }
  
  public LocationCoordinate2D getBaseStationLocation()
  {
    return this.bsLocation;
  }
  
  public ReceiverInfo getBaseStationReceiverBeiDouInfo()
  {
    return this.bsReceiverBeiDouInfo;
  }
  
  public ReceiverInfo getBaseStationReceiverGLONASSInfo()
  {
    return this.bsReceiverGLONASSInfo;
  }
  
  public ReceiverInfo getBaseStationReceiverGPSInfo()
  {
    return this.bsReceiverGPSInfo;
  }
  
  public DJIError getError()
  {
    return this.error;
  }
  
  public float getHeading()
  {
    return this.heading;
  }
  
  public float getMobileStationAltitude()
  {
    return this.msAntenna1Altitude;
  }
  
  public LocationCoordinate2D getMobileStationLocation()
  {
    return this.msAntenna1Location;
  }
  
  public ReceiverInfo getMobileStationReceiver1BeiDouInfo()
  {
    return this.msReceiver1BeiDouInfo;
  }
  
  public ReceiverInfo getMobileStationReceiver1GLONASSInfo()
  {
    return this.msReceiver1GLONASSInfo;
  }
  
  public ReceiverInfo getMobileStationReceiver1GPSInfo()
  {
    return this.msReceiver1GPSInfo;
  }
  
  public ReceiverInfo getMobileStationReceiver2BeiDouInfo()
  {
    return this.msReceiver2BeiDouInfo;
  }
  
  public ReceiverInfo getMobileStationReceiver2GLONASSInfo()
  {
    return this.msReceiver2GLONASSInfo;
  }
  
  public ReceiverInfo getMobileStationReceiver2GPSInfo()
  {
    return this.msReceiver2GPSInfo;
  }
  
  public PositioningSolution getPositioningSolution()
  {
    return this.positioningSolution;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isHeadingValid()
  {
    return this.isHeadingValid;
  }
  
  public boolean isRTKEnabled()
  {
    return this.isRTKEnabled;
  }
  
  public static final class Builder
  {
    private float bsAltitude;
    private LocationCoordinate2D bsLocation;
    private ReceiverInfo bsReceiverBeiDouInfo;
    private ReceiverInfo bsReceiverGLONASSInfo;
    private ReceiverInfo bsReceiverGPSInfo;
    private DJIError error;
    private float heading;
    private boolean isHeadingValid;
    private boolean isRTKEnabled;
    private float msAntenna1Altitude;
    private LocationCoordinate2D msAntenna1Location;
    private ReceiverInfo msReceiver1BeiDouInfo;
    private ReceiverInfo msReceiver1GLONASSInfo;
    private ReceiverInfo msReceiver1GPSInfo;
    private ReceiverInfo msReceiver2BeiDouInfo;
    private ReceiverInfo msReceiver2GLONASSInfo;
    private ReceiverInfo msReceiver2GPSInfo;
    private PositioningSolution positioningSolution;
    
    public Builder bsAltitude(float paramFloat)
    {
      this.bsAltitude = paramFloat;
      return this;
    }
    
    public Builder bsLocation(LocationCoordinate2D paramLocationCoordinate2D)
    {
      this.bsLocation = paramLocationCoordinate2D;
      return this;
    }
    
    public Builder bsReceiverBeiDouInfo(ReceiverInfo paramReceiverInfo)
    {
      this.bsReceiverBeiDouInfo = paramReceiverInfo;
      return this;
    }
    
    public Builder bsReceiverGLONASSInfo(ReceiverInfo paramReceiverInfo)
    {
      this.bsReceiverGLONASSInfo = paramReceiverInfo;
      return this;
    }
    
    public Builder bsReceiverGPSInfo(ReceiverInfo paramReceiverInfo)
    {
      this.bsReceiverGPSInfo = paramReceiverInfo;
      return this;
    }
    
    public RTKState build()
    {
      return new RTKState(this);
    }
    
    public Builder error(DJIError paramDJIError)
    {
      this.error = paramDJIError;
      return this;
    }
    
    public Builder heading(float paramFloat)
    {
      this.heading = paramFloat;
      return this;
    }
    
    public Builder isHeadingValid(boolean paramBoolean)
    {
      this.isHeadingValid = paramBoolean;
      return this;
    }
    
    public Builder isRTKEnabled(boolean paramBoolean)
    {
      this.isRTKEnabled = paramBoolean;
      return this;
    }
    
    public Builder msAntenna1Altitude(float paramFloat)
    {
      this.msAntenna1Altitude = paramFloat;
      return this;
    }
    
    public Builder msAntenna1Location(LocationCoordinate2D paramLocationCoordinate2D)
    {
      this.msAntenna1Location = paramLocationCoordinate2D;
      return this;
    }
    
    public Builder msReceiver1BeiDouInfo(ReceiverInfo paramReceiverInfo)
    {
      this.msReceiver1BeiDouInfo = paramReceiverInfo;
      return this;
    }
    
    public Builder msReceiver1GLONASSInfo(ReceiverInfo paramReceiverInfo)
    {
      this.msReceiver1GLONASSInfo = paramReceiverInfo;
      return this;
    }
    
    public Builder msReceiver1GPSInfo(ReceiverInfo paramReceiverInfo)
    {
      this.msReceiver1GPSInfo = paramReceiverInfo;
      return this;
    }
    
    public Builder msReceiver2BeiDouInfo(ReceiverInfo paramReceiverInfo)
    {
      this.msReceiver2BeiDouInfo = paramReceiverInfo;
      return this;
    }
    
    public Builder msReceiver2GLONASSInfo(ReceiverInfo paramReceiverInfo)
    {
      this.msReceiver2GLONASSInfo = paramReceiverInfo;
      return this;
    }
    
    public Builder msReceiver2GPSInfo(ReceiverInfo paramReceiverInfo)
    {
      this.msReceiver2GPSInfo = paramReceiverInfo;
      return this;
    }
    
    public Builder positioningSolution(PositioningSolution paramPositioningSolution)
    {
      this.positioningSolution = paramPositioningSolution;
      return this;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(RTKState paramRTKState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\RTKState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */