package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class HalfSerializer
{
  private HalfSerializer()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static void onComplete(Observer<?> paramObserver, AtomicInteger paramAtomicInteger, AtomicThrowable paramAtomicThrowable)
  {
    if (paramAtomicInteger.getAndIncrement() == 0)
    {
      paramAtomicInteger = paramAtomicThrowable.terminate();
      if (paramAtomicInteger != null)
      {
        paramObserver.onError(paramAtomicInteger);
        return;
      }
      paramObserver.onComplete();
    }
  }
  
  public static void onComplete(Subscriber<?> paramSubscriber, AtomicInteger paramAtomicInteger, AtomicThrowable paramAtomicThrowable)
  {
    if (paramAtomicInteger.getAndIncrement() == 0)
    {
      paramAtomicInteger = paramAtomicThrowable.terminate();
      if (paramAtomicInteger != null)
      {
        paramSubscriber.onError(paramAtomicInteger);
        return;
      }
      paramSubscriber.onComplete();
    }
  }
  
  public static void onError(Observer<?> paramObserver, Throwable paramThrowable, AtomicInteger paramAtomicInteger, AtomicThrowable paramAtomicThrowable)
  {
    if (paramAtomicThrowable.addThrowable(paramThrowable))
    {
      if (paramAtomicInteger.getAndIncrement() == 0) {
        paramObserver.onError(paramAtomicThrowable.terminate());
      }
    }
    else {
      RxJavaPlugins.onError(paramThrowable);
    }
  }
  
  public static void onError(Subscriber<?> paramSubscriber, Throwable paramThrowable, AtomicInteger paramAtomicInteger, AtomicThrowable paramAtomicThrowable)
  {
    if (paramAtomicThrowable.addThrowable(paramThrowable))
    {
      if (paramAtomicInteger.getAndIncrement() == 0) {
        paramSubscriber.onError(paramAtomicThrowable.terminate());
      }
    }
    else {
      RxJavaPlugins.onError(paramThrowable);
    }
  }
  
  public static <T> void onNext(Observer<? super T> paramObserver, T paramT, AtomicInteger paramAtomicInteger, AtomicThrowable paramAtomicThrowable)
  {
    if ((paramAtomicInteger.get() == 0) && (paramAtomicInteger.compareAndSet(0, 1)))
    {
      paramObserver.onNext(paramT);
      if (paramAtomicInteger.decrementAndGet() != 0)
      {
        paramT = paramAtomicThrowable.terminate();
        if (paramT != null)
        {
          paramObserver.onError(paramT);
          return;
        }
        paramObserver.onComplete();
      }
    }
  }
  
  public static <T> void onNext(Subscriber<? super T> paramSubscriber, T paramT, AtomicInteger paramAtomicInteger, AtomicThrowable paramAtomicThrowable)
  {
    if ((paramAtomicInteger.get() == 0) && (paramAtomicInteger.compareAndSet(0, 1)))
    {
      paramSubscriber.onNext(paramT);
      if (paramAtomicInteger.decrementAndGet() != 0)
      {
        paramT = paramAtomicThrowable.terminate();
        if (paramT != null)
        {
          paramSubscriber.onError(paramT);
          return;
        }
        paramSubscriber.onComplete();
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\HalfSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */