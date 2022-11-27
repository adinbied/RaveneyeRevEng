package dji.common.camera;

public class WhiteBalance
{
  private final int colorTemperature;
  private final SettingsDefinitions.WhiteBalancePreset whiteBalancePreset;
  
  public WhiteBalance(int paramInt)
  {
    this.whiteBalancePreset = SettingsDefinitions.WhiteBalancePreset.CUSTOM;
    this.colorTemperature = paramInt;
  }
  
  public WhiteBalance(SettingsDefinitions.WhiteBalancePreset paramWhiteBalancePreset)
  {
    this.whiteBalancePreset = paramWhiteBalancePreset;
    this.colorTemperature = 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int getColorTemperature()
  {
    return this.colorTemperature;
  }
  
  public SettingsDefinitions.WhiteBalancePreset getWhiteBalancePreset()
  {
    return this.whiteBalancePreset;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\WhiteBalance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */