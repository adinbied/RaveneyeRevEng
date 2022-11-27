package dji.thirdparty.sanselan.formats.tiff;

import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.formats.tiff.constants.TagInfo;
import dji.thirdparty.sanselan.formats.tiff.constants.TiffConstants;
import java.util.ArrayList;

public class TiffDirectory
  extends TiffElement
  implements TiffConstants
{
  public final ArrayList entries;
  private JpegImageData jpegImageData = null;
  public final int nextDirectoryOffset;
  public final int type;
  
  public TiffDirectory(int paramInt1, ArrayList paramArrayList, int paramInt2, int paramInt3)
  {
    super(paramInt2, paramArrayList.size() * 12 + 2 + 4);
    this.type = paramInt1;
    this.entries = paramArrayList;
    this.nextDirectoryOffset = paramInt3;
  }
  
  public static final String description(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Bad Type";
    case 2: 
      return "Thumbnail";
    case 1: 
      return "Sub";
    case 0: 
      return "Root";
    case -1: 
      return "Unknown";
    case -2: 
      return "Exif";
    case -3: 
      return "Gps";
    }
    return "Interoperability";
  }
  
  private ArrayList getRawImageDataElements(TiffField paramTiffField1, TiffField paramTiffField2)
    throws ImageReadException
  {
    return null;
  }
  
  public String description()
  {
    return description(this.type);
  }
  
  /* Error */
  public void dump()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void fillInValues(dji.thirdparty.sanselan.common.byteSources.ByteSource arg1)
    throws ImageReadException, java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public TiffField findField(TagInfo paramTagInfo)
    throws ImageReadException
  {
    return findField(paramTagInfo, false);
  }
  
  public TiffField findField(TagInfo paramTagInfo, boolean paramBoolean)
    throws ImageReadException
  {
    return null;
  }
  
  public ArrayList getDirectoryEntrys()
  {
    return new ArrayList(this.entries);
  }
  
  public String getElementDescription(boolean paramBoolean)
  {
    return null;
  }
  
  public JpegImageData getJpegImageData()
  {
    return this.jpegImageData;
  }
  
  public ImageDataElement getJpegRawImageDataElement()
    throws ImageReadException
  {
    return null;
  }
  
  public ArrayList getTiffRawImageDataElements()
    throws ImageReadException
  {
    return null;
  }
  
  public boolean hasJpegImageData()
    throws ImageReadException
  {
    return false;
  }
  
  public boolean hasTiffImageData()
    throws ImageReadException
  {
    return false;
  }
  
  public boolean imageDataInStrips()
    throws ImageReadException
  {
    return false;
  }
  
  public void setJpegImageData(JpegImageData paramJpegImageData)
  {
    this.jpegImageData = paramJpegImageData;
  }
  
  public final class ImageDataElement
    extends TiffElement
  {
    public ImageDataElement(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public String getElementDescription(boolean paramBoolean)
    {
      if (paramBoolean) {
        return null;
      }
      return "ImageDataElement";
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\TiffDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */