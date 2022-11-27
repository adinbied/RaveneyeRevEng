package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class KyoceraMakernoteDirectory
  extends Directory
{
  public static final int TAG_PRINT_IMAGE_MATCHING_INFO = 3584;
  public static final int TAG_PROPRIETARY_THUMBNAIL = 1;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Proprietary Thumbnail Format Data");
    _tagNameMap.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
  }
  
  public KyoceraMakernoteDirectory()
  {
    setDescriptor(new KyoceraMakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Kyocera/Contax Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\KyoceraMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */