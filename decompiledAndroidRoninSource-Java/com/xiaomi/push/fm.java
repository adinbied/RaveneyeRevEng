package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.am.b;
import java.util.HashMap;
import java.util.Map;

class fm
{
  public static void a(am.b paramb, String paramString, fu paramfu)
  {
    em.c localc = new em.c();
    if (!TextUtils.isEmpty(paramb.c)) {
      localc.a(paramb.c);
    }
    if (!TextUtils.isEmpty(paramb.e)) {
      localc.d(paramb.e);
    }
    if (!TextUtils.isEmpty(paramb.f)) {
      localc.e(paramb.f);
    }
    if (paramb.jdField_a_of_type_Boolean) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localc.b((String)localObject1);
    if (!TextUtils.isEmpty(paramb.d)) {
      localc.c(paramb.d);
    } else {
      localc.c("XIAOMI-SASL");
    }
    Object localObject1 = new fn();
    ((fn)localObject1).c(paramb.b);
    ((fn)localObject1).a(Integer.parseInt(paramb.g));
    ((fn)localObject1).b(paramb.jdField_a_of_type_JavaLangString);
    ((fn)localObject1).a("BIND", null);
    ((fn)localObject1).a(((fn)localObject1).e());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[Slim]: bind id=");
    ((StringBuilder)localObject2).append(((fn)localObject1).e());
    b.a(((StringBuilder)localObject2).toString());
    localObject2 = new HashMap();
    ((Map)localObject2).put("challenge", paramString);
    ((Map)localObject2).put("token", paramb.c);
    ((Map)localObject2).put("chid", paramb.g);
    ((Map)localObject2).put("from", paramb.b);
    ((Map)localObject2).put("id", ((fn)localObject1).e());
    ((Map)localObject2).put("to", "xiaomi.com");
    if (paramb.jdField_a_of_type_Boolean) {
      ((Map)localObject2).put("kick", "1");
    } else {
      ((Map)localObject2).put("kick", "0");
    }
    if (!TextUtils.isEmpty(paramb.e)) {
      ((Map)localObject2).put("client_attrs", paramb.e);
    } else {
      ((Map)localObject2).put("client_attrs", "");
    }
    if (!TextUtils.isEmpty(paramb.f)) {
      ((Map)localObject2).put("cloud_attrs", paramb.f);
    } else {
      ((Map)localObject2).put("cloud_attrs", "");
    }
    if ((!paramb.d.equals("XIAOMI-PASS")) && (!paramb.d.equals("XMPUSH-PASS")))
    {
      paramb.d.equals("XIAOMI-SASL");
      paramb = null;
    }
    else
    {
      paramb = bd.a(paramb.d, null, (Map)localObject2, paramb.h);
    }
    localc.f(paramb);
    ((fn)localObject1).a(localc.a(), null);
    paramfu.b((fn)localObject1);
  }
  
  public static void a(String paramString1, String paramString2, fu paramfu)
  {
    fn localfn = new fn();
    localfn.c(paramString2);
    localfn.a(Integer.parseInt(paramString1));
    localfn.a("UBND", null);
    paramfu.b(localfn);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\fm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */