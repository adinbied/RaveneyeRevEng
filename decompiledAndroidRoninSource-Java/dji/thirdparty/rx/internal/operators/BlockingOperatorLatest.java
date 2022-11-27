package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Notification;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Subscriber;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingOperatorLatest
{
  private BlockingOperatorLatest()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Iterable<T> latest(Observable<? extends T> paramObservable)
  {
    new Iterable()
    {
      public Iterator<T> iterator()
      {
        return null;
      }
    };
  }
  
  static final class LatestObserverIterator<T>
    extends Subscriber<Notification<? extends T>>
    implements Iterator<T>
  {
    Notification<? extends T> iNotif;
    final Semaphore notify = new Semaphore(0);
    final AtomicReference<Notification<? extends T>> value = new AtomicReference();
    
    public boolean hasNext()
    {
      return false;
    }
    
    public T next()
    {
      return null;
    }
    
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
    
    public void remove()
    {
      throw new UnsupportedOperationException("Read-only iterator.");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\BlockingOperatorLatest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */