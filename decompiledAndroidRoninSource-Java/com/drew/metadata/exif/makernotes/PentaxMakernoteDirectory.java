package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class PentaxMakernoteDirectory
  extends Directory
{
  public static final int TAG_CAPTURE_MODE = 1;
  public static final int TAG_COLOUR = 23;
  public static final int TAG_CONTRAST = 12;
  public static final int TAG_DAYLIGHT_SAVINGS = 4097;
  public static final int TAG_DIGITAL_ZOOM = 10;
  public static final int TAG_FLASH_MODE = 4;
  public static final int TAG_FOCUS_MODE = 3;
  public static final int TAG_ISO_SPEED = 20;
  public static final int TAG_PRINT_IMAGE_MATCHING_INFO = 3584;
  public static final int TAG_QUALITY_LEVEL = 2;
  public static final int TAG_SATURATION = 13;
  public static final int TAG_SHARPNESS = 11;
  public static final int TAG_TIME_ZONE = 4096;
  public static final int TAG_WHITE_BALANCE = 7;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Capture Mode");
    _tagNameMap.put(Integer.valueOf(2), "Quality Level");
    _tagNameMap.put(Integer.valueOf(3), "Focus Mode");
    _tagNameMap.put(Integer.valueOf(4), "Flash Mode");
    _tagNameMap.put(Integer.valueOf(7), "White Balance");
    _tagNameMap.put(Integer.valueOf(10), "Digital Zoom");
    _tagNameMap.put(Integer.valueOf(11), "Sharpness");
    _tagNameMap.put(Integer.valueOf(12), "Contrast");
    _tagNameMap.put(Integer.valueOf(13), "Saturation");
    _tagNameMap.put(Integer.valueOf(20), "ISO Speed");
    _tagNameMap.put(Integer.valueOf(23), "Colour");
    _tagNameMap.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
    _tagNameMap.put(Integer.valueOf(4096), "Time Zone");
    _tagNameMap.put(Integer.valueOf(4097), "Daylight Savings");
  }
  
  public PentaxMakernoteDirectory()
  {
    setDescriptor(new PentaxMakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Pentax Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\PentaxMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */