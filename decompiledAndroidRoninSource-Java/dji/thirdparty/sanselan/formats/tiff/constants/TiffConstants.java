package dji.thirdparty.sanselan.formats.tiff.constants;

import dji.thirdparty.sanselan.SanselanConstants;
import dji.thirdparty.sanselan.common.BinaryConstants;

public abstract interface TiffConstants
  extends SanselanConstants, TiffFieldTypeConstants, TiffDirectoryConstants, AllTagConstants, BinaryConstants
{
  public static final int DEFAULT_TIFF_BYTE_ORDER = 73;
  public static final int TIFF_COMPRESSION_CCITT_1D = 2;
  public static final int TIFF_COMPRESSION_CCITT_GROUP_3 = 3;
  public static final int TIFF_COMPRESSION_CCITT_GROUP_4 = 4;
  public static final int TIFF_COMPRESSION_JPEG = 6;
  public static final int TIFF_COMPRESSION_LZW = 5;
  public static final int TIFF_COMPRESSION_PACKBITS = 32773;
  public static final int TIFF_COMPRESSION_UNCOMPRESSED = 1;
  public static final int TIFF_COMPRESSION_UNCOMPRESSED_1 = 1;
  public static final int TIFF_COMPRESSION_UNCOMPRESSED_2 = 32771;
  public static final int TIFF_DIRECTORY_FOOTER_LENGTH = 4;
  public static final int TIFF_DIRECTORY_HEADER_LENGTH = 2;
  public static final int TIFF_ENTRY_LENGTH = 12;
  public static final int TIFF_ENTRY_MAX_VALUE_LENGTH = 4;
  public static final int TIFF_HEADER_SIZE = 8;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\constants\TiffConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */