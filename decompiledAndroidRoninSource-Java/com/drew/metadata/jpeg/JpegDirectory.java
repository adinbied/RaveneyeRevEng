package com.drew.metadata.jpeg;

import com.drew.metadata.Directory;
import com.drew.metadata.MetadataException;
import java.util.HashMap;

public class JpegDirectory
  extends Directory
{
  public static final int TAG_COMPONENT_DATA_1 = 6;
  public static final int TAG_COMPONENT_DATA_2 = 7;
  public static final int TAG_COMPONENT_DATA_3 = 8;
  public static final int TAG_COMPONENT_DATA_4 = 9;
  public static final int TAG_COMPRESSION_TYPE = -3;
  public static final int TAG_DATA_PRECISION = 0;
  public static final int TAG_IMAGE_HEIGHT = 1;
  public static final int TAG_IMAGE_WIDTH = 3;
  public static final int TAG_NUMBER_OF_COMPONENTS = 5;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(-3), "Compression Type");
    _tagNameMap.put(Integer.valueOf(0), "Data Precision");
    _tagNameMap.put(Integer.valueOf(3), "Image Width");
    _tagNameMap.put(Integer.valueOf(1), "Image Height");
    _tagNameMap.put(Integer.valueOf(5), "Number of Components");
    _tagNameMap.put(Integer.valueOf(6), "Component 1");
    _tagNameMap.put(Integer.valueOf(7), "Component 2");
    _tagNameMap.put(Integer.valueOf(8), "Component 3");
    _tagNameMap.put(Integer.valueOf(9), "Component 4");
  }
  
  public JpegDirectory()
  {
    setDescriptor(new JpegDescriptor(this));
  }
  
  public JpegComponent getComponent(int paramInt)
  {
    return (JpegComponent)getObject(paramInt + 6);
  }
  
  public int getImageHeight()
    throws MetadataException
  {
    return getInt(1);
  }
  
  public int getImageWidth()
    throws MetadataException
  {
    return getInt(3);
  }
  
  public String getName()
  {
    return "JPEG";
  }
  
  public int getNumberOfComponents()
    throws MetadataException
  {
    return getInt(5);
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\jpeg\JpegDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */