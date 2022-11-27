package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingOperatorToFuture
{
  private BlockingOperatorToFuture()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Future<T> toFuture(Observable<? extends T> paramObservable)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final AtomicReference localAtomicReference1 = new AtomicReference();
    final AtomicReference localAtomicReference2 = new AtomicReference();
    new Future()
    {
      public void onCompleted()
      {
        this.val$finished.countDown();
      }
      
      /* Error */
      public void onError(Throwable arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void onNext(T paramAnonymousT)
      {
        localAtomicReference1.set(paramAnonymousT);
      }
    }
    {
      private volatile boolean cancelled = false;
      
      private T getValue()
        throws ExecutionException
      {
        return null;
      }
      
      public boolean cancel(boolean paramAnonymousBoolean)
      {
        return false;
      }
      
      public T get()
        throws InterruptedException, ExecutionException
      {
        return null;
      }
      
      public T get(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
        throws InterruptedException, ExecutionException, TimeoutException
      {
        return null;
      }
      
      public boolean isCancelled()
      {
        return this.cancelled;
      }
      
      public boolean isDone()
      {
        return false;
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\BlockingOperatorToFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */