package dji.thirdparty.sanselan.formats.tiff.write;

import dji.thirdparty.sanselan.ImageWriteException;
import dji.thirdparty.sanselan.formats.tiff.constants.TagInfo;
import dji.thirdparty.sanselan.formats.tiff.constants.TiffConstants;
import dji.thirdparty.sanselan.util.Debug;
import java.util.ArrayList;
import java.util.List;

public final class TiffOutputSet
  implements TiffConstants
{
  private static final String newline = System.getProperty("line.separator");
  public final int byteOrder;
  private final ArrayList directories = new ArrayList();
  
  public TiffOutputSet()
  {
    this(73);
  }
  
  public TiffOutputSet(int paramInt)
  {
    this.byteOrder = paramInt;
  }
  
  /* Error */
  public void addDirectory(TiffOutputDirectory arg1)
    throws ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public TiffOutputDirectory addExifDirectory()
    throws ImageWriteException
  {
    return null;
  }
  
  public TiffOutputDirectory addGPSDirectory()
    throws ImageWriteException
  {
    return null;
  }
  
  public TiffOutputDirectory addInteroperabilityDirectory()
    throws ImageWriteException
  {
    return null;
  }
  
  public TiffOutputDirectory addRootDirectory()
    throws ImageWriteException
  {
    return null;
  }
  
  public void dump()
  {
    Debug.debug(toString());
  }
  
  public TiffOutputDirectory findDirectory(int paramInt)
  {
    return null;
  }
  
  public TiffOutputField findField(int paramInt)
  {
    return null;
  }
  
  public TiffOutputField findField(TagInfo paramTagInfo)
  {
    return findField(paramTagInfo.tag);
  }
  
  public List getDirectories()
  {
    return new ArrayList(this.directories);
  }
  
  public TiffOutputDirectory getExifDirectory()
  {
    return findDirectory(-2);
  }
  
  public TiffOutputDirectory getGPSDirectory()
  {
    return findDirectory(-3);
  }
  
  public TiffOutputDirectory getInteroperabilityDirectory()
  {
    return findDirectory(-4);
  }
  
  public TiffOutputDirectory getOrCreateExifDirectory()
    throws ImageWriteException
  {
    return null;
  }
  
  public TiffOutputDirectory getOrCreateGPSDirectory()
    throws ImageWriteException
  {
    return null;
  }
  
  public TiffOutputDirectory getOrCreateRootDirectory()
    throws ImageWriteException
  {
    return null;
  }
  
  protected List getOutputItems(TiffOutputSummary paramTiffOutputSummary)
    throws ImageWriteException
  {
    return null;
  }
  
  public TiffOutputDirectory getRootDirectory()
  {
    return findDirectory(0);
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
  
  /* Error */
  public void setGPSInDegrees(double arg1, double arg3)
    throws ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\write\TiffOutputSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */