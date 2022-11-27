package com.drew.metadata.exif;

import java.util.HashMap;

public class ExifIFD0Directory
  extends ExifDirectoryBase
{
  public static final int TAG_EXIF_SUB_IFD_OFFSET = 34665;
  public static final int TAG_GPS_INFO_OFFSET = 34853;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    addExifTagNames(localHashMap);
  }
  
  public ExifIFD0Directory()
  {
    setDescriptor(new ExifIFD0Descriptor(this));
  }
  
  public String getName()
  {
    return "Exif IFD0";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\ExifIFD0Directory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */