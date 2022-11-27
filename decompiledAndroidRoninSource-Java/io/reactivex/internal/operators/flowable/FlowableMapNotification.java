package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableMapNotification<T, R>
  extends AbstractFlowableWithUpstream<T, R>
{
  final Callable<? extends R> onCompleteSupplier;
  final Function<? super Throwable, ? extends R> onErrorMapper;
  final Function<? super T, ? extends R> onNextMapper;
  
  public FlowableMapNotification(Flowable<T> paramFlowable, Function<? super T, ? extends R> paramFunction, Function<? super Throwable, ? extends R> paramFunction1, Callable<? extends R> paramCallable)
  {
    super(paramFlowable);
    this.onNextMapper = paramFunction;
    this.onErrorMapper = paramFunction1;
    this.onCompleteSupplier = paramCallable;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class MapNotificationSubscriber<T, R>
    extends SinglePostCompleteSubscriber<T, R>
  {
    private static final long serialVersionUID = 2757120512858778108L;
    final Callable<? extends R> onCompleteSupplier;
    final Function<? super Throwable, ? extends R> onErrorMapper;
    final Function<? super T, ? extends R> onNextMapper;
    
    MapNotificationSubscriber(Subscriber<? super R> paramSubscriber, Function<? super T, ? extends R> paramFunction, Function<? super Throwable, ? extends R> paramFunction1, Callable<? extends R> paramCallable)
    {
      super();
      this.onNextMapper = paramFunction;
      this.onErrorMapper = paramFunction1;
      this.onCompleteSupplier = paramCallable;
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
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableMapNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */