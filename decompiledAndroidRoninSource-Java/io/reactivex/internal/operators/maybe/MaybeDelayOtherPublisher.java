package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeDelayOtherPublisher<T, U>
  extends AbstractMaybeWithUpstream<T, T>
{
  final Publisher<U> other;
  
  public MaybeDelayOtherPublisher(MaybeSource<T> paramMaybeSource, Publisher<U> paramPublisher)
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
  
  static final class DelayMaybeObserver<T, U>
    implements MaybeObserver<T>, Disposable
  {
    final MaybeDelayOtherPublisher.OtherSubscriber<T> other;
    final Publisher<U> otherSource;
    Disposable upstream;
    
    DelayMaybeObserver(MaybeObserver<? super T> paramMaybeObserver, Publisher<U> paramPublisher)
    {
      this.other = new MaybeDelayOtherPublisher.OtherSubscriber(paramMaybeObserver);
      this.otherSource = paramPublisher;
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
      this.upstream = DisposableHelper.DISPOSED;
      subscribeNext();
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
    
    void subscribeNext()
    {
      this.otherSource.subscribe(this.other);
    }
  }
  
  static final class OtherSubscriber<T>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<Object>
  {
    private static final long serialVersionUID = -1215060610805418006L;
    final MaybeObserver<? super T> downstream;
    Throwable error;
    T value;
    
    OtherSubscriber(MaybeObserver<? super T> paramMaybeObserver)
    {
      this.downstream = paramMaybeObserver;
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDelayOtherPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */