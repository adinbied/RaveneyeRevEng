package com.huawei.hianalytics.f.g;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.huawei.hianalytics.util.e;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  public static JSONObject a(Context paramContext)
  {
    String str2 = b(paramContext);
    String str1;
    if (Build.MANUFACTURER == null) {
      str1 = "UNKNOWN";
    } else {
      str1 = Build.MANUFACTURER;
    }
    String str3 = Build.VERSION.RELEASE;
    paramContext = paramContext.getResources().getDisplayMetrics();
    int i = paramContext.heightPixels;
    int j = paramContext.widthPixels;
    paramContext = b("ro.product.CustCVersion", "");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("_sys_language", str2);
      localJSONObject.put("_cust_version", paramContext);
      localJSONObject.put("_manufacturer", str1);
      localJSONObject.put("_os", "android");
      localJSONObject.put("_os_ver", str3);
      localJSONObject.put("_screen_height", i);
      localJSONObject.put("_screen_width", j);
      return localJSONObject;
    }
    catch (JSONException paramContext)
    {
      for (;;) {}
    }
    com.huawei.hianalytics.g.b.c("HiAnalytics/event", "getDeviceInfo() json Exc,A parameter error!");
    return null;
  }
  
  public static JSONObject a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = a(paramContext);
    if (paramContext != null) {}
    try
    {
      paramContext.put("_start_type", paramString1);
      paramContext.put("_start_cmd", paramString2);
      return paramContext;
    }
    catch (JSONException paramContext)
    {
      for (;;) {}
    }
    paramContext = "startType or startCMD error";
    break label36;
    paramContext = "getInfoJson is null";
    label36:
    com.huawei.hianalytics.g.b.c("HiAnalytics/event", paramContext);
    return null;
  }
  
  public static JSONObject a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("_old_app_version", paramString2);
      localJSONObject.put("_current_app_version", paramString1);
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      for (;;) {}
    }
    com.huawei.hianalytics.g.b.c("HiAnalytics/event", "Json Exc : app ver error");
    return null;
  }
  
  public static String b(Context paramContext)
  {
    paramContext = paramContext.getResources().getConfiguration();
    if ((paramContext != null) && (paramContext.locale != null)) {
      return paramContext.locale.toString();
    }
    return "";
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return e.b(paramString1, paramString2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */