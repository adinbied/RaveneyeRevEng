package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dh;
import com.xiaomi.push.fd;
import com.xiaomi.push.g;
import com.xiaomi.push.gf;
import com.xiaomi.push.gz;
import com.xiaomi.push.ho;
import com.xiaomi.push.hy;
import com.xiaomi.push.ib;
import com.xiaomi.push.ie;
import com.xiaomi.push.ik;
import com.xiaomi.push.in;
import com.xiaomi.push.iy;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public class p
{
  public static Intent a(byte[] paramArrayOfByte, long paramLong)
  {
    ik localik = a(paramArrayOfByte);
    if (localik == null) {
      return null;
    }
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.putExtra("mipush_payload", paramArrayOfByte);
    localIntent.putExtra("mrt", Long.toString(paramLong));
    localIntent.setPackage(localik.b);
    return localIntent;
  }
  
  public static ik a(Context paramContext, ik paramik)
  {
    ie localie = new ie();
    localie.b(paramik.a());
    ib localib = paramik.a();
    if (localib != null)
    {
      localie.a(localib.a());
      localie.a(localib.a());
      if (!TextUtils.isEmpty(localib.b())) {
        localie.c(localib.b());
      }
    }
    localie.a(iy.a(paramContext, paramik));
    paramContext = w.a(paramik.b(), paramik.a(), localie, ho.f);
    paramik = paramik.a().a();
    paramik.a("mat", Long.toString(System.currentTimeMillis()));
    paramContext.a(paramik);
    return paramContext;
  }
  
  public static ik a(byte[] paramArrayOfByte)
  {
    ik localik = new ik();
    try
    {
      iy.a(localik, paramArrayOfByte);
      return localik;
    }
    finally
    {
      b.a(paramArrayOfByte);
    }
    return null;
  }
  
  private static void a(XMPushService paramXMPushService, ik paramik)
  {
    paramXMPushService.a(new q(4, paramXMPushService, paramik));
  }
  
  private static void a(XMPushService paramXMPushService, ik paramik, String paramString)
  {
    paramXMPushService.a(new u(4, paramXMPushService, paramik, paramString));
  }
  
  private static void a(XMPushService paramXMPushService, ik paramik, String paramString1, String paramString2)
  {
    paramXMPushService.a(new v(4, paramXMPushService, paramik, paramString1, paramString2));
  }
  
  public static void a(XMPushService paramXMPushService, String paramString, byte[] paramArrayOfByte, Intent paramIntent)
  {
    ik localik = a(paramArrayOfByte);
    Object localObject = localik.a();
    String str2 = null;
    String str1 = null;
    if (paramArrayOfByte != null) {
      dh.a(localik.b(), paramXMPushService.getApplicationContext(), null, localik.a(), paramArrayOfByte.length);
    }
    if ((c(localik)) && (a(paramXMPushService, paramString)))
    {
      if (aa.e(localik)) {
        fd.a(paramXMPushService.getApplicationContext()).a(localik.b(), aa.b(localik), ((ib)localObject).a(), "old message received by new SDK.");
      }
      c(paramXMPushService, localik);
      return;
    }
    if ((a(localik)) && (!a(paramXMPushService, paramString)) && (!b(localik)))
    {
      if (aa.e(localik)) {
        fd.a(paramXMPushService.getApplicationContext()).a(localik.b(), aa.b(localik), ((ib)localObject).a(), "new message received by old SDK.");
      }
      d(paramXMPushService, localik);
      return;
    }
    if (((aa.a(localik)) && (g.b(paramXMPushService, localik.b))) || (a(paramXMPushService, paramIntent)))
    {
      if (ho.a == localik.a())
      {
        String str3 = localik.b();
        SharedPreferences.Editor localEditor = paramXMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
        localEditor.putString(str3, localik.jdField_a_of_type_JavaLangString);
        localEditor.commit();
        fd.a(paramXMPushService.getApplicationContext()).a(str3, "E100003", ((ib)localObject).a(), 6003, "receive a register message");
        if (!TextUtils.isEmpty(((ib)localObject).a()))
        {
          paramIntent.putExtra("messageId", ((ib)localObject).a());
          paramIntent.putExtra("eventMessageType", 6000);
        }
      }
      if (aa.c(localik))
      {
        fd.a(paramXMPushService.getApplicationContext()).a(localik.b(), aa.b(localik), ((ib)localObject).a(), 1001, System.currentTimeMillis(), "receive notification message ");
        if (!TextUtils.isEmpty(((ib)localObject).a()))
        {
          paramIntent.putExtra("messageId", ((ib)localObject).a());
          paramIntent.putExtra("eventMessageType", 1000);
        }
      }
      if (aa.b(localik))
      {
        fd.a(paramXMPushService.getApplicationContext()).a(localik.b(), aa.b(localik), ((ib)localObject).a(), 2001, System.currentTimeMillis(), "receive passThrough message");
        if (!TextUtils.isEmpty(((ib)localObject).a()))
        {
          paramIntent.putExtra("messageId", ((ib)localObject).a());
          paramIntent.putExtra("eventMessageType", 2000);
        }
      }
      if (aa.a(localik))
      {
        fd.a(paramXMPushService.getApplicationContext()).a(localik.b(), aa.b(localik), ((ib)localObject).a(), 3001, System.currentTimeMillis(), "receive business message");
        if (!TextUtils.isEmpty(((ib)localObject).a()))
        {
          paramIntent.putExtra("messageId", ((ib)localObject).a());
          paramIntent.putExtra("eventMessageType", 3000);
        }
      }
      if ((localObject != null) && (!TextUtils.isEmpty(((ib)localObject).c())) && (!TextUtils.isEmpty(((ib)localObject).d())) && (((ib)localObject).b != 1) && ((aa.a(((ib)localObject).a())) || (!aa.a(paramXMPushService, localik.b))))
      {
        boolean bool;
        if (localObject != null)
        {
          paramString = str1;
          if (((ib)localObject).a != null) {
            paramString = (String)((ib)localObject).a.get("jobkey");
          }
          paramIntent = paramString;
          if (TextUtils.isEmpty(paramString)) {
            paramIntent = ((ib)localObject).a();
          }
          bool = ac.a(paramXMPushService, localik.b, paramIntent);
        }
        else
        {
          bool = false;
          paramIntent = str2;
        }
        if (bool)
        {
          fd.a(paramXMPushService.getApplicationContext()).c(localik.b(), aa.b(localik), ((ib)localObject).a(), "drop a duplicate message");
          paramString = new StringBuilder();
          paramString.append("drop a duplicate message, key=");
          paramString.append(paramIntent);
          b.a(paramString.toString());
        }
        else
        {
          paramString = aa.a(paramXMPushService, localik, paramArrayOfByte);
          if ((paramString.jdField_a_of_type_Long > 0L) && (!TextUtils.isEmpty(paramString.jdField_a_of_type_JavaLangString))) {
            gz.a(paramXMPushService, paramString.jdField_a_of_type_JavaLangString, paramString.jdField_a_of_type_Long, true, false, System.currentTimeMillis());
          }
          if (!aa.a(localik))
          {
            paramString = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
            paramString.putExtra("mipush_payload", paramArrayOfByte);
            paramString.setPackage(localik.b);
            try
            {
              paramArrayOfByte = paramXMPushService.getPackageManager().queryBroadcastReceivers(paramString, 0);
              if ((paramArrayOfByte != null) && (!paramArrayOfByte.isEmpty())) {
                paramXMPushService.sendBroadcast(paramString, w.a(localik.b));
              }
            }
            catch (Exception paramArrayOfByte)
            {
              paramXMPushService.sendBroadcast(paramString, w.a(localik.b));
              fd.a(paramXMPushService.getApplicationContext()).b(localik.b(), aa.b(localik), ((ib)localObject).a(), paramArrayOfByte.getMessage());
            }
          }
        }
        b(paramXMPushService, localik);
      }
      else if (("com.xiaomi.xmsf".contains(localik.b)) && (!localik.b()) && (localObject != null) && (((ib)localObject).a() != null) && (((ib)localObject).a().containsKey("ab")))
      {
        b(paramXMPushService, localik);
        paramString = new StringBuilder();
        paramString.append("receive abtest message. ack it.");
        paramString.append(((ib)localObject).a());
        b.c(paramString.toString());
      }
      else if (a(paramXMPushService, paramString, localik, (ib)localObject))
      {
        if ((localObject != null) && (!TextUtils.isEmpty(((ib)localObject).a())))
        {
          int i;
          if (aa.b(localik))
          {
            paramString = fd.a(paramXMPushService.getApplicationContext());
            paramArrayOfByte = localik.b();
            str1 = aa.b(localik);
            str2 = ((ib)localObject).a();
            i = 2002;
          }
          for (localObject = "try send passThrough message Broadcast";; localObject = "try send register broadcast")
          {
            paramString.a(paramArrayOfByte, str1, str2, i, (String)localObject);
            break;
            if (aa.a(localik))
            {
              paramString = fd.a(paramXMPushService.getApplicationContext());
              paramArrayOfByte = localik.b();
              str1 = aa.b(localik);
              str2 = ((ib)localObject).a();
            }
            for (localObject = "try show awake message , but it don't show in foreground";; localObject = "try show notification message , but it don't show in foreground")
            {
              paramString.a(paramArrayOfByte, str1, str2, (String)localObject);
              break label1227;
              if (!aa.c(localik)) {
                break;
              }
              paramString = fd.a(paramXMPushService.getApplicationContext());
              paramArrayOfByte = localik.b();
              str1 = aa.b(localik);
              str2 = ((ib)localObject).a();
            }
            if (!aa.d(localik)) {
              break;
            }
            paramString = fd.a(paramXMPushService.getApplicationContext());
            paramArrayOfByte = localik.b();
            str2 = ((ib)localObject).a();
            i = 6004;
            str1 = "E100003";
          }
        }
        label1227:
        paramXMPushService.sendBroadcast(paramIntent, w.a(localik.b));
      }
      else
      {
        fd.a(paramXMPushService.getApplicationContext()).a(localik.b(), aa.b(localik), ((ib)localObject).a(), "passThough message: not permit to send broadcast ");
      }
      if ((localik.a() == ho.b) && (!"com.xiaomi.xmsf".equals(paramXMPushService.getPackageName()))) {
        paramXMPushService.stopSelf();
      }
    }
    else
    {
      if (!g.b(paramXMPushService, localik.b))
      {
        if (aa.e(localik)) {
          fd.a(paramXMPushService.getApplicationContext()).b(localik.b(), aa.b(localik), ((ib)localObject).a(), "receive a message, but the package is removed.");
        }
        a(paramXMPushService, localik);
        return;
      }
      b.a("receive a mipush message, we can see the app, but we can't see the receiver.");
      if (aa.e(localik)) {
        fd.a(paramXMPushService.getApplicationContext()).b(localik.b(), aa.b(localik), ((ib)localObject).a(), "receive a mipush message, we can see the app, but we can't see the receiver.");
      }
    }
  }
  
  private static void a(XMPushService paramXMPushService, byte[] paramArrayOfByte, long paramLong)
  {
    ik localik = a(paramArrayOfByte);
    if (localik == null) {
      return;
    }
    if (TextUtils.isEmpty(localik.b))
    {
      b.a("receive a mipush message without package name");
      return;
    }
    Object localObject1 = Long.valueOf(System.currentTimeMillis());
    Intent localIntent = a(paramArrayOfByte, ((Long)localObject1).longValue());
    String str = aa.a(localik);
    gz.a(paramXMPushService, str, paramLong, true, true, System.currentTimeMillis());
    ib localib = localik.a();
    if (localib != null) {
      localib.a("mrt", Long.toString(((Long)localObject1).longValue()));
    }
    Object localObject2 = ho.e;
    ho localho = localik.a();
    localObject1 = "";
    if ((localObject2 == localho) && (m.a(paramXMPushService).a(localik.b)) && (!aa.a(localik)))
    {
      if (localib != null)
      {
        paramArrayOfByte = localib.a();
        localObject1 = paramArrayOfByte;
        if (aa.e(localik))
        {
          fd.a(paramXMPushService.getApplicationContext()).a(localik.b(), aa.b(localik), paramArrayOfByte, "Drop a message for unregistered");
          localObject1 = paramArrayOfByte;
        }
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Drop a message for unregistered, msgid=");
      paramArrayOfByte.append((String)localObject1);
      b.a(paramArrayOfByte.toString());
      a(paramXMPushService, localik, localik.b);
      return;
    }
    if ((ho.e == localik.a()) && (m.a(paramXMPushService).c(localik.b)) && (!aa.a(localik)))
    {
      if (localib != null)
      {
        paramArrayOfByte = localib.a();
        localObject1 = paramArrayOfByte;
        if (aa.e(localik))
        {
          fd.a(paramXMPushService.getApplicationContext()).a(localik.b(), aa.b(localik), paramArrayOfByte, "Drop a message for push closed");
          localObject1 = paramArrayOfByte;
        }
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Drop a message for push closed, msgid=");
      paramArrayOfByte.append((String)localObject1);
      b.a(paramArrayOfByte.toString());
      a(paramXMPushService, localik, localik.b);
      return;
    }
    if ((ho.e == localik.a()) && (!TextUtils.equals(paramXMPushService.getPackageName(), "com.xiaomi.xmsf")) && (!TextUtils.equals(paramXMPushService.getPackageName(), localik.b)))
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Receive a message with wrong package name, expect ");
      paramArrayOfByte.append(paramXMPushService.getPackageName());
      paramArrayOfByte.append(", received ");
      paramArrayOfByte.append(localik.b);
      b.a(paramArrayOfByte.toString());
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("package should be ");
      paramArrayOfByte.append(paramXMPushService.getPackageName());
      paramArrayOfByte.append(", but got ");
      paramArrayOfByte.append(localik.b);
      a(paramXMPushService, localik, "unmatched_package", paramArrayOfByte.toString());
      if ((localib != null) && (aa.e(localik))) {
        fd.a(paramXMPushService.getApplicationContext()).a(localik.b(), aa.b(localik), localib.a(), "Receive a message with wrong package name");
      }
      return;
    }
    if ((localib != null) && (localib.a() != null)) {
      b.a(String.format("receive a message, appid=%1$s, msgid= %2$s", new Object[] { localik.a(), localib.a() }));
    }
    if (localib != null)
    {
      localObject1 = localib.a();
      if ((localObject1 != null) && (((Map)localObject1).containsKey("hide")) && ("true".equalsIgnoreCase((String)((Map)localObject1).get("hide"))))
      {
        b(paramXMPushService, localik);
        return;
      }
    }
    if ((localib != null) && (localib.a() != null) && (localib.a().containsKey("__miid")))
    {
      localObject1 = (String)localib.a().get("__miid");
      localObject2 = com.xiaomi.push.t.a(paramXMPushService.getApplicationContext());
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)))
      {
        if (aa.e(localik)) {
          fd.a(paramXMPushService.getApplicationContext()).a(localik.b(), aa.b(localik), localib.a(), "miid already logout or anther already login");
        }
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append((String)localObject1);
        paramArrayOfByte.append(" should be login, but got ");
        paramArrayOfByte.append((String)localObject2);
        b.a(paramArrayOfByte.toString());
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append((String)localObject1);
        paramArrayOfByte.append(" should be login, but got ");
        paramArrayOfByte.append((String)localObject2);
        a(paramXMPushService, localik, "miid already logout or anther already login", paramArrayOfByte.toString());
        return;
      }
    }
    a(paramXMPushService, str, paramArrayOfByte, localIntent);
  }
  
  private static boolean a(Context paramContext, Intent paramIntent)
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
  
  private static boolean a(Context paramContext, String paramString)
  {
    Intent localIntent1 = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
    localIntent1.setPackage(paramString);
    Intent localIntent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
    localIntent2.setPackage(paramString);
    paramContext = paramContext.getPackageManager();
    boolean bool1 = false;
    try
    {
      paramString = paramContext.queryBroadcastReceivers(localIntent2, 32);
      paramContext = paramContext.queryIntentServices(localIntent1, 32);
      if (paramString.isEmpty())
      {
        boolean bool2 = paramContext.isEmpty();
        if (bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramContext)
    {
      b.a(paramContext);
    }
    return false;
  }
  
  private static boolean a(ik paramik)
  {
    return ("com.xiaomi.xmsf".equals(paramik.b)) && (paramik.a() != null) && (paramik.a().a() != null) && (paramik.a().a().containsKey("miui_package_name"));
  }
  
  private static boolean a(XMPushService paramXMPushService, String paramString, ik paramik, ib paramib)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool1 = bool3;
    if (paramib != null)
    {
      bool1 = bool3;
      if (paramib.a() != null)
      {
        bool1 = bool3;
        if (paramib.a().containsKey("__check_alive"))
        {
          bool1 = bool3;
          if (paramib.a().containsKey("__awake"))
          {
            in localin = new in();
            localin.b(paramik.a());
            localin.d(paramString);
            localin.c(hy.G.jdField_a_of_type_JavaLangString);
            localin.a(paramib.a());
            localin.a = new HashMap();
            bool3 = g.a(paramXMPushService.getApplicationContext(), paramString);
            localin.a.put("app_running", Boolean.toString(bool3));
            bool1 = bool2;
            if (!bool3)
            {
              bool3 = Boolean.parseBoolean((String)paramib.a().get("__awake"));
              localin.a.put("awaked", Boolean.toString(bool3));
              bool1 = bool2;
              if (!bool3) {
                bool1 = false;
              }
            }
            paramString = w.a(paramik.b(), paramik.a(), localin, ho.i);
            try
            {
              w.a(paramXMPushService, paramString);
              return bool1;
            }
            catch (gf paramXMPushService)
            {
              b.a(paramXMPushService);
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private static void b(XMPushService paramXMPushService, ik paramik)
  {
    paramXMPushService.a(new r(4, paramXMPushService, paramik));
  }
  
  private static boolean b(ik paramik)
  {
    paramik = paramik.a().a();
    return (paramik != null) && (paramik.containsKey("notify_effect"));
  }
  
  private static void c(XMPushService paramXMPushService, ik paramik)
  {
    paramXMPushService.a(new s(4, paramXMPushService, paramik));
  }
  
  private static boolean c(ik paramik)
  {
    if ((paramik.a() != null) && (paramik.a().a() != null)) {
      return "1".equals(paramik.a().a().get("obslete_ads_message"));
    }
    return false;
  }
  
  private static void d(XMPushService paramXMPushService, ik paramik)
  {
    paramXMPushService.a(new t(4, paramXMPushService, paramik));
  }
  
  public void a(Context paramContext, am.b paramb, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean)
    {
      paramb = l.a(paramContext);
      if ((paramb != null) && ("token-expired".equals(paramString)))
      {
        try
        {
          l.a(paramContext, paramb.f, paramb.d, paramb.e);
          return;
        }
        catch (JSONException paramContext) {}catch (IOException paramContext) {}
        b.a(paramContext);
      }
    }
  }
  
  /* Error */
  public void a(XMPushService arg1, com.xiaomi.push.fn arg2, am.b arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(XMPushService arg1, com.xiaomi.push.gl arg2, am.b arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */