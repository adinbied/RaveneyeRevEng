package com.drew.metadata.webp;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class WebpDirectory
  extends Directory
{
  public static final int TAG_HAS_ALPHA = 3;
  public static final int TAG_IMAGE_HEIGHT = 1;
  public static final int TAG_IMAGE_WIDTH = 2;
  public static final int TAG_IS_ANIMATION = 4;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Image Height");
    _tagNameMap.put(Integer.valueOf(2), "Image Width");
    _tagNameMap.put(Integer.valueOf(3), "Has Alpha");
    _tagNameMap.put(Integer.valueOf(4), "Is Animation");
  }
  
  public WebpDirectory()
  {
    setDescriptor(new WebpDescriptor(this));
  }
  
  public String getName()
  {
    return "WebP";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\webp\WebpDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */