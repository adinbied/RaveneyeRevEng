package dji.thirdparty.sanselan.formats.tiff.write;

import dji.thirdparty.sanselan.ImageWriteException;
import dji.thirdparty.sanselan.common.BinaryConstants;
import dji.thirdparty.sanselan.common.BinaryOutputStream;
import dji.thirdparty.sanselan.formats.tiff.constants.TiffConstants;
import java.io.IOException;
import java.io.OutputStream;

public abstract class TiffImageWriterBase
  implements TiffConstants, BinaryConstants
{
  protected final int byteOrder;
  
  public TiffImageWriterBase()
  {
    this.byteOrder = 73;
  }
  
  public TiffImageWriterBase(int paramInt)
  {
    this.byteOrder = paramInt;
  }
  
  protected static final int imageDataPaddingLength(int paramInt)
  {
    return (4 - paramInt % 4) % 4;
  }
  
  protected TiffOutputSummary validateDirectories(TiffOutputSet paramTiffOutputSet)
    throws ImageWriteException
  {
    return null;
  }
  
  public abstract void write(OutputStream paramOutputStream, TiffOutputSet paramTiffOutputSet)
    throws IOException, ImageWriteException;
  
  protected void writeImageFileHeader(BinaryOutputStream paramBinaryOutputStream)
    throws IOException, ImageWriteException
  {
    writeImageFileHeader(paramBinaryOutputStream, 8);
  }
  
  /* Error */
  protected void writeImageFileHeader(BinaryOutputStream arg1, int arg2)
    throws IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\write\TiffImageWriterBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */