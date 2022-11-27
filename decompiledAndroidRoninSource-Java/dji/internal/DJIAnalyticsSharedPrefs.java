package dji.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class DJIAnalyticsSharedPrefs
{
  private static final boolean BOOLEAN_DEFAULT_VALUE = false;
  private static final Integer INTEGER_DEFAULT_VALUE = Integer.valueOf(0);
  private static final long LONG_DEFAULT_VALUE = 0L;
  private static final String PREFERENCE_FILE_KEY = "dji.internal.analytics";
  private static final String STRING_DEFAULT_VALUE = "";
  private static SharedPreferences.Editor sEditor;
  private static SharedPreferences sSharedPref;
  
  public static boolean containsKey(String paramString)
  {
    SharedPreferences localSharedPreferences = sSharedPref;
    if (localSharedPreferences != null) {
      return localSharedPreferences.contains(paramString);
    }
    return false;
  }
  
  public static boolean getBooleanPref(String paramString)
  {
    SharedPreferences localSharedPreferences = sSharedPref;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean(paramString, false);
    }
    return false;
  }
  
  public static Integer getIntegerPref(String paramString)
  {
    SharedPreferences localSharedPreferences = sSharedPref;
    if (localSharedPreferences != null) {
      return Integer.valueOf(localSharedPreferences.getInt(paramString, INTEGER_DEFAULT_VALUE.intValue()));
    }
    return INTEGER_DEFAULT_VALUE;
  }
  
  public static Long getLongPref(String paramString)
  {
    SharedPreferences localSharedPreferences = sSharedPref;
    if (localSharedPreferences != null) {
      return Long.valueOf(localSharedPreferences.getLong(paramString, 0L));
    }
    return Long.valueOf(0L);
  }
  
  public static String getStringPref(String paramString)
  {
    SharedPreferences localSharedPreferences = sSharedPref;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(paramString, "");
    }
    return "";
  }
  
  public static void init(Context paramContext)
  {
    sSharedPref = paramContext.getSharedPreferences("dji.internal.analytics", 0);
  }
  
  public static void setBooleanPref(String paramString, Boolean paramBoolean)
  {
    Object localObject = sSharedPref;
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      sEditor = (SharedPreferences.Editor)localObject;
      ((SharedPreferences.Editor)localObject).putBoolean(paramString, paramBoolean.booleanValue());
      sEditor.apply();
    }
  }
  
  public static void setIntegerPref(String paramString, Integer paramInteger)
  {
    Object localObject = sSharedPref;
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      sEditor = (SharedPreferences.Editor)localObject;
      ((SharedPreferences.Editor)localObject).putInt(paramString, paramInteger.intValue());
      sEditor.apply();
    }
  }
  
  public static void setLongPref(String paramString, Long paramLong)
  {
    Object localObject = sSharedPref;
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      sEditor = (SharedPreferences.Editor)localObject;
      ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong.longValue());
      sEditor.apply();
    }
  }
  
  public static void setStringPref(String paramString1, String paramString2)
  {
    Object localObject = sSharedPref;
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      sEditor = (SharedPreferences.Editor)localObject;
      ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      sEditor.apply();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\DJIAnalyticsSharedPrefs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */