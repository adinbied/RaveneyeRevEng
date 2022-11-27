package com.facebook.imageutils;

import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JfifUtil
{
  public static final int APP1_EXIF_MAGIC = 1165519206;
  public static final int MARKER_APP1 = 225;
  public static final int MARKER_EOI = 217;
  public static final int MARKER_ESCAPE_BYTE = 0;
  public static final int MARKER_FIRST_BYTE = 255;
  public static final int MARKER_RST0 = 208;
  public static final int MARKER_RST7 = 215;
  public static final int MARKER_SOFn = 192;
  public static final int MARKER_SOI = 216;
  public static final int MARKER_SOS = 218;
  public static final int MARKER_TEM = 1;
  
  public static int getAutoRotateAngleFromOrientation(int paramInt)
  {
    return TiffUtil.getAutoRotateAngleFromOrientation(paramInt);
  }
  
  public static int getOrientation(InputStream paramInputStream)
  {
    try
    {
      int i = moveToAPP1EXIF(paramInputStream);
      if (i == 0) {
        return 0;
      }
      i = TiffUtil.readOrientationFromTIFF(paramInputStream, i);
      return i;
    }
    catch (IOException paramInputStream) {}
    return 0;
  }
  
  public static int getOrientation(byte[] paramArrayOfByte)
  {
    return getOrientation(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  private static boolean isSOFn(int paramInt)
  {
    switch (paramInt)
    {
    case 196: 
    case 200: 
    case 204: 
    default: 
      return false;
    }
    return true;
  }
  
  private static int moveToAPP1EXIF(InputStream paramInputStream)
    throws IOException
  {
    if (moveToMarker(paramInputStream, 225))
    {
      int i = StreamProcessor.readPackedInt(paramInputStream, 2, false) - 2;
      if (i > 6)
      {
        int j = StreamProcessor.readPackedInt(paramInputStream, 4, false);
        int k = StreamProcessor.readPackedInt(paramInputStream, 2, false);
        if ((j == 1165519206) && (k == 0)) {
          return i - 4 - 2;
        }
      }
    }
    return 0;
  }
  
  public static boolean moveToMarker(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    while (StreamProcessor.readPackedInt(paramInputStream, 1, false) == 255)
    {
      for (int i = 255; i == 255; i = StreamProcessor.readPackedInt(paramInputStream, 1, false)) {}
      if ((paramInt == 192) && (isSOFn(i))) {
        return true;
      }
      if (i == paramInt) {
        return true;
      }
      if ((i != 216) && (i != 1))
      {
        if (i == 217) {
          break;
        }
        if (i == 218) {
          return false;
        }
        paramInputStream.skip(StreamProcessor.readPackedInt(paramInputStream, 2, false) - 2);
      }
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imageutils\JfifUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */