package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate;
import io.reactivex.internal.util.NotificationLite;

final class SerializedSubject<T>
  extends Subject<T>
  implements AppendOnlyLinkedArrayList.NonThrowingPredicate<Object>
{
  final Subject<T> actual;
  volatile boolean done;
  boolean emitting;
  AppendOnlyLinkedArrayList<Object> queue;
  
  SerializedSubject(Subject<T> paramSubject)
  {
    this.actual = paramSubject;
  }
  
  /* Error */
  void emitLoop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Throwable getThrowable()
  {
    return this.actual.getThrowable();
  }
  
  public boolean hasComplete()
  {
    return this.actual.hasComplete();
  }
  
  public boolean hasObservers()
  {
    return this.actual.hasObservers();
  }
  
  public boolean hasThrowable()
  {
    return this.actual.hasThrowable();
  }
  
  /* Error */
  public void onComplete()
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
  public void onSubscribe(io.reactivex.disposables.Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver)
  {
    this.actual.subscribe(paramObserver);
  }
  
  public boolean test(Object paramObject)
  {
    return NotificationLite.acceptFull(paramObject, this.actual);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\subjects\SerializedSubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */