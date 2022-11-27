package com.drew.metadata.exif;

import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class ExifSubIFDDirectory
  extends ExifDirectoryBase
{
  public static final int TAG_INTEROP_OFFSET = 40965;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    addExifTagNames(localHashMap);
  }
  
  public ExifSubIFDDirectory()
  {
    setDescriptor(new ExifSubIFDDescriptor(this));
  }
  
  public Date getDateDigitized()
  {
    return getDateDigitized(null);
  }
  
  public Date getDateDigitized(TimeZone paramTimeZone)
  {
    return null;
  }
  
  public Date getDateOriginal()
  {
    return getDateOriginal(null);
  }
  
  public Date getDateOriginal(TimeZone paramTimeZone)
  {
    return null;
  }
  
  public String getName()
  {
    return "Exif SubIFD";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\ExifSubIFDDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */