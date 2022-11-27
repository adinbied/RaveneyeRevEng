package dji.common.camera;

public class ExposureSettings
{
  private SettingsDefinitions.Aperture aperture;
  private SettingsDefinitions.ExposureCompensation exposureCompensation;
  private SettingsDefinitions.ISO iso;
  private SettingsDefinitions.ShutterSpeed shutterSpeed;
  
  public ExposureSettings(SettingsDefinitions.Aperture paramAperture, SettingsDefinitions.ShutterSpeed paramShutterSpeed, SettingsDefinitions.ISO paramISO, SettingsDefinitions.ExposureCompensation paramExposureCompensation)
  {
    this.aperture = paramAperture;
    this.shutterSpeed = paramShutterSpeed;
    this.iso = paramISO;
    this.exposureCompensation = paramExposureCompensation;
  }
  
  public SettingsDefinitions.Aperture getAperture()
  {
    return this.aperture;
  }
  
  public SettingsDefinitions.ExposureCompensation getExposureCompensation()
  {
    return this.exposureCompensation;
  }
  
  public SettingsDefinitions.ISO getISO()
  {
    return this.iso;
  }
  
  public SettingsDefinitions.ShutterSpeed getShutterSpeed()
  {
    return this.shutterSpeed;
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(ExposureSettings paramExposureSettings);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\ExposureSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */