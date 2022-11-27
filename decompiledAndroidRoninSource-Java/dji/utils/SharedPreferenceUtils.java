package dji.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.collection.SimpleArrayMap;
import java.util.Map;
import java.util.Set;

public class SharedPreferenceUtils
{
  private static final SimpleArrayMap<String, SharedPreferenceUtils> SP_UTILS_MAP = new SimpleArrayMap();
  private SharedPreferences sp;
  
  private SharedPreferenceUtils(Context paramContext, String paramString)
  {
    this.sp = paramContext.getApplicationContext().getSharedPreferences(paramString, 0);
  }
  
  private SharedPreferenceUtils(Context paramContext, String paramString, int paramInt)
  {
    this.sp = paramContext.getApplicationContext().getSharedPreferences(paramString, paramInt);
  }
  
  public static SharedPreferenceUtils getInstance()
  {
    return getInstance(AppUtils.getApp(), "", 0);
  }
  
  public static SharedPreferenceUtils getInstance(Context paramContext)
  {
    return getInstance(paramContext, "", 0);
  }
  
  public static SharedPreferenceUtils getInstance(Context paramContext, int paramInt)
  {
    return getInstance(paramContext, "", paramInt);
  }
  
  public static SharedPreferenceUtils getInstance(Context paramContext, String paramString)
  {
    return getInstance(paramContext, paramString, 0);
  }
  
  public static SharedPreferenceUtils getInstance(Context paramContext, String paramString, int paramInt)
  {
    String str = paramString;
    if (hasSpace(paramString)) {
      str = paramContext.getPackageName();
    }
    SharedPreferenceUtils localSharedPreferenceUtils = (SharedPreferenceUtils)SP_UTILS_MAP.get(str);
    paramString = localSharedPreferenceUtils;
    if (localSharedPreferenceUtils == null)
    {
      paramString = new SharedPreferenceUtils(paramContext, str, paramInt);
      SP_UTILS_MAP.put(str, paramString);
    }
    return paramString;
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
  
  public void clear()
  {
    clear(true);
  }
  
  public void clear(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.sp.edit().clear().commit();
      return;
    }
    this.sp.edit().clear().apply();
  }
  
  public boolean contains(String paramString)
  {
    return this.sp.contains(paramString);
  }
  
  public Map<String, ?> getAll()
  {
    return this.sp.getAll();
  }
  
  public boolean getBoolean(String paramString)
  {
    return getBoolean(paramString, false);
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.sp.getBoolean(paramString, paramBoolean);
  }
  
  public float getFloat(String paramString)
  {
    return getFloat(paramString, -1.0F);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    return this.sp.getFloat(paramString, paramFloat);
  }
  
  public int getInt(String paramString)
  {
    return getInt(paramString, -1);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.sp.getInt(paramString, paramInt);
  }
  
  public long getLong(String paramString)
  {
    return getLong(paramString, -1L);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return this.sp.getLong(paramString, paramLong);
  }
  
  public String getString(String paramString)
  {
    return getString(paramString, "");
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return this.sp.getString(paramString1, paramString2);
  }
  
  public Set<String> getStringSet(String paramString)
  {
    return null;
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    return this.sp.getStringSet(paramString, paramSet);
  }
  
  public void put(String paramString, float paramFloat)
  {
    put(paramString, paramFloat, true);
  }
  
  public void put(String paramString, float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.sp.edit().putFloat(paramString, paramFloat).commit();
      return;
    }
    this.sp.edit().putFloat(paramString, paramFloat).apply();
  }
  
  public void put(String paramString, int paramInt)
  {
    put(paramString, paramInt, true);
  }
  
  public void put(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.sp.edit().putInt(paramString, paramInt).commit();
      return;
    }
    this.sp.edit().putInt(paramString, paramInt).apply();
  }
  
  public void put(String paramString, long paramLong)
  {
    put(paramString, paramLong, true);
  }
  
  public void put(String paramString, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.sp.edit().putLong(paramString, paramLong).commit();
      return;
    }
    this.sp.edit().putLong(paramString, paramLong).apply();
  }
  
  public void put(String paramString1, String paramString2)
  {
    put(paramString1, paramString2, true);
  }
  
  public void put(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.sp.edit().putString(paramString1, paramString2).commit();
      return;
    }
    this.sp.edit().putString(paramString1, paramString2).apply();
  }
  
  public void put(String paramString, Set<String> paramSet)
  {
    put(paramString, paramSet, true);
  }
  
  public void put(String paramString, Set<String> paramSet, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.sp.edit().putStringSet(paramString, paramSet).commit();
      return;
    }
    this.sp.edit().putStringSet(paramString, paramSet).apply();
  }
  
  public void put(String paramString, boolean paramBoolean)
  {
    put(paramString, paramBoolean, true);
  }
  
  public void put(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.sp.edit().putBoolean(paramString, paramBoolean1).commit();
      return;
    }
    this.sp.edit().putBoolean(paramString, paramBoolean1).apply();
  }
  
  public void remove(String paramString)
  {
    remove(paramString, true);
  }
  
  public void remove(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.sp.edit().remove(paramString).commit();
      return;
    }
    this.sp.edit().remove(paramString).apply();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\SharedPreferenceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */