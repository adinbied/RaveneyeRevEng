package io.reactivex;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.single.SingleAmb;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleDefer;
import io.reactivex.internal.operators.single.SingleEquals;
import io.reactivex.internal.operators.single.SingleError;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFromCallable;
import io.reactivex.internal.operators.single.SingleFromPublisher;
import io.reactivex.internal.operators.single.SingleFromUnsafeSource;
import io.reactivex.internal.operators.single.SingleInternalHelper;
import io.reactivex.internal.operators.single.SingleJust;
import io.reactivex.internal.operators.single.SingleNever;
import io.reactivex.internal.operators.single.SingleTimer;
import io.reactivex.internal.operators.single.SingleUsing;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.internal.operators.single.SingleZipIterable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

public abstract class Single<T>
  implements SingleSource<T>
{
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> amb(Iterable<? extends SingleSource<? extends T>> paramIterable)
  {
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    return RxJavaPlugins.onAssembly(new SingleAmb(null, paramIterable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> ambArray(SingleSource<? extends T>... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return error(SingleInternalHelper.emptyThrower());
    }
    if (paramVarArgs.length == 1) {
      return wrap(paramVarArgs[0]);
    }
    return RxJavaPlugins.onAssembly(new SingleAmb(paramVarArgs, null));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concat(SingleSource<? extends T> paramSingleSource1, SingleSource<? extends T> paramSingleSource2)
  {
    ObjectHelper.requireNonNull(paramSingleSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source2 is null");
    return concat(Flowable.fromArray(new SingleSource[] { paramSingleSource1, paramSingleSource2 }));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concat(SingleSource<? extends T> paramSingleSource1, SingleSource<? extends T> paramSingleSource2, SingleSource<? extends T> paramSingleSource3)
  {
    ObjectHelper.requireNonNull(paramSingleSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source2 is null");
    ObjectHelper.requireNonNull(paramSingleSource3, "source3 is null");
    return concat(Flowable.fromArray(new SingleSource[] { paramSingleSource1, paramSingleSource2, paramSingleSource3 }));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concat(SingleSource<? extends T> paramSingleSource1, SingleSource<? extends T> paramSingleSource2, SingleSource<? extends T> paramSingleSource3, SingleSource<? extends T> paramSingleSource4)
  {
    ObjectHelper.requireNonNull(paramSingleSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source2 is null");
    ObjectHelper.requireNonNull(paramSingleSource3, "source3 is null");
    ObjectHelper.requireNonNull(paramSingleSource4, "source4 is null");
    return concat(Flowable.fromArray(new SingleSource[] { paramSingleSource1, paramSingleSource2, paramSingleSource3, paramSingleSource4 }));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concat(Iterable<? extends SingleSource<? extends T>> paramIterable)
  {
    return concat(Flowable.fromIterable(paramIterable));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concat(Publisher<? extends SingleSource<? extends T>> paramPublisher)
  {
    return concat(paramPublisher, 2);
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concat(Publisher<? extends SingleSource<? extends T>> paramPublisher, int paramInt)
  {
    ObjectHelper.requireNonNull(paramPublisher, "sources is null");
    ObjectHelper.verifyPositive(paramInt, "prefetch");
    return RxJavaPlugins.onAssembly(new FlowableConcatMapPublisher(paramPublisher, SingleInternalHelper.toFlowable(), paramInt, ErrorMode.IMMEDIATE));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Observable<T> concat(ObservableSource<? extends SingleSource<? extends T>> paramObservableSource)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "sources is null");
    return RxJavaPlugins.onAssembly(new ObservableConcatMap(paramObservableSource, SingleInternalHelper.toObservable(), 2, ErrorMode.IMMEDIATE));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatArray(SingleSource<? extends T>... paramVarArgs)
  {
    return RxJavaPlugins.onAssembly(new FlowableConcatMap(Flowable.fromArray(paramVarArgs), SingleInternalHelper.toFlowable(), 2, ErrorMode.BOUNDARY));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatArrayEager(SingleSource<? extends T>... paramVarArgs)
  {
    return Flowable.fromArray(paramVarArgs).concatMapEager(SingleInternalHelper.toFlowable());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatEager(Iterable<? extends SingleSource<? extends T>> paramIterable)
  {
    return Flowable.fromIterable(paramIterable).concatMapEager(SingleInternalHelper.toFlowable());
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> concatEager(Publisher<? extends SingleSource<? extends T>> paramPublisher)
  {
    return Flowable.fromPublisher(paramPublisher).concatMapEager(SingleInternalHelper.toFlowable());
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> create(SingleOnSubscribe<T> paramSingleOnSubscribe)
  {
    ObjectHelper.requireNonNull(paramSingleOnSubscribe, "source is null");
    return RxJavaPlugins.onAssembly(new SingleCreate(paramSingleOnSubscribe));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> defer(Callable<? extends SingleSource<? extends T>> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "singleSupplier is null");
    return RxJavaPlugins.onAssembly(new SingleDefer(paramCallable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<Boolean> equals(SingleSource<? extends T> paramSingleSource1, SingleSource<? extends T> paramSingleSource2)
  {
    ObjectHelper.requireNonNull(paramSingleSource1, "first is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "second is null");
    return RxJavaPlugins.onAssembly(new SingleEquals(paramSingleSource1, paramSingleSource2));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> error(Throwable paramThrowable)
  {
    ObjectHelper.requireNonNull(paramThrowable, "exception is null");
    return error(Functions.justCallable(paramThrowable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> error(Callable<? extends Throwable> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "errorSupplier is null");
    return RxJavaPlugins.onAssembly(new SingleError(paramCallable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> fromCallable(Callable<? extends T> paramCallable)
  {
    ObjectHelper.requireNonNull(paramCallable, "callable is null");
    return RxJavaPlugins.onAssembly(new SingleFromCallable(paramCallable));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> fromFuture(Future<? extends T> paramFuture)
  {
    return toSingle(Flowable.fromFuture(paramFuture));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> fromFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    return toSingle(Flowable.fromFuture(paramFuture, paramLong, paramTimeUnit));
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static <T> Single<T> fromFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return toSingle(Flowable.fromFuture(paramFuture, paramLong, paramTimeUnit, paramScheduler));
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static <T> Single<T> fromFuture(Future<? extends T> paramFuture, Scheduler paramScheduler)
  {
    return toSingle(Flowable.fromFuture(paramFuture, paramScheduler));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> fromObservable(ObservableSource<? extends T> paramObservableSource)
  {
    ObjectHelper.requireNonNull(paramObservableSource, "observableSource is null");
    return RxJavaPlugins.onAssembly(new ObservableSingleSingle(paramObservableSource, null));
  }
  
  @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> fromPublisher(Publisher<? extends T> paramPublisher)
  {
    ObjectHelper.requireNonNull(paramPublisher, "publisher is null");
    return RxJavaPlugins.onAssembly(new SingleFromPublisher(paramPublisher));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> just(T paramT)
  {
    ObjectHelper.requireNonNull(paramT, "item is null");
    return RxJavaPlugins.onAssembly(new SingleJust(paramT));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> merge(SingleSource<? extends T> paramSingleSource1, SingleSource<? extends T> paramSingleSource2)
  {
    ObjectHelper.requireNonNull(paramSingleSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source2 is null");
    return merge(Flowable.fromArray(new SingleSource[] { paramSingleSource1, paramSingleSource2 }));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> merge(SingleSource<? extends T> paramSingleSource1, SingleSource<? extends T> paramSingleSource2, SingleSource<? extends T> paramSingleSource3)
  {
    ObjectHelper.requireNonNull(paramSingleSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source2 is null");
    ObjectHelper.requireNonNull(paramSingleSource3, "source3 is null");
    return merge(Flowable.fromArray(new SingleSource[] { paramSingleSource1, paramSingleSource2, paramSingleSource3 }));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> merge(SingleSource<? extends T> paramSingleSource1, SingleSource<? extends T> paramSingleSource2, SingleSource<? extends T> paramSingleSource3, SingleSource<? extends T> paramSingleSource4)
  {
    ObjectHelper.requireNonNull(paramSingleSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source2 is null");
    ObjectHelper.requireNonNull(paramSingleSource3, "source3 is null");
    ObjectHelper.requireNonNull(paramSingleSource4, "source4 is null");
    return merge(Flowable.fromArray(new SingleSource[] { paramSingleSource1, paramSingleSource2, paramSingleSource3, paramSingleSource4 }));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> merge(Iterable<? extends SingleSource<? extends T>> paramIterable)
  {
    return merge(Flowable.fromIterable(paramIterable));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> merge(Publisher<? extends SingleSource<? extends T>> paramPublisher)
  {
    ObjectHelper.requireNonNull(paramPublisher, "sources is null");
    return RxJavaPlugins.onAssembly(new FlowableFlatMapPublisher(paramPublisher, SingleInternalHelper.toFlowable(), false, Integer.MAX_VALUE, Flowable.bufferSize()));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> merge(SingleSource<? extends SingleSource<? extends T>> paramSingleSource)
  {
    ObjectHelper.requireNonNull(paramSingleSource, "source is null");
    return RxJavaPlugins.onAssembly(new SingleFlatMap(paramSingleSource, Functions.identity()));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> paramSingleSource1, SingleSource<? extends T> paramSingleSource2)
  {
    ObjectHelper.requireNonNull(paramSingleSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source2 is null");
    return mergeDelayError(Flowable.fromArray(new SingleSource[] { paramSingleSource1, paramSingleSource2 }));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> paramSingleSource1, SingleSource<? extends T> paramSingleSource2, SingleSource<? extends T> paramSingleSource3)
  {
    ObjectHelper.requireNonNull(paramSingleSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source2 is null");
    ObjectHelper.requireNonNull(paramSingleSource3, "source3 is null");
    return mergeDelayError(Flowable.fromArray(new SingleSource[] { paramSingleSource1, paramSingleSource2, paramSingleSource3 }));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> paramSingleSource1, SingleSource<? extends T> paramSingleSource2, SingleSource<? extends T> paramSingleSource3, SingleSource<? extends T> paramSingleSource4)
  {
    ObjectHelper.requireNonNull(paramSingleSource1, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source2 is null");
    ObjectHelper.requireNonNull(paramSingleSource3, "source3 is null");
    ObjectHelper.requireNonNull(paramSingleSource4, "source4 is null");
    return mergeDelayError(Flowable.fromArray(new SingleSource[] { paramSingleSource1, paramSingleSource2, paramSingleSource3, paramSingleSource4 }));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeDelayError(Iterable<? extends SingleSource<? extends T>> paramIterable)
  {
    return mergeDelayError(Flowable.fromIterable(paramIterable));
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Flowable<T> mergeDelayError(Publisher<? extends SingleSource<? extends T>> paramPublisher)
  {
    ObjectHelper.requireNonNull(paramPublisher, "sources is null");
    return RxJavaPlugins.onAssembly(new FlowableFlatMapPublisher(paramPublisher, SingleInternalHelper.toFlowable(), true, Integer.MAX_VALUE, Flowable.bufferSize()));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> never()
  {
    return RxJavaPlugins.onAssembly(SingleNever.INSTANCE);
  }
  
  private Single<T> timeout0(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, SingleSource<? extends T> paramSingleSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public static Single<Long> timer(long paramLong, TimeUnit paramTimeUnit)
  {
    return timer(paramLong, paramTimeUnit, Schedulers.computation());
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public static Single<Long> timer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    ObjectHelper.requireNonNull(paramTimeUnit, "unit is null");
    ObjectHelper.requireNonNull(paramScheduler, "scheduler is null");
    return RxJavaPlugins.onAssembly(new SingleTimer(paramLong, paramTimeUnit, paramScheduler));
  }
  
  private static <T> Single<T> toSingle(Flowable<T> paramFlowable)
  {
    return RxJavaPlugins.onAssembly(new FlowableSingleSingle(paramFlowable, null));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> unsafeCreate(SingleSource<T> paramSingleSource)
  {
    ObjectHelper.requireNonNull(paramSingleSource, "onSubscribe is null");
    if (!(paramSingleSource instanceof Single)) {
      return RxJavaPlugins.onAssembly(new SingleFromUnsafeSource(paramSingleSource));
    }
    throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, U> Single<T> using(Callable<U> paramCallable, Function<? super U, ? extends SingleSource<? extends T>> paramFunction, Consumer<? super U> paramConsumer)
  {
    return using(paramCallable, paramFunction, paramConsumer, true);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, U> Single<T> using(Callable<U> paramCallable, Function<? super U, ? extends SingleSource<? extends T>> paramFunction, Consumer<? super U> paramConsumer, boolean paramBoolean)
  {
    ObjectHelper.requireNonNull(paramCallable, "resourceSupplier is null");
    ObjectHelper.requireNonNull(paramFunction, "singleFunction is null");
    ObjectHelper.requireNonNull(paramConsumer, "disposer is null");
    return RxJavaPlugins.onAssembly(new SingleUsing(paramCallable, paramFunction, paramConsumer, paramBoolean));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T> Single<T> wrap(SingleSource<T> paramSingleSource)
  {
    ObjectHelper.requireNonNull(paramSingleSource, "source is null");
    if ((paramSingleSource instanceof Single)) {
      return RxJavaPlugins.onAssembly((Single)paramSingleSource);
    }
    return RxJavaPlugins.onAssembly(new SingleFromUnsafeSource(paramSingleSource));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> zip(SingleSource<? extends T1> paramSingleSource, SingleSource<? extends T2> paramSingleSource1, SingleSource<? extends T3> paramSingleSource2, SingleSource<? extends T4> paramSingleSource3, SingleSource<? extends T5> paramSingleSource4, SingleSource<? extends T6> paramSingleSource5, SingleSource<? extends T7> paramSingleSource6, SingleSource<? extends T8> paramSingleSource7, SingleSource<? extends T9> paramSingleSource8, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> paramFunction9)
  {
    ObjectHelper.requireNonNull(paramSingleSource, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramSingleSource3, "source4 is null");
    ObjectHelper.requireNonNull(paramSingleSource4, "source5 is null");
    ObjectHelper.requireNonNull(paramSingleSource5, "source6 is null");
    ObjectHelper.requireNonNull(paramSingleSource6, "source7 is null");
    ObjectHelper.requireNonNull(paramSingleSource7, "source8 is null");
    ObjectHelper.requireNonNull(paramSingleSource8, "source9 is null");
    return zipArray(Functions.toFunction(paramFunction9), new SingleSource[] { paramSingleSource, paramSingleSource1, paramSingleSource2, paramSingleSource3, paramSingleSource4, paramSingleSource5, paramSingleSource6, paramSingleSource7, paramSingleSource8 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> zip(SingleSource<? extends T1> paramSingleSource, SingleSource<? extends T2> paramSingleSource1, SingleSource<? extends T3> paramSingleSource2, SingleSource<? extends T4> paramSingleSource3, SingleSource<? extends T5> paramSingleSource4, SingleSource<? extends T6> paramSingleSource5, SingleSource<? extends T7> paramSingleSource6, SingleSource<? extends T8> paramSingleSource7, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> paramFunction8)
  {
    ObjectHelper.requireNonNull(paramSingleSource, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramSingleSource3, "source4 is null");
    ObjectHelper.requireNonNull(paramSingleSource4, "source5 is null");
    ObjectHelper.requireNonNull(paramSingleSource5, "source6 is null");
    ObjectHelper.requireNonNull(paramSingleSource6, "source7 is null");
    ObjectHelper.requireNonNull(paramSingleSource7, "source8 is null");
    return zipArray(Functions.toFunction(paramFunction8), new SingleSource[] { paramSingleSource, paramSingleSource1, paramSingleSource2, paramSingleSource3, paramSingleSource4, paramSingleSource5, paramSingleSource6, paramSingleSource7 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, T7, R> Single<R> zip(SingleSource<? extends T1> paramSingleSource, SingleSource<? extends T2> paramSingleSource1, SingleSource<? extends T3> paramSingleSource2, SingleSource<? extends T4> paramSingleSource3, SingleSource<? extends T5> paramSingleSource4, SingleSource<? extends T6> paramSingleSource5, SingleSource<? extends T7> paramSingleSource6, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> paramFunction7)
  {
    ObjectHelper.requireNonNull(paramSingleSource, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramSingleSource3, "source4 is null");
    ObjectHelper.requireNonNull(paramSingleSource4, "source5 is null");
    ObjectHelper.requireNonNull(paramSingleSource5, "source6 is null");
    ObjectHelper.requireNonNull(paramSingleSource6, "source7 is null");
    return zipArray(Functions.toFunction(paramFunction7), new SingleSource[] { paramSingleSource, paramSingleSource1, paramSingleSource2, paramSingleSource3, paramSingleSource4, paramSingleSource5, paramSingleSource6 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, T6, R> Single<R> zip(SingleSource<? extends T1> paramSingleSource, SingleSource<? extends T2> paramSingleSource1, SingleSource<? extends T3> paramSingleSource2, SingleSource<? extends T4> paramSingleSource3, SingleSource<? extends T5> paramSingleSource4, SingleSource<? extends T6> paramSingleSource5, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> paramFunction6)
  {
    ObjectHelper.requireNonNull(paramSingleSource, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramSingleSource3, "source4 is null");
    ObjectHelper.requireNonNull(paramSingleSource4, "source5 is null");
    ObjectHelper.requireNonNull(paramSingleSource5, "source6 is null");
    return zipArray(Functions.toFunction(paramFunction6), new SingleSource[] { paramSingleSource, paramSingleSource1, paramSingleSource2, paramSingleSource3, paramSingleSource4, paramSingleSource5 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, T5, R> Single<R> zip(SingleSource<? extends T1> paramSingleSource, SingleSource<? extends T2> paramSingleSource1, SingleSource<? extends T3> paramSingleSource2, SingleSource<? extends T4> paramSingleSource3, SingleSource<? extends T5> paramSingleSource4, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> paramFunction5)
  {
    ObjectHelper.requireNonNull(paramSingleSource, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramSingleSource3, "source4 is null");
    ObjectHelper.requireNonNull(paramSingleSource4, "source5 is null");
    return zipArray(Functions.toFunction(paramFunction5), new SingleSource[] { paramSingleSource, paramSingleSource1, paramSingleSource2, paramSingleSource3, paramSingleSource4 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, T4, R> Single<R> zip(SingleSource<? extends T1> paramSingleSource, SingleSource<? extends T2> paramSingleSource1, SingleSource<? extends T3> paramSingleSource2, SingleSource<? extends T4> paramSingleSource3, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramFunction4)
  {
    ObjectHelper.requireNonNull(paramSingleSource, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source3 is null");
    ObjectHelper.requireNonNull(paramSingleSource3, "source4 is null");
    return zipArray(Functions.toFunction(paramFunction4), new SingleSource[] { paramSingleSource, paramSingleSource1, paramSingleSource2, paramSingleSource3 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, T3, R> Single<R> zip(SingleSource<? extends T1> paramSingleSource, SingleSource<? extends T2> paramSingleSource1, SingleSource<? extends T3> paramSingleSource2, Function3<? super T1, ? super T2, ? super T3, ? extends R> paramFunction3)
  {
    ObjectHelper.requireNonNull(paramSingleSource, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource1, "source2 is null");
    ObjectHelper.requireNonNull(paramSingleSource2, "source3 is null");
    return zipArray(Functions.toFunction(paramFunction3), new SingleSource[] { paramSingleSource, paramSingleSource1, paramSingleSource2 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T1, T2, R> Single<R> zip(SingleSource<? extends T1> paramSingleSource, SingleSource<? extends T2> paramSingleSource1, BiFunction<? super T1, ? super T2, ? extends R> paramBiFunction)
  {
    ObjectHelper.requireNonNull(paramSingleSource, "source1 is null");
    ObjectHelper.requireNonNull(paramSingleSource1, "source2 is null");
    return zipArray(Functions.toFunction(paramBiFunction), new SingleSource[] { paramSingleSource, paramSingleSource1 });
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Single<R> zip(Iterable<? extends SingleSource<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction)
  {
    ObjectHelper.requireNonNull(paramFunction, "zipper is null");
    ObjectHelper.requireNonNull(paramIterable, "sources is null");
    return RxJavaPlugins.onAssembly(new SingleZipIterable(paramIterable, paramFunction));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public static <T, R> Single<R> zipArray(Function<? super Object[], ? extends R> paramFunction, SingleSource<? extends T>... paramVarArgs)
  {
    ObjectHelper.requireNonNull(paramFunction, "zipper is null");
    ObjectHelper.requireNonNull(paramVarArgs, "sources is null");
    if (paramVarArgs.length == 0) {
      return error(new NoSuchElementException());
    }
    return RxJavaPlugins.onAssembly(new SingleZipArray(paramVarArgs, paramFunction));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> ambWith(SingleSource<? extends T> paramSingleSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> R as(SingleConverter<T, ? extends R> paramSingleConverter)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final T blockingGet()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> cache()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Single<U> cast(Class<? extends U> paramClass)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Single<R> compose(SingleTransformer<? super T, ? extends R> paramSingleTransformer)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> concatWith(SingleSource<? extends T> paramSingleSource)
  {
    return concat(this, paramSingleSource);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<Boolean> contains(Object paramObject)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<Boolean> contains(Object paramObject, BiPredicate<Object, Object> paramBiPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Single<T> delay(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Single<T> delay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Single<T> delay(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Single<T> delay(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Single<T> delaySubscription(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Single<T> delaySubscription(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return delaySubscription(Observable.timer(paramLong, paramTimeUnit, paramScheduler));
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> delaySubscription(CompletableSource paramCompletableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Single<T> delaySubscription(ObservableSource<U> paramObservableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Single<T> delaySubscription(SingleSource<U> paramSingleSource)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Single<T> delaySubscription(Publisher<U> paramPublisher)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Maybe<R> dematerialize(Function<? super T, Notification<R>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> doAfterSuccess(Consumer<? super T> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> doAfterTerminate(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> doFinally(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> doOnDispose(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> doOnError(Consumer<? super Throwable> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> doOnEvent(BiConsumer<? super T, ? super Throwable> paramBiConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> doOnSubscribe(Consumer<? super Disposable> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> doOnSuccess(Consumer<? super T> paramConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> doOnTerminate(Action paramAction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Maybe<T> filter(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Single<R> flatMap(Function<? super T, ? extends SingleSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Maybe<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Observable<R> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Flowable<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> paramFunction)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Flowable<U> flattenAsFlowable(Function<? super T, ? extends Iterable<? extends U>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U> Observable<U> flattenAsObservable(Function<? super T, ? extends Iterable<? extends U>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> hide()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Completable ignoreElement()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Single<R> lift(SingleOperator<? extends R, ? super T> paramSingleOperator)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> Single<R> map(Function<? super T, ? extends R> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<Notification<T>> materialize()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> mergeWith(SingleSource<? extends T> paramSingleSource)
  {
    return merge(this, paramSingleSource);
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Single<T> observeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> onErrorResumeNext(Single<? extends T> paramSingle)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> onErrorResumeNext(Function<? super Throwable, ? extends SingleSource<? extends T>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> onErrorReturn(Function<Throwable, ? extends T> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> onErrorReturnItem(T paramT)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> onTerminateDetach()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> repeat()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> repeat(long paramLong)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> repeatUntil(BooleanSupplier paramBooleanSupplier)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> retry()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> retry(long paramLong)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> retry(long paramLong, Predicate<? super Throwable> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> retry(BiPredicate<? super Integer, ? super Throwable> paramBiPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> retry(Predicate<? super Throwable> paramPredicate)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> paramFunction)
  {
    return null;
  }
  
  @SchedulerSupport("none")
  public final Disposable subscribe()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable subscribe(BiConsumer<? super T, ? super Throwable> paramBiConsumer)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable subscribe(Consumer<? super T> paramConsumer)
  {
    return subscribe(paramConsumer, Functions.ON_ERROR_MISSING);
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Disposable subscribe(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1)
  {
    return null;
  }
  
  /* Error */
  @SchedulerSupport("none")
  public final void subscribe(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected abstract void subscribeActual(SingleObserver<? super T> paramSingleObserver);
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Single<T> subscribeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <E extends SingleObserver<? super T>> E subscribeWith(E paramE)
  {
    subscribe(paramE);
    return paramE;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Single<T> takeUntil(CompletableSource paramCompletableSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <E> Single<T> takeUntil(SingleSource<? extends E> paramSingleSource)
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <E> Single<T> takeUntil(Publisher<E> paramPublisher)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final TestObserver<T> test()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final TestObserver<T> test(boolean paramBoolean)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, SingleSource<? extends T> paramSingleSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("io.reactivex:computation")
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit, SingleSource<? extends T> paramSingleSource)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <R> R to(Function<? super Single<T>, R> paramFunction)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  @Deprecated
  public final Completable toCompletable()
  {
    return null;
  }
  
  @BackpressureSupport(BackpressureKind.FULL)
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Flowable<T> toFlowable()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Future<T> toFuture()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Maybe<T> toMaybe()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final Observable<T> toObservable()
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("custom")
  public final Single<T> unsubscribeOn(Scheduler paramScheduler)
  {
    return null;
  }
  
  @CheckReturnValue
  @SchedulerSupport("none")
  public final <U, R> Single<R> zipWith(SingleSource<U> paramSingleSource, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
  {
    return zip(this, paramSingleSource, paramBiFunction);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\Single.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */