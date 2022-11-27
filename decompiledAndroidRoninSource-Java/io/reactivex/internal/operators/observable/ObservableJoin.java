package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R>
  extends AbstractObservableWithUpstream<TLeft, R>
{
  final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd;
  final ObservableSource<? extends TRight> other;
  final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
  final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;
  
  public ObservableJoin(ObservableSource<TLeft> paramObservableSource, ObservableSource<? extends TRight> paramObservableSource1, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> paramFunction, Function<? super TRight, ? extends ObservableSource<TRightEnd>> paramFunction1, BiFunction<? super TLeft, ? super TRight, ? extends R> paramBiFunction)
  {
    super(paramObservableSource);
    this.other = paramObservableSource1;
    this.leftEnd = paramFunction;
    this.rightEnd = paramFunction1;
    this.resultSelector = paramBiFunction;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R>
    extends AtomicInteger
    implements Disposable, ObservableGroupJoin.JoinSupport
  {
    static final Integer LEFT_CLOSE = Integer.valueOf(3);
    static final Integer LEFT_VALUE = Integer.valueOf(1);
    static final Integer RIGHT_CLOSE = Integer.valueOf(4);
    static final Integer RIGHT_VALUE = Integer.valueOf(2);
    private static final long serialVersionUID = -6071216598687999801L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final CompositeDisposable disposables;
    final Observer<? super R> downstream;
    final AtomicReference<Throwable> error;
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd;
    int leftIndex;
    final Map<Integer, TLeft> lefts;
    final SpscLinkedArrayQueue<Object> queue;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;
    int rightIndex;
    final Map<Integer, TRight> rights;
    
    JoinDisposable(Observer<? super R> paramObserver, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> paramFunction, Function<? super TRight, ? extends ObservableSource<TRightEnd>> paramFunction1, BiFunction<? super TLeft, ? super TRight, ? extends R> paramBiFunction)
    {
      this.downstream = paramObserver;
      this.disposables = new CompositeDisposable();
      this.queue = new SpscLinkedArrayQueue(Observable.bufferSize());
      this.lefts = new LinkedHashMap();
      this.rights = new LinkedHashMap();
      this.error = new AtomicReference();
      this.leftEnd = paramFunction;
      this.rightEnd = paramFunction1;
      this.resultSelector = paramBiFunction;
      this.active = new AtomicInteger(2);
    }
    
    void cancelAll()
    {
      this.disposables.dispose();
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void errorAll(Observer<?> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void fail(Throwable arg1, Observer<?> arg2, SpscLinkedArrayQueue<?> arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void innerClose(boolean arg1, ObservableGroupJoin.LeftRightEndObserver arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    /* Error */
    public void innerCloseError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void innerComplete(ObservableGroupJoin.LeftRightObserver arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void innerError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void innerValue(boolean arg1, Object arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableJoin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */