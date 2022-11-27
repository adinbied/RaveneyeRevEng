package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.internal.util.atomic.SpscLinkedArrayQueue;
import dji.thirdparty.rx.subjects.Subject;
import dji.thirdparty.rx.subscriptions.Subscriptions;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class OperatorWindowWithSize<T>
  implements Observable.Operator<Observable<T>, T>
{
  final int size;
  final int skip;
  
  public OperatorWindowWithSize(int paramInt1, int paramInt2)
  {
    this.size = paramInt1;
    this.skip = paramInt2;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<T>> paramSubscriber)
  {
    return null;
  }
  
  static final class WindowExact<T>
    extends Subscriber<T>
    implements Action0
  {
    final Subscriber<? super Observable<T>> actual;
    final Subscription cancel;
    int index;
    final int size;
    Subject<T, T> window;
    final AtomicInteger wip;
    
    public WindowExact(Subscriber<? super Observable<T>> paramSubscriber, int paramInt)
    {
      this.actual = paramSubscriber;
      this.size = paramInt;
      this.wip = new AtomicInteger(1);
      paramSubscriber = Subscriptions.create(this);
      this.cancel = paramSubscriber;
      add(paramSubscriber);
      request(0L);
    }
    
    /* Error */
    public void call()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
  
  static final class WindowOverlap<T>
    extends Subscriber<T>
    implements Action0
  {
    final Subscriber<? super Observable<T>> actual;
    final Subscription cancel;
    volatile boolean done;
    final AtomicInteger drainWip;
    Throwable error;
    int index;
    int produced;
    final Queue<Subject<T, T>> queue;
    final AtomicLong requested;
    final int size;
    final int skip;
    final ArrayDeque<Subject<T, T>> windows;
    final AtomicInteger wip;
    
    public WindowOverlap(Subscriber<? super Observable<T>> paramSubscriber, int paramInt1, int paramInt2)
    {
      this.actual = paramSubscriber;
      this.size = paramInt1;
      this.skip = paramInt2;
      this.wip = new AtomicInteger(1);
      this.windows = new ArrayDeque();
      this.drainWip = new AtomicInteger();
      this.requested = new AtomicLong();
      paramSubscriber = Subscriptions.create(this);
      this.cancel = paramSubscriber;
      add(paramSubscriber);
      request(0L);
      this.queue = new SpscLinkedArrayQueue((paramInt1 + (paramInt2 - 1)) / paramInt2);
    }
    
    /* Error */
    public void call()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super Subject<T, T>> paramSubscriber, Queue<Subject<T, T>> paramQueue)
    {
      return false;
    }
    
    Producer createProducer()
    {
      return new WindowOverlapProducer();
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    
    final class WindowOverlapProducer
      extends AtomicBoolean
      implements Producer
    {
      private static final long serialVersionUID = 4625807964358024108L;
      
      WindowOverlapProducer() {}
      
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
  
  static final class WindowSkip<T>
    extends Subscriber<T>
    implements Action0
  {
    final Subscriber<? super Observable<T>> actual;
    final Subscription cancel;
    int index;
    final int size;
    final int skip;
    Subject<T, T> window;
    final AtomicInteger wip;
    
    public WindowSkip(Subscriber<? super Observable<T>> paramSubscriber, int paramInt1, int paramInt2)
    {
      this.actual = paramSubscriber;
      this.size = paramInt1;
      this.skip = paramInt2;
      this.wip = new AtomicInteger(1);
      paramSubscriber = Subscriptions.create(this);
      this.cancel = paramSubscriber;
      add(paramSubscriber);
      request(0L);
    }
    
    /* Error */
    public void call()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    Producer createProducer()
    {
      return new WindowSkipProducer();
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
    
    final class WindowSkipProducer
      extends AtomicBoolean
      implements Producer
    {
      private static final long serialVersionUID = 4625807964358024108L;
      
      WindowSkipProducer() {}
      
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorWindowWithSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */