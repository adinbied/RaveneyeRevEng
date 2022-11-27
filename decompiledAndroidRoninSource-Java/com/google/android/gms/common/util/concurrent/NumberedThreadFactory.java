package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberedThreadFactory
  implements ThreadFactory
{
  private final int priority;
  private final ThreadFactory zzhr = Executors.defaultThreadFactory();
  private final String zzhs;
  private final AtomicInteger zzht = new AtomicInteger();
  
  public NumberedThreadFactory(String paramString)
  {
    this(paramString, 0);
  }
  
  private NumberedThreadFactory(String paramString, int paramInt)
  {
    this.zzhs = ((String)Preconditions.checkNotNull(paramString, "Name must not be null"));
    this.priority = 0;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = this.zzhr.newThread(new zza(paramRunnable, 0));
    String str = this.zzhs;
    int i = this.zzht.getAndIncrement();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 13);
    localStringBuilder.append(str);
    localStringBuilder.append("[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    paramRunnable.setName(localStringBuilder.toString());
    return paramRunnable;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\concurrent\NumberedThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */