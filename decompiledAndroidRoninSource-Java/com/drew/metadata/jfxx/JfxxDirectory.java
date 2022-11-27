package com.drew.metadata.jfxx;

import com.drew.metadata.Directory;
import com.drew.metadata.MetadataException;
import java.util.HashMap;

public class JfxxDirectory
  extends Directory
{
  public static final int TAG_EXTENSION_CODE = 5;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(5), "Extension Code");
  }
  
  public JfxxDirectory()
  {
    setDescriptor(new JfxxDescriptor(this));
  }
  
  public int getExtensionCode()
    throws MetadataException
  {
    return getInt(5);
  }
  
  public String getName()
  {
    return "JFXX";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\jfxx\JfxxDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */