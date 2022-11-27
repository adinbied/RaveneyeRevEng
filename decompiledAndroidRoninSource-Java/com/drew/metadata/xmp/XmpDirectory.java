package com.drew.metadata.xmp;

import com.adobe.xmp.XMPMeta;
import com.drew.metadata.Directory;
import java.util.HashMap;
import java.util.Map;

public class XmpDirectory
  extends Directory
{
  public static final int TAG_XMP_VALUE_COUNT = 65535;
  protected static final HashMap<Integer, String> _tagNameMap;
  private XMPMeta _xmpMeta;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(65535), "XMP Value Count");
  }
  
  public XmpDirectory()
  {
    setDescriptor(new XmpDescriptor(this));
  }
  
  public String getName()
  {
    return "XMP";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
  
  public XMPMeta getXMPMeta()
  {
    return null;
  }
  
  public Map<String, String> getXmpProperties()
  {
    return null;
  }
  
  /* Error */
  public void setXMPMeta(XMPMeta arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\xmp\XmpDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */