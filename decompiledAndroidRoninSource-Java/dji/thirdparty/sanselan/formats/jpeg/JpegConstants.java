package dji.thirdparty.sanselan.formats.jpeg;

public abstract interface JpegConstants
{
  public static final byte[] CONST_8BIM = { 56, 66, 73, 77 };
  public static final byte[] EOI;
  public static final byte[] EXIF_IDENTIFIER_CODE;
  public static final byte[] JFIF0_SIGNATURE = { 74, 70, 73, 70, 0 };
  public static final byte[] JFIF0_SIGNATURE_ALTERNATIVE = { 74, 70, 73, 70, 32 };
  public static final int JFIFMarker = 65504;
  public static final int JPEG_APP0 = 224;
  public static final int JPEG_APP0_Marker = 65504;
  public static final int JPEG_APP13_Marker = 65517;
  public static final int JPEG_APP14_Marker = 65518;
  public static final int JPEG_APP15_Marker = 65519;
  public static final int JPEG_APP1_Marker = 65505;
  public static final int JPEG_APP2_Marker = 65506;
  public static final int[] MARKERS;
  public static final int MAX_SEGMENT_SIZE = 65535;
  public static final byte[] PHOTOSHOP_IDENTIFICATION_STRING;
  public static final int SOF0Marker = 65472;
  public static final int SOF10Marker = 65482;
  public static final int SOF11Marker = 65483;
  public static final int SOF12Marker = 65484;
  public static final int SOF13Marker = 65485;
  public static final int SOF14Marker = 65486;
  public static final int SOF15Marker = 65487;
  public static final int SOF1Marker = 65473;
  public static final int SOF2Marker = 65474;
  public static final int SOF3Marker = 65475;
  public static final int SOF4Marker = 65476;
  public static final int SOF5Marker = 65477;
  public static final int SOF6Marker = 65478;
  public static final int SOF7Marker = 65479;
  public static final int SOF8Marker = 65480;
  public static final int SOF9Marker = 65481;
  public static final byte[] SOI;
  public static final int SOS_Marker = 65498;
  public static final byte[] XMP_IDENTIFIER;
  public static final byte[] icc_profile_label;
  
  static
  {
    EXIF_IDENTIFIER_CODE = new byte[] { 69, 120, 105, 102 };
    XMP_IDENTIFIER = new byte[] { 104, 116, 116, 112, 58, 47, 47, 110, 115, 46, 97, 100, 111, 98, 101, 46, 99, 111, 109, 47, 120, 97, 112, 47, 49, 46, 48, 47, 0 };
    SOI = new byte[] { -1, -40 };
    EOI = new byte[] { -1, -39 };
    MARKERS = new int[] { 65498, 224, 65504, 65505, 65506, 65517, 65518, 65519, 65504, 65472, 65473, 65474, 65475, 65476, 65477, 65478, 65479, 65480, 65481, 65482, 65483, 65484, 65485, 65486, 65487 };
    icc_profile_label = new byte[] { 73, 67, 67, 95, 80, 82, 79, 70, 73, 76, 69, 0 };
    PHOTOSHOP_IDENTIFICATION_STRING = new byte[] { 80, 104, 111, 116, 111, 115, 104, 111, 112, 32, 51, 46, 48, 0 };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\jpeg\JpegConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */