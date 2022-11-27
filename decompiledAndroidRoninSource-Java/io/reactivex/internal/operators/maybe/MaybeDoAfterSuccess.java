package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public final class MaybeDoAfterSuccess<T>
  extends AbstractMaybeWithUpstream<T, T>
{
  final Consumer<? super T> onAfterSuccess;
  
  public MaybeDoAfterSuccess(MaybeSource<T> paramMaybeSource, Consumer<? super T> paramConsumer)
  {
    super(paramMaybeSource);
    this.onAfterSuccess = paramConsumer;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DoAfterObserver<T>
    implements MaybeObserver<T>, Disposable
  {
    final MaybeObserver<? super T> downstream;
    final Consumer<? super T> onAfterSuccess;
    Disposable upstream;
    
    DoAfterObserver(MaybeObserver<? super T> paramMaybeObserver, Consumer<? super T> paramConsumer)
    {
      this.downstream = paramMaybeObserver;
      this.onAfterSuccess = paramConsumer;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
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
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDoAfterSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */