package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.util.ArrayListSupplier;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

public final class FlowableToListSingle<T, U extends Collection<? super T>>
  extends Single<U>
  implements FuseToFlowable<U>
{
  final Callable<U> collectionSupplier;
  final Flowable<T> source;
  
  public FlowableToListSingle(Flowable<T> paramFlowable)
  {
    this(paramFlowable, ArrayListSupplier.asCallable());
  }
  
  public FlowableToListSingle(Flowable<T> paramFlowable, Callable<U> paramCallable)
  {
    this.source = paramFlowable;
    this.collectionSupplier = paramCallable;
  }
  
  public Flowable<U> fuseToFlowable()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class ToListSubscriber<T, U extends Collection<? super T>>
    implements FlowableSubscriber<T>, Disposable
  {
    final SingleObserver<? super U> downstream;
    Subscription upstream;
    U value;
    
    ToListSubscriber(SingleObserver<? super U> paramSingleObserver, U paramU)
    {
      this.downstream = paramSingleObserver;
      this.value = paramU;
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
    
    public void onNext(T paramT)
    {
      this.value.add(paramT);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableToListSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */