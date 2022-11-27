package dji.thirdparty.sanselan.formats.tiff.constants;

public abstract interface TiffTagConstants
  extends TiffDirectoryConstants, TiffFieldTypeConstants
{
  public static final TagInfo[] ALL_TIFF_TAGS = { TIFF_TAG_NEW_SUBFILE_TYPE, TIFF_TAG_SUBFILE_TYPE, TIFF_TAG_IMAGE_WIDTH, TIFF_TAG_IMAGE_LENGTH, TIFF_TAG_BITS_PER_SAMPLE, TIFF_TAG_COMPRESSION, TIFF_TAG_PHOTOMETRIC_INTERPRETATION, TIFF_TAG_THRESHHOLDING, TIFF_TAG_CELL_WIDTH, TIFF_TAG_CELL_LENGTH, TIFF_TAG_FILL_ORDER, TIFF_TAG_DOCUMENT_NAME, TIFF_TAG_IMAGE_DESCRIPTION, TIFF_TAG_MAKE, TIFF_TAG_MODEL, TIFF_TAG_STRIP_OFFSETS, TIFF_TAG_ORIENTATION, TIFF_TAG_SAMPLES_PER_PIXEL, TIFF_TAG_ROWS_PER_STRIP, TIFF_TAG_STRIP_BYTE_COUNTS, TIFF_TAG_MIN_SAMPLE_VALUE, TIFF_TAG_MAX_SAMPLE_VALUE, TIFF_TAG_XRESOLUTION, TIFF_TAG_YRESOLUTION, TIFF_TAG_PLANAR_CONFIGURATION, TIFF_TAG_PAGE_NAME, TIFF_TAG_XPOSITION, TIFF_TAG_YPOSITION, TIFF_TAG_FREE_OFFSETS, TIFF_TAG_FREE_BYTE_COUNTS, TIFF_TAG_GRAY_RESPONSE_UNIT, TIFF_TAG_GRAY_RESPONSE_CURVE, TIFF_TAG_T4_OPTIONS, TIFF_TAG_T6_OPTIONS, TIFF_TAG_RESOLUTION_UNIT, TIFF_TAG_PAGE_NUMBER, TIFF_TAG_TRANSFER_FUNCTION, TIFF_TAG_SOFTWARE, TIFF_TAG_DATE_TIME, TIFF_TAG_ARTIST, TIFF_TAG_HOST_COMPUTER, TIFF_TAG_PREDICTOR, TIFF_TAG_WHITE_POINT, TIFF_TAG_PRIMARY_CHROMATICITIES, TIFF_TAG_COLOR_MAP, TIFF_TAG_HALFTONE_HINTS, TIFF_TAG_TILE_WIDTH, TIFF_TAG_TILE_LENGTH, TIFF_TAG_TILE_OFFSETS, TIFF_TAG_TILE_BYTE_COUNTS, TIFF_TAG_INK_SET, TIFF_TAG_INK_NAMES, TIFF_TAG_NUMBER_OF_INKS, TIFF_TAG_DOT_RANGE, TIFF_TAG_TARGET_PRINTER, TIFF_TAG_EXTRA_SAMPLES, TIFF_TAG_SAMPLE_FORMAT, TIFF_TAG_SMIN_SAMPLE_VALUE, TIFF_TAG_SMAX_SAMPLE_VALUE, TIFF_TAG_TRANSFER_RANGE, TIFF_TAG_JPEG_PROC, TIFF_TAG_JPEG_INTERCHANGE_FORMAT, TIFF_TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, TIFF_TAG_JPEG_RESTART_INTERVAL, TIFF_TAG_JPEG_LOSSLESS_PREDICTORS, TIFF_TAG_JPEG_POINT_TRANSFORMS, TIFF_TAG_JPEG_QTABLES, TIFF_TAG_JPEG_DCTABLES, TIFF_TAG_JPEG_ACTABLES, TIFF_TAG_YCBCR_COEFFICIENTS, TIFF_TAG_YCBCR_SUB_SAMPLING, TIFF_TAG_YCBCR_POSITIONING, TIFF_TAG_REFERENCE_BLACK_WHITE, TIFF_TAG_COPYRIGHT, TIFF_TAG_XMP };
  public static final TagInfo TIFF_TAG_ARTIST;
  public static final TagInfo TIFF_TAG_BITS_PER_SAMPLE;
  public static final TagInfo TIFF_TAG_CELL_LENGTH;
  public static final TagInfo TIFF_TAG_CELL_WIDTH;
  public static final TagInfo TIFF_TAG_COLOR_MAP;
  public static final TagInfo TIFF_TAG_COMPRESSION;
  public static final TagInfo TIFF_TAG_COPYRIGHT;
  public static final TagInfo TIFF_TAG_DATE_TIME;
  public static final TagInfo TIFF_TAG_DOCUMENT_NAME;
  public static final TagInfo TIFF_TAG_DOT_RANGE;
  public static final TagInfo TIFF_TAG_EXTRA_SAMPLES;
  public static final TagInfo TIFF_TAG_FILL_ORDER;
  public static final TagInfo TIFF_TAG_FREE_BYTE_COUNTS;
  public static final TagInfo TIFF_TAG_FREE_OFFSETS;
  public static final TagInfo TIFF_TAG_GRAY_RESPONSE_CURVE;
  public static final TagInfo TIFF_TAG_GRAY_RESPONSE_UNIT;
  public static final TagInfo TIFF_TAG_HALFTONE_HINTS;
  public static final TagInfo TIFF_TAG_HOST_COMPUTER;
  public static final TagInfo TIFF_TAG_IMAGE_DESCRIPTION;
  public static final TagInfo TIFF_TAG_IMAGE_LENGTH;
  public static final TagInfo TIFF_TAG_IMAGE_WIDTH;
  public static final TagInfo TIFF_TAG_INK_NAMES;
  public static final TagInfo TIFF_TAG_INK_SET;
  public static final TagInfo TIFF_TAG_JPEG_ACTABLES;
  public static final TagInfo TIFF_TAG_JPEG_DCTABLES;
  public static final TagInfo TIFF_TAG_JPEG_INTERCHANGE_FORMAT;
  public static final TagInfo TIFF_TAG_JPEG_INTERCHANGE_FORMAT_LENGTH;
  public static final TagInfo TIFF_TAG_JPEG_LOSSLESS_PREDICTORS;
  public static final TagInfo TIFF_TAG_JPEG_POINT_TRANSFORMS;
  public static final TagInfo TIFF_TAG_JPEG_PROC;
  public static final TagInfo TIFF_TAG_JPEG_QTABLES;
  public static final TagInfo TIFF_TAG_JPEG_RESTART_INTERVAL;
  public static final TagInfo TIFF_TAG_MAKE;
  public static final TagInfo TIFF_TAG_MAX_SAMPLE_VALUE;
  public static final TagInfo TIFF_TAG_MIN_SAMPLE_VALUE;
  public static final TagInfo TIFF_TAG_MODEL;
  public static final TagInfo TIFF_TAG_NEW_SUBFILE_TYPE = new TagInfo("New Subfile Type", 254, FIELD_TYPE_DESCRIPTION_LONG, 1, TIFF_DIRECTORY_ROOT);
  public static final TagInfo TIFF_TAG_NUMBER_OF_INKS;
  public static final TagInfo TIFF_TAG_ORIENTATION;
  public static final TagInfo TIFF_TAG_PAGE_NAME;
  public static final TagInfo TIFF_TAG_PAGE_NUMBER;
  public static final TagInfo TIFF_TAG_PHOTOMETRIC_INTERPRETATION;
  public static final TagInfo TIFF_TAG_PLANAR_CONFIGURATION;
  public static final TagInfo TIFF_TAG_PREDICTOR;
  public static final TagInfo TIFF_TAG_PRIMARY_CHROMATICITIES;
  public static final TagInfo TIFF_TAG_REFERENCE_BLACK_WHITE;
  public static final TagInfo TIFF_TAG_RESOLUTION_UNIT;
  public static final TagInfo TIFF_TAG_ROWS_PER_STRIP;
  public static final TagInfo TIFF_TAG_SAMPLES_PER_PIXEL;
  public static final TagInfo TIFF_TAG_SAMPLE_FORMAT;
  public static final TagInfo TIFF_TAG_SMAX_SAMPLE_VALUE;
  public static final TagInfo TIFF_TAG_SMIN_SAMPLE_VALUE;
  public static final TagInfo TIFF_TAG_SOFTWARE;
  public static final TagInfo TIFF_TAG_STRIP_BYTE_COUNTS;
  public static final TagInfo TIFF_TAG_STRIP_OFFSETS;
  public static final TagInfo TIFF_TAG_SUBFILE_TYPE = new TagInfo("Subfile Type", 255, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
  public static final TagInfo TIFF_TAG_T4_OPTIONS;
  public static final TagInfo TIFF_TAG_T6_OPTIONS;
  public static final TagInfo TIFF_TAG_TARGET_PRINTER;
  public static final TagInfo TIFF_TAG_THRESHHOLDING;
  public static final TagInfo TIFF_TAG_TILE_BYTE_COUNTS;
  public static final TagInfo TIFF_TAG_TILE_LENGTH;
  public static final TagInfo TIFF_TAG_TILE_OFFSETS;
  public static final TagInfo TIFF_TAG_TILE_WIDTH;
  public static final TagInfo TIFF_TAG_TRANSFER_FUNCTION;
  public static final TagInfo TIFF_TAG_TRANSFER_RANGE;
  public static final TagInfo TIFF_TAG_UNKNOWN;
  public static final TagInfo TIFF_TAG_WHITE_POINT;
  public static final TagInfo TIFF_TAG_XMP;
  public static final TagInfo TIFF_TAG_XPOSITION;
  public static final TagInfo TIFF_TAG_XRESOLUTION;
  public static final TagInfo TIFF_TAG_YCBCR_COEFFICIENTS;
  public static final TagInfo TIFF_TAG_YCBCR_POSITIONING;
  public static final TagInfo TIFF_TAG_YCBCR_SUB_SAMPLING;
  public static final TagInfo TIFF_TAG_YPOSITION;
  public static final TagInfo TIFF_TAG_YRESOLUTION;
  
  static
  {
    TIFF_TAG_IMAGE_WIDTH = new TagInfo("Image Width", 256, FIELD_TYPE_DESCRIPTION_SHORT_OR_LONG, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_IMAGE_LENGTH = new TagInfo("Image Length", 257, FIELD_TYPE_DESCRIPTION_SHORT_OR_LONG, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_BITS_PER_SAMPLE = new TagInfo("Bits Per Sample", 258, FIELD_TYPE_DESCRIPTION_SHORT, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_COMPRESSION = new TagInfo("Compression", 259, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_PHOTOMETRIC_INTERPRETATION = new TagInfo("Photometric Interpretation", 262, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_THRESHHOLDING = new TagInfo("Threshholding", 263, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_CELL_WIDTH = new TagInfo("Cell Width", 264, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_CELL_LENGTH = new TagInfo("Cell Length", 265, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_FILL_ORDER = new TagInfo("Fill Order", 266, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_DOCUMENT_NAME = new TagInfo("Document Name", 269, FIELD_TYPE_DESCRIPTION_ASCII, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_IMAGE_DESCRIPTION = new TagInfo("Image Description", 270, FIELD_TYPE_DESCRIPTION_ASCII, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_MAKE = new TagInfo("Make", 271, FIELD_TYPE_DESCRIPTION_ASCII, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_MODEL = new TagInfo("Model", 272, FIELD_TYPE_DESCRIPTION_ASCII, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_STRIP_OFFSETS = new TagInfo.Offset("Strip Offsets", 273, FIELD_TYPE_DESCRIPTION_SHORT_OR_LONG, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_ORIENTATION = new TagInfo("Orientation", 274, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_SAMPLES_PER_PIXEL = new TagInfo("Samples Per Pixel", 277, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_ROWS_PER_STRIP = new TagInfo("Rows Per Strip", 278, FIELD_TYPE_DESCRIPTION_SHORT_OR_LONG, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_STRIP_BYTE_COUNTS = new TagInfo("Strip Byte Counts", 279, FIELD_TYPE_DESCRIPTION_LONG_OR_SHORT, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_MIN_SAMPLE_VALUE = new TagInfo("Min Sample Value", 280, FIELD_TYPE_DESCRIPTION_SHORT, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_MAX_SAMPLE_VALUE = new TagInfo("Max Sample Value", 281, FIELD_TYPE_DESCRIPTION_SHORT, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_XRESOLUTION = new TagInfo("XResolution", 282, FIELD_TYPE_DESCRIPTION_RATIONAL, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_YRESOLUTION = new TagInfo("YResolution", 283, FIELD_TYPE_DESCRIPTION_RATIONAL, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_PLANAR_CONFIGURATION = new TagInfo("Planar Configuration", 284, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_PAGE_NAME = new TagInfo("Page Name", 285, FIELD_TYPE_DESCRIPTION_ASCII, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_XPOSITION = new TagInfo("XPosition", 286, FIELD_TYPE_DESCRIPTION_RATIONAL, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_YPOSITION = new TagInfo("YPosition", 287, FIELD_TYPE_DESCRIPTION_RATIONAL, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_FREE_OFFSETS = new TagInfo("Free Offsets", 288, FIELD_TYPE_DESCRIPTION_LONG, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_FREE_BYTE_COUNTS = new TagInfo("Free Byte Counts", 289, FIELD_TYPE_DESCRIPTION_LONG, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_GRAY_RESPONSE_UNIT = new TagInfo("Gray Response Unit", 290, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_GRAY_RESPONSE_CURVE = new TagInfo("Gray Response Curve", 291, FIELD_TYPE_DESCRIPTION_SHORT, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_T4_OPTIONS = new TagInfo("T4 Options", 292, FIELD_TYPE_DESCRIPTION_LONG, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_T6_OPTIONS = new TagInfo("T6 Options", 293, FIELD_TYPE_DESCRIPTION_LONG, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_RESOLUTION_UNIT = new TagInfo("Resolution Unit", 296, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_PAGE_NUMBER = new TagInfo("Page Number", 297, FIELD_TYPE_DESCRIPTION_SHORT, 2, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_TRANSFER_FUNCTION = new TagInfo("Transfer Function", 301, FIELD_TYPE_DESCRIPTION_SHORT, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_SOFTWARE = new TagInfo("Software", 305, FIELD_TYPE_DESCRIPTION_ASCII, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_DATE_TIME = new TagInfo("Date Time", 306, FIELD_TYPE_DESCRIPTION_ASCII, 20, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_ARTIST = new TagInfo("Artist", 315, FIELD_TYPE_DESCRIPTION_ASCII, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_HOST_COMPUTER = new TagInfo("Host Computer", 316, FIELD_TYPE_DESCRIPTION_ASCII, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_PREDICTOR = new TagInfo("Predictor", 317, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_WHITE_POINT = new TagInfo("White Point", 318, FIELD_TYPE_DESCRIPTION_RATIONAL, 2, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_PRIMARY_CHROMATICITIES = new TagInfo("Primary Chromaticities", 319, FIELD_TYPE_DESCRIPTION_RATIONAL, 6, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_COLOR_MAP = new TagInfo("Color Map", 320, FIELD_TYPE_DESCRIPTION_SHORT, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_HALFTONE_HINTS = new TagInfo("Halftone Hints", 321, FIELD_TYPE_DESCRIPTION_SHORT, 2, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_TILE_WIDTH = new TagInfo("Tile Width", 322, FIELD_TYPE_DESCRIPTION_SHORT_OR_LONG, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_TILE_LENGTH = new TagInfo("Tile Length", 323, FIELD_TYPE_DESCRIPTION_SHORT_OR_LONG, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_TILE_OFFSETS = new TagInfo.Offset("Tile Offsets", 324, FIELD_TYPE_DESCRIPTION_LONG, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_TILE_BYTE_COUNTS = new TagInfo("Tile Byte Counts", 325, FIELD_TYPE_DESCRIPTION_SHORT_OR_LONG, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_INK_SET = new TagInfo("Ink Set", 332, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_INK_NAMES = new TagInfo("Ink Names", 333, FIELD_TYPE_DESCRIPTION_ASCII, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_NUMBER_OF_INKS = new TagInfo("Number Of Inks", 334, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_DOT_RANGE = new TagInfo("Dot Range", 336, FIELD_TYPE_DESCRIPTION_BYTE_OR_SHORT, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_TARGET_PRINTER = new TagInfo("Target Printer", 337, FIELD_TYPE_DESCRIPTION_ASCII, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_EXTRA_SAMPLES = new TagInfo("Extra Samples", 338, FIELD_TYPE_DESCRIPTION_BYTE, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_SAMPLE_FORMAT = new TagInfo("Sample Format", 339, FIELD_TYPE_DESCRIPTION_SHORT, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_SMIN_SAMPLE_VALUE = new TagInfo("SMin Sample Value", 340, FIELD_TYPE_DESCRIPTION_ANY, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_SMAX_SAMPLE_VALUE = new TagInfo("SMax Sample Value", 341, FIELD_TYPE_DESCRIPTION_ANY, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_TRANSFER_RANGE = new TagInfo("Transfer Range", 342, FIELD_TYPE_DESCRIPTION_SHORT, 6, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_JPEG_PROC = new TagInfo("JPEGProc", 512, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_JPEG_INTERCHANGE_FORMAT = new TagInfo.Offset("JPEGInterchange Format", 513, FIELD_TYPE_DESCRIPTION_LONG, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = new TagInfo("JPEGInterchange Format Length", 514, FIELD_TYPE_DESCRIPTION_LONG, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_JPEG_RESTART_INTERVAL = new TagInfo("JPEGRestart Interval", 515, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_JPEG_LOSSLESS_PREDICTORS = new TagInfo("JPEGLossless Predictors", 517, FIELD_TYPE_DESCRIPTION_SHORT, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_JPEG_POINT_TRANSFORMS = new TagInfo("JPEGPoint Transforms", 518, FIELD_TYPE_DESCRIPTION_SHORT, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_JPEG_QTABLES = new TagInfo("JPEGQTables", 519, FIELD_TYPE_DESCRIPTION_LONG, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_JPEG_DCTABLES = new TagInfo("JPEGDCTables", 520, FIELD_TYPE_DESCRIPTION_LONG, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_JPEG_ACTABLES = new TagInfo("JPEGACTables", 521, FIELD_TYPE_DESCRIPTION_LONG, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_YCBCR_COEFFICIENTS = new TagInfo("YCbCr Coefficients", 529, FIELD_TYPE_DESCRIPTION_RATIONAL, 3, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_YCBCR_SUB_SAMPLING = new TagInfo("YCbCr Sub Sampling", 530, FIELD_TYPE_DESCRIPTION_SHORT, 2, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_YCBCR_POSITIONING = new TagInfo("YCbCr Positioning", 531, FIELD_TYPE_DESCRIPTION_SHORT, 1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_REFERENCE_BLACK_WHITE = new TagInfo("Reference Black White", 532, FIELD_TYPE_DESCRIPTION_LONG, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_COPYRIGHT = new TagInfo("Copyright", 33432, FIELD_TYPE_DESCRIPTION_ASCII, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_XMP = new TagInfo("XMP", 700, FIELD_TYPE_DESCRIPTION_BYTE, -1, TIFF_DIRECTORY_ROOT);
    TIFF_TAG_UNKNOWN = new TagInfo.Unknown("Unknown Tag", -1, FIELD_TYPE_DESCRIPTION_UNKNOWN, -1, EXIF_DIRECTORY_UNKNOWN);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\constants\TiffTagConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */