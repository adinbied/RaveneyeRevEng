package com.huawei.hianalytics.log.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.hianalytics.a.d;
import com.huawei.hianalytics.d.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  public static String a(Context paramContext)
  {
    paramContext = b(paramContext);
    String str1 = Build.MODEL;
    String str2 = Build.DISPLAY;
    String str3 = com.huawei.hianalytics.c.c.b();
    String str4 = Build.VERSION.RELEASE;
    String str5 = d.h();
    return String.format(Locale.getDefault(), "%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s", new Object[] { "shaSN", paramContext, "model", str1, "romVersion", str2, "emuiVersion", str3, "osVersion", str4, "countryCode", str5 });
  }
  
  public static String a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new Date();
    String str2 = new SimpleDateFormat("yyyyMMddHHmmssSSS").format((Date)localObject);
    String str1 = a.a().c();
    localObject = str1;
    if (TextUtils.isEmpty(str1))
    {
      str1 = com.huawei.hianalytics.a.b.h();
      localObject = str1;
      if (TextUtils.isEmpty(str1))
      {
        localObject = c(paramContext);
        com.huawei.hianalytics.a.b.c((String)localObject);
      }
    }
    paramContext = b.a((String)localObject);
    if (paramBoolean1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/Eventid_");
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append("_ALL.zip");
      return ((StringBuilder)localObject).toString();
    }
    if (paramBoolean2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/Crash_");
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(".zip");
      return ((StringBuilder)localObject).toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/Eventid_");
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(".zip");
    return ((StringBuilder)localObject).toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      localJSONObject = new JSONObject(paramString2);
      paramString1 = localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject;
      for (;;) {}
    }
    com.huawei.hianalytics.g.b.b("LogStringUtil", "collectErrorLog() MetaData is not a JSON format!");
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(paramString1, paramString2);
    }
    catch (JSONException paramString1)
    {
      for (;;) {}
    }
    com.huawei.hianalytics.g.b.c("LogStringUtil", "checkMetaMsg() An exception occurred in json.put ");
    paramString1 = localJSONObject;
    return paramString1.toString();
  }
  
  public static String b(Context paramContext)
  {
    return b.a(c(paramContext));
  }
  
  public static String c(Context paramContext)
  {
    SharedPreferences localSharedPreferences = c.a(paramContext, "global_v2");
    if (localSharedPreferences != null)
    {
      String str = (String)c.b(localSharedPreferences, "uuid", "");
      paramContext = str;
      if (TextUtils.isEmpty(str))
      {
        paramContext = UUID.randomUUID().toString().replace("-", "");
        localSharedPreferences.edit().putString("uuid", paramContext).apply();
        return paramContext;
      }
    }
    else
    {
      paramContext = UUID.randomUUID().toString();
    }
    return paramContext;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */