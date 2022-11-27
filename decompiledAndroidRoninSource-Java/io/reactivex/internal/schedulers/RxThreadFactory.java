package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory
  extends AtomicLong
  implements ThreadFactory
{
  private static final long serialVersionUID = -7789753024099756196L;
  final boolean nonBlocking;
  final String prefix;
  final int priority;
  
  public RxThreadFactory(String paramString)
  {
    this(paramString, 5, false);
  }
  
  public RxThreadFactory(String paramString, int paramInt)
  {
    this(paramString, paramInt, false);
  }
  
  public RxThreadFactory(String paramString, int paramInt, boolean paramBoolean)
  {
    this.prefix = paramString;
    this.priority = paramInt;
    this.nonBlocking = paramBoolean;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
  
  static final class RxCustomThread
    extends Thread
    implements NonBlockingThread
  {
    RxCustomThread(Runnable paramRunnable, String paramString)
    {
      super(paramString);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\RxThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */