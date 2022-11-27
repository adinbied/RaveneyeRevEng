package com.drew.metadata.photoshop;

import com.drew.metadata.Directory;
import com.drew.metadata.TagDescriptor;
import java.util.HashMap;

public class DuckyDirectory
  extends Directory
{
  public static final int TAG_COMMENT = 2;
  public static final int TAG_COPYRIGHT = 3;
  public static final int TAG_QUALITY = 1;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Quality");
    _tagNameMap.put(Integer.valueOf(2), "Comment");
    _tagNameMap.put(Integer.valueOf(3), "Copyright");
  }
  
  public DuckyDirectory()
  {
    setDescriptor(new TagDescriptor(this));
  }
  
  public String getName()
  {
    return "Ducky";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\photoshop\DuckyDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */