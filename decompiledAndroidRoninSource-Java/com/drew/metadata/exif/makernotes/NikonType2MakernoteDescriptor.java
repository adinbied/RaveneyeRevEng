package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

public class NikonType2MakernoteDescriptor
  extends TagDescriptor<NikonType2MakernoteDirectory>
{
  public NikonType2MakernoteDescriptor(NikonType2MakernoteDirectory paramNikonType2MakernoteDirectory)
  {
    super(paramNikonType2MakernoteDirectory);
  }
  
  private String getEVDescription(int paramInt)
  {
    return null;
  }
  
  public String getActiveDLightingDescription()
  {
    return null;
  }
  
  public String getAutoFlashCompensationDescription()
  {
    return getEVDescription(18);
  }
  
  public String getAutoFocusPositionDescription()
  {
    return null;
  }
  
  public String getColorModeDescription()
  {
    return null;
  }
  
  public String getColorSpaceDescription()
  {
    return null;
  }
  
  public String getDescription(int paramInt)
  {
    return null;
  }
  
  public String getDigitalZoomDescription()
  {
    return null;
  }
  
  public String getExposureDifferenceDescription()
  {
    return getEVDescription(14);
  }
  
  public String getExposureTuningDescription()
  {
    return getEVDescription(28);
  }
  
  public String getFirmwareVersionDescription()
  {
    return getVersionBytesDescription(1, 2);
  }
  
  public String getFlashBracketCompensationDescription()
  {
    return getEVDescription(24);
  }
  
  public String getFlashExposureCompensationDescription()
  {
    return getEVDescription(23);
  }
  
  public String getFlashUsedDescription()
  {
    return null;
  }
  
  public String getHighISONoiseReductionDescription()
  {
    return null;
  }
  
  public String getHueAdjustmentDescription()
  {
    return null;
  }
  
  public String getIsoSettingDescription()
  {
    return null;
  }
  
  public String getLensDescription()
  {
    return getLensSpecificationDescription(132);
  }
  
  public String getLensStopsDescription()
  {
    return getEVDescription(139);
  }
  
  public String getLensTypeDescription()
  {
    return null;
  }
  
  public String getNEFCompressionDescription()
  {
    return null;
  }
  
  public String getPowerUpTimeDescription()
  {
    return getEpochTimeDescription(182);
  }
  
  public String getProgramShiftDescription()
  {
    return getEVDescription(13);
  }
  
  public String getShootingModeDescription()
  {
    return null;
  }
  
  public String getVignetteControlDescription()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\NikonType2MakernoteDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */