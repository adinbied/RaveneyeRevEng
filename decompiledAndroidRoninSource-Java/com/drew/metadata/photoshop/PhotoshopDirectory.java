package com.drew.metadata.photoshop;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class PhotoshopDirectory
  extends Directory
{
  public static final int TAG_ALPHA_CHANNELS = 1006;
  public static final int TAG_ALPHA_IDENTIFIERS = 1053;
  public static final int TAG_ALTERNATE_DUOTONE_COLORS = 1066;
  public static final int TAG_ALTERNATE_SPOT_COLORS = 1067;
  public static final int TAG_AUTO_SAVE_FILE_PATH = 1086;
  public static final int TAG_AUTO_SAVE_FORMAT = 1087;
  public static final int TAG_BACKGROUND_COLOR = 1010;
  public static final int TAG_BORDER_INFORMATION = 1009;
  public static final int TAG_CAPTION = 1008;
  public static final int TAG_CAPTION_DIGEST = 1061;
  public static final int TAG_CHANNELS_ROWS_COLUMNS_DEPTH_MODE = 1000;
  public static final int TAG_CLIPPING_PATH_NAME = 2999;
  public static final int TAG_COLOR_HALFTONING_INFORMATION = 1013;
  public static final int TAG_COLOR_SAMPLERS = 1073;
  public static final int TAG_COLOR_TRANSFER_FUNCTIONS = 1016;
  public static final int TAG_COPYRIGHT = 1034;
  public static final int TAG_COUNT_INFORMATION = 1080;
  public static final int TAG_DISPLAY_INFO = 1077;
  public static final int TAG_DISPLAY_INFO_OBSOLETE = 1007;
  public static final int TAG_DUOTONE_HALFTONING_INFORMATION = 1014;
  public static final int TAG_DUOTONE_IMAGE_INFORMATION = 1018;
  public static final int TAG_DUOTONE_TRANSFER_FUNCTIONS = 1017;
  public static final int TAG_EFFECTIVE_BLACK_AND_WHITE_VALUES = 1019;
  public static final int TAG_EFFECTS_VISIBLE = 1042;
  public static final int TAG_EPS_OPTIONS = 1021;
  public static final int TAG_EXIF_DATA_1 = 1058;
  public static final int TAG_EXIF_DATA_3 = 1059;
  public static final int TAG_GLOBAL_ALTITUDE = 1049;
  public static final int TAG_GLOBAL_ANGLE = 1037;
  public static final int TAG_GRAYSCALE_AND_MULTICHANNEL_HALFTONING_INFORMATION = 1012;
  public static final int TAG_GRAYSCALE_AND_MULTICHANNEL_TRANSFER_FUNCTION = 1015;
  public static final int TAG_GRID_AND_GUIDES_INFORMATION = 1032;
  public static final int TAG_HDR_TONING_INFO = 1070;
  public static final int TAG_ICC_PROFILE_BYTES = 1039;
  public static final int TAG_ICC_UNTAGGED_PROFILE = 1041;
  public static final int TAG_IMAGE_MODE_FOR_RAW_FORMAT_FILES = 1029;
  public static final int TAG_IMAGE_READY_DATA_SETS = 7001;
  public static final int TAG_IMAGE_READY_VARIABLES_XML = 7000;
  public static final int TAG_INDEXED_COLOR_TABLE = 1003;
  public static final int TAG_INDEXED_COLOR_TABLE_COUNT = 1046;
  public static final int TAG_IPTC = 1028;
  public static final int TAG_JPEG_QUALITY = 1030;
  public static final int TAG_JUMP_TO_XPEP = 1052;
  public static final int TAG_LAYERS_GROUP_INFORMATION = 1026;
  public static final int TAG_LAYER_COMPS = 1065;
  public static final int TAG_LAYER_GROUPS_ENABLED_ID = 1072;
  public static final int TAG_LAYER_SELECTION_IDS = 1069;
  public static final int TAG_LAYER_STATE_INFORMATION = 1024;
  public static final int TAG_LIGHTROOM_WORKFLOW = 8000;
  public static final int TAG_MAC_NSPRINTINFO = 1084;
  public static final int TAG_MAC_PRINT_INFO = 1001;
  public static final int TAG_MEASUREMENT_SCALE = 1074;
  public static final int TAG_ONION_SKINS = 1078;
  public static final int TAG_ORIGIN_PATH_INFO = 3000;
  public static final int TAG_PATH_SELECTION_STATE = 1088;
  public static final int TAG_PIXEL_ASPECT_RATIO = 1064;
  public static final int TAG_PRINT_FLAGS = 1011;
  public static final int TAG_PRINT_FLAGS_INFO = 10000;
  public static final int TAG_PRINT_INFO = 1071;
  public static final int TAG_PRINT_INFO_2 = 1082;
  public static final int TAG_PRINT_SCALE = 1062;
  public static final int TAG_PRINT_STYLE = 1083;
  public static final int TAG_QUICK_MASK_INFORMATION = 1022;
  public static final int TAG_RESOLUTION_INFO = 1005;
  public static final int TAG_SEED_NUMBER = 1044;
  public static final int TAG_SHEET_DISCLOSURE = 1076;
  public static final int TAG_SLICES = 1050;
  public static final int TAG_SPOT_HALFTONE = 1043;
  public static final int TAG_THUMBNAIL = 1036;
  public static final int TAG_THUMBNAIL_OLD = 1033;
  public static final int TAG_TIMELINE_INFORMATION = 1075;
  public static final int TAG_TRANSPARENCY_INDEX = 1047;
  public static final int TAG_UNICODE_ALPHA_NAMES = 1045;
  public static final int TAG_URL = 1035;
  public static final int TAG_URL_LIST = 1054;
  public static final int TAG_VERSION = 1057;
  public static final int TAG_WATERMARK = 1040;
  public static final int TAG_WIN_DEVMODE = 1085;
  public static final int TAG_WORKFLOW_URL = 1051;
  public static final int TAG_XML = 1002;
  public static final int TAG_XMP_DATA = 1060;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1000), "Channels, Rows, Columns, Depth, Mode");
    _tagNameMap.put(Integer.valueOf(1001), "Mac Print Info");
    _tagNameMap.put(Integer.valueOf(1002), "XML Data");
    _tagNameMap.put(Integer.valueOf(1003), "Indexed Color Table");
    _tagNameMap.put(Integer.valueOf(1005), "Resolution Info");
    _tagNameMap.put(Integer.valueOf(1006), "Alpha Channels");
    _tagNameMap.put(Integer.valueOf(1007), "Display Info (Obsolete)");
    _tagNameMap.put(Integer.valueOf(1008), "Caption");
    _tagNameMap.put(Integer.valueOf(1009), "Border Information");
    _tagNameMap.put(Integer.valueOf(1010), "Background Color");
    _tagNameMap.put(Integer.valueOf(1011), "Print Flags");
    _tagNameMap.put(Integer.valueOf(1012), "Grayscale and Multichannel Halftoning Information");
    _tagNameMap.put(Integer.valueOf(1013), "Color Halftoning Information");
    _tagNameMap.put(Integer.valueOf(1014), "Duotone Halftoning Information");
    _tagNameMap.put(Integer.valueOf(1015), "Grayscale and Multichannel Transfer Function");
    _tagNameMap.put(Integer.valueOf(1016), "Color Transfer Functions");
    _tagNameMap.put(Integer.valueOf(1017), "Duotone Transfer Functions");
    _tagNameMap.put(Integer.valueOf(1018), "Duotone Image Information");
    _tagNameMap.put(Integer.valueOf(1019), "Effective Black and White Values");
    _tagNameMap.put(Integer.valueOf(1021), "EPS Options");
    _tagNameMap.put(Integer.valueOf(1022), "Quick Mask Information");
    _tagNameMap.put(Integer.valueOf(1024), "Layer State Information");
    _tagNameMap.put(Integer.valueOf(1026), "Layers Group Information");
    _tagNameMap.put(Integer.valueOf(1028), "IPTC-NAA Record");
    _tagNameMap.put(Integer.valueOf(1029), "Image Mode for Raw Format Files");
    _tagNameMap.put(Integer.valueOf(1030), "JPEG Quality");
    _tagNameMap.put(Integer.valueOf(1032), "Grid and Guides Information");
    _tagNameMap.put(Integer.valueOf(1033), "Photoshop 4.0 Thumbnail");
    _tagNameMap.put(Integer.valueOf(1034), "Copyright Flag");
    _tagNameMap.put(Integer.valueOf(1035), "URL");
    _tagNameMap.put(Integer.valueOf(1036), "Thumbnail Data");
    _tagNameMap.put(Integer.valueOf(1037), "Global Angle");
    _tagNameMap.put(Integer.valueOf(1039), "ICC Profile Bytes");
    _tagNameMap.put(Integer.valueOf(1040), "Watermark");
    _tagNameMap.put(Integer.valueOf(1041), "ICC Untagged Profile");
    _tagNameMap.put(Integer.valueOf(1042), "Effects Visible");
    _tagNameMap.put(Integer.valueOf(1043), "Spot Halftone");
    _tagNameMap.put(Integer.valueOf(1044), "Seed Number");
    _tagNameMap.put(Integer.valueOf(1045), "Unicode Alpha Names");
    _tagNameMap.put(Integer.valueOf(1046), "Indexed Color Table Count");
    _tagNameMap.put(Integer.valueOf(1047), "Transparency Index");
    _tagNameMap.put(Integer.valueOf(1049), "Global Altitude");
    _tagNameMap.put(Integer.valueOf(1050), "Slices");
    _tagNameMap.put(Integer.valueOf(1051), "Workflow URL");
    _tagNameMap.put(Integer.valueOf(1052), "Jump To XPEP");
    _tagNameMap.put(Integer.valueOf(1053), "Alpha Identifiers");
    _tagNameMap.put(Integer.valueOf(1054), "URL List");
    _tagNameMap.put(Integer.valueOf(1057), "Version Info");
    _tagNameMap.put(Integer.valueOf(1058), "EXIF Data 1");
    _tagNameMap.put(Integer.valueOf(1059), "EXIF Data 3");
    _tagNameMap.put(Integer.valueOf(1060), "XMP Data");
    _tagNameMap.put(Integer.valueOf(1061), "Caption Digest");
    _tagNameMap.put(Integer.valueOf(1062), "Print Scale");
    _tagNameMap.put(Integer.valueOf(1064), "Pixel Aspect Ratio");
    _tagNameMap.put(Integer.valueOf(1065), "Layer Comps");
    _tagNameMap.put(Integer.valueOf(1066), "Alternate Duotone Colors");
    _tagNameMap.put(Integer.valueOf(1067), "Alternate Spot Colors");
    _tagNameMap.put(Integer.valueOf(1069), "Layer Selection IDs");
    _tagNameMap.put(Integer.valueOf(1070), "HDR Toning Info");
    _tagNameMap.put(Integer.valueOf(1071), "Print Info");
    _tagNameMap.put(Integer.valueOf(1072), "Layer Groups Enabled ID");
    _tagNameMap.put(Integer.valueOf(1073), "Color Samplers");
    _tagNameMap.put(Integer.valueOf(1074), "Measurement Scale");
    _tagNameMap.put(Integer.valueOf(1075), "Timeline Information");
    _tagNameMap.put(Integer.valueOf(1076), "Sheet Disclosure");
    _tagNameMap.put(Integer.valueOf(1077), "Display Info");
    _tagNameMap.put(Integer.valueOf(1078), "Onion Skins");
    _tagNameMap.put(Integer.valueOf(1080), "Count information");
    _tagNameMap.put(Integer.valueOf(1082), "Print Info 2");
    _tagNameMap.put(Integer.valueOf(1083), "Print Style");
    _tagNameMap.put(Integer.valueOf(1084), "Mac NSPrintInfo");
    _tagNameMap.put(Integer.valueOf(1085), "Win DEVMODE");
    _tagNameMap.put(Integer.valueOf(1086), "Auto Save File Path");
    _tagNameMap.put(Integer.valueOf(1087), "Auto Save Format");
    _tagNameMap.put(Integer.valueOf(1088), "Path Selection State");
    _tagNameMap.put(Integer.valueOf(2999), "Clipping Path Name");
    _tagNameMap.put(Integer.valueOf(3000), "Origin Path Info");
    _tagNameMap.put(Integer.valueOf(7000), "Image Ready Variables XML");
    _tagNameMap.put(Integer.valueOf(7001), "Image Ready Data Sets");
    _tagNameMap.put(Integer.valueOf(8000), "Lightroom Workflow");
    _tagNameMap.put(Integer.valueOf(10000), "Print Flags Information");
  }
  
  public PhotoshopDirectory()
  {
    setDescriptor(new PhotoshopDescriptor(this));
  }
  
  public String getName()
  {
    return "Photoshop";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
  
  public byte[] getThumbnailBytes()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\photoshop\PhotoshopDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */