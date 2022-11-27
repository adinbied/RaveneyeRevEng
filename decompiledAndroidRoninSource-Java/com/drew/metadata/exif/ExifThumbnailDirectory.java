package com.drew.metadata.exif;

import java.util.HashMap;

public class ExifThumbnailDirectory
  extends ExifDirectoryBase
{
  @Deprecated
  public static final int TAG_THUMBNAIL_COMPRESSION = 259;
  public static final int TAG_THUMBNAIL_LENGTH = 514;
  public static final int TAG_THUMBNAIL_OFFSET = 513;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    addExifTagNames(localHashMap);
    _tagNameMap.put(Integer.valueOf(513), "Thumbnail Offset");
    _tagNameMap.put(Integer.valueOf(514), "Thumbnail Length");
  }
  
  public ExifThumbnailDirectory()
  {
    setDescriptor(new ExifThumbnailDescriptor(this));
  }
  
  public String getName()
  {
    return "Exif Thumbnail";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\ExifThumbnailDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */