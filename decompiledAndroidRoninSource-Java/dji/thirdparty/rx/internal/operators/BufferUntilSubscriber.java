package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.subjects.Subject;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

public final class BufferUntilSubscriber<T>
  extends Subject<T, T>
{
  static final Observer EMPTY_OBSERVER = new Observer()
  {
    public void onCompleted() {}
    
    public void onError(Throwable paramAnonymousThrowable) {}
    
    public void onNext(Object paramAnonymousObject) {}
  };
  private boolean forward = false;
  final State<T> state;
  
  private BufferUntilSubscriber(State<T> paramState)
  {
    super(new OnSubscribeAction(paramState));
    this.state = paramState;
  }
  
  public static <T> BufferUntilSubscriber<T> create()
  {
    return new BufferUntilSubscriber(new State());
  }
  
  /* Error */
  private void emit(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean hasObservers()
  {
    return false;
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
  
  static final class OnSubscribeAction<T>
    implements Observable.OnSubscribe<T>
  {
    final BufferUntilSubscriber.State<T> state;
    
    public OnSubscribeAction(BufferUntilSubscriber.State<T> paramState)
    {
      this.state = paramState;
    }
    
    /* Error */
    public void call(dji.thirdparty.rx.Subscriber<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  static final class State<T>
    extends AtomicReference<Observer<? super T>>
  {
    final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue();
    boolean emitting = false;
    final Object guard = new Object();
    final NotificationLite<T> nl = NotificationLite.instance();
    
    boolean casObserverRef(Observer<? super T> paramObserver1, Observer<? super T> paramObserver2)
    {
      return compareAndSet(paramObserver1, paramObserver2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\BufferUntilSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */