package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class CanonMakernoteDirectory
  extends Directory
{
  private static final int TAG_AF_INFO_ARRAY = 18;
  public static final int TAG_AF_INFO_ARRAY_2 = 38;
  public static final int TAG_AF_POINTS_IN_FOCUS_1D = 148;
  public static final int TAG_AMBIANCE_INFO_ARRAY = 16416;
  public static final int TAG_ASPECT_INFO_ARRAY = 154;
  public static final int TAG_BLACK_LEVEL = 16392;
  public static final int TAG_CAMERA_INFO_ARRAY = 13;
  private static final int TAG_CAMERA_SETTINGS_ARRAY = 1;
  public static final int TAG_CANON_CUSTOM_FUNCTIONS_ARRAY = 15;
  public static final int TAG_CANON_FILE_LENGTH = 14;
  public static final int TAG_CANON_FIRMWARE_VERSION = 7;
  public static final int TAG_CANON_FLAGS_ARRAY = 176;
  public static final int TAG_CANON_IMAGE_NUMBER = 8;
  public static final int TAG_CANON_IMAGE_TYPE = 6;
  public static final int TAG_CANON_OWNER_NAME = 9;
  public static final int TAG_CANON_SERIAL_NUMBER = 12;
  public static final int TAG_CATEGORIES = 35;
  public static final int TAG_COLOR_BALANCE_ARRAY = 169;
  public static final int TAG_COLOR_DATA_ARRAY_2 = 16385;
  public static final int TAG_COLOR_INFO_ARRAY = 16403;
  public static final int TAG_COLOR_INFO_ARRAY_2 = 16387;
  public static final int TAG_COLOR_SPACE = 180;
  public static final int TAG_COLOR_TEMPERATURE = 174;
  public static final int TAG_CROP_INFO = 152;
  public static final int TAG_CRW_PARAM = 16386;
  public static final int TAG_CUSTOM_FUNCTIONS_1D_ARRAY = 144;
  public static final int TAG_CUSTOM_FUNCTIONS_ARRAY_2 = 153;
  public static final int TAG_CUSTOM_PICTURE_STYLE_FILE_NAME = 16400;
  public static final int TAG_DATE_STAMP_MODE = 28;
  public static final int TAG_DUST_REMOVAL_DATA = 151;
  public static final int TAG_FACE_DETECT_ARRAY_1 = 36;
  public static final int TAG_FACE_DETECT_ARRAY_2 = 37;
  public static final int TAG_FILE_INFO_ARRAY = 147;
  public static final int TAG_FILTER_INFO_ARRAY = 16420;
  public static final int TAG_FIRMWARE_REVISION = 30;
  private static final int TAG_FOCAL_LENGTH_ARRAY = 2;
  public static final int TAG_IMAGE_UNIQUE_ID = 40;
  public static final int TAG_LENS_INFO_ARRAY = 16409;
  public static final int TAG_LENS_MODEL = 149;
  public static final int TAG_LIGHTING_OPTIMIZER_ARRAY = 16408;
  public static final int TAG_MEASURED_COLOR_ARRAY = 170;
  public static final int TAG_MODEL_ID = 16;
  public static final int TAG_MODIFIED_INFO_ARRAY = 177;
  public static final int TAG_MOVIE_INFO_ARRAY = 17;
  public static final int TAG_MY_COLORS = 29;
  public static final int TAG_ORIGINAL_DECISION_DATA_OFFSET = 131;
  private static final int TAG_PANORAMA_ARRAY = 5;
  public static final int TAG_PERSONAL_FUNCTIONS_ARRAY = 145;
  public static final int TAG_PERSONAL_FUNCTION_VALUES_ARRAY = 146;
  public static final int TAG_PREVIEW_IMAGE_INFO_ARRAY = 182;
  public static final int TAG_PROCESSING_INFO_ARRAY = 160;
  public static final int TAG_RAW_DATA_OFFSET = 129;
  public static final int TAG_SENSOR_INFO_ARRAY = 224;
  public static final int TAG_SERIAL_INFO_ARRAY = 150;
  public static final int TAG_SERIAL_NUMBER_FORMAT = 21;
  public static final int TAG_SHARPNESS_FREQ_TABLE = 163;
  public static final int TAG_SHARPNESS_TABLE = 162;
  private static final int TAG_SHOT_INFO_ARRAY = 4;
  public static final int TAG_SUPER_MACRO = 26;
  public static final int TAG_THUMBNAIL_IMAGE_VALID_AREA = 19;
  public static final int TAG_TONE_CURVE_MATCHING = 178;
  public static final int TAG_TONE_CURVE_TABLE = 161;
  public static final int TAG_VIGNETTING_CORRECTION_ARRAY_1 = 16405;
  public static final int TAG_VIGNETTING_CORRECTION_ARRAY_2 = 16406;
  public static final int TAG_VRD_OFFSET = 208;
  public static final int TAG_WHITE_BALANCE_MATCHING = 179;
  public static final int TAG_WHITE_BALANCE_TABLE = 164;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(7), "Firmware Version");
    _tagNameMap.put(Integer.valueOf(8), "Image Number");
    _tagNameMap.put(Integer.valueOf(6), "Image Type");
    _tagNameMap.put(Integer.valueOf(9), "Owner Name");
    _tagNameMap.put(Integer.valueOf(12), "Camera Serial Number");
    _tagNameMap.put(Integer.valueOf(13), "Camera Info Array");
    _tagNameMap.put(Integer.valueOf(14), "File Length");
    _tagNameMap.put(Integer.valueOf(15), "Custom Functions");
    _tagNameMap.put(Integer.valueOf(16), "Canon Model ID");
    _tagNameMap.put(Integer.valueOf(17), "Movie Info Array");
    _tagNameMap.put(Integer.valueOf(49427), "AF Point Selected");
    _tagNameMap.put(Integer.valueOf(49413), "Continuous Drive Mode");
    _tagNameMap.put(Integer.valueOf(49421), "Contrast");
    _tagNameMap.put(Integer.valueOf(49419), "Easy Shooting Mode");
    _tagNameMap.put(Integer.valueOf(49428), "Exposure Mode");
    _tagNameMap.put(Integer.valueOf(49437), "Flash Details");
    _tagNameMap.put(Integer.valueOf(49412), "Flash Mode");
    _tagNameMap.put(Integer.valueOf(49433), "Focal Units per mm");
    _tagNameMap.put(Integer.valueOf(49415), "Focus Mode");
    _tagNameMap.put(Integer.valueOf(49440), "Focus Mode");
    _tagNameMap.put(Integer.valueOf(49418), "Image Size");
    _tagNameMap.put(Integer.valueOf(49424), "Iso");
    _tagNameMap.put(Integer.valueOf(49431), "Long Focal Length");
    _tagNameMap.put(Integer.valueOf(49409), "Macro Mode");
    _tagNameMap.put(Integer.valueOf(49425), "Metering Mode");
    _tagNameMap.put(Integer.valueOf(49422), "Saturation");
    _tagNameMap.put(Integer.valueOf(49410), "Self Timer Delay");
    _tagNameMap.put(Integer.valueOf(49423), "Sharpness");
    _tagNameMap.put(Integer.valueOf(49432), "Short Focal Length");
    _tagNameMap.put(Integer.valueOf(49411), "Quality");
    _tagNameMap.put(Integer.valueOf(49414), "Unknown Camera Setting 2");
    _tagNameMap.put(Integer.valueOf(49416), "Unknown Camera Setting 3");
    _tagNameMap.put(Integer.valueOf(49417), "Record Mode");
    _tagNameMap.put(Integer.valueOf(49420), "Digital Zoom");
    _tagNameMap.put(Integer.valueOf(49426), "Focus Type");
    _tagNameMap.put(Integer.valueOf(49429), "Unknown Camera Setting 7");
    _tagNameMap.put(Integer.valueOf(49430), "Lens Type");
    _tagNameMap.put(Integer.valueOf(49434), "Max Aperture");
    _tagNameMap.put(Integer.valueOf(49435), "Min Aperture");
    _tagNameMap.put(Integer.valueOf(49436), "Flash Activity");
    _tagNameMap.put(Integer.valueOf(49438), "Focus Continuous");
    _tagNameMap.put(Integer.valueOf(49439), "AE Setting");
    _tagNameMap.put(Integer.valueOf(49441), "Display Aperture");
    _tagNameMap.put(Integer.valueOf(49442), "Zoom Source Width");
    _tagNameMap.put(Integer.valueOf(49443), "Zoom Target Width");
    _tagNameMap.put(Integer.valueOf(49445), "Spot Metering Mode");
    _tagNameMap.put(Integer.valueOf(49446), "Photo Effect");
    _tagNameMap.put(Integer.valueOf(49447), "Manual Flash Output");
    _tagNameMap.put(Integer.valueOf(49449), "Color Tone");
    _tagNameMap.put(Integer.valueOf(49453), "SRAW Quality");
    _tagNameMap.put(Integer.valueOf(49671), "White Balance");
    _tagNameMap.put(Integer.valueOf(49673), "Sequence Number");
    _tagNameMap.put(Integer.valueOf(49678), "AF Point Used");
    _tagNameMap.put(Integer.valueOf(49679), "Flash Bias");
    _tagNameMap.put(Integer.valueOf(49680), "Auto Exposure Bracketing");
    _tagNameMap.put(Integer.valueOf(49681), "AEB Bracket Value");
    _tagNameMap.put(Integer.valueOf(49683), "Subject Distance");
    _tagNameMap.put(Integer.valueOf(50177), "Auto ISO");
    _tagNameMap.put(Integer.valueOf(50178), "Base ISO");
    _tagNameMap.put(Integer.valueOf(50179), "Measured EV");
    _tagNameMap.put(Integer.valueOf(50180), "Target Aperture");
    _tagNameMap.put(Integer.valueOf(50181), "Target Exposure Time");
    _tagNameMap.put(Integer.valueOf(50182), "Exposure Compensation");
    _tagNameMap.put(Integer.valueOf(50183), "White Balance");
    _tagNameMap.put(Integer.valueOf(50184), "Slow Shutter");
    _tagNameMap.put(Integer.valueOf(50185), "Sequence Number");
    _tagNameMap.put(Integer.valueOf(50186), "Optical Zoom Code");
    _tagNameMap.put(Integer.valueOf(50188), "Camera Temperature");
    _tagNameMap.put(Integer.valueOf(50189), "Flash Guide Number");
    _tagNameMap.put(Integer.valueOf(50190), "AF Points in Focus");
    _tagNameMap.put(Integer.valueOf(50191), "Flash Exposure Compensation");
    _tagNameMap.put(Integer.valueOf(50192), "Auto Exposure Bracketing");
    _tagNameMap.put(Integer.valueOf(50193), "AEB Bracket Value");
    _tagNameMap.put(Integer.valueOf(50194), "Control Mode");
    _tagNameMap.put(Integer.valueOf(50195), "Focus Distance Upper");
    _tagNameMap.put(Integer.valueOf(50196), "Focus Distance Lower");
    _tagNameMap.put(Integer.valueOf(50197), "F Number");
    _tagNameMap.put(Integer.valueOf(50198), "Exposure Time");
    _tagNameMap.put(Integer.valueOf(50199), "Measured EV 2");
    _tagNameMap.put(Integer.valueOf(50200), "Bulb Duration");
    _tagNameMap.put(Integer.valueOf(50202), "Camera Type");
    _tagNameMap.put(Integer.valueOf(50203), "Auto Rotate");
    _tagNameMap.put(Integer.valueOf(50204), "ND Filter");
    _tagNameMap.put(Integer.valueOf(50205), "Self Timer 2");
    _tagNameMap.put(Integer.valueOf(50209), "Flash Output");
    _tagNameMap.put(Integer.valueOf(50434), "Panorama Frame Number");
    _tagNameMap.put(Integer.valueOf(50437), "Panorama Direction");
    _tagNameMap.put(Integer.valueOf(53760), "AF Point Count");
    _tagNameMap.put(Integer.valueOf(53761), "Valid AF Point Count");
    _tagNameMap.put(Integer.valueOf(53762), "Image Width");
    _tagNameMap.put(Integer.valueOf(53763), "Image Height");
    _tagNameMap.put(Integer.valueOf(53764), "AF Image Width");
    _tagNameMap.put(Integer.valueOf(53765), "AF Image Height");
    _tagNameMap.put(Integer.valueOf(53766), "AF Area Width");
    _tagNameMap.put(Integer.valueOf(53767), "AF Area Height");
    _tagNameMap.put(Integer.valueOf(53768), "AF Area X Positions");
    _tagNameMap.put(Integer.valueOf(53769), "AF Area Y Positions");
    _tagNameMap.put(Integer.valueOf(53770), "AF Points in Focus");
    _tagNameMap.put(Integer.valueOf(53771), "Primary AF Point 1");
    _tagNameMap.put(Integer.valueOf(53772), "Primary AF Point 2");
    _tagNameMap.put(Integer.valueOf(19), "Thumbnail Image Valid Area");
    _tagNameMap.put(Integer.valueOf(21), "Serial Number Format");
    _tagNameMap.put(Integer.valueOf(26), "Super Macro");
    _tagNameMap.put(Integer.valueOf(28), "Date Stamp Mode");
    _tagNameMap.put(Integer.valueOf(29), "My Colors");
    _tagNameMap.put(Integer.valueOf(30), "Firmware Revision");
    _tagNameMap.put(Integer.valueOf(35), "Categories");
    _tagNameMap.put(Integer.valueOf(36), "Face Detect Array 1");
    _tagNameMap.put(Integer.valueOf(37), "Face Detect Array 2");
    _tagNameMap.put(Integer.valueOf(38), "AF Info Array 2");
    _tagNameMap.put(Integer.valueOf(40), "Image Unique ID");
    _tagNameMap.put(Integer.valueOf(129), "Raw Data Offset");
    _tagNameMap.put(Integer.valueOf(131), "Original Decision Data Offset");
    _tagNameMap.put(Integer.valueOf(144), "Custom Functions (1D) Array");
    _tagNameMap.put(Integer.valueOf(145), "Personal Functions Array");
    _tagNameMap.put(Integer.valueOf(146), "Personal Function Values Array");
    _tagNameMap.put(Integer.valueOf(147), "File Info Array");
    _tagNameMap.put(Integer.valueOf(148), "AF Points in Focus (1D)");
    _tagNameMap.put(Integer.valueOf(149), "Lens Model");
    _tagNameMap.put(Integer.valueOf(150), "Serial Info Array");
    _tagNameMap.put(Integer.valueOf(151), "Dust Removal Data");
    _tagNameMap.put(Integer.valueOf(152), "Crop Info");
    _tagNameMap.put(Integer.valueOf(153), "Custom Functions Array 2");
    _tagNameMap.put(Integer.valueOf(154), "Aspect Information Array");
    _tagNameMap.put(Integer.valueOf(160), "Processing Information Array");
    _tagNameMap.put(Integer.valueOf(161), "Tone Curve Table");
    _tagNameMap.put(Integer.valueOf(162), "Sharpness Table");
    _tagNameMap.put(Integer.valueOf(163), "Sharpness Frequency Table");
    _tagNameMap.put(Integer.valueOf(164), "White Balance Table");
    _tagNameMap.put(Integer.valueOf(169), "Color Balance Array");
    _tagNameMap.put(Integer.valueOf(170), "Measured Color Array");
    _tagNameMap.put(Integer.valueOf(174), "Color Temperature");
    _tagNameMap.put(Integer.valueOf(176), "Canon Flags Array");
    _tagNameMap.put(Integer.valueOf(177), "Modified Information Array");
    _tagNameMap.put(Integer.valueOf(178), "Tone Curve Matching");
    _tagNameMap.put(Integer.valueOf(179), "White Balance Matching");
    _tagNameMap.put(Integer.valueOf(180), "Color Space");
    _tagNameMap.put(Integer.valueOf(182), "Preview Image Info Array");
    _tagNameMap.put(Integer.valueOf(208), "VRD Offset");
    _tagNameMap.put(Integer.valueOf(224), "Sensor Information Array");
    _tagNameMap.put(Integer.valueOf(16385), "Color Data Array 1");
    _tagNameMap.put(Integer.valueOf(16386), "CRW Parameters");
    _tagNameMap.put(Integer.valueOf(16387), "Color Data Array 2");
    _tagNameMap.put(Integer.valueOf(16392), "Black Level");
    _tagNameMap.put(Integer.valueOf(16400), "Custom Picture Style File Name");
    _tagNameMap.put(Integer.valueOf(16403), "Color Info Array");
    _tagNameMap.put(Integer.valueOf(16405), "Vignetting Correction Array 1");
    _tagNameMap.put(Integer.valueOf(16406), "Vignetting Correction Array 2");
    _tagNameMap.put(Integer.valueOf(16408), "Lighting Optimizer Array");
    _tagNameMap.put(Integer.valueOf(16409), "Lens Info Array");
    _tagNameMap.put(Integer.valueOf(16416), "Ambiance Info Array");
    _tagNameMap.put(Integer.valueOf(16420), "Filter Info Array");
  }
  
  public CanonMakernoteDirectory()
  {
    setDescriptor(new CanonMakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Canon Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
  
  /* Error */
  public void setObjectArray(int arg1, Object arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public static final class AFInfo
  {
    private static final int OFFSET = 53760;
    public static final int TAG_AF_AREA_HEIGHT = 53767;
    public static final int TAG_AF_AREA_WIDTH = 53766;
    public static final int TAG_AF_AREA_X_POSITIONS = 53768;
    public static final int TAG_AF_AREA_Y_POSITIONS = 53769;
    public static final int TAG_AF_IMAGE_HEIGHT = 53765;
    public static final int TAG_AF_IMAGE_WIDTH = 53764;
    public static final int TAG_AF_POINTS_IN_FOCUS = 53770;
    public static final int TAG_IMAGE_HEIGHT = 53763;
    public static final int TAG_IMAGE_WIDTH = 53762;
    public static final int TAG_NUM_AF_POINTS = 53760;
    public static final int TAG_PRIMARY_AF_POINT_1 = 53771;
    public static final int TAG_PRIMARY_AF_POINT_2 = 53772;
    public static final int TAG_VALID_AF_POINTS = 53761;
  }
  
  public static final class CameraSettings
  {
    private static final int OFFSET = 49408;
    public static final int TAG_AE_SETTING = 49439;
    public static final int TAG_AF_POINT_SELECTED = 49427;
    public static final int TAG_COLOR_TONE = 49449;
    public static final int TAG_CONTINUOUS_DRIVE_MODE = 49413;
    public static final int TAG_CONTRAST = 49421;
    public static final int TAG_DIGITAL_ZOOM = 49420;
    public static final int TAG_DISPLAY_APERTURE = 49441;
    public static final int TAG_EASY_SHOOTING_MODE = 49419;
    public static final int TAG_EXPOSURE_MODE = 49428;
    public static final int TAG_FLASH_ACTIVITY = 49436;
    public static final int TAG_FLASH_DETAILS = 49437;
    public static final int TAG_FLASH_MODE = 49412;
    public static final int TAG_FOCAL_UNITS_PER_MM = 49433;
    public static final int TAG_FOCUS_CONTINUOUS = 49438;
    public static final int TAG_FOCUS_MODE_1 = 49415;
    public static final int TAG_FOCUS_MODE_2 = 49440;
    public static final int TAG_FOCUS_TYPE = 49426;
    public static final int TAG_IMAGE_SIZE = 49418;
    public static final int TAG_ISO = 49424;
    public static final int TAG_LENS_TYPE = 49430;
    public static final int TAG_LONG_FOCAL_LENGTH = 49431;
    public static final int TAG_MACRO_MODE = 49409;
    public static final int TAG_MANUAL_FLASH_OUTPUT = 49447;
    public static final int TAG_MAX_APERTURE = 49434;
    public static final int TAG_METERING_MODE = 49425;
    public static final int TAG_MIN_APERTURE = 49435;
    public static final int TAG_PHOTO_EFFECT = 49446;
    public static final int TAG_QUALITY = 49411;
    public static final int TAG_RECORD_MODE = 49417;
    public static final int TAG_SATURATION = 49422;
    public static final int TAG_SELF_TIMER_DELAY = 49410;
    public static final int TAG_SHARPNESS = 49423;
    public static final int TAG_SHORT_FOCAL_LENGTH = 49432;
    public static final int TAG_SPOT_METERING_MODE = 49445;
    public static final int TAG_SRAW_QUALITY = 49453;
    public static final int TAG_UNKNOWN_2 = 49414;
    public static final int TAG_UNKNOWN_3 = 49416;
    public static final int TAG_UNKNOWN_7 = 49429;
    public static final int TAG_ZOOM_SOURCE_WIDTH = 49442;
    public static final int TAG_ZOOM_TARGET_WIDTH = 49443;
  }
  
  public static final class FocalLength
  {
    private static final int OFFSET = 49664;
    public static final int TAG_AEB_BRACKET_VALUE = 49681;
    public static final int TAG_AF_POINT_USED = 49678;
    public static final int TAG_AUTO_EXPOSURE_BRACKETING = 49680;
    public static final int TAG_FLASH_BIAS = 49679;
    public static final int TAG_SEQUENCE_NUMBER = 49673;
    public static final int TAG_SUBJECT_DISTANCE = 49683;
    public static final int TAG_WHITE_BALANCE = 49671;
  }
  
  public static final class Panorama
  {
    private static final int OFFSET = 50432;
    public static final int TAG_PANORAMA_DIRECTION = 50437;
    public static final int TAG_PANORAMA_FRAME_NUMBER = 50434;
  }
  
  public static final class ShotInfo
  {
    private static final int OFFSET = 50176;
    public static final int TAG_AEB_BRACKET_VALUE = 50193;
    public static final int TAG_AF_POINTS_IN_FOCUS = 50190;
    public static final int TAG_AUTO_EXPOSURE_BRACKETING = 50192;
    public static final int TAG_AUTO_ISO = 50177;
    public static final int TAG_AUTO_ROTATE = 50203;
    public static final int TAG_BASE_ISO = 50178;
    public static final int TAG_BULB_DURATION = 50200;
    public static final int TAG_CAMERA_TEMPERATURE = 50188;
    public static final int TAG_CAMERA_TYPE = 50202;
    public static final int TAG_CONTROL_MODE = 50194;
    public static final int TAG_EXPOSURE_COMPENSATION = 50182;
    public static final int TAG_EXPOSURE_TIME = 50198;
    public static final int TAG_FLASH_EXPOSURE_BRACKETING = 50191;
    public static final int TAG_FLASH_GUIDE_NUMBER = 50189;
    public static final int TAG_FLASH_OUTPUT = 50209;
    public static final int TAG_FOCUS_DISTANCE_LOWER = 50196;
    public static final int TAG_FOCUS_DISTANCE_UPPER = 50195;
    public static final int TAG_F_NUMBER = 50197;
    public static final int TAG_MEASURED_EV = 50179;
    public static final int TAG_MEASURED_EV_2 = 50199;
    public static final int TAG_ND_FILTER = 50204;
    public static final int TAG_OPTICAL_ZOOM_CODE = 50186;
    public static final int TAG_SELF_TIMER_2 = 50205;
    public static final int TAG_SEQUENCE_NUMBER = 50185;
    public static final int TAG_SLOW_SHUTTER = 50184;
    public static final int TAG_TARGET_APERTURE = 50180;
    public static final int TAG_TARGET_EXPOSURE_TIME = 50181;
    public static final int TAG_WHITE_BALANCE = 50183;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\CanonMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */