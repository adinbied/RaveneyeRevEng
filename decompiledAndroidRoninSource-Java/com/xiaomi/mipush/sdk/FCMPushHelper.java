package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.Map;

public class FCMPushHelper
{
  public static void clearToken(Context paramContext)
  {
    h.a(paramContext, d.b);
  }
  
  public static void convertMessage(Intent paramIntent)
  {
    h.a(paramIntent);
  }
  
  public static boolean isFCMSwitchOpen(Context paramContext)
  {
    return (h.a(paramContext, d.b)) && (MiPushClient.getOpenFCMPush(paramContext));
  }
  
  public static void notifyFCMNotificationCome(Context paramContext, Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("pushMsg");
    if (!TextUtils.isEmpty(paramMap))
    {
      PushMessageReceiver localPushMessageReceiver = h.a(paramContext);
      if (localPushMessageReceiver != null) {
        localPushMessageReceiver.onNotificationMessageArrived(paramContext, h.a(paramMap));
      }
    }
  }
  
  public static void notifyFCMPassThoughMessageCome(Context paramContext, Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("pushMsg");
    if (!TextUtils.isEmpty(paramMap))
    {
      PushMessageReceiver localPushMessageReceiver = h.a(paramContext);
      if (localPushMessageReceiver != null) {
        localPushMessageReceiver.onReceivePassThroughMessage(paramContext, h.a(paramMap));
      }
    }
  }
  
  public static void reportFCMMessageDelete()
  {
    MiTinyDataClient.upload(h.b(d.b), "fcm", 1L, "some fcm messages was deleted ");
  }
  
  public static void uploadToken(Context paramContext, String paramString)
  {
    h.a(paramContext, d.b, paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\FCMPushHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */