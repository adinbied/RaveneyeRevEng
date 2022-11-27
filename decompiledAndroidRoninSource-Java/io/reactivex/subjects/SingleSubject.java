package io.reactivex.subjects;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubject<T>
  extends Single<T>
  implements SingleObserver<T>
{
  static final SingleDisposable[] EMPTY = new SingleDisposable[0];
  static final SingleDisposable[] TERMINATED = new SingleDisposable[0];
  Throwable error;
  final AtomicReference<SingleDisposable<T>[]> observers = new AtomicReference(EMPTY);
  final AtomicBoolean once = new AtomicBoolean();
  T value;
  
  @CheckReturnValue
  public static <T> SingleSubject<T> create()
  {
    return new SingleSubject();
  }
  
  boolean add(SingleDisposable<T> paramSingleDisposable)
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
  
  int observerCount()
  {
    return 0;
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
  public void onSubscribe(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onSuccess(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void remove(SingleDisposable<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SingleDisposable<T>
    extends AtomicReference<SingleSubject<T>>
    implements Disposable
  {
    private static final long serialVersionUID = -7650903191002190468L;
    final SingleObserver<? super T> downstream;
    
    SingleDisposable(SingleObserver<? super T> paramSingleObserver, SingleSubject<T> paramSingleSubject)
    {
      this.downstream = paramSingleObserver;
      lazySet(paramSingleSubject);
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\subjects\SingleSubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */