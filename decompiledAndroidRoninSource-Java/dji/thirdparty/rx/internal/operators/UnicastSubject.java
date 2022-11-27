package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.internal.util.atomic.SpscLinkedAtomicQueue;
import dji.thirdparty.rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import dji.thirdparty.rx.internal.util.unsafe.SpscLinkedQueue;
import dji.thirdparty.rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import dji.thirdparty.rx.internal.util.unsafe.UnsafeAccess;
import dji.thirdparty.rx.subjects.Subject;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastSubject<T>
  extends Subject<T, T>
{
  final State<T> state;
  
  private UnicastSubject(State<T> paramState)
  {
    super(paramState);
    this.state = paramState;
  }
  
  public static <T> UnicastSubject<T> create()
  {
    return create(16);
  }
  
  public static <T> UnicastSubject<T> create(int paramInt)
  {
    return new UnicastSubject(new State(paramInt, null));
  }
  
  public static <T> UnicastSubject<T> create(int paramInt, Action0 paramAction0)
  {
    return new UnicastSubject(new State(paramInt, paramAction0));
  }
  
  public boolean hasObservers()
  {
    return false;
  }
  
  public void onCompleted()
  {
    this.state.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.state.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.state.onNext(paramT);
  }
  
  static final class State<T>
    extends AtomicLong
    implements Producer, Observer<T>, Action0, Observable.OnSubscribe<T>
  {
    private static final long serialVersionUID = -9044104859202255786L;
    volatile boolean caughtUp;
    volatile boolean done;
    boolean emitting;
    Throwable error;
    boolean missed;
    final NotificationLite<T> nl = NotificationLite.instance();
    final Queue<Object> queue;
    final AtomicReference<Subscriber<? super T>> subscriber = new AtomicReference();
    final AtomicReference<Action0> terminateOnce;
    
    public State(int paramInt, Action0 paramAction0)
    {
      if (paramAction0 != null) {
        paramAction0 = new AtomicReference(paramAction0);
      } else {
        paramAction0 = null;
      }
      this.terminateOnce = paramAction0;
      if (paramInt > 1)
      {
        if (UnsafeAccess.isUnsafeAvailable()) {
          paramAction0 = new SpscUnboundedArrayQueue(paramInt);
        } else {
          paramAction0 = new SpscUnboundedAtomicArrayQueue(paramInt);
        }
      }
      else if (UnsafeAccess.isUnsafeAvailable()) {
        paramAction0 = new SpscLinkedQueue();
      } else {
        paramAction0 = new SpscLinkedAtomicQueue();
      }
      this.queue = paramAction0;
    }
    
    /* Error */
    public void call()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void call(Subscriber<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super T> paramSubscriber)
    {
      return false;
    }
    
    /* Error */
    void doTerminate()
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
      //   2: return
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
    void replay()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\UnicastSubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */