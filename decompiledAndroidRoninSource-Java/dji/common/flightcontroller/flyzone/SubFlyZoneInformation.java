package dji.common.flightcontroller.flyzone;

import dji.common.model.LocationCoordinate2D;
import java.util.List;

public class SubFlyZoneInformation
{
  private int areaID;
  private LocationCoordinate2D center;
  private int maximumFlightHeight;
  private double radius;
  private SubFlyZoneShape shape;
  private List<LocationCoordinate2D> vertices;
  
  private SubFlyZoneInformation(Builder paramBuilder)
  {
    this.areaID = paramBuilder.areaID;
    this.shape = paramBuilder.shape;
    this.vertices = paramBuilder.vertices;
    this.maximumFlightHeight = paramBuilder.maximumFlightHeight;
    this.center = paramBuilder.center;
    this.radius = paramBuilder.radius;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int getAreaID()
  {
    return this.areaID;
  }
  
  public LocationCoordinate2D getCenter()
  {
    return this.center;
  }
  
  public int getMaxFlightHeight()
  {
    return this.maximumFlightHeight;
  }
  
  public double getRadius()
  {
    return this.radius;
  }
  
  public SubFlyZoneShape getShape()
  {
    return this.shape;
  }
  
  public List<LocationCoordinate2D> getVertices()
  {
    return this.vertices;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public static final class Builder
  {
    private int areaID;
    private LocationCoordinate2D center;
    private int maximumFlightHeight;
    private double radius;
    private SubFlyZoneShape shape;
    private List<LocationCoordinate2D> vertices;
    
    public SubFlyZoneInformation build()
    {
      return new SubFlyZoneInformation(this, null);
    }
    
    public Builder coordinate(LocationCoordinate2D paramLocationCoordinate2D)
    {
      this.center = paramLocationCoordinate2D;
      return this;
    }
    
    public Builder graphic(SubFlyZoneShape paramSubFlyZoneShape)
    {
      this.shape = paramSubFlyZoneShape;
      return this;
    }
    
    public Builder maximumFlightHeight(int paramInt)
    {
      this.maximumFlightHeight = paramInt;
      return this;
    }
    
    public Builder polygonPoints(List<LocationCoordinate2D> paramList)
    {
      this.vertices = paramList;
      return this;
    }
    
    public Builder radius(double paramDouble)
    {
      this.radius = paramDouble;
      return this;
    }
    
    public Builder subAreaID(int paramInt)
    {
      this.areaID = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\flyzone\SubFlyZoneInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */