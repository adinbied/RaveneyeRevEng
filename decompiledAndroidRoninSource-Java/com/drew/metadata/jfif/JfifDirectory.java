package com.drew.metadata.jfif;

import com.drew.metadata.Directory;
import com.drew.metadata.MetadataException;
import java.util.HashMap;

public class JfifDirectory
  extends Directory
{
  public static final int TAG_RESX = 8;
  public static final int TAG_RESY = 10;
  public static final int TAG_THUMB_HEIGHT = 13;
  public static final int TAG_THUMB_WIDTH = 12;
  public static final int TAG_UNITS = 7;
  public static final int TAG_VERSION = 5;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(5), "Version");
    _tagNameMap.put(Integer.valueOf(7), "Resolution Units");
    _tagNameMap.put(Integer.valueOf(10), "Y Resolution");
    _tagNameMap.put(Integer.valueOf(8), "X Resolution");
    _tagNameMap.put(Integer.valueOf(12), "Thumbnail Width Pixels");
    _tagNameMap.put(Integer.valueOf(13), "Thumbnail Height Pixels");
  }
  
  public JfifDirectory()
  {
    setDescriptor(new JfifDescriptor(this));
  }
  
  @Deprecated
  public int getImageHeight()
    throws MetadataException
  {
    return getInt(8);
  }
  
  @Deprecated
  public int getImageWidth()
    throws MetadataException
  {
    return getInt(10);
  }
  
  public String getName()
  {
    return "JFIF";
  }
  
  public int getResUnits()
    throws MetadataException
  {
    return getInt(7);
  }
  
  public int getResX()
    throws MetadataException
  {
    return getInt(8);
  }
  
  public int getResY()
    throws MetadataException
  {
    return getInt(10);
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
  
  public int getVersion()
    throws MetadataException
  {
    return getInt(5);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\jfif\JfifDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */