package dji.thirdparty.rx.internal.util;

import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.internal.operators.NotificationLite;
import dji.thirdparty.rx.internal.util.unsafe.SpmcArrayQueue;
import dji.thirdparty.rx.internal.util.unsafe.SpscArrayQueue;
import dji.thirdparty.rx.internal.util.unsafe.UnsafeAccess;
import java.io.PrintStream;
import java.util.Queue;

public class RxRingBuffer
  implements Subscription
{
  public static final int SIZE;
  public static ObjectPool<Queue<Object>> SPMC_POOL = new ObjectPool()
  {
    protected SpmcArrayQueue<Object> createObject()
    {
      return new SpmcArrayQueue(RxRingBuffer.SIZE);
    }
  };
  public static ObjectPool<Queue<Object>> SPSC_POOL;
  static int _size;
  private static final NotificationLite<Object> on = ;
  private final ObjectPool<Queue<Object>> pool;
  private Queue<Object> queue;
  private final int size;
  public volatile Object terminalState;
  
  static
  {
    _size = 128;
    if (PlatformDependent.isAndroid()) {
      _size = 16;
    }
    String str = System.getProperty("rx.ring-buffer.size");
    if (str != null) {
      try
      {
        _size = Integer.parseInt(str);
      }
      catch (Exception localException)
      {
        PrintStream localPrintStream = System.err;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to set 'rx.buffer.size' with value ");
        localStringBuilder.append(str);
        localStringBuilder.append(" => ");
        localStringBuilder.append(localException.getMessage());
        localPrintStream.println(localStringBuilder.toString());
      }
    }
    SIZE = _size;
    SPSC_POOL = new ObjectPool()
    {
      protected SpscArrayQueue<Object> createObject()
      {
        return new SpscArrayQueue(RxRingBuffer.SIZE);
      }
    };
  }
  
  RxRingBuffer()
  {
    this(new SynchronizedQueue(SIZE), SIZE);
  }
  
  private RxRingBuffer(ObjectPool<Queue<Object>> paramObjectPool, int paramInt)
  {
    this.pool = paramObjectPool;
    this.queue = ((Queue)paramObjectPool.borrowObject());
    this.size = paramInt;
  }
  
  private RxRingBuffer(Queue<Object> paramQueue, int paramInt)
  {
    this.queue = paramQueue;
    this.pool = null;
    this.size = paramInt;
  }
  
  public static RxRingBuffer getSpmcInstance()
  {
    if (UnsafeAccess.isUnsafeAvailable()) {
      return new RxRingBuffer(SPMC_POOL, SIZE);
    }
    return new RxRingBuffer();
  }
  
  public static RxRingBuffer getSpscInstance()
  {
    if (UnsafeAccess.isUnsafeAvailable()) {
      return new RxRingBuffer(SPSC_POOL, SIZE);
    }
    return new RxRingBuffer();
  }
  
  public boolean accept(Object paramObject, Observer paramObserver)
  {
    return on.accept(paramObserver, paramObject);
  }
  
  public Throwable asError(Object paramObject)
  {
    return on.getError(paramObject);
  }
  
  public int available()
  {
    return this.size - count();
  }
  
  public int capacity()
  {
    return this.size;
  }
  
  public int count()
  {
    return 0;
  }
  
  public Object getValue(Object paramObject)
  {
    return on.getValue(paramObject);
  }
  
  public boolean isCompleted(Object paramObject)
  {
    return on.isCompleted(paramObject);
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean isError(Object paramObject)
  {
    return on.isError(paramObject);
  }
  
  public boolean isUnsubscribed()
  {
    return this.queue == null;
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
  public void onNext(Object arg1)
    throws dji.thirdparty.rx.exceptions.MissingBackpressureException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Object peek()
  {
    return null;
  }
  
  public Object poll()
  {
    return null;
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void unsubscribe()
  {
    release();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\RxRingBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */