package dji.thirdparty.sanselan.formats.tiff.write;

import dji.thirdparty.sanselan.formats.tiff.TiffElement.DataElement;

class ImageDataOffsets
{
  public final int[] imageDataOffsets;
  public final TiffOutputField imageDataOffsetsField;
  public final TiffOutputItem[] outputItems;
  
  public ImageDataOffsets(TiffElement.DataElement[] paramArrayOfDataElement, int[] paramArrayOfInt, TiffOutputField paramTiffOutputField)
  {
    this.imageDataOffsets = paramArrayOfInt;
    this.imageDataOffsetsField = paramTiffOutputField;
    this.outputItems = new TiffOutputItem[paramArrayOfDataElement.length];
    int i = 0;
    while (i < paramArrayOfDataElement.length)
    {
      paramArrayOfInt = new TiffOutputItem.Value("TIFF image data", paramArrayOfDataElement[i].data);
      this.outputItems[i] = paramArrayOfInt;
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\write\ImageDataOffsets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */