package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class FujifilmMakernoteDirectory
  extends Directory
{
  public static final int TAG_AUTO_BRACKETING = 4352;
  public static final int TAG_AUTO_DYNAMIC_RANGE = 5131;
  public static final int TAG_AUTO_EXPOSURE_WARNING = 4866;
  public static final int TAG_BLUR_WARNING = 4864;
  public static final int TAG_COLOR_SATURATION = 4099;
  public static final int TAG_COLOR_TEMPERATURE = 4101;
  public static final int TAG_CONTRAST = 4102;
  public static final int TAG_DEVELOPMENT_DYNAMIC_RANGE = 5123;
  public static final int TAG_DYNAMIC_RANGE = 5120;
  public static final int TAG_DYNAMIC_RANGE_SETTING = 5122;
  public static final int TAG_EXR_AUTO = 4147;
  public static final int TAG_EXR_MODE = 4148;
  public static final int TAG_FACES_DETECTED = 16640;
  public static final int TAG_FACE_POSITIONS = 16643;
  public static final int TAG_FACE_REC_INFO = 17026;
  public static final int TAG_FILE_SOURCE = 32768;
  public static final int TAG_FILM_MODE = 5121;
  public static final int TAG_FINE_PIX_COLOR = 4624;
  public static final int TAG_FLASH_EV = 4113;
  public static final int TAG_FLASH_MODE = 4112;
  public static final int TAG_FOCUS_MODE = 4129;
  public static final int TAG_FOCUS_PIXEL = 4131;
  public static final int TAG_FOCUS_WARNING = 4865;
  public static final int TAG_FRAME_NUMBER = 32771;
  public static final int TAG_GE_IMAGE_SIZE = 4868;
  public static final int TAG_HIGH_ISO_NOISE_REDUCTION = 4110;
  public static final int TAG_MACRO = 4128;
  public static final int TAG_MAKERNOTE_VERSION = 0;
  public static final int TAG_MAX_APERTURE_AT_MAX_FOCAL = 5127;
  public static final int TAG_MAX_APERTURE_AT_MIN_FOCAL = 5126;
  public static final int TAG_MAX_FOCAL_LENGTH = 5125;
  public static final int TAG_MIN_FOCAL_LENGTH = 5124;
  public static final int TAG_NOISE_REDUCTION = 4107;
  public static final int TAG_ORDER_NUMBER = 32770;
  public static final int TAG_PARALLAX = 45585;
  public static final int TAG_PICTURE_MODE = 4145;
  public static final int TAG_QUALITY = 4096;
  public static final int TAG_SEQUENCE_NUMBER = 4353;
  public static final int TAG_SERIAL_NUMBER = 16;
  public static final int TAG_SHARPNESS = 4097;
  public static final int TAG_SLOW_SYNC = 4144;
  public static final int TAG_TONE = 4100;
  public static final int TAG_WHITE_BALANCE = 4098;
  public static final int TAG_WHITE_BALANCE_FINE_TUNE = 4106;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(0), "Makernote Version");
    _tagNameMap.put(Integer.valueOf(16), "Serial Number");
    _tagNameMap.put(Integer.valueOf(4096), "Quality");
    _tagNameMap.put(Integer.valueOf(4097), "Sharpness");
    _tagNameMap.put(Integer.valueOf(4098), "White Balance");
    _tagNameMap.put(Integer.valueOf(4099), "Color Saturation");
    _tagNameMap.put(Integer.valueOf(4100), "Tone (Contrast)");
    _tagNameMap.put(Integer.valueOf(4101), "Color Temperature");
    _tagNameMap.put(Integer.valueOf(4102), "Contrast");
    _tagNameMap.put(Integer.valueOf(4106), "White Balance Fine Tune");
    _tagNameMap.put(Integer.valueOf(4107), "Noise Reduction");
    _tagNameMap.put(Integer.valueOf(4110), "High ISO Noise Reduction");
    _tagNameMap.put(Integer.valueOf(4112), "Flash Mode");
    _tagNameMap.put(Integer.valueOf(4113), "Flash Strength");
    _tagNameMap.put(Integer.valueOf(4128), "Macro");
    _tagNameMap.put(Integer.valueOf(4129), "Focus Mode");
    _tagNameMap.put(Integer.valueOf(4131), "Focus Pixel");
    _tagNameMap.put(Integer.valueOf(4144), "Slow Sync");
    _tagNameMap.put(Integer.valueOf(4145), "Picture Mode");
    _tagNameMap.put(Integer.valueOf(4147), "EXR Auto");
    _tagNameMap.put(Integer.valueOf(4148), "EXR Mode");
    _tagNameMap.put(Integer.valueOf(4352), "Auto Bracketing");
    _tagNameMap.put(Integer.valueOf(4353), "Sequence Number");
    _tagNameMap.put(Integer.valueOf(4624), "FinePix Color Setting");
    _tagNameMap.put(Integer.valueOf(4864), "Blur Warning");
    _tagNameMap.put(Integer.valueOf(4865), "Focus Warning");
    _tagNameMap.put(Integer.valueOf(4866), "AE Warning");
    _tagNameMap.put(Integer.valueOf(4868), "GE Image Size");
    _tagNameMap.put(Integer.valueOf(5120), "Dynamic Range");
    _tagNameMap.put(Integer.valueOf(5121), "Film Mode");
    _tagNameMap.put(Integer.valueOf(5122), "Dynamic Range Setting");
    _tagNameMap.put(Integer.valueOf(5123), "Development Dynamic Range");
    _tagNameMap.put(Integer.valueOf(5124), "Minimum Focal Length");
    _tagNameMap.put(Integer.valueOf(5125), "Maximum Focal Length");
    _tagNameMap.put(Integer.valueOf(5126), "Maximum Aperture at Minimum Focal Length");
    _tagNameMap.put(Integer.valueOf(5127), "Maximum Aperture at Maximum Focal Length");
    _tagNameMap.put(Integer.valueOf(5131), "Auto Dynamic Range");
    _tagNameMap.put(Integer.valueOf(16640), "Faces Detected");
    _tagNameMap.put(Integer.valueOf(16643), "Face Positions");
    _tagNameMap.put(Integer.valueOf(17026), "Face Detection Data");
    _tagNameMap.put(Integer.valueOf(32768), "File Source");
    _tagNameMap.put(Integer.valueOf(32770), "Order Number");
    _tagNameMap.put(Integer.valueOf(32771), "Frame Number");
    _tagNameMap.put(Integer.valueOf(45585), "Parallax");
  }
  
  public FujifilmMakernoteDirectory()
  {
    setDescriptor(new FujifilmMakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Fujifilm Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\FujifilmMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */