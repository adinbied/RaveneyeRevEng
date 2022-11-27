package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fd;
import com.xiaomi.push.fi;
import com.xiaomi.push.hs;
import com.xiaomi.push.iy;
import com.xiaomi.push.iz;
import com.xiaomi.push.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PushMessageHandler
  extends BaseService
{
  private static List<MiPushClient.MiPushClientCallback> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  
  protected static void a()
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public static void a(long paramLong, String paramString1, String paramString2)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((MiPushClient.MiPushClientCallback)localIterator.next()).onInitializeResult(paramLong, paramString1, paramString2);
      }
      return;
    }
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(paramContext, PushMessageHandler.class));
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      b.a(paramContext.getMessage());
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addjob PushMessageHandler ");
    localStringBuilder.append(paramIntent);
    b.c(localStringBuilder.toString());
    if (paramIntent != null)
    {
      c(paramContext, paramIntent);
      a(paramContext);
    }
  }
  
  private static void a(Context paramContext, Intent paramIntent, ResolveInfo paramResolveInfo)
  {
    try
    {
      paramResolveInfo = (PushMessageReceiver)t.a(paramContext, paramResolveInfo.activityInfo.name).newInstance();
      MessageHandleService.addJob(paramContext.getApplicationContext(), new MessageHandleService.a(paramIntent, paramResolveInfo));
      MessageHandleService.a(paramContext, new Intent(paramContext.getApplicationContext(), MessageHandleService.class));
      return;
    }
    finally
    {
      b.a(paramContext);
    }
  }
  
  public static void a(Context arg0, MiPushMessage paramMiPushMessage)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        MiPushClient.MiPushClientCallback localMiPushClientCallback = (MiPushClient.MiPushClientCallback)localIterator.next();
        if (a(paramMiPushMessage.getCategory(), localMiPushClientCallback.getCategory()))
        {
          localMiPushClientCallback.onReceiveMessage(paramMiPushMessage.getContent(), paramMiPushMessage.getAlias(), paramMiPushMessage.getTopic(), paramMiPushMessage.isNotified());
          localMiPushClientCallback.onReceiveMessage(paramMiPushMessage);
        }
      }
      return;
    }
  }
  
  public static void a(Context paramContext, a parama)
  {
    if ((parama instanceof MiPushMessage))
    {
      a(paramContext, (MiPushMessage)parama);
      return;
    }
    if ((parama instanceof MiPushCommandMessage))
    {
      MiPushCommandMessage localMiPushCommandMessage = (MiPushCommandMessage)parama;
      String str = localMiPushCommandMessage.getCommand();
      boolean bool = fi.jdField_a_of_type_ComXiaomiPushFi.jdField_a_of_type_JavaLangString.equals(str);
      List localList1 = null;
      List localList2 = null;
      parama = null;
      if (bool)
      {
        localList1 = localMiPushCommandMessage.getCommandArguments();
        paramContext = parama;
        if (localList1 != null)
        {
          paramContext = parama;
          if (!localList1.isEmpty()) {
            paramContext = (String)localList1.get(0);
          }
        }
        a(localMiPushCommandMessage.getResultCode(), localMiPushCommandMessage.getReason(), paramContext);
        return;
      }
      if ((!fi.c.jdField_a_of_type_JavaLangString.equals(str)) && (!fi.d.jdField_a_of_type_JavaLangString.equals(str)) && (!fi.i.jdField_a_of_type_JavaLangString.equals(str)))
      {
        if (fi.g.jdField_a_of_type_JavaLangString.equals(str))
        {
          localList2 = localMiPushCommandMessage.getCommandArguments();
          parama = localList1;
          if (localList2 != null)
          {
            parama = localList1;
            if (!localList2.isEmpty()) {
              parama = (String)localList2.get(0);
            }
          }
          a(paramContext, localMiPushCommandMessage.getCategory(), localMiPushCommandMessage.getResultCode(), localMiPushCommandMessage.getReason(), parama);
          return;
        }
        if (fi.h.jdField_a_of_type_JavaLangString.equals(str))
        {
          localList1 = localMiPushCommandMessage.getCommandArguments();
          parama = localList2;
          if (localList1 != null)
          {
            parama = localList2;
            if (!localList1.isEmpty()) {
              parama = (String)localList1.get(0);
            }
          }
          b(paramContext, localMiPushCommandMessage.getCategory(), localMiPushCommandMessage.getResultCode(), localMiPushCommandMessage.getReason(), parama);
        }
      }
      else
      {
        a(paramContext, localMiPushCommandMessage.getCategory(), str, localMiPushCommandMessage.getResultCode(), localMiPushCommandMessage.getReason(), localMiPushCommandMessage.getCommandArguments());
      }
    }
  }
  
  protected static void a(Context arg0, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        MiPushClient.MiPushClientCallback localMiPushClientCallback = (MiPushClient.MiPushClientCallback)localIterator.next();
        if (a(paramString1, localMiPushClientCallback.getCategory())) {
          localMiPushClientCallback.onSubscribeResult(paramLong, paramString2, paramString3);
        }
      }
      return;
    }
  }
  
  protected static void a(Context arg0, String paramString1, String paramString2, long paramLong, String paramString3, List<String> paramList)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        MiPushClient.MiPushClientCallback localMiPushClientCallback = (MiPushClient.MiPushClientCallback)localIterator.next();
        if (a(paramString1, localMiPushClientCallback.getCategory())) {
          localMiPushClientCallback.onCommandResult(paramString2, paramLong, paramString3, paramList);
        }
      }
      return;
    }
  }
  
  protected static void a(MiPushClient.MiPushClientCallback paramMiPushClientCallback)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      if (!jdField_a_of_type_JavaUtilList.contains(paramMiPushClientCallback)) {
        jdField_a_of_type_JavaUtilList.add(paramMiPushClientCallback);
      }
      return;
    }
  }
  
  protected static boolean a(String paramString1, String paramString2)
  {
    return ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) || (TextUtils.equals(paramString1, paramString2));
  }
  
  protected static void b(Context paramContext, Intent paramIntent)
  {
    try
    {
      boolean bool = "com.xiaomi.mipush.sdk.WAKEUP".equals(paramIntent.getAction());
      StringBuilder localStringBuilder = null;
      if (bool)
      {
        n.a(paramContext, paramIntent, null);
        return;
      }
      Object localObject1;
      if ("com.xiaomi.mipush.SEND_TINYDATA".equals(paramIntent.getAction()))
      {
        localObject1 = new hs();
        iy.a((iz)localObject1, paramIntent.getByteArrayExtra("mipush_payload"));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("PushMessageHandler.onHandleIntent ");
        localStringBuilder.append(((hs)localObject1).d());
        b.c(localStringBuilder.toString());
        MiTinyDataClient.upload(paramContext, (hs)localObject1);
        return;
      }
      if (1 == PushMessageHelper.getPushMode(paramContext))
      {
        if (b())
        {
          b.d("receive a message before application calling initialize");
          return;
        }
        localObject1 = at.a(paramContext).a(paramIntent);
        if (localObject1 != null) {
          a(paramContext, (a)localObject1);
        }
      }
      else
      {
        if ("com.xiaomi.mipush.sdk.SYNC_LOG".equals(paramIntent.getAction()))
        {
          Logger.uploadLogFile(paramContext, false);
          return;
        }
        Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        localIntent.setPackage(paramContext.getPackageName());
        localIntent.putExtras(paramIntent);
        localObject1 = paramContext.getPackageManager();
        try
        {
          Object localObject2 = ((PackageManager)localObject1).queryBroadcastReceivers(localIntent, 32);
          localObject1 = localStringBuilder;
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            do
            {
              localObject1 = localStringBuilder;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (ResolveInfo)((Iterator)localObject2).next();
            } while ((((ResolveInfo)localObject1).activityInfo == null) || (!((ResolveInfo)localObject1).activityInfo.packageName.equals(paramContext.getPackageName())) || (!PushMessageReceiver.class.isAssignableFrom(t.a(paramContext, ((ResolveInfo)localObject1).activityInfo.name))));
          }
          if (localObject1 != null)
          {
            a(paramContext, localIntent, (ResolveInfo)localObject1);
            return;
          }
          b.d("cannot find the receiver to handler this message, check your manifest");
          fd.a(paramContext).a(paramContext.getPackageName(), paramIntent, "cannot find the receiver to handler this message, check your manifest");
          return;
        }
        catch (Exception localException) {}
      }
      return;
    }
    finally
    {
      b.a(localThrowable);
      fd.a(paramContext).a(paramContext.getPackageName(), paramIntent, localThrowable);
    }
  }
  
  protected static void b(Context arg0, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        MiPushClient.MiPushClientCallback localMiPushClientCallback = (MiPushClient.MiPushClientCallback)localIterator.next();
        if (a(paramString1, localMiPushClientCallback.getCategory())) {
          localMiPushClientCallback.onUnsubscribeResult(paramLong, paramString2, paramString3);
        }
      }
      return;
    }
  }
  
  public static boolean b()
  {
    return jdField_a_of_type_JavaUtilList.isEmpty();
  }
  
  private static void c(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (!jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.isShutdown())) {
      jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(new as(paramContext, paramIntent));
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    c(getApplicationContext(), paramIntent);
  }
  
  static abstract interface a
    extends Serializable
  {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\PushMessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */