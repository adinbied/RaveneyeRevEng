package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Notification;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.internal.util.RxRingBuffer;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class BlockingOperatorToIterator
{
  private BlockingOperatorToIterator()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Iterator<T> toIterator(Observable<? extends T> paramObservable)
  {
    SubscriberIterator localSubscriberIterator = new SubscriberIterator();
    paramObservable.materialize().subscribe(localSubscriberIterator);
    return localSubscriberIterator;
  }
  
  public static final class SubscriberIterator<T>
    extends Subscriber<Notification<? extends T>>
    implements Iterator<T>
  {
    static final int LIMIT = RxRingBuffer.SIZE * 3 / 4;
    private Notification<? extends T> buf;
    private final BlockingQueue<Notification<? extends T>> notifications = new LinkedBlockingQueue();
    private int received;
    
    private Notification<? extends T> take()
    {
      return null;
    }
    
    public boolean hasNext()
    {
      return false;
    }
    
    public T next()
    {
      return null;
    }
    
    public void onCompleted() {}
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onNext(Notification<? extends T> paramNotification)
    {
      this.notifications.offer(paramNotification);
    }
    
    public void onStart()
    {
      request(RxRingBuffer.SIZE);
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Read-only iterator");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\BlockingOperatorToIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */