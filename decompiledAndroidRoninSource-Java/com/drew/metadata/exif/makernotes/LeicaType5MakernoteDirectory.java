package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class LeicaType5MakernoteDirectory
  extends Directory
{
  public static final int TagExposureMode = 1037;
  public static final int TagFilmMode = 1042;
  public static final int TagLensModel = 771;
  public static final int TagOriginalDirectory = 1032;
  public static final int TagOriginalFileName = 1031;
  public static final int TagShotInfo = 1040;
  public static final int TagWbRgbLevels = 1043;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(771), "Lens Model");
    _tagNameMap.put(Integer.valueOf(1031), "Original File Name");
    _tagNameMap.put(Integer.valueOf(1032), "Original Directory");
    _tagNameMap.put(Integer.valueOf(1037), "Exposure Mode");
    _tagNameMap.put(Integer.valueOf(1040), "Shot Info");
    _tagNameMap.put(Integer.valueOf(1042), "Film Mode");
    _tagNameMap.put(Integer.valueOf(1043), "WB RGB Levels");
  }
  
  public LeicaType5MakernoteDirectory()
  {
    setDescriptor(new LeicaType5MakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Leica Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\LeicaType5MakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */