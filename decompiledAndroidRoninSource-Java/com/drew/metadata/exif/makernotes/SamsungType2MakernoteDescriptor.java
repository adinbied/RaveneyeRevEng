package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

public class SamsungType2MakernoteDescriptor
  extends TagDescriptor<SamsungType2MakernoteDirectory>
{
  public SamsungType2MakernoteDescriptor(SamsungType2MakernoteDirectory paramSamsungType2MakernoteDirectory)
  {
    super(paramSamsungType2MakernoteDirectory);
  }
  
  private String getCameraTemperatureDescription()
  {
    return null;
  }
  
  public String getDescription(int paramInt)
  {
    return null;
  }
  
  public String getDeviceTypeDescription()
  {
    return null;
  }
  
  public String getFaceDetectDescription()
  {
    return null;
  }
  
  public String getFaceRecognitionDescription()
  {
    return null;
  }
  
  public String getMakernoteVersionDescription()
  {
    return getVersionBytesDescription(1, 2);
  }
  
  public String getSamsungModelIdDescription()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\SamsungType2MakernoteDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */