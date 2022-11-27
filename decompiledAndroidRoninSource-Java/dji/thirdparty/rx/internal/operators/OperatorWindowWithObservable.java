package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.observers.SerializedSubscriber;
import java.util.List;

public final class OperatorWindowWithObservable<T, U>
  implements Observable.Operator<Observable<T>, T>
{
  static final Object NEXT_SUBJECT = new Object();
  static final NotificationLite<Object> nl = NotificationLite.instance();
  final Observable<U> other;
  
  public OperatorWindowWithObservable(Observable<U> paramObservable)
  {
    this.other = paramObservable;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<T>> paramSubscriber)
  {
    return null;
  }
  
  static final class BoundarySubscriber<T, U>
    extends Subscriber<U>
  {
    final OperatorWindowWithObservable.SourceSubscriber<T> sub;
    
    public BoundarySubscriber(Subscriber<?> paramSubscriber, OperatorWindowWithObservable.SourceSubscriber<T> paramSourceSubscriber)
    {
      this.sub = paramSourceSubscriber;
    }
    
    public void onCompleted()
    {
      this.sub.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.sub.onError(paramThrowable);
    }
    
    public void onNext(U paramU)
    {
      this.sub.replaceWindow();
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
  
  static final class SourceSubscriber<T>
    extends Subscriber<T>
  {
    final Subscriber<? super Observable<T>> child;
    Observer<T> consumer;
    boolean emitting;
    final Object guard;
    Observable<T> producer;
    List<Object> queue;
    
    public SourceSubscriber(Subscriber<? super Observable<T>> paramSubscriber)
    {
      this.child = new SerializedSubscriber(paramSubscriber);
      this.guard = new Object();
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
      //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorWindowWithObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */