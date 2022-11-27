package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class NikonType1MakernoteDirectory
  extends Directory
{
  public static final int TAG_CCD_SENSITIVITY = 6;
  public static final int TAG_COLOR_MODE = 4;
  public static final int TAG_CONVERTER = 11;
  public static final int TAG_DIGITAL_ZOOM = 10;
  public static final int TAG_FOCUS = 8;
  public static final int TAG_IMAGE_ADJUSTMENT = 5;
  public static final int TAG_QUALITY = 3;
  public static final int TAG_UNKNOWN_1 = 2;
  public static final int TAG_UNKNOWN_2 = 9;
  public static final int TAG_UNKNOWN_3 = 3840;
  public static final int TAG_WHITE_BALANCE = 7;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(6), "CCD Sensitivity");
    _tagNameMap.put(Integer.valueOf(4), "Color Mode");
    _tagNameMap.put(Integer.valueOf(10), "Digital Zoom");
    _tagNameMap.put(Integer.valueOf(11), "Fisheye Converter");
    _tagNameMap.put(Integer.valueOf(8), "Focus");
    _tagNameMap.put(Integer.valueOf(5), "Image Adjustment");
    _tagNameMap.put(Integer.valueOf(3), "Quality");
    _tagNameMap.put(Integer.valueOf(2), "Makernote Unknown 1");
    _tagNameMap.put(Integer.valueOf(9), "Makernote Unknown 2");
    _tagNameMap.put(Integer.valueOf(3840), "Makernote Unknown 3");
    _tagNameMap.put(Integer.valueOf(7), "White Balance");
  }
  
  public NikonType1MakernoteDirectory()
  {
    setDescriptor(new NikonType1MakernoteDescriptor(this));
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\NikonType1MakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */