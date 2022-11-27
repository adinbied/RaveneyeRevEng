package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class OlympusCameraSettingsMakernoteDirectory
  extends Directory
{
  public static final int TagAeLock = 513;
  public static final int TagAfAreas = 772;
  public static final int TagAfFineTune = 774;
  public static final int TagAfFineTuneAdj = 775;
  public static final int TagAfPointSelected = 773;
  public static final int TagAfSearch = 771;
  public static final int TagArtFilter = 1321;
  public static final int TagArtFilterEffect = 1327;
  public static final int TagCameraSettingsVersion = 0;
  public static final int TagColorCreatorEffect = 1330;
  public static final int TagColorSpace = 1287;
  public static final int TagCompressionFactor = 1293;
  public static final int TagContrastSetting = 1285;
  public static final int TagCustomSaturation = 1283;
  public static final int TagDateTimeUtc = 2312;
  public static final int TagDistortionCorrection = 1291;
  public static final int TagDriveMode = 1536;
  public static final int TagExposureMode = 512;
  public static final int TagExposureShift = 515;
  public static final int TagExtendedWBDetect = 2306;
  public static final int TagFlashControlMode = 1028;
  public static final int TagFlashExposureComp = 1025;
  public static final int TagFlashIntensity = 1029;
  public static final int TagFlashMode = 1024;
  public static final int TagFlashRemoteControl = 1027;
  public static final int TagFocusMode = 769;
  public static final int TagFocusProcess = 770;
  public static final int TagGradation = 1295;
  public static final int TagImageQuality2 = 1539;
  public static final int TagImageStabilization = 1540;
  public static final int TagMacroMode = 768;
  public static final int TagMagicFilter = 1324;
  public static final int TagManometerPressure = 2304;
  public static final int TagManometerReading = 2305;
  public static final int TagManualFlashStrength = 1030;
  public static final int TagMeteringMode = 514;
  public static final int TagModifiedSaturation = 1284;
  public static final int TagNdFilter = 516;
  public static final int TagNoiseFilter = 1319;
  public static final int TagNoiseReduction = 1290;
  public static final int TagPanoramaMode = 1537;
  public static final int TagPictureMode = 1312;
  public static final int TagPictureModeBWFilter = 1317;
  public static final int TagPictureModeContrast = 1315;
  public static final int TagPictureModeEffect = 1325;
  public static final int TagPictureModeHue = 1314;
  public static final int TagPictureModeSaturation = 1313;
  public static final int TagPictureModeSharpness = 1316;
  public static final int TagPictureModeTone = 1318;
  public static final int TagPitchAngle = 2308;
  public static final int TagPreviewImageLength = 258;
  public static final int TagPreviewImageStart = 257;
  public static final int TagPreviewImageValid = 256;
  public static final int TagRollAngle = 2307;
  public static final int TagSceneMode = 1289;
  public static final int TagShadingCompensation = 1292;
  public static final int TagSharpnessSetting = 1286;
  public static final int TagStackedImage = 2052;
  public static final int TagToneLevel = 1326;
  public static final int TagWhiteBalance2 = 1280;
  public static final int TagWhiteBalanceBracket = 1282;
  public static final int TagWhiteBalanceTemperature = 1281;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(0), "Camera Settings Version");
    _tagNameMap.put(Integer.valueOf(256), "Preview Image Valid");
    _tagNameMap.put(Integer.valueOf(257), "Preview Image Start");
    _tagNameMap.put(Integer.valueOf(258), "Preview Image Length");
    _tagNameMap.put(Integer.valueOf(512), "Exposure Mode");
    _tagNameMap.put(Integer.valueOf(513), "AE Lock");
    _tagNameMap.put(Integer.valueOf(514), "Metering Mode");
    _tagNameMap.put(Integer.valueOf(515), "Exposure Shift");
    _tagNameMap.put(Integer.valueOf(516), "ND Filter");
    _tagNameMap.put(Integer.valueOf(768), "Macro Mode");
    _tagNameMap.put(Integer.valueOf(769), "Focus Mode");
    _tagNameMap.put(Integer.valueOf(770), "Focus Process");
    _tagNameMap.put(Integer.valueOf(771), "AF Search");
    _tagNameMap.put(Integer.valueOf(772), "AF Areas");
    _tagNameMap.put(Integer.valueOf(773), "AF Point Selected");
    _tagNameMap.put(Integer.valueOf(774), "AF Fine Tune");
    _tagNameMap.put(Integer.valueOf(775), "AF Fine Tune Adj");
    _tagNameMap.put(Integer.valueOf(1024), "Flash Mode");
    _tagNameMap.put(Integer.valueOf(1025), "Flash Exposure Comp");
    _tagNameMap.put(Integer.valueOf(1027), "Flash Remote Control");
    _tagNameMap.put(Integer.valueOf(1028), "Flash Control Mode");
    _tagNameMap.put(Integer.valueOf(1029), "Flash Intensity");
    _tagNameMap.put(Integer.valueOf(1030), "Manual Flash Strength");
    _tagNameMap.put(Integer.valueOf(1280), "White Balance 2");
    _tagNameMap.put(Integer.valueOf(1281), "White Balance Temperature");
    _tagNameMap.put(Integer.valueOf(1282), "White Balance Bracket");
    _tagNameMap.put(Integer.valueOf(1283), "Custom Saturation");
    _tagNameMap.put(Integer.valueOf(1284), "Modified Saturation");
    _tagNameMap.put(Integer.valueOf(1285), "Contrast Setting");
    _tagNameMap.put(Integer.valueOf(1286), "Sharpness Setting");
    _tagNameMap.put(Integer.valueOf(1287), "Color Space");
    _tagNameMap.put(Integer.valueOf(1289), "Scene Mode");
    _tagNameMap.put(Integer.valueOf(1290), "Noise Reduction");
    _tagNameMap.put(Integer.valueOf(1291), "Distortion Correction");
    _tagNameMap.put(Integer.valueOf(1292), "Shading Compensation");
    _tagNameMap.put(Integer.valueOf(1293), "Compression Factor");
    _tagNameMap.put(Integer.valueOf(1295), "Gradation");
    _tagNameMap.put(Integer.valueOf(1312), "Picture Mode");
    _tagNameMap.put(Integer.valueOf(1313), "Picture Mode Saturation");
    _tagNameMap.put(Integer.valueOf(1314), "Picture Mode Hue");
    _tagNameMap.put(Integer.valueOf(1315), "Picture Mode Contrast");
    _tagNameMap.put(Integer.valueOf(1316), "Picture Mode Sharpness");
    _tagNameMap.put(Integer.valueOf(1317), "Picture Mode BW Filter");
    _tagNameMap.put(Integer.valueOf(1318), "Picture Mode Tone");
    _tagNameMap.put(Integer.valueOf(1319), "Noise Filter");
    _tagNameMap.put(Integer.valueOf(1321), "Art Filter");
    _tagNameMap.put(Integer.valueOf(1324), "Magic Filter");
    _tagNameMap.put(Integer.valueOf(1325), "Picture Mode Effect");
    _tagNameMap.put(Integer.valueOf(1326), "Tone Level");
    _tagNameMap.put(Integer.valueOf(1327), "Art Filter Effect");
    _tagNameMap.put(Integer.valueOf(1330), "Color Creator Effect");
    _tagNameMap.put(Integer.valueOf(1536), "Drive Mode");
    _tagNameMap.put(Integer.valueOf(1537), "Panorama Mode");
    _tagNameMap.put(Integer.valueOf(1539), "Image Quality 2");
    _tagNameMap.put(Integer.valueOf(1540), "Image Stabilization");
    _tagNameMap.put(Integer.valueOf(2052), "Stacked Image");
    _tagNameMap.put(Integer.valueOf(2304), "Manometer Pressure");
    _tagNameMap.put(Integer.valueOf(2305), "Manometer Reading");
    _tagNameMap.put(Integer.valueOf(2306), "Extended WB Detect");
    _tagNameMap.put(Integer.valueOf(2307), "Roll Angle");
    _tagNameMap.put(Integer.valueOf(2308), "Pitch Angle");
    _tagNameMap.put(Integer.valueOf(2312), "Date Time UTC");
  }
  
  public OlympusCameraSettingsMakernoteDirectory()
  {
    setDescriptor(new OlympusCameraSettingsMakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Olympus Camera Settings";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\OlympusCameraSettingsMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */