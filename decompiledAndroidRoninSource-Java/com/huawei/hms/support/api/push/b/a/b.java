package com.huawei.hms.support.api.push.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.api.push.b.a.a.c;
import com.huawei.hms.support.api.push.b.b.d;
import com.huawei.hms.support.log.a;

public abstract class b
{
  public static String a(Context paramContext, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    if (bool) {
      return "";
    }
    try
    {
      paramContext = d.b(paramContext, new c(paramContext, paramString).b("token_info_v2"));
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("getSecureData");
      paramString.append(paramContext.getMessage());
      a.d("PushDataEncrypterManager", paramString.toString());
      paramContext = str;
    }
    if (TextUtils.isEmpty(paramContext)) {
      a.a("PushDataEncrypterManager", "getSecureData not exist");
    }
    return paramContext;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString2 = d.a(paramContext, paramString2);
    return new c(paramContext, paramString1).a("token_info_v2", paramString2);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      new c(paramContext, paramString).d("token_info_v2");
      return;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("removeSecureData");
      paramString.append(paramContext.getMessage());
      a.d("PushDataEncrypterManager", paramString.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */