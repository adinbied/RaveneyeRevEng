package dji.thirdparty.sanselan.formats.tiff;

import dji.thirdparty.sanselan.FormatCompliance;
import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.common.BinaryFileParser;
import dji.thirdparty.sanselan.common.byteSources.ByteSource;
import dji.thirdparty.sanselan.formats.tiff.constants.TiffConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TiffReader
  extends BinaryFileParser
  implements TiffConstants
{
  private final boolean strict;
  
  public TiffReader(boolean paramBoolean)
  {
    this.strict = paramBoolean;
  }
  
  private JpegImageData getJpegRawImageData(ByteSource paramByteSource, TiffDirectory paramTiffDirectory)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  /* Error */
  private void readDirectories(ByteSource arg1, FormatCompliance arg2, Listener arg3)
    throws ImageReadException, IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean readDirectory(ByteSource paramByteSource, int paramInt1, int paramInt2, FormatCompliance paramFormatCompliance, Listener paramListener, List paramList)
    throws ImageReadException, IOException
  {
    return false;
  }
  
  private boolean readDirectory(ByteSource paramByteSource, int paramInt1, int paramInt2, FormatCompliance paramFormatCompliance, Listener paramListener, boolean paramBoolean, List paramList)
    throws ImageReadException, IOException
  {
    return false;
  }
  
  /* Error */
  private TiffHeader readTiffHeader(ByteSource paramByteSource, FormatCompliance paramFormatCompliance)
    throws ImageReadException, IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 50	dji/thirdparty/sanselan/common/byteSources/ByteSource:getInputStream	()Ljava/io/InputStream;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokespecial 53	dji/thirdparty/sanselan/formats/tiff/TiffReader:readTiffHeader	(Ljava/io/InputStream;Ldji/thirdparty/sanselan/FormatCompliance;)Ldji/thirdparty/sanselan/formats/tiff/TiffHeader;
    //   11: astore_2
    //   12: aload_1
    //   13: ifnull +14 -> 27
    //   16: aload_1
    //   17: invokevirtual 58	java/io/InputStream:close	()V
    //   20: aload_2
    //   21: areturn
    //   22: astore_1
    //   23: aload_1
    //   24: invokestatic 64	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   27: aload_2
    //   28: areturn
    //   29: astore_3
    //   30: aload_1
    //   31: astore_2
    //   32: aload_3
    //   33: astore_1
    //   34: goto +6 -> 40
    //   37: astore_1
    //   38: aconst_null
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull +15 -> 56
    //   44: aload_2
    //   45: invokevirtual 58	java/io/InputStream:close	()V
    //   48: goto +8 -> 56
    //   51: astore_2
    //   52: aload_2
    //   53: invokestatic 64	dji/thirdparty/sanselan/util/Debug:debug	(Ljava/lang/Throwable;)V
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	TiffReader
    //   0	58	1	paramByteSource	ByteSource
    //   0	58	2	paramFormatCompliance	FormatCompliance
    //   29	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	20	22	java/lang/Exception
    //   5	12	29	finally
    //   0	5	37	finally
    //   44	48	51	java/lang/Exception
  }
  
  private TiffHeader readTiffHeader(InputStream paramInputStream, FormatCompliance paramFormatCompliance)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public void read(ByteSource paramByteSource, Map paramMap, FormatCompliance paramFormatCompliance, Listener paramListener)
    throws ImageReadException, IOException
  {
    readDirectories(paramByteSource, paramFormatCompliance, paramListener);
  }
  
  public TiffContents readContents(ByteSource paramByteSource, Map paramMap, FormatCompliance paramFormatCompliance)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public TiffContents readDirectories(ByteSource paramByteSource, boolean paramBoolean, FormatCompliance paramFormatCompliance)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public TiffContents readFirstDirectory(ByteSource paramByteSource, Map paramMap, boolean paramBoolean, FormatCompliance paramFormatCompliance)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  private static class Collector
    implements TiffReader.Listener
  {
    private ArrayList directories = new ArrayList();
    private ArrayList fields = new ArrayList();
    private final boolean readThumbnails;
    private TiffHeader tiffHeader = null;
    
    public Collector()
    {
      this(null);
    }
    
    public Collector(Map paramMap)
    {
      boolean bool;
      if ((paramMap != null) && (paramMap.containsKey("READ_THUMBNAILS"))) {
        bool = Boolean.TRUE.equals(paramMap.get("READ_THUMBNAILS"));
      } else {
        bool = true;
      }
      this.readThumbnails = bool;
    }
    
    public boolean addDirectory(TiffDirectory paramTiffDirectory)
    {
      this.directories.add(paramTiffDirectory);
      return true;
    }
    
    public boolean addField(TiffField paramTiffField)
    {
      this.fields.add(paramTiffField);
      return true;
    }
    
    public TiffContents getContents()
    {
      return null;
    }
    
    public boolean readImageData()
    {
      return this.readThumbnails;
    }
    
    public boolean readOffsetDirectories()
    {
      return true;
    }
    
    public boolean setTiffHeader(TiffHeader paramTiffHeader)
    {
      this.tiffHeader = paramTiffHeader;
      return true;
    }
  }
  
  private static class DirectoryCollector
    extends TiffReader.Collector
  {
    private final boolean readImageData;
    
    public DirectoryCollector(boolean paramBoolean)
    {
      this.readImageData = paramBoolean;
    }
    
    public boolean addDirectory(TiffDirectory paramTiffDirectory)
    {
      super.addDirectory(paramTiffDirectory);
      return false;
    }
    
    public boolean readImageData()
    {
      return this.readImageData;
    }
  }
  
  private static class FirstDirectoryCollector
    extends TiffReader.Collector
  {
    private final boolean readImageData;
    
    public FirstDirectoryCollector(boolean paramBoolean)
    {
      this.readImageData = paramBoolean;
    }
    
    public boolean addDirectory(TiffDirectory paramTiffDirectory)
    {
      super.addDirectory(paramTiffDirectory);
      return false;
    }
    
    public boolean readImageData()
    {
      return this.readImageData;
    }
  }
  
  public static abstract interface Listener
  {
    public abstract boolean addDirectory(TiffDirectory paramTiffDirectory);
    
    public abstract boolean addField(TiffField paramTiffField);
    
    public abstract boolean readImageData();
    
    public abstract boolean readOffsetDirectories();
    
    public abstract boolean setTiffHeader(TiffHeader paramTiffHeader);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\TiffReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */