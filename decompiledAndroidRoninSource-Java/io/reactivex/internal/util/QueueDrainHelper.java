package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class QueueDrainHelper
{
  static final long COMPLETED_MASK = Long.MIN_VALUE;
  static final long REQUESTED_MASK = Long.MAX_VALUE;
  
  private QueueDrainHelper()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T, U> boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Observer<?> paramObserver, boolean paramBoolean3, SimpleQueue<?> paramSimpleQueue, Disposable paramDisposable, ObservableQueueDrain<T, U> paramObservableQueueDrain)
  {
    if (paramObservableQueueDrain.cancelled())
    {
      paramSimpleQueue.clear();
      paramDisposable.dispose();
      return true;
    }
    if (paramBoolean1) {
      if (paramBoolean3)
      {
        if (paramBoolean2)
        {
          if (paramDisposable != null) {
            paramDisposable.dispose();
          }
          paramSimpleQueue = paramObservableQueueDrain.error();
          if (paramSimpleQueue != null)
          {
            paramObserver.onError(paramSimpleQueue);
            return true;
          }
          paramObserver.onComplete();
          return true;
        }
      }
      else
      {
        paramObservableQueueDrain = paramObservableQueueDrain.error();
        if (paramObservableQueueDrain != null)
        {
          paramSimpleQueue.clear();
          if (paramDisposable != null) {
            paramDisposable.dispose();
          }
          paramObserver.onError(paramObservableQueueDrain);
          return true;
        }
        if (paramBoolean2)
        {
          if (paramDisposable != null) {
            paramDisposable.dispose();
          }
          paramObserver.onComplete();
          return true;
        }
      }
    }
    return false;
  }
  
  public static <T, U> boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<?> paramSubscriber, boolean paramBoolean3, SimpleQueue<?> paramSimpleQueue, QueueDrain<T, U> paramQueueDrain)
  {
    if (paramQueueDrain.cancelled())
    {
      paramSimpleQueue.clear();
      return true;
    }
    if (paramBoolean1) {
      if (paramBoolean3)
      {
        if (paramBoolean2)
        {
          paramSimpleQueue = paramQueueDrain.error();
          if (paramSimpleQueue != null)
          {
            paramSubscriber.onError(paramSimpleQueue);
            return true;
          }
          paramSubscriber.onComplete();
          return true;
        }
      }
      else
      {
        paramQueueDrain = paramQueueDrain.error();
        if (paramQueueDrain != null)
        {
          paramSimpleQueue.clear();
          paramSubscriber.onError(paramQueueDrain);
          return true;
        }
        if (paramBoolean2)
        {
          paramSubscriber.onComplete();
          return true;
        }
      }
    }
    return false;
  }
  
  public static <T> SimpleQueue<T> createQueue(int paramInt)
  {
    if (paramInt < 0) {
      return new SpscLinkedArrayQueue(-paramInt);
    }
    return new SpscArrayQueue(paramInt);
  }
  
  public static <T, U> void drainLoop(SimplePlainQueue<T> paramSimplePlainQueue, Observer<? super U> paramObserver, boolean paramBoolean, Disposable paramDisposable, ObservableQueueDrain<T, U> paramObservableQueueDrain)
  {
    int i = 1;
    if (checkTerminated(paramObservableQueueDrain.done(), paramSimplePlainQueue.isEmpty(), paramObserver, paramBoolean, paramSimplePlainQueue, paramDisposable, paramObservableQueueDrain)) {
      return;
    }
    for (;;)
    {
      boolean bool2 = paramObservableQueueDrain.done();
      Object localObject = paramSimplePlainQueue.poll();
      boolean bool1;
      if (localObject == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (checkTerminated(bool2, bool1, paramObserver, paramBoolean, paramSimplePlainQueue, paramDisposable, paramObservableQueueDrain)) {
        return;
      }
      if (bool1)
      {
        int j = paramObservableQueueDrain.leave(-i);
        i = j;
        if (j != 0) {
          break;
        }
        return;
      }
      paramObservableQueueDrain.accept(paramObserver, localObject);
    }
  }
  
  public static <T, U> void drainMaxLoop(SimplePlainQueue<T> paramSimplePlainQueue, Subscriber<? super U> paramSubscriber, boolean paramBoolean, Disposable paramDisposable, QueueDrain<T, U> paramQueueDrain)
  {
    int i = 1;
    for (;;)
    {
      boolean bool2 = paramQueueDrain.done();
      Object localObject = paramSimplePlainQueue.poll();
      boolean bool1;
      if (localObject == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (checkTerminated(bool2, bool1, paramSubscriber, paramBoolean, paramSimplePlainQueue, paramQueueDrain))
      {
        if (paramDisposable != null) {
          paramDisposable.dispose();
        }
        return;
      }
      if (bool1)
      {
        int j = paramQueueDrain.leave(-i);
        i = j;
        if (j != 0) {}
      }
      else
      {
        long l = paramQueueDrain.requested();
        if (l == 0L) {
          break;
        }
        if ((paramQueueDrain.accept(paramSubscriber, localObject)) && (l != Long.MAX_VALUE)) {
          paramQueueDrain.produced(1L);
        }
      }
    }
    paramSimplePlainQueue.clear();
    if (paramDisposable != null) {
      paramDisposable.dispose();
    }
    paramSubscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
  }
  
  static boolean isCancelled(BooleanSupplier paramBooleanSupplier)
  {
    try
    {
      boolean bool = paramBooleanSupplier.getAsBoolean();
      return bool;
    }
    finally
    {
      Exceptions.throwIfFatal(paramBooleanSupplier);
    }
    return true;
  }
  
  public static <T> void postComplete(Subscriber<? super T> paramSubscriber, Queue<T> paramQueue, AtomicLong paramAtomicLong, BooleanSupplier paramBooleanSupplier)
  {
    if (paramQueue.isEmpty())
    {
      paramSubscriber.onComplete();
      return;
    }
    if (postCompleteDrain(paramAtomicLong.get(), paramSubscriber, paramQueue, paramAtomicLong, paramBooleanSupplier)) {
      return;
    }
    long l1;
    long l2;
    do
    {
      l1 = paramAtomicLong.get();
      if ((l1 & 0x8000000000000000) != 0L) {
        return;
      }
      l2 = l1 | 0x8000000000000000;
    } while (!paramAtomicLong.compareAndSet(l1, l2));
    if (l1 != 0L) {
      postCompleteDrain(l2, paramSubscriber, paramQueue, paramAtomicLong, paramBooleanSupplier);
    }
  }
  
  static <T> boolean postCompleteDrain(long paramLong, Subscriber<? super T> paramSubscriber, Queue<T> paramQueue, AtomicLong paramAtomicLong, BooleanSupplier paramBooleanSupplier)
  {
    long l1 = paramLong & 0x8000000000000000;
    for (;;)
    {
      if (l1 != paramLong)
      {
        if (isCancelled(paramBooleanSupplier)) {
          return true;
        }
        Object localObject = paramQueue.poll();
        if (localObject == null)
        {
          paramSubscriber.onComplete();
          return true;
        }
        paramSubscriber.onNext(localObject);
        l1 += 1L;
      }
      else
      {
        if (isCancelled(paramBooleanSupplier)) {
          return true;
        }
        if (paramQueue.isEmpty())
        {
          paramSubscriber.onComplete();
          return true;
        }
        long l2 = paramAtomicLong.get();
        paramLong = l2;
        if (l2 == l1)
        {
          l1 = paramAtomicLong.addAndGet(-(l1 & 0x7FFFFFFFFFFFFFFF));
          if ((0x7FFFFFFFFFFFFFFF & l1) == 0L) {
            return false;
          }
          paramLong = l1;
          l1 &= 0x8000000000000000;
        }
      }
    }
  }
  
  public static <T> boolean postCompleteRequest(long paramLong, Subscriber<? super T> paramSubscriber, Queue<T> paramQueue, AtomicLong paramAtomicLong, BooleanSupplier paramBooleanSupplier)
  {
    long l;
    do
    {
      l = paramAtomicLong.get();
    } while (!paramAtomicLong.compareAndSet(l, BackpressureHelper.addCap(0x7FFFFFFFFFFFFFFF & l, paramLong) | l & 0x8000000000000000));
    if (l == Long.MIN_VALUE)
    {
      postCompleteDrain(paramLong | 0x8000000000000000, paramSubscriber, paramQueue, paramAtomicLong, paramBooleanSupplier);
      return true;
    }
    return false;
  }
  
  public static void request(Subscription paramSubscription, int paramInt)
  {
    long l;
    if (paramInt < 0) {
      l = Long.MAX_VALUE;
    } else {
      l = paramInt;
    }
    paramSubscription.request(l);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\QueueDrainHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */