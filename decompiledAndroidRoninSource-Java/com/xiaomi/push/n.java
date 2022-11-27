package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import java.util.Map;

public abstract class n
{
  public static void a(Context paramContext) {}
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static void a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if ((paramMap != null) && (paramString1 != null) && (paramString2 != null)) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext);
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */