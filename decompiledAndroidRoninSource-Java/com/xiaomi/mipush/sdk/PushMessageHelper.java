package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.push.ia;
import com.xiaomi.push.ib;
import com.xiaomi.push.ir;
import java.util.List;

public class PushMessageHelper
{
  public static final String ERROR_MESSAGE = "error_message";
  public static final String ERROR_TYPE = "error_type";
  public static final String ERROR_TYPE_NEED_PERMISSION = "error_lack_of_permission";
  public static final String KEY_COMMAND = "key_command";
  public static final String KEY_MESSAGE = "key_message";
  public static final int MESSAGE_COMMAND = 3;
  public static final int MESSAGE_ERROR = 5;
  public static final int MESSAGE_QUIT = 4;
  public static final int MESSAGE_RAW = 1;
  public static final int MESSAGE_SENDMESSAGE = 2;
  public static final String MESSAGE_TYPE = "message_type";
  public static final int PUSH_MODE_BROADCAST = 2;
  public static final int PUSH_MODE_CALLBACK = 1;
  private static int pushMode;
  
  public static MiPushCommandMessage generateCommandMessage(String paramString1, List<String> paramList, long paramLong, String paramString2, String paramString3)
  {
    MiPushCommandMessage localMiPushCommandMessage = new MiPushCommandMessage();
    localMiPushCommandMessage.setCommand(paramString1);
    localMiPushCommandMessage.setCommandArguments(paramList);
    localMiPushCommandMessage.setResultCode(paramLong);
    localMiPushCommandMessage.setReason(paramString2);
    localMiPushCommandMessage.setCategory(paramString3);
    return localMiPushCommandMessage;
  }
  
  public static MiPushMessage generateMessage(ir paramir, ib paramib, boolean paramBoolean)
  {
    MiPushMessage localMiPushMessage = new MiPushMessage();
    localMiPushMessage.setMessageId(paramir.a());
    if (!TextUtils.isEmpty(paramir.d()))
    {
      localMiPushMessage.setMessageType(1);
      localMiPushMessage.setAlias(paramir.d());
    }
    else if (!TextUtils.isEmpty(paramir.c()))
    {
      localMiPushMessage.setMessageType(2);
      localMiPushMessage.setTopic(paramir.c());
    }
    else if (!TextUtils.isEmpty(paramir.f()))
    {
      localMiPushMessage.setMessageType(3);
      localMiPushMessage.setUserAccount(paramir.f());
    }
    else
    {
      localMiPushMessage.setMessageType(0);
    }
    localMiPushMessage.setCategory(paramir.e());
    if (paramir.a() != null) {
      localMiPushMessage.setContent(paramir.a().c());
    }
    if (paramib != null)
    {
      if (TextUtils.isEmpty(localMiPushMessage.getMessageId())) {
        localMiPushMessage.setMessageId(paramib.a());
      }
      if (TextUtils.isEmpty(localMiPushMessage.getTopic())) {
        localMiPushMessage.setTopic(paramib.b());
      }
      localMiPushMessage.setDescription(paramib.d());
      localMiPushMessage.setTitle(paramib.c());
      localMiPushMessage.setNotifyType(paramib.a());
      localMiPushMessage.setNotifyId(paramib.c());
      localMiPushMessage.setPassThrough(paramib.b());
      localMiPushMessage.setExtra(paramib.a());
    }
    localMiPushMessage.setNotified(paramBoolean);
    return localMiPushMessage;
  }
  
  public static ib generateMessage(MiPushMessage paramMiPushMessage)
  {
    ib localib = new ib();
    localib.a(paramMiPushMessage.getMessageId());
    localib.b(paramMiPushMessage.getTopic());
    localib.d(paramMiPushMessage.getDescription());
    localib.c(paramMiPushMessage.getTitle());
    localib.c(paramMiPushMessage.getNotifyId());
    localib.a(paramMiPushMessage.getNotifyType());
    localib.b(paramMiPushMessage.getPassThrough());
    localib.a(paramMiPushMessage.getExtra());
    return localib;
  }
  
  public static int getPushMode(Context paramContext)
  {
    if (pushMode == 0)
    {
      int i;
      if (isUseCallbackPushMode(paramContext)) {
        i = 1;
      } else {
        i = 2;
      }
      setPushMode(i);
    }
    return pushMode;
  }
  
  private static boolean isIntentAvailable(Context paramContext, Intent paramIntent)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.queryBroadcastReceivers(paramIntent, 32);
      if (paramContext != null)
      {
        boolean bool = paramContext.isEmpty();
        if (!bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramContext) {}
    return true;
  }
  
  public static boolean isUseCallbackPushMode(Context paramContext)
  {
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.setClassName(paramContext.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
    return isIntentAvailable(paramContext, localIntent);
  }
  
  public static void sendCommandMessageBroadcast(Context paramContext, MiPushCommandMessage paramMiPushCommandMessage)
  {
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("message_type", 3);
    localIntent.putExtra("key_command", paramMiPushCommandMessage);
    new PushServiceReceiver().onReceive(paramContext, localIntent);
  }
  
  public static void sendQuitMessageBroadcast(Context paramContext)
  {
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("message_type", 4);
    new PushServiceReceiver().onReceive(paramContext, localIntent);
  }
  
  private static void setPushMode(int paramInt)
  {
    pushMode = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\PushMessageHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */