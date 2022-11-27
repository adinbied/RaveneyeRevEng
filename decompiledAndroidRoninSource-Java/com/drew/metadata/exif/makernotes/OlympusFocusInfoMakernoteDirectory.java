package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class OlympusFocusInfoMakernoteDirectory
  extends Directory
{
  public static final int TagAfInfo = 808;
  public static final int TagAfPoint = 776;
  public static final int TagAutoFocus = 521;
  public static final int TagExternalFlash = 4609;
  public static final int TagExternalFlashBounce = 4612;
  public static final int TagExternalFlashGuideNumber = 4611;
  public static final int TagExternalFlashZoom = 4613;
  public static final int TagFocusDistance = 773;
  public static final int TagFocusInfoVersion = 0;
  public static final int TagFocusStepCount = 769;
  public static final int TagFocusStepInfinity = 771;
  public static final int TagFocusStepNear = 772;
  public static final int TagImageStabilization = 5632;
  public static final int TagInternalFlash = 4616;
  public static final int TagMacroLed = 4618;
  public static final int TagManualFlash = 4617;
  public static final int TagSceneArea = 529;
  public static final int TagSceneDetect = 528;
  public static final int TagSceneDetectData = 530;
  public static final int TagSensorTemperature = 5376;
  public static final int TagZoomStepCount = 768;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(0), "Focus Info Version");
    _tagNameMap.put(Integer.valueOf(521), "Auto Focus");
    _tagNameMap.put(Integer.valueOf(528), "Scene Detect");
    _tagNameMap.put(Integer.valueOf(529), "Scene Area");
    _tagNameMap.put(Integer.valueOf(530), "Scene Detect Data");
    _tagNameMap.put(Integer.valueOf(768), "Zoom Step Count");
    _tagNameMap.put(Integer.valueOf(769), "Focus Step Count");
    _tagNameMap.put(Integer.valueOf(771), "Focus Step Infinity");
    _tagNameMap.put(Integer.valueOf(772), "Focus Step Near");
    _tagNameMap.put(Integer.valueOf(773), "Focus Distance");
    _tagNameMap.put(Integer.valueOf(776), "AF Point");
    _tagNameMap.put(Integer.valueOf(808), "AF Info");
    _tagNameMap.put(Integer.valueOf(4609), "External Flash");
    _tagNameMap.put(Integer.valueOf(4611), "External Flash Guide Number");
    _tagNameMap.put(Integer.valueOf(4612), "External Flash Bounce");
    _tagNameMap.put(Integer.valueOf(4613), "External Flash Zoom");
    _tagNameMap.put(Integer.valueOf(4616), "Internal Flash");
    _tagNameMap.put(Integer.valueOf(4617), "Manual Flash");
    _tagNameMap.put(Integer.valueOf(4618), "Macro LED");
    _tagNameMap.put(Integer.valueOf(5376), "Sensor Temperature");
    _tagNameMap.put(Integer.valueOf(5632), "Image Stabilization");
  }
  
  public OlympusFocusInfoMakernoteDirectory()
  {
    setDescriptor(new OlympusFocusInfoMakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Olympus Focus Info";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\OlympusFocusInfoMakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */