package dji.thirdparty.sanselan.formats.tiff.write;

import dji.thirdparty.sanselan.ImageWriteException;
import dji.thirdparty.sanselan.formats.tiff.TiffElement;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.List;

public class TiffImageWriterLossless
  extends TiffImageWriterBase
{
  private static final Comparator ELEMENT_SIZE_COMPARATOR = new Comparator()
  {
    public int compare(Object paramAnonymousObject1, Object paramAnonymousObject2)
    {
      paramAnonymousObject1 = (TiffElement)paramAnonymousObject1;
      paramAnonymousObject2 = (TiffElement)paramAnonymousObject2;
      return ((TiffElement)paramAnonymousObject1).length - ((TiffElement)paramAnonymousObject2).length;
    }
  };
  private static final Comparator ITEM_SIZE_COMPARATOR = new Comparator()
  {
    public int compare(Object paramAnonymousObject1, Object paramAnonymousObject2)
    {
      paramAnonymousObject1 = (TiffOutputItem)paramAnonymousObject1;
      paramAnonymousObject2 = (TiffOutputItem)paramAnonymousObject2;
      return ((TiffOutputItem)paramAnonymousObject1).getItemLength() - ((TiffOutputItem)paramAnonymousObject2).getItemLength();
    }
  };
  private final byte[] exifBytes;
  
  public TiffImageWriterLossless(int paramInt, byte[] paramArrayOfByte)
  {
    super(paramInt);
    this.exifBytes = paramArrayOfByte;
  }
  
  public TiffImageWriterLossless(byte[] paramArrayOfByte)
  {
    this.exifBytes = paramArrayOfByte;
  }
  
  private List analyzeOldTiff()
    throws ImageWriteException, IOException
  {
    return null;
  }
  
  /* Error */
  private void dumpElements(dji.thirdparty.sanselan.common.byteSources.ByteSource arg1, List arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void dumpElements(List arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private int updateOffsetsStep(List paramList1, List paramList2)
    throws IOException, ImageWriteException
  {
    return 0;
  }
  
  /* Error */
  private void writeStep(OutputStream arg1, TiffOutputSet arg2, List arg3, List arg4, int arg5)
    throws IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void write(OutputStream arg1, TiffOutputSet arg2)
    throws IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static class BufferOutputStream
    extends OutputStream
  {
    private final byte[] buffer;
    private int index;
    
    public BufferOutputStream(byte[] paramArrayOfByte, int paramInt)
    {
      this.buffer = paramArrayOfByte;
      this.index = paramInt;
    }
    
    /* Error */
    public void write(int arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void write(byte[] arg1, int arg2, int arg3)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\write\TiffImageWriterLossless.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */