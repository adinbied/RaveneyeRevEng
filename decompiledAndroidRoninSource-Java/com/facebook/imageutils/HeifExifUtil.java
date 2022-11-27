package com.facebook.imageutils;

import android.media.ExifInterface;
import android.os.Build.VERSION;
import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;

public class HeifExifUtil
{
  public static final String TAG = "HeifExifUtil";
  
  public static int getOrientation(InputStream paramInputStream)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return HeifExifUtilAndroidN.getOrientation(paramInputStream);
    }
    FLog.d("HeifExifUtil", "Trying to read Heif Exif information before Android N -> ignoring");
    return 0;
  }
  
  private static class HeifExifUtilAndroidN
  {
    static int getOrientation(InputStream paramInputStream)
    {
      try
      {
        int i = new ExifInterface(paramInputStream).getAttributeInt("Orientation", 1);
        return i;
      }
      catch (IOException paramInputStream)
      {
        FLog.d("HeifExifUtil", "Failed reading Heif Exif orientation -> ignoring", paramInputStream);
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imageutils\HeifExifUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */