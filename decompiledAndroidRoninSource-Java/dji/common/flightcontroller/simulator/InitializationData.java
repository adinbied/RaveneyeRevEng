package dji.common.flightcontroller.simulator;

import dji.common.model.LocationCoordinate2D;

public final class InitializationData
{
  private final LocationCoordinate2D location;
  private final int satelliteCount;
  private final int updateFrequency;
  
  private InitializationData(LocationCoordinate2D paramLocationCoordinate2D, int paramInt1, int paramInt2)
  {
    this.location = paramLocationCoordinate2D;
    this.updateFrequency = paramInt1;
    this.satelliteCount = paramInt2;
  }
  
  public static InitializationData createInstance(LocationCoordinate2D paramLocationCoordinate2D, int paramInt1, int paramInt2)
  {
    return new InitializationData(paramLocationCoordinate2D, paramInt1, paramInt2);
  }
  
  public LocationCoordinate2D getLocation()
  {
    return this.location;
  }
  
  public int getSatelliteCount()
  {
    return this.satelliteCount;
  }
  
  public int getUpdateFrequency()
  {
    return this.updateFrequency;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\simulator\InitializationData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */