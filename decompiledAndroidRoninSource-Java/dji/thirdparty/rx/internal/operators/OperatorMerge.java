package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.internal.util.RxRingBuffer;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

public final class OperatorMerge<T>
  implements Observable.Operator<T, Observable<? extends T>>
{
  final boolean delayErrors;
  final int maxConcurrent;
  
  OperatorMerge(boolean paramBoolean, int paramInt)
  {
    this.delayErrors = paramBoolean;
    this.maxConcurrent = paramInt;
  }
  
  public static <T> OperatorMerge<T> instance(boolean paramBoolean)
  {
    if (paramBoolean) {
      return HolderDelayErrors.INSTANCE;
    }
    return HolderNoDelay.INSTANCE;
  }
  
  public static <T> OperatorMerge<T> instance(boolean paramBoolean, int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInt == Integer.MAX_VALUE) {
        return instance(paramBoolean);
      }
      return new OperatorMerge(paramBoolean, paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxConcurrent > 0 required but it was ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public Subscriber<Observable<? extends T>> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  private static final class HolderDelayErrors
  {
    static final OperatorMerge<Object> INSTANCE = new OperatorMerge(true, Integer.MAX_VALUE);
  }
  
  private static final class HolderNoDelay
  {
    static final OperatorMerge<Object> INSTANCE = new OperatorMerge(false, Integer.MAX_VALUE);
  }
  
  static final class InnerSubscriber<T>
    extends Subscriber<T>
  {
    static final int limit = RxRingBuffer.SIZE / 4;
    volatile boolean done;
    final long id;
    int outstanding;
    final OperatorMerge.MergeSubscriber<T> parent;
    volatile RxRingBuffer queue;
    
    public InnerSubscriber(OperatorMerge.MergeSubscriber<T> paramMergeSubscriber, long paramLong)
    {
      this.parent = paramMergeSubscriber;
      this.id = paramLong;
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
    
    public void onNext(T paramT)
    {
      this.parent.tryEmit(this, paramT);
    }
    
    /* Error */
    public void onStart()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void requestMore(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
  
  static final class MergeProducer<T>
    extends AtomicLong
    implements Producer
  {
    private static final long serialVersionUID = -1214379189873595503L;
    final OperatorMerge.MergeSubscriber<T> subscriber;
    
    public MergeProducer(OperatorMerge.MergeSubscriber<T> paramMergeSubscriber)
    {
      this.subscriber = paramMergeSubscriber;
    }
    
    public long produced(int paramInt)
    {
      return addAndGet(-paramInt);
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
  
  static final class MergeSubscriber<T>
    extends Subscriber<Observable<? extends T>>
  {
    static final OperatorMerge.InnerSubscriber<?>[] EMPTY = new OperatorMerge.InnerSubscriber[0];
    final Subscriber<? super T> child;
    final boolean delayErrors;
    volatile boolean done;
    boolean emitting;
    volatile ConcurrentLinkedQueue<Throwable> errors;
    final Object innerGuard;
    volatile OperatorMerge.InnerSubscriber<?>[] innerSubscribers;
    long lastId;
    int lastIndex;
    final int maxConcurrent;
    boolean missed;
    final NotificationLite<T> nl;
    OperatorMerge.MergeProducer<T> producer;
    volatile Queue<Object> queue;
    int scalarEmissionCount;
    final int scalarEmissionLimit;
    volatile CompositeSubscription subscriptions;
    long uniqueId;
    
    public MergeSubscriber(Subscriber<? super T> paramSubscriber, boolean paramBoolean, int paramInt)
    {
      this.child = paramSubscriber;
      this.delayErrors = paramBoolean;
      this.maxConcurrent = paramInt;
      this.nl = NotificationLite.instance();
      this.innerGuard = new Object();
      this.innerSubscribers = EMPTY;
      if (paramInt == Integer.MAX_VALUE)
      {
        this.scalarEmissionLimit = Integer.MAX_VALUE;
        request(Long.MAX_VALUE);
        return;
      }
      this.scalarEmissionLimit = Math.max(1, paramInt >> 1);
      request(paramInt);
    }
    
    /* Error */
    private void reportError()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void addInner(OperatorMerge.InnerSubscriber<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    boolean checkTerminate()
    {
      return false;
    }
    
    /* Error */
    void emit()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
    protected void emitScalar(OperatorMerge.InnerSubscriber<T> arg1, T arg2, long arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    protected void emitScalar(T arg1, long arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    CompositeSubscription getOrCreateComposite()
    {
      return null;
    }
    
    Queue<Throwable> getOrCreateErrorQueue()
    {
      return null;
    }
    
    public void onCompleted()
    {
      this.done = true;
      emit();
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
    public void onNext(Observable<? extends T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    protected void queueScalar(OperatorMerge.InnerSubscriber<T> arg1, T arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    protected void queueScalar(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void removeInner(OperatorMerge.InnerSubscriber<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void requestMore(long paramLong)
    {
      request(paramLong);
    }
    
    /* Error */
    void tryEmit(OperatorMerge.InnerSubscriber<T> arg1, T arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void tryEmit(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */