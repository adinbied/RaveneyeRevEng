package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class SanyoMakernoteDirectory
  extends Directory
{
  public static final int TAG_CAMERA_ID = 521;
  public static final int TAG_COLOR_ADJUSTMENT_MODE = 528;
  public static final int TAG_DATA_DUMP = 3840;
  public static final int TAG_DIGITAL_ZOOM = 516;
  public static final int TAG_DIGITAL_ZOOM_ON = 539;
  public static final int TAG_FLASH_MODE = 549;
  public static final int TAG_FLICKER_REDUCE = 536;
  public static final int TAG_LIGHT_SOURCE_SPECIAL = 541;
  public static final int TAG_MACRO = 514;
  public static final int TAG_MAKERNOTE_OFFSET = 255;
  public static final int TAG_MANUAL_FOCUS_DISTANCE_OR_FACE_INFO = 547;
  public static final int TAG_OPTICAL_ZOOM_ON = 537;
  public static final int TAG_PICT_INFO = 520;
  public static final int TAG_PRINT_IMAGE_MATCHING_INFO = 3584;
  public static final int TAG_QUICK_SHOT = 531;
  public static final int TAG_RECORD_SHUTTER_RELEASE = 535;
  public static final int TAG_RESAVED = 542;
  public static final int TAG_SANYO_QUALITY = 513;
  public static final int TAG_SANYO_THUMBNAIL = 256;
  public static final int TAG_SCENE_SELECT = 543;
  public static final int TAG_SELF_TIMER = 532;
  public static final int TAG_SEQUENCE_SHOT_INTERVAL = 548;
  public static final int TAG_SEQUENTIAL_SHOT = 526;
  public static final int TAG_SOFTWARE_VERSION = 519;
  public static final int TAG_SPECIAL_MODE = 512;
  public static final int TAG_VOICE_MEMO = 534;
  public static final int TAG_WIDE_RANGE = 527;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(255), "Makernote Offset");
    _tagNameMap.put(Integer.valueOf(256), "Sanyo Thumbnail");
    _tagNameMap.put(Integer.valueOf(512), "Special Mode");
    _tagNameMap.put(Integer.valueOf(513), "Sanyo Quality");
    _tagNameMap.put(Integer.valueOf(514), "Macro");
    _tagNameMap.put(Integer.valueOf(516), "Digital Zoom");
    _tagNameMap.put(Integer.valueOf(519), "Software Version");
    _tagNameMap.put(Integer.valueOf(520), "Pict Info");
    _tagNameMap.put(Integer.valueOf(521), "Camera ID");
    _tagNameMap.put(Integer.valueOf(526), "Sequential Shot");
    _tagNameMap.put(Integer.valueOf(527), "Wide Range");
    _tagNameMap.put(Integer.valueOf(528), "Color Adjustment Node");
    _tagNameMap.put(Integer.valueOf(531), "Quick Shot");
    _tagNameMap.put(Integer.valueOf(532), "Self Timer");
    _tagNameMap.put(Integer.valueOf(534), "Voice Memo");
    _tagNameMap.put(Integer.valueOf(535), "Record Shutter Release");
    _tagNameMap.put(Integer.valueOf(536), "Flicker Reduce");
    _tagNameMap.put(Integer.valueOf(537), "Optical Zoom On");
    _tagNameMap.put(Integer.valueOf(539), "Digital Zoom On");
    _tagNameMap.put(Integer.valueOf(541), "Light Source Special");
    _tagNameMap.put(Integer.valueOf(542), "Resaved");
    _tagNameMap.put(Integer.valueOf(543), "Scene Select");
    _tagNameMap.put(Integer.valueOf(547), "Manual Focus Distance or Face Info");
    _tagNameMap.put(Integer.valueOf(548), "Sequence Shot Interval");
    _tagNameMap.put(Integer.valueOf(549), "Flash Mode");
    _tagNameMap.put(Integer.valueOf(3584), "Print IM");
    _tagNameMap.put(Integer.valueOf(3840), "Data Dump");
  }
  
  public SanyoMakernoteDirectory()
  {
    setDescriptor(new SanyoMakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Sanyo Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\SanyoMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */