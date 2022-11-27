package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeEqualSingle<T>
  extends Single<Boolean>
{
  final BiPredicate<? super T, ? super T> isEqual;
  final MaybeSource<? extends T> source1;
  final MaybeSource<? extends T> source2;
  
  public MaybeEqualSingle(MaybeSource<? extends T> paramMaybeSource1, MaybeSource<? extends T> paramMaybeSource2, BiPredicate<? super T, ? super T> paramBiPredicate)
  {
    this.source1 = paramMaybeSource1;
    this.source2 = paramMaybeSource2;
    this.isEqual = paramBiPredicate;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super Boolean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class EqualCoordinator<T>
    extends AtomicInteger
    implements Disposable
  {
    final SingleObserver<? super Boolean> downstream;
    final BiPredicate<? super T, ? super T> isEqual;
    final MaybeEqualSingle.EqualObserver<T> observer1;
    final MaybeEqualSingle.EqualObserver<T> observer2;
    
    EqualCoordinator(SingleObserver<? super Boolean> paramSingleObserver, BiPredicate<? super T, ? super T> paramBiPredicate)
    {
      super();
      this.downstream = paramSingleObserver;
      this.isEqual = paramBiPredicate;
      this.observer1 = new MaybeEqualSingle.EqualObserver(this);
      this.observer2 = new MaybeEqualSingle.EqualObserver(this);
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
    void done()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void error(MaybeEqualSingle.EqualObserver<T> arg1, Throwable arg2)
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
    
    /* Error */
    void subscribe(MaybeSource<? extends T> arg1, MaybeSource<? extends T> arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class EqualObserver<T>
    extends AtomicReference<Disposable>
    implements MaybeObserver<T>
  {
    private static final long serialVersionUID = -3031974433025990931L;
    final MaybeEqualSingle.EqualCoordinator<T> parent;
    Object value;
    
    EqualObserver(MaybeEqualSingle.EqualCoordinator<T> paramEqualCoordinator)
    {
      this.parent = paramEqualCoordinator;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
    }
    
    public void onComplete()
    {
      this.parent.done();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.error(this, paramThrowable);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this, paramDisposable);
    }
    
    public void onSuccess(T paramT)
    {
      this.value = paramT;
      this.parent.done();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeEqualSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */