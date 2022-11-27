package com.drew.metadata.bmp;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class BmpHeaderDirectory
  extends Directory
{
  public static final int TAG_BITS_PER_PIXEL = 4;
  public static final int TAG_COLOUR_PLANES = 3;
  public static final int TAG_COMPRESSION = 5;
  public static final int TAG_HEADER_SIZE = -1;
  public static final int TAG_IMAGE_HEIGHT = 1;
  public static final int TAG_IMAGE_WIDTH = 2;
  public static final int TAG_IMPORTANT_COLOUR_COUNT = 9;
  public static final int TAG_PALETTE_COLOUR_COUNT = 8;
  public static final int TAG_X_PIXELS_PER_METER = 6;
  public static final int TAG_Y_PIXELS_PER_METER = 7;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(-1), "Header Size");
    _tagNameMap.put(Integer.valueOf(1), "Image Height");
    _tagNameMap.put(Integer.valueOf(2), "Image Width");
    _tagNameMap.put(Integer.valueOf(3), "Planes");
    _tagNameMap.put(Integer.valueOf(4), "Bits Per Pixel");
    _tagNameMap.put(Integer.valueOf(5), "Compression");
    _tagNameMap.put(Integer.valueOf(6), "X Pixels per Meter");
    _tagNameMap.put(Integer.valueOf(7), "Y Pixels per Meter");
    _tagNameMap.put(Integer.valueOf(8), "Palette Colour Count");
    _tagNameMap.put(Integer.valueOf(9), "Important Colour Count");
  }
  
  public BmpHeaderDirectory()
  {
    setDescriptor(new BmpHeaderDescriptor(this));
  }
  
  public String getName()
  {
    return "BMP Header";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\bmp\BmpHeaderDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */