package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class PublishSubject<T>
  extends Subject<T>
{
  static final PublishDisposable[] EMPTY = new PublishDisposable[0];
  static final PublishDisposable[] TERMINATED = new PublishDisposable[0];
  Throwable error;
  final AtomicReference<PublishDisposable<T>[]> subscribers = new AtomicReference(EMPTY);
  
  @CheckReturnValue
  public static <T> PublishSubject<T> create()
  {
    return new PublishSubject();
  }
  
  boolean add(PublishDisposable<T> paramPublishDisposable)
  {
    return false;
  }
  
  public Throwable getThrowable()
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
  public void onSubscribe(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void remove(PublishDisposable<T> arg1)
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
  
  static final class PublishDisposable<T>
    extends AtomicBoolean
    implements Disposable
  {
    private static final long serialVersionUID = 3562861878281475070L;
    final Observer<? super T> downstream;
    final PublishSubject<T> parent;
    
    PublishDisposable(Observer<? super T> paramObserver, PublishSubject<T> paramPublishSubject)
    {
      this.downstream = paramObserver;
      this.parent = paramPublishSubject;
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
      return get();
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\subjects\PublishSubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */