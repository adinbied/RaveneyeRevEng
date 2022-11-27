package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiFunction;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZipIterable<T, U, V>
  extends AbstractFlowableWithUpstream<T, V>
{
  final Iterable<U> other;
  final BiFunction<? super T, ? super U, ? extends V> zipper;
  
  public FlowableZipIterable(Flowable<T> paramFlowable, Iterable<U> paramIterable, BiFunction<? super T, ? super U, ? extends V> paramBiFunction)
  {
    super(paramFlowable);
    this.other = paramIterable;
    this.zipper = paramBiFunction;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super V> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class ZipIterableSubscriber<T, U, V>
    implements FlowableSubscriber<T>, Subscription
  {
    boolean done;
    final Subscriber<? super V> downstream;
    final Iterator<U> iterator;
    Subscription upstream;
    final BiFunction<? super T, ? super U, ? extends V> zipper;
    
    ZipIterableSubscriber(Subscriber<? super V> paramSubscriber, Iterator<U> paramIterator, BiFunction<? super T, ? super U, ? extends V> paramBiFunction)
    {
      this.downstream = paramSubscriber;
      this.iterator = paramIterator;
      this.zipper = paramBiFunction;
    }
    
    public void cancel()
    {
      this.upstream.cancel();
    }
    
    /* Error */
    void error(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void request(long paramLong)
    {
      this.upstream.request(paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableZipIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */