package com.drew.imaging.jpeg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public enum JpegSegmentType
{
  public static final Collection<JpegSegmentType> canContainMetadataTypes;
  public final byte byteValue;
  public final boolean canContainMetadata;
  
  static
  {
    int i = 0;
    APP0 = new JpegSegmentType("APP0", 0, (byte)-32, true);
    APP1 = new JpegSegmentType("APP1", 1, (byte)-31, true);
    APP2 = new JpegSegmentType("APP2", 2, (byte)-30, true);
    APP3 = new JpegSegmentType("APP3", 3, (byte)-29, true);
    APP4 = new JpegSegmentType("APP4", 4, (byte)-28, true);
    APP5 = new JpegSegmentType("APP5", 5, (byte)-27, true);
    APP6 = new JpegSegmentType("APP6", 6, (byte)-26, true);
    APP7 = new JpegSegmentType("APP7", 7, (byte)-25, true);
    APP8 = new JpegSegmentType("APP8", 8, (byte)-24, true);
    APP9 = new JpegSegmentType("APP9", 9, (byte)-23, true);
    APPA = new JpegSegmentType("APPA", 10, (byte)-22, true);
    APPB = new JpegSegmentType("APPB", 11, (byte)-21, true);
    APPC = new JpegSegmentType("APPC", 12, (byte)-20, true);
    APPD = new JpegSegmentType("APPD", 13, (byte)-19, true);
    APPE = new JpegSegmentType("APPE", 14, (byte)-18, true);
    APPF = new JpegSegmentType("APPF", 15, (byte)-17, true);
    SOI = new JpegSegmentType("SOI", 16, (byte)-40, false);
    DQT = new JpegSegmentType("DQT", 17, (byte)-37, false);
    DNL = new JpegSegmentType("DNL", 18, (byte)-36, false);
    DRI = new JpegSegmentType("DRI", 19, (byte)-35, false);
    DHP = new JpegSegmentType("DHP", 20, (byte)-34, false);
    EXP = new JpegSegmentType("EXP", 21, (byte)-33, false);
    DHT = new JpegSegmentType("DHT", 22, (byte)-60, false);
    DAC = new JpegSegmentType("DAC", 23, (byte)-52, false);
    SOF0 = new JpegSegmentType("SOF0", 24, (byte)-64, true);
    SOF1 = new JpegSegmentType("SOF1", 25, (byte)-63, true);
    SOF2 = new JpegSegmentType("SOF2", 26, (byte)-62, true);
    SOF3 = new JpegSegmentType("SOF3", 27, (byte)-61, true);
    SOF5 = new JpegSegmentType("SOF5", 28, (byte)-59, true);
    SOF6 = new JpegSegmentType("SOF6", 29, (byte)-58, true);
    SOF7 = new JpegSegmentType("SOF7", 30, (byte)-57, true);
    JPG = new JpegSegmentType("JPG", 31, (byte)-56, true);
    SOF9 = new JpegSegmentType("SOF9", 32, (byte)-55, true);
    SOF10 = new JpegSegmentType("SOF10", 33, (byte)-54, true);
    SOF11 = new JpegSegmentType("SOF11", 34, (byte)-53, true);
    SOF13 = new JpegSegmentType("SOF13", 35, (byte)-51, true);
    SOF14 = new JpegSegmentType("SOF14", 36, (byte)-50, true);
    SOF15 = new JpegSegmentType("SOF15", 37, (byte)-49, true);
    Object localObject = new JpegSegmentType("COM", 38, (byte)-2, true);
    COM = (JpegSegmentType)localObject;
    $VALUES = new JpegSegmentType[] { APP0, APP1, APP2, APP3, APP4, APP5, APP6, APP7, APP8, APP9, APPA, APPB, APPC, APPD, APPE, APPF, SOI, DQT, DNL, DRI, DHP, EXP, DHT, DAC, SOF0, SOF1, SOF2, SOF3, SOF5, SOF6, SOF7, JPG, SOF9, SOF10, SOF11, SOF13, SOF14, SOF15, localObject };
    localObject = new ArrayList();
    JpegSegmentType[] arrayOfJpegSegmentType = (JpegSegmentType[])JpegSegmentType.class.getEnumConstants();
    int j = arrayOfJpegSegmentType.length;
    while (i < j)
    {
      JpegSegmentType localJpegSegmentType = arrayOfJpegSegmentType[i];
      if (localJpegSegmentType.canContainMetadata) {
        ((List)localObject).add(localJpegSegmentType);
      }
      i += 1;
    }
    canContainMetadataTypes = (Collection)localObject;
  }
  
  private JpegSegmentType(byte paramByte, boolean paramBoolean)
  {
    this.byteValue = paramByte;
    this.canContainMetadata = paramBoolean;
  }
  
  public static JpegSegmentType fromByte(byte paramByte)
  {
    JpegSegmentType[] arrayOfJpegSegmentType = (JpegSegmentType[])JpegSegmentType.class.getEnumConstants();
    int j = arrayOfJpegSegmentType.length;
    int i = 0;
    while (i < j)
    {
      JpegSegmentType localJpegSegmentType = arrayOfJpegSegmentType[i];
      if (localJpegSegmentType.byteValue == paramByte) {
        return localJpegSegmentType;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\jpeg\JpegSegmentType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */