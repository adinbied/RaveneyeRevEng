package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import java.util.Map;

public final class d
{
  private static d a;
  private com.tencent.bugly.crashreport.common.strategy.a b;
  private com.tencent.bugly.crashreport.common.info.a c;
  private b d;
  private Context e;
  
  private d(Context paramContext)
  {
    c localc = c.a();
    if (localc == null) {
      return;
    }
    this.b = com.tencent.bugly.crashreport.common.strategy.a.a();
    this.c = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    this.d = localc.p;
    this.e = paramContext;
    w.a().a(new Runnable()
    {
      public final void run()
      {
        d.a(d.this);
      }
    });
  }
  
  public static d a(Context paramContext)
  {
    if (a == null) {
      a = new d(paramContext);
    }
    return a;
  }
  
  public static void a(Thread paramThread, final int paramInt, final String paramString1, final String paramString2, final String paramString3, final Map<String, String> paramMap)
  {
    w.a().a(new Runnable()
    {
      public final void run()
      {
        try
        {
          if (d.a() == null)
          {
            x.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
            return;
          }
          d.a(d.a(), this.a, paramInt, paramString1, paramString2, paramString3, paramMap);
          return;
        }
        finally
        {
          if (!x.b(localThrowable)) {
            localThrowable.printStackTrace();
          }
          x.e("[ExtraCrashManager] Crash error %s %s %s", new Object[] { paramString1, paramString2, paramString3 });
        }
      }
    });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\crash\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */