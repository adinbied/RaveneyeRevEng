package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xiaomi.push.bf;
import com.xiaomi.push.i;
import com.xiaomi.push.l;
import java.util.HashMap;

class ai
{
  public static HashMap<String, String> a(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("appToken", b.a(paramContext).b());
      localHashMap.put("regId", MiPushClient.getRegId(paramContext));
      localHashMap.put("appId", b.a(paramContext).a());
      localHashMap.put("regResource", b.a(paramContext).e());
      if (!l.d())
      {
        localObject = i.g(paramContext);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localHashMap.put("imeiMd5", bf.a((String)localObject));
        }
      }
      localHashMap.put("isMIUI", String.valueOf(l.a()));
      localHashMap.put("miuiVersion", l.a());
      localHashMap.put("devId", i.a(paramContext, true));
      localHashMap.put("model", Build.MODEL);
      localHashMap.put("pkgName", paramContext.getPackageName());
      localHashMap.put("sdkVersion", "3_7_0");
      localHashMap.put("androidVersion", String.valueOf(Build.VERSION.SDK_INT));
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(Build.VERSION.INCREMENTAL);
      localHashMap.put("os", ((StringBuilder)localObject).toString());
      localHashMap.put("andId", i.e(paramContext));
      if (!TextUtils.isEmpty(paramString)) {
        localHashMap.put("clientInterfaceId", paramString);
      }
      return localHashMap;
    }
    finally {}
    return localHashMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */