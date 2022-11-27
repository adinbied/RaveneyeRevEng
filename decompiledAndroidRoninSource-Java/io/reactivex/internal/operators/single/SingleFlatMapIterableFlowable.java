package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public final class SingleFlatMapIterableFlowable<T, R>
  extends Flowable<R>
{
  final Function<? super T, ? extends Iterable<? extends R>> mapper;
  final SingleSource<T> source;
  
  public SingleFlatMapIterableFlowable(SingleSource<T> paramSingleSource, Function<? super T, ? extends Iterable<? extends R>> paramFunction)
  {
    this.source = paramSingleSource;
    this.mapper = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class FlatMapIterableObserver<T, R>
    extends BasicIntQueueSubscription<R>
    implements SingleObserver<T>
  {
    private static final long serialVersionUID = -8938804753851907758L;
    volatile boolean cancelled;
    final Subscriber<? super R> downstream;
    volatile Iterator<? extends R> it;
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    boolean outputFused;
    final AtomicLong requested;
    Disposable upstream;
    
    FlatMapIterableObserver(Subscriber<? super R> paramSubscriber, Function<? super T, ? extends Iterable<? extends R>> paramFunction)
    {
      this.downstream = paramSubscriber;
      this.mapper = paramFunction;
      this.requested = new AtomicLong();
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void clear()
    {
      this.it = null;
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isEmpty()
    {
      return this.it == null;
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
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSuccess(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public R poll()
      throws Exception
    {
      return null;
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    public int requestFusion(int paramInt)
    {
      return 0;
    }
    
    /* Error */
    void slowPath(Subscriber<? super R> arg1, Iterator<? extends R> arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleFlatMapIterableFlowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */