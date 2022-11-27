package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.t;
import java.lang.reflect.Field;

public class k
{
  public final int a;
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  
  public k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = t.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    return ("com.xiaomi.xmsf".equals(paramContext.getPackageName())) && (a());
  }
  
  private static boolean b(Context paramContext)
  {
    return paramContext.getPackageName().equals("com.xiaomi.xmsf");
  }
  
  public am.b a(XMPushService paramXMPushService)
  {
    return null;
  }
  
  public am.b a(am.b paramb, Context paramContext, d paramd, String paramString)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */