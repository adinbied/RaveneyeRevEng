package dji.common.camera;

public enum ThermalMeasurementMode
{
  private int value;
  
  static
  {
    AREA_METERING = new ThermalMeasurementMode("AREA_METERING", 2, 2);
    ThermalMeasurementMode localThermalMeasurementMode = new ThermalMeasurementMode("UNKNOWN", 3, 255);
    UNKNOWN = localThermalMeasurementMode;
    $VALUES = new ThermalMeasurementMode[] { DISABLED, SPOT_METERING, AREA_METERING, localThermalMeasurementMode };
  }
  
  private ThermalMeasurementMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static ThermalMeasurementMode find(int paramInt)
  {
    ThermalMeasurementMode localThermalMeasurementMode = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localThermalMeasurementMode;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\ThermalMeasurementMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */