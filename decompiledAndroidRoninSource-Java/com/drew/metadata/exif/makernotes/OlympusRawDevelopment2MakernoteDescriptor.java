package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;
import java.util.HashMap;

public class OlympusRawDevelopment2MakernoteDescriptor
  extends TagDescriptor<OlympusRawDevelopment2MakernoteDirectory>
{
  private static final HashMap<Integer, String> _filters;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _filters = localHashMap;
    localHashMap.put(Integer.valueOf(0), "Off");
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
  }
  
  public OlympusRawDevelopment2MakernoteDescriptor(OlympusRawDevelopment2MakernoteDirectory paramOlympusRawDevelopment2MakernoteDirectory)
  {
    super(paramOlympusRawDevelopment2MakernoteDirectory);
  }
  
  public String getDescription(int paramInt)
  {
    return null;
  }
  
  public String getFilterDescription(int paramInt)
  {
    return null;
  }
  
  public String getRawDevArtFilterDescription()
  {
    return getFilterDescription(289);
  }
  
  public String getRawDevColorSpaceDescription()
  {
    return null;
  }
  
  public String getRawDevEngineDescription()
  {
    return null;
  }
  
  public String getRawDevExposureBiasValueDescription()
  {
    return null;
  }
  
  public String getRawDevNoiseReductionDescription()
  {
    return null;
  }
  
  public String getRawDevPictureModeDescription()
  {
    return null;
  }
  
  public String getRawDevPmBwFilterDescription()
  {
    return null;
  }
  
  public String getRawDevPmPictureToneDescription()
  {
    return null;
  }
  
  public String getRawDevVersionDescription()
  {
    return getVersionBytesDescription(0, 4);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\OlympusRawDevelopment2MakernoteDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */