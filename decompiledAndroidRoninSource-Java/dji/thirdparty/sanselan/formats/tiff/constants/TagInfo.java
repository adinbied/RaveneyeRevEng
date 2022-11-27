package dji.thirdparty.sanselan.formats.tiff.constants;

import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.ImageWriteException;
import dji.thirdparty.sanselan.formats.tiff.TiffField;
import dji.thirdparty.sanselan.formats.tiff.fieldtypes.FieldType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TagInfo
  implements TiffDirectoryConstants, TiffFieldTypeConstants
{
  protected static final int LENGTH_UNKNOWN = -1;
  public final FieldType[] dataTypes;
  public final TiffDirectoryConstants.ExifDirectoryType directoryType;
  public final int length;
  public final String name;
  public final int tag;
  
  public TagInfo(String paramString, int paramInt, FieldType paramFieldType)
  {
    this(paramString, paramInt, paramFieldType, -1, EXIF_DIRECTORY_UNKNOWN);
  }
  
  public TagInfo(String paramString, int paramInt1, FieldType paramFieldType, int paramInt2)
  {
    this(paramString, paramInt1, new FieldType[] { paramFieldType }, paramInt2, localExifDirectoryType);
  }
  
  public TagInfo(String paramString, int paramInt1, FieldType paramFieldType, int paramInt2, TiffDirectoryConstants.ExifDirectoryType paramExifDirectoryType)
  {
    this(paramString, paramInt1, new FieldType[] { paramFieldType }, paramInt2, paramExifDirectoryType);
  }
  
  public TagInfo(String paramString1, int paramInt, FieldType paramFieldType, String paramString2)
  {
    this(paramString1, paramInt, new FieldType[] { paramFieldType }, -1, paramString2);
  }
  
  public TagInfo(String paramString, int paramInt1, FieldType[] paramArrayOfFieldType, int paramInt2, TiffDirectoryConstants.ExifDirectoryType paramExifDirectoryType)
  {
    this.name = paramString;
    this.tag = paramInt1;
    this.dataTypes = paramArrayOfFieldType;
    this.length = paramInt2;
    this.directoryType = paramExifDirectoryType;
  }
  
  public TagInfo(String paramString1, int paramInt1, FieldType[] paramArrayOfFieldType, int paramInt2, String paramString2)
  {
    this(paramString1, paramInt1, paramArrayOfFieldType, paramInt2, EXIF_DIRECTORY_UNKNOWN);
  }
  
  public TagInfo(String paramString1, int paramInt, FieldType[] paramArrayOfFieldType, String paramString2)
  {
    this(paramString1, paramInt, paramArrayOfFieldType, -1, EXIF_DIRECTORY_UNKNOWN);
  }
  
  public byte[] encodeValue(FieldType paramFieldType, Object paramObject, int paramInt)
    throws ImageWriteException
  {
    return paramFieldType.writeData(paramObject, paramInt);
  }
  
  public String getDescription()
  {
    return null;
  }
  
  public Object getValue(TiffField paramTiffField)
    throws ImageReadException
  {
    return paramTiffField.fieldType.getSimpleValue(paramTiffField);
  }
  
  public boolean isDate()
  {
    return false;
  }
  
  public boolean isOffset()
  {
    return false;
  }
  
  public boolean isText()
  {
    return false;
  }
  
  public boolean isUnknown()
  {
    return false;
  }
  
  public String toString()
  {
    return null;
  }
  
  public static class Date
    extends TagInfo
  {
    private static final DateFormat DATE_FORMAT_1 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    private static final DateFormat DATE_FORMAT_2 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
    
    public Date(String paramString, int paramInt1, FieldType paramFieldType, int paramInt2)
    {
      super(paramInt1, paramFieldType, paramInt2);
    }
    
    public byte[] encodeValue(FieldType paramFieldType, Object paramObject, int paramInt)
      throws ImageWriteException
    {
      return null;
    }
    
    public Object getValue(TiffField paramTiffField)
      throws ImageReadException
    {
      return null;
    }
    
    public boolean isDate()
    {
      return true;
    }
    
    public String toString()
    {
      return null;
    }
  }
  
  public static class Offset
    extends TagInfo
  {
    public Offset(String paramString, int paramInt1, FieldType paramFieldType, int paramInt2)
    {
      super(paramInt1, paramFieldType, paramInt2);
    }
    
    public Offset(String paramString, int paramInt1, FieldType paramFieldType, int paramInt2, TiffDirectoryConstants.ExifDirectoryType paramExifDirectoryType)
    {
      super(paramInt1, paramFieldType, paramInt2, paramExifDirectoryType);
    }
    
    public Offset(String paramString, int paramInt1, FieldType[] paramArrayOfFieldType, int paramInt2, TiffDirectoryConstants.ExifDirectoryType paramExifDirectoryType)
    {
      super(paramInt1, paramArrayOfFieldType, paramInt2, paramExifDirectoryType);
    }
    
    public boolean isOffset()
    {
      return true;
    }
  }
  
  public static final class Text
    extends TagInfo
  {
    private static final TextEncoding[] TEXT_ENCODINGS;
    private static final TextEncoding TEXT_ENCODING_ASCII = new TextEncoding(new byte[] { 65, 83, 67, 73, 73, 0, 0, 0 }, "US-ASCII");
    private static final TextEncoding TEXT_ENCODING_JIS = new TextEncoding(new byte[] { 74, 73, 83, 0, 0, 0, 0, 0 }, "JIS");
    private static final TextEncoding TEXT_ENCODING_UNDEFINED;
    private static final TextEncoding TEXT_ENCODING_UNICODE = new TextEncoding(new byte[] { 85, 78, 73, 67, 79, 68, 69, 0 }, "UTF-8");
    
    static
    {
      TextEncoding localTextEncoding = new TextEncoding(new byte[] { 0, 0, 0, 0, 0, 0, 0, 0 }, "ISO-8859-1");
      TEXT_ENCODING_UNDEFINED = localTextEncoding;
      TEXT_ENCODINGS = new TextEncoding[] { TEXT_ENCODING_ASCII, TEXT_ENCODING_JIS, TEXT_ENCODING_UNICODE, localTextEncoding };
    }
    
    public Text(String paramString, int paramInt1, FieldType paramFieldType, int paramInt2, TiffDirectoryConstants.ExifDirectoryType paramExifDirectoryType)
    {
      super(paramInt1, paramFieldType, paramInt2, paramExifDirectoryType);
    }
    
    public Text(String paramString, int paramInt1, FieldType[] paramArrayOfFieldType, int paramInt2, TiffDirectoryConstants.ExifDirectoryType paramExifDirectoryType)
    {
      super(paramInt1, paramArrayOfFieldType, paramInt2, paramExifDirectoryType);
    }
    
    public byte[] encodeValue(FieldType paramFieldType, Object paramObject, int paramInt)
      throws ImageWriteException
    {
      return null;
    }
    
    public Object getValue(TiffField paramTiffField)
      throws ImageReadException
    {
      return null;
    }
    
    public boolean isText()
    {
      return true;
    }
    
    private static final class TextEncoding
    {
      public final String encodingName;
      public final byte[] prefix;
      
      public TextEncoding(byte[] paramArrayOfByte, String paramString)
      {
        this.prefix = paramArrayOfByte;
        this.encodingName = paramString;
      }
    }
  }
  
  public static final class Unknown
    extends TagInfo
  {
    public Unknown(String paramString, int paramInt1, FieldType[] paramArrayOfFieldType, int paramInt2, TiffDirectoryConstants.ExifDirectoryType paramExifDirectoryType)
    {
      super(paramInt1, paramArrayOfFieldType, paramInt2, paramExifDirectoryType);
    }
    
    public byte[] encodeValue(FieldType paramFieldType, Object paramObject, int paramInt)
      throws ImageWriteException
    {
      return super.encodeValue(paramFieldType, paramObject, paramInt);
    }
    
    public Object getValue(TiffField paramTiffField)
      throws ImageReadException
    {
      return super.getValue(paramTiffField);
    }
    
    public boolean isUnknown()
    {
      return true;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\constants\TagInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */