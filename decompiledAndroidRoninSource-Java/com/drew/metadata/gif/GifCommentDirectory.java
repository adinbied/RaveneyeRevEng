package com.drew.metadata.gif;

import com.drew.metadata.Directory;
import com.drew.metadata.StringValue;
import java.util.HashMap;

public class GifCommentDirectory
  extends Directory
{
  public static final int TAG_COMMENT = 1;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Comment");
  }
  
  public GifCommentDirectory(StringValue paramStringValue)
  {
    setDescriptor(new GifCommentDescriptor(this));
    setStringValue(1, paramStringValue);
  }
  
  public String getName()
  {
    return "GIF Comment";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\gif\GifCommentDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */