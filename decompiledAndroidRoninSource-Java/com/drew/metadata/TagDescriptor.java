package com.drew.metadata;

import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.DecimalFormat;

public class TagDescriptor<T extends Directory>
{
  protected final T _directory;
  
  public TagDescriptor(T paramT)
  {
    this._directory = paramT;
  }
  
  public static String convertBytesToVersionString(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while ((i < 4) && (i < paramArrayOfInt.length))
    {
      if (i == paramInt) {
        localStringBuilder.append('.');
      }
      char c2 = (char)paramArrayOfInt[i];
      char c1 = c2;
      if (c2 < '0') {
        c1 = (char)(c2 + '0');
      }
      if ((i != 0) || (c1 != '0')) {
        localStringBuilder.append(c1);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  protected static String getFStopDescription(double paramDouble)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("0.0");
    localDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("f/");
    localStringBuilder.append(localDecimalFormat.format(paramDouble));
    return localStringBuilder.toString();
  }
  
  protected static String getFocalLengthDescription(double paramDouble)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("0.#");
    localDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localDecimalFormat.format(paramDouble));
    localStringBuilder.append(" mm");
    return localStringBuilder.toString();
  }
  
  protected String get7BitStringFromBytes(int paramInt)
  {
    return null;
  }
  
  protected String getBitFlagDescription(int paramInt, Object... paramVarArgs)
  {
    return null;
  }
  
  protected String getByteLengthDescription(int paramInt)
  {
    return null;
  }
  
  protected String getDecimalRational(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public String getDescription(int paramInt)
  {
    return null;
  }
  
  protected String getEpochTimeDescription(int paramInt)
  {
    return null;
  }
  
  protected String getFormattedFloat(int paramInt, String paramString)
  {
    return null;
  }
  
  protected String getFormattedInt(int paramInt, String paramString)
  {
    return null;
  }
  
  protected String getFormattedString(int paramInt, String paramString)
  {
    return null;
  }
  
  protected String getIndexedDescription(int paramInt1, int paramInt2, String... paramVarArgs)
  {
    return null;
  }
  
  protected String getIndexedDescription(int paramInt, String... paramVarArgs)
  {
    return getIndexedDescription(paramInt, 0, paramVarArgs);
  }
  
  protected String getLensSpecificationDescription(int paramInt)
  {
    return null;
  }
  
  protected String getLightSourceDescription(short paramShort)
  {
    return null;
  }
  
  protected String getOrientationDescription(int paramInt)
  {
    return null;
  }
  
  protected String getRationalOrDoubleString(int paramInt)
  {
    return null;
  }
  
  protected String getShutterSpeedDescription(int paramInt)
  {
    return null;
  }
  
  protected String getSimpleRational(int paramInt)
  {
    return null;
  }
  
  protected String getStringFromBytes(int paramInt, Charset paramCharset)
  {
    return null;
  }
  
  protected String getVersionBytesDescription(int paramInt1, int paramInt2)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\TagDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */