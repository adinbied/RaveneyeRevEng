package dji.thirdparty.rx.observables;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.exceptions.OnErrorNotImplementedException;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.functions.Actions;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.internal.operators.BlockingOperatorLatest;
import dji.thirdparty.rx.internal.operators.BlockingOperatorMostRecent;
import dji.thirdparty.rx.internal.operators.BlockingOperatorNext;
import dji.thirdparty.rx.internal.operators.BlockingOperatorToFuture;
import dji.thirdparty.rx.internal.operators.BlockingOperatorToIterator;
import dji.thirdparty.rx.internal.operators.NotificationLite;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObservable<T>
{
  static final Object ON_START = new Object();
  static final Object SET_PRODUCER = new Object();
  static final Object UNSUBSCRIBE = new Object();
  private final Observable<? extends T> o;
  
  private BlockingObservable(Observable<? extends T> paramObservable)
  {
    this.o = paramObservable;
  }
  
  private T blockForSingle(Observable<? extends T> paramObservable)
  {
    return null;
  }
  
  public static <T> BlockingObservable<T> from(Observable<? extends T> paramObservable)
  {
    return new BlockingObservable(paramObservable);
  }
  
  public T first()
  {
    return null;
  }
  
  public T first(Func1<? super T, Boolean> paramFunc1)
  {
    return null;
  }
  
  public T firstOrDefault(T paramT)
  {
    return null;
  }
  
  public T firstOrDefault(T paramT, Func1<? super T, Boolean> paramFunc1)
  {
    return null;
  }
  
  /* Error */
  public void forEach(Action1<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Iterator<T> getIterator()
  {
    return BlockingOperatorToIterator.toIterator(this.o);
  }
  
  public T last()
  {
    return null;
  }
  
  public T last(Func1<? super T, Boolean> paramFunc1)
  {
    return null;
  }
  
  public T lastOrDefault(T paramT)
  {
    return null;
  }
  
  public T lastOrDefault(T paramT, Func1<? super T, Boolean> paramFunc1)
  {
    return null;
  }
  
  public Iterable<T> latest()
  {
    return BlockingOperatorLatest.latest(this.o);
  }
  
  public Iterable<T> mostRecent(T paramT)
  {
    return BlockingOperatorMostRecent.mostRecent(this.o, paramT);
  }
  
  public Iterable<T> next()
  {
    return BlockingOperatorNext.next(this.o);
  }
  
  public T single()
  {
    return null;
  }
  
  public T single(Func1<? super T, Boolean> paramFunc1)
  {
    return null;
  }
  
  public T singleOrDefault(T paramT)
  {
    return null;
  }
  
  public T singleOrDefault(T paramT, Func1<? super T, Boolean> paramFunc1)
  {
    return null;
  }
  
  /* Error */
  public void subscribe()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void subscribe(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void subscribe(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void subscribe(Action1<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void subscribe(Action1<? super T> paramAction1, Action1<? super Throwable> paramAction11)
  {
    subscribe(paramAction1, paramAction11, Actions.empty());
  }
  
  /* Error */
  public void subscribe(Action1<? super T> arg1, Action1<? super Throwable> arg2, Action0 arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Future<T> toFuture()
  {
    return BlockingOperatorToFuture.toFuture(this.o);
  }
  
  public Iterable<T> toIterable()
  {
    new Iterable()
    {
      public Iterator<T> iterator()
      {
        return BlockingObservable.this.getIterator();
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\observables\BlockingObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */