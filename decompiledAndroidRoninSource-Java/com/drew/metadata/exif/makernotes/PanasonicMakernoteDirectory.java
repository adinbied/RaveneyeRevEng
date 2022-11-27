package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Age;
import com.drew.metadata.Directory;
import com.drew.metadata.Face;
import java.util.HashMap;

public class PanasonicMakernoteDirectory
  extends Directory
{
  public static final int TAG_ACCELEROMETER_X = 141;
  public static final int TAG_ACCELEROMETER_Y = 142;
  public static final int TAG_ACCELEROMETER_Z = 140;
  public static final int TAG_ACCESSORY_SERIAL_NUMBER = 84;
  public static final int TAG_ACCESSORY_TYPE = 83;
  public static final int TAG_ADVANCED_SCENE_MODE = 61;
  public static final int TAG_AF_AREA_MODE = 15;
  public static final int TAG_AF_ASSIST_LAMP = 49;
  public static final int TAG_AF_POINT_POSITION = 77;
  public static final int TAG_AUDIO = 32;
  public static final int TAG_BABY_AGE = 51;
  public static final int TAG_BABY_AGE_1 = 32784;
  public static final int TAG_BABY_NAME = 102;
  public static final int TAG_BRACKET_SETTINGS = 69;
  public static final int TAG_BURST_MODE = 42;
  public static final int TAG_BURST_SPEED = 119;
  public static final int TAG_CAMERA_ORIENTATION = 143;
  public static final int TAG_CITY = 109;
  public static final int TAG_CITY2 = 128;
  public static final int TAG_CLEAR_RETOUCH = 124;
  public static final int TAG_CLEAR_RETOUCH_VALUE = 163;
  public static final int TAG_COLOR_EFFECT = 40;
  public static final int TAG_COLOR_MODE = 50;
  public static final int TAG_COLOR_TEMP_KELVIN = 68;
  public static final int TAG_CONTRAST = 57;
  public static final int TAG_CONTRAST_MODE = 44;
  public static final int TAG_CONVERSION_LENS = 53;
  public static final int TAG_COUNTRY = 105;
  public static final int TAG_EASY_MODE = 34;
  public static final int TAG_EXIF_VERSION = 38;
  public static final int TAG_FACES_DETECTED = 63;
  public static final int TAG_FACE_DETECTION_INFO = 78;
  public static final int TAG_FACE_RECOGNITION_INFO = 97;
  public static final int TAG_FILM_MODE = 66;
  public static final int TAG_FIRMWARE_VERSION = 2;
  public static final int TAG_FLASH_BIAS = 36;
  public static final int TAG_FLASH_CURTAIN = 72;
  public static final int TAG_FLASH_FIRED = 32775;
  public static final int TAG_FLASH_WARNING = 98;
  public static final int TAG_FOCUS_MODE = 7;
  public static final int TAG_HDR = 158;
  public static final int TAG_IMAGE_STABILIZATION = 26;
  public static final int TAG_INTELLIGENT_D_RANGE = 121;
  public static final int TAG_INTELLIGENT_EXPOSURE = 93;
  public static final int TAG_INTELLIGENT_RESOLUTION = 112;
  public static final int TAG_INTERNAL_ND_FILTER = 157;
  public static final int TAG_INTERNAL_SERIAL_NUMBER = 37;
  public static final int TAG_LANDMARK = 111;
  public static final int TAG_LENS_FIRMWARE_VERSION = 96;
  public static final int TAG_LENS_SERIAL_NUMBER = 82;
  public static final int TAG_LENS_TYPE = 81;
  public static final int TAG_LOCATION = 103;
  public static final int TAG_LONG_EXPOSURE_NOISE_REDUCTION = 73;
  public static final int TAG_MACRO_MODE = 28;
  public static final int TAG_MAKERNOTE_VERSION = 32768;
  public static final int TAG_NOISE_REDUCTION = 45;
  public static final int TAG_OPTICAL_ZOOM_MODE = 52;
  public static final int TAG_PANASONIC_IMAGE_HEIGHT = 76;
  public static final int TAG_PANASONIC_IMAGE_WIDTH = 75;
  public static final int TAG_PHOTO_STYLE = 137;
  public static final int TAG_PITCH_ANGLE = 145;
  public static final int TAG_PRINT_IMAGE_MATCHING_INFO = 3584;
  public static final int TAG_PROGRAM_ISO = 60;
  public static final int TAG_QUALITY_MODE = 1;
  public static final int TAG_RECOGNIZED_FACE_FLAGS = 99;
  public static final int TAG_RECORD_MODE = 31;
  public static final int TAG_ROLL_ANGLE = 144;
  public static final int TAG_ROTATION = 48;
  public static final int TAG_SATURATION = 64;
  public static final int TAG_SCENE_MODE = 32769;
  public static final int TAG_SELF_TIMER = 46;
  public static final int TAG_SEQUENCE_NUMBER = 43;
  public static final int TAG_SHADING_COMPENSATION = 138;
  public static final int TAG_SHARPNESS = 65;
  public static final int TAG_SHUTTER_TYPE = 159;
  public static final int TAG_STATE = 107;
  public static final int TAG_SWEEP_PANORAMA_DIRECTION = 147;
  public static final int TAG_SWEEP_PANORAMA_FIELD_OF_VIEW = 148;
  public static final int TAG_TEXT_STAMP = 59;
  public static final int TAG_TEXT_STAMP_1 = 62;
  public static final int TAG_TEXT_STAMP_2 = 32776;
  public static final int TAG_TEXT_STAMP_3 = 32777;
  public static final int TAG_TIMER_RECORDING = 150;
  public static final int TAG_TITLE = 101;
  public static final int TAG_TOUCH_AE = 171;
  public static final int TAG_TRANSFORM = 89;
  public static final int TAG_TRANSFORM_1 = 32786;
  public static final int TAG_TRAVEL_DAY = 54;
  public static final int TAG_UNKNOWN_DATA_DUMP = 33;
  public static final int TAG_UPTIME = 41;
  public static final int TAG_WB_ADJUST_AB = 70;
  public static final int TAG_WB_ADJUST_GM = 71;
  public static final int TAG_WB_BLUE_LEVEL = 32774;
  public static final int TAG_WB_GREEN_LEVEL = 32773;
  public static final int TAG_WB_RED_LEVEL = 32772;
  public static final int TAG_WHITE_BALANCE = 3;
  public static final int TAG_WHITE_BALANCE_BIAS = 35;
  public static final int TAG_WORLD_TIME_LOCATION = 58;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Quality Mode");
    _tagNameMap.put(Integer.valueOf(2), "Version");
    _tagNameMap.put(Integer.valueOf(3), "White Balance");
    _tagNameMap.put(Integer.valueOf(7), "Focus Mode");
    _tagNameMap.put(Integer.valueOf(15), "AF Area Mode");
    _tagNameMap.put(Integer.valueOf(26), "Image Stabilization");
    _tagNameMap.put(Integer.valueOf(28), "Macro Mode");
    _tagNameMap.put(Integer.valueOf(31), "Record Mode");
    _tagNameMap.put(Integer.valueOf(32), "Audio");
    _tagNameMap.put(Integer.valueOf(37), "Internal Serial Number");
    _tagNameMap.put(Integer.valueOf(33), "Unknown Data Dump");
    _tagNameMap.put(Integer.valueOf(34), "Easy Mode");
    _tagNameMap.put(Integer.valueOf(35), "White Balance Bias");
    _tagNameMap.put(Integer.valueOf(36), "Flash Bias");
    _tagNameMap.put(Integer.valueOf(38), "Exif Version");
    _tagNameMap.put(Integer.valueOf(40), "Color Effect");
    _tagNameMap.put(Integer.valueOf(41), "Camera Uptime");
    _tagNameMap.put(Integer.valueOf(42), "Burst Mode");
    _tagNameMap.put(Integer.valueOf(43), "Sequence Number");
    _tagNameMap.put(Integer.valueOf(44), "Contrast Mode");
    _tagNameMap.put(Integer.valueOf(45), "Noise Reduction");
    _tagNameMap.put(Integer.valueOf(46), "Self Timer");
    _tagNameMap.put(Integer.valueOf(48), "Rotation");
    _tagNameMap.put(Integer.valueOf(49), "AF Assist Lamp");
    _tagNameMap.put(Integer.valueOf(50), "Color Mode");
    _tagNameMap.put(Integer.valueOf(51), "Baby Age");
    _tagNameMap.put(Integer.valueOf(52), "Optical Zoom Mode");
    _tagNameMap.put(Integer.valueOf(53), "Conversion Lens");
    _tagNameMap.put(Integer.valueOf(54), "Travel Day");
    _tagNameMap.put(Integer.valueOf(57), "Contrast");
    _tagNameMap.put(Integer.valueOf(58), "World Time Location");
    _tagNameMap.put(Integer.valueOf(59), "Text Stamp");
    _tagNameMap.put(Integer.valueOf(60), "Program ISO");
    _tagNameMap.put(Integer.valueOf(61), "Advanced Scene Mode");
    _tagNameMap.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
    _tagNameMap.put(Integer.valueOf(63), "Number of Detected Faces");
    _tagNameMap.put(Integer.valueOf(64), "Saturation");
    _tagNameMap.put(Integer.valueOf(65), "Sharpness");
    _tagNameMap.put(Integer.valueOf(66), "Film Mode");
    _tagNameMap.put(Integer.valueOf(68), "Color Temp Kelvin");
    _tagNameMap.put(Integer.valueOf(69), "Bracket Settings");
    _tagNameMap.put(Integer.valueOf(70), "White Balance Adjust (AB)");
    _tagNameMap.put(Integer.valueOf(71), "White Balance Adjust (GM)");
    _tagNameMap.put(Integer.valueOf(72), "Flash Curtain");
    _tagNameMap.put(Integer.valueOf(73), "Long Exposure Noise Reduction");
    _tagNameMap.put(Integer.valueOf(75), "Panasonic Image Width");
    _tagNameMap.put(Integer.valueOf(76), "Panasonic Image Height");
    _tagNameMap.put(Integer.valueOf(77), "Af Point Position");
    _tagNameMap.put(Integer.valueOf(78), "Face Detection Info");
    _tagNameMap.put(Integer.valueOf(81), "Lens Type");
    _tagNameMap.put(Integer.valueOf(82), "Lens Serial Number");
    _tagNameMap.put(Integer.valueOf(83), "Accessory Type");
    _tagNameMap.put(Integer.valueOf(84), "Accessory Serial Number");
    _tagNameMap.put(Integer.valueOf(89), "Transform");
    _tagNameMap.put(Integer.valueOf(93), "Intelligent Exposure");
    _tagNameMap.put(Integer.valueOf(96), "Lens Firmware Version");
    _tagNameMap.put(Integer.valueOf(97), "Face Recognition Info");
    _tagNameMap.put(Integer.valueOf(98), "Flash Warning");
    _tagNameMap.put(Integer.valueOf(99), "Recognized Face Flags");
    _tagNameMap.put(Integer.valueOf(101), "Title");
    _tagNameMap.put(Integer.valueOf(102), "Baby Name");
    _tagNameMap.put(Integer.valueOf(103), "Location");
    _tagNameMap.put(Integer.valueOf(105), "Country");
    _tagNameMap.put(Integer.valueOf(107), "State");
    _tagNameMap.put(Integer.valueOf(109), "City");
    _tagNameMap.put(Integer.valueOf(111), "Landmark");
    _tagNameMap.put(Integer.valueOf(112), "Intelligent Resolution");
    _tagNameMap.put(Integer.valueOf(119), "Burst Speed");
    _tagNameMap.put(Integer.valueOf(121), "Intelligent D-Range");
    _tagNameMap.put(Integer.valueOf(124), "Clear Retouch");
    _tagNameMap.put(Integer.valueOf(128), "City 2");
    _tagNameMap.put(Integer.valueOf(137), "Photo Style");
    _tagNameMap.put(Integer.valueOf(138), "Shading Compensation");
    _tagNameMap.put(Integer.valueOf(140), "Accelerometer Z");
    _tagNameMap.put(Integer.valueOf(141), "Accelerometer X");
    _tagNameMap.put(Integer.valueOf(142), "Accelerometer Y");
    _tagNameMap.put(Integer.valueOf(143), "Camera Orientation");
    _tagNameMap.put(Integer.valueOf(144), "Roll Angle");
    _tagNameMap.put(Integer.valueOf(145), "Pitch Angle");
    _tagNameMap.put(Integer.valueOf(147), "Sweep Panorama Direction");
    _tagNameMap.put(Integer.valueOf(148), "Sweep Panorama Field Of View");
    _tagNameMap.put(Integer.valueOf(150), "Timer Recording");
    _tagNameMap.put(Integer.valueOf(157), "Internal ND Filter");
    _tagNameMap.put(Integer.valueOf(158), "HDR");
    _tagNameMap.put(Integer.valueOf(159), "Shutter Type");
    _tagNameMap.put(Integer.valueOf(163), "Clear Retouch Value");
    _tagNameMap.put(Integer.valueOf(171), "Touch AE");
    _tagNameMap.put(Integer.valueOf(32768), "Makernote Version");
    _tagNameMap.put(Integer.valueOf(32769), "Scene Mode");
    _tagNameMap.put(Integer.valueOf(32772), "White Balance (Red)");
    _tagNameMap.put(Integer.valueOf(32773), "White Balance (Green)");
    _tagNameMap.put(Integer.valueOf(32774), "White Balance (Blue)");
    _tagNameMap.put(Integer.valueOf(32775), "Flash Fired");
    _tagNameMap.put(Integer.valueOf(62), "Text Stamp 1");
    _tagNameMap.put(Integer.valueOf(32776), "Text Stamp 2");
    _tagNameMap.put(Integer.valueOf(32777), "Text Stamp 3");
    _tagNameMap.put(Integer.valueOf(32784), "Baby Age 1");
    _tagNameMap.put(Integer.valueOf(32786), "Transform 1");
  }
  
  public PanasonicMakernoteDirectory()
  {
    setDescriptor(new PanasonicMakernoteDescriptor(this));
  }
  
  public Age getAge(int paramInt)
  {
    String str = getString(paramInt);
    if (str == null) {
      return null;
    }
    return Age.fromPanasonicString(str);
  }
  
  public Face[] getDetectedFaces()
  {
    return null;
  }
  
  public String getName()
  {
    return "Panasonic Makernote";
  }
  
  public Face[] getRecognizedFaces()
  {
    return null;
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\PanasonicMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */