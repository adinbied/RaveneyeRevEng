package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class LeicaMakernoteDirectory
  extends Directory
{
  public static final int TAG_APPROXIMATE_F_NUMBER = 787;
  public static final int TAG_CAMERA_TEMPERATURE = 800;
  public static final int TAG_CCD_BOARD_VERSION = 817;
  public static final int TAG_CCD_VERSION = 816;
  public static final int TAG_COLOR_TEMPERATURE = 801;
  public static final int TAG_CONTROLLER_BOARD_VERSION = 818;
  public static final int TAG_EXTERNAL_SENSOR_BRIGHTNESS_VALUE = 785;
  public static final int TAG_IMAGE_ID_NUMBER = 832;
  public static final int TAG_LENS_TYPE = 784;
  public static final int TAG_M16_C_VERSION = 819;
  public static final int TAG_MEASURED_LV = 786;
  public static final int TAG_QUALITY = 768;
  public static final int TAG_SERIAL_NUMBER = 771;
  public static final int TAG_USER_PROFILE = 770;
  public static final int TAG_WB_BLUE_LEVEL = 804;
  public static final int TAG_WB_GREEN_LEVEL = 803;
  public static final int TAG_WB_RED_LEVEL = 802;
  public static final int TAG_WHITE_BALANCE = 772;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(768), "Quality");
    _tagNameMap.put(Integer.valueOf(770), "User Profile");
    _tagNameMap.put(Integer.valueOf(771), "Serial Number");
    _tagNameMap.put(Integer.valueOf(772), "White Balance");
    _tagNameMap.put(Integer.valueOf(784), "Lens Type");
    _tagNameMap.put(Integer.valueOf(785), "External Sensor Brightness Value");
    _tagNameMap.put(Integer.valueOf(786), "Measured LV");
    _tagNameMap.put(Integer.valueOf(787), "Approximate F Number");
    _tagNameMap.put(Integer.valueOf(800), "Camera Temperature");
    _tagNameMap.put(Integer.valueOf(801), "Color Temperature");
    _tagNameMap.put(Integer.valueOf(802), "WB Red Level");
    _tagNameMap.put(Integer.valueOf(803), "WB Green Level");
    _tagNameMap.put(Integer.valueOf(804), "WB Blue Level");
    _tagNameMap.put(Integer.valueOf(816), "CCD Version");
    _tagNameMap.put(Integer.valueOf(817), "CCD Board Version");
    _tagNameMap.put(Integer.valueOf(818), "Controller Board Version");
    _tagNameMap.put(Integer.valueOf(819), "M16 C Version");
    _tagNameMap.put(Integer.valueOf(832), "Image ID Number");
  }
  
  public LeicaMakernoteDirectory()
  {
    setDescriptor(new LeicaMakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Leica Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\LeicaMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */