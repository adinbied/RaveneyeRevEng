package com.drew.metadata.pcx;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class PcxDirectory
  extends Directory
{
  public static final int TAG_BITS_PER_PIXEL = 2;
  public static final int TAG_BYTES_PER_LINE = 11;
  public static final int TAG_COLOR_PLANES = 10;
  public static final int TAG_HORIZONTAL_DPI = 7;
  public static final int TAG_HSCR_SIZE = 13;
  public static final int TAG_PALETTE = 9;
  public static final int TAG_PALETTE_TYPE = 12;
  public static final int TAG_VERSION = 1;
  public static final int TAG_VERTICAL_DPI = 8;
  public static final int TAG_VSCR_SIZE = 14;
  public static final int TAG_XMAX = 5;
  public static final int TAG_XMIN = 3;
  public static final int TAG_YMAX = 6;
  public static final int TAG_YMIN = 4;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Version");
    _tagNameMap.put(Integer.valueOf(2), "Bits Per Pixel");
    _tagNameMap.put(Integer.valueOf(3), "X Min");
    _tagNameMap.put(Integer.valueOf(4), "Y Min");
    _tagNameMap.put(Integer.valueOf(5), "X Max");
    _tagNameMap.put(Integer.valueOf(6), "Y Max");
    _tagNameMap.put(Integer.valueOf(7), "Horizontal DPI");
    _tagNameMap.put(Integer.valueOf(8), "Vertical DPI");
    _tagNameMap.put(Integer.valueOf(9), "Palette");
    _tagNameMap.put(Integer.valueOf(10), "Color Planes");
    _tagNameMap.put(Integer.valueOf(11), "Bytes Per Line");
    _tagNameMap.put(Integer.valueOf(12), "Palette Type");
    _tagNameMap.put(Integer.valueOf(13), "H Scr Size");
    _tagNameMap.put(Integer.valueOf(14), "V Scr Size");
  }
  
  public PcxDirectory()
  {
    setDescriptor(new PcxDescriptor(this));
  }
  
  public String getName()
  {
    return "PCX";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\pcx\PcxDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */