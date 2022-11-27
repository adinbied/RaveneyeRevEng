package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class AppleMakernoteDirectory
  extends Directory
{
  public static final int TAG_BURST_UUID = 11;
  public static final int TAG_HDR_IMAGE_TYPE = 10;
  public static final int TAG_RUN_TIME = 3;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(3), "Run Time");
    _tagNameMap.put(Integer.valueOf(10), "HDR Image Type");
    _tagNameMap.put(Integer.valueOf(11), "Burst UUID");
  }
  
  public AppleMakernoteDirectory()
  {
    setDescriptor(new AppleMakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Apple Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\AppleMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */