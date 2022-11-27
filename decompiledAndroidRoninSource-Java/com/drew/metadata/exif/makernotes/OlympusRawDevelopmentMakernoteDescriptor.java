package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

public class OlympusRawDevelopmentMakernoteDescriptor
  extends TagDescriptor<OlympusRawDevelopmentMakernoteDirectory>
{
  public OlympusRawDevelopmentMakernoteDescriptor(OlympusRawDevelopmentMakernoteDirectory paramOlympusRawDevelopmentMakernoteDirectory)
  {
    super(paramOlympusRawDevelopmentMakernoteDirectory);
  }
  
  public String getDescription(int paramInt)
  {
    if (paramInt != 0)
    {
      switch (paramInt)
      {
      default: 
        return super.getDescription(paramInt);
      case 268: 
        return getRawDevSettingsDescription();
      case 267: 
        return getRawDevEditStatusDescription();
      case 266: 
        return getRawDevNoiseReductionDescription();
      case 265: 
        return getRawDevEngineDescription();
      }
      return getRawDevColorSpaceDescription();
    }
    return getRawDevVersionDescription();
  }
  
  public String getRawDevColorSpaceDescription()
  {
    return null;
  }
  
  public String getRawDevEditStatusDescription()
  {
    return null;
  }
  
  public String getRawDevEngineDescription()
  {
    return null;
  }
  
  public String getRawDevNoiseReductionDescription()
  {
    return null;
  }
  
  public String getRawDevSettingsDescription()
  {
    return null;
  }
  
  public String getRawDevVersionDescription()
  {
    return getVersionBytesDescription(0, 4);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\OlympusRawDevelopmentMakernoteDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */