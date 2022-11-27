package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class AsyncSubject<T>
  extends Subject<T>
{
  static final AsyncDisposable[] EMPTY = new AsyncDisposable[0];
  static final AsyncDisposable[] TERMINATED = new AsyncDisposable[0];
  Throwable error;
  final AtomicReference<AsyncDisposable<T>[]> subscribers = new AtomicReference(EMPTY);
  T value;
  
  @CheckReturnValue
  public static <T> AsyncSubject<T> create()
  {
    return new AsyncSubject();
  }
  
  boolean add(AsyncDisposable<T> paramAsyncDisposable)
  {
    return false;
  }
  
  public Throwable getThrowable()
  {
    return null;
  }
  
  public T getValue()
  {
    return null;
  }
  
  @Deprecated
  public Object[] getValues()
  {
    return null;
  }
  
  @Deprecated
  public T[] getValues(T[] paramArrayOfT)
  {
    return null;
  }
  
  public boolean hasComplete()
  {
    return false;
  }
  
  public boolean hasObservers()
  {
    return false;
  }
  
  public boolean hasThrowable()
  {
    return false;
  }
  
  public boolean hasValue()
  {
    return false;
  }
  
  /* Error */
  public void onComplete()
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
  
  /* Error */
  public void onSubscribe(io.reactivex.disposables.Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void remove(AsyncDisposable<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class AsyncDisposable<T>
    extends DeferredScalarDisposable<T>
  {
    private static final long serialVersionUID = 5629876084736248016L;
    final AsyncSubject<T> parent;
    
    AsyncDisposable(Observer<? super T> paramObserver, AsyncSubject<T> paramAsyncSubject)
    {
      super();
      this.parent = paramAsyncSubject;
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\subjects\AsyncSubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */