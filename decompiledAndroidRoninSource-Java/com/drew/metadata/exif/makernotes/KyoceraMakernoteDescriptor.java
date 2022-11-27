package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;

public class KyoceraMakernoteDescriptor
  extends TagDescriptor<KyoceraMakernoteDirectory>
{
  public KyoceraMakernoteDescriptor(KyoceraMakernoteDirectory paramKyoceraMakernoteDirectory)
  {
    super(paramKyoceraMakernoteDirectory);
  }
  
  public String getDescription(int paramInt)
  {
    return null;
  }
  
  public String getProprietaryThumbnailDataDescription()
  {
    return getByteLengthDescription(1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\KyoceraMakernoteDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */