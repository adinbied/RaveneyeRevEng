package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dh;
import com.xiaomi.push.fn;
import com.xiaomi.push.fu;
import com.xiaomi.push.gf;
import com.xiaomi.push.gl;
import com.xiaomi.push.ho;
import com.xiaomi.push.ib;
import com.xiaomi.push.id;
import com.xiaomi.push.ik;
import com.xiaomi.push.in;
import com.xiaomi.push.iy;
import com.xiaomi.push.iz;
import com.xiaomi.push.je;
import java.nio.ByteBuffer;
import java.util.Map;

final class w
{
  static fn a(XMPushService paramXMPushService, byte[] paramArrayOfByte)
  {
    ik localik = new ik();
    try
    {
      iy.a(localik, paramArrayOfByte);
      paramXMPushService = a(l.a(paramXMPushService), paramXMPushService, localik);
      return paramXMPushService;
    }
    catch (je paramXMPushService)
    {
      b.a(paramXMPushService);
    }
    return null;
  }
  
  static fn a(k paramk, Context paramContext, ik paramik)
  {
    try
    {
      paramContext = new fn();
      paramContext.a(5);
      paramContext.c(paramk.jdField_a_of_type_JavaLangString);
      paramContext.b(a(paramik));
      paramContext.a("SECMSG", "message");
      String str = paramk.jdField_a_of_type_JavaLangString;
      paramik.jdField_a_of_type_ComXiaomiPushId.jdField_a_of_type_JavaLangString = str.substring(0, str.indexOf("@"));
      paramik.jdField_a_of_type_ComXiaomiPushId.c = str.substring(str.indexOf("/") + 1);
      paramContext.a(iy.a(paramik), paramk.c);
      paramContext.a((short)1);
      paramk = new StringBuilder();
      paramk.append("try send mi push message. packagename:");
      paramk.append(paramik.b);
      paramk.append(" action:");
      paramk.append(paramik.jdField_a_of_type_ComXiaomiPushHo);
      b.a(paramk.toString());
      return paramContext;
    }
    catch (NullPointerException paramk)
    {
      b.a(paramk);
    }
    return null;
  }
  
  static ik a(String paramString1, String paramString2)
  {
    in localin = new in();
    localin.b(paramString2);
    localin.c("package uninstalled");
    localin.a(gl.i());
    localin.a(false);
    return a(paramString1, paramString2, localin, ho.i);
  }
  
  static <T extends iz<T, ?>> ik a(String paramString1, String paramString2, T paramT, ho paramho)
  {
    paramT = iy.a(paramT);
    ik localik = new ik();
    id localid = new id();
    localid.jdField_a_of_type_Long = 5L;
    localid.jdField_a_of_type_JavaLangString = "fakeid";
    localik.a(localid);
    localik.a(ByteBuffer.wrap(paramT));
    localik.a(paramho);
    localik.b(true);
    localik.b(paramString1);
    localik.a(false);
    localik.a(paramString2);
    return localik;
  }
  
  private static String a(ik paramik)
  {
    if ((paramik.jdField_a_of_type_ComXiaomiPushIb != null) && (paramik.jdField_a_of_type_ComXiaomiPushIb.b != null))
    {
      String str = (String)paramik.jdField_a_of_type_ComXiaomiPushIb.b.get("ext_traffic_source_pkg");
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
    }
    return paramik.b;
  }
  
  static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".permission.MIPUSH_RECEIVE");
    return localStringBuilder.toString();
  }
  
  static void a(XMPushService paramXMPushService)
  {
    k localk = l.a(paramXMPushService.getApplicationContext());
    if (localk != null)
    {
      am.b localb = l.a(paramXMPushService.getApplicationContext()).a(paramXMPushService);
      a(paramXMPushService, localb);
      am.a().a(localb);
      bd.a(paramXMPushService).a(new x("GAID", 172800L, paramXMPushService, localk));
      a(paramXMPushService, localk, 172800);
    }
  }
  
  static void a(XMPushService paramXMPushService, ik paramik)
  {
    dh.a(paramik.b(), paramXMPushService.getApplicationContext(), paramik, -1);
    fu localfu = paramXMPushService.a();
    if (localfu != null)
    {
      if (localfu.a())
      {
        paramXMPushService = a(l.a(paramXMPushService), paramXMPushService, paramik);
        if (paramXMPushService != null) {
          localfu.b(paramXMPushService);
        }
        return;
      }
      throw new gf("Don't support XMPP connection.");
    }
    throw new gf("try send msg while connection is null.");
  }
  
  static void a(XMPushService paramXMPushService, am.b paramb)
  {
    paramb.a(null);
    paramb.a(new z(paramXMPushService));
  }
  
  private static void a(XMPushService paramXMPushService, k paramk, int paramInt)
  {
    bd.a(paramXMPushService).a(new y("MSAID", paramInt, paramXMPushService, paramk));
  }
  
  static void a(XMPushService paramXMPushService, String paramString, byte[] paramArrayOfByte)
  {
    dh.a(paramString, paramXMPushService.getApplicationContext(), paramArrayOfByte);
    fu localfu = paramXMPushService.a();
    if (localfu != null)
    {
      if (localfu.a())
      {
        fn localfn = a(paramXMPushService, paramArrayOfByte);
        if (localfn != null)
        {
          localfu.b(localfn);
          return;
        }
        o.a(paramXMPushService, paramString, paramArrayOfByte, 70000003, "not a valid message");
        return;
      }
      throw new gf("Don't support XMPP connection.");
    }
    throw new gf("try send msg while connection is null.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */