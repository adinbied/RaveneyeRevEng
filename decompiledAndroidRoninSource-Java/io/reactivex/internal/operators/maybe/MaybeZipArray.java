package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeZipArray<T, R>
  extends Maybe<R>
{
  final MaybeSource<? extends T>[] sources;
  final Function<? super Object[], ? extends R> zipper;
  
  public MaybeZipArray(MaybeSource<? extends T>[] paramArrayOfMaybeSource, Function<? super Object[], ? extends R> paramFunction)
  {
    this.sources = paramArrayOfMaybeSource;
    this.zipper = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class SingletonArrayFunc
    implements Function<T, R>
  {
    SingletonArrayFunc() {}
    
    public R apply(T paramT)
      throws Exception
    {
      return null;
    }
  }
  
  static final class ZipCoordinator<T, R>
    extends AtomicInteger
    implements Disposable
  {
    private static final long serialVersionUID = -5556924161382950569L;
    final MaybeObserver<? super R> downstream;
    final MaybeZipArray.ZipMaybeObserver<T>[] observers;
    final Object[] values;
    final Function<? super Object[], ? extends R> zipper;
    
    ZipCoordinator(MaybeObserver<? super R> paramMaybeObserver, int paramInt, Function<? super Object[], ? extends R> paramFunction)
    {
      super();
      this.downstream = paramMaybeObserver;
      this.zipper = paramFunction;
      paramMaybeObserver = new MaybeZipArray.ZipMaybeObserver[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        paramMaybeObserver[i] = new MaybeZipArray.ZipMaybeObserver(this, i);
        i += 1;
      }
      this.observers = paramMaybeObserver;
      this.values = new Object[paramInt];
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
    void disposeExcept(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerComplete(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerError(Throwable arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerSuccess(T arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isDisposed()
    {
      return false;
    }
  }
  
  static final class ZipMaybeObserver<T>
    extends AtomicReference<Disposable>
    implements MaybeObserver<T>
  {
    private static final long serialVersionUID = 3323743579927613702L;
    final int index;
    final MaybeZipArray.ZipCoordinator<T, ?> parent;
    
    ZipMaybeObserver(MaybeZipArray.ZipCoordinator<T, ?> paramZipCoordinator, int paramInt)
    {
      this.parent = paramZipCoordinator;
      this.index = paramInt;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
    }
    
    public void onComplete()
    {
      this.parent.innerComplete(this.index);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.innerError(paramThrowable, this.index);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this, paramDisposable);
    }
    
    public void onSuccess(T paramT)
    {
      this.parent.innerSuccess(paramT, this.index);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeZipArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */