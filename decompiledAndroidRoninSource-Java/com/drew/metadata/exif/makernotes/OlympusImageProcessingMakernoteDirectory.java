package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class OlympusImageProcessingMakernoteDirectory
  extends Directory
{
  public static final int TagAspectFrame = 4371;
  public static final int TagAspectRatio = 4370;
  public static final int TagBlackLevel2 = 1536;
  public static final int TagCameraTemperature = 4870;
  public static final int TagColorMatrix = 512;
  public static final int TagCoringFilter = 784;
  public static final int TagCoringValues = 785;
  public static final int TagCropHeight = 1557;
  public static final int TagCropLeft = 1554;
  public static final int TagCropTop = 1555;
  public static final int TagCropWidth = 1556;
  public static final int TagDistortionCorrection2 = 4113;
  public static final int TagEnhancer = 768;
  public static final int TagEnhancerValues = 769;
  public static final int TagFaceDetectArea = 4609;
  public static final int TagFaceDetectFrameCrop = 4615;
  public static final int TagFaceDetectFrameSize = 4611;
  public static final int TagFacesDetected = 4608;
  public static final int TagGainBase = 1552;
  public static final int TagImageProcessingVersion = 0;
  public static final int TagKeystoneCompensation = 6400;
  public static final int TagKeystoneDirection = 6401;
  public static final int TagKeystoneValue = 6406;
  public static final int TagMaxFaces = 4610;
  public static final int TagMultipleExposureMode = 4124;
  public static final int TagNoiseReduction2 = 4112;
  public static final int TagSensorCalibration = 2053;
  public static final int TagShadingCompensation2 = 4114;
  public static final int TagUnknownBlock1 = 1589;
  public static final int TagUnknownBlock2 = 1590;
  public static final int TagUnknownBlock3 = 4355;
  public static final int TagUnknownBlock4 = 4356;
  public static final int TagValidBits = 1553;
  public static final int TagWbGLevel = 287;
  public static final int TagWbGLevel3000K = 275;
  public static final int TagWbGLevel3300K = 276;
  public static final int TagWbGLevel3600K = 277;
  public static final int TagWbGLevel3900K = 278;
  public static final int TagWbGLevel4000K = 279;
  public static final int TagWbGLevel4300K = 280;
  public static final int TagWbGLevel4500K = 281;
  public static final int TagWbGLevel4800K = 282;
  public static final int TagWbGLevel5300K = 283;
  public static final int TagWbGLevel6000K = 284;
  public static final int TagWbGLevel6600K = 285;
  public static final int TagWbGLevel7500K = 286;
  public static final int TagWbRbLevels = 256;
  public static final int TagWbRbLevels3000K = 258;
  public static final int TagWbRbLevels3300K = 259;
  public static final int TagWbRbLevels3600K = 260;
  public static final int TagWbRbLevels3900K = 261;
  public static final int TagWbRbLevels4000K = 262;
  public static final int TagWbRbLevels4300K = 263;
  public static final int TagWbRbLevels4500K = 264;
  public static final int TagWbRbLevels4800K = 265;
  public static final int TagWbRbLevels5300K = 266;
  public static final int TagWbRbLevels6000K = 267;
  public static final int TagWbRbLevels6600K = 268;
  public static final int TagWbRbLevels7500K = 269;
  public static final int TagWbRbLevelsCwB1 = 270;
  public static final int TagWbRbLevelsCwB2 = 271;
  public static final int TagWbRbLevelsCwB3 = 272;
  public static final int TagWbRbLevelsCwB4 = 273;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(0), "Image Processing Version");
    _tagNameMap.put(Integer.valueOf(256), "WB RB Levels");
    _tagNameMap.put(Integer.valueOf(258), "WB RB Levels 3000K");
    _tagNameMap.put(Integer.valueOf(259), "WB RB Levels 3300K");
    _tagNameMap.put(Integer.valueOf(260), "WB RB Levels 3600K");
    _tagNameMap.put(Integer.valueOf(261), "WB RB Levels 3900K");
    _tagNameMap.put(Integer.valueOf(262), "WB RB Levels 4000K");
    _tagNameMap.put(Integer.valueOf(263), "WB RB Levels 4300K");
    _tagNameMap.put(Integer.valueOf(264), "WB RB Levels 4500K");
    _tagNameMap.put(Integer.valueOf(265), "WB RB Levels 4800K");
    _tagNameMap.put(Integer.valueOf(266), "WB RB Levels 5300K");
    _tagNameMap.put(Integer.valueOf(267), "WB RB Levels 6000K");
    _tagNameMap.put(Integer.valueOf(268), "WB RB Levels 6600K");
    _tagNameMap.put(Integer.valueOf(269), "WB RB Levels 7500K");
    _tagNameMap.put(Integer.valueOf(270), "WB RB Levels CWB1");
    _tagNameMap.put(Integer.valueOf(271), "WB RB Levels CWB2");
    _tagNameMap.put(Integer.valueOf(272), "WB RB Levels CWB3");
    _tagNameMap.put(Integer.valueOf(273), "WB RB Levels CWB4");
    _tagNameMap.put(Integer.valueOf(275), "WB G Level 3000K");
    _tagNameMap.put(Integer.valueOf(276), "WB G Level 3300K");
    _tagNameMap.put(Integer.valueOf(277), "WB G Level 3600K");
    _tagNameMap.put(Integer.valueOf(278), "WB G Level 3900K");
    _tagNameMap.put(Integer.valueOf(279), "WB G Level 4000K");
    _tagNameMap.put(Integer.valueOf(280), "WB G Level 4300K");
    _tagNameMap.put(Integer.valueOf(281), "WB G Level 4500K");
    _tagNameMap.put(Integer.valueOf(282), "WB G Level 4800K");
    _tagNameMap.put(Integer.valueOf(283), "WB G Level 5300K");
    _tagNameMap.put(Integer.valueOf(284), "WB G Level 6000K");
    _tagNameMap.put(Integer.valueOf(285), "WB G Level 6600K");
    _tagNameMap.put(Integer.valueOf(286), "WB G Level 7500K");
    _tagNameMap.put(Integer.valueOf(287), "WB G Level");
    _tagNameMap.put(Integer.valueOf(512), "Color Matrix");
    _tagNameMap.put(Integer.valueOf(768), "Enhancer");
    _tagNameMap.put(Integer.valueOf(769), "Enhancer Values");
    _tagNameMap.put(Integer.valueOf(784), "Coring Filter");
    _tagNameMap.put(Integer.valueOf(785), "Coring Values");
    _tagNameMap.put(Integer.valueOf(1536), "Black Level 2");
    _tagNameMap.put(Integer.valueOf(1552), "Gain Base");
    _tagNameMap.put(Integer.valueOf(1553), "Valid Bits");
    _tagNameMap.put(Integer.valueOf(1554), "Crop Left");
    _tagNameMap.put(Integer.valueOf(1555), "Crop Top");
    _tagNameMap.put(Integer.valueOf(1556), "Crop Width");
    _tagNameMap.put(Integer.valueOf(1557), "Crop Height");
    _tagNameMap.put(Integer.valueOf(1589), "Unknown Block 1");
    _tagNameMap.put(Integer.valueOf(1590), "Unknown Block 2");
    _tagNameMap.put(Integer.valueOf(2053), "Sensor Calibration");
    _tagNameMap.put(Integer.valueOf(4112), "Noise Reduction 2");
    _tagNameMap.put(Integer.valueOf(4113), "Distortion Correction 2");
    _tagNameMap.put(Integer.valueOf(4114), "Shading Compensation 2");
    _tagNameMap.put(Integer.valueOf(4124), "Multiple Exposure Mode");
    _tagNameMap.put(Integer.valueOf(4355), "Unknown Block 3");
    _tagNameMap.put(Integer.valueOf(4356), "Unknown Block 4");
    _tagNameMap.put(Integer.valueOf(4370), "Aspect Ratio");
    _tagNameMap.put(Integer.valueOf(4371), "Aspect Frame");
    _tagNameMap.put(Integer.valueOf(4608), "Faces Detected");
    _tagNameMap.put(Integer.valueOf(4609), "Face Detect Area");
    _tagNameMap.put(Integer.valueOf(4610), "Max Faces");
    _tagNameMap.put(Integer.valueOf(4611), "Face Detect Frame Size");
    _tagNameMap.put(Integer.valueOf(4615), "Face Detect Frame Crop");
    _tagNameMap.put(Integer.valueOf(4870), "Camera Temperature");
    _tagNameMap.put(Integer.valueOf(6400), "Keystone Compensation");
    _tagNameMap.put(Integer.valueOf(6401), "Keystone Direction");
    _tagNameMap.put(Integer.valueOf(6406), "Keystone Value");
  }
  
  public OlympusImageProcessingMakernoteDirectory()
  {
    setDescriptor(new OlympusImageProcessingMakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Olympus Image Processing";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\OlympusImageProcessingMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */