package dji.thirdparty.sanselan.formats.jpeg;

import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.common.IImageMetadata;
import dji.thirdparty.sanselan.formats.tiff.TiffField;
import dji.thirdparty.sanselan.formats.tiff.TiffImageMetadata;
import dji.thirdparty.sanselan.formats.tiff.constants.TagInfo;
import dji.thirdparty.sanselan.util.Debug;
import java.io.IOException;
import java.util.ArrayList;

public class JpegImageMetadata
  implements IImageMetadata
{
  private static final String newline = System.getProperty("line.separator");
  private final TiffImageMetadata exif;
  
  public JpegImageMetadata(Object paramObject, TiffImageMetadata paramTiffImageMetadata)
  {
    this.exif = paramTiffImageMetadata;
  }
  
  public void dump()
  {
    Debug.debug(toString());
  }
  
  public TiffField findEXIFValue(TagInfo paramTagInfo)
  {
    return null;
  }
  
  public Object getEXIFThumbnail()
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public TiffImageMetadata getExif()
  {
    return this.exif;
  }
  
  public ArrayList getItems()
  {
    return null;
  }
  
  public String toString()
  {
    return toString(null);
  }
  
  public String toString(String paramString)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\jpeg\JpegImageMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */