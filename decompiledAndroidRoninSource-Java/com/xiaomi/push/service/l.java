package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ab;
import com.xiaomi.push.au;
import com.xiaomi.push.ax;
import com.xiaomi.push.az;
import com.xiaomi.push.bf;
import com.xiaomi.push.fv;
import com.xiaomi.push.i;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class l
{
  private static k jdField_a_of_type_ComXiaomiPushServiceK;
  private static a jdField_a_of_type_ComXiaomiPushServiceL$a;
  
  public static k a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_ComXiaomiPushServiceK != null)
      {
        paramContext = jdField_a_of_type_ComXiaomiPushServiceK;
        return paramContext;
      }
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("mipush_account", 0);
      String str3 = localSharedPreferences.getString("uuid", null);
      String str4 = localSharedPreferences.getString("token", null);
      String str5 = localSharedPreferences.getString("security", null);
      String str6 = localSharedPreferences.getString("app_id", null);
      String str7 = localSharedPreferences.getString("app_token", null);
      String str8 = localSharedPreferences.getString("package_name", null);
      String str2 = localSharedPreferences.getString("device_id", null);
      int i = localSharedPreferences.getInt("env_type", 1);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (i.a(str2))
        {
          str1 = i.k(paramContext);
          localSharedPreferences.edit().putString("device_id", str1).commit();
        }
      }
      if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str5)))
      {
        str2 = i.k(paramContext);
        if ((!"com.xiaomi.xmsf".equals(paramContext.getPackageName())) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (!str1.equals(str2))) {
          b.a("read_phone_state permission changes.");
        }
        paramContext = new k(str3, str4, str5, str6, str7, str8, i);
        jdField_a_of_type_ComXiaomiPushServiceK = paramContext;
        return paramContext;
      }
      return null;
    }
    finally {}
  }
  
  public static k a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        Object localObject4 = new TreeMap();
        localObject1 = i.a(paramContext, false);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("account register:");
        ((StringBuilder)localObject2).append((String)localObject1);
        b.a(((StringBuilder)localObject2).toString());
        ((Map)localObject4).put("devid", localObject1);
        ((Map)localObject4).put("devid1", i.a(paramContext));
        if ((jdField_a_of_type_ComXiaomiPushServiceK != null) && (!TextUtils.isEmpty(jdField_a_of_type_ComXiaomiPushServiceK.jdField_a_of_type_JavaLangString)))
        {
          ((Map)localObject4).put("uuid", jdField_a_of_type_ComXiaomiPushServiceK.jdField_a_of_type_JavaLangString);
          int i = jdField_a_of_type_ComXiaomiPushServiceK.jdField_a_of_type_JavaLangString.lastIndexOf("/");
          if (i != -1)
          {
            localObject1 = jdField_a_of_type_ComXiaomiPushServiceK.jdField_a_of_type_JavaLangString.substring(i + 1);
            au.a(paramContext).a((Map)localObject4);
            localObject2 = i.c(paramContext);
            if (localObject2 != null) {
              ((Map)localObject4).put("vdevid", localObject2);
            }
            localObject2 = i.b(paramContext);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              ((Map)localObject4).put("gaid", localObject2);
            }
            if (a(paramContext)) {
              paramString2 = "1000271";
            }
            if (a(paramContext)) {
              paramString3 = "420100086271";
            }
            localObject2 = paramString1;
            if (a(paramContext)) {
              localObject2 = "com.xiaomi.xmsf";
            }
            ((Map)localObject4).put("appid", paramString2);
            ((Map)localObject4).put("apptoken", paramString3);
            try
            {
              paramString1 = paramContext.getPackageManager().getPackageInfo((String)localObject2, 16384);
            }
            catch (Exception paramString1)
            {
              b.a(paramString1);
              paramString1 = null;
            }
            if (paramString1 == null) {
              break label943;
            }
            paramString1 = String.valueOf(paramString1.versionCode);
            ((Map)localObject4).put("appversion", paramString1);
            ((Map)localObject4).put("sdkversion", Integer.toString(30700));
            ((Map)localObject4).put("packagename", localObject2);
            ((Map)localObject4).put("model", Build.MODEL);
            ((Map)localObject4).put("board", Build.BOARD);
            String str1;
            if (!com.xiaomi.push.l.d())
            {
              paramString1 = "";
              localObject3 = i.f(paramContext);
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                paramString1 = new StringBuilder();
                paramString1.append("");
                paramString1.append(bf.a((String)localObject3));
                paramString1 = paramString1.toString();
              }
              str1 = i.h(paramContext);
              localObject3 = paramString1;
              if (!TextUtils.isEmpty(paramString1))
              {
                localObject3 = paramString1;
                if (!TextUtils.isEmpty(str1))
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append(paramString1);
                  ((StringBuilder)localObject3).append(",");
                  ((StringBuilder)localObject3).append(str1);
                  localObject3 = ((StringBuilder)localObject3).toString();
                }
              }
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                ((Map)localObject4).put("imei_md5", localObject3);
              }
            }
            paramString1 = new StringBuilder();
            paramString1.append(Build.VERSION.RELEASE);
            paramString1.append("-");
            paramString1.append(Build.VERSION.INCREMENTAL);
            ((Map)localObject4).put("os", paramString1.toString());
            i = i.a();
            if (i >= 0) {
              ((Map)localObject4).put("space_id", Integer.toString(i));
            }
            paramString1 = i.n(paramContext);
            if (!TextUtils.isEmpty(paramString1)) {
              ((Map)localObject4).put("mac_address", bf.a(paramString1));
            }
            ((Map)localObject4).put("android_id", i.e(paramContext));
            paramString1 = new StringBuilder();
            paramString1.append(Build.BRAND);
            paramString1.append("");
            ((Map)localObject4).put("brand", paramString1.toString());
            ((Map)localObject4).put("ram", i.b());
            ((Map)localObject4).put("rom", i.c());
            Object localObject3 = az.a(paramContext, a(paramContext), (Map)localObject4);
            paramString1 = "";
            if (localObject3 != null) {
              paramString1 = ((ax)localObject3).a();
            }
            if (!TextUtils.isEmpty(paramString1))
            {
              localObject3 = new JSONObject(paramString1);
              if (((JSONObject)localObject3).getInt("code") == 0)
              {
                localObject3 = ((JSONObject)localObject3).getJSONObject("data");
                localObject4 = ((JSONObject)localObject3).getString("ssecurity");
                str1 = ((JSONObject)localObject3).getString("token");
                String str2 = ((JSONObject)localObject3).getString("userId");
                paramString1 = (String)localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1))
                {
                  paramString1 = new StringBuilder();
                  paramString1.append("an");
                  paramString1.append(bf.a(6));
                  paramString1 = paramString1.toString();
                }
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(str2);
                ((StringBuilder)localObject1).append("@xiaomi.com/");
                ((StringBuilder)localObject1).append(paramString1);
                paramString1 = new k(((StringBuilder)localObject1).toString(), str1, (String)localObject4, paramString2, paramString3, (String)localObject2, ab.a());
                a(paramContext, paramString1);
                i.a(paramContext, ((JSONObject)localObject3).optString("vdevid"));
                jdField_a_of_type_ComXiaomiPushServiceK = paramString1;
                return paramString1;
              }
              o.a(paramContext, ((JSONObject)localObject3).getInt("code"), ((JSONObject)localObject3).optString("description"));
              b.a(paramString1);
            }
            return null;
          }
        }
      }
      finally {}
      Object localObject1 = null;
      continue;
      label943:
      paramString1 = "0";
    }
  }
  
  public static String a(Context paramContext)
  {
    paramContext = a.a(paramContext).a();
    StringBuilder localStringBuilder;
    if (ab.b())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("http://");
      localStringBuilder.append(fv.b);
      paramContext = ":9085";
    }
    for (;;)
    {
      localStringBuilder.append(paramContext);
      localStringBuilder.append("/pass/v2/register");
      return localStringBuilder.toString();
      if (com.xiaomi.push.o.a.name().equals(paramContext))
      {
        localStringBuilder = new StringBuilder();
        paramContext = "https://cn.register.xmpush.xiaomi.com";
      }
      else if (com.xiaomi.push.o.b.name().equals(paramContext))
      {
        localStringBuilder = new StringBuilder();
        paramContext = "https://register.xmpush.global.xiaomi.com";
      }
      else if (com.xiaomi.push.o.c.name().equals(paramContext))
      {
        localStringBuilder = new StringBuilder();
        paramContext = "https://fr.register.xmpush.global.xiaomi.com";
      }
      else if (com.xiaomi.push.o.d.name().equals(paramContext))
      {
        localStringBuilder = new StringBuilder();
        paramContext = "https://ru.register.xmpush.global.xiaomi.com";
      }
      else if (com.xiaomi.push.o.e.name().equals(paramContext))
      {
        localStringBuilder = new StringBuilder();
        paramContext = "https://idmb.register.xmpush.global.xiaomi.com";
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https://");
        if (ab.a()) {
          paramContext = "sandbox.xmpush.xiaomi.com";
        } else {
          paramContext = "register.xmpush.xiaomi.com";
        }
      }
    }
  }
  
  public static void a()
  {
    a locala = jdField_a_of_type_ComXiaomiPushServiceL$a;
    if (locala != null) {
      locala.a();
    }
  }
  
  public static void a(Context paramContext)
  {
    paramContext.getSharedPreferences("mipush_account", 0).edit().clear().commit();
    jdField_a_of_type_ComXiaomiPushServiceK = null;
    a();
  }
  
  public static void a(Context paramContext, k paramk)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("mipush_account", 0).edit();
    localEditor.putString("uuid", paramk.jdField_a_of_type_JavaLangString);
    localEditor.putString("security", paramk.c);
    localEditor.putString("token", paramk.b);
    localEditor.putString("app_id", paramk.d);
    localEditor.putString("package_name", paramk.f);
    localEditor.putString("app_token", paramk.e);
    localEditor.putString("device_id", i.k(paramContext));
    localEditor.putInt("env_type", paramk.jdField_a_of_type_Int);
    localEditor.commit();
    a();
  }
  
  public static void a(a parama)
  {
    jdField_a_of_type_ComXiaomiPushServiceL$a = parama;
  }
  
  private static boolean a(Context paramContext)
  {
    return paramContext.getPackageName().equals("com.xiaomi.xmsf");
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */