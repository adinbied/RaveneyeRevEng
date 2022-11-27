package dji.thirdparty.sanselan;

public class ImageFormat
{
  public static final ImageFormat IMAGE_FORMAT_BMP;
  public static final ImageFormat IMAGE_FORMAT_GIF;
  public static final ImageFormat IMAGE_FORMAT_ICO;
  public static final ImageFormat IMAGE_FORMAT_JBIG2 = new ImageFormat("JBig2");
  public static final ImageFormat IMAGE_FORMAT_JPEG;
  public static final ImageFormat IMAGE_FORMAT_PBM;
  public static final ImageFormat IMAGE_FORMAT_PGM;
  public static final ImageFormat IMAGE_FORMAT_PNG;
  public static final ImageFormat IMAGE_FORMAT_PNM;
  public static final ImageFormat IMAGE_FORMAT_PPM;
  public static final ImageFormat IMAGE_FORMAT_PSD;
  public static final ImageFormat IMAGE_FORMAT_TGA;
  public static final ImageFormat IMAGE_FORMAT_TIFF;
  public static final ImageFormat IMAGE_FORMAT_UNKNOWN = new ImageFormat("UNKNOWN", false);
  public final boolean actual;
  public final String extension;
  public final String name;
  
  static
  {
    IMAGE_FORMAT_PNG = new ImageFormat("PNG");
    IMAGE_FORMAT_GIF = new ImageFormat("GIF");
    IMAGE_FORMAT_ICO = new ImageFormat("ICO");
    IMAGE_FORMAT_TIFF = new ImageFormat("TIFF");
    IMAGE_FORMAT_JPEG = new ImageFormat("JPEG");
    IMAGE_FORMAT_BMP = new ImageFormat("BMP");
    IMAGE_FORMAT_PSD = new ImageFormat("PSD");
    IMAGE_FORMAT_PBM = new ImageFormat("PBM");
    IMAGE_FORMAT_PGM = new ImageFormat("PGM");
    IMAGE_FORMAT_PPM = new ImageFormat("PPM");
    IMAGE_FORMAT_PNM = new ImageFormat("PNM");
    IMAGE_FORMAT_TGA = new ImageFormat("TGA");
  }
  
  private ImageFormat(String paramString)
  {
    this.name = paramString;
    this.extension = paramString;
    this.actual = true;
  }
  
  private ImageFormat(String paramString, boolean paramBoolean)
  {
    this.name = paramString;
    this.extension = paramString;
    this.actual = paramBoolean;
  }
  
  public static final ImageFormat[] getAllFormats()
  {
    return new ImageFormat[] { IMAGE_FORMAT_UNKNOWN, IMAGE_FORMAT_PNG, IMAGE_FORMAT_GIF, IMAGE_FORMAT_TIFF, IMAGE_FORMAT_JPEG, IMAGE_FORMAT_BMP, IMAGE_FORMAT_PSD, IMAGE_FORMAT_PBM, IMAGE_FORMAT_PGM, IMAGE_FORMAT_PPM, IMAGE_FORMAT_PNM, IMAGE_FORMAT_TGA, IMAGE_FORMAT_JBIG2 };
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return this.name.hashCode();
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\ImageFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */