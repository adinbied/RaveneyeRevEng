package com.xiaomi.push.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai;
import com.xiaomi.push.ba;
import com.xiaomi.push.fd;
import com.xiaomi.push.g;
import com.xiaomi.push.g.a;
import com.xiaomi.push.ho;
import com.xiaomi.push.ib;
import com.xiaomi.push.ik;
import com.xiaomi.push.l;
import com.xiaomi.push.t;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class aa
{
  public static long a;
  private static final LinkedList<Pair<Integer, ik>> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private static ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newCachedThreadPool();
  
  static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("pref_notify_type", 0).getInt(paramString, Integer.MAX_VALUE);
  }
  
  private static int a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1.equals(paramContext.getPackageName())) {
      return paramContext.getResources().getIdentifier(paramString2, "drawable", paramString1);
    }
    return 0;
  }
  
  private static int a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString().hashCode() / 10 * 10 + 32768;
  }
  
  private static int a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      paramMap = null;
    } else {
      paramMap = (String)paramMap.get("timeout");
    }
    boolean bool = TextUtils.isEmpty(paramMap);
    int i = 0;
    if (!bool) {}
    try
    {
      i = Integer.parseInt(paramMap);
      return i;
    }
    catch (Exception paramMap) {}
    return 0;
  }
  
  private static Notification.Builder a(Notification.Builder paramBuilder, Context paramContext, String paramString, Map<String, String> paramMap)
  {
    PendingIntent localPendingIntent = a(paramContext, paramString, 1, paramMap);
    if ((localPendingIntent != null) && (!TextUtils.isEmpty((CharSequence)paramMap.get("notification_style_button_left_name")))) {
      paramBuilder.addAction(0, (CharSequence)paramMap.get("notification_style_button_left_name"), localPendingIntent);
    }
    localPendingIntent = a(paramContext, paramString, 2, paramMap);
    if ((localPendingIntent != null) && (!TextUtils.isEmpty((CharSequence)paramMap.get("notification_style_button_mid_name")))) {
      paramBuilder.addAction(0, (CharSequence)paramMap.get("notification_style_button_mid_name"), localPendingIntent);
    }
    paramContext = a(paramContext, paramString, 3, paramMap);
    if ((paramContext != null) && (!TextUtils.isEmpty((CharSequence)paramMap.get("notification_style_button_right_name")))) {
      paramBuilder.addAction(0, (CharSequence)paramMap.get("notification_style_button_right_name"), paramContext);
    }
    return paramBuilder;
  }
  
  private static Notification.Builder a(Context paramContext, Map<String, String> paramMap, Notification.Builder paramBuilder, String paramString)
  {
    if ("2".equals(paramMap.get("notification_style_type")))
    {
      if (paramMap == null) {
        paramContext = null;
      } else {
        paramContext = a(paramContext, (String)paramMap.get("notification_bigPic_uri"), false);
      }
      if (paramContext == null)
      {
        b.a("can not get big picture.");
        return paramBuilder;
      }
      paramMap = new Notification.BigPictureStyle(paramBuilder);
      paramMap.bigPicture(paramContext);
      paramMap.setSummaryText(paramString);
      paramMap.bigLargeIcon((Bitmap)null);
      paramBuilder.setStyle(paramMap);
      return paramBuilder;
    }
    if ("1".equals(paramMap.get("notification_style_type"))) {
      paramBuilder.setStyle(new Notification.BigTextStyle().bigText(paramString));
    }
    return paramBuilder;
  }
  
  private static Notification a(Notification paramNotification)
  {
    Object localObject = ba.a(paramNotification, "extraNotification");
    if (localObject != null) {
      ba.a(localObject, "setCustomizedIcon", new Object[] { Boolean.valueOf(true) });
    }
    return paramNotification;
  }
  
  private static Notification a(Notification paramNotification, String paramString)
  {
    try
    {
      Object localObject = Notification.class.getDeclaredField("extraNotification");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(paramNotification);
      Method localMethod = localObject.getClass().getDeclaredMethod("setTargetPkg", new Class[] { CharSequence.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localObject, new Object[] { paramString });
      return paramNotification;
    }
    catch (Exception paramString)
    {
      b.a(paramString);
    }
    return paramNotification;
  }
  
  private static PendingIntent a(Context paramContext, ik paramik, ib paramib, byte[] paramArrayOfByte, int paramInt)
  {
    int i;
    if (c(paramik)) {
      i = 1000;
    } else if (a(paramik)) {
      i = 3000;
    } else {
      i = -1;
    }
    String str;
    if (paramib != null) {
      str = paramib.a();
    } else {
      str = "";
    }
    if ((paramib != null) && (!TextUtils.isEmpty(paramib.e)))
    {
      paramik = new Intent("android.intent.action.VIEW");
      paramik.setData(Uri.parse(paramib.e));
      paramik.addFlags(268435456);
      paramik.putExtra("messageId", str);
      paramik.putExtra("eventMessageType", i);
      return PendingIntent.getActivity(paramContext, 0, paramik, 134217728);
    }
    ComponentName localComponentName;
    if (a(paramik))
    {
      paramib = new Intent();
      localComponentName = new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler");
    }
    else
    {
      paramib = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
      localComponentName = new ComponentName(paramik.b, "com.xiaomi.mipush.sdk.PushMessageHandler");
    }
    paramib.setComponent(localComponentName);
    paramib.putExtra("mipush_payload", paramArrayOfByte);
    paramib.putExtra("mipush_notified", true);
    paramib.addCategory(String.valueOf(paramInt));
    paramib.addCategory(String.valueOf(str));
    paramib.putExtra("messageId", str);
    paramib.putExtra("eventMessageType", i);
    if (f.b(paramContext, paramik.b, "com.xiaomi.mipush.MESSAGE_CLICKED"))
    {
      paramArrayOfByte = new Intent();
      paramArrayOfByte.setAction("com.xiaomi.mipush.MESSAGE_CLICKED");
      paramArrayOfByte.setClassName(paramik.b, "com.xiaomi.mipush.sdk.BridgeActivity");
      paramArrayOfByte.addFlags(276824064);
      paramArrayOfByte.putExtra("mipush_serviceIntent", paramib);
      paramArrayOfByte.addCategory(String.valueOf(paramInt));
      paramArrayOfByte.addCategory(String.valueOf(str));
      return PendingIntent.getActivity(paramContext, 0, paramArrayOfByte, 134217728);
    }
    return PendingIntent.getService(paramContext, 0, paramib, 134217728);
  }
  
  private static PendingIntent a(Context paramContext, String paramString, int paramInt, Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    paramString = a(paramContext, paramString, paramInt, paramMap);
    if (paramString != null) {
      return PendingIntent.getActivity(paramContext, 0, paramString, 0);
    }
    return null;
  }
  
  private static Intent a(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (paramContext.getPackageManager().getPackageInfo("com.android.browser", 4) != null) {
        paramIntent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
      }
      return paramIntent;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      b.a(paramContext);
    }
    return paramIntent;
  }
  
  private static Intent a(Context paramContext, String paramString, int paramInt, Map<String, String> paramMap)
  {
    if (paramInt < 2) {
      str = "notification_style_button_left_notify_effect";
    } else if (paramInt < 3) {
      str = "notification_style_button_mid_notify_effect";
    } else {
      str = "notification_style_button_right_notify_effect";
    }
    String str = (String)paramMap.get(str);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    if (aq.jdField_a_of_type_JavaLangString.equals(str))
    {
      try
      {
        paramString = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
      }
      catch (Exception paramString)
      {
        paramMap = new StringBuilder();
        paramMap.append("Cause: ");
        paramMap.append(paramString.getMessage());
        b.d(paramMap.toString());
        break label557;
      }
    }
    else
    {
      Object localObject1;
      if (aq.b.equals(str))
      {
        if (paramInt < 2) {
          str = "notification_style_button_left_intent_uri";
        } else if (paramInt < 3) {
          str = "notification_style_button_mid_intent_uri";
        } else {
          str = "notification_style_button_right_intent_uri";
        }
        Object localObject2;
        if (paramInt < 2) {
          localObject2 = "notification_style_button_left_intent_class";
        } else if (paramInt < 3) {
          localObject2 = "notification_style_button_mid_intent_class";
        } else {
          localObject2 = "notification_style_button_right_intent_class";
        }
        if (paramMap.containsKey(str))
        {
          paramMap = (String)paramMap.get(str);
          if (paramMap != null)
          {
            try
            {
              paramMap = Intent.parseUri(paramMap, 1);
              try
              {
                paramMap.setPackage(paramString);
                paramString = paramMap;
              }
              catch (URISyntaxException localURISyntaxException1)
              {
                paramString = paramMap;
              }
              localObject2 = new StringBuilder();
            }
            catch (URISyntaxException localURISyntaxException2)
            {
              paramString = null;
            }
            ((StringBuilder)localObject2).append("Cause: ");
            paramMap = localURISyntaxException2.getMessage();
            localObject1 = localObject2;
          }
          else
          {
            paramString = null;
            break label554;
          }
        }
        else
        {
          if (!paramMap.containsKey(localObject2)) {
            break label557;
          }
          localObject1 = (String)paramMap.get(localObject2);
          paramMap = new Intent();
          paramMap.setComponent(new ComponentName(paramString, (String)localObject1));
          paramString = paramMap;
          break label559;
        }
      }
      else
      {
        if (!aq.c.equals(localObject1)) {
          break label557;
        }
        if (paramInt < 2) {
          paramString = "notification_style_button_left_web_uri";
        } else if (paramInt < 3) {
          paramString = "notification_style_button_mid_web_uri";
        } else {
          paramString = "notification_style_button_right_web_uri";
        }
        paramString = (String)paramMap.get(paramString);
        if (TextUtils.isEmpty(paramString)) {
          break label557;
        }
        paramMap = paramString.trim();
        paramString = paramMap;
        if (!paramMap.startsWith("http://"))
        {
          paramString = paramMap;
          if (!paramMap.startsWith("https://"))
          {
            paramString = new StringBuilder();
            paramString.append("http://");
            paramString.append(paramMap);
            paramString = paramString.toString();
          }
        }
        try
        {
          paramMap = new URL(paramString).getProtocol();
          if ((!"http".equals(paramMap)) && (!"https".equals(paramMap))) {
            break label557;
          }
          localObject1 = new Intent("android.intent.action.VIEW");
          try
          {
            ((Intent)localObject1).setData(Uri.parse(paramString));
            paramString = a(paramContext, (Intent)localObject1);
          }
          catch (MalformedURLException paramMap)
          {
            paramString = (String)localObject1;
          }
          localObject1 = new StringBuilder();
        }
        catch (MalformedURLException paramMap)
        {
          paramString = null;
        }
        ((StringBuilder)localObject1).append("Cause: ");
        paramMap = paramMap.getMessage();
      }
      ((StringBuilder)localObject1).append(paramMap);
      b.d(((StringBuilder)localObject1).toString());
      label554:
      break label559;
    }
    label557:
    paramString = null;
    label559:
    if (paramString != null)
    {
      paramString.addFlags(268435456);
      try
      {
        paramContext = paramContext.getPackageManager().resolveActivity(paramString, 65536);
        if (paramContext != null) {
          return paramString;
        }
      }
      catch (Exception paramContext)
      {
        paramString = new StringBuilder();
        paramString.append("Cause: ");
        paramString.append(paramContext.getMessage());
        b.d(paramString.toString());
      }
    }
    return null;
  }
  
  private static Bitmap a(Context paramContext, int paramInt)
  {
    return a(paramContext.getResources().getDrawable(paramInt));
  }
  
  /* Error */
  private static Bitmap a(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 37	com/xiaomi/push/service/aa:jdField_a_of_type_JavaUtilConcurrentExecutorService	Ljava/util/concurrent/ExecutorService;
    //   3: new 6	com/xiaomi/push/service/aa$a
    //   6: dup
    //   7: aload_1
    //   8: aload_0
    //   9: iload_2
    //   10: invokespecial 483	com/xiaomi/push/service/aa$a:<init>	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   13: invokeinterface 489 2 0
    //   18: astore_3
    //   19: aload_3
    //   20: ldc2_w 490
    //   23: getstatic 497	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   26: invokeinterface 502 4 0
    //   31: checkcast 169	android/graphics/Bitmap
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: aload_1
    //   38: ifnonnull +40 -> 78
    //   41: aload_3
    //   42: iconst_1
    //   43: invokeinterface 506 2 0
    //   48: pop
    //   49: aload_1
    //   50: areturn
    //   51: astore_0
    //   52: goto +28 -> 80
    //   55: astore_0
    //   56: goto +8 -> 64
    //   59: astore_0
    //   60: goto +4 -> 64
    //   63: astore_0
    //   64: aload_0
    //   65: invokestatic 241	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   68: aload_3
    //   69: iconst_1
    //   70: invokeinterface 506 2 0
    //   75: pop
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_0
    //   79: areturn
    //   80: aload_3
    //   81: iconst_1
    //   82: invokeinterface 506 2 0
    //   87: pop
    //   88: aload_0
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramContext	Context
    //   0	90	1	paramString	String
    //   0	90	2	paramBoolean	boolean
    //   18	63	3	localFuture	java.util.concurrent.Future
    // Exception table:
    //   from	to	target	type
    //   19	35	51	finally
    //   64	68	51	finally
    //   19	35	55	java/util/concurrent/TimeoutException
    //   19	35	59	java/util/concurrent/ExecutionException
    //   19	35	63	java/lang/InterruptedException
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = 1;
    if (i <= 0) {
      i = 1;
    }
    int k = paramDrawable.getIntrinsicHeight();
    if (k > 0) {
      j = k;
    }
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private static RemoteViews a(Context paramContext, ik paramik, byte[] paramArrayOfByte)
  {
    Object localObject1 = paramik.a();
    paramArrayOfByte = a(paramik);
    localObject1 = ((ib)localObject1).a();
    if (localObject1 == null) {
      return null;
    }
    paramik = (String)((Map)localObject1).get("layout_name");
    Object localObject2 = (String)((Map)localObject1).get("layout_value");
    if (!TextUtils.isEmpty(paramik))
    {
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return null;
      }
      paramContext = paramContext.getPackageManager();
      try
      {
        localObject1 = paramContext.getResourcesForApplication(paramArrayOfByte);
        int i = ((Resources)localObject1).getIdentifier(paramik, "layout", paramArrayOfByte);
        if (i == 0) {
          return null;
        }
        RemoteViews localRemoteViews = new RemoteViews(paramArrayOfByte, i);
        try
        {
          paramContext = new JSONObject((String)localObject2);
          boolean bool = paramContext.has("text");
          Object localObject3;
          String str;
          if (bool)
          {
            paramik = paramContext.getJSONObject("text");
            localObject2 = paramik.keys();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              str = paramik.getString((String)localObject3);
              i = ((Resources)localObject1).getIdentifier((String)localObject3, "id", paramArrayOfByte);
              if (i > 0) {
                localRemoteViews.setTextViewText(i, str);
              }
            }
          }
          if (paramContext.has("image"))
          {
            paramik = paramContext.getJSONObject("image");
            localObject2 = paramik.keys();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              str = paramik.getString((String)localObject3);
              i = ((Resources)localObject1).getIdentifier((String)localObject3, "id", paramArrayOfByte);
              int j = ((Resources)localObject1).getIdentifier(str, "drawable", paramArrayOfByte);
              if (i > 0) {
                localRemoteViews.setImageViewResource(i, j);
              }
            }
          }
          if (paramContext.has("time"))
          {
            localObject2 = paramContext.getJSONObject("time");
            localObject3 = ((JSONObject)localObject2).keys();
            while (((Iterator)localObject3).hasNext())
            {
              str = (String)((Iterator)localObject3).next();
              paramik = ((JSONObject)localObject2).getString(str);
              paramContext = paramik;
              if (paramik.length() == 0) {
                paramContext = "yy-MM-dd hh:mm";
              }
              i = ((Resources)localObject1).getIdentifier(str, "id", paramArrayOfByte);
              if (i > 0)
              {
                long l = System.currentTimeMillis();
                localRemoteViews.setTextViewText(i, new SimpleDateFormat(paramContext).format(new Date(l)));
              }
            }
          }
          return localRemoteViews;
        }
        catch (JSONException paramContext)
        {
          b.a(paramContext);
          return null;
        }
        return null;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        b.a(paramContext);
      }
    }
  }
  
  private static b a(Context paramContext, ik paramik, byte[] paramArrayOfByte, RemoteViews paramRemoteViews, PendingIntent paramPendingIntent)
  {
    b localb = new b();
    Object localObject3 = paramik.a();
    String str = a(paramik);
    Map localMap = ((ib)localObject3).a();
    Object localObject1 = new Notification.Builder(paramContext);
    Object localObject2 = a(paramContext, (ib)localObject3);
    ((Notification.Builder)localObject1).setContentTitle(localObject2[0]);
    ((Notification.Builder)localObject1).setContentText(localObject2[1]);
    if (paramRemoteViews != null)
    {
      ((Notification.Builder)localObject1).setContent(paramRemoteViews);
      paramArrayOfByte = (byte[])localObject1;
    }
    else
    {
      paramArrayOfByte = (byte[])localObject1;
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramArrayOfByte = (byte[])localObject1;
        if (localMap != null)
        {
          paramArrayOfByte = (byte[])localObject1;
          if (localMap.containsKey("notification_style_type")) {
            paramArrayOfByte = a(paramContext, localMap, (Notification.Builder)localObject1, localObject2[1]);
          }
        }
      }
    }
    localObject2 = a(paramArrayOfByte, paramContext, paramik.b(), localMap);
    ((Notification.Builder)localObject2).setWhen(System.currentTimeMillis());
    if (localMap == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = (String)localMap.get("notification_show_when");
    }
    if (TextUtils.isEmpty(paramArrayOfByte))
    {
      if (Build.VERSION.SDK_INT >= 24) {
        ((Notification.Builder)localObject2).setShowWhen(true);
      }
    }
    else {
      ((Notification.Builder)localObject2).setShowWhen(Boolean.parseBoolean(paramArrayOfByte));
    }
    ((Notification.Builder)localObject2).setContentIntent(paramPendingIntent);
    int i = a(paramContext, str, "mipush_notification");
    int j = a(paramContext, str, "mipush_small_notification");
    if ((i > 0) && (j > 0))
    {
      ((Notification.Builder)localObject2).setLargeIcon(a(paramContext, i));
      ((Notification.Builder)localObject2).setSmallIcon(j);
    }
    else
    {
      ((Notification.Builder)localObject2).setSmallIcon(b(paramContext, str));
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (localMap == null) {
        paramArrayOfByte = null;
      } else {
        paramArrayOfByte = a(paramContext, (String)localMap.get("notification_small_icon_uri"), true);
      }
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = ba.a("android.graphics.drawable.Icon", "createWithBitmap", new Object[] { paramArrayOfByte });
        if (paramArrayOfByte != null)
        {
          ba.a(localObject2, "setSmallIcon", new Object[] { paramArrayOfByte });
          paramArrayOfByte = new Bundle();
          paramArrayOfByte.putBoolean("miui.isGrayscaleIcon", true);
          ((Notification.Builder)localObject2).addExtras(paramArrayOfByte);
        }
        else
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("failed te get small icon with url:");
          paramPendingIntent = (String)localMap.get("notification_small_icon_uri");
          paramRemoteViews = paramArrayOfByte;
        }
      }
      else
      {
        for (paramArrayOfByte = paramPendingIntent;; paramArrayOfByte = null)
        {
          paramRemoteViews.append(paramArrayOfByte);
          b.a(paramRemoteViews.toString());
          break label472;
          paramRemoteViews = new StringBuilder();
          paramRemoteViews.append("failed to get small icon url:");
          paramArrayOfByte = paramRemoteViews;
          if (localMap != null) {
            break;
          }
        }
      }
      label472:
      if (localMap == null) {
        paramArrayOfByte = null;
      } else {
        paramArrayOfByte = (String)localMap.get("notification_small_icon_color");
      }
      if (!TextUtils.isEmpty(paramArrayOfByte)) {
        try
        {
          ba.a(localObject2, "setColor", new Object[] { Integer.valueOf(Color.parseColor(paramArrayOfByte)) });
        }
        catch (Exception paramArrayOfByte)
        {
          b.a(paramArrayOfByte);
        }
      }
    }
    if (localMap == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = (String)localMap.get("__dynamic_icon_uri");
    }
    if ((localMap != null) && (Boolean.parseBoolean((String)localMap.get("__adiom")))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (l.a())) {
      i = 0;
    } else {
      i = 1;
    }
    if ((paramArrayOfByte != null) && (i != 0))
    {
      if (paramArrayOfByte.startsWith("http"))
      {
        paramRemoteViews = ag.a(paramContext, paramArrayOfByte, true);
        if (paramRemoteViews != null)
        {
          paramArrayOfByte = paramRemoteViews.jdField_a_of_type_AndroidGraphicsBitmap;
          localb.jdField_a_of_type_Long = paramRemoteViews.jdField_a_of_type_Long;
        }
        else
        {
          paramArrayOfByte = null;
        }
      }
      else
      {
        paramArrayOfByte = ag.a(paramContext, paramArrayOfByte);
      }
      if (paramArrayOfByte != null)
      {
        ((Notification.Builder)localObject2).setLargeIcon(paramArrayOfByte);
        k = 1;
        break label692;
      }
    }
    int k = 0;
    label692:
    if (localMap == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = a(paramContext, (String)localMap.get("notification_large_icon_uri"), true);
    }
    if (paramArrayOfByte != null) {
      ((Notification.Builder)localObject2).setLargeIcon(paramArrayOfByte);
    }
    boolean bool;
    if ((localMap != null) && (Build.VERSION.SDK_INT >= 24))
    {
      paramRemoteViews = (String)localMap.get("notification_group");
      bool = Boolean.parseBoolean((String)localMap.get("notification_is_summary"));
      paramArrayOfByte = paramRemoteViews;
      if (TextUtils.isEmpty(paramRemoteViews)) {
        paramArrayOfByte = a(paramik);
      }
      ba.a(localObject2, "setGroup", new Object[] { paramArrayOfByte });
      ba.a(localObject2, "setGroupSummary", new Object[] { Boolean.valueOf(bool) });
    }
    ((Notification.Builder)localObject2).setAutoCancel(true);
    long l = System.currentTimeMillis();
    if ((localMap != null) && (localMap.containsKey("ticker"))) {
      ((Notification.Builder)localObject2).setTicker((CharSequence)localMap.get("ticker"));
    }
    if (l - jdField_a_of_type_Long > 10000L)
    {
      jdField_a_of_type_Long = l;
      i = ((ib)localObject3).a;
      if (b(paramContext, str)) {
        i = a(paramContext, str);
      }
      ((Notification.Builder)localObject2).setDefaults(i);
      j = i;
      if (localMap != null)
      {
        j = i;
        if ((i & 0x1) != 0)
        {
          paramArrayOfByte = (String)localMap.get("sound_uri");
          j = i;
          if (!TextUtils.isEmpty(paramArrayOfByte))
          {
            paramRemoteViews = new StringBuilder();
            paramRemoteViews.append("android.resource://");
            paramRemoteViews.append(str);
            j = i;
            if (paramArrayOfByte.startsWith(paramRemoteViews.toString()))
            {
              ((Notification.Builder)localObject2).setDefaults(i ^ 0x1);
              paramRemoteViews = Uri.parse(paramArrayOfByte);
              ((Notification.Builder)localObject2).setSound(paramRemoteViews);
              break label1046;
            }
          }
        }
      }
    }
    else
    {
      j = -100;
    }
    paramRemoteViews = null;
    i = j;
    label1046:
    Object localObject4;
    if ((localMap != null) && (Build.VERSION.SDK_INT >= 26))
    {
      j = a(localMap);
      if (j > 0) {
        ba.a(localObject2, "setTimeoutAfter", new Object[] { Long.valueOf(j * 1000) });
      }
      localObject1 = (String)localMap.get("channel_id");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) && (paramContext.getApplicationInfo().targetSdkVersion < 26)) {
        break label1755;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("mipush_");
      paramArrayOfByte.append(str);
      paramArrayOfByte.append("_default");
      paramPendingIntent = paramArrayOfByte.toString();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramArrayOfByte = paramPendingIntent;
      }
      else
      {
        paramArrayOfByte = (byte[])localObject1;
        if (l.a())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("mipush_");
          paramArrayOfByte.append(str);
          paramArrayOfByte.append("_");
          paramArrayOfByte.append((String)localObject1);
          paramArrayOfByte = paramArrayOfByte.toString();
        }
      }
      ba.a(localObject2, "setChannelId", new Object[] { paramArrayOfByte });
      localObject1 = paramContext;
      localObject4 = a((Context)localObject1, str, localMap);
      j = b(localMap);
      localObject3 = (NotificationManager)((Context)localObject1).getSystemService("notification");
    }
    for (;;)
    {
      try
      {
        if (ba.a(localObject3, "getNotificationChannel", new Object[] { paramArrayOfByte }) == null)
        {
          paramArrayOfByte = t.a((Context)localObject1, "android.app.NotificationChannel").getConstructor(new Class[] { String.class, CharSequence.class, Integer.TYPE }).newInstance(new Object[] { paramArrayOfByte, localObject4, Integer.valueOf(j) });
          if (i > -100)
          {
            ((Notification.Builder)localObject2).setSound(null, null);
            ((Notification.Builder)localObject2).setDefaults(0);
            if ((i & 0x1) != 1) {
              ba.a(paramArrayOfByte, "setSound", new Object[] { null, null });
            }
            if (paramRemoteViews != null) {
              ba.a(paramArrayOfByte, "setSound", new Object[] { paramRemoteViews, Notification.AUDIO_ATTRIBUTES_DEFAULT });
            }
            if ((i & 0x2) != 2) {
              break label2074;
            }
            bool = true;
            ba.a(paramArrayOfByte, "enableVibration", new Object[] { Boolean.valueOf(bool) });
            if ((i & 0x4) != 4) {
              break label2080;
            }
            bool = true;
            ba.a(paramArrayOfByte, "enableLights", new Object[] { Boolean.valueOf(bool) });
          }
          a(paramArrayOfByte, localMap);
          ba.a(localObject3, "createNotificationChannel", new Object[] { paramArrayOfByte });
        }
        paramArrayOfByte = ba.a(localObject3, "getNotificationChannels", new Object[0]);
        if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof List)))
        {
          paramArrayOfByte = (List)paramArrayOfByte;
          if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
          {
            i = 0;
            if (i < paramArrayOfByte.size())
            {
              paramRemoteViews = paramArrayOfByte.get(i);
              localObject4 = ba.a(paramRemoteViews, "getName", new Object[0]);
              paramRemoteViews = ba.a(paramRemoteViews, "getId", new Object[0]);
              Object localObject5 = g.b((Context)localObject1, str);
              if ((localObject4 != null) && (paramRemoteViews != null) && ((localObject4 instanceof CharSequence)) && ((paramRemoteViews instanceof String)) && (localObject4.equals(localObject5)))
              {
                localObject4 = (String)paramRemoteViews;
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append("mipush_");
                ((StringBuilder)localObject5).append(str);
                if ((((String)localObject4).startsWith(((StringBuilder)localObject5).toString())) && (!paramRemoteViews.equals(paramPendingIntent))) {
                  ba.a(localObject3, "deleteNotificationChannel", new Object[] { paramRemoteViews });
                }
              }
              i += 1;
              continue;
            }
          }
        }
        paramArrayOfByte = (String)localMap.get("background_color");
      }
      catch (Exception paramArrayOfByte)
      {
        b.a(paramArrayOfByte);
      }
      label1755:
      if (!TextUtils.isEmpty(paramArrayOfByte))
      {
        try
        {
          i = Integer.parseInt(paramArrayOfByte);
          ((Notification.Builder)localObject2).setOngoing(true);
          ((Notification.Builder)localObject2).setColor(i);
          ba.a(localObject2, "setColorized", new Object[] { Boolean.valueOf(true) });
        }
        catch (Exception paramArrayOfByte)
        {
          b.a(paramArrayOfByte);
        }
        if ((localMap != null) && (Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 26)) {
          ba.a(localObject2, "setPriority", new Object[] { Integer.valueOf(c(localMap)) });
        }
      }
      if ((l.c()) && ("com.xiaomi.xmsf".equals(paramContext.getPackageName()))) {
        ba.a("miui.util.NotificationHelper", "setTargetPkg", new Object[] { paramContext, localObject2, a(paramik) });
      }
      paramContext = ((Notification.Builder)localObject2).getNotification();
      if ((k != 0) && (l.a())) {
        a(paramContext);
      }
      if (localMap != null)
      {
        paramik = ba.a(paramContext, "extraNotification");
        if (paramik != null)
        {
          if (!TextUtils.isEmpty((CharSequence)localMap.get("enable_keyguard"))) {
            ba.a(paramik, "setEnableKeyguard", new Object[] { Boolean.valueOf(Boolean.parseBoolean((String)localMap.get("enable_keyguard"))) });
          }
          if (!TextUtils.isEmpty((CharSequence)localMap.get("enable_float"))) {
            ba.a(paramik, "setEnableFloat", new Object[] { Boolean.valueOf(Boolean.parseBoolean((String)localMap.get("enable_float"))) });
          }
        }
      }
      localb.jdField_a_of_type_AndroidAppNotification = paramContext;
      return localb;
      label2074:
      bool = false;
      continue;
      label2080:
      bool = false;
    }
  }
  
  public static c a(Context arg0, ik paramik, byte[] paramArrayOfByte)
  {
    c localc = new c();
    Object localObject3;
    Object localObject1;
    Object localObject4;
    if (g.a(???, a(paramik)) == g.a.c)
    {
      localObject3 = paramik.a();
      if (localObject3 != null)
      {
        ??? = fd.a(???.getApplicationContext());
        paramArrayOfByte = paramik.b();
        localObject1 = b(paramik);
        localObject3 = ((ib)localObject3).a();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("Do not notify because user block ");
        ((StringBuilder)localObject4).append(a(paramik));
        ((StringBuilder)localObject4).append("‘s notification");
        ???.a(paramArrayOfByte, (String)localObject1, (String)localObject3, ((StringBuilder)localObject4).toString());
      }
      ??? = new StringBuilder();
      ???.append("Do not notify because user block ");
      ???.append(a(paramik));
      ???.append("‘s notification");
    }
    ib localib;
    RemoteViews localRemoteViews;
    int i;
    int j;
    for (??? = ???.toString();; ??? = "The click PendingIntent is null. ")
    {
      b.a(???);
      return localc;
      localObject4 = (NotificationManager)???.getSystemService("notification");
      localib = paramik.a();
      localRemoteViews = a(???, paramik, paramArrayOfByte);
      if (localib != null) {
        i = localib.c();
      } else {
        i = 0;
      }
      j = a(paramik).hashCode() / 10 * 10 + i;
      localObject1 = a(???, paramik, localib, paramArrayOfByte, j);
      if (localObject1 != null) {
        break;
      }
      if (localib != null) {
        fd.a(???.getApplicationContext()).a(paramik.b(), b(paramik), localib.a(), "The click PendingIntent is null. ");
      }
    }
    label474:
    label498:
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramArrayOfByte = a(???, paramik, paramArrayOfByte, localRemoteViews, (PendingIntent)localObject1);
      localc.jdField_a_of_type_Long = paramArrayOfByte.jdField_a_of_type_Long;
      localc.jdField_a_of_type_JavaLangString = a(paramik);
      paramArrayOfByte = paramArrayOfByte.jdField_a_of_type_AndroidAppNotification;
    }
    else
    {
      localObject3 = new Notification(b(???, a(paramik)), null, System.currentTimeMillis());
      paramArrayOfByte = a(???, localib);
      try
      {
        localObject3.getClass().getMethod("setLatestEventInfo", new Class[] { Context.class, CharSequence.class, CharSequence.class, PendingIntent.class }).invoke(localObject3, new Object[] { ???, paramArrayOfByte[0], paramArrayOfByte[1], localObject1 });
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        paramArrayOfByte = localInvocationTargetException;
        if (localib == null) {
          break label498;
        }
        paramArrayOfByte = localInvocationTargetException;
        break label474;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        paramArrayOfByte = localIllegalArgumentException;
        if (localib == null) {
          break label498;
        }
        paramArrayOfByte = localIllegalArgumentException;
        break label474;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        paramArrayOfByte = localIllegalAccessException;
        if (localib == null) {
          break label498;
        }
        paramArrayOfByte = localIllegalAccessException;
        break label474;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        paramArrayOfByte = localNoSuchMethodException;
        if (localib == null) {
          break label498;
        }
      }
      paramArrayOfByte = localNoSuchMethodException;
      fd.a(???.getApplicationContext()).a(paramik.b(), b(paramik), localib.a(), paramArrayOfByte);
      b.a(paramArrayOfByte);
      paramArrayOfByte = localib.a();
      if ((paramArrayOfByte != null) && (paramArrayOfByte.containsKey("ticker"))) {
        ((Notification)localObject3).tickerText = ((CharSequence)paramArrayOfByte.get("ticker"));
      }
      long l = System.currentTimeMillis();
      if (l - jdField_a_of_type_Long > 10000L)
      {
        jdField_a_of_type_Long = l;
        i = localib.a;
        if (b(???, a(paramik))) {
          i = a(???, a(paramik));
        }
        ((Notification)localObject3).defaults = i;
        if ((paramArrayOfByte != null) && ((i & 0x1) != 0))
        {
          paramArrayOfByte = (String)paramArrayOfByte.get("sound_uri");
          if (!TextUtils.isEmpty(paramArrayOfByte))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("android.resource://");
            ((StringBuilder)localObject2).append(a(paramik));
            if (paramArrayOfByte.startsWith(((StringBuilder)localObject2).toString()))
            {
              ((Notification)localObject3).defaults = (i ^ 0x1);
              ((Notification)localObject3).sound = Uri.parse(paramArrayOfByte);
            }
          }
        }
      }
      ((Notification)localObject3).flags |= 0x10;
      paramArrayOfByte = (byte[])localObject3;
      if (localRemoteViews != null)
      {
        ((Notification)localObject3).contentView = localRemoteViews;
        paramArrayOfByte = (byte[])localObject3;
      }
    }
    if ((l.a()) && (Build.VERSION.SDK_INT >= 19))
    {
      if (!TextUtils.isEmpty(localib.a())) {
        paramArrayOfByte.extras.putString("message_id", localib.a());
      }
      if (localib.b() == null) {
        localObject2 = null;
      } else {
        localObject2 = (String)localib.b().get("score_info");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        paramArrayOfByte.extras.putString("score_info", (String)localObject2);
      }
      i = -1;
      if (c(paramik)) {
        i = 1000;
      } else if (a(paramik)) {
        i = 3000;
      }
      paramArrayOfByte.extras.putString("eventMessageType", String.valueOf(i));
      paramArrayOfByte.extras.putString("target_package", a(paramik));
    }
    if (localib.a() == null) {
      localObject2 = null;
    } else {
      localObject2 = (String)localib.a().get("message_count");
    }
    if ((l.a()) && (localObject2 != null)) {
      try
      {
        a(paramArrayOfByte, Integer.parseInt((String)localObject2));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (localib != null) {
          fd.a(???.getApplicationContext()).a(paramik.b(), b(paramik), localib.a(), localNumberFormatException);
        }
        b.a(localNumberFormatException);
      }
    }
    if ((!l.c()) && ("com.xiaomi.xmsf".equals(???.getPackageName()))) {
      a(paramArrayOfByte, a(paramik));
    }
    ((NotificationManager)localObject4).notify(j, paramArrayOfByte);
    if ((l.a()) && ("com.xiaomi.xmsf".equals(???.getPackageName()))) {
      a(???, paramArrayOfByte, j, a(paramik));
    }
    if (a(paramik)) {
      fd.a(???.getApplicationContext()).a(paramik.b(), b(paramik), localib.a(), 3002, "try show business message");
    }
    if (c(paramik)) {
      fd.a(???.getApplicationContext()).a(paramik.b(), b(paramik), localib.a(), 1002, "try show notification message");
    }
    if (Build.VERSION.SDK_INT < 26)
    {
      ??? = ai.a(???);
      ???.a(j);
      i = a(localib.a());
      if (i > 0) {
        ???.b(new ab(j, (NotificationManager)localObject4), i);
      }
    }
    paramik = new Pair(Integer.valueOf(j), paramik);
    synchronized (jdField_a_of_type_JavaUtilLinkedList)
    {
      jdField_a_of_type_JavaUtilLinkedList.add(paramik);
      if (jdField_a_of_type_JavaUtilLinkedList.size() > 100) {
        jdField_a_of_type_JavaUtilLinkedList.remove();
      }
      return localc;
    }
  }
  
  private static d a(NotificationManager paramNotificationManager, String paramString1, String paramString2)
  {
    d locald = new d();
    if ((paramNotificationManager != null) && (Build.VERSION.SDK_INT >= 23) && (!TextUtils.isEmpty(paramString1)))
    {
      StatusBarNotification[] arrayOfStatusBarNotification = paramNotificationManager.getActiveNotifications();
      if ((arrayOfStatusBarNotification != null) && (arrayOfStatusBarNotification.length > 0))
      {
        int k = arrayOfStatusBarNotification.length;
        int i = 0;
        while (i < k)
        {
          StatusBarNotification localStatusBarNotification = arrayOfStatusBarNotification[i];
          if (localStatusBarNotification != null)
          {
            paramString1 = localStatusBarNotification.getPackageName();
            if (localStatusBarNotification.getNotification() != null) {
              paramNotificationManager = localStatusBarNotification.getNotification().getGroup();
            } else {
              paramNotificationManager = "";
            }
            if (!TextUtils.isEmpty(paramNotificationManager))
            {
              Object localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramString1);
              ((StringBuilder)localObject).append(paramNotificationManager);
              localObject = ((StringBuilder)localObject).toString();
              boolean bool = paramString2.equals(localObject);
              paramNotificationManager = null;
              if (bool)
              {
                paramString1 = ba.a(localStatusBarNotification.getNotification(), "isGroupSummary", (Object[])null);
                if ((paramString1 != null) && ((paramString1 instanceof Boolean)) && (((Boolean)Boolean.class.cast(paramString1)).booleanValue()))
                {
                  locald.jdField_a_of_type_Boolean = true;
                  locald.jdField_a_of_type_AndroidServiceNotificationStatusBarNotification = localStatusBarNotification;
                  break label329;
                }
              }
              int j;
              if (locald.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
                j = ((Integer)locald.jdField_a_of_type_JavaUtilHashMap.get(localObject)).intValue();
              } else {
                j = 0;
              }
              locald.jdField_a_of_type_JavaUtilHashMap.put(localObject, Integer.valueOf(j + 1));
              if (locald.b.containsKey(localObject)) {
                paramNotificationManager = (HashSet)locald.b.get(localObject);
              }
              paramString1 = paramNotificationManager;
              if (paramNotificationManager == null)
              {
                paramString1 = new HashSet();
                locald.b.put(localObject, paramString1);
              }
              paramString1.add(Integer.valueOf(localStatusBarNotification.getId()));
            }
          }
          label329:
          i += 1;
        }
      }
    }
    return locald;
  }
  
  private static String a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    if ((paramMap != null) && (!TextUtils.isEmpty((CharSequence)paramMap.get("channel_name")))) {
      return (String)paramMap.get("channel_name");
    }
    return g.b(paramContext, paramString);
  }
  
  static String a(ik paramik)
  {
    if ("com.xiaomi.xmsf".equals(paramik.b))
    {
      Object localObject = paramik.a();
      if ((localObject != null) && (((ib)localObject).a() != null))
      {
        localObject = (String)((ib)localObject).a().get("miui_package_name");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          return (String)localObject;
        }
      }
    }
    return paramik.b;
  }
  
  private static void a(Notification paramNotification, int paramInt)
  {
    paramNotification = ba.a(paramNotification, "extraNotification");
    if (paramNotification != null) {
      ba.a(paramNotification, "setMessageCount", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  private static void a(NotificationManager paramNotificationManager, String paramString1, String paramString2)
  {
    int i = a(paramString1, paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("GROUPSUMMARY  : cancelGroupSummarytargetPackageName = ");
    paramString2.append(paramString1);
    paramString2.append(" id = ");
    paramString2.append(i);
    b.b(paramString2.toString());
    paramNotificationManager.cancel(i);
  }
  
  private static void a(Context paramContext, Notification paramNotification, int paramInt, String paramString)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramContext.getPackageName());
    ((StringBuilder)localObject1).append(paramNotification.getGroup());
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = a(localNotificationManager, paramNotification.getGroup(), (String)localObject2);
    boolean bool = ((d)localObject1).jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2);
    int k = 0;
    int i;
    if (bool) {
      i = ((Integer)((d)localObject1).jdField_a_of_type_JavaUtilHashMap.get(localObject2)).intValue();
    } else {
      i = 0;
    }
    int j = k;
    if (((d)localObject1).b.containsKey(localObject2))
    {
      localObject2 = (HashSet)((d)localObject1).b.get(localObject2);
      j = k;
      if (localObject2 != null)
      {
        j = k;
        if (((HashSet)localObject2).contains(Integer.valueOf(paramInt))) {
          j = 1;
        }
      }
    }
    if ((i <= 1) && ((i != 1) || (j != 0)))
    {
      if ((i < 1) && (((d)localObject1).jdField_a_of_type_Boolean)) {
        a(localNotificationManager, paramString, paramNotification.getGroup());
      }
    }
    else
    {
      if (!((d)localObject1).jdField_a_of_type_Boolean)
      {
        a(paramContext, paramString, paramNotification, localNotificationManager);
        return;
      }
      if ((((d)localObject1).jdField_a_of_type_AndroidServiceNotificationStatusBarNotification != null) && (((d)localObject1).jdField_a_of_type_AndroidServiceNotificationStatusBarNotification.getNotification() != null))
      {
        paramContext = ((d)localObject1).jdField_a_of_type_AndroidServiceNotificationStatusBarNotification.getNotification();
        paramContext.when = System.currentTimeMillis();
        localNotificationManager.notify(((d)localObject1).jdField_a_of_type_AndroidServiceNotificationStatusBarNotification.getId(), paramContext);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, -1);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    int i = paramString.hashCode() / 10 * 10 + paramInt;
    LinkedList localLinkedList2 = new LinkedList();
    if (paramInt >= 0) {
      localNotificationManager.cancel(i);
    }
    synchronized (jdField_a_of_type_JavaUtilLinkedList)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        Object localObject = (ik)localPair.second;
        if (localObject != null)
        {
          localObject = a((ik)localObject);
          if (paramInt >= 0) {
            if ((i != ((Integer)localPair.first).intValue()) || (!TextUtils.equals((CharSequence)localObject, paramString))) {
              break;
            }
          } else {
            for (;;)
            {
              localLinkedList2.add(localPair);
              break;
              if ((paramInt != -1) || (!TextUtils.equals((CharSequence)localObject, paramString))) {
                break;
              }
              localNotificationManager.cancel(((Integer)localPair.first).intValue());
            }
          }
        }
      }
      if (jdField_a_of_type_JavaUtilLinkedList != null)
      {
        jdField_a_of_type_JavaUtilLinkedList.removeAll(localLinkedList2);
        a(paramContext, localLinkedList2);
      }
      return;
    }
  }
  
  private static void a(Context paramContext, String paramString, Notification paramNotification, NotificationManager paramNotificationManager)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        String str = paramNotification.getGroup();
        Object localObject = null;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26)
        {
          if (ba.a(paramNotificationManager, "getNotificationChannel", new Object[] { "groupSummary" }) == null) {
            ba.a(paramNotificationManager, "createNotificationChannel", new Object[] { t.a(paramContext, "android.app.NotificationChannel").getConstructor(new Class[] { String.class, CharSequence.class, Integer.TYPE }).newInstance(new Object[] { "groupSummary", "group_summary", Integer.valueOf(3) }) });
          }
          if (!TextUtils.isEmpty(str))
          {
            localObject = new Notification.Builder(paramContext);
            ((Notification.Builder)localObject).setContentTitle("GroupSummary").setContentText("GroupSummary").setLargeIcon(paramNotification.getLargeIcon()).setSmallIcon(paramNotification.getSmallIcon()).setAutoCancel(true).setGroup(str).setGroupSummary(true);
            ba.a(localObject, "setChannelId", new Object[] { "groupSummary" });
            localObject = ((Notification.Builder)localObject).build();
          }
        }
        else if (!TextUtils.isEmpty(str))
        {
          localObject = new Notification.Builder(paramContext);
          ((Notification.Builder)localObject).setContentTitle("GroupSummary").setContentText("GroupSummary").setLargeIcon(paramNotification.getLargeIcon()).setSmallIcon(paramNotification.getSmallIcon()).setPriority(0).setDefaults(-1).setAutoCancel(true).setGroup(str).setGroupSummary(true);
          localObject = ((Notification.Builder)localObject).build();
        }
        if ((localObject != null) && (!l.c()) && ("com.xiaomi.xmsf".equals(paramContext.getPackageName())))
        {
          a((Notification)localObject, paramString);
          if (((Notification)localObject).extras != null) {
            ((Notification)localObject).extras.putString("target_package", paramString);
          }
        }
        i = a(paramString, str);
        if (localObject != null)
        {
          paramNotificationManager.notify(i, (Notification)localObject);
          paramContext = new StringBuilder();
          paramContext.append("GROUPSUMMARY  : showGroupSummary targetPackageName = ");
          paramContext.append(paramString);
          paramContext.append(" id = ");
          paramContext.append(i);
          b.b(paramContext.toString());
          return;
        }
      }
    }
    catch (Exception paramContext)
    {
      b.a(paramContext);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
      return;
    }
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    LinkedList localLinkedList2 = new LinkedList();
    synchronized (jdField_a_of_type_JavaUtilLinkedList)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        Object localObject = (ik)localPair.second;
        if (localObject != null)
        {
          String str = a((ik)localObject);
          localObject = ((ik)localObject).a();
          if ((localObject != null) && (TextUtils.equals(str, paramString1)))
          {
            str = ((ib)localObject).c();
            localObject = ((ib)localObject).d();
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (a(paramString2, str)) && (a(paramString3, (String)localObject)))
            {
              localNotificationManager.cancel(((Integer)localPair.first).intValue());
              localLinkedList2.add(localPair);
            }
          }
        }
      }
      if (jdField_a_of_type_JavaUtilLinkedList != null)
      {
        jdField_a_of_type_JavaUtilLinkedList.removeAll(localLinkedList2);
        a(paramContext, localLinkedList2);
      }
      return;
    }
  }
  
  public static void a(Context paramContext, LinkedList<? extends Object> paramLinkedList)
  {
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0)) {
      bf.a(paramContext, "category_clear_notification", "clear_notification", paramLinkedList.size(), "");
    }
  }
  
  private static void a(Object paramObject, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (TextUtils.isEmpty((CharSequence)paramMap.get("channel_description"))) {
        return;
      }
      ba.a(paramObject, "setDescription", new Object[] { paramMap.get("channel_description") });
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localRunningAppProcessInfo.importance == 100) && (Arrays.asList(localRunningAppProcessInfo.pkgList).contains(paramString))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(ib paramib)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramib != null)
    {
      paramib = paramib.a();
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramib))
      {
        bool1 = bool2;
        if (paramib.length() == 22)
        {
          bool1 = bool2;
          if ("satuigmo".indexOf(paramib.charAt(0)) >= 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(ik paramik)
  {
    paramik = paramik.a();
    return (a(paramik)) && (paramik.l());
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return (TextUtils.isEmpty(paramString1)) || (paramString2.contains(paramString1));
  }
  
  public static boolean a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey("notify_foreground"))) {
      return "1".equals((String)paramMap.get("notify_foreground"));
    }
    return true;
  }
  
  private static String[] a(Context paramContext, ib paramib)
  {
    String str1 = paramib.c();
    String str2 = paramib.d();
    Map localMap = paramib.a();
    paramib = str1;
    Object localObject = str2;
    if (localMap != null)
    {
      int i = paramContext.getResources().getDisplayMetrics().widthPixels;
      float f = paramContext.getResources().getDisplayMetrics().density;
      i = Float.valueOf(i / f + 0.5F).intValue();
      if (i <= 320)
      {
        paramib = (String)localMap.get("title_short");
        paramContext = str1;
        if (!TextUtils.isEmpty(paramib)) {
          paramContext = paramib;
        }
        str1 = (String)localMap.get("description_short");
        paramib = paramContext;
        localObject = str2;
        if (TextUtils.isEmpty(str1)) {
          break label212;
        }
        paramib = str1;
      }
      else
      {
        paramib = str1;
        localObject = str2;
        if (i <= 360) {
          break label212;
        }
        paramib = (String)localMap.get("title_long");
        paramContext = str1;
        if (!TextUtils.isEmpty(paramib)) {
          paramContext = paramib;
        }
        str1 = (String)localMap.get("description_long");
        paramib = paramContext;
        localObject = str2;
        if (TextUtils.isEmpty(str1)) {
          break label212;
        }
        paramib = str1;
      }
      localObject = paramib;
      paramib = paramContext;
    }
    label212:
    return new String[] { paramib, localObject };
  }
  
  private static int b(Context paramContext, String paramString)
  {
    int i = a(paramContext, paramString, "mipush_notification");
    int j = a(paramContext, paramString, "mipush_small_notification");
    if (i <= 0) {
      if (j > 0) {
        i = j;
      } else {
        i = paramContext.getApplicationInfo().icon;
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (Build.VERSION.SDK_INT >= 9) {
        j = paramContext.getApplicationInfo().logo;
      }
    }
    return j;
  }
  
  private static int b(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = (String)paramMap.get("channel_importance");
      if (!TextUtils.isEmpty(paramMap)) {
        try
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("importance=");
          localStringBuilder.append(3);
          b.c(localStringBuilder.toString());
          int i = Integer.parseInt(paramMap);
          return i;
        }
        catch (Exception paramMap)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("parsing channel importance error: ");
          localStringBuilder.append(paramMap);
          b.d(localStringBuilder.toString());
        }
      }
    }
    return 3;
  }
  
  public static String b(ik paramik)
  {
    if (a(paramik)) {
      return "E100002";
    }
    if (c(paramik)) {
      return "E100000";
    }
    if (b(paramik)) {
      return "E100001";
    }
    if (d(paramik)) {
      return "E100003";
    }
    return "";
  }
  
  static void b(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("pref_notify_type", 0).edit().remove(paramString).commit();
  }
  
  static void b(Context paramContext, String paramString, int paramInt)
  {
    paramContext.getSharedPreferences("pref_notify_type", 0).edit().putInt(paramString, paramInt).commit();
  }
  
  static boolean b(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("pref_notify_type", 0).contains(paramString);
  }
  
  public static boolean b(ik paramik)
  {
    ib localib = paramik.a();
    return (a(localib)) && (localib.b == 1) && (!a(paramik));
  }
  
  private static int c(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = (String)paramMap.get("notification_priority");
      if (!TextUtils.isEmpty(paramMap)) {
        try
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("priority=");
          localStringBuilder.append(paramMap);
          b.c(localStringBuilder.toString());
          int i = Integer.parseInt(paramMap);
          return i;
        }
        catch (Exception paramMap)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("parsing notification priority error: ");
          localStringBuilder.append(paramMap);
          b.d(localStringBuilder.toString());
        }
      }
    }
    return 0;
  }
  
  public static boolean c(ik paramik)
  {
    ib localib = paramik.a();
    return (a(localib)) && (localib.b == 0) && (!a(paramik));
  }
  
  public static boolean d(ik paramik)
  {
    return paramik.a() == ho.a;
  }
  
  public static boolean e(ik paramik)
  {
    return (a(paramik)) || (c(paramik)) || (b(paramik));
  }
  
  private static class a
    implements Callable<Bitmap>
  {
    private Context jdField_a_of_type_AndroidContentContext;
    private String jdField_a_of_type_JavaLangString;
    private boolean jdField_a_of_type_Boolean;
    
    public a(String paramString, Context paramContext, boolean paramBoolean)
    {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
    
    public Bitmap a()
    {
      return null;
    }
  }
  
  public static class b
  {
    long jdField_a_of_type_Long;
    Notification jdField_a_of_type_AndroidAppNotification;
    
    public b()
    {
      this.a = 0L;
    }
  }
  
  public static class c
  {
    public long a = 0L;
    public String a;
  }
  
  public static class d
  {
    public StatusBarNotification a;
    public HashMap<String, Integer> a;
    public boolean a;
    public HashMap<String, HashSet<Integer>> b = new HashMap();
    
    public d()
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidServiceNotificationStatusBarNotification = null;
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */