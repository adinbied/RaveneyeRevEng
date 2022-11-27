package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

public class SonyType6MakernoteDescriptor
  extends TagDescriptor<SonyType6MakernoteDirectory>
{
  public SonyType6MakernoteDescriptor(SonyType6MakernoteDirectory paramSonyType6MakernoteDirectory)
  {
    super(paramSonyType6MakernoteDirectory);
  }
  
  public String getDescription(int paramInt)
  {
    return null;
  }
  
  public String getMakernoteThumbVersionDescription()
  {
    return getVersionBytesDescription(8192, 2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\SonyType6MakernoteDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */