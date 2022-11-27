package com.drew.imaging.tiff;

public class TiffDataFormat
{
  public static final int CODE_DOUBLE = 12;
  public static final int CODE_INT16_S = 8;
  public static final int CODE_INT16_U = 3;
  public static final int CODE_INT32_S = 9;
  public static final int CODE_INT32_U = 4;
  public static final int CODE_INT8_S = 6;
  public static final int CODE_INT8_U = 1;
  public static final int CODE_RATIONAL_S = 10;
  public static final int CODE_RATIONAL_U = 5;
  public static final int CODE_SINGLE = 11;
  public static final int CODE_STRING = 2;
  public static final int CODE_UNDEFINED = 7;
  public static final TiffDataFormat DOUBLE = new TiffDataFormat("DOUBLE", 12, 8);
  public static final TiffDataFormat INT16_S;
  public static final TiffDataFormat INT16_U;
  public static final TiffDataFormat INT32_S;
  public static final TiffDataFormat INT32_U;
  public static final TiffDataFormat INT8_S;
  public static final TiffDataFormat INT8_U = new TiffDataFormat("BYTE", 1, 1);
  public static final TiffDataFormat RATIONAL_S;
  public static final TiffDataFormat RATIONAL_U;
  public static final TiffDataFormat SINGLE;
  public static final TiffDataFormat STRING = new TiffDataFormat("STRING", 2, 1);
  public static final TiffDataFormat UNDEFINED;
  private final int _componentSizeBytes;
  private final String _name;
  private final int _tiffFormatCode;
  
  static
  {
    INT16_U = new TiffDataFormat("USHORT", 3, 2);
    INT32_U = new TiffDataFormat("ULONG", 4, 4);
    RATIONAL_U = new TiffDataFormat("URATIONAL", 5, 8);
    INT8_S = new TiffDataFormat("SBYTE", 6, 1);
    UNDEFINED = new TiffDataFormat("UNDEFINED", 7, 1);
    INT16_S = new TiffDataFormat("SSHORT", 8, 2);
    INT32_S = new TiffDataFormat("SLONG", 9, 4);
    RATIONAL_S = new TiffDataFormat("SRATIONAL", 10, 8);
    SINGLE = new TiffDataFormat("SINGLE", 11, 4);
  }
  
  private TiffDataFormat(String paramString, int paramInt1, int paramInt2)
  {
    this._name = paramString;
    this._tiffFormatCode = paramInt1;
    this._componentSizeBytes = paramInt2;
  }
  
  public static TiffDataFormat fromTiffFormatCode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 12: 
      return DOUBLE;
    case 11: 
      return SINGLE;
    case 10: 
      return RATIONAL_S;
    case 9: 
      return INT32_S;
    case 8: 
      return INT16_S;
    case 7: 
      return UNDEFINED;
    case 6: 
      return INT8_S;
    case 5: 
      return RATIONAL_U;
    case 4: 
      return INT32_U;
    case 3: 
      return INT16_U;
    case 2: 
      return STRING;
    }
    return INT8_U;
  }
  
  public int getComponentSizeBytes()
  {
    return this._componentSizeBytes;
  }
  
  public int getTiffFormatCode()
  {
    return this._tiffFormatCode;
  }
  
  public String toString()
  {
    return this._name;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\tiff\TiffDataFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */