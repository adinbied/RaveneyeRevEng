package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.FuncN;
import dji.thirdparty.rx.internal.util.RxRingBuffer;
import dji.thirdparty.rx.internal.util.atomic.SpscLinkedArrayQueue;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class OnSubscribeCombineLatest<T, R>
  implements Observable.OnSubscribe<R>
{
  final int bufferSize;
  final FuncN<? extends R> combiner;
  final boolean delayError;
  final Observable<? extends T>[] sources;
  final Iterable<? extends Observable<? extends T>> sourcesIterable;
  
  public OnSubscribeCombineLatest(Iterable<? extends Observable<? extends T>> paramIterable, FuncN<? extends R> paramFuncN)
  {
    this(null, paramIterable, paramFuncN, RxRingBuffer.SIZE, false);
  }
  
  public OnSubscribeCombineLatest(Observable<? extends T>[] paramArrayOfObservable, Iterable<? extends Observable<? extends T>> paramIterable, FuncN<? extends R> paramFuncN, int paramInt, boolean paramBoolean)
  {
    this.sources = paramArrayOfObservable;
    this.sourcesIterable = paramIterable;
    this.combiner = paramFuncN;
    this.bufferSize = paramInt;
    this.delayError = paramBoolean;
  }
  
  /* Error */
  public void call(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CombinerSubscriber<T, R>
    extends Subscriber<T>
  {
    boolean done;
    final int index;
    final NotificationLite<T> nl;
    final OnSubscribeCombineLatest.LatestCoordinator<T, R> parent;
    
    public CombinerSubscriber(OnSubscribeCombineLatest.LatestCoordinator<T, R> paramLatestCoordinator, int paramInt)
    {
      this.parent = paramLatestCoordinator;
      this.index = paramInt;
      this.nl = NotificationLite.instance();
      request(paramLatestCoordinator.bufferSize);
    }
    
    /* Error */
    public void onCompleted()
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
      //   2: goto -2 -> 0
    }
    
    public void requestMore(long paramLong)
    {
      request(paramLong);
    }
  }
  
  static final class LatestCoordinator<T, R>
    extends AtomicInteger
    implements Producer, Subscription
  {
    static final Object MISSING = new Object();
    private static final long serialVersionUID = 8567835998786448817L;
    int active;
    final Subscriber<? super R> actual;
    final int bufferSize;
    volatile boolean cancelled;
    final FuncN<? extends R> combiner;
    int complete;
    final int count;
    final boolean delayError;
    volatile boolean done;
    final AtomicReference<Throwable> error;
    final Object[] latest;
    final SpscLinkedArrayQueue<Object> queue;
    final AtomicLong requested;
    final OnSubscribeCombineLatest.CombinerSubscriber<T, R>[] subscribers;
    
    public LatestCoordinator(Subscriber<? super R> paramSubscriber, FuncN<? extends R> paramFuncN, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.actual = paramSubscriber;
      this.combiner = paramFuncN;
      this.count = paramInt1;
      this.bufferSize = paramInt2;
      this.delayError = paramBoolean;
      paramSubscriber = new Object[paramInt1];
      this.latest = paramSubscriber;
      Arrays.fill(paramSubscriber, MISSING);
      this.subscribers = new OnSubscribeCombineLatest.CombinerSubscriber[paramInt1];
      this.queue = new SpscLinkedArrayQueue(paramInt2);
      this.requested = new AtomicLong();
      this.error = new AtomicReference();
    }
    
    /* Error */
    void cancel(Queue<?> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<?> paramSubscriber, Queue<?> paramQueue, boolean paramBoolean3)
    {
      return false;
    }
    
    /* Error */
    void combine(Object arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isUnsubscribed()
    {
      return this.cancelled;
    }
    
    /* Error */
    void onError(Throwable arg1)
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
    public void subscribe(Observable<? extends T>[] arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void unsubscribe()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeCombineLatest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */