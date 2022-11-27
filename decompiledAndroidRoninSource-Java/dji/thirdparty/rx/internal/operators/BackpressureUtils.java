package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Subscriber;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public final class BackpressureUtils
{
  static final long COMPLETED_MASK = Long.MIN_VALUE;
  static final long REQUESTED_MASK = Long.MAX_VALUE;
  
  private BackpressureUtils()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static long addCap(long paramLong1, long paramLong2)
  {
    paramLong2 = paramLong1 + paramLong2;
    paramLong1 = paramLong2;
    if (paramLong2 < 0L) {
      paramLong1 = Long.MAX_VALUE;
    }
    return paramLong1;
  }
  
  public static long getAndAddRequest(AtomicLong paramAtomicLong, long paramLong)
  {
    long l;
    do
    {
      l = paramAtomicLong.get();
    } while (!paramAtomicLong.compareAndSet(l, addCap(l, paramLong)));
    return l;
  }
  
  public static <T> long getAndAddRequest(AtomicLongFieldUpdater<T> paramAtomicLongFieldUpdater, T paramT, long paramLong)
  {
    long l;
    do
    {
      l = paramAtomicLongFieldUpdater.get(paramT);
    } while (!paramAtomicLongFieldUpdater.compareAndSet(paramT, l, addCap(l, paramLong)));
    return l;
  }
  
  public static long multiplyCap(long paramLong1, long paramLong2)
  {
    long l2 = paramLong1 * paramLong2;
    long l1 = l2;
    if ((paramLong1 | paramLong2) >>> 31 != 0L)
    {
      l1 = l2;
      if (paramLong2 != 0L)
      {
        l1 = l2;
        if (l2 / paramLong2 != paramLong1) {
          l1 = Long.MAX_VALUE;
        }
      }
    }
    return l1;
  }
  
  public static <T> void postCompleteDone(AtomicLong paramAtomicLong, Queue<T> paramQueue, Subscriber<? super T> paramSubscriber)
  {
    long l;
    do
    {
      l = paramAtomicLong.get();
      if ((l & 0x8000000000000000) != 0L) {
        return;
      }
    } while (!paramAtomicLong.compareAndSet(l, 0x8000000000000000 | l));
    if (l != 0L) {
      postCompleteDrain(paramAtomicLong, paramQueue, paramSubscriber);
    }
  }
  
  static <T> void postCompleteDrain(AtomicLong paramAtomicLong, Queue<T> paramQueue, Subscriber<? super T> paramSubscriber)
  {
    long l1 = paramAtomicLong.get();
    long l2;
    do
    {
      l2 = Long.MIN_VALUE;
      long l3;
      do
      {
        boolean bool;
        for (;;)
        {
          bool = l2 < l1;
          if (!bool) {
            break;
          }
          if (paramSubscriber.isUnsubscribed()) {
            return;
          }
          Object localObject = paramQueue.poll();
          if (localObject == null)
          {
            paramSubscriber.onCompleted();
            return;
          }
          paramSubscriber.onNext(localObject);
          l2 += 1L;
        }
        if (!bool)
        {
          if (paramSubscriber.isUnsubscribed()) {
            return;
          }
          if (paramQueue.isEmpty())
          {
            paramSubscriber.onCompleted();
            return;
          }
        }
        l3 = paramAtomicLong.get();
        l1 = l3;
      } while (l3 != l2);
      l2 = paramAtomicLong.addAndGet(-(0x7FFFFFFFFFFFFFFF & l2));
      l1 = l2;
    } while (l2 != Long.MIN_VALUE);
  }
  
  public static <T> boolean postCompleteRequest(AtomicLong paramAtomicLong, long paramLong, Queue<T> paramQueue, Subscriber<? super T> paramSubscriber)
  {
    boolean bool = paramLong < 0L;
    if (!bool)
    {
      if (!bool) {
        return (paramAtomicLong.get() & 0x8000000000000000) == 0L;
      }
      for (;;)
      {
        long l1 = paramAtomicLong.get();
        long l2 = l1 & 0x8000000000000000;
        if (paramAtomicLong.compareAndSet(l1, addCap(0x7FFFFFFFFFFFFFFF & l1, paramLong) | l2))
        {
          if (l1 == Long.MIN_VALUE)
          {
            postCompleteDrain(paramAtomicLong, paramQueue, paramSubscriber);
            return false;
          }
          return l2 == 0L;
        }
      }
    }
    paramAtomicLong = new StringBuilder();
    paramAtomicLong.append("n >= 0 required but it was ");
    paramAtomicLong.append(paramLong);
    throw new IllegalArgumentException(paramAtomicLong.toString());
  }
  
  public static long produced(AtomicLong paramAtomicLong, long paramLong)
  {
    long l1;
    long l2;
    do
    {
      l1 = paramAtomicLong.get();
      if (l1 == Long.MAX_VALUE) {
        return Long.MAX_VALUE;
      }
      l2 = l1 - paramLong;
      if (l2 < 0L) {
        break;
      }
    } while (!paramAtomicLong.compareAndSet(l1, l2));
    return l2;
    paramAtomicLong = new StringBuilder();
    paramAtomicLong.append("More produced than requested: ");
    paramAtomicLong.append(l2);
    throw new IllegalStateException(paramAtomicLong.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\BackpressureUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */