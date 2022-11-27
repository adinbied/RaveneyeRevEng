package com.drew.metadata.exif;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class PrintIMDirectory
  extends Directory
{
  public static final int TagPrintImVersion = 0;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(0), "PrintIM Version");
  }
  
  public PrintIMDirectory()
  {
    setDescriptor(new PrintIMDescriptor(this));
  }
  
  public String getName()
  {
    return "PrintIM";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\PrintIMDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */