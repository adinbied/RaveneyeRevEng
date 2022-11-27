package dji.thirdparty.sanselan;

import dji.thirdparty.sanselan.common.BinaryFileParser;
import dji.thirdparty.sanselan.common.IImageMetadata;
import dji.thirdparty.sanselan.common.byteSources.ByteSource;
import dji.thirdparty.sanselan.formats.jpeg.JpegImageParser;
import dji.thirdparty.sanselan.formats.tiff.TiffImageParser;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public abstract class ImageParser
  extends BinaryFileParser
  implements SanselanConstants
{
  public static final ImageParser[] getAllImageParsers()
  {
    return new ImageParser[] { new JpegImageParser(), new TiffImageParser() };
  }
  
  public static final boolean isStrict(Map paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey("STRICT"))) {
      return ((Boolean)paramMap.get("STRICT")).booleanValue();
    }
    return false;
  }
  
  protected final boolean canAcceptExtension(File paramFile)
  {
    return canAcceptExtension(paramFile.getName());
  }
  
  protected final boolean canAcceptExtension(String paramString)
  {
    return false;
  }
  
  public boolean canAcceptType(ImageFormat paramImageFormat)
  {
    return false;
  }
  
  public final String dumpImageFile(ByteSource paramByteSource)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public final String dumpImageFile(File paramFile)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public final String dumpImageFile(byte[] paramArrayOfByte)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public boolean dumpImageFile(PrintWriter paramPrintWriter, ByteSource paramByteSource)
    throws ImageReadException, IOException
  {
    return false;
  }
  
  public abstract boolean embedICCProfile(File paramFile1, File paramFile2, byte[] paramArrayOfByte);
  
  protected abstract String[] getAcceptedExtensions();
  
  protected abstract ImageFormat[] getAcceptedTypes();
  
  public abstract String getDefaultExtension();
  
  public FormatCompliance getFormatCompliance(ByteSource paramByteSource)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public final FormatCompliance getFormatCompliance(File paramFile)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public final FormatCompliance getFormatCompliance(byte[] paramArrayOfByte)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public abstract byte[] getICCProfileBytes(ByteSource paramByteSource, Map paramMap)
    throws ImageReadException, IOException;
  
  public final byte[] getICCProfileBytes(File paramFile)
    throws ImageReadException, IOException
  {
    return getICCProfileBytes(paramFile, null);
  }
  
  public final byte[] getICCProfileBytes(File paramFile, Map paramMap)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public final byte[] getICCProfileBytes(byte[] paramArrayOfByte)
    throws ImageReadException, IOException
  {
    return getICCProfileBytes(paramArrayOfByte, null);
  }
  
  public final byte[] getICCProfileBytes(byte[] paramArrayOfByte, Map paramMap)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public final ImageInfo getImageInfo(ByteSource paramByteSource)
    throws ImageReadException, IOException
  {
    return getImageInfo(paramByteSource, null);
  }
  
  public abstract ImageInfo getImageInfo(ByteSource paramByteSource, Map paramMap)
    throws ImageReadException, IOException;
  
  public final ImageInfo getImageInfo(File paramFile, Map paramMap)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public final ImageInfo getImageInfo(byte[] paramArrayOfByte, Map paramMap)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public final IImageMetadata getMetadata(ByteSource paramByteSource)
    throws ImageReadException, IOException
  {
    return getMetadata(paramByteSource, null);
  }
  
  public abstract IImageMetadata getMetadata(ByteSource paramByteSource, Map paramMap)
    throws ImageReadException, IOException;
  
  public final IImageMetadata getMetadata(File paramFile)
    throws ImageReadException, IOException
  {
    return getMetadata(paramFile, null);
  }
  
  public final IImageMetadata getMetadata(File paramFile, Map paramMap)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public final IImageMetadata getMetadata(byte[] paramArrayOfByte, Map paramMap)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public abstract String getName();
  
  public abstract String getXmpXml(ByteSource paramByteSource, Map paramMap)
    throws ImageReadException, IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\ImageParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */