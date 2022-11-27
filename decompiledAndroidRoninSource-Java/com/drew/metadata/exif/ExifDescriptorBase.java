package com.drew.metadata.exif;

import com.drew.metadata.Directory;
import com.drew.metadata.TagDescriptor;

public abstract class ExifDescriptorBase<T extends Directory>
  extends TagDescriptor<T>
{
  private final boolean _allowDecimalRepresentationOfRationals = true;
  
  public ExifDescriptorBase(T paramT)
  {
    super(paramT);
  }
  
  private int[] decodeCfaPattern(int paramInt)
  {
    return null;
  }
  
  private static String formatCFAPattern(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    int j = paramArrayOfInt.length;
    int i = 2;
    if (j < 2) {
      return "<truncated data>";
    }
    if ((paramArrayOfInt[0] == 0) && (paramArrayOfInt[1] == 0)) {
      return "<zero pattern size>";
    }
    j = paramArrayOfInt[0] * paramArrayOfInt[1] + 2;
    if (j > paramArrayOfInt.length) {
      return "<invalid pattern size>";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    while (i < j)
    {
      if (paramArrayOfInt[i] <= 6)
      {
        int k = paramArrayOfInt[i];
        localStringBuilder.append(new String[] { "Red", "Green", "Blue", "Cyan", "Magenta", "Yellow", "White" }[k]);
      }
      else
      {
        localStringBuilder.append("Unknown");
      }
      if ((i - 2) % paramArrayOfInt[1] == 0) {
        localStringBuilder.append(",");
      } else if (i != j - 1) {
        localStringBuilder.append("][");
      }
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private String getUnicodeDescription(int paramInt)
  {
    return null;
  }
  
  public String get35mmFilmEquivFocalLengthDescription()
  {
    return null;
  }
  
  public String getApertureValueDescription()
  {
    return null;
  }
  
  public String getBitsPerSampleDescription()
  {
    return null;
  }
  
  public String getCfaPattern2Description()
  {
    return null;
  }
  
  public String getCfaPatternDescription()
  {
    return null;
  }
  
  public String getColorSpaceDescription()
  {
    return null;
  }
  
  public String getComponentConfigurationDescription()
  {
    return null;
  }
  
  public String getCompressedAverageBitsPerPixelDescription()
  {
    return null;
  }
  
  public String getCompressionDescription()
  {
    return null;
  }
  
  public String getContrastDescription()
  {
    return null;
  }
  
  public String getCustomRenderedDescription()
  {
    return null;
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 42034: 
      return getLensSpecificationDescription();
    case 41996: 
      return getSubjectDistanceRangeDescription();
    case 41994: 
      return getSharpnessDescription();
    case 41993: 
      return getSaturationDescription();
    case 41992: 
      return getContrastDescription();
    case 41991: 
      return getGainControlDescription();
    case 41990: 
      return getSceneCaptureTypeDescription();
    case 41989: 
      return get35mmFilmEquivFocalLengthDescription();
    case 41988: 
      return getDigitalZoomRatioDescription();
    case 41987: 
      return getWhiteBalanceModeDescription();
    case 41986: 
      return getExposureModeDescription();
    case 41985: 
      return getCustomRenderedDescription();
    case 41730: 
      return getCfaPatternDescription();
    case 41729: 
      return getSceneTypeDescription();
    case 41728: 
      return getFileSourceDescription();
    case 41495: 
      return getSensingMethodDescription();
    case 41488: 
      return getFocalPlaneResolutionUnitDescription();
    case 41487: 
      return getFocalPlaneYResolutionDescription();
    case 41486: 
      return getFocalPlaneXResolutionDescription();
    case 40963: 
      return getExifImageHeightDescription();
    case 40962: 
      return getExifImageWidthDescription();
    case 40961: 
      return getColorSpaceDescription();
    case 40960: 
      return getFlashPixVersionDescription();
    case 40095: 
      return getWindowsSubjectDescription();
    case 40094: 
      return getWindowsKeywordsDescription();
    case 40093: 
      return getWindowsAuthorDescription();
    case 40092: 
      return getWindowsCommentDescription();
    case 40091: 
      return getWindowsTitleDescription();
    case 37510: 
      return getUserCommentDescription();
    case 37386: 
      return getFocalLengthDescription();
    case 37385: 
      return getFlashDescription();
    case 37384: 
      return getWhiteBalanceDescription();
    case 37383: 
      return getMeteringModeDescription();
    case 37382: 
      return getSubjectDistanceDescription();
    case 37381: 
      return getMaxApertureValueDescription();
    case 37380: 
      return getExposureBiasDescription();
    case 37378: 
      return getApertureValueDescription();
    case 37377: 
      return getShutterSpeedDescription();
    case 37122: 
      return getCompressedAverageBitsPerPixelDescription();
    case 37121: 
      return getComponentConfigurationDescription();
    case 36864: 
      return getExifVersionDescription();
    case 34864: 
      return getSensitivityTypeRangeDescription();
    case 34855: 
      return getIsoEquivalentDescription();
    case 34850: 
      return getExposureProgramDescription();
    case 33437: 
      return getFNumberDescription();
    case 33434: 
      return getExposureTimeDescription();
    case 33422: 
      return getCfaPattern2Description();
    case 532: 
      return getReferenceBlackWhiteDescription();
    case 531: 
      return getYCbCrPositioningDescription();
    case 530: 
      return getYCbCrSubsamplingDescription();
    case 512: 
      return getJpegProcDescription();
    case 296: 
      return getResolutionDescription();
    case 284: 
      return getPlanarConfigurationDescription();
    case 283: 
      return getYResolutionDescription();
    case 282: 
      return getXResolutionDescription();
    case 279: 
      return getStripByteCountsDescription();
    case 278: 
      return getRowsPerStripDescription();
    case 277: 
      return getSamplesPerPixelDescription();
    case 274: 
      return getOrientationDescription();
    case 266: 
      return getFillOrderDescription();
    case 263: 
      return getThresholdingDescription();
    case 262: 
      return getPhotometricInterpretationDescription();
    case 259: 
      return getCompressionDescription();
    case 258: 
      return getBitsPerSampleDescription();
    case 257: 
      return getImageHeightDescription();
    case 256: 
      return getImageWidthDescription();
    case 255: 
      return getSubfileTypeDescription();
    case 254: 
      return getNewSubfileTypeDescription();
    case 2: 
      return getInteropVersionDescription();
    }
    return getInteropIndexDescription();
  }
  
  public String getDigitalZoomRatioDescription()
  {
    return null;
  }
  
  public String getExifImageHeightDescription()
  {
    return null;
  }
  
  public String getExifImageWidthDescription()
  {
    return null;
  }
  
  public String getExifVersionDescription()
  {
    return null;
  }
  
  public String getExposureBiasDescription()
  {
    return null;
  }
  
  public String getExposureModeDescription()
  {
    return null;
  }
  
  public String getExposureProgramDescription()
  {
    return null;
  }
  
  public String getExposureTimeDescription()
  {
    return null;
  }
  
  public String getFNumberDescription()
  {
    return null;
  }
  
  public String getFileSourceDescription()
  {
    return null;
  }
  
  public String getFillOrderDescription()
  {
    return null;
  }
  
  public String getFlashDescription()
  {
    return null;
  }
  
  public String getFlashPixVersionDescription()
  {
    return null;
  }
  
  public String getFocalLengthDescription()
  {
    return null;
  }
  
  public String getFocalPlaneResolutionUnitDescription()
  {
    return null;
  }
  
  public String getFocalPlaneXResolutionDescription()
  {
    return null;
  }
  
  public String getFocalPlaneYResolutionDescription()
  {
    return null;
  }
  
  public String getGainControlDescription()
  {
    return null;
  }
  
  public String getImageHeightDescription()
  {
    return null;
  }
  
  public String getImageWidthDescription()
  {
    return null;
  }
  
  public String getInteropIndexDescription()
  {
    return null;
  }
  
  public String getInteropVersionDescription()
  {
    return getVersionBytesDescription(2, 2);
  }
  
  public String getIsoEquivalentDescription()
  {
    return null;
  }
  
  public String getJpegProcDescription()
  {
    return null;
  }
  
  public String getLensSpecificationDescription()
  {
    return getLensSpecificationDescription(42034);
  }
  
  public String getMaxApertureValueDescription()
  {
    return null;
  }
  
  public String getMeteringModeDescription()
  {
    return null;
  }
  
  public String getNewSubfileTypeDescription()
  {
    return null;
  }
  
  public String getOrientationDescription()
  {
    return super.getOrientationDescription(274);
  }
  
  public String getPhotometricInterpretationDescription()
  {
    return null;
  }
  
  public String getPlanarConfigurationDescription()
  {
    return null;
  }
  
  public String getReferenceBlackWhiteDescription()
  {
    return null;
  }
  
  public String getResolutionDescription()
  {
    return null;
  }
  
  public String getRowsPerStripDescription()
  {
    return null;
  }
  
  public String getSamplesPerPixelDescription()
  {
    return null;
  }
  
  public String getSaturationDescription()
  {
    return null;
  }
  
  public String getSceneCaptureTypeDescription()
  {
    return null;
  }
  
  public String getSceneTypeDescription()
  {
    return null;
  }
  
  public String getSensingMethodDescription()
  {
    return null;
  }
  
  public String getSensitivityTypeRangeDescription()
  {
    return null;
  }
  
  public String getSharpnessDescription()
  {
    return null;
  }
  
  public String getShutterSpeedDescription()
  {
    return super.getShutterSpeedDescription(37377);
  }
  
  public String getStripByteCountsDescription()
  {
    return null;
  }
  
  public String getSubfileTypeDescription()
  {
    return null;
  }
  
  public String getSubjectDistanceDescription()
  {
    return null;
  }
  
  public String getSubjectDistanceRangeDescription()
  {
    return null;
  }
  
  public String getThresholdingDescription()
  {
    return null;
  }
  
  public String getUserCommentDescription()
  {
    return null;
  }
  
  public String getWhiteBalanceDescription()
  {
    return null;
  }
  
  public String getWhiteBalanceModeDescription()
  {
    return null;
  }
  
  public String getWindowsAuthorDescription()
  {
    return getUnicodeDescription(40093);
  }
  
  public String getWindowsCommentDescription()
  {
    return getUnicodeDescription(40092);
  }
  
  public String getWindowsKeywordsDescription()
  {
    return getUnicodeDescription(40094);
  }
  
  public String getWindowsSubjectDescription()
  {
    return getUnicodeDescription(40095);
  }
  
  public String getWindowsTitleDescription()
  {
    return getUnicodeDescription(40091);
  }
  
  public String getXResolutionDescription()
  {
    return null;
  }
  
  public String getYCbCrPositioningDescription()
  {
    return null;
  }
  
  public String getYCbCrSubsamplingDescription()
  {
    return null;
  }
  
  public String getYResolutionDescription()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\ExifDescriptorBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */