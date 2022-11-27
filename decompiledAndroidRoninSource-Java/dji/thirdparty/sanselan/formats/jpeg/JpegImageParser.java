package dji.thirdparty.sanselan.formats.jpeg;

import dji.thirdparty.sanselan.ImageFormat;
import dji.thirdparty.sanselan.ImageInfo;
import dji.thirdparty.sanselan.ImageParser;
import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.common.BinaryFileParser;
import dji.thirdparty.sanselan.common.IImageMetadata;
import dji.thirdparty.sanselan.common.byteSources.ByteSource;
import dji.thirdparty.sanselan.formats.jpeg.segments.GenericSegment;
import dji.thirdparty.sanselan.formats.tiff.TiffImageMetadata;
import dji.thirdparty.sanselan.formats.tiff.constants.TiffTagConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JpegImageParser
  extends ImageParser
  implements JpegConstants, TiffTagConstants
{
  public static final String[] AcceptedExtensions = { ".jpg", ".jpeg" };
  private static final String DEFAULT_EXTENSION = ".jpg";
  public static final boolean permissive = true;
  
  public JpegImageParser()
  {
    setByteOrder(77);
  }
  
  private byte[] assembleSegments(ArrayList paramArrayList)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  private byte[] assembleSegments(ArrayList paramArrayList, boolean paramBoolean)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  /* Error */
  private void dumpSegments(ArrayList arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private ArrayList filterAPP1Segments(ArrayList paramArrayList)
  {
    return null;
  }
  
  private ArrayList filterSegments(ArrayList paramArrayList, List paramList)
  {
    return null;
  }
  
  public static boolean isExifAPP1Segment(GenericSegment paramGenericSegment)
  {
    return byteArrayHasPrefix(paramGenericSegment.bytes, EXIF_IDENTIFIER_CODE);
  }
  
  private boolean keepMarker(int paramInt, int[] paramArrayOfInt)
  {
    return false;
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
    return AcceptedExtensions;
  }
  
  protected ImageFormat[] getAcceptedTypes()
  {
    return null;
  }
  
  public String getDefaultExtension()
  {
    return ".jpg";
  }
  
  public TiffImageMetadata getExifMetadata(ByteSource paramByteSource, Map paramMap)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public byte[] getExifRawData(ByteSource paramByteSource)
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
    return "Jpeg-Custom";
  }
  
  public Object getPhotoshopMetadata(ByteSource paramByteSource, Map paramMap)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public String getXmpXml(ByteSource paramByteSource, Map paramMap)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public boolean hasExifSegment(ByteSource paramByteSource)
    throws ImageReadException, IOException
  {
    return false;
  }
  
  public boolean hasIptcSegment(ByteSource paramByteSource)
    throws ImageReadException, IOException
  {
    return false;
  }
  
  public boolean hasXmpSegment(ByteSource paramByteSource)
    throws ImageReadException, IOException
  {
    return false;
  }
  
  public ArrayList readSegments(ByteSource paramByteSource, int[] paramArrayOfInt, boolean paramBoolean)
    throws ImageReadException, IOException
  {
    return readSegments(paramByteSource, paramArrayOfInt, paramBoolean, false);
  }
  
  public ArrayList readSegments(ByteSource paramByteSource, int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2)
    throws ImageReadException, IOException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\jpeg\JpegImageParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */