package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class CasioType2MakernoteDirectory
  extends Directory
{
  public static final int TAG_BESTSHOT_MODE = 12295;
  public static final int TAG_CCD_ISO_SENSITIVITY = 12308;
  public static final int TAG_COLOUR_MODE = 12309;
  public static final int TAG_CONTRAST = 32;
  public static final int TAG_ENHANCEMENT = 12310;
  public static final int TAG_FILTER = 12311;
  public static final int TAG_FLASH_DISTANCE = 8244;
  public static final int TAG_FOCAL_LENGTH = 29;
  public static final int TAG_FOCUS_MODE_1 = 13;
  public static final int TAG_FOCUS_MODE_2 = 12291;
  public static final int TAG_IMAGE_SIZE = 9;
  public static final int TAG_ISO_SENSITIVITY = 20;
  public static final int TAG_OBJECT_DISTANCE = 8226;
  public static final int TAG_PREVIEW_THUMBNAIL = 8192;
  public static final int TAG_PRINT_IMAGE_MATCHING_INFO = 3584;
  public static final int TAG_QUALITY = 12290;
  public static final int TAG_QUALITY_MODE = 8;
  public static final int TAG_RECORD_MODE = 12288;
  public static final int TAG_SATURATION = 31;
  public static final int TAG_SELF_TIMER = 12289;
  public static final int TAG_SHARPNESS = 33;
  public static final int TAG_THUMBNAIL_DIMENSIONS = 2;
  public static final int TAG_THUMBNAIL_OFFSET = 4;
  public static final int TAG_THUMBNAIL_SIZE = 3;
  public static final int TAG_TIME_ZONE = 12294;
  public static final int TAG_WHITE_BALANCE_1 = 25;
  public static final int TAG_WHITE_BALANCE_2 = 8210;
  public static final int TAG_WHITE_BALANCE_BIAS = 8209;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(2), "Thumbnail Dimensions");
    _tagNameMap.put(Integer.valueOf(3), "Thumbnail Size");
    _tagNameMap.put(Integer.valueOf(4), "Thumbnail Offset");
    _tagNameMap.put(Integer.valueOf(8), "Quality Mode");
    _tagNameMap.put(Integer.valueOf(9), "Image Size");
    _tagNameMap.put(Integer.valueOf(13), "Focus Mode");
    _tagNameMap.put(Integer.valueOf(20), "ISO Sensitivity");
    _tagNameMap.put(Integer.valueOf(25), "White Balance");
    _tagNameMap.put(Integer.valueOf(29), "Focal Length");
    _tagNameMap.put(Integer.valueOf(31), "Saturation");
    _tagNameMap.put(Integer.valueOf(32), "Contrast");
    _tagNameMap.put(Integer.valueOf(33), "Sharpness");
    _tagNameMap.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
    _tagNameMap.put(Integer.valueOf(8192), "Casio Preview Thumbnail");
    _tagNameMap.put(Integer.valueOf(8209), "White Balance Bias");
    _tagNameMap.put(Integer.valueOf(8210), "White Balance");
    _tagNameMap.put(Integer.valueOf(8226), "Object Distance");
    _tagNameMap.put(Integer.valueOf(8244), "Flash Distance");
    _tagNameMap.put(Integer.valueOf(12288), "Record Mode");
    _tagNameMap.put(Integer.valueOf(12289), "Self Timer");
    _tagNameMap.put(Integer.valueOf(12290), "Quality");
    _tagNameMap.put(Integer.valueOf(12291), "Focus Mode");
    _tagNameMap.put(Integer.valueOf(12294), "Time Zone");
    _tagNameMap.put(Integer.valueOf(12295), "BestShot Mode");
    _tagNameMap.put(Integer.valueOf(12308), "CCD ISO Sensitivity");
    _tagNameMap.put(Integer.valueOf(12309), "Colour Mode");
    _tagNameMap.put(Integer.valueOf(12310), "Enhancement");
    _tagNameMap.put(Integer.valueOf(12311), "Filter");
  }
  
  public CasioType2MakernoteDirectory()
  {
    setDescriptor(new CasioType2MakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Casio Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\CasioType2MakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */