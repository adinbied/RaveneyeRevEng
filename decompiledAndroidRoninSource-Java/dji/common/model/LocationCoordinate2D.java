package dji.common.model;

public class LocationCoordinate2D
{
  public static final double UNKNOWN = Double.MIN_VALUE;
  private final double latitude;
  private final double longitude;
  
  public LocationCoordinate2D(double paramDouble1, double paramDouble2)
  {
    this.latitude = paramDouble1;
    this.longitude = paramDouble2;
  }
  
  public static boolean isValid(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 >= -90.0D) && (paramDouble1 <= 90.0D) && (paramDouble2 >= -180.0D) && (paramDouble2 <= 180.0D);
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isValid()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\model\LocationCoordinate2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */