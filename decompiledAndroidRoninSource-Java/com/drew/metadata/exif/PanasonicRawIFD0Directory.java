package com.drew.metadata.exif;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class PanasonicRawIFD0Directory
  extends Directory
{
  public static final int TagBlackLevel1 = 8;
  public static final int TagBlackLevel2 = 9;
  public static final int TagBlackLevel3 = 10;
  public static final int TagBlackLevelBlue = 30;
  public static final int TagBlackLevelGreen = 29;
  public static final int TagBlackLevelRed = 28;
  public static final int TagBlueBalance = 18;
  public static final int TagCropBottom = 49;
  public static final int TagCropLeft = 48;
  public static final int TagCropRight = 50;
  public static final int TagCropTop = 47;
  public static final int TagDistortionInfo = 281;
  public static final int TagHighIsoMultiplierBlue = 26;
  public static final int TagHighIsoMultiplierGreen = 25;
  public static final int TagHighIsoMultiplierRed = 24;
  public static final int TagIso = 23;
  public static final int TagJpgFromRaw = 46;
  public static final int TagLinearityLimitBlue = 16;
  public static final int TagLinearityLimitGreen = 15;
  public static final int TagLinearityLimitRed = 14;
  public static final int TagMake = 271;
  public static final int TagModel = 272;
  public static final int TagOrientation = 274;
  public static final int TagPanasonicRawVersion = 1;
  public static final int TagRawDataOffset = 280;
  public static final int TagRedBalance = 17;
  public static final int TagRowsPerStrip = 278;
  public static final int TagSensorBottomBorder = 6;
  public static final int TagSensorHeight = 3;
  public static final int TagSensorLeftBorder = 5;
  public static final int TagSensorRightBorder = 7;
  public static final int TagSensorTopBorder = 4;
  public static final int TagSensorWidth = 2;
  public static final int TagStripByteCounts = 279;
  public static final int TagStripOffsets = 273;
  public static final int TagWbBlueLevel = 38;
  public static final int TagWbGreenLevel = 37;
  public static final int TagWbInfo = 19;
  public static final int TagWbInfo2 = 39;
  public static final int TagWbRedLevel = 36;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Panasonic Raw Version");
    _tagNameMap.put(Integer.valueOf(2), "Sensor Width");
    _tagNameMap.put(Integer.valueOf(3), "Sensor Height");
    _tagNameMap.put(Integer.valueOf(4), "Sensor Top Border");
    _tagNameMap.put(Integer.valueOf(5), "Sensor Left Border");
    _tagNameMap.put(Integer.valueOf(6), "Sensor Bottom Border");
    _tagNameMap.put(Integer.valueOf(7), "Sensor Right Border");
    _tagNameMap.put(Integer.valueOf(8), "Black Level 1");
    _tagNameMap.put(Integer.valueOf(9), "Black Level 2");
    _tagNameMap.put(Integer.valueOf(10), "Black Level 3");
    _tagNameMap.put(Integer.valueOf(14), "Linearity Limit Red");
    _tagNameMap.put(Integer.valueOf(15), "Linearity Limit Green");
    _tagNameMap.put(Integer.valueOf(16), "Linearity Limit Blue");
    _tagNameMap.put(Integer.valueOf(17), "Red Balance");
    _tagNameMap.put(Integer.valueOf(18), "Blue Balance");
    _tagNameMap.put(Integer.valueOf(23), "ISO");
    _tagNameMap.put(Integer.valueOf(24), "High ISO Multiplier Red");
    _tagNameMap.put(Integer.valueOf(25), "High ISO Multiplier Green");
    _tagNameMap.put(Integer.valueOf(26), "High ISO Multiplier Blue");
    _tagNameMap.put(Integer.valueOf(28), "Black Level Red");
    _tagNameMap.put(Integer.valueOf(29), "Black Level Green");
    _tagNameMap.put(Integer.valueOf(30), "Black Level Blue");
    _tagNameMap.put(Integer.valueOf(36), "WB Red Level");
    _tagNameMap.put(Integer.valueOf(37), "WB Green Level");
    _tagNameMap.put(Integer.valueOf(38), "WB Blue Level");
    _tagNameMap.put(Integer.valueOf(46), "Jpg From Raw");
    _tagNameMap.put(Integer.valueOf(47), "Crop Top");
    _tagNameMap.put(Integer.valueOf(48), "Crop Left");
    _tagNameMap.put(Integer.valueOf(49), "Crop Bottom");
    _tagNameMap.put(Integer.valueOf(50), "Crop Right");
    _tagNameMap.put(Integer.valueOf(271), "Make");
    _tagNameMap.put(Integer.valueOf(272), "Model");
    _tagNameMap.put(Integer.valueOf(273), "Strip Offsets");
    _tagNameMap.put(Integer.valueOf(274), "Orientation");
    _tagNameMap.put(Integer.valueOf(278), "Rows Per Strip");
    _tagNameMap.put(Integer.valueOf(279), "Strip Byte Counts");
    _tagNameMap.put(Integer.valueOf(280), "Raw Data Offset");
  }
  
  public PanasonicRawIFD0Directory()
  {
    setDescriptor(new PanasonicRawIFD0Descriptor(this));
  }
  
  public String getName()
  {
    return "PanasonicRaw Exif IFD0";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\PanasonicRawIFD0Directory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */