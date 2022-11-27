package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import java.util.concurrent.atomic.AtomicInteger;

public final class MaybeDoFinally<T>
  extends AbstractMaybeWithUpstream<T, T>
{
  final Action onFinally;
  
  public MaybeDoFinally(MaybeSource<T> paramMaybeSource, Action paramAction)
  {
    super(paramMaybeSource);
    this.onFinally = paramAction;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DoFinallyObserver<T>
    extends AtomicInteger
    implements MaybeObserver<T>, Disposable
  {
    private static final long serialVersionUID = 4109457741734051389L;
    final MaybeObserver<? super T> downstream;
    final Action onFinally;
    Disposable upstream;
    
    DoFinallyObserver(MaybeObserver<? super T> paramMaybeObserver, Action paramAction)
    {
      this.downstream = paramMaybeObserver;
      this.onFinally = paramAction;
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
    void runFinally()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDoFinally.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */