package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

public final class OnSubscribeFromIterable<T>
  implements Observable.OnSubscribe<T>
{
  final Iterable<? extends T> is;
  
  public OnSubscribeFromIterable(Iterable<? extends T> paramIterable)
  {
    if (paramIterable != null)
    {
      this.is = paramIterable;
      return;
    }
    throw new NullPointerException("iterable must not be null");
  }
  
  /* Error */
  public void call(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static final class IterableProducer<T>
    extends AtomicLong
    implements Producer
  {
    private static final long serialVersionUID = -8730475647105475802L;
    private final Iterator<? extends T> it;
    private final Subscriber<? super T> o;
    
    IterableProducer(Subscriber<? super T> paramSubscriber, Iterator<? extends T> paramIterator)
    {
      this.o = paramSubscriber;
      this.it = paramIterator;
    }
    
    /* Error */
    void fastpath()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void slowpath(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeFromIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */