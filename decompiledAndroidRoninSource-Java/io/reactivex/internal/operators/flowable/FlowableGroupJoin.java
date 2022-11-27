package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R>
  extends AbstractFlowableWithUpstream<TLeft, R>
{
  final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
  final Publisher<? extends TRight> other;
  final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> resultSelector;
  final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;
  
  public FlowableGroupJoin(Flowable<TLeft> paramFlowable, Publisher<? extends TRight> paramPublisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> paramFunction, Function<? super TRight, ? extends Publisher<TRightEnd>> paramFunction1, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> paramBiFunction)
  {
    super(paramFlowable);
    this.other = paramPublisher;
    this.leftEnd = paramFunction;
    this.rightEnd = paramFunction1;
    this.resultSelector = paramBiFunction;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R>
    extends AtomicInteger
    implements Subscription, FlowableGroupJoin.JoinSupport
  {
    static final Integer LEFT_CLOSE = Integer.valueOf(3);
    static final Integer LEFT_VALUE = Integer.valueOf(1);
    static final Integer RIGHT_CLOSE = Integer.valueOf(4);
    static final Integer RIGHT_VALUE = Integer.valueOf(2);
    private static final long serialVersionUID = -6071216598687999801L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final CompositeDisposable disposables;
    final Subscriber<? super R> downstream;
    final AtomicReference<Throwable> error;
    final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
    int leftIndex;
    final Map<Integer, UnicastProcessor<TRight>> lefts;
    final SpscLinkedArrayQueue<Object> queue;
    final AtomicLong requested;
    final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> resultSelector;
    final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;
    int rightIndex;
    final Map<Integer, TRight> rights;
    
    GroupJoinSubscription(Subscriber<? super R> paramSubscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> paramFunction, Function<? super TRight, ? extends Publisher<TRightEnd>> paramFunction1, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> paramBiFunction)
    {
      this.downstream = paramSubscriber;
      this.requested = new AtomicLong();
      this.disposables = new CompositeDisposable();
      this.queue = new SpscLinkedArrayQueue(Flowable.bufferSize());
      this.lefts = new LinkedHashMap();
      this.rights = new LinkedHashMap();
      this.error = new AtomicReference();
      this.leftEnd = paramFunction;
      this.rightEnd = paramFunction1;
      this.resultSelector = paramBiFunction;
      this.active = new AtomicInteger(2);
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void cancelAll()
    {
      this.disposables.dispose();
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
    void errorAll(Subscriber<?> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void fail(Throwable arg1, Subscriber<?> arg2, io.reactivex.internal.fuseable.SimpleQueue<?> arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void innerClose(boolean arg1, FlowableGroupJoin.LeftRightEndSubscriber arg2)
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
    public void innerComplete(FlowableGroupJoin.LeftRightSubscriber arg1)
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
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
  
  static abstract interface JoinSupport
  {
    public abstract void innerClose(boolean paramBoolean, FlowableGroupJoin.LeftRightEndSubscriber paramLeftRightEndSubscriber);
    
    public abstract void innerCloseError(Throwable paramThrowable);
    
    public abstract void innerComplete(FlowableGroupJoin.LeftRightSubscriber paramLeftRightSubscriber);
    
    public abstract void innerError(Throwable paramThrowable);
    
    public abstract void innerValue(boolean paramBoolean, Object paramObject);
  }
  
  static final class LeftRightEndSubscriber
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<Object>, Disposable
  {
    private static final long serialVersionUID = 1883890389173668373L;
    final int index;
    final boolean isLeft;
    final FlowableGroupJoin.JoinSupport parent;
    
    LeftRightEndSubscriber(FlowableGroupJoin.JoinSupport paramJoinSupport, boolean paramBoolean, int paramInt)
    {
      this.parent = paramJoinSupport;
      this.isLeft = paramBoolean;
      this.index = paramInt;
    }
    
    public void dispose()
    {
      SubscriptionHelper.cancel(this);
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    public void onComplete()
    {
      this.parent.innerClose(this.isLeft, this);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.innerCloseError(paramThrowable);
    }
    
    /* Error */
    public void onNext(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
  
  static final class LeftRightSubscriber
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<Object>, Disposable
  {
    private static final long serialVersionUID = 1883890389173668373L;
    final boolean isLeft;
    final FlowableGroupJoin.JoinSupport parent;
    
    LeftRightSubscriber(FlowableGroupJoin.JoinSupport paramJoinSupport, boolean paramBoolean)
    {
      this.parent = paramJoinSupport;
      this.isLeft = paramBoolean;
    }
    
    public void dispose()
    {
      SubscriptionHelper.cancel(this);
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    public void onComplete()
    {
      this.parent.innerComplete(this);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.innerError(paramThrowable);
    }
    
    public void onNext(Object paramObject)
    {
      this.parent.innerValue(this.isLeft, paramObject);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableGroupJoin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */