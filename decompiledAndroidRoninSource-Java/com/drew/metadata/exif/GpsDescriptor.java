package com.drew.metadata.exif;

import com.drew.metadata.TagDescriptor;

public class GpsDescriptor
  extends TagDescriptor<GpsDirectory>
{
  public GpsDescriptor(GpsDirectory paramGpsDirectory)
  {
    super(paramGpsDirectory);
  }
  
  private String getGpsVersionIdDescription()
  {
    return getVersionBytesDescription(0, 1);
  }
  
  public String getDegreesMinutesSecondsDescription()
  {
    return null;
  }
  
  public String getDescription(int paramInt)
  {
    return null;
  }
  
  public String getGpsAltitudeDescription()
  {
    return null;
  }
  
  public String getGpsAltitudeRefDescription()
  {
    return null;
  }
  
  public String getGpsDestinationReferenceDescription()
  {
    return null;
  }
  
  public String getGpsDifferentialDescription()
  {
    return null;
  }
  
  public String getGpsDirectionDescription(int paramInt)
  {
    return null;
  }
  
  public String getGpsDirectionReferenceDescription(int paramInt)
  {
    return null;
  }
  
  public String getGpsLatitudeDescription()
  {
    return null;
  }
  
  public String getGpsLongitudeDescription()
  {
    return null;
  }
  
  public String getGpsMeasureModeDescription()
  {
    return null;
  }
  
  public String getGpsSpeedRefDescription()
  {
    return null;
  }
  
  public String getGpsStatusDescription()
  {
    return null;
  }
  
  public String getGpsTimeStampDescription()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\GpsDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */