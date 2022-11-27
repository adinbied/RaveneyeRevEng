package com.drew.metadata.exif.makernotes;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class SamsungType2MakernoteDirectory
  extends Directory
{
  public static final int TagCameraTemperature = 67;
  public static final int TagDeviceType = 2;
  public static final int TagFaceDetect = 256;
  public static final int TagFaceName = 291;
  public static final int TagFaceRecognition = 288;
  public static final int TagFirmwareName = 40961;
  public static final int TagMakerNoteVersion = 1;
  public static final int TagSamsungModelId = 3;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Maker Note Version");
    _tagNameMap.put(Integer.valueOf(2), "Device Type");
    _tagNameMap.put(Integer.valueOf(3), "Model Id");
    _tagNameMap.put(Integer.valueOf(67), "Camera Temperature");
    _tagNameMap.put(Integer.valueOf(256), "Face Detect");
    _tagNameMap.put(Integer.valueOf(288), "Face Recognition");
    _tagNameMap.put(Integer.valueOf(291), "Face Name");
    _tagNameMap.put(Integer.valueOf(40961), "Firmware Name");
  }
  
  public SamsungType2MakernoteDirectory()
  {
    setDescriptor(new SamsungType2MakernoteDescriptor(this));
  }
  
  public String getName()
  {
    return "Samsung Makernote";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\SamsungType2MakernoteDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */