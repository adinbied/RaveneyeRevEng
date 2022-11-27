package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class ReconyxHyperFireMakernoteDirectory
  extends Directory
{
  public static final int MAKERNOTE_VERSION = 61697;
  public static final int TAG_AMBIENT_TEMPERATURE = 40;
  public static final int TAG_AMBIENT_TEMPERATURE_FAHRENHEIT = 38;
  public static final int TAG_BATTERY_VOLTAGE = 84;
  public static final int TAG_BRIGHTNESS = 74;
  public static final int TAG_CONTRAST = 72;
  public static final int TAG_DATE_TIME_ORIGINAL = 22;
  public static final int TAG_EVENT_NUMBER = 18;
  public static final int TAG_FIRMWARE_VERSION = 2;
  public static final int TAG_INFRARED_ILLUMINATOR = 80;
  public static final int TAG_MAKERNOTE_VERSION = 0;
  public static final int TAG_MOON_PHASE = 36;
  public static final int TAG_MOTION_SENSITIVITY = 82;
  public static final int TAG_SATURATION = 78;
  public static final int TAG_SEQUENCE = 14;
  public static final int TAG_SERIAL_NUMBER = 42;
  public static final int TAG_SHARPNESS = 76;
  public static final int TAG_TRIGGER_MODE = 12;
  public static final int TAG_USER_LABEL = 86;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(0), "Makernote Version");
    _tagNameMap.put(Integer.valueOf(2), "Firmware Version");
    _tagNameMap.put(Integer.valueOf(12), "Trigger Mode");
    _tagNameMap.put(Integer.valueOf(14), "Sequence");
    _tagNameMap.put(Integer.valueOf(18), "Event Number");
    _tagNameMap.put(Integer.valueOf(22), "Date/Time Original");
    _tagNameMap.put(Integer.valueOf(36), "Moon Phase");
    _tagNameMap.put(Integer.valueOf(38), "Ambient Temperature Fahrenheit");
    _tagNameMap.put(Integer.valueOf(40), "Ambient Temperature");
    _tagNameMap.put(Integer.valueOf(42), "Serial Number");
    _tagNameMap.put(Integer.valueOf(72), "Contrast");
    _tagNameMap.put(Integer.valueOf(74), "Brightness");
    _tagNameMap.put(Integer.valueOf(76), "Sharpness");
    _tagNameMap.put(Integer.valueOf(78), "Saturation");
    _tagNameMap.put(Integer.valueOf(80), "Infrared Illuminator");
    _tagNameMap.put(Integer.valueOf(82), "Motion Sensitivity");
    _tagNameMap.put(Integer.valueOf(84), "Battery Voltage");
    _tagNameMap.put(Integer.valueOf(86), "User Label");
  }
  
  public ReconyxHyperFireMakernoteDirectory()
  {
    setDescriptor(new ReconyxHyperFireMakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Reconyx HyperFire Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\ReconyxHyperFireMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */