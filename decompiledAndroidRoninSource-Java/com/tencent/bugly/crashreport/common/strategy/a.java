package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;
import java.util.Map;

public final class a
{
  public static int a = 1000;
  private static a b;
  private static String h;
  private final List<com.tencent.bugly.a> c;
  private final w d;
  private final StrategyBean e;
  private StrategyBean f = null;
  private Context g;
  
  private a(Context paramContext, List<com.tencent.bugly.a> paramList)
  {
    this.g = paramContext;
    if (com.tencent.bugly.crashreport.common.info.a.a(paramContext) != null)
    {
      paramContext = com.tencent.bugly.crashreport.common.info.a.a(paramContext).y;
      if ("oversea".equals(paramContext)) {}
      for (paramContext = "https://astat.bugly.qcloud.com/rqd/async";; paramContext = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async")
      {
        StrategyBean.a = paramContext;
        StrategyBean.b = paramContext;
        break;
        if (!"na_https".equals(paramContext)) {
          break;
        }
      }
    }
    this.e = new StrategyBean();
    this.c = paramList;
    this.d = w.a();
  }
  
  public static a a()
  {
    try
    {
      a locala = b;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static a a(Context paramContext, List<com.tencent.bugly.a> paramList)
  {
    try
    {
      if (b == null) {
        b = new a(paramContext, paramList);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    if ((!z.a(paramString)) && (z.c(paramString)))
    {
      h = paramString;
      return;
    }
    x.d("URL user set is invalid.", new Object[0]);
  }
  
  public static StrategyBean d()
  {
    Object localObject = p.a().a(2);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (r)((List)localObject).get(0);
      if (((r)localObject).g != null) {
        return (StrategyBean)z.a(((r)localObject).g, StrategyBean.CREATOR);
      }
    }
    return null;
  }
  
  public final void a(long paramLong)
  {
    this.d.a(new Thread()
    {
      public final void run()
      {
        try
        {
          Object localObject = p.a().a(a.a, null, true);
          if (localObject != null)
          {
            byte[] arrayOfByte = (byte[])((Map)localObject).get("device");
            localObject = (byte[])((Map)localObject).get("gateway");
            if (arrayOfByte != null) {
              com.tencent.bugly.crashreport.common.info.a.a(a.a(a.this)).f(new String(arrayOfByte));
            }
            if (localObject != null) {
              com.tencent.bugly.crashreport.common.info.a.a(a.a(a.this)).e(new String((byte[])localObject));
            }
          }
          a.a(a.this, a.d());
          if (a.b(a.this) != null) {
            if ((!z.a(a.e())) && (z.c(a.e())))
            {
              a.b(a.this).p = a.e();
              a.b(a.this).q = a.e();
            }
            else
            {
              a.b(a.this).p = StrategyBean.a;
              a.b(a.this).q = StrategyBean.b;
            }
          }
        }
        finally
        {
          if (!x.a(localThrowable)) {
            localThrowable.printStackTrace();
          }
        }
        a locala = a.this;
        locala.a(a.b(locala), false);
      }
    }, paramLong);
  }
  
  /* Error */
  protected final void a(StrategyBean paramStrategyBean, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc -111
    //   2: iconst_1
    //   3: anewarray 4	java/lang/Object
    //   6: dup
    //   7: iconst_0
    //   8: ldc -109
    //   10: invokevirtual 152	java/lang/Class:getName	()Ljava/lang/String;
    //   13: aastore
    //   14: invokestatic 154	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   17: pop
    //   18: aload_1
    //   19: iload_2
    //   20: invokestatic 156	com/tencent/bugly/crashreport/biz/b:a	(Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;Z)V
    //   23: aload_0
    //   24: getfield 67	com/tencent/bugly/crashreport/common/strategy/a:c	Ljava/util/List;
    //   27: invokeinterface 160 1 0
    //   32: astore_3
    //   33: aload_3
    //   34: invokeinterface 166 1 0
    //   39: ifeq +62 -> 101
    //   42: aload_3
    //   43: invokeinterface 170 1 0
    //   48: checkcast 172	com/tencent/bugly/a
    //   51: astore 4
    //   53: ldc -111
    //   55: iconst_1
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload 4
    //   63: invokevirtual 176	java/lang/Object:getClass	()Ljava/lang/Class;
    //   66: invokevirtual 152	java/lang/Class:getName	()Ljava/lang/String;
    //   69: aastore
    //   70: invokestatic 154	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   73: pop
    //   74: aload 4
    //   76: aload_1
    //   77: invokevirtual 180	com/tencent/bugly/a:onServerStrategyChanged	(Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;)V
    //   80: goto -47 -> 33
    //   83: astore 4
    //   85: aload 4
    //   87: invokestatic 183	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   90: ifne -57 -> 33
    //   93: aload 4
    //   95: invokevirtual 188	java/lang/Throwable:printStackTrace	()V
    //   98: goto -65 -> 33
    //   101: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	a
    //   0	102	1	paramStrategyBean	StrategyBean
    //   0	102	2	paramBoolean	boolean
    //   32	11	3	localIterator	java.util.Iterator
    //   51	24	4	locala	com.tencent.bugly.a
    //   83	11	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   53	80	83	finally
  }
  
  public final void a(ap paramap)
  {
    if (paramap == null) {
      return;
    }
    if ((this.f != null) && (paramap.h == this.f.n)) {
      return;
    }
    StrategyBean localStrategyBean = new StrategyBean();
    localStrategyBean.e = paramap.a;
    localStrategyBean.g = paramap.c;
    localStrategyBean.f = paramap.b;
    if ((z.a(h)) || (!z.c(h)))
    {
      if (z.c(paramap.d))
      {
        x.c("[Strategy] Upload url changes to %s", new Object[] { paramap.d });
        localStrategyBean.p = paramap.d;
      }
      if (z.c(paramap.e))
      {
        x.c("[Strategy] Exception upload url changes to %s", new Object[] { paramap.e });
        localStrategyBean.q = paramap.e;
      }
    }
    if ((paramap.f != null) && (!z.a(paramap.f.a))) {
      localStrategyBean.r = paramap.f.a;
    }
    if (paramap.h != 0L) {
      localStrategyBean.n = paramap.h;
    }
    if ((paramap.g != null) && (paramap.g.size() > 0))
    {
      localStrategyBean.s = paramap.g;
      String str1 = (String)paramap.g.get("B11");
      if ((str1 != null) && (str1.equals("1"))) {
        localStrategyBean.h = true;
      } else {
        localStrategyBean.h = false;
      }
      str1 = (String)paramap.g.get("B3");
      if (str1 != null) {
        localStrategyBean.v = Long.valueOf(str1).longValue();
      }
      localStrategyBean.o = paramap.i;
      localStrategyBean.u = paramap.i;
      str1 = (String)paramap.g.get("B27");
      if ((str1 != null) && (str1.length() > 0)) {
        try
        {
          int i = Integer.parseInt(str1);
          if (i > 0) {
            localStrategyBean.t = i;
          }
        }
        catch (Exception localException)
        {
          if (!x.a(localException)) {
            localException.printStackTrace();
          }
        }
      }
      String str2 = (String)paramap.g.get("B25");
      if ((str2 != null) && (str2.equals("1"))) {
        localStrategyBean.j = true;
      } else {
        localStrategyBean.j = false;
      }
    }
    x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", new Object[] { Boolean.valueOf(localStrategyBean.e), Boolean.valueOf(localStrategyBean.g), Boolean.valueOf(localStrategyBean.f), Boolean.valueOf(localStrategyBean.h), Boolean.valueOf(localStrategyBean.i), Boolean.valueOf(localStrategyBean.l), Boolean.valueOf(localStrategyBean.m), Long.valueOf(localStrategyBean.o), Boolean.valueOf(localStrategyBean.j), Long.valueOf(localStrategyBean.n) });
    this.f = localStrategyBean;
    if (!z.c(paramap.d))
    {
      x.c("[Strategy] download url is null", new Object[0]);
      this.f.p = "";
    }
    if (!z.c(paramap.e))
    {
      x.c("[Strategy] download crashurl is null", new Object[0]);
      this.f.q = "";
    }
    p.a().b(2);
    paramap = new r();
    paramap.b = 2;
    paramap.a = localStrategyBean.c;
    paramap.e = localStrategyBean.d;
    paramap.g = z.a(localStrategyBean);
    p.a().a(paramap);
    a(localStrategyBean, true);
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/bugly/crashreport/common/strategy/a:f	Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	a
    //   12	7	1	bool	boolean
    //   6	2	2	localStrategyBean	StrategyBean
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final StrategyBean c()
  {
    StrategyBean localStrategyBean = this.f;
    if (localStrategyBean != null)
    {
      if (!z.c(localStrategyBean.p)) {
        this.f.p = StrategyBean.a;
      }
      if (!z.c(this.f.q)) {
        this.f.q = StrategyBean.b;
      }
      return this.f;
    }
    if ((!z.a(h)) && (z.c(h)))
    {
      this.e.p = h;
      this.e.q = h;
    }
    return this.e;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\common\strategy\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */