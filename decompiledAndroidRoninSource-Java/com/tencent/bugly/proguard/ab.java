package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.util.ArrayList;
import java.util.List;

public final class ab
  extends Thread
{
  private boolean a = false;
  private boolean b = false;
  private List<aa> c = new ArrayList();
  private List<ac> d = new ArrayList();
  private ArrayList<aa> e = new ArrayList();
  
  private void a(Handler paramHandler, long paramLong)
  {
    if (paramHandler == null)
    {
      x.e("addThread handler should not be null", new Object[0]);
      return;
    }
    String str = paramHandler.getLooper().getThread().getName();
    int i = 0;
    try
    {
      while (i < this.c.size())
      {
        if (((aa)this.c.get(i)).d().equals(paramHandler.getLooper().getThread().getName()))
        {
          x.e("addThread fail ,this thread has been added in monitor queue", new Object[0]);
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      x.b(localException);
      this.c.add(new aa(paramHandler, str, 5000L));
    }
  }
  
  private int e()
  {
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      try
      {
        if (j < this.c.size())
        {
          i = Math.max(k, ((aa)this.c.get(j)).c());
          j += 1;
        }
      }
      catch (Exception localException)
      {
        x.b(localException);
      }
    }
    return k;
  }
  
  public final void a()
  {
    a(new Handler(Looper.getMainLooper()), 5000L);
  }
  
  public final void a(ac paramac)
  {
    if (this.d.contains(paramac))
    {
      x.c("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
      return;
    }
    this.d.add(paramac);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b = true;
  }
  
  public final void b()
  {
    int i = 0;
    try
    {
      while (i < this.c.size())
      {
        if (((aa)this.c.get(i)).d().equals(Looper.getMainLooper().getThread().getName()))
        {
          x.c("remove handler::%s", new Object[] { this.c.get(i) });
          this.c.remove(i);
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      x.b(localException);
    }
  }
  
  public final void b(ac paramac)
  {
    this.d.remove(paramac);
  }
  
  public final boolean c()
  {
    this.a = true;
    if (!isAlive()) {
      return false;
    }
    try
    {
      interrupt();
      return true;
    }
    catch (Exception localException)
    {
      x.b(localException);
    }
    return true;
  }
  
  public final boolean d()
  {
    if (isAlive()) {
      return false;
    }
    try
    {
      start();
      return true;
    }
    catch (Exception localException)
    {
      x.b(localException);
    }
    return false;
  }
  
  public final void run()
  {
    int i;
    if (!this.a) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.c.size())
        {
          ((aa)this.c.get(i)).a();
          i += 1;
          continue;
        }
        long l2 = SystemClock.uptimeMillis();
        long l1 = 2000L;
        if ((l1 > 0L) && (!isInterrupted()))
        {
          sleep(l1);
          l1 = 2000L - (SystemClock.uptimeMillis() - l2);
          continue;
        }
        i = e();
        if ((i == 0) || (i == 1)) {
          break;
        }
        this.e.clear();
        i = 0;
        if (i < this.c.size())
        {
          localObject = (aa)this.c.get(i);
          if (!((aa)localObject).b()) {
            break label374;
          }
          this.e.add(localObject);
          ((aa)localObject).a(Long.MAX_VALUE);
          break label374;
        }
        Object localObject = NativeCrashHandler.getInstance();
        if ((localObject != null) && (((NativeCrashHandler)localObject).isEnableCatchAnrTrace()))
        {
          ((NativeCrashHandler)localObject).dumpAnrNativeStack();
          x.c("jni mannual dump anr trace", new Object[0]);
          break label381;
        }
        x.c("do not enable jni mannual dump anr trace", new Object[0]);
        break label381;
        if (this.b) {
          break label386;
        }
        x.c("do not enable anr continue check", new Object[0]);
        sleep(2000L);
        int j = i + 1;
        i = j;
        if (j != 15) {
          continue;
        }
        this.e.clear();
        break label386;
        if (i >= this.e.size()) {
          break;
        }
        localObject = (aa)this.e.get(i);
        j = 0;
        if (j < this.d.size())
        {
          x.e("main thread blocked,now begin to upload anr stack", new Object[0]);
          ((ac)this.d.get(j)).a((aa)localObject);
          this.b = false;
          j += 1;
          continue;
        }
        i += 1;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        x.b(localOutOfMemoryError);
      }
      catch (Exception localException)
      {
        x.b(localException);
      }
      break;
      return;
      label374:
      i += 1;
      continue;
      label381:
      i = 0;
      continue;
      label386:
      i = 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */