package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

public class FujifilmMakernoteDescriptor
  extends TagDescriptor<FujifilmMakernoteDirectory>
{
  public FujifilmMakernoteDescriptor(FujifilmMakernoteDirectory paramFujifilmMakernoteDirectory)
  {
    super(paramFujifilmMakernoteDirectory);
  }
  
  private String getMakernoteVersionDescription()
  {
    return getVersionBytesDescription(0, 2);
  }
  
  public String getAutoBracketingDescription()
  {
    return null;
  }
  
  public String getAutoExposureWarningDescription()
  {
    return null;
  }
  
  public String getBlurWarningDescription()
  {
    return null;
  }
  
  public String getColorSaturationDescription()
  {
    return null;
  }
  
  public String getContrastDescription()
  {
    return null;
  }
  
  public String getDescription(int paramInt)
  {
    return null;
  }
  
  public String getDynamicRangeDescription()
  {
    return null;
  }
  
  public String getDynamicRangeSettingDescription()
  {
    return null;
  }
  
  public String getExrAutoDescription()
  {
    return null;
  }
  
  public String getExrModeDescription()
  {
    return null;
  }
  
  public String getFilmModeDescription()
  {
    return null;
  }
  
  public String getFinePixColorDescription()
  {
    return null;
  }
  
  public String getFlashExposureValueDescription()
  {
    return null;
  }
  
  public String getFlashModeDescription()
  {
    return null;
  }
  
  public String getFocusModeDescription()
  {
    return null;
  }
  
  public String getFocusWarningDescription()
  {
    return null;
  }
  
  public String getHighIsoNoiseReductionDescription()
  {
    return null;
  }
  
  public String getMacroDescription()
  {
    return null;
  }
  
  public String getNoiseReductionDescription()
  {
    return null;
  }
  
  public String getPictureModeDescription()
  {
    return null;
  }
  
  public String getSharpnessDescription()
  {
    return null;
  }
  
  public String getSlowSyncDescription()
  {
    return null;
  }
  
  public String getToneDescription()
  {
    return null;
  }
  
  public String getWhiteBalanceDescription()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\FujifilmMakernoteDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */