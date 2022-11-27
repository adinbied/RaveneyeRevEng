package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.BackpressureOverflow;
import dji.thirdparty.rx.BackpressureOverflow.Strategy;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.internal.util.BackpressureDrainManager;
import dji.thirdparty.rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class OperatorOnBackpressureBuffer<T>
  implements Observable.Operator<T, T>
{
  private final Long capacity;
  private final Action0 onOverflow;
  private final BackpressureOverflow.Strategy overflowStrategy;
  
  OperatorOnBackpressureBuffer()
  {
    this.capacity = null;
    this.onOverflow = null;
    this.overflowStrategy = BackpressureOverflow.ON_OVERFLOW_DEFAULT;
  }
  
  public OperatorOnBackpressureBuffer(long paramLong)
  {
    this(paramLong, null, BackpressureOverflow.ON_OVERFLOW_DEFAULT);
  }
  
  public OperatorOnBackpressureBuffer(long paramLong, Action0 paramAction0)
  {
    this(paramLong, paramAction0, BackpressureOverflow.ON_OVERFLOW_DEFAULT);
  }
  
  public OperatorOnBackpressureBuffer(long paramLong, Action0 paramAction0, BackpressureOverflow.Strategy paramStrategy)
  {
    if (paramLong > 0L)
    {
      if (paramStrategy != null)
      {
        this.capacity = Long.valueOf(paramLong);
        this.onOverflow = paramAction0;
        this.overflowStrategy = paramStrategy;
        return;
      }
      throw new NullPointerException("The BackpressureOverflow strategy must not be null");
    }
    throw new IllegalArgumentException("Buffer capacity must be > 0");
  }
  
  public static <T> OperatorOnBackpressureBuffer<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  private static final class BufferSubscriber<T>
    extends Subscriber<T>
    implements BackpressureDrainManager.BackpressureQueueCallback
  {
    private final Long baseCapacity;
    private final AtomicLong capacity;
    private final Subscriber<? super T> child;
    private final BackpressureDrainManager manager;
    private final NotificationLite<T> on = NotificationLite.instance();
    private final Action0 onOverflow;
    private final BackpressureOverflow.Strategy overflowStrategy;
    private final ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue();
    private final AtomicBoolean saturated = new AtomicBoolean(false);
    
    public BufferSubscriber(Subscriber<? super T> paramSubscriber, Long paramLong, Action0 paramAction0, BackpressureOverflow.Strategy paramStrategy)
    {
      this.child = paramSubscriber;
      this.baseCapacity = paramLong;
      if (paramLong != null) {
        paramSubscriber = new AtomicLong(paramLong.longValue());
      } else {
        paramSubscriber = null;
      }
      this.capacity = paramSubscriber;
      this.onOverflow = paramAction0;
      this.manager = new BackpressureDrainManager(this);
      this.overflowStrategy = paramStrategy;
    }
    
    private boolean assertCapacity()
    {
      return false;
    }
    
    public boolean accept(Object paramObject)
    {
      return false;
    }
    
    /* Error */
    public void complete(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    protected Producer manager()
    {
      return this.manager;
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
    
    /* Error */
    public void onStart()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public Object peek()
    {
      return this.queue.peek();
    }
    
    public Object poll()
    {
      return null;
    }
  }
  
  private static class Holder
  {
    static final OperatorOnBackpressureBuffer<?> INSTANCE = new OperatorOnBackpressureBuffer();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorOnBackpressureBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */