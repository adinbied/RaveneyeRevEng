package com.drew.metadata.photoshop;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class PsdHeaderDirectory
  extends Directory
{
  public static final int TAG_BITS_PER_CHANNEL = 4;
  public static final int TAG_CHANNEL_COUNT = 1;
  public static final int TAG_COLOR_MODE = 5;
  public static final int TAG_IMAGE_HEIGHT = 2;
  public static final int TAG_IMAGE_WIDTH = 3;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Channel Count");
    _tagNameMap.put(Integer.valueOf(2), "Image Height");
    _tagNameMap.put(Integer.valueOf(3), "Image Width");
    _tagNameMap.put(Integer.valueOf(4), "Bits Per Channel");
    _tagNameMap.put(Integer.valueOf(5), "Color Mode");
  }
  
  public PsdHeaderDirectory()
  {
    setDescriptor(new PsdHeaderDescriptor(this));
  }
  
  public String getName()
  {
    return "PSD Header";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\photoshop\PsdHeaderDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */