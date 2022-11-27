package com.facebook.imagepipeline.core;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityThreadFactory
  implements ThreadFactory
{
  private final boolean mAddThreadNumber;
  private final String mPrefix;
  private final AtomicInteger mThreadNumber = new AtomicInteger(1);
  private final int mThreadPriority;
  
  public PriorityThreadFactory(int paramInt)
  {
    this(paramInt, "PriorityThreadFactory", true);
  }
  
  public PriorityThreadFactory(int paramInt, String paramString, boolean paramBoolean)
  {
    this.mThreadPriority = paramInt;
    this.mPrefix = paramString;
    this.mAddThreadNumber = paramBoolean;
  }
  
  public Thread newThread(final Runnable paramRunnable)
  {
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        try
        {
          Process.setThreadPriority(PriorityThreadFactory.this.mThreadPriority);
          paramRunnable.run();
          return;
        }
        finally
        {
          for (;;) {}
        }
      }
    };
    if (this.mAddThreadNumber)
    {
      paramRunnable = new StringBuilder();
      paramRunnable.append(this.mPrefix);
      paramRunnable.append("-");
      paramRunnable.append(this.mThreadNumber.getAndIncrement());
      paramRunnable = paramRunnable.toString();
    }
    else
    {
      paramRunnable = this.mPrefix;
    }
    return new Thread(local1, paramRunnable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\core\PriorityThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */