package dji.common.flightcontroller;

public class LocationCoordinate3D
{
  private final float altitude;
  private final double latitude;
  private final double longitude;
  
  public LocationCoordinate3D(double paramDouble1, double paramDouble2, float paramFloat)
  {
    this.longitude = paramDouble2;
    this.latitude = paramDouble1;
    this.altitude = paramFloat;
  }
  
  public float getAltitude()
  {
    return this.altitude;
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\LocationCoordinate3D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */