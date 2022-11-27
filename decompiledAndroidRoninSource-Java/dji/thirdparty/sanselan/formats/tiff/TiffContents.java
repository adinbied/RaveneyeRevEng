package dji.thirdparty.sanselan.formats.tiff;

import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.formats.tiff.constants.TagInfo;
import java.util.ArrayList;

public class TiffContents
{
  public final ArrayList directories;
  public final TiffHeader header;
  
  public TiffContents(TiffHeader paramTiffHeader, ArrayList paramArrayList)
  {
    this.header = paramTiffHeader;
    this.directories = paramArrayList;
  }
  
  /* Error */
  public void dissect(boolean arg1)
    throws ImageReadException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public TiffField findField(TagInfo paramTagInfo)
    throws ImageReadException
  {
    return null;
  }
  
  public ArrayList getElements()
    throws ImageReadException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\TiffContents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */