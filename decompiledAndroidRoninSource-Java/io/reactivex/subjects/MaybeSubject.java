package io.reactivex.subjects;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubject<T>
  extends Maybe<T>
  implements MaybeObserver<T>
{
  static final MaybeDisposable[] EMPTY = new MaybeDisposable[0];
  static final MaybeDisposable[] TERMINATED = new MaybeDisposable[0];
  Throwable error;
  final AtomicReference<MaybeDisposable<T>[]> observers = new AtomicReference(EMPTY);
  final AtomicBoolean once = new AtomicBoolean();
  T value;
  
  @CheckReturnValue
  public static <T> MaybeSubject<T> create()
  {
    return new MaybeSubject();
  }
  
  boolean add(MaybeDisposable<T> paramMaybeDisposable)
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
  
  int observerCount()
  {
    return 0;
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
  void remove(MaybeDisposable<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class MaybeDisposable<T>
    extends AtomicReference<MaybeSubject<T>>
    implements Disposable
  {
    private static final long serialVersionUID = -7650903191002190468L;
    final MaybeObserver<? super T> downstream;
    
    MaybeDisposable(MaybeObserver<? super T> paramMaybeObserver, MaybeSubject<T> paramMaybeSubject)
    {
      this.downstream = paramMaybeObserver;
      lazySet(paramMaybeSubject);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\subjects\MaybeSubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */