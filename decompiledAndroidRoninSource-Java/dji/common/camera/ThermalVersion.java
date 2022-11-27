package dji.common.camera;

public enum ThermalVersion
{
  static
  {
    ThermalVersion localThermalVersion = new ThermalVersion("XT_ADVANCED_RADIOMETRY_ENABLED", 1);
    XT_ADVANCED_RADIOMETRY_ENABLED = localThermalVersion;
    $VALUES = new ThermalVersion[] { XT_STANDARD, localThermalVersion };
  }
  
  private ThermalVersion() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\ThermalVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */