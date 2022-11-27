package com.huawei.hianalytics.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.huawei.hianalytics.g.b;

public class d
{
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(b(paramContext, paramString), 0);
  }
  
  public static void a(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    if ((paramSharedPreferences != null) && (paramString != null))
    {
      if (paramString.isEmpty()) {
        return;
      }
      paramSharedPreferences = paramSharedPreferences.edit();
      if ((paramObject instanceof Boolean)) {
        paramSharedPreferences.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      } else if ((paramObject instanceof Float)) {
        paramSharedPreferences.putFloat(paramString, ((Float)paramObject).floatValue());
      } else if ((paramObject instanceof Integer)) {
        paramSharedPreferences.putInt(paramString, ((Integer)paramObject).intValue());
      } else if ((paramObject instanceof Long)) {
        paramSharedPreferences.putLong(paramString, ((Long)paramObject).longValue());
      } else {
        paramSharedPreferences.putString(paramString, (String)paramObject);
      }
      paramSharedPreferences.commit();
    }
  }
  
  public static Object b(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    if ((paramSharedPreferences != null) && (paramString != null) && (!paramString.isEmpty())) {}
    try
    {
      if ((paramObject instanceof Boolean)) {
        return Boolean.valueOf(paramSharedPreferences.getBoolean(paramString, ((Boolean)paramObject).booleanValue()));
      }
      if ((paramObject instanceof Float)) {
        return Float.valueOf(paramSharedPreferences.getFloat(paramString, ((Float)paramObject).floatValue()));
      }
      if ((paramObject instanceof Integer)) {
        return Integer.valueOf(paramSharedPreferences.getInt(paramString, ((Integer)paramObject).intValue()));
      }
      if ((paramObject instanceof Long)) {
        return Long.valueOf(paramSharedPreferences.getLong(paramString, ((Long)paramObject).longValue()));
      }
      if (!(paramObject instanceof String)) {
        break label146;
      }
      paramSharedPreferences = paramSharedPreferences.getString(paramString, (String)paramObject);
      return paramSharedPreferences;
    }
    catch (ClassCastException paramSharedPreferences)
    {
      for (;;) {}
    }
    b.c("HiAnalyticsSharedPreference", "getInfoFromSP() class cast Exception !");
    label146:
    return paramObject;
    return "";
  }
  
  public static String b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hianalytics_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramContext);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytic\\util\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */