package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.BlockingSubscriber;
import io.reactivex.internal.subscribers.BoundedSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.BlockingIgnoringReceiver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableBlockingSubscribe
{
  private FlowableBlockingSubscribe()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> void subscribe(Publisher<? extends T> paramPublisher)
  {
    BlockingIgnoringReceiver localBlockingIgnoringReceiver = new BlockingIgnoringReceiver();
    LambdaSubscriber localLambdaSubscriber = new LambdaSubscriber(Functions.emptyConsumer(), localBlockingIgnoringReceiver, localBlockingIgnoringReceiver, Functions.REQUEST_MAX);
    paramPublisher.subscribe(localLambdaSubscriber);
    BlockingHelper.awaitForComplete(localBlockingIgnoringReceiver, localLambdaSubscriber);
    paramPublisher = localBlockingIgnoringReceiver.error;
    if (paramPublisher == null) {
      return;
    }
    throw ExceptionHelper.wrapOrThrow(paramPublisher);
  }
  
  public static <T> void subscribe(Publisher<? extends T> paramPublisher, Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction)
  {
    ObjectHelper.requireNonNull(paramConsumer, "onNext is null");
    ObjectHelper.requireNonNull(paramConsumer1, "onError is null");
    ObjectHelper.requireNonNull(paramAction, "onComplete is null");
    subscribe(paramPublisher, new LambdaSubscriber(paramConsumer, paramConsumer1, paramAction, Functions.REQUEST_MAX));
  }
  
  public static <T> void subscribe(Publisher<? extends T> paramPublisher, Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction, int paramInt)
  {
    ObjectHelper.requireNonNull(paramConsumer, "onNext is null");
    ObjectHelper.requireNonNull(paramConsumer1, "onError is null");
    ObjectHelper.requireNonNull(paramAction, "onComplete is null");
    ObjectHelper.verifyPositive(paramInt, "number > 0 required");
    subscribe(paramPublisher, new BoundedSubscriber(paramConsumer, paramConsumer1, paramAction, Functions.boundedConsumer(paramInt), paramInt));
  }
  
  public static <T> void subscribe(Publisher<? extends T> paramPublisher, Subscriber<? super T> paramSubscriber)
  {
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue();
    BlockingSubscriber localBlockingSubscriber = new BlockingSubscriber(localLinkedBlockingQueue);
    paramPublisher.subscribe(localBlockingSubscriber);
    try
    {
      boolean bool;
      do
      {
        if (localBlockingSubscriber.isCancelled()) {
          return;
        }
        Object localObject = localLinkedBlockingQueue.poll();
        paramPublisher = (Publisher<? extends T>)localObject;
        if (localObject == null)
        {
          if (localBlockingSubscriber.isCancelled()) {
            return;
          }
          BlockingHelper.verifyNonBlocking();
          paramPublisher = localLinkedBlockingQueue.take();
        }
        if (localBlockingSubscriber.isCancelled()) {
          return;
        }
        if (paramPublisher == BlockingSubscriber.TERMINATED) {
          break;
        }
        bool = NotificationLite.acceptFull(paramPublisher, paramSubscriber);
      } while (!bool);
      return;
    }
    catch (InterruptedException paramPublisher)
    {
      localBlockingSubscriber.cancel();
      paramSubscriber.onError(paramPublisher);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableBlockingSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */