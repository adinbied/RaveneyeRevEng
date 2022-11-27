package dji.common.flightcontroller.flyzone;

import dji.common.model.LocationCoordinate2D;

public final class FlyZoneInformation
{
  private final FlyZoneGEOCategory category;
  private final LocationCoordinate2D coordinate;
  private final String endTime;
  private final int flyZoneID;
  private final FlyZoneType flyZoneType;
  private final String name;
  private final double radius;
  private final FlyZoneReason reason;
  private final FlyZoneShape shape;
  private final String startTime;
  private final SubFlyZoneInformation[] subFlyZones;
  private final String unlockEndTime;
  private final String unlockStartTime;
  
  private FlyZoneInformation(Builder paramBuilder)
  {
    this.flyZoneID = paramBuilder.flyZoneID;
    this.coordinate = paramBuilder.coordinate;
    this.radius = paramBuilder.radius;
    this.startTime = paramBuilder.startTime;
    this.endTime = paramBuilder.endTime;
    this.reason = paramBuilder.type;
    this.shape = paramBuilder.shape;
    this.category = paramBuilder.category;
    this.unlockStartTime = paramBuilder.unlockStartTime;
    this.unlockEndTime = paramBuilder.unlockEndTime;
    this.name = paramBuilder.name;
    this.subFlyZones = paramBuilder.subFlyZones;
    this.flyZoneType = paramBuilder.flyZoneType;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public FlyZoneGEOCategory getCategory()
  {
    return this.category;
  }
  
  public LocationCoordinate2D getCoordinate()
  {
    return this.coordinate;
  }
  
  public String getEndTime()
  {
    return this.endTime;
  }
  
  public int getFlyZoneID()
  {
    return this.flyZoneID;
  }
  
  public FlyZoneType getFlyZoneType()
  {
    return this.flyZoneType;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public double getRadius()
  {
    return this.radius;
  }
  
  public FlyZoneReason getReason()
  {
    return this.reason;
  }
  
  public FlyZoneShape getShape()
  {
    return this.shape;
  }
  
  public String getStartTime()
  {
    return this.startTime;
  }
  
  public SubFlyZoneInformation[] getSubFlyZones()
  {
    return this.subFlyZones;
  }
  
  public String getUnlockEndTime()
  {
    return this.unlockEndTime;
  }
  
  public String getUnlockStartTime()
  {
    return this.unlockStartTime;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public static final class Builder
  {
    private FlyZoneGEOCategory category;
    private LocationCoordinate2D coordinate;
    private String endTime;
    private int flyZoneID;
    private FlyZoneType flyZoneType;
    private String name;
    private double radius;
    private FlyZoneShape shape;
    private String startTime;
    private SubFlyZoneInformation[] subFlyZones;
    private FlyZoneReason type;
    private String unlockEndTime;
    private String unlockStartTime;
    
    public FlyZoneInformation build()
    {
      return new FlyZoneInformation(this, null);
    }
    
    public Builder category(FlyZoneGEOCategory paramFlyZoneGEOCategory)
    {
      this.category = paramFlyZoneGEOCategory;
      return this;
    }
    
    public Builder coordinate(LocationCoordinate2D paramLocationCoordinate2D)
    {
      this.coordinate = paramLocationCoordinate2D;
      return this;
    }
    
    public Builder endTime(String paramString)
    {
      this.endTime = paramString;
      return this;
    }
    
    public Builder flyZoneID(int paramInt)
    {
      this.flyZoneID = paramInt;
      return this;
    }
    
    public Builder flyZoneReason(FlyZoneReason paramFlyZoneReason)
    {
      this.type = paramFlyZoneReason;
      return this;
    }
    
    public Builder flyZoneType(FlyZoneType paramFlyZoneType)
    {
      this.flyZoneType = paramFlyZoneType;
      return this;
    }
    
    public Builder name(String paramString)
    {
      this.name = paramString;
      return this;
    }
    
    public Builder radius(double paramDouble)
    {
      this.radius = paramDouble;
      return this;
    }
    
    public Builder shape(FlyZoneShape paramFlyZoneShape)
    {
      this.shape = paramFlyZoneShape;
      return this;
    }
    
    public Builder startTime(String paramString)
    {
      this.startTime = paramString;
      return this;
    }
    
    public Builder subFlyZoneInformation(SubFlyZoneInformation[] paramArrayOfSubFlyZoneInformation)
    {
      this.subFlyZones = paramArrayOfSubFlyZoneInformation;
      return this;
    }
    
    public Builder unlockEndTime(String paramString)
    {
      this.unlockEndTime = paramString;
      return this;
    }
    
    public Builder unlockStartTime(String paramString)
    {
      this.unlockStartTime = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\flyzone\FlyZoneInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */