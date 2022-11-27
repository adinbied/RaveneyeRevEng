package dji.thirdparty.sanselan.formats.tiff.write;

import dji.thirdparty.sanselan.formats.tiff.constants.TiffConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class TiffOutputSummary
  implements TiffConstants
{
  public final int byteOrder;
  public final Map directoryTypeMap;
  private List imageDataItems = new ArrayList();
  private List offsetItems = new ArrayList();
  public final TiffOutputDirectory rootDirectory;
  
  public TiffOutputSummary(int paramInt, TiffOutputDirectory paramTiffOutputDirectory, Map paramMap)
  {
    this.byteOrder = paramInt;
    this.rootDirectory = paramTiffOutputDirectory;
    this.directoryTypeMap = paramMap;
  }
  
  /* Error */
  public void add(TiffOutputItem arg1, TiffOutputField arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void addTiffImageData(ImageDataOffsets paramImageDataOffsets)
  {
    this.imageDataItems.add(paramImageDataOffsets);
  }
  
  /* Error */
  public void updateOffsets(int arg1)
    throws dji.thirdparty.sanselan.ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private static class OffsetItem
  {
    public final TiffOutputItem item;
    public final TiffOutputField itemOffsetField;
    
    public OffsetItem(TiffOutputItem paramTiffOutputItem, TiffOutputField paramTiffOutputField)
    {
      this.itemOffsetField = paramTiffOutputField;
      this.item = paramTiffOutputItem;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\write\TiffOutputSummary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */