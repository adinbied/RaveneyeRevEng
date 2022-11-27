package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

public class OlympusImageProcessingMakernoteDescriptor
  extends TagDescriptor<OlympusImageProcessingMakernoteDirectory>
{
  public OlympusImageProcessingMakernoteDescriptor(OlympusImageProcessingMakernoteDirectory paramOlympusImageProcessingMakernoteDirectory)
  {
    super(paramOlympusImageProcessingMakernoteDirectory);
  }
  
  public String getAspectRatioDescription()
  {
    return null;
  }
  
  public String getColorMatrixDescription()
  {
    return null;
  }
  
  public String getDescription(int paramInt)
  {
    return null;
  }
  
  public String getDistortionCorrection2Description()
  {
    return null;
  }
  
  public String getImageProcessingVersionDescription()
  {
    return getVersionBytesDescription(0, 4);
  }
  
  public String getKeystoneCompensationDescription()
  {
    return null;
  }
  
  public String getKeystoneDirectionDescription()
  {
    return null;
  }
  
  public String getMultipleExposureModeDescription()
  {
    return null;
  }
  
  public String getNoiseReduction2Description()
  {
    return null;
  }
  
  public String getShadingCompensation2Description()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\OlympusImageProcessingMakernoteDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */