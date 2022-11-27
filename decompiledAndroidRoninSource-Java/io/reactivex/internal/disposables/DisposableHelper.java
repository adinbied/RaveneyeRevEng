package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public enum DisposableHelper
  implements Disposable
{
  static
  {
    DisposableHelper localDisposableHelper = new DisposableHelper("DISPOSED", 0);
    DISPOSED = localDisposableHelper;
    $VALUES = new DisposableHelper[] { localDisposableHelper };
  }
  
  private DisposableHelper() {}
  
  public static boolean dispose(AtomicReference<Disposable> paramAtomicReference)
  {
    Disposable localDisposable = (Disposable)paramAtomicReference.get();
    DisposableHelper localDisposableHelper = DISPOSED;
    if (localDisposable != localDisposableHelper)
    {
      paramAtomicReference = (Disposable)paramAtomicReference.getAndSet(localDisposableHelper);
      if (paramAtomicReference != localDisposableHelper)
      {
        if (paramAtomicReference != null) {
          paramAtomicReference.dispose();
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean isDisposed(Disposable paramDisposable)
  {
    return paramDisposable == DISPOSED;
  }
  
  public static boolean replace(AtomicReference<Disposable> paramAtomicReference, Disposable paramDisposable)
  {
    Disposable localDisposable;
    do
    {
      localDisposable = (Disposable)paramAtomicReference.get();
      if (localDisposable == DISPOSED)
      {
        if (paramDisposable != null) {
          paramDisposable.dispose();
        }
        return false;
      }
    } while (!paramAtomicReference.compareAndSet(localDisposable, paramDisposable));
    return true;
  }
  
  public static void reportDisposableSet()
  {
    RxJavaPlugins.onError(new ProtocolViolationException("Disposable already set!"));
  }
  
  public static boolean set(AtomicReference<Disposable> paramAtomicReference, Disposable paramDisposable)
  {
    Disposable localDisposable;
    do
    {
      localDisposable = (Disposable)paramAtomicReference.get();
      if (localDisposable == DISPOSED)
      {
        if (paramDisposable != null) {
          paramDisposable.dispose();
        }
        return false;
      }
    } while (!paramAtomicReference.compareAndSet(localDisposable, paramDisposable));
    if (localDisposable != null) {
      localDisposable.dispose();
    }
    return true;
  }
  
  public static boolean setOnce(AtomicReference<Disposable> paramAtomicReference, Disposable paramDisposable)
  {
    ObjectHelper.requireNonNull(paramDisposable, "d is null");
    if (!paramAtomicReference.compareAndSet(null, paramDisposable))
    {
      paramDisposable.dispose();
      if (paramAtomicReference.get() != DISPOSED) {
        reportDisposableSet();
      }
      return false;
    }
    return true;
  }
  
  public static boolean trySet(AtomicReference<Disposable> paramAtomicReference, Disposable paramDisposable)
  {
    if (!paramAtomicReference.compareAndSet(null, paramDisposable))
    {
      if (paramAtomicReference.get() == DISPOSED) {
        paramDisposable.dispose();
      }
      return false;
    }
    return true;
  }
  
  public static boolean validate(Disposable paramDisposable1, Disposable paramDisposable2)
  {
    if (paramDisposable2 == null)
    {
      RxJavaPlugins.onError(new NullPointerException("next is null"));
      return false;
    }
    if (paramDisposable1 != null)
    {
      paramDisposable2.dispose();
      reportDisposableSet();
      return false;
    }
    return true;
  }
  
  public void dispose() {}
  
  public boolean isDisposed()
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\disposables\DisposableHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */