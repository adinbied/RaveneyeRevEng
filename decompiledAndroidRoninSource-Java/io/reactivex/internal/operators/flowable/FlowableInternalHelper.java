package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableInternalHelper
{
  private FlowableInternalHelper()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T, U> Function<T, Publisher<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> paramFunction)
  {
    return new FlatMapIntoIterable(paramFunction);
  }
  
  public static <T, U, R> Function<T, Publisher<R>> flatMapWithCombiner(Function<? super T, ? extends Publisher<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
  {
    return new FlatMapWithCombinerOuter(paramBiFunction, paramFunction);
  }
  
  public static <T, U> Function<T, Publisher<T>> itemDelay(Function<? super T, ? extends Publisher<U>> paramFunction)
  {
    return new ItemDelayFunction(paramFunction);
  }
  
  public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> paramFlowable)
  {
    return new ReplayCallable(paramFlowable);
  }
  
  public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> paramFlowable, int paramInt)
  {
    return new BufferedReplayCallable(paramFlowable, paramInt);
  }
  
  public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> paramFlowable, int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return new BufferedTimedReplay(paramFlowable, paramInt, paramLong, paramTimeUnit, paramScheduler);
  }
  
  public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> paramFlowable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return new TimedReplay(paramFlowable, paramLong, paramTimeUnit, paramScheduler);
  }
  
  public static <T, R> Function<Flowable<T>, Publisher<R>> replayFunction(Function<? super Flowable<T>, ? extends Publisher<R>> paramFunction, Scheduler paramScheduler)
  {
    return new ReplayFunction(paramFunction, paramScheduler);
  }
  
  public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> paramBiConsumer)
  {
    return new SimpleBiGenerator(paramBiConsumer);
  }
  
  public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> paramConsumer)
  {
    return new SimpleGenerator(paramConsumer);
  }
  
  public static <T> Action subscriberOnComplete(Subscriber<T> paramSubscriber)
  {
    return new SubscriberOnComplete(paramSubscriber);
  }
  
  public static <T> Consumer<Throwable> subscriberOnError(Subscriber<T> paramSubscriber)
  {
    return new SubscriberOnError(paramSubscriber);
  }
  
  public static <T> Consumer<T> subscriberOnNext(Subscriber<T> paramSubscriber)
  {
    return new SubscriberOnNext(paramSubscriber);
  }
  
  public static <T, R> Function<List<Publisher<? extends T>>, Publisher<? extends R>> zipIterable(Function<? super Object[], ? extends R> paramFunction)
  {
    return new ZipIterableFunction(paramFunction);
  }
  
  static final class BufferedReplayCallable<T>
    implements Callable<ConnectableFlowable<T>>
  {
    private final int bufferSize;
    private final Flowable<T> parent;
    
    BufferedReplayCallable(Flowable<T> paramFlowable, int paramInt)
    {
      this.parent = paramFlowable;
      this.bufferSize = paramInt;
    }
    
    public ConnectableFlowable<T> call()
    {
      return null;
    }
  }
  
  static final class BufferedTimedReplay<T>
    implements Callable<ConnectableFlowable<T>>
  {
    private final int bufferSize;
    private final Flowable<T> parent;
    private final Scheduler scheduler;
    private final long time;
    private final TimeUnit unit;
    
    BufferedTimedReplay(Flowable<T> paramFlowable, int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      this.parent = paramFlowable;
      this.bufferSize = paramInt;
      this.time = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
    }
    
    public ConnectableFlowable<T> call()
    {
      return null;
    }
  }
  
  static final class FlatMapIntoIterable<T, U>
    implements Function<T, Publisher<U>>
  {
    private final Function<? super T, ? extends Iterable<? extends U>> mapper;
    
    FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> paramFunction)
    {
      this.mapper = paramFunction;
    }
    
    public Publisher<U> apply(T paramT)
      throws Exception
    {
      return null;
    }
  }
  
  static final class FlatMapWithCombinerInner<U, R, T>
    implements Function<U, R>
  {
    private final BiFunction<? super T, ? super U, ? extends R> combiner;
    private final T t;
    
    FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> paramBiFunction, T paramT)
    {
      this.combiner = paramBiFunction;
      this.t = paramT;
    }
    
    public R apply(U paramU)
      throws Exception
    {
      return null;
    }
  }
  
  static final class FlatMapWithCombinerOuter<T, R, U>
    implements Function<T, Publisher<R>>
  {
    private final BiFunction<? super T, ? super U, ? extends R> combiner;
    private final Function<? super T, ? extends Publisher<? extends U>> mapper;
    
    FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> paramBiFunction, Function<? super T, ? extends Publisher<? extends U>> paramFunction)
    {
      this.combiner = paramBiFunction;
      this.mapper = paramFunction;
    }
    
    public Publisher<R> apply(T paramT)
      throws Exception
    {
      return null;
    }
  }
  
  static final class ItemDelayFunction<T, U>
    implements Function<T, Publisher<T>>
  {
    final Function<? super T, ? extends Publisher<U>> itemDelay;
    
    ItemDelayFunction(Function<? super T, ? extends Publisher<U>> paramFunction)
    {
      this.itemDelay = paramFunction;
    }
    
    public Publisher<T> apply(T paramT)
      throws Exception
    {
      return null;
    }
  }
  
  static final class ReplayCallable<T>
    implements Callable<ConnectableFlowable<T>>
  {
    private final Flowable<T> parent;
    
    ReplayCallable(Flowable<T> paramFlowable)
    {
      this.parent = paramFlowable;
    }
    
    public ConnectableFlowable<T> call()
    {
      return this.parent.replay();
    }
  }
  
  static final class ReplayFunction<T, R>
    implements Function<Flowable<T>, Publisher<R>>
  {
    private final Scheduler scheduler;
    private final Function<? super Flowable<T>, ? extends Publisher<R>> selector;
    
    ReplayFunction(Function<? super Flowable<T>, ? extends Publisher<R>> paramFunction, Scheduler paramScheduler)
    {
      this.selector = paramFunction;
      this.scheduler = paramScheduler;
    }
    
    public Publisher<R> apply(Flowable<T> paramFlowable)
      throws Exception
    {
      return null;
    }
  }
  
  public static enum RequestMax
    implements Consumer<Subscription>
  {
    static
    {
      RequestMax localRequestMax = new RequestMax("INSTANCE", 0);
      INSTANCE = localRequestMax;
      $VALUES = new RequestMax[] { localRequestMax };
    }
    
    private RequestMax() {}
    
    public void accept(Subscription paramSubscription)
      throws Exception
    {
      paramSubscription.request(Long.MAX_VALUE);
    }
  }
  
  static final class SimpleBiGenerator<T, S>
    implements BiFunction<S, Emitter<T>, S>
  {
    final BiConsumer<S, Emitter<T>> consumer;
    
    SimpleBiGenerator(BiConsumer<S, Emitter<T>> paramBiConsumer)
    {
      this.consumer = paramBiConsumer;
    }
    
    public S apply(S paramS, Emitter<T> paramEmitter)
      throws Exception
    {
      this.consumer.accept(paramS, paramEmitter);
      return paramS;
    }
  }
  
  static final class SimpleGenerator<T, S>
    implements BiFunction<S, Emitter<T>, S>
  {
    final Consumer<Emitter<T>> consumer;
    
    SimpleGenerator(Consumer<Emitter<T>> paramConsumer)
    {
      this.consumer = paramConsumer;
    }
    
    public S apply(S paramS, Emitter<T> paramEmitter)
      throws Exception
    {
      this.consumer.accept(paramEmitter);
      return paramS;
    }
  }
  
  static final class SubscriberOnComplete<T>
    implements Action
  {
    final Subscriber<T> subscriber;
    
    SubscriberOnComplete(Subscriber<T> paramSubscriber)
    {
      this.subscriber = paramSubscriber;
    }
    
    public void run()
      throws Exception
    {
      this.subscriber.onComplete();
    }
  }
  
  static final class SubscriberOnError<T>
    implements Consumer<Throwable>
  {
    final Subscriber<T> subscriber;
    
    SubscriberOnError(Subscriber<T> paramSubscriber)
    {
      this.subscriber = paramSubscriber;
    }
    
    public void accept(Throwable paramThrowable)
      throws Exception
    {
      this.subscriber.onError(paramThrowable);
    }
  }
  
  static final class SubscriberOnNext<T>
    implements Consumer<T>
  {
    final Subscriber<T> subscriber;
    
    SubscriberOnNext(Subscriber<T> paramSubscriber)
    {
      this.subscriber = paramSubscriber;
    }
    
    public void accept(T paramT)
      throws Exception
    {
      this.subscriber.onNext(paramT);
    }
  }
  
  static final class TimedReplay<T>
    implements Callable<ConnectableFlowable<T>>
  {
    private final Flowable<T> parent;
    private final Scheduler scheduler;
    private final long time;
    private final TimeUnit unit;
    
    TimedReplay(Flowable<T> paramFlowable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      this.parent = paramFlowable;
      this.time = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
    }
    
    public ConnectableFlowable<T> call()
    {
      return null;
    }
  }
  
  static final class ZipIterableFunction<T, R>
    implements Function<List<Publisher<? extends T>>, Publisher<? extends R>>
  {
    private final Function<? super Object[], ? extends R> zipper;
    
    ZipIterableFunction(Function<? super Object[], ? extends R> paramFunction)
    {
      this.zipper = paramFunction;
    }
    
    public Publisher<? extends R> apply(List<Publisher<? extends T>> paramList)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableInternalHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */