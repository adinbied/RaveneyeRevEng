package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class SingleDelayWithPublisher<T, U>
  extends Single<T>
{
  final Publisher<U> other;
  final SingleSource<T> source;
  
  public SingleDelayWithPublisher(SingleSource<T> paramSingleSource, Publisher<U> paramPublisher)
  {
    this.source = paramSingleSource;
    this.other = paramPublisher;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class OtherSubscriber<T, U>
    extends AtomicReference<Disposable>
    implements FlowableSubscriber<U>, Disposable
  {
    private static final long serialVersionUID = -8565274649390031272L;
    boolean done;
    final SingleObserver<? super T> downstream;
    final SingleSource<T> source;
    Subscription upstream;
    
    OtherSubscriber(SingleObserver<? super T> paramSingleObserver, SingleSource<T> paramSingleSource)
    {
      this.downstream = paramSingleObserver;
      this.source = paramSingleSource;
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onNext(U paramU)
    {
      this.upstream.cancel();
      onComplete();
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDelayWithPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */