package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class KodakMakernoteDirectory
  extends Directory
{
  public static final int TAG_BURST_MODE = 10;
  public static final int TAG_BURST_MODE_2 = 24;
  public static final int TAG_COLOR_MODE = 102;
  public static final int TAG_DATE_TIME_STAMP = 100;
  public static final int TAG_DIGITAL_ZOOM = 104;
  public static final int TAG_EXPOSURE_COMPENSATION = 36;
  public static final int TAG_EXPOSURE_TIME = 32;
  public static final int TAG_FLASH_FIRED = 93;
  public static final int TAG_FLASH_MODE = 92;
  public static final int TAG_FOCUS_MODE = 56;
  public static final int TAG_F_NUMBER = 30;
  public static final int TAG_IMAGE_HEIGHT = 14;
  public static final int TAG_IMAGE_WIDTH = 12;
  public static final int TAG_ISO = 96;
  public static final int TAG_ISO_SETTING = 94;
  public static final int TAG_KODAK_MODEL = 0;
  public static final int TAG_METERING_MODE = 28;
  public static final int TAG_MONTH_DAY_CREATED = 18;
  public static final int TAG_QUALITY = 9;
  public static final int TAG_SEQUENCE_NUMBER = 29;
  public static final int TAG_SHARPNESS = 107;
  public static final int TAG_SHUTTER_MODE = 27;
  public static final int TAG_TIME_CREATED = 20;
  public static final int TAG_TOTAL_ZOOM = 98;
  public static final int TAG_WHITE_BALANCE = 64;
  public static final int TAG_YEAR_CREATED = 16;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(0), "Kodak Model");
    _tagNameMap.put(Integer.valueOf(9), "Quality");
    _tagNameMap.put(Integer.valueOf(10), "Burst Mode");
    _tagNameMap.put(Integer.valueOf(12), "Image Width");
    _tagNameMap.put(Integer.valueOf(14), "Image Height");
    _tagNameMap.put(Integer.valueOf(16), "Year Created");
    _tagNameMap.put(Integer.valueOf(18), "Month/Day Created");
    _tagNameMap.put(Integer.valueOf(20), "Time Created");
    _tagNameMap.put(Integer.valueOf(24), "Burst Mode 2");
    _tagNameMap.put(Integer.valueOf(27), "Shutter Speed");
    _tagNameMap.put(Integer.valueOf(28), "Metering Mode");
    _tagNameMap.put(Integer.valueOf(29), "Sequence Number");
    _tagNameMap.put(Integer.valueOf(30), "F Number");
    _tagNameMap.put(Integer.valueOf(32), "Exposure Time");
    _tagNameMap.put(Integer.valueOf(36), "Exposure Compensation");
    _tagNameMap.put(Integer.valueOf(56), "Focus Mode");
    _tagNameMap.put(Integer.valueOf(64), "White Balance");
    _tagNameMap.put(Integer.valueOf(92), "Flash Mode");
    _tagNameMap.put(Integer.valueOf(93), "Flash Fired");
    _tagNameMap.put(Integer.valueOf(94), "ISO Setting");
    _tagNameMap.put(Integer.valueOf(96), "ISO");
    _tagNameMap.put(Integer.valueOf(98), "Total Zoom");
    _tagNameMap.put(Integer.valueOf(100), "Date/Time Stamp");
    _tagNameMap.put(Integer.valueOf(102), "Color Mode");
    _tagNameMap.put(Integer.valueOf(104), "Digital Zoom");
    _tagNameMap.put(Integer.valueOf(107), "Sharpness");
  }
  
  public KodakMakernoteDirectory()
  {
    setDescriptor(new KodakMakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Kodak Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\KodakMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */