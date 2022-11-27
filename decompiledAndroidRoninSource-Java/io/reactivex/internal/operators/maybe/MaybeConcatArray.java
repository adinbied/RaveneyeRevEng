package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatArray<T>
  extends Flowable<T>
{
  final MaybeSource<? extends T>[] sources;
  
  public MaybeConcatArray(MaybeSource<? extends T>[] paramArrayOfMaybeSource)
  {
    this.sources = paramArrayOfMaybeSource;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ConcatMaybeObserver<T>
    extends AtomicInteger
    implements MaybeObserver<T>, Subscription
  {
    private static final long serialVersionUID = 3520831347801429610L;
    final AtomicReference<Object> current;
    final SequentialDisposable disposables;
    final Subscriber<? super T> downstream;
    int index;
    long produced;
    final AtomicLong requested;
    final MaybeSource<? extends T>[] sources;
    
    ConcatMaybeObserver(Subscriber<? super T> paramSubscriber, MaybeSource<? extends T>[] paramArrayOfMaybeSource)
    {
      this.downstream = paramSubscriber;
      this.sources = paramArrayOfMaybeSource;
      this.requested = new AtomicLong();
      this.disposables = new SequentialDisposable();
      this.current = new AtomicReference(NotificationLite.COMPLETE);
    }
    
    public void cancel()
    {
      this.disposables.dispose();
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.disposables.replace(paramDisposable);
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
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeConcatArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */