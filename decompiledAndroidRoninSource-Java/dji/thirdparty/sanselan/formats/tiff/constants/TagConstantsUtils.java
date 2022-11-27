package dji.thirdparty.sanselan.formats.tiff.constants;

public class TagConstantsUtils
  implements TiffDirectoryConstants
{
  public static TiffDirectoryConstants.ExifDirectoryType getExifDirectoryType(int paramInt)
  {
    int i = 0;
    while (i < EXIF_DIRECTORIES.length)
    {
      if (EXIF_DIRECTORIES[i].directoryType == paramInt) {
        return EXIF_DIRECTORIES[i];
      }
      i += 1;
    }
    return EXIF_DIRECTORY_UNKNOWN;
  }
  
  public static TagInfo[] mergeTagLists(TagInfo[][] paramArrayOfTagInfo)
  {
    int i = 0;
    int j = 0;
    while (i < paramArrayOfTagInfo.length)
    {
      j += paramArrayOfTagInfo[i].length;
      i += 1;
    }
    TagInfo[] arrayOfTagInfo = new TagInfo[j];
    i = 0;
    j = 0;
    while (i < paramArrayOfTagInfo.length)
    {
      System.arraycopy(paramArrayOfTagInfo[i], 0, arrayOfTagInfo, j, paramArrayOfTagInfo[i].length);
      j += paramArrayOfTagInfo[i].length;
      i += 1;
    }
    return arrayOfTagInfo;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\constants\TagConstantsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */