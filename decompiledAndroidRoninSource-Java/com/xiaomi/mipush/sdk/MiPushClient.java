package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.push.ai;
import com.xiaomi.push.au;
import com.xiaomi.push.bf;
import com.xiaomi.push.ds;
import com.xiaomi.push.fa;
import com.xiaomi.push.fb;
import com.xiaomi.push.fc;
import com.xiaomi.push.fi;
import com.xiaomi.push.g;
import com.xiaomi.push.ho;
import com.xiaomi.push.ht;
import com.xiaomi.push.hy;
import com.xiaomi.push.i;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.ii;
import com.xiaomi.push.in;
import com.xiaomi.push.io;
import com.xiaomi.push.is;
import com.xiaomi.push.iu;
import com.xiaomi.push.iw;
import com.xiaomi.push.l;
import com.xiaomi.push.m;
import com.xiaomi.push.n;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import com.xiaomi.push.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public abstract class MiPushClient
{
  public static final String COMMAND_REGISTER = "register";
  public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
  public static final String COMMAND_SET_ACCOUNT = "set-account";
  public static final String COMMAND_SET_ALIAS = "set-alias";
  public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
  public static final String COMMAND_UNREGISTER = "unregister";
  public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
  public static final String COMMAND_UNSET_ALIAS = "unset-alias";
  public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
  public static final String PREF_EXTRA = "mipush_extra";
  private static boolean isCrashHandlerSuggested;
  private static Context sContext;
  private static long sCurMsgId = ;
  
  private static boolean acceptTimeSet(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = getAcceptTime(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramString2);
    return TextUtils.equals(paramContext, localStringBuilder.toString());
  }
  
  public static long accountSetTime(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("account_");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), -1L);
  }
  
  static void addAcceptTime(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("mipush_extra", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",");
      localStringBuilder.append(paramString2);
      paramContext.putString("accept_time", localStringBuilder.toString());
      com.xiaomi.push.r.a(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static void addAccount(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("mipush_extra", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("account_");
      localStringBuilder.append(paramString);
      paramContext.putLong(localStringBuilder.toString(), System.currentTimeMillis()).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static void addAlias(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("mipush_extra", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("alias_");
      localStringBuilder.append(paramString);
      paramContext.putLong(localStringBuilder.toString(), System.currentTimeMillis()).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static void addPullNotificationTime(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0).edit();
    paramContext.putLong("last_pull_notification", System.currentTimeMillis());
    com.xiaomi.push.r.a(paramContext);
  }
  
  private static void addRegRequestTime(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0).edit();
    paramContext.putLong("last_reg_request", System.currentTimeMillis());
    com.xiaomi.push.r.a(paramContext);
  }
  
  static void addTopic(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("mipush_extra", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("topic_");
      localStringBuilder.append(paramString);
      paramContext.putLong(localStringBuilder.toString(), System.currentTimeMillis()).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static long aliasSetTime(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("alias_");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), -1L);
  }
  
  public static void awakeApps(Context paramContext, String[] paramArrayOfString)
  {
    ai.a(paramContext).a(new af(paramArrayOfString, paramContext));
  }
  
  private static void awakePushServiceByPackageInfo(Context paramContext, PackageInfo paramPackageInfo)
  {
    Object localObject = paramPackageInfo.services;
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramPackageInfo = localObject[i];
        if ((paramPackageInfo.exported) && (paramPackageInfo.enabled) && ("com.xiaomi.mipush.sdk.PushMessageHandler".equals(paramPackageInfo.name)) && (!paramContext.getPackageName().equals(paramPackageInfo.packageName))) {}
        try
        {
          Thread.sleep((Math.random() * 2.0D + 1.0D) * 1000L);
          localObject = new Intent();
          ((Intent)localObject).setClassName(paramPackageInfo.packageName, paramPackageInfo.name);
          ((Intent)localObject).setAction("com.xiaomi.mipush.sdk.WAKEUP");
          ((Intent)localObject).putExtra("waker_pkgname", paramContext.getPackageName());
          PushMessageHandler.a(paramContext, (Intent)localObject);
          return;
        }
        finally {}
        i += 1;
      }
    }
    else {}
  }
  
  private static void checkNotNull(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      return;
    }
    paramObject = new StringBuilder();
    ((StringBuilder)paramObject).append("param ");
    ((StringBuilder)paramObject).append(paramString);
    ((StringBuilder)paramObject).append(" is not nullable");
    throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
  }
  
  private static boolean checkPermission(Context paramContext)
  {
    boolean bool2 = true;
    Object localObject1;
    Object localObject2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (l.a()) {
        break label140;
      }
      if ("com.xiaomi.xmsf".equals(paramContext.getPackageName()))
      {
        bool1 = bool2;
        break label140;
      }
      if (!TextUtils.isEmpty(i.b(paramContext)))
      {
        bool1 = bool2;
        break label140;
      }
      if ((paramContext.getApplicationInfo().targetSdkVersion >= 23) && (Build.VERSION.SDK_INT >= 23))
      {
        bool1 = bool2;
        if (m.a(paramContext, "android.permission.READ_PHONE_STATE")) {
          break label140;
        }
        bool1 = bool2;
        if (m.a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
          break label140;
        }
        if (au.a(paramContext).a())
        {
          bool1 = bool2;
          break label140;
        }
      }
      else
      {
        localObject1 = i.f(paramContext);
        localObject2 = i.a();
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label140;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          bool1 = bool2;
          break label140;
        }
      }
    }
    boolean bool1 = false;
    label140:
    if (!bool1)
    {
      com.xiaomi.channel.commonutils.logger.b.d("Because of lack of necessary information, mi push can't be initialized");
      localObject2 = new ArrayList();
      if (!m.a(paramContext, "android.permission.READ_PHONE_STATE")) {
        ((ArrayList)localObject2).add("android.permission.READ_PHONE_STATE");
      }
      if (!m.a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
        ((ArrayList)localObject2).add("android.permission.WRITE_EXTERNAL_STORAGE");
      }
      if (!((ArrayList)localObject2).isEmpty())
      {
        localObject1 = new String[((ArrayList)localObject2).size()];
        ((ArrayList)localObject2).toArray((Object[])localObject1);
        localObject2 = new Intent();
        ((Intent)localObject2).setAction("com.xiaomi.mipush.ERROR");
        ((Intent)localObject2).setPackage(paramContext.getPackageName());
        ((Intent)localObject2).putExtra("message_type", 5);
        ((Intent)localObject2).putExtra("error_type", "error_lack_of_permission");
        ((Intent)localObject2).putExtra("error_message", (String[])localObject1);
        paramContext.sendBroadcast((Intent)localObject2);
      }
    }
    return bool1;
  }
  
  protected static void clearExtras(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0).edit();
    paramContext.clear();
    paramContext.commit();
  }
  
  public static void clearLocalNotificationType(Context paramContext)
  {
    aw.a(paramContext).e();
  }
  
  public static void clearNotification(Context paramContext)
  {
    aw.a(paramContext).a(-1);
  }
  
  public static void clearNotification(Context paramContext, int paramInt)
  {
    aw.a(paramContext).a(paramInt);
  }
  
  public static void clearNotification(Context paramContext, String paramString1, String paramString2)
  {
    aw.a(paramContext).a(paramString1, paramString2);
  }
  
  public static void disablePush(Context paramContext)
  {
    aw.a(paramContext).a(true);
  }
  
  public static void enablePush(Context paramContext)
  {
    aw.a(paramContext).a(false);
  }
  
  private static void forceHandleCrash()
  {
    boolean bool = com.xiaomi.push.service.ah.a(sContext).a(ht.av.a(), false);
    if ((!isCrashHandlerSuggested) && (bool)) {
      Thread.setDefaultUncaughtExceptionHandler(new v(sContext));
    }
  }
  
  protected static String getAcceptTime(Context paramContext)
  {
    return paramContext.getSharedPreferences("mipush_extra", 0).getString("accept_time", "00:00-23:59");
  }
  
  public static List<String> getAllAlias(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0).getAll().keySet().iterator();
    while (paramContext.hasNext())
    {
      String str = (String)paramContext.next();
      if (str.startsWith("alias_")) {
        localArrayList.add(str.substring(6));
      }
    }
    return localArrayList;
  }
  
  public static List<String> getAllTopic(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0).getAll().keySet().iterator();
    while (paramContext.hasNext())
    {
      String str = (String)paramContext.next();
      if ((str.startsWith("topic_")) && (!str.contains("**ALL**"))) {
        localArrayList.add(str.substring(6));
      }
    }
    return localArrayList;
  }
  
  public static List<String> getAllUserAccount(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0).getAll().keySet().iterator();
    while (paramContext.hasNext())
    {
      String str = (String)paramContext.next();
      if (str.startsWith("account_")) {
        localArrayList.add(str.substring(8));
      }
    }
    return localArrayList;
  }
  
  public static String getAppRegion(Context paramContext)
  {
    if (b.a(paramContext).c()) {
      return b.a(paramContext).f();
    }
    return null;
  }
  
  private static boolean getDefaultSwitch()
  {
    return l.b();
  }
  
  protected static boolean getOpenFCMPush(Context paramContext)
  {
    checkNotNull(paramContext, "context");
    return e.a(paramContext).b(d.b);
  }
  
  protected static boolean getOpenHmsPush(Context paramContext)
  {
    checkNotNull(paramContext, "context");
    return e.a(paramContext).b(d.a);
  }
  
  protected static boolean getOpenOPPOPush(Context paramContext)
  {
    checkNotNull(paramContext, "context");
    return e.a(paramContext).b(d.c);
  }
  
  protected static boolean getOpenVIVOPush(Context paramContext)
  {
    return e.a(paramContext).b(d.d);
  }
  
  public static String getRegId(Context paramContext)
  {
    if (b.a(paramContext).c()) {
      return b.a(paramContext).c();
    }
    return null;
  }
  
  private static void initEventPerfLogic(Context paramContext)
  {
    fc.a(new ag());
    Config localConfig = fc.a(paramContext);
    ClientReportClient.init(paramContext, localConfig, new fa(paramContext), new fb(paramContext));
    a.a(paramContext);
    r.a(paramContext, localConfig);
    com.xiaomi.push.service.ah.a(paramContext).a(new ah(100, "perf event job update", paramContext));
  }
  
  @Deprecated
  public static void initialize(Context paramContext, String paramString1, String paramString2, MiPushClientCallback paramMiPushClientCallback)
  {
    initialize(paramContext, paramString1, paramString2, paramMiPushClientCallback, null);
  }
  
  private static void initialize(Context paramContext, String paramString1, String paramString2, MiPushClientCallback paramMiPushClientCallback, String paramString3)
  {
    for (;;)
    {
      try
      {
        com.xiaomi.channel.commonutils.logger.b.a("sdk_version = 3_7_0");
        if (paramMiPushClientCallback != null) {
          PushMessageHandler.a(paramMiPushClientCallback);
        }
        if (t.a(sContext)) {
          x.a(sContext);
        }
        if ((!b.a(sContext).a(paramString1, paramString2)) && (!checkPermission(sContext))) {
          return;
        }
        if (b.a(sContext).a() != Constants.a())
        {
          bool1 = true;
          if ((!bool1) && (!shouldSendRegRequest(sContext)))
          {
            aw.a(sContext).a();
            com.xiaomi.channel.commonutils.logger.b.a("Could not send  register message within 5s repeatly .");
            return;
          }
          if ((!bool1) && (b.a(sContext).a(paramString1, paramString2)) && (!b.a(sContext).e()))
          {
            if (1 == PushMessageHelper.getPushMode(sContext))
            {
              checkNotNull(paramMiPushClientCallback, "callback");
              paramMiPushClientCallback.onInitializeResult(0L, null, b.a(sContext).c());
            }
            else
            {
              paramString2 = new ArrayList();
              paramString2.add(b.a(sContext).c());
              paramString2 = PushMessageHelper.generateCommandMessage(fi.jdField_a_of_type_ComXiaomiPushFi.jdField_a_of_type_JavaLangString, paramString2, 0L, null, null);
              PushMessageHelper.sendCommandMessageBroadcast(sContext, paramString2);
            }
            aw.a(sContext).a();
            if (b.a(sContext).a())
            {
              paramString2 = new in();
              paramString2.b(b.a(sContext).a());
              paramString2.c("client_info_update");
              paramString2.a(ak.a());
              paramString2.a = new HashMap();
              paramString2.a.put("app_version", g.a(sContext, sContext.getPackageName()));
              paramString2.a.put("app_version_code", Integer.toString(g.a(sContext, sContext.getPackageName())));
              paramString2.a.put("push_sdk_vn", "3_7_0");
              paramString2.a.put("push_sdk_vc", Integer.toString(30700));
              paramMiPushClientCallback = b.a(sContext).e();
              if (!TextUtils.isEmpty(paramMiPushClientCallback)) {
                paramString2.a.put("deviceid", paramMiPushClientCallback);
              }
              aw.a(sContext).a(paramString2, ho.i, false, null);
            }
            if (!n.a(sContext, "update_devId", false))
            {
              updateImeiOrOaid();
              n.a(sContext, "update_devId", true);
            }
            paramString2 = i.d(sContext);
            if (!TextUtils.isEmpty(paramString2))
            {
              paramMiPushClientCallback = new ii();
              paramMiPushClientCallback.a(ak.a());
              paramMiPushClientCallback.b(paramString1);
              paramMiPushClientCallback.c(fi.j.jdField_a_of_type_JavaLangString);
              paramString3 = new ArrayList();
              paramString3.add(i.c(sContext));
              paramString3.add(paramString2);
              paramString1 = Build.MODEL;
              paramString2 = "";
              if (paramString1 == null) {
                break label1141;
              }
              paramString1 = Build.MODEL;
              paramString3.add(paramString1);
              paramString1 = paramString2;
              if (Build.BOARD != null) {
                paramString1 = Build.BOARD;
              }
              paramString3.add(paramString1);
              paramMiPushClientCallback.a(paramString3);
              aw.a(sContext).a(paramMiPushClientCallback, ho.j, false, null);
            }
            if ((shouldUseMIUIPush(sContext)) && (shouldPullNotification(sContext)))
            {
              paramString1 = new in();
              paramString1.b(b.a(sContext).a());
              paramString1.c(hy.j.jdField_a_of_type_JavaLangString);
              paramString1.a(ak.a());
              paramString1.a(false);
              aw.a(sContext).a(paramString1, ho.i, false, null, false);
              addPullNotificationTime(sContext);
            }
          }
          else
          {
            String str = bf.a(6);
            b.a(sContext).a();
            b.a(sContext).a(Constants.a());
            b.a(sContext).a(paramString1, paramString2, str);
            MiTinyDataClient.a.a().b("com.xiaomi.xmpushsdk.tinydataPending.appId");
            clearExtras(sContext);
            paramMiPushClientCallback = new io();
            paramMiPushClientCallback.a(ak.a());
            paramMiPushClientCallback.b(paramString1);
            paramMiPushClientCallback.e(paramString2);
            paramMiPushClientCallback.d(sContext.getPackageName());
            paramMiPushClientCallback.f(str);
            paramMiPushClientCallback.c(g.a(sContext, sContext.getPackageName()));
            paramMiPushClientCallback.b(g.a(sContext, sContext.getPackageName()));
            paramMiPushClientCallback.h("3_7_0");
            paramMiPushClientCallback.a(30700);
            paramMiPushClientCallback.i(i.e(sContext));
            paramMiPushClientCallback.a(ic.c);
            if (!TextUtils.isEmpty(paramString3)) {
              paramMiPushClientCallback.g(paramString3);
            }
            if (!l.d())
            {
              paramString2 = i.g(sContext);
              paramString3 = i.i(sContext);
              if (!TextUtils.isEmpty(paramString2))
              {
                boolean bool2 = l.b();
                paramString1 = paramString2;
                if (bool2)
                {
                  paramString1 = paramString2;
                  if (!TextUtils.isEmpty(paramString3))
                  {
                    paramString1 = new StringBuilder();
                    paramString1.append(paramString2);
                    paramString1.append(",");
                    paramString1.append(paramString3);
                    paramString1 = paramString1.toString();
                  }
                  paramMiPushClientCallback.j(paramString1);
                }
                paramString2 = new StringBuilder();
                paramString2.append(bf.a(paramString1));
                paramString2.append(",");
                paramString2.append(i.j(sContext));
                paramMiPushClientCallback.l(paramString2.toString());
              }
            }
            paramMiPushClientCallback.k(i.a());
            int i = i.a();
            if (i >= 0) {
              paramMiPushClientCallback.c(i);
            }
            aw.a(sContext).a(paramMiPushClientCallback, bool1);
            sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
          }
          addRegRequestTime(sContext);
          scheduleOcVersionCheckJob();
          scheduleDataCollectionJobs(sContext);
          initEventPerfLogic(sContext);
          bc.a(sContext);
          forceHandleCrash();
          if (!sContext.getPackageName().equals("com.xiaomi.xmsf"))
          {
            if (Logger.getUserLogger() != null) {
              Logger.setLogger(sContext, Logger.getUserLogger());
            }
            com.xiaomi.channel.commonutils.logger.b.a(2);
          }
        }
      }
      finally
      {
        com.xiaomi.channel.commonutils.logger.b.a(paramContext);
        return;
      }
      boolean bool1 = false;
      continue;
      label1141:
      paramString1 = "";
    }
  }
  
  private static void operateSyncAction(Context paramContext)
  {
    if ("syncing".equals(am.a(sContext).a(bb.a))) {
      disablePush(sContext);
    }
    if ("syncing".equals(am.a(sContext).a(bb.b))) {
      enablePush(sContext);
    }
    if ("syncing".equals(am.a(sContext).a(bb.c))) {
      syncAssemblePushToken(sContext);
    }
    if ("syncing".equals(am.a(sContext).a(bb.d))) {
      syncAssembleFCMPushToken(sContext);
    }
    if ("syncing".equals(am.a(sContext).a(bb.e))) {
      syncAssembleCOSPushToken(paramContext);
    }
    if ("syncing".equals(am.a(sContext).a(bb.f))) {
      syncAssembleFTOSPushToken(paramContext);
    }
  }
  
  public static void pausePush(Context paramContext, String paramString)
  {
    setAcceptTime(paramContext, 0, 0, 0, 0, paramString);
  }
  
  static void reInitialize(Context paramContext, ic paramic)
  {
    if (!b.a(paramContext).c()) {
      return;
    }
    String str1 = bf.a(6);
    String str2 = b.a(paramContext).a();
    String str3 = b.a(paramContext).b();
    b.a(paramContext).a();
    b.a(paramContext).a(Constants.a());
    b.a(paramContext).a(str2, str3, str1);
    io localio = new io();
    localio.a(ak.a());
    localio.b(str2);
    localio.e(str3);
    localio.f(str1);
    localio.d(paramContext.getPackageName());
    localio.c(g.a(paramContext, paramContext.getPackageName()));
    localio.a(paramic);
    aw.a(paramContext).a(localio, false);
  }
  
  public static void registerCrashHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    Thread.setDefaultUncaughtExceptionHandler(new v(sContext, paramUncaughtExceptionHandler));
    isCrashHandlerSuggested = true;
  }
  
  private static void registerNetworkReceiver(Context paramContext)
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.addCategory("android.intent.category.DEFAULT");
      paramContext.getApplicationContext().registerReceiver(new NetworkStatusReceiver(null), localIntentFilter);
      return;
    }
    finally
    {
      com.xiaomi.channel.commonutils.logger.b.a(paramContext);
    }
  }
  
  public static void registerPush(Context paramContext, String paramString1, String paramString2)
  {
    registerPush(paramContext, paramString1, paramString2, new PushConfiguration());
  }
  
  public static void registerPush(Context paramContext, String paramString1, String paramString2, PushConfiguration paramPushConfiguration)
  {
    registerPush(paramContext, paramString1, paramString2, paramPushConfiguration, null);
  }
  
  private static void registerPush(Context paramContext, String paramString1, String paramString2, PushConfiguration paramPushConfiguration, String paramString3)
  {
    checkNotNull(paramContext, "context");
    checkNotNull(paramString1, "appID");
    checkNotNull(paramString2, "appToken");
    Context localContext = paramContext.getApplicationContext();
    sContext = localContext;
    if (localContext == null) {
      sContext = paramContext;
    }
    paramContext = sContext;
    t.a(paramContext);
    if (!NetworkStatusReceiver.a()) {
      registerNetworkReceiver(sContext);
    }
    e.a(sContext).a(paramPushConfiguration);
    ai.a(paramContext).a(new ac(paramString1, paramString2, paramString3));
  }
  
  public static void registerPush(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    registerPush(paramContext, paramString1, paramString2, new PushConfiguration(), paramString3);
  }
  
  static void removeAcceptTime(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("mipush_extra", 0).edit();
      paramContext.remove("accept_time");
      com.xiaomi.push.r.a(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static void removeAccount(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("mipush_extra", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("account_");
      localStringBuilder.append(paramString);
      paramContext.remove(localStringBuilder.toString()).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static void removeAlias(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("mipush_extra", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("alias_");
      localStringBuilder.append(paramString);
      paramContext.remove(localStringBuilder.toString()).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static void removeAllAccounts(Context paramContext)
  {
    try
    {
      Iterator localIterator = getAllUserAccount(paramContext).iterator();
      while (localIterator.hasNext()) {
        removeAccount(paramContext, (String)localIterator.next());
      }
      return;
    }
    finally {}
  }
  
  static void removeAllAliases(Context paramContext)
  {
    try
    {
      Iterator localIterator = getAllAlias(paramContext).iterator();
      while (localIterator.hasNext()) {
        removeAlias(paramContext, (String)localIterator.next());
      }
      return;
    }
    finally {}
  }
  
  static void removeAllTopics(Context paramContext)
  {
    try
    {
      Iterator localIterator = getAllTopic(paramContext).iterator();
      while (localIterator.hasNext()) {
        removeTopic(paramContext, (String)localIterator.next());
      }
      return;
    }
    finally {}
  }
  
  static void removeTopic(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("mipush_extra", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("topic_");
      localStringBuilder.append(paramString);
      paramContext.remove(localStringBuilder.toString()).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void reportAppRunInBackground(Context paramContext, boolean paramBoolean)
  {
    if (!b.a(paramContext).b()) {
      return;
    }
    hy localhy;
    if (paramBoolean) {
      localhy = hy.Q;
    } else {
      localhy = hy.P;
    }
    in localin = new in();
    localin.b(b.a(paramContext).a());
    localin.c(localhy.jdField_a_of_type_JavaLangString);
    localin.d(paramContext.getPackageName());
    localin.a(ak.a());
    localin.a(false);
    aw.a(paramContext).a(localin, ho.i, false, null, false);
  }
  
  static void reportIgnoreRegMessageClicked(Context paramContext, String paramString1, ib paramib, String paramString2, String paramString3)
  {
    in localin = new in();
    if (TextUtils.isEmpty(paramString3))
    {
      com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
      return;
    }
    localin.b(paramString3);
    localin.c("bar:click");
    localin.a(paramString1);
    localin.a(false);
    aw.a(paramContext).a(localin, ho.i, false, true, paramib, true, paramString2, paramString3);
  }
  
  public static void reportMessageClicked(Context paramContext, MiPushMessage paramMiPushMessage)
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
    reportMessageClicked(paramContext, paramMiPushMessage.getMessageId(), localib, null);
  }
  
  @Deprecated
  public static void reportMessageClicked(Context paramContext, String paramString)
  {
    reportMessageClicked(paramContext, paramString, null, null);
  }
  
  static void reportMessageClicked(Context paramContext, String paramString1, ib paramib, String paramString2)
  {
    in localin = new in();
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      if (b.a(paramContext).b())
      {
        str = b.a(paramContext).a();
      }
      else
      {
        com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
        return;
      }
    }
    localin.b(str);
    localin.c("bar:click");
    localin.a(paramString1);
    localin.a(false);
    aw.a(paramContext).a(localin, ho.i, false, paramib);
  }
  
  public static void resumePush(Context paramContext, String paramString)
  {
    setAcceptTime(paramContext, 0, 0, 23, 59, paramString);
  }
  
  private static void scheduleDataCollectionJobs(Context paramContext)
  {
    int i = ht.z.a();
    if (com.xiaomi.push.service.ah.a(sContext).a(i, getDefaultSwitch()))
    {
      ds.a().a(new q(paramContext));
      ai.a(sContext).a(new ad(), 10);
    }
  }
  
  private static void scheduleOcVersionCheckJob()
  {
    int i = com.xiaomi.push.service.ah.a(sContext).a(ht.A.a(), 86400);
    ai.a(sContext).a(new al(sContext), i, 5);
  }
  
  public static void setAcceptTime(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    if ((paramInt1 >= 0) && (paramInt1 < 24) && (paramInt3 >= 0) && (paramInt3 < 24) && (paramInt2 >= 0) && (paramInt2 < 60) && (paramInt4 >= 0) && (paramInt4 < 60))
    {
      Object localObject1 = TimeZone.getTimeZone("GMT+08");
      Object localObject2 = TimeZone.getDefault();
      long l2 = (((TimeZone)localObject1).getRawOffset() - ((TimeZone)localObject2).getRawOffset()) / 1000 / 60;
      long l1 = (paramInt1 * 60 + paramInt2 + l2 + 1440L) % 1440L;
      l2 = (paramInt3 * 60 + paramInt4 + l2 + 1440L) % 1440L;
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(String.format("%1$02d:%2$02d", new Object[] { Long.valueOf(l1 / 60L), Long.valueOf(l1 % 60L) }));
      ((ArrayList)localObject1).add(String.format("%1$02d:%2$02d", new Object[] { Long.valueOf(l2 / 60L), Long.valueOf(l2 % 60L) }));
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(String.format("%1$02d:%2$02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      ((ArrayList)localObject2).add(String.format("%1$02d:%2$02d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
      if (acceptTimeSet(paramContext, (String)((ArrayList)localObject1).get(0), (String)((ArrayList)localObject1).get(1)))
      {
        if (1 == PushMessageHelper.getPushMode(paramContext))
        {
          PushMessageHandler.a(paramContext, paramString, fi.i.jdField_a_of_type_JavaLangString, 0L, null, (List)localObject2);
          return;
        }
        PushMessageHelper.sendCommandMessageBroadcast(paramContext, PushMessageHelper.generateCommandMessage(fi.i.jdField_a_of_type_JavaLangString, (List)localObject2, 0L, null, null));
        return;
      }
      setCommand(paramContext, fi.i.jdField_a_of_type_JavaLangString, (ArrayList)localObject1, paramString);
      return;
    }
    throw new IllegalArgumentException("the input parameter is not valid.");
  }
  
  public static void setAlias(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      setCommand(paramContext, fi.c.jdField_a_of_type_JavaLangString, paramString1, paramString2);
    }
  }
  
  protected static void setCommand(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString2)) {
      localArrayList.add(paramString2);
    }
    if ((fi.c.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString1)) && (Math.abs(System.currentTimeMillis() - aliasSetTime(paramContext, paramString2)) < 86400000L))
    {
      if (1 == PushMessageHelper.getPushMode(paramContext))
      {
        PushMessageHandler.a(paramContext, paramString3, paramString1, 0L, null, localArrayList);
        return;
      }
      paramString1 = fi.c;
      label78:
      PushMessageHelper.sendCommandMessageBroadcast(paramContext, PushMessageHelper.generateCommandMessage(paramString1.jdField_a_of_type_JavaLangString, localArrayList, 0L, null, paramString3));
      return;
    }
    if ((fi.d.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString1)) && (aliasSetTime(paramContext, paramString2) < 0L)) {
      paramContext = new StringBuilder();
    }
    for (paramString1 = "Don't cancel alias for ";; paramString1 = "Don't cancel account for ")
    {
      paramContext.append(paramString1);
      paramContext.append(bf.a(localArrayList.toString(), 3));
      paramContext.append(" is unseted");
      com.xiaomi.channel.commonutils.logger.b.a(paramContext.toString());
      return;
      if ((fi.e.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString1)) && (Math.abs(System.currentTimeMillis() - accountSetTime(paramContext, paramString2)) < 3600000L))
      {
        if (1 == PushMessageHelper.getPushMode(paramContext)) {
          break;
        }
        paramString1 = fi.e;
        break label78;
      }
      if ((!fi.f.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString1)) || (accountSetTime(paramContext, paramString2) >= 0L)) {
        break label254;
      }
      paramContext = new StringBuilder();
    }
    label254:
    setCommand(paramContext, paramString1, localArrayList, paramString3);
  }
  
  protected static void setCommand(Context paramContext, String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    if (TextUtils.isEmpty(b.a(paramContext).a())) {
      return;
    }
    ii localii = new ii();
    localii.a(ak.a());
    localii.b(b.a(paramContext).a());
    localii.c(paramString1);
    paramString1 = paramArrayList.iterator();
    while (paramString1.hasNext()) {
      localii.a((String)paramString1.next());
    }
    localii.e(paramString2);
    localii.d(paramContext.getPackageName());
    aw.a(paramContext).a(localii, ho.j, null);
  }
  
  public static void setLocalNotificationType(Context paramContext, int paramInt)
  {
    aw.a(paramContext).b(paramInt & 0xFFFFFFFF);
  }
  
  public static void setUserAccount(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      setCommand(paramContext, fi.e.jdField_a_of_type_JavaLangString, paramString1, paramString2);
    }
  }
  
  private static boolean shouldPullNotification(Context paramContext)
  {
    boolean bool = false;
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0);
    if (Math.abs(System.currentTimeMillis() - paramContext.getLong("last_pull_notification", -1L)) > 300000L) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean shouldSendRegRequest(Context paramContext)
  {
    boolean bool = false;
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0);
    if (Math.abs(System.currentTimeMillis() - paramContext.getLong("last_reg_request", -1L)) > 5000L) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean shouldUseMIUIPush(Context paramContext)
  {
    return aw.a(paramContext).a();
  }
  
  public static void subscribe(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(b.a(paramContext).a()))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(paramContext, paramString1)) > 86400000L)
      {
        is localis = new is();
        localis.a(ak.a());
        localis.b(b.a(paramContext).a());
        localis.c(paramString1);
        localis.d(paramContext.getPackageName());
        localis.e(paramString2);
        aw.a(paramContext).a(localis, ho.c, null);
        return;
      }
      if (1 == PushMessageHelper.getPushMode(paramContext))
      {
        PushMessageHandler.a(paramContext, paramString2, 0L, null, paramString1);
        return;
      }
      paramString2 = new ArrayList();
      paramString2.add(paramString1);
      PushMessageHelper.sendCommandMessageBroadcast(paramContext, PushMessageHelper.generateCommandMessage(fi.g.jdField_a_of_type_JavaLangString, paramString2, 0L, null, null));
    }
  }
  
  public static void syncAssembleCOSPushToken(Context paramContext)
  {
    aw.a(paramContext).a(null, bb.e, d.c);
  }
  
  public static void syncAssembleFCMPushToken(Context paramContext)
  {
    aw.a(paramContext).a(null, bb.d, d.b);
  }
  
  public static void syncAssembleFTOSPushToken(Context paramContext)
  {
    aw.a(paramContext).a(null, bb.f, d.d);
  }
  
  public static void syncAssemblePushToken(Context paramContext)
  {
    aw.a(paramContext).a(null, bb.c, d.a);
  }
  
  public static long topicSubscribedTime(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("topic_");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), -1L);
  }
  
  public static void unregisterPush(Context paramContext)
  {
    h.c(paramContext);
    com.xiaomi.push.service.ah.a(paramContext).a();
    if (!b.a(paramContext).b()) {
      return;
    }
    iu localiu = new iu();
    localiu.a(ak.a());
    localiu.b(b.a(paramContext).a());
    localiu.c(b.a(paramContext).c());
    localiu.e(b.a(paramContext).b());
    localiu.d(paramContext.getPackageName());
    aw.a(paramContext).a(localiu);
    PushMessageHandler.a();
    b.a(paramContext).b();
    clearLocalNotificationType(paramContext);
    clearNotification(paramContext);
    clearExtras(paramContext);
  }
  
  public static void unsetAlias(Context paramContext, String paramString1, String paramString2)
  {
    setCommand(paramContext, fi.d.jdField_a_of_type_JavaLangString, paramString1, paramString2);
  }
  
  public static void unsetUserAccount(Context paramContext, String paramString1, String paramString2)
  {
    setCommand(paramContext, fi.f.jdField_a_of_type_JavaLangString, paramString1, paramString2);
  }
  
  public static void unsubscribe(Context paramContext, String paramString1, String paramString2)
  {
    if (!b.a(paramContext).b()) {
      return;
    }
    if (topicSubscribedTime(paramContext, paramString1) < 0L)
    {
      paramContext = new StringBuilder();
      paramContext.append("Don't cancel subscribe for ");
      paramContext.append(paramString1);
      paramContext.append(" is unsubscribed");
      com.xiaomi.channel.commonutils.logger.b.a(paramContext.toString());
      return;
    }
    iw localiw = new iw();
    localiw.a(ak.a());
    localiw.b(b.a(paramContext).a());
    localiw.c(paramString1);
    localiw.d(paramContext.getPackageName());
    localiw.e(paramString2);
    aw.a(paramContext).a(localiw, ho.d, null);
  }
  
  private static void updateImeiOrOaid()
  {
    new Thread(new ae()).start();
  }
  
  @Deprecated
  public static abstract class MiPushClientCallback
  {
    private String category;
    
    protected String getCategory()
    {
      return this.category;
    }
    
    public void onCommandResult(String paramString1, long paramLong, String paramString2, List<String> paramList) {}
    
    public void onInitializeResult(long paramLong, String paramString1, String paramString2) {}
    
    public void onReceiveMessage(MiPushMessage paramMiPushMessage) {}
    
    public void onReceiveMessage(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
    
    public void onSubscribeResult(long paramLong, String paramString1, String paramString2) {}
    
    public void onUnsubscribeResult(long paramLong, String paramString1, String paramString2) {}
    
    protected void setCategory(String paramString)
    {
      this.category = paramString;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\MiPushClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */