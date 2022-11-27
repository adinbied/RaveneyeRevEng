package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.observers.SerializedObserver;
import dji.thirdparty.rx.observers.SerializedSubscriber;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import java.util.LinkedList;
import java.util.List;

public final class OperatorWindowWithStartEndObservable<T, U, V>
  implements Observable.Operator<Observable<T>, T>
{
  final Func1<? super U, ? extends Observable<? extends V>> windowClosingSelector;
  final Observable<? extends U> windowOpenings;
  
  public OperatorWindowWithStartEndObservable(Observable<? extends U> paramObservable, Func1<? super U, ? extends Observable<? extends V>> paramFunc1)
  {
    this.windowOpenings = paramObservable;
    this.windowClosingSelector = paramFunc1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<T>> paramSubscriber)
  {
    return null;
  }
  
  static final class SerializedSubject<T>
  {
    final Observer<T> consumer;
    final Observable<T> producer;
    
    public SerializedSubject(Observer<T> paramObserver, Observable<T> paramObservable)
    {
      this.consumer = new SerializedObserver(paramObserver);
      this.producer = paramObservable;
    }
  }
  
  final class SourceSubscriber
    extends Subscriber<T>
  {
    final Subscriber<? super Observable<T>> child;
    final List<OperatorWindowWithStartEndObservable.SerializedSubject<T>> chunks;
    final CompositeSubscription csub;
    boolean done;
    final Object guard;
    
    public SourceSubscriber(CompositeSubscription paramCompositeSubscription)
    {
      this.child = new SerializedSubscriber(paramCompositeSubscription);
      this.guard = new Object();
      this.chunks = new LinkedList();
      CompositeSubscription localCompositeSubscription;
      this.csub = localCompositeSubscription;
    }
    
    /* Error */
    void beginWindow(U arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    OperatorWindowWithStartEndObservable.SerializedSubject<T> createSerializedSubject()
    {
      return null;
    }
    
    /* Error */
    void endWindow(OperatorWindowWithStartEndObservable.SerializedSubject<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorWindowWithStartEndObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */