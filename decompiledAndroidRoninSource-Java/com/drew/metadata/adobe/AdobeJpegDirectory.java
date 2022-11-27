package com.drew.metadata.adobe;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class AdobeJpegDirectory
  extends Directory
{
  public static final int TAG_APP14_FLAGS0 = 1;
  public static final int TAG_APP14_FLAGS1 = 2;
  public static final int TAG_COLOR_TRANSFORM = 3;
  public static final int TAG_DCT_ENCODE_VERSION = 0;
  private static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(0), "DCT Encode Version");
    _tagNameMap.put(Integer.valueOf(1), "Flags 0");
    _tagNameMap.put(Integer.valueOf(2), "Flags 1");
    _tagNameMap.put(Integer.valueOf(3), "Color Transform");
  }
  
  public AdobeJpegDirectory()
  {
    setDescriptor(new AdobeJpegDescriptor(this));
  }
  
  public String getName()
  {
    return "Adobe JPEG";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\adobe\AdobeJpegDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */