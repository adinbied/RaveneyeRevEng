package dji.thirdparty.sanselan.formats.tiff;

import dji.thirdparty.sanselan.FormatCompliance;
import dji.thirdparty.sanselan.ImageFormat;
import dji.thirdparty.sanselan.ImageInfo;
import dji.thirdparty.sanselan.ImageParser;
import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.common.IImageMetadata;
import dji.thirdparty.sanselan.common.byteSources.ByteSource;
import dji.thirdparty.sanselan.formats.tiff.constants.TiffConstants;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class TiffImageParser
  extends ImageParser
  implements TiffConstants
{
  private static final String[] ACCEPTED_EXTENSIONS = { ".tif", ".tiff" };
  private static final String DEFAULT_EXTENSION = ".tif";
  
  public List collectRawImageData(ByteSource paramByteSource, Map paramMap)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public boolean dumpImageFile(PrintWriter paramPrintWriter, ByteSource paramByteSource)
    throws ImageReadException, IOException
  {
    return false;
  }
  
  public boolean embedICCProfile(File paramFile1, File paramFile2, byte[] paramArrayOfByte)
  {
    return false;
  }
  
  public byte[] embedICCProfile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return null;
  }
  
  protected String[] getAcceptedExtensions()
  {
    return ACCEPTED_EXTENSIONS;
  }
  
  protected ImageFormat[] getAcceptedTypes()
  {
    return null;
  }
  
  public String getDefaultExtension()
  {
    return ".tif";
  }
  
  public FormatCompliance getFormatCompliance(ByteSource paramByteSource)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public byte[] getICCProfileBytes(ByteSource paramByteSource, Map paramMap)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public ImageInfo getImageInfo(ByteSource paramByteSource, Map paramMap)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public int[] getImageSize(ByteSource paramByteSource, Map paramMap)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public IImageMetadata getMetadata(ByteSource paramByteSource, Map paramMap)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public String getName()
  {
    return "Tiff-Custom";
  }
  
  public String getXmpXml(ByteSource paramByteSource, Map paramMap)
    throws ImageReadException, IOException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\TiffImageParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */