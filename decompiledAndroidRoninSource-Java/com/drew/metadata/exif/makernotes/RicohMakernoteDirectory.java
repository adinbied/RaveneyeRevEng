package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class RicohMakernoteDirectory
  extends Directory
{
  public static final int TAG_MAKERNOTE_DATA_TYPE = 1;
  public static final int TAG_PRINT_IMAGE_MATCHING_INFO = 3584;
  public static final int TAG_RICOH_CAMERA_INFO_MAKERNOTE_SUB_IFD_POINTER = 8193;
  public static final int TAG_VERSION = 2;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Makernote Data Type");
    _tagNameMap.put(Integer.valueOf(2), "Version");
    _tagNameMap.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
    _tagNameMap.put(Integer.valueOf(8193), "Ricoh Camera Info Makernote Sub-IFD");
  }
  
  public RicohMakernoteDirectory()
  {
    setDescriptor(new RicohMakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Ricoh Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\RicohMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */