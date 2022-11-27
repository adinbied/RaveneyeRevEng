package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.observers.SerializedSubscriber;
import dji.thirdparty.rx.subscriptions.SerialSubscription;
import java.util.List;

public final class OperatorWindowWithObservableFactory<T, U>
  implements Observable.Operator<Observable<T>, T>
{
  static final Object NEXT_SUBJECT = new Object();
  static final NotificationLite<Object> nl = NotificationLite.instance();
  final Func0<? extends Observable<? extends U>> otherFactory;
  
  public OperatorWindowWithObservableFactory(Func0<? extends Observable<? extends U>> paramFunc0)
  {
    this.otherFactory = paramFunc0;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<T>> paramSubscriber)
  {
    return null;
  }
  
  static final class BoundarySubscriber<T, U>
    extends Subscriber<U>
  {
    boolean done;
    final OperatorWindowWithObservableFactory.SourceSubscriber<T, U> sub;
    
    public BoundarySubscriber(Subscriber<?> paramSubscriber, OperatorWindowWithObservableFactory.SourceSubscriber<T, U> paramSourceSubscriber)
    {
      this.sub = paramSourceSubscriber;
    }
    
    /* Error */
    public void onCompleted()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.sub.onError(paramThrowable);
    }
    
    public void onNext(U paramU)
    {
      if (!this.done)
      {
        this.done = true;
        this.sub.replaceWindow();
      }
    }
    
    /* Error */
    public void onStart()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class SourceSubscriber<T, U>
    extends Subscriber<T>
  {
    final Subscriber<? super Observable<T>> child;
    Observer<T> consumer;
    boolean emitting;
    final Object guard;
    final Func0<? extends Observable<? extends U>> otherFactory;
    Observable<T> producer;
    List<Object> queue;
    final SerialSubscription ssub;
    
    public SourceSubscriber(Subscriber<? super Observable<T>> paramSubscriber, Func0<? extends Observable<? extends U>> paramFunc0)
    {
      this.child = new SerializedSubscriber(paramSubscriber);
      this.guard = new Object();
      paramSubscriber = new SerialSubscription();
      this.ssub = paramSubscriber;
      this.otherFactory = paramFunc0;
      add(paramSubscriber);
    }
    
    /* Error */
    void complete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void createNewWindow()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void drain(List<Object> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void emitValue(T paramT)
    {
      Observer localObserver = this.consumer;
      if (localObserver != null) {
        localObserver.onNext(paramT);
      }
    }
    
    /* Error */
    void error(Throwable arg1)
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
    public void onStart()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void replaceSubject()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void replaceWindow()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorWindowWithObservableFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */