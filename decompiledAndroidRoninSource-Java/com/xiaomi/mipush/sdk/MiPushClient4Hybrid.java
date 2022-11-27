package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.push.bf;
import com.xiaomi.push.fi;
import com.xiaomi.push.g;
import com.xiaomi.push.g.a;
import com.xiaomi.push.ho;
import com.xiaomi.push.hy;
import com.xiaomi.push.i;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.ie;
import com.xiaomi.push.in;
import com.xiaomi.push.io;
import com.xiaomi.push.ip;
import com.xiaomi.push.iu;
import com.xiaomi.push.iv;
import com.xiaomi.push.iy;
import com.xiaomi.push.iz;
import com.xiaomi.push.l;
import com.xiaomi.push.service.aa;
import com.xiaomi.push.service.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MiPushClient4Hybrid
{
  private static Map<String, b.a> dataMap = new HashMap();
  private static MiPushCallback sCallback;
  private static Map<String, Long> sRegisterTimeMap = new HashMap();
  
  private static void addPullNotificationTime(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_pull_notification_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    paramContext.edit().putLong(paramString, System.currentTimeMillis()).commit();
  }
  
  private static short getDeviceStatus(MiPushMessage paramMiPushMessage, boolean paramBoolean)
  {
    if (paramMiPushMessage.getExtra() == null) {
      paramMiPushMessage = "";
    } else {
      paramMiPushMessage = (String)paramMiPushMessage.getExtra().get("__hybrid_device_status");
    }
    int i = 0;
    if (!TextUtils.isEmpty(paramMiPushMessage)) {
      i = Integer.valueOf(paramMiPushMessage).intValue();
    }
    int j = i;
    if (!paramBoolean) {
      j = (i & 0xFFFFFFFC) + g.a.c.a();
    }
    return (short)j;
  }
  
  public static boolean isRegistered(Context paramContext, String paramString)
  {
    return b.a(paramContext).a(paramString) != null;
  }
  
  public static void onReceiveRegisterResult(Context paramContext, ip paramip)
  {
    String str = paramip.b();
    if (paramip.a() == 0L)
    {
      b.a locala = (b.a)dataMap.get(str);
      if (locala != null)
      {
        locala.a(paramip.e, paramip.f);
        b.a(paramContext).a(str, locala);
      }
    }
    paramContext = null;
    if (!TextUtils.isEmpty(paramip.e))
    {
      paramContext = new ArrayList();
      paramContext.add(paramip.e);
    }
    paramContext = PushMessageHelper.generateCommandMessage(fi.jdField_a_of_type_ComXiaomiPushFi.jdField_a_of_type_JavaLangString, paramContext, paramip.a, paramip.d, null);
    paramip = sCallback;
    if (paramip != null) {
      paramip.onReceiveRegisterResult(str, paramContext);
    }
  }
  
  public static void onReceiveUnregisterResult(Context paramContext, iv paramiv)
  {
    paramContext = PushMessageHelper.generateCommandMessage(fi.b.jdField_a_of_type_JavaLangString, null, paramiv.a, paramiv.d, null);
    paramiv = paramiv.a();
    MiPushCallback localMiPushCallback = sCallback;
    if (localMiPushCallback != null) {
      localMiPushCallback.onReceiveUnregisterResult(paramiv, paramContext);
    }
  }
  
  public static void registerPush(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    if (b.a(paramContext).a(paramString2, paramString3, paramString1))
    {
      paramString3 = new ArrayList();
      localObject = b.a(paramContext).a(paramString1);
      if (localObject != null)
      {
        paramString3.add(((b.a)localObject).c);
        paramString3 = PushMessageHelper.generateCommandMessage(fi.jdField_a_of_type_ComXiaomiPushFi.jdField_a_of_type_JavaLangString, paramString3, 0L, null, null);
        localObject = sCallback;
        if (localObject != null) {
          ((MiPushCallback)localObject).onReceiveRegisterResult(paramString1, paramString3);
        }
      }
      if (shouldPullNotification(paramContext, paramString1))
      {
        paramString3 = new in();
        paramString3.b(paramString2);
        paramString3.c(hy.j.jdField_a_of_type_JavaLangString);
        paramString3.a(ak.a());
        paramString3.a(false);
        aw.a(paramContext).a(paramString3, ho.i, false, true, null, false, paramString1, paramString2);
        com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
        addPullNotificationTime(paramContext, paramString1);
      }
    }
    else
    {
      long l2 = System.currentTimeMillis();
      long l1;
      if (sRegisterTimeMap.get(paramString1) != null) {
        l1 = ((Long)sRegisterTimeMap.get(paramString1)).longValue();
      } else {
        l1 = 0L;
      }
      if (Math.abs(l2 - l1) < 5000L)
      {
        com.xiaomi.channel.commonutils.logger.b.a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
        return;
      }
      sRegisterTimeMap.put(paramString1, Long.valueOf(l2));
      String str = bf.a(6);
      localObject = new b.a(paramContext);
      ((b.a)localObject).c(paramString2, paramString3, str);
      dataMap.put(paramString1, localObject);
      localObject = new io();
      ((io)localObject).a(ak.a());
      ((io)localObject).b(paramString2);
      ((io)localObject).e(paramString3);
      ((io)localObject).d(paramString1);
      ((io)localObject).f(str);
      ((io)localObject).c(g.a(paramContext, paramContext.getPackageName()));
      ((io)localObject).b(g.a(paramContext, paramContext.getPackageName()));
      ((io)localObject).h("3_7_0");
      ((io)localObject).a(30700);
      ((io)localObject).i(i.e(paramContext));
      ((io)localObject).a(ic.c);
      if (!l.d())
      {
        paramString1 = i.g(paramContext);
        if (!TextUtils.isEmpty(paramString1))
        {
          if (l.b()) {
            ((io)localObject).j(paramString1);
          }
          ((io)localObject).l(bf.a(paramString1));
        }
      }
      ((io)localObject).k(i.a());
      int i = i.a();
      if (i >= 0) {
        ((io)localObject).c(i);
      }
      paramString1 = new in();
      paramString1.c(hy.I.jdField_a_of_type_JavaLangString);
      paramString1.b(b.a(paramContext).a());
      paramString1.d(paramContext.getPackageName());
      paramString1.a(iy.a((iz)localObject));
      paramString1.a(ak.a());
      aw.a(paramContext).a(paramString1, ho.i, null);
    }
  }
  
  public static void removeDuplicateCache(Context paramContext, MiPushMessage paramMiPushMessage)
  {
    String str1;
    if (paramMiPushMessage.getExtra() != null) {
      str1 = (String)paramMiPushMessage.getExtra().get("jobkey");
    } else {
      str1 = null;
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = paramMiPushMessage.getMessageId();
    }
    at.a(paramContext, str2);
  }
  
  public static void reportMessageArrived(Context paramContext, MiPushMessage paramMiPushMessage, boolean paramBoolean)
  {
    if ((paramMiPushMessage != null) && (paramMiPushMessage.getExtra() != null))
    {
      try
      {
        ie localie = new ie();
        localie.b(b.a(paramContext).a());
        localie.a(paramMiPushMessage.getMessageId());
        localie.a(Long.valueOf((String)paramMiPushMessage.getExtra().get("__hybrid_message_ts")).longValue());
        localie.a(getDeviceStatus(paramMiPushMessage, paramBoolean));
        if (!TextUtils.isEmpty(paramMiPushMessage.getTopic())) {
          localie.c(paramMiPushMessage.getTopic());
        }
        ib localib = PushMessageHelper.generateMessage(paramMiPushMessage);
        aw.a(paramContext).a(localie, ho.f, false, localib);
        paramContext = new StringBuilder();
        paramContext.append("MiPushClient4Hybrid ack mina message, messageId is ");
        paramContext.append(paramMiPushMessage.getMessageId());
        com.xiaomi.channel.commonutils.logger.b.b(paramContext.toString());
      }
      finally {}
      try
      {
        com.xiaomi.channel.commonutils.logger.b.a(paramContext);
        return;
      }
      finally
      {
        paramMiPushMessage.getExtra().remove("__hybrid_message_ts");
        paramMiPushMessage.getExtra().remove("__hybrid_device_status");
      }
    }
    com.xiaomi.channel.commonutils.logger.b.a("do not ack message, message is null");
  }
  
  public static void reportMessageClicked(Context paramContext, MiPushMessage paramMiPushMessage)
  {
    MiPushClient.reportMessageClicked(paramContext, paramMiPushMessage);
  }
  
  public static void setCallback(MiPushCallback paramMiPushCallback)
  {
    sCallback = paramMiPushCallback;
  }
  
  private static boolean shouldPullNotification(Context paramContext, String paramString)
  {
    boolean bool = false;
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_pull_notification_");
    localStringBuilder.append(paramString);
    long l = paramContext.getLong(localStringBuilder.toString(), -1L);
    if (Math.abs(System.currentTimeMillis() - l) > 300000L) {
      bool = true;
    }
    return bool;
  }
  
  public static void unregisterPush(Context paramContext, String paramString)
  {
    sRegisterTimeMap.remove(paramString);
    Object localObject = b.a(paramContext).a(paramString);
    if (localObject == null) {
      return;
    }
    iu localiu = new iu();
    localiu.a(ak.a());
    localiu.d(paramString);
    localiu.b(((b.a)localObject).jdField_a_of_type_JavaLangString);
    localiu.c(((b.a)localObject).c);
    localiu.e(((b.a)localObject).b);
    localObject = new in();
    ((in)localObject).c(hy.K.jdField_a_of_type_JavaLangString);
    ((in)localObject).b(b.a(paramContext).a());
    ((in)localObject).d(paramContext.getPackageName());
    ((in)localObject).a(iy.a(localiu));
    ((in)localObject).a(ak.a());
    aw.a(paramContext).a((iz)localObject, ho.i, null);
    b.a(paramContext).b(paramString);
  }
  
  public static void uploadClearMessageData(Context paramContext, LinkedList<? extends Object> paramLinkedList)
  {
    aa.a(paramContext, paramLinkedList);
  }
  
  public static class MiPushCallback
  {
    public void onCommandResult(String paramString, MiPushCommandMessage paramMiPushCommandMessage) {}
    
    public void onReceiveRegisterResult(String paramString, MiPushCommandMessage paramMiPushCommandMessage) {}
    
    public void onReceiveUnregisterResult(String paramString, MiPushCommandMessage paramMiPushCommandMessage) {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\MiPushClient4Hybrid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */