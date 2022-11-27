package dji.common.camera;

public class ThermalExternalSceneSettings
{
  private short atmosphericTemp;
  private short atmosphericTransCoefficient;
  private short bckgrndTemp;
  private short sceneEmissivity;
  private short windowReflectedTemp;
  private short windowReflection;
  private short windowTemp;
  private short windowTransCoefficient;
  
  public ThermalExternalSceneSettings() {}
  
  public ThermalExternalSceneSettings(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, short paramShort6, short paramShort7, short paramShort8)
  {
    this.atmosphericTemp = paramShort1;
    this.atmosphericTransCoefficient = paramShort2;
    this.bckgrndTemp = paramShort3;
    this.sceneEmissivity = paramShort4;
    this.windowReflection = paramShort5;
    this.windowReflectedTemp = paramShort6;
    this.windowTemp = paramShort7;
    this.windowTransCoefficient = paramShort8;
  }
  
  public short getAtmosphericTemperature()
  {
    return this.atmosphericTemp;
  }
  
  public short getAtmosphericTransmissionCoefficient()
  {
    return this.atmosphericTransCoefficient;
  }
  
  public short getBackgroundTemperature()
  {
    return this.bckgrndTemp;
  }
  
  public short getSceneEmissivity()
  {
    return this.sceneEmissivity;
  }
  
  public short getWindowReflectedTemperature()
  {
    return this.windowReflectedTemp;
  }
  
  public short getWindowReflection()
  {
    return this.windowReflection;
  }
  
  public short getWindowTemperature()
  {
    return this.windowTemp;
  }
  
  public short getWindowTransmissionCoefficient()
  {
    return this.windowTransCoefficient;
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(ThermalExternalSceneSettings paramThermalExternalSceneSettings);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\ThermalExternalSceneSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */