package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubscribeOn<T>
  extends AbstractMaybeWithUpstream<T, T>
{
  final Scheduler scheduler;
  
  public MaybeSubscribeOn(MaybeSource<T> paramMaybeSource, Scheduler paramScheduler)
  {
    super(paramMaybeSource);
    this.scheduler = paramScheduler;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SubscribeOnMaybeObserver<T>
    extends AtomicReference<Disposable>
    implements MaybeObserver<T>, Disposable
  {
    private static final long serialVersionUID = 8571289934935992137L;
    final MaybeObserver<? super T> downstream;
    final SequentialDisposable task;
    
    SubscribeOnMaybeObserver(MaybeObserver<? super T> paramMaybeObserver)
    {
      this.downstream = paramMaybeObserver;
      this.task = new SequentialDisposable();
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
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this, paramDisposable);
    }
    
    public void onSuccess(T paramT)
    {
      this.downstream.onSuccess(paramT);
    }
  }
  
  static final class SubscribeTask<T>
    implements Runnable
  {
    final MaybeObserver<? super T> observer;
    final MaybeSource<T> source;
    
    SubscribeTask(MaybeObserver<? super T> paramMaybeObserver, MaybeSource<T> paramMaybeSource)
    {
      this.observer = paramMaybeObserver;
      this.source = paramMaybeSource;
    }
    
    public void run()
    {
      this.source.subscribe(this.observer);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeSubscribeOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */