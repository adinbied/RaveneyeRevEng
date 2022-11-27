package dji.thirdparty.sanselan;

import java.util.ArrayList;

public class ImageInfo
{
  public static final int COLOR_TYPE_BW = 0;
  public static final int COLOR_TYPE_CMYK = 3;
  public static final int COLOR_TYPE_GRAYSCALE = 1;
  public static final int COLOR_TYPE_OTHER = -1;
  public static final int COLOR_TYPE_RGB = 2;
  public static final int COLOR_TYPE_UNKNOWN = -2;
  public static final String COMPRESSION_ALGORITHM_CCITT_1D = "CCITT 1D";
  public static final String COMPRESSION_ALGORITHM_CCITT_GROUP_3 = "CCITT Group 3 1-Dimensional Modified Huffman run-length encoding.";
  public static final String COMPRESSION_ALGORITHM_CCITT_GROUP_4 = "CCITT Group 4";
  public static final String COMPRESSION_ALGORITHM_JPEG = "JPEG";
  public static final String COMPRESSION_ALGORITHM_LZW = "LZW";
  public static final String COMPRESSION_ALGORITHM_NONE = "None";
  public static final String COMPRESSION_ALGORITHM_PACKBITS = "PackBits";
  public static final String COMPRESSION_ALGORITHM_PNG_FILTER = "PNG Filter";
  public static final String COMPRESSION_ALGORITHM_PSD = "Photoshop";
  public static final String COMPRESSION_ALGORITHM_RLE = "RLE: Run-Length Encoding";
  public static final String COMPRESSION_ALGORITHM_UNKNOWN = "Unknown";
  private final int bitsPerPixel;
  private final int colorType;
  private final ArrayList comments;
  private final String compressionAlgorithm;
  private final ImageFormat format;
  private final String formatDetails;
  private final String formatName;
  private final int height;
  private final boolean isProgressive;
  private final boolean isTransparent;
  private final String mimeType;
  private final int numberOfImages;
  private final int physicalHeightDpi;
  private final float physicalHeightInch;
  private final int physicalWidthDpi;
  private final float physicalWidthInch;
  private final boolean usesPalette;
  private final int width;
  
  public ImageInfo(String paramString1, int paramInt1, ArrayList paramArrayList, ImageFormat paramImageFormat, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, float paramFloat1, int paramInt5, float paramFloat2, int paramInt6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt7, String paramString4)
  {
    this.formatDetails = paramString1;
    this.bitsPerPixel = paramInt1;
    this.comments = paramArrayList;
    this.format = paramImageFormat;
    this.formatName = paramString2;
    this.height = paramInt2;
    this.mimeType = paramString3;
    this.numberOfImages = paramInt3;
    this.physicalHeightDpi = paramInt4;
    this.physicalHeightInch = paramFloat1;
    this.physicalWidthDpi = paramInt5;
    this.physicalWidthInch = paramFloat2;
    this.width = paramInt6;
    this.isProgressive = paramBoolean1;
    this.isTransparent = paramBoolean2;
    this.usesPalette = paramBoolean3;
    this.colorType = paramInt7;
    this.compressionAlgorithm = paramString4;
  }
  
  /* Error */
  public void dump()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getBitsPerPixel()
  {
    return this.bitsPerPixel;
  }
  
  public int getColorType()
  {
    return this.colorType;
  }
  
  public String getColorTypeDescription()
  {
    return null;
  }
  
  public ArrayList getComments()
  {
    return new ArrayList(this.comments);
  }
  
  public ImageFormat getFormat()
  {
    return this.format;
  }
  
  public String getFormatName()
  {
    return this.formatName;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public boolean getIsProgressive()
  {
    return this.isProgressive;
  }
  
  public String getMimeType()
  {
    return this.mimeType;
  }
  
  public int getNumberOfImages()
  {
    return this.numberOfImages;
  }
  
  public int getPhysicalHeightDpi()
  {
    return this.physicalHeightDpi;
  }
  
  public float getPhysicalHeightInch()
  {
    return this.physicalHeightInch;
  }
  
  public int getPhysicalWidthDpi()
  {
    return this.physicalWidthDpi;
  }
  
  public float getPhysicalWidthInch()
  {
    return this.physicalWidthInch;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public String toString()
  {
    return null;
  }
  
  /* Error */
  public void toString(java.io.PrintWriter arg1, String arg2)
    throws ImageReadException, java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\ImageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */