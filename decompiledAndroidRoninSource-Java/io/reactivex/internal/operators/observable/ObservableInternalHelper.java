package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.ConnectableObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class ObservableInternalHelper
{
  private ObservableInternalHelper()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T, U> Function<T, ObservableSource<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> paramFunction)
  {
    return new FlatMapIntoIterable(paramFunction);
  }
  
  public static <T, U, R> Function<T, ObservableSource<R>> flatMapWithCombiner(Function<? super T, ? extends ObservableSource<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
  {
    return new FlatMapWithCombinerOuter(paramBiFunction, paramFunction);
  }
  
  public static <T, U> Function<T, ObservableSource<T>> itemDelay(Function<? super T, ? extends ObservableSource<U>> paramFunction)
  {
    return new ItemDelayFunction(paramFunction);
  }
  
  public static <T> Action observerOnComplete(Observer<T> paramObserver)
  {
    return new ObserverOnComplete(paramObserver);
  }
  
  public static <T> Consumer<Throwable> observerOnError(Observer<T> paramObserver)
  {
    return new ObserverOnError(paramObserver);
  }
  
  public static <T> Consumer<T> observerOnNext(Observer<T> paramObserver)
  {
    return new ObserverOnNext(paramObserver);
  }
  
  public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> paramObservable)
  {
    return new ReplayCallable(paramObservable);
  }
  
  public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> paramObservable, int paramInt)
  {
    return new BufferedReplayCallable(paramObservable, paramInt);
  }
  
  public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> paramObservable, int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return new BufferedTimedReplayCallable(paramObservable, paramInt, paramLong, paramTimeUnit, paramScheduler);
  }
  
  public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> paramObservable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return new TimedReplayCallable(paramObservable, paramLong, paramTimeUnit, paramScheduler);
  }
  
  public static <T, R> Function<Observable<T>, ObservableSource<R>> replayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> paramFunction, Scheduler paramScheduler)
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
  
  public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> zipIterable(Function<? super Object[], ? extends R> paramFunction)
  {
    return new ZipIterableFunction(paramFunction);
  }
  
  static final class BufferedReplayCallable<T>
    implements Callable<ConnectableObservable<T>>
  {
    private final int bufferSize;
    private final Observable<T> parent;
    
    BufferedReplayCallable(Observable<T> paramObservable, int paramInt)
    {
      this.parent = paramObservable;
      this.bufferSize = paramInt;
    }
    
    public ConnectableObservable<T> call()
    {
      return null;
    }
  }
  
  static final class BufferedTimedReplayCallable<T>
    implements Callable<ConnectableObservable<T>>
  {
    private final int bufferSize;
    private final Observable<T> parent;
    private final Scheduler scheduler;
    private final long time;
    private final TimeUnit unit;
    
    BufferedTimedReplayCallable(Observable<T> paramObservable, int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      this.parent = paramObservable;
      this.bufferSize = paramInt;
      this.time = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
    }
    
    public ConnectableObservable<T> call()
    {
      return null;
    }
  }
  
  static final class FlatMapIntoIterable<T, U>
    implements Function<T, ObservableSource<U>>
  {
    private final Function<? super T, ? extends Iterable<? extends U>> mapper;
    
    FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> paramFunction)
    {
      this.mapper = paramFunction;
    }
    
    public ObservableSource<U> apply(T paramT)
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
    implements Function<T, ObservableSource<R>>
  {
    private final BiFunction<? super T, ? super U, ? extends R> combiner;
    private final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
    
    FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> paramBiFunction, Function<? super T, ? extends ObservableSource<? extends U>> paramFunction)
    {
      this.combiner = paramBiFunction;
      this.mapper = paramFunction;
    }
    
    public ObservableSource<R> apply(T paramT)
      throws Exception
    {
      return null;
    }
  }
  
  static final class ItemDelayFunction<T, U>
    implements Function<T, ObservableSource<T>>
  {
    final Function<? super T, ? extends ObservableSource<U>> itemDelay;
    
    ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> paramFunction)
    {
      this.itemDelay = paramFunction;
    }
    
    public ObservableSource<T> apply(T paramT)
      throws Exception
    {
      return null;
    }
  }
  
  static enum MapToInt
    implements Function<Object, Object>
  {
    static
    {
      MapToInt localMapToInt = new MapToInt("INSTANCE", 0);
      INSTANCE = localMapToInt;
      $VALUES = new MapToInt[] { localMapToInt };
    }
    
    private MapToInt() {}
    
    public Object apply(Object paramObject)
      throws Exception
    {
      return Integer.valueOf(0);
    }
  }
  
  static final class ObserverOnComplete<T>
    implements Action
  {
    final Observer<T> observer;
    
    ObserverOnComplete(Observer<T> paramObserver)
    {
      this.observer = paramObserver;
    }
    
    public void run()
      throws Exception
    {
      this.observer.onComplete();
    }
  }
  
  static final class ObserverOnError<T>
    implements Consumer<Throwable>
  {
    final Observer<T> observer;
    
    ObserverOnError(Observer<T> paramObserver)
    {
      this.observer = paramObserver;
    }
    
    public void accept(Throwable paramThrowable)
      throws Exception
    {
      this.observer.onError(paramThrowable);
    }
  }
  
  static final class ObserverOnNext<T>
    implements Consumer<T>
  {
    final Observer<T> observer;
    
    ObserverOnNext(Observer<T> paramObserver)
    {
      this.observer = paramObserver;
    }
    
    public void accept(T paramT)
      throws Exception
    {
      this.observer.onNext(paramT);
    }
  }
  
  static final class ReplayCallable<T>
    implements Callable<ConnectableObservable<T>>
  {
    private final Observable<T> parent;
    
    ReplayCallable(Observable<T> paramObservable)
    {
      this.parent = paramObservable;
    }
    
    public ConnectableObservable<T> call()
    {
      return this.parent.replay();
    }
  }
  
  static final class ReplayFunction<T, R>
    implements Function<Observable<T>, ObservableSource<R>>
  {
    private final Scheduler scheduler;
    private final Function<? super Observable<T>, ? extends ObservableSource<R>> selector;
    
    ReplayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> paramFunction, Scheduler paramScheduler)
    {
      this.selector = paramFunction;
      this.scheduler = paramScheduler;
    }
    
    public ObservableSource<R> apply(Observable<T> paramObservable)
      throws Exception
    {
      return null;
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
  
  static final class TimedReplayCallable<T>
    implements Callable<ConnectableObservable<T>>
  {
    private final Observable<T> parent;
    private final Scheduler scheduler;
    private final long time;
    private final TimeUnit unit;
    
    TimedReplayCallable(Observable<T> paramObservable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      this.parent = paramObservable;
      this.time = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
    }
    
    public ConnectableObservable<T> call()
    {
      return null;
    }
  }
  
  static final class ZipIterableFunction<T, R>
    implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>>
  {
    private final Function<? super Object[], ? extends R> zipper;
    
    ZipIterableFunction(Function<? super Object[], ? extends R> paramFunction)
    {
      this.zipper = paramFunction;
    }
    
    public ObservableSource<? extends R> apply(List<ObservableSource<? extends T>> paramList)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableInternalHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */