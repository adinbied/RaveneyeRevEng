package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleZipArray<T, R>
  extends Single<R>
{
  final SingleSource<? extends T>[] sources;
  final Function<? super Object[], ? extends R> zipper;
  
  public SingleZipArray(SingleSource<? extends T>[] paramArrayOfSingleSource, Function<? super Object[], ? extends R> paramFunction)
  {
    this.sources = paramArrayOfSingleSource;
    this.zipper = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super R> arg1)
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
    final SingleObserver<? super R> downstream;
    final SingleZipArray.ZipSingleObserver<T>[] observers;
    final Object[] values;
    final Function<? super Object[], ? extends R> zipper;
    
    ZipCoordinator(SingleObserver<? super R> paramSingleObserver, int paramInt, Function<? super Object[], ? extends R> paramFunction)
    {
      super();
      this.downstream = paramSingleObserver;
      this.zipper = paramFunction;
      paramSingleObserver = new SingleZipArray.ZipSingleObserver[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        paramSingleObserver[i] = new SingleZipArray.ZipSingleObserver(this, i);
        i += 1;
      }
      this.observers = paramSingleObserver;
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
  
  static final class ZipSingleObserver<T>
    extends AtomicReference<Disposable>
    implements SingleObserver<T>
  {
    private static final long serialVersionUID = 3323743579927613702L;
    final int index;
    final SingleZipArray.ZipCoordinator<T, ?> parent;
    
    ZipSingleObserver(SingleZipArray.ZipCoordinator<T, ?> paramZipCoordinator, int paramInt)
    {
      this.parent = paramZipCoordinator;
      this.index = paramInt;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleZipArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */