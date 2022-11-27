package dji.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class UnitUtils
{
  public static final float LENGTH_METRIC2IMPERIAL = 3.28F;
  public static final float LENGTH_METRIC2INCH = 39.4F;
  public static final int MEMORY_SIZE_BYTE = 1;
  public static final int MEMORY_SIZE_GB = 1073741824;
  public static final int MEMORY_SIZE_KB = 1024;
  public static final int MEMORY_SIZE_MB = 1048576;
  public static final float SPEED_METRIC2IMPERIAL = 2.237F;
  public static final float SPEED_MS_TO_KMH = 3.6F;
  public static final float TEMPERATURE_K2C = 273.15F;
  
  public static byte[] bits2Bytes(String paramString)
  {
    int k = paramString.length() % 8;
    int j = paramString.length() / 8;
    int i = j;
    Object localObject = paramString;
    if (k != 0)
    {
      i = k;
      while (i < 8)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0");
        ((StringBuilder)localObject).append(paramString);
        paramString = ((StringBuilder)localObject).toString();
        i += 1;
      }
      i = j + 1;
      localObject = paramString;
    }
    paramString = new byte[i];
    j = 0;
    while (j < i)
    {
      k = 0;
      while (k < 8)
      {
        paramString[j] = ((byte)(paramString[j] << 1));
        paramString[j] = ((byte)(paramString[j] | ((String)localObject).charAt(j * 8 + k) - '0'));
        k += 1;
      }
      j += 1;
    }
    return paramString;
  }
  
  public static String byte2FitMemorySize(long paramLong)
  {
    if (paramLong < 0L) {
      return "shouldn't be less than zero!";
    }
    if (paramLong < 1024L) {
      return String.format("%.3fB", new Object[] { Double.valueOf(paramLong) });
    }
    if (paramLong < 1048576L) {
      return String.format("%.3fKB", new Object[] { Double.valueOf(paramLong / 1024.0D) });
    }
    if (paramLong < 1073741824L) {
      return String.format("%.3fMB", new Object[] { Double.valueOf(paramLong / 1048576.0D) });
    }
    return String.format("%.3fGB", new Object[] { Double.valueOf(paramLong / 1.073741824E9D) });
  }
  
  public static double byte2MemorySize(long paramLong, int paramInt)
  {
    if (paramLong < 0L) {
      return -1.0D;
    }
    return paramLong / paramInt;
  }
  
  public static String bytes2Bits(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int k = paramArrayOfByte.length;
      int i = 0;
      while (i < k)
      {
        int m = paramArrayOfByte[i];
        int j = 7;
        while (j >= 0)
        {
          char c;
          if ((m >> j & 0x1) == 0) {
            c = '0';
          } else {
            c = '1';
          }
          localStringBuilder.append(c);
          j -= 1;
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static char[] bytes2Chars(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    int j = paramArrayOfByte.length;
    if (j <= 0) {
      return null;
    }
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((char)(paramArrayOfByte[i] & 0xFF));
      i += 1;
    }
    return arrayOfChar;
  }
  
  public static final float celsiusToFahrenheit(float paramFloat)
  {
    return paramFloat * 1.8F + 32.0F;
  }
  
  public static final float celsiusToKelvin(float paramFloat)
  {
    return paramFloat + 273.15F;
  }
  
  public static byte[] chars2Bytes(char[] paramArrayOfChar)
  {
    if ((paramArrayOfChar != null) && (paramArrayOfChar.length > 0))
    {
      int j = paramArrayOfChar.length;
      byte[] arrayOfByte = new byte[j];
      int i = 0;
      while (i < j)
      {
        arrayOfByte[i] = ((byte)paramArrayOfChar[i]);
        i += 1;
      }
      return arrayOfByte;
    }
    return null;
  }
  
  public static int dp2px(float paramFloat)
  {
    return (int)(paramFloat * Resources.getSystem().getDisplayMetrics().density + 0.5F);
  }
  
  public static final float fahrenheitToCelsius(float paramFloat)
  {
    return (paramFloat - 32.0F) / 1.8F;
  }
  
  public static int getDimens(Context paramContext, int paramInt)
  {
    return (int)paramContext.getResources().getDimension(paramInt);
  }
  
  private static boolean hasSpace(String paramString)
  {
    if (paramString == null) {
      return true;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!Character.isWhitespace(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static float imperialToMetricByLength(float paramFloat)
  {
    return paramFloat / 3.28F;
  }
  
  public static float imperialToMetricBySpeed(float paramFloat)
  {
    return paramFloat / 2.237F;
  }
  
  public static final float kelvinToCelsius(float paramFloat)
  {
    return paramFloat - 273.15F;
  }
  
  public static long memorySize2Byte(long paramLong, int paramInt)
  {
    if (paramLong < 0L) {
      return -1L;
    }
    return paramLong * paramInt;
  }
  
  public static final float meterPerSecondToKiloMeterPerHour(float paramFloat)
  {
    return paramFloat * 3.6F;
  }
  
  public static float metricToImperialByLength(float paramFloat)
  {
    return paramFloat * 3.28F;
  }
  
  public static float metricToImperialBySpeed(float paramFloat)
  {
    return paramFloat * 2.237F;
  }
  
  public static int px2dp(float paramFloat)
  {
    return (int)(paramFloat / Resources.getSystem().getDisplayMetrics().density + 0.5F);
  }
  
  public static int px2sp(float paramFloat)
  {
    return (int)(paramFloat / Resources.getSystem().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public static int sp2px(float paramFloat)
  {
    return (int)(paramFloat * Resources.getSystem().getDisplayMetrics().scaledDensity + 0.5F);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\UnitUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */