package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class SonyType1MakernoteDirectory
  extends Directory
{
  public static final int TAG_AF_ILLUMINATOR = 45124;
  public static final int TAG_AF_MODE = 45123;
  public static final int TAG_AF_POINT_SELECTED = 8222;
  public static final int TAG_ANTI_BLUR = 45131;
  public static final int TAG_AUTO_PORTRAIT_FRAMED = 8214;
  public static final int TAG_BRIGHTNESS = 8199;
  public static final int TAG_CAMERA_INFO = 16;
  public static final int TAG_CAMERA_SETTINGS = 276;
  public static final int TAG_COLOR_COMPENSATION_FILTER = 45090;
  public static final int TAG_COLOR_MODE = 45097;
  public static final int TAG_COLOR_MODE_SETTING = 45088;
  public static final int TAG_COLOR_TEMPERATURE = 45089;
  public static final int TAG_CONTRAST = 8196;
  public static final int TAG_DISTORTION_CORRECTION = 8211;
  public static final int TAG_DYNAMIC_RANGE_OPTIMISER = 45093;
  public static final int TAG_DYNAMIC_RANGE_OPTIMIZER = 45135;
  public static final int TAG_EXPOSURE_MODE = 45121;
  public static final int TAG_EXTRA_INFO = 278;
  public static final int TAG_FILE_FORMAT = 45056;
  public static final int TAG_FLASH_EXPOSURE_COMP = 260;
  public static final int TAG_FLASH_LEVEL = 45128;
  public static final int TAG_FOCUS_INFO = 32;
  public static final int TAG_FOCUS_MODE = 8219;
  public static final int TAG_FOCUS_MODE_2 = 45122;
  public static final int TAG_FULL_IMAGE_SIZE = 45099;
  public static final int TAG_HDR = 8202;
  public static final int TAG_HIGH_ISO_NOISE_REDUCTION = 8201;
  public static final int TAG_HIGH_ISO_NOISE_REDUCTION_2 = 45136;
  public static final int TAG_IMAGE_QUALITY = 258;
  public static final int TAG_IMAGE_STABILISATION = 45094;
  public static final int TAG_INTELLIGENT_AUTO = 45138;
  public static final int TAG_JPEG_QUALITY = 45127;
  public static final int TAG_LATERAL_CHROMATIC_ABERRATION = 8210;
  public static final int TAG_LENS_ID = 45095;
  public static final int TAG_LENS_SPEC = 45098;
  public static final int TAG_LONG_EXPOSURE_NOISE_REDUCTION = 8200;
  public static final int TAG_LONG_EXPOSURE_NOISE_REDUCTION_OR_FOCUS_MODE = 45134;
  public static final int TAG_MACRO = 45120;
  public static final int TAG_MINOLTA_MAKERNOTE = 45096;
  public static final int TAG_MULTI_BURST_IMAGE_HEIGHT = 4098;
  public static final int TAG_MULTI_BURST_IMAGE_WIDTH = 4097;
  public static final int TAG_MULTI_BURST_MODE = 4096;
  public static final int TAG_MULTI_FRAME_NOISE_REDUCTION = 8203;
  public static final int TAG_NO_PRINT = 65535;
  public static final int TAG_PANORAMA = 4099;
  public static final int TAG_PICTURE_EFFECT = 8206;
  public static final int TAG_PREVIEW_IMAGE = 8193;
  public static final int TAG_PREVIEW_IMAGE_SIZE = 45100;
  public static final int TAG_PRINT_IMAGE_MATCHING_INFO = 3584;
  public static final int TAG_RATING = 8194;
  public static final int TAG_RELEASE_MODE = 45129;
  public static final int TAG_SATURATION = 8197;
  public static final int TAG_SCENE_MODE = 45091;
  public static final int TAG_SEQUENCE_NUMBER = 45130;
  public static final int TAG_SHARPNESS = 8198;
  public static final int TAG_SHOT_INFO = 12288;
  public static final int TAG_SOFT_SKIN_EFFECT = 8207;
  public static final int TAG_SONY_MODEL_ID = 45057;
  public static final int TAG_TELECONVERTER = 261;
  public static final int TAG_VIGNETTING_CORRECTION = 8209;
  public static final int TAG_WB_SHIFT_AMBER_MAGENTA = 8212;
  public static final int TAG_WHITE_BALANCE = 277;
  public static final int TAG_WHITE_BALANCE_2 = 45140;
  public static final int TAG_WHITE_BALANCE_FINE_TUNE = 274;
  public static final int TAG_ZONE_MATCHING = 45092;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(16), "Camera Info");
    _tagNameMap.put(Integer.valueOf(32), "Focus Info");
    _tagNameMap.put(Integer.valueOf(258), "Image Quality");
    _tagNameMap.put(Integer.valueOf(260), "Flash Exposure Compensation");
    _tagNameMap.put(Integer.valueOf(261), "Teleconverter Model");
    _tagNameMap.put(Integer.valueOf(274), "White Balance Fine Tune Value");
    _tagNameMap.put(Integer.valueOf(276), "Camera Settings");
    _tagNameMap.put(Integer.valueOf(277), "White Balance");
    _tagNameMap.put(Integer.valueOf(278), "Extra Info");
    _tagNameMap.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
    _tagNameMap.put(Integer.valueOf(4096), "Multi Burst Mode");
    _tagNameMap.put(Integer.valueOf(4097), "Multi Burst Image Width");
    _tagNameMap.put(Integer.valueOf(4098), "Multi Burst Image Height");
    _tagNameMap.put(Integer.valueOf(4099), "Panorama");
    _tagNameMap.put(Integer.valueOf(8193), "Preview Image");
    _tagNameMap.put(Integer.valueOf(8194), "Rating");
    _tagNameMap.put(Integer.valueOf(8196), "Contrast");
    _tagNameMap.put(Integer.valueOf(8197), "Saturation");
    _tagNameMap.put(Integer.valueOf(8198), "Sharpness");
    _tagNameMap.put(Integer.valueOf(8199), "Brightness");
    _tagNameMap.put(Integer.valueOf(8200), "Long Exposure Noise Reduction");
    _tagNameMap.put(Integer.valueOf(8201), "High ISO Noise Reduction");
    _tagNameMap.put(Integer.valueOf(8202), "HDR");
    _tagNameMap.put(Integer.valueOf(8203), "Multi Frame Noise Reduction");
    _tagNameMap.put(Integer.valueOf(8206), "Picture Effect");
    _tagNameMap.put(Integer.valueOf(8207), "Soft Skin Effect");
    _tagNameMap.put(Integer.valueOf(8209), "Vignetting Correction");
    _tagNameMap.put(Integer.valueOf(8210), "Lateral Chromatic Aberration");
    _tagNameMap.put(Integer.valueOf(8211), "Distortion Correction");
    _tagNameMap.put(Integer.valueOf(8212), "WB Shift Amber/Magenta");
    _tagNameMap.put(Integer.valueOf(8214), "Auto Portrait Framing");
    _tagNameMap.put(Integer.valueOf(8219), "Focus Mode");
    _tagNameMap.put(Integer.valueOf(8222), "AF Point Selected");
    _tagNameMap.put(Integer.valueOf(12288), "Shot Info");
    _tagNameMap.put(Integer.valueOf(45056), "File Format");
    _tagNameMap.put(Integer.valueOf(45057), "Sony Model ID");
    _tagNameMap.put(Integer.valueOf(45088), "Color Mode Setting");
    _tagNameMap.put(Integer.valueOf(45089), "Color Temperature");
    _tagNameMap.put(Integer.valueOf(45090), "Color Compensation Filter");
    _tagNameMap.put(Integer.valueOf(45091), "Scene Mode");
    _tagNameMap.put(Integer.valueOf(45092), "Zone Matching");
    _tagNameMap.put(Integer.valueOf(45093), "Dynamic Range Optimizer");
    _tagNameMap.put(Integer.valueOf(45094), "Image Stabilisation");
    _tagNameMap.put(Integer.valueOf(45095), "Lens ID");
    _tagNameMap.put(Integer.valueOf(45096), "Minolta Makernote");
    _tagNameMap.put(Integer.valueOf(45097), "Color Mode");
    _tagNameMap.put(Integer.valueOf(45098), "Lens Spec");
    _tagNameMap.put(Integer.valueOf(45099), "Full Image Size");
    _tagNameMap.put(Integer.valueOf(45100), "Preview Image Size");
    _tagNameMap.put(Integer.valueOf(45120), "Macro");
    _tagNameMap.put(Integer.valueOf(45121), "Exposure Mode");
    _tagNameMap.put(Integer.valueOf(45122), "Focus Mode");
    _tagNameMap.put(Integer.valueOf(45123), "AF Mode");
    _tagNameMap.put(Integer.valueOf(45124), "AF Illuminator");
    _tagNameMap.put(Integer.valueOf(45127), "Quality");
    _tagNameMap.put(Integer.valueOf(45128), "Flash Level");
    _tagNameMap.put(Integer.valueOf(45129), "Release Mode");
    _tagNameMap.put(Integer.valueOf(45130), "Sequence Number");
    _tagNameMap.put(Integer.valueOf(45131), "Anti Blur");
    _tagNameMap.put(Integer.valueOf(45134), "Long Exposure Noise Reduction");
    _tagNameMap.put(Integer.valueOf(45135), "Dynamic Range Optimizer");
    _tagNameMap.put(Integer.valueOf(45136), "High ISO Noise Reduction");
    _tagNameMap.put(Integer.valueOf(45138), "Intelligent Auto");
    _tagNameMap.put(Integer.valueOf(45140), "White Balance 2");
    _tagNameMap.put(Integer.valueOf(65535), "No Print");
  }
  
  public SonyType1MakernoteDirectory()
  {
    setDescriptor(new SonyType1MakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Sony Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\SonyType1MakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */