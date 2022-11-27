package com.drew.metadata.exif;

import java.util.HashMap;

public class ExifInteropDirectory
  extends ExifDirectoryBase
{
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    addExifTagNames(localHashMap);
  }
  
  public ExifInteropDirectory()
  {
    setDescriptor(new ExifInteropDescriptor(this));
  }
  
  public String getName()
  {
    return "Interoperability";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\ExifInteropDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */