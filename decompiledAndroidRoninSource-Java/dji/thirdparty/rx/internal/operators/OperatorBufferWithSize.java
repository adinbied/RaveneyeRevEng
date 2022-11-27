package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class OperatorBufferWithSize<T>
  implements Observable.Operator<List<T>, T>
{
  final int count;
  final int skip;
  
  public OperatorBufferWithSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 > 0)
      {
        this.count = paramInt1;
        this.skip = paramInt2;
        return;
      }
      throw new IllegalArgumentException("skip must be greater than 0");
    }
    throw new IllegalArgumentException("count must be greater than 0");
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    return null;
  }
  
  static final class BufferExact<T>
    extends Subscriber<T>
  {
    final Subscriber<? super List<T>> actual;
    List<T> buffer;
    final int count;
    
    public BufferExact(Subscriber<? super List<T>> paramSubscriber, int paramInt)
    {
      this.actual = paramSubscriber;
      this.count = paramInt;
      request(0L);
    }
    
    Producer createProducer()
    {
      new Producer()
      {
        /* Error */
        public void request(long arg1)
        {
          // Byte code:
          //   0: return
          //   1: astore_3
          //   2: goto -2 -> 0
        }
      };
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
  }
  
  static final class BufferOverlap<T>
    extends Subscriber<T>
  {
    final Subscriber<? super List<T>> actual;
    final int count;
    long index;
    long produced;
    final ArrayDeque<List<T>> queue;
    final AtomicLong requested;
    final int skip;
    
    public BufferOverlap(Subscriber<? super List<T>> paramSubscriber, int paramInt1, int paramInt2)
    {
      this.actual = paramSubscriber;
      this.count = paramInt1;
      this.skip = paramInt2;
      this.queue = new ArrayDeque();
      this.requested = new AtomicLong();
      request(0L);
    }
    
    Producer createProducer()
    {
      return new BufferOverlapProducer();
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
    
    final class BufferOverlapProducer
      extends AtomicBoolean
      implements Producer
    {
      private static final long serialVersionUID = -4015894850868853147L;
      
      BufferOverlapProducer() {}
      
      /* Error */
      public void request(long arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_3
        //   2: goto -2 -> 0
      }
    }
  }
  
  static final class BufferSkip<T>
    extends Subscriber<T>
  {
    final Subscriber<? super List<T>> actual;
    List<T> buffer;
    final int count;
    long index;
    final int skip;
    
    public BufferSkip(Subscriber<? super List<T>> paramSubscriber, int paramInt1, int paramInt2)
    {
      this.actual = paramSubscriber;
      this.count = paramInt1;
      this.skip = paramInt2;
      request(0L);
    }
    
    Producer createProducer()
    {
      return new BufferSkipProducer();
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
    
    final class BufferSkipProducer
      extends AtomicBoolean
      implements Producer
    {
      private static final long serialVersionUID = 3428177408082367154L;
      
      BufferSkipProducer() {}
      
      /* Error */
      public void request(long arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_3
        //   2: goto -2 -> 0
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorBufferWithSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */