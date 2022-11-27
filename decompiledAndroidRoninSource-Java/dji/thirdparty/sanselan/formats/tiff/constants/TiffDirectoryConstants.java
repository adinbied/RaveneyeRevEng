package dji.thirdparty.sanselan.formats.tiff.constants;

public abstract interface TiffDirectoryConstants
{
  public static final int DIRECTORY_TYPE_DIR_0 = 0;
  public static final int DIRECTORY_TYPE_DIR_1 = 1;
  public static final int DIRECTORY_TYPE_DIR_2 = 2;
  public static final int DIRECTORY_TYPE_DIR_3 = 3;
  public static final int DIRECTORY_TYPE_DIR_4 = 4;
  public static final int DIRECTORY_TYPE_EXIF = -2;
  public static final int DIRECTORY_TYPE_GPS = -3;
  public static final int DIRECTORY_TYPE_INTEROPERABILITY = -4;
  public static final int DIRECTORY_TYPE_MAKER_NOTES = -5;
  public static final int DIRECTORY_TYPE_ROOT = 0;
  public static final int DIRECTORY_TYPE_SUB = 1;
  public static final int DIRECTORY_TYPE_SUB0 = 1;
  public static final int DIRECTORY_TYPE_SUB1 = 2;
  public static final int DIRECTORY_TYPE_SUB2 = 3;
  public static final int DIRECTORY_TYPE_THUMBNAIL = 2;
  public static final int DIRECTORY_TYPE_UNKNOWN = -1;
  public static final ExifDirectoryType[] EXIF_DIRECTORIES;
  public static final ExifDirectoryType EXIF_DIRECTORY_EXIF_IFD;
  public static final ExifDirectoryType EXIF_DIRECTORY_GPS;
  public static final ExifDirectoryType EXIF_DIRECTORY_IFD0;
  public static final ExifDirectoryType EXIF_DIRECTORY_IFD1;
  public static final ExifDirectoryType EXIF_DIRECTORY_IFD2;
  public static final ExifDirectoryType EXIF_DIRECTORY_IFD3;
  public static final ExifDirectoryType EXIF_DIRECTORY_INTEROP_IFD;
  public static final ExifDirectoryType EXIF_DIRECTORY_MAKER_NOTES;
  public static final ExifDirectoryType EXIF_DIRECTORY_SUB_IFD;
  public static final ExifDirectoryType EXIF_DIRECTORY_SUB_IFD1;
  public static final ExifDirectoryType EXIF_DIRECTORY_SUB_IFD2;
  public static final ExifDirectoryType EXIF_DIRECTORY_UNKNOWN;
  public static final ExifDirectoryType TIFF_DIRECTORY_IFD0;
  public static final ExifDirectoryType TIFF_DIRECTORY_IFD1;
  public static final ExifDirectoryType TIFF_DIRECTORY_IFD2;
  public static final ExifDirectoryType TIFF_DIRECTORY_IFD3;
  public static final ExifDirectoryType TIFF_DIRECTORY_ROOT;
  
  static
  {
    Object localObject = new TiffDirectoryConstants.ExifDirectoryType.Image(0, "IFD0");
    TIFF_DIRECTORY_IFD0 = (ExifDirectoryType)localObject;
    EXIF_DIRECTORY_IFD0 = (ExifDirectoryType)localObject;
    TIFF_DIRECTORY_ROOT = (ExifDirectoryType)localObject;
    localObject = new TiffDirectoryConstants.ExifDirectoryType.Image(1, "IFD1");
    TIFF_DIRECTORY_IFD1 = (ExifDirectoryType)localObject;
    EXIF_DIRECTORY_IFD1 = (ExifDirectoryType)localObject;
    localObject = new TiffDirectoryConstants.ExifDirectoryType.Image(2, "IFD2");
    TIFF_DIRECTORY_IFD2 = (ExifDirectoryType)localObject;
    EXIF_DIRECTORY_IFD2 = (ExifDirectoryType)localObject;
    localObject = new TiffDirectoryConstants.ExifDirectoryType.Image(3, "IFD3");
    TIFF_DIRECTORY_IFD3 = (ExifDirectoryType)localObject;
    EXIF_DIRECTORY_IFD3 = (ExifDirectoryType)localObject;
    EXIF_DIRECTORY_SUB_IFD = TIFF_DIRECTORY_IFD1;
    EXIF_DIRECTORY_SUB_IFD1 = TIFF_DIRECTORY_IFD2;
    EXIF_DIRECTORY_SUB_IFD2 = (ExifDirectoryType)localObject;
    EXIF_DIRECTORY_INTEROP_IFD = new TiffDirectoryConstants.ExifDirectoryType.Special(-4, "Interop IFD");
    EXIF_DIRECTORY_MAKER_NOTES = new TiffDirectoryConstants.ExifDirectoryType.Special(-5, "Maker Notes");
    EXIF_DIRECTORY_EXIF_IFD = new TiffDirectoryConstants.ExifDirectoryType.Special(-2, "Exif IFD");
    localObject = new TiffDirectoryConstants.ExifDirectoryType.Special(-3, "GPS IFD");
    EXIF_DIRECTORY_GPS = (ExifDirectoryType)localObject;
    EXIF_DIRECTORY_UNKNOWN = null;
    EXIF_DIRECTORIES = new ExifDirectoryType[] { TIFF_DIRECTORY_ROOT, EXIF_DIRECTORY_EXIF_IFD, TIFF_DIRECTORY_IFD0, EXIF_DIRECTORY_IFD0, TIFF_DIRECTORY_IFD1, EXIF_DIRECTORY_IFD1, TIFF_DIRECTORY_IFD2, EXIF_DIRECTORY_IFD2, EXIF_DIRECTORY_INTEROP_IFD, EXIF_DIRECTORY_MAKER_NOTES, EXIF_DIRECTORY_SUB_IFD, EXIF_DIRECTORY_SUB_IFD1, EXIF_DIRECTORY_SUB_IFD2, localObject };
  }
  
  public static abstract class ExifDirectoryType
  {
    public final int directoryType;
    public final String name;
    
    public ExifDirectoryType(int paramInt, String paramString)
    {
      this.directoryType = paramInt;
      this.name = paramString;
    }
    
    public abstract boolean isImageDirectory();
    
    public static class Image
      extends TiffDirectoryConstants.ExifDirectoryType
    {
      public Image(int paramInt, String paramString)
      {
        super(paramString);
      }
      
      public boolean isImageDirectory()
      {
        return true;
      }
    }
    
    public static class Special
      extends TiffDirectoryConstants.ExifDirectoryType
    {
      public Special(int paramInt, String paramString)
      {
        super(paramString);
      }
      
      public boolean isImageDirectory()
      {
        return false;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\constants\TiffDirectoryConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */