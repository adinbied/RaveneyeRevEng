package dji.common.flightcontroller;

public final class ReceiverInfo
{
  private final boolean constellationSupported;
  private final int satelliteCount;
  
  private ReceiverInfo(boolean paramBoolean, int paramInt)
  {
    this.constellationSupported = paramBoolean;
    this.satelliteCount = paramInt;
  }
  
  public static ReceiverInfo createInstance(boolean paramBoolean, int paramInt)
  {
    return new ReceiverInfo(paramBoolean, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int getSatelliteCount()
  {
    return this.satelliteCount;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isConstellationSupported()
  {
    return this.constellationSupported;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\ReceiverInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */