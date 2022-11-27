package io.reactivex.subjects;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubject
  extends Completable
  implements CompletableObserver
{
  static final CompletableDisposable[] EMPTY = new CompletableDisposable[0];
  static final CompletableDisposable[] TERMINATED = new CompletableDisposable[0];
  Throwable error;
  final AtomicReference<CompletableDisposable[]> observers = new AtomicReference(EMPTY);
  final AtomicBoolean once = new AtomicBoolean();
  
  @CheckReturnValue
  public static CompletableSubject create()
  {
    return new CompletableSubject();
  }
  
  boolean add(CompletableDisposable paramCompletableDisposable)
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
  void remove(CompletableDisposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CompletableDisposable
    extends AtomicReference<CompletableSubject>
    implements Disposable
  {
    private static final long serialVersionUID = -7650903191002190468L;
    final CompletableObserver downstream;
    
    CompletableDisposable(CompletableObserver paramCompletableObserver, CompletableSubject paramCompletableSubject)
    {
      this.downstream = paramCompletableObserver;
      lazySet(paramCompletableSubject);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\subjects\CompletableSubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */