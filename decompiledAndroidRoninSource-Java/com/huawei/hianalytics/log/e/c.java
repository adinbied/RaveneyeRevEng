package com.huawei.hianalytics.log.e;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hianalytics.util.d;

public class c
{
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    return d.a(paramContext, paramString);
  }
  
  public static String a(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hianalytics_log_");
    localStringBuilder.append(paramContext.getPackageName());
    return localStringBuilder.toString();
  }
  
  public static void a(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    d.a(paramSharedPreferences, paramString, paramObject);
  }
  
  public static SharedPreferences b(Context paramContext)
  {
    return paramContext.getSharedPreferences(a(paramContext), 0);
  }
  
  public static Object b(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    return d.b(paramSharedPreferences, paramString, paramObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */