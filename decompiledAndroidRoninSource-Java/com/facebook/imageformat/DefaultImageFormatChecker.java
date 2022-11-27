package com.facebook.imageformat;

import com.facebook.common.internal.Ints;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.webp.WebpSupportStatus;
import javax.annotation.Nullable;

public class DefaultImageFormatChecker
  implements ImageFormat.FormatChecker
{
  private static final byte[] BMP_HEADER;
  private static final int BMP_HEADER_LENGTH;
  private static final byte[] DNG_HEADER_II;
  private static final int DNG_HEADER_LENGTH;
  private static final byte[] DNG_HEADER_MM;
  private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
  private static final byte[] GIF_HEADER_87A;
  private static final byte[] GIF_HEADER_89A;
  private static final int GIF_HEADER_LENGTH = 6;
  private static final int HEIF_HEADER_LENGTH = 12;
  private static final byte[] HEIF_HEADER_PREFIX;
  private static final byte[][] HEIF_HEADER_SUFFIXES;
  private static final byte[] ICO_HEADER;
  private static final int ICO_HEADER_LENGTH;
  private static final byte[] JPEG_HEADER;
  private static final int JPEG_HEADER_LENGTH;
  private static final byte[] PNG_HEADER;
  private static final int PNG_HEADER_LENGTH;
  private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
  final int MAX_HEADER_LENGTH = Ints.max(new int[] { 21, 20, JPEG_HEADER_LENGTH, PNG_HEADER_LENGTH, 6, BMP_HEADER_LENGTH, ICO_HEADER_LENGTH, 12 });
  
  static
  {
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = -1;
    arrayOfByte[1] = -40;
    arrayOfByte[2] = -1;
    arrayOfByte;
    JPEG_HEADER = arrayOfByte;
    JPEG_HEADER_LENGTH = arrayOfByte.length;
    arrayOfByte = new byte[8];
    arrayOfByte[0] = -119;
    arrayOfByte[1] = 80;
    arrayOfByte[2] = 78;
    arrayOfByte[3] = 71;
    arrayOfByte[4] = 13;
    arrayOfByte[5] = 10;
    arrayOfByte[6] = 26;
    arrayOfByte[7] = 10;
    arrayOfByte;
    PNG_HEADER = arrayOfByte;
    PNG_HEADER_LENGTH = arrayOfByte.length;
    GIF_HEADER_87A = ImageFormatCheckerUtils.asciiBytes("GIF87a");
    GIF_HEADER_89A = ImageFormatCheckerUtils.asciiBytes("GIF89a");
    arrayOfByte = ImageFormatCheckerUtils.asciiBytes("BM");
    BMP_HEADER = arrayOfByte;
    BMP_HEADER_LENGTH = arrayOfByte.length;
    arrayOfByte = new byte[4];
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 0;
    arrayOfByte[2] = 1;
    arrayOfByte[3] = 0;
    arrayOfByte;
    ICO_HEADER = arrayOfByte;
    ICO_HEADER_LENGTH = arrayOfByte.length;
    HEIF_HEADER_PREFIX = ImageFormatCheckerUtils.asciiBytes("ftyp");
    HEIF_HEADER_SUFFIXES = new byte[][] { ImageFormatCheckerUtils.asciiBytes("heic"), ImageFormatCheckerUtils.asciiBytes("heix"), ImageFormatCheckerUtils.asciiBytes("hevc"), ImageFormatCheckerUtils.asciiBytes("hevx"), ImageFormatCheckerUtils.asciiBytes("mif1"), ImageFormatCheckerUtils.asciiBytes("msf1") };
    arrayOfByte = new byte[4];
    arrayOfByte[0] = 73;
    arrayOfByte[1] = 73;
    arrayOfByte[2] = 42;
    arrayOfByte[3] = 0;
    arrayOfByte;
    DNG_HEADER_II = arrayOfByte;
    DNG_HEADER_MM = new byte[] { 77, 77, 0, 42 };
    DNG_HEADER_LENGTH = arrayOfByte.length;
  }
  
  private static ImageFormat getWebpFormat(byte[] paramArrayOfByte, int paramInt)
  {
    Preconditions.checkArgument(WebpSupportStatus.isWebpHeader(paramArrayOfByte, 0, paramInt));
    if (WebpSupportStatus.isSimpleWebpHeader(paramArrayOfByte, 0)) {
      return DefaultImageFormats.WEBP_SIMPLE;
    }
    if (WebpSupportStatus.isLosslessWebpHeader(paramArrayOfByte, 0)) {
      return DefaultImageFormats.WEBP_LOSSLESS;
    }
    if (WebpSupportStatus.isExtendedWebpHeader(paramArrayOfByte, 0, paramInt))
    {
      if (WebpSupportStatus.isAnimatedWebpHeader(paramArrayOfByte, 0)) {
        return DefaultImageFormats.WEBP_ANIMATED;
      }
      if (WebpSupportStatus.isExtendedWebpHeaderWithAlpha(paramArrayOfByte, 0)) {
        return DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA;
      }
      return DefaultImageFormats.WEBP_EXTENDED;
    }
    return ImageFormat.UNKNOWN;
  }
  
  private static boolean isBmpHeader(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = BMP_HEADER;
    if (paramInt < arrayOfByte.length) {
      return false;
    }
    return ImageFormatCheckerUtils.startsWithPattern(paramArrayOfByte, arrayOfByte);
  }
  
  private static boolean isDngHeader(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramInt >= DNG_HEADER_LENGTH) && ((ImageFormatCheckerUtils.startsWithPattern(paramArrayOfByte, DNG_HEADER_II)) || (ImageFormatCheckerUtils.startsWithPattern(paramArrayOfByte, DNG_HEADER_MM)));
  }
  
  private static boolean isGifHeader(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = false;
    if (paramInt < 6) {
      return false;
    }
    if ((ImageFormatCheckerUtils.startsWithPattern(paramArrayOfByte, GIF_HEADER_87A)) || (ImageFormatCheckerUtils.startsWithPattern(paramArrayOfByte, GIF_HEADER_89A))) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean isHeifHeader(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt < 12) {
      return false;
    }
    if (paramArrayOfByte[3] < 8) {
      return false;
    }
    if (!ImageFormatCheckerUtils.hasPatternAt(paramArrayOfByte, HEIF_HEADER_PREFIX, 4)) {
      return false;
    }
    byte[][] arrayOfByte = HEIF_HEADER_SUFFIXES;
    int i = arrayOfByte.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (ImageFormatCheckerUtils.hasPatternAt(paramArrayOfByte, arrayOfByte[paramInt], 8)) {
        return true;
      }
      paramInt += 1;
    }
    return false;
  }
  
  private static boolean isIcoHeader(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = ICO_HEADER;
    if (paramInt < arrayOfByte.length) {
      return false;
    }
    return ImageFormatCheckerUtils.startsWithPattern(paramArrayOfByte, arrayOfByte);
  }
  
  private static boolean isJpegHeader(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = JPEG_HEADER;
    return (paramInt >= arrayOfByte.length) && (ImageFormatCheckerUtils.startsWithPattern(paramArrayOfByte, arrayOfByte));
  }
  
  private static boolean isPngHeader(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = PNG_HEADER;
    return (paramInt >= arrayOfByte.length) && (ImageFormatCheckerUtils.startsWithPattern(paramArrayOfByte, arrayOfByte));
  }
  
  @Nullable
  public final ImageFormat determineFormat(byte[] paramArrayOfByte, int paramInt)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    if (WebpSupportStatus.isWebpHeader(paramArrayOfByte, 0, paramInt)) {
      return getWebpFormat(paramArrayOfByte, paramInt);
    }
    if (isJpegHeader(paramArrayOfByte, paramInt)) {
      return DefaultImageFormats.JPEG;
    }
    if (isPngHeader(paramArrayOfByte, paramInt)) {
      return DefaultImageFormats.PNG;
    }
    if (isGifHeader(paramArrayOfByte, paramInt)) {
      return DefaultImageFormats.GIF;
    }
    if (isBmpHeader(paramArrayOfByte, paramInt)) {
      return DefaultImageFormats.BMP;
    }
    if (isIcoHeader(paramArrayOfByte, paramInt)) {
      return DefaultImageFormats.ICO;
    }
    if (isHeifHeader(paramArrayOfByte, paramInt)) {
      return DefaultImageFormats.HEIF;
    }
    if (isDngHeader(paramArrayOfByte, paramInt)) {
      return DefaultImageFormats.DNG;
    }
    return ImageFormat.UNKNOWN;
  }
  
  public int getHeaderSize()
  {
    return this.MAX_HEADER_LENGTH;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imageformat\DefaultImageFormatChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */