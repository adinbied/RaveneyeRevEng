package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;
import java.util.HashMap;

public class OlympusCameraSettingsMakernoteDescriptor
  extends TagDescriptor<OlympusCameraSettingsMakernoteDirectory>
{
  private static final HashMap<Integer, String> _filters;
  private static final HashMap<Integer, String> _toneLevelType = new HashMap();
  
  static
  {
    HashMap localHashMap = new HashMap();
    _filters = localHashMap;
    Integer localInteger = Integer.valueOf(0);
    localHashMap.put(localInteger, "Off");
    _filters.put(Integer.valueOf(1), "Soft Focus");
    _filters.put(Integer.valueOf(2), "Pop Art");
    _filters.put(Integer.valueOf(3), "Pale & Light Color");
    _filters.put(Integer.valueOf(4), "Light Tone");
    _filters.put(Integer.valueOf(5), "Pin Hole");
    _filters.put(Integer.valueOf(6), "Grainy Film");
    _filters.put(Integer.valueOf(9), "Diorama");
    _filters.put(Integer.valueOf(10), "Cross Process");
    _filters.put(Integer.valueOf(12), "Fish Eye");
    _filters.put(Integer.valueOf(13), "Drawing");
    _filters.put(Integer.valueOf(14), "Gentle Sepia");
    _filters.put(Integer.valueOf(15), "Pale & Light Color II");
    _filters.put(Integer.valueOf(16), "Pop Art II");
    _filters.put(Integer.valueOf(17), "Pin Hole II");
    _filters.put(Integer.valueOf(18), "Pin Hole III");
    _filters.put(Integer.valueOf(19), "Grainy Film II");
    _filters.put(Integer.valueOf(20), "Dramatic Tone");
    _filters.put(Integer.valueOf(21), "Punk");
    _filters.put(Integer.valueOf(22), "Soft Focus 2");
    _filters.put(Integer.valueOf(23), "Sparkle");
    _filters.put(Integer.valueOf(24), "Watercolor");
    _filters.put(Integer.valueOf(25), "Key Line");
    _filters.put(Integer.valueOf(26), "Key Line II");
    _filters.put(Integer.valueOf(27), "Miniature");
    _filters.put(Integer.valueOf(28), "Reflection");
    _filters.put(Integer.valueOf(29), "Fragmented");
    _filters.put(Integer.valueOf(31), "Cross Process II");
    _filters.put(Integer.valueOf(32), "Dramatic Tone II");
    _filters.put(Integer.valueOf(33), "Watercolor I");
    _filters.put(Integer.valueOf(34), "Watercolor II");
    _filters.put(Integer.valueOf(35), "Diorama II");
    _filters.put(Integer.valueOf(36), "Vintage");
    _filters.put(Integer.valueOf(37), "Vintage II");
    _filters.put(Integer.valueOf(38), "Vintage III");
    _filters.put(Integer.valueOf(39), "Partial Color");
    _filters.put(Integer.valueOf(40), "Partial Color II");
    _filters.put(Integer.valueOf(41), "Partial Color III");
    _toneLevelType.put(localInteger, "0");
    _toneLevelType.put(Integer.valueOf(33537), "Highlights ");
    _toneLevelType.put(Integer.valueOf(33538), "Shadows ");
    _toneLevelType.put(Integer.valueOf(33539), "Midtones ");
  }
  
  public OlympusCameraSettingsMakernoteDescriptor(OlympusCameraSettingsMakernoteDirectory paramOlympusCameraSettingsMakernoteDirectory)
  {
    super(paramOlympusCameraSettingsMakernoteDirectory);
  }
  
  private String getFiltersDescription(int paramInt)
  {
    return null;
  }
  
  private String getValueMinMaxDescription(int paramInt)
  {
    return null;
  }
  
  public String getAeLockDescription()
  {
    return null;
  }
  
  public String getAfAreasDescription()
  {
    return null;
  }
  
  public String getAfFineTuneDescription()
  {
    return null;
  }
  
  public String getAfPointSelectedDescription()
  {
    return null;
  }
  
  public String getAfSearchDescription()
  {
    return null;
  }
  
  public String getArtFilterDescription()
  {
    return getFiltersDescription(1321);
  }
  
  public String getArtFilterEffectDescription()
  {
    return null;
  }
  
  public String getCameraSettingsVersionDescription()
  {
    return getVersionBytesDescription(0, 4);
  }
  
  public String getColorCreatorEffectDescription()
  {
    return null;
  }
  
  public String getColorSpaceDescription()
  {
    return null;
  }
  
  public String getContrastSettingDescription()
  {
    return getValueMinMaxDescription(1285);
  }
  
  public String getCustomSaturationDescription()
  {
    return getValueMinMaxDescription(1283);
  }
  
  public String getDateTimeUTCDescription()
  {
    return null;
  }
  
  public String getDescription(int paramInt)
  {
    return null;
  }
  
  public String getDistortionCorrectionDescription()
  {
    return null;
  }
  
  public String getDriveModeDescription()
  {
    return null;
  }
  
  public String getExposureModeDescription()
  {
    return null;
  }
  
  public String getExposureShiftDescription()
  {
    return getRationalOrDoubleString(515);
  }
  
  public String getExtendedWBDetectDescription()
  {
    return null;
  }
  
  public String getFlashControlModeDescription()
  {
    return null;
  }
  
  public String getFlashIntensityDescription()
  {
    return null;
  }
  
  public String getFlashModeDescription()
  {
    return null;
  }
  
  public String getFlashRemoteControlDescription()
  {
    return null;
  }
  
  public String getFocusModeDescription()
  {
    return null;
  }
  
  public String getFocusProcessDescription()
  {
    return null;
  }
  
  public String getGradationDescription()
  {
    return null;
  }
  
  public String getImageQuality2Description()
  {
    return null;
  }
  
  public String getImageStabilizationDescription()
  {
    return null;
  }
  
  public String getMacroModeDescription()
  {
    return null;
  }
  
  public String getMagicFilterDescription()
  {
    return getFiltersDescription(1324);
  }
  
  public String getManometerPressureDescription()
  {
    return null;
  }
  
  public String getManometerReadingDescription()
  {
    return null;
  }
  
  public String getManualFlashStrengthDescription()
  {
    return null;
  }
  
  public String getMeteringModeDescription()
  {
    return null;
  }
  
  public String getModifiedSaturationDescription()
  {
    return null;
  }
  
  public String getNdFilterDescription()
  {
    return null;
  }
  
  public String getNoiseFilterDescription()
  {
    return null;
  }
  
  public String getNoiseReductionDescription()
  {
    return null;
  }
  
  public String getPanoramaModeDescription()
  {
    return null;
  }
  
  public String getPictureModeBWFilterDescription()
  {
    return null;
  }
  
  public String getPictureModeContrastDescription()
  {
    return getValueMinMaxDescription(1315);
  }
  
  public String getPictureModeDescription()
  {
    return null;
  }
  
  public String getPictureModeEffectDescription()
  {
    return null;
  }
  
  public String getPictureModeSaturationDescription()
  {
    return getValueMinMaxDescription(1313);
  }
  
  public String getPictureModeSharpnessDescription()
  {
    return getValueMinMaxDescription(1316);
  }
  
  public String getPictureModeToneDescription()
  {
    return null;
  }
  
  public String getPitchAngleDescription()
  {
    return null;
  }
  
  public String getPreviewImageValidDescription()
  {
    return null;
  }
  
  public String getRollAngleDescription()
  {
    return null;
  }
  
  public String getSceneModeDescription()
  {
    return null;
  }
  
  public String getShadingCompensationDescription()
  {
    return null;
  }
  
  public String getSharpnessSettingDescription()
  {
    return getValueMinMaxDescription(1286);
  }
  
  public String getStackedImageDescription()
  {
    return null;
  }
  
  public String getToneLevelDescription()
  {
    return null;
  }
  
  public String getWhiteBalance2Description()
  {
    return null;
  }
  
  public String getWhiteBalanceTemperatureDescription()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\OlympusCameraSettingsMakernoteDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */