package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class SonyType6MakernoteDirectory
  extends Directory
{
  public static final int TAG_MAKERNOTE_THUMB_LENGTH = 1300;
  public static final int TAG_MAKERNOTE_THUMB_OFFSET = 1299;
  public static final int TAG_MAKERNOTE_THUMB_VERSION = 8192;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1299), "Makernote Thumb Offset");
    _tagNameMap.put(Integer.valueOf(1300), "Makernote Thumb Length");
    _tagNameMap.put(Integer.valueOf(8192), "Makernote Thumb Version");
  }
  
  public SonyType6MakernoteDirectory()
  {
    setDescriptor(new SonyType6MakernoteDescriptor(this));
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\SonyType6MakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */