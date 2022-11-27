package dji.thirdparty.sanselan.formats.tiff.write;

import dji.thirdparty.sanselan.ImageWriteException;
import dji.thirdparty.sanselan.formats.tiff.JpegImageData;
import dji.thirdparty.sanselan.formats.tiff.TiffDirectory;
import dji.thirdparty.sanselan.formats.tiff.constants.TagInfo;
import dji.thirdparty.sanselan.formats.tiff.constants.TiffConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class TiffOutputDirectory
  extends TiffOutputItem
  implements TiffConstants
{
  private final ArrayList fields = new ArrayList();
  private JpegImageData jpegImageData = null;
  private TiffOutputDirectory nextDirectory = null;
  public final int type;
  
  public TiffOutputDirectory(int paramInt)
  {
    this.type = paramInt;
  }
  
  /* Error */
  private void removeFieldIfPresent(TagInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void add(TiffOutputField paramTiffOutputField)
  {
    this.fields.add(paramTiffOutputField);
  }
  
  public String description()
  {
    return TiffDirectory.description(this.type);
  }
  
  public TiffOutputField findField(int paramInt)
  {
    return null;
  }
  
  public TiffOutputField findField(TagInfo paramTagInfo)
  {
    return findField(paramTagInfo.tag);
  }
  
  public ArrayList getFields()
  {
    return new ArrayList(this.fields);
  }
  
  public String getItemDescription()
  {
    return null;
  }
  
  public int getItemLength()
  {
    return 0;
  }
  
  protected List getOutputItems(TiffOutputSummary paramTiffOutputSummary)
    throws ImageWriteException
  {
    return null;
  }
  
  public JpegImageData getRawJpegImageData()
  {
    return this.jpegImageData;
  }
  
  /* Error */
  public void removeField(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void removeField(TagInfo paramTagInfo)
  {
    removeField(paramTagInfo.tag);
  }
  
  public void setJpegImageData(JpegImageData paramJpegImageData)
  {
    this.jpegImageData = paramJpegImageData;
  }
  
  public void setNextDirectory(TiffOutputDirectory paramTiffOutputDirectory)
  {
    this.nextDirectory = paramTiffOutputDirectory;
  }
  
  /* Error */
  public void sortFields()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void writeItem(dji.thirdparty.sanselan.common.BinaryOutputStream arg1)
    throws java.io.IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\write\TiffOutputDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */