package com.drew.metadata.gif;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class GifAnimationDirectory
  extends Directory
{
  public static final int TAG_ITERATION_COUNT = 1;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Iteration Count");
  }
  
  public GifAnimationDirectory()
  {
    setDescriptor(new GifAnimationDescriptor(this));
  }
  
  public String getName()
  {
    return "GIF Animation";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\gif\GifAnimationDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */