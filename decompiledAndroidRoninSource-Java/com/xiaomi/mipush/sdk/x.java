package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.aq;
import com.xiaomi.push.t;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class x
{
  private static ActivityInfo a(PackageManager paramPackageManager, Intent paramIntent, Class<?> paramClass)
  {
    paramPackageManager = paramPackageManager.queryBroadcastReceivers(paramIntent, 16384).iterator();
    while (paramPackageManager.hasNext())
    {
      paramIntent = ((ResolveInfo)paramPackageManager.next()).activityInfo;
      if ((paramIntent != null) && (paramClass.getCanonicalName().equals(paramIntent.name))) {
        return paramIntent;
      }
    }
    return null;
  }
  
  public static void a(Context paramContext)
  {
    new Thread(new y(paramContext)).start();
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    paramString1 = new Intent(paramString1);
    paramString1.setPackage(paramContext);
    paramContext = localPackageManager.queryBroadcastReceivers(paramString1, 16384).iterator();
    int j = 0;
    int i;
    do
    {
      i = j;
      if (!paramContext.hasNext()) {
        break;
      }
      paramString1 = ((ResolveInfo)paramContext.next()).activityInfo;
      if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.name)) && (paramString1.name.equals(paramString2))) {
        i = 1;
      } else {
        i = 0;
      }
      j = i;
    } while (i == 0);
    if (i != 0) {
      return;
    }
    throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", new Object[] { paramString2 }));
  }
  
  private static void a(ActivityInfo paramActivityInfo, Boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean[0].booleanValue() == paramActivityInfo.enabled)
    {
      if (paramArrayOfBoolean[1].booleanValue() == paramActivityInfo.exported) {
        return;
      }
      throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", new Object[] { paramActivityInfo.name, paramArrayOfBoolean[1] }));
    }
    throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", new Object[] { paramActivityInfo.name, paramArrayOfBoolean[0] }));
  }
  
  private static boolean a(PackageInfo paramPackageInfo, String[] paramArrayOfString)
  {
    paramPackageInfo = paramPackageInfo.services;
    int j = paramPackageInfo.length;
    int i = 0;
    while (i < j)
    {
      if (a(paramArrayOfString, paramPackageInfo[i].name)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static boolean a(String[] paramArrayOfString, String paramString)
  {
    if (paramArrayOfString != null)
    {
      if (paramString == null) {
        return false;
      }
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (TextUtils.equals(paramArrayOfString[i], paramString)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private static void c(Context paramContext)
  {
    Object localObject1 = paramContext.getPackageManager();
    Object localObject2 = paramContext.getPackageName();
    Object localObject3 = new Intent(aq.o);
    ((Intent)localObject3).setPackage((String)localObject2);
    try
    {
      localObject3 = a((PackageManager)localObject1, (Intent)localObject3, t.a(paramContext, "com.xiaomi.push.service.receivers.PingReceiver"));
      if (!MiPushClient.shouldUseMIUIPush(paramContext))
      {
        if (localObject3 != null) {
          a((ActivityInfo)localObject3, new Boolean[] { Boolean.valueOf(true), Boolean.valueOf(false) });
        } else {
          throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", new Object[] { "com.xiaomi.push.service.receivers.PingReceiver" }));
        }
      }
      else if (localObject3 != null) {
        a((ActivityInfo)localObject3, new Boolean[] { Boolean.valueOf(true), Boolean.valueOf(false) });
      }
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      b.a(localClassNotFoundException2);
    }
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.setPackage((String)localObject2);
    localObject1 = ((PackageManager)localObject1).queryBroadcastReceivers(localIntent, 16384).iterator();
    int j = 0;
    int i;
    do
    {
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          break label276;
        }
        localObject2 = ((ResolveInfo)((Iterator)localObject1).next()).activityInfo;
        if (localObject2 == null) {
          break;
        }
        try
        {
          if ((TextUtils.isEmpty(((ActivityInfo)localObject2).name)) || (!PushMessageReceiver.class.isAssignableFrom(t.a(paramContext, ((ActivityInfo)localObject2).name)))) {
            break;
          }
          boolean bool = ((ActivityInfo)localObject2).enabled;
          if (!bool) {
            break;
          }
          i = 1;
        }
        catch (ClassNotFoundException localClassNotFoundException1)
        {
          b.a(localClassNotFoundException1);
        }
      }
      i = 0;
      j = i;
    } while (i == 0);
    label276:
    if (i != 0)
    {
      if (MiPushClient.getOpenHmsPush(paramContext))
      {
        a(paramContext, "com.huawei.android.push.intent.RECEIVE", "com.xiaomi.assemble.control.HmsPushReceiver");
        a(paramContext, "com.huawei.intent.action.PUSH", "com.huawei.hms.support.api.push.PushEventReceiver");
      }
      if (MiPushClient.getOpenVIVOPush(paramContext)) {
        a(paramContext, "com.vivo.pushclient.action.RECEIVE", "com.xiaomi.assemble.control.FTOSPushMessageReceiver");
      }
      return;
    }
    throw new a("Receiver: none of the subclasses of PushMessageReceiver is enabled or defined.");
  }
  
  private static void c(Context paramContext, PackageInfo paramPackageInfo)
  {
    HashSet localHashSet = new HashSet();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getPackageName());
    ((StringBuilder)localObject).append(".permission.MIPUSH_RECEIVE");
    paramContext = ((StringBuilder)localObject).toString();
    localHashSet.addAll(Arrays.asList(new String[] { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", paramContext, "android.permission.ACCESS_WIFI_STATE", "android.permission.READ_PHONE_STATE", "android.permission.GET_TASKS", "android.permission.VIBRATE" }));
    int j;
    if (paramPackageInfo.permissions != null)
    {
      localObject = paramPackageInfo.permissions;
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        if (paramContext.equals(localObject[i].name))
        {
          i = 1;
          break label145;
        }
        i += 1;
      }
    }
    int i = 0;
    label145:
    if (i != 0)
    {
      if (paramPackageInfo.requestedPermissions != null)
      {
        paramContext = paramPackageInfo.requestedPermissions;
        j = paramContext.length;
        i = 0;
        while (i < j)
        {
          paramPackageInfo = paramContext[i];
          if ((!TextUtils.isEmpty(paramPackageInfo)) && (localHashSet.contains(paramPackageInfo)))
          {
            localHashSet.remove(paramPackageInfo);
            if (localHashSet.isEmpty()) {
              break;
            }
          }
          i += 1;
        }
      }
      if (localHashSet.isEmpty()) {
        return;
      }
      throw new a(String.format("<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest.", new Object[] { localHashSet.iterator().next() }));
    }
    throw new a(String.format("<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest.", new Object[] { paramContext }));
  }
  
  private static void d(Context paramContext, PackageInfo paramPackageInfo)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put(PushMessageHandler.class.getCanonicalName(), new b(PushMessageHandler.class.getCanonicalName(), true, true, ""));
    localHashMap2.put(MessageHandleService.class.getCanonicalName(), new b(MessageHandleService.class.getCanonicalName(), true, false, ""));
    if (MiPushClient.shouldUseMIUIPush(paramContext))
    {
      if (!a(paramPackageInfo, new String[] { "com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService" })) {}
    }
    else
    {
      localHashMap2.put("com.xiaomi.push.service.XMJobService", new b("com.xiaomi.push.service.XMJobService", true, false, "android.permission.BIND_JOB_SERVICE"));
      localHashMap2.put("com.xiaomi.push.service.XMPushService", new b("com.xiaomi.push.service.XMPushService", true, false, ""));
    }
    if (MiPushClient.getOpenFCMPush(paramContext))
    {
      localHashMap2.put("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", new b("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", true, false, ""));
      localHashMap2.put("com.xiaomi.assemble.control.MiFirebaseMessagingService", new b("com.xiaomi.assemble.control.MiFirebaseMessagingService", true, false, ""));
    }
    if (MiPushClient.getOpenOPPOPush(paramContext)) {
      localHashMap2.put("com.xiaomi.assemble.control.COSPushMessageService", new b("com.xiaomi.assemble.control.COSPushMessageService", true, true, "com.coloros.mcs.permission.SEND_MCS_MESSAGE"));
    }
    if (paramPackageInfo.services != null)
    {
      paramContext = paramPackageInfo.services;
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        paramPackageInfo = paramContext[i];
        if ((!TextUtils.isEmpty(paramPackageInfo.name)) && (localHashMap2.containsKey(paramPackageInfo.name)))
        {
          Object localObject = (b)localHashMap2.remove(paramPackageInfo.name);
          boolean bool1 = ((b)localObject).a;
          boolean bool2 = ((b)localObject).jdField_b_of_type_Boolean;
          localObject = ((b)localObject).jdField_b_of_type_JavaLangString;
          if (bool1 == paramPackageInfo.enabled)
          {
            if (bool2 == paramPackageInfo.exported)
            {
              if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.equals((CharSequence)localObject, paramPackageInfo.permission))) {
                throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\".", new Object[] { paramPackageInfo.name, localObject }));
              }
              localHashMap1.put(paramPackageInfo.name, paramPackageInfo.processName);
              if (localHashMap2.isEmpty()) {
                break;
              }
            }
            else
            {
              throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", new Object[] { paramPackageInfo.name, Boolean.valueOf(bool2) }));
            }
          }
          else {
            throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", new Object[] { paramPackageInfo.name, Boolean.valueOf(bool1) }));
          }
        }
        i += 1;
      }
    }
    if (localHashMap2.isEmpty())
    {
      if (TextUtils.equals((CharSequence)localHashMap1.get(PushMessageHandler.class.getCanonicalName()), (CharSequence)localHashMap1.get(MessageHandleService.class.getCanonicalName())))
      {
        if ((localHashMap1.containsKey("com.xiaomi.push.service.XMJobService")) && (localHashMap1.containsKey("com.xiaomi.push.service.XMPushService")))
        {
          if (TextUtils.equals((CharSequence)localHashMap1.get("com.xiaomi.push.service.XMJobService"), (CharSequence)localHashMap1.get("com.xiaomi.push.service.XMPushService"))) {
            return;
          }
          throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", new Object[] { "com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService" }));
        }
        return;
      }
      throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", new Object[] { PushMessageHandler.class.getCanonicalName(), MessageHandleService.class.getCanonicalName() }));
    }
    throw new a(String.format("<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", new Object[] { localHashMap2.keySet().iterator().next() }));
  }
  
  public static class a
    extends RuntimeException
  {
    public a(String paramString)
    {
      super();
    }
  }
  
  public static class b
  {
    public String a;
    public boolean a;
    public String b;
    public boolean b;
    
    public b(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_Boolean = paramBoolean1;
      this.jdField_b_of_type_Boolean = paramBoolean2;
      this.jdField_b_of_type_JavaLangString = paramString2;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */