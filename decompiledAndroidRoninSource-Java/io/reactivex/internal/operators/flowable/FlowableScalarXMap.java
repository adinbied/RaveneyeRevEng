package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableScalarXMap
{
  private FlowableScalarXMap()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T, U> Flowable<U> scalarXMap(T paramT, Function<? super T, ? extends Publisher<? extends U>> paramFunction)
  {
    return RxJavaPlugins.onAssembly(new ScalarXMapFlowable(paramT, paramFunction));
  }
  
  public static <T, R> boolean tryScalarXMapSubscribe(Publisher<T> paramPublisher, Subscriber<? super R> paramSubscriber, Function<? super T, ? extends Publisher<? extends R>> paramFunction)
  {
    if ((paramPublisher instanceof Callable)) {
      try
      {
        paramPublisher = ((Callable)paramPublisher).call();
        if (paramPublisher == null)
        {
          EmptySubscription.complete(paramSubscriber);
          return true;
        }
        try
        {
          paramPublisher = (Publisher)ObjectHelper.requireNonNull(paramFunction.apply(paramPublisher), "The mapper returned a null Publisher");
          if ((paramPublisher instanceof Callable)) {
            try
            {
              paramPublisher = ((Callable)paramPublisher).call();
              if (paramPublisher == null)
              {
                EmptySubscription.complete(paramSubscriber);
                return true;
              }
              paramSubscriber.onSubscribe(new ScalarSubscription(paramSubscriber, paramPublisher));
              return true;
            }
            finally {}
          }
          paramPublisher.subscribe(paramSubscriber);
          return true;
        }
        finally {}
        return false;
      }
      finally
      {
        Exceptions.throwIfFatal(paramPublisher);
        EmptySubscription.error(paramPublisher, paramSubscriber);
        return true;
      }
    }
  }
  
  static final class ScalarXMapFlowable<T, R>
    extends Flowable<R>
  {
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final T value;
    
    ScalarXMapFlowable(T paramT, Function<? super T, ? extends Publisher<? extends R>> paramFunction)
    {
      this.value = paramT;
      this.mapper = paramFunction;
    }
    
    /* Error */
    public void subscribeActual(Subscriber<? super R> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableScalarXMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */