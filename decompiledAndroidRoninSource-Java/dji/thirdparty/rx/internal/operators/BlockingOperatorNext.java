package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Notification;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Subscriber;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class BlockingOperatorNext
{
  private BlockingOperatorNext()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Iterable<T> next(Observable<? extends T> paramObservable)
  {
    new Iterable()
    {
      public Iterator<T> iterator()
      {
        return null;
      }
    };
  }
  
  static final class NextIterator<T>
    implements Iterator<T>
  {
    private Throwable error = null;
    private boolean hasNext = true;
    private boolean isNextConsumed = true;
    private final Observable<? extends T> items;
    private T next;
    private final BlockingOperatorNext.NextObserver<T> observer;
    private boolean started = false;
    
    NextIterator(Observable<? extends T> paramObservable, BlockingOperatorNext.NextObserver<T> paramNextObserver)
    {
      this.items = paramObservable;
      this.observer = paramNextObserver;
    }
    
    private boolean moveToNext()
    {
      return false;
    }
    
    public boolean hasNext()
    {
      return false;
    }
    
    public T next()
    {
      return null;
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Read only iterator");
    }
  }
  
  private static class NextObserver<T>
    extends Subscriber<Notification<? extends T>>
  {
    private final BlockingQueue<Notification<? extends T>> buf = new ArrayBlockingQueue(1);
    final AtomicInteger waiting = new AtomicInteger();
    
    public void onCompleted() {}
    
    public void onError(Throwable paramThrowable) {}
    
    /* Error */
    public void onNext(Notification<? extends T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void setWaiting(int paramInt)
    {
      this.waiting.set(paramInt);
    }
    
    public Notification<? extends T> takeNext()
      throws InterruptedException
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\BlockingOperatorNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */