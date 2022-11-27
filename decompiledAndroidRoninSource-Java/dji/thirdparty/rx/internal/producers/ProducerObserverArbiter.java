package dji.thirdparty.rx.internal.producers;

import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import java.util.List;

public final class ProducerObserverArbiter<T>
  implements Producer, Observer<T>
{
  static final Producer NULL_PRODUCER = new Producer()
  {
    public void request(long paramAnonymousLong) {}
  };
  final Subscriber<? super T> child;
  Producer currentProducer;
  boolean emitting;
  volatile boolean hasError;
  Producer missedProducer;
  long missedRequested;
  Object missedTerminal;
  List<T> queue;
  long requested;
  
  public ProducerObserverArbiter(Subscriber<? super T> paramSubscriber)
  {
    this.child = paramSubscriber;
  }
  
  /* Error */
  void emitLoop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onCompleted()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onError(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onNext(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void request(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  /* Error */
  public void setProducer(Producer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\producers\ProducerObserverArbiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */