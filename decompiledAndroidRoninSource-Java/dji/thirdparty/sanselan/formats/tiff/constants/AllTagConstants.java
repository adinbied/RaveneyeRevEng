package dji.thirdparty.sanselan.formats.tiff.constants;

import dji.thirdparty.sanselan.SanselanConstants;

public abstract interface AllTagConstants
  extends SanselanConstants, TiffTagConstants, ExifTagConstants, GPSTagConstants
{
  public static final TagInfo[] ALL_TAGS = TagConstantsUtils.mergeTagLists(new TagInfo[][] { ALL_TIFF_TAGS, ALL_EXIF_TAGS, ALL_GPS_TAGS });
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\constants\AllTagConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */