package io.reactivex.parallel;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.parallel.ParallelFromArray;
import io.reactivex.internal.operators.parallel.ParallelFromPublisher;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class ParallelFlowable<T>
{
  @CheckReturnValue
  public static <T> ParallelFlowable<T> from(Publisher<? extends T> paramPublisher)
  {
    return from(paramPublisher, Runtime.getRuntime().availableProcessors(), Flowable.bufferSize());
  }
  
  @CheckReturnValue
  public static <T> ParallelFlowable<T> from(Publisher<? extends T> paramPublisher, int paramInt)
  {
    return from(paramPublisher, paramInt, Flowable.bufferSize());
  }
  
  @CheckReturnValue
  public static <T> ParallelFlowable<T> from(Publisher<? extends T> paramPublisher, int paramInt1, int paramInt2)
  {
    ObjectHelper.requireNonNull(paramPublisher, "source");
    ObjectHelper.verifyPositive(paramInt1, "parallelism");
    ObjectHelper.verifyPositive(paramInt2, "prefetch");
    return RxJavaPlugins.onAssembly(new ParallelFromPublisher(paramPublisher, paramInt1, paramInt2));
  }
  
  @CheckReturnValue
  public static <T> ParallelFlowable<T> fromArray(Publisher<T>... paramVarArgs)
  {
    if (paramVarArgs.length != 0) {
      return RxJavaPlugins.onAssembly(new ParallelFromArray(paramVarArgs));
    }
    throw new IllegalArgumentException("Zero publishers not supported");
  }
  
  @CheckReturnValue
  public final <R> R as(ParallelFlowableConverter<T, R> paramParallelFlowableConverter)
  {
    return null;
  }
  
  @CheckReturnValue
  public final <C> ParallelFlowable<C> collect(Callable<? extends C> paramCallable, BiConsumer<? super C, ? super T> paramBiConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  public final <U> ParallelFlowable<U> compose(ParallelTransformer<T, U> paramParallelTransformer)
  {
    return null;
  }
  
  @CheckReturnValue
  public final <R> ParallelFlowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction)
  {
    return concatMap(paramFunction, 2);
  }
  
  @CheckReturnValue
  public final <R> ParallelFlowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  public final <R> ParallelFlowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  public final <R> ParallelFlowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> paramFunction, boolean paramBoolean)
  {
    return concatMapDelayError(paramFunction, 2, paramBoolean);
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> doAfterNext(Consumer<? super T> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> doAfterTerminated(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> doOnCancel(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> doOnComplete(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> doOnError(Consumer<Throwable> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> doOnNext(Consumer<? super T> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> doOnNext(Consumer<? super T> paramConsumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> doOnNext(Consumer<? super T> paramConsumer, ParallelFailureHandling paramParallelFailureHandling)
  {
    return null;
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> doOnRequest(LongConsumer paramLongConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> doOnSubscribe(Consumer<? super Subscription> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> filter(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> filter(Predicate<? super T> paramPredicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> filter(Predicate<? super T> paramPredicate, ParallelFailureHandling paramParallelFailureHandling)
  {
    return null;
  }
  
  @CheckReturnValue
  public final <R> ParallelFlowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  public final <R> ParallelFlowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  public final <R> ParallelFlowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  public final <R> ParallelFlowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> paramFunction, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  @CheckReturnValue
  public final <R> ParallelFlowable<R> map(Function<? super T, ? extends R> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  public final <R> ParallelFlowable<R> map(Function<? super T, ? extends R> paramFunction, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  public final <R> ParallelFlowable<R> map(Function<? super T, ? extends R> paramFunction, ParallelFailureHandling paramParallelFailureHandling)
  {
    return null;
  }
  
  public abstract int parallelism();
  
  @CheckReturnValue
  public final Flowable<T> reduce(BiFunction<T, T, T> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  public final <R> ParallelFlowable<R> reduce(Callable<R> paramCallable, BiFunction<R, ? super T, R> paramBiFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> runOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  public final ParallelFlowable<T> runOn(Scheduler paramScheduler, int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> sequential()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> sequential(int paramInt)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> sequentialDelayError()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> sequentialDelayError(int paramInt)
  {
    return null;
  }
  
  @CheckReturnValue
  public final Flowable<T> sorted(Comparator<? super T> paramComparator)
  {
    return sorted(paramComparator, 16);
  }
  
  @CheckReturnValue
  public final Flowable<T> sorted(Comparator<? super T> paramComparator, int paramInt)
  {
    return null;
  }
  
  public abstract void subscribe(Subscriber<? super T>[] paramArrayOfSubscriber);
  
  @CheckReturnValue
  public final <U> U to(Function<? super ParallelFlowable<T>, U> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  public final Flowable<List<T>> toSortedList(Comparator<? super T> paramComparator)
  {
    return toSortedList(paramComparator, 16);
  }
  
  @CheckReturnValue
  public final Flowable<List<T>> toSortedList(Comparator<? super T> paramComparator, int paramInt)
  {
    return null;
  }
  
  protected final boolean validate(Subscriber<?>[] paramArrayOfSubscriber)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\parallel\ParallelFlowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */