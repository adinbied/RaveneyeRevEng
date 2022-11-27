package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

public class NikonType1MakernoteDescriptor
  extends TagDescriptor<NikonType1MakernoteDirectory>
{
  public NikonType1MakernoteDescriptor(NikonType1MakernoteDirectory paramNikonType1MakernoteDirectory)
  {
    super(paramNikonType1MakernoteDirectory);
  }
  
  public String getCcdSensitivityDescription()
  {
    return null;
  }
  
  public String getColorModeDescription()
  {
    return null;
  }
  
  public String getConverterDescription()
  {
    return null;
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    default: 
      return super.getDescription(paramInt);
    case 11: 
      return getConverterDescription();
    case 10: 
      return getDigitalZoomDescription();
    case 8: 
      return getFocusDescription();
    case 7: 
      return getWhiteBalanceDescription();
    case 6: 
      return getCcdSensitivityDescription();
    case 5: 
      return getImageAdjustmentDescription();
    case 4: 
      return getColorModeDescription();
    }
    return getQualityDescription();
  }
  
  public String getDigitalZoomDescription()
  {
    return null;
  }
  
  public String getFocusDescription()
  {
    return null;
  }
  
  public String getImageAdjustmentDescription()
  {
    return null;
  }
  
  public String getQualityDescription()
  {
    return null;
  }
  
  public String getWhiteBalanceDescription()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\NikonType1MakernoteDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */