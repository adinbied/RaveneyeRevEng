package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

public class BuglyBroadcastReceiver
  extends BroadcastReceiver
{
  private static BuglyBroadcastReceiver d;
  private IntentFilter a = new IntentFilter();
  private Context b;
  private String c;
  private boolean e = true;
  
  private boolean a(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null)) {
      try
      {
        if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          if (this.e)
          {
            this.e = false;
            return true;
          }
          paramIntent = com.tencent.bugly.crashreport.common.info.b.b(this.b);
          Object localObject1 = new StringBuilder("is Connect BC ");
          ((StringBuilder)localObject1).append(paramIntent);
          x.c(((StringBuilder)localObject1).toString(), new Object[0]);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.c);
          localObject1 = ((StringBuilder)localObject1).toString();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramIntent);
          x.a("network %s changed to %s", new Object[] { localObject1, ((StringBuilder)localObject2).toString() });
          if (paramIntent == null)
          {
            this.c = null;
            return true;
          }
          localObject1 = this.c;
          this.c = paramIntent;
          long l = System.currentTimeMillis();
          localObject2 = com.tencent.bugly.crashreport.common.strategy.a.a();
          u localu = u.a();
          paramContext = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
          if ((localObject2 != null) && (localu != null) && (paramContext != null))
          {
            if ((!paramIntent.equals(localObject1)) && (l - localu.a(c.a) > 30000L))
            {
              x.a("try to upload crash on network changed.", new Object[0]);
              paramContext = c.a();
              if (paramContext != null) {
                paramContext.a(0L);
              }
              x.a("try to upload userinfo on network changed.", new Object[0]);
              com.tencent.bugly.crashreport.biz.b.a.b();
            }
            return true;
          }
          x.d("not inited BC not work", new Object[0]);
          return true;
        }
      }
      finally {}
    }
    return false;
  }
  
  public static BuglyBroadcastReceiver getInstance()
  {
    try
    {
      if (d == null) {
        d = new BuglyBroadcastReceiver();
      }
      BuglyBroadcastReceiver localBuglyBroadcastReceiver = d;
      return localBuglyBroadcastReceiver;
    }
    finally {}
  }
  
  public void addFilter(String paramString)
  {
    try
    {
      if (!this.a.hasAction(paramString)) {
        this.a.addAction(paramString);
      }
      x.c("add action %s", new Object[] { paramString });
      return;
    }
    finally {}
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      a(paramContext, paramIntent);
      return;
    }
    finally
    {
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void register(Context paramContext)
  {
    try
    {
      this.b = paramContext;
      z.a(new Runnable()
      {
        public final void run()
        {
          try
          {
            x.a(BuglyBroadcastReceiver.a().getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
            synchronized (jdField_this)
            {
              BuglyBroadcastReceiver.b(BuglyBroadcastReceiver.this).registerReceiver(BuglyBroadcastReceiver.a(), BuglyBroadcastReceiver.a(BuglyBroadcastReceiver.this), "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
              return;
            }
            return;
          }
          finally
          {
            ((Throwable)localObject1).printStackTrace();
          }
        }
      });
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void unregister(Context paramContext)
  {
    try
    {
      x.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
      paramContext.unregisterReceiver(this);
      this.b = paramContext;
      return;
    }
    finally
    {
      paramContext = finally;
      try
      {
        if (!x.a(paramContext)) {
          paramContext.printStackTrace();
        }
        return;
      }
      finally
      {
        paramContext = finally;
        throw paramContext;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\crash\BuglyBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */