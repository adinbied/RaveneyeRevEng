package dji.midware.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class DjiSharedPreferencesManager
{
  public static boolean getBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    return getSp(paramContext).getBoolean(paramString, paramBoolean);
  }
  
  public static double getDouble(Context paramContext, String paramString, double paramDouble)
  {
    return Double.longBitsToDouble(getSp(paramContext).getLong(paramString, Double.doubleToLongBits(paramDouble)));
  }
  
  public static float getFloat(Context paramContext, String paramString, float paramFloat)
  {
    return getSp(paramContext).getFloat(paramString, paramFloat);
  }
  
  public static int getInt(Context paramContext, String paramString, int paramInt)
  {
    return getSp(paramContext).getInt(paramString, paramInt);
  }
  
  public static long getLong(Context paramContext, String paramString, long paramLong)
  {
    return getSp(paramContext).getLong(paramString, paramLong);
  }
  
  public static SharedPreferences getSp(Context paramContext)
  {
    return paramContext.getSharedPreferences(paramContext.getPackageName(), 0);
  }
  
  public static String getString(Context paramContext, String paramString1, String paramString2)
  {
    return getSp(paramContext).getString(paramString1, paramString2);
  }
  
  public static boolean putBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    return getSp(paramContext).edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static boolean putDouble(Context paramContext, String paramString, double paramDouble)
  {
    return getSp(paramContext).edit().putLong(paramString, Double.doubleToRawLongBits(paramDouble)).commit();
  }
  
  public static boolean putFloat(Context paramContext, String paramString, float paramFloat)
  {
    return getSp(paramContext).edit().putFloat(paramString, paramFloat).commit();
  }
  
  public static boolean putInt(Context paramContext, String paramString, int paramInt)
  {
    return getSp(paramContext).edit().putInt(paramString, paramInt).commit();
  }
  
  public static boolean putLong(Context paramContext, String paramString, long paramLong)
  {
    return getSp(paramContext).edit().putLong(paramString, paramLong).commit();
  }
  
  public static boolean putString(Context paramContext, String paramString1, String paramString2)
  {
    return getSp(paramContext).edit().putString(paramString1, paramString2).commit();
  }
  
  public static boolean removeString(Context paramContext, String paramString)
  {
    return getSp(paramContext).edit().remove(paramString).commit();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\DjiSharedPreferencesManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */