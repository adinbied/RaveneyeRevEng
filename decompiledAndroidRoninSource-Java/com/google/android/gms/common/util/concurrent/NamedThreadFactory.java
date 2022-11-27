package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory
  implements ThreadFactory
{
  private final String name;
  private final int priority;
  private final ThreadFactory zzhr = Executors.defaultThreadFactory();
  
  public NamedThreadFactory(String paramString)
  {
    this(paramString, 0);
  }
  
  private NamedThreadFactory(String paramString, int paramInt)
  {
    this.name = ((String)Preconditions.checkNotNull(paramString, "Name must not be null"));
    this.priority = 0;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = this.zzhr.newThread(new zza(paramRunnable, 0));
    paramRunnable.setName(this.name);
    return paramRunnable;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\concurrent\NamedThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */