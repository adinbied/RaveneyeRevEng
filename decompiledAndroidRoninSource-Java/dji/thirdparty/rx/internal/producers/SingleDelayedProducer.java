package dji.thirdparty.rx.internal.producers;

import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.exceptions.Exceptions;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingleDelayedProducer<T>
  extends AtomicInteger
  implements Producer
{
  static final int HAS_REQUEST_HAS_VALUE = 3;
  static final int HAS_REQUEST_NO_VALUE = 2;
  static final int NO_REQUEST_HAS_VALUE = 1;
  static final int NO_REQUEST_NO_VALUE = 0;
  private static final long serialVersionUID = -2873467947112093874L;
  final Subscriber<? super T> child;
  T value;
  
  public SingleDelayedProducer(Subscriber<? super T> paramSubscriber)
  {
    this.child = paramSubscriber;
  }
  
  private static <T> void emit(Subscriber<? super T> paramSubscriber, T paramT)
  {
    if (paramSubscriber.isUnsubscribed()) {
      return;
    }
    try
    {
      paramSubscriber.onNext(paramT);
      if (paramSubscriber.isUnsubscribed()) {
        return;
      }
      paramSubscriber.onCompleted();
      return;
    }
    finally
    {
      Exceptions.throwOrReport(localThrowable, paramSubscriber, paramT);
    }
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
  public void setValue(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\producers\SingleDelayedProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */