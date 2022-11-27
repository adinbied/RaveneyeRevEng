package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public final class MaybePeek<T>
  extends AbstractMaybeWithUpstream<T, T>
{
  final Action onAfterTerminate;
  final Action onCompleteCall;
  final Action onDisposeCall;
  final Consumer<? super Throwable> onErrorCall;
  final Consumer<? super Disposable> onSubscribeCall;
  final Consumer<? super T> onSuccessCall;
  
  public MaybePeek(MaybeSource<T> paramMaybeSource, Consumer<? super Disposable> paramConsumer, Consumer<? super T> paramConsumer1, Consumer<? super Throwable> paramConsumer2, Action paramAction1, Action paramAction2, Action paramAction3)
  {
    super(paramMaybeSource);
    this.onSubscribeCall = paramConsumer;
    this.onSuccessCall = paramConsumer1;
    this.onErrorCall = paramConsumer2;
    this.onCompleteCall = paramAction1;
    this.onAfterTerminate = paramAction2;
    this.onDisposeCall = paramAction3;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class MaybePeekObserver<T>
    implements MaybeObserver<T>, Disposable
  {
    final MaybeObserver<? super T> downstream;
    final MaybePeek<T> parent;
    Disposable upstream;
    
    MaybePeekObserver(MaybeObserver<? super T> paramMaybeObserver, MaybePeek<T> paramMaybePeek)
    {
      this.downstream = paramMaybeObserver;
      this.parent = paramMaybePeek;
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
    }
    
    /* Error */
    void onAfterTerminate()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void onErrorInner(Throwable arg1)
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
      //   2: return
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybePeek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */