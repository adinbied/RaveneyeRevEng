package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.push.ai;
import com.xiaomi.push.es;
import com.xiaomi.push.eu;
import com.xiaomi.push.ht;
import com.xiaomi.push.hy;
import com.xiaomi.push.in;
import com.xiaomi.push.iy;
import com.xiaomi.push.iz;
import com.xiaomi.push.l;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.ak;
import java.util.HashMap;
import java.util.Map;

public class n
{
  public static void a(Context paramContext, Intent paramIntent, Uri paramUri)
  {
    if (paramContext == null) {
      return;
    }
    aw.a(paramContext).a();
    if (es.a(paramContext.getApplicationContext()).a() == null)
    {
      es.a(paramContext.getApplicationContext()).a(b.a(paramContext.getApplicationContext()).a(), paramContext.getPackageName(), ah.a(paramContext.getApplicationContext()).a(ht.aF.a(), 0), new c());
      ah.a(paramContext).a(new p(102, "awake online config", paramContext));
    }
    es locales;
    if (((paramContext instanceof Activity)) && (paramIntent != null))
    {
      locales = es.a(paramContext.getApplicationContext());
      paramUri = eu.a;
    }
    for (;;)
    {
      locales.a(paramUri, paramContext, paramIntent, null);
      return;
      if ((!(paramContext instanceof Service)) || (paramIntent == null)) {
        break;
      }
      if ("com.xiaomi.mipush.sdk.WAKEUP".equals(paramIntent.getAction()))
      {
        locales = es.a(paramContext.getApplicationContext());
        paramUri = eu.c;
      }
      else
      {
        locales = es.a(paramContext.getApplicationContext());
        paramUri = eu.b;
      }
    }
    if ((paramUri != null) && (!TextUtils.isEmpty(paramUri.toString()))) {
      es.a(paramContext.getApplicationContext()).a(eu.d, paramContext, null, paramUri.toString());
    }
  }
  
  private static void a(Context paramContext, in paramin)
  {
    ah localah = ah.a(paramContext);
    int i = ht.aG.a();
    boolean bool1 = false;
    boolean bool2 = localah.a(i, false);
    int j = ah.a(paramContext).a(ht.aH.a(), 0);
    i = j;
    if (j >= 0)
    {
      i = j;
      if (j < 30)
      {
        com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
        i = 30;
      }
    }
    if (i >= 0) {
      bool1 = bool2;
    }
    if (!l.a())
    {
      a(paramContext, paramin, bool1, i);
      return;
    }
    if (bool1) {
      ai.a(paramContext.getApplicationContext()).a(new o(paramin, paramContext), i);
    }
  }
  
  public static final <T extends iz<T, ?>> void a(Context paramContext, T paramT, boolean paramBoolean, int paramInt)
  {
    paramT = iy.a(paramT);
    if (paramT == null)
    {
      com.xiaomi.channel.commonutils.logger.b.a("send message fail, because msgBytes is null.");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("action_help_ping");
    localIntent.putExtra("extra_help_ping_switch", paramBoolean);
    localIntent.putExtra("extra_help_ping_frequency", paramInt);
    localIntent.putExtra("mipush_payload", paramT);
    localIntent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
    aw.a(paramContext).a(localIntent);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    com.xiaomi.channel.commonutils.logger.b.a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
    HashMap localHashMap = new HashMap();
    localHashMap.put("awake_info", paramString);
    localHashMap.put("event_type", String.valueOf(9999));
    localHashMap.put("description", "ping message");
    paramString = new in();
    paramString.b(b.a(paramContext).a());
    paramString.d(paramContext.getPackageName());
    paramString.c(hy.H.a);
    paramString.a(ak.a());
    paramString.a = localHashMap;
    a(paramContext, paramString);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    in localin = new in();
    localin.b(paramString1);
    localin.a(new HashMap());
    localin.a().put("extra_aw_app_online_cmd", String.valueOf(paramInt));
    localin.a().put("extra_help_aw_info", paramString2);
    localin.a(ak.a());
    paramString1 = iy.a(localin);
    if (paramString1 == null)
    {
      com.xiaomi.channel.commonutils.logger.b.a("send message fail, because msgBytes is null.");
      return;
    }
    paramString2 = new Intent();
    paramString2.setAction("action_aw_app_logic");
    paramString2.putExtra("mipush_payload", paramString1);
    aw.a(paramContext).a(paramString2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */