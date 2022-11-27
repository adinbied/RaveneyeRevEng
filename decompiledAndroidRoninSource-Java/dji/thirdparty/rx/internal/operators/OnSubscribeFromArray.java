package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import java.util.concurrent.atomic.AtomicLong;

public final class OnSubscribeFromArray<T>
  implements Observable.OnSubscribe<T>
{
  final T[] array;
  
  public OnSubscribeFromArray(T[] paramArrayOfT)
  {
    this.array = paramArrayOfT;
  }
  
  /* Error */
  public void call(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class FromArrayProducer<T>
    extends AtomicLong
    implements Producer
  {
    private static final long serialVersionUID = 3534218984725836979L;
    final T[] array;
    final Subscriber<? super T> child;
    int index;
    
    public FromArrayProducer(Subscriber<? super T> paramSubscriber, T[] paramArrayOfT)
    {
      this.child = paramSubscriber;
      this.array = paramArrayOfT;
    }
    
    /* Error */
    void fastPath()
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
    void slowPath(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeFromArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */