package com.drew.imaging.png;

public enum PngColorType
{
  private final int[] _allowedBitDepths;
  private final String _description;
  private final int _numericValue;
  
  static
  {
    IndexedColor = new PngColorType("IndexedColor", 2, 3, "Indexed Color", new int[] { 1, 2, 4, 8 });
    GreyscaleWithAlpha = new PngColorType("GreyscaleWithAlpha", 3, 4, "Greyscale with Alpha", new int[] { 8, 16 });
    PngColorType localPngColorType = new PngColorType("TrueColorWithAlpha", 4, 6, "True Color with Alpha", new int[] { 8, 16 });
    TrueColorWithAlpha = localPngColorType;
    $VALUES = new PngColorType[] { Greyscale, TrueColor, IndexedColor, GreyscaleWithAlpha, localPngColorType };
  }
  
  private PngColorType(int paramInt, String paramString, int... paramVarArgs)
  {
    this._numericValue = paramInt;
    this._description = paramString;
    this._allowedBitDepths = paramVarArgs;
  }
  
  public static PngColorType fromNumericValue(int paramInt)
  {
    PngColorType[] arrayOfPngColorType = (PngColorType[])PngColorType.class.getEnumConstants();
    int j = arrayOfPngColorType.length;
    int i = 0;
    while (i < j)
    {
      PngColorType localPngColorType = arrayOfPngColorType[i];
      if (localPngColorType.getNumericValue() == paramInt) {
        return localPngColorType;
      }
      i += 1;
    }
    return null;
  }
  
  public int[] getAllowedBitDepths()
  {
    return this._allowedBitDepths;
  }
  
  public String getDescription()
  {
    return this._description;
  }
  
  public int getNumericValue()
  {
    return this._numericValue;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\png\PngColorType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */