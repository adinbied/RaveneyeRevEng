package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class HWPushHelper
{
  private static boolean a;
  
  public static void convertMessage(Intent paramIntent)
  {
    h.a(paramIntent);
  }
  
  public static boolean hasNetwork(Context paramContext)
  {
    return h.a(paramContext);
  }
  
  public static boolean isHmsTokenSynced(Context paramContext)
  {
    String str = h.a(d.a);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    str = h.a(paramContext, str);
    paramContext = am.a(paramContext).a(bb.c);
    return (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramContext)) && ("synced".equals(paramContext));
  }
  
  public static boolean isUserOpenHmsPush(Context paramContext)
  {
    return MiPushClient.getOpenHmsPush(paramContext);
  }
  
  public static boolean needConnect()
  {
    return a;
  }
  
  public static void notifyHmsNotificationMessageClicked(Context paramContext, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    Object localObject = str;
    if (!bool) {
      try
      {
        paramString = new JSONArray(paramString);
        localObject = str;
        if (paramString.length() > 0)
        {
          int i = 0;
          for (;;)
          {
            localObject = str;
            if (i >= paramString.length()) {
              break;
            }
            localObject = paramString.getJSONObject(i);
            if (((JSONObject)localObject).has("pushMsg"))
            {
              localObject = ((JSONObject)localObject).getString("pushMsg");
              break;
            }
            i += 1;
          }
        }
        paramString = h.a(paramContext);
      }
      catch (Exception paramString)
      {
        b.d(paramString.toString());
        localObject = str;
      }
    }
    if (paramString != null)
    {
      localObject = h.a((String)localObject);
      if (((MiPushMessage)localObject).getExtra().containsKey("notify_effect")) {
        return;
      }
      paramString.onNotificationMessageClicked(paramContext, (MiPushMessage)localObject);
    }
  }
  
  public static void notifyHmsPassThoughMessageArrived(Context paramContext, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        str1 = str2;
        if (paramString.has("content")) {
          str1 = paramString.getString("content");
        }
      }
    }
    catch (Exception paramString)
    {
      b.d(paramString.toString());
      str1 = str2;
    }
    paramString = h.a(paramContext);
    if (paramString != null) {
      paramString.onReceivePassThroughMessage(paramContext, h.a(str1));
    }
  }
  
  public static void registerHuaWeiAssemblePush(Context paramContext)
  {
    paramContext = e.a(paramContext).a(d.a);
    if (paramContext != null) {
      paramContext.register();
    }
  }
  
  public static void reportError(String paramString, int paramInt)
  {
    h.a(paramString, paramInt);
  }
  
  public static void setConnectTime(Context paramContext)
  {
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void setGetTokenTime(Context paramContext)
  {
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().putLong("last_get_token_time", System.currentTimeMillis()).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void setNeedConnect(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static boolean shouldGetToken(Context paramContext)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getSharedPreferences("mipush_extra", 0);
      long l = Math.abs(System.currentTimeMillis() - paramContext.getLong("last_get_token_time", -1L));
      if (l > 172800000L) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean shouldTryConnect(Context paramContext)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getSharedPreferences("mipush_extra", 0);
      long l = Math.abs(System.currentTimeMillis() - paramContext.getLong("last_connect_time", -1L));
      if (l > 5000L) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void uploadToken(Context paramContext, String paramString)
  {
    h.a(paramContext, d.a, paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\HWPushHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */