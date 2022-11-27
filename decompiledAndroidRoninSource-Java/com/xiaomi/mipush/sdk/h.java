package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai;
import com.xiaomi.push.az;
import com.xiaomi.push.ht;
import com.xiaomi.push.r;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class h
{
  private static HashMap<String, String> a = new HashMap();
  
  public static MiPushMessage a(String paramString)
  {
    MiPushMessage localMiPushMessage = new MiPushMessage();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("messageId")) {
          localMiPushMessage.setMessageId(paramString.getString("messageId"));
        }
        if (paramString.has("description")) {
          localMiPushMessage.setDescription(paramString.getString("description"));
        }
        if (paramString.has("title")) {
          localMiPushMessage.setTitle(paramString.getString("title"));
        }
        if (paramString.has("content")) {
          localMiPushMessage.setContent(paramString.getString("content"));
        }
        if (paramString.has("passThrough")) {
          localMiPushMessage.setPassThrough(paramString.getInt("passThrough"));
        }
        if (paramString.has("notifyType")) {
          localMiPushMessage.setNotifyType(paramString.getInt("notifyType"));
        }
        if (paramString.has("messageType")) {
          localMiPushMessage.setMessageType(paramString.getInt("messageType"));
        }
        if (paramString.has("alias")) {
          localMiPushMessage.setAlias(paramString.getString("alias"));
        }
        if (paramString.has("topic")) {
          localMiPushMessage.setTopic(paramString.getString("topic"));
        }
        if (paramString.has("user_account")) {
          localMiPushMessage.setUserAccount(paramString.getString("user_account"));
        }
        if (paramString.has("notifyId")) {
          localMiPushMessage.setNotifyId(paramString.getInt("notifyId"));
        }
        if (paramString.has("category")) {
          localMiPushMessage.setCategory(paramString.getString("category"));
        }
        if (paramString.has("isNotified")) {
          localMiPushMessage.setNotified(paramString.getBoolean("isNotified"));
        }
        if (paramString.has("extra"))
        {
          paramString = paramString.getJSONObject("extra");
          Iterator localIterator = paramString.keys();
          HashMap localHashMap = new HashMap();
          while ((localIterator != null) && (localIterator.hasNext()))
          {
            String str = (String)localIterator.next();
            localHashMap.put(str, paramString.getString(str));
          }
          if (localHashMap.size() > 0)
          {
            localMiPushMessage.setExtra(localHashMap);
            return localMiPushMessage;
          }
        }
      }
      catch (Exception paramString)
      {
        b.d(paramString.toString());
      }
    }
    return localMiPushMessage;
  }
  
  protected static PushMessageReceiver a(Context paramContext)
  {
    Object localObject1 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    ((Intent)localObject1).setPackage(paramContext.getPackageName());
    Object localObject2 = paramContext.getPackageManager();
    for (;;)
    {
      try
      {
        localObject1 = ((PackageManager)localObject2).queryBroadcastReceivers((Intent)localObject1, 32);
        if (localObject1 != null)
        {
          localObject2 = ((List)localObject1).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = (ResolveInfo)((Iterator)localObject2).next();
            if ((((ResolveInfo)localObject1).activityInfo == null) || (!((ResolveInfo)localObject1).activityInfo.packageName.equals(paramContext.getPackageName()))) {
              continue;
            }
            if (localObject1 != null)
            {
              paramContext = (PushMessageReceiver)t.a(paramContext, ((ResolveInfo)localObject1).activityInfo.name).newInstance();
              return paramContext;
            }
            return null;
          }
        }
      }
      catch (Exception paramContext)
      {
        b.d(paramContext.toString());
        return null;
      }
      localObject1 = null;
    }
  }
  
  protected static String a(Context paramContext, String paramString)
  {
    try
    {
      paramString = (String)a.get(paramString);
      paramContext = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramContext = "";
      }
      return paramContext;
    }
    finally {}
  }
  
  public static String a(d paramd)
  {
    int i = j.a[paramd.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return null;
          }
          return "ftos_push_token";
        }
        return "cos_push_token";
      }
      return "fcm_push_token";
    }
    return "hms_push_token";
  }
  
  public static HashMap<String, String> a(Context paramContext, d paramd)
  {
    HashMap localHashMap = new HashMap();
    String str = a(paramd);
    if (TextUtils.isEmpty(str)) {
      return localHashMap;
    }
    int i = j.a[paramd.ordinal()];
    Object localObject = null;
    paramd = null;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            paramContext = (Context)localObject;
            break label387;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("brand:");
          paramd = an.e;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("brand:");
          paramd = an.d;
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("brand:");
        paramd = an.c;
      }
      ((StringBuilder)localObject).append(paramd.name());
      ((StringBuilder)localObject).append("~");
      ((StringBuilder)localObject).append("token");
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(a(paramContext, str));
      ((StringBuilder)localObject).append("~");
      ((StringBuilder)localObject).append("package_name");
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      paramContext = ((StringBuilder)localObject).toString();
    }
    else
    {
      try
      {
        localObject = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
        paramd = (d)localObject;
      }
      catch (Exception localException)
      {
        b.d(localException.toString());
      }
      i = -1;
      if (paramd != null) {
        i = paramd.metaData.getInt("com.huawei.hms.client.appid");
      }
      paramd = new StringBuilder();
      paramd.append("brand:");
      paramd.append(m.a(paramContext).name());
      paramd.append("~");
      paramd.append("token");
      paramd.append(":");
      paramd.append(a(paramContext, str));
      paramd.append("~");
      paramd.append("package_name");
      paramd.append(":");
      paramd.append(paramContext.getPackageName());
      paramd.append("~");
      paramd.append("app_id");
      paramd.append(":");
      paramd.append(i);
      paramContext = paramd.toString();
    }
    label387:
    localHashMap.put("RegInfo", paramContext);
    return localHashMap;
  }
  
  static void a(Context paramContext)
  {
    int j = 0;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("mipush_extra", 0);
    String str1 = a(d.a);
    String str2 = a(d.b);
    int i = j;
    if (!TextUtils.isEmpty(localSharedPreferences.getString(str1, "")))
    {
      i = j;
      if (TextUtils.isEmpty(localSharedPreferences.getString(str2, ""))) {
        i = 1;
      }
    }
    if (i != 0) {
      aw.a(paramContext).a(2, str1);
    }
  }
  
  public static void a(Context paramContext, d paramd)
  {
    paramd = a(paramd);
    if (TextUtils.isEmpty(paramd)) {
      return;
    }
    r.a(paramContext.getSharedPreferences("mipush_extra", 0).edit().putString(paramd, ""));
  }
  
  public static void a(Context paramContext, d paramd, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = paramContext.getSharedPreferences("mipush_extra", 0);
      String str = a(paramd);
      if (TextUtils.isEmpty(str))
      {
        b.a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
        return;
      }
      localObject = ((SharedPreferences)localObject).getString(str, "");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramString.equals(localObject)))
      {
        b.a("ASSEMBLE_PUSH : do not need to send token");
        return;
      }
      b.a("ASSEMBLE_PUSH : send token upload");
      a(paramd, paramString);
      paramString = k.a(paramd);
      if (paramString == null) {
        return;
      }
      aw.a(paramContext).a(null, paramString, paramd);
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Bundle localBundle = paramIntent.getExtras();
      if ((localBundle != null) && (localBundle.containsKey("pushMsg"))) {
        paramIntent.putExtra("key_message", a(localBundle.getString("pushMsg")));
      }
    }
  }
  
  private static void a(d paramd, String paramString)
  {
    try
    {
      paramd = a(paramd);
      if (TextUtils.isEmpty(paramd))
      {
        b.a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
        return;
      }
      if (TextUtils.isEmpty(paramString))
      {
        b.a("ASSEMBLE_PUSH : token is null");
        return;
      }
      a.put(paramd, paramString);
      return;
    }
    finally {}
  }
  
  public static void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("error code = ");
    localStringBuilder.append(paramInt);
    MiTinyDataClient.upload("hms_push_error", paramString, 1L, localStringBuilder.toString());
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return az.b(paramContext);
  }
  
  public static boolean a(Context paramContext, d paramd)
  {
    if (k.a(paramd) != null) {
      return ah.a(paramContext).a(k.a(paramd).a(), true);
    }
    return false;
  }
  
  public static String b(d paramd)
  {
    int i = j.a[paramd.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return null;
          }
          return "ftos_push_error";
        }
        return "cos_push_error";
      }
      return "fcm_push_error";
    }
    return "hms_push_error";
  }
  
  public static void b(Context paramContext)
  {
    e.a(paramContext).register();
  }
  
  public static void b(Context paramContext, d paramd, String paramString)
  {
    ai.a(paramContext).a(new i(paramString, paramContext, paramd));
  }
  
  public static void c(Context paramContext)
  {
    e.a(paramContext).unregister();
  }
  
  private static void d(Context paramContext, d paramd, String paramString)
  {
    try
    {
      paramd = a(paramd);
      if (TextUtils.isEmpty(paramd))
      {
        b.a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
        return;
      }
      r.a(paramContext.getSharedPreferences("mipush_extra", 0).edit().putString(paramd, paramString));
      paramContext = new StringBuilder();
      paramContext.append("ASSEMBLE_PUSH : update sp file success!  ");
      paramContext.append(paramString);
      b.a(paramContext.toString());
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */