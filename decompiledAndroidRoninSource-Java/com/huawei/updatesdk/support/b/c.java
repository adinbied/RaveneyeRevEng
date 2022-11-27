package com.huawei.updatesdk.support.b;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c
{
  public static final ThreadPoolExecutor a = new ThreadPoolExecutor(2, 2, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  public static final ThreadPoolExecutor b = new ThreadPoolExecutor(2, 3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  public static final ThreadPoolExecutor c = new ThreadPoolExecutor(0, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  public static final ThreadPoolExecutor d = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\support\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */