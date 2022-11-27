package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;

public final class MaybeDoOnEvent<T>
  extends AbstractMaybeWithUpstream<T, T>
{
  final BiConsumer<? super T, ? super Throwable> onEvent;
  
  public MaybeDoOnEvent(MaybeSource<T> paramMaybeSource, BiConsumer<? super T, ? super Throwable> paramBiConsumer)
  {
    super(paramMaybeSource);
    this.onEvent = paramBiConsumer;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DoOnEventMaybeObserver<T>
    implements MaybeObserver<T>, Disposable
  {
    final MaybeObserver<? super T> downstream;
    final BiConsumer<? super T, ? super Throwable> onEvent;
    Disposable upstream;
    
    DoOnEventMaybeObserver(MaybeObserver<? super T> paramMaybeObserver, BiConsumer<? super T, ? super Throwable> paramBiConsumer)
    {
      this.downstream = paramMaybeObserver;
      this.onEvent = paramBiConsumer;
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
      return this.upstream.isDisposed();
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDoOnEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */