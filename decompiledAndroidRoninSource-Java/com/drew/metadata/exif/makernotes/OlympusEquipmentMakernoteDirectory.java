package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class OlympusEquipmentMakernoteDirectory
  extends Directory
{
  public static final int TAG_BODY_FIRMWARE_VERSION = 260;
  public static final int TAG_CAMERA_TYPE_2 = 256;
  public static final int TAG_CONVERSION_LENS = 1027;
  public static final int TAG_EQUIPMENT_VERSION = 0;
  public static final int TAG_EXTENDER = 769;
  public static final int TAG_EXTENDER_FIRMWARE_VERSION = 772;
  public static final int TAG_EXTENDER_MODEL = 771;
  public static final int TAG_EXTENDER_SERIAL_NUMBER = 770;
  public static final int TAG_FLASH_FIRMWARE_VERSION = 4098;
  public static final int TAG_FLASH_MODEL = 4097;
  public static final int TAG_FLASH_SERIAL_NUMBER = 4099;
  public static final int TAG_FLASH_TYPE = 4096;
  public static final int TAG_FOCAL_PLANE_DIAGONAL = 259;
  public static final int TAG_INTERNAL_SERIAL_NUMBER = 258;
  public static final int TAG_LENS_FIRMWARE_VERSION = 516;
  public static final int TAG_LENS_MODEL = 515;
  public static final int TAG_LENS_PROPERTIES = 523;
  public static final int TAG_LENS_SERIAL_NUMBER = 514;
  public static final int TAG_LENS_TYPE = 513;
  public static final int TAG_MAX_APERTURE = 522;
  public static final int TAG_MAX_APERTURE_AT_MAX_FOCAL = 518;
  public static final int TAG_MAX_APERTURE_AT_MIN_FOCAL = 517;
  public static final int TAG_MAX_FOCAL_LENGTH = 520;
  public static final int TAG_MIN_FOCAL_LENGTH = 519;
  public static final int TAG_SERIAL_NUMBER = 257;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(0), "Equipment Version");
    _tagNameMap.put(Integer.valueOf(256), "Camera Type 2");
    _tagNameMap.put(Integer.valueOf(257), "Serial Number");
    _tagNameMap.put(Integer.valueOf(258), "Internal Serial Number");
    _tagNameMap.put(Integer.valueOf(259), "Focal Plane Diagonal");
    _tagNameMap.put(Integer.valueOf(260), "Body Firmware Version");
    _tagNameMap.put(Integer.valueOf(513), "Lens Type");
    _tagNameMap.put(Integer.valueOf(514), "Lens Serial Number");
    _tagNameMap.put(Integer.valueOf(515), "Lens Model");
    _tagNameMap.put(Integer.valueOf(516), "Lens Firmware Version");
    _tagNameMap.put(Integer.valueOf(517), "Max Aperture At Min Focal");
    _tagNameMap.put(Integer.valueOf(518), "Max Aperture At Max Focal");
    _tagNameMap.put(Integer.valueOf(519), "Min Focal Length");
    _tagNameMap.put(Integer.valueOf(520), "Max Focal Length");
    _tagNameMap.put(Integer.valueOf(522), "Max Aperture");
    _tagNameMap.put(Integer.valueOf(523), "Lens Properties");
    _tagNameMap.put(Integer.valueOf(769), "Extender");
    _tagNameMap.put(Integer.valueOf(770), "Extender Serial Number");
    _tagNameMap.put(Integer.valueOf(771), "Extender Model");
    _tagNameMap.put(Integer.valueOf(772), "Extender Firmware Version");
    _tagNameMap.put(Integer.valueOf(1027), "Conversion Lens");
    _tagNameMap.put(Integer.valueOf(4096), "Flash Type");
    _tagNameMap.put(Integer.valueOf(4097), "Flash Model");
    _tagNameMap.put(Integer.valueOf(4098), "Flash Firmware Version");
    _tagNameMap.put(Integer.valueOf(4099), "Flash Serial Number");
  }
  
  public OlympusEquipmentMakernoteDirectory()
  {
    setDescriptor(new OlympusEquipmentMakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Olympus Equipment";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\OlympusEquipmentMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */