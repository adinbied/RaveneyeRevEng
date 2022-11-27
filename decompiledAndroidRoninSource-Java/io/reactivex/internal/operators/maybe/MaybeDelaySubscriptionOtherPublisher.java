package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeDelaySubscriptionOtherPublisher<T, U>
  extends AbstractMaybeWithUpstream<T, T>
{
  final Publisher<U> other;
  
  public MaybeDelaySubscriptionOtherPublisher(MaybeSource<T> paramMaybeSource, Publisher<U> paramPublisher)
  {
    super(paramMaybeSource);
    this.other = paramPublisher;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DelayMaybeObserver<T>
    extends AtomicReference<Disposable>
    implements MaybeObserver<T>
  {
    private static final long serialVersionUID = 706635022205076709L;
    final MaybeObserver<? super T> downstream;
    
    DelayMaybeObserver(MaybeObserver<? super T> paramMaybeObserver)
    {
      this.downstream = paramMaybeObserver;
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
  
  static final class OtherSubscriber<T>
    implements FlowableSubscriber<Object>, Disposable
  {
    final MaybeDelaySubscriptionOtherPublisher.DelayMaybeObserver<T> main;
    MaybeSource<T> source;
    Subscription upstream;
    
    OtherSubscriber(MaybeObserver<? super T> paramMaybeObserver, MaybeSource<T> paramMaybeSource)
    {
      this.main = new MaybeDelaySubscriptionOtherPublisher.DelayMaybeObserver(paramMaybeObserver);
      this.source = paramMaybeSource;
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
    public void onNext(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void subscribeNext()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDelaySubscriptionOtherPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */