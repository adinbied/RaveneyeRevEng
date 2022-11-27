package com.huawei.hms.support.api.push.b.a;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c
{
  private static final Object a = new Object();
  private static ThreadPoolExecutor b = new ThreadPoolExecutor(1, 50, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  
  public static ThreadPoolExecutor a()
  {
    synchronized (a)
    {
      ThreadPoolExecutor localThreadPoolExecutor = b;
      return localThreadPoolExecutor;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\b\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */