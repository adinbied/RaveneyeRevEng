package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class OlympusRawDevelopment2MakernoteDirectory
  extends Directory
{
  public static final int TagRawDevArtFilter = 289;
  public static final int TagRawDevAutoGradation = 281;
  public static final int TagRawDevColorSpace = 265;
  public static final int TagRawDevContrastValue = 261;
  public static final int TagRawDevEngine = 267;
  public static final int TagRawDevExposureBiasValue = 256;
  public static final int TagRawDevGradation = 274;
  public static final int TagRawDevGrayPoint = 260;
  public static final int TagRawDevMemoryColorEmphasis = 264;
  public static final int TagRawDevNoiseReduction = 266;
  public static final int TagRawDevPictureMode = 268;
  public static final int TagRawDevPmBwFilter = 272;
  public static final int TagRawDevPmContrast = 270;
  public static final int TagRawDevPmNoiseFilter = 288;
  public static final int TagRawDevPmPictureTone = 273;
  public static final int TagRawDevPmSaturation = 269;
  public static final int TagRawDevPmSharpness = 271;
  public static final int TagRawDevSaturation3 = 275;
  public static final int TagRawDevSaturationEmphasis = 263;
  public static final int TagRawDevSharpnessValue = 262;
  public static final int TagRawDevVersion = 0;
  public static final int TagRawDevWbFineAdjustment = 259;
  public static final int TagRawDevWhiteBalance = 257;
  public static final int TagRawDevWhiteBalanceValue = 258;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(0), "Raw Dev Version");
    _tagNameMap.put(Integer.valueOf(256), "Raw Dev Exposure Bias Value");
    _tagNameMap.put(Integer.valueOf(257), "Raw Dev White Balance");
    _tagNameMap.put(Integer.valueOf(258), "Raw Dev White Balance Value");
    _tagNameMap.put(Integer.valueOf(259), "Raw Dev WB Fine Adjustment");
    _tagNameMap.put(Integer.valueOf(260), "Raw Dev Gray Point");
    _tagNameMap.put(Integer.valueOf(261), "Raw Dev Contrast Value");
    _tagNameMap.put(Integer.valueOf(262), "Raw Dev Sharpness Value");
    _tagNameMap.put(Integer.valueOf(263), "Raw Dev Saturation Emphasis");
    _tagNameMap.put(Integer.valueOf(264), "Raw Dev Memory Color Emphasis");
    _tagNameMap.put(Integer.valueOf(265), "Raw Dev Color Space");
    _tagNameMap.put(Integer.valueOf(266), "Raw Dev Noise Reduction");
    _tagNameMap.put(Integer.valueOf(267), "Raw Dev Engine");
    _tagNameMap.put(Integer.valueOf(268), "Raw Dev Picture Mode");
    _tagNameMap.put(Integer.valueOf(269), "Raw Dev PM Saturation");
    _tagNameMap.put(Integer.valueOf(270), "Raw Dev PM Contrast");
    _tagNameMap.put(Integer.valueOf(271), "Raw Dev PM Sharpness");
    _tagNameMap.put(Integer.valueOf(272), "Raw Dev PM BW Filter");
    _tagNameMap.put(Integer.valueOf(273), "Raw Dev PM Picture Tone");
    _tagNameMap.put(Integer.valueOf(274), "Raw Dev Gradation");
    _tagNameMap.put(Integer.valueOf(275), "Raw Dev Saturation 3");
    _tagNameMap.put(Integer.valueOf(281), "Raw Dev Auto Gradation");
    _tagNameMap.put(Integer.valueOf(288), "Raw Dev PM Noise Filter");
    _tagNameMap.put(Integer.valueOf(289), "Raw Dev Art Filter");
  }
  
  public OlympusRawDevelopment2MakernoteDirectory()
  {
    setDescriptor(new OlympusRawDevelopment2MakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Olympus Raw Development 2";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\OlympusRawDevelopment2MakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */