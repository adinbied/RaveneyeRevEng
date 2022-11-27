package com.huawei.hianalytics.i;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class b
{
  private static b b = new b();
  private static b c = new b();
  private static b d = new b();
  private static b e = new b();
  private ThreadPoolExecutor a;
  
  private b()
  {
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue(5000);
    this.a = new ThreadPoolExecutor(0, 1, 60000L, TimeUnit.MILLISECONDS, localLinkedBlockingQueue);
  }
  
  public static b a()
  {
    return b;
  }
  
  public static b b()
  {
    return c;
  }
  
  public static b c()
  {
    return d;
  }
  
  public static b d()
  {
    return e;
  }
  
  /* Error */
  public void a(a arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private static class a
    implements Runnable
  {
    private Runnable a;
    
    public a(Runnable paramRunnable)
    {
      this.a = paramRunnable;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */