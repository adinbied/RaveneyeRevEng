package dji.thirdparty.sanselan.formats.tiff;

import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.ImageWriteException;
import dji.thirdparty.sanselan.common.IImageMetadata.IImageMetadataItem;
import dji.thirdparty.sanselan.common.ImageMetadata;
import dji.thirdparty.sanselan.common.ImageMetadata.Item;
import dji.thirdparty.sanselan.common.RationalNumber;
import dji.thirdparty.sanselan.formats.tiff.constants.TagInfo;
import dji.thirdparty.sanselan.formats.tiff.constants.TiffDirectoryConstants;
import dji.thirdparty.sanselan.formats.tiff.write.TiffOutputDirectory;
import dji.thirdparty.sanselan.formats.tiff.write.TiffOutputSet;
import java.util.ArrayList;
import java.util.List;

public class TiffImageMetadata
  extends ImageMetadata
  implements TiffDirectoryConstants
{
  public final TiffContents contents;
  
  public TiffImageMetadata(TiffContents paramTiffContents)
  {
    this.contents = paramTiffContents;
  }
  
  public TiffDirectory findDirectory(int paramInt)
  {
    return null;
  }
  
  public TiffField findField(TagInfo paramTagInfo)
    throws ImageReadException
  {
    return null;
  }
  
  public List getAllFields()
    throws ImageReadException
  {
    return null;
  }
  
  public ArrayList getDirectories()
  {
    return super.getItems();
  }
  
  public GPSInfo getGPS()
    throws ImageReadException
  {
    return null;
  }
  
  public ArrayList getItems()
  {
    return null;
  }
  
  public TiffOutputSet getOutputSet()
    throws ImageWriteException
  {
    return null;
  }
  
  public static class Directory
    extends ImageMetadata
    implements IImageMetadata.IImageMetadataItem
  {
    private final TiffDirectory directory;
    public final int type;
    
    public Directory(TiffDirectory paramTiffDirectory)
    {
      this.type = paramTiffDirectory.type;
      this.directory = paramTiffDirectory;
    }
    
    /* Error */
    public void add(TiffField arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public TiffField findField(TagInfo paramTagInfo)
      throws ImageReadException
    {
      return this.directory.findField(paramTagInfo);
    }
    
    public List getAllFields()
      throws ImageReadException
    {
      return this.directory.getDirectoryEntrys();
    }
    
    public JpegImageData getJpegImageData()
    {
      return this.directory.getJpegImageData();
    }
    
    public TiffOutputDirectory getOutputDirectory(int paramInt)
      throws ImageWriteException
    {
      return null;
    }
    
    public String toString(String paramString)
    {
      return null;
    }
  }
  
  public static class GPSInfo
  {
    public final RationalNumber latitudeDegrees;
    public final RationalNumber latitudeMinutes;
    public final String latitudeRef;
    public final RationalNumber latitudeSeconds;
    public final RationalNumber longitudeDegrees;
    public final RationalNumber longitudeMinutes;
    public final String longitudeRef;
    public final RationalNumber longitudeSeconds;
    
    public GPSInfo(String paramString1, String paramString2, RationalNumber paramRationalNumber1, RationalNumber paramRationalNumber2, RationalNumber paramRationalNumber3, RationalNumber paramRationalNumber4, RationalNumber paramRationalNumber5, RationalNumber paramRationalNumber6)
    {
      this.latitudeRef = paramString1;
      this.longitudeRef = paramString2;
      this.latitudeDegrees = paramRationalNumber1;
      this.latitudeMinutes = paramRationalNumber2;
      this.latitudeSeconds = paramRationalNumber3;
      this.longitudeDegrees = paramRationalNumber4;
      this.longitudeMinutes = paramRationalNumber5;
      this.longitudeSeconds = paramRationalNumber6;
    }
    
    public double getLatitudeAsDegreesNorth()
      throws ImageReadException
    {
      return 1.372342103E-315D;
    }
    
    public double getLongitudeAsDegreesEast()
      throws ImageReadException
    {
      return 1.372342163E-315D;
    }
    
    public String toString()
    {
      return null;
    }
  }
  
  public static class Item
    extends ImageMetadata.Item
  {
    private final TiffField entry;
    
    public Item(TiffField paramTiffField)
    {
      super(paramTiffField.getValueDescription());
      this.entry = paramTiffField;
    }
    
    public TiffField getTiffField()
    {
      return this.entry;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\TiffImageMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */