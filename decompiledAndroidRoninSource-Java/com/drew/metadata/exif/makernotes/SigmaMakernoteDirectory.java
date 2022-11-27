package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class SigmaMakernoteDirectory
  extends Directory
{
  public static final int TAG_ADJUSTMENT_MODE = 21;
  public static final int TAG_AUTO_BRACKET = 25;
  public static final int TAG_AUTO_FOCUS_MODE = 5;
  public static final int TAG_COLOR_ADJUSTMENT = 20;
  public static final int TAG_COLOR_SPACE = 11;
  public static final int TAG_CONTRAST = 13;
  public static final int TAG_DRIVE_MODE = 3;
  public static final int TAG_EXPOSURE = 12;
  public static final int TAG_EXPOSURE_MODE = 8;
  public static final int TAG_FILL_LIGHT = 18;
  public static final int TAG_FIRMWARE = 23;
  public static final int TAG_FOCUS_SETTING = 6;
  public static final int TAG_HIGHLIGHT = 15;
  public static final int TAG_LENS_RANGE = 10;
  public static final int TAG_METERING_MODE = 9;
  public static final int TAG_QUALITY = 22;
  public static final int TAG_RESOLUTION_MODE = 4;
  public static final int TAG_SATURATION = 16;
  public static final int TAG_SERIAL_NUMBER = 2;
  public static final int TAG_SHADOW = 14;
  public static final int TAG_SHARPNESS = 17;
  public static final int TAG_SOFTWARE = 24;
  public static final int TAG_WHITE_BALANCE = 7;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(2), "Serial Number");
    _tagNameMap.put(Integer.valueOf(3), "Drive Mode");
    _tagNameMap.put(Integer.valueOf(4), "Resolution Mode");
    _tagNameMap.put(Integer.valueOf(5), "Auto Focus Mode");
    _tagNameMap.put(Integer.valueOf(6), "Focus Setting");
    _tagNameMap.put(Integer.valueOf(7), "White Balance");
    _tagNameMap.put(Integer.valueOf(8), "Exposure Mode");
    _tagNameMap.put(Integer.valueOf(9), "Metering Mode");
    _tagNameMap.put(Integer.valueOf(10), "Lens Range");
    _tagNameMap.put(Integer.valueOf(11), "Color Space");
    _tagNameMap.put(Integer.valueOf(12), "Exposure");
    _tagNameMap.put(Integer.valueOf(13), "Contrast");
    _tagNameMap.put(Integer.valueOf(14), "Shadow");
    _tagNameMap.put(Integer.valueOf(15), "Highlight");
    _tagNameMap.put(Integer.valueOf(16), "Saturation");
    _tagNameMap.put(Integer.valueOf(17), "Sharpness");
    _tagNameMap.put(Integer.valueOf(18), "Fill Light");
    _tagNameMap.put(Integer.valueOf(20), "Color Adjustment");
    _tagNameMap.put(Integer.valueOf(21), "Adjustment Mode");
    _tagNameMap.put(Integer.valueOf(22), "Quality");
    _tagNameMap.put(Integer.valueOf(23), "Firmware");
    _tagNameMap.put(Integer.valueOf(24), "Software");
    _tagNameMap.put(Integer.valueOf(25), "Auto Bracket");
  }
  
  public SigmaMakernoteDirectory()
  {
    setDescriptor(new SigmaMakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Sigma Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\SigmaMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */