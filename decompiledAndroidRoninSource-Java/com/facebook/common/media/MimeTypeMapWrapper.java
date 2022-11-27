package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;

public class MimeTypeMapWrapper
{
  private static final Map<String, String> sExtensionToMimeTypeMap = ImmutableMap.of("heif", "image/heif", "heic", "image/heic");
  private static final MimeTypeMap sMimeTypeMap = ;
  private static final Map<String, String> sMimeTypeToExtensionMap = ImmutableMap.of("image/heif", "heif", "image/heic", "heic");
  
  public static String getExtensionFromMimeType(String paramString)
  {
    String str = (String)sMimeTypeToExtensionMap.get(paramString);
    if (str != null) {
      return str;
    }
    return sMimeTypeMap.getExtensionFromMimeType(paramString);
  }
  
  public static String getMimeTypeFromExtension(String paramString)
  {
    String str = (String)sExtensionToMimeTypeMap.get(paramString);
    if (str != null) {
      return str;
    }
    return sMimeTypeMap.getMimeTypeFromExtension(paramString);
  }
  
  public static boolean hasExtension(String paramString)
  {
    return (sExtensionToMimeTypeMap.containsKey(paramString)) || (sMimeTypeMap.hasExtension(paramString));
  }
  
  public static boolean hasMimeType(String paramString)
  {
    return (sMimeTypeToExtensionMap.containsKey(paramString)) || (sMimeTypeMap.hasMimeType(paramString));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\media\MimeTypeMapWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */