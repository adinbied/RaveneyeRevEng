package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Face;
import com.drew.metadata.TagDescriptor;

public class PanasonicMakernoteDescriptor
  extends TagDescriptor<PanasonicMakernoteDirectory>
{
  private static final String[] _sceneModes = { "Normal", "Portrait", "Scenery", "Sports", "Night Portrait", "Program", "Aperture Priority", "Shutter Priority", "Macro", "Spot", "Manual", "Movie Preview", "Panning", "Simple", "Color Effects", "Self Portrait", "Economy", "Fireworks", "Party", "Snow", "Night Scenery", "Food", "Baby", "Soft Skin", "Candlelight", "Starry Night", "High Sensitivity", "Panorama Assist", "Underwater", "Beach", "Aerial Photo", "Sunset", "Pet", "Intelligent ISO", "Clipboard", "High Speed Continuous Shooting", "Intelligent Auto", null, "Multi-aspect", null, "Transform", "Flash Burst", "Pin Hole", "Film Grain", "My Color", "Photo Frame", null, null, null, null, "HDR" };
  
  public PanasonicMakernoteDescriptor(PanasonicMakernoteDirectory paramPanasonicMakernoteDirectory)
  {
    super(paramPanasonicMakernoteDirectory);
  }
  
  private String buildFacesDescription(Face[] paramArrayOfFace)
  {
    return null;
  }
  
  private String getTransformDescription(int paramInt)
  {
    return null;
  }
  
  private static String trim(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.trim();
  }
  
  public String getAccelerometerXDescription()
  {
    return null;
  }
  
  public String getAccelerometerYDescription()
  {
    return null;
  }
  
  public String getAccelerometerZDescription()
  {
    return null;
  }
  
  public String getAdvancedSceneModeDescription()
  {
    return null;
  }
  
  public String getAfAreaModeDescription()
  {
    return null;
  }
  
  public String getAfAssistLampDescription()
  {
    return null;
  }
  
  public String getAudioDescription()
  {
    return null;
  }
  
  public String getBabyAge1Description()
  {
    return null;
  }
  
  public String getBabyAgeDescription()
  {
    return null;
  }
  
  public String getBabyNameDescription()
  {
    return null;
  }
  
  public String getBracketSettingsDescription()
  {
    return null;
  }
  
  public String getBurstModeDescription()
  {
    return null;
  }
  
  public String getCameraOrientationDescription()
  {
    return null;
  }
  
  public String getCityDescription()
  {
    return null;
  }
  
  public String getClearRetouchDescription()
  {
    return null;
  }
  
  public String getColorEffectDescription()
  {
    return null;
  }
  
  public String getColorModeDescription()
  {
    return null;
  }
  
  public String getContrastDescription()
  {
    return null;
  }
  
  public String getContrastModeDescription()
  {
    return null;
  }
  
  public String getConversionLensDescription()
  {
    return null;
  }
  
  public String getCountryDescription()
  {
    return null;
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 32786: 
      return getTransform1Description();
    case 32784: 
      return getBabyAge1Description();
    case 32777: 
      return getTextStamp3Description();
    case 32776: 
      return getTextStamp2Description();
    case 32775: 
      return getFlashFiredDescription();
    case 32769: 
      return getSceneModeDescription();
    case 32768: 
      return getMakernoteVersionDescription();
    case 171: 
      return getTouchAeDescription();
    case 159: 
      return getShutterTypeDescription();
    case 158: 
      return getHDRDescription();
    case 150: 
      return getTimerRecordingDescription();
    case 147: 
      return getSweepPanoramaDirectionDescription();
    case 145: 
      return getPitchAngleDescription();
    case 144: 
      return getRollAngleDescription();
    case 143: 
      return getCameraOrientationDescription();
    case 142: 
      return getAccelerometerYDescription();
    case 141: 
      return getAccelerometerXDescription();
    case 140: 
      return getAccelerometerZDescription();
    case 138: 
      return getShadingCompensationDescription();
    case 137: 
      return getPhotoStyleDescription();
    case 124: 
      return getClearRetouchDescription();
    case 121: 
      return getIntelligentDRangeDescription();
    case 112: 
      return getIntelligentResolutionDescription();
    case 111: 
      return getLandmarkDescription();
    case 109: 
      return getCityDescription();
    case 107: 
      return getStateDescription();
    case 105: 
      return getCountryDescription();
    case 103: 
      return getLocationDescription();
    case 102: 
      return getBabyNameDescription();
    case 101: 
      return getTitleDescription();
    case 98: 
      return getFlashWarningDescription();
    case 97: 
      return getRecognizedFacesDescription();
    case 96: 
      return getLensFirmwareVersionDescription();
    case 93: 
      return getIntelligentExposureDescription();
    case 89: 
      return getTransformDescription();
    case 78: 
      return getDetectedFacesDescription();
    case 73: 
      return getLongExposureNoiseReductionDescription();
    case 72: 
      return getFlashCurtainDescription();
    case 69: 
      return getBracketSettingsDescription();
    case 62: 
      return getTextStamp1Description();
    case 61: 
      return getAdvancedSceneModeDescription();
    case 59: 
      return getTextStampDescription();
    case 58: 
      return getWorldTimeLocationDescription();
    case 57: 
      return getContrastDescription();
    case 53: 
      return getConversionLensDescription();
    case 52: 
      return getOpticalZoomModeDescription();
    case 51: 
      return getBabyAgeDescription();
    case 50: 
      return getColorModeDescription();
    case 49: 
      return getAfAssistLampDescription();
    case 48: 
      return getRotationDescription();
    case 46: 
      return getSelfTimerDescription();
    case 45: 
      return getNoiseReductionDescription();
    case 44: 
      return getContrastModeDescription();
    case 42: 
      return getBurstModeDescription();
    case 41: 
      return getUptimeDescription();
    case 40: 
      return getColorEffectDescription();
    case 38: 
      return getExifVersionDescription();
    case 37: 
      return getInternalSerialNumberDescription();
    case 33: 
      return getUnknownDataDumpDescription();
    case 32: 
      return getAudioDescription();
    case 31: 
      return getRecordModeDescription();
    case 28: 
      return getMacroModeDescription();
    case 26: 
      return getImageStabilizationDescription();
    case 15: 
      return getAfAreaModeDescription();
    case 7: 
      return getFocusModeDescription();
    case 3: 
      return getWhiteBalanceDescription();
    case 2: 
      return getVersionDescription();
    }
    return getQualityModeDescription();
  }
  
  public String getDetectedFacesDescription()
  {
    return null;
  }
  
  public String getExifVersionDescription()
  {
    return getVersionBytesDescription(38, 2);
  }
  
  public String getFlashCurtainDescription()
  {
    return null;
  }
  
  public String getFlashFiredDescription()
  {
    return null;
  }
  
  public String getFlashWarningDescription()
  {
    return null;
  }
  
  public String getFocusModeDescription()
  {
    return null;
  }
  
  public String getHDRDescription()
  {
    return null;
  }
  
  public String getImageStabilizationDescription()
  {
    return null;
  }
  
  public String getIntelligentDRangeDescription()
  {
    return null;
  }
  
  public String getIntelligentExposureDescription()
  {
    return null;
  }
  
  public String getIntelligentResolutionDescription()
  {
    return null;
  }
  
  public String getInternalSerialNumberDescription()
  {
    return get7BitStringFromBytes(37);
  }
  
  public String getLandmarkDescription()
  {
    return null;
  }
  
  public String getLensFirmwareVersionDescription()
  {
    return null;
  }
  
  public String getLocationDescription()
  {
    return null;
  }
  
  public String getLongExposureNoiseReductionDescription()
  {
    return null;
  }
  
  public String getMacroModeDescription()
  {
    return null;
  }
  
  public String getMakernoteVersionDescription()
  {
    return null;
  }
  
  public String getNoiseReductionDescription()
  {
    return null;
  }
  
  public String getOpticalZoomModeDescription()
  {
    return null;
  }
  
  public String getPhotoStyleDescription()
  {
    return null;
  }
  
  public String getPitchAngleDescription()
  {
    return null;
  }
  
  public String getQualityModeDescription()
  {
    return null;
  }
  
  public String getRecognizedFacesDescription()
  {
    return null;
  }
  
  public String getRecordModeDescription()
  {
    return null;
  }
  
  public String getRollAngleDescription()
  {
    return null;
  }
  
  public String getRotationDescription()
  {
    return null;
  }
  
  public String getSceneModeDescription()
  {
    return null;
  }
  
  public String getSelfTimerDescription()
  {
    return null;
  }
  
  public String getShadingCompensationDescription()
  {
    return null;
  }
  
  public String getShutterTypeDescription()
  {
    return null;
  }
  
  public String getStateDescription()
  {
    return null;
  }
  
  public String getSweepPanoramaDirectionDescription()
  {
    return null;
  }
  
  public String getTextStamp1Description()
  {
    return null;
  }
  
  public String getTextStamp2Description()
  {
    return null;
  }
  
  public String getTextStamp3Description()
  {
    return null;
  }
  
  public String getTextStampDescription()
  {
    return null;
  }
  
  public String getTimerRecordingDescription()
  {
    return null;
  }
  
  public String getTitleDescription()
  {
    return null;
  }
  
  public String getTouchAeDescription()
  {
    return null;
  }
  
  public String getTransform1Description()
  {
    return getTransformDescription(32786);
  }
  
  public String getTransformDescription()
  {
    return getTransformDescription(89);
  }
  
  public String getUnknownDataDumpDescription()
  {
    return getByteLengthDescription(33);
  }
  
  public String getUptimeDescription()
  {
    return null;
  }
  
  public String getVersionDescription()
  {
    return getVersionBytesDescription(2, 2);
  }
  
  public String getWhiteBalanceDescription()
  {
    return null;
  }
  
  public String getWorldTimeLocationDescription()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\PanasonicMakernoteDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */