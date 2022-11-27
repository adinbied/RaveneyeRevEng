package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.x;

public class CrashModule
  extends a
{
  public static final int MODULE_ID = 1004;
  private static int c;
  private static CrashModule e = new CrashModule();
  private long a;
  private BuglyStrategy.a b;
  private boolean d = false;
  
  private void a(Context paramContext, BuglyStrategy paramBuglyStrategy)
  {
    if (paramBuglyStrategy == null) {
      return;
    }
    try
    {
      String str = paramBuglyStrategy.getLibBuglySOFilePath();
      if (!TextUtils.isEmpty(str))
      {
        com.tencent.bugly.crashreport.common.info.a.a(paramContext).m = str;
        x.a("setted libBugly.so file path :%s", new Object[] { str });
      }
      if (paramBuglyStrategy.getCrashHandleCallback() != null)
      {
        this.b = paramBuglyStrategy.getCrashHandleCallback();
        x.a("setted CrashHanldeCallback", new Object[0]);
      }
      if (paramBuglyStrategy.getAppReportDelay() > 0L)
      {
        long l = paramBuglyStrategy.getAppReportDelay();
        this.a = l;
        x.a("setted delay: %d", new Object[] { Long.valueOf(l) });
      }
      return;
    }
    finally {}
  }
  
  public static CrashModule getInstance()
  {
    e.id = 1004;
    return e;
  }
  
  public String[] getTables()
  {
    return new String[] { "t_cr" };
  }
  
  public boolean hasInitialized()
  {
    try
    {
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void init(Context paramContext, boolean paramBoolean, BuglyStrategy paramBuglyStrategy)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        if (!this.d)
        {
          x.a("Initializing crash module.", new Object[0]);
          Object localObject = n.a();
          int i = c + 1;
          c = i;
          ((n)localObject).a(1004, i);
          this.d = true;
          CrashReport.setContext(paramContext);
          a(paramContext, paramBuglyStrategy);
          localObject = c.a(1004, paramContext, paramBoolean, this.b, null, null);
          ((c)localObject).f();
          if (paramBuglyStrategy != null)
          {
            ((c)localObject).a(paramBuglyStrategy.getCallBackType());
            ((c)localObject).a(paramBuglyStrategy.getCloseErrorCallback());
            c.l = paramBuglyStrategy.isUploadSpotCrash();
          }
          if ((paramBuglyStrategy != null) && (paramBuglyStrategy.isEnableCatchAnrTrace())) {
            ((c)localObject).k();
          }
          ((c)localObject).o();
          if ((paramBuglyStrategy != null) && (!paramBuglyStrategy.isEnableNativeCrashMonitor()))
          {
            x.a("[crash] Closed native crash monitor!", new Object[0]);
            ((c)localObject).g();
          }
          else
          {
            ((c)localObject).h();
          }
          if ((paramBuglyStrategy != null) && (!paramBuglyStrategy.isEnableANRCrashMonitor()))
          {
            x.a("[crash] Closed ANR monitor!", new Object[0]);
            ((c)localObject).j();
          }
          else
          {
            ((c)localObject).i();
          }
          if (paramBuglyStrategy != null) {
            c.d = paramBuglyStrategy.isMerged();
          }
          if (paramBuglyStrategy == null) {
            break label305;
          }
          l = paramBuglyStrategy.getAppReportDelay();
          ((c)localObject).a(l);
          ((c)localObject).n();
          d.a(paramContext);
          paramBuglyStrategy = BuglyBroadcastReceiver.getInstance();
          paramBuglyStrategy.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
          paramBuglyStrategy.register(paramContext);
          paramContext = n.a();
          i = c - 1;
          c = i;
          paramContext.a(1004, i);
          return;
        }
      }
      finally {}
      return;
      label305:
      long l = 0L;
    }
  }
  
  public void onServerStrategyChanged(StrategyBean paramStrategyBean)
  {
    if (paramStrategyBean == null) {
      return;
    }
    c localc = c.a();
    if (localc != null) {
      localc.a(paramStrategyBean);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\CrashModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */