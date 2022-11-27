package dji.thirdparty.sanselan.formats.tiff.constants;

import dji.thirdparty.sanselan.SanselanConstants;
import dji.thirdparty.sanselan.formats.tiff.fieldtypes.FieldType;
import dji.thirdparty.sanselan.formats.tiff.fieldtypes.FieldTypeASCII;
import dji.thirdparty.sanselan.formats.tiff.fieldtypes.FieldTypeByte;
import dji.thirdparty.sanselan.formats.tiff.fieldtypes.FieldTypeDouble;
import dji.thirdparty.sanselan.formats.tiff.fieldtypes.FieldTypeFloat;
import dji.thirdparty.sanselan.formats.tiff.fieldtypes.FieldTypeLong;
import dji.thirdparty.sanselan.formats.tiff.fieldtypes.FieldTypeRational;
import dji.thirdparty.sanselan.formats.tiff.fieldtypes.FieldTypeShort;
import dji.thirdparty.sanselan.formats.tiff.fieldtypes.FieldTypeUnknown;

public abstract interface TiffFieldTypeConstants
  extends SanselanConstants
{
  public static final FieldType[] FIELD_TYPES;
  public static final FieldType[] FIELD_TYPE_ANY;
  public static final FieldTypeASCII FIELD_TYPE_ASCII;
  public static final FieldTypeByte FIELD_TYPE_BYTE = new FieldTypeByte(1, "Byte");
  public static final FieldType[] FIELD_TYPE_DESCRIPTION_ANY;
  public static final FieldType[] FIELD_TYPE_DESCRIPTION_ASCII;
  public static final FieldType[] FIELD_TYPE_DESCRIPTION_BYTE;
  public static final FieldType[] FIELD_TYPE_DESCRIPTION_BYTE_OR_SHORT;
  public static final FieldType[] FIELD_TYPE_DESCRIPTION_LONG;
  public static final FieldType[] FIELD_TYPE_DESCRIPTION_LONG_OR_SHORT;
  public static final FieldType[] FIELD_TYPE_DESCRIPTION_RATIONAL;
  public static final FieldType[] FIELD_TYPE_DESCRIPTION_SHORT;
  public static final FieldType[] FIELD_TYPE_DESCRIPTION_SHORT_OR_LONG;
  public static final FieldType[] FIELD_TYPE_DESCRIPTION_UNKNOWN = null;
  public static final FieldType FIELD_TYPE_DOUBLE;
  public static final FieldType FIELD_TYPE_FLOAT;
  public static final FieldTypeLong FIELD_TYPE_LONG;
  public static final FieldType FIELD_TYPE_LONG2;
  public static final FieldTypeRational FIELD_TYPE_RATIONAL;
  public static final FieldType FIELD_TYPE_SBYTE;
  public static final FieldTypeShort FIELD_TYPE_SHORT;
  public static final FieldType FIELD_TYPE_SLONG;
  public static final FieldType FIELD_TYPE_SRATIONAL;
  public static final FieldType FIELD_TYPE_SSHORT;
  public static final FieldType FIELD_TYPE_UNDEFINED;
  public static final FieldType FIELD_TYPE_UNKNOWN;
  
  static
  {
    FIELD_TYPE_ASCII = new FieldTypeASCII(2, "ASCII");
    FIELD_TYPE_SHORT = new FieldTypeShort(3, "Short");
    FIELD_TYPE_LONG = new FieldTypeLong(4, "Long");
    FIELD_TYPE_RATIONAL = new FieldTypeRational(5, "Rational");
    FIELD_TYPE_SBYTE = new FieldTypeByte(6, "SByte");
    FIELD_TYPE_UNDEFINED = new FieldTypeByte(7, "Undefined");
    FIELD_TYPE_SSHORT = new FieldTypeShort(8, "SShort");
    FIELD_TYPE_SLONG = new FieldTypeLong(9, "SLong");
    FIELD_TYPE_SRATIONAL = new FieldTypeRational(10, "SRational");
    FIELD_TYPE_FLOAT = new FieldTypeFloat();
    FIELD_TYPE_DOUBLE = new FieldTypeDouble();
    FIELD_TYPE_LONG2 = new FieldTypeLong(13, "Long");
    FIELD_TYPE_UNKNOWN = new FieldTypeUnknown();
    FieldType[] arrayOfFieldType = new FieldType[13];
    FieldTypeByte localFieldTypeByte = FIELD_TYPE_BYTE;
    arrayOfFieldType[0] = localFieldTypeByte;
    FieldTypeASCII localFieldTypeASCII = FIELD_TYPE_ASCII;
    arrayOfFieldType[1] = localFieldTypeASCII;
    FieldTypeShort localFieldTypeShort = FIELD_TYPE_SHORT;
    arrayOfFieldType[2] = localFieldTypeShort;
    FieldTypeLong localFieldTypeLong = FIELD_TYPE_LONG;
    arrayOfFieldType[3] = localFieldTypeLong;
    FieldTypeRational localFieldTypeRational = FIELD_TYPE_RATIONAL;
    arrayOfFieldType[4] = localFieldTypeRational;
    arrayOfFieldType[5] = FIELD_TYPE_SBYTE;
    arrayOfFieldType[6] = FIELD_TYPE_UNDEFINED;
    arrayOfFieldType[7] = FIELD_TYPE_SSHORT;
    arrayOfFieldType[8] = FIELD_TYPE_SLONG;
    arrayOfFieldType[9] = FIELD_TYPE_SRATIONAL;
    arrayOfFieldType[10] = FIELD_TYPE_FLOAT;
    arrayOfFieldType[11] = FIELD_TYPE_DOUBLE;
    arrayOfFieldType[12] = FIELD_TYPE_LONG2;
    FIELD_TYPES = arrayOfFieldType;
    FIELD_TYPE_ANY = arrayOfFieldType;
    FIELD_TYPE_DESCRIPTION_LONG = new FieldType[] { localFieldTypeLong };
    FIELD_TYPE_DESCRIPTION_SHORT = new FieldType[] { localFieldTypeShort };
    FIELD_TYPE_DESCRIPTION_SHORT_OR_LONG = new FieldType[] { localFieldTypeShort, localFieldTypeLong };
    FIELD_TYPE_DESCRIPTION_ASCII = new FieldType[] { localFieldTypeASCII };
    FIELD_TYPE_DESCRIPTION_LONG_OR_SHORT = new FieldType[] { localFieldTypeShort, localFieldTypeLong };
    FIELD_TYPE_DESCRIPTION_RATIONAL = new FieldType[] { localFieldTypeRational };
    FIELD_TYPE_DESCRIPTION_BYTE_OR_SHORT = new FieldType[] { localFieldTypeShort, localFieldTypeByte };
    FIELD_TYPE_DESCRIPTION_BYTE = new FieldType[] { localFieldTypeByte };
    FIELD_TYPE_DESCRIPTION_ANY = arrayOfFieldType;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\constants\TiffFieldTypeConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */