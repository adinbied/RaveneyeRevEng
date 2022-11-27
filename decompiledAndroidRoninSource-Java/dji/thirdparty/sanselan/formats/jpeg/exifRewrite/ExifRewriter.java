package dji.thirdparty.sanselan.formats.jpeg.exifRewrite;

import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.ImageWriteException;
import dji.thirdparty.sanselan.common.BinaryFileParser;
import dji.thirdparty.sanselan.common.byteSources.ByteSource;
import dji.thirdparty.sanselan.formats.jpeg.JpegConstants;
import dji.thirdparty.sanselan.formats.jpeg.JpegUtils.Visitor;
import dji.thirdparty.sanselan.formats.tiff.write.TiffImageWriterBase;
import dji.thirdparty.sanselan.formats.tiff.write.TiffOutputSet;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExifRewriter
  extends BinaryFileParser
  implements JpegConstants
{
  public ExifRewriter()
  {
    setByteOrder(77);
  }
  
  public ExifRewriter(int paramInt)
  {
    setByteOrder(paramInt);
  }
  
  private JFIFPieces analyzeJFIF(ByteSource paramByteSource)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  private byte[] writeExifSegment(TiffImageWriterBase paramTiffImageWriterBase, TiffOutputSet paramTiffOutputSet, boolean paramBoolean)
    throws IOException, ImageWriteException
  {
    return null;
  }
  
  /* Error */
  private void writeSegmentsReplacingExif(OutputStream arg1, List arg2, byte[] arg3)
    throws ImageWriteException, IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void removeExifMetadata(ByteSource arg1, OutputStream arg2)
    throws ImageReadException, IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void removeExifMetadata(java.io.File arg1, OutputStream arg2)
    throws ImageReadException, IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void removeExifMetadata(InputStream arg1, OutputStream arg2)
    throws ImageReadException, IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void removeExifMetadata(byte[] arg1, OutputStream arg2)
    throws ImageReadException, IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateExifMetadataLossless(ByteSource arg1, OutputStream arg2, TiffOutputSet arg3)
    throws ImageReadException, IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateExifMetadataLossless(java.io.File arg1, OutputStream arg2, TiffOutputSet arg3)
    throws ImageReadException, IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateExifMetadataLossless(InputStream arg1, OutputStream arg2, TiffOutputSet arg3)
    throws ImageReadException, IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateExifMetadataLossless(byte[] arg1, OutputStream arg2, TiffOutputSet arg3)
    throws ImageReadException, IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateExifMetadataLossy(ByteSource arg1, OutputStream arg2, TiffOutputSet arg3)
    throws ImageReadException, IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateExifMetadataLossy(java.io.File arg1, OutputStream arg2, TiffOutputSet arg3)
    throws ImageReadException, IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateExifMetadataLossy(InputStream arg1, OutputStream arg2, TiffOutputSet arg3)
    throws ImageReadException, IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateExifMetadataLossy(byte[] arg1, OutputStream arg2, TiffOutputSet arg3)
    throws ImageReadException, IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class ExifOverflowException
    extends ImageWriteException
  {
    public ExifOverflowException(String paramString)
    {
      super();
    }
  }
  
  private static abstract class JFIFPiece
  {
    protected abstract void write(OutputStream paramOutputStream)
      throws IOException;
  }
  
  private static class JFIFPieceImageData
    extends ExifRewriter.JFIFPiece
  {
    public final byte[] imageData;
    public final InputStream isImageData;
    public final byte[] markerBytes;
    
    public JFIFPieceImageData(byte[] paramArrayOfByte, InputStream paramInputStream)
    {
      super();
      this.markerBytes = paramArrayOfByte;
      this.imageData = null;
      this.isImageData = paramInputStream;
    }
    
    public JFIFPieceImageData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      super();
      this.markerBytes = paramArrayOfByte1;
      this.imageData = paramArrayOfByte2;
      this.isImageData = null;
    }
    
    /* Error */
    protected void write(OutputStream arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  private static class JFIFPieceSegment
    extends ExifRewriter.JFIFPiece
  {
    public final int marker;
    public final byte[] markerBytes;
    public final byte[] markerLengthBytes;
    public final byte[] segmentData;
    
    public JFIFPieceSegment(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      super();
      this.marker = paramInt;
      this.markerBytes = paramArrayOfByte1;
      this.markerLengthBytes = paramArrayOfByte2;
      this.segmentData = paramArrayOfByte3;
    }
    
    /* Error */
    protected void write(OutputStream arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private static class JFIFPieceSegmentExif
    extends ExifRewriter.JFIFPieceSegment
  {
    public JFIFPieceSegmentExif(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      super(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
    }
  }
  
  private static class JFIFPieces
  {
    public final List exifPieces;
    public final List pieces;
    
    public JFIFPieces(List paramList1, List paramList2)
    {
      this.pieces = paramList1;
      this.exifPieces = paramList2;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\jpeg\exifRewrite\ExifRewriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */