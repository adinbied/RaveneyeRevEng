package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class NikonType2MakernoteDirectory
  extends Directory
{
  public static final int TAG_ACTIVE_D_LIGHTING = 34;
  public static final int TAG_ADAPTER = 130;
  public static final int TAG_AE_BRACKET_COMPENSATION = 25;
  public static final int TAG_AF_FOCUS_POSITION = 136;
  public static final int TAG_AF_INFO_2 = 183;
  public static final int TAG_AF_RESPONSE = 173;
  public static final int TAG_AF_TUNE = 185;
  public static final int TAG_AF_TYPE = 7;
  public static final int TAG_AUTO_FLASH_COMPENSATION = 18;
  public static final int TAG_AUTO_FLASH_MODE = 9;
  public static final int TAG_CAMERA_COLOR_MODE = 141;
  public static final int TAG_CAMERA_HUE_ADJUSTMENT = 146;
  public static final int TAG_CAMERA_SERIAL_NUMBER = 29;
  public static final int TAG_CAMERA_SERIAL_NUMBER_2 = 160;
  public static final int TAG_CAMERA_SHARPENING = 6;
  public static final int TAG_CAMERA_TONE_COMPENSATION = 129;
  public static final int TAG_CAMERA_WHITE_BALANCE = 5;
  public static final int TAG_CAMERA_WHITE_BALANCE_FINE = 11;
  public static final int TAG_CAMERA_WHITE_BALANCE_RB_COEFF = 12;
  public static final int TAG_COLOR_BALANCE = 151;
  public static final int TAG_COLOR_MODE = 3;
  public static final int TAG_COLOR_SPACE = 30;
  public static final int TAG_CONTRAST_CURVE = 140;
  public static final int TAG_CROP_HIGH_SPEED = 27;
  public static final int TAG_DATA_DUMP = 16;
  public static final int TAG_DELETED_IMAGE_COUNT = 166;
  public static final int TAG_DIGITAL_VARI_PROGRAM = 171;
  public static final int TAG_DIGITAL_ZOOM = 134;
  public static final int TAG_EXPOSURE_DIFFERENCE = 14;
  public static final int TAG_EXPOSURE_SEQUENCE_NUMBER = 167;
  public static final int TAG_EXPOSURE_TUNING = 28;
  public static final int TAG_FILE_INFO = 184;
  public static final int TAG_FIRMWARE_VERSION = 1;
  public static final int TAG_FLASH_BRACKET_COMPENSATION = 24;
  public static final int TAG_FLASH_EXPOSURE_COMPENSATION = 23;
  public static final int TAG_FLASH_INFO = 168;
  public static final int TAG_FLASH_MODE = 26;
  public static final int TAG_FLASH_SYNC_MODE = 8;
  public static final int TAG_FLASH_USED = 135;
  public static final int TAG_HIGH_ISO_NOISE_REDUCTION = 177;
  public static final int TAG_IMAGE_ADJUSTMENT = 128;
  public static final int TAG_IMAGE_AUTHENTICATION = 32;
  public static final int TAG_IMAGE_BOUNDARY = 22;
  public static final int TAG_IMAGE_COUNT = 165;
  public static final int TAG_IMAGE_DATA_SIZE = 162;
  public static final int TAG_IMAGE_OPTIMISATION = 169;
  public static final int TAG_IMAGE_STABILISATION = 172;
  public static final int TAG_ISO_1 = 2;
  public static final int TAG_ISO_INFO = 37;
  public static final int TAG_ISO_MODE = 15;
  public static final int TAG_ISO_REQUESTED = 19;
  public static final int TAG_LENS = 132;
  public static final int TAG_LENS_DATA = 152;
  public static final int TAG_LENS_STOPS = 139;
  public static final int TAG_LENS_TYPE = 131;
  public static final int TAG_LIGHT_SOURCE = 144;
  public static final int TAG_LINEARIZATION_TABLE = 150;
  public static final int TAG_MANUAL_FOCUS_DISTANCE = 133;
  public static final int TAG_MULTI_EXPOSURE = 176;
  public static final int TAG_NEF_BIT_DEPTH = 3618;
  public static final int TAG_NEF_COMPRESSION = 147;
  public static final int TAG_NEF_THUMBNAIL_SIZE = 153;
  public static final int TAG_NIKON_CAPTURE_DATA = 3585;
  public static final int TAG_NIKON_CAPTURE_OFFSETS = 3598;
  public static final int TAG_NIKON_CAPTURE_VERSION = 3593;
  public static final int TAG_NIKON_SCAN = 3600;
  public static final int TAG_NOISE_REDUCTION = 149;
  public static final int TAG_PICTURE_CONTROL = 35;
  public static final int TAG_POWER_UP_TIME = 182;
  public static final int TAG_PREVIEW_IFD = 17;
  public static final int TAG_PRINT_IMAGE_MATCHING_INFO = 3584;
  public static final int TAG_PROGRAM_SHIFT = 13;
  public static final int TAG_QUALITY_AND_FILE_FORMAT = 4;
  public static final int TAG_RETOUCH_HISTORY = 158;
  public static final int TAG_SATURATION = 148;
  public static final int TAG_SATURATION_2 = 170;
  public static final int TAG_SCENE_ASSIST = 156;
  public static final int TAG_SCENE_MODE = 143;
  public static final int TAG_SENSOR_PIXEL_SIZE = 154;
  public static final int TAG_SHOOTING_MODE = 137;
  public static final int TAG_SHOT_INFO = 145;
  public static final int TAG_UNKNOWN_10 = 155;
  public static final int TAG_UNKNOWN_11 = 157;
  public static final int TAG_UNKNOWN_12 = 159;
  public static final int TAG_UNKNOWN_20 = 138;
  public static final int TAG_UNKNOWN_27 = 163;
  public static final int TAG_UNKNOWN_28 = 164;
  public static final int TAG_UNKNOWN_29 = 174;
  public static final int TAG_UNKNOWN_30 = 175;
  public static final int TAG_UNKNOWN_31 = 178;
  public static final int TAG_UNKNOWN_32 = 179;
  public static final int TAG_UNKNOWN_33 = 180;
  public static final int TAG_UNKNOWN_34 = 10;
  public static final int TAG_UNKNOWN_35 = 33;
  public static final int TAG_UNKNOWN_36 = 38;
  public static final int TAG_UNKNOWN_37 = 39;
  public static final int TAG_UNKNOWN_38 = 40;
  public static final int TAG_UNKNOWN_39 = 41;
  public static final int TAG_UNKNOWN_40 = 43;
  public static final int TAG_UNKNOWN_41 = 44;
  public static final int TAG_UNKNOWN_42 = 45;
  public static final int TAG_UNKNOWN_43 = 46;
  public static final int TAG_UNKNOWN_44 = 47;
  public static final int TAG_UNKNOWN_45 = 48;
  public static final int TAG_UNKNOWN_46 = 49;
  public static final int TAG_UNKNOWN_47 = 142;
  public static final int TAG_UNKNOWN_48 = 181;
  public static final int TAG_UNKNOWN_49 = 187;
  public static final int TAG_UNKNOWN_50 = 189;
  public static final int TAG_UNKNOWN_51 = 259;
  public static final int TAG_UNKNOWN_52 = 3589;
  public static final int TAG_UNKNOWN_53 = 3592;
  public static final int TAG_UNKNOWN_54 = 3609;
  public static final int TAG_UNKNOWN_55 = 3619;
  public static final int TAG_VIGNETTE_CONTROL = 42;
  public static final int TAG_VR_INFO = 31;
  public static final int TAG_WORLD_TIME = 36;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Firmware Version");
    _tagNameMap.put(Integer.valueOf(2), "ISO");
    _tagNameMap.put(Integer.valueOf(4), "Quality & File Format");
    _tagNameMap.put(Integer.valueOf(5), "White Balance");
    _tagNameMap.put(Integer.valueOf(6), "Sharpening");
    _tagNameMap.put(Integer.valueOf(7), "AF Type");
    _tagNameMap.put(Integer.valueOf(11), "White Balance Fine");
    _tagNameMap.put(Integer.valueOf(12), "White Balance RB Coefficients");
    _tagNameMap.put(Integer.valueOf(19), "ISO");
    _tagNameMap.put(Integer.valueOf(15), "ISO Mode");
    _tagNameMap.put(Integer.valueOf(16), "Data Dump");
    _tagNameMap.put(Integer.valueOf(13), "Program Shift");
    _tagNameMap.put(Integer.valueOf(14), "Exposure Difference");
    _tagNameMap.put(Integer.valueOf(17), "Preview IFD");
    _tagNameMap.put(Integer.valueOf(131), "Lens Type");
    _tagNameMap.put(Integer.valueOf(135), "Flash Used");
    _tagNameMap.put(Integer.valueOf(136), "AF Focus Position");
    _tagNameMap.put(Integer.valueOf(137), "Shooting Mode");
    _tagNameMap.put(Integer.valueOf(139), "Lens Stops");
    _tagNameMap.put(Integer.valueOf(140), "Contrast Curve");
    _tagNameMap.put(Integer.valueOf(144), "Light source");
    _tagNameMap.put(Integer.valueOf(145), "Shot Info");
    _tagNameMap.put(Integer.valueOf(151), "Color Balance");
    _tagNameMap.put(Integer.valueOf(152), "Lens Data");
    _tagNameMap.put(Integer.valueOf(153), "NEF Thumbnail Size");
    _tagNameMap.put(Integer.valueOf(154), "Sensor Pixel Size");
    _tagNameMap.put(Integer.valueOf(155), "Unknown 10");
    _tagNameMap.put(Integer.valueOf(156), "Scene Assist");
    _tagNameMap.put(Integer.valueOf(157), "Unknown 11");
    _tagNameMap.put(Integer.valueOf(158), "Retouch History");
    _tagNameMap.put(Integer.valueOf(159), "Unknown 12");
    _tagNameMap.put(Integer.valueOf(8), "Flash Sync Mode");
    _tagNameMap.put(Integer.valueOf(9), "Auto Flash Mode");
    _tagNameMap.put(Integer.valueOf(18), "Auto Flash Compensation");
    _tagNameMap.put(Integer.valueOf(167), "Exposure Sequence Number");
    _tagNameMap.put(Integer.valueOf(3), "Color Mode");
    _tagNameMap.put(Integer.valueOf(138), "Unknown 20");
    _tagNameMap.put(Integer.valueOf(22), "Image Boundary");
    _tagNameMap.put(Integer.valueOf(23), "Flash Exposure Compensation");
    _tagNameMap.put(Integer.valueOf(24), "Flash Bracket Compensation");
    _tagNameMap.put(Integer.valueOf(25), "AE Bracket Compensation");
    _tagNameMap.put(Integer.valueOf(26), "Flash Mode");
    _tagNameMap.put(Integer.valueOf(27), "Crop High Speed");
    _tagNameMap.put(Integer.valueOf(28), "Exposure Tuning");
    _tagNameMap.put(Integer.valueOf(29), "Camera Serial Number");
    _tagNameMap.put(Integer.valueOf(30), "Color Space");
    _tagNameMap.put(Integer.valueOf(31), "VR Info");
    _tagNameMap.put(Integer.valueOf(32), "Image Authentication");
    _tagNameMap.put(Integer.valueOf(33), "Unknown 35");
    _tagNameMap.put(Integer.valueOf(34), "Active D-Lighting");
    _tagNameMap.put(Integer.valueOf(35), "Picture Control");
    _tagNameMap.put(Integer.valueOf(36), "World Time");
    _tagNameMap.put(Integer.valueOf(37), "ISO Info");
    _tagNameMap.put(Integer.valueOf(38), "Unknown 36");
    _tagNameMap.put(Integer.valueOf(39), "Unknown 37");
    _tagNameMap.put(Integer.valueOf(40), "Unknown 38");
    _tagNameMap.put(Integer.valueOf(41), "Unknown 39");
    _tagNameMap.put(Integer.valueOf(42), "Vignette Control");
    _tagNameMap.put(Integer.valueOf(43), "Unknown 40");
    _tagNameMap.put(Integer.valueOf(44), "Unknown 41");
    _tagNameMap.put(Integer.valueOf(45), "Unknown 42");
    _tagNameMap.put(Integer.valueOf(46), "Unknown 43");
    _tagNameMap.put(Integer.valueOf(47), "Unknown 44");
    _tagNameMap.put(Integer.valueOf(48), "Unknown 45");
    _tagNameMap.put(Integer.valueOf(49), "Unknown 46");
    _tagNameMap.put(Integer.valueOf(142), "Unknown 47");
    _tagNameMap.put(Integer.valueOf(143), "Scene Mode");
    _tagNameMap.put(Integer.valueOf(160), "Camera Serial Number");
    _tagNameMap.put(Integer.valueOf(162), "Image Data Size");
    _tagNameMap.put(Integer.valueOf(163), "Unknown 27");
    _tagNameMap.put(Integer.valueOf(164), "Unknown 28");
    _tagNameMap.put(Integer.valueOf(165), "Image Count");
    _tagNameMap.put(Integer.valueOf(166), "Deleted Image Count");
    _tagNameMap.put(Integer.valueOf(170), "Saturation");
    _tagNameMap.put(Integer.valueOf(171), "Digital Vari Program");
    _tagNameMap.put(Integer.valueOf(172), "Image Stabilisation");
    _tagNameMap.put(Integer.valueOf(173), "AF Response");
    _tagNameMap.put(Integer.valueOf(174), "Unknown 29");
    _tagNameMap.put(Integer.valueOf(175), "Unknown 30");
    _tagNameMap.put(Integer.valueOf(176), "Multi Exposure");
    _tagNameMap.put(Integer.valueOf(177), "High ISO Noise Reduction");
    _tagNameMap.put(Integer.valueOf(178), "Unknown 31");
    _tagNameMap.put(Integer.valueOf(179), "Unknown 32");
    _tagNameMap.put(Integer.valueOf(180), "Unknown 33");
    _tagNameMap.put(Integer.valueOf(181), "Unknown 48");
    _tagNameMap.put(Integer.valueOf(182), "Power Up Time");
    _tagNameMap.put(Integer.valueOf(183), "AF Info 2");
    _tagNameMap.put(Integer.valueOf(184), "File Info");
    _tagNameMap.put(Integer.valueOf(185), "AF Tune");
    _tagNameMap.put(Integer.valueOf(168), "Flash Info");
    _tagNameMap.put(Integer.valueOf(169), "Image Optimisation");
    _tagNameMap.put(Integer.valueOf(128), "Image Adjustment");
    _tagNameMap.put(Integer.valueOf(129), "Tone Compensation");
    _tagNameMap.put(Integer.valueOf(130), "Adapter");
    _tagNameMap.put(Integer.valueOf(132), "Lens");
    _tagNameMap.put(Integer.valueOf(133), "Manual Focus Distance");
    _tagNameMap.put(Integer.valueOf(134), "Digital Zoom");
    _tagNameMap.put(Integer.valueOf(141), "Colour Mode");
    _tagNameMap.put(Integer.valueOf(146), "Camera Hue Adjustment");
    _tagNameMap.put(Integer.valueOf(147), "NEF Compression");
    _tagNameMap.put(Integer.valueOf(148), "Saturation");
    _tagNameMap.put(Integer.valueOf(149), "Noise Reduction");
    _tagNameMap.put(Integer.valueOf(150), "Linearization Table");
    _tagNameMap.put(Integer.valueOf(3585), "Nikon Capture Data");
    _tagNameMap.put(Integer.valueOf(187), "Unknown 49");
    _tagNameMap.put(Integer.valueOf(189), "Unknown 50");
    _tagNameMap.put(Integer.valueOf(259), "Unknown 51");
    _tagNameMap.put(Integer.valueOf(3584), "Print IM");
    _tagNameMap.put(Integer.valueOf(3589), "Unknown 52");
    _tagNameMap.put(Integer.valueOf(3592), "Unknown 53");
    _tagNameMap.put(Integer.valueOf(3593), "Nikon Capture Version");
    _tagNameMap.put(Integer.valueOf(3598), "Nikon Capture Offsets");
    _tagNameMap.put(Integer.valueOf(3600), "Nikon Scan");
    _tagNameMap.put(Integer.valueOf(3609), "Unknown 54");
    _tagNameMap.put(Integer.valueOf(3618), "NEF Bit Depth");
    _tagNameMap.put(Integer.valueOf(3619), "Unknown 55");
  }
  
  public NikonType2MakernoteDirectory()
  {
    setDescriptor(new NikonType2MakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Nikon Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\NikonType2MakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */