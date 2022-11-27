package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

public class LeicaMakernoteDescriptor
  extends TagDescriptor<LeicaMakernoteDirectory>
{
  public LeicaMakernoteDescriptor(LeicaMakernoteDirectory paramLeicaMakernoteDirectory)
  {
    super(paramLeicaMakernoteDirectory);
  }
  
  private String getApproximateFNumberDescription()
  {
    return getSimpleRational(787);
  }
  
  private String getCameraTemperatureDescription()
  {
    return null;
  }
  
  private String getExternalSensorBrightnessValueDescription()
  {
    return getSimpleRational(785);
  }
  
  private String getMeasuredLvDescription()
  {
    return getSimpleRational(786);
  }
  
  private String getQualityDescription()
  {
    return null;
  }
  
  private String getUserProfileDescription()
  {
    return null;
  }
  
  private String getWhiteBalanceDescription()
  {
    return null;
  }
  
  public String getDescription(int paramInt)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\LeicaMakernoteDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */